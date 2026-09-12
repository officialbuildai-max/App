package androidx.compose.ui.node;

import androidx.compose.ui.f;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;

/* loaded from: classes.dex */
public abstract class j1 {
    public static final boolean a(androidx.compose.ui.semantics.i iVar) {
        return SemanticsConfigurationKt.a(iVar, androidx.compose.ui.semantics.h.f6051a.j()) != null;
    }

    public static final void b(i1 i1Var) {
        g.m(i1Var).B0();
    }

    public static final y.i c(f.c cVar, boolean z10) {
        return !cVar.getNode().k1() ? y.i.f78598e.a() : !z10 ? androidx.compose.ui.layout.m.b(g.h(cVar, s0.a(8))) : g.h(cVar, s0.a(8)).K2();
    }
}
