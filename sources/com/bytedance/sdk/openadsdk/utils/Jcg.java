package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.compose.animation.core.j0;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Jcg {
    private static final AtomicReference<Boolean> Sj = new AtomicReference<>(null);
    private static final AtomicReference<String> sP = new AtomicReference<>(null);

    private static boolean Dq() {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "persist.sys.muiltdisplay_type", 0)).intValue() == 2;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("BED", "isXiaomiFold return false " + th2.getMessage());
            return false;
        }
    }

    private static boolean Dq(Context context) {
        try {
            Class.forName("com.unity3d.player.UnityPlayerActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libunity.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static int EjP(Context context) {
        try {
            Class.forName("com.google.android.play.core.splitinstall.SplitInstallManager");
            return 1;
        } catch (ClassNotFoundException unused) {
            return 0;
        }
    }

    private static boolean EjP() {
        String lowerCase;
        if (Ym()) {
            return true;
        }
        String[] strArr = {"sm-f9000", "sm-f9160", "sm-f9260", "sm-f9360", "sm-f9460", "sm-f9560", "sm-f7000", "sm-f7070", "sm-f7110", "sm-f7210", "sm-f7310", "sm-f7410"};
        String[] strArr2 = {"winner", "f2q", "q2q", "q4q", "q5q", "q6q", "bloomq", "bloomxq", "b2q", "b4q", "b5q", "b6q"};
        try {
            String lowerCase2 = Build.DEVICE.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase2)) {
                for (int i11 = 0; i11 < 12; i11++) {
                    if (lowerCase2.contains(strArr2[i11])) {
                        return true;
                    }
                }
            }
            lowerCase = Build.MODEL.toLowerCase();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        for (int i12 = 0; i12 < 12; i12++) {
            if (lowerCase.contains(strArr[i12])) {
                return true;
            }
        }
        if (sP()) {
            String Sj2 = com.bytedance.sdk.openadsdk.dx.Sj.Sj("fold_config", "fold_samung", "");
            if (TextUtils.isEmpty(Sj2)) {
                return false;
            }
            for (String str : Sj2.split(",")) {
                if (lowerCase.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String HiB(Context context) {
        try {
            AtomicReference<String> atomicReference = sP;
            String str = atomicReference.get();
            if (str != null) {
                return str;
            }
            PackageInfo vS = vS(context);
            String str2 = vS != null ? vS.versionName : "";
            j0.a(atomicReference, null, str2);
            return str2;
        } catch (Throwable unused) {
            j0.a(sP, null, "");
            return "";
        }
    }

    private static boolean HiB() {
        if (Dq()) {
            return true;
        }
        String[] strArr = {"M2011J18C", "22061218C", "2308CPXD0C", "24072PX77C", "2405CPX3DC", "2405CPX3DG"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i11 = 0; i11 < 6; i11++) {
                    if (lowerCase.contains(strArr[i11])) {
                        return true;
                    }
                }
                if (sP()) {
                    String TKC = TKC();
                    if (TextUtils.isEmpty(TKC)) {
                        return false;
                    }
                    for (String str : TKC.split(",")) {
                        if (lowerCase.contains(str)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean Jcg() {
        try {
            return "foldable".equals(Class.forName("android.util.FtDeviceInfo").getMethod("getDeviceType", null).invoke(null, null));
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("BED", "isVIVOFoldDevice return false " + th2.getMessage());
            return false;
        }
    }

    public static boolean Jcg(Context context) {
        boolean z10;
        boolean z11;
        char c11;
        try {
            AtomicReference<Boolean> atomicReference = Sj;
            Boolean bool = atomicReference.get();
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase();
            }
            String str2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.toLowerCase();
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                j0.a(atomicReference, null, Boolean.FALSE);
                return false;
            }
            char c12 = 65535;
            if (TextUtils.isEmpty(str)) {
                z10 = false;
                z11 = false;
            } else {
                switch (str.hashCode()) {
                    case -759499589:
                        if (str.equals("xiaomi")) {
                            c11 = 2;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 3418016:
                        if (str.equals("oppo")) {
                            c11 = 0;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 3620012:
                        if (str.equals("vivo")) {
                            c11 = 1;
                            break;
                        }
                        c11 = 65535;
                        break;
                    case 1864941562:
                        if (str.equals("samsung")) {
                            c11 = 3;
                            break;
                        }
                        c11 = 65535;
                        break;
                    default:
                        c11 = 65535;
                        break;
                }
                if (c11 == 0) {
                    z10 = uA();
                } else if (c11 == 1) {
                    z10 = vS();
                } else if (c11 == 2) {
                    z10 = HiB();
                } else if (c11 != 3) {
                    z10 = false;
                    z11 = true;
                } else {
                    z10 = EjP();
                }
                z11 = false;
            }
            if (z11 && !TextUtils.isEmpty(str2)) {
                switch (str2.hashCode()) {
                    case -759499589:
                        if (str2.equals("xiaomi")) {
                            c12 = 2;
                            break;
                        }
                        break;
                    case 3418016:
                        if (str2.equals("oppo")) {
                            c12 = 0;
                            break;
                        }
                        break;
                    case 3620012:
                        if (str2.equals("vivo")) {
                            c12 = 1;
                            break;
                        }
                        break;
                    case 1864941562:
                        if (str2.equals("samsung")) {
                            c12 = 3;
                            break;
                        }
                        break;
                }
                z10 = c12 != 0 ? c12 != 1 ? c12 != 2 ? c12 != 3 ? false : EjP() : HiB() : vS() : uA();
            }
            j0.a(atomicReference, null, Boolean.valueOf(z10));
            return z10;
        } catch (Throwable unused) {
            j0.a(Sj, null, Boolean.FALSE);
            return false;
        }
    }

    public static String Sj() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Exception unused) {
            return "";
        }
    }

    public static void Sj(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (sP()) {
                com.bytedance.sdk.openadsdk.core.TKC Sj2 = com.bytedance.sdk.openadsdk.core.TKC.Sj(context);
                Sj2.Sj("w_ver", HiB(context));
                Sj2.Sj("bp", sP(context));
                Sj2.Sj("is_fold", Jcg(context) ? 1 : 0);
                Sj2.Sj("abi", Sj());
                Sj2.Sj("t_ver", TKC(context));
                Sj2.Sj(CampaignEx.JSON_KEY_AAB, EjP(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void Sj(JSONObject jSONObject, Context context) {
        if (context == null) {
            return;
        }
        try {
            if (sP()) {
                com.bytedance.sdk.openadsdk.core.TKC Sj2 = com.bytedance.sdk.openadsdk.core.TKC.Sj(context);
                String sP2 = Sj2.sP("md", com.bytedance.sdk.openadsdk.core.uA.sP().Jcg());
                if (!TextUtils.isEmpty(sP2)) {
                    jSONObject.put("md", sP2);
                }
                int sP3 = Sj2.sP("bp", sP(context));
                if (sP3 != 4) {
                    jSONObject.put("bp", sP3);
                }
                String sP4 = Sj2.sP("t_ver", TKC(context));
                if (!TextUtils.isEmpty(sP4)) {
                    jSONObject.put("t_ver", sP4);
                }
                jSONObject.put("is_fold", Sj2.sP("is_fold", Jcg(context) ? 1 : 0));
                jSONObject.put(CampaignEx.JSON_KEY_AAB, Sj2.sP(CampaignEx.JSON_KEY_AAB, EjP(context)));
                String sP5 = Sj2.sP("w_ver", HiB(context));
                if (!TextUtils.isEmpty(sP5)) {
                    jSONObject.put("w_ver", sP5);
                }
                String sP6 = Sj2.sP("abi", Sj());
                if (TextUtils.isEmpty(sP6)) {
                    return;
                }
                jSONObject.put("abi", sP6);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean TEQ() {
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object invoke = cls.getDeclaredMethod("hasFeature", String.class).invoke(cls.getMethod("getInstance", null).invoke(null, null), "oplus.hardware.type.fold");
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (ClassNotFoundException e11) {
            e = e11;
            com.bytedance.sdk.component.utils.sU.sP("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (IllegalAccessException e12) {
            e = e12;
            com.bytedance.sdk.component.utils.sU.sP("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (NoSuchMethodException e13) {
            e = e13;
            com.bytedance.sdk.component.utils.sU.sP("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (InvocationTargetException e14) {
            e = e14;
            com.bytedance.sdk.component.utils.sU.sP("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean TEQ(Context context) {
        try {
            Class.forName("com.facebook.react.ReactActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libreactnativejni.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static String TKC() {
        return com.bytedance.sdk.openadsdk.dx.Sj.Sj("fold_config", "fold_default", "");
    }

    public static String TKC(Context context) {
        try {
            return String.valueOf(context.getApplicationInfo().targetSdkVersion);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static PackageInfo Ym(Context context) {
        try {
            String str = Build.VERSION.SDK_INT <= 23 ? (String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", null).invoke(null, null) : (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", null).invoke(null, null);
            if (str == null) {
                return null;
            }
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean Ym() {
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            Object invoke = cls.getMethod("getInstance", null).invoke(null, null);
            Method declaredMethod = cls.getDeclaredMethod("getString", String.class);
            if ("TRUE".equalsIgnoreCase((String) declaredMethod.invoke(invoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD"))) {
                return true;
            }
            return "TRUE".equalsIgnoreCase((String) declaredMethod.invoke(invoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FLIP"));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            com.bytedance.sdk.component.utils.sU.sP("PAG_BANNER", "get ss fold device error: " + e11.getMessage());
            return false;
        }
    }

    public static int sP(Context context) {
        if (Dq(context)) {
            return 1;
        }
        if (uA(context)) {
            return 2;
        }
        return TEQ(context) ? 3 : 4;
    }

    public static boolean sP() {
        return com.bytedance.sdk.openadsdk.dx.Sj.Sj("fold_config", OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, 0) == 1;
    }

    private static boolean uA() {
        if (TEQ()) {
            return true;
        }
        String[] strArr = {"CPH2439", "CPH2437", "CPH2499", "CPH2519", "PEUM00", "PGU110", "PGT110", "PHN110", "PHT110"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i11 = 0; i11 < 9; i11++) {
                    if (lowerCase.contains(strArr[i11].toLowerCase())) {
                        return true;
                    }
                }
                if (sP()) {
                    String TKC = TKC();
                    if (TextUtils.isEmpty(TKC)) {
                        return false;
                    }
                    for (String str : TKC.split(",")) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean uA(Context context) {
        try {
            Class.forName("io.flutter.embedding.android.FlutterActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libflutter.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static PackageInfo vS(Context context) {
        PackageInfo currentWebViewPackage;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                currentWebViewPackage = WebView.getCurrentWebViewPackage();
                return currentWebViewPackage;
            }
            PackageInfo packageInfo = (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
            return packageInfo != null ? packageInfo : Ym(context);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean vS() {
        if (Jcg()) {
            return true;
        }
        String[] strArr = {"V2330", "V2178A", "V2229A", "V2303A", "V2337A", "V2256A", "V2266A"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i11 = 0; i11 < 7; i11++) {
                    if (lowerCase.contains(strArr[i11].toLowerCase())) {
                        return true;
                    }
                }
                if (sP()) {
                    String TKC = TKC();
                    if (TextUtils.isEmpty(TKC)) {
                        return false;
                    }
                    for (String str : TKC.split(",")) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
