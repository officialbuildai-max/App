package androidx.compose.animation;

import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2443a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final float[] f2444b;

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f2445c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f2446d;

    /* renamed from: androidx.compose.animation.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0028a {

        /* renamed from: a, reason: collision with root package name */
        private final float f2447a;

        /* renamed from: b, reason: collision with root package name */
        private final float f2448b;

        public C0028a(float f11, float f12) {
            this.f2447a = f11;
            this.f2448b = f12;
        }

        public final float a() {
            return this.f2447a;
        }

        public final float b() {
            return this.f2448b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0028a)) {
                return false;
            }
            C0028a c0028a = (C0028a) obj;
            return Float.compare(this.f2447a, c0028a.f2447a) == 0 && Float.compare(this.f2448b, c0028a.f2448b) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f2447a) * 31) + Float.floatToIntBits(this.f2448b);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.f2447a + ", velocityCoefficient=" + this.f2448b + ')';
        }
    }

    static {
        float[] fArr = new float[101];
        f2444b = fArr;
        float[] fArr2 = new float[101];
        f2445c = fArr2;
        f.b(fArr, fArr2, 100);
        f2446d = 8;
    }

    private a() {
    }

    public final double a(float f11, float f12) {
        return Math.log((Math.abs(f11) * 0.35f) / f12);
    }

    public final C0028a b(float f11) {
        float f12 = 0.0f;
        float f13 = 1.0f;
        float l11 = RangesKt.l(f11, 0.0f, 1.0f);
        float f14 = 100;
        int i11 = (int) (f14 * l11);
        if (i11 < 100) {
            float f15 = i11 / f14;
            int i12 = i11 + 1;
            float f16 = i12 / f14;
            float[] fArr = f2444b;
            float f17 = fArr[i11];
            float f18 = (fArr[i12] - f17) / (f16 - f15);
            float f19 = ((l11 - f15) * f18) + f17;
            f12 = f18;
            f13 = f19;
        }
        return new C0028a(f13, f12);
    }
}
