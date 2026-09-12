package id;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final float f65314a;

    /* renamed from: b, reason: collision with root package name */
    private final float f65315b;

    /* renamed from: c, reason: collision with root package name */
    private final float f65316c;

    /* renamed from: d, reason: collision with root package name */
    private final float f65317d;

    /* renamed from: e, reason: collision with root package name */
    private final float f65318e;

    /* renamed from: f, reason: collision with root package name */
    private final float f65319f;

    /* renamed from: g, reason: collision with root package name */
    private final float f65320g;

    /* renamed from: h, reason: collision with root package name */
    private final float f65321h;

    /* renamed from: i, reason: collision with root package name */
    private final float f65322i;

    private n(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.f65314a = f11;
        this.f65315b = f14;
        this.f65316c = f17;
        this.f65317d = f12;
        this.f65318e = f15;
        this.f65319f = f18;
        this.f65320g = f13;
        this.f65321h = f16;
        this.f65322i = f19;
    }

    public static n b(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26) {
        return d(f19, f20, f21, f22, f23, f24, f25, f26).e(c(f11, f12, f13, f14, f15, f16, f17, f18));
    }

    public static n c(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        return d(f11, f12, f13, f14, f15, f16, f17, f18).a();
    }

    public static n d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        float f19 = ((f11 - f13) + f15) - f17;
        float f20 = ((f12 - f14) + f16) - f18;
        if (f19 == 0.0f && f20 == 0.0f) {
            return new n(f13 - f11, f15 - f13, f11, f14 - f12, f16 - f14, f12, 0.0f, 0.0f, 1.0f);
        }
        float f21 = f13 - f15;
        float f22 = f17 - f15;
        float f23 = f14 - f16;
        float f24 = f18 - f16;
        float f25 = (f21 * f24) - (f22 * f23);
        float f26 = ((f24 * f19) - (f22 * f20)) / f25;
        float f27 = ((f21 * f20) - (f19 * f23)) / f25;
        return new n((f13 - f11) + (f26 * f13), (f17 - f11) + (f27 * f17), f11, (f14 - f12) + (f26 * f14), (f18 - f12) + (f27 * f18), f12, f26, f27, 1.0f);
    }

    n a() {
        float f11 = this.f65318e;
        float f12 = this.f65322i;
        float f13 = this.f65319f;
        float f14 = this.f65321h;
        float f15 = (f11 * f12) - (f13 * f14);
        float f16 = this.f65320g;
        float f17 = this.f65317d;
        float f18 = (f13 * f16) - (f17 * f12);
        float f19 = (f17 * f14) - (f11 * f16);
        float f20 = this.f65316c;
        float f21 = this.f65315b;
        float f22 = (f20 * f14) - (f21 * f12);
        float f23 = this.f65314a;
        return new n(f15, f18, f19, f22, (f12 * f23) - (f20 * f16), (f16 * f21) - (f14 * f23), (f21 * f13) - (f20 * f11), (f20 * f17) - (f13 * f23), (f23 * f11) - (f21 * f17));
    }

    n e(n nVar) {
        float f11 = this.f65314a;
        float f12 = nVar.f65314a;
        float f13 = this.f65317d;
        float f14 = nVar.f65315b;
        float f15 = this.f65320g;
        float f16 = nVar.f65316c;
        float f17 = (f11 * f12) + (f13 * f14) + (f15 * f16);
        float f18 = nVar.f65317d;
        float f19 = nVar.f65318e;
        float f20 = nVar.f65319f;
        float f21 = (f11 * f18) + (f13 * f19) + (f15 * f20);
        float f22 = nVar.f65320g;
        float f23 = nVar.f65321h;
        float f24 = nVar.f65322i;
        float f25 = (f11 * f22) + (f13 * f23) + (f15 * f24);
        float f26 = this.f65315b;
        float f27 = this.f65318e;
        float f28 = this.f65321h;
        float f29 = (f26 * f12) + (f27 * f14) + (f28 * f16);
        float f30 = (f26 * f18) + (f27 * f19) + (f28 * f20);
        float f31 = (f28 * f24) + (f26 * f22) + (f27 * f23);
        float f32 = this.f65316c;
        float f33 = this.f65319f;
        float f34 = (f12 * f32) + (f14 * f33);
        float f35 = this.f65322i;
        return new n(f17, f21, f25, f29, f30, f31, (f16 * f35) + f34, (f18 * f32) + (f19 * f33) + (f20 * f35), (f32 * f22) + (f33 * f23) + (f35 * f24));
    }

    public void f(float[] fArr) {
        float f11 = this.f65314a;
        float f12 = this.f65315b;
        float f13 = this.f65316c;
        float f14 = this.f65317d;
        float f15 = this.f65318e;
        float f16 = this.f65319f;
        float f17 = this.f65320g;
        float f18 = this.f65321h;
        float f19 = this.f65322i;
        int length = fArr.length - 1;
        for (int i11 = 0; i11 < length; i11 += 2) {
            float f20 = fArr[i11];
            int i12 = i11 + 1;
            float f21 = fArr[i12];
            float f22 = (f13 * f20) + (f16 * f21) + f19;
            fArr[i11] = (((f11 * f20) + (f14 * f21)) + f17) / f22;
            fArr[i12] = (((f20 * f12) + (f21 * f15)) + f18) / f22;
        }
    }
}
