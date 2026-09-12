package androidx.compose.material.ripple;

import androidx.compose.foundation.x;
import androidx.compose.foundation.y;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.u1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class Ripple implements x {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3517a;

    /* renamed from: b, reason: collision with root package name */
    private final float f3518b;

    /* renamed from: c, reason: collision with root package name */
    private final a3 f3519c;

    private Ripple(boolean z10, float f11, a3 a3Var) {
        this.f3517a = z10;
        this.f3518b = f11;
        this.f3519c = a3Var;
    }

    public /* synthetic */ Ripple(boolean z10, float f11, a3 a3Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, f11, a3Var);
    }

    @Override // androidx.compose.foundation.x
    public final y a(p.g gVar, androidx.compose.runtime.i iVar, int i11) {
        long a11;
        iVar.P(988743187);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(988743187, i11, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:196)");
        }
        i iVar2 = (i) iVar.l(RippleThemeKt.d());
        if (((u1) this.f3519c.getValue()).u() != 16) {
            iVar.P(-303571590);
            iVar.K();
            a11 = ((u1) this.f3519c.getValue()).u();
        } else {
            iVar.P(-303521246);
            a11 = iVar2.a(iVar, 0);
            iVar.K();
        }
        a3 i12 = r2.i(u1.g(a11), iVar, 0);
        a3 i13 = r2.i(iVar2.b(iVar, 0), iVar, 0);
        int i14 = i11 & 14;
        RippleIndicationInstance c11 = c(gVar, this.f3517a, this.f3518b, i12, i13, iVar, i14 | ((i11 << 12) & 458752));
        boolean A = iVar.A(c11) | (((i14 ^ 6) > 4 && iVar.O(gVar)) || (i11 & 6) == 4);
        Object y10 = iVar.y();
        if (A || y10 == androidx.compose.runtime.i.f3811a.a()) {
            y10 = new Ripple$rememberUpdatedInstance$1$1(gVar, c11, null);
            iVar.p(y10);
        }
        g0.c(c11, gVar, (Function2) y10, iVar, (i11 << 3) & 112);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        iVar.K();
        return c11;
    }

    public abstract RippleIndicationInstance c(p.g gVar, boolean z10, float f11, a3 a3Var, a3 a3Var2, androidx.compose.runtime.i iVar, int i11);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ripple)) {
            return false;
        }
        Ripple ripple = (Ripple) obj;
        return this.f3517a == ripple.f3517a && o0.i.i(this.f3518b, ripple.f3518b) && Intrinsics.c(this.f3519c, ripple.f3519c);
    }

    public int hashCode() {
        return (((androidx.compose.foundation.e.a(this.f3517a) * 31) + o0.i.j(this.f3518b)) * 31) + this.f3519c.hashCode();
    }
}
