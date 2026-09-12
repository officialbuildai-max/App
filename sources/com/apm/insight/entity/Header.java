package com.apm.insight.entity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.apm.insight.e;
import com.apm.insight.l.k;
import com.apm.insight.l.l;
import com.apm.insight.runtime.o;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniutils.constant.TimeConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class Header {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f19562a = {"version_code", "manifest_version_code", "aid", "update_version_code"};

    /* renamed from: d, reason: collision with root package name */
    private static String f19563d = null;

    /* renamed from: e, reason: collision with root package name */
    private static int f19564e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static int f19565f = -1;

    /* renamed from: b, reason: collision with root package name */
    private Context f19566b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f19567c = new JSONObject();

    public Header(Context context) {
        this.f19566b = context;
    }

    public static Header a(long j11) {
        Header a11;
        o a12 = o.a();
        if (j11 == 0) {
            j11 = System.currentTimeMillis();
        }
        JSONObject a13 = a12.a(j11);
        if (a13 == null || a13.length() == 0) {
            a11 = a(e.g());
            a11.c();
            try {
                a11.f19567c.put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            try {
                if (!a13.has("aid")) {
                    a13.put("aid", 4444);
                }
            } catch (Exception unused2) {
            }
            a11 = new Header(e.g());
        }
        b(a11);
        a11.a(a13);
        return a11;
    }

    public static Header a(Context context) {
        Header header = new Header(context);
        JSONObject jSONObject = header.f19567c;
        try {
            jSONObject.put("sdk_version", 20089);
            jSONObject.put("sdk_version_name", "2008-20250701130429");
        } catch (Exception unused) {
        }
        return header;
    }

    public static Header a(Header header) {
        addRuntimeHeader(header.f19567c);
        return header;
    }

    public static boolean a() {
        if (f19564e == -1) {
            f19564e = g().contains("64") ? 1 : 0;
        }
        return f19564e == 1;
    }

    @Keep
    public static void addOtherHeader(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            if (com.apm.insight.l.d.b()) {
                sb2.append("MIUI-");
            } else if (com.apm.insight.l.d.c()) {
                sb2.append("FLYME-");
            } else {
                String a11 = com.apm.insight.l.d.a();
                if (com.apm.insight.l.d.a(a11)) {
                    sb2.append("EMUI-");
                }
                if (!TextUtils.isEmpty(a11)) {
                    sb2.append(a11);
                    sb2.append("-");
                }
            }
            sb2.append(Build.VERSION.INCREMENTAL);
            if (sb2.length() > 0) {
                jSONObject.put("rom", sb2.toString());
            }
            jSONObject.put("rom_version", l.a());
        } catch (Throwable unused) {
        }
        try {
            DisplayMetrics displayMetrics = e.g().getResources().getDisplayMetrics();
            int i11 = displayMetrics.densityDpi;
            String str = i11 != 120 ? i11 != 240 ? i11 != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i11);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused2) {
        }
        try {
            String language = e.g().getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(TmcConstants.KEY_LANGUAGE, language);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / TimeConstants.HOUR;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("os", "Android");
            jSONObject.put("device_id", e.c().a());
            String str2 = Build.VERSION.RELEASE;
            if (!str2.contains(".")) {
                str2 = str2 + ".0";
            }
            jSONObject.put("os_version", str2);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            String str3 = Build.MODEL;
            String str4 = Build.BRAND;
            if (str3 == null) {
                str3 = str4;
            } else if (str4 != null && !str3.contains(str4)) {
                str3 = str4 + ' ' + str3;
            }
            jSONObject.put("device_model", str3);
            jSONObject.put("device_brand", str4);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", g());
            Context g11 = e.g();
            String packageName = g11.getPackageName();
            jSONObject.put("package", packageName);
            PackageInfo packageInfo = g11.getPackageManager().getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                int i12 = applicationInfo.labelRes;
                if (i12 > 0) {
                    jSONObject.put("display_name", g11.getString(i12));
                } else {
                    jSONObject.put("display_name", g11.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        d.a(jSONObject);
    }

    public static void addRuntimeHeader(JSONObject jSONObject) {
        try {
            jSONObject.put("access", k.a(e.g()));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.g().getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public static Header b(Context context) {
        Header a11 = a(context);
        a(a11);
        b(a11);
        a11.c();
        a11.d();
        a11.e();
        return a11;
    }

    public static void b(Header header) {
        if (header == null) {
            return;
        }
        addOtherHeader(header.f19567c);
    }

    public static boolean b() {
        if (f19565f == -1) {
            f19565f = g().contains("86") ? 1 : 0;
        }
        return f19565f == 1;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject.optInt("unauthentic_version", 0) == 1;
    }

    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return true;
        }
        return (jSONObject.opt("app_version") == null && jSONObject.opt("version_name") == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            String optString = jSONObject.optString("aid");
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            try {
                return Integer.parseInt(optString) <= 0;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private static String g() {
        if (f19563d == null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    int i11 = 0;
                    while (true) {
                        String[] strArr = Build.SUPPORTED_ABIS;
                        if (i11 >= strArr.length) {
                            break;
                        }
                        sb2.append(strArr[i11]);
                        if (i11 != strArr.length - 1) {
                            sb2.append(", ");
                        }
                        i11++;
                    }
                } else {
                    sb2 = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    f19563d = TmcConstants.ROUTE_UNKNOWN;
                }
                f19563d = sb2.toString();
            } catch (Exception e11) {
                com.apm.insight.a.b((Throwable) e11);
                f19563d = TmcConstants.ROUTE_UNKNOWN;
            }
        }
        return f19563d;
    }

    public final JSONObject a(@Nullable Map<String, Object> map) {
        if (map == null) {
            return this.f19567c;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.f19567c.has(entry.getKey())) {
                this.f19567c.put(entry.getKey(), entry.getValue());
            }
        }
        String[] strArr = f19562a;
        for (int i11 = 0; i11 < 4; i11++) {
            String str = strArr[i11];
            if (map.containsKey(str)) {
                try {
                    this.f19567c.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                } catch (Throwable unused) {
                    this.f19567c.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            try {
                this.f19567c.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
            } catch (Throwable unused2) {
            }
        }
        if (map.containsKey("iid")) {
            this.f19567c.put("udid", map.get("iid"));
            this.f19567c.remove("iid");
        }
        if (map.containsKey("version_name")) {
            this.f19567c.put("app_version", map.get("version_name"));
            this.f19567c.remove("version_name");
        }
        return this.f19567c;
    }

    public final JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this.f19567c;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f19567c.put(next, jSONObject.opt(next));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return this.f19567c;
    }

    public final JSONObject c() {
        return a(e.a().a());
    }

    public final JSONObject d() {
        try {
            this.f19567c.put("device_id", e.c().a());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return this.f19567c;
    }

    public final JSONObject e() {
        try {
            long f11 = e.a().f();
            if (f11 > 0) {
                this.f19567c.put("user_id", f11);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return this.f19567c;
    }

    public final JSONObject f() {
        return this.f19567c;
    }
}
