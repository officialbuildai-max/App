package rl;

/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final int f74686a;

    /* renamed from: b, reason: collision with root package name */
    private final int f74687b;

    public k(int i11, int i12) {
        this.f74686a = i11;
        this.f74687b = i12;
    }

    public final int a() {
        return this.f74687b;
    }

    public final int b() {
        return this.f74686a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f74686a == kVar.f74686a && this.f74687b == kVar.f74687b;
    }

    public int hashCode() {
        return (this.f74686a * 31) + this.f74687b;
    }

    public String toString() {
        return "UGCFilterCoverSize(width=" + this.f74686a + ", height=" + this.f74687b + ")";
    }
}
