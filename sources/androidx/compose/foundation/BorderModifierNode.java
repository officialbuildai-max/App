package androidx.compose.foundation;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.t1;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class BorderModifierNode extends androidx.compose.ui.node.i {

    /* renamed from: p, reason: collision with root package name */
    private c f2631p;

    /* renamed from: q, reason: collision with root package name */
    private float f2632q;

    /* renamed from: r, reason: collision with root package name */
    private j1 f2633r;

    /* renamed from: s, reason: collision with root package name */
    private a5 f2634s;

    /* renamed from: t, reason: collision with root package name */
    private final androidx.compose.ui.draw.b f2635t;

    private BorderModifierNode(float f11, j1 j1Var, a5 a5Var) {
        this.f2632q = f11;
        this.f2633r = j1Var;
        this.f2634s = a5Var;
        this.f2635t = (androidx.compose.ui.draw.b) D1(androidx.compose.ui.draw.g.a(new Function1<androidx.compose.ui.draw.c, androidx.compose.ui.draw.h>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final androidx.compose.ui.draw.h invoke(androidx.compose.ui.draw.c cVar) {
                androidx.compose.ui.draw.h i11;
                androidx.compose.ui.draw.h j11;
                androidx.compose.ui.draw.h M1;
                androidx.compose.ui.draw.h L1;
                if (cVar.E0(BorderModifierNode.this.P1()) < 0.0f || y.m.h(cVar.i()) <= 0.0f) {
                    i11 = BorderKt.i(cVar);
                    return i11;
                }
                float f12 = 2;
                float min = Math.min(o0.i.i(BorderModifierNode.this.P1(), o0.i.f70726b.a()) ? 1.0f : (float) Math.ceil(cVar.E0(BorderModifierNode.this.P1())), (float) Math.ceil(y.m.h(cVar.i()) / f12));
                float f13 = min / f12;
                long a11 = y.h.a(f13, f13);
                long a12 = y.n.a(y.m.i(cVar.i()) - min, y.m.g(cVar.i()) - min);
                boolean z10 = f12 * min > y.m.h(cVar.i());
                k4 a13 = BorderModifierNode.this.O1().a(cVar.i(), cVar.getLayoutDirection(), cVar);
                if (a13 instanceof k4.a) {
                    BorderModifierNode borderModifierNode = BorderModifierNode.this;
                    L1 = borderModifierNode.L1(cVar, borderModifierNode.N1(), (k4.a) a13, z10, min);
                    return L1;
                }
                if (a13 instanceof k4.c) {
                    BorderModifierNode borderModifierNode2 = BorderModifierNode.this;
                    M1 = borderModifierNode2.M1(cVar, borderModifierNode2.N1(), (k4.c) a13, a11, a12, z10, min);
                    return M1;
                }
                if (!(a13 instanceof k4.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                j11 = BorderKt.j(cVar, BorderModifierNode.this.N1(), a11, a12, z10, min);
                return j11;
            }
        }));
    }

    public /* synthetic */ BorderModifierNode(float f11, j1 j1Var, a5 a5Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, j1Var, a5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d9, code lost:
    
        if (androidx.compose.ui.graphics.f4.h(r14, r6 != null ? androidx.compose.ui.graphics.f4.f(r6.b()) : null) != false) goto L26;
     */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [T, androidx.compose.ui.graphics.e4] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.draw.h L1(androidx.compose.ui.draw.c r48, final androidx.compose.ui.graphics.j1 r49, final androidx.compose.ui.graphics.k4.a r50, boolean r51, float r52) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.L1(androidx.compose.ui.draw.c, androidx.compose.ui.graphics.j1, androidx.compose.ui.graphics.k4$a, boolean, float):androidx.compose.ui.draw.h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final androidx.compose.ui.draw.h M1(androidx.compose.ui.draw.c cVar, final j1 j1Var, k4.c cVar2, final long j11, final long j12, final boolean z10, final float f11) {
        final Path h11;
        if (y.l.e(cVar2.b())) {
            final long h12 = cVar2.b().h();
            final float f12 = f11 / 2;
            final z.m mVar = new z.m(f11, 0.0f, 0, 0, null, 30, null);
            return cVar.v(new Function1<z.c, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((z.c) obj);
                    return Unit.f67184a;
                }

                public final void invoke(z.c cVar3) {
                    long k11;
                    long j13;
                    cVar3.Y0();
                    if (z10) {
                        z.f.k(cVar3, j1Var, 0L, 0L, h12, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float d11 = y.a.d(h12);
                    float f13 = f12;
                    if (d11 >= f13) {
                        j1 j1Var2 = j1Var;
                        long j14 = j11;
                        long j15 = j12;
                        k11 = BorderKt.k(h12, f13);
                        z.f.k(cVar3, j1Var2, j14, j15, k11, 0.0f, mVar, null, 0, Sdk$SDKError.Reason.INVALID_BID_PAYLOAD_VALUE, null);
                        return;
                    }
                    float f14 = f11;
                    float i11 = y.m.i(cVar3.i()) - f11;
                    float g11 = y.m.g(cVar3.i()) - f11;
                    int a11 = t1.f4722a.a();
                    j1 j1Var3 = j1Var;
                    long j16 = h12;
                    z.d H0 = cVar3.H0();
                    long i12 = H0.i();
                    H0.e().n();
                    try {
                        H0.c().a(f14, f14, i11, g11, a11);
                        j13 = i12;
                        try {
                            z.f.k(cVar3, j1Var3, 0L, 0L, j16, 0.0f, null, null, 0, 246, null);
                            H0.e().j();
                            H0.f(j13);
                        } catch (Throwable th2) {
                            th = th2;
                            H0.e().j();
                            H0.f(j13);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        j13 = i12;
                    }
                }
            });
        }
        if (this.f2631p == null) {
            this.f2631p = new c(null, null, null, null, 15, null);
        }
        c cVar3 = this.f2631p;
        Intrinsics.e(cVar3);
        h11 = BorderKt.h(cVar3.g(), cVar2.b(), f11, z10);
        return cVar.v(new Function1<z.c, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z.c) obj);
                return Unit.f67184a;
            }

            public final void invoke(z.c cVar4) {
                cVar4.Y0();
                z.f.g(cVar4, Path.this, j1Var, 0.0f, null, null, 0, 60, null);
            }
        });
    }

    public final void A0(a5 a5Var) {
        if (Intrinsics.c(this.f2634s, a5Var)) {
            return;
        }
        this.f2634s = a5Var;
        this.f2635t.o0();
    }

    public final j1 N1() {
        return this.f2633r;
    }

    public final a5 O1() {
        return this.f2634s;
    }

    public final float P1() {
        return this.f2632q;
    }

    public final void Q1(j1 j1Var) {
        if (Intrinsics.c(this.f2633r, j1Var)) {
            return;
        }
        this.f2633r = j1Var;
        this.f2635t.o0();
    }

    public final void R1(float f11) {
        if (o0.i.i(this.f2632q, f11)) {
            return;
        }
        this.f2632q = f11;
        this.f2635t.o0();
    }
}
