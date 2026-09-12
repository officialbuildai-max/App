package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.intf.ISDKConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.cloud.tmc.miniutils.util.EncodeUtils;
import com.cloud.tmc.miniutils.util.Utils;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bJ*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bJ*\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u001e"}, d2 = {"Lcom/cloud/tmc/integration/utils/BaseAppPrepareUtils;", "", "()V", "changeTarUnCompressStatus", "", "context", "Landroid/content/Context;", "appId", "", "uniqueIdentificationUrl", NotificationCompat.CATEGORY_STATUS, "", "changeZipDownloadStatus", "changeZipUnCompressStatus", "checkZipDownloadStatus", "checkZipUnCompressStatus", "getCommonHeader", "", "hashMap", "useCommonHeader", "getMcc", "getMnc", "getSimOperator", "isShellType", "appModel", "Lcom/cloud/tmc/integration/model/AppModel;", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "addCommonIntentParameter", "Landroid/content/Intent;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public class BaseAppPrepareUtils {
    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getMcc() {
        /*
            r5 = this;
            java.lang.String r0 = r5.getSimOperator()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = ""
            if (r1 != 0) goto L26
            r1 = 0
            if (r0 == 0) goto L14
            int r3 = r0.length()
            goto L15
        L14:
            r3 = r1
        L15:
            r4 = 3
            if (r3 < r4) goto L26
            if (r0 == 0) goto L24
            java.lang.String r0 = r0.substring(r1, r4)
            java.lang.String r1 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            goto L27
        L24:
            r0 = 0
            goto L27
        L26:
            r0 = r2
        L27:
            if (r0 != 0) goto L2a
            goto L2b
        L2a:
            r2 = r0
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.BaseAppPrepareUtils.getMcc():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getMnc() {
        /*
            r4 = this;
            java.lang.String r0 = r4.getSimOperator()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = ""
            if (r1 != 0) goto L25
            if (r0 == 0) goto L13
            int r1 = r0.length()
            goto L14
        L13:
            r1 = 0
        L14:
            r3 = 3
            if (r1 < r3) goto L25
            if (r0 == 0) goto L23
            java.lang.String r0 = r0.substring(r3)
            java.lang.String r1 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            goto L26
        L23:
            r0 = 0
            goto L26
        L25:
            r0 = r2
        L26:
            if (r0 != 0) goto L29
            goto L2a
        L29:
            r2 = r0
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.BaseAppPrepareUtils.getMnc():java.lang.String");
    }

    private final String getSimOperator() {
        try {
            Object systemService = Utils.getApp().getSystemService("phone");
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public final void addCommonIntentParameter(Intent intent, Context context) {
        Intrinsics.h(intent, "<this>");
        intent.setPackage(context != null ? context.getPackageName() : null);
    }

    public final void changeTarUnCompressStatus(Context context, String appId, String uniqueIdentificationUrl, boolean status) {
        Intrinsics.h(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
        if (appId != null) {
            kVStorageProxy.putBoolean(context, appId, uniqueIdentificationUrl + "_tar", status);
        }
    }

    public final synchronized void changeZipDownloadStatus(Context context, String appId, String uniqueIdentificationUrl, boolean status) {
        Intrinsics.h(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
        if (appId != null) {
            kVStorageProxy.putBoolean(context, appId, uniqueIdentificationUrl + "_download", status);
        }
    }

    public final void changeZipUnCompressStatus(Context context, String appId, String uniqueIdentificationUrl, boolean status) {
        Intrinsics.h(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
        if (appId != null) {
            kVStorageProxy.putBoolean(context, appId, uniqueIdentificationUrl + "_zip", status);
        }
    }

    public final synchronized boolean checkZipDownloadStatus(Context context, String appId, String uniqueIdentificationUrl) {
        boolean z10;
        Intrinsics.h(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
        z10 = false;
        if (appId != null) {
            z10 = kVStorageProxy.getBoolean(context, appId, uniqueIdentificationUrl + "_download", false);
        }
        return z10;
    }

    public final boolean checkZipUnCompressStatus(Context context, String appId, String uniqueIdentificationUrl) {
        Intrinsics.h(context, "context");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
        if (appId == null) {
            return false;
        }
        return kVStorageProxy.getBoolean(context, appId, uniqueIdentificationUrl + "_zip", false);
    }

    public final Map<String, String> getCommonHeader(Map<String, String> hashMap, boolean useCommonHeader) {
        String str;
        String str2 = "0000-0000-0000-0000";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (useCommonHeader) {
            try {
                String country = Locale.getDefault().getCountry();
                Intrinsics.g(country, "getDefault().country");
                linkedHashMap.put("m-country-alpha2", country);
                linkedHashMap.put("m-os", "android");
                String appVersion = ((ISDKConfig) TmcProxy.get(ISDKConfig.class)).getAppVersion();
                String str3 = "";
                if (appVersion == null) {
                    appVersion = "";
                }
                linkedHashMap.put("m-app-ver", appVersion);
                String frameworkVersion = ((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getFrameworkVersion();
                if (frameworkVersion == null) {
                    frameworkVersion = "";
                }
                linkedHashMap.put("m-fw-ver", frameworkVersion);
                String sDKVersion = ((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getSDKVersion();
                if (sDKVersion == null) {
                    sDKVersion = "";
                }
                linkedHashMap.put("m-mnsdk-ver", sDKVersion);
                linkedHashMap.put("m-mcc", getMcc());
                linkedHashMap.put("m-mnc", getMnc());
                String transferNetworkType = NetworkUtil.transferNetworkType(NetworkUtil.getCurrentNetworkType(Utils.getApp(), true));
                Intrinsics.g(transferNetworkType, "transferNetworkType(currentNetworkType)");
                linkedHashMap.put("m-nettype", transferNetworkType);
                String language = Locale.getDefault().getLanguage();
                Intrinsics.g(language, "getDefault().language");
                linkedHashMap.put("m-language", language);
                String str4 = Build.MANUFACTURER;
                String MODEL = Build.MODEL;
                linkedHashMap.put("m-phone-model", str4 + " " + MODEL);
                Intrinsics.g(MODEL, "MODEL");
                linkedHashMap.put("m-device-model", MODEL);
                String urlEncode = EncodeUtils.urlEncode(((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getAppId());
                Intrinsics.g(urlEncode, "urlEncode(TmcProxy.get(I…onfig::class.java).appId)");
                linkedHashMap.put("m-app", urlEncode);
                try {
                    if (!DeviceUtil.INSTANCE.getIsNewUserStatus()) {
                        String vaid = ((ReportProxy) TmcProxy.get(ReportProxy.class)).getVaid();
                        Intrinsics.g(vaid, "{\n                      …aid\n                    }");
                        str2 = vaid;
                    }
                } catch (Throwable th2) {
                    TmcLogger.e("CommonHeader", "just print get vaid failed. errMsg: " + th2.getMessage());
                }
                linkedHashMap.put("m-vaid", str2);
                linkedHashMap.put("m-mini-sdk-mode", AppDynamicBuildConfig.getSDK_BUILD_VARIANT_TYPE());
                try {
                    str = Utils.getApp().getPackageName();
                } catch (Throwable unused) {
                    str = "";
                }
                Intrinsics.g(str, "try {\n                  …     \"\"\n                }");
                linkedHashMap.put("m-app-pkg", str);
                try {
                    str3 = AppDynamicBuildConfig.getSDK_VERSION_NUM();
                } catch (Throwable unused2) {
                }
                linkedHashMap.put("m-mnsdk-num", str3);
            } catch (Throwable th3) {
                TmcLogger.e("CommonHeader", th3);
            }
        }
        if (hashMap != null) {
            for (String str5 : hashMap.keySet()) {
                String str6 = hashMap.get(str5);
                if (str6 != null) {
                    linkedHashMap.put(str5, str6);
                }
            }
        }
        return linkedHashMap;
    }

    public final boolean isShellType(int type) {
        return type == MiniAppType.SHELL.getType() || type == MiniAppType.SHELL_GAME.getType();
    }

    public final boolean isShellType(AppModel appModel) {
        if (appModel != null) {
            return appModel.getAppinfoCategoryType() == MiniAppType.SHELL.getType() || appModel.getAppinfoCategoryType() == MiniAppType.SHELL_GAME.getType();
        }
        return false;
    }
}
