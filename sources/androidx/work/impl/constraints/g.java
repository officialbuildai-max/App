package androidx.work.impl.constraints;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f15700a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f15701b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f15702c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f15703d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f15704e;

    public g(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f15700a = z10;
        this.f15701b = z11;
        this.f15702c = z12;
        this.f15703d = z13;
        this.f15704e = z14;
    }

    public static /* synthetic */ g b(g gVar, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = gVar.f15700a;
        }
        if ((i11 & 2) != 0) {
            z11 = gVar.f15701b;
        }
        boolean z15 = z11;
        if ((i11 & 4) != 0) {
            z12 = gVar.f15702c;
        }
        boolean z16 = z12;
        if ((i11 & 8) != 0) {
            z13 = gVar.f15703d;
        }
        boolean z17 = z13;
        if ((i11 & 16) != 0) {
            z14 = gVar.f15704e;
        }
        return gVar.a(z10, z15, z16, z17, z14);
    }

    public final g a(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return new g(z10, z11, z12, z13, z14);
    }

    public final boolean c() {
        return this.f15704e;
    }

    public final boolean d() {
        return this.f15700a;
    }

    public final boolean e() {
        return this.f15702c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f15700a == gVar.f15700a && this.f15701b == gVar.f15701b && this.f15702c == gVar.f15702c && this.f15703d == gVar.f15703d && this.f15704e == gVar.f15704e;
    }

    public final boolean f() {
        return this.f15703d;
    }

    public final boolean g() {
        return this.f15701b;
    }

    public int hashCode() {
        return (((((((androidx.compose.foundation.e.a(this.f15700a) * 31) + androidx.compose.foundation.e.a(this.f15701b)) * 31) + androidx.compose.foundation.e.a(this.f15702c)) * 31) + androidx.compose.foundation.e.a(this.f15703d)) * 31) + androidx.compose.foundation.e.a(this.f15704e);
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.f15700a + ", isValidated=" + this.f15701b + ", isMetered=" + this.f15702c + ", isNotRoaming=" + this.f15703d + ", isBlocked=" + this.f15704e + ')';
    }
}
