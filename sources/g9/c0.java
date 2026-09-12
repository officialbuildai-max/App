package g9;

/* loaded from: classes4.dex */
public final class c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f63497c = new c0(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f63498a;

    /* renamed from: b, reason: collision with root package name */
    public final long f63499b;

    public c0(long j11, long j12) {
        this.f63498a = j11;
        this.f63499b = j12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f63498a == c0Var.f63498a && this.f63499b == c0Var.f63499b;
    }

    public int hashCode() {
        return (((int) this.f63498a) * 31) + ((int) this.f63499b);
    }

    public String toString() {
        return "[timeUs=" + this.f63498a + ", position=" + this.f63499b + "]";
    }
}
