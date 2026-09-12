package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;

/* loaded from: classes3.dex */
public class Sj {
    public static void Sj(com.bytedance.sdk.openadsdk.core.model.Sj sj2, int i11, boolean z10) {
        if (sj2 == null || sj2.EjP() == null || sj2.EjP().size() <= 0) {
            return;
        }
        if (i11 >= sj2.EjP().size()) {
            i11 = 0;
        }
        sU sUVar = sj2.EjP().get(i11);
        Context Sj = dNu.Sj();
        Sj(sUVar, !TextUtils.isEmpty(z10 ? aa.Sj(Sj).Sj(sUVar) : EjP.Sj(Sj).Sj(sUVar)), z10);
    }

    public static void Sj(final sU sUVar, final boolean z10, final boolean z11) {
        com.bytedance.sdk.openadsdk.core.sef.sP().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.1
            @Override // java.lang.Runnable
            public void run() {
                sU sUVar2 = sU.this;
                if (sUVar2 != null && !sUVar2.ODI()) {
                    try {
                        Context Sj = dNu.Sj();
                        AdSlot xD = sU.this.xD();
                        if (xD == null) {
                            return;
                        }
                        int sP = HiB.sP();
                        if (sP == 0 || sP == 2) {
                            if (z11) {
                                Fmk.Sj(Sj).Sj(xD.getCodeId(), sU.this);
                            } else {
                                HiB.Sj(Sj).Sj(xD.getCodeId(), sU.this);
                            }
                        }
                        if (!z10) {
                            return;
                        }
                        if (z11) {
                            Fmk.Sj(Sj).Sj(xD);
                            return;
                        }
                        HiB.Sj(Sj).Sj(xD);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
