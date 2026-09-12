package com.bytedance.adsdk.Sj;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class Dq {
    public static vS Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 3143097:
                if (str.equals("find")) {
                    c11 = 0;
                    break;
                }
                break;
            case 94642797:
                if (str.equals("chunk")) {
                    c11 = 1;
                    break;
                }
                break;
            case 96955127:
                if (str.equals("exist")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    c11 = 3;
                    break;
                }
                break;
            case 2056988195:
                if (str.equals("isDigit")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new EjP();
            case 1:
                return new Sj();
            case 2:
                return new TKC();
            case 3:
                return new Jcg();
            case 4:
                return new HiB();
            default:
                return null;
        }
    }

    public static Object Sj(com.bytedance.adsdk.Sj.sP.Sj.Sj sj2) {
        vS Sj;
        if (sj2 == null || (Sj = Sj(sj2.Sj())) == null) {
            return null;
        }
        return Sj.Sj(null, sj2.sP());
    }
}
