package com.cloud.tmc.miniapp.utils;

import android.app.Application;
import android.content.Context;
import com.cloud.config.utils.CommonUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.net.TmcResponseCallback;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.PopWindowManager;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class MessageBubbleUtils {
    public static final MessageBubbleUtils OooO00o = new MessageBubbleUtils();

    public final void OooO00o(Context context, TmcResponseCallback<LauncherMiniAppMsgModel> tmcResponseCallback) {
        String str;
        try {
            String uRL_MINI_QUERY_NEW_MSG_mini = UrlKt.getURL_MINI_QUERY_NEW_MSG_mini();
            TmcLogger.d("MessageBubbleUtils", "requestUrl -> " + uRL_MINI_QUERY_NEW_MSG_mini);
            try {
                str = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(context, TmcConstants.KEY_MINI_SDK_STORAGE, "device_util_ga_id");
                if (str == null) {
                    str = "";
                }
                TmcLogger.d("MessageBubbleUtils", "requestQueryMsgStatus mGAId:" + str);
            } catch (Throwable unused) {
                str = "";
            }
            if (str.length() == 0) {
                tmcResponseCallback.onFailure(TmcConstants.COLD_OPEN_TYPE, "gaid is null", "");
                TmcLogger.d("MessageBubbleUtils", "mGAId is null ");
                return;
            }
            OooO0o oooO0o = OooO0o.OooO00o;
            Pair<String, String> OooO0o0 = oooO0o.OooO0o0(context);
            HashMap hashMap = new HashMap();
            hashMap.put("originType", "3");
            hashMap.put(CommonUtils.PARAM_UID, str);
            hashMap.put("webQueryTimestamp", Long.valueOf(System.currentTimeMillis()));
            String first = OooO0o0.getFirst();
            String second = OooO0o0.getSecond();
            if (first.length() > 0) {
                hashMap.put("mainSwitchStatus", first);
            }
            if (second.length() > 0) {
                hashMap.put("mainSwitchTimestamp", second);
            }
            JsonArray OooO0O0 = oooO0o.OooO0O0(context);
            if (!OooO0O0.isEmpty()) {
                hashMap.put("miniAppSwitchOnOffs", OooO0O0);
                TmcLogger.d("MessageBubbleUtils", "miniAppSwitchOnOffs:" + TmcGsonUtilsKt.toJson(hashMap));
            }
            ((INetWorkProxy) TmcProxy.get(INetWorkProxy.class)).postJson(uRL_MINI_QUERY_NEW_MSG_mini, new LinkedHashMap(), new LinkedHashMap(), hashMap, Boolean.TRUE, tmcResponseCallback);
        } catch (Throwable th2) {
            TmcLogger.e("MessageBubbleUtils", th2);
        }
    }

    public final void OooO00o(Context context, String appId, String miniAppPopWindowToken, PopWindowManager.IPopWindowManagerController controller) {
        int configInt;
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(miniAppPopWindowToken, "miniAppPopWindowToken");
        Intrinsics.h(controller, "controller");
        if (appId.length() == 0) {
            return;
        }
        TmcLogger.d("MessageBubbleUtils", "checkAndShowMsgBubble");
        if (OooO00o(appId)) {
            return;
        }
        long j11 = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(context, appId, TmcConstants.KEY_SHOW_MSG_BUBBLE_TIME);
        TmcLogger.d("MessageBubbleUtils", "checkAndShowMsgBubble showAddHomeTime->" + j11 + " currentTimeMillis->" + System.currentTimeMillis() + " diff ->" + (System.currentTimeMillis() - j11));
        int i11 = 43200000;
        try {
            i11 = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigInt(LauncherMiniAppConfigHelper.KEY_MINI_POPWINDOW_MSG_BUBBLE_INTERVAL, 43200000);
        } catch (Throwable th2) {
            TmcLogger.e("MessageBubbleUtils", th2);
        }
        if (System.currentTimeMillis() - j11 >= i11 && (configInt = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigInt(LauncherMiniAppConfigHelper.KEY_MINI_POPWINDOW_MSG_BUBBLE_DELAY, 60000)) > 0) {
            TmcLogger.d("MessageBubbleUtils", "addPopWindow msg bubble:->" + configInt);
            PopWindowManager.INSTANCE.addPopWindow(miniAppPopWindowToken, new PopWindowManager.PopWindowData(appId, (long) configInt, 2, controller, false, 16, null));
        }
    }

    public final void OooO00o(App app, OooO0O0 oooO0O0) {
        Application application$com_cloud_tmc_miniapp_sdk;
        AppContext appContext;
        try {
            TmcLogger.d("MessageBubbleUtils", "requestMsgBubbleStatus");
            Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
            if (context == null) {
                return;
            }
            OooO0o oooO0o = OooO0o.OooO00o;
            String OooO0OO = oooO0o.OooO0OO(context);
            if (OooO0OO.length() == 0) {
                TmcLogger.d("MessageBubbleUtils", "latestUnreadMsg is null or empty");
                return;
            }
            JsonObject jsonObject = (JsonObject) GsonUtils.fromJson(OooO0OO, JsonObject.class);
            JsonElement jsonElement = jsonObject.get(TmcConstants.KEY_MINI_APPID);
            String asString = jsonElement != null ? jsonElement.getAsString() : null;
            String str = "";
            if (asString == null) {
                asString = "";
            }
            JsonElement jsonElement2 = jsonObject.get("miniappName");
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            if (asString2 == null) {
                asString2 = "";
            }
            if (Intrinsics.c(app.getAppId(), asString)) {
                return;
            }
            if (!oooO0o.OooO00o(context, asString)) {
                TmcLogger.d("MessageBubbleUtils", "requestMsgBubbleStatus msg switch is closed -> " + asString);
                return;
            }
            TmcLogger.d("MessageBubbleUtils", "checkAndShowMessageBubble appId " + asString);
            String appId = app.getAppId();
            if (appId != null) {
                str = appId;
            }
            if (str.length() == 0 || (application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk()) == null) {
                return;
            }
            if (System.currentTimeMillis() - ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, str, "MessageBubbleLatestTime") < TmcConstants.MINI_POPWINDOW_MSG_BUBBLE_INTERVAL) {
                return;
            }
            TmcLogger.d("MessageBubbleUtils", "show msg bubble");
            if (oooO0O0 != null) {
                oooO0O0.show(str, asString2);
            }
        } catch (Throwable th2) {
            TmcLogger.e("MessageBubbleUtils", "requestMsgBubbleStatus", th2);
        }
    }

    public final boolean OooO00o() {
        try {
            if (OooO0O0()) {
                return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_MSG_BOTTOM_ENABLE, false);
            }
            return false;
        } catch (Throwable th2) {
            TmcLogger.e("MessageBubbleUtils", th2);
            return false;
        }
    }

    public final boolean OooO00o(String str) {
        try {
            Object fromJson = GsonUtils.fromJson(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_MINI_POPWINDOW_MSG_BUBBLE_FORBID_ID, MiniAppConfigHelper.DEFAULT_MINI_POPWINDOW_MSG_BUBBLE_FORBID_ID), (Class<Object>) List.class);
            List list = fromJson instanceof List ? (List) fromJson : null;
            if (list == null) {
                list = new ArrayList();
            }
            return list.contains(str);
        } catch (Throwable th2) {
            TmcLogger.e("MessageBubbleUtils", th2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO0O0(final com.cloud.tmc.integration.structure.App r9, final com.cloud.tmc.miniapp.utils.OooO0O0 r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = 0
            if (r9 == 0) goto L10
            com.cloud.tmc.integration.structure.AppContext r2 = r9.getAppContext()
            if (r2 == 0) goto L10
            android.content.Context r2 = r2.getContext()
            goto L11
        L10:
            r2 = r1
        L11:
            if (r2 != 0) goto L14
            return
        L14:
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r3 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.Object r4 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r3)
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r4 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r4
            java.lang.String r5 = "isNewUser"
            r6 = 1
            java.lang.String r7 = "100000"
            boolean r4 = r4.getBoolean(r2, r7, r5, r6)
            java.lang.String r5 = "MessageBubbleUtils"
            if (r4 == 0) goto L2f
            java.lang.String r9 = "updateDateMsgStatus isFirst = true"
            com.cloud.tmc.kernel.log.TmcLogger.d(r5, r9)
            return
        L2f:
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.h(r2, r4)
            java.lang.Object r3 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r3)     // Catch: java.lang.Throwable -> L76
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r3 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r3     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = "miniMsgProvider"
            java.lang.String r6 = "mainMsgSwitch"
            java.lang.String r3 = r3.getString(r2, r4, r6)     // Catch: java.lang.Throwable -> L76
            if (r3 == 0) goto L76
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L76
            if (r4 <= 0) goto L76
            java.lang.Class<com.google.gson.JsonObject> r4 = com.google.gson.JsonObject.class
            java.lang.Object r3 = com.cloud.tmc.miniutils.util.GsonUtils.fromJson(r3, r4)     // Catch: java.lang.Throwable -> L76
            com.google.gson.JsonObject r3 = (com.google.gson.JsonObject) r3     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = "mainSwitchStatus"
            com.google.gson.JsonElement r4 = r3.get(r4)     // Catch: java.lang.Throwable -> L76
            if (r4 == 0) goto L5f
            java.lang.String r4 = r4.getAsString()     // Catch: java.lang.Throwable -> L76
            goto L60
        L5f:
            r4 = r1
        L60:
            if (r4 != 0) goto L63
            r4 = r0
        L63:
            java.lang.String r6 = "mainSwitchTimestamp"
            com.google.gson.JsonElement r3 = r3.get(r6)     // Catch: java.lang.Throwable -> L76
            if (r3 == 0) goto L6f
            java.lang.String r1 = r3.getAsString()     // Catch: java.lang.Throwable -> L76
        L6f:
            if (r1 != 0) goto L72
            goto L73
        L72:
            r0 = r1
        L73:
            r1 = r0
            r0 = r4
            goto L77
        L76:
            r1 = r0
        L77:
            kotlin.Pair r0 = kotlin.TuplesKt.a(r0, r1)
            java.lang.Object r0 = r0.getFirst()
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r1)
            if (r0 != 0) goto L8d
            java.lang.String r9 = "main msg switch is closed,return"
            com.cloud.tmc.kernel.log.TmcLogger.d(r5, r9)
            return
        L8d:
            com.cloud.tmc.miniapp.utils.MessageBubbleUtils$requestMsgInfo$1 r0 = new com.cloud.tmc.miniapp.utils.MessageBubbleUtils$requestMsgInfo$1
            r0.<init>()
            r8.OooO00o(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.utils.MessageBubbleUtils.OooO0O0(com.cloud.tmc.integration.structure.App, com.cloud.tmc.miniapp.utils.OooO0O0):void");
    }

    public final boolean OooO0O0() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINI_MSG_ENABLE, false);
        } catch (Throwable th2) {
            TmcLogger.e("MessageBubbleUtils", th2);
            return false;
        }
    }
}
