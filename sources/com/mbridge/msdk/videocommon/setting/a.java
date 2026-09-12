package com.mbridge.msdk.videocommon.setting;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f40023a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.videocommon.entity.c> f40024b;

    /* renamed from: c, reason: collision with root package name */
    private long f40025c;

    /* renamed from: d, reason: collision with root package name */
    private long f40026d;

    /* renamed from: e, reason: collision with root package name */
    private long f40027e;

    /* renamed from: f, reason: collision with root package name */
    private long f40028f;

    /* renamed from: g, reason: collision with root package name */
    private long f40029g;

    /* renamed from: h, reason: collision with root package name */
    private long f40030h;

    /* renamed from: j, reason: collision with root package name */
    private String f40032j;

    /* renamed from: i, reason: collision with root package name */
    private int f40031i = 0;

    /* renamed from: k, reason: collision with root package name */
    private String f40033k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f40034l = "";

    public static a a(String str) {
        a aVar;
        a aVar2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                aVar = new a();
            } catch (Exception e11) {
                e = e11;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("caplist");
                aVar.b(jSONObject.optString("ab_id", ""));
                aVar.c(jSONObject.optString("rid", ""));
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        int optInt = optJSONObject.optInt(next, 1000);
                        if (!TextUtils.isEmpty(next)) {
                            if (TextUtils.isEmpty(next) || optInt != 0) {
                                hashMap.put(next, Integer.valueOf(optInt));
                            } else {
                                hashMap.put(next, 1000);
                            }
                        }
                    }
                    aVar.a(hashMap);
                }
                aVar.b(com.mbridge.msdk.videocommon.entity.c.a(jSONObject.optJSONArray("reward")));
                aVar.c(jSONObject.optLong("getpf", 43200L));
                aVar.e(jSONObject.optLong("ruct", 5400L));
                aVar.d(jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600L));
                aVar.b(jSONObject.optLong("dlct", 3600L));
                aVar.f(jSONObject.optLong("vcct", 5L));
                aVar.a(jSONObject.optLong("current_time"));
                aVar.d(jSONObject.optString("vtag", ""));
                return aVar;
            } catch (Exception e12) {
                e = e12;
                aVar2 = aVar;
                e.printStackTrace();
                return aVar2;
            }
        }
        return aVar2;
    }

    public String a() {
        return this.f40032j;
    }

    public void a(int i11) {
        this.f40031i = i11;
    }

    public void a(long j11) {
        this.f40030h = j11;
    }

    public void a(Map<String, Integer> map) {
        this.f40023a = map;
    }

    public long b() {
        return this.f40030h;
    }

    public void b(long j11) {
        this.f40028f = j11;
    }

    public void b(String str) {
        this.f40032j = str;
    }

    public void b(Map<String, com.mbridge.msdk.videocommon.entity.c> map) {
        this.f40024b = map;
    }

    public long c() {
        return this.f40028f;
    }

    public void c(long j11) {
        this.f40025c = j11;
    }

    public void c(String str) {
        this.f40034l = str;
    }

    public long d() {
        return this.f40025c * 1000;
    }

    public void d(long j11) {
        this.f40027e = j11;
    }

    public void d(String str) {
        this.f40033k = str;
    }

    public long e() {
        return this.f40027e * 1000;
    }

    public void e(long j11) {
        this.f40026d = j11;
    }

    public String f() {
        return this.f40034l;
    }

    public void f(long j11) {
        this.f40029g = j11;
    }

    public Map<String, com.mbridge.msdk.videocommon.entity.c> g() {
        return this.f40024b;
    }

    public long h() {
        return this.f40026d * 1000;
    }

    public long i() {
        return this.f40029g;
    }

    public String j() {
        return this.f40033k;
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.f40023a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.f40023a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            Map<String, com.mbridge.msdk.videocommon.entity.c> map2 = this.f40024b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, com.mbridge.msdk.videocommon.entity.c> entry2 : this.f40024b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        com.mbridge.msdk.videocommon.entity.c value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put("name", value.c());
                            jSONObject3.put(RewardPlus.AMOUNT, value.a());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.f40025c);
            jSONObject.put("ruct", this.f40026d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.f40027e);
            jSONObject.put("dlct", this.f40028f);
            jSONObject.put("vcct", this.f40029g);
            jSONObject.put("current_time", this.f40030h);
            jSONObject.put("vtag", this.f40033k);
            jSONObject.put("isDefault", this.f40031i);
            return jSONObject;
        } catch (Exception e13) {
            e13.printStackTrace();
            return jSONObject;
        }
    }
}
