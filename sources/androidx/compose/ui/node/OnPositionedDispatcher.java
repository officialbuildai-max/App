package androidx.compose.ui.node;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class OnPositionedDispatcher {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f5442c = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f5443d = 8;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5444a = new androidx.compose.runtime.collection.b(new LayoutNode[16], 0);

    /* renamed from: b, reason: collision with root package name */
    private LayoutNode[] f5445b;

    /* loaded from: classes.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion$DepthComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        /* loaded from: classes.dex */
        private static final class DepthComparator implements Comparator<LayoutNode> {
            public static final DepthComparator INSTANCE = new DepthComparator();

            private DepthComparator() {
            }

            @Override // java.util.Comparator
            public int compare(LayoutNode a11, LayoutNode b11) {
                int j11 = Intrinsics.j(b11.I(), a11.I());
                return j11 != 0 ? j11 : Intrinsics.j(a11.hashCode(), b11.hashCode());
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void b(LayoutNode layoutNode) {
        layoutNode.x();
        int i11 = 0;
        layoutNode.p1(false);
        androidx.compose.runtime.collection.b p02 = layoutNode.p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            do {
                b((LayoutNode) m11[i11]);
                i11++;
            } while (i11 < n11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r2 < r0) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r4 = this;
            androidx.compose.runtime.collection.b r0 = r4.f5444a
            androidx.compose.ui.node.OnPositionedDispatcher$Companion$DepthComparator r1 = androidx.compose.ui.node.OnPositionedDispatcher.Companion.DepthComparator.INSTANCE
            r0.A(r1)
            androidx.compose.runtime.collection.b r0 = r4.f5444a
            int r0 = r0.n()
            androidx.compose.ui.node.LayoutNode[] r1 = r4.f5445b
            if (r1 == 0) goto L14
            int r2 = r1.length
            if (r2 >= r0) goto L22
        L14:
            androidx.compose.runtime.collection.b r1 = r4.f5444a
            int r1 = r1.n()
            r2 = 16
            int r1 = java.lang.Math.max(r2, r1)
            androidx.compose.ui.node.LayoutNode[] r1 = new androidx.compose.ui.node.LayoutNode[r1]
        L22:
            r2 = 0
            r4.f5445b = r2
            r2 = 0
        L26:
            if (r2 >= r0) goto L35
            androidx.compose.runtime.collection.b r3 = r4.f5444a
            java.lang.Object[] r3 = r3.m()
            r3 = r3[r2]
            r1[r2] = r3
            int r2 = r2 + 1
            goto L26
        L35:
            androidx.compose.runtime.collection.b r2 = r4.f5444a
            r2.h()
            int r0 = r0 + (-1)
        L3c:
            r2 = -1
            if (r2 >= r0) goto L50
            r2 = r1[r0]
            kotlin.jvm.internal.Intrinsics.e(r2)
            boolean r3 = r2.d0()
            if (r3 == 0) goto L4d
            r4.b(r2)
        L4d:
            int r0 = r0 + (-1)
            goto L3c
        L50:
            r4.f5445b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.OnPositionedDispatcher.a():void");
    }

    public final boolean c() {
        return this.f5444a.q();
    }

    public final void d(LayoutNode layoutNode) {
        this.f5444a.b(layoutNode);
        layoutNode.p1(true);
    }

    public final void e(LayoutNode layoutNode) {
        this.f5444a.h();
        this.f5444a.b(layoutNode);
        layoutNode.p1(true);
    }

    public final void f(LayoutNode layoutNode) {
        this.f5444a.t(layoutNode);
    }
}
