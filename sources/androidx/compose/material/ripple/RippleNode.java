package androidx.compose.material.ripple;

import androidx.collection.l0;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.layout.l;
import androidx.compose.ui.node.n;
import androidx.compose.ui.node.o;
import androidx.compose.ui.node.v;
import androidx.compose.ui.node.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.n0;
import o0.u;
import p.k;
import y.m;

/* loaded from: classes.dex */
public abstract class RippleNode extends f.c implements androidx.compose.ui.node.d, n, w {

    /* renamed from: n, reason: collision with root package name */
    private final p.g f3547n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f3548o;

    /* renamed from: p, reason: collision with root package name */
    private final float f3549p;

    /* renamed from: q, reason: collision with root package name */
    private final x1 f3550q;

    /* renamed from: r, reason: collision with root package name */
    private final Function0 f3551r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f3552s;

    /* renamed from: t, reason: collision with root package name */
    private StateLayer f3553t;

    /* renamed from: u, reason: collision with root package name */
    private float f3554u;

    /* renamed from: v, reason: collision with root package name */
    private long f3555v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3556w;

    /* renamed from: x, reason: collision with root package name */
    private final l0 f3557x;

    private RippleNode(p.g gVar, boolean z10, float f11, x1 x1Var, Function0 function0) {
        this.f3547n = gVar;
        this.f3548o = z10;
        this.f3549p = f11;
        this.f3550q = x1Var;
        this.f3551r = function0;
        this.f3555v = m.f78614b.b();
        this.f3557x = new l0(0, 1, null);
    }

    public /* synthetic */ RippleNode(p.g gVar, boolean z10, float f11, x1 x1Var, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, z10, f11, x1Var, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(p.k kVar) {
        if (kVar instanceof k.b) {
            I1((k.b) kVar, this.f3555v, this.f3554u);
        } else if (kVar instanceof k.c) {
            P1(((k.c) kVar).a());
        } else if (kVar instanceof k.a) {
            P1(((k.a) kVar).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(p.f fVar, n0 n0Var) {
        StateLayer stateLayer = this.f3553t;
        if (stateLayer == null) {
            stateLayer = new StateLayer(this.f3548o, this.f3551r);
            o.a(this);
            this.f3553t = stateLayer;
        }
        stateLayer.c(fVar, n0Var);
    }

    @Override // androidx.compose.ui.node.w
    public void F(long j11) {
        this.f3556w = true;
        o0.e i11 = androidx.compose.ui.node.g.i(this);
        this.f3555v = u.d(j11);
        this.f3554u = Float.isNaN(this.f3549p) ? d.a(i11, this.f3548o, this.f3555v) : i11.E0(this.f3549p);
        l0 l0Var = this.f3557x;
        Object[] objArr = l0Var.f2319a;
        int i12 = l0Var.f2320b;
        for (int i13 = 0; i13 < i12; i13++) {
            O1((p.k) objArr[i13]);
        }
        this.f3557x.f();
    }

    @Override // androidx.compose.ui.node.w
    public /* synthetic */ void I(l lVar) {
        v.a(this, lVar);
    }

    public abstract void I1(k.b bVar, long j11, float f11);

    public abstract void J1(z.g gVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean K1() {
        return this.f3548o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function0 L1() {
        return this.f3551r;
    }

    public final long M1() {
        return this.f3550q.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long N1() {
        return this.f3555v;
    }

    public abstract void P1(k.b bVar);

    @Override // androidx.compose.ui.f.c
    public final boolean i1() {
        return this.f3552s;
    }

    @Override // androidx.compose.ui.node.n
    public void n(z.c cVar) {
        cVar.Y0();
        StateLayer stateLayer = this.f3553t;
        if (stateLayer != null) {
            stateLayer.b(cVar, this.f3554u, M1());
        }
        J1(cVar);
    }

    @Override // androidx.compose.ui.f.c
    public void n1() {
        kotlinx.coroutines.k.d(d1(), null, null, new RippleNode$onAttach$1(this, null), 3, null);
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void w0() {
        androidx.compose.ui.node.m.a(this);
    }
}
