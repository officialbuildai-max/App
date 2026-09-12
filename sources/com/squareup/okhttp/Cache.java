package com.squareup.okhttp;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.g;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.b;
import com.squareup.okhttp.internal.http.h;
import com.squareup.okhttp.internal.http.m;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: classes5.dex */
public final class Cache {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class CacheRequestImpl implements CacheRequest {
        private Sink body;
        private Sink cacheOut;
        private boolean done;
        private final DiskLruCache.d editor;

        public CacheRequestImpl(final DiskLruCache.d dVar) throws IOException {
            this.editor = dVar;
            Sink f11 = dVar.f(1);
            this.cacheOut = f11;
            this.body = new ForwardingSink(f11) { // from class: com.squareup.okhttp.Cache.CacheRequestImpl.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        try {
                            if (CacheRequestImpl.this.done) {
                                return;
                            }
                            CacheRequestImpl.this.done = true;
                            Cache.access$808(Cache.this);
                            super.close();
                            dVar.e();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            };
        }

        @Override // com.squareup.okhttp.internal.http.CacheRequest
        public void abort() {
            synchronized (Cache.this) {
                try {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    Cache.access$908(Cache.this);
                    g.c(this.cacheOut);
                    try {
                        this.editor.a();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.squareup.okhttp.internal.http.CacheRequest
        public Sink body() {
            return this.body;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.f snapshot;

        public CacheResponseBody(final DiskLruCache.f fVar, String str, String str2) {
            this.snapshot = fVar;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer(new ForwardingSource(fVar.h(1)) { // from class: com.squareup.okhttp.Cache.CacheResponseBody.1
                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    fVar.close();
                    super.close();
                }
            });
        }

        @Override // com.squareup.okhttp.ResponseBody
        public long contentLength() {
            try {
                String str = this.contentLength;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.squareup.okhttp.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Entry {
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String url;
        private final Headers varyHeaders;

        public Entry(Response response) {
            this.url = response.request().urlString();
            this.varyHeaders = OkHeaders.p(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
        }

        public Entry(Source source) throws IOException {
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.url = buffer.readUtf8LineStrict();
                this.requestMethod = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(buffer);
                for (int i11 = 0; i11 < readInt; i11++) {
                    builder.addLenient(buffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                m a11 = m.a(buffer.readUtf8LineStrict());
                this.protocol = a11.f40595a;
                this.code = a11.f40596b;
                this.message = a11.f40597c;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(buffer);
                for (int i12 = 0; i12 < readInt2; i12++) {
                    builder2.addLenient(buffer.readUtf8LineStrict());
                }
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                    this.handshake = Handshake.get(buffer.readUtf8LineStrict(), readCertificateList(buffer), readCertificateList(buffer));
                } else {
                    this.handshake = null;
                }
                source.close();
            } catch (Throwable th2) {
                source.close();
                throw th2;
            }
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 < readInt; i11++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        private void writeCertList(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size());
                bufferedSink.writeByte(10);
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    bufferedSink.writeUtf8(ByteString.of(list.get(i11).getEncoded()).base64());
                    bufferedSink.writeByte(10);
                }
            } catch (CertificateEncodingException e11) {
                throw new IOException(e11.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            return this.url.equals(request.urlString()) && this.requestMethod.equals(request.method()) && OkHeaders.q(response, this.varyHeaders, request);
        }

        public Response response(Request request, DiskLruCache.f fVar) {
            String str = this.responseHeaders.get(HttpHeaders.CONTENT_TYPE);
            String str2 = this.responseHeaders.get(HttpHeaders.CONTENT_LENGTH);
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(fVar, str, str2)).handshake(this.handshake).build();
        }

        public void writeTo(DiskLruCache.d dVar) throws IOException {
            BufferedSink buffer = Okio.buffer(dVar.f(0));
            buffer.writeUtf8(this.url);
            buffer.writeByte(10);
            buffer.writeUtf8(this.requestMethod);
            buffer.writeByte(10);
            buffer.writeDecimalLong(this.varyHeaders.size());
            buffer.writeByte(10);
            int size = this.varyHeaders.size();
            for (int i11 = 0; i11 < size; i11++) {
                buffer.writeUtf8(this.varyHeaders.name(i11));
                buffer.writeUtf8(": ");
                buffer.writeUtf8(this.varyHeaders.value(i11));
                buffer.writeByte(10);
            }
            buffer.writeUtf8(new m(this.protocol, this.code, this.message).toString());
            buffer.writeByte(10);
            buffer.writeDecimalLong(this.responseHeaders.size());
            buffer.writeByte(10);
            int size2 = this.responseHeaders.size();
            for (int i12 = 0; i12 < size2; i12++) {
                buffer.writeUtf8(this.responseHeaders.name(i12));
                buffer.writeUtf8(": ");
                buffer.writeUtf8(this.responseHeaders.value(i12));
                buffer.writeByte(10);
            }
            if (isHttps()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.handshake.cipherSuite());
                buffer.writeByte(10);
                writeCertList(buffer, this.handshake.peerCertificates());
                writeCertList(buffer, this.handshake.localCertificates());
            }
            buffer.close();
        }
    }

    public Cache(File file, long j11) {
        this(file, j11, FileSystem.SYSTEM);
    }

    Cache(File file, long j11, FileSystem fileSystem) {
        this.internalCache = new InternalCache() { // from class: com.squareup.okhttp.Cache.1
            @Override // com.squareup.okhttp.internal.InternalCache
            public Response get(Request request) throws IOException {
                return Cache.this.get(request);
            }

            @Override // com.squareup.okhttp.internal.InternalCache
            public CacheRequest put(Response response) throws IOException {
                return Cache.this.put(response);
            }

            @Override // com.squareup.okhttp.internal.InternalCache
            public void remove(Request request) throws IOException {
                Cache.this.remove(request);
            }

            @Override // com.squareup.okhttp.internal.InternalCache
            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            @Override // com.squareup.okhttp.internal.InternalCache
            public void trackResponse(b bVar) {
                Cache.this.trackResponse(bVar);
            }

            @Override // com.squareup.okhttp.internal.InternalCache
            public void update(Response response, Response response2) throws IOException {
                Cache.this.update(response, response2);
            }
        };
        this.cache = DiskLruCache.x(fileSystem, file, VERSION, 2, j11);
    }

    private void abortQuietly(DiskLruCache.d dVar) {
        if (dVar != null) {
            try {
                dVar.a();
            } catch (IOException unused) {
            }
        }
    }

    static /* synthetic */ int access$808(Cache cache) {
        int i11 = cache.writeSuccessCount;
        cache.writeSuccessCount = i11 + 1;
        return i11;
    }

    static /* synthetic */ int access$908(Cache cache) {
        int i11 = cache.writeAbortCount;
        cache.writeAbortCount = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CacheRequest put(Response response) throws IOException {
        DiskLruCache.d dVar;
        String method = response.request().method();
        if (h.a(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!method.equals("GET") || OkHeaders.g(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            dVar = this.cache.U(urlToKey(response.request()));
            if (dVar == null) {
                return null;
            }
            try {
                entry.writeTo(dVar);
                return new CacheRequestImpl(dVar);
            } catch (IOException unused2) {
                abortQuietly(dVar);
                return null;
            }
        } catch (IOException unused3) {
            dVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e11) {
            throw new IOException(e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remove(Request request) throws IOException {
        this.cache.q0(urlToKey(request));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void trackResponse(b bVar) {
        try {
            this.requestCount++;
            if (bVar.f40496a != null) {
                this.networkCount++;
            } else if (bVar.f40497b != null) {
                this.hitCount++;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(Response response, Response response2) {
        DiskLruCache.d dVar;
        Entry entry = new Entry(response2);
        try {
            dVar = ((CacheResponseBody) response.body()).snapshot.d();
            if (dVar != null) {
                try {
                    entry.writeTo(dVar);
                    dVar.e();
                } catch (IOException unused) {
                    abortQuietly(dVar);
                }
            }
        } catch (IOException unused2) {
            dVar = null;
        }
    }

    private static String urlToKey(Request request) {
        return g.p(request.urlString());
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.T();
    }

    public void evictAll() throws IOException {
        this.cache.Z();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    Response get(Request request) {
        try {
            DiskLruCache.f a02 = this.cache.a0(urlToKey(request));
            if (a02 == null) {
                return null;
            }
            try {
                Entry entry = new Entry(a02.h(0));
                Response response = entry.response(request, a02);
                if (entry.matches(request, response)) {
                    return response;
                }
                g.c(response.body());
                return null;
            } catch (IOException unused) {
                g.c(a02);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public File getDirectory() {
        return this.cache.c0();
    }

    public synchronized int getHitCount() {
        return this.hitCount;
    }

    public long getMaxSize() {
        return this.cache.d0();
    }

    public synchronized int getNetworkCount() {
        return this.networkCount;
    }

    public synchronized int getRequestCount() {
        return this.requestCount;
    }

    public long getSize() throws IOException {
        return this.cache.u0();
    }

    public synchronized int getWriteAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int getWriteSuccessCount() {
        return this.writeSuccessCount;
    }

    public void initialize() throws IOException {
        this.cache.g0();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public Iterator<String> urls() throws IOException {
        return new Iterator<String>() { // from class: com.squareup.okhttp.Cache.2
            boolean canRemove;
            final Iterator<DiskLruCache.f> delegate;
            String nextUrl;

            {
                this.delegate = Cache.this.cache.v0();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    DiskLruCache.f next = this.delegate.next();
                    try {
                        this.nextUrl = Okio.buffer(next.h(0)).readUtf8LineStrict();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String str = this.nextUrl;
                this.nextUrl = null;
                this.canRemove = true;
                return str;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.canRemove) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.delegate.remove();
            }
        };
    }
}
