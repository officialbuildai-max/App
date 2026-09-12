package com.google.zxing.qrcode.encoder;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.g;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes4.dex */
abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f33107a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f33108b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f33109c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, -1, -1}, new int[]{6, 34, 62, 90, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, -1, -1}, new int[]{6, 26, 50, 74, 98, Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, 142, -1}, new int[]{6, 34, 62, 90, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 158}, new int[]{6, 32, 58, 84, 110, Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, 142, 170}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f33110d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(id.a aVar, ErrorCorrectionLevel errorCorrectionLevel, g gVar, int i11, yd.a aVar2) {
        c(aVar2);
        d(gVar, aVar2);
        l(errorCorrectionLevel, i11, aVar2);
        s(gVar, aVar2);
        f(aVar, i11, aVar2);
    }

    static int b(int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int n11 = n(i12);
        int i13 = i11 << (n11 - 1);
        while (n(i13) >= n11) {
            i13 ^= i12 << (n(i13) - n11);
        }
        return i13;
    }

    static void c(yd.a aVar) {
        aVar.a((byte) -1);
    }

    static void d(g gVar, yd.a aVar) {
        j(aVar);
        e(aVar);
        r(gVar, aVar);
        k(aVar);
    }

    private static void e(yd.a aVar) {
        if (aVar.b(8, aVar.d() - 8) == 0) {
            throw new WriterException();
        }
        aVar.f(8, aVar.d() - 8, 1);
    }

    static void f(id.a aVar, int i11, yd.a aVar2) {
        boolean z10;
        int e11 = aVar2.e() - 1;
        int d11 = aVar2.d() - 1;
        int i12 = 0;
        int i13 = -1;
        while (e11 > 0) {
            if (e11 == 6) {
                e11--;
            }
            while (d11 >= 0 && d11 < aVar2.d()) {
                for (int i14 = 0; i14 < 2; i14++) {
                    int i15 = e11 - i14;
                    if (o(aVar2.b(i15, d11))) {
                        if (i12 < aVar.m()) {
                            z10 = aVar.i(i12);
                            i12++;
                        } else {
                            z10 = false;
                        }
                        if (i11 != -1 && c.f(i11, i15, d11)) {
                            z10 = !z10;
                        }
                        aVar2.g(i15, d11, z10);
                    }
                }
                d11 += i13;
            }
            i13 = -i13;
            d11 += i13;
            e11 -= 2;
        }
        if (i12 == aVar.m()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i12 + '/' + aVar.m());
    }

    private static void g(int i11, int i12, yd.a aVar) {
        for (int i13 = 0; i13 < 8; i13++) {
            int i14 = i11 + i13;
            if (!o(aVar.b(i14, i12))) {
                throw new WriterException();
            }
            aVar.f(i14, i12, 0);
        }
    }

    private static void h(int i11, int i12, yd.a aVar) {
        for (int i13 = 0; i13 < 5; i13++) {
            int[] iArr = f33108b[i13];
            for (int i14 = 0; i14 < 5; i14++) {
                aVar.f(i11 + i14, i12 + i13, iArr[i14]);
            }
        }
    }

    private static void i(int i11, int i12, yd.a aVar) {
        for (int i13 = 0; i13 < 7; i13++) {
            int[] iArr = f33107a[i13];
            for (int i14 = 0; i14 < 7; i14++) {
                aVar.f(i11 + i14, i12 + i13, iArr[i14]);
            }
        }
    }

    private static void j(yd.a aVar) {
        int length = f33107a[0].length;
        i(0, 0, aVar);
        i(aVar.e() - length, 0, aVar);
        i(0, aVar.e() - length, aVar);
        g(0, 7, aVar);
        g(aVar.e() - 8, 7, aVar);
        g(0, aVar.e() - 8, aVar);
        m(7, 0, aVar);
        m(aVar.d() - 8, 0, aVar);
        m(7, aVar.d() - 7, aVar);
    }

    private static void k(yd.a aVar) {
        int i11 = 8;
        while (i11 < aVar.e() - 8) {
            int i12 = i11 + 1;
            int i13 = i12 % 2;
            if (o(aVar.b(i11, 6))) {
                aVar.f(i11, 6, i13);
            }
            if (o(aVar.b(6, i11))) {
                aVar.f(6, i11, i13);
            }
            i11 = i12;
        }
    }

    static void l(ErrorCorrectionLevel errorCorrectionLevel, int i11, yd.a aVar) {
        int d11;
        id.a aVar2 = new id.a();
        p(errorCorrectionLevel, i11, aVar2);
        for (int i12 = 0; i12 < aVar2.m(); i12++) {
            boolean i13 = aVar2.i((aVar2.m() - 1) - i12);
            int[] iArr = f33110d[i12];
            aVar.g(iArr[0], iArr[1], i13);
            int i14 = 8;
            if (i12 < 8) {
                d11 = 8;
                i14 = (aVar.e() - i12) - 1;
            } else {
                d11 = (aVar.d() - 7) + (i12 - 8);
            }
            aVar.g(i14, d11, i13);
        }
    }

    private static void m(int i11, int i12, yd.a aVar) {
        for (int i13 = 0; i13 < 7; i13++) {
            int i14 = i12 + i13;
            if (!o(aVar.b(i11, i14))) {
                throw new WriterException();
            }
            aVar.f(i11, i14, 0);
        }
    }

    static int n(int i11) {
        return 32 - Integer.numberOfLeadingZeros(i11);
    }

    private static boolean o(int i11) {
        return i11 == -1;
    }

    static void p(ErrorCorrectionLevel errorCorrectionLevel, int i11, id.a aVar) {
        if (!yd.b.b(i11)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i11;
        aVar.c(bits, 5);
        aVar.c(b(bits, 1335), 10);
        id.a aVar2 = new id.a();
        aVar2.c(21522, 15);
        aVar.u(aVar2);
        if (aVar.m() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.m());
    }

    static void q(g gVar, id.a aVar) {
        aVar.c(gVar.j(), 6);
        aVar.c(b(gVar.j(), 7973), 12);
        if (aVar.m() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.m());
    }

    private static void r(g gVar, yd.a aVar) {
        if (gVar.j() < 2) {
            return;
        }
        int[] iArr = f33109c[gVar.j() - 1];
        for (int i11 : iArr) {
            if (i11 >= 0) {
                for (int i12 : iArr) {
                    if (i12 >= 0 && o(aVar.b(i12, i11))) {
                        h(i12 - 2, i11 - 2, aVar);
                    }
                }
            }
        }
    }

    static void s(g gVar, yd.a aVar) {
        if (gVar.j() < 7) {
            return;
        }
        id.a aVar2 = new id.a();
        q(gVar, aVar2);
        int i11 = 17;
        for (int i12 = 0; i12 < 6; i12++) {
            for (int i13 = 0; i13 < 3; i13++) {
                boolean i14 = aVar2.i(i11);
                i11--;
                aVar.g(i12, (aVar.d() - 11) + i13, i14);
                aVar.g((aVar.d() - 11) + i13, i12, i14);
            }
        }
    }
}
