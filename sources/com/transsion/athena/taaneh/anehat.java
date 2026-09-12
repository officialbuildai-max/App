package com.transsion.athena.taaneh;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.transsion.sdk.oneid.OneID;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k4.a;
import k4.b;

/* loaded from: classes5.dex */
public class anehat {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f42853a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f42854b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f42855c = true;

    /* renamed from: d, reason: collision with root package name */
    private static long f42856d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f42857e = 0;

    public static int a(long j11) {
        if (j11 > 999) {
            return Integer.parseInt(String.valueOf(j11).substring(0, 4));
        }
        return 0;
    }

    @NonNull
    public static String a() {
        return f42853a == null ? "" : f42853a;
    }

    public static String a(int i11) {
        StringBuilder sb2;
        String str;
        if (i11 > 10) {
            sb2 = new StringBuilder();
            str = "";
        } else {
            sb2 = new StringBuilder();
            str = "0";
        }
        sb2.append(str);
        sb2.append(i11);
        return sb2.toString();
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f42853a)) {
            try {
                f42853a = athena.a(context).a();
                if (!TextUtils.isEmpty(f42853a)) {
                    a a11 = a.a(context);
                    if (!TextUtils.equals(f42853a, a11.i("athena_id"))) {
                        a11.g("athena_id", f42853a);
                    }
                }
            } catch (Exception e11) {
                aethna.b(e11.getMessage());
            }
            if (TextUtils.isEmpty(f42853a)) {
                f42853a = a.a(context).i("athena_id");
            }
        }
        return f42853a;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.e("Athena", "------------------------------------------------------------");
        Log.e("Athena", "");
        Log.e("Athena", str);
        Log.e("Athena", "");
        Log.e("Athena", "------------------------------------------------------------");
    }

    public static boolean a(Context context, String str) {
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                String[] strArr = packageInfo.requestedPermissions;
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null && applicationInfo.uid == 1000 && strArr != null) {
                    for (String str2 : strArr) {
                        if (TextUtils.equals(str2, str)) {
                            return true;
                        }
                    }
                    return false;
                }
            } catch (Exception e11) {
                aethna.b(e11.getMessage());
            }
        }
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e12) {
            aethna.b(e12.getMessage());
            return false;
        }
    }

    public static String b(Context context, String str) {
        Map<String, String> map = f42854b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        try {
            if (!OneID.f()) {
                return "";
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = f42856d;
            if (j11 != 0 && elapsedRealtime - j11 < 600000) {
                return "";
            }
            String a11 = b.b(context).a(str);
            if (TextUtils.isEmpty(a11)) {
                f42856d = elapsedRealtime;
                return "";
            }
            map.put(str, a11);
            f42856d = 0L;
            return a11;
        } catch (Exception e11) {
            aethna.b(e11.getMessage());
            return "";
        }
    }

    public static void b(String str) {
        f42853a = str;
    }

    public static boolean b() {
        return com.transsion.athena.config.data.model.ehanat.q() || com.transsion.athena.config.data.model.ehanat.v();
    }

    public static boolean b(long j11) {
        return j11 > 999 && j11 <= 9999;
    }

    public static boolean b(Context context) {
        try {
            if (f42855c) {
                if (TextUtils.isEmpty(a.a(context).i("first_launch"))) {
                    if (new File(context.getFilesDir() + File.separator + com.transsion.athena.config.data.model.ehanat.f42663j, "global.cfg").exists()) {
                        f42855c = false;
                    }
                } else {
                    f42855c = false;
                }
            }
        } catch (Exception e11) {
            aethna.b(Log.getStackTraceString(e11));
        }
        return f42855c;
    }

    public static boolean c(Context context) {
        try {
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo("com.hoffnung", 8).providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if ("com.transsion.dataservice.provider".equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (Exception e11) {
            aethna.b(Log.getStackTraceString(e11));
        }
        return false;
    }
}
