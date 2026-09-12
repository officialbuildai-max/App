package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import xe.q;

/* loaded from: classes4.dex */
public class o extends PreviewScalingStrategy {
    private static float e(float f11) {
        return f11 < 1.0f ? 1.0f / f11 : f11;
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected float c(q qVar, q qVar2) {
        int i11 = qVar.f78357a;
        if (i11 <= 0 || qVar.f78358b <= 0) {
            return 0.0f;
        }
        float e11 = (1.0f / e((i11 * 1.0f) / qVar2.f78357a)) / e((qVar.f78358b * 1.0f) / qVar2.f78358b);
        float e12 = e(((qVar.f78357a * 1.0f) / qVar.f78358b) / ((qVar2.f78357a * 1.0f) / qVar2.f78358b));
        return e11 * (((1.0f / e12) / e12) / e12);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(q qVar, q qVar2) {
        return new Rect(0, 0, qVar2.f78357a, qVar2.f78358b);
    }
}
