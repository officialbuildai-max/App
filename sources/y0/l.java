package y0;

/* loaded from: classes2.dex */
final class l {

    /* renamed from: k, reason: collision with root package name */
    static final l f78664k = k(b.f78629c, (float) ((b.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a, reason: collision with root package name */
    private final float f78665a;

    /* renamed from: b, reason: collision with root package name */
    private final float f78666b;

    /* renamed from: c, reason: collision with root package name */
    private final float f78667c;

    /* renamed from: d, reason: collision with root package name */
    private final float f78668d;

    /* renamed from: e, reason: collision with root package name */
    private final float f78669e;

    /* renamed from: f, reason: collision with root package name */
    private final float f78670f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f78671g;

    /* renamed from: h, reason: collision with root package name */
    private final float f78672h;

    /* renamed from: i, reason: collision with root package name */
    private final float f78673i;

    /* renamed from: j, reason: collision with root package name */
    private final float f78674j;

    private l(float f11, float f12, float f13, float f14, float f15, float f16, float[] fArr, float f17, float f18, float f19) {
        this.f78670f = f11;
        this.f78665a = f12;
        this.f78666b = f13;
        this.f78667c = f14;
        this.f78668d = f15;
        this.f78669e = f16;
        this.f78671g = fArr;
        this.f78672h = f17;
        this.f78673i = f18;
        this.f78674j = f19;
    }

    static l k(float[] fArr, float f11, float f12, float f13, boolean z10) {
        float[][] fArr2 = b.f78627a;
        float f14 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f15 = fArr3[0] * f14;
        float f16 = fArr[1];
        float f17 = f15 + (fArr3[1] * f16);
        float f18 = fArr[2];
        float f19 = f17 + (fArr3[2] * f18);
        float[] fArr4 = fArr2[1];
        float f20 = (fArr4[0] * f14) + (fArr4[1] * f16) + (fArr4[2] * f18);
        float[] fArr5 = fArr2[2];
        float f21 = (f14 * fArr5[0]) + (f16 * fArr5[1]) + (f18 * fArr5[2]);
        float f22 = (f13 / 10.0f) + 0.8f;
        float d11 = ((double) f22) >= 0.9d ? b.d(0.59f, 0.69f, (f22 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f22 - 0.8f) * 10.0f);
        float exp = z10 ? 1.0f : (1.0f - (((float) Math.exp(((-f11) - 42.0f) / 92.0f)) * 0.2777778f)) * f22;
        double d12 = exp;
        if (d12 > 1.0d) {
            exp = 1.0f;
        } else if (d12 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f19) * exp) + 1.0f) - exp, (((100.0f / f20) * exp) + 1.0f) - exp, (((100.0f / f21) * exp) + 1.0f) - exp};
        float f23 = 1.0f / ((5.0f * f11) + 1.0f);
        float f24 = f23 * f23 * f23 * f23;
        float f25 = 1.0f - f24;
        float cbrt = (f24 * f11) + (0.1f * f25 * f25 * ((float) Math.cbrt(f11 * 5.0d)));
        float h11 = b.h(f12) / fArr[1];
        double d13 = h11;
        float sqrt = ((float) Math.sqrt(d13)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d13, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f19) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f20) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f21) / 100.0d, 0.42d)};
        float f26 = fArr7[0];
        float f27 = (f26 * 400.0f) / (f26 + 27.13f);
        float f28 = fArr7[1];
        float f29 = (f28 * 400.0f) / (f28 + 27.13f);
        float f30 = fArr7[2];
        float[] fArr8 = {f27, f29, (400.0f * f30) / (f30 + 27.13f)};
        return new l(h11, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, d11, f22, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f78665a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f78668d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f78672h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f78673i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f78670f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f78666b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f78669e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.f78667c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] i() {
        return this.f78671g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f78674j;
    }
}
