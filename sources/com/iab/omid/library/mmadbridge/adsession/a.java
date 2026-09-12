package com.iab.omid.library.mmadbridge.adsession;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final h f33703a;

    private a(h hVar) {
        this.f33703a = hVar;
    }

    public static a a(b bVar) {
        h hVar = (h) bVar;
        oe.g.d(bVar, "AdSession is null");
        oe.g.l(hVar);
        oe.g.g(hVar);
        a aVar = new a(hVar);
        hVar.t().d(aVar);
        return aVar;
    }

    public void b() {
        oe.g.g(this.f33703a);
        oe.g.j(this.f33703a);
        if (!this.f33703a.q()) {
            try {
                this.f33703a.g();
            } catch (Exception unused) {
            }
        }
        if (this.f33703a.q()) {
            this.f33703a.x();
        }
    }

    public void c() {
        oe.g.c(this.f33703a);
        oe.g.j(this.f33703a);
        this.f33703a.y();
    }

    public void d(com.iab.omid.library.mmadbridge.adsession.media.b bVar) {
        oe.g.d(bVar, "VastProperties is null");
        oe.g.c(this.f33703a);
        oe.g.j(this.f33703a);
        this.f33703a.k(bVar.a());
    }
}
