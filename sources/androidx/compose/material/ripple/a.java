package androidx.compose.material.ripple;

import androidx.compose.ui.graphics.u1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3569b = new a();

    private a() {
    }

    @Override // androidx.compose.material.ripple.i
    public long a(androidx.compose.runtime.i iVar, int i11) {
        iVar.P(2042140174);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(2042140174, i11, -1, "androidx.compose.material.ripple.DebugRippleTheme.defaultColor (RippleTheme.kt:239)");
        }
        long b11 = i.f3579a.b(u1.f4733b.a(), true);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        iVar.K();
        return b11;
    }

    @Override // androidx.compose.material.ripple.i
    public c b(androidx.compose.runtime.i iVar, int i11) {
        iVar.P(-1629816343);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-1629816343, i11, -1, "androidx.compose.material.ripple.DebugRippleTheme.rippleAlpha (RippleTheme.kt:243)");
        }
        c a11 = i.f3579a.a(u1.f4733b.a(), true);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        iVar.K();
        return a11;
    }
}
