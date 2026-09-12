package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Zq {
    private Sj Sj;

    /* loaded from: classes3.dex */
    public static class Sj {
        C0285Sj Sj;
        C0285Sj sP;

        /* renamed from: com.bytedance.sdk.openadsdk.core.model.Zq$Sj$Sj, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0285Sj {
            String Sj;

            public C0285Sj(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.Sj = jSONObject.optString("entry");
            }

            public boolean Sj() {
                return !TextUtils.isEmpty(this.Sj);
            }
        }

        public Sj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.has("vertical")) {
                this.Sj = new C0285Sj(jSONObject.optJSONObject("vertical"));
            }
            if (jSONObject.has("horizontal")) {
                this.sP = new C0285Sj(jSONObject.optJSONObject("horizontal"));
            }
        }

        public String Sj(boolean z10) {
            if (z10) {
                C0285Sj c0285Sj = this.Sj;
                return c0285Sj != null ? c0285Sj.Sj : "";
            }
            C0285Sj c0285Sj2 = this.sP;
            return c0285Sj2 != null ? c0285Sj2.Sj : "";
        }

        public boolean Sj() {
            C0285Sj c0285Sj = this.sP;
            if (c0285Sj != null && c0285Sj.Sj()) {
                return true;
            }
            C0285Sj c0285Sj2 = this.Sj;
            return c0285Sj2 != null && c0285Sj2.Sj();
        }
    }

    public Zq(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("easy_playable")) == null) {
            return;
        }
        this.Sj = new Sj(optJSONObject.optJSONObject("components"));
    }

    public static boolean Sj(sU sUVar) {
        Zq tX;
        Sj sj2;
        return (sUVar == null || (tX = sUVar.tX()) == null || (sj2 = tX.Sj) == null || !sj2.Sj()) ? false : true;
    }

    public static Sj sP(sU sUVar) {
        Zq tX;
        if (sUVar == null || (tX = sUVar.tX()) == null) {
            return null;
        }
        return tX.Sj;
    }
}
