package com.bytedance.adsdk.ugeno.EjP.EjP;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.EjP.TEQ;
import com.bytedance.adsdk.ugeno.EjP.Ym;
import com.bytedance.adsdk.ugeno.EjP.vS;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class Sj {
    protected String Dq;
    protected vS.Sj EjP;
    protected Map<String, String> HiB;
    protected String Jcg;
    protected Ym Sj;
    protected Context TEQ;
    protected com.bytedance.adsdk.ugeno.EjP.vS TKC;
    protected com.bytedance.adsdk.ugeno.sP.TKC sP;
    protected String uA;
    protected String vS;

    /* renamed from: com.bytedance.adsdk.ugeno.EjP.EjP.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0205Sj {
        public static Sj Sj(Context context, com.bytedance.adsdk.ugeno.sP.TKC tkc, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.EjP.vS Sj;
            vS.Sj Sj2;
            if (tkc == null || jSONObject == null || (Sj = com.bytedance.adsdk.ugeno.EjP.vS.Sj(jSONObject, jSONObject2)) == null || (Sj2 = Sj.Sj()) == null) {
                return null;
            }
            String Sj3 = Sj2.Sj();
            if (TextUtils.equals(Sj3, "custom")) {
                sP sPVar = new sP(context);
                sPVar.Sj(tkc);
                sPVar.Sj(Sj);
                sPVar.Sj();
                return sPVar;
            }
            com.bytedance.adsdk.ugeno.EjP.Jcg Sj4 = (TextUtils.isEmpty(Sj3) || TextUtils.equals(Sj3, FrameworkConstants.GLOBAL_KEY_GLOBAL)) ? TEQ.Sj(Sj2.sP()) : TEQ.Sj(Sj2.HiB());
            if (Sj4 == null) {
                return null;
            }
            Sj Sj5 = Sj4.Sj(context);
            Sj5.Sj(tkc);
            Sj5.Sj(Sj);
            Sj5.Sj();
            return Sj5;
        }
    }

    public Sj(Context context) {
        this.TEQ = context;
    }

    public void Sj() {
        this.EjP = this.TKC.Sj();
        com.bytedance.adsdk.ugeno.EjP.vS vSVar = this.TKC;
        if (vSVar == null) {
            return;
        }
        vS.Sj Sj = vSVar.Sj();
        this.EjP = Sj;
        if (Sj == null) {
            return;
        }
        this.HiB = Sj.TKC();
        this.vS = this.EjP.sP();
        this.Jcg = this.EjP.Sj();
        this.Dq = this.EjP.EjP();
        this.uA = this.EjP.HiB();
    }

    public void Sj(Ym ym2) {
        this.Sj = ym2;
    }

    public void Sj(com.bytedance.adsdk.ugeno.EjP.vS vSVar) {
        this.TKC = vSVar;
    }

    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc) {
        this.sP = tkc;
    }

    public abstract boolean Sj(Object... objArr);

    public String TKC() {
        return this.uA;
    }

    public String sP() {
        return this.vS;
    }
}
