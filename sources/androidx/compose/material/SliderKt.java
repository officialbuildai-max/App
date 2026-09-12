package androidx.compose.material;

import androidx.compose.animation.core.r0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e0;
import androidx.compose.foundation.v;
import androidx.compose.material.l;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.s;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.t4;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.input.pointer.l0;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.mvel2.ast.ASTNode;

/* loaded from: classes.dex */
public abstract class SliderKt {

    /* renamed from: a, reason: collision with root package name */
    private static final float f3450a = o0.i.g(10);

    /* renamed from: b, reason: collision with root package name */
    private static final float f3451b = o0.i.g(24);

    /* renamed from: c, reason: collision with root package name */
    private static final float f3452c = o0.i.g(1);

    /* renamed from: d, reason: collision with root package name */
    private static final float f3453d = o0.i.g(6);

    /* renamed from: e, reason: collision with root package name */
    private static final float f3454e = o0.i.g(4);

    /* renamed from: f, reason: collision with root package name */
    private static final float f3455f;

    /* renamed from: g, reason: collision with root package name */
    private static final float f3456g;

    /* renamed from: h, reason: collision with root package name */
    private static final androidx.compose.ui.f f3457h;

    /* renamed from: i, reason: collision with root package name */
    private static final r0 f3458i;

    static {
        float g11 = o0.i.g(48);
        f3455f = g11;
        float g12 = o0.i.g(144);
        f3456g = g12;
        f3457h = SizeKt.g(SizeKt.n(androidx.compose.ui.f.f4253a, g12, 0.0f, 2, null), 0.0f, g11, 1, null);
        f3458i = new r0(100, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final Function1 function1, final ClosedFloatingPointRange closedFloatingPointRange, final ClosedFloatingPointRange closedFloatingPointRange2, final i1 i1Var, final float f11, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i g11 = iVar.g(-743965752);
        if ((i11 & 6) == 0) {
            i12 = (g11.A(function1) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.O(closedFloatingPointRange) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= g11.O(closedFloatingPointRange2) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= g11.O(i1Var) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= g11.b(f11) ? 16384 : 8192;
        }
        if ((i12 & 9363) == 9362 && g11.h()) {
            g11.G();
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-743965752, i12, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:847)");
            }
            boolean z10 = ((i12 & 112) == 32) | ((i12 & 14) == 4) | ((57344 & i12) == 16384) | ((i12 & 7168) == 2048) | ((i12 & 896) == 256);
            Object y10 = g11.y();
            if (z10 || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new Function0<Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m75invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m75invoke() {
                        float floatValue = (((Number) closedFloatingPointRange.e()).floatValue() - ((Number) closedFloatingPointRange.j()).floatValue()) / 1000;
                        float floatValue2 = ((Number) function1.invoke(Float.valueOf(f11))).floatValue();
                        if (Math.abs(floatValue2 - ((Number) i1Var.getValue()).floatValue()) <= floatValue || !closedFloatingPointRange2.a((Comparable) i1Var.getValue())) {
                            return;
                        }
                        i1Var.setValue(Float.valueOf(floatValue2));
                    }
                };
                g11.p(y10);
            }
            g0.e((Function0) y10, g11, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$2
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

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    SliderKt.a(function1, closedFloatingPointRange, closedFloatingPointRange2, i1Var, f11, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final kotlin.ranges.ClosedFloatingPointRange r40, final kotlin.jvm.functions.Function1 r41, androidx.compose.ui.f r42, boolean r43, kotlin.ranges.ClosedFloatingPointRange r44, int r45, kotlin.jvm.functions.Function0 r46, androidx.compose.material.j r47, androidx.compose.runtime.i r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 637
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.b(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.f, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material.j, androidx.compose.runtime.i, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final boolean z10, final float f11, final float f12, final List list, final j jVar, final float f13, final p.i iVar, final p.i iVar2, final androidx.compose.ui.f fVar, final androidx.compose.ui.f fVar2, final androidx.compose.ui.f fVar3, androidx.compose.runtime.i iVar3, final int i11, final int i12) {
        int i13;
        int i14;
        androidx.compose.runtime.i iVar4;
        androidx.compose.runtime.i g11 = iVar3.g(-278895713);
        if ((i11 & 6) == 0) {
            i13 = (g11.a(z10) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= g11.b(f11) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i13 |= g11.b(f12) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= g11.A(list) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= g11.O(jVar) ? 16384 : 8192;
        }
        if ((i11 & 196608) == 0) {
            i13 |= g11.b(f13) ? 131072 : 65536;
        }
        if ((i11 & 1572864) == 0) {
            i13 |= g11.O(iVar) ? 1048576 : 524288;
        }
        if ((i11 & 12582912) == 0) {
            i13 |= g11.O(iVar2) ? 8388608 : 4194304;
        }
        if ((i11 & 100663296) == 0) {
            i13 |= g11.O(fVar) ? 67108864 : ASTNode.PCTX_STORED;
        }
        if ((i11 & 805306368) == 0) {
            i13 |= g11.O(fVar2) ? ASTNode.DISCARD : ASTNode.DEOP;
        }
        if ((i12 & 6) == 0) {
            i14 = i12 | (g11.O(fVar3) ? 4 : 2);
        } else {
            i14 = i12;
        }
        if ((i13 & 306783379) == 306783378 && (i14 & 3) == 2 && g11.h()) {
            g11.G();
            iVar4 = g11;
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-278895713, i13, i14, "androidx.compose.material.RangeSliderImpl (Slider.kt:633)");
            }
            l.a aVar = l.f3495a;
            final String a11 = m.a(aVar.g(), g11, 6);
            final String a12 = m.a(aVar.f(), g11, 6);
            androidx.compose.ui.f e11 = fVar.e(f3457h);
            b.a aVar2 = androidx.compose.ui.b.f4162a;
            t h11 = BoxKt.h(aVar2.m(), false);
            int a13 = androidx.compose.runtime.g.a(g11, 0);
            s n11 = g11.n();
            androidx.compose.ui.f e12 = ComposedModifierKt.e(g11, e11);
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a14 = companion.a();
            if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            g11.C();
            if (g11.e()) {
                g11.F(a14);
            } else {
                g11.o();
            }
            androidx.compose.runtime.i a15 = f3.a(g11);
            f3.b(a15, h11, companion.c());
            f3.b(a15, n11, companion.e());
            Function2 b11 = companion.b();
            if (a15.e() || !Intrinsics.c(a15.y(), Integer.valueOf(a13))) {
                a15.p(Integer.valueOf(a13));
                a15.k(Integer.valueOf(a13), b11);
            }
            f3.b(a15, e12, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2819a;
            o0.e eVar = (o0.e) g11.l(CompositionLocalsKt.c());
            float E0 = eVar.E0(f3454e);
            float f14 = f3450a;
            float E02 = eVar.E0(f14);
            float y02 = eVar.y0(f13);
            float g12 = o0.i.g(f14 * 2);
            float g13 = o0.i.g(y02 * f11);
            float g14 = o0.i.g(y02 * f12);
            f.a aVar3 = androidx.compose.ui.f.f4253a;
            androidx.compose.ui.f b12 = SizeKt.b(boxScopeInstance.b(aVar3, aVar2.g()), 0.0f, 1, null);
            int i15 = i13 >> 9;
            int i16 = i13 << 6;
            int i17 = i13;
            e(b12, jVar, z10, f11, f12, list, E02, E0, g11, (i16 & 896) | (i15 & 112) | (i16 & 7168) | (i16 & 57344) | (i16 & 458752));
            iVar4 = g11;
            boolean O = iVar4.O(a11);
            Object y10 = iVar4.y();
            if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new Function1<androidx.compose.ui.semantics.n, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((androidx.compose.ui.semantics.n) obj);
                        return Unit.f67184a;
                    }

                    public final void invoke(androidx.compose.ui.semantics.n nVar) {
                        SemanticsPropertiesKt.v(nVar, a11);
                    }
                };
                iVar4.p(y10);
            }
            int i18 = i17 & 57344;
            int i19 = (i17 << 15) & 458752;
            d(boxScopeInstance, FocusableKt.a(androidx.compose.ui.semantics.k.b(aVar3, true, (Function1) y10), true, iVar).e(fVar2), g13, iVar, jVar, z10, g12, iVar4, (i15 & 7168) | 1572870 | i18 | i19);
            boolean O2 = iVar4.O(a12);
            Object y11 = iVar4.y();
            if (O2 || y11 == androidx.compose.runtime.i.f3811a.a()) {
                y11 = new Function1<androidx.compose.ui.semantics.n, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((androidx.compose.ui.semantics.n) obj);
                        return Unit.f67184a;
                    }

                    public final void invoke(androidx.compose.ui.semantics.n nVar) {
                        SemanticsPropertiesKt.v(nVar, a12);
                    }
                };
                iVar4.p(y11);
            }
            d(boxScopeInstance, FocusableKt.a(androidx.compose.ui.semantics.k.b(aVar3, true, (Function1) y11), true, iVar2).e(fVar3), g14, iVar2, jVar, z10, g12, iVar4, ((i17 >> 12) & 7168) | 1572870 | i18 | i19);
            iVar4.r();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = iVar4.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$2
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

                public final void invoke(androidx.compose.runtime.i iVar5, int i20) {
                    SliderKt.c(z10, f11, f12, list, jVar, f13, iVar, iVar2, fVar, fVar2, fVar3, iVar5, v1.a(i11 | 1), v1.a(i12));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final androidx.compose.foundation.layout.f fVar, final androidx.compose.ui.f fVar2, final float f11, final p.i iVar, final j jVar, final boolean z10, final float f12, androidx.compose.runtime.i iVar2, final int i11) {
        int i12;
        androidx.compose.runtime.i g11 = iVar2.g(428907178);
        if ((i11 & 6) == 0) {
            i12 = (g11.O(fVar) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.O(fVar2) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= g11.b(f11) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= g11.O(iVar) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= g11.O(jVar) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= g11.a(z10) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= g11.b(f12) ? 1048576 : 524288;
        }
        int i13 = i12;
        if ((599187 & i13) == 599186 && g11.h()) {
            g11.G();
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(428907178, i13, -1, "androidx.compose.material.SliderThumb (Slider.kt:696)");
            }
            androidx.compose.ui.f i14 = PaddingKt.i(androidx.compose.ui.f.f4253a, f11, 0.0f, 0.0f, 0.0f, 14, null);
            b.a aVar = androidx.compose.ui.b.f4162a;
            androidx.compose.ui.f b11 = fVar.b(i14, aVar.g());
            t h11 = BoxKt.h(aVar.m(), false);
            int a11 = androidx.compose.runtime.g.a(g11, 0);
            s n11 = g11.n();
            androidx.compose.ui.f e11 = ComposedModifierKt.e(g11, b11);
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
            f3.b(a13, h11, companion.c());
            f3.b(a13, n11, companion.e());
            Function2 b12 = companion.b();
            if (a13.e() || !Intrinsics.c(a13.y(), Integer.valueOf(a11))) {
                a13.p(Integer.valueOf(a11));
                a13.k(Integer.valueOf(a11), b12);
            }
            f3.b(a13, e11, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2819a;
            Object y10 = g11.y();
            i.a aVar2 = androidx.compose.runtime.i.f3811a;
            if (y10 == aVar2.a()) {
                y10 = r2.d();
                g11.p(y10);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) y10;
            boolean z11 = (i13 & 7168) == 2048;
            Object y11 = g11.y();
            if (z11 || y11 == aVar2.a()) {
                y11 = new SliderKt$SliderThumb$1$1$1(iVar, snapshotStateList, null);
                g11.p(y11);
            }
            int i15 = i13 >> 9;
            g0.d(iVar, (Function2) y11, g11, i15 & 14);
            e0.a(BackgroundKt.a(androidx.compose.ui.draw.l.b(v.b(IndicationKt.b(SizeKt.k(fVar2, f12, f12), iVar, RippleKt.f(false, f3451b, 0L, g11, 54, 4)), iVar, false, 2, null), z10 ? !snapshotStateList.isEmpty() ? f3453d : f3452c : o0.i.g(0), q.g.e(), false, 0L, 0L, 24, null), ((u1) jVar.c(z10, g11, ((i13 >> 15) & 14) | (i15 & 112)).getValue()).u(), q.g.e()), g11, 0);
            g11.r();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderThumb$2
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

                public final void invoke(androidx.compose.runtime.i iVar3, int i16) {
                    SliderKt.d(androidx.compose.foundation.layout.f.this, fVar2, f11, iVar, jVar, z10, f12, iVar3, v1.a(i11 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final androidx.compose.ui.f fVar, final j jVar, final boolean z10, final float f11, final float f12, final List list, final float f13, final float f14, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        int i13;
        androidx.compose.runtime.i iVar2;
        androidx.compose.runtime.i g11 = iVar.g(1833126050);
        if ((i11 & 6) == 0) {
            i12 = (g11.O(fVar) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.O(jVar) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= g11.a(z10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= g11.b(f11) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= g11.b(f12) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= g11.A(list) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= g11.b(f13) ? 1048576 : 524288;
        }
        if ((12582912 & i11) == 0) {
            i12 |= g11.b(f14) ? 8388608 : 4194304;
        }
        if ((i12 & 4793491) == 4793490 && g11.h()) {
            g11.G();
            iVar2 = g11;
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(1833126050, i12, -1, "androidx.compose.material.Track (Slider.kt:747)");
            }
            int i14 = ((i12 >> 6) & 14) | 48 | ((i12 << 3) & 896);
            final a3 b11 = jVar.b(z10, false, g11, i14);
            final a3 b12 = jVar.b(z10, true, g11, i14);
            final a3 a11 = jVar.a(z10, false, g11, i14);
            final a3 a12 = jVar.a(z10, true, g11, i14);
            boolean O = ((29360128 & i12) == 8388608) | ((i12 & 3670016) == 1048576) | g11.O(b11) | ((57344 & i12) == 16384) | ((i12 & 7168) == 2048) | g11.O(b12) | g11.A(list) | g11.O(a11) | g11.O(a12);
            Object y10 = g11.y();
            if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                i13 = i12;
                iVar2 = g11;
                Object obj = new Function1<z.g, Unit>() { // from class: androidx.compose.material.SliderKt$Track$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((z.g) obj2);
                        return Unit.f67184a;
                    }

                    public final void invoke(z.g gVar) {
                        boolean z11 = gVar.getLayoutDirection() == LayoutDirection.Rtl;
                        long a13 = y.h.a(f13, y.g.n(gVar.O0()));
                        long a14 = y.h.a(y.m.i(gVar.i()) - f13, y.g.n(gVar.O0()));
                        long j11 = z11 ? a14 : a13;
                        if (!z11) {
                            a13 = a14;
                        }
                        long u11 = ((u1) b11.getValue()).u();
                        float f15 = f14;
                        c5.a aVar = c5.f4393a;
                        long j12 = j11;
                        z.f.f(gVar, u11, j11, a13, f15, aVar.b(), null, 0.0f, null, 0, 480, null);
                        z.f.f(gVar, ((u1) b12.getValue()).u(), y.h.a(y.g.m(j12) + ((y.g.m(a13) - y.g.m(j12)) * f11), y.g.n(gVar.O0())), y.h.a(y.g.m(j12) + ((y.g.m(a13) - y.g.m(j12)) * f12), y.g.n(gVar.O0())), f14, aVar.b(), null, 0.0f, null, 0, 480, null);
                        List<Float> list2 = list;
                        float f16 = f12;
                        float f17 = f11;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Object obj2 : list2) {
                            float floatValue = ((Number) obj2).floatValue();
                            Boolean valueOf = Boolean.valueOf(floatValue > f16 || floatValue < f17);
                            Object obj3 = linkedHashMap.get(valueOf);
                            if (obj3 == null) {
                                obj3 = new ArrayList();
                                linkedHashMap.put(valueOf, obj3);
                            }
                            ((List) obj3).add(obj2);
                        }
                        a3 a3Var = a11;
                        a3 a3Var2 = a12;
                        float f18 = f14;
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                            List list3 = (List) entry.getValue();
                            ArrayList arrayList = new ArrayList(list3.size());
                            int size = list3.size();
                            for (int i15 = 0; i15 < size; i15++) {
                                arrayList.add(y.g.d(y.h.a(y.g.m(y.h.e(j12, a13, ((Number) list3.get(i15)).floatValue())), y.g.n(gVar.O0()))));
                            }
                            z.f.h(gVar, arrayList, t4.f4726a.b(), ((u1) (booleanValue ? a3Var : a3Var2).getValue()).u(), f18, c5.f4393a.b(), null, 0.0f, null, 0, 480, null);
                        }
                    }
                };
                iVar2.p(obj);
                y10 = obj;
            } else {
                i13 = i12;
                iVar2 = g11;
            }
            CanvasKt.a(fVar, (Function1) y10, iVar2, i13 & 14);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = iVar2.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$Track$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar3, int i15) {
                    SliderKt.e(androidx.compose.ui.f.this, jVar, z10, f11, f12, list, f13, f14, iVar3, v1.a(i11 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object r(androidx.compose.ui.input.pointer.c r8, long r9, int r11, kotlin.coroutines.Continuation r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material.SliderKt$awaitSlop$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = (androidx.compose.material.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = new androidx.compose.material.SliderKt$awaitSlop$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r6.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.b(r12)
            goto L55
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.b(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1 r5 = new androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
            r5.<init>()
            r6.L$0 = r12
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material.DragGestureDetectorCopyKt.a(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L52
            return r0
        L52:
            r7 = r12
            r12 = r8
            r8 = r7
        L55:
            androidx.compose.ui.input.pointer.w r12 = (androidx.compose.ui.input.pointer.w) r12
            if (r12 == 0) goto L64
            float r8 = r8.element
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.c(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.a(r12, r8)
            goto L65
        L64:
            r8 = 0
        L65:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.r(androidx.compose.ui.input.pointer.c, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float s(float f11, float f12, float f13) {
        float f14 = f12 - f11;
        float f15 = f14 == 0.0f ? 0.0f : (f13 - f11) / f14;
        float f16 = f15 >= 0.0f ? f15 : 0.0f;
        if (f16 > 1.0f) {
            return 1.0f;
        }
        return f16;
    }

    public static final float t() {
        return f3450a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.f u(androidx.compose.ui.f fVar, p.i iVar, p.i iVar2, a3 a3Var, a3 a3Var2, boolean z10, boolean z11, float f11, ClosedFloatingPointRange closedFloatingPointRange, a3 a3Var3, a3 a3Var4) {
        return z10 ? l0.d(fVar, new Object[]{iVar, iVar2, Float.valueOf(f11), Boolean.valueOf(z11), closedFloatingPointRange}, new SliderKt$rangeSliderPressDragModifier$1(iVar, iVar2, a3Var, a3Var2, a3Var4, z11, f11, a3Var3, null)) : fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float v(float f11, float f12, float f13, float f14, float f15) {
        return q0.b.b(f14, f15, s(f11, f12, f13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange w(float f11, float f12, ClosedFloatingPointRange closedFloatingPointRange, float f13, float f14) {
        return RangesKt.b(v(f11, f12, ((Number) closedFloatingPointRange.j()).floatValue(), f13, f14), v(f11, f12, ((Number) closedFloatingPointRange.e()).floatValue(), f13, f14));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.f x(androidx.compose.ui.f fVar, float f11, final boolean z10, final Function1 function1, final Function0 function0, final ClosedFloatingPointRange closedFloatingPointRange, final int i11) {
        final float l11 = RangesKt.l(f11, ((Number) closedFloatingPointRange.j()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
        return ProgressSemanticsKt.a(androidx.compose.ui.semantics.k.c(fVar, false, new Function1<androidx.compose.ui.semantics.n, Unit>() { // from class: androidx.compose.material.SliderKt$sliderSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((androidx.compose.ui.semantics.n) obj);
                return Unit.f67184a;
            }

            public final void invoke(androidx.compose.ui.semantics.n nVar) {
                if (!z10) {
                    SemanticsPropertiesKt.f(nVar);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i12 = i11;
                final float f12 = l11;
                final Function1<Float, Unit> function12 = function1;
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.z(nVar, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material.SliderKt$sliderSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public final Boolean invoke(float f13) {
                        int i13;
                        float l12 = RangesKt.l(f13, ((Number) closedFloatingPointRange2.j()).floatValue(), ((Number) closedFloatingPointRange2.e()).floatValue());
                        int i14 = i12;
                        boolean z11 = false;
                        if (i14 > 0 && (i13 = i14 + 1) >= 0) {
                            float f14 = l12;
                            float f15 = f14;
                            int i15 = 0;
                            while (true) {
                                float b11 = q0.b.b(((Number) closedFloatingPointRange2.j()).floatValue(), ((Number) closedFloatingPointRange2.e()).floatValue(), i15 / (i12 + 1));
                                float f16 = b11 - l12;
                                if (Math.abs(f16) <= f14) {
                                    f14 = Math.abs(f16);
                                    f15 = b11;
                                }
                                if (i15 == i13) {
                                    break;
                                }
                                i15++;
                            }
                            l12 = f15;
                        }
                        if (l12 != f12) {
                            function12.invoke(Float.valueOf(l12));
                            Function0<Unit> function03 = function02;
                            if (function03 != null) {
                                function03.invoke();
                            }
                            z11 = true;
                        }
                        return Boolean.valueOf(z11);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).floatValue());
                    }
                }, 1, null);
            }
        }, 1, null), f11, closedFloatingPointRange, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float y(float f11, List list, float f12, float f13) {
        Object obj;
        if (list.isEmpty()) {
            obj = null;
        } else {
            Object obj2 = list.get(0);
            float abs = Math.abs(q0.b.b(f12, f13, ((Number) obj2).floatValue()) - f11);
            int n11 = CollectionsKt.n(list);
            int i11 = 1;
            if (1 <= n11) {
                while (true) {
                    Object obj3 = list.get(i11);
                    float abs2 = Math.abs(q0.b.b(f12, f13, ((Number) obj3).floatValue()) - f11);
                    if (Float.compare(abs, abs2) > 0) {
                        obj2 = obj3;
                        abs = abs2;
                    }
                    if (i11 == n11) {
                        break;
                    }
                    i11++;
                }
            }
            obj = obj2;
        }
        Float f14 = (Float) obj;
        return f14 != null ? q0.b.b(f12, f13, f14.floatValue()) : f11;
    }

    private static final List z(int i11) {
        if (i11 == 0) {
            return CollectionsKt.l();
        }
        int i12 = i11 + 2;
        ArrayList arrayList = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            arrayList.add(Float.valueOf(i13 / (i11 + 1)));
        }
        return arrayList;
    }
}
