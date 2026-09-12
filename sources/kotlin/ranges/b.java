package kotlin.ranges;

/* loaded from: classes7.dex */
final class b implements ClosedFloatingPointRange {

    /* renamed from: a, reason: collision with root package name */
    private final float f67493a;

    /* renamed from: b, reason: collision with root package name */
    private final float f67494b;

    public b(float f11, float f12) {
        this.f67493a = f11;
        this.f67494b = f12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    public boolean b(float f11) {
        return f11 >= this.f67493a && f11 <= this.f67494b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean c(Comparable comparable, Comparable comparable2) {
        return g(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float e() {
        return Float.valueOf(this.f67494b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.f67493a != bVar.f67493a || this.f67494b != bVar.f67494b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float j() {
        return Float.valueOf(this.f67493a);
    }

    public boolean g(float f11, float f12) {
        return f11 <= f12;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f67493a) * 31) + Float.floatToIntBits(this.f67494b);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public boolean isEmpty() {
        return this.f67493a > this.f67494b;
    }

    public String toString() {
        return this.f67493a + ".." + this.f67494b;
    }
}
