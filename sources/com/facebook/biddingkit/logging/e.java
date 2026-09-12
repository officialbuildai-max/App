package com.facebook.biddingkit.logging;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f24177a;

    /* renamed from: b, reason: collision with root package name */
    private String f24178b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f24179c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private String f24180d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends AsyncTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(e... eVarArr) {
            f.g(eVarArr[0]);
            return null;
        }
    }

    public void a(String str) {
        this.f24178b = str;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) this.f24179c.get(str);
        if (map == null) {
            map = new HashMap();
            this.f24179c.put(str, map);
        }
        map.put("cpm_cents", str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        this.f24177a = str;
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) this.f24179c.get(str);
        if (map == null) {
            map = new HashMap();
            this.f24179c.put(str, map);
        }
        map.put("error", str2);
    }

    public void e(String str) {
        this.f24180d = str;
    }

    public void f(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) this.f24179c.get(str);
        if (map == null) {
            map = new HashMap();
            this.f24179c.put(str, map);
        }
        map.put("latency_ms", str2);
    }

    public void g(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Map map = (Map) this.f24179c.get(str);
        if (map == null) {
            map = new HashMap();
            this.f24179c.put(str, map);
        }
        map.put("result", str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        Iterator it = this.f24179c.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            jSONObject.put(str, j(str));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String i() {
        return TextUtils.isEmpty(this.f24178b) ? "" : this.f24178b;
    }

    protected JSONObject j(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!this.f24179c.containsKey(str)) {
            return jSONObject;
        }
        for (Map.Entry entry : ((Map) this.f24179c.get(str)).entrySet()) {
            if ("cpm_cents".equals(entry.getKey())) {
                jSONObject.put((String) entry.getKey(), Double.parseDouble((String) entry.getValue()));
            } else if ("latency_ms".equals(entry.getKey())) {
                jSONObject.put((String) entry.getKey(), Long.parseLong((String) entry.getValue()));
            } else {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k() {
        return this.f24177a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String l() {
        return TextUtils.isEmpty(this.f24180d) ? "" : this.f24180d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f24178b)) {
                jSONObject.put("auction_id", this.f24178b);
            }
            if (!TextUtils.isEmpty(this.f24180d)) {
                jSONObject.put("exception", this.f24180d);
            }
            Iterator it = this.f24179c.entrySet().iterator();
            while (it.hasNext()) {
                String str = (String) ((Map.Entry) it.next()).getKey();
                jSONObject.put(str, j(str));
            }
        } catch (JSONException e11) {
            b.d("EventLog", "Failed to create json data", e11);
        }
        return jSONObject;
    }

    public void n() {
        new a().execute(this);
    }
}
