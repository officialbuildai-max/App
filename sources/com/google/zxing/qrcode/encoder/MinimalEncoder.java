package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import id.g;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class MinimalEncoder {

    /* renamed from: a, reason: collision with root package name */
    private final String f33081a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f33082b;

    /* renamed from: c, reason: collision with root package name */
    private final g f33083c;

    /* renamed from: d, reason: collision with root package name */
    private final ErrorCorrectionLevel f33084d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum VersionSize {
        SMALL("version 1-9"),
        MEDIUM("version 10-26"),
        LARGE("version 27-40");

        private final String description;

        VersionSize(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33085a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f33086b;

        static {
            int[] iArr = new int[Mode.values().length];
            f33086b = iArr;
            try {
                iArr[Mode.KANJI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33086b[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33086b[Mode.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33086b[Mode.BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33086b[Mode.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[VersionSize.values().length];
            f33085a = iArr2;
            try {
                iArr2[VersionSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33085a[VersionSize.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33085a[VersionSize.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Mode f33087a;

        /* renamed from: b, reason: collision with root package name */
        private final int f33088b;

        /* renamed from: c, reason: collision with root package name */
        private final int f33089c;

        /* renamed from: d, reason: collision with root package name */
        private final int f33090d;

        /* renamed from: e, reason: collision with root package name */
        private final b f33091e;

        /* renamed from: f, reason: collision with root package name */
        private final int f33092f;

        private b(Mode mode, int i11, int i12, int i13, b bVar, com.google.zxing.qrcode.decoder.g gVar) {
            this.f33087a = mode;
            this.f33088b = i11;
            Mode mode2 = Mode.BYTE;
            int i14 = (mode == mode2 || bVar == null) ? i12 : bVar.f33089c;
            this.f33089c = i14;
            this.f33090d = i13;
            this.f33091e = bVar;
            boolean z10 = false;
            int i15 = bVar != null ? bVar.f33092f : 0;
            if ((mode == mode2 && bVar == null && i14 != 0) || (bVar != null && i14 != bVar.f33089c)) {
                z10 = true;
            }
            i15 = (bVar == null || mode != bVar.f33087a || z10) ? i15 + mode.getCharacterCountBits(gVar) + 4 : i15;
            int i16 = a.f33086b[mode.ordinal()];
            if (i16 == 1) {
                i15 += 13;
            } else if (i16 == 2) {
                i15 += i13 == 1 ? 6 : 11;
            } else if (i16 == 3) {
                i15 += i13 != 1 ? i13 == 2 ? 7 : 10 : 4;
            } else if (i16 == 4) {
                i15 += MinimalEncoder.this.f33083c.c(MinimalEncoder.this.f33081a.substring(i11, i13 + i11), i12).length * 8;
                if (z10) {
                    i15 += 12;
                }
            }
            this.f33092f = i15;
        }

        /* synthetic */ b(MinimalEncoder minimalEncoder, Mode mode, int i11, int i12, int i13, b bVar, com.google.zxing.qrcode.decoder.g gVar, a aVar) {
            this(mode, i11, i12, i13, bVar, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final List f33094a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final com.google.zxing.qrcode.decoder.g f33095b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public final class a {

            /* renamed from: a, reason: collision with root package name */
            private final Mode f33097a;

            /* renamed from: b, reason: collision with root package name */
            private final int f33098b;

            /* renamed from: c, reason: collision with root package name */
            private final int f33099c;

            /* renamed from: d, reason: collision with root package name */
            private final int f33100d;

            a(Mode mode, int i11, int i12, int i13) {
                this.f33097a = mode;
                this.f33098b = i11;
                this.f33099c = i12;
                this.f33100d = i13;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void d(id.a aVar) {
                aVar.c(this.f33097a.getBits(), 4);
                if (this.f33100d > 0) {
                    aVar.c(e(), this.f33097a.getCharacterCountBits(c.this.f33095b));
                }
                if (this.f33097a == Mode.ECI) {
                    aVar.c(MinimalEncoder.this.f33083c.e(this.f33099c), 8);
                } else if (this.f33100d > 0) {
                    String str = MinimalEncoder.this.f33081a;
                    int i11 = this.f33098b;
                    com.google.zxing.qrcode.encoder.b.c(str.substring(i11, this.f33100d + i11), this.f33097a, aVar, MinimalEncoder.this.f33083c.d(this.f33099c));
                }
            }

            private int e() {
                if (this.f33097a != Mode.BYTE) {
                    return this.f33100d;
                }
                g gVar = MinimalEncoder.this.f33083c;
                String str = MinimalEncoder.this.f33081a;
                int i11 = this.f33098b;
                return gVar.c(str.substring(i11, this.f33100d + i11), this.f33099c).length;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int f(com.google.zxing.qrcode.decoder.g gVar) {
                int i11;
                int i12;
                int characterCountBits = this.f33097a.getCharacterCountBits(gVar);
                int i13 = characterCountBits + 4;
                int i14 = a.f33086b[this.f33097a.ordinal()];
                if (i14 != 1) {
                    int i15 = 0;
                    if (i14 == 2) {
                        int i16 = this.f33100d;
                        i12 = i13 + ((i16 / 2) * 11);
                        if (i16 % 2 == 1) {
                            i15 = 6;
                        }
                    } else if (i14 == 3) {
                        int i17 = this.f33100d;
                        i12 = i13 + ((i17 / 3) * 10);
                        int i18 = i17 % 3;
                        if (i18 == 1) {
                            i15 = 4;
                        } else if (i18 == 2) {
                            i15 = 7;
                        }
                    } else {
                        if (i14 != 4) {
                            return i14 != 5 ? i13 : characterCountBits + 12;
                        }
                        i11 = e() * 8;
                    }
                    return i12 + i15;
                }
                i11 = this.f33100d * 13;
                return i13 + i11;
            }

            private String g(String str) {
                StringBuilder sb2 = new StringBuilder();
                for (int i11 = 0; i11 < str.length(); i11++) {
                    if (str.charAt(i11) < ' ' || str.charAt(i11) > '~') {
                        sb2.append('.');
                    } else {
                        sb2.append(str.charAt(i11));
                    }
                }
                return sb2.toString();
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f33097a);
                sb2.append('(');
                if (this.f33097a == Mode.ECI) {
                    sb2.append(MinimalEncoder.this.f33083c.d(this.f33099c).displayName());
                } else {
                    String str = MinimalEncoder.this.f33081a;
                    int i11 = this.f33098b;
                    sb2.append(g(str.substring(i11, this.f33100d + i11)));
                }
                sb2.append(')');
                return sb2.toString();
            }
        }

        c(com.google.zxing.qrcode.decoder.g gVar, b bVar) {
            int i11;
            int i12;
            int i13 = 0;
            boolean z10 = false;
            while (true) {
                i11 = 1;
                if (bVar == null) {
                    break;
                }
                int i14 = i13 + bVar.f33090d;
                b bVar2 = bVar.f33091e;
                boolean z11 = (bVar.f33087a == Mode.BYTE && bVar2 == null && bVar.f33089c != 0) || !(bVar2 == null || bVar.f33089c == bVar2.f33089c);
                z10 = z11 ? true : z10;
                if (bVar2 == null || bVar2.f33087a != bVar.f33087a || z11) {
                    this.f33094a.add(0, new a(bVar.f33087a, bVar.f33088b, bVar.f33089c, i14));
                    i14 = 0;
                }
                if (z11) {
                    this.f33094a.add(0, new a(Mode.ECI, bVar.f33088b, bVar.f33089c, 0));
                }
                bVar = bVar2;
                i13 = i14;
            }
            if (MinimalEncoder.this.f33082b) {
                a aVar = (a) this.f33094a.get(0);
                if (aVar != null) {
                    Mode mode = aVar.f33097a;
                    Mode mode2 = Mode.ECI;
                    if (mode != mode2 && z10) {
                        this.f33094a.add(0, new a(mode2, 0, 0, 0));
                    }
                }
                this.f33094a.add(((a) this.f33094a.get(0)).f33097a == Mode.ECI ? 1 : 0, new a(Mode.FNC1_FIRST_POSITION, 0, 0, 0));
            }
            int j11 = gVar.j();
            int i15 = a.f33085a[MinimalEncoder.m(gVar).ordinal()];
            if (i15 == 1) {
                i12 = 9;
            } else if (i15 != 2) {
                i11 = 27;
                i12 = 40;
            } else {
                i11 = 10;
                i12 = 26;
            }
            int d11 = d(gVar);
            while (j11 < i12 && !com.google.zxing.qrcode.encoder.b.v(d11, com.google.zxing.qrcode.decoder.g.i(j11), MinimalEncoder.this.f33084d)) {
                j11++;
            }
            while (j11 > i11 && com.google.zxing.qrcode.encoder.b.v(d11, com.google.zxing.qrcode.decoder.g.i(j11 - 1), MinimalEncoder.this.f33084d)) {
                j11--;
            }
            this.f33095b = com.google.zxing.qrcode.decoder.g.i(j11);
        }

        private int d(com.google.zxing.qrcode.decoder.g gVar) {
            Iterator it = this.f33094a.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                i11 += ((a) it.next()).f(gVar);
            }
            return i11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(id.a aVar) {
            Iterator it = this.f33094a.iterator();
            while (it.hasNext()) {
                ((a) it.next()).d(aVar);
            }
        }

        int c() {
            return d(this.f33095b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public com.google.zxing.qrcode.decoder.g e() {
            return this.f33095b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            a aVar = null;
            for (a aVar2 : this.f33094a) {
                if (aVar != null) {
                    sb2.append(",");
                }
                sb2.append(aVar2.toString());
                aVar = aVar2;
            }
            return sb2.toString();
        }
    }

    MinimalEncoder(String str, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) {
        this.f33081a = str;
        this.f33082b = z10;
        this.f33083c = new g(str, charset, -1);
        this.f33084d = errorCorrectionLevel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c i(String str, com.google.zxing.qrcode.decoder.g gVar, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) {
        return new MinimalEncoder(str, charset, z10, errorCorrectionLevel).h(gVar);
    }

    static int k(Mode mode) {
        int i11;
        if (mode == null || (i11 = a.f33086b[mode.ordinal()]) == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 1;
        }
        if (i11 == 3) {
            return 2;
        }
        if (i11 == 4) {
            return 3;
        }
        throw new IllegalStateException("Illegal mode " + mode);
    }

    static com.google.zxing.qrcode.decoder.g l(VersionSize versionSize) {
        int i11 = a.f33085a[versionSize.ordinal()];
        return i11 != 1 ? i11 != 2 ? com.google.zxing.qrcode.decoder.g.i(40) : com.google.zxing.qrcode.decoder.g.i(26) : com.google.zxing.qrcode.decoder.g.i(9);
    }

    static VersionSize m(com.google.zxing.qrcode.decoder.g gVar) {
        return gVar.j() <= 9 ? VersionSize.SMALL : gVar.j() <= 26 ? VersionSize.MEDIUM : VersionSize.LARGE;
    }

    static boolean n(char c11) {
        return com.google.zxing.qrcode.encoder.b.p(c11) != -1;
    }

    static boolean o(char c11) {
        return com.google.zxing.qrcode.encoder.b.s(String.valueOf(c11));
    }

    static boolean p(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    void e(b[][][] bVarArr, int i11, b bVar) {
        b[] bVarArr2 = bVarArr[i11 + bVar.f33090d][bVar.f33089c];
        int k11 = k(bVar.f33087a);
        b bVar2 = bVarArr2[k11];
        if (bVar2 == null || bVar2.f33092f > bVar.f33092f) {
            bVarArr2[k11] = bVar;
        }
    }

    void f(com.google.zxing.qrcode.decoder.g gVar, b[][][] bVarArr, int i11, b bVar) {
        int i12;
        int g11 = this.f33083c.g();
        int f11 = this.f33083c.f();
        if (f11 < 0 || !this.f33083c.a(this.f33081a.charAt(i11), f11)) {
            f11 = 0;
        } else {
            g11 = f11 + 1;
        }
        int i13 = g11;
        for (int i14 = f11; i14 < i13; i14++) {
            if (this.f33083c.a(this.f33081a.charAt(i11), i14)) {
                e(bVarArr, i11, new b(this, Mode.BYTE, i11, i14, 1, bVar, gVar, null));
            }
        }
        Mode mode = Mode.KANJI;
        if (g(mode, this.f33081a.charAt(i11))) {
            e(bVarArr, i11, new b(this, mode, i11, 0, 1, bVar, gVar, null));
        }
        int length = this.f33081a.length();
        Mode mode2 = Mode.ALPHANUMERIC;
        if (g(mode2, this.f33081a.charAt(i11))) {
            int i15 = i11 + 1;
            e(bVarArr, i11, new b(this, mode2, i11, 0, (i15 >= length || !g(mode2, this.f33081a.charAt(i15))) ? 1 : 2, bVar, gVar, null));
        }
        Mode mode3 = Mode.NUMERIC;
        if (g(mode3, this.f33081a.charAt(i11))) {
            int i16 = i11 + 1;
            if (i16 >= length || !g(mode3, this.f33081a.charAt(i16))) {
                i12 = 1;
            } else {
                int i17 = i11 + 2;
                i12 = (i17 >= length || !g(mode3, this.f33081a.charAt(i17))) ? 2 : 3;
            }
            e(bVarArr, i11, new b(this, mode3, i11, 0, i12, bVar, gVar, null));
        }
    }

    boolean g(Mode mode, char c11) {
        int i11 = a.f33086b[mode.ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 == 4 : p(c11) : n(c11) : o(c11);
    }

    c h(com.google.zxing.qrcode.decoder.g gVar) {
        if (gVar != null) {
            c j11 = j(gVar);
            if (com.google.zxing.qrcode.encoder.b.v(j11.c(), l(m(j11.e())), this.f33084d)) {
                return j11;
            }
            throw new WriterException("Data too big for version" + gVar);
        }
        com.google.zxing.qrcode.decoder.g[] gVarArr = {l(VersionSize.SMALL), l(VersionSize.MEDIUM), l(VersionSize.LARGE)};
        c[] cVarArr = {j(gVarArr[0]), j(gVarArr[1]), j(gVarArr[2])};
        int i11 = Integer.MAX_VALUE;
        int i12 = -1;
        for (int i13 = 0; i13 < 3; i13++) {
            int c11 = cVarArr[i13].c();
            if (com.google.zxing.qrcode.encoder.b.v(c11, gVarArr[i13], this.f33084d) && c11 < i11) {
                i12 = i13;
                i11 = c11;
            }
        }
        if (i12 >= 0) {
            return cVarArr[i12];
        }
        throw new WriterException("Data too big for any version");
    }

    c j(com.google.zxing.qrcode.decoder.g gVar) {
        int length = this.f33081a.length();
        b[][][] bVarArr = (b[][][]) Array.newInstance((Class<?>) b.class, length + 1, this.f33083c.g(), 4);
        f(gVar, bVarArr, 0, null);
        for (int i11 = 1; i11 <= length; i11++) {
            for (int i12 = 0; i12 < this.f33083c.g(); i12++) {
                for (int i13 = 0; i13 < 4; i13++) {
                    b bVar = bVarArr[i11][i12][i13];
                    if (bVar != null && i11 < length) {
                        f(gVar, bVarArr, i11, bVar);
                    }
                }
            }
        }
        int i14 = -1;
        int i15 = Integer.MAX_VALUE;
        int i16 = -1;
        for (int i17 = 0; i17 < this.f33083c.g(); i17++) {
            for (int i18 = 0; i18 < 4; i18++) {
                b bVar2 = bVarArr[length][i17][i18];
                if (bVar2 != null && bVar2.f33092f < i15) {
                    i15 = bVar2.f33092f;
                    i14 = i17;
                    i16 = i18;
                }
            }
        }
        if (i14 >= 0) {
            return new c(gVar, bVarArr[length][i14][i16]);
        }
        throw new WriterException("Internal error: failed to encode \"" + this.f33081a + "\"");
    }
}
