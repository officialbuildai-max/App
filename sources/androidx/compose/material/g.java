package androidx.compose.material;

import androidx.compose.ui.graphics.u1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final long f3485a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.compose.material.ripple.c f3486b;

    private g(long j11, androidx.compose.material.ripple.c cVar) {
        this.f3485a = j11;
        this.f3486b = cVar;
    }

    public /* synthetic */ g(long j11, androidx.compose.material.ripple.c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? u1.f4733b.e() : j11, (i11 & 2) != 0 ? null : cVar, null);
    }

    public /* synthetic */ g(long j11, androidx.compose.material.ripple.c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, cVar);
    }

    public final long a() {
        return this.f3485a;
    }

    public final androidx.compose.material.ripple.c b() {
        return this.f3486b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return u1.m(this.f3485a, gVar.f3485a) && Intrinsics.c(this.f3486b, gVar.f3486b);
    }

    public int hashCode() {
        int s11 = u1.s(this.f3485a) * 31;
        androidx.compose.material.ripple.c cVar = this.f3486b;
        return s11 + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "RippleConfiguration(color=" + ((Object) u1.t(this.f3485a)) + ", rippleAlpha=" + this.f3486b + ')';
    }
}
