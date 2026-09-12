package com.cloud.tmc.miniapp.bridge;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
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
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.util.Map;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class NavigateMiniAppBridge implements BridgeExtension {
    public static final OooO00o Companion = new OooO00o();

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public final void navigateToMiniProgram(@BindingParam({"appId"}) String str, @BindingParam({"path"}) String str2, @BindingParam({"extraData"}) String str3, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        Context context;
        Uri uri;
        String path;
        String decode;
        String str4;
        String str5;
        Boolean m12;
        String str6;
        Boolean m13;
        String str7;
        if (app != null && app.getAppContext() != null) {
            AppContext appContext = app.getAppContext();
            if ((appContext != null ? appContext.getContext() : null) != null && str != null && str.length() != 0) {
                AppContext appContext2 = app.getAppContext();
                if (appContext2 == null || (context = appContext2.getContext()) == null || !(context instanceof Activity)) {
                    return;
                }
                Context launchContext = MiniAppLaunch.INSTANCE.getLaunchContext(str, context);
                Bundle bundle = new Bundle();
                if ((str2 != null && StringsKt.W(str2, "http://", false, 2, null)) || (str2 != null && StringsKt.W(str2, "https://", false, 2, null))) {
                    bundle.putString("page", str2);
                } else if (str2 != null) {
                    try {
                        decode = UrlUtils.decode(str2);
                    } catch (Throwable th2) {
                        TmcLogger.e("NavigateMiniAppBridge", "Unable to decode", th2);
                    }
                    if (decode != null && decode.length() != 0) {
                        uri = Uri.parse(decode);
                        if (uri != null && (path = uri.getPath()) != null && path.length() != 0) {
                            bundle.putString("page", uri.getPath());
                            bundle.putString("query", uri.getQuery());
                        }
                    }
                    uri = null;
                    if (uri != null) {
                        bundle.putString("page", uri.getPath());
                        bundle.putString("query", uri.getQuery());
                    }
                }
                try {
                    Map mapFromJson = TmcGsonUtils.mapFromJson(str3);
                    bundle.putString("scene_id", StringExtKt.orDefault(mapFromJson != null ? (String) mapFromJson.get("scene_id") : null, "100000"));
                    String str8 = mapFromJson != null ? (String) mapFromJson.get(TmcConstants.EXTRA_CURRENT_MINIAPP_ID) : null;
                    String str9 = mapFromJson != null ? (String) mapFromJson.get(TmcConstants.EXTRA_CURRENT_MINIAPP_VERSION) : null;
                    if (str8 != null) {
                        bundle.putString(TmcConstants.EXTRA_CURRENT_MINIAPP_ID, str8);
                    }
                    if (str9 != null) {
                        bundle.putString(TmcConstants.EXTRA_CURRENT_MINIAPP_VERSION, str9);
                    }
                    if (mapFromJson != null && (str7 = (String) mapFromJson.get("extraMiniBackToUrl")) != null) {
                        bundle.putString("extraMiniBackToUrl", str7);
                    }
                    if (mapFromJson != null && (str6 = (String) mapFromJson.get("extraMiniClearAllPages")) != null && (m13 = StringsKt.m1(str6)) != null) {
                        bundle.putBoolean("extraMiniClearAllPages", m13.booleanValue());
                    }
                    if (mapFromJson != null && (str5 = (String) mapFromJson.get("quickMode")) != null && (m12 = StringsKt.m1(str5)) != null) {
                        bundle.putBoolean("quickMode", m12.booleanValue());
                    }
                    if (mapFromJson != null && (str4 = (String) mapFromJson.get("mfah")) != null) {
                        bundle.putString("mfah", str4);
                    }
                    bundle.putString(TmcConstants.EXTRA_DATA, str3);
                } catch (Throwable th3) {
                    TmcLogger.e("NavigateMiniAppBridge", th3);
                }
                Unit unit = Unit.f67184a;
                MiniAppLaunch.launchMiniAppForId(launchContext, str, bundle);
                if (bridgeCallback != null) {
                    bridgeCallback.sendSuccessResponse();
                    return;
                }
                return;
            }
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
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
}
