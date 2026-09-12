package com.bytedance.adsdk.ugeno.EjP.sP;

import com.bytedance.adsdk.ugeno.EjP.vS;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class sP extends Sj {
    private List<com.bytedance.adsdk.ugeno.EjP.Sj.EjP> Dq;

    public sP(com.bytedance.adsdk.ugeno.sP.TKC tkc, String str, vS.Sj sj2) {
        super(tkc, str, sj2);
        this.Dq = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.EjP.sP.Sj
    public void Sj() {
        com.bytedance.adsdk.ugeno.EjP.Sj.TKC Sj;
        Map<String, String> map = this.vS;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.vS.get("name");
        com.bytedance.adsdk.ugeno.EjP.Sj.Sj Fm = this.TKC.Fm();
        if (Fm == null || (Sj = Fm.Sj(str)) == null) {
            return;
        }
        Sj.Sj(str);
    }
}
