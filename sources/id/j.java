package id;

import com.google.zxing.NotFoundException;

/* loaded from: classes5.dex */
public abstract class j extends com.google.zxing.a {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f65303d = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private byte[] f65304b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f65305c;

    public j(com.google.zxing.e eVar) {
        super(eVar);
        this.f65304b = f65303d;
        this.f65305c = new int[32];
    }

    private static int g(int[] iArr) {
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = iArr[i14];
            if (i15 > i11) {
                i13 = i14;
                i11 = i15;
            }
            if (i15 > i12) {
                i12 = i15;
            }
        }
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            int i19 = i18 - i13;
            int i20 = iArr[i18] * i19 * i19;
            if (i20 > i17) {
                i16 = i18;
                i17 = i20;
            }
        }
        if (i13 <= i16) {
            int i21 = i13;
            i13 = i16;
            i16 = i21;
        }
        if (i13 - i16 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i22 = i13 - 1;
        int i23 = -1;
        int i24 = i22;
        while (i22 > i16) {
            int i25 = i22 - i16;
            int i26 = i25 * i25 * (i13 - i22) * (i12 - iArr[i22]);
            if (i26 > i23) {
                i24 = i22;
                i23 = i26;
            }
            i22--;
        }
        return i24 << 3;
    }

    private void h(int i11) {
        if (this.f65304b.length < i11) {
            this.f65304b = new byte[i11];
        }
        for (int i12 = 0; i12 < 32; i12++) {
            this.f65305c[i12] = 0;
        }
    }

    @Override // com.google.zxing.a
    public b b() {
        com.google.zxing.e e11 = e();
        int d11 = e11.d();
        int a11 = e11.a();
        b bVar = new b(d11, a11);
        h(d11);
        int[] iArr = this.f65305c;
        for (int i11 = 1; i11 < 5; i11++) {
            byte[] c11 = e11.c((a11 * i11) / 5, this.f65304b);
            int i12 = (d11 * 4) / 5;
            for (int i13 = d11 / 5; i13 < i12; i13++) {
                int i14 = (c11[i13] & 255) >> 3;
                iArr[i14] = iArr[i14] + 1;
            }
        }
        int g11 = g(iArr);
        byte[] b11 = e11.b();
        for (int i15 = 0; i15 < a11; i15++) {
            int i16 = i15 * d11;
            for (int i17 = 0; i17 < d11; i17++) {
                if ((b11[i16 + i17] & 255) < g11) {
                    bVar.r(i17, i15);
                }
            }
        }
        return bVar;
    }

    @Override // com.google.zxing.a
    public a c(int i11, a aVar) {
        com.google.zxing.e e11 = e();
        int d11 = e11.d();
        if (aVar == null || aVar.m() < d11) {
            aVar = new a(d11);
        } else {
            aVar.e();
        }
        h(d11);
        byte[] c11 = e11.c(i11, this.f65304b);
        int[] iArr = this.f65305c;
        for (int i12 = 0; i12 < d11; i12++) {
            int i13 = (c11[i12] & 255) >> 3;
            iArr[i13] = iArr[i13] + 1;
        }
        int g11 = g(iArr);
        if (d11 < 3) {
            for (int i14 = 0; i14 < d11; i14++) {
                if ((c11[i14] & 255) < g11) {
                    aVar.r(i14);
                }
            }
        } else {
            int i15 = 1;
            int i16 = c11[0] & 255;
            int i17 = c11[1] & 255;
            while (i15 < d11 - 1) {
                int i18 = i15 + 1;
                int i19 = c11[i18] & 255;
                if ((((i17 * 4) - i16) - i19) / 2 < g11) {
                    aVar.r(i15);
                }
                i16 = i17;
                i15 = i18;
                i17 = i19;
            }
        }
        return aVar;
    }
}
