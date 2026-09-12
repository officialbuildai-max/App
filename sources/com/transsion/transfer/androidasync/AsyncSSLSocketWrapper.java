package com.transsion.transfer.androidasync;

import bv.d;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.AbstractVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

/* loaded from: classes6.dex */
public class AsyncSSLSocketWrapper implements j, p, com.transsion.transfer.androidasync.a {

    /* renamed from: v, reason: collision with root package name */
    static SSLContext f55229v;

    /* renamed from: w, reason: collision with root package name */
    static SSLContext f55230w;

    /* renamed from: x, reason: collision with root package name */
    static TrustManager[] f55231x;

    /* renamed from: y, reason: collision with root package name */
    static HostnameVerifier f55232y;

    /* renamed from: a, reason: collision with root package name */
    j f55233a;

    /* renamed from: b, reason: collision with root package name */
    n f55234b;

    /* renamed from: c, reason: collision with root package name */
    boolean f55235c;

    /* renamed from: d, reason: collision with root package name */
    SSLEngine f55236d;

    /* renamed from: e, reason: collision with root package name */
    boolean f55237e;

    /* renamed from: f, reason: collision with root package name */
    private int f55238f;

    /* renamed from: g, reason: collision with root package name */
    private String f55239g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f55240h;

    /* renamed from: i, reason: collision with root package name */
    HostnameVerifier f55241i;

    /* renamed from: j, reason: collision with root package name */
    g f55242j;

    /* renamed from: k, reason: collision with root package name */
    X509Certificate[] f55243k;

    /* renamed from: l, reason: collision with root package name */
    bv.j f55244l;

    /* renamed from: m, reason: collision with root package name */
    bv.d f55245m;

    /* renamed from: n, reason: collision with root package name */
    TrustManager[] f55246n;

    /* renamed from: o, reason: collision with root package name */
    boolean f55247o;

    /* renamed from: p, reason: collision with root package name */
    boolean f55248p;

    /* renamed from: q, reason: collision with root package name */
    Exception f55249q;

    /* renamed from: r, reason: collision with root package name */
    final ByteBufferList f55250r = new ByteBufferList();

    /* renamed from: s, reason: collision with root package name */
    final bv.d f55251s;

    /* renamed from: t, reason: collision with root package name */
    ByteBufferList f55252t;

    /* renamed from: u, reason: collision with root package name */
    bv.a f55253u;

    /* loaded from: classes6.dex */
    class a implements X509TrustManager {
        a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                if (x509Certificate != null && x509Certificate.getCriticalExtensionOIDs() != null) {
                    x509Certificate.getCriticalExtensionOIDs().remove("2.5.29.15");
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: classes6.dex */
    class b implements X509TrustManager {
        b() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: classes6.dex */
    class c implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f55254a;

        c(g gVar) {
            this.f55254a = gVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (exc != null) {
                this.f55254a.a(exc, null);
            } else {
                this.f55254a.a(new SSLException("socket closed during handshake"), null);
            }
        }
    }

    /* loaded from: classes6.dex */
    class d implements bv.j {
        d() {
        }

        @Override // bv.j
        public void a() {
            bv.j jVar = AsyncSSLSocketWrapper.this.f55244l;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    class e implements bv.a {
        e() {
        }

        @Override // bv.a
        public void g(Exception exc) {
            bv.a aVar;
            AsyncSSLSocketWrapper asyncSSLSocketWrapper = AsyncSSLSocketWrapper.this;
            if (asyncSSLSocketWrapper.f55248p) {
                return;
            }
            asyncSSLSocketWrapper.f55248p = true;
            asyncSSLSocketWrapper.f55249q = exc;
            if (asyncSSLSocketWrapper.f55250r.r() || (aVar = AsyncSSLSocketWrapper.this.f55253u) == null) {
                return;
            }
            aVar.g(exc);
        }
    }

    /* loaded from: classes6.dex */
    class f implements bv.d {

        /* renamed from: a, reason: collision with root package name */
        final com.transsion.transfer.androidasync.util.a f55257a = new com.transsion.transfer.androidasync.util.a().d(8192);

        /* renamed from: b, reason: collision with root package name */
        final ByteBufferList f55258b = new ByteBufferList();

        f() {
        }

        @Override // bv.d
        public void F(p pVar, ByteBufferList byteBufferList) {
            AsyncSSLSocketWrapper asyncSSLSocketWrapper = AsyncSSLSocketWrapper.this;
            if (asyncSSLSocketWrapper.f55235c) {
                return;
            }
            try {
                try {
                    asyncSSLSocketWrapper.f55235c = true;
                    byteBufferList.f(this.f55258b);
                    if (this.f55258b.r()) {
                        this.f55258b.a(this.f55258b.j());
                    }
                    ByteBuffer byteBuffer = ByteBufferList.f55292j;
                    while (true) {
                        if (byteBuffer.remaining() == 0 && this.f55258b.E() > 0) {
                            byteBuffer = this.f55258b.D();
                        }
                        int remaining = byteBuffer.remaining();
                        int C = AsyncSSLSocketWrapper.this.f55250r.C();
                        ByteBuffer a11 = this.f55257a.a();
                        SSLEngineResult unwrap = AsyncSSLSocketWrapper.this.f55236d.unwrap(byteBuffer, a11);
                        AsyncSSLSocketWrapper asyncSSLSocketWrapper2 = AsyncSSLSocketWrapper.this;
                        asyncSSLSocketWrapper2.k(asyncSSLSocketWrapper2.f55250r, a11);
                        this.f55257a.e(AsyncSSLSocketWrapper.this.f55250r.C() - C);
                        if (unwrap.getStatus() != SSLEngineResult.Status.BUFFER_OVERFLOW) {
                            if (unwrap.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                                this.f55258b.c(byteBuffer);
                                if (this.f55258b.E() <= 1) {
                                    break;
                                }
                                this.f55258b.c(this.f55258b.j());
                                byteBuffer = ByteBufferList.f55292j;
                            }
                            AsyncSSLSocketWrapper.this.u(unwrap.getHandshakeStatus());
                            if (byteBuffer.remaining() != remaining && C == AsyncSSLSocketWrapper.this.f55250r.C()) {
                                this.f55258b.c(byteBuffer);
                                break;
                            }
                        } else {
                            com.transsion.transfer.androidasync.util.a aVar = this.f55257a;
                            aVar.d(aVar.c() * 2);
                        }
                        remaining = -1;
                        AsyncSSLSocketWrapper.this.u(unwrap.getHandshakeStatus());
                        if (byteBuffer.remaining() != remaining) {
                        }
                    }
                    AsyncSSLSocketWrapper.this.C();
                } catch (SSLException e11) {
                    AsyncSSLSocketWrapper.this.F(e11);
                }
                AsyncSSLSocketWrapper.this.f55235c = false;
            } catch (Throwable th2) {
                AsyncSSLSocketWrapper.this.f55235c = false;
                throw th2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(Exception exc, com.transsion.transfer.androidasync.a aVar);
    }

    static {
        try {
            f55229v = SSLContext.getInstance("Default");
        } catch (Exception e11) {
            try {
                f55229v = SSLContext.getInstance("TLS");
                f55229v.init(null, new TrustManager[]{new a()}, null);
            } catch (Exception e12) {
                e11.printStackTrace();
                e12.printStackTrace();
            }
        }
        try {
            f55230w = SSLContext.getInstance("TLS");
            TrustManager[] trustManagerArr = {new b()};
            f55231x = trustManagerArr;
            f55230w.init(null, trustManagerArr, null);
            f55232y = new HostnameVerifier() { // from class: com.transsion.transfer.androidasync.b
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    boolean y10;
                    y10 = AsyncSSLSocketWrapper.y(str, sSLSession);
                    return y10;
                }
            };
        } catch (Exception e13) {
            e13.printStackTrace();
        }
    }

    private AsyncSSLSocketWrapper(j jVar, String str, int i11, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z10) {
        f fVar = new f();
        this.f55251s = fVar;
        this.f55252t = new ByteBufferList();
        this.f55233a = jVar;
        this.f55241i = hostnameVerifier;
        this.f55247o = z10;
        this.f55246n = trustManagerArr;
        this.f55236d = sSLEngine;
        this.f55239g = str;
        this.f55238f = i11;
        sSLEngine.setUseClientMode(z10);
        n nVar = new n(jVar);
        this.f55234b = nVar;
        nVar.o(new d());
        this.f55233a.s(new e());
        this.f55233a.t(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Exception exc) {
        g gVar = this.f55242j;
        if (gVar == null) {
            bv.a r11 = r();
            if (r11 != null) {
                r11.g(exc);
                return;
            }
            return;
        }
        this.f55242j = null;
        this.f55233a.t(new d.a());
        this.f55233a.d();
        this.f55233a.p(null);
        this.f55233a.close();
        gVar.a(exc, null);
    }

    public static SSLContext q() {
        return f55229v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(SSLEngineResult.HandshakeStatus handshakeStatus) {
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.f55236d.getDelegatedTask().run();
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            l(this.f55252t);
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            this.f55251s.F(this, new ByteBufferList());
        }
        try {
            if (this.f55237e) {
                return;
            }
            if (this.f55236d.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING && this.f55236d.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.FINISHED) {
                return;
            }
            if (this.f55247o) {
                boolean z10 = false;
                try {
                    this.f55243k = (X509Certificate[]) this.f55236d.getSession().getPeerCertificates();
                    String str = this.f55239g;
                    if (str != null) {
                        HostnameVerifier hostnameVerifier = this.f55241i;
                        if (hostnameVerifier == null) {
                            new StrictHostnameVerifier().verify(this.f55239g, AbstractVerifier.getCNs(this.f55243k[0]), AbstractVerifier.getDNSSubjectAlts(this.f55243k[0]));
                        } else if (!hostnameVerifier.verify(str, this.f55236d.getSession())) {
                            throw new SSLException("hostname <" + this.f55239g + "> has been denied");
                        }
                    }
                    z10 = true;
                    e = null;
                } catch (SSLException e11) {
                    e = e11;
                }
                this.f55237e = true;
                if (!z10) {
                    AsyncSSLException asyncSSLException = new AsyncSSLException(e);
                    F(asyncSSLException);
                    if (!asyncSSLException.getIgnore()) {
                        throw asyncSSLException;
                    }
                }
            } else {
                this.f55237e = true;
            }
            this.f55242j.a(null, this);
            this.f55242j = null;
            this.f55233a.p(null);
            a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncSSLSocketWrapper.7
                @Override // java.lang.Runnable
                public void run() {
                    bv.j jVar = AsyncSSLSocketWrapper.this.f55244l;
                    if (jVar != null) {
                        jVar.a();
                    }
                }
            });
            C();
        } catch (Exception e12) {
            F(e12);
        }
    }

    public static void w(j jVar, String str, int i11, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z10, g gVar) {
        AsyncSSLSocketWrapper asyncSSLSocketWrapper = new AsyncSSLSocketWrapper(jVar, str, i11, sSLEngine, trustManagerArr, hostnameVerifier, z10);
        asyncSSLSocketWrapper.f55242j = gVar;
        jVar.p(new c(gVar));
        try {
            asyncSSLSocketWrapper.f55236d.beginHandshake();
            asyncSSLSocketWrapper.u(asyncSSLSocketWrapper.f55236d.getHandshakeStatus());
        } catch (SSLException e11) {
            asyncSSLSocketWrapper.F(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean y(String str, SSLSession sSLSession) {
        return true;
    }

    public void C() {
        bv.a aVar;
        a0.a(this, this.f55250r);
        if (!this.f55248p || this.f55250r.r() || (aVar = this.f55253u) == null) {
            return;
        }
        aVar.g(this.f55249q);
    }

    @Override // com.transsion.transfer.androidasync.p
    public bv.d I() {
        return this.f55245m;
    }

    @Override // com.transsion.transfer.androidasync.j, com.transsion.transfer.androidasync.p, com.transsion.transfer.androidasync.s
    public AsyncServer a() {
        return this.f55233a.a();
    }

    @Override // com.transsion.transfer.androidasync.p
    public void close() {
        this.f55233a.close();
    }

    @Override // com.transsion.transfer.androidasync.s
    public void d() {
        this.f55233a.d();
    }

    @Override // com.transsion.transfer.androidasync.s
    public bv.j i() {
        return this.f55244l;
    }

    @Override // com.transsion.transfer.androidasync.s
    public boolean isOpen() {
        return this.f55233a.isOpen();
    }

    @Override // com.transsion.transfer.androidasync.p
    public boolean isPaused() {
        return this.f55233a.isPaused();
    }

    void k(ByteBufferList byteBufferList, ByteBuffer byteBuffer) {
        byteBuffer.flip();
        if (byteBuffer.hasRemaining()) {
            byteBufferList.a(byteBuffer);
        } else {
            ByteBufferList.A(byteBuffer);
        }
    }

    @Override // com.transsion.transfer.androidasync.s
    public void l(ByteBufferList byteBufferList) {
        if (!this.f55240h && this.f55234b.k() <= 0) {
            this.f55240h = true;
            ByteBuffer t11 = ByteBufferList.t(m(byteBufferList.C()));
            SSLEngineResult sSLEngineResult = null;
            do {
                if (!this.f55237e || byteBufferList.C() != 0) {
                    int C = byteBufferList.C();
                    try {
                        ByteBuffer[] k11 = byteBufferList.k();
                        sSLEngineResult = this.f55236d.wrap(k11, t11);
                        byteBufferList.b(k11);
                        t11.flip();
                        this.f55252t.a(t11);
                        if (this.f55252t.C() > 0) {
                            this.f55234b.l(this.f55252t);
                        }
                        int capacity = t11.capacity();
                        try {
                            if (sSLEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                                t11 = ByteBufferList.t(capacity * 2);
                                C = -1;
                            } else {
                                t11 = ByteBufferList.t(m(byteBufferList.C()));
                                u(sSLEngineResult.getHandshakeStatus());
                            }
                        } catch (SSLException e11) {
                            e = e11;
                            t11 = null;
                            F(e);
                            if (C != byteBufferList.C()) {
                            }
                        }
                    } catch (SSLException e12) {
                        e = e12;
                    }
                    if (C != byteBufferList.C() && (sSLEngineResult == null || sSLEngineResult.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_WRAP)) {
                        break;
                    }
                } else {
                    break;
                }
            } while (this.f55234b.k() == 0);
            this.f55240h = false;
            ByteBufferList.A(t11);
        }
    }

    int m(int i11) {
        int i12 = (i11 * 3) / 2;
        if (i12 == 0) {
            return 8192;
        }
        return i12;
    }

    @Override // com.transsion.transfer.androidasync.s
    public void o(bv.j jVar) {
        this.f55244l = jVar;
    }

    @Override // com.transsion.transfer.androidasync.s
    public void p(bv.a aVar) {
        this.f55233a.p(aVar);
    }

    @Override // com.transsion.transfer.androidasync.p
    public void pause() {
        this.f55233a.pause();
    }

    public bv.a r() {
        return this.f55253u;
    }

    @Override // com.transsion.transfer.androidasync.p
    public void resume() {
        this.f55233a.resume();
        C();
    }

    @Override // com.transsion.transfer.androidasync.p
    public void s(bv.a aVar) {
        this.f55253u = aVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public void t(bv.d dVar) {
        this.f55245m = dVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public String v() {
        return null;
    }
}
