package com.google.zxing.aztec.encoder;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public final class HighLevelEncoder {

    /* renamed from: c, reason: collision with root package name */
    static final String[] f32880c = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: d, reason: collision with root package name */
    static final int[][] f32881d = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: e, reason: collision with root package name */
    private static final int[][] f32882e;

    /* renamed from: f, reason: collision with root package name */
    static final int[][] f32883f;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f32884a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f32885b;

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        f32882e = iArr;
        iArr[0][32] = 1;
        for (int i11 = 65; i11 <= 90; i11++) {
            f32882e[0][i11] = i11 - 63;
        }
        f32882e[1][32] = 1;
        for (int i12 = 97; i12 <= 122; i12++) {
            f32882e[1][i12] = i12 - 95;
        }
        f32882e[2][32] = 1;
        for (int i13 = 48; i13 <= 57; i13++) {
            f32882e[2][i13] = i13 - 46;
        }
        int[] iArr2 = f32882e[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 126, 127};
        int i14 = 0;
        for (int i15 = 28; i14 < i15; i15 = 28) {
            f32882e[3][iArr3[i14]] = i14;
            i14++;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE};
        for (int i16 = 0; i16 < 31; i16++) {
            int i17 = iArr4[i16];
            if (i17 > 0) {
                f32882e[4][i17] = i16;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f32883f = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f32883f;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public HighLevelEncoder(byte[] bArr, Charset charset) {
        this.f32884a = bArr;
        this.f32885b = charset;
    }

    private static Collection b(Iterable iterable) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    linkedList.addFirst(eVar);
                    break;
                }
                e eVar2 = (e) it2.next();
                if (eVar2.h(eVar)) {
                    break;
                }
                if (eVar.h(eVar2)) {
                    it2.remove();
                }
            }
        }
        return linkedList;
    }

    private void c(e eVar, int i11, Collection collection) {
        char c11 = (char) (this.f32884a[i11] & 255);
        boolean z10 = f32882e[eVar.g()][c11] > 0;
        e eVar2 = null;
        for (int i12 = 0; i12 <= 4; i12++) {
            int i13 = f32882e[i12][c11];
            if (i13 > 0) {
                if (eVar2 == null) {
                    eVar2 = eVar.d(i11);
                }
                if (!z10 || i12 == eVar.g() || i12 == 2) {
                    collection.add(eVar2.i(i12, i13));
                }
                if (!z10 && f32883f[eVar.g()][i12] >= 0) {
                    collection.add(eVar2.j(i12, i13));
                }
            }
        }
        if (eVar.e() > 0 || f32882e[eVar.g()][c11] == 0) {
            collection.add(eVar.a(i11));
        }
    }

    private static void d(e eVar, int i11, int i12, Collection collection) {
        e d11 = eVar.d(i11);
        collection.add(d11.i(4, i12));
        if (eVar.g() != 4) {
            collection.add(d11.j(4, i12));
        }
        if (i12 == 3 || i12 == 4) {
            collection.add(d11.i(2, 16 - i12).i(2, 1));
        }
        if (eVar.e() > 0) {
            collection.add(eVar.a(i11).a(i11 + 1));
        }
    }

    private Collection e(Iterable iterable, int i11) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c((e) it.next(), i11, linkedList);
        }
        return b(linkedList);
    }

    private static Collection f(Iterable iterable, int i11, int i12) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            d((e) it.next(), i11, i12, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public id.a a() {
        /*
            r8 = this;
            com.google.zxing.aztec.encoder.e r0 = com.google.zxing.aztec.encoder.e.f32896f
            java.nio.charset.Charset r1 = r8.f32885b
            if (r1 == 0) goto L2e
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECI(r1)
            if (r1 == 0) goto L15
            int r1 = r1.getValue()
            com.google.zxing.aztec.encoder.e r0 = r0.b(r1)
            goto L2e
        L15:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No ECI code for character set "
            r1.append(r2)
            java.nio.charset.Charset r2 = r8.f32885b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L2e:
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r1
        L34:
            byte[] r3 = r8.f32884a
            int r4 = r3.length
            if (r2 >= r4) goto L78
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L41
            r5 = r3[r4]
            goto L42
        L41:
            r5 = r1
        L42:
            r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L64
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L60
            r6 = 46
            if (r3 == r6) goto L5c
            r6 = 58
            if (r3 == r6) goto L58
        L56:
            r3 = r1
            goto L69
        L58:
            if (r5 != r7) goto L56
            r3 = 5
            goto L69
        L5c:
            if (r5 != r7) goto L56
            r3 = 3
            goto L69
        L60:
            if (r5 != r7) goto L56
            r3 = 4
            goto L69
        L64:
            r3 = 10
            if (r5 != r3) goto L56
            r3 = 2
        L69:
            if (r3 <= 0) goto L71
            java.util.Collection r0 = f(r0, r2, r3)
            r2 = r4
            goto L75
        L71:
            java.util.Collection r0 = r8.e(r0, r2)
        L75:
            int r2 = r2 + 1
            goto L34
        L78:
            com.google.zxing.aztec.encoder.HighLevelEncoder$1 r1 = new com.google.zxing.aztec.encoder.HighLevelEncoder$1
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.google.zxing.aztec.encoder.e r0 = (com.google.zxing.aztec.encoder.e) r0
            byte[] r1 = r8.f32884a
            id.a r0 = r0.k(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.HighLevelEncoder.a():id.a");
    }
}
