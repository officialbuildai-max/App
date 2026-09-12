package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class r {
    public static final androidx.compose.ui.node.j0 a(androidx.compose.ui.node.j0 j0Var) {
        LayoutNode a12 = j0Var.a1();
        while (true) {
            LayoutNode h02 = a12.h0();
            if ((h02 != null ? h02.V() : null) == null) {
                androidx.compose.ui.node.j0 U1 = a12.f0().U1();
                Intrinsics.e(U1);
                return U1;
            }
            LayoutNode h03 = a12.h0();
            LayoutNode V = h03 != null ? h03.V() : null;
            Intrinsics.e(V);
            if (V.H0()) {
                a12 = a12.h0();
                Intrinsics.e(a12);
            } else {
                LayoutNode h04 = a12.h0();
                Intrinsics.e(h04);
                a12 = h04.V();
                Intrinsics.e(a12);
            }
        }
    }
}
