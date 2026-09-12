package com.apm.insight.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.apm.insight.runtime.m;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static File f19731a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f19732b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f19733c;

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, String> f19734d;

    public static void a(String str) {
        if (f19734d == null) {
            f19734d = new HashMap();
        }
        f19734d.put(str, String.valueOf(System.currentTimeMillis()));
    }

    public static void a(JSONArray jSONArray) {
        try {
            com.apm.insight.l.f.a(new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configFile"), jSONArray);
        } catch (IOException unused) {
        }
        try {
            com.apm.insight.l.f.a(h(), f19734d);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return f19732b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return f19733c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        if (f19732b) {
            return;
        }
        f19733c = true;
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configFile");
        if (file.exists()) {
            try {
                com.apm.insight.runtime.a.a(new JSONArray(com.apm.insight.l.f.a(file, "\n")), false);
                f19732b = true;
            } catch (Throwable unused) {
                com.apm.insight.runtime.a.a((JSONArray) null, false);
            }
        }
    }

    public static void d() {
        c();
        if (g()) {
            a.a();
        }
    }

    public static void e() {
        m.a().a(new Runnable() { // from class: com.apm.insight.k.j.1
            @Override // java.lang.Runnable
            public final void run() {
                if (j.g()) {
                    a.a();
                }
            }
        });
    }

    public static void f() {
        Map<String, String> map = f19734d;
        if (map != null) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g() {
        File h11 = h();
        try {
            Map<String, String> map = f19734d;
            if (map == null) {
                map = com.apm.insight.l.f.c(h11);
            }
            f19734d = map;
            if (map == null) {
                f19734d = new HashMap();
                return true;
            }
            if (map.size() < com.apm.insight.entity.b.c()) {
                return true;
            }
            Iterator<String> it = com.apm.insight.entity.b.d().iterator();
            while (it.hasNext()) {
                if (!f19734d.containsKey(it.next())) {
                    return true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = false;
            for (Map.Entry<String, String> entry : f19734d.entrySet()) {
                try {
                    if (currentTimeMillis - Long.decode(entry.getValue()).longValue() > com.apm.insight.runtime.d.d(entry.getKey())) {
                        z10 = true;
                    }
                } catch (Throwable th2) {
                    com.apm.insight.a.a(th2);
                }
            }
            if (z10) {
                com.apm.insight.a.a((Object) "config should be updated");
            } else {
                com.apm.insight.a.a((Object) "config should not be updated");
            }
            return z10;
        } catch (Throwable th3) {
            Log.e("npth", NotificationCompat.CATEGORY_ERROR, th3);
            return true;
        }
    }

    @NonNull
    private static File h() {
        if (f19731a == null) {
            f19731a = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/configCrash/configInvalid");
        }
        return f19731a;
    }
}
