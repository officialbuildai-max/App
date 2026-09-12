package vd;

import com.google.zxing.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f77385a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f77386b = {6, 2, 7, 3};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f77387c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f77388d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f77389e = {0, 180, 270, 90};

    private static id.b a(id.b bVar, int i11) {
        if (i11 % 360 == 0) {
            return bVar;
        }
        id.b clone = bVar.clone();
        clone.o(i11);
        return clone;
    }

    private static void b(k[] kVarArr, k[] kVarArr2, int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            kVarArr[iArr[i11]] = kVarArr2[i11];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r3.hasNext() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        r4 = (com.google.zxing.k[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r7 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (r4 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List c(boolean r8, id.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
            r3 = r2
        L8:
            r4 = r3
        L9:
            int r5 = r9.k()
            if (r2 >= r5) goto L7a
            com.google.zxing.k[] r3 = g(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L50
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L50
            if (r4 != 0) goto L20
            goto L7a
        L20:
            java.util.Iterator r3 = r0.iterator()
        L24:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L4c
            java.lang.Object r4 = r3.next()
            com.google.zxing.k[] r4 = (com.google.zxing.k[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L3e
            float r2 = (float) r2
            float r7 = r7.d()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L3e:
            r4 = r4[r5]
            if (r4 == 0) goto L24
            float r4 = r4.d()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L24
        L4c:
            int r2 = r2 + 5
            r3 = r1
            goto L8
        L50:
            r0.add(r3)
            if (r8 != 0) goto L56
            goto L7a
        L56:
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L69
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
        L66:
            int r2 = (int) r2
            r3 = r4
            goto L78
        L69:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
            goto L66
        L78:
            r4 = r6
            goto L9
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: vd.a.c(boolean, id.b):java.util.List");
    }

    public static b d(com.google.zxing.b bVar, Map map, boolean z10) {
        id.b a11 = bVar.a();
        for (int i11 : f77389e) {
            id.b a12 = a(a11, i11);
            List c11 = c(z10, a12);
            if (!c11.isEmpty()) {
                return new b(a12, c11, i11);
            }
        }
        return new b(a11, new ArrayList(), 0);
    }

    private static int[] e(id.b bVar, int i11, int i12, int i13, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i14 = 0;
        while (bVar.g(i11, i12) && i11 > 0) {
            int i15 = i14 + 1;
            if (i14 >= 3) {
                break;
            }
            i11--;
            i14 = i15;
        }
        int length = iArr.length;
        int i16 = i11;
        int i17 = 0;
        boolean z10 = false;
        while (i11 < i13) {
            if (bVar.g(i11, i12) != z10) {
                iArr2[i17] = iArr2[i17] + 1;
            } else {
                if (i17 != length - 1) {
                    i17++;
                } else {
                    if (h(iArr2, iArr) < 0.42f) {
                        return new int[]{i16, i11};
                    }
                    i16 += iArr2[0] + iArr2[1];
                    int i18 = i17 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i18);
                    iArr2[i18] = 0;
                    iArr2[i17] = 0;
                    i17--;
                }
                iArr2[i17] = 1;
                z10 = !z10;
            }
            i11++;
        }
        if (i17 != length - 1 || h(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i16, i11 - 1};
    }

    private static k[] f(id.b bVar, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        boolean z10;
        int i16;
        k[] kVarArr = new k[4];
        int[] iArr2 = new int[iArr.length];
        int i17 = i13;
        while (true) {
            if (i17 >= i11) {
                z10 = false;
                break;
            }
            int[] e11 = e(bVar, i14, i17, i12, iArr, iArr2);
            if (e11 != null) {
                int i18 = i17;
                int[] iArr3 = e11;
                while (i18 > 0) {
                    int i19 = i18 - 1;
                    int[] e12 = e(bVar, i14, i19, i12, iArr, iArr2);
                    if (e12 == null) {
                        break;
                    }
                    iArr3 = e12;
                    i18 = i19;
                }
                float f11 = i18;
                kVarArr[0] = new k(iArr3[0], f11);
                kVarArr[1] = new k(iArr3[1], f11);
                z10 = true;
                i17 = i18;
            } else {
                i17 += 5;
            }
        }
        int i20 = i17 + 1;
        if (z10) {
            int[] iArr4 = {(int) kVarArr[0].c(), (int) kVarArr[1].c()};
            int i21 = i20;
            int i22 = 0;
            while (true) {
                if (i21 >= i11) {
                    i16 = i22;
                    break;
                }
                i16 = i22;
                int[] e13 = e(bVar, iArr4[0], i21, i12, iArr, iArr2);
                if (e13 != null && Math.abs(iArr4[0] - e13[0]) < 5 && Math.abs(iArr4[1] - e13[1]) < 5) {
                    iArr4 = e13;
                    i22 = 0;
                } else {
                    if (i16 > 25) {
                        break;
                    }
                    i22 = i16 + 1;
                }
                i21++;
            }
            i20 = i21 - (i16 + 1);
            float f12 = i20;
            kVarArr[2] = new k(iArr4[0], f12);
            kVarArr[3] = new k(iArr4[1], f12);
        }
        if (i20 - i17 < i15) {
            Arrays.fill(kVarArr, (Object) null);
        }
        return kVarArr;
    }

    private static k[] g(id.b bVar, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int k11 = bVar.k();
        int n11 = bVar.n();
        k[] kVarArr = new k[8];
        b(kVarArr, f(bVar, k11, n11, i11, i12, 10, f77387c), f77385a);
        k kVar = kVarArr[4];
        if (kVar != null) {
            i12 = (int) kVar.c();
            i11 = (int) kVarArr[4].d();
            if (kVarArr[5] != null) {
                i13 = i11;
                i14 = i12;
                i15 = (int) Math.max((((int) r0.d()) - i11) * 0.5f, 10.0f);
                b(kVarArr, f(bVar, k11, n11, i13, i14, i15, f77388d), f77386b);
                return kVarArr;
            }
        }
        i13 = i11;
        i14 = i12;
        i15 = 10;
        b(kVarArr, f(bVar, k11, n11, i13, i14, i15, f77388d), f77386b);
        return kVarArr;
    }

    private static float h(int[] iArr, int[] iArr2) {
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
        float f11 = i11;
        float f12 = f11 / i12;
        float f13 = 0.8f * f12;
        float f14 = 0.0f;
        for (int i14 = 0; i14 < length; i14++) {
            float f15 = iArr2[i14] * f12;
            float f16 = iArr[i14];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }
}
