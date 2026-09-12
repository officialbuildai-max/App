package androidx.compose.foundation.lazy;

/* loaded from: classes.dex */
public abstract class f {
    public static final androidx.compose.foundation.lazy.layout.h a(LazyListState lazyListState, int i11, androidx.compose.runtime.i iVar, int i12) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-1877443446, i12, -1, "androidx.compose.foundation.lazy.rememberLazyListBeyondBoundsState (LazyListBeyondBoundsModifier.kt:26)");
        }
        boolean z10 = ((((i12 & 14) ^ 6) > 4 && iVar.O(lazyListState)) || (i12 & 6) == 4) | ((((i12 & 112) ^ 48) > 32 && iVar.c(i11)) || (i12 & 48) == 32);
        Object y10 = iVar.y();
        if (z10 || y10 == androidx.compose.runtime.i.f3811a.a()) {
            y10 = new g(lazyListState, i11);
            iVar.p(y10);
        }
        g gVar = (g) y10;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return gVar;
    }
}
