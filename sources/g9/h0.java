package g9;

import android.util.Base64;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class h0 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f63535a;

        /* renamed from: b, reason: collision with root package name */
        public final int f63536b;

        /* renamed from: c, reason: collision with root package name */
        public final long[] f63537c;

        /* renamed from: d, reason: collision with root package name */
        public final int f63538d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f63539e;

        public a(int i11, int i12, long[] jArr, int i13, boolean z10) {
            this.f63535a = i11;
            this.f63536b = i12;
            this.f63537c = jArr;
            this.f63538d = i13;
            this.f63539e = z10;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f63540a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f63541b;

        /* renamed from: c, reason: collision with root package name */
        public final int f63542c;

        public b(String str, String[] strArr, int i11) {
            this.f63540a = str;
            this.f63541b = strArr;
            this.f63542c = i11;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f63543a;

        /* renamed from: b, reason: collision with root package name */
        public final int f63544b;

        /* renamed from: c, reason: collision with root package name */
        public final int f63545c;

        /* renamed from: d, reason: collision with root package name */
        public final int f63546d;

        public c(boolean z10, int i11, int i12, int i13) {
            this.f63543a = z10;
            this.f63544b = i11;
            this.f63545c = i12;
            this.f63546d = i13;
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f63547a;

        /* renamed from: b, reason: collision with root package name */
        public final int f63548b;

        /* renamed from: c, reason: collision with root package name */
        public final int f63549c;

        /* renamed from: d, reason: collision with root package name */
        public final int f63550d;

        /* renamed from: e, reason: collision with root package name */
        public final int f63551e;

        /* renamed from: f, reason: collision with root package name */
        public final int f63552f;

        /* renamed from: g, reason: collision with root package name */
        public final int f63553g;

        /* renamed from: h, reason: collision with root package name */
        public final int f63554h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f63555i;

        /* renamed from: j, reason: collision with root package name */
        public final byte[] f63556j;

        public d(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z10, byte[] bArr) {
            this.f63547a = i11;
            this.f63548b = i12;
            this.f63549c = i13;
            this.f63550d = i14;
            this.f63551e = i15;
            this.f63552f = i16;
            this.f63553g = i17;
            this.f63554h = i18;
            this.f63555i = z10;
            this.f63556j = bArr;
        }
    }

    public static int a(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    private static long b(long j11, long j12) {
        return (long) Math.floor(Math.pow(j11, 1.0d / j12));
    }

    public static Metadata c(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = (String) list.get(i11);
            String[] T0 = p0.T0(str, UrlUtils.EQUAL_MARK);
            if (T0.length != 2) {
                com.google.android.exoplayer2.util.s.i("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (T0[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new com.google.android.exoplayer2.util.d0(Base64.decode(T0[1], 0))));
                } catch (RuntimeException e11) {
                    com.google.android.exoplayer2.util.s.j("VorbisUtil", "Failed to parse vorbis picture", e11);
                }
            } else {
                arrayList.add(new VorbisComment(T0[0], T0[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static a d(g0 g0Var) {
        if (g0Var.d(24) != 5653314) {
            throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + g0Var.b(), null);
        }
        int d11 = g0Var.d(16);
        int d12 = g0Var.d(24);
        long[] jArr = new long[d12];
        boolean c11 = g0Var.c();
        long j11 = 0;
        if (c11) {
            int d13 = g0Var.d(5) + 1;
            int i11 = 0;
            while (i11 < d12) {
                int d14 = g0Var.d(a(d12 - i11));
                for (int i12 = 0; i12 < d14 && i11 < d12; i12++) {
                    jArr[i11] = d13;
                    i11++;
                }
                d13++;
            }
        } else {
            boolean c12 = g0Var.c();
            for (int i13 = 0; i13 < d12; i13++) {
                if (!c12) {
                    jArr[i13] = g0Var.d(5) + 1;
                } else if (g0Var.c()) {
                    jArr[i13] = g0Var.d(5) + 1;
                } else {
                    jArr[i13] = 0;
                }
            }
        }
        int d15 = g0Var.d(4);
        if (d15 > 2) {
            throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + d15, null);
        }
        if (d15 == 1 || d15 == 2) {
            g0Var.e(32);
            g0Var.e(32);
            int d16 = g0Var.d(4) + 1;
            g0Var.e(1);
            if (d15 != 1) {
                j11 = d12 * d11;
            } else if (d11 != 0) {
                j11 = b(d12, d11);
            }
            g0Var.e((int) (j11 * d16));
        }
        return new a(d11, d12, jArr, d15, c11);
    }

    private static void e(g0 g0Var) {
        int d11 = g0Var.d(6) + 1;
        for (int i11 = 0; i11 < d11; i11++) {
            int d12 = g0Var.d(16);
            if (d12 == 0) {
                g0Var.e(8);
                g0Var.e(16);
                g0Var.e(16);
                g0Var.e(6);
                g0Var.e(8);
                int d13 = g0Var.d(4) + 1;
                for (int i12 = 0; i12 < d13; i12++) {
                    g0Var.e(8);
                }
            } else {
                if (d12 != 1) {
                    throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + d12, null);
                }
                int d14 = g0Var.d(5);
                int[] iArr = new int[d14];
                int i13 = -1;
                for (int i14 = 0; i14 < d14; i14++) {
                    int d15 = g0Var.d(4);
                    iArr[i14] = d15;
                    if (d15 > i13) {
                        i13 = d15;
                    }
                }
                int i15 = i13 + 1;
                int[] iArr2 = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    iArr2[i16] = g0Var.d(3) + 1;
                    int d16 = g0Var.d(2);
                    if (d16 > 0) {
                        g0Var.e(8);
                    }
                    for (int i17 = 0; i17 < (1 << d16); i17++) {
                        g0Var.e(8);
                    }
                }
                g0Var.e(2);
                int d17 = g0Var.d(4);
                int i18 = 0;
                int i19 = 0;
                for (int i20 = 0; i20 < d14; i20++) {
                    i18 += iArr2[iArr[i20]];
                    while (i19 < i18) {
                        g0Var.e(d17);
                        i19++;
                    }
                }
            }
        }
    }

    private static void f(int i11, g0 g0Var) {
        int d11 = g0Var.d(6) + 1;
        for (int i12 = 0; i12 < d11; i12++) {
            int d12 = g0Var.d(16);
            if (d12 != 0) {
                com.google.android.exoplayer2.util.s.c("VorbisUtil", "mapping type other than 0 not supported: " + d12);
            } else {
                int d13 = g0Var.c() ? g0Var.d(4) + 1 : 1;
                if (g0Var.c()) {
                    int d14 = g0Var.d(8) + 1;
                    for (int i13 = 0; i13 < d14; i13++) {
                        int i14 = i11 - 1;
                        g0Var.e(a(i14));
                        g0Var.e(a(i14));
                    }
                }
                if (g0Var.d(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (d13 > 1) {
                    for (int i15 = 0; i15 < i11; i15++) {
                        g0Var.e(4);
                    }
                }
                for (int i16 = 0; i16 < d13; i16++) {
                    g0Var.e(8);
                    g0Var.e(8);
                    g0Var.e(8);
                }
            }
        }
    }

    private static c[] g(g0 g0Var) {
        int d11 = g0Var.d(6) + 1;
        c[] cVarArr = new c[d11];
        for (int i11 = 0; i11 < d11; i11++) {
            cVarArr[i11] = new c(g0Var.c(), g0Var.d(16), g0Var.d(16), g0Var.d(8));
        }
        return cVarArr;
    }

    private static void h(g0 g0Var) {
        int d11 = g0Var.d(6) + 1;
        for (int i11 = 0; i11 < d11; i11++) {
            if (g0Var.d(16) > 2) {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
            g0Var.e(24);
            g0Var.e(24);
            g0Var.e(24);
            int d12 = g0Var.d(6) + 1;
            g0Var.e(8);
            int[] iArr = new int[d12];
            for (int i12 = 0; i12 < d12; i12++) {
                iArr[i12] = ((g0Var.c() ? g0Var.d(5) : 0) * 8) + g0Var.d(3);
            }
            for (int i13 = 0; i13 < d12; i13++) {
                for (int i14 = 0; i14 < 8; i14++) {
                    if ((iArr[i13] & (1 << i14)) != 0) {
                        g0Var.e(8);
                    }
                }
            }
        }
    }

    public static b i(com.google.android.exoplayer2.util.d0 d0Var) {
        return j(d0Var, true, true);
    }

    public static b j(com.google.android.exoplayer2.util.d0 d0Var, boolean z10, boolean z11) {
        if (z10) {
            m(3, d0Var, false);
        }
        String A = d0Var.A((int) d0Var.t());
        int length = A.length();
        long t11 = d0Var.t();
        String[] strArr = new String[(int) t11];
        int i11 = length + 15;
        for (int i12 = 0; i12 < t11; i12++) {
            String A2 = d0Var.A((int) d0Var.t());
            strArr[i12] = A2;
            i11 = i11 + 4 + A2.length();
        }
        if (z11 && (d0Var.D() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new b(A, strArr, i11 + 1);
    }

    public static d k(com.google.android.exoplayer2.util.d0 d0Var) {
        m(1, d0Var, false);
        int u11 = d0Var.u();
        int D = d0Var.D();
        int u12 = d0Var.u();
        int q11 = d0Var.q();
        if (q11 <= 0) {
            q11 = -1;
        }
        int q12 = d0Var.q();
        if (q12 <= 0) {
            q12 = -1;
        }
        int q13 = d0Var.q();
        if (q13 <= 0) {
            q13 = -1;
        }
        int D2 = d0Var.D();
        return new d(u11, D, u12, q11, q12, q13, (int) Math.pow(2.0d, D2 & 15), (int) Math.pow(2.0d, (D2 & 240) >> 4), (d0Var.D() & 1) > 0, Arrays.copyOf(d0Var.d(), d0Var.f()));
    }

    public static c[] l(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        m(5, d0Var, false);
        int D = d0Var.D() + 1;
        g0 g0Var = new g0(d0Var.d());
        g0Var.e(d0Var.e() * 8);
        for (int i12 = 0; i12 < D; i12++) {
            d(g0Var);
        }
        int d11 = g0Var.d(6) + 1;
        for (int i13 = 0; i13 < d11; i13++) {
            if (g0Var.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        e(g0Var);
        h(g0Var);
        f(i11, g0Var);
        c[] g11 = g(g0Var);
        if (g0Var.c()) {
            return g11;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }

    public static boolean m(int i11, com.google.android.exoplayer2.util.d0 d0Var, boolean z10) {
        if (d0Var.a() < 7) {
            if (z10) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + d0Var.a(), null);
        }
        if (d0Var.D() != i11) {
            if (z10) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i11), null);
        }
        if (d0Var.D() == 118 && d0Var.D() == 111 && d0Var.D() == 114 && d0Var.D() == 98 && d0Var.D() == 105 && d0Var.D() == 115) {
            return true;
        }
        if (z10) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
    }
}
