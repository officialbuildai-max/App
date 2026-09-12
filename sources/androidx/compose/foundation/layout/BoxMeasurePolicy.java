package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.g0;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BoxMeasurePolicy implements androidx.compose.ui.layout.t {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.ui.b f2817a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f2818b;

    public BoxMeasurePolicy(androidx.compose.ui.b bVar, boolean z10) {
        this.f2817a = bVar;
        this.f2818b = z10;
    }

    @Override // androidx.compose.ui.layout.t
    public androidx.compose.ui.layout.v c(final androidx.compose.ui.layout.x xVar, final List list, long j11) {
        boolean g11;
        boolean g12;
        boolean g13;
        int n11;
        int m11;
        androidx.compose.ui.layout.g0 P;
        if (list.isEmpty()) {
            return androidx.compose.ui.layout.w.b(xVar, o0.b.n(j11), o0.b.m(j11), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((g0.a) obj);
                    return Unit.f67184a;
                }

                public final void invoke(g0.a aVar) {
                }
            }, 4, null);
        }
        long d11 = this.f2818b ? j11 : o0.b.d(j11, 0, 0, 0, 0, 10, null);
        if (list.size() == 1) {
            final androidx.compose.ui.layout.s sVar = (androidx.compose.ui.layout.s) list.get(0);
            g13 = BoxKt.g(sVar);
            if (g13) {
                n11 = o0.b.n(j11);
                m11 = o0.b.m(j11);
                P = sVar.P(o0.b.f70719b.c(o0.b.n(j11), o0.b.m(j11)));
            } else {
                P = sVar.P(d11);
                n11 = Math.max(o0.b.n(j11), P.u0());
                m11 = Math.max(o0.b.m(j11), P.l0());
            }
            final int i11 = n11;
            final int i12 = m11;
            final androidx.compose.ui.layout.g0 g0Var = P;
            return androidx.compose.ui.layout.w.b(xVar, i11, i12, null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((g0.a) obj);
                    return Unit.f67184a;
                }

                public final void invoke(g0.a aVar) {
                    androidx.compose.ui.b bVar;
                    androidx.compose.ui.layout.g0 g0Var2 = androidx.compose.ui.layout.g0.this;
                    androidx.compose.ui.layout.s sVar2 = sVar;
                    LayoutDirection layoutDirection = xVar.getLayoutDirection();
                    int i13 = i11;
                    int i14 = i12;
                    bVar = this.f2817a;
                    BoxKt.i(aVar, g0Var2, sVar2, layoutDirection, i13, i14, bVar);
                }
            }, 4, null);
        }
        final androidx.compose.ui.layout.g0[] g0VarArr = new androidx.compose.ui.layout.g0[list.size()];
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = o0.b.n(j11);
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = o0.b.m(j11);
        int size = list.size();
        boolean z10 = false;
        for (int i13 = 0; i13 < size; i13++) {
            androidx.compose.ui.layout.s sVar2 = (androidx.compose.ui.layout.s) list.get(i13);
            g12 = BoxKt.g(sVar2);
            if (g12) {
                z10 = true;
            } else {
                androidx.compose.ui.layout.g0 P2 = sVar2.P(d11);
                g0VarArr[i13] = P2;
                intRef.element = Math.max(intRef.element, P2.u0());
                intRef2.element = Math.max(intRef2.element, P2.l0());
            }
        }
        if (z10) {
            int i14 = intRef.element;
            int i15 = i14 != Integer.MAX_VALUE ? i14 : 0;
            int i16 = intRef2.element;
            long a11 = o0.c.a(i15, i14, i16 != Integer.MAX_VALUE ? i16 : 0, i16);
            int size2 = list.size();
            for (int i17 = 0; i17 < size2; i17++) {
                androidx.compose.ui.layout.s sVar3 = (androidx.compose.ui.layout.s) list.get(i17);
                g11 = BoxKt.g(sVar3);
                if (g11) {
                    g0VarArr[i17] = sVar3.P(a11);
                }
            }
        }
        return androidx.compose.ui.layout.w.b(xVar, intRef.element, intRef2.element, null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$5
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
                androidx.compose.ui.b bVar;
                androidx.compose.ui.layout.g0[] g0VarArr2 = g0VarArr;
                List<androidx.compose.ui.layout.s> list2 = list;
                androidx.compose.ui.layout.x xVar2 = xVar;
                Ref.IntRef intRef3 = intRef;
                Ref.IntRef intRef4 = intRef2;
                BoxMeasurePolicy boxMeasurePolicy = this;
                int length = g0VarArr2.length;
                int i18 = 0;
                int i19 = 0;
                while (i18 < length) {
                    androidx.compose.ui.layout.g0 g0Var2 = g0VarArr2[i18];
                    Intrinsics.f(g0Var2, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                    androidx.compose.ui.layout.s sVar4 = list2.get(i19);
                    LayoutDirection layoutDirection = xVar2.getLayoutDirection();
                    int i20 = intRef3.element;
                    int i21 = intRef4.element;
                    bVar = boxMeasurePolicy.f2817a;
                    BoxKt.i(aVar, g0Var2, sVar4, layoutDirection, i20, i21, bVar);
                    i18++;
                    i19++;
                }
            }
        }, 4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) obj;
        return Intrinsics.c(this.f2817a, boxMeasurePolicy.f2817a) && this.f2818b == boxMeasurePolicy.f2818b;
    }

    public int hashCode() {
        return (this.f2817a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f2818b);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.f2817a + ", propagateMinConstraints=" + this.f2818b + ')';
    }
}
