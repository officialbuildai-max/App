package androidx.compose.material;

import androidx.compose.foundation.b0;
import androidx.compose.foundation.w;
import androidx.compose.foundation.y;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.x1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class i implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3488a;

    /* renamed from: b, reason: collision with root package name */
    private final float f3489b;

    /* renamed from: c, reason: collision with root package name */
    private final x1 f3490c;

    /* renamed from: d, reason: collision with root package name */
    private final long f3491d;

    /* loaded from: classes.dex */
    static final class a implements x1 {
        a() {
        }

        @Override // androidx.compose.ui.graphics.x1
        public final long a() {
            return i.this.f3491d;
        }
    }

    private i(boolean z10, float f11, long j11) {
        this(z10, f11, (x1) null, j11);
    }

    public /* synthetic */ i(boolean z10, float f11, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, f11, j11);
    }

    private i(boolean z10, float f11, x1 x1Var, long j11) {
        this.f3488a = z10;
        this.f3489b = f11;
        this.f3490c = x1Var;
        this.f3491d = j11;
    }

    @Override // androidx.compose.foundation.x
    public /* synthetic */ y a(p.g gVar, androidx.compose.runtime.i iVar, int i11) {
        return w.a(this, gVar, iVar, i11);
    }

    @Override // androidx.compose.foundation.b0
    public androidx.compose.ui.node.f b(p.g gVar) {
        x1 x1Var = this.f3490c;
        if (x1Var == null) {
            x1Var = new a();
        }
        return new DelegatingThemeAwareRippleNode(gVar, this.f3488a, this.f3489b, x1Var, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f3488a == iVar.f3488a && o0.i.i(this.f3489b, iVar.f3489b) && Intrinsics.c(this.f3490c, iVar.f3490c)) {
            return u1.m(this.f3491d, iVar.f3491d);
        }
        return false;
    }

    public int hashCode() {
        int a11 = ((androidx.compose.foundation.e.a(this.f3488a) * 31) + o0.i.j(this.f3489b)) * 31;
        x1 x1Var = this.f3490c;
        return ((a11 + (x1Var != null ? x1Var.hashCode() : 0)) * 31) + u1.s(this.f3491d);
    }
}
