package androidx.compose.ui.layout;

import androidx.compose.ui.layout.g0;
import androidx.compose.ui.node.LayoutNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.d {

    /* renamed from: b, reason: collision with root package name */
    public static final RootMeasurePolicy f5225b = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // androidx.compose.ui.layout.t
    public v c(x xVar, List list, long j11) {
        if (list.isEmpty()) {
            return w.b(xVar, o0.b.n(j11), o0.b.m(j11), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((g0.a) obj);
                    return Unit.f67184a;
                }

                public final void invoke(g0.a aVar) {
                }
            }, 4, null);
        }
        if (list.size() == 1) {
            final g0 P = ((s) list.get(0)).P(j11);
            return w.b(xVar, o0.c.i(j11, P.u0()), o0.c.h(j11, P.l0()), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((g0.a) obj);
                    return Unit.f67184a;
                }

                public final void invoke(g0.a aVar) {
                    g0.a.n(aVar, g0.this, 0, 0, 0.0f, null, 12, null);
                }
            }, 4, null);
        }
        final ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(((s) list.get(i11)).P(j11));
        }
        int size2 = arrayList.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size2; i14++) {
            g0 g0Var = (g0) arrayList.get(i14);
            i12 = Math.max(g0Var.u0(), i12);
            i13 = Math.max(g0Var.l0(), i13);
        }
        return w.b(xVar, o0.c.i(j11, i12), o0.c.h(j11, i13), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((g0.a) obj);
                return Unit.f67184a;
            }

            public final void invoke(g0.a aVar) {
                List<g0> list2 = arrayList;
                int size3 = list2.size();
                for (int i15 = 0; i15 < size3; i15++) {
                    g0.a.n(aVar, list2.get(i15), 0, 0, 0.0f, null, 12, null);
                }
            }
        }, 4, null);
    }
}
