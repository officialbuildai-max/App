package com.google.android.exoplayer2.util;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f27718a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f27719b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c, reason: collision with root package name */
    private static final Object f27720c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static int[] f27721d = new int[10];

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f27722a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f27723b;

        /* renamed from: c, reason: collision with root package name */
        public final int f27724c;

        /* renamed from: d, reason: collision with root package name */
        public final int f27725d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f27726e;

        /* renamed from: f, reason: collision with root package name */
        public final int f27727f;

        /* renamed from: g, reason: collision with root package name */
        public final int f27728g;

        /* renamed from: h, reason: collision with root package name */
        public final int f27729h;

        /* renamed from: i, reason: collision with root package name */
        public final int f27730i;

        /* renamed from: j, reason: collision with root package name */
        public final float f27731j;

        public a(int i11, boolean z10, int i12, int i13, int[] iArr, int i14, int i15, int i16, int i17, float f11) {
            this.f27722a = i11;
            this.f27723b = z10;
            this.f27724c = i12;
            this.f27725d = i13;
            this.f27726e = iArr;
            this.f27727f = i14;
            this.f27728g = i15;
            this.f27729h = i16;
            this.f27730i = i17;
            this.f27731j = f11;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f27732a;

        /* renamed from: b, reason: collision with root package name */
        public final int f27733b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f27734c;

        public b(int i11, int i12, boolean z10) {
            this.f27732a = i11;
            this.f27733b = i12;
            this.f27734c = z10;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f27735a;

        /* renamed from: b, reason: collision with root package name */
        public final int f27736b;

        /* renamed from: c, reason: collision with root package name */
        public final int f27737c;

        /* renamed from: d, reason: collision with root package name */
        public final int f27738d;

        /* renamed from: e, reason: collision with root package name */
        public final int f27739e;

        /* renamed from: f, reason: collision with root package name */
        public final int f27740f;

        /* renamed from: g, reason: collision with root package name */
        public final int f27741g;

        /* renamed from: h, reason: collision with root package name */
        public final float f27742h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f27743i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f27744j;

        /* renamed from: k, reason: collision with root package name */
        public final int f27745k;

        /* renamed from: l, reason: collision with root package name */
        public final int f27746l;

        /* renamed from: m, reason: collision with root package name */
        public final int f27747m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f27748n;

        public c(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11, boolean z10, boolean z11, int i18, int i19, int i20, boolean z12) {
            this.f27735a = i11;
            this.f27736b = i12;
            this.f27737c = i13;
            this.f27738d = i14;
            this.f27739e = i15;
            this.f27740f = i16;
            this.f27741g = i17;
            this.f27742h = f11;
            this.f27743i = z10;
            this.f27744j = z11;
            this.f27745k = i18;
            this.f27746l = i19;
            this.f27747m = i20;
            this.f27748n = z12;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 1;
            if (i13 >= position) {
                byteBuffer.clear();
                return;
            }
            int i14 = byteBuffer.get(i11) & 255;
            if (i12 == 3) {
                if (i14 == 1 && (byteBuffer.get(i13) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i11 - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i14 == 0) {
                i12++;
            }
            if (i14 != 0) {
                i12 = 0;
            }
            i11 = i13;
        }
    }

    public static int c(byte[] bArr, int i11, int i12, boolean[] zArr) {
        int i13 = i12 - i11;
        com.google.android.exoplayer2.util.a.g(i13 >= 0);
        if (i13 == 0) {
            return i12;
        }
        if (zArr[0]) {
            a(zArr);
            return i11 - 3;
        }
        if (i13 > 1 && zArr[1] && bArr[i11] == 1) {
            a(zArr);
            return i11 - 2;
        }
        if (i13 > 2 && zArr[2] && bArr[i11] == 0 && bArr[i11 + 1] == 1) {
            a(zArr);
            return i11 - 1;
        }
        int i14 = i12 - 1;
        int i15 = i11 + 2;
        while (i15 < i14) {
            byte b11 = bArr[i15];
            if ((b11 & 254) == 0) {
                int i16 = i15 - 2;
                if (bArr[i16] == 0 && bArr[i15 - 1] == 0 && b11 == 1) {
                    a(zArr);
                    return i16;
                }
                i15 -= 2;
            }
            i15 += 3;
        }
        zArr[0] = i13 <= 2 ? !(i13 != 2 ? !(zArr[1] && bArr[i14] == 1) : !(zArr[2] && bArr[i12 + (-2)] == 0 && bArr[i14] == 1)) : bArr[i12 + (-3)] == 0 && bArr[i12 + (-2)] == 0 && bArr[i14] == 1;
        zArr[1] = i13 <= 1 ? zArr[2] && bArr[i14] == 0 : bArr[i12 + (-2)] == 0 && bArr[i14] == 0;
        zArr[2] = bArr[i14] == 0;
        return i12;
    }

    private static int d(byte[] bArr, int i11, int i12) {
        while (i11 < i12 - 2) {
            if (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 3) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int e(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i11) {
        return bArr[i11 + 3] & 31;
    }

    public static boolean g(String str, byte b11) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b11 & 31) == 6) {
            return true;
        }
        return MimeTypes.VIDEO_H265.equals(str) && ((b11 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i11, int i12) {
        return i(bArr, i11 + 2, i12);
    }

    public static a i(byte[] bArr, int i11, int i12) {
        e0 e0Var = new e0(bArr, i11, i12);
        e0Var.l(4);
        int e11 = e0Var.e(3);
        e0Var.k();
        int e12 = e0Var.e(2);
        boolean d11 = e0Var.d();
        int e13 = e0Var.e(5);
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i14 >= 32) {
                break;
            }
            if (e0Var.d()) {
                i13 |= 1 << i14;
            }
            i14++;
        }
        int[] iArr = new int[6];
        for (int i15 = 0; i15 < 6; i15++) {
            iArr[i15] = e0Var.e(8);
        }
        int e14 = e0Var.e(8);
        int i16 = 0;
        for (int i17 = 0; i17 < e11; i17++) {
            if (e0Var.d()) {
                i16 += 89;
            }
            if (e0Var.d()) {
                i16 += 8;
            }
        }
        e0Var.l(i16);
        if (e11 > 0) {
            e0Var.l((8 - e11) * 2);
        }
        int h11 = e0Var.h();
        int h12 = e0Var.h();
        if (h12 == 3) {
            e0Var.k();
        }
        int h13 = e0Var.h();
        int h14 = e0Var.h();
        if (e0Var.d()) {
            int h15 = e0Var.h();
            int h16 = e0Var.h();
            int h17 = e0Var.h();
            int h18 = e0Var.h();
            h13 -= ((h12 == 1 || h12 == 2) ? 2 : 1) * (h15 + h16);
            h14 -= (h12 == 1 ? 2 : 1) * (h17 + h18);
        }
        int i18 = h13;
        e0Var.h();
        e0Var.h();
        int h19 = e0Var.h();
        for (int i19 = e0Var.d() ? 0 : e11; i19 <= e11; i19++) {
            e0Var.h();
            e0Var.h();
            e0Var.h();
        }
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        e0Var.h();
        if (e0Var.d() && e0Var.d()) {
            n(e0Var);
        }
        e0Var.l(2);
        if (e0Var.d()) {
            e0Var.l(8);
            e0Var.h();
            e0Var.h();
            e0Var.k();
        }
        p(e0Var);
        if (e0Var.d()) {
            for (int i20 = 0; i20 < e0Var.h(); i20++) {
                e0Var.l(h19 + 5);
            }
        }
        e0Var.l(2);
        float f11 = 1.0f;
        if (e0Var.d()) {
            if (e0Var.d()) {
                int e15 = e0Var.e(8);
                if (e15 == 255) {
                    int e16 = e0Var.e(16);
                    int e17 = e0Var.e(16);
                    if (e16 != 0 && e17 != 0) {
                        f11 = e16 / e17;
                    }
                } else {
                    float[] fArr = f27719b;
                    if (e15 < fArr.length) {
                        f11 = fArr[e15];
                    } else {
                        s.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + e15);
                    }
                }
            }
            if (e0Var.d()) {
                e0Var.k();
            }
            if (e0Var.d()) {
                e0Var.l(4);
                if (e0Var.d()) {
                    e0Var.l(24);
                }
            }
            if (e0Var.d()) {
                e0Var.h();
                e0Var.h();
            }
            e0Var.k();
            if (e0Var.d()) {
                h14 *= 2;
            }
        }
        return new a(e12, d11, e13, i13, iArr, e14, h11, i18, h14, f11);
    }

    public static b j(byte[] bArr, int i11, int i12) {
        return k(bArr, i11 + 1, i12);
    }

    public static b k(byte[] bArr, int i11, int i12) {
        e0 e0Var = new e0(bArr, i11, i12);
        int h11 = e0Var.h();
        int h12 = e0Var.h();
        e0Var.k();
        return new b(h11, h12, e0Var.d());
    }

    public static c l(byte[] bArr, int i11, int i12) {
        return m(bArr, i11 + 1, i12);
    }

    public static c m(byte[] bArr, int i11, int i12) {
        int h11;
        boolean d11;
        int i13;
        boolean z10;
        boolean z11;
        int i14;
        float f11;
        int i15;
        e0 e0Var = new e0(bArr, i11, i12);
        int e11 = e0Var.e(8);
        int e12 = e0Var.e(8);
        int e13 = e0Var.e(8);
        int h12 = e0Var.h();
        if (e11 == 100 || e11 == 110 || e11 == 122 || e11 == 244 || e11 == 44 || e11 == 83 || e11 == 86 || e11 == 118 || e11 == 128 || e11 == 138) {
            h11 = e0Var.h();
            d11 = h11 == 3 ? e0Var.d() : false;
            e0Var.h();
            e0Var.h();
            e0Var.k();
            if (e0Var.d()) {
                int i16 = h11 != 3 ? 8 : 12;
                int i17 = 0;
                while (i17 < i16) {
                    if (e0Var.d()) {
                        o(e0Var, i17 < 6 ? 16 : 64);
                    }
                    i17++;
                }
            }
        } else {
            h11 = 1;
            d11 = false;
        }
        int h13 = e0Var.h() + 4;
        int h14 = e0Var.h();
        if (h14 == 0) {
            i13 = h11;
            z10 = d11;
            i14 = e0Var.h() + 4;
            z11 = false;
        } else {
            if (h14 == 1) {
                boolean d12 = e0Var.d();
                e0Var.g();
                e0Var.g();
                z10 = d11;
                long h15 = e0Var.h();
                i13 = h11;
                for (int i18 = 0; i18 < h15; i18++) {
                    e0Var.h();
                }
                z11 = d12;
            } else {
                i13 = h11;
                z10 = d11;
                z11 = false;
            }
            i14 = 0;
        }
        int h16 = e0Var.h();
        e0Var.k();
        int h17 = e0Var.h() + 1;
        int h18 = e0Var.h() + 1;
        boolean d13 = e0Var.d();
        int i19 = (2 - (d13 ? 1 : 0)) * h18;
        if (!d13) {
            e0Var.k();
        }
        e0Var.k();
        int i20 = h17 * 16;
        int i21 = i19 * 16;
        if (e0Var.d()) {
            int h19 = e0Var.h();
            int h20 = e0Var.h();
            int h21 = e0Var.h();
            int h22 = e0Var.h();
            if (i13 == 0) {
                i15 = 2 - (d13 ? 1 : 0);
            } else {
                int i22 = i13;
                r9 = i22 == 3 ? 1 : 2;
                i15 = (2 - (d13 ? 1 : 0)) * (i22 == 1 ? 2 : 1);
            }
            i20 -= (h19 + h20) * r9;
            i21 -= (h21 + h22) * i15;
        }
        int i23 = i20;
        int i24 = i21;
        float f12 = 1.0f;
        if (e0Var.d() && e0Var.d()) {
            int e14 = e0Var.e(8);
            if (e14 == 255) {
                int e15 = e0Var.e(16);
                int e16 = e0Var.e(16);
                if (e15 != 0 && e16 != 0) {
                    f12 = e15 / e16;
                }
            } else {
                float[] fArr = f27719b;
                if (e14 < fArr.length) {
                    f11 = fArr[e14];
                    return new c(e11, e12, e13, h12, h16, i23, i24, f11, z10, d13, h13, h14, i14, z11);
                }
                s.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + e14);
            }
        }
        f11 = f12;
        return new c(e11, e12, e13, h12, h16, i23, i24, f11, z10, d13, h13, h14, i14, z11);
    }

    private static void n(e0 e0Var) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (e0Var.d()) {
                    int min = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        e0Var.g();
                    }
                    for (int i14 = 0; i14 < min; i14++) {
                        e0Var.g();
                    }
                } else {
                    e0Var.h();
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    private static void o(e0 e0Var, int i11) {
        int i12 = 8;
        int i13 = 8;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 != 0) {
                i12 = ((e0Var.g() + i13) + 256) % 256;
            }
            if (i12 != 0) {
                i13 = i12;
            }
        }
    }

    private static void p(e0 e0Var) {
        int h11 = e0Var.h();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < h11; i13++) {
            if (i13 == 0 || !e0Var.d()) {
                int h12 = e0Var.h();
                int h13 = e0Var.h();
                int[] iArr3 = new int[h12];
                for (int i14 = 0; i14 < h12; i14++) {
                    iArr3[i14] = e0Var.h() + 1;
                    e0Var.k();
                }
                int[] iArr4 = new int[h13];
                for (int i15 = 0; i15 < h13; i15++) {
                    iArr4[i15] = e0Var.h() + 1;
                    e0Var.k();
                }
                i11 = h12;
                iArr = iArr3;
                i12 = h13;
                iArr2 = iArr4;
            } else {
                int i16 = i11 + i12;
                int h14 = (1 - ((e0Var.d() ? 1 : 0) * 2)) * (e0Var.h() + 1);
                int i17 = i16 + 1;
                boolean[] zArr = new boolean[i17];
                for (int i18 = 0; i18 <= i16; i18++) {
                    if (e0Var.d()) {
                        zArr[i18] = true;
                    } else {
                        zArr[i18] = e0Var.d();
                    }
                }
                int[] iArr5 = new int[i17];
                int[] iArr6 = new int[i17];
                int i19 = 0;
                for (int i20 = i12 - 1; i20 >= 0; i20--) {
                    int i21 = iArr2[i20] + h14;
                    if (i21 < 0 && zArr[i11 + i20]) {
                        iArr5[i19] = i21;
                        i19++;
                    }
                }
                if (h14 < 0 && zArr[i16]) {
                    iArr5[i19] = h14;
                    i19++;
                }
                for (int i22 = 0; i22 < i11; i22++) {
                    int i23 = iArr[i22] + h14;
                    if (i23 < 0 && zArr[i22]) {
                        iArr5[i19] = i23;
                        i19++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr5, i19);
                int i24 = 0;
                for (int i25 = i11 - 1; i25 >= 0; i25--) {
                    int i26 = iArr[i25] + h14;
                    if (i26 > 0 && zArr[i25]) {
                        iArr6[i24] = i26;
                        i24++;
                    }
                }
                if (h14 > 0 && zArr[i16]) {
                    iArr6[i24] = h14;
                    i24++;
                }
                for (int i27 = 0; i27 < i12; i27++) {
                    int i28 = iArr2[i27] + h14;
                    if (i28 > 0 && zArr[i11 + i27]) {
                        iArr6[i24] = i28;
                        i24++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr6, i24);
                iArr = copyOf;
                i11 = i19;
                i12 = i24;
            }
        }
    }

    public static int q(byte[] bArr, int i11) {
        int i12;
        synchronized (f27720c) {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11) {
                try {
                    i13 = d(bArr, i13, i11);
                    if (i13 < i11) {
                        int[] iArr = f27721d;
                        if (iArr.length <= i14) {
                            f27721d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f27721d[i14] = i13;
                        i13 += 3;
                        i14++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            i12 = i11 - i14;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < i14; i17++) {
                int i18 = f27721d[i17] - i16;
                System.arraycopy(bArr, i16, bArr, i15, i18);
                int i19 = i15 + i18;
                int i20 = i19 + 1;
                bArr[i19] = 0;
                i15 = i19 + 2;
                bArr[i20] = 0;
                i16 += i18 + 3;
            }
            System.arraycopy(bArr, i16, bArr, i15, i12 - i15);
        }
        return i12;
    }
}
