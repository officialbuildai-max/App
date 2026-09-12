package com.mbridge.msdk.setting;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.e0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.w0;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f37374a = "h";

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f37375b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile g f37376c;

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, l> f37377d = new HashMap<>();

    private h() {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r5, java.lang.String r6) {
        /*
            com.mbridge.msdk.foundation.controller.d r0 = com.mbridge.msdk.foundation.controller.d.a()
            boolean r0 = r0.e()
            java.lang.String r1 = "mbridge"
            r2 = 0
            if (r0 == 0) goto L1d
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch: java.lang.Exception -> L1d
            com.mbridge.msdk.foundation.same.directory.c r3 = com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG     // Catch: java.lang.Exception -> L1d
            java.lang.String r3 = com.mbridge.msdk.foundation.same.directory.e.b(r3)     // Catch: java.lang.Exception -> L1d
            r0.<init>(r3, r1)     // Catch: java.lang.Exception -> L1d
            com.mbridge.msdk.foundation.tools.FastKV r0 = r0.build()     // Catch: java.lang.Exception -> L1d
            goto L1e
        L1d:
            r0 = r2
        L1e:
            java.lang.String r3 = "_"
            if (r0 == 0) goto L66
            java.util.Map r2 = r0.getAll()     // Catch: java.lang.Exception -> L26
        L26:
            if (r2 == 0) goto Lac
            java.util.Set r5 = r2.keySet()     // Catch: java.lang.Exception -> L61
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L61
        L30:
            boolean r0 = r5.hasNext()     // Catch: java.lang.Exception -> L61
            if (r0 == 0) goto Lac
            java.lang.Object r0 = r5.next()     // Catch: java.lang.Exception -> L61
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L61
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L61
            r1.<init>()     // Catch: java.lang.Exception -> L61
            r1.append(r6)     // Catch: java.lang.Exception -> L61
            r1.append(r3)     // Catch: java.lang.Exception -> L61
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L61
            boolean r1 = r0.startsWith(r1)     // Catch: java.lang.Exception -> L61
            if (r1 == 0) goto L30
            java.util.HashMap<java.lang.String, com.mbridge.msdk.setting.l> r1 = com.mbridge.msdk.setting.h.f37377d     // Catch: java.lang.Exception -> L61
            java.lang.Object r4 = r2.get(r0)     // Catch: java.lang.Exception -> L61
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L61
            com.mbridge.msdk.setting.l r4 = com.mbridge.msdk.setting.l.l(r4)     // Catch: java.lang.Exception -> L61
            r1.put(r0, r4)     // Catch: java.lang.Exception -> L61
            goto L30
        L61:
            r5 = move-exception
            r5.printStackTrace()
            goto Lac
        L66:
            r0 = 0
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r1, r0)     // Catch: java.lang.Exception -> La8
            java.util.Map r5 = r5.getAll()     // Catch: java.lang.Exception -> La8
            java.util.Set r0 = r5.keySet()     // Catch: java.lang.Exception -> La8
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> La8
        L77:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> La8
            if (r1 == 0) goto Lac
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> La8
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> La8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La8
            r2.<init>()     // Catch: java.lang.Exception -> La8
            r2.append(r6)     // Catch: java.lang.Exception -> La8
            r2.append(r3)     // Catch: java.lang.Exception -> La8
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> La8
            boolean r2 = r1.startsWith(r2)     // Catch: java.lang.Exception -> La8
            if (r2 == 0) goto L77
            java.util.HashMap<java.lang.String, com.mbridge.msdk.setting.l> r2 = com.mbridge.msdk.setting.h.f37377d     // Catch: java.lang.Exception -> La8
            java.lang.Object r4 = r5.get(r1)     // Catch: java.lang.Exception -> La8
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> La8
            com.mbridge.msdk.setting.l r4 = com.mbridge.msdk.setting.l.l(r4)     // Catch: java.lang.Exception -> La8
            r2.put(r1, r4)     // Catch: java.lang.Exception -> La8
            goto L77
        La8:
            r5 = move-exception
            r5.printStackTrace()
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.setting.h.a(android.content.Context, java.lang.String):void");
    }

    public static h b() {
        if (f37375b == null) {
            synchronized (h.class) {
                try {
                    if (f37375b == null) {
                        f37375b = new h();
                    }
                } finally {
                }
            }
        }
        return f37375b;
    }

    private l b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.c.m().b();
        }
        String str3 = str + "_" + str2;
        if (f37377d.containsKey(str3)) {
            return f37377d.get(str3);
        }
        l lVar = null;
        try {
            lVar = l.l(com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str3));
            f37377d.put(str3, lVar);
            return lVar;
        } catch (Exception e11) {
            l lVar2 = lVar;
            e11.printStackTrace();
            return lVar2;
        }
    }

    public g a() {
        return i.a();
    }

    public l a(String str, String str2) {
        return b(str, str2);
    }

    public JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return jSONObject2;
        }
        if (jSONObject2 != null && jSONObject2.length() != 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if ("unitSetting".equals(next) && jSONObject.has("unitSetting")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("unitSetting");
                        jSONArray.put(0, a((JSONObject) jSONArray.get(0), (JSONObject) jSONObject2.getJSONArray("unitSetting").get(0)));
                        jSONObject.put(next, jSONArray);
                    } else {
                        jSONObject.put(next, jSONObject2.opt(next));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public void a(String str) {
        i.a(str, this);
    }

    public void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str4, str3);
        f37377d.put(str4, l.l(str3));
    }

    public boolean a(String str, int i11, String str2) {
        try {
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            String str3 = str + "_" + i11 + "_" + str2;
            long currentTimeMillis = System.currentTimeMillis();
            long j11 = 0;
            long longValue = ((Long) w0.a(d11, str3, 0L)).longValue();
            g d12 = d(str);
            if (d12 == null) {
                d12 = b().a();
            } else {
                j11 = longValue;
            }
            if (j11 + (d12.l0() * 1000) > currentTimeMillis) {
                return false;
            }
            w0.b(d11, str3, Long.valueOf(currentTimeMillis));
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public g b(String str) {
        g d11;
        try {
            return (TextUtils.isEmpty(str) || (d11 = d(str)) == null) ? a() : d11;
        } catch (Exception unused) {
            return a();
        }
    }

    public g c() {
        return f37376c != null ? f37376c : a();
    }

    public l c(String str, String str2) {
        l a11 = a(str, str2);
        return a11 == null ? l.N() : a11;
    }

    public String c(String str) {
        return com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("ivreward_" + str);
    }

    public g d(String str) {
        if (f37376c == null) {
            try {
                String a11 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str);
                if (!TextUtils.isEmpty(a11)) {
                    JSONObject jSONObject = new JSONObject(a11);
                    if (jSONObject.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        jSONObject.remove(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                    }
                    if (jSONObject.has("c")) {
                        jSONObject.remove("c");
                    }
                    f37376c = g.C(jSONObject.toString());
                    if (f37376c != null) {
                        f37376c.K0();
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return f37376c;
    }

    public l d(String str, String str2) {
        l e11 = e(str, str2);
        return e11 == null ? l.N() : e11;
    }

    public l e(String str, String str2) {
        l b11 = b(str, str2);
        if (b11 != null && b11.L() == 0) {
            b11.d(1);
        }
        return b11;
    }

    public String e(String str) {
        if (str == null) {
            return "";
        }
        try {
            String a11 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str);
            return a11 == null ? "" : a11;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            return "";
        }
    }

    public String f(String str, String str2) {
        return com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str + "_" + str2);
    }

    public boolean f(String str) {
        g d11 = d(str);
        if (d11 != null) {
            long A = d11.A() * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            long w11 = d11.w() + A;
            if (w11 > currentTimeMillis) {
                o0.c(f37374a, "app setting nexttime is not ready  [settingNextRequestTime= " + w11 + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
        }
        o0.c(f37374a, "app setting timeout or not exists");
        return true;
    }

    public void g(String str) {
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().c("ivreward_" + str);
    }

    public boolean g(String str, String str2) {
        g d11 = d(str2);
        if (f(str2) && a(str2, 1, str)) {
            new j().b(com.mbridge.msdk.foundation.controller.c.m().d(), str2, com.mbridge.msdk.foundation.controller.c.m().c());
        }
        l e11 = e(str2, str);
        if (d11 != null && e11 != null) {
            long q02 = d11.q0() * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            long o11 = e11.o() + q02;
            if (o11 > currentTimeMillis) {
                o0.c(f37374a, "unit setting  nexttime is not ready  [settingNextRequestTime= " + o11 + " currentTime = " + currentTimeMillis + "]");
                return false;
            }
        }
        o0.c(f37374a, "unit setting timeout or not exists");
        return true;
    }

    public void h(String str) {
        try {
            String e11 = e(str);
            if (TextUtils.isEmpty(e11)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(e11);
            jSONObject.put("current_time", System.currentTimeMillis());
            h(str, jSONObject.toString());
        } catch (Throwable th2) {
            o0.b(f37374a, th2.getMessage());
        }
    }

    public void h(String str, String str2) {
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str, str2);
        f37376c = g.C(str2);
        if (f37376c != null) {
            f37376c.K0();
        }
        i.a(f37376c);
        e0.a().a(f37376c.Q());
    }

    public void i(String str, String str2) {
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("ivreward_" + str, str2);
    }

    public void j(String str, String str2) {
        try {
            String a11 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str + "_" + str2);
            if (TextUtils.isEmpty(a11)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a11);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th2) {
            o0.b(f37374a, th2.getMessage());
        }
    }
}
