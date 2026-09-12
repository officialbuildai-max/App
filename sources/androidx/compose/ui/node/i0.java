package androidx.compose.ui.node;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class i0 extends AlignmentLines {
    public i0(a aVar) {
        super(aVar, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    protected long d(NodeCoordinator nodeCoordinator, long j11) {
        j0 U1 = nodeCoordinator.U1();
        Intrinsics.e(U1);
        long e12 = U1.e1();
        return y.g.r(y.h.a(o0.p.h(e12), o0.p.i(e12)), j11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.AlignmentLines
    public Map e(NodeCoordinator nodeCoordinator) {
        j0 U1 = nodeCoordinator.U1();
        Intrinsics.e(U1);
        return U1.b1().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.AlignmentLines
    public int i(NodeCoordinator nodeCoordinator, androidx.compose.ui.layout.a aVar) {
        j0 U1 = nodeCoordinator.U1();
        Intrinsics.e(U1);
        return U1.T0(aVar);
    }
}
