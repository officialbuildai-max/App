package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.w1;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class Rgb extends c {

    /* renamed from: t, reason: collision with root package name */
    public static final a f4397t = new a(null);

    /* renamed from: u, reason: collision with root package name */
    private static final j f4398u = new j() { // from class: androidx.compose.ui.graphics.colorspace.q
        @Override // androidx.compose.ui.graphics.colorspace.j
        public final double a(double d11) {
            double t11;
            t11 = Rgb.t(d11);
            return t11;
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final y f4399e;

    /* renamed from: f, reason: collision with root package name */
    private final float f4400f;

    /* renamed from: g, reason: collision with root package name */
    private final float f4401g;

    /* renamed from: h, reason: collision with root package name */
    private final x f4402h;

    /* renamed from: i, reason: collision with root package name */
    private final float[] f4403i;

    /* renamed from: j, reason: collision with root package name */
    private final float[] f4404j;

    /* renamed from: k, reason: collision with root package name */
    private final float[] f4405k;

    /* renamed from: l, reason: collision with root package name */
    private final j f4406l;

    /* renamed from: m, reason: collision with root package name */
    private final Function1 f4407m;

    /* renamed from: n, reason: collision with root package name */
    private final j f4408n;

    /* renamed from: o, reason: collision with root package name */
    private final j f4409o;

    /* renamed from: p, reason: collision with root package name */
    private final Function1 f4410p;

    /* renamed from: q, reason: collision with root package name */
    private final j f4411q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f4412r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f4413s;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float e(float[] fArr) {
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            float f15 = fArr[4];
            float f16 = fArr[5];
            float f17 = ((((((f11 * f14) + (f12 * f15)) + (f13 * f16)) - (f14 * f15)) - (f12 * f13)) - (f11 * f16)) * 0.5f;
            return f17 < 0.0f ? -f17 : f17;
        }

        private final boolean f(double d11, j jVar, j jVar2) {
            return Math.abs(jVar.a(d11) - jVar2.a(d11)) <= 0.001d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] g(float[] fArr, y yVar) {
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            float f15 = fArr[4];
            float f16 = fArr[5];
            float a11 = yVar.a();
            float b11 = yVar.b();
            float f17 = 1;
            float f18 = (f17 - f11) / f12;
            float f19 = (f17 - f13) / f14;
            float f20 = (f17 - f15) / f16;
            float f21 = (f17 - a11) / b11;
            float f22 = f11 / f12;
            float f23 = (f13 / f14) - f22;
            float f24 = (a11 / b11) - f22;
            float f25 = f19 - f18;
            float f26 = (f15 / f16) - f22;
            float f27 = (((f21 - f18) * f23) - (f24 * f25)) / (((f20 - f18) * f23) - (f25 * f26));
            float f28 = (f24 - (f26 * f27)) / f23;
            float f29 = (1.0f - f28) - f27;
            float f30 = f29 / f12;
            float f31 = f28 / f14;
            float f32 = f27 / f16;
            return new float[]{f30 * f11, f29, f30 * ((1.0f - f11) - f12), f31 * f13, f28, f31 * ((1.0f - f13) - f14), f32 * f15, f27, f32 * ((1.0f - f15) - f16)};
        }

        private final boolean h(float[] fArr, float[] fArr2) {
            float f11 = fArr[0];
            float f12 = fArr2[0];
            float f13 = fArr[1];
            float f14 = fArr2[1];
            float f15 = fArr[2] - fArr2[2];
            float f16 = fArr[3] - fArr2[3];
            float f17 = fArr[4];
            float f18 = fArr2[4];
            float f19 = fArr[5];
            float f20 = fArr2[5];
            float[] fArr3 = {f11 - f12, f13 - f14, f15, f16, f17 - f18, f19 - f20};
            return i(fArr3[0], fArr3[1], f12 - f18, f14 - f20) >= 0.0f && i(fArr2[0] - fArr2[2], fArr2[1] - fArr2[3], fArr3[0], fArr3[1]) >= 0.0f && i(fArr3[2], fArr3[3], fArr2[2] - fArr2[0], fArr2[3] - fArr2[1]) >= 0.0f && i(fArr2[2] - fArr2[4], fArr2[3] - fArr2[5], fArr3[2], fArr3[3]) >= 0.0f && i(fArr3[4], fArr3[5], fArr2[4] - fArr2[2], fArr2[5] - fArr2[3]) >= 0.0f && i(fArr2[4] - fArr2[0], fArr2[5] - fArr2[1], fArr3[4], fArr3[5]) >= 0.0f;
        }

        private final float i(float f11, float f12, float f13, float f14) {
            return (f11 * f14) - (f12 * f13);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean j(float[] fArr, y yVar, j jVar, j jVar2, float f11, float f12, int i11) {
            if (i11 == 0) {
                return true;
            }
            g gVar = g.f4428a;
            if (!d.g(fArr, gVar.x()) || !d.f(yVar, k.f4463a.e()) || f11 != 0.0f || f12 != 1.0f) {
                return false;
            }
            Rgb w11 = gVar.w();
            for (double d11 = 0.0d; d11 <= 1.0d; d11 += 0.00392156862745098d) {
                if (!f(d11, jVar, w11.J()) || !f(d11, jVar2, w11.F())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean k(float[] fArr, float f11, float f12) {
            float e11 = e(fArr);
            g gVar = g.f4428a;
            return (e11 / e(gVar.s()) > 0.9f && h(fArr, gVar.x())) || (f11 < 0.0f && f12 > 1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] l(float[] fArr) {
            float[] fArr2 = new float[6];
            if (fArr.length == 9) {
                float f11 = fArr[0];
                float f12 = fArr[1];
                float f13 = f11 + f12 + fArr[2];
                fArr2[0] = f11 / f13;
                fArr2[1] = f12 / f13;
                float f14 = fArr[3];
                float f15 = fArr[4];
                float f16 = f14 + f15 + fArr[5];
                fArr2[2] = f14 / f16;
                fArr2[3] = f15 / f16;
                float f17 = fArr[6];
                float f18 = fArr[7];
                float f19 = f17 + f18 + fArr[8];
                fArr2[4] = f17 / f19;
                fArr2[5] = f18 / f19;
            } else {
                ArraysKt.p(fArr, fArr2, 0, 0, 6, 6, null);
            }
            return fArr2;
        }
    }

    public Rgb(Rgb rgb, float[] fArr, y yVar) {
        this(rgb.f(), rgb.f4403i, yVar, fArr, rgb.f4406l, rgb.f4409o, rgb.f4400f, rgb.f4401g, rgb.f4402h, -1);
    }

    public Rgb(String str, float[] fArr, y yVar, final double d11, float f11, float f12, int i11) {
        this(str, fArr, yVar, null, d11 == 1.0d ? f4398u : new j() { // from class: androidx.compose.ui.graphics.colorspace.r
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d12) {
                double u11;
                u11 = Rgb.u(d11, d12);
                return u11;
            }
        }, d11 == 1.0d ? f4398u : new j() { // from class: androidx.compose.ui.graphics.colorspace.s
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d12) {
                double v11;
                v11 = Rgb.v(d11, d12);
                return v11;
            }
        }, f11, f12, new x(d11, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 96, null), i11);
    }

    public Rgb(String str, float[] fArr, y yVar, final x xVar, int i11) {
        this(str, fArr, yVar, null, (xVar.e() == 0.0d && xVar.f() == 0.0d) ? new j() { // from class: androidx.compose.ui.graphics.colorspace.t
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                double w11;
                w11 = Rgb.w(x.this, d11);
                return w11;
            }
        } : new j() { // from class: androidx.compose.ui.graphics.colorspace.u
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                double x10;
                x10 = Rgb.x(x.this, d11);
                return x10;
            }
        }, (xVar.e() == 0.0d && xVar.f() == 0.0d) ? new j() { // from class: androidx.compose.ui.graphics.colorspace.v
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                double y10;
                y10 = Rgb.y(x.this, d11);
                return y10;
            }
        } : new j() { // from class: androidx.compose.ui.graphics.colorspace.w
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                double z10;
                z10 = Rgb.z(x.this, d11);
                return z10;
            }
        }, 0.0f, 1.0f, xVar, i11);
    }

    public Rgb(String str, float[] fArr, y yVar, float[] fArr2, j jVar, j jVar2, float f11, float f12, x xVar, int i11) {
        super(str, b.f4419a.b(), i11, null);
        this.f4399e = yVar;
        this.f4400f = f11;
        this.f4401g = f12;
        this.f4402h = xVar;
        this.f4406l = jVar;
        this.f4407m = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Double invoke(double d11) {
                float f13;
                float f14;
                double a11 = Rgb.this.J().a(d11);
                f13 = Rgb.this.f4400f;
                double d12 = f13;
                f14 = Rgb.this.f4401g;
                return Double.valueOf(RangesKt.k(a11, d12, f14));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).doubleValue());
            }
        };
        this.f4408n = new j() { // from class: androidx.compose.ui.graphics.colorspace.o
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                double O;
                O = Rgb.O(Rgb.this, d11);
                return O;
            }
        };
        this.f4409o = jVar2;
        this.f4410p = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Double invoke(double d11) {
                float f13;
                float f14;
                j F = Rgb.this.F();
                f13 = Rgb.this.f4400f;
                double d12 = f13;
                f14 = Rgb.this.f4401g;
                return Double.valueOf(F.a(RangesKt.k(d11, d12, f14)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).doubleValue());
            }
        };
        this.f4411q = new j() { // from class: androidx.compose.ui.graphics.colorspace.p
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d11) {
                double C;
                C = Rgb.C(Rgb.this, d11);
                return C;
            }
        };
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f11 >= f12) {
            throw new IllegalArgumentException("Invalid range: min=" + f11 + ", max=" + f12 + "; min must be strictly < max");
        }
        a aVar = f4397t;
        float[] l11 = aVar.l(fArr);
        this.f4403i = l11;
        if (fArr2 == null) {
            this.f4404j = aVar.g(l11, yVar);
        } else {
            if (fArr2.length != 9) {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
            }
            this.f4404j = fArr2;
        }
        this.f4405k = d.k(this.f4404j);
        this.f4412r = aVar.k(l11, f11, f12);
        this.f4413s = aVar.j(l11, yVar, jVar, jVar2, f11, f12, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double C(Rgb rgb, double d11) {
        return rgb.f4409o.a(RangesKt.k(d11, rgb.f4400f, rgb.f4401g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double O(Rgb rgb, double d11) {
        return RangesKt.k(rgb.f4406l.a(d11), rgb.f4400f, rgb.f4401g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double t(double d11) {
        return d11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double u(double d11, double d12) {
        if (d12 < 0.0d) {
            d12 = 0.0d;
        }
        return Math.pow(d12, 1.0d / d11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double v(double d11, double d12) {
        if (d12 < 0.0d) {
            d12 = 0.0d;
        }
        return Math.pow(d12, d11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double w(x xVar, double d11) {
        return d.o(d11, xVar.a(), xVar.b(), xVar.c(), xVar.d(), xVar.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double x(x xVar, double d11) {
        return d.p(d11, xVar.a(), xVar.b(), xVar.c(), xVar.d(), xVar.e(), xVar.f(), xVar.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double y(x xVar, double d11) {
        return d.q(d11, xVar.a(), xVar.b(), xVar.c(), xVar.d(), xVar.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double z(x xVar, double d11) {
        return d.r(d11, xVar.a(), xVar.b(), xVar.c(), xVar.d(), xVar.e(), xVar.f(), xVar.g());
    }

    public final Function1 D() {
        return this.f4410p;
    }

    public final j E() {
        return this.f4411q;
    }

    public final j F() {
        return this.f4409o;
    }

    public final float[] G() {
        return this.f4405k;
    }

    public final Function1 H() {
        return this.f4407m;
    }

    public final j I() {
        return this.f4408n;
    }

    public final j J() {
        return this.f4406l;
    }

    public final float[] K() {
        return this.f4403i;
    }

    public final x L() {
        return this.f4402h;
    }

    public final float[] M() {
        return this.f4404j;
    }

    public final y N() {
        return this.f4399e;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float c(int i11) {
        return this.f4401g;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float d(int i11) {
        return this.f4400f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rgb.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.f4400f, this.f4400f) != 0 || Float.compare(rgb.f4401g, this.f4401g) != 0 || !Intrinsics.c(this.f4399e, rgb.f4399e) || !Arrays.equals(this.f4403i, rgb.f4403i)) {
            return false;
        }
        x xVar = this.f4402h;
        if (xVar != null) {
            return Intrinsics.c(xVar, rgb.f4402h);
        }
        if (rgb.f4402h == null) {
            return true;
        }
        if (Intrinsics.c(this.f4406l, rgb.f4406l)) {
            return Intrinsics.c(this.f4409o, rgb.f4409o);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public boolean g() {
        return this.f4413s;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long h(float f11, float f12, float f13) {
        float a11 = (float) this.f4411q.a(f11);
        float a12 = (float) this.f4411q.a(f12);
        float a13 = (float) this.f4411q.a(f13);
        float[] fArr = this.f4404j;
        float f14 = (fArr[0] * a11) + (fArr[3] * a12) + (fArr[6] * a13);
        float f15 = (fArr[1] * a11) + (fArr[4] * a12) + (fArr[7] * a13);
        return (Float.floatToRawIntBits(f14) << 32) | (Float.floatToRawIntBits(f15) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public int hashCode() {
        int hashCode = ((((super.hashCode() * 31) + this.f4399e.hashCode()) * 31) + Arrays.hashCode(this.f4403i)) * 31;
        float f11 = this.f4400f;
        int floatToIntBits = (hashCode + (f11 == 0.0f ? 0 : Float.floatToIntBits(f11))) * 31;
        float f12 = this.f4401g;
        int floatToIntBits2 = (floatToIntBits + (f12 == 0.0f ? 0 : Float.floatToIntBits(f12))) * 31;
        x xVar = this.f4402h;
        int hashCode2 = floatToIntBits2 + (xVar != null ? xVar.hashCode() : 0);
        return this.f4402h == null ? (((hashCode2 * 31) + this.f4406l.hashCode()) * 31) + this.f4409o.hashCode() : hashCode2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float i(float f11, float f12, float f13) {
        float a11 = (float) this.f4411q.a(f11);
        float a12 = (float) this.f4411q.a(f12);
        float a13 = (float) this.f4411q.a(f13);
        float[] fArr = this.f4404j;
        return (fArr[2] * a11) + (fArr[5] * a12) + (fArr[8] * a13);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long j(float f11, float f12, float f13, float f14, c cVar) {
        float[] fArr = this.f4405k;
        return w1.a((float) this.f4408n.a((fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f13)), (float) this.f4408n.a((fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f13)), (float) this.f4408n.a((fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f13)), f14, cVar);
    }
}
