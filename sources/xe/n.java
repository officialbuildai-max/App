package xe;

import android.graphics.Rect;

/* loaded from: classes5.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f78349a;

    /* renamed from: b, reason: collision with root package name */
    private int f78350b;

    /* renamed from: c, reason: collision with root package name */
    private int f78351c;

    public n(byte[] bArr, int i11, int i12) {
        this.f78349a = bArr;
        this.f78350b = i11;
        this.f78351c = i12;
    }

    public static byte[] e(byte[] bArr, int i11, int i12) {
        int i13 = i11 * i12;
        byte[] bArr2 = new byte[i13];
        int i14 = i13 - 1;
        for (int i15 = 0; i15 < i13; i15++) {
            bArr2[i14] = bArr[i15];
            i14--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i11, int i12) {
        int i13 = i11 * i12;
        byte[] bArr2 = new byte[i13];
        int i14 = i13 - 1;
        for (int i15 = 0; i15 < i11; i15++) {
            for (int i16 = i12 - 1; i16 >= 0; i16--) {
                bArr2[i14] = bArr[(i16 * i11) + i15];
                i14--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i11 * i12];
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            for (int i15 = i12 - 1; i15 >= 0; i15--) {
                bArr2[i13] = bArr[(i15 * i11) + i14];
                i13++;
            }
        }
        return bArr2;
    }

    public n a(Rect rect, int i11) {
        int width = rect.width() / i11;
        int height = rect.height() / i11;
        int i12 = rect.top;
        byte[] bArr = new byte[width * height];
        if (i11 == 1) {
            int i13 = (i12 * this.f78350b) + rect.left;
            for (int i14 = 0; i14 < height; i14++) {
                System.arraycopy(this.f78349a, i13, bArr, i14 * width, width);
                i13 += this.f78350b;
            }
        } else {
            int i15 = (i12 * this.f78350b) + rect.left;
            for (int i16 = 0; i16 < height; i16++) {
                int i17 = i16 * width;
                int i18 = i15;
                for (int i19 = 0; i19 < width; i19++) {
                    bArr[i17] = this.f78349a[i18];
                    i18 += i11;
                    i17++;
                }
                i15 += this.f78350b * i11;
            }
        }
        return new n(bArr, width, height);
    }

    public byte[] b() {
        return this.f78349a;
    }

    public int c() {
        return this.f78351c;
    }

    public int d() {
        return this.f78350b;
    }

    public n h(int i11) {
        return i11 != 90 ? i11 != 180 ? i11 != 270 ? this : new n(f(this.f78349a, this.f78350b, this.f78351c), this.f78351c, this.f78350b) : new n(e(this.f78349a, this.f78350b, this.f78351c), this.f78350b, this.f78351c) : new n(g(this.f78349a, this.f78350b, this.f78351c), this.f78351c, this.f78350b);
    }
}
