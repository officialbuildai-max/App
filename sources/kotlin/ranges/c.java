package kotlin.ranges;

/* loaded from: classes7.dex */
final class c implements OpenEndRange {

    /* renamed from: a, reason: collision with root package name */
    private final float f67495a;

    /* renamed from: b, reason: collision with root package name */
    private final float f67496b;

    public c(float f11, float f12) {
        this.f67495a = f11;
        this.f67496b = f12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    public boolean b(float f11) {
        return f11 >= this.f67495a && f11 < this.f67496b;
    }

    public boolean c() {
        return this.f67495a >= this.f67496b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!c() || !((c) obj).c()) {
                c cVar = (c) obj;
                if (this.f67495a != cVar.f67495a || this.f67496b != cVar.f67496b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f67495a) * 31) + Float.floatToIntBits(this.f67496b);
    }

    public String toString() {
        return this.f67495a + "..<" + this.f67496b;
    }
}
