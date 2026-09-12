package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.a3;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class b extends Ripple {
    private b(boolean z10, float f11, a3 a3Var) {
        super(z10, f11, a3Var, null);
    }

    public /* synthetic */ b(boolean z10, float f11, a3 a3Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, f11, a3Var);
    }

    @Override // androidx.compose.material.ripple.Ripple
    public RippleIndicationInstance c(p.g gVar, boolean z10, float f11, a3 a3Var, a3 a3Var2, androidx.compose.runtime.i iVar, int i11) {
        ViewGroup e11;
        iVar.P(331259447);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(331259447, i11, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:92)");
        }
        e11 = j.e((View) iVar.l(AndroidCompositionLocals_androidKt.j()));
        boolean O = ((((i11 & 14) ^ 6) > 4 && iVar.O(gVar)) || (i11 & 6) == 4) | ((((458752 & i11) ^ 196608) > 131072 && iVar.O(this)) || (i11 & 196608) == 131072) | iVar.O(e11);
        Object y10 = iVar.y();
        if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
            y10 = new AndroidRippleIndicationInstance(z10, f11, a3Var, a3Var2, e11, null);
            iVar.p(y10);
        }
        AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) y10;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        iVar.K();
        return androidRippleIndicationInstance;
    }
}
