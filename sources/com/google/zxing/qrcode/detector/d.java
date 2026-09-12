package com.google.zxing.qrcode.detector;

import com.google.zxing.k;

/* loaded from: classes4.dex */
public final class d extends k {

    /* renamed from: c, reason: collision with root package name */
    private final float f33076c;

    /* renamed from: d, reason: collision with root package name */
    private final int f33077d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(float f11, float f12, float f13) {
        this(f11, f12, f13, 1);
    }

    private d(float f11, float f12, float f13, int i11) {
        super(f11, f12);
        this.f33076c = f13;
        this.f33077d = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f11, float f12, float f13) {
        if (Math.abs(f12 - d()) > f11 || Math.abs(f13 - c()) > f11) {
            return false;
        }
        float abs = Math.abs(f11 - this.f33076c);
        return abs <= 1.0f || abs <= this.f33076c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d g(float f11, float f12, float f13) {
        int i11 = this.f33077d;
        int i12 = i11 + 1;
        float c11 = (i11 * c()) + f12;
        float f14 = i12;
        return new d(c11 / f14, ((this.f33077d * d()) + f11) / f14, ((this.f33077d * this.f33076c) + f13) / f14, i12);
    }

    public int h() {
        return this.f33077d;
    }

    public float i() {
        return this.f33076c;
    }
}
