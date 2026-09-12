package androidx.compose.foundation.layout;

import androidx.compose.runtime.f3;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class e0 {
    public static final void a(androidx.compose.ui.f fVar, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-72882467, i11, -1, "androidx.compose.foundation.layout.Spacer (Spacer.kt:38)");
        }
        SpacerMeasurePolicy spacerMeasurePolicy = SpacerMeasurePolicy.f2867a;
        int a11 = androidx.compose.runtime.g.a(iVar, 0);
        androidx.compose.ui.f e11 = ComposedModifierKt.e(iVar, fVar);
        androidx.compose.runtime.s n11 = iVar.n();
        ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
        Function0 a12 = companion.a();
        if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
            androidx.compose.runtime.g.b();
        }
        iVar.C();
        if (iVar.e()) {
            iVar.F(a12);
        } else {
            iVar.o();
        }
        androidx.compose.runtime.i a13 = f3.a(iVar);
        f3.b(a13, spacerMeasurePolicy, companion.c());
        f3.b(a13, n11, companion.e());
        f3.b(a13, e11, companion.d());
        Function2 b11 = companion.b();
        if (a13.e() || !Intrinsics.c(a13.y(), Integer.valueOf(a11))) {
            a13.p(Integer.valueOf(a11));
            a13.k(Integer.valueOf(a11), b11);
        }
        iVar.r();
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
    }
}
