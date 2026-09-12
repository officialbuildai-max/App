package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    private float f2540a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2542c;

    /* renamed from: d, reason: collision with root package name */
    private double f2543d;

    /* renamed from: e, reason: collision with root package name */
    private double f2544e;

    /* renamed from: f, reason: collision with root package name */
    private double f2545f;

    /* renamed from: b, reason: collision with root package name */
    private double f2541b = Math.sqrt(50.0d);

    /* renamed from: g, reason: collision with root package name */
    private float f2546g = 1.0f;

    public m0(float f11) {
        this.f2540a = f11;
    }

    private final void c() {
        if (this.f2542c) {
            return;
        }
        if (this.f2540a == n0.b()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f11 = this.f2546g;
        double d11 = f11 * f11;
        if (f11 > 1.0f) {
            double d12 = this.f2541b;
            double d13 = d11 - 1;
            this.f2543d = ((-f11) * d12) + (d12 * Math.sqrt(d13));
            double d14 = -this.f2546g;
            double d15 = this.f2541b;
            this.f2544e = (d14 * d15) - (d15 * Math.sqrt(d13));
        } else if (f11 >= 0.0f && f11 < 1.0f) {
            this.f2545f = this.f2541b * Math.sqrt(1 - d11);
        }
        this.f2542c = true;
    }

    public final float a() {
        return this.f2546g;
    }

    public final float b() {
        double d11 = this.f2541b;
        return (float) (d11 * d11);
    }

    public final void d(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f2546g = f11;
        this.f2542c = false;
    }

    public final void e(float f11) {
        this.f2540a = f11;
    }

    public final void f(float f11) {
        if (b() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f2541b = Math.sqrt(f11);
        this.f2542c = false;
    }

    public final long g(float f11, float f12, long j11) {
        double cos;
        double d11;
        c();
        float f13 = f11 - this.f2540a;
        double d12 = j11 / 1000.0d;
        float f14 = this.f2546g;
        if (f14 > 1.0f) {
            double d13 = f13;
            double d14 = this.f2544e;
            double d15 = f12;
            double d16 = this.f2543d;
            double d17 = d13 - (((d14 * d13) - d15) / (d14 - d16));
            double d18 = ((d13 * d14) - d15) / (d14 - d16);
            d11 = (Math.exp(d14 * d12) * d17) + (Math.exp(this.f2543d * d12) * d18);
            double d19 = this.f2544e;
            double exp = d17 * d19 * Math.exp(d19 * d12);
            double d20 = this.f2543d;
            cos = exp + (d18 * d20 * Math.exp(d20 * d12));
        } else if (f14 == 1.0f) {
            double d21 = this.f2541b;
            double d22 = f13;
            double d23 = f12 + (d21 * d22);
            double d24 = d22 + (d23 * d12);
            double exp2 = Math.exp((-d21) * d12) * d24;
            double exp3 = d24 * Math.exp((-this.f2541b) * d12);
            double d25 = this.f2541b;
            cos = (exp3 * (-d25)) + (d23 * Math.exp((-d25) * d12));
            d11 = exp2;
        } else {
            double d26 = 1 / this.f2545f;
            double d27 = this.f2541b;
            double d28 = f13;
            double d29 = d26 * ((f14 * d27 * d28) + f12);
            double exp4 = Math.exp((-f14) * d27 * d12) * ((Math.cos(this.f2545f * d12) * d28) + (Math.sin(this.f2545f * d12) * d29));
            double d30 = this.f2541b;
            double d31 = (-d30) * exp4 * this.f2546g;
            double exp5 = Math.exp((-r5) * d30 * d12);
            double d32 = this.f2545f;
            double sin = (-d32) * d28 * Math.sin(d32 * d12);
            double d33 = this.f2545f;
            cos = d31 + (exp5 * (sin + (d29 * d33 * Math.cos(d33 * d12))));
            d11 = exp4;
        }
        return n0.a((float) (d11 + this.f2540a), (float) cos);
    }
}
