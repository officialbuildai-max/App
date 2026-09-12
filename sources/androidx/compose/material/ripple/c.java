package androidx.compose.material.ripple;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final float f3570a;

    /* renamed from: b, reason: collision with root package name */
    private final float f3571b;

    /* renamed from: c, reason: collision with root package name */
    private final float f3572c;

    /* renamed from: d, reason: collision with root package name */
    private final float f3573d;

    public c(float f11, float f12, float f13, float f14) {
        this.f3570a = f11;
        this.f3571b = f12;
        this.f3572c = f13;
        this.f3573d = f14;
    }

    public final float a() {
        return this.f3570a;
    }

    public final float b() {
        return this.f3571b;
    }

    public final float c() {
        return this.f3572c;
    }

    public final float d() {
        return this.f3573d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3570a == cVar.f3570a && this.f3571b == cVar.f3571b && this.f3572c == cVar.f3572c && this.f3573d == cVar.f3573d;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f3570a) * 31) + Float.floatToIntBits(this.f3571b)) * 31) + Float.floatToIntBits(this.f3572c)) * 31) + Float.floatToIntBits(this.f3573d);
    }

    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.f3570a + ", focusedAlpha=" + this.f3571b + ", hoveredAlpha=" + this.f3572c + ", pressedAlpha=" + this.f3573d + ')';
    }
}
