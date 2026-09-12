package y;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private float f78589a;

    /* renamed from: b, reason: collision with root package name */
    private float f78590b;

    /* renamed from: c, reason: collision with root package name */
    private float f78591c;

    /* renamed from: d, reason: collision with root package name */
    private float f78592d;

    public e(float f11, float f12, float f13, float f14) {
        this.f78589a = f11;
        this.f78590b = f12;
        this.f78591c = f13;
        this.f78592d = f14;
    }

    public final float a() {
        return this.f78592d;
    }

    public final float b() {
        return this.f78589a;
    }

    public final float c() {
        return this.f78591c;
    }

    public final float d() {
        return this.f78590b;
    }

    public final void e(float f11, float f12, float f13, float f14) {
        this.f78589a = Math.max(f11, this.f78589a);
        this.f78590b = Math.max(f12, this.f78590b);
        this.f78591c = Math.min(f13, this.f78591c);
        this.f78592d = Math.min(f14, this.f78592d);
    }

    public final boolean f() {
        return this.f78589a >= this.f78591c || this.f78590b >= this.f78592d;
    }

    public final void g(float f11, float f12, float f13, float f14) {
        this.f78589a = f11;
        this.f78590b = f12;
        this.f78591c = f13;
        this.f78592d = f14;
    }

    public final void h(float f11) {
        this.f78592d = f11;
    }

    public final void i(float f11) {
        this.f78589a = f11;
    }

    public final void j(float f11) {
        this.f78591c = f11;
    }

    public final void k(float f11) {
        this.f78590b = f11;
    }

    public String toString() {
        return "MutableRect(" + c.a(this.f78589a, 1) + ", " + c.a(this.f78590b, 1) + ", " + c.a(this.f78591c, 1) + ", " + c.a(this.f78592d, 1) + ')';
    }
}
