package com.bytedance.sdk.openadsdk.multipro.EjP;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.Sj;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.core.uA;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class sP {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> Sj;

    @Nullable
    public static SharedPreferences Sj(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(Sj(str), 0);
        } catch (Throwable th2) {
            sU.sP("SPMultiHelperImpl", "getSharedPreferences error ", th2.getMessage());
            return null;
        }
    }

    private static Object Sj(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = Sj;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(Sj(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String Sj(Context context, String str, String str2, String str3) {
        Object Sj2 = Sj(str, str2);
        if (Sj2 != null) {
            return String.valueOf(Sj2);
        }
        Object sP = sP(context, str, str2, str3);
        Sj(str, str2, sP);
        return String.valueOf(sP);
    }

    private static String Sj(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized <T> void Sj(Context context, String str, String str2, T t11) {
        synchronized (sP.class) {
            String Sj2 = Sj.Sj(str, str2);
            if (uA.Jcg(Sj2)) {
                com.bytedance.sdk.component.Sj Sj3 = com.bytedance.sdk.component.Sj.Sj(context, Sj2);
                if (t11.equals(Sj(Sj2, str2))) {
                    return;
                }
                Sj.TKC sP = Sj3.sP();
                Sj(sP, str2, (Object) t11);
                sP.apply();
                Sj(Sj2, str2, t11);
                return;
            }
            SharedPreferences Sj4 = Sj(context, Sj2);
            if (Sj4 == null) {
                return;
            }
            if (t11.equals(Sj(Sj2, str2))) {
                return;
            }
            SharedPreferences.Editor edit = Sj4.edit();
            Sj(edit, str2, t11);
            edit.apply();
            Sj(Sj2, str2, t11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void Sj(SharedPreferences.Editor editor, String str, T t11) {
        if (t11 instanceof Integer) {
            editor.putInt(str, ((Integer) t11).intValue());
        }
        if (t11 instanceof Long) {
            editor.putLong(str, ((Long) t11).longValue());
        }
        if (t11 instanceof Float) {
            editor.putFloat(str, ((Float) t11).floatValue());
        }
        if (t11 instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t11).booleanValue());
        }
        if (t11 instanceof String) {
            editor.putString(str, (String) t11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void Sj(Sj.TKC tkc, String str, T t11) {
        if (t11 instanceof Integer) {
            tkc.putInt(str, ((Integer) t11).intValue());
        }
        if (t11 instanceof Long) {
            tkc.putLong(str, ((Long) t11).longValue());
        }
        if (t11 instanceof Float) {
            tkc.putFloat(str, ((Float) t11).floatValue());
        }
        if (t11 instanceof Boolean) {
            tkc.putBoolean(str, ((Boolean) t11).booleanValue());
        }
        if (t11 instanceof String) {
            tkc.putString(str, (String) t11);
        }
    }

    private static void Sj(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = Sj;
        if (softReference == null || softReference.get() == null) {
            Sj = new SoftReference<>(new ConcurrentHashMap());
        }
        String Sj2 = Sj(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = Sj.get();
        if (concurrentHashMap.get(Sj2) == null) {
            concurrentHashMap.put(Sj2, new HashMap());
        }
        concurrentHashMap.get(Sj2).put(str2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Sj(Context context, String str, String str2) {
        String Sj2 = Sj.Sj(str, str2);
        if (uA.Jcg(Sj2)) {
            return com.bytedance.sdk.component.Sj.Sj(context, Sj2).Sj(str2);
        }
        SharedPreferences Sj3 = Sj(context, Sj2);
        return Sj3 != null && Sj3.contains(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, ?> TKC(Context context, String str) {
        SharedPreferences Sj2 = Sj(context, str);
        if (Sj2 == null) {
            return null;
        }
        return Sj2.getAll();
    }

    private static Object sP(Context context, String str, String str2, String str3) {
        String Sj2 = Sj(str);
        if (!Sj(context, Sj2, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return Sj.Sj(context, Sj2, str2, (String) null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(Sj.Sj(context, Sj2, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(Sj.Sj(context, Sj2, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(Sj.Sj(context, Sj2, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(Sj.Sj(context, Sj2, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return Sj.Sj(context, Sj2, str2, (String) null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sP(Context context, String str) {
        if (uA.Jcg(str)) {
            com.bytedance.sdk.component.Sj.Sj(context, str).sP().clear().apply();
            sP(str);
            return;
        }
        SharedPreferences Sj2 = Sj(context, str);
        if (Sj2 == null) {
            return;
        }
        SharedPreferences.Editor edit = Sj2.edit();
        edit.clear();
        edit.apply();
        sP(str);
    }

    public static void sP(Context context, String str, String str2) {
        try {
            String Sj2 = Sj.Sj(str, str2);
            if (uA.Jcg(Sj2)) {
                com.bytedance.sdk.component.Sj.Sj(context, Sj2).sP().remove(str2).apply();
                return;
            }
            SharedPreferences Sj3 = Sj(context, Sj2);
            if (Sj3 == null) {
                return;
            }
            SharedPreferences.Editor edit = Sj3.edit();
            edit.remove(str2);
            edit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = Sj;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            Map<String, Object> map = Sj.get().get(Sj(Sj2));
            if (map != null && map.size() != 0) {
                map.remove(str2);
            }
        } catch (Throwable unused) {
        }
    }

    private static void sP(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = Sj;
        if (softReference == null || softReference.get() == null || (map = Sj.get().get(Sj(str))) == null) {
            return;
        }
        map.clear();
    }
}
