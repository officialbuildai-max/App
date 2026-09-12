package androidx.media3.datasource.cronet;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.u;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.i;
import androidx.media3.common.util.l;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.c;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.base.n;
import com.google.common.primitives.Longs;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import w1.h;

/* loaded from: classes2.dex */
public class CronetDataSource extends w1.a implements HttpDataSource {
    private IOException A;
    private boolean B;
    private volatile long C;

    /* renamed from: e, reason: collision with root package name */
    private final CronetEngine f10953e;

    /* renamed from: f, reason: collision with root package name */
    private final Executor f10954f;

    /* renamed from: g, reason: collision with root package name */
    private final int f10955g;

    /* renamed from: h, reason: collision with root package name */
    private final int f10956h;

    /* renamed from: i, reason: collision with root package name */
    private final int f10957i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f10958j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f10959k;

    /* renamed from: l, reason: collision with root package name */
    private final String f10960l;

    /* renamed from: m, reason: collision with root package name */
    private final HttpDataSource.b f10961m;

    /* renamed from: n, reason: collision with root package name */
    private final HttpDataSource.b f10962n;

    /* renamed from: o, reason: collision with root package name */
    private final l f10963o;

    /* renamed from: p, reason: collision with root package name */
    private final i f10964p;

    /* renamed from: q, reason: collision with root package name */
    private final int f10965q;

    /* renamed from: r, reason: collision with root package name */
    private final n f10966r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f10967s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f10968t;

    /* renamed from: u, reason: collision with root package name */
    private long f10969u;

    /* renamed from: v, reason: collision with root package name */
    private UrlRequest f10970v;

    /* renamed from: w, reason: collision with root package name */
    c f10971w;

    /* renamed from: x, reason: collision with root package name */
    private h f10972x;

    /* renamed from: y, reason: collision with root package name */
    private ByteBuffer f10973y;

    /* renamed from: z, reason: collision with root package name */
    private UrlResponseInfo f10974z;

    /* loaded from: classes2.dex */
    public static final class OpenException extends HttpDataSource.HttpDataSourceException {
        public final int cronetConnectionStatus;

        @Deprecated
        public OpenException(IOException iOException, h hVar, int i11) {
            super(iOException, hVar, 2000, 1);
            this.cronetConnectionStatus = i11;
        }

        public OpenException(IOException iOException, h hVar, int i11, int i12) {
            super(iOException, hVar, i11, 1);
            this.cronetConnectionStatus = i12;
        }

        @Deprecated
        public OpenException(String str, h hVar, int i11) {
            super(str, hVar, 2000, 1);
            this.cronetConnectionStatus = i11;
        }

        public OpenException(String str, h hVar, int i11, int i12) {
            super(str, hVar, i11, 1);
            this.cronetConnectionStatus = i12;
        }

        public OpenException(h hVar, int i11, int i12) {
            super(hVar, i11, 1);
            this.cronetConnectionStatus = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends UrlRequest.StatusListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f10975a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f10976b;

        a(int[] iArr, l lVar) {
            this.f10975a = iArr;
            this.f10976b = lVar;
        }

        @Override // org.chromium.net.UrlRequest.StatusListener
        public void onStatus(int i11) {
            this.f10975a[0] = i11;
            this.f10976b.f();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements HttpDataSource.a {

        /* renamed from: a, reason: collision with root package name */
        private final CronetEngine f10977a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f10978b;

        /* renamed from: e, reason: collision with root package name */
        private HttpDataSource.a f10981e;

        /* renamed from: f, reason: collision with root package name */
        private n f10982f;

        /* renamed from: g, reason: collision with root package name */
        private w1.n f10983g;

        /* renamed from: h, reason: collision with root package name */
        private String f10984h;

        /* renamed from: m, reason: collision with root package name */
        private boolean f10989m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f10990n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f10991o;

        /* renamed from: c, reason: collision with root package name */
        private final HttpDataSource.b f10979c = new HttpDataSource.b();

        /* renamed from: d, reason: collision with root package name */
        private final c.b f10980d = null;

        /* renamed from: i, reason: collision with root package name */
        private int f10985i = 3;

        /* renamed from: j, reason: collision with root package name */
        private int f10986j = 8000;

        /* renamed from: k, reason: collision with root package name */
        private int f10987k = 8000;

        /* renamed from: l, reason: collision with root package name */
        private int f10988l = 32768;

        public b(CronetEngine cronetEngine, Executor executor) {
            this.f10977a = (CronetEngine) androidx.media3.common.util.a.e(cronetEngine);
            this.f10978b = executor;
        }

        @Override // androidx.media3.datasource.HttpDataSource.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b a(Map map) {
            this.f10979c.a(map);
            c.b bVar = this.f10980d;
            if (bVar != null) {
                bVar.a(map);
            }
            return this;
        }

        @Override // androidx.media3.datasource.a.InterfaceC0099a
        public HttpDataSource createDataSource() {
            if (this.f10977a == null) {
                HttpDataSource.a aVar = this.f10981e;
                return aVar != null ? aVar.createDataSource() : ((c.b) androidx.media3.common.util.a.e(this.f10980d)).createDataSource();
            }
            CronetDataSource cronetDataSource = new CronetDataSource(this.f10977a, this.f10978b, this.f10985i, this.f10986j, this.f10987k, this.f10989m, this.f10990n, this.f10984h, this.f10979c, this.f10982f, this.f10991o, this.f10988l);
            w1.n nVar = this.f10983g;
            if (nVar != null) {
                cronetDataSource.c(nVar);
            }
            return cronetDataSource;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends UrlRequest.Callback {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f10992a = false;

        c() {
        }

        public void a() {
            this.f10992a = true;
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            try {
                if (this.f10992a) {
                    return;
                }
                if ((cronetException instanceof NetworkException) && ((NetworkException) cronetException).getErrorCode() == 1) {
                    CronetDataSource.this.A = new UnknownHostException();
                } else {
                    CronetDataSource.this.A = cronetException;
                }
                CronetDataSource.this.f10963o.f();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            if (this.f10992a) {
                return;
            }
            CronetDataSource.this.f10963o.f();
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            if (this.f10992a) {
                return;
            }
            androidx.media3.common.util.a.e(CronetDataSource.this.f10970v);
            androidx.media3.common.util.a.e(CronetDataSource.this.f10971w);
            h hVar = (h) androidx.media3.common.util.a.e(CronetDataSource.this.f10972x);
            int httpStatusCode = urlResponseInfo.getHttpStatusCode();
            if (hVar.f77636c == 2 && (httpStatusCode == 307 || httpStatusCode == 308)) {
                CronetDataSource.this.A = new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfo.getHttpStatusText(), null, urlResponseInfo.getAllHeaders(), hVar, a1.f10437f);
                CronetDataSource.this.f10963o.f();
                return;
            }
            if (CronetDataSource.this.f10958j) {
                CronetDataSource.this.F();
            }
            boolean z10 = CronetDataSource.this.f10967s && hVar.f77636c == 2 && httpStatusCode == 302;
            if (!z10 && !CronetDataSource.this.f10959k) {
                urlRequest.followRedirect();
                return;
            }
            String C = CronetDataSource.C(urlResponseInfo.getAllHeaders().get("Set-Cookie"));
            if (!z10 && TextUtils.isEmpty(C)) {
                urlRequest.followRedirect();
                return;
            }
            h g11 = (z10 || hVar.f77636c != 2) ? hVar.g(Uri.parse(str)) : hVar.a().j(str).d(1).c(null).a();
            if (!TextUtils.isEmpty(C)) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(hVar.f77638e);
                hashMap.put("Cookie", C);
                g11 = g11.a().e(hashMap).a();
            }
            CronetDataSource.this.w();
            try {
                CronetDataSource.this.x(g11);
                CronetDataSource.this.f10970v.start();
            } catch (IOException e11) {
                CronetDataSource.this.A = e11;
            }
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (this.f10992a) {
                return;
            }
            CronetDataSource.this.f10974z = urlResponseInfo;
            CronetDataSource.this.f10963o.f();
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (this.f10992a) {
                return;
            }
            CronetDataSource.this.B = true;
            CronetDataSource.this.f10963o.f();
        }
    }

    static {
        u.a("media3.datasource.cronet");
    }

    protected CronetDataSource(CronetEngine cronetEngine, Executor executor, int i11, int i12, int i13, boolean z10, boolean z11, String str, HttpDataSource.b bVar, n nVar, boolean z12, int i14) {
        super(true);
        this.f10953e = (CronetEngine) androidx.media3.common.util.a.e(cronetEngine);
        this.f10954f = (Executor) androidx.media3.common.util.a.e(executor);
        this.f10955g = i11;
        this.f10956h = i12;
        this.f10957i = i13;
        this.f10958j = z10;
        this.f10959k = z11;
        this.f10960l = str;
        this.f10961m = bVar;
        this.f10966r = nVar;
        this.f10967s = z12;
        this.f10964p = i.f10469a;
        this.f10965q = i14;
        this.f10962n = new HttpDataSource.b();
        this.f10963o = new l();
    }

    private static int A(UrlRequest urlRequest) {
        l lVar = new l();
        int[] iArr = new int[1];
        urlRequest.getStatus(new a(iArr, lVar));
        lVar.a();
        return iArr[0];
    }

    private static boolean B(UrlResponseInfo urlResponseInfo) {
        Iterator<Map.Entry<String, String>> it = urlResponseInfo.getAllHeadersAsList().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equalsIgnoreCase(HttpHeaders.CONTENT_ENCODING)) {
                return !r0.getValue().equalsIgnoreCase("identity");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String C(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return TextUtils.join(";", list);
    }

    private void D(ByteBuffer byteBuffer, h hVar) {
        ((UrlRequest) a1.i(this.f10970v)).read(byteBuffer);
        try {
        } catch (InterruptedException unused) {
            if (byteBuffer == this.f10973y) {
                this.f10973y = null;
            }
            Thread.currentThread().interrupt();
            this.A = new InterruptedIOException();
        } catch (SocketTimeoutException e11) {
            if (byteBuffer == this.f10973y) {
                this.f10973y = null;
            }
            this.A = new HttpDataSource.HttpDataSourceException(e11, hVar, 2002, 2);
        }
        if (!this.f10963o.b(this.f10957i)) {
            throw new SocketTimeoutException();
        }
        IOException iOException = this.A;
        if (iOException != null) {
            if (!(iOException instanceof HttpDataSource.HttpDataSourceException)) {
                throw HttpDataSource.HttpDataSourceException.createForIOException(iOException, hVar, 2);
            }
            throw ((HttpDataSource.HttpDataSourceException) iOException);
        }
    }

    private byte[] E() {
        byte[] bArr = a1.f10437f;
        ByteBuffer z10 = z();
        while (!this.B) {
            this.f10963o.d();
            z10.clear();
            D(z10, (h) a1.i(this.f10972x));
            z10.flip();
            if (z10.remaining() > 0) {
                int length = bArr.length;
                bArr = Arrays.copyOf(bArr, bArr.length + z10.remaining());
                z10.get(bArr, length, z10.remaining());
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        this.C = this.f10964p.elapsedRealtime() + this.f10956h;
    }

    private void G(long j11, h hVar) {
        if (j11 == 0) {
            return;
        }
        ByteBuffer z10 = z();
        while (j11 > 0) {
            try {
                this.f10963o.d();
                z10.clear();
                D(z10, hVar);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (this.B) {
                    throw new OpenException(hVar, 2008, 14);
                }
                z10.flip();
                androidx.media3.common.util.a.g(z10.hasRemaining());
                int min = (int) Math.min(z10.remaining(), j11);
                z10.position(z10.position() + min);
                j11 -= min;
            } catch (IOException e11) {
                if (e11 instanceof HttpDataSource.HttpDataSourceException) {
                    throw ((HttpDataSource.HttpDataSourceException) e11);
                }
                throw new OpenException(e11, hVar, e11 instanceof SocketTimeoutException ? 2002 : 2001, 14);
            }
        }
    }

    private boolean u() {
        long elapsedRealtime = this.f10964p.elapsedRealtime();
        boolean z10 = false;
        while (!z10 && elapsedRealtime < this.C) {
            z10 = this.f10963o.b((this.C - elapsedRealtime) + 5);
            elapsedRealtime = this.f10964p.elapsedRealtime();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        UrlRequest urlRequest = this.f10970v;
        if (urlRequest != null) {
            urlRequest.cancel();
            this.f10970v = null;
        }
        c cVar = this.f10971w;
        if (cVar != null) {
            cVar.a();
            this.f10971w = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(h hVar) {
        this.f10971w = new c();
        this.f10970v = v(hVar).build();
    }

    private static String y(Map map, String str) {
        List list = (List) map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    private ByteBuffer z() {
        if (this.f10973y == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f10965q);
            this.f10973y = allocateDirect;
            allocateDirect.limit(0);
        }
        return this.f10973y;
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        byte[] bArr;
        String y10;
        androidx.media3.common.util.a.e(hVar);
        androidx.media3.common.util.a.g(!this.f10968t);
        this.f10963o.d();
        F();
        this.f10972x = hVar;
        try {
            x(hVar);
            UrlRequest urlRequest = this.f10970v;
            urlRequest.start();
            f(hVar);
            try {
                boolean u11 = u();
                IOException iOException = this.A;
                if (iOException != null) {
                    String message = iOException.getMessage();
                    if (message == null || !com.google.common.base.a.e(message).contains("err_cleartext_not_permitted")) {
                        throw new OpenException(iOException, hVar, 2001, A(urlRequest));
                    }
                    throw new HttpDataSource.CleartextNotPermittedException(iOException, hVar);
                }
                if (!u11) {
                    throw new OpenException(new SocketTimeoutException(), hVar, 2002, A(urlRequest));
                }
                UrlResponseInfo urlResponseInfo = (UrlResponseInfo) androidx.media3.common.util.a.e(this.f10974z);
                int httpStatusCode = urlResponseInfo.getHttpStatusCode();
                Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
                long j11 = 0;
                if (httpStatusCode < 200 || httpStatusCode > 299) {
                    if (httpStatusCode == 416) {
                        if (hVar.f77640g == w1.i.c(y(allHeaders, "Content-Range"))) {
                            this.f10968t = true;
                            g(hVar);
                            long j12 = hVar.f77641h;
                            if (j12 != -1) {
                                return j12;
                            }
                            return 0L;
                        }
                    }
                    try {
                        bArr = E();
                    } catch (IOException unused) {
                        bArr = a1.f10437f;
                    }
                    throw new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfo.getHttpStatusText(), httpStatusCode == 416 ? new DataSourceException(2008) : null, allHeaders, hVar, bArr);
                }
                n nVar = this.f10966r;
                if (nVar != null && (y10 = y(allHeaders, HttpHeaders.CONTENT_TYPE)) != null && !nVar.apply(y10)) {
                    throw new HttpDataSource.InvalidContentTypeException(y10, hVar);
                }
                if (httpStatusCode == 200) {
                    long j13 = hVar.f77640g;
                    if (j13 != 0) {
                        j11 = j13;
                    }
                }
                if (B(urlResponseInfo)) {
                    this.f10969u = hVar.f77641h;
                } else {
                    long j14 = hVar.f77641h;
                    if (j14 != -1) {
                        this.f10969u = j14;
                    } else {
                        long b11 = w1.i.b(y(allHeaders, HttpHeaders.CONTENT_LENGTH), y(allHeaders, "Content-Range"));
                        this.f10969u = b11 != -1 ? b11 - j11 : -1L;
                    }
                }
                this.f10968t = true;
                g(hVar);
                G(j11, hVar);
                return this.f10969u;
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                throw new OpenException(new InterruptedIOException(), hVar, 1004, -1);
            }
        } catch (IOException e11) {
            if (e11 instanceof HttpDataSource.HttpDataSourceException) {
                throw ((HttpDataSource.HttpDataSourceException) e11);
            }
            throw new OpenException(e11, hVar, 2000, 0);
        }
    }

    @Override // androidx.media3.datasource.a
    public synchronized void close() {
        try {
            w();
            ByteBuffer byteBuffer = this.f10973y;
            if (byteBuffer != null) {
                byteBuffer.limit(0);
            }
            this.f10972x = null;
            this.f10974z = null;
            this.A = null;
            this.B = false;
            if (this.f10968t) {
                this.f10968t = false;
                e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // w1.a, androidx.media3.datasource.a
    public Map getResponseHeaders() {
        UrlResponseInfo urlResponseInfo = this.f10974z;
        return urlResponseInfo == null ? Collections.emptyMap() : urlResponseInfo.getAllHeaders();
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        UrlResponseInfo urlResponseInfo = this.f10974z;
        if (urlResponseInfo != null) {
            return Uri.parse(urlResponseInfo.getUrl());
        }
        h hVar = this.f10972x;
        if (hVar != null) {
            return hVar.f77634a;
        }
        return null;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        androidx.media3.common.util.a.g(this.f10968t);
        if (i12 == 0) {
            return 0;
        }
        if (this.f10969u == 0) {
            return -1;
        }
        ByteBuffer z10 = z();
        if (!z10.hasRemaining()) {
            this.f10963o.d();
            z10.clear();
            D(z10, (h) a1.i(this.f10972x));
            if (this.B) {
                this.f10969u = 0L;
                return -1;
            }
            z10.flip();
            androidx.media3.common.util.a.g(z10.hasRemaining());
        }
        long j11 = this.f10969u;
        if (j11 == -1) {
            j11 = Long.MAX_VALUE;
        }
        int i13 = (int) Longs.i(j11, z10.remaining(), i12);
        z10.get(bArr, i11, i13);
        long j12 = this.f10969u;
        if (j12 != -1) {
            this.f10969u = j12 - i13;
        }
        d(i13);
        return i13;
    }

    protected UrlRequest.Builder v(h hVar) {
        UrlRequest.Builder allowDirectExecutor = this.f10953e.newUrlRequestBuilder(hVar.f77634a.toString(), this.f10971w, this.f10954f).setPriority(this.f10955g).allowDirectExecutor();
        HashMap hashMap = new HashMap();
        HttpDataSource.b bVar = this.f10961m;
        if (bVar != null) {
            hashMap.putAll(bVar.b());
        }
        hashMap.putAll(this.f10962n.b());
        hashMap.putAll(hVar.f77638e);
        for (Map.Entry entry : hashMap.entrySet()) {
            allowDirectExecutor.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        if (hVar.f77637d != null && !hashMap.containsKey(HttpHeaders.CONTENT_TYPE)) {
            throw new OpenException("HTTP request with non-empty body must set Content-Type", hVar, 1004, 0);
        }
        String a11 = w1.i.a(hVar.f77640g, hVar.f77641h);
        if (a11 != null) {
            allowDirectExecutor.addHeader("Range", a11);
        }
        String str = this.f10960l;
        if (str != null) {
            allowDirectExecutor.addHeader("User-Agent", str);
        }
        allowDirectExecutor.setHttpMethod(hVar.b());
        byte[] bArr = hVar.f77637d;
        if (bArr != null) {
            allowDirectExecutor.setUploadDataProvider(new androidx.media3.datasource.cronet.a(bArr), this.f10954f);
        }
        return allowDirectExecutor;
    }
}
