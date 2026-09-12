package com.bytedance.sdk.openadsdk.EjP;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.utils.JcM;
import com.bytedance.sdk.openadsdk.utils.ib;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Sj implements com.bytedance.sdk.component.vS.Sj.EjP.Sj.sP {
    private static final Set<String> TEQ = new HashSet(Arrays.asList("insight_log"));
    private static final Map<String, String> Ym = new HashMap<String, String>() { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.1
        {
            put("id", "extra_id");
            put(EventConstants.KEY_SOURCE, "extra_source");
            put("url", "extra_url");
            put("toolType", "extra_tool_type");
            put("storeOpenType", "store_open_type");
            put("errorCode", "error_code");
            put("md5", "extra_md5");
            put("areaType", "area_type");
            put("rectInfo", "rect_info");
        }
    };
    private int Dq;
    private long EjP;
    private JSONObject Fmk;
    private long HiB;
    private int Jcg;
    private String RiZ;
    public final String Sj;
    private boolean TKC;
    private String TzV;
    private String Zq;

    /* renamed from: aa, reason: collision with root package name */
    private final AtomicBoolean f21017aa;
    private String dNu;

    /* renamed from: dx, reason: collision with root package name */
    private String f21018dx;

    /* renamed from: ib, reason: collision with root package name */
    private int f21019ib;
    private String kF;
    protected final JSONObject sP;
    private com.bytedance.sdk.openadsdk.EjP.sP.Sj sU;
    private String sef;
    private int uA;
    private String uvD;
    private final String vS;
    private String zR;

    /* renamed from: com.bytedance.sdk.openadsdk.EjP.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0242Sj {
        private String Dq;
        private String EjP;
        private String Fmk;
        private String HiB;
        private String Jcg;
        private boolean RiZ;
        public int Sj;
        private JSONObject TEQ;
        private String TKC;
        private int TzV;
        private String Ym;
        private com.bytedance.sdk.openadsdk.EjP.sP.Sj Zq;

        /* renamed from: aa, reason: collision with root package name */
        private final int f21020aa;
        private int dNu;
        private String sP;
        private String sU;
        private com.bytedance.sdk.openadsdk.EjP.sP.sP sef;
        private String uA;
        private final long uvD;
        private String vS;

        public C0242Sj(long j11, sU sUVar) {
            this.dNu = -1;
            this.TzV = -1;
            this.Sj = -1;
            if (sUVar != null) {
                this.RiZ = uP.sP(sUVar);
                this.dNu = sUVar.zR();
                this.TzV = sUVar.dx();
                this.Sj = sUVar.HcZ();
            }
            this.uvD = j11;
            this.f21020aa = TzV.TKC(com.bytedance.sdk.openadsdk.core.dNu.Sj());
        }

        public C0242Sj Dq(String str) {
            this.sU = str;
            return this;
        }

        public C0242Sj EjP(String str) {
            this.HiB = str;
            return this;
        }

        public C0242Sj HiB(String str) {
            this.Dq = str;
            return this;
        }

        public C0242Sj Jcg(String str) {
            this.Jcg = str;
            return this;
        }

        public C0242Sj Sj(String str) {
            this.Fmk = str;
            return this;
        }

        public C0242Sj Sj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.TEQ = jSONObject;
            return this;
        }

        public void Sj(com.bytedance.sdk.openadsdk.EjP.sP.Sj sj2) {
            com.bytedance.sdk.openadsdk.vS.sP.Sj().Sj(this.EjP, this.sU, this.Jcg, this.TKC);
            this.Zq = sj2;
            final Sj sj3 = new Sj(this);
            try {
                com.bytedance.sdk.openadsdk.EjP.sP.sP sPVar = this.sef;
                if (sPVar != null) {
                    sPVar.Sj(sj3.sP, this.uvD);
                } else {
                    new com.bytedance.sdk.openadsdk.EjP.sP.TKC().Sj(sj3.sP, this.uvD);
                }
            } catch (Throwable unused) {
            }
            if (com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
                JcM.TKC(new com.bytedance.sdk.component.Dq.Dq("dispatchEvent") { // from class: com.bytedance.sdk.openadsdk.EjP.Sj.Sj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.EjP.Sj.EjP.Sj(sj3);
                    }
                });
            } else {
                com.bytedance.sdk.openadsdk.EjP.Sj.EjP.Sj(sj3);
            }
        }

        public C0242Sj TKC(String str) {
            this.EjP = str;
            return this;
        }

        public C0242Sj sP(String str) {
            this.TKC = str;
            return this;
        }

        public C0242Sj vS(String str) {
            this.uA = str;
            return this;
        }
    }

    Sj(C0242Sj c0242Sj) {
        this.vS = "adiff";
        this.f21017aa = new AtomicBoolean(false);
        this.Fmk = new JSONObject();
        if (TextUtils.isEmpty(c0242Sj.sP)) {
            this.Sj = ib.Sj();
        } else {
            this.Sj = c0242Sj.sP;
        }
        this.sU = c0242Sj.Zq;
        this.zR = c0242Sj.vS;
        this.sef = c0242Sj.TKC;
        this.Zq = c0242Sj.EjP;
        if (TextUtils.isEmpty(c0242Sj.HiB)) {
            this.uvD = "app_union";
        } else {
            this.uvD = c0242Sj.HiB;
        }
        this.f21018dx = c0242Sj.Ym;
        this.dNu = c0242Sj.Dq;
        this.RiZ = c0242Sj.uA;
        this.TzV = c0242Sj.Jcg;
        this.f21019ib = c0242Sj.f21020aa;
        this.kF = c0242Sj.Fmk;
        this.Fmk = c0242Sj.TEQ = c0242Sj.TEQ != null ? c0242Sj.TEQ : new JSONObject();
        JSONObject jSONObject = new JSONObject();
        this.sP = jSONObject;
        if (!TextUtils.isEmpty(c0242Sj.Fmk)) {
            try {
                jSONObject.put("app_log_url", c0242Sj.Fmk);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.sU.sP("AdEvent", e11.getMessage());
            }
        }
        this.Jcg = c0242Sj.dNu;
        this.Dq = c0242Sj.TzV;
        this.uA = c0242Sj.Sj;
        this.TKC = c0242Sj.RiZ;
        this.HiB = System.currentTimeMillis();
        vS();
    }

    public Sj(String str, JSONObject jSONObject) {
        this.vS = "adiff";
        this.f21017aa = new AtomicBoolean(false);
        this.Fmk = new JSONObject();
        this.Sj = str;
        this.sP = jSONObject;
    }

    private void Jcg() throws JSONException {
        this.sP.putOpt("app_log_url", this.kF);
        this.sP.putOpt("tag", this.sef);
        this.sP.putOpt("label", this.Zq);
        this.sP.putOpt("category", this.uvD);
        if (!TextUtils.isEmpty(this.dNu)) {
            try {
                this.sP.putOpt(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(Long.parseLong(this.dNu)));
            } catch (NumberFormatException unused) {
                this.sP.putOpt(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0L);
            }
        }
        if (!TextUtils.isEmpty(this.RiZ)) {
            try {
                this.sP.putOpt("ext_value", Long.valueOf(Long.parseLong(this.RiZ)));
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.zR)) {
            this.sP.putOpt("log_extra", this.zR);
        }
        if (!TextUtils.isEmpty(this.f21018dx)) {
            try {
                this.sP.putOpt("ua_policy", Integer.valueOf(Integer.parseInt(this.f21018dx)));
            } catch (NumberFormatException unused3) {
            }
        }
        Sj(this.sP, this.Zq);
        try {
            this.sP.putOpt("nt", Integer.valueOf(this.f21019ib));
        } catch (Exception unused4) {
        }
        Iterator<String> keys = this.Fmk.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.sP.putOpt(next, this.Fmk.opt(next));
        }
    }

    private JSONObject Sj(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("adiff")) {
                jSONObject.put("adiff", this.Sj);
            }
            if (this.TKC) {
                if (!jSONObject.has("interaction_method")) {
                    jSONObject.put("interaction_method", this.Jcg);
                }
                if (!jSONObject.has("real_interaction_method")) {
                    jSONObject.put("real_interaction_method", this.Dq);
                }
                if (!jSONObject.has("image_mode")) {
                    jSONObject.put("image_mode", this.uA);
                }
            }
            if (com.bytedance.sdk.openadsdk.dx.Sj.Sj("replace_log_extra_key", false)) {
                sP(jSONObject);
            }
            jSONObject.put("pangle_client_unique_id", "pangle-" + this.Sj + "-" + System.currentTimeMillis());
            return jSONObject;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("AdEvent", th2.getMessage() == null ? "error " : th2.getMessage());
            return jSONObject;
        }
    }

    private static void Sj(JSONObject jSONObject, String str) {
        try {
            Set<String> set = TEQ;
            if (!set.contains(str) && !set.contains(jSONObject.get("label"))) {
                jSONObject.putOpt("is_ad_event", "1");
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("AdEvent", th2);
        }
    }

    private boolean Sj(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0") || TextUtils.isEmpty(str3)) {
            return false;
        }
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case 111399750:
                if (str2.equals("umeng")) {
                    c11 = 0;
                    break;
                }
                break;
            case 278118976:
                if (str2.equals("event_v1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 278118978:
                if (str2.equals("event_v3")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1844205361:
                if (str2.equals("app_union")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    private void sP(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : Ym.keySet()) {
            try {
                if (jSONObject.has(str)) {
                    Object opt = jSONObject.opt(str);
                    jSONObject.remove(str);
                    jSONObject.put(Ym.get(str), opt);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private boolean sP(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 111399750:
                if (str.equals("umeng")) {
                    c11 = 0;
                    break;
                }
                break;
            case 278118976:
                if (str.equals("event_v1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 278118978:
                if (str.equals("event_v3")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1844205361:
                if (str.equals("app_union")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    private void vS() {
        JSONObject jSONObject = this.Fmk;
        if (jSONObject != null) {
            String optString = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            String optString2 = this.Fmk.optString("category");
            String optString3 = this.Fmk.optString("log_extra");
            if (Sj(this.dNu, this.uvD, this.zR)) {
                if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
                    return;
                }
                if (!TextUtils.isEmpty(optString2) && !sP(optString2)) {
                    return;
                }
            } else {
                if ((TextUtils.isEmpty(optString) || TextUtils.equals(optString, "0")) && (TextUtils.isEmpty(this.dNu) || TextUtils.equals(this.dNu, "0"))) {
                    return;
                }
                if ((TextUtils.isEmpty(this.uvD) || !sP(this.uvD)) && (TextUtils.isEmpty(optString2) || !sP(optString2))) {
                    return;
                }
                if (TextUtils.isEmpty(this.zR) && TextUtils.isEmpty(optString3)) {
                    return;
                }
            }
        } else if (!Sj(this.dNu, this.uvD, this.zR)) {
            return;
        }
        this.EjP = com.bytedance.sdk.openadsdk.EjP.Sj.EjP.Sj.incrementAndGet();
    }

    public String EjP() {
        return this.Sj;
    }

    public boolean HiB() {
        Set<String> aa2;
        if (this.sP == null || (aa2 = com.bytedance.sdk.openadsdk.core.dNu.EjP().aa()) == null) {
            return false;
        }
        String optString = this.sP.optString("label");
        if (!TextUtils.isEmpty(optString)) {
            return aa2.contains(optString);
        }
        if (TextUtils.isEmpty(this.Zq)) {
            return false;
        }
        return aa2.contains(this.Zq);
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj.sP
    public long Sj() {
        return this.HiB;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj.sP
    public JSONObject Sj(String str) {
        return TKC();
    }

    public JSONObject Sj(boolean z10) {
        JSONObject TKC = TKC();
        try {
            if (!z10) {
                JSONObject jSONObject = new JSONObject(TKC.toString());
                jSONObject.remove("app_log_url");
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(TKC.toString());
            JSONObject optJSONObject = jSONObject2.optJSONObject("params");
            if (optJSONObject != null) {
                optJSONObject.remove("app_log_url");
            }
            return jSONObject2;
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.sU.sP("AdEvent", e11.getMessage());
            return TKC;
        }
    }

    public JSONObject TKC() {
        if (this.f21017aa.get()) {
            return this.sP;
        }
        try {
            Jcg();
        } catch (Throwable unused) {
        }
        if (this.sP.has("ad_extra_data")) {
            Object opt = this.sP.opt("ad_extra_data");
            if (opt != null) {
                try {
                    if (opt instanceof JSONObject) {
                        this.sP.put("ad_extra_data", Sj((JSONObject) opt).toString());
                    } else if (opt instanceof String) {
                        this.sP.put("ad_extra_data", Sj(new JSONObject((String) opt)).toString());
                    }
                } catch (JSONException e11) {
                    com.bytedance.sdk.component.utils.sU.sP("AdEvent", "json error", e11.getMessage());
                }
            }
            this.f21017aa.set(true);
            return this.sP;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adiff", this.Sj);
            if (this.TKC) {
                jSONObject.put("interaction_method", this.Jcg);
                jSONObject.put("real_interaction_method", this.Dq);
                jSONObject.put("image_mode", this.uA);
            }
            this.sP.put("ad_extra_data", jSONObject.toString());
        } catch (JSONException e12) {
            com.bytedance.sdk.component.utils.sU.sP("AdEvent", "json error", e12.getMessage());
        }
        this.f21017aa.set(true);
        return this.sP;
        return this.sP;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.EjP.Sj.sP
    public long sP() {
        return this.EjP;
    }
}
