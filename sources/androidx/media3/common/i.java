package androidx.media3.common;

import androidx.media3.common.util.a1;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: h, reason: collision with root package name */
    public static final i f10145h = new b().d(1).c(2).e(3).a();

    /* renamed from: i, reason: collision with root package name */
    public static final i f10146i = new b().d(1).c(1).e(2).a();

    /* renamed from: j, reason: collision with root package name */
    private static final String f10147j = a1.C0(0);

    /* renamed from: k, reason: collision with root package name */
    private static final String f10148k = a1.C0(1);

    /* renamed from: l, reason: collision with root package name */
    private static final String f10149l = a1.C0(2);

    /* renamed from: m, reason: collision with root package name */
    private static final String f10150m = a1.C0(3);

    /* renamed from: n, reason: collision with root package name */
    private static final String f10151n = a1.C0(4);

    /* renamed from: o, reason: collision with root package name */
    private static final String f10152o = a1.C0(5);

    /* renamed from: a, reason: collision with root package name */
    public final int f10153a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10154b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10155c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f10156d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10157e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10158f;

    /* renamed from: g, reason: collision with root package name */
    private int f10159g;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f10160a;

        /* renamed from: b, reason: collision with root package name */
        private int f10161b;

        /* renamed from: c, reason: collision with root package name */
        private int f10162c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f10163d;

        /* renamed from: e, reason: collision with root package name */
        private int f10164e;

        /* renamed from: f, reason: collision with root package name */
        private int f10165f;

        public b() {
            this.f10160a = -1;
            this.f10161b = -1;
            this.f10162c = -1;
            this.f10164e = -1;
            this.f10165f = -1;
        }

        private b(i iVar) {
            this.f10160a = iVar.f10153a;
            this.f10161b = iVar.f10154b;
            this.f10162c = iVar.f10155c;
            this.f10163d = iVar.f10156d;
            this.f10164e = iVar.f10157e;
            this.f10165f = iVar.f10158f;
        }

        public i a() {
            return new i(this.f10160a, this.f10161b, this.f10162c, this.f10163d, this.f10164e, this.f10165f);
        }

        public b b(int i11) {
            this.f10165f = i11;
            return this;
        }

        public b c(int i11) {
            this.f10161b = i11;
            return this;
        }

        public b d(int i11) {
            this.f10160a = i11;
            return this;
        }

        public b e(int i11) {
            this.f10162c = i11;
            return this;
        }

        public b f(byte[] bArr) {
            this.f10163d = bArr;
            return this;
        }

        public b g(int i11) {
            this.f10164e = i11;
            return this;
        }
    }

    private i(int i11, int i12, int i13, byte[] bArr, int i14, int i15) {
        this.f10153a = i11;
        this.f10154b = i12;
        this.f10155c = i13;
        this.f10156d = bArr;
        this.f10157e = i14;
        this.f10158f = i15;
    }

    private static String b(int i11) {
        if (i11 == -1) {
            return "NA";
        }
        return i11 + "bit Chroma";
    }

    private static String c(int i11) {
        if (i11 == -1) {
            return "Unset color range";
        }
        if (i11 == 1) {
            return "Full range";
        }
        if (i11 == 2) {
            return "Limited range";
        }
        return "Undefined color range " + i11;
    }

    private static String d(int i11) {
        if (i11 == -1) {
            return "Unset color space";
        }
        if (i11 == 6) {
            return "BT2020";
        }
        if (i11 == 1) {
            return "BT709";
        }
        if (i11 == 2) {
            return "BT601";
        }
        return "Undefined color space " + i11;
    }

    private static String e(int i11) {
        if (i11 == -1) {
            return "Unset color transfer";
        }
        if (i11 == 10) {
            return "Gamma 2.2";
        }
        if (i11 == 1) {
            return "Linear";
        }
        if (i11 == 2) {
            return "sRGB";
        }
        if (i11 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i11 == 6) {
            return "ST2084 PQ";
        }
        if (i11 == 7) {
            return "HLG";
        }
        return "Undefined color transfer " + i11;
    }

    public static boolean h(i iVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (iVar == null) {
            return true;
        }
        int i15 = iVar.f10153a;
        return (i15 == -1 || i15 == 1 || i15 == 2) && ((i11 = iVar.f10154b) == -1 || i11 == 2) && (((i12 = iVar.f10155c) == -1 || i12 == 3) && iVar.f10156d == null && (((i13 = iVar.f10158f) == -1 || i13 == 8) && ((i14 = iVar.f10157e) == -1 || i14 == 8)));
    }

    public static int j(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 9) {
            return (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int k(int i11) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 4) {
            return 10;
        }
        if (i11 == 13) {
            return 2;
        }
        if (i11 == 16) {
            return 6;
        }
        if (i11 != 18) {
            return (i11 == 6 || i11 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String l(int i11) {
        if (i11 == -1) {
            return "NA";
        }
        return i11 + "bit Luma";
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f10153a == iVar.f10153a && this.f10154b == iVar.f10154b && this.f10155c == iVar.f10155c && Arrays.equals(this.f10156d, iVar.f10156d) && this.f10157e == iVar.f10157e && this.f10158f == iVar.f10158f;
    }

    public boolean f() {
        return (this.f10157e == -1 || this.f10158f == -1) ? false : true;
    }

    public boolean g() {
        return (this.f10153a == -1 || this.f10154b == -1 || this.f10155c == -1) ? false : true;
    }

    public int hashCode() {
        if (this.f10159g == 0) {
            this.f10159g = ((((((((((527 + this.f10153a) * 31) + this.f10154b) * 31) + this.f10155c) * 31) + Arrays.hashCode(this.f10156d)) * 31) + this.f10157e) * 31) + this.f10158f;
        }
        return this.f10159g;
    }

    public boolean i() {
        return f() || g();
    }

    public String m() {
        String str;
        String G = g() ? a1.G("%s/%s/%s", d(this.f10153a), c(this.f10154b), e(this.f10155c)) : "NA/NA/NA";
        if (f()) {
            str = this.f10157e + "/" + this.f10158f;
        } else {
            str = "NA/NA";
        }
        return G + "/" + str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ColorInfo(");
        sb2.append(d(this.f10153a));
        sb2.append(", ");
        sb2.append(c(this.f10154b));
        sb2.append(", ");
        sb2.append(e(this.f10155c));
        sb2.append(", ");
        sb2.append(this.f10156d != null);
        sb2.append(", ");
        sb2.append(l(this.f10157e));
        sb2.append(", ");
        sb2.append(b(this.f10158f));
        sb2.append(")");
        return sb2.toString();
    }
}
