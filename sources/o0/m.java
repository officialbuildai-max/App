package o0;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class m {
    public static float a(n nVar, long j11) {
        p0.a b11;
        if (!y.g(w.g(j11), y.f70755b.b())) {
            o.b("Only Sp can convert to Px");
        }
        p0.b bVar = p0.b.f72344a;
        if (bVar.f(nVar.C0()) && (b11 = bVar.b(nVar.C0())) != null) {
            return i.g(b11.b(w.h(j11)));
        }
        return i.g(w.h(j11) * nVar.C0());
    }

    public static long b(n nVar, float f11) {
        p0.b bVar = p0.b.f72344a;
        if (!bVar.f(nVar.C0())) {
            return x.b(f11 / nVar.C0());
        }
        p0.a b11 = bVar.b(nVar.C0());
        return x.b(b11 != null ? b11.a(f11) : f11 / nVar.C0());
    }
}
