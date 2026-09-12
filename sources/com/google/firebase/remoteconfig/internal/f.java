package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: h, reason: collision with root package name */
    private static final Date f32554h = new Date(0);

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f32555a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f32556b;

    /* renamed from: c, reason: collision with root package name */
    private Date f32557c;

    /* renamed from: d, reason: collision with root package name */
    private JSONArray f32558d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f32559e;

    /* renamed from: f, reason: collision with root package name */
    private long f32560f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f32561g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f32562a;

        /* renamed from: b, reason: collision with root package name */
        private Date f32563b;

        /* renamed from: c, reason: collision with root package name */
        private JSONArray f32564c;

        /* renamed from: d, reason: collision with root package name */
        private JSONObject f32565d;

        /* renamed from: e, reason: collision with root package name */
        private long f32566e;

        /* renamed from: f, reason: collision with root package name */
        private JSONArray f32567f;

        private b() {
            this.f32562a = new JSONObject();
            this.f32563b = f.f32554h;
            this.f32564c = new JSONArray();
            this.f32565d = new JSONObject();
            this.f32566e = 0L;
            this.f32567f = new JSONArray();
        }

        public f a() {
            return new f(this.f32562a, this.f32563b, this.f32564c, this.f32565d, this.f32566e, this.f32567f);
        }

        public b b(JSONObject jSONObject) {
            try {
                this.f32562a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b c(JSONArray jSONArray) {
            try {
                this.f32564c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b d(Date date) {
            this.f32563b = date;
            return this;
        }

        public b e(JSONObject jSONObject) {
            try {
                this.f32565d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b f(JSONArray jSONArray) {
            try {
                this.f32567f = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b g(long j11) {
            this.f32566e = j11;
            return this;
        }
    }

    private f(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j11, JSONArray jSONArray2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j11);
        jSONObject3.put("rollout_metadata_key", jSONArray2);
        this.f32556b = jSONObject;
        this.f32557c = date;
        this.f32558d = jSONArray;
        this.f32559e = jSONObject2;
        this.f32560f = j11;
        this.f32561g = jSONArray2;
        this.f32555a = jSONObject3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("rollout_metadata_key");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        return new f(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), jSONObject2, jSONObject.optLong("template_version_number_key"), optJSONArray);
    }

    private Map c() {
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < j().length(); i11++) {
            JSONObject jSONObject = j().getJSONObject(i11);
            String string = jSONObject.getString("rolloutId");
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                String string3 = jSONArray.getString(i12);
                if (!hashMap.containsKey(string3)) {
                    hashMap.put(string3, new HashMap());
                }
                Map map = (Map) hashMap.get(string3);
                if (map != null) {
                    map.put(string, string2);
                }
            }
        }
        return hashMap;
    }

    private static f d(JSONObject jSONObject) {
        return b(new JSONObject(jSONObject.toString()));
    }

    public static b l() {
        return new b();
    }

    public JSONArray e() {
        return this.f32558d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return this.f32555a.toString().equals(((f) obj).toString());
        }
        return false;
    }

    public Set f(f fVar) {
        JSONObject g11 = d(fVar.f32555a).g();
        Map c11 = c();
        Map c12 = fVar.c();
        HashSet hashSet = new HashSet();
        Iterator<String> keys = g().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!fVar.g().has(next)) {
                hashSet.add(next);
            } else if (!g().get(next).equals(fVar.g().get(next))) {
                hashSet.add(next);
            } else if ((i().has(next) && !fVar.i().has(next)) || (!i().has(next) && fVar.i().has(next))) {
                hashSet.add(next);
            } else if (i().has(next) && fVar.i().has(next) && !i().getJSONObject(next).toString().equals(fVar.i().getJSONObject(next).toString())) {
                hashSet.add(next);
            } else if (c11.containsKey(next) != c12.containsKey(next)) {
                hashSet.add(next);
            } else if (c11.containsKey(next) && c12.containsKey(next) && !((Map) c11.get(next)).equals(c12.get(next))) {
                hashSet.add(next);
            } else {
                g11.remove(next);
            }
        }
        Iterator<String> keys2 = g11.keys();
        while (keys2.hasNext()) {
            hashSet.add(keys2.next());
        }
        return hashSet;
    }

    public JSONObject g() {
        return this.f32556b;
    }

    public Date h() {
        return this.f32557c;
    }

    public int hashCode() {
        return this.f32555a.hashCode();
    }

    public JSONObject i() {
        return this.f32559e;
    }

    public JSONArray j() {
        return this.f32561g;
    }

    public long k() {
        return this.f32560f;
    }

    public String toString() {
        return this.f32555a.toString();
    }
}
