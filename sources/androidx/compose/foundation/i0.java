package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;

/* loaded from: classes.dex */
public abstract class i0 {
    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, androidx.compose.foundation.gestures.o oVar, Orientation orientation, boolean z10, boolean z11, androidx.compose.foundation.gestures.g gVar, p.i iVar, androidx.compose.foundation.gestures.d dVar, androidx.compose.runtime.i iVar2, int i11, int i12) {
        androidx.compose.foundation.gestures.d dVar2 = (i12 & 64) != 0 ? null : dVar;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-1677817431, i11, -1, "androidx.compose.foundation.scrollingContainer (ScrollingContainer.kt:40)");
        }
        androidx.compose.foundation.gestures.m mVar = androidx.compose.foundation.gestures.m.f2803a;
        f0 b11 = mVar.b(iVar2, 6);
        androidx.compose.ui.f f11 = ScrollableKt.f(g0.a(g.a(fVar, orientation), b11), oVar, orientation, b11, z10, mVar.c((LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation, z11), gVar, iVar, dVar2);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return f11;
    }
}
