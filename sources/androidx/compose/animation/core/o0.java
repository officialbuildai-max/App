package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class o0 implements g {

    /* renamed from: a, reason: collision with root package name */
    private final float f2553a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2554b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f2555c;

    public o0() {
        this(0.0f, 0.0f, null, 7, null);
    }

    public o0(float f11, float f12, Object obj) {
        this.f2553a = f11;
        this.f2554b = f12;
        this.f2555c = obj;
    }

    public /* synthetic */ o0(float f11, float f12, Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1.0f : f11, (i11 & 2) != 0 ? 1500.0f : f12, (i11 & 4) != 0 ? null : obj);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return o0Var.f2553a == this.f2553a && o0Var.f2554b == this.f2554b && Intrinsics.c(o0Var.f2555c, this.f2555c);
    }

    @Override // androidx.compose.animation.core.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e1 a(s0 s0Var) {
        o b11;
        float f11 = this.f2553a;
        float f12 = this.f2554b;
        b11 = h.b(s0Var, this.f2555c);
        return new e1(f11, f12, b11);
    }

    public int hashCode() {
        Object obj = this.f2555c;
        return ((((obj != null ? obj.hashCode() : 0) * 31) + Float.floatToIntBits(this.f2553a)) * 31) + Float.floatToIntBits(this.f2554b);
    }
}
