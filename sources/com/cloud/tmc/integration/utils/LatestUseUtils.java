package com.cloud.tmc.integration.utils;

import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.Utils;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class LatestUseUtils {
    private static final String CONSTANT_LOGO = "logo_";
    private static final int INSIDE_MARGIN = 10;
    private static final float INSIDE_RADIUS = 14.0f;
    private static final int LARGE_ICON_SIZE = 144;
    private static final String LATEST_APP_COUNT_KEY = "latest_app_count";
    private static final String LATEST_APP_ICON_KEY = "latest_app_icon";
    private static final String LATEST_APP_ICON_MSG_KEY = "latest_app_icon_msg";
    private static final String LATEST_APP_ICON_MSG_NIGHT_KEY = "latest_app_icon_msg_night";
    private static final String LATEST_APP_ICON_NIGHT_KEY = "latest_app_icon_night";
    private static final String LATEST_USE_APP_KEY = "latest_use_app";
    private static final int OUTSIDE_MARGIN = 16;
    private static final float OUTSIDE_RADIUS = 36.0f;
    private static final int SMALL_ICON_SIZE = 51;
    private static final String TAG = "LatestUseUtils";

    public static synchronized boolean addAppUse(String str, String str2, String str3, String str4, List<String> list, String str5, int i11) {
        synchronized (LatestUseUtils.class) {
            TmcLogger.d(TAG, "addAppUse -> appId -> " + str + "appName " + str2);
            try {
                if (!AbilitiesUtils.INSTANCE.getAbilityEnableStatus(str, TmcConstants.MENU_KEY_LATEST_USE)) {
                    TmcLogger.e(TAG, "config not add latest use.");
                    return false;
                }
                HashMap<String, AppStoreInfo> latestUseApp = getLatestUseApp();
                AppStoreInfo appStoreInfo = new AppStoreInfo(str, str2, str3, str4, list, str5, i11);
                if (latestUseApp == null || latestUseApp.size() == 0) {
                    latestUseApp = new HashMap<>();
                }
                Collections.sort(new ArrayList(latestUseApp.values()), new Comparator<AppStoreInfo>() { // from class: com.cloud.tmc.integration.utils.LatestUseUtils.1
                    @Override // java.util.Comparator
                    public int compare(AppStoreInfo appStoreInfo2, AppStoreInfo appStoreInfo3) {
                        return appStoreInfo2.getSaveTime() > appStoreInfo3.getSaveTime() ? -1 : 1;
                    }
                });
                latestUseApp.put(str, appStoreInfo);
                updateLatestUseApp(latestUseApp);
                return true;
            } catch (Throwable th2) {
                TmcLogger.e(TAG, th2);
                return false;
            }
        }
    }

    public static synchronized boolean deleteAppUse(String str) {
        synchronized (LatestUseUtils.class) {
            try {
                HashMap<String, AppStoreInfo> latestUseApp = getLatestUseApp();
                if (latestUseApp != null && latestUseApp.size() != 0) {
                    if (latestUseApp.get(str) != null) {
                        latestUseApp.remove(str);
                        updateLatestUseApp(latestUseApp);
                    }
                    return true;
                }
                return true;
            } catch (Throwable th2) {
                TmcLogger.e(TAG, th2);
                return false;
            }
        }
    }

    private static HashMap<String, AppStoreInfo> getLatestUseApp() {
        try {
            Type type = new TypeToken<HashMap<String, AppStoreInfo>>() { // from class: com.cloud.tmc.integration.utils.LatestUseUtils.3
            }.getType();
            String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(Utils.getApp(), TmcConstants.KEYS_MINI_LATEST_USE_APP, LATEST_USE_APP_KEY);
            if (string != null && !string.isEmpty()) {
                return (HashMap) GsonUtils.fromJson(string, type);
            }
            MMKV multiMMKVInstance = MiniAppConfigHelper.getMultiMMKVInstance();
            if (multiMMKVInstance == null) {
                return null;
            }
            String string2 = multiMMKVInstance.getString(LATEST_USE_APP_KEY, "{}");
            TmcLogger.d(TAG, "getLatestUseApp->" + string2);
            HashMap<String, AppStoreInfo> hashMap = (HashMap) GsonUtils.fromJson(string2, type);
            updateLatestUseApp(hashMap);
            return hashMap;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #2 {, blocks: (B:14:0x0032, B:25:0x002b), top: B:24:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.util.List<com.cloud.tmc.integration.model.AppStoreInfo> getLatestUseApps() {
        /*
            java.lang.Class<com.cloud.tmc.integration.utils.LatestUseUtils> r0 = com.cloud.tmc.integration.utils.LatestUseUtils.class
            monitor-enter(r0)
            r1 = 0
            java.util.HashMap r2 = getLatestUseApp()     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L29
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L25
            if (r3 != 0) goto L11
            goto L29
        L11:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L25
            java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L25
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L25
            com.cloud.tmc.integration.utils.LatestUseUtils$2 r1 = new com.cloud.tmc.integration.utils.LatestUseUtils$2     // Catch: java.lang.Throwable -> L23
            r1.<init>()     // Catch: java.lang.Throwable -> L23
            java.util.Collections.sort(r3, r1)     // Catch: java.lang.Throwable -> L23
            goto L30
        L23:
            r1 = move-exception
            goto L2b
        L25:
            r2 = move-exception
            r3 = r1
            r1 = r2
            goto L2b
        L29:
            monitor-exit(r0)
            return r1
        L2b:
            java.lang.String r2 = "LatestUseUtils"
            com.cloud.tmc.kernel.log.TmcLogger.e(r2, r1)     // Catch: java.lang.Throwable -> L38
        L30:
            if (r3 != 0) goto L3a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L38
            r3.<init>()     // Catch: java.lang.Throwable -> L38
            goto L3a
        L38:
            r1 = move-exception
            goto L3c
        L3a:
            monitor-exit(r0)
            return r3
        L3c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.LatestUseUtils.getLatestUseApps():java.util.List");
    }

    public static synchronized void removeList(List<String> list) {
        synchronized (LatestUseUtils.class) {
            try {
                HashMap<String, AppStoreInfo> latestUseApp = getLatestUseApp();
                for (String str : list) {
                    if (!TextUtils.isEmpty(str) && latestUseApp != null) {
                        latestUseApp.remove(str);
                    }
                }
                updateLatestUseApp(latestUseApp);
            } finally {
            }
        }
    }

    private static void updateLatestUseApp(HashMap<String, AppStoreInfo> hashMap) {
        if (hashMap == null) {
            return;
        }
        try {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(Utils.getApp(), TmcConstants.KEYS_MINI_LATEST_USE_APP, LATEST_USE_APP_KEY, GsonUtils.toJson(hashMap));
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }
}
