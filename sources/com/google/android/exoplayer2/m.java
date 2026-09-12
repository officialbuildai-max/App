package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.v1;
import com.google.common.primitives.Longs;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes3.dex */
public final class m implements s1 {

    /* renamed from: a, reason: collision with root package name */
    private final float f25315a;

    /* renamed from: b, reason: collision with root package name */
    private final float f25316b;

    /* renamed from: c, reason: collision with root package name */
    private final long f25317c;

    /* renamed from: d, reason: collision with root package name */
    private final float f25318d;

    /* renamed from: e, reason: collision with root package name */
    private final long f25319e;

    /* renamed from: f, reason: collision with root package name */
    private final long f25320f;

    /* renamed from: g, reason: collision with root package name */
    private final float f25321g;

    /* renamed from: h, reason: collision with root package name */
    private long f25322h;

    /* renamed from: i, reason: collision with root package name */
    private long f25323i;

    /* renamed from: j, reason: collision with root package name */
    private long f25324j;

    /* renamed from: k, reason: collision with root package name */
    private long f25325k;

    /* renamed from: l, reason: collision with root package name */
    private long f25326l;

    /* renamed from: m, reason: collision with root package name */
    private long f25327m;

    /* renamed from: n, reason: collision with root package name */
    private float f25328n;

    /* renamed from: o, reason: collision with root package name */
    private float f25329o;

    /* renamed from: p, reason: collision with root package name */
    private float f25330p;

    /* renamed from: q, reason: collision with root package name */
    private long f25331q;

    /* renamed from: r, reason: collision with root package name */
    private long f25332r;

    /* renamed from: s, reason: collision with root package name */
    private long f25333s;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private float f25334a = 0.97f;

        /* renamed from: b, reason: collision with root package name */
        private float f25335b = 1.03f;

        /* renamed from: c, reason: collision with root package name */
        private long f25336c = 1000;

        /* renamed from: d, reason: collision with root package name */
        private float f25337d = 1.0E-7f;

        /* renamed from: e, reason: collision with root package name */
        private long f25338e = com.google.android.exoplayer2.util.p0.B0(20);

        /* renamed from: f, reason: collision with root package name */
        private long f25339f = com.google.android.exoplayer2.util.p0.B0(500);

        /* renamed from: g, reason: collision with root package name */
        private float f25340g = 0.999f;

        public m a() {
            return new m(this.f25334a, this.f25335b, this.f25336c, this.f25337d, this.f25338e, this.f25339f, this.f25340g);
        }
    }

    private m(float f11, float f12, long j11, float f13, long j12, long j13, float f14) {
        this.f25315a = f11;
        this.f25316b = f12;
        this.f25317c = j11;
        this.f25318d = f13;
        this.f25319e = j12;
        this.f25320f = j13;
        this.f25321g = f14;
        this.f25322h = C.TIME_UNSET;
        this.f25323i = C.TIME_UNSET;
        this.f25325k = C.TIME_UNSET;
        this.f25326l = C.TIME_UNSET;
        this.f25329o = f11;
        this.f25328n = f12;
        this.f25330p = 1.0f;
        this.f25331q = C.TIME_UNSET;
        this.f25324j = C.TIME_UNSET;
        this.f25327m = C.TIME_UNSET;
        this.f25332r = C.TIME_UNSET;
        this.f25333s = C.TIME_UNSET;
    }

    private void f(long j11) {
        long j12 = this.f25332r + (this.f25333s * 3);
        if (this.f25327m > j12) {
            float B0 = (float) com.google.android.exoplayer2.util.p0.B0(this.f25317c);
            this.f25327m = Longs.h(j12, this.f25324j, this.f25327m - (((this.f25330p - 1.0f) * B0) + ((this.f25328n - 1.0f) * B0)));
            return;
        }
        long r11 = com.google.android.exoplayer2.util.p0.r(j11 - (Math.max(0.0f, this.f25330p - 1.0f) / this.f25318d), this.f25327m, j12);
        this.f25327m = r11;
        long j13 = this.f25326l;
        if (j13 == C.TIME_UNSET || r11 <= j13) {
            return;
        }
        this.f25327m = j13;
    }

    private void g() {
        long j11 = this.f25322h;
        if (j11 != C.TIME_UNSET) {
            long j12 = this.f25323i;
            if (j12 != C.TIME_UNSET) {
                j11 = j12;
            }
            long j13 = this.f25325k;
            if (j13 != C.TIME_UNSET && j11 < j13) {
                j11 = j13;
            }
            long j14 = this.f25326l;
            if (j14 != C.TIME_UNSET && j11 > j14) {
                j11 = j14;
            }
        } else {
            j11 = -9223372036854775807L;
        }
        if (this.f25324j == j11) {
            return;
        }
        this.f25324j = j11;
        this.f25327m = j11;
        this.f25332r = C.TIME_UNSET;
        this.f25333s = C.TIME_UNSET;
        this.f25331q = C.TIME_UNSET;
    }

    private static long h(long j11, long j12, float f11) {
        return (((float) j11) * f11) + ((1.0f - f11) * ((float) j12));
    }

    private void i(long j11, long j12) {
        long j13 = j11 - j12;
        long j14 = this.f25332r;
        if (j14 == C.TIME_UNSET) {
            this.f25332r = j13;
            this.f25333s = 0L;
        } else {
            long max = Math.max(j13, h(j14, j13, this.f25321g));
            this.f25332r = max;
            this.f25333s = h(this.f25333s, Math.abs(j13 - max), this.f25321g);
        }
    }

    @Override // com.google.android.exoplayer2.s1
    public float a(long j11, long j12) {
        if (this.f25322h == C.TIME_UNSET) {
            return 1.0f;
        }
        i(j11, j12);
        if (this.f25331q != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.f25331q < this.f25317c) {
            return this.f25330p;
        }
        this.f25331q = SystemClock.elapsedRealtime();
        f(j11);
        long j13 = j11 - this.f25327m;
        if (Math.abs(j13) < this.f25319e) {
            this.f25330p = 1.0f;
        } else {
            this.f25330p = com.google.android.exoplayer2.util.p0.p((this.f25318d * ((float) j13)) + 1.0f, this.f25329o, this.f25328n);
        }
        return this.f25330p;
    }

    @Override // com.google.android.exoplayer2.s1
    public long b() {
        return this.f25327m;
    }

    @Override // com.google.android.exoplayer2.s1
    public void c() {
        long j11 = this.f25327m;
        if (j11 == C.TIME_UNSET) {
            return;
        }
        long j12 = j11 + this.f25320f;
        this.f25327m = j12;
        long j13 = this.f25326l;
        if (j13 != C.TIME_UNSET && j12 > j13) {
            this.f25327m = j13;
        }
        this.f25331q = C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.s1
    public void d(long j11) {
        this.f25323i = j11;
        g();
    }

    @Override // com.google.android.exoplayer2.s1
    public void e(v1.g gVar) {
        this.f25322h = com.google.android.exoplayer2.util.p0.B0(gVar.f27816a);
        this.f25325k = com.google.android.exoplayer2.util.p0.B0(gVar.f27817b);
        this.f25326l = com.google.android.exoplayer2.util.p0.B0(gVar.f27818c);
        float f11 = gVar.f27819d;
        if (f11 == -3.4028235E38f) {
            f11 = this.f25315a;
        }
        this.f25329o = f11;
        float f12 = gVar.f27820e;
        if (f12 == -3.4028235E38f) {
            f12 = this.f25316b;
        }
        this.f25328n = f12;
        if (f11 == 1.0f && f12 == 1.0f) {
            this.f25322h = C.TIME_UNSET;
        }
        g();
    }
}
