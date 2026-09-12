package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.w;
import androidx.compose.runtime.e1;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.n2;
import androidx.compose.runtime.snapshots.j;
import androidx.compose.runtime.u2;
import androidx.compose.ui.layout.f0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
final class v implements androidx.compose.ui.layout.f0, f0.a, w.a {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3152a;

    /* renamed from: b, reason: collision with root package name */
    private final w f3153b;

    /* renamed from: c, reason: collision with root package name */
    private final e1 f3154c = n2.a(-1);

    /* renamed from: d, reason: collision with root package name */
    private final e1 f3155d = n2.a(0);

    /* renamed from: e, reason: collision with root package name */
    private final i1 f3156e;

    /* renamed from: f, reason: collision with root package name */
    private final i1 f3157f;

    public v(Object obj, w wVar) {
        i1 c11;
        i1 c12;
        this.f3152a = obj;
        this.f3153b = wVar;
        c11 = u2.c(null, null, 2, null);
        this.f3156e = c11;
        c12 = u2.c(null, null, 2, null);
        this.f3157f = c12;
    }

    private final f0.a b() {
        return (f0.a) this.f3156e.getValue();
    }

    private final int d() {
        return this.f3155d.getIntValue();
    }

    private final androidx.compose.ui.layout.f0 e() {
        return (androidx.compose.ui.layout.f0) this.f3157f.getValue();
    }

    private final void h(f0.a aVar) {
        this.f3156e.setValue(aVar);
    }

    private final void j(int i11) {
        this.f3155d.setIntValue(i11);
    }

    private final void k(androidx.compose.ui.layout.f0 f0Var) {
        this.f3157f.setValue(f0Var);
    }

    @Override // androidx.compose.ui.layout.f0
    public f0.a a() {
        if (d() == 0) {
            this.f3153b.j(this);
            androidx.compose.ui.layout.f0 c11 = c();
            h(c11 != null ? c11.a() : null);
        }
        j(d() + 1);
        return this;
    }

    public final androidx.compose.ui.layout.f0 c() {
        return e();
    }

    public final void f() {
        int d11 = d();
        for (int i11 = 0; i11 < d11; i11++) {
            release();
        }
    }

    public void g(int i11) {
        this.f3154c.setIntValue(i11);
    }

    @Override // androidx.compose.foundation.lazy.layout.w.a
    public int getIndex() {
        return this.f3154c.getIntValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.w.a
    public Object getKey() {
        return this.f3152a;
    }

    public final void i(androidx.compose.ui.layout.f0 f0Var) {
        j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
        androidx.compose.runtime.snapshots.j d11 = aVar.d();
        Function1 h11 = d11 != null ? d11.h() : null;
        androidx.compose.runtime.snapshots.j f11 = aVar.f(d11);
        try {
            if (f0Var != e()) {
                k(f0Var);
                if (d() > 0) {
                    f0.a b11 = b();
                    if (b11 != null) {
                        b11.release();
                    }
                    h(f0Var != null ? f0Var.a() : null);
                }
            }
            Unit unit = Unit.f67184a;
            aVar.m(d11, f11, h11);
        } catch (Throwable th2) {
            aVar.m(d11, f11, h11);
            throw th2;
        }
    }

    @Override // androidx.compose.ui.layout.f0.a
    public void release() {
        if (d() <= 0) {
            throw new IllegalStateException("Release should only be called once");
        }
        j(d() - 1);
        if (d() == 0) {
            this.f3153b.l(this);
            f0.a b11 = b();
            if (b11 != null) {
                b11.release();
            }
            h(null);
        }
    }
}
