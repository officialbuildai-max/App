package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes5.dex */
public final class d implements HttpStream {

    /* renamed from: a, reason: collision with root package name */
    private final n f40510a;

    /* renamed from: b, reason: collision with root package name */
    private final BufferedSource f40511b;

    /* renamed from: c, reason: collision with root package name */
    private final BufferedSink f40512c;

    /* renamed from: d, reason: collision with root package name */
    private com.squareup.okhttp.internal.http.g f40513d;

    /* renamed from: e, reason: collision with root package name */
    private int f40514e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public abstract class b implements Source {

        /* renamed from: a, reason: collision with root package name */
        protected final ForwardingTimeout f40515a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f40516b;

        private b() {
            this.f40515a = new ForwardingTimeout(d.this.f40511b.getTimeout());
        }

        protected final void d() {
            if (d.this.f40514e != 5) {
                throw new IllegalStateException("state: " + d.this.f40514e);
            }
            d.this.g(this.f40515a);
            d.this.f40514e = 6;
            if (d.this.f40510a != null) {
                d.this.f40510a.r(d.this);
            }
        }

        protected final void h() {
            if (d.this.f40514e == 6) {
                return;
            }
            d.this.f40514e = 6;
            if (d.this.f40510a != null) {
                d.this.f40510a.l();
                d.this.f40510a.r(d.this);
            }
        }

        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return this.f40515a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class c implements Sink {

        /* renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f40518a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f40519b;

        private c() {
            this.f40518a = new ForwardingTimeout(d.this.f40512c.getTimeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f40519b) {
                return;
            }
            this.f40519b = true;
            d.this.f40512c.writeUtf8("0\r\n\r\n");
            d.this.g(this.f40518a);
            d.this.f40514e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.f40519b) {
                return;
            }
            d.this.f40512c.flush();
        }

        @Override // okio.Sink
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return this.f40518a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j11) {
            if (this.f40519b) {
                throw new IllegalStateException("closed");
            }
            if (j11 == 0) {
                return;
            }
            d.this.f40512c.writeHexadecimalUnsignedLong(j11);
            d.this.f40512c.writeUtf8("\r\n");
            d.this.f40512c.write(buffer, j11);
            d.this.f40512c.writeUtf8("\r\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.squareup.okhttp.internal.http.d$d, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0582d extends b {

        /* renamed from: d, reason: collision with root package name */
        private long f40521d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f40522e;

        /* renamed from: f, reason: collision with root package name */
        private final com.squareup.okhttp.internal.http.g f40523f;

        C0582d(com.squareup.okhttp.internal.http.g gVar) {
            super();
            this.f40521d = -1L;
            this.f40522e = true;
            this.f40523f = gVar;
        }

        private void k() {
            if (this.f40521d != -1) {
                d.this.f40511b.readUtf8LineStrict();
            }
            try {
                this.f40521d = d.this.f40511b.readHexadecimalUnsignedLong();
                String trim = d.this.f40511b.readUtf8LineStrict().trim();
                if (this.f40521d < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f40521d + trim + "\"");
                }
                if (this.f40521d == 0) {
                    this.f40522e = false;
                    this.f40523f.t(d.this.n());
                    d();
                }
            } catch (NumberFormatException e11) {
                throw new ProtocolException(e11.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f40516b) {
                return;
            }
            if (this.f40522e && !com.squareup.okhttp.internal.g.g(this, 100, TimeUnit.MILLISECONDS)) {
                h();
            }
            this.f40516b = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f40516b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f40522e) {
                return -1L;
            }
            long j12 = this.f40521d;
            if (j12 == 0 || j12 == -1) {
                k();
                if (!this.f40522e) {
                    return -1L;
                }
            }
            long read = d.this.f40511b.read(buffer, Math.min(j11, this.f40521d));
            if (read != -1) {
                this.f40521d -= read;
                return read;
            }
            h();
            throw new ProtocolException("unexpected end of stream");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class e implements Sink {

        /* renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f40525a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f40526b;

        /* renamed from: c, reason: collision with root package name */
        private long f40527c;

        private e(long j11) {
            this.f40525a = new ForwardingTimeout(d.this.f40512c.getTimeout());
            this.f40527c = j11;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f40526b) {
                return;
            }
            this.f40526b = true;
            if (this.f40527c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            d.this.g(this.f40525a);
            d.this.f40514e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.f40526b) {
                return;
            }
            d.this.f40512c.flush();
        }

        @Override // okio.Sink
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return this.f40525a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j11) {
            if (this.f40526b) {
                throw new IllegalStateException("closed");
            }
            com.squareup.okhttp.internal.g.a(buffer.size(), 0L, j11);
            if (j11 <= this.f40527c) {
                d.this.f40512c.write(buffer, j11);
                this.f40527c -= j11;
                return;
            }
            throw new ProtocolException("expected " + this.f40527c + " bytes but received " + j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class f extends b {

        /* renamed from: d, reason: collision with root package name */
        private long f40529d;

        public f(long j11) {
            super();
            this.f40529d = j11;
            if (j11 == 0) {
                d();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f40516b) {
                return;
            }
            if (this.f40529d != 0 && !com.squareup.okhttp.internal.g.g(this, 100, TimeUnit.MILLISECONDS)) {
                h();
            }
            this.f40516b = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f40516b) {
                throw new IllegalStateException("closed");
            }
            if (this.f40529d == 0) {
                return -1L;
            }
            long read = d.this.f40511b.read(buffer, Math.min(this.f40529d, j11));
            if (read == -1) {
                h();
                throw new ProtocolException("unexpected end of stream");
            }
            long j12 = this.f40529d - read;
            this.f40529d = j12;
            if (j12 == 0) {
                d();
            }
            return read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class g extends b {

        /* renamed from: d, reason: collision with root package name */
        private boolean f40531d;

        private g() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f40516b) {
                return;
            }
            if (!this.f40531d) {
                h();
            }
            this.f40516b = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f40516b) {
                throw new IllegalStateException("closed");
            }
            if (this.f40531d) {
                return -1L;
            }
            long read = d.this.f40511b.read(buffer, j11);
            if (read != -1) {
                return read;
            }
            this.f40531d = true;
            d();
            return -1L;
        }
    }

    public d(n nVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f40510a = nVar;
        this.f40511b = bufferedSource;
        this.f40512c = bufferedSink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.getDelegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    private Source h(Response response) {
        if (!com.squareup.okhttp.internal.http.g.n(response)) {
            return l(0L);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return j(this.f40513d);
        }
        long e11 = OkHeaders.e(response);
        return e11 != -1 ? l(e11) : m();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void cancel() {
        df.a c11 = this.f40510a.c();
        if (c11 != null) {
            c11.b();
        }
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Sink createRequestBody(Request request, long j11) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return i();
        }
        if (j11 != -1) {
            return k(j11);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void finishRequest() {
        this.f40512c.flush();
    }

    public Sink i() {
        if (this.f40514e == 1) {
            this.f40514e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f40514e);
    }

    public Source j(com.squareup.okhttp.internal.http.g gVar) {
        if (this.f40514e == 4) {
            this.f40514e = 5;
            return new C0582d(gVar);
        }
        throw new IllegalStateException("state: " + this.f40514e);
    }

    public Sink k(long j11) {
        if (this.f40514e == 1) {
            this.f40514e = 2;
            return new e(j11);
        }
        throw new IllegalStateException("state: " + this.f40514e);
    }

    public Source l(long j11) {
        if (this.f40514e == 4) {
            this.f40514e = 5;
            return new f(j11);
        }
        throw new IllegalStateException("state: " + this.f40514e);
    }

    public Source m() {
        if (this.f40514e != 4) {
            throw new IllegalStateException("state: " + this.f40514e);
        }
        n nVar = this.f40510a;
        if (nVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f40514e = 5;
        nVar.l();
        return new g();
    }

    public Headers n() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readUtf8LineStrict = this.f40511b.readUtf8LineStrict();
            if (readUtf8LineStrict.length() == 0) {
                return builder.build();
            }
            com.squareup.okhttp.internal.c.instance.addLenient(builder, readUtf8LineStrict);
        }
    }

    public Response.Builder o() {
        m a11;
        Response.Builder headers;
        int i11 = this.f40514e;
        if (i11 != 1 && i11 != 3) {
            throw new IllegalStateException("state: " + this.f40514e);
        }
        do {
            try {
                a11 = m.a(this.f40511b.readUtf8LineStrict());
                headers = new Response.Builder().protocol(a11.f40595a).code(a11.f40596b).message(a11.f40597c).headers(n());
            } catch (EOFException e11) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f40510a);
                iOException.initCause(e11);
                throw iOException;
            }
        } while (a11.f40596b == 100);
        this.f40514e = 4;
        return headers;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public ResponseBody openResponseBody(Response response) {
        return new i(response.headers(), Okio.buffer(h(response)));
    }

    public void p(Headers headers, String str) {
        if (this.f40514e != 0) {
            throw new IllegalStateException("state: " + this.f40514e);
        }
        this.f40512c.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f40512c.writeUtf8(headers.name(i11)).writeUtf8(": ").writeUtf8(headers.value(i11)).writeUtf8("\r\n");
        }
        this.f40512c.writeUtf8("\r\n");
        this.f40514e = 1;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Response.Builder readResponseHeaders() {
        return o();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void setHttpEngine(com.squareup.okhttp.internal.http.g gVar) {
        this.f40513d = gVar;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestBody(k kVar) {
        if (this.f40514e == 1) {
            this.f40514e = 3;
            kVar.h(this.f40512c);
        } else {
            throw new IllegalStateException("state: " + this.f40514e);
        }
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestHeaders(Request request) {
        this.f40513d.C();
        p(request.headers(), j.a(request, this.f40513d.k().getRoute().getProxy().type()));
    }
}
