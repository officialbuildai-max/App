package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final kd.c f33043a = new kd.c(kd.a.f66888l);

    private int a(byte[] bArr, int i11) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = bArr[i12] & 255;
        }
        try {
            int a11 = this.f33043a.a(iArr, bArr.length - i11);
            for (int i13 = 0; i13 < i11; i13++) {
                bArr[i13] = (byte) iArr[i13];
            }
            return a11;
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private id.d b(a aVar, Map map) {
        g e11 = aVar.e();
        ErrorCorrectionLevel d11 = aVar.d().d();
        b[] b11 = b.b(aVar.c(), e11, d11);
        int i11 = 0;
        for (b bVar : b11) {
            i11 += bVar.c();
        }
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        for (b bVar2 : b11) {
            byte[] a11 = bVar2.a();
            int c11 = bVar2.c();
            i12 += a(a11, c11);
            int i14 = 0;
            while (i14 < c11) {
                bArr[i13] = a11[i14];
                i14++;
                i13++;
            }
        }
        id.d a12 = c.a(bArr, e11, d11, map);
        a12.n(Integer.valueOf(i12));
        return a12;
    }

    public id.d c(id.b bVar, Map map) {
        ChecksumException e11;
        a aVar = new a(bVar);
        FormatException formatException = null;
        try {
            return b(aVar, map);
        } catch (ChecksumException e12) {
            e11 = e12;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                id.d b11 = b(aVar, map);
                b11.p(new f(true));
                return b11;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e11;
            }
        } catch (FormatException e13) {
            e11 = null;
            formatException = e13;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            id.d b112 = b(aVar, map);
            b112.p(new f(true));
            return b112;
        }
    }
}
