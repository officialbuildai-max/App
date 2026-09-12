package com.cloud.tmc.miniapp.prestrategy;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.model.LauncherPreDataModel;
import com.cloud.tmc.integration.model.LauncherPreStrategyBaseModel;
import com.cloud.tmc.integration.model.LauncherPreStrategyModel;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.KUrlUtils;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.ipc.IpcMiniLauncherService;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PreStrategyManager {
    public static long OooO0O0;
    public static HashMap<String, Boolean> OooO0Oo;
    public static long OooO0o0;
    public static final PreStrategyManager OooO00o = new PreStrategyManager();
    public static Map<String, String> OooO0OO = MapsKt.m(TuplesKt.a("keyZeroRecentData", "zeroRecent"), TuplesKt.a("keyZeroMinicardData", "zeroCard"), TuplesKt.a("keyZeroMinicardUpdate", "zeroCard"), TuplesKt.a("keyFullRecentMiniData", "fullSearchRecent"), TuplesKt.a("keyFullMinicardData", "fullSearchCard"), TuplesKt.a("keyAzRecentData", "azRecent"), TuplesKt.a("keyFullSearchAppData", "fullSearchApp"), TuplesKt.a("keyZeroBannerData", "zeroBanner"), TuplesKt.a("keyMiniAppStart", "miniappStart"), TuplesKt.a(TmcConstants.KEY_MC_RECOMMEND_START, "miniappCenterRecommend"));
    public static final long OooO0o = 3600000;

    public static final void OooO0OO(Context context, String type, String str, Function1 function1) {
        Intrinsics.h(type, "$type");
        OooO00o.OooO00o(context, type, str, (Function1<? super Boolean, Unit>) function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0163 A[Catch: all -> 0x0157, TryCatch #1 {all -> 0x0157, blocks: (B:48:0x0146, B:50:0x0150, B:53:0x015d, B:55:0x0163, B:56:0x0169, B:58:0x0171, B:59:0x0177, B:62:0x0189, B:67:0x0197, B:74:0x01a0), top: B:47:0x0146 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0171 A[Catch: all -> 0x0157, TryCatch #1 {all -> 0x0157, blocks: (B:48:0x0146, B:50:0x0150, B:53:0x015d, B:55:0x0163, B:56:0x0169, B:58:0x0171, B:59:0x0177, B:62:0x0189, B:67:0x0197, B:74:0x01a0), top: B:47:0x0146 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO00o(android.content.Context r17, java.lang.String r18, java.lang.String r19, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO00o(android.content.Context, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7 A[Catch: all -> 0x00bd, TryCatch #0 {all -> 0x00bd, blocks: (B:35:0x00ac, B:39:0x00b6, B:42:0x00c1, B:44:0x00c7, B:45:0x00cd, B:47:0x00d5, B:48:0x00db, B:51:0x00ed, B:56:0x00fa, B:64:0x0101, B:60:0x0120), top: B:34:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5 A[Catch: all -> 0x00bd, TryCatch #0 {all -> 0x00bd, blocks: (B:35:0x00ac, B:39:0x00b6, B:42:0x00c1, B:44:0x00c7, B:45:0x00cd, B:47:0x00d5, B:48:0x00db, B:51:0x00ed, B:56:0x00fa, B:64:0x0101, B:60:0x0120), top: B:34:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO00o(android.content.Context r11, java.util.List<java.lang.String> r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO00o(android.content.Context, java.util.List, java.lang.String):void");
    }

    public final void OooO00o(LauncherPreDataModel launcherPreDataModel, ArrayList<String> arrayList, ArrayList<String> arrayList2, Function1<? super Boolean, Unit> function1) {
        Unit unit;
        String str;
        ExtendModel extend;
        Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
        if (application$com_cloud_tmc_miniapp_sdk == null) {
            TmcLogger.e("Prefetch:PreStrategyManager", "executePrefetchConfig application is null");
            return;
        }
        String appId = launcherPreDataModel.getAppId();
        if (appId == null || appId.length() == 0) {
            TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyProcessing appId is null");
            return;
        }
        TmcLogger.e("Prefetch:PreStrategyManager", appId + " start pre strategy.");
        if (arrayList != null) {
            for (String str2 : arrayList) {
                if (Intrinsics.c(str2, "preHtml")) {
                    if (OooO00o.OooO0Oo()) {
                        AppModel appModel = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModel(application$com_cloud_tmc_miniapp_sdk, AppInfoQuery.INSTANCE.make(appId));
                        if (appModel == null) {
                            PreHtmStrategyProxy preHtmStrategyProxy = (PreHtmStrategyProxy) TmcProxy.get(PreHtmStrategyProxy.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("failReason", "get appModel is null");
                            bundle.putString("failAppId", String.valueOf(appId));
                            preHtmStrategyProxy.trackPreStrategyFailPoint(bundle);
                        }
                        if (appModel == null || (extend = appModel.getExtend()) == null || (str = extend.getH5Url()) == null) {
                            str = "";
                        }
                        if (str.length() == 0) {
                            TmcLogger.d("Prefetch:PreStrategyManager", appId + " ->h5Url is empty ,return!");
                        } else {
                            String generateShellUrl = KUrlUtils.generateShellUrl(str, launcherPreDataModel.getBundle());
                            TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_PREHTML ->" + appId + "  ->" + generateShellUrl);
                            if (arrayList2 == null || arrayList2.isEmpty()) {
                                TmcLogger.d("Prefetch:PreStrategyManager", appId + " ->preWhiteList is null or empty");
                                Object obj = TmcProxy.get(PreHtmStrategyProxy.class);
                                Intrinsics.g(obj, "get(PreHtmStrategyProxy::class.java)");
                                PreHtmStrategyProxy.DefaultImpls.requestHtml$default((PreHtmStrategyProxy) obj, application$com_cloud_tmc_miniapp_sdk, generateShellUrl, null, 4, null);
                            } else if (arrayList2.contains(UrlUtils.getHost(generateShellUrl))) {
                                TmcLogger.d("Prefetch:PreStrategyManager", appId + " ->host is preWhiteList ->" + generateShellUrl);
                                Object obj2 = TmcProxy.get(PreHtmStrategyProxy.class);
                                Intrinsics.g(obj2, "get(PreHtmStrategyProxy::class.java)");
                                PreHtmStrategyProxy.DefaultImpls.requestHtml$default((PreHtmStrategyProxy) obj2, application$com_cloud_tmc_miniapp_sdk, generateShellUrl, null, 4, null);
                            } else {
                                TmcLogger.d("Prefetch:PreStrategyManager", appId + " ->host is not preWhiteList ->" + generateShellUrl + " ");
                            }
                        }
                    } else {
                        TmcLogger.e("Prefetch:PreStrategyManager", appId + " ->checkEnablePreHtmlConfig enable status is false");
                    }
                } else if (Intrinsics.c(str2, "preAppInfo")) {
                    if (OooO00o.OooO0O0()) {
                        TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_PREAPPINFO ->" + appId + " ");
                        com.cloud.tmc.miniapp.prestrategy.strategy.OooO00o.OooO00o.OooO00o(application$com_cloud_tmc_miniapp_sdk, appId);
                    } else {
                        TmcLogger.e("Prefetch:PreStrategyManager", "CONFIG_PREAPPINFO enable status is false");
                    }
                } else if (Intrinsics.c(str2, "rendering")) {
                    TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_RENDERING ->" + appId);
                } else if (Intrinsics.c(str2, "preOfflinePackage")) {
                    if (OooO00o.OooO0o0()) {
                        TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_OFFLINEPACKAGE ->" + appId + " ");
                        com.cloud.tmc.miniapp.prestrategy.strategy.OooO0O0.OooO00o.OooO00o(application$com_cloud_tmc_miniapp_sdk, appId);
                    } else {
                        TmcLogger.e("Prefetch:PreStrategyManager", "CONFIG_OFFLINEPACKAGE enable status is false");
                    }
                } else if (Intrinsics.c(str2, LauncherMiniAppConfigHelper.KEY_OFF_SCREEN_RENDER)) {
                    TmcLogger.d("Prefetch:PreStrategyManager", "CONFIG_OFF_SCREEN_RENDER ->" + appId);
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                }
            }
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        if (unit == null) {
            TmcLogger.e("Prefetch:PreStrategyManager", "executePrefetchConfig list is null");
        }
    }

    public final boolean OooO00o() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_OPEN_BROWSER_CONFIG, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x02ab, code lost:
    
        if (r6.length() != 0) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02ae, code lost:
    
        r3 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.INSTANCE;
        kotlin.jvm.internal.Intrinsics.g(r11, "curSDKVersion");
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02b7, code lost:
    
        if (r3.compareVersion(r11, r6) == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02b9, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e("Prefetch:PreStrategyManager", r12.getAppId() + " cur sdk:" + r11 + " > " + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02d8, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x007e, code lost:
    
        if (r2 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0080, code lost:
    
        com.cloud.tmc.kernel.log.TmcLogger.e("Prefetch:PreStrategyManager", r12.getAppId() + " netType disallow, config.netType = " + r12.getNetType());
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x009f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x006e, code lost:
    
        if (r2 != false) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean OooO00o(android.content.Context r11, com.cloud.tmc.integration.model.LauncherPreStrategyModel r12) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO00o(android.content.Context, com.cloud.tmc.integration.model.LauncherPreStrategyModel):boolean");
    }

    public final boolean OooO00o(Context context, String appId, String str) {
        LauncherPreStrategyModel launcherPreStrategyModel;
        JsonArray asJsonArray;
        Object obj;
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        try {
            if (OooO0OO.OooO00o.OooO0O0()) {
                TmcLogger.e("Prefetch:PreStrategyManager", "new prefetch config. not open browser.");
                return false;
            }
            if (!OooO00o()) {
                TmcLogger.e("Prefetch:PreStrategyManager", "checkEnableOpenBrowserConfig is false");
                return false;
            }
            String OooO0O02 = OooO0O0(str);
            if (OooO0O02 != null && OooO0O02.length() != 0) {
                LauncherPreStrategyBaseModel OooO0O03 = OooO00o.OooO00o.OooO0O0(context);
                if (OooO0O03 == null) {
                    TmcLogger.e("Prefetch:PreStrategyManager", "preStrategyConfig is null");
                    return false;
                }
                ArrayList<LauncherPreStrategyModel> configList = OooO0O03.getConfigList();
                JsonElement jsonElement = null;
                if (configList != null) {
                    Iterator<T> it = configList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.c(((LauncherPreStrategyModel) obj).getAppId(), appId)) {
                            break;
                        }
                    }
                    launcherPreStrategyModel = (LauncherPreStrategyModel) obj;
                } else {
                    launcherPreStrategyModel = null;
                }
                JsonObject commonConfig = launcherPreStrategyModel != null ? launcherPreStrategyModel.getCommonConfig() : null;
                if (commonConfig == null) {
                    TmcLogger.e("Prefetch:PreStrategyManager", appId + " preStrategyConfig.commonConfig is null");
                    return false;
                }
                Long openBrowserTime = launcherPreStrategyModel.getOpenBrowserTime();
                long longValue = openBrowserTime != null ? openBrowserTime.longValue() : -1L;
                if (longValue >= 0 && longValue <= System.currentTimeMillis()) {
                    JsonElement jsonElement2 = commonConfig.get(OooO0O02);
                    if (jsonElement2 != null && (asJsonArray = jsonElement2.getAsJsonArray()) != null) {
                        Iterator<JsonElement> it2 = asJsonArray.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            JsonElement next = it2.next();
                            if (Intrinsics.c(next.getAsString(), "allowOpenBrowser")) {
                                jsonElement = next;
                                break;
                            }
                        }
                        if (jsonElement != null) {
                            return true;
                        }
                    }
                    return false;
                }
                TmcLogger.e("Prefetch:PreStrategyManager", appId + " preStrategyConfig.openBrowserTime = " + longValue + " is not suitable.");
                return false;
            }
            TmcLogger.e("Prefetch:PreStrategyManager", "openScene is null");
            return false;
        } catch (Throwable th2) {
            TmcLogger.e("Prefetch:PreStrategyManager", th2);
            return false;
        }
    }

    public final boolean OooO00o(String str) {
        try {
            if (OooO0Oo == null || System.currentTimeMillis() - OooO0o0 > OooO0o) {
                OooO0o0 = System.currentTimeMillis();
                OooO0Oo = (HashMap) GsonUtils.fromJson(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_PRE_MANAGER_ENABLE_CONFIG, LauncherMiniAppConfigHelper.DEFAULT_PRE_MANAGER_ENABLE_CONFIG), (Type) HashMap.class);
            }
            HashMap<String, Boolean> hashMap = OooO0Oo;
            Boolean bool = hashMap != null ? hashMap.get(str) : null;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String OooO0O0(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L68
            int r0 = r2.hashCode()
            switch(r0) {
                case 1448635040: goto L5c;
                case 1448635042: goto L50;
                case 1448635048: goto L44;
                case 1449558561: goto L3b;
                case 1449558562: goto L2f;
                case 1449558564: goto L23;
                case 1449558565: goto L17;
                case 1449558594: goto Lb;
                default: goto L9;
            }
        L9:
            goto L68
        Lb:
            java.lang.String r0 = "110013"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L14
            goto L68
        L14:
            java.lang.String r2 = "fullSearchCard"
            goto L69
        L17:
            java.lang.String r0 = "110005"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L20
            goto L68
        L20:
            java.lang.String r2 = "zeroRecent"
            goto L69
        L23:
            java.lang.String r0 = "110004"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L2c
            goto L68
        L2c:
            java.lang.String r2 = "azRecent"
            goto L69
        L2f:
            java.lang.String r0 = "110002"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L38
            goto L68
        L38:
            java.lang.String r2 = "fullSearchRecent"
            goto L69
        L3b:
            java.lang.String r0 = "110001"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L65
            goto L68
        L44:
            java.lang.String r0 = "100009"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L4d
            goto L68
        L4d:
            java.lang.String r2 = "miniappCenterRecommend"
            goto L69
        L50:
            java.lang.String r0 = "100003"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L59
            goto L68
        L59:
            java.lang.String r2 = "zeroCard"
            goto L69
        L5c:
            java.lang.String r0 = "100001"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L65
            goto L68
        L65:
            java.lang.String r2 = "fullSearchApp"
            goto L69
        L68:
            r2 = 0
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO0O0(java.lang.String):java.lang.String");
    }

    public final ArrayList<LauncherPreDataModel> OooO0O0(Context context, String key, String str) {
        ArrayList<LauncherPreDataModel> arrayList;
        Intrinsics.h(key, "key");
        if (context == null || str == null) {
            arrayList = null;
        } else {
            try {
                TmcLogger.d("Prefetch:PreStrategyManager", "preStrategyProcessing -> " + key + " -> " + str);
                arrayList = (ArrayList) GsonUtils.fromJson(str, new TypeToken<List<LauncherPreDataModel>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager$getLauncherData$1$1$1
                }.getType());
            } catch (Throwable th2) {
                TmcLogger.e("Prefetch:PreStrategyManager", "getLauncherData", th2);
                return new ArrayList<>();
            }
        }
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final void OooO0O0(final Context context, final String type, final String str, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.h(type, "type");
        if (ProcessUtils.isMiniProcess()) {
            try {
                ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.prestrategy.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        PreStrategyManager.OooO0OO(context, type, str, function1);
                    }
                });
                return;
            } catch (Throwable th2) {
                TmcLogger.e("Prefetch:PreStrategyManager", th2);
                return;
            }
        }
        Intrinsics.h(type, "type");
        IpcMiniLauncherService.OooO00o oooO00o = IpcMiniLauncherService.OooO00o;
        OooO0O0 oooO0O0 = new OooO0O0(type, str, context, function1);
        Intrinsics.h(type, "type");
        try {
            TmcLogger.d(":IpcTaskManagerService", "preLauncherData");
            if (ProcessUtils.isMiniProcess()) {
                TmcLogger.d(":IpcTaskManagerService", "preLauncherData isMiniProcess");
                Context applicationContext = context != null ? context.getApplicationContext() : null;
                Utils.setAppIfNecessary(applicationContext instanceof Application ? (Application) applicationContext : null);
                oooO0O0.OooO00o(false);
                return;
            }
            Intent intent = new Intent(context, (Class<?>) IpcMiniLauncherService.class);
            AppPrepareUtils.INSTANCE.addCommonIntentParameter(intent, context);
            if (context != null) {
                context.bindService(intent, new com.cloud.tmc.miniapp.ipc.OooO0OO(type, context, oooO0O0, str), 1);
            }
        } catch (Throwable th3) {
            TmcLogger.e(":IpcTaskManagerService", th3);
            oooO0O0.OooO00o(0, th3);
        }
    }

    public final boolean OooO0O0() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_PRE_APPINFO_CONFIG, true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean OooO0OO() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_PRE_MANAGER_CONFIG, true);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r8.equals("keyFullRecentMiniData") != false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001a, B:11:0x0022, B:13:0x0028, B:15:0x004a, B:17:0x005f, B:26:0x00b7, B:28:0x0078, B:31:0x0092, B:33:0x009f, B:35:0x00a5, B:37:0x0081, B:40:0x008a, B:42:0x00af, B:44:0x00bb, B:46:0x00c8, B:48:0x00ce), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001a, B:11:0x0022, B:13:0x0028, B:15:0x004a, B:17:0x005f, B:26:0x00b7, B:28:0x0078, B:31:0x0092, B:33:0x009f, B:35:0x00a5, B:37:0x0081, B:40:0x008a, B:42:0x00af, B:44:0x00bb, B:46:0x00c8, B:48:0x00ce), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO0Oo(android.content.Context r7, java.lang.String r8, java.lang.String r9, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r10) {
        /*
            r6 = this;
            java.lang.String r0 = "Prefetch:PreStrategyManager"
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.h(r8, r1)
            if (r7 == 0) goto Ldd
            com.cloud.tmc.miniapp.ByteAppManager r1 = com.cloud.tmc.miniapp.ByteAppManager.INSTANCE     // Catch: java.lang.Throwable -> L17
            boolean r1 = r1.checkPreInitConfig(r7)     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L1a
            java.lang.String r7 = "close pre init subprocess"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r7)     // Catch: java.lang.Throwable -> L17
            return
        L17:
            r7 = move-exception
            goto Ld8
        L1a:
            com.cloud.tmc.miniapp.prestrategy.PreStrategyManager r1 = com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO00o     // Catch: java.lang.Throwable -> L17
            boolean r2 = r1.OooO0OO()     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L28
            java.lang.String r7 = "checkEnablePreConfig enable status is false  return"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r7)     // Catch: java.lang.Throwable -> L17
            return
        L28:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L17
            java.lang.String r3 = "updateLauncherData "
            r2.append(r3)     // Catch: java.lang.Throwable -> L17
            r2.append(r8)     // Catch: java.lang.Throwable -> L17
            java.lang.String r3 = " -> "
            r2.append(r3)     // Catch: java.lang.Throwable -> L17
            r2.append(r9)     // Catch: java.lang.Throwable -> L17
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L17
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r2)     // Catch: java.lang.Throwable -> L17
            boolean r2 = r1.OooO00o(r8)     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L5f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L17
            r7.<init>()     // Catch: java.lang.Throwable -> L17
            r7.append(r8)     // Catch: java.lang.Throwable -> L17
            java.lang.String r8 = " is not allow execute"
            r7.append(r8)     // Catch: java.lang.Throwable -> L17
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L17
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r7)     // Catch: java.lang.Throwable -> L17
            return
        L5f:
            int r2 = r8.hashCode()     // Catch: java.lang.Throwable -> L17
            r3 = -2066930763(0xffffffff84cd23b5, float:-4.822806E-36)
            if (r2 == r3) goto Laf
            r3 = -1879995062(0xffffffff8ff18d4a, float:-2.3818857E-29)
            if (r2 == r3) goto L8a
            r3 = -605809219(0xffffffffdbe415bd, float:-1.28400392E17)
            if (r2 == r3) goto L81
            r3 = 936969644(0x37d905ac, float:2.5871057E-5)
            if (r2 == r3) goto L78
            goto Lb7
        L78:
            java.lang.String r2 = "keyZeroRecentData"
            boolean r2 = r8.equals(r2)     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L92
            goto Lb7
        L81:
            java.lang.String r2 = "keyAzRecentData"
            boolean r2 = r8.equals(r2)     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L92
            goto Lb7
        L8a:
            java.lang.String r2 = "keyFullRecentMiniData"
            boolean r2 = r8.equals(r2)     // Catch: java.lang.Throwable -> L17
            if (r2 == 0) goto Lb7
        L92:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L17
            long r4 = com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO0O0     // Catch: java.lang.Throwable -> L17
            long r2 = r2 - r4
            r4 = 500(0x1f4, double:2.47E-321)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto La5
            java.lang.String r7 = "recent update diff < 500ms"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r7)     // Catch: java.lang.Throwable -> L17
            return
        La5:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L17
            com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO0O0 = r2     // Catch: java.lang.Throwable -> L17
            r1.OooO0O0(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L17
            goto Ldd
        Laf:
            java.lang.String r2 = "keyFullSearchAppData"
            boolean r2 = r8.equals(r2)     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto Lbb
        Lb7:
            r1.OooO0O0(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L17
            goto Ldd
        Lbb:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L17
            long r4 = com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO0O0     // Catch: java.lang.Throwable -> L17
            long r2 = r2 - r4
            r4 = 300(0x12c, double:1.48E-321)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto Lce
            java.lang.String r7 = "KEY_FULL_SEARCH_APP_DATA diff < 500ms"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r7)     // Catch: java.lang.Throwable -> L17
            return
        Lce:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L17
            com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO0O0 = r2     // Catch: java.lang.Throwable -> L17
            r1.OooO0O0(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L17
            goto Ldd
        Ld8:
            java.lang.String r8 = "updateLauncherData"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r8, r7)
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prestrategy.PreStrategyManager.OooO0Oo(android.content.Context, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1):void");
    }

    public final boolean OooO0Oo() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_PRE_HTML_CONFIG, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean OooO0o0() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_PRE_OFFLINE_CONFIG, true);
        } catch (Throwable unused) {
            return false;
        }
    }
}
