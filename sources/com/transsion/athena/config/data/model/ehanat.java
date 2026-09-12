package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import be.g;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.transsion.ga.AthenaAnalytics;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import k4.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ehanat {
    private static String A = "";
    private static boolean B = false;
    public static boolean C = false;
    public static boolean D = false;
    public static boolean E = false;
    public static boolean F = false;
    public static boolean G = true;
    public static boolean H = true;
    public static boolean I = true;
    public static boolean J = true;
    public static boolean K = false;
    private static JSONObject L = new JSONObject();
    private static JSONObject M = new JSONObject();
    private static JSONObject N = new JSONObject();
    private static JSONObject O = new JSONObject();
    private static JSONObject P = new JSONObject();
    private static final ArrayMap<Integer, String> Q = new ArrayMap<>();
    public static boolean R = true;

    /* renamed from: a, reason: collision with root package name */
    private static String f42654a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f42655b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f42656c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f42657d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f42658e = null;

    /* renamed from: f, reason: collision with root package name */
    private static String f42659f = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f42660g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f42661h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f42662i = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f42663j = null;

    /* renamed from: k, reason: collision with root package name */
    public static String f42664k = null;

    /* renamed from: l, reason: collision with root package name */
    public static String f42665l = null;

    /* renamed from: m, reason: collision with root package name */
    public static byte[] f42666m = null;

    /* renamed from: n, reason: collision with root package name */
    public static byte[] f42667n = null;

    /* renamed from: o, reason: collision with root package name */
    public static byte[] f42668o = null;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f42669p = false;

    /* renamed from: q, reason: collision with root package name */
    private static String f42670q = "online";

    /* renamed from: r, reason: collision with root package name */
    private static long f42671r = 30000;

    /* renamed from: s, reason: collision with root package name */
    private static String f42672s = "";

    /* renamed from: t, reason: collision with root package name */
    private static String f42673t = "";

    /* renamed from: u, reason: collision with root package name */
    private static boolean f42674u = true;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f42675v = true;

    /* renamed from: w, reason: collision with root package name */
    private static boolean f42676w = false;

    /* renamed from: x, reason: collision with root package name */
    private static int f42677x = 10485760;

    /* renamed from: y, reason: collision with root package name */
    private static int f42678y;

    /* renamed from: z, reason: collision with root package name */
    private static short f42679z;

    public static String a(int i11) {
        ArrayMap<Integer, String> arrayMap = Q;
        return arrayMap.containsKey(Integer.valueOf(i11)) ? arrayMap.get(Integer.valueOf(i11)) : "";
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return a(false) + f42659f;
        }
        return str + f42659f;
    }

    @NonNull
    public static String a(boolean z10) {
        char c11;
        String str = f42670q;
        int hashCode = str.hashCode();
        if (hashCode == -1012222381) {
            if (str.equals("online")) {
                c11 = 2;
            }
            c11 = 65535;
        } else if (hashCode != 99349) {
            if (hashCode == 3556498 && str.equals(OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_TEST)) {
                c11 = 1;
            }
            c11 = 65535;
        } else {
            if (str.equals("dev")) {
                c11 = 0;
            }
            c11 = 65535;
        }
        String str2 = c11 != 0 ? c11 != 1 ? z10 ? f42657d : f42658e : z10 ? f42655b : f42656c : f42654a;
        try {
            if (anehat.a(AthenaAnalytics.J(), "debug.athena.test_mode", false).booleanValue()) {
                str2 = z10 ? f42655b : f42656c;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return "https://" + str2;
    }

    public static void a() {
        f42676w = true;
    }

    public static void a(int i11, String str) {
        Q.put(Integer.valueOf(i11), str);
    }

    public static void a(long j11) {
        if (j11 < 30000) {
            j11 = 30000;
        }
        f42671r = j11;
    }

    public static void a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(obj)) {
                M.put(str, obj);
            }
        } catch (JSONException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    public static void a(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(f42672s) || z10) {
            f42672s = str;
        }
    }

    public static void a(short s11, String str) {
        f42679z = s11;
        A = str;
    }

    private static boolean a(Object obj) {
        int length = obj.toString().getBytes(StandardCharsets.UTF_8).length;
        if (length <= 2000) {
            return true;
        }
        com.transsion.athena.taaneh.aethna.b(String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length)));
        return false;
    }

    public static String b() {
        return A;
    }

    public static String b(String str) {
        return str + f42662i;
    }

    public static void b(int i11) {
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 > 200) {
            i11 = 200;
        }
        f42678y = i11;
    }

    public static void b(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(obj)) {
                P.put(str, obj);
            }
        } catch (JSONException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    public static void b(boolean z10) {
        f42675v = z10;
    }

    public static short c() {
        return f42679z;
    }

    public static void c(int i11) {
        if (i11 < 2097152) {
            f42677x = 2097152;
        }
        f42677x = i11;
    }

    public static void c(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        f42654a = jSONObject.getString("d");
        f42655b = jSONObject.getString("tu");
        f42656c = jSONObject.getString("tc");
        f42657d = jSONObject.getString("ou");
        f42658e = jSONObject.getString("oc");
        f42659f = jSONObject.getString("c").replace("v6", "v7");
        f42660g = jSONObject.getString(g.f16474b) + "v2";
        String string = jSONObject.getString(TmcStartParams.KEY_URL_SHORT);
        f42661h = string;
        f42662i = string.replace("v2", "v3");
        f42663j = jSONObject.getString("fc");
        f42664k = jSONObject.getString("fd");
        f42665l = jSONObject.getString("fe");
        f42667n = jSONObject.getString("w").getBytes();
        f42668o = jSONObject.getString("iv").getBytes();
        a a11 = a.a(AthenaAnalytics.J());
        try {
            if (a11.e("athena_def") != 0) {
                f42666m = f42667n;
                return;
            }
            String h11 = a11.h("athena_ea");
            if (TextUtils.isEmpty(h11)) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                h11 = anehat.c(keyGenerator.generateKey().getEncoded());
                a11.c("athena_ea", h11);
            }
            f42666m = anehat.a(h11);
        } catch (Exception unused) {
            a11.b("athena_def", 1);
            f42666m = f42667n;
        }
    }

    public static void c(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(obj)) {
                O.put(str, obj);
            }
        } catch (JSONException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    public static void c(boolean z10) {
        f42669p = z10;
    }

    public static JSONObject d() {
        return M;
    }

    public static void d(String str) {
        f42673t = str;
    }

    public static synchronized void d(String str, Object obj) {
        synchronized (ehanat.class) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (a(obj)) {
                        L.put(str, obj);
                    }
                } catch (JSONException e11) {
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                }
            }
        }
    }

    public static void d(boolean z10) {
        com.transsion.athena.taaneh.aethna.c("setEnable isEnable = " + z10);
        f42674u = z10;
    }

    public static JSONObject e() {
        return P;
    }

    public static void e(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(obj)) {
                N.put(str, obj);
            }
        } catch (JSONException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    public static void e(boolean z10) {
        B = z10;
    }

    public static JSONObject f() {
        return O;
    }

    public static void f(boolean z10) {
        f42670q = z10 ? OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_TEST : "online";
    }

    public static String g() {
        return f42672s;
    }

    public static synchronized JSONObject h() {
        JSONObject jSONObject;
        synchronized (ehanat.class) {
            jSONObject = L;
        }
        return jSONObject;
    }

    public static String i() {
        return a(false) + f42660g;
    }

    public static int j() {
        return f42678y;
    }

    public static int k() {
        return f42677x;
    }

    public static JSONObject l() {
        return N;
    }

    public static String m() {
        return f42673t;
    }

    public static long n() {
        return f42671r;
    }

    public static String o() {
        return a(true) + f42662i;
    }

    public static boolean p() {
        return f42675v;
    }

    public static boolean q() {
        return f42669p;
    }

    public static boolean r() {
        return f42674u;
    }

    public static boolean s() {
        return B;
    }

    public static boolean t() {
        return TextUtils.equals(f42670q, "online");
    }

    public static boolean u() {
        return f42676w;
    }

    public static boolean v() {
        return TextUtils.equals(f42670q, OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_TEST);
    }
}
