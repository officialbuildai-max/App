package androidx.compose.foundation.lazy;

import androidx.compose.runtime.e1;
import androidx.compose.runtime.n2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private final e1 f3213a;

    /* renamed from: b, reason: collision with root package name */
    private final e1 f3214b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3215c;

    /* renamed from: d, reason: collision with root package name */
    private Object f3216d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.compose.foundation.lazy.layout.u f3217e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.v.<init>():void");
    }

    public v(int i11, int i12) {
        this.f3213a = n2.a(i11);
        this.f3214b = n2.a(i12);
        this.f3217e = new androidx.compose.foundation.lazy.layout.u(i11, 30, 100);
    }

    public /* synthetic */ v(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12);
    }

    private final void f(int i11) {
        this.f3214b.setIntValue(i11);
    }

    private final void g(int i11, int i12) {
        if (i11 >= 0.0f) {
            e(i11);
            this.f3217e.e(i11);
            f(i12);
        } else {
            throw new IllegalArgumentException(("Index should be non-negative (" + i11 + ')').toString());
        }
    }

    public final int a() {
        return this.f3213a.getIntValue();
    }

    public final androidx.compose.foundation.lazy.layout.u b() {
        return this.f3217e;
    }

    public final int c() {
        return this.f3214b.getIntValue();
    }

    public final void d(int i11, int i12) {
        g(i11, i12);
        this.f3216d = null;
    }

    public final void e(int i11) {
        this.f3213a.setIntValue(i11);
    }

    public final void h(m mVar) {
        n o11 = mVar.o();
        this.f3216d = o11 != null ? o11.getKey() : null;
        if (this.f3215c || mVar.d() > 0) {
            this.f3215c = true;
            int p11 = mVar.p();
            if (p11 >= 0.0f) {
                n o12 = mVar.o();
                g(o12 != null ? o12.getIndex() : 0, p11);
            } else {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + p11 + ')').toString());
            }
        }
    }

    public final void i(int i11) {
        if (i11 >= 0.0f) {
            f(i11);
            return;
        }
        throw new IllegalStateException(("scrollOffset should be non-negative (" + i11 + ')').toString());
    }

    public final int j(k kVar, int i11) {
        int a11 = androidx.compose.foundation.lazy.layout.n.a(kVar, this.f3216d, i11);
        if (i11 != a11) {
            e(a11);
            this.f3217e.e(i11);
        }
        return a11;
    }
}
