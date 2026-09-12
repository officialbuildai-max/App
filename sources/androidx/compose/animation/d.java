package androidx.compose.animation;

import androidx.collection.s;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final float f2590a;

    /* renamed from: b, reason: collision with root package name */
    private final o0.e f2591b;

    /* renamed from: c, reason: collision with root package name */
    private final float f2592c;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final float f2593a;

        /* renamed from: b, reason: collision with root package name */
        private final float f2594b;

        /* renamed from: c, reason: collision with root package name */
        private final long f2595c;

        public a(float f11, float f12, long j11) {
            this.f2593a = f11;
            this.f2594b = f12;
            this.f2595c = j11;
        }

        public final float a(long j11) {
            long j12 = this.f2595c;
            return this.f2594b * Math.signum(this.f2593a) * androidx.compose.animation.a.f2443a.b(j12 > 0 ? ((float) j11) / ((float) j12) : 1.0f).a();
        }

        public final float b(long j11) {
            long j12 = this.f2595c;
            return (((androidx.compose.animation.a.f2443a.b(j12 > 0 ? ((float) j11) / ((float) j12) : 1.0f).b() * Math.signum(this.f2593a)) * this.f2594b) / ((float) this.f2595c)) * 1000.0f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.f2593a, aVar.f2593a) == 0 && Float.compare(this.f2594b, aVar.f2594b) == 0 && this.f2595c == aVar.f2595c;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.f2593a) * 31) + Float.floatToIntBits(this.f2594b)) * 31) + s.a(this.f2595c);
        }

        public String toString() {
            return "FlingInfo(initialVelocity=" + this.f2593a + ", distance=" + this.f2594b + ", duration=" + this.f2595c + ')';
        }
    }

    public d(float f11, o0.e eVar) {
        this.f2590a = f11;
        this.f2591b = eVar;
        this.f2592c = a(eVar);
    }

    private final float a(o0.e eVar) {
        float c11;
        c11 = e.c(0.84f, eVar.getDensity());
        return c11;
    }

    private final double e(float f11) {
        return androidx.compose.animation.a.f2443a.a(f11, this.f2590a * this.f2592c);
    }

    public final float b(float f11) {
        float f12;
        float f13;
        double e11 = e(f11);
        f12 = e.f2596a;
        double d11 = f12 - 1.0d;
        double d12 = this.f2590a * this.f2592c;
        f13 = e.f2596a;
        return (float) (d12 * Math.exp((f13 / d11) * e11));
    }

    public final long c(float f11) {
        float f12;
        double e11 = e(f11);
        f12 = e.f2596a;
        return (long) (Math.exp(e11 / (f12 - 1.0d)) * 1000.0d);
    }

    public final a d(float f11) {
        float f12;
        float f13;
        double e11 = e(f11);
        f12 = e.f2596a;
        double d11 = f12 - 1.0d;
        double d12 = this.f2590a * this.f2592c;
        f13 = e.f2596a;
        return new a(f11, (float) (d12 * Math.exp((f13 / d11) * e11)), (long) (Math.exp(e11 / d11) * 1000.0d));
    }
}
