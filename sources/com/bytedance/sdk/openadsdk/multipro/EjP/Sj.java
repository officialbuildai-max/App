package com.bytedance.sdk.openadsdk.multipro.EjP;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.vS;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.uA;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class Sj {
    public static HashSet<String> Sj = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.multipro.EjP.Sj.1
        {
            add("app_id");
            add("tt_gdpr");
            add("keywords");
            add("extra_data");
            add("sdk_app_sha1");
            add("uuid");
            add("android_system_ua");
            add("sdk_local_web_ua");
            add("sdk_local_rom_info");
        }
    };

    private static String EjP() {
        return com.bytedance.sdk.openadsdk.multipro.EjP.sP + "/t_sp/";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float Sj(Context context, String str, String str2, float f11) {
        String Sj2 = Sj(str, str2);
        if (uA.Jcg(Sj2)) {
            return com.bytedance.sdk.component.Sj.Sj(context, Sj2).Sj(str2, f11);
        }
        SharedPreferences Sj3 = sP.Sj(context, Sj2);
        return Sj3 == null ? f11 : Sj3.getFloat(str2, f11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int Sj(Context context, String str, String str2, int i11) {
        String Sj2 = Sj(str, str2);
        if (uA.Jcg(Sj2)) {
            return com.bytedance.sdk.component.Sj.Sj(context, Sj2).Sj(str2, i11);
        }
        SharedPreferences Sj3 = sP.Sj(context, Sj2);
        return Sj3 == null ? i11 : Sj3.getInt(str2, i11);
    }

    public static int Sj(String str, String str2, int i11) {
        if (!Sj()) {
            return i11;
        }
        if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            return Sj(TKC(), str, str2, i11);
        }
        vS sP = sP();
        if (sP != null) {
            String Sj2 = sP.Sj(Uri.parse(EjP() + "int/" + str2 + sP(str)));
            if (Sj2 != null && !Sj2.equals("null")) {
                return Integer.parseInt(Sj2);
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long Sj(Context context, String str, String str2, long j11) {
        String Sj2 = Sj(str, str2);
        if (uA.Jcg(Sj2)) {
            return com.bytedance.sdk.component.Sj.Sj(context, Sj2).Sj(str2, j11);
        }
        SharedPreferences Sj3 = sP.Sj(context, Sj2);
        return Sj3 == null ? j11 : Sj3.getLong(str2, j11);
    }

    public static long Sj(String str, String str2, long j11) {
        if (!Sj()) {
            return j11;
        }
        if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            return Sj(TKC(), str, str2, j11);
        }
        vS sP = sP();
        if (sP != null) {
            String Sj2 = sP.Sj(Uri.parse(EjP() + "long/" + str2 + sP(str)));
            if (Sj2 != null && !Sj2.equals("null")) {
                return Long.parseLong(Sj2);
            }
        }
        return j11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String Sj(Context context, String str, String str2, String str3) {
        String Sj2 = Sj(str, str2);
        if (uA.Jcg(Sj2)) {
            return com.bytedance.sdk.component.Sj.Sj(context, Sj2).Sj(str2, str3);
        }
        SharedPreferences Sj3 = sP.Sj(context, Sj2);
        return Sj3 == null ? str3 : Sj3.getString(str2, str3);
    }

    public static String Sj(String str, String str2) {
        return Sj.contains(str2) ? "pag_sp_bad_par" : str;
    }

    public static void Sj(String str) {
        if (Sj()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
                    sP.sP(TKC(), str);
                    return;
                }
                vS sP = sP();
                if (sP != null) {
                    sP.Sj(Uri.parse(EjP() + "clean" + sP(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void Sj(String str, String str2, Boolean bool) {
        synchronized (Sj.class) {
            if (Sj()) {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
                        sP.Sj(TKC(), str, str2, bool);
                        return;
                    }
                    vS sP = sP();
                    if (sP != null) {
                        Uri parse = Uri.parse(EjP() + "boolean/" + str2 + sP(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, bool);
                        sP.Sj(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void Sj(String str, String str2, Integer num) {
        synchronized (Sj.class) {
            if (Sj()) {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
                        sP.Sj(TKC(), str, str2, num);
                        return;
                    }
                    vS sP = sP();
                    if (sP != null) {
                        Uri parse = Uri.parse(EjP() + "int/" + str2 + sP(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, num);
                        sP.Sj(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void Sj(String str, String str2, Long l11) {
        synchronized (Sj.class) {
            if (Sj()) {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
                        sP.Sj(TKC(), str, str2, l11);
                        return;
                    }
                    vS sP = sP();
                    if (sP != null) {
                        Uri parse = Uri.parse(EjP() + "long/" + str2 + sP(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, l11);
                        sP.Sj(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void Sj(String str, String str2, String str3) {
        synchronized (Sj.class) {
            if (Sj()) {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
                        sP.Sj(TKC(), str, str2, str3);
                        return;
                    }
                    vS sP = sP();
                    if (sP != null) {
                        Uri parse = Uri.parse(EjP() + "string/" + str2 + sP(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str3);
                        sP.Sj(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static boolean Sj() {
        return dNu.Sj() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean Sj(Context context, String str, String str2, boolean z10) {
        String Sj2 = Sj(str, str2);
        if (uA.Jcg(Sj2)) {
            return com.bytedance.sdk.component.Sj.Sj(context, Sj2).Sj(str2, z10);
        }
        SharedPreferences Sj3 = sP.Sj(context, Sj2);
        return Sj3 == null ? z10 : Sj3.getBoolean(str2, z10);
    }

    public static boolean Sj(String str, String str2, boolean z10) {
        if (!Sj()) {
            return z10;
        }
        if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            return Sj(TKC(), str, str2, z10);
        }
        vS sP = sP();
        if (sP != null) {
            String Sj2 = sP.Sj(Uri.parse(EjP() + "boolean/" + str2 + sP(str)));
            if (Sj2 != null && !Sj2.equals("null")) {
                return Boolean.parseBoolean(Sj2);
            }
        }
        return z10;
    }

    private static Context TKC() {
        return dNu.Sj();
    }

    private static vS sP() {
        try {
            if (Sj()) {
                return com.bytedance.sdk.openadsdk.multipro.Sj.Sj.Sj(dNu.Sj());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String sP(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    public static String sP(String str, String str2, String str3) {
        if (!Sj()) {
            return str3;
        }
        if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
            return Sj(TKC(), str, str2, str3);
        }
        vS sP = sP();
        if (sP != null) {
            String Sj2 = sP.Sj(Uri.parse(EjP() + "string/" + str2 + sP(str)));
            if (Sj2 != null && !Sj2.equals("null")) {
                return Sj2;
            }
        }
        return str3;
    }

    public static void sP(String str, String str2) {
        if (Sj()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.sP.TKC()) {
                    sP.sP(TKC(), str, str2);
                    return;
                }
                vS sP = sP();
                if (sP != null) {
                    sP.Sj(Uri.parse(EjP() + "long/" + str2 + sP(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
