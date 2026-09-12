package qd;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class p implements com.google.zxing.i {
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077 A[Catch: ReaderException -> 0x00c8, TRY_LEAVE, TryCatch #3 {ReaderException -> 0x00c8, blocks: (B:32:0x0071, B:34:0x0077), top: B:31:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ce A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.zxing.j d(com.google.zxing.b r22, java.util.Map r23) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: qd.p.d(com.google.zxing.b, java.util.Map):com.google.zxing.j");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float e(int[] iArr, int[] iArr2, float f11) {
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            i11 += iArr[i13];
            i12 += iArr2[i13];
        }
        if (i11 < i12) {
            return Float.POSITIVE_INFINITY;
        }
        float f12 = i11;
        float f13 = f12 / i12;
        float f14 = f11 * f13;
        float f15 = 0.0f;
        for (int i14 = 0; i14 < length; i14++) {
            float f16 = iArr2[i14] * f13;
            float f17 = iArr[i14];
            float f18 = f17 > f16 ? f17 - f16 : f16 - f17;
            if (f18 > f14) {
                return Float.POSITIVE_INFINITY;
            }
            f15 += f18;
        }
        return f15 / f12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(id.a aVar, int i11, int[] iArr) {
        int length = iArr.length;
        int i12 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int m11 = aVar.m();
        if (i11 >= m11) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z10 = !aVar.i(i11);
        while (i11 < m11) {
            if (aVar.i(i11) != z10) {
                iArr[i12] = iArr[i12] + 1;
            } else {
                i12++;
                if (i12 == length) {
                    break;
                }
                iArr[i12] = 1;
                z10 = !z10;
            }
            i11++;
        }
        if (i12 != length) {
            if (i12 != length - 1 || i11 != m11) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void g(id.a aVar, int i11, int[] iArr) {
        int length = iArr.length;
        boolean i12 = aVar.i(i11);
        while (i11 > 0 && length >= 0) {
            i11--;
            if (aVar.i(i11) != i12) {
                length--;
                i12 = !i12;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        f(aVar, i11 + 1, iArr);
    }

    @Override // com.google.zxing.i
    public com.google.zxing.j a(com.google.zxing.b bVar, Map map) {
        try {
            return d(bVar, map);
        } catch (NotFoundException e11) {
            if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER) || !bVar.e()) {
                throw e11;
            }
            com.google.zxing.b f11 = bVar.f();
            com.google.zxing.j d11 = d(f11, map);
            Map d12 = d11.d();
            int i11 = 270;
            if (d12 != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (d12.containsKey(resultMetadataType)) {
                    i11 = (((Integer) d12.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            d11.h(ResultMetadataType.ORIENTATION, Integer.valueOf(i11));
            com.google.zxing.k[] e12 = d11.e();
            if (e12 != null) {
                int c11 = f11.c();
                for (int i12 = 0; i12 < e12.length; i12++) {
                    e12[i12] = new com.google.zxing.k((c11 - e12[i12].d()) - 1.0f, e12[i12].c());
                }
            }
            return d11;
        }
    }

    @Override // com.google.zxing.i
    public com.google.zxing.j b(com.google.zxing.b bVar) {
        return a(bVar, null);
    }

    public abstract com.google.zxing.j c(int i11, id.a aVar, Map map);

    @Override // com.google.zxing.i
    public void reset() {
    }
}
