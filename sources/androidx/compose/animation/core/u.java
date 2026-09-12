package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class u implements z {

    /* renamed from: a, reason: collision with root package name */
    private final float f2572a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2573b;

    /* renamed from: c, reason: collision with root package name */
    private final float f2574c;

    /* renamed from: d, reason: collision with root package name */
    private final float f2575d;

    /* renamed from: e, reason: collision with root package name */
    private final float f2576e;

    /* renamed from: f, reason: collision with root package name */
    private final float f2577f;

    public u(float f11, float f12, float f13, float f14) {
        this.f2572a = f11;
        this.f2573b = f12;
        this.f2574c = f13;
        this.f2575d = f14;
        if (!((Float.isNaN(f11) || Float.isNaN(f12) || Float.isNaN(f13) || Float.isNaN(f14)) ? false : true)) {
            k0.a("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f11 + ", " + f12 + ", " + f13 + ", " + f14 + '.');
        }
        long b11 = androidx.compose.ui.graphics.b1.b(0.0f, f12, f14, 1.0f, new float[5], 0);
        this.f2576e = Float.intBitsToFloat((int) (b11 >> 32));
        this.f2577f = Float.intBitsToFloat((int) (b11 & 4294967295L));
    }

    private final void b(float f11) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f2572a + ", " + this.f2573b + ", " + this.f2574c + ", " + this.f2575d + ") has no solution at " + f11);
    }

    @Override // androidx.compose.animation.core.z
    public float a(float f11) {
        if (f11 <= 0.0f || f11 >= 1.0f) {
            return f11;
        }
        float e11 = androidx.compose.ui.graphics.b1.e(0.0f - f11, this.f2572a - f11, this.f2574c - f11, 1.0f - f11);
        if (Float.isNaN(e11)) {
            b(f11);
        }
        float c11 = androidx.compose.ui.graphics.b1.c(this.f2573b, this.f2575d, e11);
        float f12 = this.f2576e;
        float f13 = this.f2577f;
        if (c11 < f12) {
            c11 = f12;
        }
        return c11 > f13 ? f13 : c11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f2572a == uVar.f2572a && this.f2573b == uVar.f2573b && this.f2574c == uVar.f2574c && this.f2575d == uVar.f2575d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f2572a) * 31) + Float.floatToIntBits(this.f2573b)) * 31) + Float.floatToIntBits(this.f2574c)) * 31) + Float.floatToIntBits(this.f2575d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f2572a + ", b=" + this.f2573b + ", c=" + this.f2574c + ", d=" + this.f2575d + ')';
    }
}
