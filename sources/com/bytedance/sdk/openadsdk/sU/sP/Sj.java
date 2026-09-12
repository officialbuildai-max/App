package com.bytedance.sdk.openadsdk.sU.sP;

import android.text.TextUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Sj {
    private String Sj;
    private List<C0297Sj> TKC;
    private List<C0297Sj> sP;

    /* renamed from: com.bytedance.sdk.openadsdk.sU.sP.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0297Sj {
        private String Sj;
        private int TKC;
        private String sP;

        public static C0297Sj Sj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0297Sj c0297Sj = new C0297Sj();
            c0297Sj.Sj = jSONObject.optString("url");
            c0297Sj.sP = jSONObject.optString("md5");
            c0297Sj.TKC = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
            return c0297Sj;
        }

        public String Sj() {
            return this.Sj;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0297Sj)) {
                return super.equals(obj);
            }
            String str2 = this.Sj;
            if (str2 != null) {
                C0297Sj c0297Sj = (C0297Sj) obj;
                if (str2.equals(c0297Sj.Sj) && (str = this.sP) != null && str.equals(c0297Sj.sP)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static Sj sP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Sj sj2 = new Sj();
            sj2.Sj(jSONObject.optString("version"));
            JSONArray optJSONArray = jSONObject.optJSONArray("resources");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    C0297Sj Sj = C0297Sj.Sj(optJSONArray.optJSONObject(i11));
                    if (Sj != null) {
                        if (Sj.TKC == 1) {
                            arrayList.add(Sj);
                        } else if (Sj.TKC == 2 && arrayList2.size() < 10) {
                            arrayList2.add(Sj);
                        }
                    }
                }
            }
            sj2.Sj(arrayList);
            sj2.sP(arrayList2);
            return sj2;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String Sj() {
        return this.Sj;
    }

    public void Sj(String str) {
        this.Sj = str;
    }

    public void Sj(List<C0297Sj> list) {
        this.sP = list;
    }

    public List<C0297Sj> TKC() {
        return this.TKC;
    }

    public List<C0297Sj> sP() {
        return this.sP;
    }

    public void sP(List<C0297Sj> list) {
        this.TKC = list;
    }
}
