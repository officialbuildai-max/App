package com.bytedance.adsdk.Sj.sP.sP.Sj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Dq extends dNu {
    public Dq() {
        super(com.bytedance.adsdk.Sj.sP.EjP.TKC.LT_EQ);
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public Object Sj(Map<String, JSONObject> map) {
        Object Sj;
        if (this.Sj.Sj(map) == null || (Sj = this.sP.Sj(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.Sj.sP.HiB.Sj.TKC.Sj(r0, (Number) Sj)).booleanValue());
    }
}
