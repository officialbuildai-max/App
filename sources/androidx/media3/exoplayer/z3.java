package androidx.media3.exoplayer;

/* loaded from: classes2.dex */
public final class z3 {

    /* renamed from: c, reason: collision with root package name */
    public static final z3 f13480c = new z3(0, false);

    /* renamed from: a, reason: collision with root package name */
    public final int f13481a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13482b;

    public z3(int i11, boolean z10) {
        this.f13481a = i11;
        this.f13482b = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z3.class != obj.getClass()) {
            return false;
        }
        z3 z3Var = (z3) obj;
        return this.f13481a == z3Var.f13481a && this.f13482b == z3Var.f13482b;
    }

    public int hashCode() {
        return (this.f13481a << 1) + (this.f13482b ? 1 : 0);
    }
}
