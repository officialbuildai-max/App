package androidx.compose.foundation.layout;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public final class a implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f2906a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2907b;

    /* renamed from: c, reason: collision with root package name */
    private final i1 f2908c;

    /* renamed from: d, reason: collision with root package name */
    private final i1 f2909d;

    public a(int i11, String str) {
        i1 c11;
        i1 c12;
        this.f2906a = i11;
        this.f2907b = str;
        c11 = u2.c(z0.c.f79247e, null, 2, null);
        this.f2908c = c11;
        c12 = u2.c(Boolean.TRUE, null, 2, null);
        this.f2909d = c12;
    }

    private final void g(boolean z10) {
        this.f2909d.setValue(Boolean.valueOf(z10));
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(o0.e eVar) {
        return e().f79249b;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(o0.e eVar) {
        return e().f79251d;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(o0.e eVar, LayoutDirection layoutDirection) {
        return e().f79248a;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(o0.e eVar, LayoutDirection layoutDirection) {
        return e().f79250c;
    }

    public final z0.c e() {
        return (z0.c) this.f2908c.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f2906a == ((a) obj).f2906a;
    }

    public final void f(z0.c cVar) {
        this.f2908c.setValue(cVar);
    }

    public final void h(WindowInsetsCompat windowInsetsCompat, int i11) {
        if (i11 == 0 || (i11 & this.f2906a) != 0) {
            f(windowInsetsCompat.getInsets(this.f2906a));
            g(windowInsetsCompat.isVisible(this.f2906a));
        }
    }

    public int hashCode() {
        return this.f2906a;
    }

    public String toString() {
        return this.f2907b + '(' + e().f79248a + ", " + e().f79249b + ", " + e().f79250c + ", " + e().f79251d + ')';
    }
}
