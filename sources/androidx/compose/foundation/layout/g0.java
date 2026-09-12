package androidx.compose.foundation.layout;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f2929a;

    /* renamed from: b, reason: collision with root package name */
    private final i1 f2930b;

    public g0(r rVar, String str) {
        i1 c11;
        this.f2929a = str;
        c11 = u2.c(rVar, null, 2, null);
        this.f2930b = c11;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(o0.e eVar) {
        return e().d();
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(o0.e eVar) {
        return e().a();
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(o0.e eVar, LayoutDirection layoutDirection) {
        return e().b();
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(o0.e eVar, LayoutDirection layoutDirection) {
        return e().c();
    }

    public final r e() {
        return (r) this.f2930b.getValue();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            return Intrinsics.c(e(), ((g0) obj).e());
        }
        return false;
    }

    public final void f(r rVar) {
        this.f2930b.setValue(rVar);
    }

    public int hashCode() {
        return this.f2929a.hashCode();
    }

    public String toString() {
        return this.f2929a + "(left=" + e().b() + ", top=" + e().d() + ", right=" + e().c() + ", bottom=" + e().a() + ')';
    }
}
