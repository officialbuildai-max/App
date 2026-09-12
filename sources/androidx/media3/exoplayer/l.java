package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.common.t;
import com.google.common.primitives.Longs;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public final class l implements t2 {

    /* renamed from: a, reason: collision with root package name */
    private final float f12152a;

    /* renamed from: b, reason: collision with root package name */
    private final float f12153b;

    /* renamed from: c, reason: collision with root package name */
    private final long f12154c;

    /* renamed from: d, reason: collision with root package name */
    private final float f12155d;

    /* renamed from: e, reason: collision with root package name */
    private final long f12156e;

    /* renamed from: f, reason: collision with root package name */
    private final long f12157f;

    /* renamed from: g, reason: collision with root package name */
    private final float f12158g;

    /* renamed from: h, reason: collision with root package name */
    private long f12159h;

    /* renamed from: i, reason: collision with root package name */
    private long f12160i;

    /* renamed from: j, reason: collision with root package name */
    private long f12161j;

    /* renamed from: k, reason: collision with root package name */
    private long f12162k;

    /* renamed from: l, reason: collision with root package name */
    private long f12163l;

    /* renamed from: m, reason: collision with root package name */
    private long f12164m;

    /* renamed from: n, reason: collision with root package name */
    private float f12165n;

    /* renamed from: o, reason: collision with root package name */
    private float f12166o;

    /* renamed from: p, reason: collision with root package name */
    private float f12167p;

    /* renamed from: q, reason: collision with root package name */
    private long f12168q;

    /* renamed from: r, reason: collision with root package name */
    private long f12169r;

    /* renamed from: s, reason: collision with root package name */
    private long f12170s;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private float f12171a = 0.97f;

        /* renamed from: b, reason: collision with root package name */
        private float f12172b = 1.03f;

        /* renamed from: c, reason: collision with root package name */
        private long f12173c = 1000;

        /* renamed from: d, reason: collision with root package name */
        private float f12174d = 1.0E-7f;

        /* renamed from: e, reason: collision with root package name */
        private long f12175e = androidx.media3.common.util.a1.R0(20);

        /* renamed from: f, reason: collision with root package name */
        private long f12176f = androidx.media3.common.util.a1.R0(500);

        /* renamed from: g, reason: collision with root package name */
        private float f12177g = 0.999f;

        public l a() {
            return new l(this.f12171a, this.f12172b, this.f12173c, this.f12174d, this.f12175e, this.f12176f, this.f12177g);
        }
    }

    private l(float f11, float f12, long j11, float f13, long j12, long j13, float f14) {
        this.f12152a = f11;
        this.f12153b = f12;
        this.f12154c = j11;
        this.f12155d = f13;
        this.f12156e = j12;
        this.f12157f = j13;
        this.f12158g = f14;
        this.f12159h = C.TIME_UNSET;
        this.f12160i = C.TIME_UNSET;
        this.f12162k = C.TIME_UNSET;
        this.f12163l = C.TIME_UNSET;
        this.f12166o = f11;
        this.f12165n = f12;
        this.f12167p = 1.0f;
        this.f12168q = C.TIME_UNSET;
        this.f12161j = C.TIME_UNSET;
        this.f12164m = C.TIME_UNSET;
        this.f12169r = C.TIME_UNSET;
        this.f12170s = C.TIME_UNSET;
    }

    private void f(long j11) {
        long j12 = this.f12169r + (this.f12170s * 3);
        if (this.f12164m > j12) {
            float R0 = (float) androidx.media3.common.util.a1.R0(this.f12154c);
            this.f12164m = Longs.h(j12, this.f12161j, this.f12164m - (((this.f12167p - 1.0f) * R0) + ((this.f12165n - 1.0f) * R0)));
            return;
        }
        long q11 = androidx.media3.common.util.a1.q(j11 - (Math.max(0.0f, this.f12167p - 1.0f) / this.f12155d), this.f12164m, j12);
        this.f12164m = q11;
        long j13 = this.f12163l;
        if (j13 == C.TIME_UNSET || q11 <= j13) {
            return;
        }
        this.f12164m = j13;
    }

    private void g() {
        long j11;
        long j12 = this.f12159h;
        if (j12 != C.TIME_UNSET) {
            j11 = this.f12160i;
            if (j11 == C.TIME_UNSET) {
                long j13 = this.f12162k;
                if (j13 != C.TIME_UNSET && j12 < j13) {
                    j12 = j13;
                }
                j11 = this.f12163l;
                if (j11 == C.TIME_UNSET || j12 <= j11) {
                    j11 = j12;
                }
            }
        } else {
            j11 = -9223372036854775807L;
        }
        if (this.f12161j == j11) {
            return;
        }
        this.f12161j = j11;
        this.f12164m = j11;
        this.f12169r = C.TIME_UNSET;
        this.f12170s = C.TIME_UNSET;
        this.f12168q = C.TIME_UNSET;
    }

    private static long h(long j11, long j12, float f11) {
        return (((float) j11) * f11) + ((1.0f - f11) * ((float) j12));
    }

    private void i(long j11, long j12) {
        long j13 = j11 - j12;
        long j14 = this.f12169r;
        if (j14 == C.TIME_UNSET) {
            this.f12169r = j13;
            this.f12170s = 0L;
        } else {
            long max = Math.max(j13, h(j14, j13, this.f12158g));
            this.f12169r = max;
            this.f12170s = h(this.f12170s, Math.abs(j13 - max), this.f12158g);
        }
    }

    @Override // androidx.media3.exoplayer.t2
    public float a(long j11, long j12) {
        if (this.f12159h == C.TIME_UNSET) {
            return 1.0f;
        }
        i(j11, j12);
        if (this.f12168q != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.f12168q < this.f12154c) {
            return this.f12167p;
        }
        this.f12168q = SystemClock.elapsedRealtime();
        f(j11);
        long j13 = j11 - this.f12164m;
        if (Math.abs(j13) < this.f12156e) {
            this.f12167p = 1.0f;
        } else {
            this.f12167p = androidx.media3.common.util.a1.o((this.f12155d * ((float) j13)) + 1.0f, this.f12166o, this.f12165n);
        }
        return this.f12167p;
    }

    @Override // androidx.media3.exoplayer.t2
    public long b() {
        return this.f12164m;
    }

    @Override // androidx.media3.exoplayer.t2
    public void c() {
        long j11 = this.f12164m;
        if (j11 == C.TIME_UNSET) {
            return;
        }
        long j12 = j11 + this.f12157f;
        this.f12164m = j12;
        long j13 = this.f12163l;
        if (j13 != C.TIME_UNSET && j12 > j13) {
            this.f12164m = j13;
        }
        this.f12168q = C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.t2
    public void d(long j11) {
        this.f12160i = j11;
        g();
    }

    @Override // androidx.media3.exoplayer.t2
    public void e(t.g gVar) {
        this.f12159h = androidx.media3.common.util.a1.R0(gVar.f10367a);
        this.f12162k = androidx.media3.common.util.a1.R0(gVar.f10368b);
        this.f12163l = androidx.media3.common.util.a1.R0(gVar.f10369c);
        float f11 = gVar.f10370d;
        if (f11 == -3.4028235E38f) {
            f11 = this.f12152a;
        }
        this.f12166o = f11;
        float f12 = gVar.f10371e;
        if (f12 == -3.4028235E38f) {
            f12 = this.f12153b;
        }
        this.f12165n = f12;
        if (f11 == 1.0f && f12 == 1.0f) {
            this.f12159h = C.TIME_UNSET;
        }
        g();
    }
}
