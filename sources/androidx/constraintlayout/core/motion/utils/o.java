package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    float f6915a;

    /* renamed from: b, reason: collision with root package name */
    float f6916b;

    /* renamed from: c, reason: collision with root package name */
    float f6917c;

    /* renamed from: d, reason: collision with root package name */
    float f6918d;

    /* renamed from: e, reason: collision with root package name */
    float f6919e;

    /* renamed from: f, reason: collision with root package name */
    float f6920f;

    public void a(float f11, float f12, int i11, int i12, float[] fArr) {
        float f13 = fArr[0];
        float f14 = fArr[1];
        float f15 = (f12 - 0.5f) * 2.0f;
        float f16 = f13 + this.f6917c;
        float f17 = f14 + this.f6918d;
        float f18 = f16 + (this.f6915a * (f11 - 0.5f) * 2.0f);
        float f19 = f17 + (this.f6916b * f15);
        float radians = (float) Math.toRadians(this.f6920f);
        float radians2 = (float) Math.toRadians(this.f6919e);
        double d11 = radians;
        double d12 = i12 * f15;
        float sin = f18 + (((float) ((((-i11) * r7) * Math.sin(d11)) - (Math.cos(d11) * d12))) * radians2);
        float cos = f19 + (radians2 * ((float) (((i11 * r7) * Math.cos(d11)) - (d12 * Math.sin(d11)))));
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public void b() {
        this.f6919e = 0.0f;
        this.f6918d = 0.0f;
        this.f6917c = 0.0f;
        this.f6916b = 0.0f;
        this.f6915a = 0.0f;
    }

    public void c(KeyCycleOscillator keyCycleOscillator, float f11) {
        if (keyCycleOscillator != null) {
            this.f6919e = keyCycleOscillator.b(f11);
        }
    }

    public void d(i iVar, float f11) {
        if (iVar != null) {
            this.f6919e = iVar.b(f11);
            this.f6920f = iVar.a(f11);
        }
    }

    public void e(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f11) {
        if (keyCycleOscillator != null) {
            this.f6915a = keyCycleOscillator.b(f11);
        }
        if (keyCycleOscillator2 != null) {
            this.f6916b = keyCycleOscillator2.b(f11);
        }
    }

    public void f(i iVar, i iVar2, float f11) {
        if (iVar != null) {
            this.f6915a = iVar.b(f11);
        }
        if (iVar2 != null) {
            this.f6916b = iVar2.b(f11);
        }
    }

    public void g(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f11) {
        if (keyCycleOscillator != null) {
            this.f6917c = keyCycleOscillator.b(f11);
        }
        if (keyCycleOscillator2 != null) {
            this.f6918d = keyCycleOscillator2.b(f11);
        }
    }

    public void h(i iVar, i iVar2, float f11) {
        if (iVar != null) {
            this.f6917c = iVar.b(f11);
        }
        if (iVar2 != null) {
            this.f6918d = iVar2.b(f11);
        }
    }
}
