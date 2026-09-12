package androidx.compose.ui.graphics.colorspace;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final float f4500a;

    /* renamed from: b, reason: collision with root package name */
    private final float f4501b;

    public y(float f11, float f12) {
        this.f4500a = f11;
        this.f4501b = f12;
    }

    public y(float f11, float f12, float f13) {
        this(f11, f12, f13, f11 + f12 + f13);
    }

    private y(float f11, float f12, float f13, float f14) {
        this(f11 / f14, f12 / f14);
    }

    public final float a() {
        return this.f4500a;
    }

    public final float b() {
        return this.f4501b;
    }

    public final float[] c() {
        float f11 = this.f4500a;
        float f12 = this.f4501b;
        return new float[]{f11 / f12, 1.0f, ((1.0f - f11) - f12) / f12};
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Float.compare(this.f4500a, yVar.f4500a) == 0 && Float.compare(this.f4501b, yVar.f4501b) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f4500a) * 31) + Float.floatToIntBits(this.f4501b);
    }

    public String toString() {
        return "WhitePoint(x=" + this.f4500a + ", y=" + this.f4501b + ')';
    }
}
