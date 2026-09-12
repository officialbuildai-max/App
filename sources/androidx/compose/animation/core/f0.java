package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class f0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    private final float f2510a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2511b;

    /* renamed from: c, reason: collision with root package name */
    private final float f2512c;

    /* renamed from: d, reason: collision with root package name */
    private final m0 f2513d;

    public f0() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public f0(float f11, float f12, float f13) {
        this.f2510a = f11;
        this.f2511b = f12;
        this.f2512c = f13;
        m0 m0Var = new m0(1.0f);
        m0Var.d(f11);
        m0Var.f(f12);
        this.f2513d = m0Var;
    }

    public /* synthetic */ f0(float f11, float f12, float f13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1.0f : f11, (i11 & 2) != 0 ? 1500.0f : f12, (i11 & 4) != 0 ? 0.01f : f13);
    }

    @Override // androidx.compose.animation.core.d0, androidx.compose.animation.core.g
    public /* synthetic */ c1 a(s0 s0Var) {
        return c0.c(this, s0Var);
    }

    @Override // androidx.compose.animation.core.g
    public /* bridge */ /* synthetic */ v0 a(s0 s0Var) {
        v0 a11;
        a11 = a(s0Var);
        return a11;
    }

    @Override // androidx.compose.animation.core.d0
    public float b(float f11, float f12, float f13) {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.d0
    public float c(long j11, float f11, float f12, float f13) {
        this.f2513d.e(f12);
        return i0.b(this.f2513d.g(f11, f13, j11 / 1000000));
    }

    @Override // androidx.compose.animation.core.d0
    public float d(long j11, float f11, float f12, float f13) {
        this.f2513d.e(f12);
        return i0.c(this.f2513d.g(f11, f13, j11 / 1000000));
    }

    @Override // androidx.compose.animation.core.d0
    public long e(float f11, float f12, float f13) {
        float b11 = this.f2513d.b();
        float a11 = this.f2513d.a();
        float f14 = f11 - f12;
        float f15 = this.f2512c;
        return l0.b(b11, a11, f13 / f15, f14 / f15, 1.0f) * 1000000;
    }
}
