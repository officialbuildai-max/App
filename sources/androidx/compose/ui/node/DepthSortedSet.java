package androidx.compose.ui.node;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class DepthSortedSet {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5310a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f5311b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<Map<LayoutNode, Integer>>() { // from class: androidx.compose.ui.node.DepthSortedSet$mapOfOriginalDepth$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<LayoutNode, Integer> invoke() {
            return new LinkedHashMap();
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Comparator f5312c;

    /* renamed from: d, reason: collision with root package name */
    private final TreeSet f5313d;

    public DepthSortedSet(boolean z10) {
        this.f5310a = z10;
        Comparator<LayoutNode> comparator = new Comparator<LayoutNode>() { // from class: androidx.compose.ui.node.DepthSortedSet$DepthComparator$1
            @Override // java.util.Comparator
            public int compare(LayoutNode a11, LayoutNode b11) {
                int j11 = Intrinsics.j(a11.I(), b11.I());
                return j11 != 0 ? j11 : Intrinsics.j(a11.hashCode(), b11.hashCode());
            }
        };
        this.f5312c = comparator;
        this.f5313d = new TreeSet(comparator);
    }

    private final Map c() {
        return (Map) this.f5311b.getValue();
    }

    public final void a(LayoutNode layoutNode) {
        if (!layoutNode.D0()) {
            g0.a.b("DepthSortedSet.add called on an unattached node");
        }
        if (this.f5310a) {
            Integer num = (Integer) c().get(layoutNode);
            if (num == null) {
                c().put(layoutNode, Integer.valueOf(layoutNode.I()));
            } else {
                if (!(num.intValue() == layoutNode.I())) {
                    g0.a.b("invalid node depth");
                }
            }
        }
        this.f5313d.add(layoutNode);
    }

    public final boolean b(LayoutNode layoutNode) {
        boolean contains = this.f5313d.contains(layoutNode);
        if (this.f5310a) {
            if (!(contains == c().containsKey(layoutNode))) {
                g0.a.b("inconsistency in TreeSet");
            }
        }
        return contains;
    }

    public final boolean d() {
        return this.f5313d.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LayoutNode e() {
        LayoutNode layoutNode = (LayoutNode) this.f5313d.first();
        f(layoutNode);
        return layoutNode;
    }

    public final boolean f(LayoutNode layoutNode) {
        if (!layoutNode.D0()) {
            g0.a.b("DepthSortedSet.remove called on an unattached node");
        }
        boolean remove = this.f5313d.remove(layoutNode);
        if (this.f5310a) {
            if (!Intrinsics.c((Integer) c().remove(layoutNode), remove ? Integer.valueOf(layoutNode.I()) : null)) {
                g0.a.b("invalid node depth");
            }
        }
        return remove;
    }

    public String toString() {
        return this.f5313d.toString();
    }
}
