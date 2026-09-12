package androidx.compose.ui.input.pointer;

/* loaded from: classes.dex */
public abstract class p {
    public static final boolean a(w wVar) {
        return (wVar.p() || wVar.l() || !wVar.i()) ? false : true;
    }

    public static final boolean b(w wVar) {
        return !wVar.l() && wVar.i();
    }

    public static final boolean c(w wVar) {
        return (wVar.p() || !wVar.l() || wVar.i()) ? false : true;
    }

    public static final boolean d(w wVar) {
        return wVar.l() && !wVar.i();
    }

    public static final boolean e(w wVar, long j11) {
        long h11 = wVar.h();
        float m11 = y.g.m(h11);
        float n11 = y.g.n(h11);
        return m11 < 0.0f || m11 > ((float) o0.t.g(j11)) || n11 < 0.0f || n11 > ((float) o0.t.f(j11));
    }

    public static final boolean f(w wVar, long j11, long j12) {
        if (!h0.g(wVar.n(), h0.f5073a.d())) {
            return e(wVar, j11);
        }
        long h11 = wVar.h();
        float m11 = y.g.m(h11);
        float n11 = y.g.n(h11);
        return m11 < (-y.m.i(j12)) || m11 > ((float) o0.t.g(j11)) + y.m.i(j12) || n11 < (-y.m.g(j12)) || n11 > ((float) o0.t.f(j11)) + y.m.g(j12);
    }

    public static final long g(w wVar) {
        return i(wVar, false);
    }

    public static final long h(w wVar) {
        return i(wVar, true);
    }

    private static final long i(w wVar, boolean z10) {
        long q11 = y.g.q(wVar.h(), wVar.k());
        return (z10 || !wVar.p()) ? q11 : y.g.f78593b.c();
    }

    public static final boolean j(w wVar) {
        return !y.g.j(i(wVar, true), y.g.f78593b.c());
    }
}
