package com.tencent.tinker.loader;

import android.content.Intent;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class TinkerDexLoader {
    private static final ArrayList<ShareDexDiffPatchInfo> LOAD_DEX_LIST = new ArrayList<>();
    private static HashSet<ShareDexDiffPatchInfo> classNDexInfo = new HashSet<>();
    private static boolean isVmArt = ShareTinkerInternals.isVmArt();

    private TinkerDexLoader() {
    }

    public static boolean checkComplete(String str, ShareSecurityCheck shareSecurityCheck, String str2, Intent intent) {
        String str3 = shareSecurityCheck.getMetaContentMap().get("assets/dex_meta.txt");
        if (str3 == null) {
            return true;
        }
        LOAD_DEX_LIST.clear();
        classNDexInfo.clear();
        ArrayList arrayList = new ArrayList();
        ShareDexDiffPatchInfo.parseDexDiffPatchInfo(str3, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = (ShareDexDiffPatchInfo) it.next();
            if (!isJustArtSupportDex(shareDexDiffPatchInfo2)) {
                if (!ShareDexDiffPatchInfo.checkDexDiffPatchInfo(shareDexDiffPatchInfo2)) {
                    intent.putExtra("intent_patch_package_patch_check", -3);
                    ShareIntentUtil.setIntentReturnCode(intent, -8);
                    return false;
                }
                if (isVmArt && shareDexDiffPatchInfo2.rawName.startsWith("test.dex")) {
                    shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                } else if (isVmArt && ShareConstants.CLASS_N_PATTERN.matcher(shareDexDiffPatchInfo2.realName).matches()) {
                    classNDexInfo.add(shareDexDiffPatchInfo2);
                } else {
                    hashMap.put(shareDexDiffPatchInfo2.realName, getInfoMd5(shareDexDiffPatchInfo2));
                    LOAD_DEX_LIST.add(shareDexDiffPatchInfo2);
                }
            }
        }
        if (isVmArt && (shareDexDiffPatchInfo != null || !classNDexInfo.isEmpty())) {
            if (shareDexDiffPatchInfo != null) {
                HashSet<ShareDexDiffPatchInfo> hashSet = classNDexInfo;
                hashSet.add(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, hashSet.size() + 1));
            }
            hashMap.put("tinker_classN.apk", "");
        }
        String str4 = str + "/dex/";
        File file = new File(str4);
        if (!file.exists() || !file.isDirectory()) {
            ShareIntentUtil.setIntentReturnCode(intent, -9);
            return false;
        }
        File file2 = new File(str + "/" + str2 + "/");
        Iterator it2 = hashMap.keySet().iterator();
        while (it2.hasNext()) {
            File file3 = new File(str4 + ((String) it2.next()));
            if (!SharePatchFileUtil.isLegalFile(file3)) {
                intent.putExtra("intent_patch_missing_dex_path", file3.getAbsolutePath());
                ShareIntentUtil.setIntentReturnCode(intent, -10);
                return false;
            }
            File file4 = new File(SharePatchFileUtil.optimizedPathFor(file3, file2));
            if (!SharePatchFileUtil.isLegalFile(file4) && !SharePatchFileUtil.shouldAcceptEvenIfIllegal(file4)) {
                intent.putExtra("intent_patch_missing_dex_path", file4.getAbsolutePath());
                ShareIntentUtil.setIntentReturnCode(intent, -11);
                return false;
            }
        }
        intent.putExtra("intent_patch_dexes_path", hashMap);
        return true;
    }

    private static void deleteOutOfDateOATFile(String str) {
        SharePatchFileUtil.deleteDir(str + "/odex/");
        if (ShareTinkerInternals.isAfterAndroidO()) {
            SharePatchFileUtil.deleteDir(str + "/dex/oat/");
        }
    }

    private static String getInfoMd5(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        return isVmArt ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
    }

    private static boolean isJustArtSupportDex(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        return !isVmArt && shareDexDiffPatchInfo.destMd5InDvm.equals("0");
    }

    public static boolean loadTinkerJars(TinkerApplication tinkerApplication, String str, String str2, Intent intent, boolean z10, boolean z11) {
        ArrayList arrayList;
        File file;
        ArrayList<ShareDexDiffPatchInfo> arrayList2 = LOAD_DEX_LIST;
        if (arrayList2.isEmpty() && classNDexInfo.isEmpty()) {
            ShareTinkerLog.w("Tinker.TinkerDexLoader", "there is no dex to load", new Object[0]);
            return true;
        }
        ClassLoader classLoader = TinkerDexLoader.class.getClassLoader();
        if (classLoader == null) {
            ShareTinkerLog.e("Tinker.TinkerDexLoader", "classloader is null", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -12);
            return false;
        }
        ShareTinkerLog.i("Tinker.TinkerDexLoader", "classloader: " + classLoader.toString(), new Object[0]);
        String str3 = str + "/dex/";
        ArrayList arrayList3 = new ArrayList();
        Iterator<ShareDexDiffPatchInfo> it = arrayList2.iterator();
        while (it.hasNext()) {
            ShareDexDiffPatchInfo next = it.next();
            if (!isJustArtSupportDex(next)) {
                File file2 = new File(str3 + next.realName);
                if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!SharePatchFileUtil.verifyDexFileMd5(file2, getInfoMd5(next))) {
                        ShareIntentUtil.setIntentReturnCode(intent, -13);
                        intent.putExtra("intent_patch_mismatch_dex_path", file2.getAbsolutePath());
                        return false;
                    }
                    ShareTinkerLog.i("Tinker.TinkerDexLoader", "verify dex file:" + file2.getPath() + " md5, use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                }
                arrayList3.add(file2);
            }
        }
        if (isVmArt && !classNDexInfo.isEmpty()) {
            File file3 = new File(str3 + "tinker_classN.apk");
            long currentTimeMillis2 = System.currentTimeMillis();
            if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                Iterator<ShareDexDiffPatchInfo> it2 = classNDexInfo.iterator();
                while (it2.hasNext()) {
                    ShareDexDiffPatchInfo next2 = it2.next();
                    if (!SharePatchFileUtil.verifyDexFileMd5(file3, next2.rawName, next2.destMd5InArt)) {
                        ShareIntentUtil.setIntentReturnCode(intent, -13);
                        intent.putExtra("intent_patch_mismatch_dex_path", file3.getAbsolutePath());
                        return false;
                    }
                }
            }
            ShareTinkerLog.i("Tinker.TinkerDexLoader", "verify dex file:" + file3.getPath() + " md5, use time: " + (System.currentTimeMillis() - currentTimeMillis2), new Object[0]);
            arrayList3.add(file3);
        }
        File file4 = new File(str + "/" + str2);
        if (z10) {
            final boolean[] zArr = {true};
            final Throwable[] thArr = new Throwable[1];
            try {
                String currentInstructionSet = ShareTinkerInternals.getCurrentInstructionSet();
                deleteOutOfDateOATFile(str);
                ShareTinkerLog.w("Tinker.TinkerDexLoader", "systemOTA, try parallel oat dexes, targetISA:" + currentInstructionSet, new Object[0]);
                File file5 = new File(str + "/interpet");
                arrayList = arrayList3;
                TinkerDexOptimizer.optimizeAll(tinkerApplication, arrayList3, file5, true, tinkerApplication.isUseDelegateLastClassLoader(), currentInstructionSet, false, new TinkerDexOptimizer.ResultCallback() { // from class: com.tencent.tinker.loader.TinkerDexLoader.1
                    long start;

                    @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                    public void onFailed(File file6, File file7, Throwable th2) {
                        zArr[0] = false;
                        thArr[0] = th2;
                        ShareTinkerLog.i("Tinker.TinkerDexLoader", "fail to optimize dex " + file6.getPath() + ", use time " + (System.currentTimeMillis() - this.start), new Object[0]);
                    }

                    @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                    public void onStart(File file6, File file7) {
                        this.start = System.currentTimeMillis();
                        ShareTinkerLog.i("Tinker.TinkerDexLoader", "start to optimize dex:" + file6.getPath(), new Object[0]);
                    }

                    @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                    public void onSuccess(File file6, File file7, File file8) {
                        ShareTinkerLog.i("Tinker.TinkerDexLoader", "success to optimize dex " + file6.getPath() + ", use time " + (System.currentTimeMillis() - this.start), new Object[0]);
                    }
                });
                if (!zArr[0]) {
                    ShareTinkerLog.e("Tinker.TinkerDexLoader", "parallel oat dexes failed", new Object[0]);
                    intent.putExtra("intent_patch_interpret_exception", thArr[0]);
                    ShareIntentUtil.setIntentReturnCode(intent, -16);
                    return false;
                }
                file = file5;
            } catch (Throwable th2) {
                ShareTinkerLog.i("Tinker.TinkerDexLoader", "getCurrentInstructionSet fail:" + th2, new Object[0]);
                deleteOutOfDateOATFile(str);
                intent.putExtra("intent_patch_interpret_exception", th2);
                ShareIntentUtil.setIntentReturnCode(intent, -15);
                return false;
            }
        } else {
            arrayList = arrayList3;
            file = file4;
        }
        try {
            SystemClassLoaderAdder.installDexes(tinkerApplication, classLoader, file, arrayList, z11, tinkerApplication.isUseDelegateLastClassLoader());
            return true;
        } catch (Throwable th3) {
            ShareTinkerLog.e("Tinker.TinkerDexLoader", "install dexes failed", new Object[0]);
            intent.putExtra("intent_patch_exception", th3);
            ShareIntentUtil.setIntentReturnCode(intent, -14);
            return false;
        }
    }
}
