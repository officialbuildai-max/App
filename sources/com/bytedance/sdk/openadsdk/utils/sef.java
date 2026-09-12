package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.TEQ;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class sef implements com.bytedance.sdk.openadsdk.oem.Sj {
    private static final sef Sj = new sef();
    private static boolean TKC;
    private static com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sP;

    public static void Sj() {
        if (sP == null) {
            return;
        }
        sP = null;
        IPMiBroadcastReceiver Sj2 = IPMiBroadcastReceiver.Sj(com.bytedance.sdk.openadsdk.core.dNu.Sj());
        if (Sj2 != null) {
            Sj2.Sj();
        }
        TKC = false;
    }

    public static void Sj(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2) {
        com.bytedance.sdk.openadsdk.core.model.kF eNi = sj2.sP.eNi();
        if (eNi == null || !eNi.Jcg()) {
            return;
        }
        sP = sj2;
        IPMiBroadcastReceiver Sj2 = IPMiBroadcastReceiver.Sj(sj2.Ei);
        if (Sj2 != null) {
            Sj2.Sj(Sj);
        }
    }

    public static void sP() {
        TKC = true;
    }

    @Override // com.bytedance.sdk.openadsdk.oem.Sj
    public void Sj(String str, final int i11) {
        com.bytedance.sdk.openadsdk.core.model.EjP tz2;
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = sP;
        if (sj2 == null || (tz2 = sj2.sP.tz()) == null) {
            return;
        }
        String TKC2 = tz2.TKC();
        if (TextUtils.isEmpty(TKC2) || !TKC2.equals(str)) {
            return;
        }
        JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.sef.1
            @Override // java.lang.Runnable
            public void run() {
                int i12;
                if (sef.sP == null || (i12 = i11) <= 0 || i12 > 5) {
                    return;
                }
                boolean z10 = true;
                boolean z11 = i12 == 1;
                if (sef.TKC) {
                    sef.sP.f21075jb.EjP();
                    HashMap hashMap = new HashMap();
                    hashMap.put("click_scence", 4);
                    com.bytedance.sdk.openadsdk.EjP.TKC.Sj("click", sef.sP.sP, new TEQ.Sj().Sj(), sef.sP.HiB, true, (Map<String, Object>) hashMap, 1);
                } else {
                    z10 = z11;
                }
                if (z10) {
                    sef.Sj();
                }
            }
        });
    }
}
