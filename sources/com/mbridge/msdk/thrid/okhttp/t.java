package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.y;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes5.dex */
public class t implements Cloneable {
    static final List<u> A = com.mbridge.msdk.thrid.okhttp.internal.c.a(u.HTTP_2, u.HTTP_1_1);
    static final List<i> B = com.mbridge.msdk.thrid.okhttp.internal.c.a(i.f37942h, i.f37944j);

    /* renamed from: a, reason: collision with root package name */
    final l f38361a;

    /* renamed from: b, reason: collision with root package name */
    final Proxy f38362b;

    /* renamed from: c, reason: collision with root package name */
    final List<u> f38363c;

    /* renamed from: d, reason: collision with root package name */
    final List<i> f38364d;

    /* renamed from: e, reason: collision with root package name */
    final List<r> f38365e;

    /* renamed from: f, reason: collision with root package name */
    final List<r> f38366f;

    /* renamed from: g, reason: collision with root package name */
    final n.c f38367g;

    /* renamed from: h, reason: collision with root package name */
    final ProxySelector f38368h;

    /* renamed from: i, reason: collision with root package name */
    final k f38369i;

    /* renamed from: j, reason: collision with root package name */
    final SocketFactory f38370j;

    /* renamed from: k, reason: collision with root package name */
    final SSLSocketFactory f38371k;

    /* renamed from: l, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.internal.tls.c f38372l;

    /* renamed from: m, reason: collision with root package name */
    final HostnameVerifier f38373m;

    /* renamed from: n, reason: collision with root package name */
    final e f38374n;

    /* renamed from: o, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.b f38375o;

    /* renamed from: p, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.b f38376p;

    /* renamed from: q, reason: collision with root package name */
    final h f38377q;

    /* renamed from: r, reason: collision with root package name */
    final m f38378r;

    /* renamed from: s, reason: collision with root package name */
    final boolean f38379s;

    /* renamed from: t, reason: collision with root package name */
    final boolean f38380t;

    /* renamed from: u, reason: collision with root package name */
    final boolean f38381u;

    /* renamed from: v, reason: collision with root package name */
    final int f38382v;

    /* renamed from: w, reason: collision with root package name */
    final int f38383w;

    /* renamed from: x, reason: collision with root package name */
    final int f38384x;

    /* renamed from: y, reason: collision with root package name */
    final int f38385y;

    /* renamed from: z, reason: collision with root package name */
    final int f38386z;

    /* loaded from: classes5.dex */
    static class a extends com.mbridge.msdk.thrid.okhttp.internal.a {
        a() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public int a(y.a aVar) {
            return aVar.f38460c;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public com.mbridge.msdk.thrid.okhttp.internal.connection.c a(h hVar, com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, a0 a0Var) {
            return hVar.a(aVar, gVar, a0Var);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public com.mbridge.msdk.thrid.okhttp.internal.connection.d a(h hVar) {
            return hVar.f37936e;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public IOException a(d dVar, IOException iOException) {
            return ((v) dVar).a(iOException);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public Socket a(h hVar, com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar) {
            return hVar.a(aVar, gVar);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public void a(i iVar, SSLSocket sSLSocket, boolean z10) {
            iVar.a(sSLSocket, z10);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public void a(p.a aVar, String str) {
            aVar.a(str);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public void a(p.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public boolean a(com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public boolean a(h hVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar) {
            return hVar.a(cVar);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.a
        public void b(h hVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar) {
            hVar.b(cVar);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        l f38387a;

        /* renamed from: b, reason: collision with root package name */
        Proxy f38388b;

        /* renamed from: c, reason: collision with root package name */
        List<u> f38389c;

        /* renamed from: d, reason: collision with root package name */
        List<i> f38390d;

        /* renamed from: e, reason: collision with root package name */
        final List<r> f38391e;

        /* renamed from: f, reason: collision with root package name */
        final List<r> f38392f;

        /* renamed from: g, reason: collision with root package name */
        n.c f38393g;

        /* renamed from: h, reason: collision with root package name */
        ProxySelector f38394h;

        /* renamed from: i, reason: collision with root package name */
        k f38395i;

        /* renamed from: j, reason: collision with root package name */
        SocketFactory f38396j;

        /* renamed from: k, reason: collision with root package name */
        SSLSocketFactory f38397k;

        /* renamed from: l, reason: collision with root package name */
        com.mbridge.msdk.thrid.okhttp.internal.tls.c f38398l;

        /* renamed from: m, reason: collision with root package name */
        HostnameVerifier f38399m;

        /* renamed from: n, reason: collision with root package name */
        e f38400n;

        /* renamed from: o, reason: collision with root package name */
        com.mbridge.msdk.thrid.okhttp.b f38401o;

        /* renamed from: p, reason: collision with root package name */
        com.mbridge.msdk.thrid.okhttp.b f38402p;

        /* renamed from: q, reason: collision with root package name */
        h f38403q;

        /* renamed from: r, reason: collision with root package name */
        m f38404r;

        /* renamed from: s, reason: collision with root package name */
        boolean f38405s;

        /* renamed from: t, reason: collision with root package name */
        boolean f38406t;

        /* renamed from: u, reason: collision with root package name */
        boolean f38407u;

        /* renamed from: v, reason: collision with root package name */
        int f38408v;

        /* renamed from: w, reason: collision with root package name */
        int f38409w;

        /* renamed from: x, reason: collision with root package name */
        int f38410x;

        /* renamed from: y, reason: collision with root package name */
        int f38411y;

        /* renamed from: z, reason: collision with root package name */
        int f38412z;

        public b() {
            this.f38391e = new ArrayList();
            this.f38392f = new ArrayList();
            this.f38387a = new l();
            this.f38389c = t.A;
            this.f38390d = t.B;
            this.f38393g = n.factory(n.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f38394h = proxySelector;
            if (proxySelector == null) {
                this.f38394h = new com.mbridge.msdk.thrid.okhttp.internal.proxy.a();
            }
            this.f38395i = k.f38326a;
            this.f38396j = SocketFactory.getDefault();
            this.f38399m = com.mbridge.msdk.thrid.okhttp.internal.tls.d.f38312a;
            this.f38400n = e.f37852c;
            com.mbridge.msdk.thrid.okhttp.b bVar = com.mbridge.msdk.thrid.okhttp.b.f37821a;
            this.f38401o = bVar;
            this.f38402p = bVar;
            this.f38403q = new h();
            this.f38404r = m.f38335a;
            this.f38405s = true;
            this.f38406t = true;
            this.f38407u = true;
            this.f38408v = 0;
            this.f38409w = 10000;
            this.f38410x = 10000;
            this.f38411y = 10000;
            this.f38412z = 0;
        }

        b(t tVar) {
            ArrayList arrayList = new ArrayList();
            this.f38391e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f38392f = arrayList2;
            this.f38387a = tVar.f38361a;
            this.f38388b = tVar.f38362b;
            this.f38389c = tVar.f38363c;
            this.f38390d = tVar.f38364d;
            arrayList.addAll(tVar.f38365e);
            arrayList2.addAll(tVar.f38366f);
            this.f38393g = tVar.f38367g;
            this.f38394h = tVar.f38368h;
            this.f38395i = tVar.f38369i;
            this.f38396j = tVar.f38370j;
            this.f38397k = tVar.f38371k;
            this.f38398l = tVar.f38372l;
            this.f38399m = tVar.f38373m;
            this.f38400n = tVar.f38374n;
            this.f38401o = tVar.f38375o;
            this.f38402p = tVar.f38376p;
            this.f38403q = tVar.f38377q;
            this.f38404r = tVar.f38378r;
            this.f38405s = tVar.f38379s;
            this.f38406t = tVar.f38380t;
            this.f38407u = tVar.f38381u;
            this.f38408v = tVar.f38382v;
            this.f38409w = tVar.f38383w;
            this.f38410x = tVar.f38384x;
            this.f38411y = tVar.f38385y;
            this.f38412z = tVar.f38386z;
        }

        public b a(long j11, TimeUnit timeUnit) {
            this.f38408v = com.mbridge.msdk.thrid.okhttp.internal.c.a("timeout", j11, timeUnit);
            return this;
        }

        public b a(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.f38403q = hVar;
            return this;
        }

        public b a(l lVar) {
            if (lVar == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.f38387a = lVar;
            return this;
        }

        public b a(m mVar) {
            if (mVar == null) {
                throw new NullPointerException("dns == null");
            }
            this.f38404r = mVar;
            return this;
        }

        public b a(n nVar) {
            if (nVar == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.f38393g = n.factory(nVar);
            return this;
        }

        public b a(List<u> list) {
            ArrayList arrayList = new ArrayList(list);
            u uVar = u.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(uVar) && !arrayList.contains(u.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(uVar) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(u.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(u.SPDY_3);
            this.f38389c = Collections.unmodifiableList(arrayList);
            return this;
        }

        public b a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.f38399m = hostnameVerifier;
            return this;
        }

        public b a(boolean z10) {
            this.f38407u = z10;
            return this;
        }

        public t a() {
            return new t(this);
        }

        public b b(long j11, TimeUnit timeUnit) {
            this.f38409w = com.mbridge.msdk.thrid.okhttp.internal.c.a("timeout", j11, timeUnit);
            return this;
        }

        public b c(long j11, TimeUnit timeUnit) {
            this.f38412z = com.mbridge.msdk.thrid.okhttp.internal.c.a("interval", j11, timeUnit);
            return this;
        }

        public b d(long j11, TimeUnit timeUnit) {
            this.f38410x = com.mbridge.msdk.thrid.okhttp.internal.c.a("timeout", j11, timeUnit);
            return this;
        }

        public b e(long j11, TimeUnit timeUnit) {
            this.f38411y = com.mbridge.msdk.thrid.okhttp.internal.c.a("timeout", j11, timeUnit);
            return this;
        }
    }

    static {
        com.mbridge.msdk.thrid.okhttp.internal.a.f37953a = new a();
    }

    public t() {
        this(new b());
    }

    t(b bVar) {
        boolean z10;
        this.f38361a = bVar.f38387a;
        this.f38362b = bVar.f38388b;
        this.f38363c = bVar.f38389c;
        List<i> list = bVar.f38390d;
        this.f38364d = list;
        this.f38365e = com.mbridge.msdk.thrid.okhttp.internal.c.a(bVar.f38391e);
        this.f38366f = com.mbridge.msdk.thrid.okhttp.internal.c.a(bVar.f38392f);
        this.f38367g = bVar.f38393g;
        this.f38368h = bVar.f38394h;
        this.f38369i = bVar.f38395i;
        this.f38370j = bVar.f38396j;
        Iterator<i> it = list.iterator();
        loop0: while (true) {
            z10 = false;
            while (it.hasNext()) {
                z10 = (z10 || it.next().b()) ? true : z10;
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f38397k;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager a11 = com.mbridge.msdk.thrid.okhttp.internal.c.a();
            this.f38371k = a(a11);
            this.f38372l = com.mbridge.msdk.thrid.okhttp.internal.tls.c.a(a11);
        } else {
            this.f38371k = sSLSocketFactory;
            this.f38372l = bVar.f38398l;
        }
        if (this.f38371k != null) {
            com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(this.f38371k);
        }
        this.f38373m = bVar.f38399m;
        this.f38374n = bVar.f38400n.a(this.f38372l);
        this.f38375o = bVar.f38401o;
        this.f38376p = bVar.f38402p;
        this.f38377q = bVar.f38403q;
        this.f38378r = bVar.f38404r;
        this.f38379s = bVar.f38405s;
        this.f38380t = bVar.f38406t;
        this.f38381u = bVar.f38407u;
        this.f38382v = bVar.f38408v;
        this.f38383w = bVar.f38409w;
        this.f38384x = bVar.f38410x;
        this.f38385y = bVar.f38411y;
        this.f38386z = bVar.f38412z;
        if (this.f38365e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f38365e);
        }
        if (this.f38366f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f38366f);
        }
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext e11 = com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().e();
            e11.init(null, new TrustManager[]{x509TrustManager}, null);
            return e11.getSocketFactory();
        } catch (GeneralSecurityException e12) {
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("No System TLS", (Exception) e12);
        }
    }

    public SocketFactory A() {
        return this.f38370j;
    }

    public SSLSocketFactory B() {
        return this.f38371k;
    }

    public int C() {
        return this.f38385y;
    }

    public com.mbridge.msdk.thrid.okhttp.b a() {
        return this.f38376p;
    }

    public d a(w wVar) {
        return v.a(this, wVar, false);
    }

    public int b() {
        return this.f38382v;
    }

    public e c() {
        return this.f38374n;
    }

    public int e() {
        return this.f38383w;
    }

    public h f() {
        return this.f38377q;
    }

    public List<i> g() {
        return this.f38364d;
    }

    public k i() {
        return this.f38369i;
    }

    public l j() {
        return this.f38361a;
    }

    public m k() {
        return this.f38378r;
    }

    public n.c l() {
        return this.f38367g;
    }

    public boolean m() {
        return this.f38380t;
    }

    public boolean n() {
        return this.f38379s;
    }

    public HostnameVerifier o() {
        return this.f38373m;
    }

    public List<r> p() {
        return this.f38365e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.mbridge.msdk.thrid.okhttp.internal.cache.c q() {
        return null;
    }

    public List<r> r() {
        return this.f38366f;
    }

    public b s() {
        return new b(this);
    }

    public int t() {
        return this.f38386z;
    }

    public List<u> u() {
        return this.f38363c;
    }

    public Proxy v() {
        return this.f38362b;
    }

    public com.mbridge.msdk.thrid.okhttp.b w() {
        return this.f38375o;
    }

    public ProxySelector x() {
        return this.f38368h;
    }

    public int y() {
        return this.f38384x;
    }

    public boolean z() {
        return this.f38381u;
    }
}
