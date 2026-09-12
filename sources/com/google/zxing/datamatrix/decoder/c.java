package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final kd.c f32918a = new kd.c(kd.a.f66889m);

    private int a(byte[] bArr, int i11) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = bArr[i12] & 255;
        }
        try {
            int a11 = this.f32918a.a(iArr, bArr.length - i11);
            for (int i13 = 0; i13 < i11; i13++) {
                bArr[i13] = (byte) iArr[i13];
            }
            return a11;
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public id.d b(id.b bVar) {
        a aVar = new a(bVar);
        b[] b11 = b.b(aVar.c(), aVar.b());
        int i11 = 0;
        for (b bVar2 : b11) {
            i11 += bVar2.c();
        }
        byte[] bArr = new byte[i11];
        int length = b11.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            b bVar3 = b11[i13];
            byte[] a11 = bVar3.a();
            int c11 = bVar3.c();
            i12 += a(a11, c11);
            for (int i14 = 0; i14 < c11; i14++) {
                bArr[(i14 * length) + i13] = a11[i14];
            }
        }
        id.d a12 = DecodedBitStreamParser.a(bArr);
        a12.n(Integer.valueOf(i12));
        return a12;
    }
}
