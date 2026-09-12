package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4367a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f4368b = D(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f4369c = D(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f4370d = D(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f4371e = D(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f4372f = D(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f4373g = D(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f4374h = D(6);

    /* renamed from: i, reason: collision with root package name */
    private static final int f4375i = D(7);

    /* renamed from: j, reason: collision with root package name */
    private static final int f4376j = D(8);

    /* renamed from: k, reason: collision with root package name */
    private static final int f4377k = D(9);

    /* renamed from: l, reason: collision with root package name */
    private static final int f4378l = D(10);

    /* renamed from: m, reason: collision with root package name */
    private static final int f4379m = D(11);

    /* renamed from: n, reason: collision with root package name */
    private static final int f4380n = D(12);

    /* renamed from: o, reason: collision with root package name */
    private static final int f4381o = D(13);

    /* renamed from: p, reason: collision with root package name */
    private static final int f4382p = D(14);

    /* renamed from: q, reason: collision with root package name */
    private static final int f4383q = D(15);

    /* renamed from: r, reason: collision with root package name */
    private static final int f4384r = D(16);

    /* renamed from: s, reason: collision with root package name */
    private static final int f4385s = D(17);

    /* renamed from: t, reason: collision with root package name */
    private static final int f4386t = D(18);

    /* renamed from: u, reason: collision with root package name */
    private static final int f4387u = D(19);

    /* renamed from: v, reason: collision with root package name */
    private static final int f4388v = D(20);

    /* renamed from: w, reason: collision with root package name */
    private static final int f4389w = D(21);

    /* renamed from: x, reason: collision with root package name */
    private static final int f4390x = D(22);

    /* renamed from: y, reason: collision with root package name */
    private static final int f4391y = D(23);

    /* renamed from: z, reason: collision with root package name */
    private static final int f4392z = D(24);
    private static final int A = D(25);
    private static final int B = D(26);
    private static final int C = D(27);
    private static final int D = D(28);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int A() {
            return c1.f4375i;
        }

        public final int B() {
            return c1.f4371e;
        }

        public final int C() {
            return c1.f4379m;
        }

        public final int a() {
            return c1.f4368b;
        }

        public final int b() {
            return c1.C;
        }

        public final int c() {
            return c1.f4387u;
        }

        public final int d() {
            return c1.f4386t;
        }

        public final int e() {
            return c1.f4384r;
        }

        public final int f() {
            return c1.f4390x;
        }

        public final int g() {
            return c1.f4370d;
        }

        public final int h() {
            return c1.f4378l;
        }

        public final int i() {
            return c1.f4374h;
        }

        public final int j() {
            return c1.f4376j;
        }

        public final int k() {
            return c1.f4372f;
        }

        public final int l() {
            return c1.f4391y;
        }

        public final int m() {
            return c1.f4388v;
        }

        public final int n() {
            return c1.A;
        }

        public final int o() {
            return c1.f4385s;
        }

        public final int p() {
            return c1.D;
        }

        public final int q() {
            return c1.f4381o;
        }

        public final int r() {
            return c1.f4392z;
        }

        public final int s() {
            return c1.f4383q;
        }

        public final int t() {
            return c1.f4380n;
        }

        public final int u() {
            return c1.B;
        }

        public final int v() {
            return c1.f4382p;
        }

        public final int w() {
            return c1.f4389w;
        }

        public final int x() {
            return c1.f4369c;
        }

        public final int y() {
            return c1.f4377k;
        }

        public final int z() {
            return c1.f4373g;
        }
    }

    public static int D(int i11) {
        return i11;
    }

    public static final boolean E(int i11, int i12) {
        return i11 == i12;
    }

    public static int F(int i11) {
        return i11;
    }

    public static String G(int i11) {
        return E(i11, f4368b) ? "Clear" : E(i11, f4369c) ? "Src" : E(i11, f4370d) ? "Dst" : E(i11, f4371e) ? "SrcOver" : E(i11, f4372f) ? "DstOver" : E(i11, f4373g) ? "SrcIn" : E(i11, f4374h) ? "DstIn" : E(i11, f4375i) ? "SrcOut" : E(i11, f4376j) ? "DstOut" : E(i11, f4377k) ? "SrcAtop" : E(i11, f4378l) ? "DstAtop" : E(i11, f4379m) ? "Xor" : E(i11, f4380n) ? "Plus" : E(i11, f4381o) ? "Modulate" : E(i11, f4382p) ? "Screen" : E(i11, f4383q) ? "Overlay" : E(i11, f4384r) ? "Darken" : E(i11, f4385s) ? "Lighten" : E(i11, f4386t) ? "ColorDodge" : E(i11, f4387u) ? "ColorBurn" : E(i11, f4388v) ? "HardLight" : E(i11, f4389w) ? "Softlight" : E(i11, f4390x) ? "Difference" : E(i11, f4391y) ? "Exclusion" : E(i11, f4392z) ? "Multiply" : E(i11, A) ? "Hue" : E(i11, B) ? "Saturation" : E(i11, C) ? "Color" : E(i11, D) ? "Luminosity" : "Unknown";
    }
}
