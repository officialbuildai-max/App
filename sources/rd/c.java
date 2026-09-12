package rd;

import com.google.zxing.k;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f74441a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f74442b;

    /* renamed from: c, reason: collision with root package name */
    private final k[] f74443c;

    public c(int i11, int[] iArr, int i12, int i13, int i14) {
        this.f74441a = i11;
        this.f74442b = iArr;
        float f11 = i12;
        float f12 = i14;
        this.f74443c = new k[]{new k(f11, f12), new k(i13, f12)};
    }

    public k[] a() {
        return this.f74443c;
    }

    public int[] b() {
        return this.f74442b;
    }

    public int c() {
        return this.f74441a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f74441a == ((c) obj).f74441a;
    }

    public int hashCode() {
        return this.f74441a;
    }
}
