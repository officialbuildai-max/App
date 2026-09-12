package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.proxy.LauncherReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.integration.utils.MiniForceAddHomeManager;
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
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.CommonAppUtils;
import com.cloud.tmc.miniapp.dialog.o0O0O00;
import com.cloud.tmc.miniapp.dialog.oo0o0Oo;
import com.google.gson.JsonObject;
import com.transsion.push.PushConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class PrivacyBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();
    public static final ConcurrentHashMap<String, oo0o0Oo> OooO0O0 = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, o0O0O00> OooO0OO = new ConcurrentHashMap<>();
    public final String OooO00o = "PrivacyBridge";

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPrivacyDialogMap$cp() {
        return OooO0O0;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPrivacySimpleDialogMap$cp() {
        return OooO0OO;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void checkEnableMfah(@BindingCallback BridgeCallback bridgeCallback) {
        boolean z10 = true;
        try {
            z10 = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigBoolean(LauncherMiniAppConfigHelper.KEY_ENABLE_FORCE_ADD_HOME, true);
        } catch (Throwable unused) {
        }
        if (bridgeCallback != null) {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, Boolean.valueOf(z10));
                bridgeCallback.sendSuccessResponse(jsonObject);
            } catch (Throwable th2) {
                callbackFail(bridgeCallback, String.valueOf(th2.getMessage()), Boolean.FALSE);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void checkLoadingSuccess(@BindingNode(App.class) App app, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        String appId = app != null ? app.getAppId() : null;
        if (bridgeCallback == null) {
            TmcLogger.d(this.OooO00o, "checkLoadingSuccess callback is null");
            return;
        }
        if (appId == null || appId.length() == 0) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("error", "appid is null");
            bridgeCallback.sendFailResponse(jsonObject);
            bridgeCallback.close();
            return;
        }
        if (app.getHideMiniAppLoadingStatus()) {
            TmcLogger.d(this.OooO00o, "checkLoadingSuccesshide MiniAppLoadingStatus is true");
            MiniForceAddHomeManager.INSTANCE.notifyHideLoading(appId, bridgeCallback);
            return;
        }
        TmcLogger.d(this.OooO00o, "checkLoadingSuccess appId: " + appId);
        MiniForceAddHomeManager.INSTANCE.addHideLoadingCallback(appId, bridgeCallback);
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void getForceAddHomeList(@BindingParam({"appId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        String str2 = "[]";
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(bridgeCallback, "appId is null or empty", Boolean.FALSE);
            return;
        }
        try {
            str2 = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_PRIVACY_FORCE_ADD_HOME_LIST, "[]");
        } catch (Throwable unused) {
        }
        if (bridgeCallback != null) {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("forceList", str2);
                bridgeCallback.sendSuccessResponse(jsonObject);
            } catch (Throwable th2) {
                callbackFail(bridgeCallback, String.valueOf(th2.getMessage()), Boolean.FALSE);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void getPrivacyWhiteList(@BindingParam({"appId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        String str2 = "[]";
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(bridgeCallback, "appId is null or empty", Boolean.FALSE);
            return;
        }
        try {
            str2 = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_PRIVACY_AGREEMENT_DIALOG_WHITE_LIST_V4, "[]");
        } catch (Throwable unused) {
        }
        if (bridgeCallback != null) {
            try {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("privacyWhiteList", str2);
                bridgeCallback.sendSuccessResponse(jsonObject);
            } catch (Throwable th2) {
                callbackFail(bridgeCallback, String.valueOf(th2.getMessage()), Boolean.FALSE);
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.IO)
    public final void isAutoAgreePrivacy(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.INSTANCE;
                    CommonAppUtils commonAppUtils = CommonAppUtils.INSTANCE;
                    if (miniAppConfigHelper.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_PRIVACY_AUTO_AGREE, commonAppUtils.getDefaultAutoAgreePrivacy()) && commonAppUtils.isTargetApp(context)) {
                        if (bridgeCallback != null) {
                            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("autoAgree", Boolean.TRUE).build());
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(JsonObjectUtils.create().addProperty("autoAgree", Boolean.FALSE).build());
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void privacyAgreementDialogHide(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        String valueOf;
        AppContext appContext;
        if (app != null) {
            try {
                appContext = app.getAppContext();
            } catch (Throwable th2) {
                valueOf = String.valueOf(th2.getMessage());
            }
            if (appContext != null && appContext.getContext() != null) {
                ConcurrentHashMap<String, oo0o0Oo> concurrentHashMap = OooO0O0;
                if (!concurrentHashMap.containsKey(app.getAppId())) {
                    valueOf = "appId:" + app.getAppId() + " cant foud privacyDialog exist";
                    callbackFail(bridgeCallback, valueOf, Boolean.FALSE);
                }
                oo0o0Oo oo0o0oo = concurrentHashMap.get(app.getAppId());
                if (oo0o0oo != null) {
                    oo0o0oo.dismiss();
                }
                concurrentHashMap.remove(app.getAppId());
                MiniForceAddHomeManager miniForceAddHomeManager = MiniForceAddHomeManager.INSTANCE;
                AppModel appModel = app.getAppModel();
                miniForceAddHomeManager.noticeClickAllowBtn(appModel != null ? appModel.getAppId() : null);
                PermissionDialogPoint permissionDialogPoint = (PermissionDialogPoint) ExtensionPoint.as(PermissionDialogPoint.class).create();
                String appId = app.getAppId();
                Intrinsics.g(appId, "app.appId");
                permissionDialogPoint.privacyDialogDismiss(appId, app.getStartToken());
                if (bridgeCallback != null) {
                    bridgeCallback.sendSuccessResponse();
                }
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                String appId2 = app.getAppId();
                Bundle bundle = new Bundle();
                bundle.putString("miniappid", app.getAppId());
                bundle.putString(NativeComponentConstants.KEY_COMPONENT_TYPE, "3");
                Unit unit = Unit.f67184a;
                performanceAnalyseProxy.recordForCommon(appId2, "appstart_add_click", bundle);
                return;
            }
        }
        valueOf = "app error";
        callbackFail(bridgeCallback, valueOf, Boolean.FALSE);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void privacyAgreementDialogShow(@BindingParam({"showLogo"}) Boolean bool, @BindingParam({"title"}) String str, @BindingParam({"titleMaxLine"}) Integer num, @BindingParam({"baseContent"}) String str2, @BindingParam({"privacyPolocyContent"}) String str3, @BindingParam({"userAgreementContent"}) String str4, @BindingParam({"buttonText"}) String str5, @BindingParam({"privacyPolocyUrl"}) String str6, @BindingParam({"userAgreementUrl"}) String str7, @BindingParam({"showAddHome"}) boolean z10, @BindingParam({"showPrivacy"}) boolean z11, @BindingParam({"isNewUser"}) boolean z12, @BindingParam({"useCustomPrivacyContent"}) boolean z13, @BindingParam({"gdprNoticeContent"}) String gdprNoticeContent, @BindingParam({"privacyCancelTv"}) String privacyCancelTv, @BindingParam({"privacyAgreeTv"}) String privacyAgreeTv, @BindingParam({"addhomeCancelTv"}) String addhomeCancelTv, @BindingNode(App.class) App app, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        String valueOf;
        AppContext appContext;
        Context context;
        Intrinsics.h(gdprNoticeContent, "gdprNoticeContent");
        Intrinsics.h(privacyCancelTv, "privacyCancelTv");
        Intrinsics.h(privacyAgreeTv, "privacyAgreeTv");
        Intrinsics.h(addhomeCancelTv, "addhomeCancelTv");
        if (str == null || TextUtils.isEmpty(str)) {
            callbackFail(bridgeCallback, "title is null or empty", Boolean.TRUE);
            return;
        }
        if (z11) {
            if (str2 == null || TextUtils.isEmpty(str2)) {
                callbackFail(bridgeCallback, "baseContent is null or empty", Boolean.TRUE);
                return;
            }
            if (str3 == null || TextUtils.isEmpty(str3)) {
                callbackFail(bridgeCallback, "privacyPolocyContent is null or empty", Boolean.TRUE);
                return;
            } else if (str4 == null || TextUtils.isEmpty(str4)) {
                callbackFail(bridgeCallback, "userAgreementContent is null or empty", Boolean.TRUE);
                return;
            }
        }
        if (str5 == null || TextUtils.isEmpty(str5)) {
            callbackFail(bridgeCallback, "buttonText is null or empty", Boolean.TRUE);
            return;
        }
        int intValue = num != null ? num.intValue() : 1;
        try {
            MiniForceAddHomeManager.INSTANCE.addInterectMFAH(app != null ? app.getAppId() : null);
        } catch (Throwable th2) {
            valueOf = String.valueOf(th2.getMessage());
        }
        if (app == null || (appContext = app.getAppContext()) == null || (context = appContext.getContext()) == null) {
            valueOf = "app error";
            callbackFail(bridgeCallback, valueOf, Boolean.TRUE);
            return;
        }
        TmcLogger.d(this.OooO00o, "privacyAgreementDialogShow -> " + app.getAppId());
        ConcurrentHashMap<String, oo0o0Oo> concurrentHashMap = OooO0O0;
        if (concurrentHashMap.containsKey(app.getAppId())) {
            oo0o0Oo oo0o0oo = concurrentHashMap.get(app.getAppId());
            if (oo0o0oo != null) {
                oo0o0oo.dismiss();
            }
            concurrentHashMap.remove(app.getAppId());
        }
        oo0o0Oo OooO00o2 = new oo0o0Oo(context, app, bridgeCallback).OooO00o(str, intValue, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, str5, str6 == null ? "" : str6, str7 == null ? "" : str7, z10, z11, z12, z13, gdprNoticeContent, privacyCancelTv, privacyAgreeTv, addhomeCancelTv, false, false);
        OooO00o2.show();
        try {
            if (MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_FIT_PRIVACY_NAVIGATION, true)) {
                OooO00o2.OooO();
            }
        } catch (Throwable th3) {
            TmcLogger.e(this.OooO00o, "setNavigationBarColor error", th3);
        }
        ConcurrentHashMap<String, oo0o0Oo> concurrentHashMap2 = OooO0O0;
        String appId = app.getAppId();
        Intrinsics.g(appId, "app.appId");
        concurrentHashMap2.put(appId, OooO00o2);
        if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, PushConstants.PUSH_SERVICE_TYPE_SHOW);
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void privacyAgreementSimpleDialogDismiss(@BindingNode(App.class) App app, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        if (app != null) {
            try {
                ConcurrentHashMap<String, o0O0O00> concurrentHashMap = OooO0OO;
                if (concurrentHashMap.containsKey(app.getAppId())) {
                    o0O0O00 o0o0o00 = concurrentHashMap.get(app.getAppId());
                    if (o0o0o00 != null) {
                        o0o0o00.dismiss();
                    }
                    concurrentHashMap.remove(app.getAppId());
                }
            } catch (Throwable unused) {
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void privacyAgreementSimpleDialogShow(@BindingParam({"title"}) String str, @BindingParam({"baseContent"}) String str2, @BindingParam({"privacyPolocyContent"}) String str3, @BindingParam({"userAgreementContent"}) String str4, @BindingParam({"privacyPolocyUrl"}) String str5, @BindingParam({"userAgreementUrl"}) String str6, @BindingParam({"privacyCancelTv"}) String str7, @BindingParam({"privacyAgreeTv"}) String str8, @BindingParam({"titleMaxLine"}) Integer num, @BindingParam({"useCustomPrivacyContent"}) Boolean bool, @BindingParam(booleanDefault = true, value = {"onlyEnglish"}) Boolean bool2, @BindingNode(App.class) App app, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        Context context;
        String str9;
        String str10 = "";
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    TmcLogger.d(this.OooO00o, "privacyAgreementSimpleDialogShow -> " + app.getAppId());
                    ConcurrentHashMap<String, o0O0O00> concurrentHashMap = OooO0OO;
                    if (concurrentHashMap.containsKey(app.getAppId())) {
                        o0O0O00 o0o0o00 = concurrentHashMap.get(app.getAppId());
                        if (o0o0o00 != null) {
                            o0o0o00.dismiss();
                        }
                        concurrentHashMap.remove(app.getAppId());
                    }
                    String str11 = str == null ? "" : str;
                    if (str11.length() == 0) {
                        str9 = "title is empty";
                    } else {
                        String str12 = str5 == null ? "" : str5;
                        if (str12.length() == 0) {
                            str9 = "privacyPolocyUrl is empty";
                        } else {
                            String str13 = str6 == null ? "" : str6;
                            if (str13.length() == 0) {
                                str9 = "userAgreementUrl is empty";
                            } else {
                                if (!Intrinsics.c(bool, Boolean.TRUE) || ((str2 == null || str2.length() != 0) && ((str3 == null || str3.length() != 0) && (str4 == null || str4.length() != 0)))) {
                                    o0O0O00 OooO00o2 = new o0O0O00(context, app, bridgeCallback).OooO00o(str11, str2, str3 == null ? "" : str3, str4 == null ? "" : str4, str12, str13, str7, str8, num != null ? num.intValue() : 1, bool != null ? bool.booleanValue() : false, bool2 != null ? bool2.booleanValue() : false);
                                    OooO00o2.show();
                                    try {
                                        if (MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_FIT_PRIVACY_NAVIGATION, true)) {
                                            OooO00o2.OooO0Oo();
                                        }
                                    } catch (Throwable th2) {
                                        TmcLogger.e(this.OooO00o, "setNavigationBarColor error", th2);
                                    }
                                    ConcurrentHashMap<String, o0O0O00> concurrentHashMap2 = OooO0OO;
                                    String appId = app.getAppId();
                                    Intrinsics.g(appId, "app.appId");
                                    concurrentHashMap2.put(appId, OooO00o2);
                                    if (bridgeCallback != null) {
                                        JsonObject jsonObject = new JsonObject();
                                        jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, PushConstants.PUSH_SERVICE_TYPE_SHOW);
                                        bridgeCallback.sendSuccessResponse(jsonObject);
                                        return;
                                    }
                                    return;
                                }
                                str9 = "useCustomPrivacyContent, but baseContent OR privacyPolocyContent OR userAgreementContent is empty";
                            }
                        }
                    }
                    str10 = str9;
                }
            } catch (Throwable th3) {
                str10 = String.valueOf(th3.getMessage());
            }
        }
        callbackFail(bridgeCallback, str10, Boolean.FALSE);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void privacyAgreementTwoInOneDialogShow(@BindingParam({"privacyDialogType"}) String str, @BindingParam({"title"}) String str2, @BindingParam({"privacyTitle"}) String str3, @BindingParam({"baseContent"}) String str4, @BindingParam({"privacyPolocyContent"}) String str5, @BindingParam({"userAgreementContent"}) String str6, @BindingParam({"privacyPolocyUrl"}) String str7, @BindingParam({"userAgreementUrl"}) String str8, @BindingParam({"secondPrivacyTitle"}) String str9, @BindingParam({"secondBaseContent"}) String str10, @BindingParam({"secondPrivacyPolocyContent"}) String str11, @BindingParam({"secondUserAgreementContent"}) String str12, @BindingParam({"secondPrivacyPolocyUrl"}) String str13, @BindingParam({"secondUserAgreementUrl"}) String str14, @BindingParam({"gdprNoticeContent"}) String str15, @BindingParam({"highlightContent"}) String str16, @BindingParam({"privacyCancelTv"}) String str17, @BindingParam({"privacyAgreeTv"}) String str18, @BindingParam({"titleMaxLine"}) Integer num, @BindingParam({"useCustomPrivacyContent"}) Boolean bool, @BindingParam(booleanDefault = true, value = {"onlyEnglish"}) Boolean bool2, @BindingNode(App.class) App app, @BindingCallback(isSticky = true) BridgeCallback bridgeCallback) {
        String valueOf;
        AppContext appContext;
        Context context;
        try {
            MiniForceAddHomeManager.INSTANCE.addInterectMFAH(app != null ? app.getAppId() : null);
            valueOf = "";
            if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
                TmcLogger.d(this.OooO00o, "privacyAgreementDialogShow -> " + app.getAppId());
                ConcurrentHashMap<String, oo0o0Oo> concurrentHashMap = OooO0O0;
                if (concurrentHashMap.containsKey(app.getAppId())) {
                    oo0o0Oo oo0o0oo = concurrentHashMap.get(app.getAppId());
                    if (oo0o0oo != null) {
                        oo0o0oo.dismiss();
                    }
                    concurrentHashMap.remove(app.getAppId());
                }
                oo0o0Oo OooO00o2 = new oo0o0Oo(context, app, bridgeCallback).OooO00o(str == null ? "1" : str, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, str5 == null ? "" : str5, str6 == null ? "" : str6, str7 == null ? "" : str7, str8 == null ? "" : str8, str9 == null ? "" : str9, str10 == null ? "" : str10, str11 == null ? "" : str11, str12 == null ? "" : str12, str13 == null ? "" : str13, str14 == null ? "" : str14, str15 == null ? "" : str15, str16 == null ? "" : str16, str17 == null ? "" : str17, str18 == null ? "" : str18, num != null ? num.intValue() : 1, bool != null ? bool.booleanValue() : false, bool2 != null ? bool2.booleanValue() : true);
                OooO00o2.show();
                try {
                    if (MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_FIT_PRIVACY_NAVIGATION, true)) {
                        OooO00o2.OooO();
                    }
                } catch (Throwable th2) {
                    TmcLogger.e(this.OooO00o, "setNavigationBarColor error", th2);
                }
                ConcurrentHashMap<String, oo0o0Oo> concurrentHashMap2 = OooO0O0;
                String appId = app.getAppId();
                Intrinsics.g(appId, "app.appId");
                concurrentHashMap2.put(appId, OooO00o2);
                if (bridgeCallback != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, PushConstants.PUSH_SERVICE_TYPE_SHOW);
                    bridgeCallback.sendSuccessResponse(jsonObject);
                    return;
                }
                return;
            }
        } catch (Throwable th3) {
            valueOf = String.valueOf(th3.getMessage());
        }
        callbackFail(bridgeCallback, valueOf, Boolean.FALSE);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void syncMfahStatus(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        if (app != null) {
            try {
                String appId = app.getAppId();
                if (appId != null && appId.length() > 0) {
                    MiniForceAddHomeManager miniForceAddHomeManager = MiniForceAddHomeManager.INSTANCE;
                    miniForceAddHomeManager.reportAthenaData(app.getAppId());
                    AppContext appContext = app.getAppContext();
                    if (appContext != null && (context = appContext.getContext()) != null) {
                        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, "100000", TmcConstants.KEY_IS_NEW_USER, false);
                        ConcurrentHashMap<String, Boolean> interceptRealMFAHMap = miniForceAddHomeManager.getInterceptRealMFAHMap();
                        String appId2 = app.getAppId();
                        if (appId2 == null) {
                            appId2 = "";
                        }
                        interceptRealMFAHMap.remove(appId2);
                        ((LauncherReportProxy) TmcProxy.get(LauncherReportProxy.class)).reportCacheData(app.getAppId());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (bridgeCallback != null) {
            try {
                bridgeCallback.sendSuccessResponse();
            } catch (Throwable unused2) {
                bridgeCallback.sendSuccessResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void syncUserAllowStatus(@BindingNode(App.class) App app, @BindingParam({"appId"}) String str, @BindingParam({"isClick"}) Boolean bool, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        if (app != null) {
            try {
                String appId = app.getAppId();
                if (appId != null && appId.length() > 0) {
                    MiniForceAddHomeManager.INSTANCE.noticeClickAllowBtn(app != null ? app.getAppId() : null);
                }
            } catch (Throwable unused) {
                if (bridgeCallback != null) {
                    bridgeCallback.sendSuccessResponse();
                    return;
                }
                return;
            }
        }
        try {
            ((LauncherReportProxy) TmcProxy.get(LauncherReportProxy.class)).reportAllCacheData(app != null ? app.getAppId() : null);
        } catch (Throwable unused2) {
        }
        if (app != null) {
            try {
                AppContext appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putBoolean(context, "100000", TmcConstants.KEY_IS_NEW_USER, false);
                    ConcurrentHashMap<String, oo0o0Oo> concurrentHashMap = OooO0O0;
                    if (concurrentHashMap.containsKey(app.getAppId()) || Intrinsics.c(bool, Boolean.FALSE)) {
                        concurrentHashMap.remove(app.getAppId());
                        if (bridgeCallback != null) {
                            bridgeCallback.sendSuccessResponse();
                        }
                        PermissionDialogPoint permissionDialogPoint = (PermissionDialogPoint) ExtensionPoint.as(PermissionDialogPoint.class).create();
                        String appId2 = app.getAppId();
                        Intrinsics.g(appId2, "app.appId");
                        permissionDialogPoint.privacyDialogDismiss(appId2, app.getStartToken());
                        return;
                    }
                }
            } catch (Throwable unused3) {
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void updatePrivacyDialogUI(@BindingParam({"title"}) String str, @BindingParam({"titleMaxLine"}) Integer num, @BindingParam({"baseContent"}) String str2, @BindingParam({"privacyPolocyContent"}) String str3, @BindingParam({"userAgreementContent"}) String str4, @BindingParam({"buttonText"}) String str5, @BindingParam({"privacyPolocyUrl"}) String str6, @BindingParam({"userAgreementUrl"}) String str7, @BindingParam({"showAddHome"}) boolean z10, @BindingParam({"showPrivacy"}) boolean z11, @BindingParam({"isNewUser"}) boolean z12, @BindingParam({"useCustomPrivacyContent"}) boolean z13, @BindingParam({"gdprNoticeContent"}) String gdprNoticeContent, @BindingParam({"privacyCancelTv"}) String privacyCancelTv, @BindingParam({"privacyAgreeTv"}) String privacyAgreeTv, @BindingParam({"addhomeCancelTv"}) String addhomeCancelTv, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        String valueOf;
        String appId;
        Intrinsics.h(gdprNoticeContent, "gdprNoticeContent");
        Intrinsics.h(privacyCancelTv, "privacyCancelTv");
        Intrinsics.h(privacyAgreeTv, "privacyAgreeTv");
        Intrinsics.h(addhomeCancelTv, "addhomeCancelTv");
        if (app != null) {
            try {
                appId = app.getAppId();
            } catch (Throwable th2) {
                valueOf = String.valueOf(th2.getMessage());
            }
        } else {
            appId = null;
        }
        if (appId != null && appId.length() != 0) {
            if (str != null && !TextUtils.isEmpty(str)) {
                if (z11) {
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        if (str3 != null && !TextUtils.isEmpty(str3)) {
                            if (str4 == null || TextUtils.isEmpty(str4)) {
                                callbackFail(bridgeCallback, "userAgreementContent is null or empty", Boolean.TRUE);
                                return;
                            }
                        }
                        callbackFail(bridgeCallback, "privacyPolocyContent is null or empty", Boolean.TRUE);
                        return;
                    }
                    callbackFail(bridgeCallback, "baseContent is null or empty", Boolean.TRUE);
                    return;
                }
                if (str5 != null && !TextUtils.isEmpty(str5)) {
                    int intValue = num != null ? num.intValue() : 1;
                    ConcurrentHashMap<String, oo0o0Oo> concurrentHashMap = OooO0O0;
                    if (!concurrentHashMap.containsKey(appId)) {
                        valueOf = "dialog is not showing";
                        callbackFail(bridgeCallback, valueOf, Boolean.FALSE);
                        return;
                    }
                    oo0o0Oo oo0o0oo = concurrentHashMap.get(appId);
                    if (oo0o0oo != null) {
                        oo0o0oo.OooO00o(str, intValue, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, str5, str6 == null ? "" : str6, str7 == null ? "" : str7, z10, z11, z12, z13, gdprNoticeContent, privacyCancelTv, privacyAgreeTv, addhomeCancelTv, app, false, false);
                    }
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        return;
                    }
                    return;
                }
                callbackFail(bridgeCallback, "buttonText is null or empty", Boolean.TRUE);
                return;
            }
            callbackFail(bridgeCallback, "title is null or empty", Boolean.TRUE);
            return;
        }
        callbackFail(bridgeCallback, "appId is null or empty", Boolean.FALSE);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void updateTwoInOnePrivacyDialogUI(@BindingParam({"privacyDialogType"}) String str, @BindingParam({"title"}) String str2, @BindingParam({"baseContent"}) String str3, @BindingParam({"privacyPolocyContent"}) String str4, @BindingParam({"userAgreementContent"}) String str5, @BindingParam({"privacyPolocyUrl"}) String str6, @BindingParam({"userAgreementUrl"}) String str7, @BindingParam({"gdprNoticeContent"}) String str8, @BindingParam({"privacyCancelTv"}) String str9, @BindingParam({"privacyAgreeTv"}) String str10, @BindingParam({"titleMaxLine"}) Integer num, @BindingParam({"useCustomPrivacyContent"}) Boolean bool, @BindingParam(booleanDefault = true, value = {"onlyEnglish"}) Boolean bool2, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        String valueOf;
        String appId;
        if (app != null) {
            try {
                appId = app.getAppId();
            } catch (Throwable th2) {
                valueOf = String.valueOf(th2.getMessage());
            }
        } else {
            appId = null;
        }
        if (appId != null && appId.length() != 0) {
            ConcurrentHashMap<String, oo0o0Oo> concurrentHashMap = OooO0O0;
            if (!concurrentHashMap.containsKey(appId)) {
                valueOf = "dialog is not showing";
                callbackFail(bridgeCallback, valueOf, Boolean.FALSE);
                return;
            }
            oo0o0Oo oo0o0oo = concurrentHashMap.get(appId);
            if (oo0o0oo != null) {
                String str11 = str == null ? "2" : str;
                String str12 = "";
                String str13 = str2 == null ? "" : str2;
                int intValue = num != null ? num.intValue() : 1;
                String str14 = str3 == null ? "" : str3;
                String str15 = str4 == null ? "" : str4;
                String str16 = str5 == null ? "" : str5;
                String str17 = str6 == null ? "" : str6;
                if (str7 != null) {
                    str12 = str7;
                }
                oo0o0oo.OooO00o(str11, str13, intValue, str14, str15, str16, "", str17, str12, bool != null ? bool.booleanValue() : false, str8, str9, str10, "", bool2 != null ? bool2.booleanValue() : true, app);
            }
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
                return;
            }
            return;
        }
        callbackFail(bridgeCallback, "appId is null or empty", Boolean.FALSE);
    }
}
