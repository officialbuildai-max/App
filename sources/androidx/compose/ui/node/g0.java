package androidx.compose.ui.node;

/* loaded from: classes.dex */
public abstract class g0 {
    public static final boolean a(LayoutNode layoutNode) {
        if (layoutNode.V() != null) {
            LayoutNode h02 = layoutNode.h0();
            if ((h02 != null ? h02.V() : null) == null || layoutNode.P().w()) {
                return true;
            }
        }
        return false;
    }
}
