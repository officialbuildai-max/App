package com.cloud.tmc.miniapp.prepare.steps.singlepackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.OooO;
import com.cloud.tmc.miniapp.prepare.steps.OooOO0;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class OooO00o extends com.cloud.tmc.miniapp.prepare.steps.structure.OooO0O0 {
    public boolean OooO = true;

    /* renamed from: com.cloud.tmc.miniapp.prepare.steps.singlepackage.OooO00o$OooO00o, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0348OooO00o implements PackageDownloadCallback {
        public final /* synthetic */ boolean OooO00o;
        public final /* synthetic */ PrepareContext OooO0O0;
        public final /* synthetic */ AppModel OooO0OO;
        public final /* synthetic */ String OooO0Oo;
        public final /* synthetic */ PrepareController OooO0o;
        public final /* synthetic */ String OooO0o0;
        public final /* synthetic */ o000oOoO OooO0oO;

        public C0348OooO00o(boolean z10, PrepareContext prepareContext, AppModel appModel, String str, String str2, PrepareController prepareController, o000oOoO o000oooo) {
            this.OooO00o = z10;
            this.OooO0O0 = prepareContext;
            this.OooO0OO = appModel;
            this.OooO0Oo = str;
            this.OooO0o0 = str2;
            this.OooO0o = prepareController;
            this.OooO0oO = o000oooo;
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onCancel(String str, String str2) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0O0.getAppId(), OooOO0.OooO00o(this.OooO0O0, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_USER_EXIT.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_RESULT, "IOException").putData(TmcConstants.TRACK_MPU_ERROR_CODE, "D006").putData(TmcConstants.TRACK_MPU_ERROR_MSG, "Canceled"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            try {
                OooO00o.this.OooO0OO.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.e(TmcConstants.TAG, th2);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFailed(String str, String str2, String str3, IOException iOException, String str4) {
            AppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0O0.getStartContext(), this.OooO0OO, false);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0O0.getAppId(), OooOO0.OooO00o(this.OooO0O0, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_FAILED.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_RESULT, iOException.getClass().getSimpleName()).putData(TmcConstants.TRACK_MPU_ERROR_CODE, str2).putData(TmcConstants.TRACK_MPU_ERROR_MSG, iOException.getMessage()), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            try {
                OooO00o.this.OooO0OO.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.e(TmcConstants.TAG, th2);
            }
            if (!this.OooO00o) {
                this.OooO0oO.backgroundDownloadZipAsync(this.OooO0OO, false);
                return;
            }
            if (!TextUtils.isEmpty(this.OooO0Oo) && !TextUtils.isEmpty(this.OooO0o0) && MiniAppLaunch.INSTANCE.compareVersion(this.OooO0o0, this.OooO0Oo)) {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0O0.getAppId(), OooOO0.OooO00o(this.OooO0O0, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, PointAnalyseType.POINT_PACKAGE_UPDATE_FAIL.putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0).putData(TmcConstants.TRACK_MPU_RESULT, "DOWNLOAD_FAIL"), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            }
            TmcLogger.d(OooO00o.this.OooO00o, "Step_Download_资源包下载失败，" + str3);
            this.OooO0o.moveToError(new PrepareException("4", "download error:" + str3 + "   url:" + this.OooO0OO.getPackageUrl()));
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onFinish(@Nullable String str, String str2) {
            TmcLogger.d(OooO00o.this.OooO00o, "Step_Download_资源包下载完成，进行解压");
            AppPrepareUtils.INSTANCE.changeZipDownloadStatus(this.OooO0O0.getStartContext(), this.OooO0OO, true);
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "SinglePkgDownloadStep Finish:changeZipDownloadStatus true:downloadUrl:" + str + ";appInfo:appId:" + this.OooO0OO.getAppId() + ";deployVersion:" + this.OooO0OO.getDeployVersion() + ";mainPkgUrl:" + this.OooO0OO.getMainPackageUrl() + ";fullPkgUrl:" + this.OooO0OO.getPackageUrl());
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(this.OooO0O0.getAppId(), OooOO0.OooO00o(this.OooO0O0, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_SUCCESS.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, this.OooO00o ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC).putData(TmcConstants.TRACK_MPU_APPID, this.OooO0OO.getAppId()).putData(TmcConstants.TRACK_MPU_OLD_V, this.OooO0Oo).putData(TmcConstants.TRACK_MPU_NEW_V, this.OooO0o0), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
            try {
                OooO00o.this.OooO0OO.removeDownloadAppMap(this.OooO0OO.getPackageUrl_MD5());
            } catch (Throwable th2) {
                TmcLogger.e(TmcConstants.TAG, th2);
            }
            if (this.OooO00o) {
                PrepareController prepareController = this.OooO0o;
                prepareController.unlock(prepareController);
                this.OooO0o.moveToNext();
                return;
            }
            try {
                if (MiniAppLaunch.INSTANCE.checkEnableBackgroundUnzip()) {
                    com.cloud.tmc.miniapp.utils.OooOO0 oooOO0 = com.cloud.tmc.miniapp.utils.OooOO0.OooO00o;
                    Context context = this.OooO0O0.getStartContext();
                    AppModel appModel = this.OooO0OO;
                    Intrinsics.h(context, "context");
                    Intrinsics.h(appModel, "appModel");
                    com.cloud.tmc.miniapp.utils.OooOO0.OooO00o(oooOO0, context, appModel, false, false, 12);
                }
            } catch (Throwable th3) {
                TmcLogger.e(TmcConstants.TAG, th3);
            }
            this.OooO0oO.backgroundDownloadZipAsync(this.OooO0OO, true);
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onPrepare(String str, String str2) {
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public void onProgress(String str, int i11, String str2) {
            if (this.OooO00o) {
                TmcLogger.d(OooO00o.this.OooO00o, "Step_Download_下载资源包" + i11);
            }
        }

        @Override // com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback
        public /* synthetic */ void progressUpdate(String str, int i11, String str2, long j11, long j12) {
            com.cloud.tmc.kernel.proxy.network.a.a(this, str, i11, str2, j11, j12);
        }
    }

    public final void OooO00o(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo, AppModel appModel, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString(ChainPoint.TYPE, "app");
        com.cloud.tmc.miniapp.prepare.steps.OooO0O0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, bundle, ChainPoint.CHAIN_ID);
        bundle.putInt(ChainPoint.DOWNLOAD_APP_MODE, z10 ? 2 : 1);
        if (!prepareContext.getVirtualStart()) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), PointAnalyseType.POINT_CHAIN_INSERT, "", bundle);
        }
        String packageUrl = appModel.getPackageUrl();
        if (packageUrl == null || packageUrl.isEmpty()) {
            if (!z10) {
                o000oooo.backgroundDownloadZipAsync(appModel, false);
            }
            prepareController.moveToError(new PrepareException(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, "packageUrl is null or empty"));
            return;
        }
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
        String miniAppVersion = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromUsed(prepareContext.getStartContext(), prepareContext.getAppId()));
        String miniAppVersion2 = miniAppLaunch.getMiniAppVersion(this.OooO0O0.getAppModelFromPre(prepareContext.getStartContext(), prepareContext.getAppId()));
        if (z10 && !TextUtils.isEmpty(miniAppVersion) && !TextUtils.isEmpty(miniAppVersion2) && miniAppLaunch.compareVersion(miniAppVersion2, miniAppVersion)) {
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_UPDATE_START, TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
        }
        ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(prepareContext.getAppId(), OooOO0.OooO00o(prepareContext, TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE, OooO.OooO00o(appModel, PointAnalyseType.POINT_PACKAGE_DOWNLOAD_START.putData(TmcConstants.TRACK_MPU_DOWNLOAD_TYPE, z10 ? TmcConstants.KEY_SYNC : TmcConstants.KEY_ASYNC), TmcConstants.TRACK_MPU_APPID, TmcConstants.TRACK_MPU_OLD_V, miniAppVersion).putData(TmcConstants.TRACK_MPU_NEW_V, miniAppVersion2), TmcConstants.TRACK_MPU_CHAIN_UNIQUE_ID), "");
        int i11 = z10 ? 2 : 1;
        StringBuilder OooO00o = com.cloud.tmc.miniapp.OooO00o.OooO00o("SinglePkgDownloadStep startDownload:downloadUrl:");
        OooO00o.append(appModel.getPackageUrl());
        OooO00o.append(";appInfo:appId:");
        OooO00o.append(appModel.getAppId());
        OooO00o.append(";deployVersion:");
        OooO00o.append(appModel.getDeployVersion());
        TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, OooO00o.toString());
        this.OooO0OO.downloadApp(appModel, i11, true, new C0348OooO00o(z10, prepareContext, appModel, miniAppVersion, miniAppVersion2, prepareController, o000oooo));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x011d, code lost:
    
        if (r3.compareVersion(r6, r4) != false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x023e  */
    @Override // com.cloud.tmc.miniapp.prepare.steps.structure.OooO0O0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void OooO0OO(com.cloud.tmc.miniapp.prepare.controller.PrepareController r17, com.cloud.tmc.integration.model.PrepareContext r18, com.cloud.tmc.miniapp.prepare.steps.o000oOoO r19) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prepare.steps.singlepackage.OooO00o.OooO0OO(com.cloud.tmc.miniapp.prepare.controller.PrepareController, com.cloud.tmc.integration.model.PrepareContext, com.cloud.tmc.miniapp.prepare.steps.o000oOoO):void");
    }
}
