package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.z;

/* loaded from: classes.dex */
public abstract class w {
    public static final z a(LazyListState lazyListState, boolean z10, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(596174919, i11, -1, "androidx.compose.foundation.lazy.rememberLazyListSemanticState (LazyListSemantics.kt:26)");
        }
        boolean z11 = ((((i11 & 14) ^ 6) > 4 && iVar.O(lazyListState)) || (i11 & 6) == 4) | ((((i11 & 112) ^ 48) > 32 && iVar.a(z10)) || (i11 & 48) == 32);
        Object y10 = iVar.y();
        if (z11 || y10 == androidx.compose.runtime.i.f3811a.a()) {
            y10 = d.a(lazyListState, z10);
            iVar.p(y10);
        }
        z zVar = (z) y10;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return zVar;
    }
}
