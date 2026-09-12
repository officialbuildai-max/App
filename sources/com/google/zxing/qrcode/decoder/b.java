package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.g;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f33039a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f33040b;

    private b(int i11, byte[] bArr) {
        this.f33039a = i11;
        this.f33040b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] b(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != gVar.h()) {
            throw new IllegalArgumentException();
        }
        g.b f11 = gVar.f(errorCorrectionLevel);
        g.a[] a11 = f11.a();
        int i11 = 0;
        for (g.a aVar : a11) {
            i11 += aVar.a();
        }
        b[] bVarArr = new b[i11];
        int i12 = 0;
        for (g.a aVar2 : a11) {
            int i13 = 0;
            while (i13 < aVar2.a()) {
                int b11 = aVar2.b();
                bVarArr[i12] = new b(b11, new byte[f11.b() + b11]);
                i13++;
                i12++;
            }
        }
        int length = bVarArr[0].f33040b.length;
        int i14 = i11 - 1;
        while (i14 >= 0 && bVarArr[i14].f33040b.length != length) {
            i14--;
        }
        int i15 = i14 + 1;
        int b12 = length - f11.b();
        int i16 = 0;
        for (int i17 = 0; i17 < b12; i17++) {
            int i18 = 0;
            while (i18 < i12) {
                bVarArr[i18].f33040b[i17] = bArr[i16];
                i18++;
                i16++;
            }
        }
        int i19 = i15;
        while (i19 < i12) {
            bVarArr[i19].f33040b[b12] = bArr[i16];
            i19++;
            i16++;
        }
        int length2 = bVarArr[0].f33040b.length;
        while (b12 < length2) {
            int i20 = 0;
            while (i20 < i12) {
                bVarArr[i20].f33040b[i20 < i15 ? b12 : b12 + 1] = bArr[i16];
                i20++;
                i16++;
            }
            b12++;
        }
        return bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f33040b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f33039a;
    }
}
