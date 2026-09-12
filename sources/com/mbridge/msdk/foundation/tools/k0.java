package com.mbridge.msdk.foundation.tools;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.reflect.Constructor;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class k0 extends t {
    private static int A = 0;
    private static String B = "";
    private static Object C = null;
    private static int D = 0;
    private static int E = 0;
    private static long F = -1;
    private static long G = -1;
    private static String H = "";
    private static String I = "";

    /* renamed from: j, reason: collision with root package name */
    private static String f35802j = "";

    /* renamed from: k, reason: collision with root package name */
    private static String f35803k = "";

    /* renamed from: l, reason: collision with root package name */
    private static int f35804l = -1;

    /* renamed from: m, reason: collision with root package name */
    private static String f35805m = "";

    /* renamed from: n, reason: collision with root package name */
    private static int f35806n = -1;

    /* renamed from: o, reason: collision with root package name */
    private static int f35807o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static String f35808p = "";

    /* renamed from: q, reason: collision with root package name */
    private static int f35809q = -1;

    /* renamed from: r, reason: collision with root package name */
    private static String f35810r = "";

    /* renamed from: s, reason: collision with root package name */
    private static String f35811s = "";

    /* renamed from: t, reason: collision with root package name */
    private static volatile int f35812t = -1;

    /* renamed from: u, reason: collision with root package name */
    private static String f35813u = "";

    /* renamed from: v, reason: collision with root package name */
    private static String f35814v = "";

    /* renamed from: w, reason: collision with root package name */
    private static int f35815w = 0;

    /* renamed from: x, reason: collision with root package name */
    private static String f35816x = "";

    /* renamed from: y, reason: collision with root package name */
    private static String f35817y = "";

    /* renamed from: z, reason: collision with root package name */
    private static int f35818z = -1;

    /* loaded from: classes5.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35819a;

        a(Context context) {
            this.f35819a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.tools.f.c(this.f35819a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35820a;

        b(Context context) {
            this.f35820a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                str = WebSettings.getDefaultUserAgent(this.f35820a);
            } catch (Throwable unused) {
                str = null;
            }
            try {
                if (TextUtils.isEmpty(str) || str.equals(k0.f35817y)) {
                    return;
                }
                String unused2 = k0.f35817y = str;
                k0.G(this.f35820a);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35821a;

        c(Context context) {
            this.f35821a = context;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"MissingPermission"})
        public void run() {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f35821a.getSystemService("connectivity");
                if (connectivityManager != null && com.mbridge.msdk.foundation.same.a.f35408z) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        int unused = k0.f35812t = 0;
                        return;
                    }
                    if (activeNetworkInfo.getType() == 1) {
                        int unused2 = k0.f35812t = 9;
                        return;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) this.f35821a.getSystemService("phone");
                    if (telephonyManager == null) {
                        int unused3 = k0.f35812t = 0;
                    } else {
                        int unused4 = k0.f35812t = k0.c(telephonyManager.getNetworkType());
                    }
                }
            } catch (Exception unused5) {
                int unused6 = k0.f35812t = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = k0.f35816x = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.util.c.a();
            } catch (Exception e11) {
                o0.b("SameDiTool", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (d11 != null) {
                ActivityManager activityManager = (ActivityManager) d11.getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long unused = k0.G = memoryInfo.totalMem;
                long unused2 = k0.F = memoryInfo.availMem;
            }
        }
    }

    public static int A() {
        return f35818z;
    }

    public static int A(Context context) {
        if (context == null) {
            return A;
        }
        int i11 = A;
        if (i11 != 0) {
            return i11;
        }
        try {
            int i12 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            A = i12;
            return i12;
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    public static int B() {
        if (D == 0) {
            D = t0.e();
        }
        return D;
    }

    public static String B(Context context) {
        if (context == null) {
            return B;
        }
        try {
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            B = str;
            return str;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static int C() {
        return f35809q;
    }

    public static void C(Context context) {
        try {
            t.e(context);
            o();
            q();
            t(context);
            B(context);
            A(context);
            F(context);
            n();
            s();
            p(context);
            w();
            com.mbridge.msdk.foundation.same.a.B = false;
            com.mbridge.msdk.foundation.same.a.f35408z = t0.b("android.permission.ACCESS_NETWORK_STATE", context);
            w(context);
            l();
            com.mbridge.msdk.foundation.tools.f.b();
            g();
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage());
        }
    }

    public static int D() {
        if (f35806n == -1) {
            f35806n = t0.g() ? 1 : 0;
        }
        return f35806n;
    }

    public static int D(Context context) {
        if (f35804l == -1) {
            f35804l = t0.c(context, "com.tencent.mm") ? 1 : 0;
        }
        return f35804l;
    }

    private static void E() {
        String str = Build.VERSION.RELEASE;
        String n11 = n();
        String str2 = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(n11)) {
            f35817y = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Mozilla/5.0 (Linux; Android ");
        sb2.append(str);
        sb2.append("; ");
        sb2.append(n11);
        sb2.append(" Build/");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append(") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
        f35817y = sb2.toString();
    }

    public static boolean E(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int F(Context context) {
        Configuration configuration;
        return (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Context context) {
        try {
            w0.b(context, "mbridge_ua", f35817y);
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage(), th2);
        }
    }

    public static String a(Context context, int i11) {
        TelephonyManager telephonyManager;
        if (i11 == 0 || i11 == 9) {
            return "";
        }
        try {
            return (!com.mbridge.msdk.foundation.same.a.f35408z || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage(), th2);
            return "";
        }
    }

    public static String a(String str, Context context) {
        try {
        } catch (Exception e11) {
            o0.b("SameDiTool", e11.getMessage(), e11);
        }
        if (!TextUtils.isEmpty(f35802j)) {
            return f35802j;
        }
        if (!TextUtils.isEmpty(str) && context != null) {
            f35802j = context.getPackageManager().getInstallerPackageName(str);
            o0.a("SameDiTool", "PKGSource:" + f35802j);
        }
        return f35802j;
    }

    public static int c(int i11) {
        switch (i11) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    public static Object d(String str) {
        if (C == null) {
            C = t0.g(str);
        }
        return C;
    }

    public static void d(int i11) {
        f35809q = i11;
    }

    public static int e(String str) {
        if (E == 0) {
            E = t0.f(str);
        }
        return E;
    }

    public static void g() {
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new e());
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage());
        }
    }

    public static void g(Context context) {
        try {
            c cVar = new c(context);
            if (com.mbridge.msdk.foundation.same.threadpool.a.d().getActiveCount() < 1) {
                com.mbridge.msdk.foundation.same.threadpool.a.d().execute(cVar);
            }
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage());
        }
    }

    public static int h() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return 0;
            }
            long j11 = F;
            if (j11 > 0) {
                return Long.valueOf((j11 / 1000) / 1000).intValue();
            }
            return -1;
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage(), th2);
            return -1;
        }
    }

    public static void h(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.mbridge.msdk.foundation.tools.f.c(context);
            } else {
                new Handler(context.getMainLooper()).post(new a(context));
            }
        } catch (Exception e11) {
            o0.b("SameDiTool", "", e11);
        }
    }

    public static String i() {
        if (TextUtils.isEmpty(f35817y)) {
            l(com.mbridge.msdk.foundation.controller.c.m().d());
        }
        return f35817y;
    }

    private static void i(Context context) {
        if (TextUtils.isEmpty(f35817y)) {
            try {
                f35817y = w0.a(context, "mbridge_ua", "").toString();
            } catch (Throwable th2) {
                o0.b("SameDiTool", th2.getMessage(), th2);
            }
        }
    }

    public static String j() {
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA);
        return "";
    }

    public static String j(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f35803k = "";
            } else if (TextUtils.isEmpty(f35803k)) {
                f35803k = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            f35803k = "";
        }
        return f35803k;
    }

    public static String k(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER) || context == null) {
                return TmcConstants.COLD_OPEN_TYPE;
            }
            AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            String format = new DecimalFormat("0.0").format((audioManager != null ? audioManager.getStreamVolume(3) : -1) / (audioManager != null ? audioManager.getStreamMaxVolume(3) : -1));
            return TextUtils.isEmpty(format) ? TmcConstants.COLD_OPEN_TYPE : format;
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage());
            return TmcConstants.COLD_OPEN_TYPE;
        }
    }

    public static void k() {
        try {
            Object a11 = w0.a(com.mbridge.msdk.foundation.controller.c.m().d(), MBridgeConstans.SP_GA_ID, "");
            Object a12 = w0.a(com.mbridge.msdk.foundation.controller.c.m().d(), MBridgeConstans.SP_GA_ID_LIMIT, 0);
            if (a11 instanceof String) {
                String str = (String) a11;
                if (!TextUtils.isEmpty(str)) {
                    com.mbridge.msdk.foundation.tools.f.a(str);
                }
                if (a12 instanceof Integer) {
                    com.mbridge.msdk.foundation.tools.f.a(((Integer) a12).intValue());
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("SameDiTool", e11.getMessage());
            }
        }
    }

    public static String l() {
        String str;
        if (!TextUtils.isEmpty(f35805m)) {
            return f35805m;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", null).invoke(cls, null);
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage());
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str) || !str.equals("harmony")) {
                f35805m = "android";
            } else {
                jSONObject.put("osType", str);
                try {
                    Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
                    jSONObject.put("version", (String) cls2.getMethod("getVersion", null).invoke(cls2, null));
                } catch (Throwable th3) {
                    o0.b("SameDiTool", th3.getMessage());
                }
                try {
                    jSONObject.put("pure_state", Settings.Secure.getInt(com.mbridge.msdk.foundation.controller.c.m().d().getContentResolver(), "pure_mode_state", -1));
                } catch (Throwable th4) {
                    o0.b("SameDiTool", th4.getMessage());
                }
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    jSONObject2 = i0.b(jSONObject2);
                }
                f35805m = jSONObject2;
            }
        } catch (Throwable th5) {
            o0.b("SameDiTool", th5.getMessage());
        }
        return f35805m;
    }

    public static String l(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return null;
        }
        i(context);
        try {
            if (Looper.myLooper() != Looper.getMainLooper() || MBridgeConstans.DNT_GUA_ON_UI) {
                if (TextUtils.isEmpty(f35817y)) {
                    E();
                }
                z(context);
            } else if (TextUtils.isEmpty(f35817y)) {
                try {
                    f35817y = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(f35817y)) {
                    try {
                        Constructor declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
                        declaredConstructor.setAccessible(true);
                        f35817y = ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                        declaredConstructor.setAccessible(false);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (TextUtils.isEmpty(f35817y)) {
                        try {
                            f35817y = new WebView(context).getSettings().getUserAgentString();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(f35817y)) {
                        E();
                    }
                }
            } else {
                z(context);
            }
        } catch (Throwable th4) {
            o0.b("SameDiTool", th4.getMessage(), th4);
        }
        G(context);
        return f35817y;
    }

    public static int m() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.VERSION.SDK_INT;
        }
        return -1;
    }

    public static int m(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap v11 = v(context);
            return v11.get("height") == null ? displayMetrics.heightPixels : ((Integer) v11.get("height")).intValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static int n(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap v11 = v(context);
            return v11.get("width") == null ? displayMetrics.widthPixels : ((Integer) v11.get("width")).intValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static String n() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MODEL;
    }

    public static float o(Context context) {
        Resources resources;
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER) && context != null && (resources = context.getResources()) != null) {
                return resources.getConfiguration().fontScale;
            }
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage());
        }
        return -1.0f;
    }

    private static void o() {
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new f());
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage());
        }
    }

    public static String p() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MANUFACTURER;
    }

    public static String p(Context context) {
        Locale locale;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(f35808p)) {
            if (context == null) {
                return "en-US";
            }
            try {
                if (context.getResources() == null || context.getResources().getConfiguration() == null || (locale = context.getResources().getConfiguration().locale) == null) {
                    return "en-US";
                }
                String languageTag = locale.toLanguageTag();
                f35808p = languageTag;
                return languageTag;
            } catch (Throwable th2) {
                o0.a("SameDiTool", th2.getMessage());
                f35808p = "en-US";
            }
        }
        return f35808p;
    }

    public static String q() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(f35813u)) {
            f35813u = r() + "";
        }
        return f35813u;
    }

    public static String q(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f35810r = "";
            } else if (TextUtils.isEmpty(f35810r)) {
                if (context == null) {
                    f35810r = "";
                    return "";
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (t0.j(simOperator)) {
                    f35810r = simOperator.substring(0, Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            f35810r = "";
        }
        return f35810r;
    }

    public static int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static String r(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f35811s = "";
            } else if (TextUtils.isEmpty(f35811s)) {
                if (context == null) {
                    f35811s = "";
                    return f35810r;
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (t0.j(simOperator)) {
                    f35811s = simOperator.substring(Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            f35811s = "";
        }
        return f35811s;
    }

    @SuppressLint({"MissingPermission"})
    public static int s(Context context) {
        try {
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) && d11 != null) {
                if (f35812t != -1) {
                    g(d11);
                    return f35812t;
                }
                f35812t = 0;
                return f35812t;
            }
            return f35812t;
        } catch (Exception e11) {
            o0.b("SameDiTool", e11.getMessage(), e11);
            f35812t = 0;
            return f35812t;
        }
    }

    public static String s() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BRAND;
    }

    public static String t() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String t(Context context) {
        if (context == null) {
            return f35814v;
        }
        try {
            if (!TextUtils.isEmpty(f35814v)) {
                return f35814v;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            f35814v = str;
            return str;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static int u(Context context) {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER) && context != null) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode() ? 1 : 0;
            }
            return -1;
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage());
            return -1;
        }
    }

    public static String u() {
        try {
            if (TextUtils.isEmpty(I)) {
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                long a11 = j0.a();
                String j11 = j(d11);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", j11);
                    jSONObject.put("2", String.valueOf(G));
                    jSONObject.put("3", String.valueOf(a11));
                    jSONObject.put("4", "");
                    jSONObject.put("5", "");
                } catch (Exception e11) {
                    o0.b("SameDiTool", e11.getMessage());
                }
                String b11 = com.mbridge.msdk.foundation.tools.a.b(jSONObject.toString());
                I = b11;
                if (b11 == null) {
                    I = "";
                }
            }
        } catch (Exception e12) {
            o0.b("SameDiTool", e12.getMessage());
        }
        return I;
    }

    public static int v() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        long j11 = G;
        if (j11 > 0) {
            return Long.valueOf((j11 / 1000) / 1000).intValue();
        }
        return -1;
    }

    public static HashMap v(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            hashMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e11) {
            o0.b("SameDiTool", e11.getMessage(), e11);
        }
        return hashMap;
    }

    public static int w(Context context) {
        if (context == null) {
            return f35815w;
        }
        if (f35815w == 0) {
            try {
                f35815w = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e11) {
                o0.b("SameDiTool", e11.getMessage());
            }
        }
        return f35815w;
    }

    public static String w() {
        try {
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage(), th2);
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER)) {
            return "";
        }
        if (TextUtils.isEmpty(f35816x)) {
            new Thread(new d()).start();
            return f35816x;
        }
        return f35816x;
    }

    public static String x() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(H)) {
            long j11 = G;
            if (j11 > 0) {
                H = Math.ceil(Float.valueOf(((float) j11) / 1.07374182E9f).doubleValue()) + "GB";
            }
        }
        return H;
    }

    public static String x(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "time_12_24");
        } catch (Exception e11) {
            o0.b("SameDiTool", e11.getMessage(), e11);
            return "";
        } catch (Throwable th2) {
            o0.b("SameDiTool", th2.getMessage(), th2);
            return "";
        }
    }

    public static int y() {
        try {
        } catch (Exception e11) {
            f35807o = 0;
            o0.b("SameDiTool", e11.getMessage());
        }
        if (!q0.a().a("v_a_d_p", false)) {
            return 0;
        }
        if (t0.i()) {
            f35807o = 1;
        } else if (t0.j()) {
            f35807o = 2;
        } else {
            f35807o = 0;
        }
        return f35807o;
    }

    public static String y(Context context) {
        return (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) ? String.valueOf(G) : "";
    }

    public static int z() {
        try {
            if (t0.i()) {
                return 1;
            }
            return t0.j() ? 2 : 0;
        } catch (Exception e11) {
            o0.b("SameDiTool", e11.getMessage());
            return 0;
        }
    }

    private static void z(Context context) {
        try {
            new Thread(new b(context)).start();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
