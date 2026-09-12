package com.cloud.tmc.miniapp.prepare.steps.subpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.callback.PackageInstallCallback;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.integration.utils.SubpackageAppPrepareUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes3.dex */
public final class OooO0O0 extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO00o {
    public final String OooO;
    public final Integer OooOO0;
    public final OooOO0 OooOO0O;
    public String OooOO0o;

    /* loaded from: classes3.dex */
    public static final class OooO00o implements PackageInstallCallback {
        public final /* synthetic */ AppModel OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ Context OooO0Oo;
        public final /* synthetic */ PrepareContext OooO0o;
        public final /* synthetic */ PrepareController OooO0o0;

        public OooO00o(AppModel appModel, String str, Context context, PrepareController prepareController, PrepareContext prepareContext) {
            this.OooO0O0 = appModel;
            this.OooO0OO = str;
            this.OooO0Oo = context;
            this.OooO0o0 = prepareController;
            this.OooO0o = prepareContext;
        }

        @Override // com.cloud.tmc.integration.callback.PackageInstallCallback
        public void onResult(boolean z10, String str) {
            if (!z10) {
                OooO0O0.this.OooO00o(this.OooO0o, this.OooO0O0, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "INSTALL_APP_FAIL");
                OooO0O0 oooO0O0 = OooO0O0.this;
                PrepareContext prepareContext = this.OooO0o;
                PrepareController prepareController = this.OooO0o0;
                AppModel appModel = this.OooO0O0;
                oooO0O0.OooO00o(prepareContext, prepareController, appModel, "5", "unzip error" + appModel.getPackageUrl());
                return;
            }
            TmcLogger.d(OooO0O0.this.OooO00o, "Step_LoadStep: tar 包解压完成");
            try {
                SubpackageAppPrepareUtils subpackageAppPrepareUtils = SubpackageAppPrepareUtils.INSTANCE;
                if (!Intrinsics.c(JsonUtil.INSTANCE.getValueFromJson(subpackageAppPrepareUtils.getManifestJson(this.OooO0O0, this.OooO0OO), "appId"), this.OooO0O0.getAppId())) {
                    subpackageAppPrepareUtils.clearAllFilesForVersion(this.OooO0Oo, this.OooO0O0, this.OooO0OO);
                    this.OooO0o0.moveToError(new PrepareException(PrepareException.ERROR_MANIFEST_INFO, "manifest error"));
                    OooO0O0.this.OooO00o(this.OooO0o, this.OooO0O0, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "MANIFEST_FAIL");
                    return;
                }
                OooO0O0.this.OooO00o(this.OooO0o, this.OooO0O0, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, (String) null);
                TmcLogger.d(OooO0O0.this.OooO00o, "Step_LoadStep: manifest 内容校验成功");
                subpackageAppPrepareUtils.changeTarUnCompressStatus(this.OooO0Oo, this.OooO0O0.getAppId(), this.OooO0OO, true);
                OooO0O0.this.OooO0o0.deleteDownloadFileForVersion(this.OooO0O0, this.OooO0OO);
                OooO0O0 oooO0O02 = OooO0O0.this;
                if (!oooO0O02.OooOO0O.OooO0O0) {
                    TmcAppInfoManager tmcAppInfoManager = oooO0O02.OooO0O0;
                    Context context = this.OooO0Oo;
                    AppModel appModel2 = this.OooO0O0;
                    Integer num = oooO0O02.OooOO0;
                    tmcAppInfoManager.deleteOldVersionFiles(context, appModel2, num != null && num.intValue() == 1);
                    OooO0O0 oooO0O03 = OooO0O0.this;
                    oooO0O03.OooO0O0.updateOldVersion(this.OooO0Oo, this.OooO0O0, oooO0O03.OooO);
                }
                PrepareController prepareController2 = this.OooO0o0;
                prepareController2.unlock(prepareController2);
                this.OooO0o0.moveToNext();
            } catch (Throwable unused) {
                OooO0O0.this.OooO00o(this.OooO0o, this.OooO0O0, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "MANIFEST_FAIL");
                OooO0O0.this.OooO00o(this.OooO0o, this.OooO0o0, this.OooO0O0, PrepareException.ERROR_MANIFEST_INFO, "manifest error");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OooO0O0() {
        this(null, 0 == true ? 1 : 0, 3);
    }

    public OooO0O0(String str, Integer num) {
        this.OooO = str;
        this.OooOO0 = num;
        this.OooOO0O = new OooOO0();
    }

    public /* synthetic */ OooO0O0(String str, Integer num, int i11) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 1 : null);
    }

    public static final void OooO00o(OooO0O0 this$0, PrepareController controller, PrepareContext context, AppModel appModel, String identificationEncryptionUrl, boolean z10, String str) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(controller, "$controller");
        Intrinsics.h(context, "$context");
        Intrinsics.h(appModel, "$appModel");
        Intrinsics.h(identificationEncryptionUrl, "$identificationEncryptionUrl");
        if (z10) {
            TmcLogger.d(this$0.OooO00o, "Step_LoadStep: zip 包解压完成");
            this$0.OooO00o(controller, context, appModel, identificationEncryptionUrl);
            return;
        }
        this$0.OooO00o(context, appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "INSTALL_ZIP_FAIL");
        this$0.OooO00o(context, controller, appModel, "5", "unzip error" + appModel.getPackageUrl());
    }

    public final void OooO00o(PrepareContext prepareContext, AppModel appModel, PointAnalyseType pointAnalyseType, String str) {
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getSubpackageAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
        if (miniAppVersion2 == null || miniAppVersion == null || TextUtils.isEmpty(miniAppVersion) || TextUtils.isEmpty(miniAppVersion2) || !miniAppLaunch.compareVersion(miniAppVersion2, miniAppVersion)) {
            return;
        }
        com.cloud.tmc.miniapp.prepare.steps.OooO.OooO00o(appModel, pointAnalyseType, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2);
        if (str != null && str.length() != 0) {
            pointAnalyseType.putData(TmcConstants.TRACK_MPU_RESULT, str);
        }
        pointAnalyseType.putData(TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID, prepareContext.getStartParams().getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
        this.OooOO0O.OooO00o(pointAnalyseType);
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), pointAnalyseType, "");
    }

    public final void OooO00o(final PrepareContext prepareContext, final PrepareController prepareController, final AppModel appModel, final String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ChainPoint.TYPE, "app");
        com.cloud.tmc.miniapp.prepare.steps.OooO0O0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, bundle, ChainPoint.CHAIN_ID);
        bundle.putInt(ChainPoint.ZIP_APP_MODE, 2);
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        this.OooO0OO.installZip(prepareContext.getStartContext(), appModel, false, this.OooOO0O.OooO0O0(), new PackageInstallCallback() { // from class: com.cloud.tmc.miniapp.prepare.steps.subpackage.a
            @Override // com.cloud.tmc.integration.callback.PackageInstallCallback
            public final void onResult(boolean z10, String str2) {
                OooO0O0.OooO00o(OooO0O0.this, prepareController, prepareContext, appModel, str, z10, str2);
            }
        });
    }

    public final void OooO00o(PrepareContext prepareContext, PrepareController prepareController, AppModel appModel, String str, String str2) {
        if (appModel != null) {
            try {
                if (this.OooOO0O.OooO0O0) {
                    KVStorageProxy kVStorageProxy = (KVStorageProxy) TmcProxy.get(KVStorageProxy.class);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
                    SubPackageInfo OooO0O0 = this.OooOO0O.OooO0O0();
                    String format = String.format(TmcConstants.SUBPACKAGE_STORAGE_KEY_DECOMPRESSION_COUNT_FORMAT, Arrays.copyOf(new Object[]{OooO0O0 != null ? OooO0O0.getSubPackageUrlMD5() : null}, 1));
                    Intrinsics.g(format, "format(format, *args)");
                    int i11 = kVStorageProxy.getInt(prepareContext.getStartContext(), TmcConstants.SUBPACKAGE_STORAGE_FILE, format);
                    TmcLogger.d(this.OooO00o, "decompressionFailed,tryCount:" + i11);
                    if (i11 <= 1) {
                        kVStorageProxy.putInt(prepareContext.getStartContext(), TmcConstants.SUBPACKAGE_STORAGE_FILE, format, i11 + 1);
                    } else {
                        kVStorageProxy.remove(prepareContext.getStartContext(), TmcConstants.SUBPACKAGE_STORAGE_FILE, format);
                        SubpackageAppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), appModel, this.OooOO0o);
                        TmcLogger.d(this.OooO00o, "decompressionFailed,clearAll");
                    }
                } else {
                    SubpackageAppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), appModel, this.OooOO0o);
                    TmcLogger.d(this.OooO00o, "decompressionFailed,clearAll");
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.OooO00o, "", th2);
            }
        }
        prepareController.moveToError(new PrepareException(str, str2));
    }

    public final void OooO00o(PrepareController prepareController, PrepareContext prepareContext, AppModel appModel, String str) {
        Context startContext = prepareContext.getStartContext();
        TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验");
        SubpackageAppPrepareUtils subpackageAppPrepareUtils = SubpackageAppPrepareUtils.INSTANCE;
        if (subpackageAppPrepareUtils.checkSHA256(appModel, this.OooOO0O.OooO0O0())) {
            TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验正确，解压 tar 包");
            this.OooO0OO.installApp(appModel, false, this.OooOO0O.OooO0O0(), new OooO00o(appModel, str, startContext, prepareController, prepareContext));
            return;
        }
        OooO00o(prepareContext, appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL, "SIGN_FAIL");
        TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验不一致，删除所有缓存");
        subpackageAppPrepareUtils.clearAllFilesForVersion(startContext, appModel, str);
        prepareController.moveToError(new PrepareException("7", "sign error" + appModel.getAppId() + "   " + appModel.getPackageUrl()));
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO00o
    public void OooO0OO(PrepareController controller, PrepareContext context, o000oOoO callback) {
        AppModel appModel;
        String OooO00o2;
        Intrinsics.h(controller, "controller");
        Intrinsics.h(context, "context");
        Intrinsics.h(callback, "callback");
        try {
            appModel = context.getAppModel();
            this.OooOO0O.OooO00o(appModel, this.OooO, context, this.OooOO0);
            OooO00o2 = this.OooOO0O.OooO00o(appModel);
            this.OooOO0o = OooO00o2;
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO00o, th2);
            OooO00o(context, controller, null, "5", "unzip error" + th2.getMessage());
        }
        if (appModel != null && OooO00o2 != null && OooO00o2.length() != 0) {
            SubpackageAppPrepareUtils subpackageAppPrepareUtils = SubpackageAppPrepareUtils.INSTANCE;
            if (!subpackageAppPrepareUtils.checkTarUnCompressStatus(context.getStartContext(), appModel.getAppId(), OooO00o2)) {
                TmcLogger.d(this.OooO00o, "Step_LoadStep:删除旧的已解压文件");
                this.OooO0o0.deleteFile(this.OooO0Oo.getZipUnCompressPath(appModel.getAppId(), OooO00o2));
                TmcLogger.d(this.OooO00o, "Step_LoadStep:解压 zip 包");
                try {
                    OooO00o(context, controller, appModel, OooO00o2);
                    callback.updateStepProgress(LoadStepAction.STEP_FINISH_DECOMPRESS);
                    return;
                } catch (Throwable th3) {
                    TmcLogger.e(this.OooO00o, th3);
                    OooO00o(context, controller, appModel, "5", "unzip error" + th3.getMessage());
                    return;
                }
            }
            OooO00o(context, appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_SUCCESS, (String) null);
            try {
                if (!this.OooOO0O.OooO0O0 && subpackageAppPrepareUtils.checkLatestBackgroundDownloadStatus(context.getStartContext(), appModel.getAppId(), OooO00o2)) {
                    TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "delete latest download pkg,appVersion:" + appModel.getDeployVersion());
                    this.OooO0O0.deleteOldVersionFiles(context.getStartContext(), appModel, true);
                    subpackageAppPrepareUtils.clearLatestBackgroundDownloadStatus(context.getStartContext(), appModel.getAppId(), OooO00o2);
                }
            } catch (Throwable th4) {
                TmcLogger.e(this.OooO00o, "", th4);
            }
            TmcLogger.d(this.OooO00o, "Step_LoadStep:tar包已解压，跳转到 startStep");
            controller.unlock(controller);
            controller.moveToNext();
            return;
            TmcLogger.e(this.OooO00o, th2);
            OooO00o(context, controller, null, "5", "unzip error" + th2.getMessage());
        }
    }
}
