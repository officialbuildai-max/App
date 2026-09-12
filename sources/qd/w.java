package qd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class w extends p {

    /* renamed from: d, reason: collision with root package name */
    static final int[] f73721d = {1, 1, 1};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f73722e = {1, 1, 1, 1, 1};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f73723f = {1, 1, 1, 1, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    static final int[][] f73724g;

    /* renamed from: h, reason: collision with root package name */
    static final int[][] f73725h;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f73726a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final v f73727b = new v();

    /* renamed from: c, reason: collision with root package name */
    private final k f73728c = new k();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f73724g = iArr;
        int[][] iArr2 = new int[20];
        f73725h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i11 = 10; i11 < 20; i11++) {
            int[] iArr3 = f73724g[i11 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i12 = 0; i12 < iArr3.length; i12++) {
                iArr4[i12] = iArr3[(iArr3.length - i12) - 1];
            }
            f73725h[i11] = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i11 = length - 1;
        return r(charSequence.subSequence(0, i11)) == Character.digit(charSequence.charAt(i11), 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(id.a aVar, int[] iArr, int i11, int[][] iArr2) {
        p.f(aVar, i11, iArr);
        int length = iArr2.length;
        float f11 = 0.48f;
        int i12 = -1;
        for (int i13 = 0; i13 < length; i13++) {
            float e11 = p.e(iArr, iArr2[i13], 0.7f);
            if (e11 < f11) {
                i12 = i13;
                f11 = e11;
            }
        }
        if (i12 >= 0) {
            return i12;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] n(id.a aVar, int i11, boolean z10, int[] iArr) {
        return o(aVar, i11, z10, iArr, new int[iArr.length]);
    }

    private static int[] o(id.a aVar, int i11, boolean z10, int[] iArr, int[] iArr2) {
        int m11 = aVar.m();
        int l11 = z10 ? aVar.l(i11) : aVar.k(i11);
        int length = iArr.length;
        boolean z11 = z10;
        int i12 = 0;
        int i13 = l11;
        while (l11 < m11) {
            if (aVar.i(l11) != z11) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 != length - 1) {
                    i12++;
                } else {
                    if (p.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i13, l11};
                    }
                    i13 += iArr2[0] + iArr2[1];
                    int i14 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i12] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z11 = !z11;
            }
            l11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] p(id.a aVar) {
        int[] iArr = new int[f73721d.length];
        int[] iArr2 = null;
        boolean z10 = false;
        int i11 = 0;
        while (!z10) {
            int[] iArr3 = f73721d;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = o(aVar, i11, false, iArr3, iArr);
            int i12 = iArr2[0];
            int i13 = iArr2[1];
            int i14 = i12 - (i13 - i12);
            if (i14 >= 0) {
                z10 = aVar.o(i14, i12, false);
            }
            i11 = i13;
        }
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        for (int i12 = length - 1; i12 >= 0; i12 -= 2) {
            int charAt = charSequence.charAt(i12) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i11 += charAt;
        }
        int i13 = i11 * 3;
        for (int i14 = length - 2; i14 >= 0; i14 -= 2) {
            int charAt2 = charSequence.charAt(i14) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i13 += charAt2;
        }
        return (1000 - i13) % 10;
    }

    @Override // qd.p
    public com.google.zxing.j c(int i11, id.a aVar, Map map) {
        return m(i11, aVar, p(aVar), map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(String str) {
        return i(str);
    }

    int[] k(id.a aVar, int i11) {
        return n(aVar, i11, false, f73721d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int l(id.a aVar, int[] iArr, StringBuilder sb2);

    public com.google.zxing.j m(int i11, id.a aVar, int[] iArr, Map map) {
        int i12;
        String c11;
        com.google.zxing.l lVar = map == null ? null : (com.google.zxing.l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, i11));
        }
        StringBuilder sb2 = this.f73726a;
        sb2.setLength(0);
        int l11 = l(aVar, iArr, sb2);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k(l11, i11));
        }
        int[] k11 = k(aVar, l11);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k((k11[0] + k11[1]) / 2.0f, i11));
        }
        int i13 = k11[1];
        int i14 = (i13 - k11[0]) + i13;
        if (i14 >= aVar.m() || !aVar.o(i13, i14, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String sb3 = sb2.toString();
        if (sb3.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!h(sb3)) {
            throw ChecksumException.getChecksumInstance();
        }
        BarcodeFormat q11 = q();
        float f11 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(sb3, null, new com.google.zxing.k[]{new com.google.zxing.k((iArr[1] + iArr[0]) / 2.0f, f11), new com.google.zxing.k((k11[1] + k11[0]) / 2.0f, f11)}, q11);
        try {
            com.google.zxing.j a11 = this.f73727b.a(i11, aVar, k11[1]);
            jVar.h(ResultMetadataType.UPC_EAN_EXTENSION, a11.f());
            jVar.g(a11.d());
            jVar.a(a11.e());
            i12 = a11.f().length();
        } catch (ReaderException unused) {
            i12 = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            for (int i15 : iArr2) {
                if (i12 != i15) {
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        if ((q11 == BarcodeFormat.EAN_13 || q11 == BarcodeFormat.UPC_A) && (c11 = this.f73728c.c(sb3)) != null) {
            jVar.h(ResultMetadataType.POSSIBLE_COUNTRY, c11);
        }
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]E" + (q11 == BarcodeFormat.EAN_8 ? 4 : 0));
        return jVar;
    }

    abstract BarcodeFormat q();
}
