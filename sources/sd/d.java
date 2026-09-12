package sd;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.j;
import com.google.zxing.k;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qd.p;
import rd.f;

/* loaded from: classes5.dex */
public final class d extends rd.a {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f75451k = {7, 5, 4, 3, 1};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f75452l = {4, 20, 52, 104, Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f75453m = {0, 348, 1388, 2948, 3988};

    /* renamed from: n, reason: collision with root package name */
    private static final int[][] f75454n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: o, reason: collision with root package name */
    private static final int[][] f75455o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 143, 7, 21, 63}, new int[]{PsExtractor.PRIVATE_STREAM_1, 145, 13, 39, Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, 140, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE, 197, 169, 85, 44, Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE}, new int[]{185, Sdk$SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 188, 142, 4, 12, 36, TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 158, 52, 156}, new int[]{46, 138, Sdk$SDKError.Reason.AD_IS_LOADING_VALUE, 187, 139, Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 155}, new int[]{43, 129, 176, 106, 107, 110, Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE, Sdk$SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 200, 178, 112, Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 164}, new int[]{70, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, Sdk$SDKError.Reason.INVALID_BID_PAYLOAD_VALUE, Sdk$SDKError.Reason.AD_CONSUMED_VALUE, 184, 130, 179, Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE}, new int[]{134, 191, 151, 31, 93, 68, Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, PsExtractor.AUDIO_STREAM, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, 199, 175}, new int[]{103, 98, 83, 38, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 182, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* renamed from: p, reason: collision with root package name */
    private static final int[][] f75456p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: g, reason: collision with root package name */
    private final List f75457g = new ArrayList(11);

    /* renamed from: h, reason: collision with root package name */
    private final List f75458h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final int[] f75459i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    private boolean f75460j;

    private static boolean A(rd.c cVar, boolean z10, boolean z11) {
        return (cVar.c() == 0 && z10 && z11) ? false : true;
    }

    private static boolean B(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                Iterator it3 = cVar.a().iterator();
                while (it3.hasNext()) {
                    if (bVar.equals((b) it3.next())) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean C(List list) {
        for (int[] iArr : f75456p) {
            if (list.size() <= iArr.length) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    if (((b) list.get(i11)).a().c() != iArr[i11]) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private rd.c D(id.a aVar, int i11, boolean z10) {
        int i12;
        int i13;
        int i14;
        if (z10) {
            int i15 = this.f75459i[0] - 1;
            while (i15 >= 0 && !aVar.i(i15)) {
                i15--;
            }
            int i16 = i15 + 1;
            int[] iArr = this.f75459i;
            i14 = iArr[0] - i16;
            i12 = iArr[1];
            i13 = i16;
        } else {
            int[] iArr2 = this.f75459i;
            int i17 = iArr2[0];
            int l11 = aVar.l(iArr2[1] + 1);
            i12 = l11;
            i13 = i17;
            i14 = l11 - this.f75459i[1];
        }
        int[] j11 = j();
        System.arraycopy(j11, 0, j11, 1, j11.length - 1);
        j11[0] = i14;
        try {
            return new rd.c(rd.a.q(j11, f75454n), new int[]{i13, i12}, i13, i12, i11);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void E(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.a().size() != collection.size()) {
                Iterator it2 = cVar.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    } else if (!collection.contains((b) it2.next())) {
                        break;
                    }
                }
            }
        }
    }

    private static void G(int[] iArr) {
        int length = iArr.length;
        for (int i11 = 0; i11 < length / 2; i11++) {
            int i12 = iArr[i11];
            int i13 = (length - i11) - 1;
            iArr[i11] = iArr[i13];
            iArr[i13] = i12;
        }
    }

    private void H(int i11) {
        boolean z10 = false;
        int i12 = 0;
        boolean z11 = false;
        while (true) {
            if (i12 >= this.f75458h.size()) {
                break;
            }
            c cVar = (c) this.f75458h.get(i12);
            if (cVar.b() > i11) {
                z10 = cVar.c(this.f75457g);
                break;
            } else {
                z11 = cVar.c(this.f75457g);
                i12++;
            }
        }
        if (z10 || z11 || B(this.f75457g, this.f75458h)) {
            return;
        }
        this.f75458h.add(i12, new c(this.f75457g, i11));
        E(this.f75457g, this.f75458h);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void r(int r11) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sd.d.r(int):void");
    }

    private boolean s() {
        b bVar = (b) this.f75457g.get(0);
        rd.b b11 = bVar.b();
        rd.b c11 = bVar.c();
        if (c11 == null) {
            return false;
        }
        int a11 = c11.a();
        int i11 = 2;
        for (int i12 = 1; i12 < this.f75457g.size(); i12++) {
            b bVar2 = (b) this.f75457g.get(i12);
            a11 += bVar2.b().a();
            int i13 = i11 + 1;
            rd.b c12 = bVar2.c();
            if (c12 != null) {
                a11 += c12.a();
                i11 += 2;
            } else {
                i11 = i13;
            }
        }
        return ((i11 + (-4)) * 211) + (a11 % 211) == b11.b();
    }

    private List t(List list, int i11) {
        while (i11 < this.f75458h.size()) {
            c cVar = (c) this.f75458h.get(i11);
            this.f75457g.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f75457g.addAll(((c) it.next()).a());
            }
            this.f75457g.addAll(cVar.a());
            if (C(this.f75457g)) {
                if (s()) {
                    return this.f75457g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return t(arrayList, i11 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List u(boolean z10) {
        List list = null;
        if (this.f75458h.size() > 25) {
            this.f75458h.clear();
            return null;
        }
        this.f75457g.clear();
        if (z10) {
            Collections.reverse(this.f75458h);
        }
        try {
            list = t(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z10) {
            Collections.reverse(this.f75458h);
        }
        return list;
    }

    static j v(List list) {
        String d11 = com.google.zxing.oned.rss.expanded.decoders.j.a(a.a(list)).d();
        k[] a11 = ((b) list.get(0)).a().a();
        k[] a12 = ((b) list.get(list.size() - 1)).a().a();
        j jVar = new j(d11, null, new k[]{a11[0], a11[1], a12[0], a12[1]}, BarcodeFormat.RSS_EXPANDED);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return jVar;
    }

    private void y(id.a aVar, List list, int i11) {
        int[] j11 = j();
        j11[0] = 0;
        j11[1] = 0;
        j11[2] = 0;
        j11[3] = 0;
        int m11 = aVar.m();
        if (i11 < 0) {
            i11 = list.isEmpty() ? 0 : ((b) list.get(list.size() - 1)).a().b()[1];
        }
        boolean z10 = list.size() % 2 != 0;
        if (this.f75460j) {
            z10 = !z10;
        }
        boolean z11 = false;
        while (true) {
            if (i11 >= m11) {
                break;
            }
            boolean i12 = aVar.i(i11);
            boolean z12 = !i12;
            if (i12) {
                z11 = z12;
                break;
            } else {
                i11++;
                z11 = z12;
            }
        }
        int i13 = 0;
        boolean z13 = z11;
        int i14 = i11;
        while (i11 < m11) {
            if (aVar.i(i11) != z13) {
                j11[i13] = j11[i13] + 1;
            } else {
                if (i13 == 3) {
                    if (z10) {
                        G(j11);
                    }
                    if (rd.a.p(j11)) {
                        int[] iArr = this.f75459i;
                        iArr[0] = i14;
                        iArr[1] = i11;
                        return;
                    }
                    if (z10) {
                        G(j11);
                    }
                    i14 += j11[0] + j11[1];
                    j11[0] = j11[2];
                    j11[1] = j11[3];
                    j11[2] = 0;
                    j11[3] = 0;
                    i13--;
                } else {
                    i13++;
                }
                j11[i13] = 1;
                z13 = !z13;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int z(id.a aVar, int i11) {
        return aVar.i(i11) ? aVar.k(aVar.l(i11)) : aVar.l(aVar.k(i11));
    }

    b F(id.a aVar, List list, int i11) {
        rd.c D;
        rd.b bVar;
        boolean z10 = list.size() % 2 == 0;
        if (this.f75460j) {
            z10 = !z10;
        }
        int i12 = -1;
        boolean z11 = true;
        do {
            y(aVar, list, i12);
            D = D(aVar, i11, z10);
            if (D == null) {
                i12 = z(aVar, this.f75459i[0]);
            } else {
                z11 = false;
            }
        } while (z11);
        rd.b w11 = w(aVar, D, z10, true);
        if (!list.isEmpty() && ((b) list.get(list.size() - 1)).d()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            bVar = w(aVar, D, z10, false);
        } catch (NotFoundException unused) {
            bVar = null;
        }
        return new b(w11, bVar, D);
    }

    @Override // qd.p
    public j c(int i11, id.a aVar, Map map) {
        this.f75457g.clear();
        this.f75460j = false;
        try {
            return v(x(i11, aVar));
        } catch (NotFoundException unused) {
            this.f75457g.clear();
            this.f75460j = true;
            return v(x(i11, aVar));
        }
    }

    @Override // qd.p, com.google.zxing.i
    public void reset() {
        this.f75457g.clear();
        this.f75458h.clear();
    }

    rd.b w(id.a aVar, rd.c cVar, boolean z10, boolean z11) {
        int[] i11 = i();
        Arrays.fill(i11, 0);
        if (z11) {
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
        float d11 = jd.a.d(i11) / 17;
        float f11 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d11 - f11) / f11 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] m11 = m();
        int[] k11 = k();
        float[] n11 = n();
        float[] l11 = l();
        for (int i14 = 0; i14 < i11.length; i14++) {
            float f12 = (i11[i14] * 1.0f) / d11;
            int i15 = (int) (0.5f + f12);
            if (i15 < 1) {
                if (f12 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i15 = 1;
            } else if (i15 > 8) {
                if (f12 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i15 = 8;
            }
            int i16 = i14 / 2;
            if ((i14 & 1) == 0) {
                m11[i16] = i15;
                n11[i16] = f12 - i15;
            } else {
                k11[i16] = i15;
                l11[i16] = f12 - i15;
            }
        }
        r(17);
        int c11 = (((cVar.c() * 4) + (z10 ? 0 : 2)) + (!z11 ? 1 : 0)) - 1;
        int i17 = 0;
        int i18 = 0;
        for (int length2 = m11.length - 1; length2 >= 0; length2--) {
            if (A(cVar, z10, z11)) {
                i17 += m11[length2] * f75455o[c11][length2 * 2];
            }
            i18 += m11[length2];
        }
        int i19 = 0;
        for (int length3 = k11.length - 1; length3 >= 0; length3--) {
            if (A(cVar, z10, z11)) {
                i19 += k11[length3] * f75455o[c11][(length3 * 2) + 1];
            }
        }
        int i20 = i17 + i19;
        if ((i18 & 1) != 0 || i18 > 13 || i18 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i21 = (13 - i18) / 2;
        int i22 = f75451k[i21];
        return new rd.b((f.b(m11, i22, true) * f75452l[i21]) + f.b(k11, 9 - i22, false) + f75453m[i21], i20);
    }

    List x(int i11, id.a aVar) {
        boolean z10 = false;
        while (!z10) {
            try {
                List list = this.f75457g;
                list.add(F(aVar, list, i11));
            } catch (NotFoundException e11) {
                if (this.f75457g.isEmpty()) {
                    throw e11;
                }
                z10 = true;
            }
        }
        if (s()) {
            return this.f75457g;
        }
        boolean isEmpty = this.f75458h.isEmpty();
        H(i11);
        if (!isEmpty) {
            List u11 = u(false);
            if (u11 != null) {
                return u11;
            }
            List u12 = u(true);
            if (u12 != null) {
                return u12;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
