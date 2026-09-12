package com.google.android.material.bottomappbar;

import ab.g;
import ab.p;

/* loaded from: classes4.dex */
public class d extends g implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private float f28439a;

    /* renamed from: b, reason: collision with root package name */
    private float f28440b;

    /* renamed from: c, reason: collision with root package name */
    private float f28441c;

    /* renamed from: d, reason: collision with root package name */
    private float f28442d;

    /* renamed from: e, reason: collision with root package name */
    private float f28443e;

    /* renamed from: f, reason: collision with root package name */
    private float f28444f = -1.0f;

    public d(float f11, float f12, float f13) {
        this.f28440b = f11;
        this.f28439a = f12;
        k(f13);
        this.f28443e = 0.0f;
    }

    @Override // ab.g
    public void b(float f11, float f12, float f13, p pVar) {
        float f14;
        float f15;
        float f16 = this.f28441c;
        if (f16 == 0.0f) {
            pVar.m(f11, 0.0f);
            return;
        }
        float f17 = ((this.f28440b * 2.0f) + f16) / 2.0f;
        float f18 = f13 * this.f28439a;
        float f19 = f12 + this.f28443e;
        float f20 = (this.f28442d * f13) + ((1.0f - f13) * f17);
        if (f20 / f17 >= 1.0f) {
            pVar.m(f11, 0.0f);
            return;
        }
        float f21 = this.f28444f;
        float f22 = f21 * f13;
        boolean z10 = f21 == -1.0f || Math.abs((f21 * 2.0f) - f16) < 0.1f;
        if (z10) {
            f14 = f20;
            f15 = 0.0f;
        } else {
            f15 = 1.75f;
            f14 = 0.0f;
        }
        float f23 = f17 + f18;
        float f24 = f14 + f18;
        float sqrt = (float) Math.sqrt((f23 * f23) - (f24 * f24));
        float f25 = f19 - sqrt;
        float f26 = f19 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f24));
        float f27 = (90.0f - degrees) + f15;
        pVar.m(f25, 0.0f);
        float f28 = f18 * 2.0f;
        pVar.a(f25 - f18, 0.0f, f25 + f18, f28, 270.0f, degrees);
        if (z10) {
            pVar.a(f19 - f17, (-f17) - f14, f19 + f17, f17 - f14, 180.0f - f27, (f27 * 2.0f) - 180.0f);
        } else {
            float f29 = this.f28440b;
            float f30 = f22 * 2.0f;
            float f31 = f19 - f17;
            pVar.a(f31, -(f22 + f29), f31 + f29 + f30, f29 + f22, 180.0f - f27, ((f27 * 2.0f) - 180.0f) / 2.0f);
            float f32 = f19 + f17;
            float f33 = this.f28440b;
            pVar.m(f32 - ((f33 / 2.0f) + f22), f33 + f22);
            float f34 = this.f28440b;
            pVar.a(f32 - (f30 + f34), -(f22 + f34), f32, f34 + f22, 90.0f, f27 - 90.0f);
        }
        pVar.a(f26 - f18, 0.0f, f26 + f18, f28, 270.0f - degrees, degrees);
        pVar.m(f11, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f28442d;
    }

    public float e() {
        return this.f28444f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f28440b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f28439a;
    }

    public float i() {
        return this.f28441c;
    }

    public float j() {
        return this.f28443e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f28442d = f11;
    }

    public void l(float f11) {
        this.f28444f = f11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f11) {
        this.f28440b = f11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f11) {
        this.f28439a = f11;
    }

    public void o(float f11) {
        this.f28441c = f11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(float f11) {
        this.f28443e = f11;
    }
}
