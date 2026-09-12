package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import bv.d;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.http.g;
import com.transsion.transfer.androidasync.util.ArrayDeque;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Hashtable;
import java.util.Locale;

/* loaded from: classes6.dex */
public class t extends a0 {

    /* renamed from: a, reason: collision with root package name */
    String f55618a;

    /* renamed from: b, reason: collision with root package name */
    int f55619b;

    /* renamed from: c, reason: collision with root package name */
    int f55620c;

    /* renamed from: d, reason: collision with root package name */
    protected AsyncHttpClient f55621d;

    /* renamed from: e, reason: collision with root package name */
    boolean f55622e;

    /* renamed from: f, reason: collision with root package name */
    String f55623f;

    /* renamed from: g, reason: collision with root package name */
    int f55624g;

    /* renamed from: h, reason: collision with root package name */
    Hashtable f55625h;

    /* renamed from: i, reason: collision with root package name */
    int f55626i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayDeque f55627a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f55628b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f55629c;

        a(ArrayDeque arrayDeque, e eVar, String str) {
            this.f55627a = arrayDeque;
            this.f55628b = eVar;
            this.f55629c = str;
        }

        @Override // bv.a
        public void g(Exception exc) {
            synchronized (t.this) {
                this.f55627a.remove(this.f55628b);
                t.this.w(this.f55629c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.transsion.transfer.androidasync.j f55631a;

        b(com.transsion.transfer.androidasync.j jVar) {
            this.f55631a = jVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            this.f55631a.p(null);
            this.f55631a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.transsion.transfer.androidasync.j f55633a;

        c(com.transsion.transfer.androidasync.j jVar) {
            this.f55633a = jVar;
        }

        @Override // bv.d.a, bv.d
        public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            super.F(pVar, byteBufferList);
            byteBufferList.B();
            this.f55633a.p(null);
            this.f55633a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        int f55635a;

        /* renamed from: b, reason: collision with root package name */
        ArrayDeque f55636b = new ArrayDeque();

        /* renamed from: c, reason: collision with root package name */
        ArrayDeque f55637c = new ArrayDeque();

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        com.transsion.transfer.androidasync.j f55638a;

        /* renamed from: b, reason: collision with root package name */
        long f55639b = System.currentTimeMillis();

        public e(com.transsion.transfer.androidasync.j jVar) {
            this.f55638a = jVar;
        }
    }

    public t(AsyncHttpClient asyncHttpClient) {
        this(asyncHttpClient, "http", 80);
    }

    public t(AsyncHttpClient asyncHttpClient, String str, int i11) {
        this.f55620c = 300000;
        this.f55625h = new Hashtable();
        this.f55626i = Integer.MAX_VALUE;
        this.f55621d = asyncHttpClient;
        this.f55618a = str;
        this.f55619b = i11;
    }

    private d o(String str) {
        d dVar = (d) this.f55625h.get(str);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        this.f55625h.put(str, dVar2);
        return dVar2;
    }

    private void q(com.transsion.transfer.androidasync.j jVar) {
        jVar.s(new b(jVar));
        jVar.o(null);
        jVar.t(new c(jVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.transsion.transfer.androidasync.future.f s(int i11, g.a aVar, InetAddress inetAddress) {
        final com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        String format = String.format(Locale.ENGLISH, "%s:%s", inetAddress, Integer.valueOf(i11));
        aVar.f55484b.u("attempting connection to " + format);
        this.f55621d.x().n(new InetSocketAddress(inetAddress, i11), new bv.b() { // from class: com.transsion.transfer.androidasync.http.s
            @Override // bv.b
            public final void a(Exception exc, com.transsion.transfer.androidasync.j jVar) {
                com.transsion.transfer.androidasync.future.w.this.H(exc, jVar);
            }
        });
        return wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.transsion.transfer.androidasync.future.f t(final int i11, final g.a aVar, InetAddress[] inetAddressArr) {
        return com.transsion.transfer.androidasync.future.l.d(inetAddressArr, new com.transsion.transfer.androidasync.future.z() { // from class: com.transsion.transfer.androidasync.http.r
            @Override // com.transsion.transfer.androidasync.future.z
            public final com.transsion.transfer.androidasync.future.f then(Object obj) {
                com.transsion.transfer.androidasync.future.f s11;
                s11 = t.this.s(i11, aVar, (InetAddress) obj);
                return s11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(g.a aVar, Uri uri, int i11, Exception exc) {
        z(aVar, uri, i11, false, aVar.f55475c).a(exc, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(g.a aVar, Uri uri, int i11, Exception exc, com.transsion.transfer.androidasync.j jVar) {
        if (jVar == null) {
            return;
        }
        if (exc == null) {
            z(aVar, uri, i11, false, aVar.f55475c).a(null, jVar);
            return;
        }
        aVar.f55484b.r("Recycling extra socket leftover from cancelled operation");
        q(jVar);
        y(jVar, aVar.f55484b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        d dVar = (d) this.f55625h.get(str);
        if (dVar == null) {
            return;
        }
        while (!dVar.f55637c.isEmpty()) {
            e eVar = (e) dVar.f55637c.peekLast();
            com.transsion.transfer.androidasync.j jVar = eVar.f55638a;
            if (eVar.f55639b + this.f55620c > System.currentTimeMillis()) {
                break;
            }
            dVar.f55637c.pop();
            jVar.p(null);
            jVar.close();
        }
        if (dVar.f55635a == 0 && dVar.f55636b.isEmpty() && dVar.f55637c.isEmpty()) {
            this.f55625h.remove(str);
        }
    }

    private void x(j jVar) {
        Uri p11 = jVar.p();
        String n11 = n(p11, p(p11), jVar.l(), jVar.m());
        synchronized (this) {
            try {
                d dVar = (d) this.f55625h.get(n11);
                if (dVar == null) {
                    return;
                }
                dVar.f55635a--;
                while (dVar.f55635a < this.f55626i && dVar.f55636b.size() > 0) {
                    g.a aVar = (g.a) dVar.f55636b.remove();
                    com.transsion.transfer.androidasync.future.n nVar = (com.transsion.transfer.androidasync.future.n) aVar.f55476d;
                    if (!nVar.isCancelled()) {
                        nVar.setParent(e(aVar));
                    }
                }
                w(n11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void y(com.transsion.transfer.androidasync.j jVar, j jVar2) {
        ArrayDeque arrayDeque;
        if (jVar == null) {
            return;
        }
        Uri p11 = jVar2.p();
        String n11 = n(p11, p(p11), jVar2.l(), jVar2.m());
        e eVar = new e(jVar);
        synchronized (this) {
            arrayDeque = o(n11).f55637c;
            arrayDeque.push(eVar);
        }
        jVar.p(new a(arrayDeque, eVar, n11));
    }

    @Override // com.transsion.transfer.androidasync.http.a0, com.transsion.transfer.androidasync.http.g
    public void b(g.C0699g c0699g) {
        if (c0699g.f55483a.a("socket-owner") != this) {
            return;
        }
        try {
            q(c0699g.f55479f);
            if (c0699g.f55485k == null && c0699g.f55479f.isOpen()) {
                if (r(c0699g)) {
                    c0699g.f55484b.r("Recycling keep-alive socket");
                    y(c0699g.f55479f, c0699g.f55484b);
                    return;
                } else {
                    c0699g.f55484b.u("closing out socket (not keep alive)");
                    c0699g.f55479f.p(null);
                    c0699g.f55479f.close();
                }
            }
            c0699g.f55484b.u("closing out socket (exception)");
            c0699g.f55479f.p(null);
            c0699g.f55479f.close();
        } finally {
            x(c0699g.f55484b);
        }
    }

    @Override // com.transsion.transfer.androidasync.http.a0, com.transsion.transfer.androidasync.http.g
    public com.transsion.transfer.androidasync.future.a e(final g.a aVar) {
        String host;
        int i11;
        String str;
        final Uri p11 = aVar.f55484b.p();
        final int p12 = p(aVar.f55484b.p());
        if (p12 == -1) {
            return null;
        }
        aVar.f55483a.b("socket-owner", this);
        d o11 = o(n(p11, p12, aVar.f55484b.l(), aVar.f55484b.m()));
        synchronized (this) {
            try {
                int i12 = o11.f55635a;
                if (i12 >= this.f55626i) {
                    com.transsion.transfer.androidasync.future.n nVar = new com.transsion.transfer.androidasync.future.n();
                    o11.f55636b.add(aVar);
                    return nVar;
                }
                boolean z10 = true;
                o11.f55635a = i12 + 1;
                while (!o11.f55637c.isEmpty()) {
                    e eVar = (e) o11.f55637c.pop();
                    com.transsion.transfer.androidasync.j jVar = eVar.f55638a;
                    if (eVar.f55639b + this.f55620c < System.currentTimeMillis()) {
                        jVar.p(null);
                        jVar.close();
                    } else if (jVar.isOpen()) {
                        aVar.f55484b.r("Reusing keep-alive socket");
                        aVar.f55475c.a(null, jVar);
                        com.transsion.transfer.androidasync.future.n nVar2 = new com.transsion.transfer.androidasync.future.n();
                        nVar2.setComplete();
                        return nVar2;
                    }
                }
                if (this.f55622e && this.f55623f == null && aVar.f55484b.l() == null) {
                    aVar.f55484b.u("Resolving domain and connecting to all available addresses");
                    com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
                    wVar.E(this.f55621d.x().p(p11.getHost()).a(new com.transsion.transfer.androidasync.future.z() { // from class: com.transsion.transfer.androidasync.http.o
                        @Override // com.transsion.transfer.androidasync.future.z
                        public final com.transsion.transfer.androidasync.future.f then(Object obj) {
                            com.transsion.transfer.androidasync.future.f t11;
                            t11 = t.this.t(p12, aVar, (InetAddress[]) obj);
                            return t11;
                        }
                    }).e(new com.transsion.transfer.androidasync.future.d() { // from class: com.transsion.transfer.androidasync.http.p
                        @Override // com.transsion.transfer.androidasync.future.d
                        public final void a(Exception exc) {
                            t.this.u(aVar, p11, p12, exc);
                        }
                    })).f(new com.transsion.transfer.androidasync.future.g() { // from class: com.transsion.transfer.androidasync.http.q
                        @Override // com.transsion.transfer.androidasync.future.g
                        public final void a(Exception exc, Object obj) {
                            t.this.v(aVar, p11, p12, exc, (com.transsion.transfer.androidasync.j) obj);
                        }
                    });
                    return wVar;
                }
                aVar.f55484b.r("Connecting socket");
                if (aVar.f55484b.l() == null && (str = this.f55623f) != null) {
                    aVar.f55484b.d(str, this.f55624g);
                }
                if (aVar.f55484b.l() != null) {
                    host = aVar.f55484b.l();
                    i11 = aVar.f55484b.m();
                } else {
                    host = p11.getHost();
                    z10 = false;
                    i11 = p12;
                }
                if (z10) {
                    aVar.f55484b.u("Using proxy: " + host + ":" + i11);
                }
                return this.f55621d.x().m(host, i11, z(aVar, p11, p12, z10, aVar.f55475c));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    String n(Uri uri, int i11, String str, int i12) {
        String str2;
        if (str != null) {
            str2 = str + ":" + i12;
        } else {
            str2 = "";
        }
        if (str != null) {
            str2 = str + ":" + i12;
        }
        return uri.getScheme() + "//" + uri.getHost() + ":" + i11 + "?proxy=" + str2;
    }

    public int p(Uri uri) {
        if (uri.getScheme() == null || !uri.getScheme().equals(this.f55618a)) {
            return -1;
        }
        return uri.getPort() == -1 ? this.f55619b : uri.getPort();
    }

    protected boolean r(g.C0699g c0699g) {
        return HttpUtil.e(c0699g.f55480g.protocol(), c0699g.f55480g.e()) && HttpUtil.d(Protocol.HTTP_1_1, c0699g.f55484b.h());
    }

    protected bv.b z(g.a aVar, Uri uri, int i11, boolean z10, bv.b bVar) {
        return bVar;
    }
}
