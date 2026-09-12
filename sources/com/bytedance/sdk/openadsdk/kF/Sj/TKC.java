package com.bytedance.sdk.openadsdk.kF.Sj;

import com.bytedance.sdk.openadsdk.core.model.sU;

/* loaded from: classes3.dex */
public class TKC {
    public static boolean Sj = false;
    public static String TKC = "engaged_view";
    public static int sP = 6;

    public static void Sj(sU sUVar) {
        sP TKC2 = TKC(sUVar);
        if (TKC2 == null) {
            return;
        }
        TKC2.Sj();
    }

    public static void Sj(sU sUVar, int i11) {
        sP TKC2 = TKC(sUVar);
        if (TKC2 == null || TKC2.TKC()) {
            return;
        }
        TKC2.Sj(i11);
    }

    public static void Sj(sU sUVar, boolean z10) {
        sP TKC2 = TKC(sUVar);
        if (TKC2 == null || TKC2.TKC()) {
            return;
        }
        TKC2.Sj(z10);
        TKC2.Sj(z10 ? 4 : 8);
    }

    private static sP TKC(sU sUVar) {
        if (sUVar == null || !sUVar.VnJ()) {
            return null;
        }
        return sUVar.YLl();
    }

    public static void sP(sU sUVar) {
        sP TKC2 = TKC(sUVar);
        if (TKC2 == null) {
            return;
        }
        TKC2.sP();
    }
}
