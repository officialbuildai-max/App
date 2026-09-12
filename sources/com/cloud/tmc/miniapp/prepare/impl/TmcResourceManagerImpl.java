package com.cloud.tmc.miniapp.prepare.impl;

import android.content.Context;
import com.cloud.tmc.integration.callback.PackageInstallCallback;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.compress.CompressUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;
import com.cloud.tmc.miniutils.util.FileUtils;
import com.cloud.tmc.miniutils.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes3.dex */
public final class TmcResourceManagerImpl implements TmcResourceManager {
    public final String OooO00o = "TmcResourceManagerImpl";
    public final ConcurrentHashMap<String, Integer> OooO0O0 = new ConcurrentHashMap<>();

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void clearDownloadAppMap() {
        try {
            this.OooO0O0.clear();
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO00o, th2);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void creatBaseDirectory(AppModel appModel) {
        Intrinsics.h(appModel, "appModel");
        ((FileProxy) TmcProxy.get(FileProxy.class)).createBaseDirectory(appModel);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void createSoDirectory() {
        ((FileProxy) TmcProxy.get(FileProxy.class)).createSoDirectory();
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void deleteDownloadPackage(AppModel appModel) {
        Intrinsics.h(appModel, "appModel");
        ((FileProxy) TmcProxy.get(FileProxy.class)).deleteFile(((PathProxy) TmcProxy.get(PathProxy.class)).getZipPath(appModel));
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void deleteInstallStatus(String appId) {
        Intrinsics.h(appId, "appId");
        TmcLogger.d("deleteInstallStatus Not yet implemented");
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void downloadApp(AppModel appModel, int i11, boolean z10, PackageDownloadCallback packageDownloadCallback) {
        Intrinsics.h(appModel, "appModel");
        downloadApp(appModel.getAppId(), AppUtils.INSTANCE.getPackageDownloadUrl(appModel), appModel.getPackageUrl_MD5(), appModel.getZipPath(), i11, z10, packageDownloadCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a2, code lost:
    
        r12 = r7.OooO0O0.put(r10, java.lang.Integer.valueOf(r12));
     */
    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void downloadApp(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, boolean r13, com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback r14) {
        /*
            r7 = this;
            java.lang.Class<com.cloud.tmc.kernel.proxy.network.INetWorkProxy> r13 = com.cloud.tmc.kernel.proxy.network.INetWorkProxy.class
            com.cloud.tmc.miniapp.utils.MiniAppLaunch r0 = com.cloud.tmc.miniapp.utils.MiniAppLaunch.INSTANCE     // Catch: java.lang.Throwable -> L4e
            boolean r0 = r0.enableCheckBackgroundDownloadZipStatus()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto Lae
            r0 = 3
            if (r12 == r0) goto Lae
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r0 = r7.OooO0O0     // Catch: java.lang.Throwable -> L4e
            boolean r0 = r0.containsKey(r10)     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto La0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r0 = r7.OooO0O0     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.Throwable -> L4e
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = ",appMD5 ->"
            r2 = 2
            if (r0 != 0) goto L23
            goto L51
        L23:
            int r3 = r0.intValue()     // Catch: java.lang.Throwable -> L4e
            if (r3 != r2) goto L51
            java.lang.String r0 = r7.OooO00o     // Catch: java.lang.Throwable -> L4e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r2.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = "[TYPE_DOWNLOAD_SOURCE_TYPE_SYNC downloading] appdownload sourcetype "
            r2.append(r3)     // Catch: java.lang.Throwable -> L4e
            r2.append(r12)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r12 = ",appModel -> "
            r2.append(r12)     // Catch: java.lang.Throwable -> L4e
            r2.append(r8)     // Catch: java.lang.Throwable -> L4e
            r2.append(r1)     // Catch: java.lang.Throwable -> L4e
            r2.append(r10)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r10 = r2.toString()     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r10)     // Catch: java.lang.Throwable -> L4e
            return
        L4e:
            r10 = move-exception
            goto Lcd
        L51:
            if (r0 != 0) goto L54
            goto La0
        L54:
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L4e
            r3 = 1
            if (r0 != r3) goto La0
            if (r12 != r2) goto L7e
            java.lang.String r0 = r7.OooO00o     // Catch: java.lang.Throwable -> L4e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r1.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "cancel "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4e
            r1.append(r10)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.kernel.log.TmcLogger.d(r0, r1)     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r13)     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.kernel.proxy.network.INetWorkProxy r0 = (com.cloud.tmc.kernel.proxy.network.INetWorkProxy) r0     // Catch: java.lang.Throwable -> L4e
            r1 = 0
            r0.cancelDownloadCall(r8, r1)     // Catch: java.lang.Throwable -> L4e
            goto La0
        L7e:
            java.lang.String r12 = r7.OooO00o     // Catch: java.lang.Throwable -> L4e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r0.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "[TYPE_DOWNLOAD_SOURCE_TYPE_ASYNC downloading]  appModel -> "
            r0.append(r2)     // Catch: java.lang.Throwable -> L4e
            r0.append(r8)     // Catch: java.lang.Throwable -> L4e
            r0.append(r1)     // Catch: java.lang.Throwable -> L4e
            r0.append(r10)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r10 = " is downloading"
            r0.append(r10)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.kernel.log.TmcLogger.d(r12, r10)     // Catch: java.lang.Throwable -> L4e
            return
        La0:
            if (r10 == 0) goto Lae
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r0 = r7.OooO0O0     // Catch: java.lang.Throwable -> L4e
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r12 = r0.put(r10, r12)     // Catch: java.lang.Throwable -> L4e
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch: java.lang.Throwable -> L4e
        Lae:
            java.lang.String r12 = r7.OooO00o     // Catch: java.lang.Throwable -> L4e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r0.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = "addDownload "
            r0.append(r1)     // Catch: java.lang.Throwable -> L4e
            r0.append(r8)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = ","
            r0.append(r1)     // Catch: java.lang.Throwable -> L4e
            r0.append(r10)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L4e
            com.cloud.tmc.kernel.log.TmcLogger.d(r12, r10)     // Catch: java.lang.Throwable -> L4e
            goto Ld4
        Lcd:
            java.lang.String r12 = r7.OooO00o
            java.lang.String r0 = "downloadApp->"
            com.cloud.tmc.kernel.log.TmcLogger.e(r12, r0, r10)
        Ld4:
            java.lang.Object r10 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r13)
            r0 = r10
            com.cloud.tmc.kernel.proxy.network.INetWorkProxy r0 = (com.cloud.tmc.kernel.proxy.network.INetWorkProxy) r0
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r5 = 0
            r1 = r8
            r2 = r9
            r3 = r11
            r6 = r14
            r0.downloadPackage(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.prepare.impl.TmcResourceManagerImpl.downloadApp(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback):void");
    }

    public final ConcurrentHashMap<String, Integer> getDownloadAppMap() {
        return this.OooO0O0;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public String getInstallPath(AppModel appModel) {
        Intrinsics.h(appModel, "appModel");
        TmcLogger.d("getInstallPath Not yet implemented");
        return "";
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public String getInstalledAppVersion(String appId) {
        Intrinsics.h(appId, "appId");
        TmcLogger.d("getInstalledAppVersion Not yet implemented");
        return "";
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean getNativeCache(Context context, AppModel appModel) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        boolean copyFileFromAssets = ResourceUtils.copyFileFromAssets("mini_offline/" + appModel.getAppId() + "/" + appModel.getAppId() + ".zip", appModel.getZipPath());
        if (copyFileFromAssets) {
            AppPrepareUtils.INSTANCE.changeZipDownloadStatus(context, appModel, true);
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "getNativeCache:changeZipDownloadStatus true:appInfo:appId:" + appModel.getAppId() + ";deployVersion:" + appModel.getDeployVersion() + ";mainPkgUrl:" + appModel.getMainPackageUrl() + ";fullPkgUrl:" + appModel.getPackageUrl());
        }
        return copyFileFromAssets;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean getOfflineCache(Context context, AppModel appModel) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        boolean copy = FileUtils.copy(appModel.getZipPath(), ((PathProxy) TmcProxy.get(PathProxy.class)).getZipPath(appModel));
        if (copy) {
            AppPrepareUtils.INSTANCE.changeZipDownloadStatus(context, appModel, true);
            TmcLogger.d(TmcConstants.SUBPACKAGE_COMMON_TAG, "getOfflineCache:changeZipDownloadStatus true:appInfo:appId:" + appModel.getAppId() + ";deployVersion:" + appModel.getDeployVersion() + ";mainPkgUrl:" + appModel.getMainPackageUrl() + ";fullPkgUrl:" + appModel.getPackageUrl());
        }
        return copy;
    }

    public final String getTAG() {
        return this.OooO00o;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void installApp(AppModel appModel, PackageInstallCallback packageInstallCallback) {
        Intrinsics.h(appModel, "appModel");
        installApp(appModel, true, null, packageInstallCallback);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void installApp(AppModel appModel, boolean z10, SubPackageInfo subPackageInfo, PackageInstallCallback packageInstallCallback) {
        Intrinsics.h(appModel, "appModel");
        try {
            PathProxy pathProxy = (PathProxy) TmcProxy.get(PathProxy.class);
            AppUtils appUtils = AppUtils.INSTANCE;
            String currentPackageEncryptionUrl = appUtils.getCurrentPackageEncryptionUrl(appModel, subPackageInfo, Boolean.valueOf(z10));
            String currentPackageUniqueName = appUtils.getCurrentPackageUniqueName(appModel, subPackageInfo, Boolean.valueOf(z10));
            String tarUnCompressPath = pathProxy.getTarUnCompressPath(appModel, currentPackageEncryptionUrl);
            String tarPath = pathProxy.getTarPath(appModel.getAppId(), currentPackageEncryptionUrl, currentPackageUniqueName);
            try {
                try {
                    CompressUtils.untarGZip(new File(tarPath), tarUnCompressPath);
                    if (packageInstallCallback != null) {
                        packageInstallCallback.onResult(true, tarUnCompressPath);
                    }
                } catch (FileNotFoundException e11) {
                    if (packageInstallCallback != null) {
                        packageInstallCallback.onResult(false, "error:" + e11.getMessage() + "   path:   " + tarUnCompressPath);
                    }
                    TmcLogger.e(this.OooO00o, "Step_LoadStep:  tar 包文件未找到" + tarPath);
                }
            } catch (IOException e12) {
                if (packageInstallCallback != null) {
                    packageInstallCallback.onResult(false, "error:" + e12.getMessage() + "   path:   " + tarUnCompressPath);
                }
                TmcLogger.e(this.OooO00o, "Step_LoadStep:  tar解压 IOException", e12);
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO00o, "TmcResourceManagerImpl", th2);
            if (packageInstallCallback != null) {
                packageInstallCallback.onResult(false, th2.getMessage());
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void installZip(Context context, AppModel appModel, PackageInstallCallback packageInstallCallback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        installZip(context, appModel, true, null, packageInstallCallback);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void installZip(Context context, AppModel appModel, boolean z10, SubPackageInfo subPackageInfo, PackageInstallCallback packageInstallCallback) {
        String mainPackageUrlEncryption;
        String mainPackageZipPath;
        String mainPackageUnZipFilePath;
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        if (z10) {
            mainPackageUrlEncryption = appModel.getPackageUrl_MD5();
            mainPackageZipPath = appModel.getZipPath();
            mainPackageUnZipFilePath = appModel.getUnzipFilePath();
        } else if (subPackageInfo != null) {
            mainPackageUrlEncryption = subPackageInfo.getSubPackageUrlMD5();
            String subZipPath = subPackageInfo.getSubZipPath();
            mainPackageUnZipFilePath = subPackageInfo.getSubUnzipFilePath();
            mainPackageZipPath = subZipPath;
        } else {
            mainPackageUrlEncryption = appModel.getMainPackageUrlEncryption();
            mainPackageZipPath = appModel.getMainPackageZipPath();
            mainPackageUnZipFilePath = appModel.getMainPackageUnZipFilePath();
        }
        PathProxy pathProxy = (PathProxy) TmcProxy.get(PathProxy.class);
        if (AppPrepareUtils.INSTANCE.checkZipUnCompressStatus(context, appModel.getAppId(), mainPackageUrlEncryption)) {
            if (packageInstallCallback != null) {
                packageInstallCallback.onResult(true, pathProxy.getTarUnCompressPath(appModel, mainPackageUrlEncryption));
                return;
            }
            return;
        }
        try {
            CompressUtils.unzip(new File(mainPackageZipPath), mainPackageUnZipFilePath);
            if (packageInstallCallback != null) {
                packageInstallCallback.onResult(true, mainPackageUnZipFilePath);
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            TmcLogger.e(this.OooO00o, "Step_LoadStep: zip 包解压失败", e11);
            if (packageInstallCallback != null) {
                packageInstallCallback.onResult(false, "error:" + e11.getMessage() + "   path:   " + mainPackageUnZipFilePath);
            }
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean isAvailable(Context context, AppModel appModel) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        return false;
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean isDownloaded(Context context, AppModel appModel) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appModel, "appModel");
        return AppPrepareUtils.INSTANCE.checkZipDownloadStatus(context, appModel);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public boolean isDownloaded(Context context, String str, String str2) {
        Intrinsics.h(context, "context");
        return AppPrepareUtils.INSTANCE.checkZipDownloadStatus(context, str, str2);
    }

    @Override // com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager
    public void removeDownloadAppMap(String str) {
        try {
            TmcLogger.d(this.OooO00o, "remove download key " + str);
            TypeIntrinsics.d(this.OooO0O0).remove(str);
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO00o, th2);
        }
    }
}
