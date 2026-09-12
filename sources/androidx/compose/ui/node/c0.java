package androidx.compose.ui.node;

import java.util.Map;

/* loaded from: classes.dex */
public final class c0 extends AlignmentLines {
    public c0(a aVar) {
        super(aVar, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    protected long d(NodeCoordinator nodeCoordinator, long j11) {
        return NodeCoordinator.J2(nodeCoordinator, j11, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.AlignmentLines
    public Map e(NodeCoordinator nodeCoordinator) {
        return nodeCoordinator.b1().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.AlignmentLines
    public int i(NodeCoordinator nodeCoordinator, androidx.compose.ui.layout.a aVar) {
        return nodeCoordinator.T0(aVar);
    }
}
