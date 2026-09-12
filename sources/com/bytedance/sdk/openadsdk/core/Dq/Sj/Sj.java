package com.bytedance.sdk.openadsdk.core.Dq.Sj;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.FPG;

/* loaded from: classes3.dex */
public class Sj {
    public static float Sj(Context context) {
        return FPG.TKC(context, FPG.Ym(context));
    }

    @NonNull
    public static Pair<Float, Float> Sj(Window window, int i11) {
        View decorView = window.getDecorView();
        float[] fArr = {decorView.getWidth() - (decorView.getPaddingLeft() * 2), decorView.getHeight() - (decorView.getPaddingTop() * 2)};
        fArr[0] = FPG.TKC(window.getContext(), fArr[0]);
        float TKC = FPG.TKC(window.getContext(), fArr[1]);
        fArr[1] = TKC;
        if (fArr[0] < 10.0f || TKC < 10.0f) {
            fArr = Sj(window.getContext(), FPG.TKC(window.getContext(), FPG.Sj()), i11);
        }
        float max = Math.max(fArr[0], fArr[1]);
        float min = Math.min(fArr[0], fArr[1]);
        if (i11 == 1) {
            fArr[0] = min;
            fArr[1] = max;
        } else {
            fArr[0] = max;
            fArr[1] = min;
        }
        return new Pair<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
    }

    private static float[] Sj(Context context, int i11, int i12) {
        float Sj = Sj(context);
        float sP = sP(context);
        if ((i12 == 1) != (Sj > sP)) {
            float f11 = Sj + sP;
            sP = f11 - sP;
            Sj = f11 - sP;
        }
        if (i12 == 1) {
            Sj -= i11;
        } else {
            sP -= i11;
        }
        return new float[]{sP, Sj};
    }

    public static float sP(Context context) {
        return FPG.TKC(context, FPG.aa(context));
    }
}
