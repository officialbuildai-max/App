package com.apm.insight.entity;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.e;
import com.apm.insight.l.m;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f19568a;

    /* renamed from: b, reason: collision with root package name */
    private Header f19569b;

    public a() {
        JSONObject jSONObject = new JSONObject();
        this.f19568a = jSONObject;
        try {
            jSONObject.put("apm_id", "20000001");
        } catch (JSONException unused) {
        }
    }

    public a(JSONObject jSONObject) {
        this.f19568a = jSONObject;
    }

    public static a a(long j11, Context context, @NonNull Throwable th2) {
        if (j11 == 0) {
            j11 = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.a("isJava", (Object) 1);
        aVar.a("data", (Object) m.a(th2));
        aVar.a("crash_time", Long.valueOf(j11));
        aVar.a("process_name", (Object) com.apm.insight.l.a.b());
        if (!com.apm.insight.l.a.b(context)) {
            aVar.a("remote_process", (Object) 1);
        }
        return aVar;
    }

    private a a(String str, JSONArray jSONArray) {
        JSONObject optJSONObject = this.f19568a.optJSONObject("custom_long");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            a("custom_long", optJSONObject);
        }
        try {
            optJSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
        return this;
    }

    public static void a(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            try {
                optJSONObject = new JSONObject();
                jSONObject.put(str, optJSONObject);
            } catch (Throwable unused) {
                return;
            }
        }
        optJSONObject.put(str2, str3);
    }

    public static void a(JSONObject jSONObject, Throwable th2) {
        if (jSONObject.opt("npth_err_info") == null) {
            try {
                jSONObject.put("npth_err_info", m.a(th2));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        for (int i11 = 0; i11 < 5; i11++) {
            if (jSONObject.opt("npth_err_info" + i11) == null) {
                try {
                    jSONObject.put("npth_err_info" + i11, m.a(th2));
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
        }
    }

    public static void a(JSONObject jSONObject, Map<? extends String, ? extends String> map) {
        if (map != null) {
            try {
                for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject.put(PlaceTypes.STORAGE, jSONObject2);
        } catch (Throwable unused) {
        }
        long optLong = jSONObject2.optLong("inner_free");
        long optLong2 = jSONObject2.optLong("sdcard_free");
        long optLong3 = jSONObject2.optLong("inner_free_real");
        String str = "64M - ";
        String str2 = optLong <= 1024 ? "0 - 1K" : optLong <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? "1K - 64K" : optLong <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "64K - 512K" : optLong <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED ? "512K - 1M" : optLong <= 67108864 ? "1M - 64M" : "64M - ";
        String str3 = optLong3 <= 1024 ? "0 - 1K" : optLong3 <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? "1K - 64K" : optLong3 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "64K - 512K" : optLong3 <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED ? "512K - 1M" : optLong3 <= 67108864 ? "1M - 64M" : "64M - ";
        if (optLong2 <= 1024) {
            str = "0 - 1K";
        } else if (optLong2 <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            str = "1K - 64K";
        } else if (optLong2 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            str = "64K - 512K";
        } else if (optLong2 <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            str = "512K - 1M";
        } else if (optLong2 <= 67108864) {
            str = "1M - 64M";
        }
        a(jSONObject, "filters", "inner_free", str2);
        a(jSONObject, "filters", "inner_free_real", str3);
        a(jSONObject, "filters", "sdcard_free", str);
    }

    public static boolean a(String str) {
        return ((long) com.apm.insight.nativecrash.b.c(str)) > com.apm.insight.nativecrash.a.g();
    }

    public static void b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt == null) {
                    jSONObject.put(next, jSONObject2.opt(next));
                } else if (opt instanceof JSONObject) {
                    b(jSONObject.getJSONObject(next), jSONObject2.getJSONObject(next));
                } else if (opt instanceof JSONArray) {
                    JSONArray optJSONArray = jSONObject2.optJSONArray(next);
                    if (optJSONArray != null) {
                        JSONArray jSONArray = (JSONArray) opt;
                        if (jSONArray.length() == 1 && (jSONArray.opt(0) instanceof JSONObject) && (optJSONArray.opt(0) instanceof JSONObject)) {
                            b(jSONArray.getJSONObject(0), optJSONArray.getJSONObject(0));
                        } else {
                            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                                jSONArray.put(optJSONArray.get(i11));
                            }
                        }
                    }
                } else {
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static boolean b(String str) {
        return com.apm.insight.nativecrash.b.a(str) > 960;
    }

    public static boolean c(String str) {
        return com.apm.insight.nativecrash.b.b(str) > 350;
    }

    public final a a(int i11, String str) {
        try {
            this.f19568a.put("miniapp_id", i11);
            this.f19568a.put("miniapp_version", str);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return this;
    }

    public final a a(long j11) {
        try {
            a("app_start_time", Long.valueOf(j11));
            a("app_start_time_readable", (Object) new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j11)));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return this;
    }

    public final a a(Header header) {
        a("header", header.f());
        this.f19569b = header;
        return this;
    }

    public final a a(com.apm.insight.runtime.a.b bVar) {
        a("activity_trace", bVar.g());
        a("activity_track", bVar.i());
        return this;
    }

    public final a a(String str, String str2) {
        Object opt = this.f19568a.opt("data");
        if (opt instanceof JSONArray) {
            a(((JSONArray) opt).optJSONObject(0), "filters", str, str2);
        } else {
            a(this.f19568a, "filters", str, str2);
        }
        return this;
    }

    public final a a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            a("patch_info", (Object) jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        a("patch_info", (Object) jSONArray);
        return this;
    }

    public final a a(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.f19568a.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_name", str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.f19568a.put("plugin_info", jSONArray);
        return this;
    }

    public final a a(JSONObject jSONObject) {
        a("header", jSONObject);
        return this;
    }

    public final void a(@NonNull String str, @Nullable Object obj) {
        try {
            this.f19568a.put(str, obj);
        } catch (Exception e11) {
            com.apm.insight.a.b((Throwable) e11);
        }
    }

    public final boolean a() {
        Object opt = this.f19568a.opt("data");
        return opt instanceof JSONArray ? !com.apm.insight.a.a(((JSONArray) opt).optJSONObject(0), "logcat") : !com.apm.insight.a.a(this.f19568a, "logcat");
    }

    public final a b(String str, String str2) {
        Object opt = this.f19568a.opt("data");
        if (opt instanceof JSONArray) {
            a(((JSONArray) opt).optJSONObject(0), "custom", str, str2);
        } else {
            a(this.f19568a, "custom", str, str2);
        }
        return this;
    }

    public final a b(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e11) {
                    com.apm.insight.a.b((Throwable) e11);
                }
            }
            try {
                this.f19568a.put("sdk_info", jSONObject);
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
        return this;
    }

    public final a b(JSONObject jSONObject) {
        a(this.f19568a, jSONObject);
        return this;
    }

    public final void b() {
        a("has_logcat", String.valueOf(a()));
    }

    public final a c(Map<? extends String, ? extends String> map) {
        JSONObject optJSONObject;
        if (map != null) {
            Object opt = this.f19568a.opt("data");
            JSONObject optJSONObject2 = opt instanceof JSONArray ? ((JSONArray) opt).optJSONObject(0) : this.f19568a;
            if (optJSONObject2 == null) {
                optJSONObject = new JSONObject();
            } else {
                optJSONObject = optJSONObject2.optJSONObject("filters");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    a("filters", optJSONObject);
                }
            }
            for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                try {
                    optJSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
            a("filters", optJSONObject);
        }
        return this;
    }

    public final JSONObject c() {
        return this.f19568a;
    }

    public final void c(@NonNull JSONObject jSONObject) {
        b(this.f19568a, jSONObject);
    }

    public final Header d() {
        if (this.f19569b == null) {
            Header header = new Header(e.g());
            this.f19569b = header;
            a(header);
        }
        return this.f19569b;
    }
}
