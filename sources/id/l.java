package id;

import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public final class l extends j {

    /* renamed from: e, reason: collision with root package name */
    private b f65307e;

    public l(com.google.zxing.e eVar) {
        super(eVar);
    }

    private static int[][] i(byte[] bArr, int i11, int i12, int i13, int i14) {
        char c11;
        int i15 = 8;
        int i16 = i14 - 8;
        int i17 = i13 - 8;
        char c12 = 2;
        boolean z10 = true;
        int i18 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i12, i11);
        int i19 = 0;
        while (i19 < i12) {
            int i20 = i19 << 3;
            if (i20 > i16) {
                i20 = i16;
            }
            int i21 = i18;
            while (i21 < i11) {
                int i22 = i21 << 3;
                if (i22 > i17) {
                    i22 = i17;
                }
                int i23 = (i20 * i13) + i22;
                int i24 = i18;
                int i25 = i24;
                int i26 = i25;
                int i27 = 255;
                while (i24 < i15) {
                    int i28 = i26;
                    int i29 = 0;
                    while (i29 < i15) {
                        int i30 = bArr[i23 + i29] & 255;
                        i25 += i30;
                        if (i30 < i27) {
                            i27 = i30;
                        }
                        if (i30 > i28) {
                            i28 = i30;
                        }
                        i29++;
                        i15 = 8;
                    }
                    if (i28 - i27 <= 24) {
                        i24++;
                        i23 += i13;
                        i26 = i28;
                        z10 = true;
                        i15 = 8;
                    }
                    while (true) {
                        i24++;
                        i23 += i13;
                        if (i24 < 8) {
                            int i31 = 0;
                            for (int i32 = 8; i31 < i32; i32 = 8) {
                                i25 += bArr[i23 + i31] & 255;
                                i31++;
                            }
                        }
                    }
                    i24++;
                    i23 += i13;
                    i26 = i28;
                    z10 = true;
                    i15 = 8;
                }
                boolean z11 = z10;
                int i33 = i25 >> 6;
                if (i26 - i27 <= 24) {
                    i33 = i27 / 2;
                    if (i19 > 0 && i21 > 0) {
                        int[] iArr2 = iArr[i19 - 1];
                        int i34 = i21 - 1;
                        c11 = 2;
                        int i35 = ((iArr2[i21] + (iArr[i19][i34] * 2)) + iArr2[i34]) / 4;
                        if (i27 < i35) {
                            i33 = i35;
                        }
                        iArr[i19][i21] = i33;
                        i21++;
                        z10 = z11;
                        c12 = c11;
                        i15 = 8;
                        i18 = 0;
                    }
                }
                c11 = 2;
                iArr[i19][i21] = i33;
                i21++;
                z10 = z11;
                c12 = c11;
                i15 = 8;
                i18 = 0;
            }
            i19++;
            i15 = 8;
            i18 = 0;
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i11, int i12, int i13, int i14, int[][] iArr, b bVar) {
        int i15 = i14 - 8;
        int i16 = i13 - 8;
        for (int i17 = 0; i17 < i12; i17++) {
            int i18 = i17 << 3;
            if (i18 > i15) {
                i18 = i15;
            }
            int k11 = k(i17, i12 - 3);
            for (int i19 = 0; i19 < i11; i19++) {
                int i20 = i19 << 3;
                int i21 = i20 > i16 ? i16 : i20;
                int k12 = k(i19, i11 - 3);
                int i22 = 0;
                for (int i23 = -2; i23 <= 2; i23++) {
                    int[] iArr2 = iArr[k11 + i23];
                    i22 += iArr2[k12 - 2] + iArr2[k12 - 1] + iArr2[k12] + iArr2[k12 + 1] + iArr2[2 + k12];
                }
                l(bArr, i21, i18, i22 / 25, i13, bVar);
            }
        }
    }

    private static int k(int i11, int i12) {
        if (i11 < 2) {
            return 2;
        }
        return Math.min(i11, i12);
    }

    private static void l(byte[] bArr, int i11, int i12, int i13, int i14, b bVar) {
        int i15 = (i12 * i14) + i11;
        int i16 = 0;
        while (i16 < 8) {
            for (int i17 = 0; i17 < 8; i17++) {
                if ((bArr[i15 + i17] & 255) <= i13) {
                    bVar.r(i11 + i17, i12 + i16);
                }
            }
            i16++;
            i15 += i14;
        }
    }

    @Override // com.google.zxing.a
    public com.google.zxing.a a(com.google.zxing.e eVar) {
        return new l(eVar);
    }

    @Override // id.j, com.google.zxing.a
    public b b() {
        b bVar = this.f65307e;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.e e11 = e();
        int d11 = e11.d();
        int a11 = e11.a();
        if (d11 < 40 || a11 < 40) {
            this.f65307e = super.b();
        } else {
            byte[] b11 = e11.b();
            int i11 = d11 >> 3;
            if ((d11 & 7) != 0) {
                i11++;
            }
            int i12 = i11;
            int i13 = a11 >> 3;
            if ((a11 & 7) != 0) {
                i13++;
            }
            int i14 = i13;
            int[][] i15 = i(b11, i12, i14, d11, a11);
            b bVar2 = new b(d11, a11);
            j(b11, i12, i14, d11, a11, i15, bVar2);
            this.f65307e = bVar2;
        }
        return this.f65307e;
    }
}
