package com.iab.omid.library.hisavana.adsession;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final h f33589a;

    private a(h hVar) {
        this.f33589a = hVar;
    }

    public static a a(b bVar) {
        h hVar = (h) bVar;
        ie.g.d(bVar, "AdSession is null");
        ie.g.j(hVar);
        ie.g.g(hVar);
        a aVar = new a(hVar);
        hVar.l().d(aVar);
        return aVar;
    }

    public void b() {
        ie.g.g(this.f33589a);
        ie.g.i(this.f33589a);
        if (!this.f33589a.p()) {
            try {
                this.f33589a.e();
            } catch (Exception unused) {
            }
        }
        if (this.f33589a.p()) {
            this.f33589a.t();
        }
    }

    public void c() {
        ie.g.c(this.f33589a);
        ie.g.i(this.f33589a);
        this.f33589a.u();
    }
}
