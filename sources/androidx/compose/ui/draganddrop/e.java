package androidx.compose.ui.draganddrop;

import androidx.compose.ui.layout.l;
import androidx.compose.ui.layout.m;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.jvm.functions.Function1;
import o0.t;

/* loaded from: classes.dex */
public abstract class e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(d dVar, long j11) {
        if (!dVar.getNode().k1()) {
            return false;
        }
        l o11 = androidx.compose.ui.node.g.m(dVar).o();
        if (!o11.F()) {
            return false;
        }
        long k11 = o11.k();
        int g11 = t.g(k11);
        int f11 = t.f(k11);
        long e11 = m.e(o11);
        float m11 = y.g.m(e11);
        float n11 = y.g.n(e11);
        float f12 = g11 + m11;
        float f13 = f11 + n11;
        float m12 = y.g.m(j11);
        if (m11 > m12 || m12 > f12) {
            return false;
        }
        float n12 = y.g.n(j11);
        return n11 <= n12 && n12 <= f13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(f fVar, b bVar) {
        fVar.a0(bVar);
        fVar.C(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(m1 m1Var, Function1 function1) {
        if (function1.invoke(m1Var) != TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal) {
            return;
        }
        n1.e(m1Var, function1);
    }
}
