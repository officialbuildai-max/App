package jf;

/* loaded from: classes5.dex */
public class a implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f66131d = new int[0];

    /* renamed from: a, reason: collision with root package name */
    private int[] f66132a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f66133b;

    /* renamed from: c, reason: collision with root package name */
    private int f66134c;

    public a() {
        this(10);
    }

    public a(int i11) {
        if (i11 == 0) {
            int[] iArr = f66131d;
            this.f66132a = iArr;
            this.f66133b = iArr;
        } else {
            int[] iArr2 = new int[i11];
            this.f66132a = iArr2;
            this.f66133b = new int[iArr2.length];
        }
        this.f66134c = 0;
    }

    private int[] b(int[] iArr, int i11, int i12) {
        if (i11 <= iArr.length) {
            if (i11 + 1 > iArr.length) {
                int[] iArr2 = new int[j(i11)];
                System.arraycopy(iArr, 0, iArr2, 0, i11);
                iArr = iArr2;
            }
            iArr[i11] = i12;
            return iArr;
        }
        throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i11);
    }

    private int c(int[] iArr, int i11, int i12) {
        int i13 = i11 - 1;
        int i14 = 0;
        while (i14 <= i13) {
            int i15 = (i14 + i13) >>> 1;
            int i16 = iArr[i15];
            if (i16 < i12) {
                i14 = i15 + 1;
            } else {
                if (i16 <= i12) {
                    return i15;
                }
                i13 = i15 - 1;
            }
        }
        return ~i14;
    }

    public static int j(int i11) {
        if (i11 <= 4) {
            return 8;
        }
        return i11 + (i11 >> 1);
    }

    private int[] l(int[] iArr, int i11, int i12, int i13) {
        if (i11 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i11);
        }
        if (i11 + 1 <= iArr.length) {
            System.arraycopy(iArr, i12, iArr, i12 + 1, i11 - i12);
            iArr[i12] = i13;
            return iArr;
        }
        int[] iArr2 = new int[j(i11)];
        System.arraycopy(iArr, 0, iArr2, 0, i12);
        iArr2[i12] = i13;
        System.arraycopy(iArr, i12, iArr2, i12 + 1, iArr.length - i12);
        return iArr2;
    }

    public void a(int i11, int i12) {
        int i13 = this.f66134c;
        if (i13 != 0 && i11 <= this.f66132a[i13 - 1]) {
            n(i11, i12);
            return;
        }
        this.f66132a = b(this.f66132a, i13, i11);
        this.f66133b = b(this.f66133b, this.f66134c, i12);
        this.f66134c++;
    }

    public void e() {
        this.f66134c = 0;
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = null;
        try {
            a aVar2 = (a) super.clone();
            try {
                aVar2.f66132a = (int[]) this.f66132a.clone();
                aVar2.f66133b = (int[]) this.f66133b.clone();
                return aVar2;
            } catch (CloneNotSupportedException unused) {
                aVar = aVar2;
                return aVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public int g(int i11) {
        return i(i11, 0);
    }

    public int i(int i11, int i12) {
        int c11 = c(this.f66132a, this.f66134c, i11);
        return c11 < 0 ? i12 : this.f66133b[c11];
    }

    public int k(int i11) {
        return c(this.f66132a, this.f66134c, i11);
    }

    public int m(int i11) {
        return this.f66132a[i11];
    }

    public void n(int i11, int i12) {
        int c11 = c(this.f66132a, this.f66134c, i11);
        if (c11 >= 0) {
            this.f66133b[c11] = i12;
            return;
        }
        int i13 = ~c11;
        this.f66132a = l(this.f66132a, this.f66134c, i13, i11);
        this.f66133b = l(this.f66133b, this.f66134c, i13, i12);
        this.f66134c++;
    }

    public int o() {
        return this.f66134c;
    }

    public int p(int i11) {
        return this.f66133b[i11];
    }

    public String toString() {
        if (o() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f66134c * 28);
        sb2.append('{');
        for (int i11 = 0; i11 < this.f66134c; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(m(i11));
            sb2.append('=');
            sb2.append(p(i11));
        }
        sb2.append('}');
        return sb2.toString();
    }
}
