package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class m implements l {

    /* renamed from: a, reason: collision with root package name */
    private float f6889a;

    /* renamed from: b, reason: collision with root package name */
    private float f6890b;

    /* renamed from: c, reason: collision with root package name */
    private float f6891c;

    /* renamed from: d, reason: collision with root package name */
    private float f6892d;

    /* renamed from: e, reason: collision with root package name */
    private float f6893e;

    /* renamed from: f, reason: collision with root package name */
    private float f6894f;

    /* renamed from: g, reason: collision with root package name */
    private float f6895g;

    /* renamed from: h, reason: collision with root package name */
    private float f6896h;

    /* renamed from: i, reason: collision with root package name */
    private float f6897i;

    /* renamed from: j, reason: collision with root package name */
    private int f6898j;

    /* renamed from: k, reason: collision with root package name */
    private String f6899k;

    /* renamed from: m, reason: collision with root package name */
    private float f6901m;

    /* renamed from: n, reason: collision with root package name */
    private float f6902n;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6900l = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6903o = false;

    private float b(float f11) {
        this.f6903o = false;
        float f12 = this.f6892d;
        if (f11 <= f12) {
            float f13 = this.f6889a;
            return (f13 * f11) + ((((this.f6890b - f13) * f11) * f11) / (f12 * 2.0f));
        }
        int i11 = this.f6898j;
        if (i11 == 1) {
            return this.f6895g;
        }
        float f14 = f11 - f12;
        float f15 = this.f6893e;
        if (f14 < f15) {
            float f16 = this.f6895g;
            float f17 = this.f6890b;
            return f16 + (f17 * f14) + ((((this.f6891c - f17) * f14) * f14) / (f15 * 2.0f));
        }
        if (i11 == 2) {
            return this.f6896h;
        }
        float f18 = f14 - f15;
        float f19 = this.f6894f;
        if (f18 > f19) {
            this.f6903o = true;
            return this.f6897i;
        }
        float f20 = this.f6896h;
        float f21 = this.f6891c;
        return (f20 + (f21 * f18)) - (((f21 * f18) * f18) / (f19 * 2.0f));
    }

    private void e(float f11, float f12, float f13, float f14, float f15) {
        this.f6903o = false;
        if (f11 == 0.0f) {
            f11 = 1.0E-4f;
        }
        this.f6889a = f11;
        float f16 = f11 / f13;
        float f17 = (f16 * f11) / 2.0f;
        if (f11 < 0.0f) {
            float sqrt = (float) Math.sqrt((f12 - ((((-f11) / f13) * f11) / 2.0f)) * f13);
            if (sqrt < f14) {
                this.f6899k = "backward accelerate, decelerate";
                this.f6898j = 2;
                this.f6889a = f11;
                this.f6890b = sqrt;
                this.f6891c = 0.0f;
                float f18 = (sqrt - f11) / f13;
                this.f6892d = f18;
                this.f6893e = sqrt / f13;
                this.f6895g = ((f11 + sqrt) * f18) / 2.0f;
                this.f6896h = f12;
                this.f6897i = f12;
                return;
            }
            this.f6899k = "backward accelerate cruse decelerate";
            this.f6898j = 3;
            this.f6889a = f11;
            this.f6890b = f14;
            this.f6891c = f14;
            float f19 = (f14 - f11) / f13;
            this.f6892d = f19;
            float f20 = f14 / f13;
            this.f6894f = f20;
            float f21 = ((f11 + f14) * f19) / 2.0f;
            float f22 = (f20 * f14) / 2.0f;
            this.f6893e = ((f12 - f21) - f22) / f14;
            this.f6895g = f21;
            this.f6896h = f12 - f22;
            this.f6897i = f12;
            return;
        }
        if (f17 >= f12) {
            this.f6899k = "hard stop";
            this.f6898j = 1;
            this.f6889a = f11;
            this.f6890b = 0.0f;
            this.f6895g = f12;
            this.f6892d = (2.0f * f12) / f11;
            return;
        }
        float f23 = f12 - f17;
        float f24 = f23 / f11;
        if (f24 + f16 < f15) {
            this.f6899k = "cruse decelerate";
            this.f6898j = 2;
            this.f6889a = f11;
            this.f6890b = f11;
            this.f6891c = 0.0f;
            this.f6895g = f23;
            this.f6896h = f12;
            this.f6892d = f24;
            this.f6893e = f16;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f13 * f12) + ((f11 * f11) / 2.0f));
        float f25 = (sqrt2 - f11) / f13;
        this.f6892d = f25;
        float f26 = sqrt2 / f13;
        this.f6893e = f26;
        if (sqrt2 < f14) {
            this.f6899k = "accelerate decelerate";
            this.f6898j = 2;
            this.f6889a = f11;
            this.f6890b = sqrt2;
            this.f6891c = 0.0f;
            this.f6892d = f25;
            this.f6893e = f26;
            this.f6895g = ((f11 + sqrt2) * f25) / 2.0f;
            this.f6896h = f12;
            return;
        }
        this.f6899k = "accelerate cruse decelerate";
        this.f6898j = 3;
        this.f6889a = f11;
        this.f6890b = f14;
        this.f6891c = f14;
        float f27 = (f14 - f11) / f13;
        this.f6892d = f27;
        float f28 = f14 / f13;
        this.f6894f = f28;
        float f29 = ((f11 + f14) * f27) / 2.0f;
        float f30 = (f28 * f14) / 2.0f;
        this.f6893e = ((f12 - f29) - f30) / f14;
        this.f6895g = f29;
        this.f6896h = f12 - f30;
        this.f6897i = f12;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float a() {
        return this.f6900l ? -d(this.f6902n) : d(this.f6902n);
    }

    public void c(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f6903o = false;
        this.f6901m = f11;
        boolean z10 = f11 > f12;
        this.f6900l = z10;
        if (z10) {
            e(-f13, f11 - f12, f15, f16, f14);
        } else {
            e(f13, f12 - f11, f15, f16, f14);
        }
    }

    public float d(float f11) {
        float f12 = this.f6892d;
        if (f11 <= f12) {
            float f13 = this.f6889a;
            return f13 + (((this.f6890b - f13) * f11) / f12);
        }
        int i11 = this.f6898j;
        if (i11 == 1) {
            return 0.0f;
        }
        float f14 = f11 - f12;
        float f15 = this.f6893e;
        if (f14 < f15) {
            float f16 = this.f6890b;
            return f16 + (((this.f6891c - f16) * f14) / f15);
        }
        if (i11 == 2) {
            return this.f6896h;
        }
        float f17 = f14 - f15;
        float f18 = this.f6894f;
        if (f17 >= f18) {
            return this.f6897i;
        }
        float f19 = this.f6891c;
        return f19 - ((f17 * f19) / f18);
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float getInterpolation(float f11) {
        float b11 = b(f11);
        this.f6902n = f11;
        return this.f6900l ? this.f6901m - b11 : this.f6901m + b11;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public boolean isStopped() {
        return a() < 1.0E-5f && Math.abs(this.f6897i - this.f6902n) < 1.0E-5f;
    }
}
