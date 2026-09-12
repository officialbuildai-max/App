package androidx.media3.exoplayer;

/* loaded from: classes2.dex */
public final class c4 {

    /* renamed from: c, reason: collision with root package name */
    public static final c4 f11424c;

    /* renamed from: d, reason: collision with root package name */
    public static final c4 f11425d;

    /* renamed from: e, reason: collision with root package name */
    public static final c4 f11426e;

    /* renamed from: f, reason: collision with root package name */
    public static final c4 f11427f;

    /* renamed from: g, reason: collision with root package name */
    public static final c4 f11428g;

    /* renamed from: a, reason: collision with root package name */
    public final long f11429a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11430b;

    static {
        c4 c4Var = new c4(0L, 0L);
        f11424c = c4Var;
        f11425d = new c4(Long.MAX_VALUE, Long.MAX_VALUE);
        f11426e = new c4(Long.MAX_VALUE, 0L);
        f11427f = new c4(0L, Long.MAX_VALUE);
        f11428g = c4Var;
    }

    public c4(long j11, long j12) {
        androidx.media3.common.util.a.a(j11 >= 0);
        androidx.media3.common.util.a.a(j12 >= 0);
        this.f11429a = j11;
        this.f11430b = j12;
    }

    public long a(long j11, long j12, long j13) {
        long j14 = this.f11429a;
        if (j14 == 0 && this.f11430b == 0) {
            return j11;
        }
        long s12 = androidx.media3.common.util.a1.s1(j11, j14, Long.MIN_VALUE);
        long c11 = androidx.media3.common.util.a1.c(j11, this.f11430b, Long.MAX_VALUE);
        boolean z10 = false;
        boolean z11 = s12 <= j12 && j12 <= c11;
        if (s12 <= j13 && j13 <= c11) {
            z10 = true;
        }
        return (z11 && z10) ? Math.abs(j12 - j11) <= Math.abs(j13 - j11) ? j12 : j13 : z11 ? j12 : z10 ? j13 : s12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c4.class != obj.getClass()) {
            return false;
        }
        c4 c4Var = (c4) obj;
        return this.f11429a == c4Var.f11429a && this.f11430b == c4Var.f11430b;
    }

    public int hashCode() {
        return (((int) this.f11429a) * 31) + ((int) this.f11430b);
    }
}
