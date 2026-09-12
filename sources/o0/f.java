package o0;

/* loaded from: classes2.dex */
final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private final float f70721a;

    /* renamed from: b, reason: collision with root package name */
    private final float f70722b;

    public f(float f11, float f12) {
        this.f70721a = f11;
        this.f70722b = f12;
    }

    @Override // o0.n
    public float C0() {
        return this.f70722b;
    }

    @Override // o0.e
    public /* synthetic */ float E0(float f11) {
        return d.e(this, f11);
    }

    @Override // o0.n
    public /* synthetic */ long H(float f11) {
        return m.b(this, f11);
    }

    @Override // o0.n
    public /* synthetic */ float J(long j11) {
        return m.a(this, j11);
    }

    @Override // o0.e
    public /* synthetic */ long Q(float f11) {
        return d.g(this, f11);
    }

    @Override // o0.e
    public /* synthetic */ long Q0(long j11) {
        return d.f(this, j11);
    }

    @Override // o0.e
    public /* synthetic */ int c0(float f11) {
        return d.a(this, f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Float.compare(this.f70721a, fVar.f70721a) == 0 && Float.compare(this.f70722b, fVar.f70722b) == 0;
    }

    @Override // o0.e
    public float getDensity() {
        return this.f70721a;
    }

    @Override // o0.e
    public /* synthetic */ float h0(long j11) {
        return d.d(this, j11);
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f70721a) * 31) + Float.floatToIntBits(this.f70722b);
    }

    public String toString() {
        return "DensityImpl(density=" + this.f70721a + ", fontScale=" + this.f70722b + ')';
    }

    @Override // o0.e
    public /* synthetic */ float x0(int i11) {
        return d.c(this, i11);
    }

    @Override // o0.e
    public /* synthetic */ float y0(float f11) {
        return d.b(this, f11);
    }
}
