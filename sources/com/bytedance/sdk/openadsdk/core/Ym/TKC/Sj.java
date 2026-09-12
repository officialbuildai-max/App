package com.bytedance.sdk.openadsdk.core.Ym.TKC;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.utils.FPG;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class Sj {
    public static final Set<String> Sj = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.1
        {
            add("image/jpeg");
            add("image/png");
            add("image/bmp");
            add("image/gif");
            add("image/jpg");
        }
    };
    public static Set<String> sP = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.2
        {
            add("application/x-javascript");
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0275Sj {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* loaded from: classes3.dex */
    public enum sP {
        HTML_RESOURCE,
        STATIC_RESOURCE,
        IFRAME_RESOURCE
    }

    @NonNull
    public static Point Sj(Context context, int i11, int i12, sP sPVar) {
        if (context == null) {
            context = dNu.Sj();
        }
        Point point = new Point(i11, i12);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int sP2 = FPG.sP(context, i11);
        int sP3 = FPG.sP(context, i12);
        if (sP2 <= width && sP3 <= height) {
            return point;
        }
        Point point2 = new Point();
        if (sP.HTML_RESOURCE == sPVar) {
            point2.x = Math.min(width, sP2);
            point2.y = Math.min(height, sP3);
        } else {
            float f11 = sP2;
            float f12 = f11 / width;
            float f13 = sP3;
            float f14 = f13 / height;
            if (f12 >= f14) {
                point2.x = width;
                point2.y = (int) (f13 / f12);
            } else {
                point2.x = (int) (f11 / f14);
                point2.y = height;
            }
        }
        int i13 = point2.x;
        if (i13 < 0 || point2.y < 0) {
            return point;
        }
        point2.x = FPG.TKC(context, i13);
        point2.y = FPG.TKC(context, point2.y);
        return point2;
    }
}
