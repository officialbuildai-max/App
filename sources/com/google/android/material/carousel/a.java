package com.google.android.material.carousel;

/* loaded from: classes4.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    final int f28656a;

    /* renamed from: b, reason: collision with root package name */
    float f28657b;

    /* renamed from: c, reason: collision with root package name */
    int f28658c;

    /* renamed from: d, reason: collision with root package name */
    int f28659d;

    /* renamed from: e, reason: collision with root package name */
    float f28660e;

    /* renamed from: f, reason: collision with root package name */
    float f28661f;

    /* renamed from: g, reason: collision with root package name */
    final int f28662g;

    /* renamed from: h, reason: collision with root package name */
    final float f28663h;

    a(int i11, float f11, float f12, float f13, int i12, float f14, int i13, float f15, int i14, float f16) {
        this.f28656a = i11;
        this.f28657b = d1.a.a(f11, f12, f13);
        this.f28658c = i12;
        this.f28660e = f14;
        this.f28659d = i13;
        this.f28661f = f15;
        this.f28662g = i14;
        d(f16, f12, f13, f15);
        this.f28663h = b(f15);
    }

    private float a(float f11, int i11, float f12, int i12, int i13) {
        if (i11 <= 0) {
            f12 = 0.0f;
        }
        float f13 = i12 / 2.0f;
        return (f11 - ((i11 + f13) * f12)) / (i13 + f13);
    }

    private float b(float f11) {
        if (g()) {
            return Math.abs(f11 - this.f28661f) * this.f28656a;
        }
        return Float.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(float f11, float f12, float f13, float f14, int[] iArr, float f15, int[] iArr2, float f16, int[] iArr3) {
        a aVar = null;
        int i11 = 1;
        for (int i12 : iArr3) {
            int length = iArr2.length;
            int i13 = 0;
            while (i13 < length) {
                int i14 = iArr2[i13];
                int length2 = iArr.length;
                int i15 = 0;
                while (i15 < length2) {
                    int i16 = i15;
                    int i17 = length2;
                    int i18 = i13;
                    int i19 = length;
                    a aVar2 = new a(i11, f12, f13, f14, iArr[i15], f15, i14, f16, i12, f11);
                    if (aVar == null || aVar2.f28663h < aVar.f28663h) {
                        if (aVar2.f28663h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i11++;
                    i15 = i16 + 1;
                    length2 = i17;
                    i13 = i18;
                    length = i19;
                }
                i13++;
            }
        }
        return aVar;
    }

    private void d(float f11, float f12, float f13, float f14) {
        float f15 = f11 - f();
        int i11 = this.f28658c;
        if (i11 > 0 && f15 > 0.0f) {
            float f16 = this.f28657b;
            this.f28657b = f16 + Math.min(f15 / i11, f13 - f16);
        } else if (i11 > 0 && f15 < 0.0f) {
            float f17 = this.f28657b;
            this.f28657b = f17 + Math.max(f15 / i11, f12 - f17);
        }
        int i12 = this.f28658c;
        float f18 = i12 > 0 ? this.f28657b : 0.0f;
        this.f28657b = f18;
        float a11 = a(f11, i12, f18, this.f28659d, this.f28662g);
        this.f28661f = a11;
        float f19 = (this.f28657b + a11) / 2.0f;
        this.f28660e = f19;
        int i13 = this.f28659d;
        if (i13 <= 0 || a11 == f14) {
            return;
        }
        float f20 = (f14 - a11) * this.f28662g;
        float min = Math.min(Math.abs(f20), f19 * 0.1f * i13);
        if (f20 > 0.0f) {
            this.f28660e -= min / this.f28659d;
            this.f28661f += min / this.f28662g;
        } else {
            this.f28660e += min / this.f28659d;
            this.f28661f -= min / this.f28662g;
        }
    }

    private float f() {
        return (this.f28661f * this.f28662g) + (this.f28660e * this.f28659d) + (this.f28657b * this.f28658c);
    }

    private boolean g() {
        int i11 = this.f28662g;
        if (i11 <= 0 || this.f28658c <= 0 || this.f28659d <= 0) {
            return i11 <= 0 || this.f28658c <= 0 || this.f28661f > this.f28657b;
        }
        float f11 = this.f28661f;
        float f12 = this.f28660e;
        return f11 > f12 && f12 > this.f28657b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f28658c + this.f28659d + this.f28662g;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f28656a + ", smallCount=" + this.f28658c + ", smallSize=" + this.f28657b + ", mediumCount=" + this.f28659d + ", mediumSize=" + this.f28660e + ", largeCount=" + this.f28662g + ", largeSize=" + this.f28661f + ", cost=" + this.f28663h + "]";
    }
}
