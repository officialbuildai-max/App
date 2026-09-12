package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;

/* loaded from: classes.dex */
final class o implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f2946a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2947b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2948c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2949d;

    public o(int i11, int i12, int i13, int i14) {
        this.f2946a = i11;
        this.f2947b = i12;
        this.f2948c = i13;
        this.f2949d = i14;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(o0.e eVar) {
        return this.f2947b;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(o0.e eVar) {
        return this.f2949d;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(o0.e eVar, LayoutDirection layoutDirection) {
        return this.f2946a;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(o0.e eVar, LayoutDirection layoutDirection) {
        return this.f2948c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f2946a == oVar.f2946a && this.f2947b == oVar.f2947b && this.f2948c == oVar.f2948c && this.f2949d == oVar.f2949d;
    }

    public int hashCode() {
        return (((((this.f2946a * 31) + this.f2947b) * 31) + this.f2948c) * 31) + this.f2949d;
    }

    public String toString() {
        return "Insets(left=" + this.f2946a + ", top=" + this.f2947b + ", right=" + this.f2948c + ", bottom=" + this.f2949d + ')';
    }
}
