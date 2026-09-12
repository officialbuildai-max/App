package com.iab.omid.library.vungle.adsession;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final h f33823a;

    private a(h hVar) {
        this.f33823a = hVar;
    }

    public static a a(b bVar) {
        h hVar = (h) bVar;
        ue.g.d(bVar, "AdSession is null");
        ue.g.j(hVar);
        ue.g.g(hVar);
        a aVar = new a(hVar);
        hVar.k().d(aVar);
        return aVar;
    }

    public void b() {
        ue.g.g(this.f33823a);
        ue.g.i(this.f33823a);
        if (!this.f33823a.o()) {
            try {
                this.f33823a.d();
            } catch (Exception unused) {
            }
        }
        if (this.f33823a.o()) {
            this.f33823a.s();
        }
    }

    public void c() {
        ue.g.c(this.f33823a);
        ue.g.i(this.f33823a);
        this.f33823a.t();
    }
}
