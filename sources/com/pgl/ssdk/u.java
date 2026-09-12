package com.pgl.ssdk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes5.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static String f40265a;

    /* renamed from: b, reason: collision with root package name */
    private static long[][] f40266b;

    /* renamed from: c, reason: collision with root package name */
    private static String f40267c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(u.f40267c)) {
                String unused = u.f40267c = u.b();
                u0.b(x.b(), "romtype", u.f40267c);
            }
        }
    }

    public static String a(Context context) {
        String str = f40265a;
        if (str != null) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            f40265a = Settings.Global.getString(context.getContentResolver(), "boot_count");
        } else {
            f40265a = "lowapi";
        }
        return f40265a;
    }

    static /* synthetic */ String b() {
        return d();
    }

    public static boolean b(Context context) {
        Object meta = com.pgl.ssdk.ces.a.meta(156, context, null);
        if (meta instanceof Boolean) {
            return ((Boolean) meta).booleanValue();
        }
        return false;
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(f40267c)) {
            return f40267c;
        }
        String a11 = u0.a(x.b(), "romtype", (String) null);
        f40267c = a11;
        if (!TextUtils.isEmpty(a11)) {
            return f40267c;
        }
        o0.b(new a());
        return "";
    }

    private static boolean c(String str) {
        try {
            return new File(str).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONArray[] c(Context context) {
        if (f40266b == null) {
            f40266b = (long[][]) com.pgl.ssdk.ces.a.meta(157, context, null);
        }
        long[][] jArr = f40266b;
        if (jArr == null || jArr.length != 2) {
            f40266b = null;
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long[][] jArr2 = f40266b;
        long[] jArr3 = jArr2[0];
        long[] jArr4 = jArr2[1];
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < jArr3.length; i11++) {
            try {
                jSONArray.put(i11, currentTimeMillis - jArr3[i11]);
                jSONArray2.put(i11, currentTimeMillis - jArr4[i11]);
            } catch (JSONException unused) {
            }
        }
        return new JSONArray[]{jSONArray, jSONArray2};
    }

    private static String d() {
        return (b("com.samsung.android.knox.SemPersonaManager") || b("com.samsung.android.knoxguard.KnoxGuardManager")) ? "samsung" : (b("androidhnext.Manifest") || b("androidhnext.R")) ? "honor" : (b("androidhwext.Manifest") || b("androidhwext.R")) ? "huawei" : (b("oppo.Manifest") || b("oppo.R") || b("oplus.Manifest") || b("oplus.R") || b("com.oneplus.Manifest") || b("com.oneplus.R")) ? "oppo" : (b("vivo.Manifest") || b("vivo.R")) ? "vivo" : (b("miui.Manifest") || b("miui.R") || b("miui.os.Build")) ? "xiaomi" : (b("lineageos.platform.Manifest") || b("lineageos.platform.R")) ? "lineage" : c("/system/framework/com.motorola.motosignature.jar") ? "moto" : (c("/system/framework/transsion-framework.jar") || c("/system/framework/transsion-services.jar")) ? "transsion" : OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER;
    }

    public static boolean d(Context context) {
        Object meta = com.pgl.ssdk.ces.a.meta(155, context, null);
        if (meta instanceof Boolean) {
            return ((Boolean) meta).booleanValue();
        }
        return false;
    }

    public static int e() {
        return ((Integer) com.pgl.ssdk.ces.a.meta(162, null, null)).intValue();
    }
}
