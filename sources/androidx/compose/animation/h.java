package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.w;
import androidx.compose.animation.core.y;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.ui.platform.CompositionLocalsKt;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final float f2598a = ViewConfiguration.getScrollFriction();

    public static final float a() {
        return f2598a;
    }

    public static final w b(i iVar, int i11) {
        if (k.H()) {
            k.Q(904445851, i11, -1, "androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)");
        }
        o0.e eVar = (o0.e) iVar.l(CompositionLocalsKt.c());
        boolean b11 = iVar.b(eVar.getDensity());
        Object y10 = iVar.y();
        if (b11 || y10 == i.f3811a.a()) {
            y10 = y.a(new g(eVar));
            iVar.p(y10);
        }
        w wVar = (w) y10;
        if (k.H()) {
            k.P();
        }
        return wVar;
    }
}
