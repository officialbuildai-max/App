package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.t1;
import androidx.compose.ui.graphics.u1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import y.m;

/* loaded from: classes.dex */
public final class RippleAnimation {

    /* renamed from: a, reason: collision with root package name */
    private y.g f3522a;

    /* renamed from: b, reason: collision with root package name */
    private final float f3523b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3524c;

    /* renamed from: d, reason: collision with root package name */
    private Float f3525d;

    /* renamed from: e, reason: collision with root package name */
    private y.g f3526e;

    /* renamed from: f, reason: collision with root package name */
    private final Animatable f3527f;

    /* renamed from: g, reason: collision with root package name */
    private final Animatable f3528g;

    /* renamed from: h, reason: collision with root package name */
    private final Animatable f3529h;

    /* renamed from: i, reason: collision with root package name */
    private final w f3530i;

    /* renamed from: j, reason: collision with root package name */
    private final i1 f3531j;

    /* renamed from: k, reason: collision with root package name */
    private final i1 f3532k;

    private RippleAnimation(y.g gVar, float f11, boolean z10) {
        i1 c11;
        i1 c12;
        this.f3522a = gVar;
        this.f3523b = f11;
        this.f3524c = z10;
        this.f3527f = androidx.compose.animation.core.a.b(0.0f, 0.0f, 2, null);
        this.f3528g = androidx.compose.animation.core.a.b(0.0f, 0.0f, 2, null);
        this.f3529h = androidx.compose.animation.core.a.b(0.0f, 0.0f, 2, null);
        this.f3530i = y.a(null);
        Boolean bool = Boolean.FALSE;
        c11 = u2.c(bool, null, 2, null);
        this.f3531j = c11;
        c12 = u2.c(bool, null, 2, null);
        this.f3532k = c12;
    }

    public /* synthetic */ RippleAnimation(y.g gVar, float f11, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, f11, z10);
    }

    private final Object f(Continuation continuation) {
        Object e11 = o0.e(new RippleAnimation$fadeIn$2(this, null), continuation);
        return e11 == IntrinsicsKt.f() ? e11 : Unit.f67184a;
    }

    private final Object g(Continuation continuation) {
        Object e11 = o0.e(new RippleAnimation$fadeOut$2(this, null), continuation);
        return e11 == IntrinsicsKt.f() ? e11 : Unit.f67184a;
    }

    private final boolean i() {
        return ((Boolean) this.f3532k.getValue()).booleanValue();
    }

    private final boolean j() {
        return ((Boolean) this.f3531j.getValue()).booleanValue();
    }

    private final void k(boolean z10) {
        this.f3532k.setValue(Boolean.valueOf(z10));
    }

    private final void l(boolean z10) {
        this.f3531j.setValue(Boolean.valueOf(z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.material.ripple.RippleAnimation$animate$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation$animate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r7)
            goto L72
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            java.lang.Object r2 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.b(r7)
            goto L66
        L3f:
            java.lang.Object r2 = r0.L$0
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.b(r7)
            goto L56
        L47:
            kotlin.ResultKt.b(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.f(r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r2 = r6
        L56:
            r2.l(r5)
            kotlinx.coroutines.w r7 = r2.f3530i
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.i(r0)
            if (r7 != r1) goto L66
            return r1
        L66:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r2.g(r0)
            if (r7 != r1) goto L72
            return r1
        L72:
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void e(z.g gVar, long j11) {
        if (this.f3525d == null) {
            this.f3525d = Float.valueOf(d.b(gVar.i()));
        }
        if (this.f3522a == null) {
            this.f3522a = y.g.d(gVar.O0());
        }
        if (this.f3526e == null) {
            this.f3526e = y.g.d(y.h.a(m.i(gVar.i()) / 2.0f, m.g(gVar.i()) / 2.0f));
        }
        float floatValue = (!i() || j()) ? ((Number) this.f3527f.k()).floatValue() : 1.0f;
        Float f11 = this.f3525d;
        Intrinsics.e(f11);
        float b11 = q0.b.b(f11.floatValue(), this.f3523b, ((Number) this.f3528g.k()).floatValue());
        y.g gVar2 = this.f3522a;
        Intrinsics.e(gVar2);
        float m11 = y.g.m(gVar2.v());
        y.g gVar3 = this.f3526e;
        Intrinsics.e(gVar3);
        float b12 = q0.b.b(m11, y.g.m(gVar3.v()), ((Number) this.f3529h.k()).floatValue());
        y.g gVar4 = this.f3522a;
        Intrinsics.e(gVar4);
        float n11 = y.g.n(gVar4.v());
        y.g gVar5 = this.f3526e;
        Intrinsics.e(gVar5);
        long a11 = y.h.a(b12, q0.b.b(n11, y.g.n(gVar5.v()), ((Number) this.f3529h.k()).floatValue()));
        long k11 = u1.k(j11, u1.n(j11) * floatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.f3524c) {
            z.f.d(gVar, k11, b11, a11, 0.0f, null, null, 0, 120, null);
            return;
        }
        float i11 = m.i(gVar.i());
        float g11 = m.g(gVar.i());
        int b13 = t1.f4722a.b();
        z.d H0 = gVar.H0();
        long i12 = H0.i();
        H0.e().n();
        try {
            H0.c().a(0.0f, 0.0f, i11, g11, b13);
            z.f.d(gVar, k11, b11, a11, 0.0f, null, null, 0, 120, null);
        } finally {
            H0.e().j();
            H0.f(i12);
        }
    }

    public final void h() {
        k(true);
        this.f3530i.n(Unit.f67184a);
    }
}
