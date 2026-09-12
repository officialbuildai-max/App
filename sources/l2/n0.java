package l2;

/* loaded from: classes2.dex */
public final class n0 {

    /* renamed from: c, reason: collision with root package name */
    public static final n0 f68772c = new n0(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f68773a;

    /* renamed from: b, reason: collision with root package name */
    public final long f68774b;

    public n0(long j11, long j12) {
        this.f68773a = j11;
        this.f68774b = j12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n0.class != obj.getClass()) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.f68773a == n0Var.f68773a && this.f68774b == n0Var.f68774b;
    }

    public int hashCode() {
        return (((int) this.f68773a) * 31) + ((int) this.f68774b);
    }

    public String toString() {
        return "[timeUs=" + this.f68773a + ", position=" + this.f68774b + "]";
    }
}
