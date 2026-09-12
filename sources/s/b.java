package s;

import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.b2;
import androidx.compose.runtime.i2;
import androidx.compose.runtime.j2;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m;
import androidx.compose.runtime.m0;
import androidx.compose.runtime.x0;
import androidx.compose.runtime.y0;
import androidx.compose.runtime.z2;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: m, reason: collision with root package name */
    public static final a f74891m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    public static final int f74892n = 8;

    /* renamed from: a, reason: collision with root package name */
    private final ComposerImpl f74893a;

    /* renamed from: b, reason: collision with root package name */
    private s.a f74894b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f74895c;

    /* renamed from: f, reason: collision with root package name */
    private int f74898f;

    /* renamed from: g, reason: collision with root package name */
    private int f74899g;

    /* renamed from: l, reason: collision with root package name */
    private int f74904l;

    /* renamed from: d, reason: collision with root package name */
    private final m0 f74896d = new m0();

    /* renamed from: e, reason: collision with root package name */
    private boolean f74897e = true;

    /* renamed from: h, reason: collision with root package name */
    private z2 f74900h = new z2();

    /* renamed from: i, reason: collision with root package name */
    private int f74901i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f74902j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f74903k = -1;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(ComposerImpl composerImpl, s.a aVar) {
        this.f74893a = composerImpl;
        this.f74894b = aVar;
    }

    private final void A() {
        B();
    }

    private final void B() {
        int i11 = this.f74899g;
        if (i11 > 0) {
            this.f74894b.G(i11);
            this.f74899g = 0;
        }
        if (this.f74900h.d()) {
            this.f74894b.k(this.f74900h.i());
            this.f74900h.a();
        }
    }

    private final void C() {
        I(this, false, 1, null);
        K();
    }

    private final void D(boolean z10) {
        H(z10);
    }

    static /* synthetic */ void E(b bVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        bVar.D(z10);
    }

    private final void F(int i11, int i12, int i13) {
        A();
        this.f74894b.u(i11, i12, i13);
    }

    private final void G() {
        int i11 = this.f74904l;
        if (i11 > 0) {
            int i12 = this.f74901i;
            if (i12 >= 0) {
                J(i12, i11);
                this.f74901i = -1;
            } else {
                F(this.f74903k, this.f74902j, i11);
                this.f74902j = -1;
                this.f74903k = -1;
            }
            this.f74904l = 0;
        }
    }

    private final void H(boolean z10) {
        int u11 = z10 ? q().u() : q().k();
        int i11 = u11 - this.f74898f;
        if (!(i11 >= 0)) {
            k.r("Tried to seek backward");
        }
        if (i11 > 0) {
            this.f74894b.e(i11);
            this.f74898f = u11;
        }
    }

    static /* synthetic */ void I(b bVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        bVar.H(z10);
    }

    private final void J(int i11, int i12) {
        A();
        this.f74894b.x(i11, i12);
    }

    private final void k(androidx.compose.runtime.c cVar) {
        E(this, false, 1, null);
        this.f74894b.o(cVar);
        this.f74895c = true;
    }

    private final void l() {
        if (this.f74895c || !this.f74897e) {
            return;
        }
        E(this, false, 1, null);
        this.f74894b.p();
        this.f74895c = true;
    }

    private final i2 q() {
        return this.f74893a.E0();
    }

    public final void K() {
        i2 q11;
        int u11;
        if (q().x() <= 0 || this.f74896d.h(-2) == (u11 = (q11 = q()).u())) {
            return;
        }
        l();
        if (u11 > 0) {
            androidx.compose.runtime.c a11 = q11.a(u11);
            this.f74896d.j(u11);
            k(a11);
        }
    }

    public final void L() {
        B();
        if (this.f74895c) {
            U();
            j();
        }
    }

    public final void M(b2 b2Var) {
        this.f74894b.v(b2Var);
    }

    public final void N() {
        C();
        this.f74894b.w();
        this.f74898f += q().p();
    }

    public final void O(int i11, int i12) {
        if (i12 > 0) {
            if (!(i11 >= 0)) {
                k.r("Invalid remove index " + i11);
            }
            if (this.f74901i == i11) {
                this.f74904l += i12;
                return;
            }
            G();
            this.f74901i = i11;
            this.f74904l = i12;
        }
    }

    public final void P() {
        this.f74894b.y();
    }

    public final void Q() {
        this.f74895c = false;
        this.f74896d.a();
        this.f74898f = 0;
    }

    public final void R(s.a aVar) {
        this.f74894b = aVar;
    }

    public final void S(boolean z10) {
        this.f74897e = z10;
    }

    public final void T(Function0 function0) {
        this.f74894b.z(function0);
    }

    public final void U() {
        this.f74894b.A();
    }

    public final void V(int i11) {
        if (i11 > 0) {
            C();
            this.f74894b.B(i11);
        }
    }

    public final void W(Object obj, androidx.compose.runtime.c cVar, int i11) {
        this.f74894b.C(obj, cVar, i11);
    }

    public final void X(Object obj) {
        E(this, false, 1, null);
        this.f74894b.D(obj);
    }

    public final void Y(Object obj, Function2 function2) {
        A();
        this.f74894b.E(obj, function2);
    }

    public final void Z(Object obj, int i11) {
        D(true);
        this.f74894b.F(obj, i11);
    }

    public final void a(androidx.compose.runtime.c cVar, Object obj) {
        this.f74894b.f(cVar, obj);
    }

    public final void a0(Object obj) {
        A();
        this.f74894b.H(obj);
    }

    public final void b(List list, androidx.compose.runtime.internal.c cVar) {
        this.f74894b.g(list, cVar);
    }

    public final void c(x0 x0Var, m mVar, y0 y0Var, y0 y0Var2) {
        this.f74894b.h(x0Var, mVar, y0Var, y0Var2);
    }

    public final void d() {
        E(this, false, 1, null);
        this.f74894b.i();
    }

    public final void e(androidx.compose.runtime.internal.c cVar, androidx.compose.runtime.c cVar2) {
        B();
        this.f74894b.j(cVar, cVar2);
    }

    public final void f(Function1 function1, l lVar) {
        this.f74894b.l(function1, lVar);
    }

    public final void g() {
        int u11 = q().u();
        if (!(this.f74896d.h(-1) <= u11)) {
            k.r("Missed recording an endGroup");
        }
        if (this.f74896d.h(-1) == u11) {
            E(this, false, 1, null);
            this.f74896d.i();
            this.f74894b.m();
        }
    }

    public final void h() {
        this.f74894b.n();
        this.f74898f = 0;
    }

    public final void i() {
        G();
    }

    public final void j() {
        if (this.f74895c) {
            E(this, false, 1, null);
            E(this, false, 1, null);
            this.f74894b.m();
            this.f74895c = false;
        }
    }

    public final void m() {
        B();
        if (this.f74896d.d()) {
            return;
        }
        k.r("Missed recording an endGroup()");
    }

    public final s.a n() {
        return this.f74894b;
    }

    public final boolean o() {
        return this.f74897e;
    }

    public final boolean p() {
        return q().u() - this.f74898f < 0;
    }

    public final void r(s.a aVar, androidx.compose.runtime.internal.c cVar) {
        this.f74894b.q(aVar, cVar);
    }

    public final void s(androidx.compose.runtime.c cVar, j2 j2Var) {
        B();
        C();
        G();
        this.f74894b.r(cVar, j2Var);
    }

    public final void t(androidx.compose.runtime.c cVar, j2 j2Var, c cVar2) {
        B();
        C();
        G();
        this.f74894b.s(cVar, j2Var, cVar2);
    }

    public final void u(int i11) {
        C();
        this.f74894b.t(i11);
    }

    public final void v(Object obj) {
        G();
        this.f74900h.h(obj);
    }

    public final void w(int i11, int i12, int i13) {
        if (i13 > 0) {
            int i14 = this.f74904l;
            if (i14 > 0 && this.f74902j == i11 - i14 && this.f74903k == i12 - i14) {
                this.f74904l = i14 + i13;
                return;
            }
            G();
            this.f74902j = i11;
            this.f74903k = i12;
            this.f74904l = i13;
        }
    }

    public final void x(int i11) {
        this.f74898f += i11 - q().k();
    }

    public final void y(int i11) {
        this.f74898f = i11;
    }

    public final void z() {
        G();
        if (this.f74900h.d()) {
            this.f74900h.g();
        } else {
            this.f74899g++;
        }
    }
}
