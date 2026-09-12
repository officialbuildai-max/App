package com.google.zxing;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final float f32971a;

    /* renamed from: b, reason: collision with root package name */
    private final float f32972b;

    public k(float f11, float f12) {
        this.f32971a = f11;
        this.f32972b = f12;
    }

    private static float a(k kVar, k kVar2, k kVar3) {
        float f11 = kVar2.f32971a;
        float f12 = kVar2.f32972b;
        return ((kVar3.f32971a - f11) * (kVar.f32972b - f12)) - ((kVar3.f32972b - f12) * (kVar.f32971a - f11));
    }

    public static float b(k kVar, k kVar2) {
        return jd.a.a(kVar.f32971a, kVar.f32972b, kVar2.f32971a, kVar2.f32972b);
    }

    public static void e(k[] kVarArr) {
        k kVar;
        k kVar2;
        k kVar3;
        float b11 = b(kVarArr[0], kVarArr[1]);
        float b12 = b(kVarArr[1], kVarArr[2]);
        float b13 = b(kVarArr[0], kVarArr[2]);
        if (b12 >= b11 && b12 >= b13) {
            kVar = kVarArr[0];
            kVar2 = kVarArr[1];
            kVar3 = kVarArr[2];
        } else if (b13 < b12 || b13 < b11) {
            kVar = kVarArr[2];
            kVar2 = kVarArr[0];
            kVar3 = kVarArr[1];
        } else {
            kVar = kVarArr[1];
            kVar2 = kVarArr[0];
            kVar3 = kVarArr[2];
        }
        if (a(kVar2, kVar, kVar3) < 0.0f) {
            k kVar4 = kVar3;
            kVar3 = kVar2;
            kVar2 = kVar4;
        }
        kVarArr[0] = kVar2;
        kVarArr[1] = kVar;
        kVarArr[2] = kVar3;
    }

    public final float c() {
        return this.f32971a;
    }

    public final float d() {
        return this.f32972b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f32971a == kVar.f32971a && this.f32972b == kVar.f32972b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f32971a) * 31) + Float.floatToIntBits(this.f32972b);
    }

    public final String toString() {
        return "(" + this.f32971a + ',' + this.f32972b + ')';
    }
}
