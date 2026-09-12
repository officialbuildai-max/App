package com.bytedance.sdk.component.adexpress.Sj.TKC;

import android.text.TextUtils;
import android.util.Pair;
import com.cloud.tmc.integration.permission.PermissionConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Sj {
    private List<C0225Sj> EjP;
    private sP HiB;
    private Map<String, Sj> Jcg = new ConcurrentHashMap();
    private String Sj;
    private String TKC;
    private String sP;
    private String vS;

    /* renamed from: com.bytedance.sdk.component.adexpress.Sj.TKC.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0225Sj {
        private String Sj;
        private int TKC;
        private String sP;

        public String Sj() {
            return this.Sj;
        }

        public void Sj(int i11) {
            this.TKC = i11;
        }

        public void Sj(String str) {
            this.Sj = str;
        }

        public int TKC() {
            return this.TKC;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0225Sj)) {
                return super.equals(obj);
            }
            String str2 = this.Sj;
            if (str2 != null) {
                C0225Sj c0225Sj = (C0225Sj) obj;
                if (str2.equals(c0225Sj.Sj()) && (str = this.sP) != null && str.equals(c0225Sj.sP())) {
                    return true;
                }
            }
            return false;
        }

        public String sP() {
            return this.sP;
        }

        public void sP(String str) {
            this.sP = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class sP {
        private String Sj;
        private List<Pair<String, String>> TKC;
        private String sP;

        public String Sj() {
            return this.Sj;
        }

        public void Sj(String str) {
            this.Sj = str;
        }

        public void Sj(List<Pair<String, String>> list) {
            this.TKC = list;
        }

        public List<Pair<String, String>> sP() {
            return this.TKC;
        }

        public void sP(String str) {
            this.sP = str;
        }
    }

    public static Sj HiB(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Sj(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Sj Sj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        Sj sj2 = new Sj();
        sj2.Sj(jSONObject.optString("name"));
        sj2.sP(jSONObject.optString("version"));
        sj2.TKC(jSONObject.optString("main"));
        sj2.EjP(jSONObject.optString("template_fetch_url", ""));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i11);
                C0225Sj c0225Sj = new C0225Sj();
                c0225Sj.Sj(optJSONObject2.optString("url"));
                c0225Sj.sP(optJSONObject2.optString("md5"));
                c0225Sj.Sj(optJSONObject2.optInt(PermissionConstant.level));
                arrayList.add(c0225Sj);
            }
        }
        sj2.Sj(arrayList);
        try {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("engines");
            if (optJSONObject3 != null) {
                Iterator<String> keys = optJSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Sj Sj = Sj(optJSONObject3.optJSONObject(next));
                    if (Sj != null) {
                        sj2.Sj().put(next, Sj);
                    }
                }
            }
        } catch (Exception e11) {
            e11.getMessage();
        }
        if (jSONObject.has("resources_archive") && (optJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            sP sPVar = new sP();
            sPVar.Sj(optJSONObject.optString("url"));
            sPVar.sP(optJSONObject.optString("md5"));
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("map");
            if (optJSONObject4 != null) {
                Iterator<String> keys2 = optJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    arrayList2.add(new Pair<>(next2, optJSONObject4.optString(next2)));
                }
                sPVar.Sj(arrayList2);
            }
            sj2.Sj(sPVar);
        }
        if (sj2.Dq()) {
            return sj2;
        }
        return null;
    }

    public boolean Dq() {
        return (TextUtils.isEmpty(EjP()) || TextUtils.isEmpty(TKC()) || TextUtils.isEmpty(sP())) ? false : true;
    }

    public String EjP() {
        return this.TKC;
    }

    public void EjP(String str) {
        this.vS = str;
    }

    public sP HiB() {
        return this.HiB;
    }

    public String Jcg() {
        return this.vS;
    }

    public Map<String, Sj> Sj() {
        return this.Jcg;
    }

    public void Sj(sP sPVar) {
        this.HiB = sPVar;
    }

    public void Sj(String str) {
        this.Sj = str;
    }

    public void Sj(List<C0225Sj> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.EjP = list;
    }

    public String TEQ() {
        JSONObject uA;
        if (!Dq() || (uA = uA()) == null) {
            return null;
        }
        return uA.toString();
    }

    public String TKC() {
        return this.sP;
    }

    public void TKC(String str) {
        this.TKC = str;
    }

    public String sP() {
        return this.Sj;
    }

    public void sP(String str) {
        this.sP = str;
    }

    public JSONObject uA() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", sP());
            jSONObject.putOpt("version", TKC());
            jSONObject.putOpt("main", EjP());
            if (!TextUtils.isEmpty(this.vS)) {
                jSONObject.put("template_fetch_url", this.vS);
            }
            JSONArray jSONArray = new JSONArray();
            if (vS() != null) {
                for (C0225Sj c0225Sj : vS()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0225Sj.Sj());
                    jSONObject2.putOpt("md5", c0225Sj.sP());
                    jSONObject2.putOpt(PermissionConstant.level, Integer.valueOf(c0225Sj.TKC()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.Jcg.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z10 = false;
                for (String str : this.Jcg.keySet()) {
                    Sj sj2 = this.Jcg.get(str);
                    if (sj2 != null) {
                        jSONObject3.put(str, sj2.uA());
                        z10 = true;
                    }
                }
                if (z10) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            sP HiB = HiB();
            if (HiB != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", HiB.Sj);
                jSONObject4.put("md5", HiB.sP);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> sP2 = HiB.sP();
                if (sP2 != null) {
                    for (Pair<String, String> pair : sP2) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<C0225Sj> vS() {
        if (this.EjP == null) {
            this.EjP = new ArrayList();
        }
        return this.EjP;
    }
}
