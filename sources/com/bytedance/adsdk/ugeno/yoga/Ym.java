package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes2.dex */
public class Ym {
    public static long Sj(float f11, float f12) {
        return Float.floatToRawIntBits(f12) | (Float.floatToRawIntBits(f11) << 32);
    }

    public static long Sj(int i11, int i12) {
        return Sj(i11, i12);
    }
}
