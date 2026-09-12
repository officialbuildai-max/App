package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.w;
import androidx.compose.foundation.f0;
import androidx.compose.ui.unit.LayoutDirection;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f2803a = new m();

    private m() {
    }

    public final g a(androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(1107739818, i11, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.flingBehavior (Scrollable.kt:570)");
        }
        w b11 = androidx.compose.animation.h.b(iVar, 0);
        boolean O = iVar.O(b11);
        Object y10 = iVar.y();
        if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
            y10 = new DefaultFlingBehavior(b11, null, 2, null);
            iVar.p(y10);
        }
        DefaultFlingBehavior defaultFlingBehavior = (DefaultFlingBehavior) y10;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return defaultFlingBehavior;
    }

    public final f0 b(androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(1809802212, i11, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.overscrollEffect (Scrollable.kt:583)");
        }
        f0 a11 = androidx.compose.foundation.a.a(iVar, 0);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return a11;
    }

    public final boolean c(LayoutDirection layoutDirection, Orientation orientation, boolean z10) {
        return (layoutDirection != LayoutDirection.Rtl || orientation == Orientation.Vertical) ? !z10 : z10;
    }
}
