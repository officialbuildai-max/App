package rd;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qd.p;

/* loaded from: classes5.dex */
public final class e extends a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f74446i = {1, 10, 34, 70, 126};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f74447j = {4, 20, 48, 81};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f74448k = {0, 161, 961, 2015, 2715};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f74449l = {0, 336, 1036, 1516};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f74450m = {8, 6, 4, 3, 1};

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f74451n = {2, 4, 6, 8};

    /* renamed from: o, reason: collision with root package name */
    private static final int[][] f74452o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: g, reason: collision with root package name */
    private final List f74453g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List f74454h = new ArrayList();

    private static void r(Collection collection, d dVar) {
        if (dVar == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0028, code lost:
    
        if (r1 < 4) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x002a, code lost:
    
        r2 = true;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x002d, code lost:
    
        r2 = false;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0044, code lost:
    
        if (r1 < 4) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void s(boolean r10, int r11) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rd.e.s(boolean, int):void");
    }

    private static boolean t(d dVar, d dVar2) {
        int a11 = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c11 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c11 > 72) {
            c11--;
        }
        if (c11 > 8) {
            c11--;
        }
        return a11 == c11;
    }

    private static j u(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb2 = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(valueOf);
        int i11 = 0;
        for (int i12 = 0; i12 < 13; i12++) {
            int charAt = sb2.charAt(i12) - '0';
            if ((i12 & 1) == 0) {
                charAt *= 3;
            }
            i11 += charAt;
        }
        int i13 = 10 - (i11 % 10);
        if (i13 == 10) {
            i13 = 0;
        }
        sb2.append(i13);
        k[] a11 = dVar.d().a();
        k[] a12 = dVar2.d().a();
        j jVar = new j(sb2.toString(), null, new k[]{a11[0], a11[1], a12[0], a12[1]}, BarcodeFormat.RSS_14);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return jVar;
    }

    private b v(id.a aVar, c cVar, boolean z10) {
        int[] i11 = i();
        Arrays.fill(i11, 0);
        if (z10) {
            p.g(aVar, cVar.b()[0], i11);
        } else {
            p.f(aVar, cVar.b()[1], i11);
            int i12 = 0;
            for (int length = i11.length - 1; i12 < length; length--) {
                int i13 = i11[i12];
                i11[i12] = i11[length];
                i11[length] = i13;
                i12++;
            }
        }
        int i14 = z10 ? 16 : 15;
        float d11 = jd.a.d(i11) / i14;
        int[] m11 = m();
        int[] k11 = k();
        float[] n11 = n();
        float[] l11 = l();
        for (int i15 = 0; i15 < i11.length; i15++) {
            float f11 = i11[i15] / d11;
            int i16 = (int) (0.5f + f11);
            if (i16 < 1) {
                i16 = 1;
            } else if (i16 > 8) {
                i16 = 8;
            }
            int i17 = i15 / 2;
            if ((i15 & 1) == 0) {
                m11[i17] = i16;
                n11[i17] = f11 - i16;
            } else {
                k11[i17] = i16;
                l11[i17] = f11 - i16;
            }
        }
        s(z10, i14);
        int i18 = 0;
        int i19 = 0;
        for (int length2 = m11.length - 1; length2 >= 0; length2--) {
            int i20 = m11[length2];
            i18 = (i18 * 9) + i20;
            i19 += i20;
        }
        int i21 = 0;
        int i22 = 0;
        for (int length3 = k11.length - 1; length3 >= 0; length3--) {
            int i23 = k11[length3];
            i21 = (i21 * 9) + i23;
            i22 += i23;
        }
        int i24 = i18 + (i21 * 3);
        if (!z10) {
            if ((i22 & 1) != 0 || i22 > 10 || i22 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i25 = (10 - i22) / 2;
            int i26 = f74451n[i25];
            return new b((f.b(k11, 9 - i26, false) * f74447j[i25]) + f.b(m11, i26, true) + f74449l[i25], i24);
        }
        if ((i19 & 1) != 0 || i19 > 12 || i19 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i27 = (12 - i19) / 2;
        int i28 = f74450m[i27];
        return new b((f.b(m11, i28, false) * f74446i[i27]) + f.b(k11, 9 - i28, true) + f74448k[i27], i24);
    }

    private d w(id.a aVar, boolean z10, int i11, Map map) {
        try {
            c y10 = y(aVar, i11, z10, x(aVar, z10));
            l lVar = map == null ? null : (l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (lVar != null) {
                int[] b11 = y10.b();
                float f11 = ((b11[0] + b11[1]) - 1) / 2.0f;
                if (z10) {
                    f11 = (aVar.m() - 1) - f11;
                }
                lVar.a(new k(f11, i11));
            }
            b v11 = v(aVar, y10, true);
            b v12 = v(aVar, y10, false);
            return new d((v11.b() * 1597) + v12.b(), v11.a() + (v12.a() * 4), y10);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] x(id.a aVar, boolean z10) {
        int[] j11 = j();
        j11[0] = 0;
        j11[1] = 0;
        j11[2] = 0;
        j11[3] = 0;
        int m11 = aVar.m();
        int i11 = 0;
        boolean z11 = false;
        while (i11 < m11) {
            z11 = !aVar.i(i11);
            if (z10 == z11) {
                break;
            }
            i11++;
        }
        int i12 = 0;
        int i13 = i11;
        while (i11 < m11) {
            if (aVar.i(i11) != z11) {
                j11[i12] = j11[i12] + 1;
            } else {
                if (i12 != 3) {
                    i12++;
                } else {
                    if (a.p(j11)) {
                        return new int[]{i13, i11};
                    }
                    i13 += j11[0] + j11[1];
                    j11[0] = j11[2];
                    j11[1] = j11[3];
                    j11[2] = 0;
                    j11[3] = 0;
                    i12--;
                }
                j11[i12] = 1;
                z11 = !z11;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private c y(id.a aVar, int i11, boolean z10, int[] iArr) {
        int i12;
        int i13;
        boolean i14 = aVar.i(iArr[0]);
        int i15 = iArr[0] - 1;
        while (i15 >= 0 && i14 != aVar.i(i15)) {
            i15--;
        }
        int i16 = i15 + 1;
        int i17 = iArr[0] - i16;
        int[] j11 = j();
        System.arraycopy(j11, 0, j11, 1, j11.length - 1);
        j11[0] = i17;
        int q11 = a.q(j11, f74452o);
        int i18 = iArr[1];
        if (z10) {
            int m11 = (aVar.m() - 1) - i16;
            i12 = (aVar.m() - 1) - i18;
            i13 = m11;
        } else {
            i12 = i18;
            i13 = i16;
        }
        return new c(q11, new int[]{i16, iArr[1]}, i13, i12, i11);
    }

    @Override // qd.p
    public j c(int i11, id.a aVar, Map map) {
        r(this.f74453g, w(aVar, false, i11, map));
        aVar.q();
        r(this.f74454h, w(aVar, true, i11, map));
        aVar.q();
        for (d dVar : this.f74453g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f74454h) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // qd.p, com.google.zxing.i
    public void reset() {
        this.f74453g.clear();
        this.f74454h.clear();
    }
}
