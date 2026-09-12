package androidx.compose.foundation.layout;

import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.b;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class BoxKt {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap f2812a = d(true);

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap f2813b = d(false);

    /* renamed from: c, reason: collision with root package name */
    private static final androidx.compose.ui.layout.t f2814c = new BoxMeasurePolicy(androidx.compose.ui.b.f4162a.m(), false);

    /* renamed from: d, reason: collision with root package name */
    private static final androidx.compose.ui.layout.t f2815d = new androidx.compose.ui.layout.t() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1
        @Override // androidx.compose.ui.layout.t
        public final androidx.compose.ui.layout.v c(androidx.compose.ui.layout.x xVar, List list, long j11) {
            return androidx.compose.ui.layout.w.b(xVar, o0.b.n(j11), o0.b.m(j11), null, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((g0.a) obj);
                    return Unit.f67184a;
                }

                public final void invoke(g0.a aVar) {
                }
            }, 4, null);
        }
    };

    public static final void a(final androidx.compose.ui.f fVar, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i g11 = iVar.g(-211209833);
        if ((i11 & 6) == 0) {
            i12 = (g11.O(fVar) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 3) == 2 && g11.h()) {
            g11.G();
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-211209833, i12, -1, "androidx.compose.foundation.layout.Box (Box.kt:236)");
            }
            androidx.compose.ui.layout.t tVar = f2815d;
            int a11 = androidx.compose.runtime.g.a(g11, 0);
            androidx.compose.ui.f e11 = ComposedModifierKt.e(g11, fVar);
            androidx.compose.runtime.s n11 = g11.n();
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a12 = companion.a();
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
            f3.b(a13, tVar, companion.c());
            f3.b(a13, n11, companion.e());
            f3.b(a13, e11, companion.d());
            Function2 b11 = companion.b();
            if (a13.e() || !Intrinsics.c(a13.y(), Integer.valueOf(a11))) {
                a13.p(Integer.valueOf(a11));
                a13.k(Integer.valueOf(a11), b11);
            }
            g11.r();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$Box$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    BoxKt.a(androidx.compose.ui.f.this, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    private static final HashMap d(boolean z10) {
        HashMap hashMap = new HashMap(9);
        b.a aVar = androidx.compose.ui.b.f4162a;
        e(hashMap, z10, aVar.m());
        e(hashMap, z10, aVar.k());
        e(hashMap, z10, aVar.l());
        e(hashMap, z10, aVar.g());
        e(hashMap, z10, aVar.d());
        e(hashMap, z10, aVar.e());
        e(hashMap, z10, aVar.c());
        e(hashMap, z10, aVar.a());
        e(hashMap, z10, aVar.b());
        return hashMap;
    }

    private static final void e(HashMap hashMap, boolean z10, androidx.compose.ui.b bVar) {
        hashMap.put(bVar, new BoxMeasurePolicy(bVar, z10));
    }

    private static final e f(androidx.compose.ui.layout.s sVar) {
        Object G = sVar.G();
        if (G instanceof e) {
            return (e) G;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(androidx.compose.ui.layout.s sVar) {
        e f11 = f(sVar);
        if (f11 != null) {
            return f11.E1();
        }
        return false;
    }

    public static final androidx.compose.ui.layout.t h(androidx.compose.ui.b bVar, boolean z10) {
        androidx.compose.ui.layout.t tVar = (androidx.compose.ui.layout.t) (z10 ? f2812a : f2813b).get(bVar);
        return tVar == null ? new BoxMeasurePolicy(bVar, z10) : tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(g0.a aVar, androidx.compose.ui.layout.g0 g0Var, androidx.compose.ui.layout.s sVar, LayoutDirection layoutDirection, int i11, int i12, androidx.compose.ui.b bVar) {
        androidx.compose.ui.b D1;
        e f11 = f(sVar);
        g0.a.j(aVar, g0Var, ((f11 == null || (D1 = f11.D1()) == null) ? bVar : D1).a(o0.u.a(g0Var.u0(), g0Var.l0()), o0.u.a(i11, i12), layoutDirection), 0.0f, 2, null);
    }

    public static final androidx.compose.ui.layout.t j(androidx.compose.ui.b bVar, boolean z10, androidx.compose.runtime.i iVar, int i11) {
        androidx.compose.ui.layout.t tVar;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(56522820, i11, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:113)");
        }
        if (!Intrinsics.c(bVar, androidx.compose.ui.b.f4162a.m()) || z10) {
            iVar.P(-1710100211);
            boolean z11 = ((((i11 & 14) ^ 6) > 4 && iVar.O(bVar)) || (i11 & 6) == 4) | ((((i11 & 112) ^ 48) > 32 && iVar.a(z10)) || (i11 & 48) == 32);
            Object y10 = iVar.y();
            if (z11 || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new BoxMeasurePolicy(bVar, z10);
                iVar.p(y10);
            }
            tVar = (BoxMeasurePolicy) y10;
            iVar.K();
        } else {
            iVar.P(-1710139705);
            iVar.K();
            tVar = f2814c;
        }
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return tVar;
    }
}
