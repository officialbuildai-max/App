package g10;

/* loaded from: classes7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    int f63258a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f63259b = 200;

    /* renamed from: c, reason: collision with root package name */
    int f63260c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int[] f63261d = new int[94];

    /* renamed from: e, reason: collision with root package name */
    public int[] f63262e = new int[94];

    /* renamed from: f, reason: collision with root package name */
    public float[] f63263f = new float[94];

    /* renamed from: g, reason: collision with root package name */
    public float[] f63264g = new float[94];

    public k() {
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        for (int i11 = 0; i11 < 94; i11++) {
            float[] fArr = this.f63263f;
            float f11 = this.f63261d[i11];
            int i12 = this.f63258a;
            fArr[i11] = f11 / i12;
            this.f63264g[i11] = this.f63262e[i11] / i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f63258a > this.f63259b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c(float[] fArr, float f11, float[] fArr2, float f12) {
        return (f11 * d(fArr, this.f63263f)) + (f12 * d(fArr2, this.f63264g));
    }

    float d(float[] fArr, float[] fArr2) {
        float f11 = 0.0f;
        for (int i11 = 0; i11 < 94; i11++) {
            float f12 = fArr[i11] - fArr2[i11];
            f11 += f12 * f12;
        }
        return ((float) Math.sqrt(f11)) / 94.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f63258a > 1;
    }

    public void f() {
        this.f63258a = 0;
        this.f63260c = 0;
        for (int i11 = 0; i11 < 94; i11++) {
            int[] iArr = this.f63261d;
            this.f63262e[i11] = 0;
            iArr[i11] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(byte[] bArr, int i11) {
        if (this.f63260c == 1) {
            return false;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = this.f63260c;
            if (1 == i14) {
                break;
            }
            if (i14 != 0) {
                if (i14 != 1) {
                    if (i14 == 2) {
                        byte b11 = bArr[i13];
                        if ((b11 & 128) != 0 && 255 != (b11 & 255) && 161 <= (b11 & 255)) {
                            this.f63258a++;
                            int[] iArr = this.f63262e;
                            int i15 = (b11 & 255) - 161;
                            iArr[i15] = iArr[i15] + 1;
                            this.f63260c = 0;
                        }
                    }
                    this.f63260c = 1;
                }
                i12++;
                i13++;
            } else {
                byte b12 = bArr[i13];
                if ((b12 & 128) != 0) {
                    if (255 != (b12 & 255) && 161 <= (b12 & 255)) {
                        this.f63258a++;
                        int[] iArr2 = this.f63261d;
                        int i16 = (b12 & 255) - 161;
                        iArr2[i16] = iArr2[i16] + 1;
                        this.f63260c = 2;
                    }
                    this.f63260c = 1;
                }
                i12++;
                i13++;
            }
        }
        return 1 != this.f63260c;
    }
}
