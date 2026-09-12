package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.r4;
import androidx.compose.ui.graphics.w0;
import androidx.compose.ui.graphics.x0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class PathComponent extends i {

    /* renamed from: b, reason: collision with root package name */
    private String f4772b;

    /* renamed from: c, reason: collision with root package name */
    private j1 f4773c;

    /* renamed from: d, reason: collision with root package name */
    private float f4774d;

    /* renamed from: e, reason: collision with root package name */
    private List f4775e;

    /* renamed from: f, reason: collision with root package name */
    private int f4776f;

    /* renamed from: g, reason: collision with root package name */
    private float f4777g;

    /* renamed from: h, reason: collision with root package name */
    private float f4778h;

    /* renamed from: i, reason: collision with root package name */
    private j1 f4779i;

    /* renamed from: j, reason: collision with root package name */
    private int f4780j;

    /* renamed from: k, reason: collision with root package name */
    private int f4781k;

    /* renamed from: l, reason: collision with root package name */
    private float f4782l;

    /* renamed from: m, reason: collision with root package name */
    private float f4783m;

    /* renamed from: n, reason: collision with root package name */
    private float f4784n;

    /* renamed from: o, reason: collision with root package name */
    private float f4785o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4786p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f4787q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f4788r;

    /* renamed from: s, reason: collision with root package name */
    private z.m f4789s;

    /* renamed from: t, reason: collision with root package name */
    private final Path f4790t;

    /* renamed from: u, reason: collision with root package name */
    private Path f4791u;

    /* renamed from: v, reason: collision with root package name */
    private final Lazy f4792v;

    public PathComponent() {
        super(null);
        this.f4772b = "";
        this.f4774d = 1.0f;
        this.f4775e = k.d();
        this.f4776f = k.a();
        this.f4777g = 1.0f;
        this.f4780j = k.b();
        this.f4781k = k.c();
        this.f4782l = 4.0f;
        this.f4784n = 1.0f;
        this.f4786p = true;
        this.f4787q = true;
        Path a11 = x0.a();
        this.f4790t = a11;
        this.f4791u = a11;
        this.f4792v = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<r4>() { // from class: androidx.compose.ui.graphics.vector.PathComponent$pathMeasure$2
            @Override // kotlin.jvm.functions.Function0
            public final r4 invoke() {
                return w0.a();
            }
        });
    }

    private final r4 f() {
        return (r4) this.f4792v.getValue();
    }

    private final void v() {
        h.c(this.f4775e, this.f4790t);
        w();
    }

    private final void w() {
        if (this.f4783m == 0.0f && this.f4784n == 1.0f) {
            this.f4791u = this.f4790t;
            return;
        }
        if (Intrinsics.c(this.f4791u, this.f4790t)) {
            this.f4791u = x0.a();
        } else {
            int h11 = this.f4791u.h();
            this.f4791u.b();
            this.f4791u.e(h11);
        }
        f().b(this.f4790t, false);
        float length = f().getLength();
        float f11 = this.f4783m;
        float f12 = this.f4785o;
        float f13 = ((f11 + f12) % 1.0f) * length;
        float f14 = ((this.f4784n + f12) % 1.0f) * length;
        if (f13 <= f14) {
            f().a(f13, f14, this.f4791u, true);
        } else {
            f().a(f13, length, this.f4791u, true);
            f().a(0.0f, f14, this.f4791u, true);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.i
    public void a(z.g gVar) {
        if (this.f4786p) {
            v();
        } else if (this.f4788r) {
            w();
        }
        this.f4786p = false;
        this.f4788r = false;
        j1 j1Var = this.f4773c;
        if (j1Var != null) {
            z.f.g(gVar, this.f4791u, j1Var, this.f4774d, null, null, 0, 56, null);
        }
        j1 j1Var2 = this.f4779i;
        if (j1Var2 != null) {
            z.m mVar = this.f4789s;
            if (this.f4787q || mVar == null) {
                mVar = new z.m(this.f4778h, this.f4782l, this.f4780j, this.f4781k, null, 16, null);
                this.f4789s = mVar;
                this.f4787q = false;
            }
            z.f.g(gVar, this.f4791u, j1Var2, this.f4777g, mVar, null, 0, 48, null);
        }
    }

    public final j1 e() {
        return this.f4773c;
    }

    public final j1 g() {
        return this.f4779i;
    }

    public final void h(j1 j1Var) {
        this.f4773c = j1Var;
        c();
    }

    public final void i(float f11) {
        this.f4774d = f11;
        c();
    }

    public final void j(String str) {
        this.f4772b = str;
        c();
    }

    public final void k(List list) {
        this.f4775e = list;
        this.f4786p = true;
        c();
    }

    public final void l(int i11) {
        this.f4776f = i11;
        this.f4791u.e(i11);
        c();
    }

    public final void m(j1 j1Var) {
        this.f4779i = j1Var;
        c();
    }

    public final void n(float f11) {
        this.f4777g = f11;
        c();
    }

    public final void o(int i11) {
        this.f4780j = i11;
        this.f4787q = true;
        c();
    }

    public final void p(int i11) {
        this.f4781k = i11;
        this.f4787q = true;
        c();
    }

    public final void q(float f11) {
        this.f4782l = f11;
        this.f4787q = true;
        c();
    }

    public final void r(float f11) {
        this.f4778h = f11;
        this.f4787q = true;
        c();
    }

    public final void s(float f11) {
        this.f4784n = f11;
        this.f4788r = true;
        c();
    }

    public final void t(float f11) {
        this.f4785o = f11;
        this.f4788r = true;
        c();
    }

    public String toString() {
        return this.f4790t.toString();
    }

    public final void u(float f11) {
        this.f4783m = f11;
        this.f4788r = true;
        c();
    }
}
