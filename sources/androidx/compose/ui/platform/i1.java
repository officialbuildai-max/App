package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.o4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5883a = true;

    /* renamed from: b, reason: collision with root package name */
    private final Outline f5884b;

    /* renamed from: c, reason: collision with root package name */
    private k4 f5885c;

    /* renamed from: d, reason: collision with root package name */
    private Path f5886d;

    /* renamed from: e, reason: collision with root package name */
    private Path f5887e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5888f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5889g;

    /* renamed from: h, reason: collision with root package name */
    private Path f5890h;

    /* renamed from: i, reason: collision with root package name */
    private y.k f5891i;

    /* renamed from: j, reason: collision with root package name */
    private float f5892j;

    /* renamed from: k, reason: collision with root package name */
    private long f5893k;

    /* renamed from: l, reason: collision with root package name */
    private long f5894l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5895m;

    /* renamed from: n, reason: collision with root package name */
    private Path f5896n;

    /* renamed from: o, reason: collision with root package name */
    private Path f5897o;

    public i1() {
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.f5884b = outline;
        this.f5893k = y.g.f78593b.c();
        this.f5894l = y.m.f78614b.b();
    }

    private final boolean g(y.k kVar, long j11, long j12, float f11) {
        return kVar != null && y.l.e(kVar) && kVar.e() == y.g.m(j11) && kVar.g() == y.g.n(j11) && kVar.f() == y.g.m(j11) + y.m.i(j12) && kVar.a() == y.g.n(j11) + y.m.g(j12) && y.a.d(kVar.h()) == f11;
    }

    private final void i() {
        if (this.f5888f) {
            this.f5893k = y.g.f78593b.c();
            this.f5892j = 0.0f;
            this.f5887e = null;
            this.f5888f = false;
            this.f5889g = false;
            k4 k4Var = this.f5885c;
            if (k4Var == null || !this.f5895m || y.m.i(this.f5894l) <= 0.0f || y.m.g(this.f5894l) <= 0.0f) {
                this.f5884b.setEmpty();
                return;
            }
            this.f5883a = true;
            if (k4Var instanceof k4.b) {
                k(((k4.b) k4Var).b());
            } else if (k4Var instanceof k4.c) {
                l(((k4.c) k4Var).b());
            } else if (k4Var instanceof k4.a) {
                j(((k4.a) k4Var).b());
            }
        }
    }

    private final void j(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.a()) {
            Outline outline = this.f5884b;
            if (!(path instanceof androidx.compose.ui.graphics.u0)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            outline.setConvexPath(((androidx.compose.ui.graphics.u0) path).p());
            this.f5889g = !this.f5884b.canClip();
        } else {
            this.f5883a = false;
            this.f5884b.setEmpty();
            this.f5889g = true;
        }
        this.f5887e = path;
    }

    private final void k(y.i iVar) {
        this.f5893k = y.h.a(iVar.f(), iVar.i());
        this.f5894l = y.n.a(iVar.k(), iVar.e());
        this.f5884b.setRect(Math.round(iVar.f()), Math.round(iVar.i()), Math.round(iVar.g()), Math.round(iVar.c()));
    }

    private final void l(y.k kVar) {
        float d11 = y.a.d(kVar.h());
        this.f5893k = y.h.a(kVar.e(), kVar.g());
        this.f5894l = y.n.a(kVar.j(), kVar.d());
        if (y.l.e(kVar)) {
            this.f5884b.setRoundRect(Math.round(kVar.e()), Math.round(kVar.g()), Math.round(kVar.f()), Math.round(kVar.a()), d11);
            this.f5892j = d11;
            return;
        }
        Path path = this.f5886d;
        if (path == null) {
            path = androidx.compose.ui.graphics.x0.a();
            this.f5886d = path;
        }
        path.reset();
        o4.b(path, kVar, null, 2, null);
        j(path);
    }

    public final void a(androidx.compose.ui.graphics.m1 m1Var) {
        Path d11 = d();
        if (d11 != null) {
            androidx.compose.ui.graphics.l1.c(m1Var, d11, 0, 2, null);
            return;
        }
        float f11 = this.f5892j;
        if (f11 <= 0.0f) {
            androidx.compose.ui.graphics.l1.d(m1Var, y.g.m(this.f5893k), y.g.n(this.f5893k), y.g.m(this.f5893k) + y.m.i(this.f5894l), y.g.n(this.f5893k) + y.m.g(this.f5894l), 0, 16, null);
            return;
        }
        Path path = this.f5890h;
        y.k kVar = this.f5891i;
        if (path == null || !g(kVar, this.f5893k, this.f5894l, f11)) {
            y.k c11 = y.l.c(y.g.m(this.f5893k), y.g.n(this.f5893k), y.g.m(this.f5893k) + y.m.i(this.f5894l), y.g.n(this.f5893k) + y.m.g(this.f5894l), y.b.b(this.f5892j, 0.0f, 2, null));
            if (path == null) {
                path = androidx.compose.ui.graphics.x0.a();
            } else {
                path.reset();
            }
            o4.b(path, c11, null, 2, null);
            this.f5891i = c11;
            this.f5890h = path;
        }
        androidx.compose.ui.graphics.l1.c(m1Var, path, 0, 2, null);
    }

    public final Outline b() {
        i();
        if (this.f5895m && this.f5883a) {
            return this.f5884b;
        }
        return null;
    }

    public final boolean c() {
        return this.f5888f;
    }

    public final Path d() {
        i();
        return this.f5887e;
    }

    public final boolean e() {
        return !this.f5889g;
    }

    public final boolean f(long j11) {
        k4 k4Var;
        if (this.f5895m && (k4Var = this.f5885c) != null) {
            return f2.b(k4Var, y.g.m(j11), y.g.n(j11), this.f5896n, this.f5897o);
        }
        return true;
    }

    public final boolean h(k4 k4Var, float f11, boolean z10, float f12, long j11) {
        this.f5884b.setAlpha(f11);
        boolean c11 = Intrinsics.c(this.f5885c, k4Var);
        boolean z11 = !c11;
        if (!c11) {
            this.f5885c = k4Var;
            this.f5888f = true;
        }
        this.f5894l = j11;
        boolean z12 = k4Var != null && (z10 || f12 > 0.0f);
        if (this.f5895m != z12) {
            this.f5895m = z12;
            this.f5888f = true;
        }
        return z11;
    }
}
