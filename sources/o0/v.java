package o0;

/* loaded from: classes2.dex */
final class v implements p0.a {

    /* renamed from: a, reason: collision with root package name */
    private final float f70750a;

    public v(float f11) {
        this.f70750a = f11;
    }

    @Override // p0.a
    public float a(float f11) {
        return f11 / this.f70750a;
    }

    @Override // p0.a
    public float b(float f11) {
        return f11 * this.f70750a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && Float.compare(this.f70750a, ((v) obj).f70750a) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f70750a);
    }

    public String toString() {
        return "LinearFontScaleConverter(fontScale=" + this.f70750a + ')';
    }
}
