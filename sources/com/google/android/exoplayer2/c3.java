package com.google.android.exoplayer2;

/* loaded from: classes3.dex */
public final class c3 {

    /* renamed from: c, reason: collision with root package name */
    public static final c3 f24884c;

    /* renamed from: d, reason: collision with root package name */
    public static final c3 f24885d;

    /* renamed from: e, reason: collision with root package name */
    public static final c3 f24886e;

    /* renamed from: f, reason: collision with root package name */
    public static final c3 f24887f;

    /* renamed from: g, reason: collision with root package name */
    public static final c3 f24888g;

    /* renamed from: a, reason: collision with root package name */
    public final long f24889a;

    /* renamed from: b, reason: collision with root package name */
    public final long f24890b;

    static {
        c3 c3Var = new c3(0L, 0L);
        f24884c = c3Var;
        f24885d = new c3(Long.MAX_VALUE, Long.MAX_VALUE);
        f24886e = new c3(Long.MAX_VALUE, 0L);
        f24887f = new c3(0L, Long.MAX_VALUE);
        f24888g = c3Var;
    }

    public c3(long j11, long j12) {
        com.google.android.exoplayer2.util.a.a(j11 >= 0);
        com.google.android.exoplayer2.util.a.a(j12 >= 0);
        this.f24889a = j11;
        this.f24890b = j12;
    }

    public long a(long j11, long j12, long j13) {
        long j14 = this.f24889a;
        if (j14 == 0 && this.f24890b == 0) {
            return j11;
        }
        long W0 = com.google.android.exoplayer2.util.p0.W0(j11, j14, Long.MIN_VALUE);
        long b11 = com.google.android.exoplayer2.util.p0.b(j11, this.f24890b, Long.MAX_VALUE);
        boolean z10 = false;
        boolean z11 = W0 <= j12 && j12 <= b11;
        if (W0 <= j13 && j13 <= b11) {
            z10 = true;
        }
        return (z11 && z10) ? Math.abs(j12 - j11) <= Math.abs(j13 - j11) ? j12 : j13 : z11 ? j12 : z10 ? j13 : W0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c3.class != obj.getClass()) {
            return false;
        }
        c3 c3Var = (c3) obj;
        return this.f24889a == c3Var.f24889a && this.f24890b == c3Var.f24890b;
    }

    public int hashCode() {
        return (((int) this.f24889a) * 31) + ((int) this.f24890b);
    }
}
