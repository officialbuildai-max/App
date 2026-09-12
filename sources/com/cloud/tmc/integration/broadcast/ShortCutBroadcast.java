package com.cloud.tmc.integration.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.R;
import com.cloud.tmc.integration.model.AddToHomeScreenStore;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.CreateShortCutUtils;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.google.gson.JsonObject;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/cloud/tmc/integration/broadcast/ShortCutBroadcast;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class ShortCutBroadcast extends BroadcastReceiver {
    private final String TAG = "ShortCutBroadcast";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceive$lambda$4(Context context, String str, boolean z10, ShortCutBroadcast this$0, int i11, String extraAddHomeLocation) {
        Boolean valueOf;
        AddToHomeScreenStore addToHomeScreenStore;
        HashMap<String, BridgeCallback> store;
        BridgeCallback remove;
        Resources resources;
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(extraAddHomeLocation, "$extraAddHomeLocation");
        String str2 = null;
        if (context != null) {
            try {
                valueOf = Boolean.valueOf(((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getBoolean(context, TmcConstants.KEY_STORAGE_ADD_HOME, "addHomeStatus_" + str, false));
            } catch (Throwable th2) {
                TmcLogger.e(this$0.TAG, th2);
                return;
            }
        } else {
            valueOf = null;
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        Bundle bundle = new Bundle();
        bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, extraAddHomeLocation);
        Boolean bool = Boolean.TRUE;
        bundle.putString("old_state", Intrinsics.c(valueOf, bool) ? "0" : "1");
        Unit unit = Unit.f67184a;
        performanceAnalyseProxy.recordForCommon(str, "add_succ", bundle);
        if (context != null) {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, TmcConstants.KEY_STORAGE_ADD_HOME, "addHomeStatus_" + str, true);
        }
        if (z10) {
            ToastProxy toastProxy = (ToastProxy) TmcProxy.get(ToastProxy.class);
            if (context != null && (resources = context.getResources()) != null) {
                str2 = resources.getString(R.string.smallapp_create_success);
            }
            toastProxy.toast(str2);
        }
        TmcLogger.d(this$0.TAG, "检查 addHomeToScreen 设置桌面快捷方式 callback");
        CreateShortCutUtils createShortCutUtils = CreateShortCutUtils.INSTANCE;
        App app = createShortCutUtils.getAppMap().get(str);
        if (app != null && (addToHomeScreenStore = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class)) != null && (store = addToHomeScreenStore.getStore()) != null && (remove = store.remove(str)) != null) {
            JsonObject jsonObject = new JsonObject();
            TmcLogger.d(this$0.TAG, "发送 addHomeToScreen callback received");
            jsonObject.addProperty(TmcConstants.KEY_STORAGE_ADD_HOME_IS_EXIST, bool);
            remove.sendSuccessResponse(jsonObject);
        }
        if (i11 == 1) {
            App app2 = createShortCutUtils.getAppMap().get(str);
            if (app2 != null) {
                app2.backPressed();
                return;
            }
            return;
        }
        if (i11 == 2) {
            App app3 = createShortCutUtils.getAppMap().get(str);
            if (app3 != null) {
                app3.exit();
                return;
            }
            return;
        }
        try {
            App findApp = ((AppManager) TmcProxy.get(AppManager.class)).findApp(str);
            if (findApp != null) {
                findApp.hideMiniAppAddHomeBar();
            }
        } catch (Throwable th3) {
            TmcLogger.e(this$0.TAG, "onReceive error: ", th3);
        }
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[Catch: all -> 0x000a, TryCatch #0 {all -> 0x000a, blocks: (B:29:0x0002, B:5:0x0011, B:8:0x0019, B:10:0x0027, B:13:0x0031, B:18:0x003f, B:20:0x0047, B:26:0x00ab), top: B:28:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(final android.content.Context r8, android.content.Intent r9) {
        /*
            r7 = this;
            if (r9 == 0) goto Ld
            java.lang.String r0 = "miniAppId"
            java.lang.String r9 = r9.getStringExtra(r0)     // Catch: java.lang.Throwable -> La
        L8:
            r2 = r9
            goto Lf
        La:
            r8 = move-exception
            goto Lb3
        Ld:
            r9 = 0
            goto L8
        Lf:
            if (r2 == 0) goto Lab
            int r9 = r2.length()     // Catch: java.lang.Throwable -> La
            if (r9 != 0) goto L19
            goto Lab
        L19:
            com.cloud.tmc.integration.utils.CreateShortCutUtils r9 = com.cloud.tmc.integration.utils.CreateShortCutUtils.INSTANCE     // Catch: java.lang.Throwable -> La
            java.util.concurrent.ConcurrentHashMap r9 = r9.getAddHomeData()     // Catch: java.lang.Throwable -> La
            java.lang.Object r9 = r9.get(r2)     // Catch: java.lang.Throwable -> La
            com.cloud.tmc.integration.model.MiniAddHomeModel r9 = (com.cloud.tmc.integration.model.MiniAddHomeModel) r9     // Catch: java.lang.Throwable -> La
            if (r9 == 0) goto L2d
            int r0 = r9.getSourceType()     // Catch: java.lang.Throwable -> La
        L2b:
            r5 = r0
            goto L2f
        L2d:
            r0 = -1
            goto L2b
        L2f:
            if (r9 == 0) goto L3a
            java.lang.String r0 = r9.getLocation()     // Catch: java.lang.Throwable -> La
            if (r0 != 0) goto L38
            goto L3a
        L38:
            r6 = r0
            goto L3d
        L3a:
            java.lang.String r0 = ""
            goto L38
        L3d:
            if (r9 == 0) goto L45
            boolean r9 = r9.getShowSuccessToast()     // Catch: java.lang.Throwable -> La
        L43:
            r3 = r9
            goto L47
        L45:
            r9 = 1
            goto L43
        L47:
            java.lang.String r9 = r7.TAG     // Catch: java.lang.Throwable -> La
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La
            r0.<init>()     // Catch: java.lang.Throwable -> La
            java.lang.String r1 = "appId -> "
            r0.append(r1)     // Catch: java.lang.Throwable -> La
            r0.append(r2)     // Catch: java.lang.Throwable -> La
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La
            com.cloud.tmc.kernel.log.TmcLogger.d(r9, r0)     // Catch: java.lang.Throwable -> La
            java.lang.String r9 = r7.TAG     // Catch: java.lang.Throwable -> La
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La
            r0.<init>()     // Catch: java.lang.Throwable -> La
            java.lang.String r1 = "exteaAddHomeType:->"
            r0.append(r1)     // Catch: java.lang.Throwable -> La
            r0.append(r5)     // Catch: java.lang.Throwable -> La
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La
            com.cloud.tmc.kernel.log.TmcLogger.d(r9, r0)     // Catch: java.lang.Throwable -> La
            java.lang.String r9 = r7.TAG     // Catch: java.lang.Throwable -> La
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La
            r0.<init>()     // Catch: java.lang.Throwable -> La
            java.lang.String r1 = "showSuccessToast:->"
            r0.append(r1)     // Catch: java.lang.Throwable -> La
            r0.append(r3)     // Catch: java.lang.Throwable -> La
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La
            com.cloud.tmc.kernel.log.TmcLogger.d(r9, r0)     // Catch: java.lang.Throwable -> La
            java.lang.String r9 = r7.TAG     // Catch: java.lang.Throwable -> La
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La
            r0.<init>()     // Catch: java.lang.Throwable -> La
            java.lang.String r1 = "extraAddHomeLocation:->"
            r0.append(r1)     // Catch: java.lang.Throwable -> La
            r0.append(r6)     // Catch: java.lang.Throwable -> La
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La
            com.cloud.tmc.kernel.log.TmcLogger.d(r9, r0)     // Catch: java.lang.Throwable -> La
            com.cloud.tmc.integration.broadcast.a r9 = new com.cloud.tmc.integration.broadcast.a     // Catch: java.lang.Throwable -> La
            r0 = r9
            r1 = r8
            r4 = r7
            r0.<init>()     // Catch: java.lang.Throwable -> La
            com.cloud.tmc.kernel.utils.ExecutorUtils.runOnMain(r9)     // Catch: java.lang.Throwable -> La
            goto Lba
        Lab:
            java.lang.String r8 = r7.TAG     // Catch: java.lang.Throwable -> La
            java.lang.String r9 = "appid is null"
            com.cloud.tmc.kernel.log.TmcLogger.d(r8, r9)     // Catch: java.lang.Throwable -> La
            return
        Lb3:
            java.lang.String r9 = r7.TAG
            java.lang.String r0 = "onReceive error: "
            com.cloud.tmc.kernel.log.TmcLogger.e(r9, r0, r8)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.broadcast.ShortCutBroadcast.onReceive(android.content.Context, android.content.Intent):void");
    }
}
