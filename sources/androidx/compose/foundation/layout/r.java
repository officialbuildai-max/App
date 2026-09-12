package androidx.compose.foundation.layout;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final int f2951a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2952b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2953c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2954d;

    public r(int i11, int i12, int i13, int i14) {
        this.f2951a = i11;
        this.f2952b = i12;
        this.f2953c = i13;
        this.f2954d = i14;
    }

    public final int a() {
        return this.f2954d;
    }

    public final int b() {
        return this.f2951a;
    }

    public final int c() {
        return this.f2953c;
    }

    public final int d() {
        return this.f2952b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f2951a == rVar.f2951a && this.f2952b == rVar.f2952b && this.f2953c == rVar.f2953c && this.f2954d == rVar.f2954d;
    }

    public int hashCode() {
        return (((((this.f2951a * 31) + this.f2952b) * 31) + this.f2953c) * 31) + this.f2954d;
    }

    public String toString() {
        return "InsetsValues(left=" + this.f2951a + ", top=" + this.f2952b + ", right=" + this.f2953c + ", bottom=" + this.f2954d + ')';
    }
}
