package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public class SharePatchInfo {
    public String fingerPrint;
    public boolean isProtectedApp;
    public boolean isRemoveInterpretOATDir;
    public String newVersion;
    public String oatDir;
    public String oldVersion;
    public boolean useCustomPatch;
    public String versionToRemove;

    public SharePatchInfo(String str, String str2, boolean z10, boolean z11, String str3, String str4, String str5, boolean z12) {
        this.oldVersion = str;
        this.newVersion = str2;
        this.isProtectedApp = z10;
        this.versionToRemove = str3;
        this.fingerPrint = str4;
        this.oatDir = str5;
        this.isRemoveInterpretOATDir = z12;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b7 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.tencent.tinker.loader.shareutil.SharePatchInfo readAndCheckProperty(java.io.File r17) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchInfo.readAndCheckProperty(java.io.File):com.tencent.tinker.loader.shareutil.SharePatchInfo");
    }

    public static SharePatchInfo readAndCheckPropertyWithLock(File file, File file2) {
        ShareFileLockHelper shareFileLockHelper = null;
        if (file == null || file2 == null) {
            return null;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            try {
                shareFileLockHelper = ShareFileLockHelper.getFileLock(file2);
                SharePatchInfo readAndCheckProperty = readAndCheckProperty(file);
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e11) {
                        ShareTinkerLog.w("Tinker.PatchInfo", "releaseInfoLock error", e11);
                    }
                }
                return readAndCheckProperty;
            } catch (Throwable th2) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e12) {
                        ShareTinkerLog.w("Tinker.PatchInfo", "releaseInfoLock error", e12);
                    }
                }
                throw th2;
            }
        } catch (Exception e13) {
            throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e13);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean rewritePatchInfoFile(java.io.File r8, com.tencent.tinker.loader.shareutil.SharePatchInfo r9) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchInfo.rewritePatchInfoFile(java.io.File, com.tencent.tinker.loader.shareutil.SharePatchInfo):boolean");
    }

    public static boolean rewritePatchInfoFileWithLock(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            try {
                shareFileLockHelper = ShareFileLockHelper.getFileLock(file2);
                boolean rewritePatchInfoFile = rewritePatchInfoFile(file, sharePatchInfo);
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e11) {
                        ShareTinkerLog.i("Tinker.PatchInfo", "releaseInfoLock error", e11);
                    }
                }
                return rewritePatchInfoFile;
            } catch (Throwable th2) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (IOException e12) {
                        ShareTinkerLog.i("Tinker.PatchInfo", "releaseInfoLock error", e12);
                    }
                }
                throw th2;
            }
        } catch (Exception e13) {
            throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e13);
        }
    }
}
