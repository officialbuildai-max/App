package androidx.compose.ui.graphics;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class x4 implements c4 {

    /* renamed from: a, reason: collision with root package name */
    private int f4959a;

    /* renamed from: e, reason: collision with root package name */
    private float f4963e;

    /* renamed from: f, reason: collision with root package name */
    private float f4964f;

    /* renamed from: g, reason: collision with root package name */
    private float f4965g;

    /* renamed from: j, reason: collision with root package name */
    private float f4968j;

    /* renamed from: k, reason: collision with root package name */
    private float f4969k;

    /* renamed from: l, reason: collision with root package name */
    private float f4970l;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4974p;

    /* renamed from: u, reason: collision with root package name */
    private k4 f4979u;

    /* renamed from: b, reason: collision with root package name */
    private float f4960b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    private float f4961c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f4962d = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    private long f4966h = d4.a();

    /* renamed from: i, reason: collision with root package name */
    private long f4967i = d4.a();

    /* renamed from: m, reason: collision with root package name */
    private float f4971m = 8.0f;

    /* renamed from: n, reason: collision with root package name */
    private long f4972n = e5.f4511a.a();

    /* renamed from: o, reason: collision with root package name */
    private a5 f4973o = v4.a();

    /* renamed from: q, reason: collision with root package name */
    private int f4975q = w3.f4949a.a();

    /* renamed from: r, reason: collision with root package name */
    private long f4976r = y.m.f78614b.a();

    /* renamed from: s, reason: collision with root package name */
    private o0.e f4977s = o0.g.b(1.0f, 0.0f, 2, null);

    /* renamed from: t, reason: collision with root package name */
    private LayoutDirection f4978t = LayoutDirection.Ltr;

    @Override // androidx.compose.ui.graphics.c4
    public float A() {
        return this.f4961c;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void A0(a5 a5Var) {
        if (Intrinsics.c(this.f4973o, a5Var)) {
            return;
        }
        this.f4959a |= 8192;
        this.f4973o = a5Var;
    }

    public int B() {
        return this.f4975q;
    }

    public final o0.e C() {
        return this.f4977s;
    }

    @Override // o0.n
    public float C0() {
        return this.f4977s.C0();
    }

    public final LayoutDirection D() {
        return this.f4978t;
    }

    @Override // o0.e
    public /* synthetic */ float E0(float f11) {
        return o0.d.e(this, f11);
    }

    public final int F() {
        return this.f4959a;
    }

    public final k4 G() {
        return this.f4979u;
    }

    @Override // o0.n
    public /* synthetic */ long H(float f11) {
        return o0.m.b(this, f11);
    }

    public w4 I() {
        return null;
    }

    @Override // o0.n
    public /* synthetic */ float J(long j11) {
        return o0.m.a(this, j11);
    }

    public float L() {
        return this.f4965g;
    }

    public a5 M() {
        return this.f4973o;
    }

    public long O() {
        return this.f4967i;
    }

    public final void P() {
        b(1.0f);
        h(1.0f);
        setAlpha(1.0f);
        j(0.0f);
        a(0.0f);
        u(0.0f);
        p(d4.a());
        s(d4.a());
        e(0.0f);
        f(0.0f);
        g(0.0f);
        d(8.0f);
        d0(e5.f4511a.a());
        A0(v4.a());
        r(false);
        c(null);
        l(w3.f4949a.a());
        V(y.m.f78614b.a());
        this.f4979u = null;
        this.f4959a = 0;
    }

    @Override // o0.e
    public /* synthetic */ long Q(float f11) {
        return o0.d.g(this, f11);
    }

    @Override // o0.e
    public /* synthetic */ long Q0(long j11) {
        return o0.d.f(this, j11);
    }

    public final void R(o0.e eVar) {
        this.f4977s = eVar;
    }

    public final void U(LayoutDirection layoutDirection) {
        this.f4978t = layoutDirection;
    }

    public void V(long j11) {
        this.f4976r = j11;
    }

    public final void Y() {
        this.f4979u = M().a(i(), this.f4978t, this.f4977s);
    }

    @Override // androidx.compose.ui.graphics.c4
    public void a(float f11) {
        if (this.f4964f == f11) {
            return;
        }
        this.f4959a |= 16;
        this.f4964f = f11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void b(float f11) {
        if (this.f4960b == f11) {
            return;
        }
        this.f4959a |= 1;
        this.f4960b = f11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public long b0() {
        return this.f4972n;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void c(w4 w4Var) {
        if (Intrinsics.c(null, w4Var)) {
            return;
        }
        this.f4959a |= 131072;
    }

    @Override // o0.e
    public /* synthetic */ int c0(float f11) {
        return o0.d.a(this, f11);
    }

    @Override // androidx.compose.ui.graphics.c4
    public void d(float f11) {
        if (this.f4971m == f11) {
            return;
        }
        this.f4959a |= 2048;
        this.f4971m = f11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void d0(long j11) {
        if (e5.c(this.f4972n, j11)) {
            return;
        }
        this.f4959a |= 4096;
        this.f4972n = j11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void e(float f11) {
        if (this.f4968j == f11) {
            return;
        }
        this.f4959a |= 256;
        this.f4968j = f11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void f(float f11) {
        if (this.f4969k == f11) {
            return;
        }
        this.f4959a |= 512;
        this.f4969k = f11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void g(float f11) {
        if (this.f4970l == f11) {
            return;
        }
        this.f4959a |= 1024;
        this.f4970l = f11;
    }

    @Override // o0.e
    public float getDensity() {
        return this.f4977s.getDensity();
    }

    @Override // androidx.compose.ui.graphics.c4
    public void h(float f11) {
        if (this.f4961c == f11) {
            return;
        }
        this.f4959a |= 2;
        this.f4961c = f11;
    }

    @Override // o0.e
    public /* synthetic */ float h0(long j11) {
        return o0.d.d(this, j11);
    }

    public long i() {
        return this.f4976r;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void j(float f11) {
        if (this.f4963e == f11) {
            return;
        }
        this.f4959a |= 8;
        this.f4963e = f11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void l(int i11) {
        if (w3.e(this.f4975q, i11)) {
            return;
        }
        this.f4959a |= 32768;
        this.f4975q = i11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public float m() {
        return this.f4969k;
    }

    public float n() {
        return this.f4962d;
    }

    @Override // androidx.compose.ui.graphics.c4
    public float o() {
        return this.f4970l;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void p(long j11) {
        if (u1.m(this.f4966h, j11)) {
            return;
        }
        this.f4959a |= 64;
        this.f4966h = j11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public float q() {
        return this.f4971m;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void r(boolean z10) {
        if (this.f4974p != z10) {
            this.f4959a |= 16384;
            this.f4974p = z10;
        }
    }

    @Override // androidx.compose.ui.graphics.c4
    public void s(long j11) {
        if (u1.m(this.f4967i, j11)) {
            return;
        }
        this.f4959a |= 128;
        this.f4967i = j11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void setAlpha(float f11) {
        if (this.f4962d == f11) {
            return;
        }
        this.f4959a |= 4;
        this.f4962d = f11;
    }

    @Override // androidx.compose.ui.graphics.c4
    public float t() {
        return this.f4960b;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void u(float f11) {
        if (this.f4965g == f11) {
            return;
        }
        this.f4959a |= 32;
        this.f4965g = f11;
    }

    public long v() {
        return this.f4966h;
    }

    @Override // androidx.compose.ui.graphics.c4
    public float w() {
        return this.f4964f;
    }

    @Override // androidx.compose.ui.graphics.c4
    public float x() {
        return this.f4963e;
    }

    @Override // o0.e
    public /* synthetic */ float x0(int i11) {
        return o0.d.c(this, i11);
    }

    @Override // androidx.compose.ui.graphics.c4
    public float y() {
        return this.f4968j;
    }

    @Override // o0.e
    public /* synthetic */ float y0(float f11) {
        return o0.d.b(this, f11);
    }

    public boolean z() {
        return this.f4974p;
    }
}
