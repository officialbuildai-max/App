package h10;

/* loaded from: classes7.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f64387a;

    /* renamed from: b, reason: collision with root package name */
    private final int f64388b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(byte[] bArr, int i11) {
        this.f64387a = bArr;
        this.f64388b = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(z zVar, d dVar) {
        if (zVar == null) {
            dVar.g(0);
            return;
        }
        byte[] bArr = zVar.f64387a;
        int i11 = zVar.f64388b;
        dVar.h(bArr, i11, (bArr[i11] * 2) + 1);
    }

    public int a() {
        return this.f64387a[this.f64388b];
    }

    public int b(int i11) {
        return this.f64387a[this.f64388b + (i11 * 2) + 1];
    }

    public int c(int i11) {
        return this.f64387a[this.f64388b + (i11 * 2) + 2];
    }

    public String toString() {
        int a11 = a();
        StringBuilder sb2 = new StringBuilder(a11 * 2);
        for (int i11 = 0; i11 < a11; i11++) {
            int b11 = b(i11);
            if (b11 == 0) {
                sb2.append('[');
            } else if (b11 == 1) {
                sb2.append('.');
            } else if (b11 == 2) {
                sb2.append('*');
            } else {
                if (b11 != 3) {
                    throw new AssertionError();
                }
                sb2.append(c(i11));
                sb2.append(';');
            }
        }
        return sb2.toString();
    }
}
