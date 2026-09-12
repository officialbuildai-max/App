package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f73715c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a, reason: collision with root package name */
    private final int[] f73716a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f73717b = new StringBuilder();

    private int a(id.a aVar, int[] iArr, StringBuilder sb2) {
        int[] iArr2 = this.f73716a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m11 = aVar.m();
        int i11 = iArr[1];
        int i12 = 0;
        for (int i13 = 0; i13 < 5 && i11 < m11; i13++) {
            int j11 = w.j(aVar, iArr2, i11, w.f73725h);
            sb2.append((char) ((j11 % 10) + 48));
            for (int i14 : iArr2) {
                i11 += i14;
            }
            if (j11 >= 10) {
                i12 |= 1 << (4 - i13);
            }
            if (i13 != 4) {
                i11 = aVar.l(aVar.k(i11));
            }
        }
        if (sb2.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (d(sb2.toString()) == c(i12)) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int c(int i11) {
        for (int i12 = 0; i12 < 10; i12++) {
            if (i11 == f73715c[i12]) {
                return i12;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        for (int i12 = length - 2; i12 >= 0; i12 -= 2) {
            i11 += charSequence.charAt(i12) - '0';
        }
        int i13 = i11 * 3;
        for (int i14 = length - 1; i14 >= 0; i14 -= 2) {
            i13 += charSequence.charAt(i14) - '0';
        }
        return (i13 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (r5.equals("90000") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String e(java.lang.String r5) {
        /*
            r0 = 1
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 48
            if (r2 == r3) goto L4d
            r3 = 53
            if (r2 == r3) goto L4a
            r3 = 57
            java.lang.String r4 = ""
            if (r2 == r3) goto L15
            goto L4f
        L15:
            r2 = -1
            int r3 = r5.hashCode()
            switch(r3) {
                case 54118329: goto L35;
                case 54395376: goto L2a;
                case 54395377: goto L1f;
                default: goto L1d;
            }
        L1d:
            r1 = r2
            goto L3e
        L1f:
            java.lang.String r1 = "99991"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L28
            goto L1d
        L28:
            r1 = 2
            goto L3e
        L2a:
            java.lang.String r1 = "99990"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L33
            goto L1d
        L33:
            r1 = r0
            goto L3e
        L35:
            java.lang.String r3 = "90000"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L3e
            goto L1d
        L3e:
            switch(r1) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L4f
        L42:
            java.lang.String r5 = "0.00"
            return r5
        L45:
            java.lang.String r5 = "Used"
            return r5
        L48:
            r5 = 0
            return r5
        L4a:
            java.lang.String r4 = "$"
            goto L4f
        L4d:
            java.lang.String r4 = "£"
        L4f:
            java.lang.String r5 = r5.substring(r0)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L75
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "0"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            goto L79
        L75:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L79:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: qd.u.e(java.lang.String):java.lang.String");
    }

    private static Map f(String str) {
        String e11;
        if (str.length() != 5 || (e11 = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) e11);
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.j b(int i11, id.a aVar, int[] iArr) {
        StringBuilder sb2 = this.f73717b;
        sb2.setLength(0);
        int a11 = a(aVar, iArr, sb2);
        String sb3 = sb2.toString();
        Map f11 = f(sb3);
        float f12 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(sb3, null, new com.google.zxing.k[]{new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, f12), new com.google.zxing.k(a11, f12)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (f11 != null) {
            jVar.g(f11);
        }
        return jVar;
    }
}
