package com.cloud.tmc.miniapp.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.StartClientBundle;
import com.cloud.tmc.integration.athena.Constants;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppInfoQuery;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.CDNConfigBean;
import com.cloud.tmc.integration.model.EntryInfo;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.model.ForceUpdateModel;
import com.cloud.tmc.integration.model.PrepareCallbackParam;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.model.WarmUpEntranceConfigBean;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.JsonObjectUtils;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.intf.ISDKConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.BundleUtils;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.kernel.utils.KUrlUtils;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.GlobalPackageConfig;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.ad.WebviewAdFormActivity;
import com.cloud.tmc.miniapp.dialog.Oooo0;
import com.cloud.tmc.miniapp.dialog.Oooo000;
import com.cloud.tmc.miniapp.dialog.o000oOoO;
import com.cloud.tmc.miniapp.dialog.o0OoOo0;
import com.cloud.tmc.miniapp.ipc.IpcMiniLauncherService;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.cloud.tmc.miniapp.proxy.IClientStarter;
import com.cloud.tmc.miniapp.proxy.platform.IUpgradeProxy;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniAppMainProcessActivity;
import com.cloud.tmc.miniapp.ui.multiprogress.MiniAppMiniProcessActivity;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.AppUtils;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.Utils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.mvel2.ast.ASTNode;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MiniAppLaunch {
    public static final MiniAppLaunch INSTANCE = new MiniAppLaunch();
    private static final String TAG = "MiniAppLaunch";
    private static final Map<String, Map<String, Long>> commonResLaunchList = new LinkedHashMap();
    private static final Map<String, Boolean> commonResIdList = new LinkedHashMap();

    /* loaded from: classes3.dex */
    public static final class OooO implements o0OoOo0 {
        public final /* synthetic */ Context OooO00o;
        public final /* synthetic */ o000oOoO OooO0O0;
        public final /* synthetic */ com.cloud.tmc.miniapp.prepare.callback.OooO00o OooO0OO;

        public OooO(Context context, o000oOoO o000oooo, com.cloud.tmc.miniapp.prepare.callback.OooO00o oooO00o) {
            this.OooO00o = context;
            this.OooO0O0 = o000oooo;
            this.OooO0OO = oooO00o;
        }

        @Override // com.cloud.tmc.miniapp.dialog.o0OoOo0
        public void OooO00o(View view) {
            Intrinsics.h(view, "view");
            Context context = this.OooO00o;
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity != null) {
                miniAppActivity.killActivity();
            }
        }

        @Override // com.cloud.tmc.miniapp.dialog.o0OoOo0
        public void OooO0O0(View view) {
            Intrinsics.h(view, "view");
            this.OooO0O0.dismiss();
            MiniAppLaunch.INSTANCE.showProgressDialog(this.OooO00o, this.OooO0OO);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o implements PackageDownloadCallback {
        public final /* synthetic */ Function0<Unit> OooO00o;
        public final /* synthetic */ TmcResourceManager OooO0O0;
        public final /* synthetic */ AppModel OooO0OO;
        public final /* synthetic */ Context OooO0Oo;
        public final /* synthetic */ Function3<String, String, IOException, Unit> OooO0o;
        public final /* synthetic */ Function0<Unit> OooO0o0;

        /* JADX WARN: Multi-variable type inference failed */
        public OooO00o(Function0<Unit> function0, TmcResourceManager tmcResourceManager, AppModel appModel, Context context, Function0<Unit> function02, Function3<? super String, ? super String, ? super IOException, Unit> function3) {
            this.OooO00o = function0;
            this.OooO0O0 = tmcResourceManager;
            this.OooO0OO = appModel;
            this.OooO0Oo = context;
            this.OooO0o0 = function02;
            this.OooO0o = function3;
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onCancel(String str, String str2) {
            Function0<Unit> function0 = this.OooO00o;
            if (function0 != null) {
                function0.invoke();
            }
            try {
                this.OooO0O0.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.e(MiniAppLaunch.TAG, th2);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFailed(String str, String errorCode, String str2, IOException e11, String str3) {
            Intrinsics.h(errorCode, "errorCode");
            Intrinsics.h(e11, "e");
            TmcLogger.d(MiniAppLaunch.TAG, "Step_APP_Download_资源包后台下载失败，" + str2);
            Function3<String, String, IOException, Unit> function3 = this.OooO0o;
            if (function3 != null) {
                function3.invoke(errorCode, str2, e11);
            }
            try {
                this.OooO0O0.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.e(MiniAppLaunch.TAG, th2);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFinish(String str, String str2) {
            TmcLogger.d(MiniAppLaunch.TAG, "Step_APP_Download_资源包后台下载完成，进行解压");
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "backgroundDownFullPkgZip Finish:changeZipDownloadStatus:true downloadUrl:" + str + ";appInfo:appId:" + this.OooO0OO.getAppId() + ";deployVersion:" + this.OooO0OO.getDeployVersion() + ";mainPkgUrl:" + this.OooO0OO.getMainPackageUrl() + ";fullPkgUrl:" + this.OooO0OO.getPackageUrl());
            AppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0Oo, this.OooO0OO, true);
            Function0<Unit> function0 = this.OooO0o0;
            if (function0 != null) {
                function0.invoke();
            }
            if (MiniAppLaunch.INSTANCE.checkEnableBackgroundUnzip()) {
                com.cloud.tmc.miniapp.utils.OooOO0.OooO00o(com.cloud.tmc.miniapp.utils.OooOO0.OooO00o, this.OooO0Oo, this.OooO0OO, false, false, 8);
            }
            try {
                this.OooO0O0.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.e(MiniAppLaunch.TAG, th2);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onPrepare(String str, String str2) {
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onProgress(String str, int i11, String str2) {
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public /* synthetic */ void progressUpdate(String str, int i11, String str2, long j11, long j12) {
            com.cloud.tmc.kernel.proxy.network.a.a(this, str, i11, str2, j11, j12);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 implements PackageDownloadCallback {
        public final /* synthetic */ Function0<Unit> OooO00o;
        public final /* synthetic */ TmcResourceManager OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ AppModel OooO0Oo;
        public final /* synthetic */ Function0<Unit> OooO0o;
        public final /* synthetic */ Context OooO0o0;
        public final /* synthetic */ Function3<String, String, IOException, Unit> OooO0oO;

        /* JADX WARN: Multi-variable type inference failed */
        public OooO0O0(Function0<Unit> function0, TmcResourceManager tmcResourceManager, String str, AppModel appModel, Context context, Function0<Unit> function02, Function3<? super String, ? super String, ? super IOException, Unit> function3) {
            this.OooO00o = function0;
            this.OooO0O0 = tmcResourceManager;
            this.OooO0OO = str;
            this.OooO0Oo = appModel;
            this.OooO0o0 = context;
            this.OooO0o = function02;
            this.OooO0oO = function3;
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onCancel(String str, String str2) {
            Function0<Unit> function0 = this.OooO00o;
            if (function0 != null) {
                function0.invoke();
            }
            try {
                this.OooO0O0.removeDownloadAppMap(this.OooO0OO);
            } catch (Throwable th2) {
                TmcLogger.e(MiniAppLaunch.TAG, th2);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFailed(String str, String errorCode, String str2, IOException e11, String str3) {
            Intrinsics.h(errorCode, "errorCode");
            Intrinsics.h(e11, "e");
            TmcLogger.d(MiniAppLaunch.TAG, "Step_APP_Download_资源包后台下载失败，" + str2);
            Function3<String, String, IOException, Unit> function3 = this.OooO0oO;
            if (function3 != null) {
                function3.invoke(errorCode, str2, e11);
            }
            try {
                this.OooO0O0.removeDownloadAppMap(this.OooO0OO);
            } catch (Throwable th2) {
                TmcLogger.e(MiniAppLaunch.TAG, th2);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFinish(String str, String str2) {
            TmcLogger.d(MiniAppLaunch.TAG, "Step_APP_Download_资源包后台下载完成，进行解压");
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "backgroundDownSubPkgZip Finish:downloadUrl:" + str + ";appInfo:appId:" + this.OooO0Oo.getAppId() + ";deployVersion:" + this.OooO0Oo.getDeployVersion() + ";mainPkgUrl:" + this.OooO0Oo.getMainPackageUrl() + ";fullPkgUrl:" + this.OooO0Oo.getPackageUrl());
            try {
                AppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0o0, this.OooO0Oo.getAppId(), this.OooO0OO, true);
            } catch (Throwable th2) {
                TmcLogger.e(MiniAppLaunch.TAG, "", th2);
            }
            Function0<Unit> function0 = this.OooO0o;
            if (function0 != null) {
                function0.invoke();
            }
            if (MiniAppLaunch.INSTANCE.checkEnableBackgroundUnzip()) {
                TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "backgroundDownSubPkgZip startUnZip:downloadUrl:" + str + ";appInfo:appId:" + this.OooO0Oo.getAppId() + ";deployVersion:" + this.OooO0Oo.getDeployVersion() + ";mainPkgUrl:" + this.OooO0Oo.getMainPackageUrl() + ";fullPkgUrl:" + this.OooO0Oo.getPackageUrl());
                OooOOO0.OooO00o.OooO0Oo(this.OooO0o0, this.OooO0Oo, null, false, true);
            }
            try {
                this.OooO0O0.removeDownloadAppMap(this.OooO0OO);
            } catch (Throwable th3) {
                TmcLogger.e(MiniAppLaunch.TAG, th3);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onPrepare(String str, String str2) {
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onProgress(String str, int i11, String str2) {
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public /* synthetic */ void progressUpdate(String str, int i11, String str2, long j11, long j12) {
            com.cloud.tmc.kernel.proxy.network.a.a(this, str, i11, str2, j11, j12);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function0<Unit> {
        public static final OooO0OO OooO00o = new OooO0OO();

        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            ByteAppManager.setAppId("launcher");
            TmcProxy.set(ISDKConfig.class, new ISDKConfig() { // from class: com.cloud.tmc.miniapp.utils.MiniAppLaunch$byteAppInit$1$1
                @Override // com.cloud.tmc.kernel.intf.ISDKConfig
                public String getAppVersion() {
                    return "0.0.0";
                }

                @Override // com.cloud.tmc.kernel.intf.ISDKConfig
                public boolean openShareTarget() {
                    return false;
                }
            });
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o implements com.cloud.tmc.miniapp.ipc.OooO0O0 {
        public final /* synthetic */ Context OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ Bundle OooO0OO;

        public OooO0o(Context context, String str, Bundle bundle) {
            this.OooO00o = context;
            this.OooO0O0 = str;
            this.OooO0OO = bundle;
        }

        @Override // com.cloud.tmc.miniapp.ipc.OooO0O0
        public void OooO00o(Integer num, Throwable th2) {
            TmcLogger.e(MiniAppLaunch.TAG, th2);
            ByteAppManager.INSTANCE.setSchemeInitStatus(false);
        }

        public void OooO00o(boolean z10) {
            if (z10) {
                return;
            }
            boolean configBoolean = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigBoolean(LauncherMiniAppConfigHelper.KEY_CLOSE_MINI_APP_SDK, false);
            TmcLogger.e("app will launch mini app, closeSDK = " + configBoolean);
            if (configBoolean) {
                ByteAppManager.INSTANCE.preLoadConfig$com_cloud_tmc_miniapp_sdk(ByteAppManager.getSApplication());
                return;
            }
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
            if (miniAppLaunch.checkOpenBrowser(this.OooO00o, this.OooO0O0, this.OooO0OO)) {
                return;
            }
            miniAppLaunch.launchMiniActivity(this.OooO0OO, this.OooO0O0, this.OooO00o);
            ByteAppManager.INSTANCE.setSchemeInitStatus(false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 implements com.cloud.tmc.miniapp.ipc.OooO0O0 {
        public final /* synthetic */ boolean OooO00o;

        public OooOO0(boolean z10) {
            this.OooO00o = z10;
        }

        public static final void OooO0O0(boolean z10) {
            if (z10) {
                try {
                    TmcLogger.d(MiniAppLaunch.TAG, "warmupWebView");
                    ((IInnerH5WebviewPool) TmcProxy.get(IInnerH5WebviewPool.class)).createWebview();
                } catch (Throwable th2) {
                    TmcLogger.e(MiniAppLaunch.TAG, th2);
                    return;
                }
            }
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
            miniAppLaunch.warmUpWorker();
            miniAppLaunch.warmupRender();
        }

        @Override // com.cloud.tmc.miniapp.ipc.OooO0O0
        public void OooO00o(Integer num, Throwable th2) {
            TmcLogger.e(MiniAppLaunch.TAG, th2);
        }

        public void OooO00o(boolean z10) {
            if (z10) {
                return;
            }
            try {
                final boolean z11 = this.OooO00o;
                ExecutorUtils.post(new Runnable() { // from class: com.cloud.tmc.miniapp.utils.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppLaunch.OooOO0.OooO0O0(z11);
                    }
                });
            } catch (Throwable th2) {
                TmcLogger.e(MiniAppLaunch.TAG, th2);
            }
        }
    }

    private MiniAppLaunch() {
    }

    public static /* synthetic */ void backgroundDownZip$default(MiniAppLaunch miniAppLaunch, Context context, AppModel appModel, int i11, Function0 function0, Function3 function3, Function0 function02, int i12, Object obj) {
        miniAppLaunch.backgroundDownZip(context, appModel, i11, (i12 & 8) != 0 ? null : function0, (i12 & 16) != 0 ? null : function3, (i12 & 32) != 0 ? null : function02);
    }

    private final boolean backgroundDownloadOfflineCheck(AppModel appModel, Context context, Function0<Unit> function0) {
        if (!checkOfflinePkg(appModel)) {
            return false;
        }
        ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).updateAppModel(context, appModel, appModel.getAppId() + "_pre");
        TmcLogger.d(TAG, "Step_APP_Download_资源包后台从离线框架获取成功，进行解压");
        AppPrepareUtils.INSTANCE.changeZipDownloadStatus(context, appModel, true);
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "backgroundDownloadOfflineCheck:changeZipDownloadStatus true:appInfo:appId:" + appModel.getAppId() + ";deployVersion:" + appModel.getDeployVersion() + ";mainPkgUrl:" + appModel.getMainPackageUrl() + ";fullPkgUrl:" + appModel.getPackageUrl());
        if (function0 != null) {
            function0.invoke();
        }
        return true;
    }

    public static /* synthetic */ void backgroundDownloadSinglePackageZip$default(MiniAppLaunch miniAppLaunch, Context context, AppModel appModel, int i11, Function0 function0, Function3 function3, Function0 function02, int i12, Object obj) {
        miniAppLaunch.backgroundDownloadSinglePackageZip(context, appModel, i11, (i12 & 8) != 0 ? null : function0, (i12 & 16) != 0 ? null : function3, (i12 & 32) != 0 ? null : function02);
    }

    public static /* synthetic */ void backgroundDownloadSubPackageZip$default(MiniAppLaunch miniAppLaunch, Context context, AppModel appModel, int i11, Function0 function0, Function3 function3, Function0 function02, int i12, Object obj) {
        miniAppLaunch.backgroundDownloadSubPackageZip(context, appModel, i11, (i12 & 8) != 0 ? null : function0, (i12 & 16) != 0 ? null : function3, (i12 & 32) != 0 ? null : function02);
    }

    public static /* synthetic */ String buildShareUrl$default(MiniAppLaunch miniAppLaunch, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        return miniAppLaunch.buildShareUrl(str, str2);
    }

    private final boolean checkEnableAppQuickModel(boolean z10, String str) {
        boolean configBoolean = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigBoolean(LauncherMiniAppConfigHelper.KEY_MINI_ENABLE_QUICK_MODE, true);
        if (!configBoolean) {
            TmcLogger.d(TAG, "checkEnableAppQuickModel->" + configBoolean);
            return false;
        }
        if ((!StringsKt.W(str, "https://", false, 2, null) && !StringsKt.W(str, "http://", false, 2, null)) || !z10) {
            return false;
        }
        TmcLogger.d(TAG, "checkEnableAppQuickModel extQuickMode->" + z10);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean checkOfflinePkg(com.cloud.tmc.integration.model.AppModel r9) {
        /*
            java.lang.String r0 = "appModel"
            kotlin.jvm.internal.Intrinsics.h(r9, r0)
            boolean r0 = com.cloud.tmc.offline.download.OfflineManager.isEnabled()
            r1 = 0
            if (r0 != 0) goto Ld
            return r1
        Ld:
            boolean r0 = com.cloud.tmc.kernel.utils.ProcessUtils.isMiniProcess()
            if (r0 != 0) goto L14
            return r1
        L14:
            java.lang.String r0 = r9.getAppId()
            if (r0 != 0) goto L1b
            return r1
        L1b:
            java.lang.String r2 = "100000"
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r0, r2)
            if (r2 == 0) goto L24
            return r1
        L24:
            com.cloud.tmc.offline.download.model.OfflinePkgCachePath r0 = com.cloud.tmc.offline.download.OfflineManager.getOfflinePkgFwCachePath(r0)
            if (r0 != 0) goto L2b
            return r1
        L2b:
            com.cloud.tmc.offline.download.utils.Utils r2 = com.cloud.tmc.offline.download.utils.Utils.INSTANCE
            java.lang.String r2 = r2.getAppVersionFromOfflinePkgCache(r0)
            if (r2 != 0) goto L34
            return r1
        L34:
            com.cloud.tmc.miniapp.utils.MiniAppLaunch r3 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.INSTANCE
            java.lang.String r4 = r3.getMiniAppVersion(r9)
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r4, r2)
            r5 = 1
            if (r4 != 0) goto L52
            java.lang.String r4 = r3.getMiniAppVersion(r9)
            if (r4 != 0) goto L49
            java.lang.String r4 = "0"
        L49:
            boolean r4 = r3.compareVersion(r2, r4)
            if (r4 == 0) goto L50
            goto L52
        L50:
            r4 = r1
            goto L53
        L52:
            r4 = r5
        L53:
            java.lang.String r6 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.TAG
            java.lang.String r3 = r3.getMiniAppVersion(r9)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "isUpdate->"
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = ",offlineVersion-> "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r2 = ",appVersion:"
            r7.append(r2)
            r7.append(r3)
            java.lang.String r2 = r7.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r6, r2)
            if (r4 != 0) goto L80
            return r1
        L80:
            java.util.List r0 = r0.getZipFileInfo()
            if (r0 == 0) goto Lbd
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto Lbd
            java.lang.Object r0 = kotlin.collections.CollectionsKt.i0(r0)
            com.cloud.tmc.offline.download.model.ZipFileInfo r0 = (com.cloud.tmc.offline.download.model.ZipFileInfo) r0
            java.lang.String r0 = r0.getZipUnCompressPath()
            java.lang.String r2 = r9.getAppId()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "/"
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = ".zip"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            boolean r2 = com.cloud.tmc.miniutils.util.FileUtils.isFileExists(r0)
            if (r2 == 0) goto Lbd
            r9.setZipPath(r0)
            return r5
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.utils.MiniAppLaunch.checkOfflinePkg(com.cloud.tmc.integration.model.AppModel):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkOpenBrowser(Context context, String str, Bundle bundle) {
        AppModel appModel;
        if (str == null || str.length() == 0) {
            TmcLogger.e(TAG, "checkOpenBrowser failed. appId is null.");
            return false;
        }
        try {
            if (!ProcessUtils.isMiniProcess() || (appModel = ((TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class)).getAppModel(context, AppInfoQuery.INSTANCE.make(str))) == null) {
                return false;
            }
            if (!PreStrategyManager.OooO00o.OooO00o(context, str, bundle != null ? bundle.getString("scene_id") : null)) {
                TmcLogger.e(TAG, "checkOpenBrowser failed. PreStrategyManager.checkEnableOpenBrowser is false.");
                return false;
            }
            ExtendModel extend = appModel.getExtend();
            String generateShellUrl = KUrlUtils.generateShellUrl(extend != null ? extend.getH5Url() : null, bundle);
            if (generateShellUrl.length() == 0) {
                TmcLogger.e(TAG, "checkOpenBrowser failed. url is null.");
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(generateShellUrl));
            intent.addFlags(ASTNode.DEOP);
            context.startActivity(intent);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(str, PointAnalyseType.POINT_OPEN_BROWSER, "");
            return true;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return false;
        }
    }

    private final boolean checkTarget(Uri uri, String str) {
        String queryParameter;
        if (uri != null && (queryParameter = uri.getQueryParameter("target")) != null) {
            if (queryParameter.length() <= 0) {
                queryParameter = null;
            }
            if (queryParameter != null) {
                HashMap<String, String> shareTargetMap = getShareTargetMap();
                String str2 = shareTargetMap != null ? shareTargetMap.get(Utils.getApp().getPackageName()) : null;
                if (Intrinsics.c(str2, queryParameter) || str2 == null) {
                    return false;
                }
                try {
                    String query = uri.getQuery();
                    String queryParameter2 = uri.getQueryParameter(TmcConstants.EXTRA_SHARE_SUPPORT_VERSION);
                    String str3 = "dlt";
                    if (!Intrinsics.c(queryParameter2, "0") && queryParameter2 != null) {
                        str3 = "dlt" + queryParameter2;
                    }
                    String key = getKey(shareTargetMap, queryParameter);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.addFlags(ASTNode.DEOP);
                    intent.setData(Uri.parse(str3 + "://miniapp?" + query));
                    intent.setPackage(key);
                    Utils.getApp().startActivity(intent);
                    return true;
                } catch (Exception e11) {
                    TmcLogger.e(e11.getMessage());
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.addFlags(ASTNode.DEOP);
                    intent2.setData(Uri.parse(str));
                    intent2.addCategory("android.intent.category.BROWSABLE");
                    Utils.getApp().startActivity(intent2);
                    return true;
                }
            }
        }
        return false;
    }

    private final String getAllOfDigit(String str) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.isDigit(str.charAt(i11))) {
                sb2.append(str.charAt(i11));
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "builder.toString()");
        return sb3;
    }

    @JvmStatic
    public static final boolean getCloseSdkSwitch() {
        try {
            ConfigService configService = (ConfigService) TmcProxy.get(ConfigService.class);
            if (configService != null) {
                return configService.getConfigBoolean(LauncherMiniAppConfigHelper.KEY_CLOSE_MINI_APP_SDK, false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final String getKey(HashMap<String, String> hashMap, String str) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (Intrinsics.c(entry.getValue(), str)) {
                return key;
            }
        }
        return null;
    }

    @JvmStatic
    public static final Class<? extends Activity> getMiniAppLaunchActivity(Intent intent) {
        Intrinsics.h(intent, "intent");
        Bundle bundle = ((StartClientBundle) BundleUtils.getParcelable(intent.getExtras(), TmcConstants.EXTRA_START_BUNDLE)).startParams;
        String string = bundle != null ? bundle.getString(TmcConstants.EXTRA_TARGET_PROCESS) : null;
        MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.INSTANCE;
        if (!Intrinsics.c(string, miniAppConfigHelper.getDEFAULT_TARGET_PROCESS()) && !ProcessUtils.isMiniProcess() && ByteAppManager.isPreInit()) {
            ByteAppManager.otherProcessInit();
        }
        return Intrinsics.c(string, miniAppConfigHelper.getDEFAULT_TARGET_PROCESS()) ? MiniAppMiniProcessActivity.class : MiniAppMainProcessActivity.class;
    }

    private final HashMap<String, String> getShareTargetMap() {
        try {
            return (HashMap) GsonUtils.fromJson(((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_SHARE_TARGET, MiniAppConfigHelper.DEFAULT_SHARE_TARGET), (Type) HashMap.class);
        } catch (Exception e11) {
            TmcLogger.e(e11.getMessage());
            return null;
        }
    }

    @JvmStatic
    public static final String getTargetProcess() {
        return ":mini";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpGooglePlayStore$lambda$35(Context context) {
        Intrinsics.h(context, "$context");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_JUMP_STORE_DEEPLINK, MiniAppConfigHelper.DEFAULT_JUMP_STORE_DEEPLINK) + context.getPackageName()));
        intent.addFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpPalmStore$lambda$36(Context context) {
        Intrinsics.h(context, "$context");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("palmplay://thirdlauncher.com/?entryType=AppDetail&detailType=SOFT&utm_source=pushsdk&_source=miniApp&packageName=" + context.getPackageName() + "&name=" + AppUtils.getAppName()));
        intent.addFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    @JvmStatic
    public static final void killActivity(Context context) {
        try {
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity != null) {
                miniAppActivity.killActivity();
            }
        } catch (Exception e11) {
            TmcLogger.e(e11.getMessage());
        }
    }

    @JvmStatic
    public static final void launchAdLandingPage(Context context, String url, Bundle bundle) {
        Intrinsics.h(context, "context");
        Intrinsics.h(url, "url");
        Intent intent = new Intent();
        WebviewAdFormActivity.OooO00o oooO00o = WebviewAdFormActivity.OooOOo0;
        intent.putExtra("ad_web_form_url", url);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(ASTNode.DEOP);
        }
        intent.setClass(context, WebviewAdFormActivity.class);
        AppPrepareUtils.INSTANCE.addCommonIntentParameter(intent, context);
        context.startActivity(intent);
    }

    public static /* synthetic */ void launchAdLandingPage$default(Context context, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        launchAdLandingPage(context, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchMiniActivity(Bundle bundle, String str, Context context) {
        String str2;
        String str3;
        String str4;
        String string;
        if (!ProcessUtils.isMiniProcess()) {
            TmcLogger.d(TAG, "current process not allowed to start! processName:" + ProcessUtils.getProcessName());
            return;
        }
        Intent intent = new Intent();
        boolean z10 = bundle != null ? bundle.getBoolean("quickMode") : false;
        String str5 = "";
        if (bundle == null || (str2 = bundle.getString("page")) == null) {
            str2 = "";
        }
        boolean checkEnableAppQuickModel = checkEnableAppQuickModel(z10, str2);
        intent.putExtra(TmcConstants.EXTRA_APP_ENABLE_QUICK_MODE, checkEnableAppQuickModel);
        StartClientBundle createFastStartClient = ActivityHelper.createFastStartClient(new PrepareCallbackParam(), 0);
        Bundle bundle2 = createFastStartClient.startParams;
        if (bundle2 != null) {
            bundle2.putBoolean(TmcConstants.EXTRA_APP_ENABLE_QUICK_MODE, checkEnableAppQuickModel);
        }
        Bundle bundle3 = createFastStartClient.sceneParams;
        if (bundle3 != null) {
            bundle3.putBoolean(TmcConstants.EXTRA_APP_ENABLE_QUICK_MODE, checkEnableAppQuickModel);
        }
        String targetProcess = getTargetProcess();
        Bundle bundle4 = createFastStartClient.startParams;
        if (bundle4 != null) {
            bundle4.putString(TmcConstants.EXTRA_TARGET_PROCESS, targetProcess);
        }
        Bundle bundle5 = createFastStartClient.sceneParams;
        if (bundle5 != null) {
            bundle5.putString(TmcConstants.EXTRA_TARGET_PROCESS, targetProcess);
        }
        if (bundle != null) {
            Bundle bundle6 = createFastStartClient.startParams;
            if (bundle6 != null) {
                bundle6.putAll(bundle);
            }
            Bundle bundle7 = createFastStartClient.sceneParams;
            if (bundle7 != null) {
                bundle7.putAll(bundle);
            }
        }
        Unit unit = Unit.f67184a;
        intent.putExtra(TmcConstants.EXTRA_START_BUNDLE, createFastStartClient);
        intent.putExtra(TmcConstants.EXTRA_APP_ID, str);
        if (bundle == null || (str3 = bundle.getString("mode")) == null) {
            str3 = "";
        }
        intent.putExtra("mode", str3);
        if (bundle == null || (str4 = bundle.getString(TmcConstants.EXTRA_APP_DEV_TOKEN)) == null) {
            str4 = "";
        }
        intent.putExtra(TmcConstants.EXTRA_APP_DEV_TOKEN, str4);
        if (bundle != null && (string = bundle.getString("version")) != null) {
            str5 = string;
        }
        intent.putExtra("version", str5);
        if (!(context instanceof Activity)) {
            intent.addFlags(ASTNode.DEOP);
        }
        ((IClientStarter) TmcProxy.get(IClientStarter.class)).startClient(context, intent, bundle);
    }

    public static /* synthetic */ void launchMiniApp$default(MiniAppLaunch miniAppLaunch, Context context, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        miniAppLaunch.launchMiniApp(context, str, str2);
    }

    @JvmStatic
    public static final void launchMiniAppForId(Context context, String str, Bundle bundle) {
        Intrinsics.h(context, "context");
        TmcLogger.d(TAG, "launchMiniAppForId:appid:" + str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        String orDefaultAndCheckEmpty = StringExtKt.orDefaultAndCheckEmpty(bundle.getString("massid"), String.valueOf(System.currentTimeMillis()));
        if (orDefaultAndCheckEmpty.length() == 0) {
            bundle.putString("massid", orDefaultAndCheckEmpty);
        }
        try {
            if (ProcessUtils.isMiniProcess()) {
                if (bundle.getLong(TmcConstants.KEY_APP_START_FIRST_TIME, 0L) == 0) {
                    bundle.putLong(TmcConstants.KEY_APP_START_FIRST_TIME, 0L);
                }
                bundle.putLong(TmcConstants.KEY_APP_START_MINI_FIRST_TIME, System.currentTimeMillis());
                if (System.currentTimeMillis() - ByteAppManager.INSTANCE.getMiniProcessTimeStamp() > MBInterstitialActivity.WEB_LOAD_TIME) {
                    bundle.putBoolean(TmcConstants.KEY_APP_MINI_PROCESS_ALIVE, true);
                }
                com.cloud.tmc.miniapp.utils.athena.OooO0OO oooO0OO = com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o;
                Bundle bundle2 = new Bundle();
                bundle2.putString("massid", orDefaultAndCheckEmpty);
                bundle2.putString(TmcConstants.KEY_MINI_APPID, str);
                Unit unit = Unit.f67184a;
                oooO0OO.OooO0O0("miniapp_mini_start", Constants.MINI_APPID, bundle2);
            } else {
                bundle.putLong(TmcConstants.KEY_APP_START_FIRST_TIME, System.currentTimeMillis());
                com.cloud.tmc.miniapp.utils.athena.OooO0OO oooO0OO2 = com.cloud.tmc.miniapp.utils.athena.OooO0OO.OooO00o;
                Bundle bundle3 = new Bundle();
                bundle3.putString("massid", orDefaultAndCheckEmpty);
                bundle3.putString(TmcConstants.KEY_MINI_APPID, str);
                Unit unit2 = Unit.f67184a;
                oooO0OO2.OooO0O0("miniapp_main_start", Constants.MINI_APPID, bundle3);
            }
        } catch (Throwable unused) {
        }
        IpcMiniLauncherService.OooO00o.OooO00o(context, str, bundle, new OooO0o(context, str, bundle));
    }

    public static /* synthetic */ void launchMiniAppForId$default(Context context, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        launchMiniAppForId(context, str, bundle);
    }

    private final void openBrowser(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(ASTNode.DEOP);
            context.startActivity(intent);
        } catch (Exception unused) {
            TmcLogger.e("openBrowser failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorDialog$lambda$37(Context context) {
        new Oooo000(context).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showProgressDialog(Context context, com.cloud.tmc.miniapp.prepare.callback.OooO00o oooO00o) {
        if (context == null) {
            return;
        }
        final Oooo0 oooo0 = new Oooo0(context);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppLaunch.showProgressDialog$lambda$39(Oooo0.this);
            }
        });
        if (oooO00o != null) {
            oooO00o.OooO00o(oooo0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProgressDialog$lambda$39(Oooo0 dialog) {
        Intrinsics.h(dialog, "$dialog");
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUpdateFwZipDialog$lambda$38(Context context, String str, com.cloud.tmc.miniapp.prepare.callback.OooO00o oooO00o) {
        Long valueOf;
        String string;
        TextView textView;
        o000oOoO o000oooo = new o000oOoO(context);
        TextView OooO0Oo = o000oooo.OooO0Oo();
        if (OooO0Oo != null) {
            OooO0Oo.setText(o000oooo.getString(R.string.mini_dialog_update_title));
        }
        TextView OooO0OO2 = o000oooo.OooO0OO();
        if (OooO0OO2 != null) {
            OooO0OO2.setText(o000oooo.getString(R.string.mini_dialog_fw_update_content));
        }
        TextView OooO00o2 = o000oooo.OooO00o();
        if (OooO00o2 != null) {
            OooO00o2.setText(o000oooo.getString(R.string.mini_dialog_update_cancel));
        }
        TextView OooO0O02 = o000oooo.OooO0O0();
        if (OooO0O02 != null) {
            OooO0O02.setText(o000oooo.getString(R.string.mini_dialog_fw_update_now));
        }
        if (str != null) {
            try {
                valueOf = Long.valueOf(Long.parseLong(str));
            } catch (Exception e11) {
                TmcLogger.e(e11.getMessage());
            }
        } else {
            valueOf = null;
        }
        TextView textView2 = (TextView) o000oooo.OooO0o0.getValue();
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (valueOf != null && (string = o000oooo.getString(R.string.mini_dialog_download_size)) != null && (textView = (TextView) o000oooo.OooO0o0.getValue()) != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(string, Arrays.copyOf(new Object[]{o000oooo.OooO00o(valueOf.longValue())}, 1));
            Intrinsics.g(format, "format(format, *args)");
            textView.setText(format);
        }
        OooO listener = new OooO(context, o000oooo, oooO00o);
        Intrinsics.h(listener, "listener");
        o000oooo.OooO0o = listener;
        o000oooo.show();
    }

    @JvmStatic
    public static final PrepareException showUpdateStepErrorMsg(String str, int i11, String str2) {
        if (i11 == 30004) {
            return new PrepareException("30004", "appid:" + str + ", AppInfo not exist");
        }
        if (i11 == 30005) {
            return new PrepareException("30005", "appid:" + str + ",  AppInfo Version not exist");
        }
        if (i11 == 30009) {
            return new PrepareException("30009", "appid:" + str + ", The byteapp version has expired");
        }
        if (i11 == 30022) {
            return new PrepareException("30022", "appid:" + str + ", Version error");
        }
        return new PrepareException("4", "appid:" + str + ", " + str2);
    }

    private final void updateCDNConfig(CDNConfigBean cDNConfigBean, Context context) {
        try {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, TmcConstants.KEY_MINI_SDK_STORAGE, LauncherMiniAppConfigHelper.KEY_MINI_APPINFO_CDN_CONFIG, GsonUtils.toJson(cDNConfigBean));
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    private final void updateWarmUpConfig(WarmUpEntranceConfigBean warmUpEntranceConfigBean, Context context) {
        try {
            ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(context, TmcConstants.KEY_MINI_SDK_STORAGE, LauncherMiniAppConfigHelper.KEY_MINI_WARM_UP_ENTRANCE, GsonUtils.toJson(warmUpEntranceConfigBean));
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    private final boolean useCDNCloudStorage(CDNConfigBean cDNConfigBean, Context context) {
        Float grayScale;
        Boolean enableCdnRequest = cDNConfigBean != null ? cDNConfigBean.getEnableCdnRequest() : null;
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.c(bool, enableCdnRequest)) {
            TmcLogger.d(TAG, "cdn request is closed");
            return false;
        }
        float nextFloat = new SecureRandom().nextFloat();
        float floatValue = (cDNConfigBean == null || (grayScale = cDNConfigBean.getGrayScale()) == null) ? 1.0f : grayScale.floatValue();
        if (floatValue < nextFloat) {
            TmcLogger.d(TAG, "not in the gray range: [grayScale]->" + floatValue + ",[randomFloat]->" + nextFloat);
            if (cDNConfigBean != null) {
                cDNConfigBean.setEnableCdnRequest(bool);
            }
            updateCDNConfig(cDNConfigBean, context);
            return false;
        }
        TmcLogger.d(TAG, "in the gray range: [grayScale]->" + floatValue + ",[randomFloat]->" + nextFloat);
        if (cDNConfigBean != null) {
            cDNConfigBean.setEnableCdnRequest(Boolean.TRUE);
        }
        updateCDNConfig(cDNConfigBean, context);
        return true;
    }

    private final boolean useWarmUpCloudStorage(WarmUpEntranceConfigBean warmUpEntranceConfigBean, Context context) {
        Float grayScale;
        Boolean enableWarmUp = warmUpEntranceConfigBean != null ? warmUpEntranceConfigBean.getEnableWarmUp() : null;
        Boolean bool = Boolean.FALSE;
        if (Intrinsics.c(bool, enableWarmUp)) {
            TmcLogger.d(TAG, "warmup entrance is closed");
            warmUpEntranceConfigBean.setEnableWarmUp(bool);
            updateWarmUpConfig(warmUpEntranceConfigBean, context);
            return false;
        }
        float nextFloat = new SecureRandom().nextFloat();
        float floatValue = (warmUpEntranceConfigBean == null || (grayScale = warmUpEntranceConfigBean.getGrayScale()) == null) ? 1.0f : grayScale.floatValue();
        if (floatValue < nextFloat) {
            TmcLogger.d(TAG, "warmup entrance not in the gray range: [grayScale]->" + floatValue + ",[randomFloat]->" + nextFloat);
            if (warmUpEntranceConfigBean != null) {
                warmUpEntranceConfigBean.setEnableWarmUp(bool);
            }
            updateWarmUpConfig(warmUpEntranceConfigBean, context);
            return false;
        }
        TmcLogger.d(TAG, "warmup entrance in the gray range: [grayScale]->" + floatValue + ",[randomFloat]->" + nextFloat);
        if (warmUpEntranceConfigBean != null) {
            warmUpEntranceConfigBean.setEnableWarmUp(Boolean.TRUE);
        }
        updateWarmUpConfig(warmUpEntranceConfigBean, context);
        return true;
    }

    @JvmOverloads
    public final void backgroundDownZip(Context context, AppModel appModel, int i11) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownZip$default(this, context, appModel, i11, null, null, null, 56, null);
    }

    @JvmOverloads
    public final void backgroundDownZip(Context context, AppModel appModel, int i11, Function0<Unit> function0) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownZip$default(this, context, appModel, i11, function0, null, null, 48, null);
    }

    @JvmOverloads
    public final void backgroundDownZip(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownZip$default(this, context, appModel, i11, function0, function3, null, 32, null);
    }

    @JvmOverloads
    public final void backgroundDownZip(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3, Function0<Unit> function02) {
        Intrinsics.h(appModel, "appModel");
        if (context == null) {
            return;
        }
        if (OooOOO.OooO00o(appModel)) {
            backgroundDownloadSubPackageZip(context, appModel, i11, function0, function3, function02);
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "backgroundDownSubPkgZip:appInfo:appId:" + appModel.getAppId() + ";deployVersion:" + appModel.getDeployVersion());
            return;
        }
        backgroundDownloadSinglePackageZip(context, appModel, i11, function0, function3, function02);
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "backgroundDownWholePkgZip:appInfo:appId:" + appModel.getAppId() + ";deployVersion:" + appModel.getDeployVersion());
    }

    @JvmOverloads
    public final void backgroundDownloadSinglePackageZip(Context context, AppModel appModel, int i11) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownloadSinglePackageZip$default(this, context, appModel, i11, null, null, null, 56, null);
    }

    @JvmOverloads
    public final void backgroundDownloadSinglePackageZip(Context context, AppModel appModel, int i11, Function0<Unit> function0) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownloadSinglePackageZip$default(this, context, appModel, i11, function0, null, null, 48, null);
    }

    @JvmOverloads
    public final void backgroundDownloadSinglePackageZip(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownloadSinglePackageZip$default(this, context, appModel, i11, function0, function3, null, 32, null);
    }

    @JvmOverloads
    public final void backgroundDownloadSinglePackageZip(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3, Function0<Unit> function02) {
        Intrinsics.h(appModel, "appModel");
        if (context == null || backgroundDownloadOfflineCheck(appModel, context, function0)) {
            return;
        }
        TmcResourceManager tmcResourceManager = (TmcResourceManager) TmcProxy.get(TmcResourceManager.class);
        tmcResourceManager.downloadApp(appModel, i11, true, new OooO00o(function02, tmcResourceManager, appModel, context, function0, function3));
    }

    @JvmOverloads
    public final void backgroundDownloadSubPackageZip(Context context, AppModel appModel, int i11) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownloadSubPackageZip$default(this, context, appModel, i11, null, null, null, 56, null);
    }

    @JvmOverloads
    public final void backgroundDownloadSubPackageZip(Context context, AppModel appModel, int i11, Function0<Unit> function0) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownloadSubPackageZip$default(this, context, appModel, i11, function0, null, null, 48, null);
    }

    @JvmOverloads
    public final void backgroundDownloadSubPackageZip(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3) {
        Intrinsics.h(appModel, "appModel");
        backgroundDownloadSubPackageZip$default(this, context, appModel, i11, function0, function3, null, 32, null);
    }

    @JvmOverloads
    public final void backgroundDownloadSubPackageZip(Context context, AppModel appModel, int i11, Function0<Unit> function0, Function3<? super String, ? super String, ? super IOException, Unit> function3, Function0<Unit> function02) {
        Intrinsics.h(appModel, "appModel");
        if (context == null) {
            return;
        }
        try {
            if (backgroundDownloadOfflineCheck(appModel, context, function0)) {
                return;
            }
            TmcResourceManager tmcResourceManager = (TmcResourceManager) TmcProxy.get(TmcResourceManager.class);
            String mainPackageUrlEncryption = appModel.getMainPackageUrlEncryption();
            tmcResourceManager.downloadApp(appModel.getAppId(), appModel.getMainPackageUrl(), mainPackageUrlEncryption, appModel.getMainPackageZipPath(), i11, true, new OooO0O0(function02, tmcResourceManager, mainPackageUrlEncryption, appModel, context, function0, function3));
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "", th2);
        }
    }

    public final void buildDownloadPath(AppModel appmodel) {
        Intrinsics.h(appmodel, "appmodel");
        PathProxy pathProxy = (PathProxy) TmcProxy.get(PathProxy.class);
        TmcResourceManager tmcResourceManager = (TmcResourceManager) TmcProxy.get(TmcResourceManager.class);
        appmodel.setPackageUrl_MD5(AppPrepareUtils.INSTANCE.urlToSHA256(com.cloud.tmc.integration.utils.AppUtils.INSTANCE.getPackageDownloadUrl(appmodel)));
        tmcResourceManager.creatBaseDirectory(appmodel);
        appmodel.setZipPath(pathProxy.getZipPath(appmodel));
        appmodel.setUnzipFilePath(pathProxy.getZipUnCompressPath(appmodel));
    }

    public final String buildShareUrl(String str, String str2) {
        String str3;
        String str4;
        String configString = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_SHARE_PREFIX_URL, MiniAppConfigHelper.DEFAULT_SHARE_PREFIX_URL);
        HashMap<String, String> shareTargetMap = getShareTargetMap();
        if (shareTargetMap == null || (str3 = shareTargetMap.get(Utils.getApp().getPackageName())) == null) {
            str3 = "";
        }
        if (str3.length() > 0) {
            str4 = "&target=" + str3;
        } else {
            str4 = "";
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "";
        }
        String str5 = configString + "?appId=" + str + str2;
        if (!((ISDKConfig) TmcProxy.get(ISDKConfig.class)).openShareTarget()) {
            return str5;
        }
        return str5 + str4;
    }

    public final void byteAppInit$com_cloud_tmc_miniapp_sdk(Application application) {
        Intrinsics.h(application, "application");
        ByteAppManager.init(application, OooO0OO.OooO00o);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean checkAppInfoEnableCDNRequest(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.Class<com.cloud.tmc.integration.model.CDNConfigBean> r0 = com.cloud.tmc.integration.model.CDNConfigBean.class
            java.lang.String r1 = "appInfoCDNConfig"
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.h(r7, r2)
            r2 = 0
            java.lang.Class<com.cloud.tmc.kernel.service.ConfigService> r3 = com.cloud.tmc.kernel.service.ConfigService.class
            java.lang.Object r3 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r3)     // Catch: java.lang.Throwable -> L23
            com.cloud.tmc.kernel.service.ConfigService r3 = (com.cloud.tmc.kernel.service.ConfigService) r3     // Catch: java.lang.Throwable -> L23
            java.lang.String r4 = "{\"enableCdnRequest\":true,\"cdnConfigToken\":\"1\",\"grayScale\":0.5}"
            java.lang.String r3 = r3.getConfigString(r1, r4)     // Catch: java.lang.Throwable -> L23
            com.google.gson.Gson r4 = com.cloud.tmc.miniutils.util.GsonUtils.getGson()     // Catch: java.lang.Throwable -> L23
            java.lang.Object r3 = r4.fromJson(r3, r0)     // Catch: java.lang.Throwable -> L23
            com.cloud.tmc.integration.model.CDNConfigBean r3 = (com.cloud.tmc.integration.model.CDNConfigBean) r3     // Catch: java.lang.Throwable -> L23
            goto L2a
        L23:
            r3 = move-exception
            java.lang.String r4 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.TAG
            com.cloud.tmc.kernel.log.TmcLogger.e(r4, r3)
            r3 = r2
        L2a:
            java.lang.Class<com.cloud.tmc.kernel.proxy.storage.KVStorageProxy> r4 = com.cloud.tmc.kernel.proxy.storage.KVStorageProxy.class
            java.lang.Object r4 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r4)     // Catch: java.lang.Throwable -> L45
            com.cloud.tmc.kernel.proxy.storage.KVStorageProxy r4 = (com.cloud.tmc.kernel.proxy.storage.KVStorageProxy) r4     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = "minisdk_storage"
            java.lang.String r1 = r4.getString(r7, r5, r1)     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L47
            com.google.gson.Gson r4 = com.cloud.tmc.miniutils.util.GsonUtils.getGson()     // Catch: java.lang.Throwable -> L45
            java.lang.Object r0 = r4.fromJson(r1, r0)     // Catch: java.lang.Throwable -> L45
            com.cloud.tmc.integration.model.CDNConfigBean r0 = (com.cloud.tmc.integration.model.CDNConfigBean) r0     // Catch: java.lang.Throwable -> L45
            goto L4f
        L45:
            r0 = move-exception
            goto L49
        L47:
            r0 = r2
            goto L4f
        L49:
            java.lang.String r1 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.TAG
            com.cloud.tmc.kernel.log.TmcLogger.e(r1, r0)
            goto L47
        L4f:
            if (r0 == 0) goto Lb9
            java.lang.String r1 = r0.getCdnConfigToken()
            if (r3 == 0) goto L5c
            java.lang.String r4 = r3.getCdnConfigToken()
            goto L5d
        L5c:
            r4 = r2
        L5d:
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r4)
            if (r1 != 0) goto L92
            java.lang.String r1 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.TAG
            java.lang.String r0 = r0.getCdnConfigToken()
            if (r3 == 0) goto L6f
            java.lang.String r2 = r3.getCdnConfigToken()
        L6f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cdn request token changed:[nativeToken]->"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ",[cloudToken]->"
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r1, r0)
            com.cloud.tmc.miniapp.utils.MiniAppLaunch r0 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.INSTANCE
            boolean r7 = r0.useCDNCloudStorage(r3, r7)
            return r7
        L92:
            java.lang.String r7 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.TAG
            java.lang.Boolean r1 = r0.getEnableCdnRequest()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "storage cdn request status:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r7, r1)
            java.lang.Boolean r7 = r0.getEnableCdnRequest()
            if (r7 == 0) goto Lb7
            boolean r7 = r7.booleanValue()
            goto Lb8
        Lb7:
            r7 = 1
        Lb8:
            return r7
        Lb9:
            com.cloud.tmc.miniapp.utils.MiniAppLaunch r0 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.INSTANCE
            boolean r7 = r0.useCDNCloudStorage(r3, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.utils.MiniAppLaunch.checkAppInfoEnableCDNRequest(android.content.Context):boolean");
    }

    public final boolean checkEnableBackgroundUnzip() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_ENABLE_BACKGROUND_UNZIP, true);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return false;
        }
    }

    public final boolean checkFocusUpdateMyByteApp(AppModel appModel, int i11) {
        List arrayList;
        Intrinsics.h(appModel, "appModel");
        try {
            String appId = appModel.getAppId();
            if (appId == null) {
                return false;
            }
            String configString = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_MINI_ENABLE_FORCE_UPDATE_LIST, "[]");
            Object obj = null;
            if (configString != null) {
                Object fromJson = GsonUtils.fromJson(configString, new TypeToken<ArrayList<ForceUpdateModel>>() { // from class: com.cloud.tmc.miniapp.utils.MiniAppLaunch$checkFocusUpdateMyByteApp$enableForceUpdateList$1$1
                }.getType());
                arrayList = fromJson instanceof List ? (List) fromJson : null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
            } else {
                arrayList = new ArrayList();
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.c(appId, ((ForceUpdateModel) next).getAppId())) {
                    obj = next;
                    break;
                }
            }
            ForceUpdateModel forceUpdateModel = (ForceUpdateModel) obj;
            if (forceUpdateModel == null) {
                return false;
            }
            if (i11 != 1) {
                return i11 == 2;
            }
            MiniAppLaunch miniAppLaunch = INSTANCE;
            String version = forceUpdateModel.getVersion();
            String str = "";
            if (version == null) {
                version = "";
            }
            String miniAppVersion = miniAppLaunch.getMiniAppVersion(appModel);
            if (miniAppVersion != null) {
                str = miniAppVersion;
            }
            boolean compareVersion = miniAppLaunch.compareVersion(version, str);
            TmcLogger.d(TAG, "appinfo 需要强制更新" + compareVersion);
            return compareVersion;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return false;
        }
    }

    public final boolean checkFwVersionUpdate(String oldFwVersion, String newFwVersion) {
        Intrinsics.h(oldFwVersion, "oldFwVersion");
        Intrinsics.h(newFwVersion, "newFwVersion");
        if (!((ConfigService) TmcProxy.get(ConfigService.class)).getConfigBoolean(LauncherMiniAppConfigHelper.KEY_FW_UPDATE_COMPARE, true)) {
            return true;
        }
        try {
            List S0 = StringsKt.S0(oldFwVersion, new String[]{"."}, false, 0, 6, null);
            Intrinsics.f(S0, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            List c11 = TypeIntrinsics.c(S0);
            List S02 = StringsKt.S0(newFwVersion, new String[]{"."}, false, 0, 6, null);
            Intrinsics.f(S02, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            List c12 = TypeIntrinsics.c(S02);
            if (c11.size() > 3) {
                CollectionsKt.J(c11);
            }
            if (c12.size() > 3) {
                CollectionsKt.J(c12);
            }
            if (Integer.parseInt((String) c12.get(0)) > Integer.parseInt((String) c11.get(0))) {
                return true;
            }
            return Integer.parseInt((String) c12.get(1)) > Integer.parseInt((String) c11.get(1));
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return true;
        }
    }

    public final String checkH5UrlInBlackList(String url) {
        Intrinsics.h(url, "url");
        try {
            Object fromJson = GsonUtils.fromJson(ProcessUtils.isMiniProcess() ? MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_HYBRID_URL_BLACK_LIST, "[]") : MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_HYBRID_URL_BLACK_LIST, "[]"), new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.utils.MiniAppLaunch$checkH5UrlInBlackList$blackList$1
            }.getType());
            List<String> list = fromJson instanceof List ? (List) fromJson : null;
            if (list == null) {
                list = new ArrayList();
            }
            String host = UrlUtils.getHost(url);
            for (String str : list) {
                Intrinsics.g(host, "host");
                if (StringsKt.c0(host, str, false, 2, null)) {
                    TmcLogger.e(TAG, "url in blackList return " + url);
                    return null;
                }
            }
            return url;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return url;
        }
    }

    public final boolean checkLowSupportVersion(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        try {
            int parseInt = Integer.parseInt(getVersionPrefix(GlobalPackageConfig.Companion.getSDK_DEV_VERSION()));
            int parseInt2 = Integer.parseInt(getVersionPrefix(str));
            TmcLogger.d("nec", "<checkLowSupportVersion> currentV:" + parseInt + ",lowV:" + parseInt2);
            return parseInt >= parseInt2;
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final boolean checkShowDownloadTips(String str) {
        Long x10;
        if (str == null || str.length() == 0 || (x10 = StringsKt.x(str)) == null) {
            return false;
        }
        return !NetworkUtils.isWifiConnected() && x10.longValue() / ((long) 1000) > ((long) ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigInt(LauncherMiniAppConfigHelper.KEY_UPDATE_PACKAGE_SIZE, MiniAppConfigHelper.DEFAULT_UPDATE_PACKAGE_SIZE));
    }

    public final void clearLaunchMap(String str) {
        try {
            TypeIntrinsics.d(commonResLaunchList).remove(str);
            TypeIntrinsics.d(commonResIdList).remove(str);
        } catch (Throwable unused) {
        }
    }

    public final void commonResTrack(String str, String type) {
        Intrinsics.h(type, "type");
        if (str != null) {
            try {
                if (type.equals("u_s")) {
                    commonResIdList.put(str, Boolean.TRUE);
                }
                Map<String, Long> commonResLaunch = INSTANCE.getCommonResLaunch(str);
                if (commonResLaunch != null) {
                    commonResLaunch.put(type, Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean compareVersion(String nativePackageVersion, String networkVersion) {
        int i11;
        int i12;
        Intrinsics.h(nativePackageVersion, "nativePackageVersion");
        Intrinsics.h(networkVersion, "networkVersion");
        try {
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
        if (TextUtils.isEmpty(networkVersion)) {
            return true;
        }
        String miniAppVersion = ((IConfigStrategyProxy) TmcProxy.get(IConfigStrategyProxy.class)).getMiniAppVersion(nativePackageVersion);
        String miniAppVersion2 = ((IConfigStrategyProxy) TmcProxy.get(IConfigStrategyProxy.class)).getMiniAppVersion(networkVersion);
        int length = miniAppVersion.length();
        int length2 = miniAppVersion2.length();
        int i13 = 0;
        int i14 = 0;
        do {
            if (i13 >= length && i14 >= length2) {
                return false;
            }
            i11 = 0;
            while (i13 < length) {
                if (miniAppVersion.charAt(i13) == '.') {
                    break;
                }
                i11 = ((i11 * 10) + miniAppVersion.charAt(i13)) - 48;
                i13++;
            }
            i13++;
            i12 = 0;
            while (i14 < length2 && miniAppVersion2.charAt(i14) != '.') {
                i12 = ((i12 * 10) + miniAppVersion2.charAt(i14)) - 48;
                i14++;
            }
            i14++;
        } while (i11 == i12);
        return i11 > i12;
    }

    public final boolean enableCheckBackgroundDownloadZipStatus() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_CHECK_DOWNLOAD_ZIP, true);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return false;
        }
    }

    public final boolean enableWebViewMask() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_WEBVIEW_MASK_ENABLE, true);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return false;
        }
    }

    public final AppModel generateAppModel(AppInfoModel appInfoModel) {
        Intrinsics.h(appInfoModel, "appInfoModel");
        AppModel appModel = new AppModel();
        appModel.setAppId(appInfoModel.getAppId());
        appModel.setLogo(appInfoModel.getLogo());
        appModel.setDesc(appInfoModel.getDesc());
        appModel.setName(appInfoModel.getName());
        appModel.setDeveloper(appInfoModel.getDeveloper());
        appModel.setPackageUrl(appInfoModel.getPackageUrl());
        appModel.setDeployVersion(appInfoModel.getDeployVersion());
        appModel.setDeveloperVersion(appInfoModel.getDeveloperVersion());
        appModel.setMiniappSubtype(appInfoModel.getMiniappSubtype());
        appModel.setTemplateMiniappId(appInfoModel.getTemplateMiniappId());
        appModel.setTemplatePackageUrl(appInfoModel.getTemplatePackageUrl());
        appModel.setTemplateDeployVersion(appInfoModel.getTemplateDeployVersion());
        appModel.setLowestSupportTemplateVersion(appInfoModel.getLowestSupportTemplateVersion());
        appModel.setCompatiblePackageUrl(appInfoModel.getCompatiblePackageUrl());
        appModel.setPermissions(appInfoModel.getPermissions());
        appModel.setExpiresTime(appInfoModel.getExpiresTime());
        appModel.setReleaseTime(appInfoModel.getReleaseTime());
        appModel.setLowestSupportVersion(appInfoModel.getLowestSupportVersion());
        appModel.setPackageSize(appInfoModel.getPackageSize());
        appModel.setClassificationNames(appInfoModel.getClassificationNames());
        appModel.setRegisterType(appInfoModel.getRegisterType());
        appModel.setExtend(appInfoModel.getExtend());
        appModel.setAppinfoCategoryType(appInfoModel.getAppinfoCategoryType());
        appModel.setLowestOpenedVersion(appInfoModel.getLowestOpenedVersion());
        appModel.setForceUpdate(appInfoModel.getForceUpdate());
        appModel.setTestVersion(appInfoModel.getIsTestVersion());
        appModel.setMainPackageUrl(appInfoModel.getMainPackageUrl());
        appModel.setSubPackageUrls(appInfoModel.getSubPackageUrls());
        appModel.setSubPackagePages(appInfoModel.getSubPackagePages());
        appModel.setMainPackagePages(appInfoModel.getMainPackagePages());
        appModel.setClassification(appInfoModel.getClassification());
        appModel.setUserAgreement(appInfoModel.getUserAgreement());
        appModel.setUserAgreementVersion(appInfoModel.getUserAgreementVersion());
        appModel.setUserAgreementUrl(appInfoModel.getUserAgreementUrl());
        appModel.setPrivacyPolicyUrl(appInfoModel.getPrivacyPolicyUrl());
        appModel.setLinkAndButtonColor(appInfoModel.getLinkAndButtonColor());
        appModel.setProcessingMethod(appInfoModel.getProcessingMethod());
        appModel.setPopupStyle(appInfoModel.getPopupStyle());
        PathProxy pathProxy = (PathProxy) TmcProxy.get(PathProxy.class);
        String mainPackageUrl = appModel.getMainPackageUrl();
        if (mainPackageUrl != null && mainPackageUrl.length() != 0) {
            appModel.setMainPackageUrlEncryption(AppPrepareUtils.INSTANCE.urlToSHA256(appModel.getMainPackageUrl()));
            appModel.setMainPackageZipPath(pathProxy.getAppBaseDownloadPath(appModel.getAppId()) + "/" + appModel.getMainPackageUrlEncryption() + "/" + appModel.getMainPackageUrlEncryption() + ".zip");
            appModel.setMainPackageUnZipFilePath(pathProxy.getAppBaseDownloadPath(appModel.getAppId()) + "/" + appModel.getMainPackageUrlEncryption() + "/unzip");
        }
        List<SubPackageInfo> subPackagePages = appModel.getSubPackagePages();
        if (subPackagePages != null) {
            for (SubPackageInfo subPackageInfo : subPackagePages) {
                HashMap subPackageUrls = appModel.getSubPackageUrls();
                String str = subPackageUrls != null ? (String) subPackageUrls.get(subPackageInfo.getRoot()) : null;
                if (str != null && str.length() != 0) {
                    subPackageInfo.setSubPackageUrl(str);
                    subPackageInfo.setSubPackageUrlMD5(AppPrepareUtils.INSTANCE.urlToSHA256(str));
                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "root:" + subPackageInfo.getRoot() + ",encUrl:" + subPackageInfo.getSubPackageUrlMD5());
                    subPackageInfo.setSubZipPath(pathProxy.getAppBaseDownloadPath(appModel.getAppId()) + "/" + subPackageInfo.getSubPackageUrlMD5() + "/" + subPackageInfo.getSubPackageUrlMD5() + ".zip");
                    subPackageInfo.setSubUnzipFilePath(pathProxy.getAppBaseDownloadPath(appModel.getAppId()) + "/" + subPackageInfo.getSubPackageUrlMD5() + "/unzip");
                }
            }
        }
        INSTANCE.buildDownloadPath(appModel);
        return appModel;
    }

    public final EntryInfo generateEntryInfo(AppInfoModel appInfoModel) {
        Intrinsics.h(appInfoModel, "appInfoModel");
        EntryInfo entryInfo = new EntryInfo();
        entryInfo.appId = appInfoModel.getAppId();
        entryInfo.desc = appInfoModel.getDesc();
        entryInfo.iconUrl = appInfoModel.getLogo();
        entryInfo.title = appInfoModel.getName();
        entryInfo.desc = appInfoModel.getDesc();
        entryInfo.slogan = appInfoModel.getSlogan();
        entryInfo.developer = appInfoModel.getDeveloper();
        entryInfo.setClassificationNames(appInfoModel.getClassificationNames());
        ExtendModel extend = appInfoModel.getExtend();
        entryInfo.setExclusiveLogoUrl(extend != null ? extend.getExclusiveLogoUrl() : null);
        return entryInfo;
    }

    public final String getAppInfoCDNPath(String str) {
        return AppDynamicBuildConfig.getMINI_APPINFO_CDN_URL() + "platform/appinfo/releaseInfo/" + str + ".json";
    }

    public final Map<String, Long> getCommonResLaunch(String appId) {
        Intrinsics.h(appId, "appId");
        try {
            Map<String, Map<String, Long>> map = commonResLaunchList;
            Map<String, Long> map2 = map.get(appId);
            if (map2 != null) {
                return map2;
            }
            HashMap hashMap = new HashMap();
            map.put(appId, hashMap);
            return hashMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String getConfigCdnUrl(String defaultUrl) {
        Intrinsics.h(defaultUrl, "defaultUrl");
        return MiniAppConfigHelper.INSTANCE.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_PRE_MANAGER_CONFIG_URL, defaultUrl);
    }

    public final Context getLaunchContext(String str, Context context) {
        String str2 = MiniAppConfigHelper.DEFAULT_MINI_FEEDBACK_ID;
        Intrinsics.h(context, "context");
        try {
            str2 = ((ConfigService) TmcProxy.get(ConfigService.class)).getConfigString(LauncherMiniAppConfigHelper.KEY_MINI_FEEDBACK_ID, MiniAppConfigHelper.DEFAULT_MINI_FEEDBACK_ID);
        } catch (Throwable unused) {
        }
        if (Intrinsics.c(str2, str)) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "{\n            context.applicationContext\n        }");
        return applicationContext;
    }

    public final String getMiniAppVersion(AppModel appModel) {
        if (appModel == null) {
            return "";
        }
        String developerVersion = appModel.getDeveloperVersion();
        return !TextUtils.isEmpty(developerVersion) ? developerVersion : appModel.getDeployVersion();
    }

    public final long getStartLoadingH5AnimDelayTime() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetInt(LauncherMiniAppConfigHelper.KEY_AUTO_HIDE_LOADING_H5_ANIM_TIME, 5000);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return 5000L;
        }
    }

    public final long getStartLoadingNativeAnimDelayTime() {
        try {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetInt(LauncherMiniAppConfigHelper.KEY_AUTO_HIDE_LOADING_NATIVE_ANIM_TIME, 5000);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return 5000L;
        }
    }

    public final String getVersionPrefix(String str) {
        String h12;
        return (str == null || (h12 = StringsKt.h1(str, ".", null, 2, null)) == null) ? "" : h12;
    }

    public final boolean isNeedUpdate(Context context, String appId) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appId, "appId");
        try {
            TmcAppInfoManager tmcAppInfoManager = (TmcAppInfoManager) TmcProxy.get(TmcAppInfoManager.class);
            String miniAppVersion = getMiniAppVersion(tmcAppInfoManager.getAppModelFromUsed(context, appId));
            String miniAppVersion2 = getMiniAppVersion(tmcAppInfoManager.getAppModelFromPre(context, appId));
            if (miniAppVersion != null && miniAppVersion.length() != 0 && miniAppVersion2 != null && miniAppVersion2.length() != 0) {
                boolean compareVersion = compareVersion(miniAppVersion2, miniAppVersion);
                TmcLogger.d(TAG, "It's need update? update: " + compareVersion);
                return compareVersion;
            }
            return false;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
            return false;
        }
    }

    public final void jumpGooglePlayStore(final Context context, String str) {
        Intrinsics.h(context, "context");
        try {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.utils.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppLaunch.jumpGooglePlayStore$lambda$35(context);
                }
            });
        } catch (Exception unused) {
            TmcLogger.e("jump GooglePlay failed");
            jumpPalmStore(context, str);
        }
    }

    public final void jumpPalmStore(final Context context, String str) {
        Intrinsics.h(context, "context");
        try {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.utils.f
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppLaunch.jumpPalmStore$lambda$36(context);
                }
            });
        } catch (Exception unused) {
            TmcLogger.e("jump jumpPalmStore failed");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:(2:129|130)(1:8)|(1:12)|15|16|(1:128)(1:20)|21|(1:127)(1:25)|26|(1:126)(1:30)|31|32|(1:125)(6:36|37|38|(1:40)(1:123)|41|42)|43|(1:121)(2:47|(29:112|113|114|(1:116)(1:119)|117|(1:111)(2:55|(28:101|102|103|(1:105)(1:109)|106|107|60|61|(2:63|64)|66|(1:68)(1:99)|(1:70)|(1:72)|(1:74)|(1:76)|(1:78)|(1:80)|(1:82)|(1:84)|85|(1:87)|88|(1:90)|(1:92)|93|(1:95)|96|98))|59|60|61|(0)|66|(0)(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)|85|(0)|88|(0)|(0)|93|(0)|96|98))|51|(1:53)|111|59|60|61|(0)|66|(0)(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)|85|(0)|88|(0)|(0)|93|(0)|96|98) */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0192 A[Catch: all -> 0x019b, TRY_LEAVE, TryCatch #3 {all -> 0x019b, blocks: (B:61:0x018c, B:63:0x0192), top: B:60:0x018c }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ca A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d6 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01df A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e8 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f1 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fa A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0203 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x020c A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0211 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0221 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x022f A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0236 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0245 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:3:0x0035, B:15:0x007f, B:18:0x00a1, B:21:0x00b5, B:23:0x00bf, B:26:0x00d0, B:28:0x00de, B:31:0x00e7, B:34:0x00ef, B:36:0x00f5, B:45:0x0120, B:47:0x0126, B:49:0x0132, B:53:0x0158, B:55:0x015e, B:57:0x0168, B:66:0x019b, B:68:0x01ca, B:70:0x01d6, B:72:0x01df, B:74:0x01e8, B:76:0x01f1, B:78:0x01fa, B:80:0x0203, B:82:0x020c, B:84:0x0211, B:85:0x0214, B:87:0x0221, B:88:0x0226, B:90:0x022f, B:92:0x0236, B:93:0x023b, B:95:0x0245, B:96:0x024a, B:101:0x016e, B:110:0x0184, B:112:0x0138, B:120:0x014d, B:124:0x010a, B:103:0x0172, B:105:0x0178, B:106:0x017e, B:38:0x00f9, B:40:0x00ff, B:41:0x0105, B:114:0x013c, B:116:0x0142, B:117:0x0148), top: B:2:0x0035, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void launchMiniApp(android.content.Context r34, java.lang.String r35, java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.utils.MiniAppLaunch.launchMiniApp(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public final void reportMiniAppLauncherFailedTrack(String str, String type) {
        Intrinsics.h(type, "type");
        try {
            Bundle bundle = new Bundle();
            bundle.putString("close_type", type);
            bundle.putBoolean("auto_close_app_status", com.cloud.tmc.miniapp.performanceanalyse.app.OooO0O0.OooO00o.OooO00o(str));
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(str, "miniapp_auto_close_record", bundle);
            TmcLogger.d(TAG, "miniappLauncherFailed->" + type);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    public final void showErrorDialog(final Context context) {
        if (context == null) {
            return;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppLaunch.showErrorDialog$lambda$37(context);
            }
        });
    }

    public final void showFwUpdateTipsDialog(Context context, String str, com.cloud.tmc.miniapp.prepare.steps.o000oOoO prepareCallback) {
        Intrinsics.h(prepareCallback, "prepareCallback");
        ((IUpgradeProxy) TmcProxy.get(IUpgradeProxy.class)).showFwUpdateTipsDialog(context, str, prepareCallback);
    }

    public final void showUpdateFwZipDialog(final Context context, final String str, final com.cloud.tmc.miniapp.prepare.callback.OooO00o oooO00o) {
        if (context == null) {
            return;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.miniapp.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppLaunch.showUpdateFwZipDialog$lambda$38(context, str, oooO00o);
            }
        });
    }

    public final void trackCommonResPoint(String str, Bundle bundle) {
        Long l11;
        Long l12;
        Long l13;
        Long l14;
        Long l15;
        Long l16;
        try {
            if (Intrinsics.c(commonResIdList.get(str), Boolean.TRUE)) {
                Map<String, Long> map = commonResLaunchList.get(str);
                long longValue = ((map == null || (l16 = map.get("u_e")) == null) ? 0L : l16.longValue()) - ((map == null || (l15 = map.get("u_s")) == null) ? 0L : l15.longValue());
                long j11 = -1;
                if (longValue < 0) {
                    longValue = -1;
                }
                long longValue2 = ((map == null || (l14 = map.get("d_e")) == null) ? 0L : l14.longValue()) - ((map == null || (l13 = map.get("d_s")) == null) ? 0L : l13.longValue());
                if (longValue2 < 0) {
                    longValue2 = -1;
                }
                long longValue3 = ((map == null || (l12 = map.get("l_e")) == null) ? 0L : l12.longValue()) - ((map == null || (l11 = map.get("l_s")) == null) ? 0L : l11.longValue());
                if (longValue3 >= 0) {
                    j11 = longValue3;
                }
                JsonObject build = JsonObjectUtils.create().addProperty("u_t", Long.valueOf(longValue)).addProperty("d_t", Long.valueOf(longValue2)).addProperty("l_t", Long.valueOf(j11)).build();
                Intrinsics.g(build, "create().addProperty(\"u_…rty(\"l_t\", step3).build()");
                String json = TmcGsonUtilsKt.toJson(build);
                if (bundle != null) {
                    bundle.putString("m_c_p", json);
                }
                clearLaunchMap(str);
            }
        } catch (Throwable unused) {
        }
    }

    public final void warmUpWorker() {
        TmcLogger.d(TAG, "warmUpWorker");
        ((IInnerWorkerPool) TmcProxy.get(IInnerWorkerPool.class)).createWorker(false);
    }

    public final void warmupEntrance(Context context, boolean z10) {
        Intrinsics.h(context, "context");
        try {
            IpcMiniLauncherService.OooO00o.OooO00o(context.getApplicationContext(), z10, new OooOO0(z10));
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    public final void warmupRender() {
        TmcLogger.d(TAG, "warmupRender");
        ((IInnerRenderPool) TmcProxy.get(IInnerRenderPool.class)).createRender(false);
    }
}
