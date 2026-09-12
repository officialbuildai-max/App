package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class f0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final h0 f2927a;

    /* renamed from: b, reason: collision with root package name */
    private final h0 f2928b;

    public f0(h0 h0Var, h0 h0Var2) {
        this.f2927a = h0Var;
        this.f2928b = h0Var2;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(o0.e eVar) {
        return Math.max(this.f2927a.a(eVar), this.f2928b.a(eVar));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(o0.e eVar) {
        return Math.max(this.f2927a.b(eVar), this.f2928b.b(eVar));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(o0.e eVar, LayoutDirection layoutDirection) {
        return Math.max(this.f2927a.c(eVar, layoutDirection), this.f2928b.c(eVar, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(o0.e eVar, LayoutDirection layoutDirection) {
        return Math.max(this.f2927a.d(eVar, layoutDirection), this.f2928b.d(eVar, layoutDirection));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.c(f0Var.f2927a, this.f2927a) && Intrinsics.c(f0Var.f2928b, this.f2928b);
    }

    public int hashCode() {
        return this.f2927a.hashCode() + (this.f2928b.hashCode() * 31);
    }

    public String toString() {
        return '(' + this.f2927a + " ∪ " + this.f2928b + ')';
    }
}
