package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private double f2568a;

    /* renamed from: b, reason: collision with root package name */
    private double f2569b;

    public s(double d11, double d12) {
        this.f2568a = d11;
        this.f2569b = d12;
    }

    public final double e() {
        return this.f2569b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Double.compare(this.f2568a, sVar.f2568a) == 0 && Double.compare(this.f2569b, sVar.f2569b) == 0;
    }

    public final double f() {
        return this.f2568a;
    }

    public int hashCode() {
        return (r.a(this.f2568a) * 31) + r.a(this.f2569b);
    }

    public String toString() {
        return "ComplexDouble(_real=" + this.f2568a + ", _imaginary=" + this.f2569b + ')';
    }
}
