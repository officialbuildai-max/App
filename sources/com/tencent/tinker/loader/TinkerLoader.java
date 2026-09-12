package com.tencent.tinker.loader;

import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

/* loaded from: classes5.dex */
public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        int safeModeCount = ShareTinkerInternals.getSafeModeCount(tinkerApplication);
        if (safeModeCount >= 2) {
            ShareTinkerInternals.setSafeModeCount(tinkerApplication, 0);
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        ShareTinkerInternals.setSafeModeCount(tinkerApplication, safeModeCount + 1);
        return true;
    }

    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, Intent intent) {
        int i11;
        boolean z10;
        int i12;
        ShareSecurityCheck shareSecurityCheck;
        boolean z11;
        boolean z12;
        int i13;
        int i14;
        int i15;
        int tinkerFlags = tinkerApplication.getTinkerFlags();
        if (!ShareTinkerInternals.isTinkerEnabled(tinkerFlags)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles: tinker is disable, just return", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -1);
            return;
        }
        if (ShareTinkerInternals.isInPatchProcess(tinkerApplication)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles: we don't load patch with :patch process itself, just return", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -1);
            return;
        }
        File patchDirectory = SharePatchFileUtil.getPatchDirectory(tinkerApplication);
        if (patchDirectory == null) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:getPatchDirectory == null", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -2);
            return;
        }
        String absolutePath = patchDirectory.getAbsolutePath();
        if (!patchDirectory.exists()) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:patch dir not exist:" + absolutePath, new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -2);
            return;
        }
        File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(absolutePath);
        if (!patchInfoFile.exists()) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:patch info not exist:" + patchInfoFile.getAbsolutePath(), new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -3);
            return;
        }
        File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(absolutePath);
        SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
        this.patchInfo = readAndCheckPropertyWithLock;
        if (readAndCheckPropertyWithLock == null) {
            ShareIntentUtil.setIntentReturnCode(intent, -4);
            return;
        }
        boolean z13 = readAndCheckPropertyWithLock.isProtectedApp;
        intent.putExtra("intent_is_protected_app", z13);
        intent.putExtra("intent_use_custom_patch", this.patchInfo.useCustomPatch);
        SharePatchInfo sharePatchInfo = this.patchInfo;
        String str = sharePatchInfo.oldVersion;
        String str2 = sharePatchInfo.newVersion;
        String str3 = sharePatchInfo.oatDir;
        if (str == null || str2 == null || str3 == null) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchInfoCorrupted", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -4);
            return;
        }
        boolean isInMainProcess = ShareTinkerInternals.isInMainProcess(tinkerApplication);
        String str4 = this.patchInfo.versionToRemove;
        if (isInMainProcess) {
            if (ShareTinkerInternals.isNullOrNil(str4)) {
                i11 = tinkerFlags;
                z10 = isInMainProcess;
            } else if (str2.equals(str4)) {
                i11 = tinkerFlags;
                z10 = isInMainProcess;
                ShareTinkerLog.w(TAG, "found new version clean patch mark and we are in main process, delete patch file now.", new Object[0]);
                String patchVersionDirectory = SharePatchFileUtil.getPatchVersionDirectory(str2);
                if (patchVersionDirectory != null) {
                    boolean equals = str.equals(str2);
                    if (equals) {
                        str = "";
                    }
                    SharePatchInfo sharePatchInfo2 = this.patchInfo;
                    sharePatchInfo2.oldVersion = str;
                    sharePatchInfo2.newVersion = str;
                    sharePatchInfo2.versionToRemove = "";
                    SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo2, patchInfoLockFile);
                    String str5 = absolutePath + "/" + patchVersionDirectory;
                    if (equals) {
                        ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
                        SharePatchFileUtil.deleteDirAsync(str5);
                        ShareIntentUtil.setIntentReturnCode(intent, -2);
                        return;
                    }
                    SharePatchFileUtil.deleteDirAsync(str5);
                    str2 = str;
                }
            } else {
                i11 = tinkerFlags;
                z10 = isInMainProcess;
                if (str.equals(str4)) {
                    ShareTinkerLog.w(TAG, "found old version clean patch mark and we are in main process, delete patch file now.", new Object[0]);
                    String patchVersionDirectory2 = SharePatchFileUtil.getPatchVersionDirectory(str);
                    if (patchVersionDirectory2 != null) {
                        SharePatchInfo sharePatchInfo3 = this.patchInfo;
                        sharePatchInfo3.oldVersion = str2;
                        sharePatchInfo3.newVersion = str2;
                        sharePatchInfo3.versionToRemove = "";
                        SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo3, patchInfoLockFile);
                        ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
                        SharePatchFileUtil.deleteDirAsync(absolutePath + "/" + patchVersionDirectory2);
                        str = str2;
                    }
                } else {
                    SharePatchInfo sharePatchInfo4 = this.patchInfo;
                    sharePatchInfo4.versionToRemove = "";
                    SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo4, patchInfoLockFile);
                }
            }
            if (this.patchInfo.isRemoveInterpretOATDir) {
                ShareTinkerLog.i(TAG, "tryLoadPatchFiles: isRemoveInterpretOATDir is true, try to delete interpret optimize files", new Object[0]);
                SharePatchInfo sharePatchInfo5 = this.patchInfo;
                sharePatchInfo5.isRemoveInterpretOATDir = false;
                SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo5, patchInfoLockFile);
                ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
                SharePatchFileUtil.deleteDirAsync((absolutePath + "/" + SharePatchFileUtil.getPatchVersionDirectory(str2)) + "/interpet");
            }
        } else {
            i11 = tinkerFlags;
            z10 = isInMainProcess;
        }
        intent.putExtra("intent_patch_old_version", str);
        intent.putExtra("intent_patch_new_version", str2);
        boolean equals2 = str.equals(str2);
        boolean equals3 = str3.equals("changing");
        String currentOatMode = ShareTinkerInternals.getCurrentOatMode(tinkerApplication, str3);
        intent.putExtra("intent_patch_oat_dir", currentOatMode);
        if (!equals2 && z10) {
            str = str2;
        }
        if (ShareTinkerInternals.isNullOrNil(str)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:version is blank, wait main process to restart", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -5);
            return;
        }
        String patchVersionDirectory3 = SharePatchFileUtil.getPatchVersionDirectory(str);
        if (patchVersionDirectory3 == null) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:patchName is null", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -6);
            return;
        }
        String str6 = absolutePath + "/" + patchVersionDirectory3;
        File file = new File(str6);
        if (!file.exists()) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchVersionDirectoryNotFound", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -6);
            return;
        }
        String patchVersionFile = SharePatchFileUtil.getPatchVersionFile(str);
        File file2 = patchVersionFile != null ? new File(file.getAbsolutePath(), patchVersionFile) : null;
        if (!SharePatchFileUtil.isLegalFile(file2)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchVersionFileNotFound", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -7);
            return;
        }
        ShareSecurityCheck shareSecurityCheck2 = new ShareSecurityCheck(tinkerApplication);
        int i16 = i11;
        int checkTinkerPackage = ShareTinkerInternals.checkTinkerPackage(tinkerApplication, i16, file2, shareSecurityCheck2);
        if (checkTinkerPackage != 0) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:checkTinkerPackage", new Object[0]);
            intent.putExtra("intent_patch_package_patch_check", checkTinkerPackage);
            ShareIntentUtil.setIntentReturnCode(intent, -8);
            return;
        }
        intent.putExtra("intent_patch_package_config", shareSecurityCheck2.getPackagePropertiesIfPresent());
        boolean isTinkerEnabledForDex = ShareTinkerInternals.isTinkerEnabledForDex(i16);
        boolean isArkHotRuning = ShareTinkerInternals.isArkHotRuning();
        if (!isArkHotRuning && isTinkerEnabledForDex && !TinkerDexLoader.checkComplete(str6, shareSecurityCheck2, currentOatMode, intent)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:dex check fail", new Object[0]);
            return;
        }
        boolean isTinkerEnabledForArkHot = ShareTinkerInternals.isTinkerEnabledForArkHot(i16);
        if (isArkHotRuning && isTinkerEnabledForArkHot && !TinkerArkHotLoader.checkComplete(str6, shareSecurityCheck2, intent)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:dex check fail", new Object[0]);
            return;
        }
        if (ShareTinkerInternals.isTinkerEnabledForNativeLib(i16) && !TinkerSoLoader.checkComplete(str6, shareSecurityCheck2, intent)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:native lib check fail", new Object[0]);
            return;
        }
        boolean isTinkerEnabledForResource = ShareTinkerInternals.isTinkerEnabledForResource(i16);
        ShareTinkerLog.w(TAG, "tryLoadPatchFiles:isEnabledForResource:" + isTinkerEnabledForResource, new Object[0]);
        if (isTinkerEnabledForResource && !TinkerResourceLoader.checkComplete(tinkerApplication, str6, shareSecurityCheck2, intent)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:resource check fail", new Object[0]);
            return;
        }
        boolean z14 = ShareTinkerInternals.isVmArt() && ShareTinkerInternals.isSystemOTA(this.patchInfo.fingerPrint) && !ShareTinkerInternals.isAfterAndroidO();
        intent.putExtra("intent_patch_system_ota", z14);
        if (z10) {
            if (!equals2) {
                this.patchInfo.oldVersion = str;
            }
            if (equals3) {
                SharePatchInfo sharePatchInfo6 = this.patchInfo;
                sharePatchInfo6.oatDir = currentOatMode;
                sharePatchInfo6.isRemoveInterpretOATDir = true;
            }
        }
        if (checkSafeModeCount(tinkerApplication)) {
            i12 = 0;
        } else {
            if (z10) {
                SharePatchInfo sharePatchInfo7 = this.patchInfo;
                sharePatchInfo7.oldVersion = "";
                sharePatchInfo7.newVersion = "";
                sharePatchInfo7.versionToRemove = "";
                SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo7, patchInfoLockFile);
                ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
                SharePatchFileUtil.deleteDirAsync(absolutePath + "/" + patchVersionDirectory3);
                intent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
                ShareIntentUtil.setIntentReturnCode(intent, -25);
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:checkSafeModeCount fail, patch was deleted.", new Object[0]);
                return;
            }
            i12 = 0;
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:checkSafeModeCount fail, but we are not in main process, mark the patch to be deleted and continue load patch.", new Object[0]);
            ShareTinkerInternals.cleanPatch(tinkerApplication);
        }
        if (isTinkerEnabledForResource && !TinkerResourceLoader.loadTinkerResources(tinkerApplication, str6, intent)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchLoadResourcesFail", new Object[i12]);
            return;
        }
        if (isArkHotRuning || !isTinkerEnabledForDex) {
            shareSecurityCheck = shareSecurityCheck2;
            z11 = isTinkerEnabledForResource;
            z12 = equals2;
            i13 = -19;
        } else {
            z12 = equals2;
            shareSecurityCheck = shareSecurityCheck2;
            boolean z15 = z14;
            z11 = isTinkerEnabledForResource;
            i13 = -19;
            boolean loadTinkerJars = TinkerDexLoader.loadTinkerJars(tinkerApplication, str6, currentOatMode, intent, z15, z13);
            if (z15) {
                SharePatchInfo sharePatchInfo8 = this.patchInfo;
                sharePatchInfo8.fingerPrint = Build.FINGERPRINT;
                sharePatchInfo8.oatDir = loadTinkerJars ? "interpet" : "odex";
                if (!SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo8, patchInfoLockFile)) {
                    ShareIntentUtil.setIntentReturnCode(intent, -19);
                    ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onReWritePatchInfoCorrupted", new Object[0]);
                    return;
                } else {
                    i15 = 0;
                    intent.putExtra("intent_patch_oat_dir", this.patchInfo.oatDir);
                    equals3 = false;
                }
            } else {
                i15 = 0;
            }
            if (!loadTinkerJars) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchLoadDexesFail", new Object[i15]);
                return;
            }
        }
        if (isArkHotRuning && isTinkerEnabledForArkHot && !TinkerArkHotLoader.loadTinkerArkHot(tinkerApplication, str6, intent)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchLoadArkApkFail", new Object[0]);
            return;
        }
        if ((isTinkerEnabledForDex || isTinkerEnabledForArkHot) && z11) {
            ComponentHotplug.install(tinkerApplication, shareSecurityCheck);
        }
        if (!AppInfoChangedBlocker.tryStart(tinkerApplication)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:AppInfoChangedBlocker install fail.", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -28);
            return;
        }
        if (!z10 || (z12 && !equals3)) {
            i14 = 0;
        } else if (!SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, this.patchInfo, patchInfoLockFile)) {
            ShareIntentUtil.setIntentReturnCode(intent, i13);
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onReWritePatchInfoCorrupted", new Object[0]);
            return;
        } else {
            i14 = 0;
            ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
        }
        ShareIntentUtil.setIntentReturnCode(intent, i14);
        ShareTinkerLog.i(TAG, "tryLoadPatchFiles: load end, ok!", new Object[i14]);
    }

    public Intent tryLoad(TinkerApplication tinkerApplication) {
        ShareTinkerLog.d(TAG, "tryLoad test test", new Object[0]);
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.setIntentPatchCostTime(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }
}
