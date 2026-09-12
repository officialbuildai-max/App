package com.cloud.tmc.integration.utils;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.callback.IAllowMFAHListener;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonObject;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001d\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010!\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0010\u0010#\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u000e\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u0018\u0010%\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u000bJ\u0010\u0010'\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010(\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, d2 = {"Lcom/cloud/tmc/integration/utils/MiniForceAddHomeManager;", "", "()V", "TAG", "", "allMFAHMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/cloud/tmc/integration/callback/IAllowMFAHListener;", "hideLoaingMap", "Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "interceptMFAHMap", "", "interceptPrivacyMap", "interceptRealMFAHMap", "getInterceptRealMFAHMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "addHideLoadingCallback", "", "appId", "callback", "addInterectMFAH", "addMFAHListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "checkForceAddHome", "startParam", "Landroid/os/Bundle;", "checkInterect", "checkInterectMFAH", "checkInterectMFAHWithBookPrivacy", "checkPrivacyIntercept", "injectStartSpecialParam", "Lcom/cloud/tmc/integration/model/MiniAppConfigModel;", "miniAppConfigModel", "noticeClickAllowBtn", "notifyHideLoading", "removeAllMfahListener", "removeHideLoadingCallback", "removeInterectMFAH", "reportCacheData", "removeMFAHListener", "reportAthenaData", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class MiniForceAddHomeManager {
    public static final MiniForceAddHomeManager INSTANCE = new MiniForceAddHomeManager();
    private static final String TAG = "MiniForceAddHomeManager";
    private static final ConcurrentHashMap<String, Boolean> interceptRealMFAHMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Boolean> interceptMFAHMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Boolean> interceptPrivacyMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, IAllowMFAHListener> allMFAHMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, BridgeCallback> hideLoaingMap = new ConcurrentHashMap<>();

    private MiniForceAddHomeManager() {
    }

    public static /* synthetic */ void notifyHideLoading$default(MiniForceAddHomeManager miniForceAddHomeManager, String str, BridgeCallback bridgeCallback, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bridgeCallback = null;
        }
        miniForceAddHomeManager.notifyHideLoading(str, bridgeCallback);
    }

    public final void addHideLoadingCallback(String appId, BridgeCallback callback) {
        Intrinsics.h(appId, "appId");
        Intrinsics.h(callback, "callback");
        try {
            ConcurrentHashMap<String, BridgeCallback> concurrentHashMap = hideLoaingMap;
            if (concurrentHashMap.get(appId) != null) {
                TmcLogger.d(TAG, "autoRemoveHideLoadingCallback " + appId);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("autoClose", Boolean.TRUE);
                callback.sendFailResponse(jsonObject);
                callback.close();
            }
            TmcLogger.d(TAG, "addHideLoadingCallback " + appId);
            concurrentHashMap.put(appId, callback);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "addHideLoadingCallback", th2);
        }
    }

    public final void addInterectMFAH(String appId) {
        try {
            TmcLogger.d(TAG, "addInterectMFAH");
            if (appId != null && appId.length() != 0) {
                interceptMFAHMap.put(appId, Boolean.TRUE);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    public final void addMFAHListener(String appId, IAllowMFAHListener listener) {
        Intrinsics.h(listener, "listener");
        if (appId != null) {
            try {
                if (appId.length() == 0) {
                    return;
                }
                allMFAHMap.put(appId, listener);
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "addMFAHListener", th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean checkForceAddHome(android.os.Bundle r7) {
        /*
            r6 = this;
            com.cloud.tmc.integration.MiniAppConfigHelper r0 = com.cloud.tmc.integration.MiniAppConfigHelper.INSTANCE     // Catch: java.lang.Throwable -> L16
            java.lang.String r1 = "enableForceAddHome"
            r2 = 1
            boolean r1 = r0.getConfigTargetBool(r1, r2)     // Catch: java.lang.Throwable -> L16
            java.lang.String r3 = ""
            if (r7 == 0) goto L19
            java.lang.String r4 = "mfah"
            java.lang.String r4 = r7.getString(r4)     // Catch: java.lang.Throwable -> L16
            if (r4 != 0) goto L1a
            goto L19
        L16:
            r7 = move-exception
            goto La7
        L19:
            r4 = r3
        L1a:
            if (r7 == 0) goto L26
            java.lang.String r5 = "appId"
            java.lang.String r7 = r7.getString(r5)     // Catch: java.lang.Throwable -> L16
            if (r7 != 0) goto L25
            goto L26
        L25:
            r3 = r7
        L26:
            int r7 = r4.length()     // Catch: java.lang.Throwable -> L16
            if (r7 <= 0) goto L48
            java.lang.String r7 = "1"
            boolean r7 = kotlin.jvm.internal.Intrinsics.c(r4, r7)     // Catch: java.lang.Throwable -> L16
            if (r7 == 0) goto L48
            java.lang.String r7 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.TAG     // Catch: java.lang.Throwable -> L16
            java.lang.String r0 = "checkForceAddHome mfah -> true"
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r0)     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L47
            r6.addInterectMFAH(r3)     // Catch: java.lang.Throwable -> L16
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r7 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.interceptRealMFAHMap     // Catch: java.lang.Throwable -> L16
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L16
            r7.put(r3, r0)     // Catch: java.lang.Throwable -> L16
        L47:
            return r2
        L48:
            int r7 = r3.length()     // Catch: java.lang.Throwable -> L16
            if (r7 <= 0) goto L9f
            java.lang.String r7 = "mfahList"
            java.lang.String r4 = "[]"
            java.lang.String r7 = r0.getConfigTargetStr(r7, r4)     // Catch: java.lang.Throwable -> L63
            java.lang.Class<java.util.List> r0 = java.util.List.class
            java.lang.Object r7 = com.cloud.tmc.miniutils.util.GsonUtils.fromJson(r7, r0)     // Catch: java.lang.Throwable -> L63
            boolean r0 = r7 instanceof java.util.List     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto L65
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L63
            goto L66
        L63:
            r7 = move-exception
            goto L6e
        L65:
            r7 = 0
        L66:
            if (r7 != 0) goto L78
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L63
            r7.<init>()     // Catch: java.lang.Throwable -> L63
            goto L78
        L6e:
            java.lang.String r0 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.TAG     // Catch: java.lang.Throwable -> L16
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r7)     // Catch: java.lang.Throwable -> L16
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L16
            r7.<init>()     // Catch: java.lang.Throwable -> L16
        L78:
            boolean r7 = r7.contains(r3)     // Catch: java.lang.Throwable -> L16
            if (r7 == 0) goto L92
            java.lang.String r7 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.TAG     // Catch: java.lang.Throwable -> L16
            java.lang.String r0 = "checkForceAddHome appId in mfahList"
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r0)     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L91
            r6.addInterectMFAH(r3)     // Catch: java.lang.Throwable -> L16
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r7 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.interceptRealMFAHMap     // Catch: java.lang.Throwable -> L16
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L16
            r7.put(r3, r0)     // Catch: java.lang.Throwable -> L16
        L91:
            return r2
        L92:
            boolean r7 = r6.checkPrivacyIntercept(r3)     // Catch: java.lang.Throwable -> L16
            if (r7 == 0) goto L9f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r7 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.interceptPrivacyMap     // Catch: java.lang.Throwable -> L16
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L16
            r7.put(r3, r0)     // Catch: java.lang.Throwable -> L16
        L9f:
            java.lang.String r7 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.TAG     // Catch: java.lang.Throwable -> L16
            java.lang.String r0 = "checkForceAddHome mfah -> false"
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r0)     // Catch: java.lang.Throwable -> L16
            goto Lae
        La7:
            java.lang.String r0 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.TAG
            java.lang.String r1 = "checkForceAddHome"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r1, r7)
        Lae:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.MiniForceAddHomeManager.checkForceAddHome(android.os.Bundle):boolean");
    }

    public final boolean checkInterect(String appId) {
        boolean z10;
        try {
            Boolean bool = interceptMFAHMap.get(appId);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            Boolean bool2 = interceptPrivacyMap.get(appId);
            boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
            if (!booleanValue && !booleanValue2) {
                z10 = false;
                TmcLogger.d(TAG, "checkInterectmfah: " + appId + " -> mfahStatus -> " + booleanValue + ",privacyStatus ->" + booleanValue2);
                return z10;
            }
            z10 = true;
            TmcLogger.d(TAG, "checkInterectmfah: " + appId + " -> mfahStatus -> " + booleanValue + ",privacyStatus ->" + booleanValue2);
            return z10;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean checkInterectMFAH(String appId) {
        try {
            Boolean bool = interceptMFAHMap.get(appId);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            TmcLogger.d(TAG, "checkInterectmfah: " + appId + " -> mfahStatus -> " + booleanValue);
            return booleanValue;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean checkInterectMFAHWithBookPrivacy(String appId) {
        try {
            Boolean bool = interceptMFAHMap.get(appId);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            if (booleanValue && !DeviceUtil.INSTANCE.getIsNewUserStatus()) {
                Boolean bool2 = interceptRealMFAHMap.get(appId);
                if (!(bool2 != null ? bool2.booleanValue() : false)) {
                    booleanValue = false;
                }
            }
            TmcLogger.d(TAG, "checkInterectmfah: " + appId + " -> mfahStatus -> " + booleanValue);
            return booleanValue;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean checkPrivacyIntercept(String appId) {
        try {
            Boolean first = ((ReportProxy) TmcProxy.get(ReportProxy.class)).checkReportIntercept(appId, Boolean.FALSE).getFirst();
            Intrinsics.g(first, "checkReportIntercept.first");
            return first.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public final ConcurrentHashMap<String, Boolean> getInterceptRealMFAHMap() {
        return interceptRealMFAHMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001a A[Catch: all -> 0x0010, TRY_LEAVE, TryCatch #0 {all -> 0x0010, blocks: (B:14:0x0007, B:4:0x0014, B:6:0x001a), top: B:13:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.cloud.tmc.integration.model.MiniAppConfigModel injectStartSpecialParam(com.cloud.tmc.integration.model.MiniAppConfigModel r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "miniAppConfigModel"
            kotlin.jvm.internal.Intrinsics.h(r3, r0)
            if (r4 == 0) goto L12
            java.lang.String r0 = "appId"
            java.lang.String r4 = r4.getString(r0)     // Catch: java.lang.Throwable -> L10
            if (r4 != 0) goto L14
            goto L12
        L10:
            r4 = move-exception
            goto L20
        L12:
            java.lang.String r4 = ""
        L14:
            boolean r4 = r2.checkInterect(r4)     // Catch: java.lang.Throwable -> L10
            if (r4 == 0) goto L27
            java.lang.String r4 = "1"
            r3.setMfah(r4)     // Catch: java.lang.Throwable -> L10
            goto L27
        L20:
            java.lang.String r0 = com.cloud.tmc.integration.utils.MiniForceAddHomeManager.TAG
            java.lang.String r1 = "injectStartSpecialParam"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r1, r4)
        L27:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.MiniForceAddHomeManager.injectStartSpecialParam(com.cloud.tmc.integration.model.MiniAppConfigModel, android.os.Bundle):com.cloud.tmc.integration.model.MiniAppConfigModel");
    }

    public final void noticeClickAllowBtn(String appId) {
        try {
            TmcLogger.d(TAG, "noticeClickAllowBtn " + appId);
            IAllowMFAHListener iAllowMFAHListener = allMFAHMap.get(appId);
            if (iAllowMFAHListener != null) {
                iAllowMFAHListener.mfahAllow(appId);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    public final void notifyHideLoading(String appId, BridgeCallback callback) {
        Intrinsics.h(appId, "appId");
        if (callback == null) {
            try {
                callback = hideLoaingMap.get(appId);
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "notifyHideLoading", th2);
                return;
            }
        }
        if (callback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("isHideLoding", Boolean.TRUE);
            callback.sendSuccessResponse(jsonObject);
            callback.close();
            removeHideLoadingCallback(appId);
            return;
        }
        TmcLogger.d(TAG, "notifyHideLoading " + appId + " not found");
    }

    public final void removeAllMfahListener(String appId) {
        try {
            TmcLogger.d(TAG, "removeAllMfahListener -> appId: ->" + appId);
            if (appId != null && appId.length() != 0) {
                allMFAHMap.remove(appId);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    public final void removeHideLoadingCallback(String appId) {
        Intrinsics.h(appId, "appId");
        try {
            hideLoaingMap.remove(appId);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "removeHideLoadingCallback", th2);
        }
    }

    public final void removeInterectMFAH(String appId, boolean reportCacheData) {
        try {
            TmcLogger.d(TAG, "removeInterectMFAH " + appId);
            TypeIntrinsics.d(interceptMFAHMap).remove(appId);
            TypeIntrinsics.d(interceptPrivacyMap).remove(appId);
            TypeIntrinsics.d(interceptRealMFAHMap).remove(appId);
            removeHideLoadingCallback(appId == null ? "" : appId);
            if (reportCacheData) {
                reportAthenaData(appId);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    public final void removeMFAHListener(String appId) {
        try {
            TmcLogger.d(TAG, "removeMFAHListener -> appId: ->" + appId);
            if (appId != null && appId.length() != 0) {
                removeAllMfahListener(appId);
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    public final void reportAthenaData(String appId) {
        try {
            ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
            if (appId == null) {
                appId = "";
            }
            reportProxy.mfahCacheDataReport(appId);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "reportAthenaData", th2);
        }
    }
}
