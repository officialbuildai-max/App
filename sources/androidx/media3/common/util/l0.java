package androidx.media3.common.util;

/* loaded from: classes2.dex */
public final class l0 {

    /* renamed from: c, reason: collision with root package name */
    public static final l0 f10489c = new l0(-1, -1);

    /* renamed from: d, reason: collision with root package name */
    public static final l0 f10490d = new l0(0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f10491a;

    /* renamed from: b, reason: collision with root package name */
    private final int f10492b;

    public l0(int i11, int i12) {
        a.a((i11 == -1 || i11 >= 0) && (i12 == -1 || i12 >= 0));
        this.f10491a = i11;
        this.f10492b = i12;
    }

    public int a() {
        return this.f10492b;
    }

    public int b() {
        return this.f10491a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f10491a == l0Var.f10491a && this.f10492b == l0Var.f10492b;
    }

    public int hashCode() {
        int i11 = this.f10492b;
        int i12 = this.f10491a;
        return i11 ^ ((i12 >>> 16) | (i12 << 16));
    }

    public String toString() {
        return this.f10491a + "x" + this.f10492b;
    }
}
