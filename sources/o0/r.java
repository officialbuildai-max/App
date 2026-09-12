package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    public static final a f70741e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final r f70742f = new r(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f70743a;

    /* renamed from: b, reason: collision with root package name */
    private final int f70744b;

    /* renamed from: c, reason: collision with root package name */
    private final int f70745c;

    /* renamed from: d, reason: collision with root package name */
    private final int f70746d;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final r a() {
            return r.f70742f;
        }
    }

    public r(int i11, int i12, int i13, int i14) {
        this.f70743a = i11;
        this.f70744b = i12;
        this.f70745c = i13;
        this.f70746d = i14;
    }

    public static /* synthetic */ r c(r rVar, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = rVar.f70743a;
        }
        if ((i15 & 2) != 0) {
            i12 = rVar.f70744b;
        }
        if ((i15 & 4) != 0) {
            i13 = rVar.f70745c;
        }
        if ((i15 & 8) != 0) {
            i14 = rVar.f70746d;
        }
        return rVar.b(i11, i12, i13, i14);
    }

    public final r b(int i11, int i12, int i13, int i14) {
        return new r(i11, i12, i13, i14);
    }

    public final int d() {
        return this.f70746d;
    }

    public final int e() {
        return this.f70746d - this.f70744b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f70743a == rVar.f70743a && this.f70744b == rVar.f70744b && this.f70745c == rVar.f70745c && this.f70746d == rVar.f70746d;
    }

    public final int f() {
        return this.f70743a;
    }

    public final int g() {
        return this.f70745c;
    }

    public final int h() {
        return this.f70744b;
    }

    public int hashCode() {
        return (((((this.f70743a * 31) + this.f70744b) * 31) + this.f70745c) * 31) + this.f70746d;
    }

    public final long i() {
        return q.a(this.f70743a, this.f70744b);
    }

    public final int j() {
        return this.f70745c - this.f70743a;
    }

    public final boolean k() {
        return this.f70743a >= this.f70745c || this.f70744b >= this.f70746d;
    }

    public final r l(int i11, int i12) {
        return new r(this.f70743a + i11, this.f70744b + i12, this.f70745c + i11, this.f70746d + i12);
    }

    public String toString() {
        return "IntRect.fromLTRB(" + this.f70743a + ", " + this.f70744b + ", " + this.f70745c + ", " + this.f70746d + ')';
    }
}
