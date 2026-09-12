package o0;

/* loaded from: classes2.dex */
public abstract class q {
    public static final long a(int i11, int i12) {
        return p.c((i12 & 4294967295L) | (i11 << 32));
    }

    public static final long b(long j11, long j12) {
        return y.h.a(y.g.m(j11) - p.h(j12), y.g.n(j11) - p.i(j12));
    }

    public static final long c(long j11, long j12) {
        return y.h.a(y.g.m(j11) + p.h(j12), y.g.n(j11) + p.i(j12));
    }

    public static final long d(long j11) {
        return p.c((Math.round(y.g.n(j11)) & 4294967295L) | (Math.round(y.g.m(j11)) << 32));
    }
}
