package com.bytedance.adsdk.Sj;

import com.bytedance.adsdk.ugeno.TKC.Sj;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class sP implements com.bytedance.adsdk.ugeno.TKC.Sj {

    /* loaded from: classes2.dex */
    static class Sj implements Sj.InterfaceC0210Sj {
        private com.bytedance.adsdk.Sj.sP.Sj Sj;
        private String sP;

        private Sj(String str) {
            this.sP = str;
            this.Sj = com.bytedance.adsdk.Sj.sP.Sj.Sj(str);
        }

        public static Sj Sj(String str) {
            return new Sj(str);
        }

        @Override // com.bytedance.adsdk.ugeno.TKC.Sj.InterfaceC0210Sj
        public Object Sj(JSONObject jSONObject) {
            com.bytedance.adsdk.Sj.sP.Sj sj2 = this.Sj;
            if (sj2 == null) {
                return this.sP;
            }
            Object Sj = sj2.Sj(jSONObject);
            return Sj instanceof String ? Sj : Sj instanceof com.bytedance.adsdk.Sj.sP.Sj.Sj ? String.valueOf(Dq.Sj((com.bytedance.adsdk.Sj.sP.Sj.Sj) Sj)) : String.valueOf(Sj);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.TKC.Sj
    public Sj.InterfaceC0210Sj Sj(String str) {
        return Sj.Sj(str);
    }
}
