package com.bytedance.sdk.openadsdk.component.reward.sP;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.dx;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;

/* loaded from: classes3.dex */
public class Jcg {
    @NonNull
    public static sP Sj(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2) {
        sU sUVar = sj2.sP;
        return ((sUVar instanceof dx) && ((dx) sUVar).Qne()) ? new vS(sj2) : uP.TzV(sUVar) ? new TEQ(sj2) : (!Dq.Sj(sUVar) || TKC.Sj(sUVar)) ? uA.Sj(sUVar) ? new uA(sj2) : TEQ.Sj(sUVar) ? new TEQ(sj2) : EjP.Sj(sUVar) ? new EjP(sj2) : TKC.Sj(sUVar) ? new TKC(sj2) : new HiB(sj2) : new Dq(sj2);
    }
}
