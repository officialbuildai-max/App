package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.f4;
import androidx.compose.ui.graphics.v1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o0.u;
import y.m;

/* loaded from: classes.dex */
public final class VectorComponent extends i {

    /* renamed from: b, reason: collision with root package name */
    private final GroupComponent f4793b;

    /* renamed from: c, reason: collision with root package name */
    private String f4794c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4795d;

    /* renamed from: e, reason: collision with root package name */
    private final a f4796e;

    /* renamed from: f, reason: collision with root package name */
    private Function0 f4797f;

    /* renamed from: g, reason: collision with root package name */
    private final i1 f4798g;

    /* renamed from: h, reason: collision with root package name */
    private v1 f4799h;

    /* renamed from: i, reason: collision with root package name */
    private final i1 f4800i;

    /* renamed from: j, reason: collision with root package name */
    private long f4801j;

    /* renamed from: k, reason: collision with root package name */
    private float f4802k;

    /* renamed from: l, reason: collision with root package name */
    private float f4803l;

    /* renamed from: m, reason: collision with root package name */
    private final Function1 f4804m;

    public VectorComponent(GroupComponent groupComponent) {
        super(null);
        i1 c11;
        i1 c12;
        this.f4793b = groupComponent;
        groupComponent.d(new Function1<i, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((i) obj);
                return Unit.f67184a;
            }

            public final void invoke(i iVar) {
                VectorComponent.this.h();
            }
        });
        this.f4794c = "";
        this.f4795d = true;
        this.f4796e = new a();
        this.f4797f = new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$invalidateCallback$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m113invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m113invoke() {
            }
        };
        c11 = u2.c(null, null, 2, null);
        this.f4798g = c11;
        m.a aVar = y.m.f78614b;
        c12 = u2.c(y.m.c(aVar.b()), null, 2, null);
        this.f4800i = c12;
        this.f4801j = aVar.a();
        this.f4802k = 1.0f;
        this.f4803l = 1.0f;
        this.f4804m = new Function1<z.g, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$drawVectorBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z.g) obj);
                return Unit.f67184a;
            }

            public final void invoke(z.g gVar) {
                float f11;
                float f12;
                GroupComponent l11 = VectorComponent.this.l();
                VectorComponent vectorComponent = VectorComponent.this;
                f11 = vectorComponent.f4802k;
                f12 = vectorComponent.f4803l;
                long c13 = y.g.f78593b.c();
                z.d H0 = gVar.H0();
                long i11 = H0.i();
                H0.e().n();
                try {
                    H0.c().e(f11, f12, c13);
                    l11.a(gVar);
                } finally {
                    H0.e().j();
                    H0.f(i11);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.f4795d = true;
        this.f4797f.invoke();
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public void a(z.g gVar) {
        i(gVar, 1.0f, null);
    }

    public final void i(z.g gVar, float f11, v1 v1Var) {
        int a11 = (this.f4793b.j() && this.f4793b.g() != 16 && k.f(k()) && k.f(v1Var)) ? f4.f4514b.a() : f4.f4514b.b();
        if (this.f4795d || !y.m.f(this.f4801j, gVar.i()) || !f4.i(a11, j())) {
            this.f4799h = f4.i(a11, f4.f4514b.a()) ? v1.a.b(v1.f4750b, this.f4793b.g(), 0, 2, null) : null;
            this.f4802k = y.m.i(gVar.i()) / y.m.i(m());
            this.f4803l = y.m.g(gVar.i()) / y.m.g(m());
            this.f4796e.b(a11, u.a((int) Math.ceil(y.m.i(gVar.i())), (int) Math.ceil(y.m.g(gVar.i()))), gVar, gVar.getLayoutDirection(), this.f4804m);
            this.f4795d = false;
            this.f4801j = gVar.i();
        }
        if (v1Var == null) {
            v1Var = k() != null ? k() : this.f4799h;
        }
        this.f4796e.c(gVar, f11, v1Var);
    }

    public final int j() {
        e4 d11 = this.f4796e.d();
        return d11 != null ? d11.b() : f4.f4514b.b();
    }

    public final v1 k() {
        return (v1) this.f4798g.getValue();
    }

    public final GroupComponent l() {
        return this.f4793b;
    }

    public final long m() {
        return ((y.m) this.f4800i.getValue()).m();
    }

    public final void n(v1 v1Var) {
        this.f4798g.setValue(v1Var);
    }

    public final void o(Function0 function0) {
        this.f4797f = function0;
    }

    public final void p(String str) {
        this.f4794c = str;
    }

    public final void q(long j11) {
        this.f4800i.setValue(y.m.c(j11));
    }

    public String toString() {
        String str = "Params: \tname: " + this.f4794c + "\n\tviewportWidth: " + y.m.i(m()) + "\n\tviewportHeight: " + y.m.g(m()) + "\n";
        Intrinsics.g(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }
}
