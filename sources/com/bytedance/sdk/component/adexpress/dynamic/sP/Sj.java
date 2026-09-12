package com.bytedance.sdk.component.adexpress.dynamic.sP;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg;

/* loaded from: classes2.dex */
public class Sj {
    public static int Sj(Jcg jcg) {
        if (jcg == null) {
            return 0;
        }
        String Wjd = jcg.Wjd();
        String kF = jcg.kF();
        if (TextUtils.isEmpty(kF) || TextUtils.isEmpty(Wjd) || !kF.equals("creative")) {
            return 0;
        }
        if (Wjd.equals("shake")) {
            return 2;
        }
        if (Wjd.equals("twist")) {
            return 3;
        }
        return Wjd.equals("slide") ? 1 : 0;
    }
}
