package com.bytedance.sdk.openadsdk.kF.sP;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.utils.Mts;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class HiB {
    private static final Map<Integer, sP> Sj = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public static class Sj {
        public int Sj;
        public int sP = -1;

        public Sj(int i11) {
            this.Sj = i11;
        }
    }

    private static sP Sj(View view, sU sUVar, boolean z10, Sj sj2) {
        if (view == null || sUVar == null || sUVar.aZ() == null) {
            return null;
        }
        Integer sP = sP(sUVar);
        Map<Integer, sP> map = Sj;
        if (!map.containsKey(sP)) {
            sP Sj2 = sP.Sj(z10, sP, view, sUVar, sj2);
            map.put(sP, Sj2);
            return Sj2;
        }
        sP sPVar = map.get(sP);
        if (sPVar != null) {
            sPVar.Sj(view);
        }
        return sPVar;
    }

    public static sP Sj(Integer num) {
        return Sj.get(num);
    }

    public static void Sj(View view, sU sUVar, Sj sj2) {
        if (view == null || sUVar == null || sUVar.tPD()) {
            return;
        }
        boolean TKC = TKC(sUVar);
        if (uP.sP(sUVar) && sj2 != null) {
            sj2.Sj = -1;
        }
        Sj(Sj(view, sUVar, TKC, sj2));
    }

    public static void Sj(sU sUVar) {
        if (sUVar == null || sUVar.aZ() == null) {
            return;
        }
        Integer sP = sP(sUVar);
        Map<Integer, sP> map = Sj;
        sP sPVar = map.get(sP);
        if (sPVar != null) {
            sPVar.TEQ();
        }
        sP(sP);
        if (map.size() <= 0) {
            Jcg.Sj();
        }
    }

    public static void Sj(sU sUVar, int i11) {
        if (sUVar == null || sUVar.aZ() == null) {
            return;
        }
        Sj(Sj.get(sP(sUVar)), i11);
    }

    private static void Sj(sP sPVar) {
        if (sPVar == null) {
            return;
        }
        sPVar.Sj();
    }

    public static void Sj(sP sPVar, int i11) {
        if (sPVar == null) {
            return;
        }
        sPVar.Sj(i11);
    }

    private static boolean TKC(sU sUVar) {
        if (sUVar == null) {
            return false;
        }
        String Sj2 = Mts.Sj(sUVar);
        return ((!"open_ad".equals(Sj2) && !"fullscreen_interstitial_ad".equals(Sj2) && !"rewarded_video".equals(Sj2)) || uP.sP(sUVar) || sUVar.dx() == 5 || sUVar.dx() == 33 || !sU.HiB(sUVar) || sUVar.UHs() == null) ? false : true;
    }

    public static Integer sP(sU sUVar) {
        return Integer.valueOf((sUVar.cKW() + sUVar.aZ()).hashCode());
    }

    public static void sP(Integer num) {
        Sj.remove(num);
    }
}
