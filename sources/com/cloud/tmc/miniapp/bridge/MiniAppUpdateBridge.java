package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.MiniAppUpdateMessageStore;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.annotation.ActionFilter;
import com.cloud.tmc.kernel.annotation.ThreadType;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode;
import com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.utils.OooOOO;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class MiniAppUpdateBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();
    public static final String ERROR_MSG_100010 = "Download failed: 100010";
    public static final String ERROR_MSG_100011 = "Decompression failed: 100011";
    public static final String ERROR_MSG_100012 = "Start failed: 100012";
    public static final String ERROR_MSG_100013 = "Preload failed: 100013";
    public static final String ERROR_MSG_100014 = "This root was not found: 100014";
    public static final String ERROR_MSG_10009 = "Preloading,please try later: MAU10009";

    /* loaded from: classes3.dex */
    public static final class OooO extends Lambda implements Function1<BaseResponse<? extends Object>, Unit> {
        public final /* synthetic */ App OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ long OooO0Oo;
        public final /* synthetic */ BridgeCallback OooO0o0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO(App app, String str, long j11, BridgeCallback bridgeCallback) {
            super(1);
            this.OooO0O0 = app;
            this.OooO0OO = str;
            this.OooO0Oo = j11;
            this.OooO0o0 = bridgeCallback;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            BaseResponse it = (BaseResponse) obj;
            Intrinsics.h(it, "it");
            MiniAppUpdateBridge miniAppUpdateBridge = MiniAppUpdateBridge.this;
            App app = this.OooO0O0;
            miniAppUpdateBridge.OooO00o(it, app, this.OooO0OO, this.OooO0Oo, new com.cloud.tmc.miniapp.bridge.OooO0o(app, this.OooO0o0));
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ App OooO00o;
        public final /* synthetic */ BridgeCallback OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(App app, BridgeCallback bridgeCallback) {
            super(0);
            this.OooO00o = app;
            this.OooO0O0 = bridgeCallback;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            this.OooO00o.putBooleanValue(TmcConstants.MINIAPP_HAS_UPDATE_DOWNLOADING, false);
            this.OooO0O0.sendSuccessResponse();
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function3<String, String, IOException, Unit> {
        public final /* synthetic */ App OooO00o;
        public final /* synthetic */ BridgeCallback OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0OO(App app, BridgeCallback bridgeCallback) {
            super(3);
            this.OooO00o = app;
            this.OooO0O0 = bridgeCallback;
        }

        @Override // kotlin.jvm.functions.Function3
        public Object invoke(Object obj, Object obj2, Object obj3) {
            Intrinsics.h((String) obj, "<anonymous parameter 0>");
            Intrinsics.h((IOException) obj3, "<anonymous parameter 2>");
            this.OooO00o.putBooleanValue(TmcConstants.MINIAPP_HAS_UPDATE_DOWNLOADING, false);
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Failed to download the applet package, please try later: MAU10007", this.OooO0O0);
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o extends Lambda implements Function1<BaseResponse<? extends AppInfoModel>, Unit> {
        public final /* synthetic */ App OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ long OooO0Oo;
        public final /* synthetic */ BridgeCallback OooO0o;
        public final /* synthetic */ boolean OooO0o0;
        public final /* synthetic */ Context OooO0oO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0o(App app, String str, long j11, boolean z10, BridgeCallback bridgeCallback, Context context) {
            super(1);
            this.OooO0O0 = app;
            this.OooO0OO = str;
            this.OooO0Oo = j11;
            this.OooO0o0 = z10;
            this.OooO0o = bridgeCallback;
            this.OooO0oO = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            BaseResponse it = (BaseResponse) obj;
            Intrinsics.h(it, "it");
            try {
                MiniAppUpdateBridge miniAppUpdateBridge = MiniAppUpdateBridge.this;
                App app = this.OooO0O0;
                miniAppUpdateBridge.OooO00o(it, app, this.OooO0OO, this.OooO0Oo, this.OooO0o0, new com.cloud.tmc.miniapp.bridge.OooO0O0(app, this.OooO0oO, this.OooO0o), new com.cloud.tmc.miniapp.bridge.OooO0OO(this.OooO0O0, this.OooO0o));
            } catch (Throwable th2) {
                TmcLogger.e("MiniAppUpdateBridge", th2);
                this.OooO0O0.putBooleanValue(TmcConstants.MINIAPP_HAS_UPDATE_REQUESTING, false);
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "AppInfo request failed, please try again later: MAU10004", this.OooO0o);
            }
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 implements com.cloud.tmc.miniapp.prepare.callback.OooO0O0 {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ JsonObject OooO0O0;

        public OooOO0(BridgeCallback bridgeCallback, JsonObject jsonObject) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = jsonObject;
        }

        @Override // com.cloud.tmc.miniapp.prepare.callback.OooO0O0
        public void OooO00o() {
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        }

        @Override // com.cloud.tmc.miniapp.prepare.callback.OooO0O0
        public void OooO00o(String errorMessage) {
            Intrinsics.h(errorMessage, "errorMessage");
            this.OooO0O0.addProperty("errMsg", errorMessage);
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(this.OooO0O0);
            }
        }
    }

    public static /* synthetic */ void requestAppInfoFailed$default(MiniAppUpdateBridge miniAppUpdateBridge, BaseResponse baseResponse, App app, String str, long j11, Function0 function0, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            function0 = null;
        }
        miniAppUpdateBridge.OooO00o(baseResponse, app, str, j11, function0);
    }

    public final void OooO00o(BaseResponse<? extends Object> baseResponse, App app, String str, long j11, Function0<Unit> function0) {
        String appId = app.getAppId();
        Intrinsics.g(appId, "app.appId");
        OooO00o(appId, TmcConstants.CHANNEL_REQUEST_SERVER_API, false, str, j11, false);
        TmcLogger.d("MiniAppUpdateBridge", "requestAppInfoFailed: " + baseResponse.getMessage());
        if (baseResponse.getCode() == 30004) {
            try {
                FileUtil.INSTANCE.delectMiniapp(app.getAppId());
            } catch (Throwable th2) {
                TmcLogger.e("MiniAppUpdateBridge", th2);
            }
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void OooO00o(BaseResponse<AppInfoModel> baseResponse, App app, String str, long j11, boolean z10, Function0<Unit> function0, Function0<Unit> function02) {
        String appId;
        String appId2;
        AppInfoModel data = baseResponse.getData();
        if (data == null || (appId = data.getAppId()) == null || appId.length() == 0) {
            TmcLogger.d("MiniAppUpdateBridge", "requestAppInfoSuccess: appInfoModel or appId is null");
            OooO00o(new BaseResponse<>(0, null, null, null, 15, null), app, str, j11, function02);
            return;
        }
        String appId3 = app.getAppId();
        Intrinsics.g(appId3, "app.appId");
        OooO00o(appId3, TmcConstants.CHANNEL_REQUEST_SERVER_API, true, str, j11, false);
        AppModel generateAppModel = MiniAppLaunch.INSTANCE.generateAppModel(data);
        generateAppModel.setDevMode(z10);
        AppContext appContext = app.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null || (appId2 = app.getAppId()) == null) {
            return;
        }
        ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).updateAppModel(context, generateAppModel, appId2 + "_pre");
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void OooO00o(String str, String str2, boolean z10, String str3, long j11, boolean z11) {
        try {
            long currentTimeMillis = System.currentTimeMillis() - j11;
            Bundle bundle = new Bundle();
            bundle.putString("request_channel", str2);
            bundle.putLong(TrackingKey.REQUEST_TIME, currentTimeMillis);
            bundle.putBoolean("enable_cdn_request", z11);
            bundle.putString("request_token", str3);
            bundle.putBoolean("request_status", z10);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(str, "miniapp_appinfo_network", bundle);
            TmcLogger.d("MiniAppUpdateBridge", "reportNetworkTrack->request_channel:" + str2 + ",request_time:" + currentTimeMillis + ",enable_cdn_request:" + z11 + ",request_token:" + str3 + ",request_status:" + z10);
        } catch (Throwable th2) {
            TmcLogger.e("MiniAppUpdateBridge", th2);
        }
    }

    @ActionFilter("appUpdateApplyUpdate")
    @ThreadType(ExecutorType.UI)
    public final void applyUpdate(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String appId;
        AppContext appContext;
        Intrinsics.h(callback, "callback");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (app == null || context == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: MAU10001", callback);
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String appId2 = app.getAppId();
        Intrinsics.g(appId2, "app.appId");
        if (!miniAppLaunch.isNeedUpdate(context, appId2) || !(context instanceof MiniAppActivity)) {
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "There is no latest applet package to upgrade: MAU10008", callback);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(TmcConstants.EXTRA_APP_ID, app.getAppId());
        bundle.putString("mode", app.getStartParams().getString("mode"));
        bundle.putString("version", app.getStartParams().getString("version"));
        bundle.putString(TmcConstants.EXTRA_APP_DEV_TOKEN, app.getStartParams().getString(TmcConstants.EXTRA_APP_DEV_TOKEN));
        Unit unit = Unit.f67184a;
        ((MiniAppActivity) context).reload(true, bundle);
        callback.sendSuccessResponse();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter("appUpdateDownloadNew")
    @ThreadType(ExecutorType.NETWORK)
    public final void downloadNew(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        AppContext appContext;
        Intrinsics.h(callback, "callback");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (app == null || context == null) {
            callback.sendFailResponse();
            return;
        }
        try {
            if (!app.getBooleanValue(TmcConstants.MINIAPP_HAS_UPDATE)) {
                TmcLogger.d("MiniAppUpdateBridge", "has not app update");
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "There is no App update content, please use forceUpdateAppInfo to check first: MAU10005");
                callback.sendFailResponse(jsonObject);
                return;
            }
            AppModel appModelFromPre = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModelFromPre(context, app.getAppId());
            if (appModelFromPre == null) {
                TmcLogger.d("MiniAppUpdateBridge", "appModelNew not found");
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "There is no App update content, please use forceUpdateAppInfo to check first: MAU10005");
                callback.sendFailResponse(jsonObject2);
                return;
            }
            if (!NetworkUtils.isConnected()) {
                TmcLogger.d("MiniAppUpdateBridge", "network is not connect");
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("errMsg", "The network is abnormal, please check the network: MAU10003");
                callback.sendFailResponse(jsonObject3);
                return;
            }
            if (app.getBooleanValue(TmcConstants.MINIAPP_HAS_UPDATE_DOWNLOADING)) {
                TmcLogger.d("MiniAppUpdateBridge", "miniapp package downloading");
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("errMsg", "Downloading, please try later: MAU10006");
                callback.sendFailResponse(jsonObject4);
                return;
            }
            if (((TmcResourceManager) TmcProxy.get(TmcResourceManager.class)).isDownloaded(context, appModelFromPre)) {
                callback.sendSuccessResponse();
            } else {
                app.putBooleanValue(TmcConstants.MINIAPP_HAS_UPDATE_DOWNLOADING, true);
                MiniAppLaunch.backgroundDownZip$default(MiniAppLaunch.INSTANCE, context, appModelFromPre, 3, new OooO0O0(app, callback), new OooO0OO(app, callback), null, 32, null);
            }
        } catch (Throwable th2) {
            TmcLogger.e("MiniAppUpdateBridge", th2);
            callback.sendFailResponse();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007d A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:11:0x0027, B:14:0x0061, B:16:0x006a, B:20:0x0077, B:22:0x007d, B:25:0x0090, B:27:0x0096, B:29:0x00a9), top: B:10:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0090 A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:11:0x0027, B:14:0x0061, B:16:0x006a, B:20:0x0077, B:22:0x007d, B:25:0x0090, B:27:0x0096, B:29:0x00a9), top: B:10:0x0027 }] */
    @com.cloud.tmc.kernel.annotation.ActionFilter("appUpdateForceUpdateAppInfo")
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.NETWORK)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void forceUpdateAppInfo(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r17, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r18) {
        /*
            r16 = this;
            r0 = r17
            r10 = r18
            java.lang.String r1 = "miniAppHasUpdateRequesting"
            java.lang.String r2 = "_"
            java.lang.String r11 = "MiniAppUpdateBridge"
            java.lang.String r3 = "callback"
            kotlin.jvm.internal.Intrinsics.h(r10, r3)
            if (r0 == 0) goto L1d
            com.cloud.tmc.integration.structure.AppContext r3 = r17.getAppContext()
            if (r3 == 0) goto L1d
            android.content.Context r3 = r3.getContext()
        L1b:
            r9 = r3
            goto L1f
        L1d:
            r3 = 0
            goto L1b
        L1f:
            java.lang.String r3 = "errMsg"
            if (r0 == 0) goto Ld3
            if (r9 != 0) goto L27
            goto Ld3
        L27:
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r6 = r17.getAppId()     // Catch: java.lang.Throwable -> L5e
            double r7 = java.lang.Math.random()     // Catch: java.lang.Throwable -> L5e
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            r12.<init>()     // Catch: java.lang.Throwable -> L5e
            r12.append(r4)     // Catch: java.lang.Throwable -> L5e
            r12.append(r2)     // Catch: java.lang.Throwable -> L5e
            r12.append(r6)     // Catch: java.lang.Throwable -> L5e
            r12.append(r2)     // Catch: java.lang.Throwable -> L5e
            r12.append(r7)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L5e
            long r13 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5e
            android.os.Bundle r2 = r17.getStartParams()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r4 = "mode"
            java.lang.String r2 = r2.getString(r4)     // Catch: java.lang.Throwable -> L5e
            if (r2 != 0) goto L61
            java.lang.String r2 = ""
            goto L61
        L5e:
            r0 = move-exception
            goto Lcc
        L61:
            java.lang.String r4 = "debug"
            r5 = 1
            boolean r4 = kotlin.text.StringsKt.H(r4, r2, r5)     // Catch: java.lang.Throwable -> L5e
            if (r4 != 0) goto L76
            java.lang.String r4 = "dev"
            boolean r2 = kotlin.text.StringsKt.H(r4, r2, r5)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L73
            goto L76
        L73:
            r2 = 0
            r7 = r2
            goto L77
        L76:
            r7 = r5
        L77:
            boolean r2 = com.cloud.tmc.miniutils.util.NetworkUtils.isConnected()     // Catch: java.lang.Throwable -> L5e
            if (r2 != 0) goto L90
            java.lang.String r0 = "network is not connect"
            com.cloud.tmc.kernel.log.TmcLogger.d(r11, r0)     // Catch: java.lang.Throwable -> L5e
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L5e
            r0.<init>()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r1 = "The network is abnormal, please check the network: MAU10003"
            r0.addProperty(r3, r1)     // Catch: java.lang.Throwable -> L5e
            r10.sendFailResponse(r0)     // Catch: java.lang.Throwable -> L5e
            return
        L90:
            boolean r2 = r0.getBooleanValue(r1)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto La9
            java.lang.String r0 = "appInfo requesting"
            com.cloud.tmc.kernel.log.TmcLogger.d(r11, r0)     // Catch: java.lang.Throwable -> L5e
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L5e
            r0.<init>()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r1 = "Requesting, please try later: MAU10002"
            r0.addProperty(r3, r1)     // Catch: java.lang.Throwable -> L5e
            r10.sendFailResponse(r0)     // Catch: java.lang.Throwable -> L5e
            return
        La9:
            r0.putBooleanValue(r1, r5)     // Catch: java.lang.Throwable -> L5e
            com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge$OooO0o r15 = new com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge$OooO0o     // Catch: java.lang.Throwable -> L5e
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r12
            r5 = r13
            r8 = r18
            r1.<init>(r3, r4, r5, r7, r8, r9)     // Catch: java.lang.Throwable -> L5e
            com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge$OooO r8 = new com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge$OooO     // Catch: java.lang.Throwable -> L5e
            r1 = r8
            r2 = r16
            r3 = r17
            r4 = r12
            r5 = r13
            r7 = r18
            r1.<init>(r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L5e
            com.cloud.tmc.integration.utils.MiniRequestUtils.updateAppInfo(r0, r15, r8)     // Catch: java.lang.Throwable -> L5e
            goto Ld2
        Lcc:
            com.cloud.tmc.kernel.log.TmcLogger.e(r11, r0)
            r18.sendFailResponse()
        Ld2:
            return
        Ld3:
            java.lang.String r0 = "Parameter error: MAU10001"
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o(r3, r0, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.bridge.MiniAppUpdateBridge.forceUpdateAppInfo(com.cloud.tmc.integration.structure.App, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void loadSubPackage(@BindingNode(App.class) App app, @BindingParam({"root"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.h(app, "app");
        try {
            AppContext appContext = app.getAppContext();
            Context context = appContext != null ? appContext.getContext() : null;
            String appId = app.getAppId();
            JsonObject jsonObject = new JsonObject();
            if (str != null && str.length() != 0 && context != null && appId != null && appId.length() != 0) {
                Intrinsics.g(appId, "appId");
                Bundle startParams = app.getStartParams();
                Intrinsics.g(startParams, "app.startParams");
                Bundle sceneParams = app.getSceneParams();
                Intrinsics.g(sceneParams, "app.sceneParams");
                OooOOO.OooO00o(appId, str, startParams, sceneParams, context, new OooOO0(bridgeCallback, jsonObject));
                return;
            }
            jsonObject.addProperty("errMsg", "param is invalid: 10001");
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(jsonObject);
            }
        } catch (Throwable th2) {
            TmcLogger.e("AppBridge", th2);
        }
    }

    @ActionFilter("appUpdateOnCheckForUpdate")
    @ThreadType(ExecutorType.UI)
    public final void onCheckForUpdate(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String appId;
        Intrinsics.h(callback, "callback");
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: MAU10001", callback);
        } else {
            ((MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class, true)).getOnCheckForUpdate().put(app.getAppId(), callback);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
        TmcLogger.d("MiniAppUpdateBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
        TmcLogger.d("MiniAppUpdateBridge", "onInitialized");
    }

    @ActionFilter("appUpdateOnUpdateFailed")
    @ThreadType(ExecutorType.UI)
    public final void onUpdateFailed(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String appId;
        Intrinsics.h(callback, "callback");
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: MAU10001", callback);
        } else {
            ((MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class, true)).getOnUpdateFailed().put(app.getAppId(), callback);
        }
    }

    @ActionFilter("appUpdateOnUpdateReady")
    @ThreadType(ExecutorType.UI)
    public final void onUpdateReady(@BindingNode(App.class) App app, @BindingCallback BridgeCallback callback) {
        String appId;
        Intrinsics.h(callback, "callback");
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: MAU10001", callback);
        } else {
            ((MiniAppUpdateMessageStore) app.getData(MiniAppUpdateMessageStore.class, true)).getOnUpdateReady().put(app.getAppId(), callback);
        }
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void preStrategy(@BindingNode(App.class) App app, @BindingParam({"preList"}) String str, @BindingParam({"scene"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        AppContext appContext = app.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        try {
            Object fromJson = GsonUtils.fromJson(str, (Class<Object>) List.class);
            List<String> list = fromJson instanceof List ? (List) fromJson : null;
            if (list == null) {
                list = new ArrayList<>();
            }
            PreStrategyManager.OooO00o.OooO00o(context, list, str2);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e("MiniAppUpdateBridge", th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }
    }
}
