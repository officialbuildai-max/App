package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class u implements t {

    /* renamed from: a, reason: collision with root package name */
    private final float f2957a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2958b;

    /* renamed from: c, reason: collision with root package name */
    private final float f2959c;

    /* renamed from: d, reason: collision with root package name */
    private final float f2960d;

    private u(float f11, float f12, float f13, float f14) {
        this.f2957a = f11;
        this.f2958b = f12;
        this.f2959c = f13;
        this.f2960d = f14;
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Start padding must be non-negative");
        }
        if (f12 < 0.0f) {
            throw new IllegalArgumentException("Top padding must be non-negative");
        }
        if (f13 < 0.0f) {
            throw new IllegalArgumentException("End padding must be non-negative");
        }
        if (f14 < 0.0f) {
            throw new IllegalArgumentException("Bottom padding must be non-negative");
        }
    }

    public /* synthetic */ u(float f11, float f12, float f13, float f14, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14);
    }

    @Override // androidx.compose.foundation.layout.t
    public float a() {
        return this.f2960d;
    }

    @Override // androidx.compose.foundation.layout.t
    public float b(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.f2957a : this.f2959c;
    }

    @Override // androidx.compose.foundation.layout.t
    public float c(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.f2959c : this.f2957a;
    }

    @Override // androidx.compose.foundation.layout.t
    public float d() {
        return this.f2958b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return o0.i.i(this.f2957a, uVar.f2957a) && o0.i.i(this.f2958b, uVar.f2958b) && o0.i.i(this.f2959c, uVar.f2959c) && o0.i.i(this.f2960d, uVar.f2960d);
    }

    public int hashCode() {
        return (((((o0.i.j(this.f2957a) * 31) + o0.i.j(this.f2958b)) * 31) + o0.i.j(this.f2959c)) * 31) + o0.i.j(this.f2960d);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) o0.i.k(this.f2957a)) + ", top=" + ((Object) o0.i.k(this.f2958b)) + ", end=" + ((Object) o0.i.k(this.f2959c)) + ", bottom=" + ((Object) o0.i.k(this.f2960d)) + ')';
    }
}
