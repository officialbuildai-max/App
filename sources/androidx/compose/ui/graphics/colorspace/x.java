package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final double f4493a;

    /* renamed from: b, reason: collision with root package name */
    private final double f4494b;

    /* renamed from: c, reason: collision with root package name */
    private final double f4495c;

    /* renamed from: d, reason: collision with root package name */
    private final double f4496d;

    /* renamed from: e, reason: collision with root package name */
    private final double f4497e;

    /* renamed from: f, reason: collision with root package name */
    private final double f4498f;

    /* renamed from: g, reason: collision with root package name */
    private final double f4499g;

    public x(double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        this.f4493a = d11;
        this.f4494b = d12;
        this.f4495c = d13;
        this.f4496d = d14;
        this.f4497e = d15;
        this.f4498f = d16;
        this.f4499g = d17;
        if (Double.isNaN(d12) || Double.isNaN(d13) || Double.isNaN(d14) || Double.isNaN(d15) || Double.isNaN(d16) || Double.isNaN(d17) || Double.isNaN(d11)) {
            throw new IllegalArgumentException("Parameters cannot be NaN");
        }
        if (d15 < 0.0d || d15 > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d15);
        }
        if (d15 == 0.0d && (d12 == 0.0d || d11 == 0.0d)) {
            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
        }
        if (d15 >= 1.0d && d14 == 0.0d) {
            throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
        }
        if ((d12 == 0.0d || d11 == 0.0d) && d14 == 0.0d) {
            throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
        }
        if (d14 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be increasing");
        }
        if (d12 < 0.0d || d11 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be positive or increasing");
        }
    }

    public /* synthetic */ x(double d11, double d12, double d13, double d14, double d15, double d16, double d17, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(d11, d12, d13, d14, d15, (i11 & 32) != 0 ? 0.0d : d16, (i11 & 64) != 0 ? 0.0d : d17);
    }

    public final double a() {
        return this.f4494b;
    }

    public final double b() {
        return this.f4495c;
    }

    public final double c() {
        return this.f4496d;
    }

    public final double d() {
        return this.f4497e;
    }

    public final double e() {
        return this.f4498f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Double.compare(this.f4493a, xVar.f4493a) == 0 && Double.compare(this.f4494b, xVar.f4494b) == 0 && Double.compare(this.f4495c, xVar.f4495c) == 0 && Double.compare(this.f4496d, xVar.f4496d) == 0 && Double.compare(this.f4497e, xVar.f4497e) == 0 && Double.compare(this.f4498f, xVar.f4498f) == 0 && Double.compare(this.f4499g, xVar.f4499g) == 0;
    }

    public final double f() {
        return this.f4499g;
    }

    public final double g() {
        return this.f4493a;
    }

    public int hashCode() {
        return (((((((((((androidx.compose.animation.core.r.a(this.f4493a) * 31) + androidx.compose.animation.core.r.a(this.f4494b)) * 31) + androidx.compose.animation.core.r.a(this.f4495c)) * 31) + androidx.compose.animation.core.r.a(this.f4496d)) * 31) + androidx.compose.animation.core.r.a(this.f4497e)) * 31) + androidx.compose.animation.core.r.a(this.f4498f)) * 31) + androidx.compose.animation.core.r.a(this.f4499g);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.f4493a + ", a=" + this.f4494b + ", b=" + this.f4495c + ", c=" + this.f4496d + ", d=" + this.f4497e + ", e=" + this.f4498f + ", f=" + this.f4499g + ')';
    }
}
