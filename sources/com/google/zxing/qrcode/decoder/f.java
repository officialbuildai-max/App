package com.google.zxing.qrcode.decoder;

import com.google.zxing.k;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f33047a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(boolean z10) {
        this.f33047a = z10;
    }

    public void a(k[] kVarArr) {
        if (!this.f33047a || kVarArr == null || kVarArr.length < 3) {
            return;
        }
        k kVar = kVarArr[0];
        kVarArr[0] = kVarArr[2];
        kVarArr[2] = kVar;
    }
}
