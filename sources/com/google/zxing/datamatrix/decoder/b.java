package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.d;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f32916a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f32917b;

    private b(int i11, byte[] bArr) {
        this.f32916a = i11;
        this.f32917b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] b(byte[] bArr, d dVar) {
        d.c d11 = dVar.d();
        d.b[] a11 = d11.a();
        int i11 = 0;
        for (d.b bVar : a11) {
            i11 += bVar.a();
        }
        b[] bVarArr = new b[i11];
        int i12 = 0;
        for (d.b bVar2 : a11) {
            int i13 = 0;
            while (i13 < bVar2.a()) {
                int b11 = bVar2.b();
                bVarArr[i12] = new b(b11, new byte[d11.b() + b11]);
                i13++;
                i12++;
            }
        }
        int length = bVarArr[0].f32917b.length - d11.b();
        int i14 = length - 1;
        int i15 = 0;
        for (int i16 = 0; i16 < i14; i16++) {
            int i17 = 0;
            while (i17 < i12) {
                bVarArr[i17].f32917b[i16] = bArr[i15];
                i17++;
                i15++;
            }
        }
        boolean z10 = dVar.i() == 24;
        int i18 = z10 ? 8 : i12;
        int i19 = 0;
        while (i19 < i18) {
            bVarArr[i19].f32917b[i14] = bArr[i15];
            i19++;
            i15++;
        }
        int length2 = bVarArr[0].f32917b.length;
        while (length < length2) {
            int i20 = 0;
            while (i20 < i12) {
                int i21 = z10 ? (i20 + 8) % i12 : i20;
                bVarArr[i21].f32917b[(!z10 || i21 <= 7) ? length : length - 1] = bArr[i15];
                i20++;
                i15++;
            }
            length++;
        }
        if (i15 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f32917b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f32916a;
    }
}
