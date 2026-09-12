package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
final class n implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final h0 f2944a;

    /* renamed from: b, reason: collision with root package name */
    private final h0 f2945b;

    public n(h0 h0Var, h0 h0Var2) {
        this.f2944a = h0Var;
        this.f2945b = h0Var2;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(o0.e eVar) {
        return RangesKt.f(this.f2944a.a(eVar) - this.f2945b.a(eVar), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(o0.e eVar) {
        return RangesKt.f(this.f2944a.b(eVar) - this.f2945b.b(eVar), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(o0.e eVar, LayoutDirection layoutDirection) {
        return RangesKt.f(this.f2944a.c(eVar, layoutDirection) - this.f2945b.c(eVar, layoutDirection), 0);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(o0.e eVar, LayoutDirection layoutDirection) {
        return RangesKt.f(this.f2944a.d(eVar, layoutDirection) - this.f2945b.d(eVar, layoutDirection), 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.c(nVar.f2944a, this.f2944a) && Intrinsics.c(nVar.f2945b, this.f2945b);
    }

    public int hashCode() {
        return (this.f2944a.hashCode() * 31) + this.f2945b.hashCode();
    }

    public String toString() {
        return '(' + this.f2944a + " - " + this.f2945b + ')';
    }
}
