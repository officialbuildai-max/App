package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import xe.q;

/* loaded from: classes4.dex */
public class l extends PreviewScalingStrategy {
    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected float c(q qVar, q qVar2) {
        if (qVar.f78357a <= 0 || qVar.f78358b <= 0) {
            return 0.0f;
        }
        q f11 = qVar.f(qVar2);
        float f12 = (f11.f78357a * 1.0f) / qVar.f78357a;
        if (f12 > 1.0f) {
            f12 = (float) Math.pow(1.0f / f12, 1.1d);
        }
        float f13 = ((f11.f78357a * 1.0f) / qVar2.f78357a) + ((f11.f78358b * 1.0f) / qVar2.f78358b);
        return f12 * ((1.0f / f13) / f13);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(q qVar, q qVar2) {
        q f11 = qVar.f(qVar2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preview: ");
        sb2.append(qVar);
        sb2.append("; Scaled: ");
        sb2.append(f11);
        sb2.append("; Want: ");
        sb2.append(qVar2);
        int i11 = (f11.f78357a - qVar2.f78357a) / 2;
        int i12 = (f11.f78358b - qVar2.f78358b) / 2;
        return new Rect(-i11, -i12, f11.f78357a - i11, f11.f78358b - i12);
    }
}
