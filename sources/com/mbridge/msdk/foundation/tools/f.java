package com.mbridge.msdk.foundation.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.b;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f35781a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f35782b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f35783c = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f35784d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static String f35785e = "";

    /* renamed from: f, reason: collision with root package name */
    private static boolean f35786f = false;

    /* renamed from: g, reason: collision with root package name */
    private static String f35787g = "";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f35788h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f35789i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35790a;

        a(Context context) {
            this.f35790a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID) && com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f35790a);
                    f.a(advertisingIdInfo.getId());
                    f.f35784d = advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0;
                    f.b(this.f35790a, advertisingIdInfo.getId(), f.f35784d);
                } catch (Exception unused) {
                    o0.d("DomainSameDiTool", "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                    try {
                        b.C0496b a11 = new b().a(this.f35790a);
                        f.a(a11.a());
                        f.f35784d = a11.b() ? 1 : 0;
                        f.b(this.f35790a, a11.a(), f.f35784d);
                    } catch (Exception unused2) {
                        o0.d("DomainSameDiTool", "GET ADID FROM GOOGLE PLAY APP ERROR");
                    }
                } catch (Throwable th2) {
                    o0.b("DomainSameDiTool", th2.getMessage());
                }
            }
        }
    }

    public static int a() {
        return f35784d;
    }

    public static void a(int i11) {
        f35784d = i11;
    }

    public static void a(Context context) {
        new Thread(new a(context)).start();
    }

    public static void a(String str) {
        f35782b = i0.b(str);
        f35781a = str;
    }

    public static String b() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (f35786f) {
            return f35785e;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.c.m().d().getContentResolver();
                int i11 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, i11);
                jSONObject.put("amazonId", string);
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    f35787g = jSONObject2;
                    f35785e = i0.b(jSONObject2);
                }
            } catch (Settings.SettingNotFoundException e11) {
                o0.b("DomainSameDiTool", e11.getMessage());
            }
        } catch (Throwable th2) {
            o0.b("DomainSameDiTool", th2.getMessage());
        }
        f35786f = true;
        return f35785e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, int i11) {
        try {
            if (y0.b(str)) {
                w0.b(context, MBridgeConstans.SP_GA_ID, str);
            }
            w0.b(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i11));
        } catch (Exception e11) {
            o0.b("DomainSameDiTool", e11.getMessage());
        }
    }

    public static boolean b(Context context) {
        try {
        } catch (Exception unused) {
            f35788h = false;
        }
        if (f35789i) {
            return f35788h;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            f35788h = context.getPackageManager().checkPermission(i0.a("DkP3hrKuHoPMH+zwL+fALkK/WQc5x5zH+TcincKNNVfWNVJcVM=="), context.getPackageName()) == 0;
        } else {
            f35788h = true;
        }
        f35789i = true;
        return f35788h;
    }

    public static String c() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            return TextUtils.isEmpty(f35782b) ? "" : f35782b;
        }
        if (!TextUtils.isEmpty(f35782b)) {
            return (com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() || f35784d == 0) ? f35782b : "";
        }
        if (!f35783c) {
            a(com.mbridge.msdk.foundation.controller.c.m().d());
            f35783c = true;
        }
        return "";
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            WebEnvCheckEntry.class.getMethod("check", Context.class).invoke(WebEnvCheckEntry.class.newInstance(), context);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static String d() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            return TextUtils.isEmpty(f35781a) ? "" : f35781a;
        }
        if (!TextUtils.isEmpty(f35781a)) {
            return (com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() || f35784d == 0) ? f35781a : "";
        }
        k0.k();
        if (!f35783c) {
            a(com.mbridge.msdk.foundation.controller.c.m().d());
            f35783c = true;
        }
        return TextUtils.isEmpty(f35781a) ? "" : f35781a;
    }

    public static String e() {
        if (TextUtils.isEmpty(f35787g) && !f35786f) {
            b();
        }
        return f35787g;
    }
}
