package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f73713a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f73714b = new StringBuilder();

    private int a(id.a aVar, int[] iArr, StringBuilder sb2) {
        int[] iArr2 = this.f73713a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m11 = aVar.m();
        int i11 = iArr[1];
        int i12 = 0;
        for (int i13 = 0; i13 < 2 && i11 < m11; i13++) {
            int j11 = w.j(aVar, iArr2, i11, w.f73725h);
            sb2.append((char) ((j11 % 10) + 48));
            for (int i14 : iArr2) {
                i11 += i14;
            }
            if (j11 >= 10) {
                i12 |= 1 << (1 - i13);
            }
            if (i13 != 1) {
                i11 = aVar.l(aVar.k(i11));
            }
        }
        if (sb2.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb2.toString()) % 4 == i12) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(str));
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.j b(int i11, id.a aVar, int[] iArr) {
        StringBuilder sb2 = this.f73714b;
        sb2.setLength(0);
        int a11 = a(aVar, iArr, sb2);
        String sb3 = sb2.toString();
        Map c11 = c(sb3);
        float f11 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(sb3, null, new com.google.zxing.k[]{new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, f11), new com.google.zxing.k(a11, f11)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (c11 != null) {
            jVar.g(c11);
        }
        return jVar;
    }
}
