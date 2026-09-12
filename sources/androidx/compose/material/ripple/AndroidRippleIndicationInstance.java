package androidx.compose.material.ripple;

import android.view.ViewGroup;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.b2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.h0;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.u1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.n0;
import p.k;
import y.m;

/* loaded from: classes.dex */
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements b2, e {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3503c;

    /* renamed from: d, reason: collision with root package name */
    private final float f3504d;

    /* renamed from: e, reason: collision with root package name */
    private final a3 f3505e;

    /* renamed from: f, reason: collision with root package name */
    private final a3 f3506f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewGroup f3507g;

    /* renamed from: h, reason: collision with root package name */
    private RippleContainer f3508h;

    /* renamed from: i, reason: collision with root package name */
    private final i1 f3509i;

    /* renamed from: j, reason: collision with root package name */
    private final i1 f3510j;

    /* renamed from: k, reason: collision with root package name */
    private long f3511k;

    /* renamed from: l, reason: collision with root package name */
    private int f3512l;

    /* renamed from: m, reason: collision with root package name */
    private final Function0 f3513m;

    private AndroidRippleIndicationInstance(boolean z10, float f11, a3 a3Var, a3 a3Var2, ViewGroup viewGroup) {
        super(z10, a3Var2);
        i1 c11;
        i1 c12;
        this.f3503c = z10;
        this.f3504d = f11;
        this.f3505e = a3Var;
        this.f3506f = a3Var2;
        this.f3507g = viewGroup;
        c11 = u2.c(null, null, 2, null);
        this.f3509i = c11;
        c12 = u2.c(Boolean.TRUE, null, 2, null);
        this.f3510j = c12;
        this.f3511k = m.f78614b.b();
        this.f3512l = -1;
        this.f3513m = new Function0<Unit>() { // from class: androidx.compose.material.ripple.AndroidRippleIndicationInstance$onInvalidateRipple$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m76invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m76invoke() {
                boolean i11;
                AndroidRippleIndicationInstance androidRippleIndicationInstance = AndroidRippleIndicationInstance.this;
                i11 = androidRippleIndicationInstance.i();
                androidRippleIndicationInstance.l(!i11);
            }
        };
    }

    public /* synthetic */ AndroidRippleIndicationInstance(boolean z10, float f11, a3 a3Var, a3 a3Var2, ViewGroup viewGroup, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, f11, a3Var, a3Var2, viewGroup);
    }

    private final void h() {
        RippleContainer rippleContainer = this.f3508h;
        if (rippleContainer != null) {
            rippleContainer.disposeRippleIfNeeded(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        return ((Boolean) this.f3510j.getValue()).booleanValue();
    }

    private final RippleContainer j() {
        RippleContainer c11;
        RippleContainer rippleContainer = this.f3508h;
        if (rippleContainer != null) {
            Intrinsics.e(rippleContainer);
            return rippleContainer;
        }
        c11 = j.c(this.f3507g);
        this.f3508h = c11;
        Intrinsics.e(c11);
        return c11;
    }

    private final RippleHostView k() {
        return (RippleHostView) this.f3509i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(boolean z10) {
        this.f3510j.setValue(Boolean.valueOf(z10));
    }

    private final void m(RippleHostView rippleHostView) {
        this.f3509i.setValue(rippleHostView);
    }

    @Override // androidx.compose.foundation.y
    public void a(z.c cVar) {
        this.f3511k = cVar.i();
        this.f3512l = Float.isNaN(this.f3504d) ? MathKt.d(d.a(cVar, this.f3503c, cVar.i())) : cVar.c0(this.f3504d);
        long u11 = ((u1) this.f3505e.getValue()).u();
        float d11 = ((c) this.f3506f.getValue()).d();
        cVar.Y0();
        c(cVar, this.f3504d, u11);
        m1 e11 = cVar.H0().e();
        i();
        RippleHostView k11 = k();
        if (k11 != null) {
            k11.m79setRippleProperties07v42R4(cVar.i(), u11, d11);
            k11.draw(h0.d(e11));
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void b(k.b bVar, n0 n0Var) {
        RippleHostView rippleHostView = j().getRippleHostView(this);
        rippleHostView.m78addRippleKOepWvA(bVar, this.f3503c, this.f3511k, this.f3512l, ((u1) this.f3505e.getValue()).u(), ((c) this.f3506f.getValue()).d(), this.f3513m);
        m(rippleHostView);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void d(k.b bVar) {
        RippleHostView k11 = k();
        if (k11 != null) {
            k11.removeRipple();
        }
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        h();
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        h();
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
    }

    @Override // androidx.compose.material.ripple.e
    public void u0() {
        m(null);
    }
}
