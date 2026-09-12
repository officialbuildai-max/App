package com.bytedance.adsdk.Sj.sP.sP.Sj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class uA extends dNu {
    public uA() {
        super(com.bytedance.adsdk.Sj.sP.EjP.TKC.LT);
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public Object Sj(Map<String, JSONObject> map) {
        Object Sj;
        Object Sj2 = this.Sj.Sj(map);
        if (Sj2 == null || (Sj = this.sP.Sj(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.Sj.sP.HiB.Sj.EjP.Sj(Sj2, (Number) Sj);
    }
}
