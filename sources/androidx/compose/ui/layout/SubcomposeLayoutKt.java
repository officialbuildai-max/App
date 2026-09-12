package androidx.compose.ui.layout;

import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.core.view.PointerIconCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class SubcomposeLayoutKt {

    /* renamed from: a */
    private static final a f5226a = new a();

    /* loaded from: classes.dex */
    public static final class a {
        a() {
        }

        public String toString() {
            return "ReusedSlotId";
        }
    }

    public static final void a(final androidx.compose.ui.f fVar, final Function2 function2, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i g11 = iVar.g(-1298353104);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (g11.O(fVar) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 48) == 0) {
            i13 |= g11.A(function2) ? 32 : 16;
        }
        if ((i13 & 19) == 18 && g11.h()) {
            g11.G();
        } else {
            if (i14 != 0) {
                fVar = androidx.compose.ui.f.f4253a;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-1298353104, i13, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:78)");
            }
            Object y10 = g11.y();
            if (y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new SubcomposeLayoutState();
                g11.p(y10);
            }
            b((SubcomposeLayoutState) y10, fVar, function2, g11, (i13 << 3) & PointerIconCompat.TYPE_TEXT, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i15) {
                    SubcomposeLayoutKt.a(androidx.compose.ui.f.this, function2, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }

    public static final void b(final SubcomposeLayoutState subcomposeLayoutState, androidx.compose.ui.f fVar, final Function2 function2, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i g11 = iVar.g(-511989831);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (g11.A(subcomposeLayoutState) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i14 = i12 & 2;
        if (i14 != 0) {
            i13 |= 48;
        } else if ((i11 & 48) == 0) {
            i13 |= g11.O(fVar) ? 32 : 16;
        }
        if ((i12 & 4) != 0) {
            i13 |= 384;
        } else if ((i11 & 384) == 0) {
            i13 |= g11.A(function2) ? 256 : 128;
        }
        if ((i13 & 147) == 146 && g11.h()) {
            g11.G();
        } else {
            if (i14 != 0) {
                fVar = androidx.compose.ui.f.f4253a;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-511989831, i13, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:112)");
            }
            int a11 = androidx.compose.runtime.g.a(g11, 0);
            androidx.compose.runtime.m c11 = androidx.compose.runtime.g.c(g11, 0);
            androidx.compose.ui.f e11 = ComposedModifierKt.e(g11, fVar);
            androidx.compose.runtime.s n11 = g11.n();
            Function0 a12 = LayoutNode.K.a();
            if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            g11.C();
            if (g11.e()) {
                g11.F(a12);
            } else {
                g11.o();
            }
            androidx.compose.runtime.i a13 = f3.a(g11);
            f3.b(a13, subcomposeLayoutState, subcomposeLayoutState.g());
            f3.b(a13, c11, subcomposeLayoutState.e());
            f3.b(a13, function2, subcomposeLayoutState.f());
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            f3.b(a13, n11, companion.e());
            f3.b(a13, e11, companion.d());
            Function2 b11 = companion.b();
            if (a13.e() || !Intrinsics.c(a13.y(), Integer.valueOf(a11))) {
                a13.p(Integer.valueOf(a11));
                a13.k(Integer.valueOf(a11), b11);
            }
            g11.r();
            if (g11.h()) {
                g11.P(-26502501);
                g11.K();
            } else {
                g11.P(-26580342);
                boolean A = g11.A(subcomposeLayoutState);
                Object y10 = g11.y();
                if (A || y10 == androidx.compose.runtime.i.f3811a.a()) {
                    y10 = new Function0<Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$4$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m119invoke();
                            return Unit.f67184a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m119invoke() {
                            SubcomposeLayoutState.this.d();
                        }
                    };
                    g11.p(y10);
                }
                androidx.compose.runtime.g0.e((Function0) y10, g11, 0);
                g11.K();
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        final androidx.compose.ui.f fVar2 = fVar;
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i15) {
                    SubcomposeLayoutKt.b(SubcomposeLayoutState.this, fVar2, function2, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }

    public static final /* synthetic */ a c() {
        return f5226a;
    }
}
