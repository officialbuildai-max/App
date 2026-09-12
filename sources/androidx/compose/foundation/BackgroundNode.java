package androidx.compose.foundation;

import androidx.compose.ui.f;
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.l4;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.v4;
import androidx.compose.ui.node.u0;
import androidx.compose.ui.node.v0;
import androidx.compose.ui.unit.LayoutDirection;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
final class BackgroundNode extends f.c implements androidx.compose.ui.node.n, u0 {

    /* renamed from: n, reason: collision with root package name */
    private long f2623n;

    /* renamed from: o, reason: collision with root package name */
    private j1 f2624o;

    /* renamed from: p, reason: collision with root package name */
    private float f2625p;

    /* renamed from: q, reason: collision with root package name */
    private a5 f2626q;

    /* renamed from: r, reason: collision with root package name */
    private long f2627r;

    /* renamed from: s, reason: collision with root package name */
    private LayoutDirection f2628s;

    /* renamed from: t, reason: collision with root package name */
    private k4 f2629t;

    /* renamed from: u, reason: collision with root package name */
    private a5 f2630u;

    private BackgroundNode(long j11, j1 j1Var, float f11, a5 a5Var) {
        this.f2623n = j11;
        this.f2624o = j1Var;
        this.f2625p = f11;
        this.f2626q = a5Var;
        this.f2627r = y.m.f78614b.a();
    }

    public /* synthetic */ BackgroundNode(long j11, j1 j1Var, float f11, a5 a5Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j1Var, f11, a5Var);
    }

    private final void D1(z.c cVar) {
        k4 F1 = F1(cVar);
        if (!u1.m(this.f2623n, u1.f4733b.e())) {
            l4.d(cVar, F1, this.f2623n, 0.0f, null, null, 0, 60, null);
        }
        j1 j1Var = this.f2624o;
        if (j1Var != null) {
            l4.b(cVar, F1, j1Var, this.f2625p, null, null, 0, 56, null);
        }
    }

    private final void E1(z.c cVar) {
        if (!u1.m(this.f2623n, u1.f4733b.e())) {
            z.f.j(cVar, this.f2623n, 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        j1 j1Var = this.f2624o;
        if (j1Var != null) {
            z.f.i(cVar, j1Var, 0L, 0L, this.f2625p, null, null, 0, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.lang.Object, androidx.compose.ui.graphics.k4] */
    private final k4 F1(final z.c cVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (y.m.f(cVar.i(), this.f2627r) && cVar.getLayoutDirection() == this.f2628s && Intrinsics.c(this.f2630u, this.f2626q)) {
            ?? r12 = this.f2629t;
            Intrinsics.e(r12);
            objectRef.element = r12;
        } else {
            v0.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.BackgroundNode$getOutline$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m20invoke();
                    return Unit.f67184a;
                }

                /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.compose.ui.graphics.k4] */
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m20invoke() {
                    objectRef.element = this.G1().a(cVar.i(), cVar.getLayoutDirection(), cVar);
                }
            });
        }
        this.f2629t = (k4) objectRef.element;
        this.f2627r = cVar.i();
        this.f2628s = cVar.getLayoutDirection();
        this.f2630u = this.f2626q;
        T t11 = objectRef.element;
        Intrinsics.e(t11);
        return (k4) t11;
    }

    public final void A0(a5 a5Var) {
        this.f2626q = a5Var;
    }

    public final a5 G1() {
        return this.f2626q;
    }

    public final void H1(j1 j1Var) {
        this.f2624o = j1Var;
    }

    public final void I1(long j11) {
        this.f2623n = j11;
    }

    @Override // androidx.compose.ui.node.u0
    public void Z() {
        this.f2627r = y.m.f78614b.a();
        this.f2628s = null;
        this.f2629t = null;
        this.f2630u = null;
        androidx.compose.ui.node.o.a(this);
    }

    @Override // androidx.compose.ui.node.n
    public void n(z.c cVar) {
        if (this.f2626q == v4.a()) {
            E1(cVar);
        } else {
            D1(cVar);
        }
        cVar.Y0();
    }

    public final void setAlpha(float f11) {
        this.f2625p = f11;
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void w0() {
        androidx.compose.ui.node.m.a(this);
    }
}
