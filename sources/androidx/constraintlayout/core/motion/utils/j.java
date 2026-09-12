package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class j implements l {

    /* renamed from: c, reason: collision with root package name */
    private double f6879c;

    /* renamed from: d, reason: collision with root package name */
    private double f6880d;

    /* renamed from: e, reason: collision with root package name */
    private double f6881e;

    /* renamed from: f, reason: collision with root package name */
    private float f6882f;

    /* renamed from: g, reason: collision with root package name */
    private float f6883g;

    /* renamed from: h, reason: collision with root package name */
    private float f6884h;

    /* renamed from: i, reason: collision with root package name */
    private float f6885i;

    /* renamed from: j, reason: collision with root package name */
    private float f6886j;

    /* renamed from: a, reason: collision with root package name */
    double f6877a = 0.5d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6878b = false;

    /* renamed from: k, reason: collision with root package name */
    private int f6887k = 0;

    private void b(double d11) {
        double d12 = this.f6879c;
        double d13 = this.f6877a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d12 / this.f6885i) * d11) * 4.0d)) + 1.0d);
        double d14 = d11 / sqrt;
        int i11 = 0;
        while (i11 < sqrt) {
            float f11 = this.f6883g;
            double d15 = this.f6880d;
            float f12 = this.f6884h;
            double d16 = d12;
            double d17 = ((-d12) * (f11 - d15)) - (f12 * d13);
            float f13 = this.f6885i;
            double d18 = d13;
            double d19 = f12 + (((d17 / f13) * d14) / 2.0d);
            double d20 = ((((-((f11 + ((d14 * d19) / 2.0d)) - d15)) * d16) - (d19 * d18)) / f13) * d14;
            float f14 = (float) (f12 + d20);
            this.f6884h = f14;
            float f15 = (float) (f11 + ((f12 + (d20 / 2.0d)) * d14));
            this.f6883g = f15;
            int i12 = this.f6887k;
            if (i12 > 0) {
                if (f15 < 0.0f && (i12 & 1) == 1) {
                    this.f6883g = -f15;
                    this.f6884h = -f14;
                }
                float f16 = this.f6883g;
                if (f16 > 1.0f && (i12 & 2) == 2) {
                    this.f6883g = 2.0f - f16;
                    this.f6884h = -this.f6884h;
                }
            }
            i11++;
            d12 = d16;
            d13 = d18;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float a() {
        return 0.0f;
    }

    public void c(float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i11) {
        this.f6880d = f12;
        this.f6877a = f16;
        this.f6878b = false;
        this.f6883g = f11;
        this.f6881e = f13;
        this.f6879c = f15;
        this.f6885i = f14;
        this.f6886j = f17;
        this.f6887k = i11;
        this.f6882f = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float getInterpolation(float f11) {
        b(f11 - this.f6882f);
        this.f6882f = f11;
        return this.f6883g;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public boolean isStopped() {
        double d11 = this.f6883g - this.f6880d;
        double d12 = this.f6879c;
        double d13 = this.f6884h;
        return Math.sqrt((((d13 * d13) * ((double) this.f6885i)) + ((d12 * d11) * d11)) / d12) <= ((double) this.f6886j);
    }
}
