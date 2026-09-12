package androidx.compose.ui.window;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.layout.s;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.layout.v;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.x;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class AndroidDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(final kotlin.jvm.functions.Function0 r23, androidx.compose.ui.window.c r24, final kotlin.jvm.functions.Function2 r25, androidx.compose.runtime.i r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.a(kotlin.jvm.functions.Function0, androidx.compose.ui.window.c, kotlin.jvm.functions.Function2, androidx.compose.runtime.i, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2 b(a3 a3Var) {
        return (Function2) a3Var.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final androidx.compose.ui.f fVar, final Function2 function2, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i g11 = iVar.g(-1177876616);
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
                androidx.compose.runtime.k.Q(-1177876616, i13, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:464)");
            }
            AndroidDialog_androidKt$DialogLayout$1 androidDialog_androidKt$DialogLayout$1 = new t() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r13v14, types: [java.lang.Object] */
                /* JADX WARN: Type inference failed for: r13v15 */
                /* JADX WARN: Type inference failed for: r13v17 */
                /* JADX WARN: Type inference failed for: r13v18 */
                /* JADX WARN: Type inference failed for: r13v23 */
                @Override // androidx.compose.ui.layout.t
                public final v c(x xVar, List list, long j11) {
                    Object obj;
                    final ArrayList arrayList = new ArrayList(list.size());
                    int size = list.size();
                    for (int i15 = 0; i15 < size; i15++) {
                        arrayList.add(((s) list.get(i15)).P(j11));
                    }
                    g0 g0Var = null;
                    int i16 = 1;
                    if (arrayList.isEmpty()) {
                        obj = null;
                    } else {
                        obj = arrayList.get(0);
                        int u02 = ((g0) obj).u0();
                        int n11 = CollectionsKt.n(arrayList);
                        if (1 <= n11) {
                            int i17 = 1;
                            while (true) {
                                Object obj2 = arrayList.get(i17);
                                int u03 = ((g0) obj2).u0();
                                if (u02 < u03) {
                                    obj = obj2;
                                    u02 = u03;
                                }
                                if (i17 == n11) {
                                    break;
                                }
                                i17++;
                            }
                        }
                    }
                    g0 g0Var2 = (g0) obj;
                    int u04 = g0Var2 != null ? g0Var2.u0() : o0.b.n(j11);
                    if (!arrayList.isEmpty()) {
                        ?? r13 = arrayList.get(0);
                        int l02 = ((g0) r13).l0();
                        int n12 = CollectionsKt.n(arrayList);
                        boolean z10 = r13;
                        if (1 <= n12) {
                            while (true) {
                                Object obj3 = arrayList.get(i16);
                                int l03 = ((g0) obj3).l0();
                                r13 = z10;
                                if (l02 < l03) {
                                    r13 = obj3;
                                    l02 = l03;
                                }
                                if (i16 == n12) {
                                    break;
                                }
                                i16++;
                                z10 = r13;
                            }
                        }
                        g0Var = r13;
                    }
                    g0 g0Var3 = g0Var;
                    return w.b(xVar, u04, g0Var3 != null ? g0Var3.l0() : o0.b.m(j11), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                            invoke((g0.a) obj4);
                            return Unit.f67184a;
                        }

                        public final void invoke(g0.a aVar) {
                            List<g0> list2 = arrayList;
                            int size2 = list2.size();
                            for (int i18 = 0; i18 < size2; i18++) {
                                g0.a.l(aVar, list2.get(i18), 0, 0, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }
            };
            int i15 = ((i13 >> 3) & 14) | 384 | ((i13 << 3) & 112);
            int a11 = androidx.compose.runtime.g.a(g11, 0);
            androidx.compose.runtime.s n11 = g11.n();
            androidx.compose.ui.f e11 = ComposedModifierKt.e(g11, fVar);
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a12 = companion.a();
            int i16 = ((i15 << 6) & 896) | 6;
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
            f3.b(a13, androidDialog_androidKt$DialogLayout$1, companion.c());
            f3.b(a13, n11, companion.e());
            Function2 b11 = companion.b();
            if (a13.e() || !Intrinsics.c(a13.y(), Integer.valueOf(a11))) {
                a13.p(Integer.valueOf(a11));
                a13.k(Integer.valueOf(a11), b11);
            }
            f3.b(a13, e11, companion.d());
            function2.invoke(g11, Integer.valueOf((i16 >> 6) & 14));
            g11.r();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$2
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

                public final void invoke(androidx.compose.runtime.i iVar2, int i17) {
                    AndroidDialog_androidKt.c(androidx.compose.ui.f.this, function2, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }
}
