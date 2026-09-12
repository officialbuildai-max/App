package w4;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private float f77712a;

    /* renamed from: b, reason: collision with root package name */
    private float f77713b;

    public d() {
        this(1.0f, 1.0f);
    }

    public d(float f11, float f12) {
        this.f77712a = f11;
        this.f77713b = f12;
    }

    public boolean a(float f11, float f12) {
        return this.f77712a == f11 && this.f77713b == f12;
    }

    public float b() {
        return this.f77712a;
    }

    public float c() {
        return this.f77713b;
    }

    public void d(float f11, float f12) {
        this.f77712a = f11;
        this.f77713b = f12;
    }

    public String toString() {
        return b() + "x" + c();
    }
}
