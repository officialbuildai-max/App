package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.ad.Constants;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppLoadResult;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.EnvironmentUtil;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.integration.utils.ext.PageExtKt;
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
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.security.Permission;
import com.cloud.tmc.kernel.utils.BundleUtils;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.kernel.utils.UrlLauncher;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public class NavigateBridge implements BridgeExtension {
    private static final String TAG = "NavigateBridge";

    private boolean checkTabPage(Bundle bundle, String str) {
        MiniAppConfigModel miniAppConfigModel;
        MiniAppConfigModel.TabBarBean tabBarBean;
        List<MiniAppConfigModel.TabBarBean.ListBean> list;
        AppLoadResult appLoadResult = (AppLoadResult) BundleUtils.getParcelable(bundle, TmcConstants.EXTRA_APP_LOAD_RESULT);
        if (appLoadResult != null && (miniAppConfigModel = appLoadResult.appConfigModel) != null && (tabBarBean = miniAppConfigModel.tabBar) != null && (list = tabBarBean.list) != null) {
            Iterator<MiniAppConfigModel.TabBarBean.ListBean> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().pagePath, Uri.parse(str).getPath())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$navigateBack$0(App app, int i11, boolean z10, JsonObject jsonObject) {
        app.popTo(i11, z10, jsonObject);
        return null;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(BridgeCallback bridgeCallback, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, bridgeCallback, str, bool);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void exit(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            app.exit();
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(new JsonObject());
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void exitMiniProgram(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        exit(app, bridgeCallback);
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void navigateBack(@BindingParam(name = {"delta"}) final int i11, @BindingParam(name = {"autoExit"}) final boolean z10, @BindingParam(name = {"params"}) String str, @BindingNode(App.class) final App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        final JsonObject jsonObject = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                jsonObject = JsonParser.parseString(str).getAsJsonObject();
            }
        } catch (Exception e11) {
            TraceLog.w("Tmcintegration", "parse Json fail : " + e11);
        }
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        if (!PageExtKt.checkAlertBeforeUnload(page, new Function0() { // from class: com.cloud.tmc.integration.bridge.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit lambda$navigateBack$0;
                lambda$navigateBack$0 = NavigateBridge.lambda$navigateBack$0(App.this, i11, z10, jsonObject);
                return lambda$navigateBack$0;
            }
        })) {
            app.popTo(i11, z10, jsonObject);
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(new JsonObject());
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void navigateBackToHeaderPage(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            app.backToHeaderPage();
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(new JsonObject());
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void navigateBackToHomePage(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        try {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_NAV_HOME_PRESSED, "");
            app.exitToHomePage();
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2.getMessage(), th2);
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(new JsonObject());
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void navigateTo(@BindingParam(name = {"url"}) String str, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            TraceLog.w("Tmcintegration", "navigateTo url is empty!!!");
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
        app.putPageType(str, 1);
        app.putRouteType(str, "navigateTo");
        Bundle sceneParams = app.getSceneParams();
        sceneParams.putString("navigationType", "navigateTo");
        app.pushPage(str, app.getStartParams(), sceneParams);
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(new JsonObject());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
    
        r9.sendFailResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0088, code lost:
    
        return;
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.UI)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void navigateToAdLandingPage(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"url"}) java.lang.String r4, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"adInfo"}) java.lang.String r5, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"adsDTO"}) java.lang.String r6, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"pointData"}) java.lang.String r7, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r8, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r9) {
        /*
            r3 = this;
            if (r8 == 0) goto L94
            com.cloud.tmc.integration.structure.AppContext r0 = r8.getAppContext()
            if (r0 == 0) goto L94
            com.cloud.tmc.integration.structure.AppContext r0 = r8.getAppContext()
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L14
            goto L94
        L14:
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L83
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L83
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L27
            goto L83
        L27:
            com.cloud.tmc.integration.structure.AppContext r0 = r8.getAppContext()     // Catch: java.lang.Throwable -> L81
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Throwable -> L81
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Throwable -> L81
            java.lang.Class<com.cloud.tmc.integration.proxy.IAdActivityGetProxy> r2 = com.cloud.tmc.integration.proxy.IAdActivityGetProxy.class
            java.lang.Object r2 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r2)     // Catch: java.lang.Throwable -> L81
            com.cloud.tmc.integration.proxy.IAdActivityGetProxy r2 = (com.cloud.tmc.integration.proxy.IAdActivityGetProxy) r2     // Catch: java.lang.Throwable -> L81
            java.lang.Class r2 = r2.getAdLandingPageActivity()     // Catch: java.lang.Throwable -> L81
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L81
            r2 = 65536(0x10000, float:9.18355E-41)
            r1.setFlags(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "ad_landingPage_url"
            r1.putExtra(r2, r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "adInfo"
            r1.putExtra(r4, r5)     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "adsDTO"
            r1.putExtra(r4, r6)     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "pointData"
            r1.putExtra(r4, r7)     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "appId"
            java.lang.String r5 = r8.getAppId()     // Catch: java.lang.Throwable -> L81
            r1.putExtra(r4, r5)     // Catch: java.lang.Throwable -> L81
            com.cloud.tmc.integration.utils.AppPrepareUtils r4 = com.cloud.tmc.integration.utils.AppPrepareUtils.INSTANCE     // Catch: java.lang.Throwable -> L81
            r4.addCommonIntentParameter(r1, r0)     // Catch: java.lang.Throwable -> L81
            java.lang.Class<com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory> r4 = com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory.class
            java.lang.Object r4 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r4)     // Catch: java.lang.Throwable -> L81
            com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory r4 = (com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory) r4     // Catch: java.lang.Throwable -> L81
            com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter r4 = r4.getEventCenterInstance(r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "adLandingPage"
            com.cloud.tmc.integration.bridge.NavigateBridge$1 r6 = new com.cloud.tmc.integration.bridge.NavigateBridge$1     // Catch: java.lang.Throwable -> L81
            r6.<init>()     // Catch: java.lang.Throwable -> L81
            r4.register(r5, r6)     // Catch: java.lang.Throwable -> L81
            r0.startActivity(r1)     // Catch: java.lang.Throwable -> L81
            goto L93
        L81:
            r4 = move-exception
            goto L89
        L83:
            if (r9 == 0) goto L88
            r9.sendFailResponse()     // Catch: java.lang.Throwable -> L81
        L88:
            return
        L89:
            java.lang.String r5 = "NavigateBridge"
            com.cloud.tmc.kernel.log.TmcLogger.e(r5, r4)
            if (r9 == 0) goto L93
            r9.sendFailResponse()
        L93:
            return
        L94:
            if (r9 == 0) goto L99
            r9.sendFailResponse()
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NavigateBridge.navigateToAdLandingPage(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.cloud.tmc.integration.structure.App, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        r7.sendFailResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
    
        return;
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.UI)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void navigateToApp(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r5, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"packageName"}) java.lang.String r6, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback com.cloud.tmc.kernel.bridge.extension.BridgeCallback r7) {
        /*
            r4 = this;
            if (r5 == 0) goto L96
            com.cloud.tmc.integration.structure.AppContext r0 = r5.getAppContext()
            if (r0 == 0) goto L96
            com.cloud.tmc.integration.structure.AppContext r0 = r5.getAppContext()
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L14
            goto L96
        L14:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L20
            if (r7 == 0) goto L1f
            r7.sendFailResponse()
        L1f:
            return
        L20:
            com.cloud.tmc.integration.structure.AppContext r5 = r5.getAppContext()
            android.content.Context r5 = r5.getContext()
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L39
            r1 = 0
            android.content.pm.PackageInfo r6 = r0.getPackageInfo(r6, r1)     // Catch: java.lang.Throwable -> L39
            if (r6 != 0) goto L3c
            if (r7 == 0) goto L3b
            r7.sendFailResponse()     // Catch: java.lang.Throwable -> L39
            goto L3b
        L39:
            r5 = move-exception
            goto L8b
        L3b:
            return
        L3c:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = "android.intent.action.MAIN"
            r3 = 0
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = "android.intent.category.LAUNCHER"
            r0.addCategory(r2)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = r6.packageName     // Catch: java.lang.Throwable -> L39
            r0.setPackage(r6)     // Catch: java.lang.Throwable -> L39
            android.content.pm.PackageManager r6 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L39
            java.util.List r6 = r6.queryIntentActivities(r0, r1)     // Catch: java.lang.Throwable -> L39
            if (r6 == 0) goto L85
            int r1 = r6.size()     // Catch: java.lang.Throwable -> L39
            if (r1 != 0) goto L5f
            goto L85
        L5f:
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L39
            java.lang.Object r6 = r6.next()     // Catch: java.lang.Throwable -> L39
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6     // Catch: java.lang.Throwable -> L39
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r1)     // Catch: java.lang.Throwable -> L39
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L39
            android.content.pm.ActivityInfo r6 = r6.activityInfo     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = r6.packageName     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = r6.name     // Catch: java.lang.Throwable -> L39
            r1.<init>(r2, r6)     // Catch: java.lang.Throwable -> L39
            r0.setComponent(r1)     // Catch: java.lang.Throwable -> L39
            r5.startActivity(r0)     // Catch: java.lang.Throwable -> L39
            if (r7 == 0) goto L95
            r7.sendSuccessResponse()     // Catch: java.lang.Throwable -> L39
            goto L95
        L85:
            if (r7 == 0) goto L8a
            r7.sendFailResponse()     // Catch: java.lang.Throwable -> L39
        L8a:
            return
        L8b:
            java.lang.String r6 = "NavigateBridge"
            com.cloud.tmc.kernel.log.TmcLogger.e(r6, r5)
            if (r7 == 0) goto L95
            r7.sendFailResponse()
        L95:
            return
        L96:
            if (r7 == 0) goto L9b
            r7.sendFailResponse()
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NavigateBridge.navigateToApp(com.cloud.tmc.integration.structure.App, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void navigateToDeeplink(@BindingNode(App.class) App app, @BindingParam({"deeplink"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "context is null:DP002").build());
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "deeplink is empty:DP003").build());
                return;
            }
            return;
        }
        Context context = app.getAppContext().getContext();
        try {
            Intent intent = new Intent();
            if (str.startsWith("smsto") && str.split(":").length > 2) {
                String substring = str.substring(0, str.indexOf(":") + 1);
                String substring2 = str.substring(str.indexOf(":") + 1);
                int indexOf = substring2.indexOf(":");
                String substring3 = substring2.substring(0, indexOf);
                str = substring + substring3;
                intent.putExtra(Constants.SMS_BODY, URLDecoder.decode(substring2.substring(indexOf + 1), "UTF-8"));
            }
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "deeplink error:DP001," + str).build());
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void navigateToDeeplinkInternal(@BindingNode(App.class) App app, @BindingParam({"deeplink"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "context is null:DP002").build());
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "deeplink is empty:DP003").build());
                return;
            }
            return;
        }
        Context context = app.getAppContext().getContext();
        try {
            Intent intent = new Intent();
            if (str.startsWith("smsto") && str.split(":").length > 2) {
                String substring = str.substring(0, str.indexOf(":") + 1);
                String substring2 = str.substring(str.indexOf(":") + 1);
                int indexOf = substring2.indexOf(":");
                String substring3 = substring2.substring(0, indexOf);
                str = substring + substring3;
                intent.putExtra(Constants.SMS_BODY, URLDecoder.decode(substring2.substring(indexOf + 1), "UTF-8"));
            }
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "deeplink error:DP001," + str).build());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
    
        r9.sendFailResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0088, code lost:
    
        return;
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.UI)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void navigateToFormWeb(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r4, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"url"}) java.lang.String r5, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam({"adInfo"}) java.lang.String r6, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"adsDTO"}) java.lang.String r7, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"pointData"}) java.lang.String r8, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r9) {
        /*
            r3 = this;
            if (r4 == 0) goto L94
            com.cloud.tmc.integration.structure.AppContext r0 = r4.getAppContext()
            if (r0 == 0) goto L94
            com.cloud.tmc.integration.structure.AppContext r0 = r4.getAppContext()
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L14
            goto L94
        L14:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L83
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L83
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L27
            goto L83
        L27:
            com.cloud.tmc.integration.structure.AppContext r0 = r4.getAppContext()     // Catch: java.lang.Throwable -> L81
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Throwable -> L81
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Throwable -> L81
            java.lang.Class<com.cloud.tmc.integration.proxy.IAdActivityGetProxy> r2 = com.cloud.tmc.integration.proxy.IAdActivityGetProxy.class
            java.lang.Object r2 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r2)     // Catch: java.lang.Throwable -> L81
            com.cloud.tmc.integration.proxy.IAdActivityGetProxy r2 = (com.cloud.tmc.integration.proxy.IAdActivityGetProxy) r2     // Catch: java.lang.Throwable -> L81
            java.lang.Class r2 = r2.getAdFormActivity()     // Catch: java.lang.Throwable -> L81
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L81
            r2 = 65536(0x10000, float:9.18355E-41)
            r1.setFlags(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "ad_web_form_url"
            r1.putExtra(r2, r5)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "ad_web_ad_info"
            r1.putExtra(r5, r6)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "adsDTO"
            r1.putExtra(r5, r7)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "pointData"
            r1.putExtra(r5, r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "appId"
            java.lang.String r6 = r4.getAppId()     // Catch: java.lang.Throwable -> L81
            r1.putExtra(r5, r6)     // Catch: java.lang.Throwable -> L81
            com.cloud.tmc.integration.utils.AppPrepareUtils r5 = com.cloud.tmc.integration.utils.AppPrepareUtils.INSTANCE     // Catch: java.lang.Throwable -> L81
            r5.addCommonIntentParameter(r1, r0)     // Catch: java.lang.Throwable -> L81
            java.lang.Class<com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory> r5 = com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory.class
            java.lang.Object r5 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r5)     // Catch: java.lang.Throwable -> L81
            com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory r5 = (com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory) r5     // Catch: java.lang.Throwable -> L81
            com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter r4 = r5.getEventCenterInstance(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = "adFromPage"
            com.cloud.tmc.integration.bridge.NavigateBridge$2 r6 = new com.cloud.tmc.integration.bridge.NavigateBridge$2     // Catch: java.lang.Throwable -> L81
            r6.<init>()     // Catch: java.lang.Throwable -> L81
            r4.register(r5, r6)     // Catch: java.lang.Throwable -> L81
            r0.startActivity(r1)     // Catch: java.lang.Throwable -> L81
            goto L93
        L81:
            r4 = move-exception
            goto L89
        L83:
            if (r9 == 0) goto L88
            r9.sendFailResponse()     // Catch: java.lang.Throwable -> L81
        L88:
            return
        L89:
            java.lang.String r5 = "NavigateBridge"
            com.cloud.tmc.kernel.log.TmcLogger.e(r5, r4)
            if (r9 == 0) goto L93
            r9.sendFailResponse()
        L93:
            return
        L94:
            if (r9 == 0) goto L99
            r9.sendFailResponse()
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NavigateBridge.navigateToFormWeb(com.cloud.tmc.integration.structure.App, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void navigateToOutside(@BindingParam(name = {"url"}) String str, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            TraceLog.w("Tmcintegration", "navigateToOutside url is empty!!!");
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (str.startsWith("http") || str.startsWith("https") || str.startsWith("miniapp://")) {
            app.pushWebViewPage(str, app.getStartParams(), app.getSceneParams());
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(new JsonObject());
                return;
            }
            return;
        }
        TraceLog.w("Tmcintegration", "navigateToOutside url should startwith http or https!!!");
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse();
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void navigateToOutsideBrowser(@BindingParam(name = {"url"}) String str, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            TmcLogger.e("Tmcintegration", "navigateToOutsideBrowser url is empty");
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "navigateToOutsideBrowser url is empty: N001").build());
                return;
            }
            return;
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            TmcLogger.e("Tmcintegration", "navigateToOutsideBrowser url should startWith http or https");
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "navigateToOutsideBrowser url should startWith http or https: N002").build());
                return;
            }
            return;
        }
        boolean openByBrowser = EnvironmentUtil.openByBrowser(app.getAppContext().getContext(), str);
        if (bridgeCallback != null) {
            if (openByBrowser) {
                bridgeCallback.sendSuccessResponse();
            } else {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "navigateToOutsideBrowser open browser failed: N003").build());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
    
        r10.sendFailResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
    
        return;
     */
    @com.cloud.tmc.kernel.annotation.ActionFilter
    @com.cloud.tmc.kernel.annotation.ThreadType(com.cloud.tmc.kernel.executor.ExecutorType.UI)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void navigateToPersonalization(@com.cloud.tmc.kernel.bridge.extension.annotation.BindingNode(com.cloud.tmc.integration.structure.App.class) com.cloud.tmc.integration.structure.App r4, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"trigger_id"}) final java.lang.String r5, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"url"}) java.lang.String r6, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"adsDTO"}) java.lang.String r7, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"app_id_external"}) java.lang.String r8, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingParam(name = {"code_seat_id_external"}) java.lang.String r9, @com.cloud.tmc.kernel.bridge.extension.annotation.BindingCallback final com.cloud.tmc.kernel.bridge.extension.BridgeCallback r10) {
        /*
            r3 = this;
            if (r4 == 0) goto La0
            com.cloud.tmc.integration.structure.AppContext r0 = r4.getAppContext()
            if (r0 == 0) goto La0
            com.cloud.tmc.integration.structure.AppContext r0 = r4.getAppContext()
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L14
            goto La0
        L14:
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L8d
            if (r0 != 0) goto L8f
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L8d
            if (r0 != 0) goto L8f
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L8d
            if (r0 != 0) goto L8f
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L8d
            if (r0 != 0) goto L8f
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L8d
            if (r0 == 0) goto L33
            goto L8f
        L33:
            com.cloud.tmc.integration.structure.AppContext r0 = r4.getAppContext()     // Catch: java.lang.Throwable -> L8d
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Throwable -> L8d
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Throwable -> L8d
            java.lang.Class<com.cloud.tmc.integration.proxy.IAdActivityGetProxy> r2 = com.cloud.tmc.integration.proxy.IAdActivityGetProxy.class
            java.lang.Object r2 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r2)     // Catch: java.lang.Throwable -> L8d
            com.cloud.tmc.integration.proxy.IAdActivityGetProxy r2 = (com.cloud.tmc.integration.proxy.IAdActivityGetProxy) r2     // Catch: java.lang.Throwable -> L8d
            java.lang.Class r2 = r2.getAdPersonalizationActivity()     // Catch: java.lang.Throwable -> L8d
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L8d
            r2 = 65536(0x10000, float:9.18355E-41)
            r1.setFlags(r2)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = "ad_personalization_url"
            r1.putExtra(r2, r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "adsDTO"
            r1.putExtra(r6, r7)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "trigger_id"
            r1.putExtra(r6, r5)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "appId"
            java.lang.String r7 = r4.getAppId()     // Catch: java.lang.Throwable -> L8d
            r1.putExtra(r6, r7)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "appIdExternal"
            r1.putExtra(r6, r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "codeSeatIdExternal"
            r1.putExtra(r6, r9)     // Catch: java.lang.Throwable -> L8d
            java.lang.Class<com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory> r6 = com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory.class
            java.lang.Object r6 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r6)     // Catch: java.lang.Throwable -> L8d
            com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory r6 = (com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory) r6     // Catch: java.lang.Throwable -> L8d
            com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter r4 = r6.getEventCenterInstance(r4)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "adPersonalizationPage"
            com.cloud.tmc.integration.bridge.NavigateBridge$3 r7 = new com.cloud.tmc.integration.bridge.NavigateBridge$3     // Catch: java.lang.Throwable -> L8d
            r7.<init>()     // Catch: java.lang.Throwable -> L8d
            r4.register(r6, r7)     // Catch: java.lang.Throwable -> L8d
            r0.startActivity(r1)     // Catch: java.lang.Throwable -> L8d
            goto L9f
        L8d:
            r4 = move-exception
            goto L95
        L8f:
            if (r10 == 0) goto L94
            r10.sendFailResponse()     // Catch: java.lang.Throwable -> L8d
        L94:
            return
        L95:
            java.lang.String r5 = "NavigateBridge"
            com.cloud.tmc.kernel.log.TmcLogger.e(r5, r4)
            if (r10 == 0) goto L9f
            r10.sendFailResponse()
        L9f:
            return
        La0:
            if (r10 == 0) goto La5
            r10.sendFailResponse()
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.bridge.NavigateBridge.navigateToPersonalization(com.cloud.tmc.integration.structure.App, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.cloud.tmc.kernel.bridge.extension.BridgeCallback):void");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void openExternalApp(@BindingNode(App.class) App app, @BindingParam({"linkUrl"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        try {
            if (UrlLauncher.launchApp(app.getAppContext().getContext(), str)) {
                bridgeCallback.sendSuccessResponse();
            } else if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void openHybridH5Page(@BindingParam(name = {"url"}) String str, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            TraceLog.w("Tmcintegration", "openH5 url is empty!!!");
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
        app.putPageType(str, 2);
        app.putRouteType(str, "navigateTo");
        Bundle sceneParams = app.getSceneParams();
        sceneParams.putString("navigationType", TmcConstants.NAVIGATION_OPEN_HYBRID_H5_PAGE);
        app.pushPage(str, app.getStartParams(), sceneParams);
        if (bridgeCallback != null) {
            bridgeCallback.sendSuccessResponse(new JsonObject());
        }
    }

    @Override // com.cloud.tmc.kernel.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void reLaunch(@BindingParam(name = {"url"}) String str, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            if (str.isEmpty()) {
                TraceLog.w("Tmcintegration", "navigateTo url is empty!!!");
                if (bridgeCallback != null) {
                    bridgeCallback.sendFailResponse();
                    return;
                }
                return;
            }
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
            app.putRouteType(str, "reLaunch");
            Bundle sceneParams = app.getSceneParams();
            sceneParams.putString("navigationType", "reLaunch");
            app.relaunchToUrl(str, app.getStartParams(), sceneParams);
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse(new JsonObject());
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void redirectTo(@BindingParam(name = {"url"}) String str, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (str.isEmpty()) {
            TmcLogger.d("Tmcintegration", "redirectTo url is empty!!!");
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (checkTabPage(app.getSceneParams(), str)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
            }
        } else {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
            app.putRouteType(str, "redirectTo");
            app.redirectTo(str, app.getStartParams(), app.getSceneParams());
            if (bridgeCallback != null) {
                bridgeCallback.sendSuccessResponse();
            }
        }
    }

    @ActionFilter
    @ThreadType(ExecutorType.UI)
    public void switchTab(@BindingParam(name = {"url"}) String str, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        String str2;
        MiniAppConfigModel.TabBarBean tabBarConfig;
        List<MiniAppConfigModel.TabBarBean.ListBean> list;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            TmcLogger.e("Tmcintegration", "switchTab url is empty!!!");
            if (bridgeCallback != null) {
                bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "switchTab url is empty: N004").build());
                return;
            }
            return;
        }
        try {
            str2 = Uri.parse(str).getPath();
        } catch (Exception e11) {
            TmcLogger.e(TAG, e11);
            str2 = "";
        }
        if (page != null && (tabBarConfig = page.getTabBarConfig()) != null && (list = tabBarConfig.list) != null) {
            Iterator<MiniAppConfigModel.TabBarBean.ListBean> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().pagePath, str2)) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app.getAppId(), PointAnalyseType.POINT_PAGE_OPEN, "");
                    app.putRouteType(str, "switchTab");
                    app.putStringValue(TmcConstants.KEY_SWITCH_TAB_FROM_SCENE, TmcConstants.KEY_FROM_TAB_SELECTED);
                    app.switchTab(str, app.getStartParams(), app.getSceneParams());
                    if (bridgeCallback != null) {
                        bridgeCallback.sendSuccessResponse();
                        return;
                    }
                    return;
                }
            }
        }
        TmcLogger.e("Tmcintegration", "switchTab url is not supported!!!");
        if (bridgeCallback != null) {
            bridgeCallback.sendFailResponse(JsonObjectUtils.create().addProperty("errMsg", "switchTab url is not supported: N005").build());
        }
    }
}
