package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.b;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    double f9104a;

    /* renamed from: b, reason: collision with root package name */
    double f9105b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9106c;

    /* renamed from: d, reason: collision with root package name */
    private double f9107d;

    /* renamed from: e, reason: collision with root package name */
    private double f9108e;

    /* renamed from: f, reason: collision with root package name */
    private double f9109f;

    /* renamed from: g, reason: collision with root package name */
    private double f9110g;

    /* renamed from: h, reason: collision with root package name */
    private double f9111h;

    /* renamed from: i, reason: collision with root package name */
    private double f9112i;

    /* renamed from: j, reason: collision with root package name */
    private final b.o f9113j;

    public e() {
        this.f9104a = Math.sqrt(1500.0d);
        this.f9105b = 0.5d;
        this.f9106c = false;
        this.f9112i = Double.MAX_VALUE;
        this.f9113j = new b.o();
    }

    public e(float f11) {
        this.f9104a = Math.sqrt(1500.0d);
        this.f9105b = 0.5d;
        this.f9106c = false;
        this.f9112i = Double.MAX_VALUE;
        this.f9113j = new b.o();
        this.f9112i = f11;
    }

    private void b() {
        if (this.f9106c) {
            return;
        }
        if (this.f9112i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d11 = this.f9105b;
        if (d11 > 1.0d) {
            double d12 = this.f9104a;
            this.f9109f = ((-d11) * d12) + (d12 * Math.sqrt((d11 * d11) - 1.0d));
            double d13 = this.f9105b;
            double d14 = this.f9104a;
            this.f9110g = ((-d13) * d14) - (d14 * Math.sqrt((d13 * d13) - 1.0d));
        } else if (d11 >= 0.0d && d11 < 1.0d) {
            this.f9111h = this.f9104a * Math.sqrt(1.0d - (d11 * d11));
        }
        this.f9106c = true;
    }

    public float a() {
        return (float) this.f9112i;
    }

    public boolean c(float f11, float f12) {
        return ((double) Math.abs(f12)) < this.f9108e && ((double) Math.abs(f11 - a())) < this.f9107d;
    }

    public e d(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f9105b = f11;
        this.f9106c = false;
        return this;
    }

    public e e(float f11) {
        this.f9112i = f11;
        return this;
    }

    public e f(float f11) {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f9104a = Math.sqrt(f11);
        this.f9106c = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(double d11) {
        double abs = Math.abs(d11);
        this.f9107d = abs;
        this.f9108e = abs * 62.5d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b.o h(double d11, double d12, long j11) {
        double cos;
        double d13;
        b();
        double d14 = j11 / 1000.0d;
        double d15 = d11 - this.f9112i;
        double d16 = this.f9105b;
        if (d16 > 1.0d) {
            double d17 = this.f9110g;
            double d18 = this.f9109f;
            double d19 = d15 - (((d17 * d15) - d12) / (d17 - d18));
            double d20 = ((d15 * d17) - d12) / (d17 - d18);
            d13 = (Math.pow(2.718281828459045d, d17 * d14) * d19) + (Math.pow(2.718281828459045d, this.f9109f * d14) * d20);
            double d21 = this.f9110g;
            double pow = d19 * d21 * Math.pow(2.718281828459045d, d21 * d14);
            double d22 = this.f9109f;
            cos = pow + (d20 * d22 * Math.pow(2.718281828459045d, d22 * d14));
        } else if (d16 == 1.0d) {
            double d23 = this.f9104a;
            double d24 = d12 + (d23 * d15);
            double d25 = d15 + (d24 * d14);
            d13 = Math.pow(2.718281828459045d, (-d23) * d14) * d25;
            double pow2 = d25 * Math.pow(2.718281828459045d, (-this.f9104a) * d14);
            double d26 = this.f9104a;
            cos = (d24 * Math.pow(2.718281828459045d, (-d26) * d14)) + (pow2 * (-d26));
        } else {
            double d27 = 1.0d / this.f9111h;
            double d28 = this.f9104a;
            double d29 = d27 * ((d16 * d28 * d15) + d12);
            double pow3 = Math.pow(2.718281828459045d, (-d16) * d28 * d14) * ((Math.cos(this.f9111h * d14) * d15) + (Math.sin(this.f9111h * d14) * d29));
            double d30 = this.f9104a;
            double d31 = this.f9105b;
            double d32 = (-d30) * pow3 * d31;
            double pow4 = Math.pow(2.718281828459045d, (-d31) * d30 * d14);
            double d33 = this.f9111h;
            double sin = (-d33) * d15 * Math.sin(d33 * d14);
            double d34 = this.f9111h;
            cos = d32 + (pow4 * (sin + (d29 * d34 * Math.cos(d34 * d14))));
            d13 = pow3;
        }
        b.o oVar = this.f9113j;
        oVar.f9101a = (float) (d13 + this.f9112i);
        oVar.f9102b = (float) cos;
        return oVar;
    }
}
