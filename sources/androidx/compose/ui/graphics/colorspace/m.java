package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.w1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class m extends c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4475e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final float[] f4476f;

    /* renamed from: g, reason: collision with root package name */
    private static final float[] f4477g;

    /* renamed from: h, reason: collision with root package name */
    private static final float[] f4478h;

    /* renamed from: i, reason: collision with root package name */
    private static final float[] f4479i;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        float[] b11 = androidx.compose.ui.graphics.colorspace.a.f4414b.a().b();
        k kVar = k.f4463a;
        float[] l11 = d.l(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, d.e(b11, kVar.b().c(), kVar.e().c()));
        f4476f = l11;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f4477g = fArr;
        f4478h = d.k(l11);
        f4479i = d.k(fArr);
    }

    public m(String str, int i11) {
        super(str, b.f4419a.a(), i11, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float c(int i11) {
        return i11 == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float d(int i11) {
        return i11 == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long h(float f11, float f12, float f13) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        if (f12 < -0.5f) {
            f12 = -0.5f;
        }
        if (f12 > 0.5f) {
            f12 = 0.5f;
        }
        if (f13 < -0.5f) {
            f13 = -0.5f;
        }
        float f14 = f13 <= 0.5f ? f13 : 0.5f;
        float[] fArr = f4479i;
        float f15 = (fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f14);
        float f16 = (fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f14);
        float f17 = (fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f14);
        float f18 = f15 * f15 * f15;
        float f19 = f16 * f16 * f16;
        float f20 = f17 * f17 * f17;
        float[] fArr2 = f4478h;
        return (Float.floatToRawIntBits(((fArr2[0] * f18) + (fArr2[3] * f19)) + (fArr2[6] * f20)) << 32) | (Float.floatToRawIntBits((fArr2[1] * f18) + (fArr2[4] * f19) + (fArr2[7] * f20)) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public float i(float f11, float f12, float f13) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        if (f12 < -0.5f) {
            f12 = -0.5f;
        }
        if (f12 > 0.5f) {
            f12 = 0.5f;
        }
        if (f13 < -0.5f) {
            f13 = -0.5f;
        }
        float f14 = f13 <= 0.5f ? f13 : 0.5f;
        float[] fArr = f4479i;
        float f15 = (fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f14);
        float f16 = (fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f14);
        float f17 = (fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f14);
        float f18 = f15 * f15 * f15;
        float f19 = f16 * f16 * f16;
        float[] fArr2 = f4478h;
        return (fArr2[2] * f18) + (fArr2[5] * f19) + (fArr2[8] * f17 * f17 * f17);
    }

    @Override // androidx.compose.ui.graphics.colorspace.c
    public long j(float f11, float f12, float f13, float f14, c cVar) {
        float[] fArr = f4476f;
        float f15 = (fArr[0] * f11) + (fArr[3] * f12) + (fArr[6] * f13);
        float f16 = (fArr[1] * f11) + (fArr[4] * f12) + (fArr[7] * f13);
        float f17 = (fArr[2] * f11) + (fArr[5] * f12) + (fArr[8] * f13);
        float a11 = q0.b.a(f15);
        float a12 = q0.b.a(f16);
        float a13 = q0.b.a(f17);
        float[] fArr2 = f4477g;
        return w1.a((fArr2[0] * a11) + (fArr2[3] * a12) + (fArr2[6] * a13), (fArr2[1] * a11) + (fArr2[4] * a12) + (fArr2[7] * a13), (fArr2[2] * a11) + (fArr2[5] * a12) + (fArr2[8] * a13), f14, cVar);
    }
}
