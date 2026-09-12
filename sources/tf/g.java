package tf;

import android.content.Context;
import android.os.Build;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class g extends a {
    @Override // tf.a
    public boolean a(Context context, String str, boolean z10, PatchResult patchResult) {
        SharePatchInfo sharePatchInfo;
        int i11;
        File file;
        vf.a x10 = vf.a.x(context);
        File file2 = new File(str);
        if (!x10.t() || !ShareTinkerInternals.isTinkerEnableWithSharedPreferences(context)) {
            ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        }
        if (!SharePatchFileUtil.isLegalFile(file2)) {
            ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        }
        ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
        int checkTinkerPackage = ShareTinkerInternals.checkTinkerPackage(context, x10.l(), file2, shareSecurityCheck);
        if (checkTinkerPackage != 0) {
            ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
            x10.k().b(file2, checkTinkerPackage);
            return false;
        }
        String md5 = SharePatchFileUtil.getMD5(file2);
        if (md5 == null) {
            ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
            return false;
        }
        patchResult.patchVersion = md5;
        ShareTinkerLog.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", md5);
        String absolutePath = x10.h().getAbsolutePath();
        File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(absolutePath);
        File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(absolutePath);
        HashMap<String, String> packagePropertiesIfPresent = shareSecurityCheck.getPackagePropertiesIfPresent();
        if (packagePropertiesIfPresent == null) {
            ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch packageProperties is null, do we process a valid patch apk ?", new Object[0]);
            return false;
        }
        String str2 = packagePropertiesIfPresent.get("is_protected_app");
        boolean z11 = (str2 == null || str2.isEmpty() || "0".equals(str2)) ? false : true;
        String str3 = packagePropertiesIfPresent.get("use_custom_file_patch");
        boolean z12 = (str3 == null || str3.isEmpty() || "0".equals(str3)) ? false : true;
        SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
        if (readAndCheckPropertyWithLock == null) {
            sharePatchInfo = new SharePatchInfo("", md5, z11, z12, "", Build.FINGERPRINT, "odex", false);
        } else {
            if (readAndCheckPropertyWithLock.oldVersion == null || readAndCheckPropertyWithLock.newVersion == null || readAndCheckPropertyWithLock.oatDir == null) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                x10.k().c(file2, readAndCheckPropertyWithLock.oldVersion, readAndCheckPropertyWithLock.newVersion);
                return false;
            }
            if (!SharePatchFileUtil.checkIfMd5Valid(md5)) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", md5);
                x10.k().g(file2, readAndCheckPropertyWithLock, md5);
                return false;
            }
            boolean equals = readAndCheckPropertyWithLock.oatDir.equals("interpet");
            if (!equals && !ShareTinkerInternals.isNullOrNil(readAndCheckPropertyWithLock.newVersion) && readAndCheckPropertyWithLock.newVersion.equals(md5) && !readAndCheckPropertyWithLock.newVersion.equals(readAndCheckPropertyWithLock.versionToRemove)) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "patch already applied, md5: %s", md5);
                wf.c.b(context).d(md5);
                return true;
            }
            String str4 = equals ? "changing" : readAndCheckPropertyWithLock.oatDir;
            if (!md5.equals(readAndCheckPropertyWithLock.newVersion) && !readAndCheckPropertyWithLock.newVersion.equals(readAndCheckPropertyWithLock.oldVersion)) {
                String str5 = readAndCheckPropertyWithLock.newVersion;
                readAndCheckPropertyWithLock.newVersion = readAndCheckPropertyWithLock.oldVersion;
                SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, readAndCheckPropertyWithLock, patchInfoLockFile);
                SharePatchFileUtil.deleteDir(new File(absolutePath, SharePatchFileUtil.getPatchVersionDirectory(str5)));
            }
            sharePatchInfo = new SharePatchInfo(readAndCheckPropertyWithLock.oldVersion, md5, z11, z12, md5.equals(readAndCheckPropertyWithLock.versionToRemove) ? "" : readAndCheckPropertyWithLock.versionToRemove, Build.FINGERPRINT, str4, false);
        }
        String str6 = absolutePath + "/" + SharePatchFileUtil.getPatchVersionDirectory(md5);
        ShareTinkerLog.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", str6);
        File file3 = new File(str6 + "/" + SharePatchFileUtil.getPatchVersionFile(md5));
        try {
            if (!md5.equals(SharePatchFileUtil.getMD5(file3))) {
                SharePatchFileUtil.copyFileUsingStream(file2, file3);
                try {
                    ShareTinkerLog.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", file2.getAbsolutePath(), Long.valueOf(file2.length()), file3.getAbsolutePath(), Long.valueOf(file3.length()));
                } catch (IOException unused) {
                    file = file3;
                    i11 = 1;
                    String path = file2.getPath();
                    String path2 = file.getPath();
                    Object[] objArr = new Object[2];
                    objArr[0] = path;
                    objArr[i11] = path2;
                    ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", objArr);
                    x10.k().a(file2, file, file2.getName(), i11);
                    return false;
                }
            }
            if (!d.m(x10, shareSecurityCheck, context, str6, file3, z10, patchResult)) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                return false;
            }
            if (!b.e(x10, shareSecurityCheck, context, str6, file3)) {
                return false;
            }
            if (!f.e(x10, shareSecurityCheck, context, str6, file3, z12, patchResult)) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                return false;
            }
            if (!e.f(x10, shareSecurityCheck, context, str6, file3, z12, patchResult)) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                return false;
            }
            if (!d.n(file2, x10)) {
                ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
                return false;
            }
            if (SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo, patchInfoLockFile)) {
                wf.c.b(context).d(md5);
                ShareTinkerLog.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                return true;
            }
            ShareTinkerLog.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
            x10.k().c(file2, sharePatchInfo.oldVersion, sharePatchInfo.newVersion);
            return false;
        } catch (IOException unused2) {
            i11 = 1;
            file = file3;
        }
    }
}
