package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.k;
import com.google.zxing.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class FinderPatternFinder {

    /* renamed from: f, reason: collision with root package name */
    private static final EstimatedModuleComparator f33058f = new EstimatedModuleComparator();

    /* renamed from: a, reason: collision with root package name */
    private final id.b f33059a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33061c;

    /* renamed from: e, reason: collision with root package name */
    private final l f33063e;

    /* renamed from: b, reason: collision with root package name */
    private final List f33060b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final int[] f33062d = new int[5];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class EstimatedModuleComparator implements Comparator<d>, Serializable {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return Float.compare(dVar.i(), dVar2.i());
        }
    }

    public FinderPatternFinder(id.b bVar, l lVar) {
        this.f33059a = bVar;
        this.f33063e = lVar;
    }

    private static float a(int[] iArr, int i11) {
        return ((i11 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean b(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int[] k11 = k();
        int i16 = 0;
        while (i11 >= i16 && i12 >= i16 && this.f33059a.g(i12 - i16, i11 - i16)) {
            k11[2] = k11[2] + 1;
            i16++;
        }
        if (k11[2] == 0) {
            return false;
        }
        while (i11 >= i16 && i12 >= i16 && !this.f33059a.g(i12 - i16, i11 - i16)) {
            k11[1] = k11[1] + 1;
            i16++;
        }
        if (k11[1] == 0) {
            return false;
        }
        while (i11 >= i16 && i12 >= i16 && this.f33059a.g(i12 - i16, i11 - i16)) {
            k11[0] = k11[0] + 1;
            i16++;
        }
        if (k11[0] == 0) {
            return false;
        }
        int k12 = this.f33059a.k();
        int n11 = this.f33059a.n();
        int i17 = 1;
        while (true) {
            int i18 = i11 + i17;
            if (i18 >= k12 || (i15 = i12 + i17) >= n11 || !this.f33059a.g(i15, i18)) {
                break;
            }
            k11[2] = k11[2] + 1;
            i17++;
        }
        while (true) {
            int i19 = i11 + i17;
            if (i19 >= k12 || (i14 = i12 + i17) >= n11 || this.f33059a.g(i14, i19)) {
                break;
            }
            k11[3] = k11[3] + 1;
            i17++;
        }
        if (k11[3] == 0) {
            return false;
        }
        while (true) {
            int i20 = i11 + i17;
            if (i20 >= k12 || (i13 = i12 + i17) >= n11 || !this.f33059a.g(i13, i20)) {
                break;
            }
            k11[4] = k11[4] + 1;
            i17++;
        }
        if (k11[4] == 0) {
            return false;
        }
        return j(k11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0086, code lost:
    
        if (r11 >= r1) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008c, code lost:
    
        if (r0.g(r11, r12) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008e, code lost:
    
        r9 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0090, code lost:
    
        if (r9 >= r13) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        r2[4] = r9 + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0099, code lost:
    
        r12 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009b, code lost:
    
        if (r12 < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b1, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r12) - r14) * 5) < r14) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b3, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b8, code lost:
    
        if (i(r2) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
    
        return a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float c(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            id.b r0 = r10.f33059a
            int r1 = r0.n()
            int[] r2 = r10.k()
            r3 = r11
        Lb:
            r4 = 2
            r5 = 1
            if (r3 < 0) goto L1d
            boolean r6 = r0.g(r3, r12)
            if (r6 == 0) goto L1d
            r6 = r2[r4]
            int r6 = r6 + r5
            r2[r4] = r6
            int r3 = r3 + (-1)
            goto Lb
        L1d:
            r6 = 2143289344(0x7fc00000, float:NaN)
            if (r3 >= 0) goto L22
            return r6
        L22:
            if (r3 < 0) goto L35
            boolean r7 = r0.g(r3, r12)
            if (r7 != 0) goto L35
            r7 = r2[r5]
            if (r7 > r13) goto L35
            int r7 = r7 + 1
            r2[r5] = r7
            int r3 = r3 + (-1)
            goto L22
        L35:
            if (r3 < 0) goto Lbe
            r7 = r2[r5]
            if (r7 <= r13) goto L3d
            goto Lbe
        L3d:
            r7 = 0
            if (r3 < 0) goto L51
            boolean r8 = r0.g(r3, r12)
            if (r8 == 0) goto L51
            r8 = r2[r7]
            if (r8 > r13) goto L51
            int r8 = r8 + 1
            r2[r7] = r8
            int r3 = r3 + (-1)
            goto L3d
        L51:
            r3 = r2[r7]
            if (r3 <= r13) goto L56
            return r6
        L56:
            int r11 = r11 + r5
        L57:
            if (r11 >= r1) goto L67
            boolean r3 = r0.g(r11, r12)
            if (r3 == 0) goto L67
            r3 = r2[r4]
            int r3 = r3 + r5
            r2[r4] = r3
            int r11 = r11 + 1
            goto L57
        L67:
            if (r11 != r1) goto L6a
            return r6
        L6a:
            r3 = 3
            if (r11 >= r1) goto L7e
            boolean r8 = r0.g(r11, r12)
            if (r8 != 0) goto L7e
            r8 = r2[r3]
            if (r8 >= r13) goto L7e
            int r8 = r8 + 1
            r2[r3] = r8
            int r11 = r11 + 1
            goto L6a
        L7e:
            if (r11 == r1) goto Lbe
            r8 = r2[r3]
            if (r8 < r13) goto L85
            goto Lbe
        L85:
            r8 = 4
            if (r11 >= r1) goto L99
            boolean r9 = r0.g(r11, r12)
            if (r9 == 0) goto L99
            r9 = r2[r8]
            if (r9 >= r13) goto L99
            int r9 = r9 + 1
            r2[r8] = r9
            int r11 = r11 + 1
            goto L85
        L99:
            r12 = r2[r8]
            if (r12 < r13) goto L9e
            return r6
        L9e:
            r13 = r2[r7]
            r0 = r2[r5]
            int r13 = r13 + r0
            r0 = r2[r4]
            int r13 = r13 + r0
            r0 = r2[r3]
            int r13 = r13 + r0
            int r13 = r13 + r12
            int r13 = r13 - r14
            int r12 = java.lang.Math.abs(r13)
            int r12 = r12 * 5
            if (r12 < r14) goto Lb4
            return r6
        Lb4:
            boolean r12 = i(r2)
            if (r12 == 0) goto Lbe
            float r6 = a(r2, r11)
        Lbe:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.c(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0086, code lost:
    
        if (r11 >= r1) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008c, code lost:
    
        if (r0.g(r12, r11) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008e, code lost:
    
        r9 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0090, code lost:
    
        if (r9 >= r13) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        r2[4] = r9 + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0099, code lost:
    
        r12 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009b, code lost:
    
        if (r12 < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b2, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r12) - r14) * 5) < (r14 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b4, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b9, code lost:
    
        if (i(r2) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bf, code lost:
    
        return a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float d(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            id.b r0 = r10.f33059a
            int r1 = r0.k()
            int[] r2 = r10.k()
            r3 = r11
        Lb:
            r4 = 2
            r5 = 1
            if (r3 < 0) goto L1d
            boolean r6 = r0.g(r12, r3)
            if (r6 == 0) goto L1d
            r6 = r2[r4]
            int r6 = r6 + r5
            r2[r4] = r6
            int r3 = r3 + (-1)
            goto Lb
        L1d:
            r6 = 2143289344(0x7fc00000, float:NaN)
            if (r3 >= 0) goto L22
            return r6
        L22:
            if (r3 < 0) goto L35
            boolean r7 = r0.g(r12, r3)
            if (r7 != 0) goto L35
            r7 = r2[r5]
            if (r7 > r13) goto L35
            int r7 = r7 + 1
            r2[r5] = r7
            int r3 = r3 + (-1)
            goto L22
        L35:
            if (r3 < 0) goto Lbf
            r7 = r2[r5]
            if (r7 <= r13) goto L3d
            goto Lbf
        L3d:
            r7 = 0
            if (r3 < 0) goto L51
            boolean r8 = r0.g(r12, r3)
            if (r8 == 0) goto L51
            r8 = r2[r7]
            if (r8 > r13) goto L51
            int r8 = r8 + 1
            r2[r7] = r8
            int r3 = r3 + (-1)
            goto L3d
        L51:
            r3 = r2[r7]
            if (r3 <= r13) goto L56
            return r6
        L56:
            int r11 = r11 + r5
        L57:
            if (r11 >= r1) goto L67
            boolean r3 = r0.g(r12, r11)
            if (r3 == 0) goto L67
            r3 = r2[r4]
            int r3 = r3 + r5
            r2[r4] = r3
            int r11 = r11 + 1
            goto L57
        L67:
            if (r11 != r1) goto L6a
            return r6
        L6a:
            r3 = 3
            if (r11 >= r1) goto L7e
            boolean r8 = r0.g(r12, r11)
            if (r8 != 0) goto L7e
            r8 = r2[r3]
            if (r8 >= r13) goto L7e
            int r8 = r8 + 1
            r2[r3] = r8
            int r11 = r11 + 1
            goto L6a
        L7e:
            if (r11 == r1) goto Lbf
            r8 = r2[r3]
            if (r8 < r13) goto L85
            goto Lbf
        L85:
            r8 = 4
            if (r11 >= r1) goto L99
            boolean r9 = r0.g(r12, r11)
            if (r9 == 0) goto L99
            r9 = r2[r8]
            if (r9 >= r13) goto L99
            int r9 = r9 + 1
            r2[r8] = r9
            int r11 = r11 + 1
            goto L85
        L99:
            r12 = r2[r8]
            if (r12 < r13) goto L9e
            return r6
        L9e:
            r13 = r2[r7]
            r0 = r2[r5]
            int r13 = r13 + r0
            r0 = r2[r4]
            int r13 = r13 + r0
            r0 = r2[r3]
            int r13 = r13 + r0
            int r13 = r13 + r12
            int r13 = r13 - r14
            int r12 = java.lang.Math.abs(r13)
            int r12 = r12 * 5
            int r14 = r14 * r4
            if (r12 < r14) goto Lb5
            return r6
        Lb5:
            boolean r12 = i(r2)
            if (r12 == 0) goto Lbf
            float r6 = a(r2, r11)
        Lbf:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.d(int, int, int, int):float");
    }

    protected static void e(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    protected static void f(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private int h() {
        if (this.f33060b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f33060b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f33061c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    protected static boolean i(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 5; i12++) {
            int i13 = iArr[i12];
            if (i13 == 0) {
                return false;
            }
            i11 += i13;
        }
        if (i11 < 7) {
            return false;
        }
        float f11 = i11 / 7.0f;
        float f12 = f11 / 2.0f;
        return Math.abs(f11 - ((float) iArr[0])) < f12 && Math.abs(f11 - ((float) iArr[1])) < f12 && Math.abs((f11 * 3.0f) - ((float) iArr[2])) < 3.0f * f12 && Math.abs(f11 - ((float) iArr[3])) < f12 && Math.abs(f11 - ((float) iArr[4])) < f12;
    }

    protected static boolean j(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 5; i12++) {
            int i13 = iArr[i12];
            if (i13 == 0) {
                return false;
            }
            i11 += i13;
        }
        if (i11 < 7) {
            return false;
        }
        float f11 = i11 / 7.0f;
        float f12 = f11 / 1.333f;
        return Math.abs(f11 - ((float) iArr[0])) < f12 && Math.abs(f11 - ((float) iArr[1])) < f12 && Math.abs((f11 * 3.0f) - ((float) iArr[2])) < 3.0f * f12 && Math.abs(f11 - ((float) iArr[3])) < f12 && Math.abs(f11 - ((float) iArr[4])) < f12;
    }

    private int[] k() {
        e(this.f33062d);
        return this.f33062d;
    }

    private boolean m() {
        int size = this.f33060b.size();
        float f11 = 0.0f;
        int i11 = 0;
        float f12 = 0.0f;
        for (d dVar : this.f33060b) {
            if (dVar.h() >= 2) {
                i11++;
                f12 += dVar.i();
            }
        }
        if (i11 < 3) {
            return false;
        }
        float f13 = f12 / size;
        Iterator it = this.f33060b.iterator();
        while (it.hasNext()) {
            f11 += Math.abs(((d) it.next()).i() - f13);
        }
        return f11 <= f12 * 0.05f;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.zxing.qrcode.detector.d[] n() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.n():com.google.zxing.qrcode.detector.d[]");
    }

    private static double o(d dVar, d dVar2) {
        double c11 = dVar.c() - dVar2.c();
        double d11 = dVar.d() - dVar2.d();
        return (c11 * c11) + (d11 * d11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e g(Map map) {
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int k11 = this.f33059a.k();
        int n11 = this.f33059a.n();
        int i11 = (k11 * 3) / 388;
        if (i11 < 3 || z10) {
            i11 = 3;
        }
        int[] iArr = new int[5];
        int i12 = i11 - 1;
        boolean z11 = false;
        while (i12 < k11 && !z11) {
            e(iArr);
            int i13 = 0;
            int i14 = 0;
            while (i13 < n11) {
                if (this.f33059a.g(i13, i12)) {
                    if ((i14 & 1) == 1) {
                        i14++;
                    }
                    iArr[i14] = iArr[i14] + 1;
                } else if ((i14 & 1) != 0) {
                    iArr[i14] = iArr[i14] + 1;
                } else if (i14 == 4) {
                    if (!i(iArr)) {
                        f(iArr);
                    } else if (l(iArr, i12, i13)) {
                        if (this.f33061c) {
                            z11 = m();
                        } else {
                            int h11 = h();
                            int i15 = iArr[2];
                            if (h11 > i15) {
                                i12 += (h11 - i15) - 2;
                                i13 = n11 - 1;
                            }
                        }
                        e(iArr);
                        i11 = 2;
                        i14 = 0;
                    } else {
                        f(iArr);
                    }
                    i14 = 3;
                } else {
                    i14++;
                    iArr[i14] = iArr[i14] + 1;
                }
                i13++;
            }
            if (i(iArr) && l(iArr, i12, n11)) {
                i11 = iArr[0];
                if (this.f33061c) {
                    z11 = m();
                }
            }
            i12 += i11;
        }
        d[] n12 = n();
        k.e(n12);
        return new e(n12);
    }

    protected final boolean l(int[] iArr, int i11, int i12) {
        int i13 = 0;
        int i14 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a11 = (int) a(iArr, i12);
        float d11 = d(i11, a11, iArr[2], i14);
        if (!Float.isNaN(d11)) {
            int i15 = (int) d11;
            float c11 = c(a11, i15, iArr[2], i14);
            if (!Float.isNaN(c11) && b(i15, (int) c11)) {
                float f11 = i14 / 7.0f;
                while (true) {
                    if (i13 < this.f33060b.size()) {
                        d dVar = (d) this.f33060b.get(i13);
                        if (dVar.f(f11, d11, c11)) {
                            this.f33060b.set(i13, dVar.g(d11, c11, f11));
                            break;
                        }
                        i13++;
                    } else {
                        d dVar2 = new d(c11, d11, f11);
                        this.f33060b.add(dVar2);
                        l lVar = this.f33063e;
                        if (lVar != null) {
                            lVar.a(dVar2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
