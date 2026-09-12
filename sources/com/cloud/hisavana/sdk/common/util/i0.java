package com.cloud.hisavana.sdk.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;

/* loaded from: classes3.dex */
public abstract class i0 {
    public static boolean a(AdsDTO adsDTO) {
        if (adsDTO != null && adsDTO.getExt() != null) {
            return adsDTO.getExt().getStoreFlag().intValue() == 1;
        }
        e4.b().d("StoreUtil", "canShowPsMark ads、context、adx.ext is null");
        return false;
    }

    public static PackageInfo b(String str, Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return context.getPackageManager().getPackageInfo(str, 0);
    }

    public static PackageInfo c(Context context) {
        return b(MiniAppIpcConfig.PALM_STORE_PACKAGE_NAME, context);
    }

    private static long d(Context context) {
        long longVersionCode;
        PackageInfo b11 = b(MiniAppIpcConfig.PALM_STORE_PACKAGE_NAME, context);
        if (b11 == null) {
            return -1L;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return b11.versionCode;
        }
        longVersionCode = b11.getLongVersionCode();
        return longVersionCode;
    }

    public static void e(Context context) {
        PackageInfo c11;
        PackageManager packageManager;
        e0 e0Var = e0.f22238a;
        if (e0Var.b() || (c11 = c(context)) == null) {
            return;
        }
        try {
            if (c11.applicationInfo == null || (packageManager = context.getPackageManager()) == null) {
                return;
            }
            String charSequence = c11.applicationInfo.loadLabel(packageManager).toString();
            e0Var.c(charSequence);
            e4.b().d("StoreUtil", "get psAppName from PackageManager:->" + charSequence);
        } catch (Throwable th2) {
            e4.b().e("StoreUtil", "initPsAppCache error: " + th2.getMessage());
        }
    }

    public static boolean f(Context context) {
        long longVersionCode;
        PackageInfo b11 = b(MiniAppIpcConfig.PALM_STORE_PACKAGE_NAME, context);
        if (b11 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return b11.versionCode >= 8403100;
        }
        longVersionCode = b11.getLongVersionCode();
        return longVersionCode >= 8403100;
    }

    public static boolean g(Context context) {
        return d(context) >= 9207201;
    }

    public static boolean h(Context context) {
        return d(context) >= 8403100;
    }
}
