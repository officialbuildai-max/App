package com.bytedance.adsdk.ugeno.vS;

import java.util.Collection;

/* loaded from: classes2.dex */
public class EjP {
    public static int Sj(boolean z10, int i11, int i12) {
        if (i12 == 0 || !z10) {
            return i11;
        }
        int i13 = i11 - 512;
        int abs = Math.abs(i13) % i12;
        return (i13 >= 0 || abs == 0) ? abs : i12 - abs;
    }

    public static boolean Sj(int i11, Collection<?> collection) {
        return i11 >= 0 && i11 < collection.size();
    }
}
