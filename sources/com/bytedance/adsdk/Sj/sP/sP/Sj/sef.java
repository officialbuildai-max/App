package com.bytedance.adsdk.Sj.sP.sP.Sj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class sef extends dNu {
    public sef() {
        super(com.bytedance.adsdk.Sj.sP.EjP.TKC.NOT_EQ);
    }

    @Override // com.bytedance.adsdk.Sj.sP.sP.Sj
    public Object Sj(Map<String, JSONObject> map) {
        Object Sj = this.Sj.Sj(map);
        Object Sj2 = this.sP.Sj(map);
        return (Sj == null && Sj2 == null) ? Boolean.FALSE : (Sj != null || Sj2 == null) ? (Sj == null || Sj2 != null) ? ((Sj instanceof Number) && (Sj2 instanceof Number)) ? Boolean.valueOf(!com.bytedance.adsdk.Sj.sP.HiB.Sj.sP.Sj((Number) Sj, (Number) Sj2)) : Boolean.valueOf(!Sj.equals(Sj2)) : Boolean.TRUE : Boolean.TRUE;
    }
}
