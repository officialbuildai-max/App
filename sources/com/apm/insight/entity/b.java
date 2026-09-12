package com.apm.insight.entity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.l.f;
import com.apm.insight.l.m;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<com.apm.insight.d> f19570a = new ConcurrentLinkedQueue<>();

    /* loaded from: classes2.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    static {
        new ConcurrentHashMap();
    }

    public static File a(File file) {
        return new File(file, "all_data.json");
    }

    @NonNull
    public static JSONArray a() {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f19570a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.c());
        }
        return jSONArray;
    }

    @NonNull
    public static JSONArray a(Object obj) {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f19570a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.apm.insight.d next = it.next();
            if (next != null && next.a(obj)) {
                jSONArray.put(next.a(CrashType.JAVA, (JSONArray) null));
                break;
            }
        }
        return jSONArray;
    }

    public static JSONArray a(Object obj, Throwable th2, StackTraceElement[] stackTraceElementArr) {
        Iterator<com.apm.insight.d> it = f19570a.iterator();
        while (it.hasNext()) {
            com.apm.insight.d next = it.next();
            if (next != null && next.a(obj)) {
                JSONArray a11 = next.a(stackTraceElementArr, th2);
                JSONArray jSONArray = new JSONArray();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("aid", next.b());
                    jSONObject.put("lines", a11);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
                return jSONArray;
            }
        }
        return null;
    }

    @NonNull
    public static JSONArray a(String str) {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        String[] split = str.split("\n");
        Iterator<com.apm.insight.d> it = f19570a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (com.apm.insight.runtime.a.b(next.b())) {
                JSONArray a11 = next.a(split);
                if (!com.apm.insight.a.a(a11)) {
                    jSONArray.put(next.a(CrashType.ANR, a11));
                }
            }
        }
        return jSONArray;
    }

    @NonNull
    public static JSONArray a(String str, String str2, JSONArray jSONArray) {
        JSONObject optJSONObject;
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i11);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("header")) != null && com.apm.insight.runtime.a.c(String.valueOf(optJSONObject.opt("aid")))) {
                if (TextUtils.isEmpty(optJSONObject.optString("package"))) {
                    jSONArray2.put(optJSONObject2);
                } else if (a(str, optJSONObject.optJSONArray("so_list"), str2, optJSONObject.optJSONArray("so_list"))) {
                    jSONArray2.put(optJSONObject2);
                }
            }
        }
        return jSONArray2;
    }

    @Nullable
    public static JSONArray a(Throwable th2, Thread thread, @Nullable File file) {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] b11 = m.b(th2);
        Iterator<com.apm.insight.d> it = f19570a.iterator();
        while (true) {
            if (!it.hasNext() || (next = it.next()) == null) {
                break;
            }
            if (com.apm.insight.runtime.a.a(next.b())) {
                JSONArray a11 = next.a(b11, th2, thread != null ? thread.getName() : null);
                if (!com.apm.insight.a.a(a11)) {
                    jSONArray.put(next.a(CrashType.JAVA, a11));
                }
            } else {
                com.apm.insight.a.a((Object) ("not enable javaCrash aid: " + next.b()));
            }
        }
        if (com.apm.insight.a.a(jSONArray)) {
            return null;
        }
        try {
            f.a(new File(file, "all_data.json"), jSONArray);
        } catch (IOException unused) {
        }
        return jSONArray;
    }

    public static void a(@NonNull com.apm.insight.d dVar) {
        f19570a.add(dVar);
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray, a aVar) {
        JSONObject optJSONObject;
        com.apm.insight.a.a((Object) "uploadFromFile with allData ".concat(String.valueOf(jSONArray)));
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < jSONArray.length() && (optJSONObject = jSONArray.optJSONObject(i11)) != null; i11++) {
            if (com.apm.insight.a.a(optJSONObject, 0, "header", "single_upload") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                com.apm.insight.entity.a.b(jSONObject2, jSONObject);
                com.apm.insight.entity.a.b(jSONObject2, optJSONObject);
                aVar.a(jSONObject2);
            } else {
                jSONArray2.put(optJSONObject);
            }
        }
        if (jSONArray2.length() == 0) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        com.apm.insight.entity.a.b(jSONObject3, jSONObject);
        try {
            jSONObject3.put("all_data", jSONArray2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        aVar.a(jSONObject3);
    }

    public static boolean a(String str, JSONArray jSONArray, String str2, JSONArray jSONArray2) {
        if (!com.apm.insight.a.a(jSONArray)) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                if (str.contains(jSONArray.optString(i11))) {
                    return true;
                }
            }
        }
        if (!com.apm.insight.a.a(jSONArray2)) {
            for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                String optString = jSONArray2.optString(i12);
                if (optString != null && optString.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public static String b(Object obj) {
        Iterator<com.apm.insight.d> it = f19570a.iterator();
        while (it.hasNext()) {
            com.apm.insight.d next = it.next();
            if (next != null && next.a(obj)) {
                return next.b();
            }
        }
        return null;
    }

    @NonNull
    public static JSONArray b() {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f19570a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.a((CrashType) null, (JSONArray) null));
        }
        return jSONArray;
    }

    public static int c() {
        return f19570a.size();
    }

    public static List<String> d() {
        com.apm.insight.d next;
        ArrayList arrayList = new ArrayList();
        Iterator<com.apm.insight.d> it = f19570a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next.b());
        }
        return arrayList;
    }
}
