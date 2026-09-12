package l2;

import android.util.Base64;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.a1;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class v0 {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f68818a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f68819b;

        /* renamed from: c, reason: collision with root package name */
        public final int f68820c;

        public a(String str, String[] strArr, int i11) {
            this.f68818a = str;
            this.f68819b = strArr;
            this.f68820c = i11;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f68821a;

        /* renamed from: b, reason: collision with root package name */
        public final int f68822b;

        /* renamed from: c, reason: collision with root package name */
        public final int f68823c;

        /* renamed from: d, reason: collision with root package name */
        public final int f68824d;

        public b(boolean z10, int i11, int i12, int i13) {
            this.f68821a = z10;
            this.f68822b = i11;
            this.f68823c = i12;
            this.f68824d = i13;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f68825a;

        /* renamed from: b, reason: collision with root package name */
        public final int f68826b;

        /* renamed from: c, reason: collision with root package name */
        public final int f68827c;

        /* renamed from: d, reason: collision with root package name */
        public final int f68828d;

        /* renamed from: e, reason: collision with root package name */
        public final int f68829e;

        /* renamed from: f, reason: collision with root package name */
        public final int f68830f;

        /* renamed from: g, reason: collision with root package name */
        public final int f68831g;

        /* renamed from: h, reason: collision with root package name */
        public final int f68832h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f68833i;

        /* renamed from: j, reason: collision with root package name */
        public final byte[] f68834j;

        public c(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z10, byte[] bArr) {
            this.f68825a = i11;
            this.f68826b = i12;
            this.f68827c = i13;
            this.f68828d = i14;
            this.f68829e = i15;
            this.f68830f = i16;
            this.f68831g = i17;
            this.f68832h = i18;
            this.f68833i = z10;
            this.f68834j = bArr;
        }
    }

    public static int[] a(int i11) {
        if (i11 == 3) {
            return new int[]{0, 2, 1};
        }
        if (i11 == 5) {
            return new int[]{0, 2, 1, 3, 4};
        }
        if (i11 == 6) {
            return new int[]{0, 2, 1, 5, 3, 4};
        }
        if (i11 == 7) {
            return new int[]{0, 2, 1, 6, 5, 3, 4};
        }
        if (i11 != 8) {
            return null;
        }
        return new int[]{0, 2, 1, 7, 5, 6, 3, 4};
    }

    public static int b(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    private static long c(long j11, long j12) {
        return (long) Math.floor(Math.pow(j11, 1.0d / j12));
    }

    public static androidx.media3.common.x d(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = (String) list.get(i11);
            String[] p12 = a1.p1(str, UrlUtils.EQUAL_MARK);
            if (p12.length != 2) {
                androidx.media3.common.util.u.h("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (p12[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(x2.a.b(new androidx.media3.common.util.j0(Base64.decode(p12[1], 0))));
                } catch (RuntimeException e11) {
                    androidx.media3.common.util.u.i("VorbisUtil", "Failed to parse vorbis picture", e11);
                }
            } else {
                arrayList.add(new c3.a(p12[0], p12[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new androidx.media3.common.x(arrayList);
    }

    public static ImmutableList e(byte[] bArr) {
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(bArr);
        j0Var.X(1);
        int i11 = 0;
        while (j0Var.a() > 0 && j0Var.j() == 255) {
            i11 += 255;
            j0Var.X(1);
        }
        int H = i11 + j0Var.H();
        int i12 = 0;
        while (j0Var.a() > 0 && j0Var.j() == 255) {
            i12 += 255;
            j0Var.X(1);
        }
        int H2 = i12 + j0Var.H();
        byte[] bArr2 = new byte[H];
        int f11 = j0Var.f();
        System.arraycopy(bArr, f11, bArr2, 0, H);
        int i13 = f11 + H + H2;
        int length = bArr.length - i13;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i13, bArr3, 0, length);
        return ImmutableList.of(bArr2, bArr3);
    }

    private static void f(u0 u0Var) {
        int d11 = u0Var.d(6) + 1;
        for (int i11 = 0; i11 < d11; i11++) {
            int d12 = u0Var.d(16);
            if (d12 == 0) {
                u0Var.e(8);
                u0Var.e(16);
                u0Var.e(16);
                u0Var.e(6);
                u0Var.e(8);
                int d13 = u0Var.d(4) + 1;
                for (int i12 = 0; i12 < d13; i12++) {
                    u0Var.e(8);
                }
            } else {
                if (d12 != 1) {
                    throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + d12, null);
                }
                int d14 = u0Var.d(5);
                int[] iArr = new int[d14];
                int i13 = -1;
                for (int i14 = 0; i14 < d14; i14++) {
                    int d15 = u0Var.d(4);
                    iArr[i14] = d15;
                    if (d15 > i13) {
                        i13 = d15;
                    }
                }
                int i15 = i13 + 1;
                int[] iArr2 = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    iArr2[i16] = u0Var.d(3) + 1;
                    int d16 = u0Var.d(2);
                    if (d16 > 0) {
                        u0Var.e(8);
                    }
                    for (int i17 = 0; i17 < (1 << d16); i17++) {
                        u0Var.e(8);
                    }
                }
                u0Var.e(2);
                int d17 = u0Var.d(4);
                int i18 = 0;
                int i19 = 0;
                for (int i20 = 0; i20 < d14; i20++) {
                    i18 += iArr2[iArr[i20]];
                    while (i19 < i18) {
                        u0Var.e(d17);
                        i19++;
                    }
                }
            }
        }
    }

    private static void g(int i11, u0 u0Var) {
        int d11 = u0Var.d(6) + 1;
        for (int i12 = 0; i12 < d11; i12++) {
            int d12 = u0Var.d(16);
            if (d12 != 0) {
                androidx.media3.common.util.u.c("VorbisUtil", "mapping type other than 0 not supported: " + d12);
            } else {
                int d13 = u0Var.c() ? u0Var.d(4) + 1 : 1;
                if (u0Var.c()) {
                    int d14 = u0Var.d(8) + 1;
                    for (int i13 = 0; i13 < d14; i13++) {
                        int i14 = i11 - 1;
                        u0Var.e(b(i14));
                        u0Var.e(b(i14));
                    }
                }
                if (u0Var.d(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (d13 > 1) {
                    for (int i15 = 0; i15 < i11; i15++) {
                        u0Var.e(4);
                    }
                }
                for (int i16 = 0; i16 < d13; i16++) {
                    u0Var.e(8);
                    u0Var.e(8);
                    u0Var.e(8);
                }
            }
        }
    }

    private static b[] h(u0 u0Var) {
        int d11 = u0Var.d(6) + 1;
        b[] bVarArr = new b[d11];
        for (int i11 = 0; i11 < d11; i11++) {
            bVarArr[i11] = new b(u0Var.c(), u0Var.d(16), u0Var.d(16), u0Var.d(8));
        }
        return bVarArr;
    }

    private static void i(u0 u0Var) {
        int d11 = u0Var.d(6) + 1;
        for (int i11 = 0; i11 < d11; i11++) {
            if (u0Var.d(16) > 2) {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
            u0Var.e(24);
            u0Var.e(24);
            u0Var.e(24);
            int d12 = u0Var.d(6) + 1;
            u0Var.e(8);
            int[] iArr = new int[d12];
            for (int i12 = 0; i12 < d12; i12++) {
                iArr[i12] = ((u0Var.c() ? u0Var.d(5) : 0) * 8) + u0Var.d(3);
            }
            for (int i13 = 0; i13 < d12; i13++) {
                for (int i14 = 0; i14 < 8; i14++) {
                    if ((iArr[i13] & (1 << i14)) != 0) {
                        u0Var.e(8);
                    }
                }
            }
        }
    }

    public static a j(androidx.media3.common.util.j0 j0Var) {
        return k(j0Var, true, true);
    }

    public static a k(androidx.media3.common.util.j0 j0Var, boolean z10, boolean z11) {
        if (z10) {
            o(3, j0Var, false);
        }
        String E = j0Var.E((int) j0Var.x());
        int length = E.length();
        long x10 = j0Var.x();
        String[] strArr = new String[(int) x10];
        int i11 = length + 15;
        for (int i12 = 0; i12 < x10; i12++) {
            String E2 = j0Var.E((int) j0Var.x());
            strArr[i12] = E2;
            i11 = i11 + 4 + E2.length();
        }
        if (z11 && (j0Var.H() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new a(E, strArr, i11 + 1);
    }

    public static c l(androidx.media3.common.util.j0 j0Var) {
        o(1, j0Var, false);
        int y10 = j0Var.y();
        int H = j0Var.H();
        int y11 = j0Var.y();
        int u11 = j0Var.u();
        if (u11 <= 0) {
            u11 = -1;
        }
        int u12 = j0Var.u();
        if (u12 <= 0) {
            u12 = -1;
        }
        int u13 = j0Var.u();
        if (u13 <= 0) {
            u13 = -1;
        }
        int H2 = j0Var.H();
        return new c(y10, H, y11, u11, u12, u13, (int) Math.pow(2.0d, H2 & 15), (int) Math.pow(2.0d, (H2 & 240) >> 4), (j0Var.H() & 1) > 0, Arrays.copyOf(j0Var.e(), j0Var.g()));
    }

    public static b[] m(androidx.media3.common.util.j0 j0Var, int i11) {
        o(5, j0Var, false);
        int H = j0Var.H() + 1;
        u0 u0Var = new u0(j0Var.e());
        u0Var.e(j0Var.f() * 8);
        for (int i12 = 0; i12 < H; i12++) {
            n(u0Var);
        }
        int d11 = u0Var.d(6) + 1;
        for (int i13 = 0; i13 < d11; i13++) {
            if (u0Var.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        f(u0Var);
        i(u0Var);
        g(i11, u0Var);
        b[] h11 = h(u0Var);
        if (u0Var.c()) {
            return h11;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }

    private static void n(u0 u0Var) {
        if (u0Var.d(24) != 5653314) {
            throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + u0Var.b(), null);
        }
        int d11 = u0Var.d(16);
        int d12 = u0Var.d(24);
        int i11 = 0;
        if (u0Var.c()) {
            u0Var.e(5);
            while (i11 < d12) {
                i11 += u0Var.d(b(d12 - i11));
            }
        } else {
            boolean c11 = u0Var.c();
            while (i11 < d12) {
                if (!c11) {
                    u0Var.e(5);
                } else if (u0Var.c()) {
                    u0Var.e(5);
                }
                i11++;
            }
        }
        int d13 = u0Var.d(4);
        if (d13 > 2) {
            throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + d13, null);
        }
        if (d13 == 1 || d13 == 2) {
            u0Var.e(32);
            u0Var.e(32);
            int d14 = u0Var.d(4) + 1;
            u0Var.e(1);
            u0Var.e((int) ((d13 == 1 ? d11 != 0 ? c(d12, d11) : 0L : d11 * d12) * d14));
        }
    }

    public static boolean o(int i11, androidx.media3.common.util.j0 j0Var, boolean z10) {
        if (j0Var.a() < 7) {
            if (z10) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + j0Var.a(), null);
        }
        if (j0Var.H() != i11) {
            if (z10) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i11), null);
        }
        if (j0Var.H() == 118 && j0Var.H() == 111 && j0Var.H() == 114 && j0Var.H() == 98 && j0Var.H() == 105 && j0Var.H() == 115) {
            return true;
        }
        if (z10) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
    }
}
