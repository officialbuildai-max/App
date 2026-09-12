package com.bytedance.adsdk.ugeno.EjP.TKC;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bytedance.adsdk.ugeno.EjP.vS;

/* loaded from: classes2.dex */
public class sP extends com.bytedance.adsdk.ugeno.EjP.sP.Sj {
    public sP(com.bytedance.adsdk.ugeno.sP.TKC tkc, String str, vS.Sj sj2) {
        super(tkc, str, sj2);
    }

    @Override // com.bytedance.adsdk.ugeno.EjP.sP.Sj
    public void Sj() {
        if (this.TKC == null) {
            return;
        }
        int Sj = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(this.vS.get(RequestParameters.POSITION), 0);
        com.bytedance.adsdk.ugeno.sP.TKC tkc = this.TKC;
        com.bytedance.adsdk.ugeno.sP.TKC sP = tkc.sP(tkc);
        if (sP == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.sP.TKC EjP = sP.EjP("SwiperView");
        if (EjP instanceof com.bytedance.adsdk.ugeno.sP) {
            ((com.bytedance.adsdk.ugeno.sP) EjP).Sj(Sj);
        }
    }
}
