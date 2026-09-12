package com.mbridge.msdk.foundation.db.middle;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.w0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f35158a = "FrequencyDaoMiddle";

    /* renamed from: b, reason: collision with root package name */
    private static a f35159b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f35160c = "FrequencyDaoMiddle";

    /* renamed from: d, reason: collision with root package name */
    private static JSONArray f35161d = new JSONArray();

    private a() {
        c();
    }

    private JSONObject a(String str, int i11, int i12, long j11, int i13, int i14) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e11) {
            e = e11;
            jSONObject = null;
        }
        try {
            jSONObject.put("id", str);
            jSONObject.put("fc_a", i11);
            jSONObject.put("fc_b", i12);
            jSONObject.put("ts", j11);
            jSONObject.put("impression_count", i13);
            jSONObject.put("click_count", i14);
        } catch (Exception e12) {
            e = e12;
            o0.b(f35158a, e.getMessage());
            return jSONObject;
        }
        return jSONObject;
    }

    public static a b() {
        if (f35159b == null) {
            synchronized (a.class) {
                try {
                    if (f35159b == null) {
                        f35159b = new a();
                    }
                } finally {
                }
            }
        }
        return f35159b;
    }

    private void c() {
        try {
            String str = (String) w0.a(c.m().d(), f35160c, f35161d.toString());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            f35161d = new JSONArray(str);
        } catch (Exception e11) {
            o0.b(f35158a, e11.getMessage());
        }
    }

    private void d() {
        try {
            if (f35161d != null) {
                w0.b(c.m().d(), f35160c, f35161d.toString());
            }
        } catch (Exception e11) {
            o0.b(f35158a, e11.getMessage());
        }
    }

    public void a(long j11) {
        if (f35161d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i11 = 0; i11 < f35161d.length(); i11++) {
                try {
                    JSONObject jSONObject = f35161d.getJSONObject(i11);
                    if (jSONObject != null && jSONObject.optInt("ts") >= j11) {
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e11) {
                    o0.b(f35158a, e11.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                f35161d = jSONArray;
            }
        }
        d();
    }

    public void a(g gVar) {
        JSONObject a11;
        if (gVar == null || (a11 = a(gVar.a(), gVar.c(), gVar.d(), gVar.f(), gVar.e(), gVar.b())) == null) {
            return;
        }
        if (f35161d == null) {
            f35161d = new JSONArray();
        }
        f35161d.put(a11);
        d();
    }

    public void a(String str) {
        if (f35161d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i11 = 0; i11 < f35161d.length(); i11++) {
                try {
                    JSONObject jSONObject = f35161d.getJSONObject(i11);
                    if (jSONObject != null) {
                        if (jSONObject.optString("id", "").equals(str)) {
                            jSONObject.put("impression_count", jSONObject.optInt("impression_count", 0) + 1);
                            jSONArray.put(jSONObject);
                        } else {
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e11) {
                    o0.b(f35158a, e11.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                f35161d = jSONArray;
            }
            d();
        }
    }

    public String[] a() {
        ArrayList arrayList = new ArrayList();
        if (f35161d != null) {
            for (int i11 = 0; i11 < f35161d.length(); i11++) {
                try {
                    JSONObject jSONObject = f35161d.getJSONObject(i11);
                    if (jSONObject != null && jSONObject.optInt("fc_a") < jSONObject.optInt("impression_count")) {
                        arrayList.add(jSONObject.optString("id"));
                    }
                } catch (JSONException e11) {
                    o0.b(f35158a, e11.getMessage());
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            strArr[i12] = (String) arrayList.get(i12);
        }
        return strArr;
    }
}
