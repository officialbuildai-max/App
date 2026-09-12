package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.y0;

/* loaded from: classes.dex */
public abstract class u {
    public static final v b(FocusTargetNode focusTargetNode) {
        LayoutNode a12;
        y0 g02;
        i focusOwner;
        NodeCoordinator c12 = focusTargetNode.getNode().c1();
        if (c12 == null || (a12 = c12.a1()) == null || (g02 = a12.g0()) == null || (focusOwner = g02.getFocusOwner()) == null) {
            return null;
        }
        return focusOwner.c();
    }

    public static final void c(FocusTargetNode focusTargetNode) {
        androidx.compose.ui.node.g.n(focusTargetNode).getFocusOwner().g(focusTargetNode);
    }

    public static final v d(FocusTargetNode focusTargetNode) {
        return androidx.compose.ui.node.g.n(focusTargetNode).getFocusOwner().c();
    }
}
