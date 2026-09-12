package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* loaded from: classes.dex */
public abstract class a {
    public static final f0 a(androidx.compose.runtime.i iVar, int i11) {
        f0 f0Var;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-1476348564, i11, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.android.kt:63)");
        }
        Context context = (Context) iVar.l(AndroidCompositionLocals_androidKt.g());
        e0 e0Var = (e0) iVar.l(OverscrollConfiguration_androidKt.a());
        if (e0Var != null) {
            iVar.P(1586021609);
            boolean O = iVar.O(context) | iVar.O(e0Var);
            Object y10 = iVar.y();
            if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new AndroidEdgeEffectOverscrollEffect(context, e0Var);
                iVar.p(y10);
            }
            f0Var = (AndroidEdgeEffectOverscrollEffect) y10;
            iVar.K();
        } else {
            iVar.P(1586120933);
            iVar.K();
            f0Var = d0.f2696a;
        }
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return f0Var;
    }
}
