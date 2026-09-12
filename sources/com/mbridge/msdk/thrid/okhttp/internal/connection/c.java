package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.h;
import com.mbridge.msdk.thrid.okhttp.i;
import com.mbridge.msdk.thrid.okhttp.internal.http2.g;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.o;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import com.mbridge.msdk.thrid.okio.s;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: classes5.dex */
public final class c extends g.j implements com.mbridge.msdk.thrid.okhttp.g {

    /* renamed from: b, reason: collision with root package name */
    private final h f37995b;

    /* renamed from: c, reason: collision with root package name */
    private final a0 f37996c;

    /* renamed from: d, reason: collision with root package name */
    private Socket f37997d;

    /* renamed from: e, reason: collision with root package name */
    private Socket f37998e;

    /* renamed from: f, reason: collision with root package name */
    private o f37999f;

    /* renamed from: g, reason: collision with root package name */
    private u f38000g;

    /* renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.thrid.okhttp.internal.http2.g f38001h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.thrid.okio.e f38002i;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.thrid.okio.d f38003j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f38004k;

    /* renamed from: l, reason: collision with root package name */
    public int f38005l;

    /* renamed from: m, reason: collision with root package name */
    public int f38006m = 1;

    /* renamed from: n, reason: collision with root package name */
    public final List<Reference<g>> f38007n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public long f38008o = Long.MAX_VALUE;

    public c(h hVar, a0 a0Var) {
        this.f37995b = hVar;
        this.f37996c = a0Var;
    }

    private w a(int i11, int i12, w wVar, q qVar) throws IOException {
        String str = "CONNECT " + com.mbridge.msdk.thrid.okhttp.internal.c.a(qVar, true) + " HTTP/1.1";
        while (true) {
            com.mbridge.msdk.thrid.okhttp.internal.http1.a aVar = new com.mbridge.msdk.thrid.okhttp.internal.http1.a(null, null, this.f38002i, this.f38003j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f38002i.b().a(i11, timeUnit);
            this.f38003j.b().a(i12, timeUnit);
            aVar.a(wVar.c(), str);
            aVar.a();
            y a11 = aVar.a(false).a(wVar).a();
            long a12 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(a11);
            if (a12 == -1) {
                a12 = 0;
            }
            s b11 = aVar.b(a12);
            com.mbridge.msdk.thrid.okhttp.internal.c.b(b11, Integer.MAX_VALUE, timeUnit);
            b11.close();
            int k11 = a11.k();
            if (k11 == 200) {
                if (this.f38002i.a().f() && this.f38003j.a().f()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (k11 != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + a11.k());
            }
            w a13 = this.f37996c.a().g().a(this.f37996c, a11);
            if (a13 == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(a11.b("Connection"))) {
                return a13;
            }
            wVar = a13;
        }
    }

    private void a(int i11) throws IOException {
        this.f37998e.setSoTimeout(0);
        com.mbridge.msdk.thrid.okhttp.internal.http2.g a11 = new g.h(true).a(this.f37998e, this.f37996c.a().k().g(), this.f38002i, this.f38003j).a(this).a(i11).a();
        this.f38001h = a11;
        a11.m();
    }

    private void a(int i11, int i12, int i13, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws IOException {
        w e11 = e();
        q g11 = e11.g();
        for (int i14 = 0; i14 < 21; i14++) {
            a(i11, i12, dVar, nVar);
            e11 = a(i12, i13, e11, g11);
            if (e11 == null) {
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37997d);
            this.f37997d = null;
            this.f38003j = null;
            this.f38002i = null;
            nVar.connectEnd(dVar, this.f37996c.d(), this.f37996c.b(), null);
        }
    }

    private void a(int i11, int i12, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws IOException {
        Proxy b11 = this.f37996c.b();
        this.f37997d = (b11.type() == Proxy.Type.DIRECT || b11.type() == Proxy.Type.HTTP) ? this.f37996c.a().i().createSocket() : new Socket(b11);
        nVar.connectStart(dVar, this.f37996c.d(), b11);
        this.f37997d.setSoTimeout(i12);
        try {
            com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(this.f37997d, this.f37996c.d(), i11);
            try {
                this.f38002i = l.a(l.b(this.f37997d));
                this.f38003j = l.a(l.a(this.f37997d));
            } catch (NullPointerException e11) {
                if ("throw with null exception".equals(e11.getMessage())) {
                    throw new IOException(e11);
                }
            }
        } catch (ConnectException e12) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f37996c.d());
            connectException.initCause(e12);
            throw connectException;
        }
    }

    private void a(b bVar) throws IOException {
        SSLSocket sSLSocket;
        com.mbridge.msdk.thrid.okhttp.a a11 = this.f37996c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a11.j().createSocket(this.f37997d, a11.k().g(), a11.k().j(), true);
            } catch (AssertionError e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            i a12 = bVar.a(sSLSocket);
            if (a12.c()) {
                com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket, a11.k().g(), a11.e());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            o a13 = o.a(session);
            if (a11.d().verify(a11.k().g(), session)) {
                a11.a().a(a11.k().g(), a13.b());
                String b11 = a12.c() ? com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().b(sSLSocket) : null;
                this.f37998e = sSLSocket;
                this.f38002i = l.a(l.b(sSLSocket));
                this.f38003j = l.a(l.a(this.f37998e));
                this.f37999f = a13;
                this.f38000g = b11 != null ? u.a(b11) : u.HTTP_1_1;
                com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket);
                return;
            }
            List<Certificate> b12 = a13.b();
            if (b12.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + a11.k().g() + " not verified (no certificates)");
            }
            X509Certificate x509Certificate = (X509Certificate) b12.get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a11.k().g() + " not verified:\n    certificate: " + com.mbridge.msdk.thrid.okhttp.e.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.mbridge.msdk.thrid.okhttp.internal.tls.d.a(x509Certificate));
        } catch (AssertionError e12) {
            e = e12;
            if (!com.mbridge.msdk.thrid.okhttp.internal.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th3) {
            th = th3;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket2);
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private void a(b bVar, int i11, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws IOException {
        if (this.f37996c.a().j() != null) {
            nVar.secureConnectStart(dVar);
            a(bVar);
            nVar.secureConnectEnd(dVar, this.f37999f);
            if (this.f38000g == u.HTTP_2) {
                a(i11);
                return;
            }
            return;
        }
        List<u> e11 = this.f37996c.a().e();
        u uVar = u.H2_PRIOR_KNOWLEDGE;
        if (!e11.contains(uVar)) {
            this.f37998e = this.f37997d;
            this.f38000g = u.HTTP_1_1;
        } else {
            this.f37998e = this.f37997d;
            this.f38000g = uVar;
            a(i11);
        }
    }

    private w e() throws IOException {
        w a11 = new w.a().a(this.f37996c.a().k()).a("CONNECT", (x) null).b(HttpHeaders.HOST, com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37996c.a().k(), true)).b("Proxy-Connection", "Keep-Alive").b("User-Agent", com.mbridge.msdk.thrid.okhttp.internal.d.a()).a();
        w a12 = this.f37996c.a().g().a(this.f37996c, new y.a().a(a11).a(u.HTTP_1_1).a(TTAdConstant.DOWNLOAD_APP_INFO_CODE).a("Preemptive Authenticate").a(com.mbridge.msdk.thrid.okhttp.internal.c.f37957c).b(-1L).a(-1L).b("Proxy-Authenticate", "OkHttp-Preemptive").a());
        return a12 != null ? a12 : a11;
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http.c a(t tVar, r.a aVar, g gVar) throws SocketException {
        if (this.f38001h != null) {
            return new com.mbridge.msdk.thrid.okhttp.internal.http2.f(tVar, aVar, gVar, this.f38001h);
        }
        this.f37998e.setSoTimeout(aVar.b());
        com.mbridge.msdk.thrid.okio.t b11 = this.f38002i.b();
        long b12 = aVar.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        b11.a(b12, timeUnit);
        this.f38003j.b().a(aVar.c(), timeUnit);
        return new com.mbridge.msdk.thrid.okhttp.internal.http1.a(tVar, gVar, this.f38002i, this.f38003j);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public u a() {
        return this.f38000g;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r17, int r18, int r19, int r20, boolean r21, com.mbridge.msdk.thrid.okhttp.d r22, com.mbridge.msdk.thrid.okhttp.n r23) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.connection.c.a(int, int, int, int, boolean, com.mbridge.msdk.thrid.okhttp.d, com.mbridge.msdk.thrid.okhttp.n):void");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.g.j
    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.g gVar) {
        synchronized (this.f37995b) {
            this.f38006m = gVar.k();
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.g.j
    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) throws IOException {
        iVar.a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM);
    }

    public boolean a(com.mbridge.msdk.thrid.okhttp.a aVar, a0 a0Var) {
        if (this.f38007n.size() >= this.f38006m || this.f38004k || !com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(this.f37996c.a(), aVar)) {
            return false;
        }
        if (aVar.k().g().equals(c().a().k().g())) {
            return true;
        }
        if (this.f38001h == null || a0Var == null) {
            return false;
        }
        Proxy.Type type = a0Var.b().type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || this.f37996c.b().type() != type2 || !this.f37996c.d().equals(a0Var.d()) || a0Var.a().d() != com.mbridge.msdk.thrid.okhttp.internal.tls.d.f38312a || !a(aVar.k())) {
            return false;
        }
        try {
            aVar.a().a(aVar.k().g(), b().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(q qVar) {
        if (qVar.j() != this.f37996c.a().k().j()) {
            return false;
        }
        if (qVar.g().equals(this.f37996c.a().k().g())) {
            return true;
        }
        return this.f37999f != null && com.mbridge.msdk.thrid.okhttp.internal.tls.d.f38312a.a(qVar.g(), (X509Certificate) this.f37999f.b().get(0));
    }

    public boolean a(boolean z10) {
        if (this.f37998e.isClosed() || this.f37998e.isInputShutdown() || this.f37998e.isOutputShutdown()) {
            return false;
        }
        com.mbridge.msdk.thrid.okhttp.internal.http2.g gVar = this.f38001h;
        if (gVar != null) {
            return gVar.f(System.nanoTime());
        }
        if (z10) {
            try {
                int soTimeout = this.f37998e.getSoTimeout();
                try {
                    this.f37998e.setSoTimeout(1);
                    return !this.f38002i.f();
                } finally {
                    this.f37998e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public o b() {
        return this.f37999f;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public a0 c() {
        return this.f37996c;
    }

    public void d() {
        com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37997d);
    }

    public boolean f() {
        return this.f38001h != null;
    }

    public Socket g() {
        return this.f37998e;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f37996c.a().k().g());
        sb2.append(":");
        sb2.append(this.f37996c.a().k().j());
        sb2.append(", proxy=");
        sb2.append(this.f37996c.b());
        sb2.append(" hostAddress=");
        sb2.append(this.f37996c.d());
        sb2.append(" cipherSuite=");
        o oVar = this.f37999f;
        sb2.append(oVar != null ? oVar.a() : "none");
        sb2.append(" protocol=");
        sb2.append(this.f38000g);
        sb2.append('}');
        return sb2.toString();
    }
}
