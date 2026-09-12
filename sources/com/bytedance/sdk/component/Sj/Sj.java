package com.bytedance.sdk.component.Sj;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.Sj.Jcg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class Sj {
    protected String HiB;
    Jcg Jcg;
    protected Context Sj;
    protected Dq TKC;
    protected Fmk sP;
    protected Handler EjP = new Handler(Looper.getMainLooper());
    protected volatile boolean vS = false;
    private final Map<String, Jcg> Dq = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public uvD Sj(JSONObject jSONObject) {
        String optString;
        Object opt;
        if (this.vS) {
            return null;
        }
        String optString2 = jSONObject.optString("__callback_id");
        String optString3 = jSONObject.optString("func");
        if (Sj() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String str = "";
            try {
                opt = jSONObject.opt("params");
            } catch (Throwable unused) {
                optString = jSONObject.optString("params");
            }
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    optString = String.valueOf((JSONObject) opt);
                    String string2 = jSONObject.getString("JSSDK");
                    return uvD.Sj().Sj(string2).sP(string).TKC(optString3).EjP(optString).HiB(optString2).vS(jSONObject.optString("namespace")).Jcg(jSONObject.optString("__iframe_url")).Sj();
                }
                str = opt instanceof String ? (String) opt : String.valueOf(opt);
            }
            optString = str;
            String string22 = jSONObject.getString("JSSDK");
            return uvD.Sj().Sj(string22).sP(string).TKC(optString3).EjP(optString).HiB(optString2).vS(jSONObject.optString("namespace")).Jcg(jSONObject.optString("__iframe_url")).Sj();
        } catch (JSONException unused2) {
            return uvD.Sj(optString2, -1);
        }
    }

    private Jcg sP(String str) {
        return (TextUtils.equals(str, this.HiB) || TextUtils.isEmpty(str)) ? this.Jcg : this.Dq.get(str);
    }

    protected abstract Context Sj(TEQ teq);

    protected abstract String Sj();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Sj(TEQ teq, dx dxVar) {
        this.Sj = Sj(teq);
        this.TKC = teq.EjP;
        this.sP = teq.uA;
        this.Jcg = new Jcg(teq, this, dxVar);
        this.HiB = teq.Ym;
        sP(teq);
    }

    protected final void Sj(uvD uvd) {
        String Sj;
        if (this.vS || (Sj = Sj()) == null) {
            return;
        }
        Jcg sP = sP(uvd.Jcg);
        if (sP == null) {
            uvd.toString();
            if (this.sP != null) {
                Sj();
            }
            sP(kF.Sj(new TzV(-4, "Namespace " + uvd.Jcg + " unknown.")), uvd);
            return;
        }
        vS vSVar = new vS();
        vSVar.sP = Sj;
        vSVar.Sj = this.Sj;
        vSVar.TKC = sP;
        try {
            Jcg.Sj Sj2 = sP.Sj(uvd, vSVar);
            if (Sj2 != null) {
                if (Sj2.Sj) {
                    sP(Sj2.sP, uvd);
                }
                if (this.sP != null) {
                    Sj();
                    return;
                }
                return;
            }
            uvd.toString();
            if (this.sP != null) {
                Sj();
            }
            sP(kF.Sj(new TzV(-2, "Function " + uvd.EjP + " is not registered.")), uvd);
        } catch (Exception e11) {
            uvd.toString();
            sP(kF.Sj(e11), uvd);
        }
    }

    protected abstract void Sj(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sj(String str, uvD uvd) {
        Sj(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeMethod(final String str) {
        if (this.vS) {
            return;
        }
        this.EjP.post(new Runnable() { // from class: com.bytedance.sdk.component.Sj.Sj.1
            @Override // java.lang.Runnable
            public void run() {
                uvD uvd;
                if (Sj.this.vS) {
                    return;
                }
                try {
                    uvd = Sj.this.Sj(new JSONObject(str));
                } catch (Exception unused) {
                    uvd = null;
                }
                if (!uvD.Sj(uvd)) {
                    Sj.this.Sj(uvd);
                    return;
                }
                Objects.toString(uvd);
                if (uvd != null) {
                    Sj.this.sP(kF.Sj(new TzV(uvd.Sj, "Failed to parse invocation.")), uvd);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sP() {
        this.Jcg.Sj();
        Iterator<Jcg> it = this.Dq.values().iterator();
        while (it.hasNext()) {
            it.next().Sj();
        }
        this.EjP.removeCallbacksAndMessages(null);
        this.vS = true;
    }

    protected abstract void sP(TEQ teq);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void sP(String str, uvD uvd) {
        JSONObject jSONObject;
        if (this.vS || TextUtils.isEmpty(uvd.vS)) {
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            uA.Sj(new IllegalArgumentException("Illegal callback data: ".concat(str)));
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        Sj(Zq.Sj().Sj("__msg_type", "callback").Sj("__callback_id", uvd.vS).Sj("__params", jSONObject).sP(), uvd);
    }
}
