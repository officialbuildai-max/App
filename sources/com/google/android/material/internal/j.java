package com.google.android.material.internal;

/* loaded from: classes4.dex */
abstract class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f11, float[] fArr) {
        if (f11 <= 0.5f) {
            fArr[0] = 1.0f - (f11 * 2.0f);
            fArr[1] = 0.0f;
        } else {
            fArr[0] = 0.0f;
            fArr[1] = (f11 * 2.0f) - 1.0f;
        }
    }
}
