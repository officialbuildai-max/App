package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Map;

/* loaded from: classes5.dex */
public final class l extends p {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f73698b = {6, 8, 10, 12, 14};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f73699c = {1, 1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f73700d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: e, reason: collision with root package name */
    private static final int[][] f73701e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    private int f73702a = -1;

    private static int h(int[] iArr) {
        int length = f73701e.length;
        float f11 = 0.38f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float e11 = p.e(iArr, f73701e[i12], 0.5f);
            if (e11 < f11) {
                i11 = i12;
                f11 = e11;
            } else if (e11 == f11) {
                i11 = -1;
            }
        }
        if (i11 >= 0) {
            return i11 % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] i(id.a aVar) {
        int[] l11;
        aVar.q();
        try {
            int m11 = m(aVar);
            try {
                l11 = l(aVar, m11, f73700d[0]);
            } catch (NotFoundException unused) {
                l11 = l(aVar, m11, f73700d[1]);
            }
            n(aVar, l11[0]);
            int i11 = l11[0];
            l11[0] = aVar.m() - l11[1];
            l11[1] = aVar.m() - i11;
            return l11;
        } finally {
            aVar.q();
        }
    }

    private static void j(id.a aVar, int i11, int i12, StringBuilder sb2) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i11 < i12) {
            p.f(aVar, i11, iArr);
            for (int i13 = 0; i13 < 5; i13++) {
                int i14 = i13 * 2;
                iArr2[i13] = iArr[i14];
                iArr3[i13] = iArr[i14 + 1];
            }
            sb2.append((char) (h(iArr2) + 48));
            sb2.append((char) (h(iArr3) + 48));
            for (int i15 = 0; i15 < 10; i15++) {
                i11 += iArr[i15];
            }
        }
    }

    private int[] k(id.a aVar) {
        int[] l11 = l(aVar, m(aVar), f73699c);
        int i11 = l11[1];
        int i12 = l11[0];
        this.f73702a = (i11 - i12) / 4;
        n(aVar, i12);
        return l11;
    }

    private static int[] l(id.a aVar, int i11, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int m11 = aVar.m();
        int i12 = i11;
        boolean z10 = false;
        int i13 = 0;
        while (i11 < m11) {
            if (aVar.i(i11) != z10) {
                iArr2[i13] = iArr2[i13] + 1;
            } else {
                if (i13 != length - 1) {
                    i13++;
                } else {
                    if (p.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i12, i11};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i14 = i13 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i13--;
                }
                iArr2[i13] = 1;
                z10 = !z10;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int m(id.a aVar) {
        int m11 = aVar.m();
        int k11 = aVar.k(0);
        if (k11 != m11) {
            return k11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void n(id.a r3, int r4) {
        /*
            r2 = this;
            int r0 = r2.f73702a
            int r0 = r0 * 10
            int r0 = java.lang.Math.min(r0, r4)
            int r4 = r4 + (-1)
        La:
            if (r0 <= 0) goto L1a
            if (r4 < 0) goto L1a
            boolean r1 = r3.i(r4)
            if (r1 == 0) goto L15
            goto L1a
        L15:
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto La
        L1a:
            if (r0 != 0) goto L1d
            return
        L1d:
            com.google.zxing.NotFoundException r3 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: qd.l.n(id.a, int):void");
    }

    @Override // qd.p
    public com.google.zxing.j c(int i11, id.a aVar, Map map) {
        boolean z10;
        int[] k11 = k(aVar);
        int[] i12 = i(aVar);
        StringBuilder sb2 = new StringBuilder(20);
        j(aVar, k11[1], i12[0], sb2);
        String sb3 = sb2.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f73698b;
        }
        int length = sb3.length();
        int length2 = iArr.length;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= length2) {
                z10 = false;
                break;
            }
            int i15 = iArr[i13];
            if (length == i15) {
                z10 = true;
                break;
            }
            if (i15 > i14) {
                i14 = i15;
            }
            i13++;
        }
        if (!z10 && length > i14) {
            z10 = true;
        }
        if (!z10) {
            throw FormatException.getFormatInstance();
        }
        float f11 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(sb3, null, new com.google.zxing.k[]{new com.google.zxing.k(k11[1], f11), new com.google.zxing.k(i12[0], f11)}, BarcodeFormat.ITF);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]I0");
        return jVar;
    }
}
