package com.google.zxing.qrcode.detector;

import com.google.zxing.k;

/* loaded from: classes4.dex */
public final class a extends k {

    /* renamed from: c, reason: collision with root package name */
    private final float f33064c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(float f11, float f12, float f13) {
        super(f11, f12);
        this.f33064c = f13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f11, float f12, float f13) {
        if (Math.abs(f12 - d()) > f11 || Math.abs(f13 - c()) > f11) {
            return false;
        }
        float abs = Math.abs(f11 - this.f33064c);
        return abs <= 1.0f || abs <= this.f33064c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a g(float f11, float f12, float f13) {
        return new a((c() + f12) / 2.0f, (d() + f11) / 2.0f, (this.f33064c + f13) / 2.0f);
    }
}
