package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.k0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    private final LayoutNode f5462a;

    /* renamed from: b, reason: collision with root package name */
    private final j f5463b;

    /* renamed from: c, reason: collision with root package name */
    private final List f5464c;

    public h0(LayoutNode layoutNode, j jVar, List list) {
        this.f5462a = layoutNode;
        this.f5463b = jVar;
        this.f5464c = list;
    }

    private final boolean b(LayoutNode layoutNode) {
        Object obj;
        LayoutNode h02 = layoutNode.h0();
        Object obj2 = null;
        LayoutNode.LayoutState R = h02 != null ? h02.R() : null;
        if (layoutNode.n() || (layoutNode.i0() != Integer.MAX_VALUE && h02 != null && h02.n())) {
            if (layoutNode.Y()) {
                List list = this.f5464c;
                int size = list.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        obj = null;
                        break;
                    }
                    obj = list.get(i11);
                    k0.a aVar = (k0.a) obj;
                    if (Intrinsics.c(aVar.a(), layoutNode) && !aVar.c()) {
                        break;
                    }
                    i11++;
                }
                if (obj != null) {
                    return true;
                }
            }
            if (layoutNode.Y()) {
                return this.f5463b.d(layoutNode) || layoutNode.R() == LayoutNode.LayoutState.LookaheadMeasuring || (h02 != null && h02.Y()) || ((h02 != null && h02.T()) || R == LayoutNode.LayoutState.Measuring);
            }
            if (layoutNode.Q()) {
                return this.f5463b.d(layoutNode) || h02 == null || h02.Y() || h02.Q() || R == LayoutNode.LayoutState.Measuring || R == LayoutNode.LayoutState.LayingOut;
            }
        }
        if (Intrinsics.c(layoutNode.G0(), Boolean.TRUE)) {
            if (layoutNode.T()) {
                List list2 = this.f5464c;
                int size2 = list2.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size2) {
                        break;
                    }
                    Object obj3 = list2.get(i12);
                    k0.a aVar2 = (k0.a) obj3;
                    if (Intrinsics.c(aVar2.a(), layoutNode) && aVar2.c()) {
                        obj2 = obj3;
                        break;
                    }
                    i12++;
                }
                if (obj2 != null) {
                    return true;
                }
            }
            if (layoutNode.T()) {
                return this.f5463b.e(layoutNode, true) || (h02 != null && h02.T()) || R == LayoutNode.LayoutState.LookaheadMeasuring || (h02 != null && h02.Y() && Intrinsics.c(layoutNode.V(), layoutNode));
            }
            if (layoutNode.S()) {
                return this.f5463b.e(layoutNode, true) || h02 == null || h02.T() || h02.S() || R == LayoutNode.LayoutState.LookaheadMeasuring || R == LayoutNode.LayoutState.LookaheadLayingOut || (h02.Q() && Intrinsics.c(layoutNode.V(), layoutNode));
            }
        }
        return true;
    }

    private final boolean c(LayoutNode layoutNode) {
        if (!b(layoutNode)) {
            return false;
        }
        List E = layoutNode.E();
        int size = E.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!c((LayoutNode) E.get(i11))) {
                return false;
            }
        }
        return true;
    }

    private final String d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Tree state:");
        Intrinsics.g(sb2, "append(value)");
        sb2.append('\n');
        Intrinsics.g(sb2, "append('\\n')");
        e(this, sb2, this.f5462a, 0);
        return sb2.toString();
    }

    private static final void e(h0 h0Var, StringBuilder sb2, LayoutNode layoutNode, int i11) {
        String f11 = h0Var.f(layoutNode);
        if (f11.length() > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                sb2.append("..");
            }
            sb2.append(f11);
            Intrinsics.g(sb2, "append(value)");
            sb2.append('\n');
            Intrinsics.g(sb2, "append('\\n')");
            i11++;
        }
        List E = layoutNode.E();
        int size = E.size();
        for (int i13 = 0; i13 < size; i13++) {
            e(h0Var, sb2, (LayoutNode) E.get(i13), i11);
        }
    }

    private final String f(LayoutNode layoutNode) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(layoutNode);
        StringBuilder sb3 = new StringBuilder();
        sb3.append('[');
        sb3.append(layoutNode.R());
        sb3.append(']');
        sb2.append(sb3.toString());
        if (!layoutNode.n()) {
            sb2.append("[!isPlaced]");
        }
        sb2.append("[measuredByParent=" + layoutNode.a0() + ']');
        if (!b(layoutNode)) {
            sb2.append("[INCONSISTENT]");
        }
        return sb2.toString();
    }

    public final void a() {
        if (c(this.f5462a)) {
            return;
        }
        System.out.println((Object) d());
        throw new IllegalStateException("Inconsistency found!");
    }
}
