package o0;

/* loaded from: classes2.dex */
public abstract class u {
    public static final long a(int i11, int i12) {
        return t.c((i12 & 4294967295L) | (i11 << 32));
    }

    public static final long b(long j11) {
        return p.c((((j11 << 32) >> 33) & 4294967295L) | ((j11 >> 33) << 32));
    }

    public static final long c(long j11) {
        return t.c((Math.round(y.m.g(j11)) & 4294967295L) | (Math.round(y.m.i(j11)) << 32));
    }

    public static final long d(long j11) {
        return y.n.a(t.g(j11), t.f(j11));
    }
}
