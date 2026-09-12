package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes5.dex */
public class ShareTinkerInternals {
    private static final boolean VM_IS_ART = isVmArt(System.getProperty("java.vm.version"));
    private static final boolean VM_IS_JIT = isVmJitInternal();
    private static Boolean isPatchProcess = null;
    private static Boolean isARKHotRunning = null;
    private static final String[] processName = {null};
    private static String tinkerID = null;
    private static String currentInstructionSet = null;

    public static ShareDexDiffPatchInfo changeTestDexToClassN(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i11) {
        String str;
        if (!shareDexDiffPatchInfo.rawName.startsWith("test.dex")) {
            return null;
        }
        if (i11 != 1) {
            str = "classes" + i11 + ".dex";
        } else {
            str = "classes.dex";
        }
        return new ShareDexDiffPatchInfo(str, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.destMd5InDvm, shareDexDiffPatchInfo.destMd5InArt, shareDexDiffPatchInfo.dexDiffMd5, shareDexDiffPatchInfo.oldDexCrC, shareDexDiffPatchInfo.newOrPatchedDexCrC, shareDexDiffPatchInfo.dexMode);
    }

    public static int checkPackageAndTinkerFlag(ShareSecurityCheck shareSecurityCheck, int i11) {
        if (isTinkerEnabledAll(i11)) {
            return 0;
        }
        HashMap<String, String> metaContentMap = shareSecurityCheck.getMetaContentMap();
        if (!isTinkerEnabledForDex(i11) && metaContentMap.containsKey("assets/dex_meta.txt")) {
            return -9;
        }
        if (isTinkerEnabledForNativeLib(i11) || !metaContentMap.containsKey("assets/so_meta.txt")) {
            return (isTinkerEnabledForResource(i11) || !metaContentMap.containsKey("assets/res_meta.txt")) ? 0 : -9;
        }
        return -9;
    }

    public static int checkSignatureAndTinkerID(Context context, File file, ShareSecurityCheck shareSecurityCheck) {
        if (!shareSecurityCheck.verifyPatchMetaSignature(file)) {
            return -1;
        }
        String manifestTinkerID = getManifestTinkerID(context);
        if (manifestTinkerID == null) {
            return -5;
        }
        HashMap<String, String> packagePropertiesIfPresent = shareSecurityCheck.getPackagePropertiesIfPresent();
        if (packagePropertiesIfPresent == null) {
            return -2;
        }
        String str = packagePropertiesIfPresent.get("TINKER_ID");
        if (str == null) {
            return -6;
        }
        if (manifestTinkerID.equals(str)) {
            return 0;
        }
        ShareTinkerLog.e("Tinker.TinkerInternals", "tinkerId in patch is not matched with the one in base pack, base: %s, patch: %s.", manifestTinkerID, str);
        return -7;
    }

    public static int checkTinkerPackage(Context context, int i11, File file, ShareSecurityCheck shareSecurityCheck) {
        int checkSignatureAndTinkerID = checkSignatureAndTinkerID(context, file, shareSecurityCheck);
        return checkSignatureAndTinkerID == 0 ? checkPackageAndTinkerFlag(shareSecurityCheck, i11) : checkSignatureAndTinkerID;
    }

    public static void cleanPatch(Context context) {
        if (context == null) {
            throw new TinkerRuntimeException("context is null");
        }
        File patchDirectory = SharePatchFileUtil.getPatchDirectory(context);
        if (!patchDirectory.exists()) {
            ShareTinkerLog.printErrStackTrace("Tinker.TinkerInternals", new Throwable(), "try to clean patch while there're not any applied patches.", new Object[0]);
            return;
        }
        File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(patchDirectory.getAbsolutePath());
        if (!patchInfoFile.exists()) {
            ShareTinkerLog.printErrStackTrace("Tinker.TinkerInternals", new Throwable(), "try to clean patch while patch info file does not exist.", new Object[0]);
            return;
        }
        File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(patchDirectory.getAbsolutePath());
        SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
        if (readAndCheckPropertyWithLock == null) {
            ShareTinkerLog.printErrStackTrace("Tinker.TinkerInternals", new Throwable(), "fail to get patchInfo.", new Object[0]);
            return;
        }
        if (readAndCheckPropertyWithLock.newVersion.equals(readAndCheckPropertyWithLock.oldVersion)) {
            readAndCheckPropertyWithLock.versionToRemove = readAndCheckPropertyWithLock.newVersion;
        } else {
            SharePatchFileUtil.deleteDir(new File(patchDirectory, SharePatchFileUtil.getPatchVersionDirectory(readAndCheckPropertyWithLock.newVersion)));
            readAndCheckPropertyWithLock.newVersion = readAndCheckPropertyWithLock.oldVersion;
            readAndCheckPropertyWithLock.versionToRemove = "";
        }
        SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, readAndCheckPropertyWithLock, patchInfoLockFile);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    public static Properties fastGetPatchPackageMeta(File file) {
        ZipFile zipFile;
        InputStream inputStream;
        ZipFile zipFile2 = null;
        if (file != null && file.isFile()) {
            ?? r32 = (file.length() > 0L ? 1 : (file.length() == 0L ? 0 : -1));
            try {
                if (r32 != 0) {
                    try {
                        zipFile = new ZipFile(file);
                        try {
                            ZipEntry entry = zipFile.getEntry("assets/package_meta.txt");
                            if (entry == null) {
                                ShareTinkerLog.e("Tinker.TinkerInternals", "patch meta entry not found", new Object[0]);
                                SharePatchFileUtil.closeZip(zipFile);
                                return null;
                            }
                            try {
                                inputStream = zipFile.getInputStream(entry);
                                try {
                                    Properties properties = new Properties();
                                    properties.load(inputStream);
                                    SharePatchFileUtil.closeQuietly(inputStream);
                                    SharePatchFileUtil.closeZip(zipFile);
                                    return properties;
                                } catch (Throwable th2) {
                                    th = th2;
                                    SharePatchFileUtil.closeQuietly(inputStream);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                            }
                        } catch (IOException e11) {
                            e = e11;
                            ShareTinkerLog.e("Tinker.TinkerInternals", "fastGetPatchPackageMeta exception:" + e.getMessage(), new Object[0]);
                            SharePatchFileUtil.closeZip(zipFile);
                            return null;
                        }
                    } catch (IOException e12) {
                        e = e12;
                        zipFile = null;
                    } catch (Throwable th4) {
                        th = th4;
                        SharePatchFileUtil.closeZip(zipFile2);
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                zipFile2 = r32;
            }
        }
        ShareTinkerLog.e("Tinker.TinkerInternals", "patchFile is illegal", new Object[0]);
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        if (r6.equals("x86_64") == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getCurrentInstructionSet() {
        /*
            java.lang.String r0 = "mips"
            java.lang.String r1 = "x86"
            java.lang.String r2 = "x86_64"
            r3 = 0
            java.lang.String r4 = "mips64"
            r5 = 1
            java.lang.String r6 = com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet
            if (r6 == 0) goto Lf
            return r6
        Lf:
            java.lang.String r6 = "dalvik.system.VMRuntime"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Throwable -> L29
            java.lang.String r7 = "getCurrentInstructionSet"
            r8 = 0
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)     // Catch: java.lang.Throwable -> L29
            r6.setAccessible(r5)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r6 = r6.invoke(r8, r8)     // Catch: java.lang.Throwable -> L29
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L29
            com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet = r6     // Catch: java.lang.Throwable -> L29
            goto La9
        L29:
            java.lang.String r6 = android.os.Build.CPU_ABI
            r6.hashCode()
            r7 = -1
            int r8 = r6.hashCode()
            switch(r8) {
                case -1073971299: goto L72;
                case -806050265: goto L6b;
                case -738963905: goto L60;
                case 117110: goto L57;
                case 3351711: goto L4e;
                case 145444210: goto L43;
                case 1431565292: goto L38;
                default: goto L36;
            }
        L36:
            r5 = r7
            goto L7a
        L38:
            java.lang.String r5 = "arm64-v8a"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L41
            goto L36
        L41:
            r5 = 6
            goto L7a
        L43:
            java.lang.String r5 = "armeabi-v7a"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L4c
            goto L36
        L4c:
            r5 = 5
            goto L7a
        L4e:
            boolean r5 = r6.equals(r0)
            if (r5 != 0) goto L55
            goto L36
        L55:
            r5 = 4
            goto L7a
        L57:
            boolean r5 = r6.equals(r1)
            if (r5 != 0) goto L5e
            goto L36
        L5e:
            r5 = 3
            goto L7a
        L60:
            java.lang.String r5 = "armeabi"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L69
            goto L36
        L69:
            r5 = 2
            goto L7a
        L6b:
            boolean r8 = r6.equals(r2)
            if (r8 != 0) goto L7a
            goto L36
        L72:
            boolean r5 = r6.equals(r4)
            if (r5 != 0) goto L79
            goto L36
        L79:
            r5 = r3
        L7a:
            switch(r5) {
                case 0: goto La7;
                case 1: goto La4;
                case 2: goto L9f;
                case 3: goto L9c;
                case 4: goto L99;
                case 5: goto L9f;
                case 6: goto L94;
                default: goto L7d;
            }
        L7d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported abi: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L94:
            java.lang.String r0 = "arm64"
            com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet = r0
            goto La9
        L99:
            com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet = r0
            goto La9
        L9c:
            com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet = r1
            goto La9
        L9f:
            java.lang.String r0 = "arm"
            com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet = r0
            goto La9
        La4:
            com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet = r2
            goto La9
        La7:
            com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet = r4
        La9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getCurrentInstructionSet:"
            r0.append(r1)
            java.lang.String r1 = com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "Tinker.TinkerInternals"
            com.tencent.tinker.loader.shareutil.ShareTinkerLog.d(r2, r0, r1)
            java.lang.String r0 = com.tencent.tinker.loader.shareutil.ShareTinkerInternals.currentInstructionSet
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.getCurrentInstructionSet():java.lang.String");
    }

    public static String getCurrentOatMode(Context context, String str) {
        return str.equals("changing") ? isInMainProcess(context) ? "odex" : "interpet" : str;
    }

    public static String getExceptionCauseString(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (true) {
            try {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    th2.printStackTrace(printStream);
                    return toVisualString(byteArrayOutputStream.toString());
                }
                th2 = cause;
            } finally {
                SharePatchFileUtil.closeQuietly(printStream);
            }
        }
    }

    public static String getManifestTinkerID(Context context) {
        String str = tinkerID;
        if (str != null) {
            return str;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("TINKER_ID");
            if (obj != null) {
                tinkerID = String.valueOf(obj);
            } else {
                tinkerID = null;
            }
            return tinkerID;
        } catch (Exception e11) {
            ShareTinkerLog.e("Tinker.TinkerInternals", "getManifestTinkerID exception:" + e11.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String getProcessName(Context context) {
        String[] strArr = processName;
        if (strArr[0] == null) {
            synchronized (strArr) {
                try {
                    if (strArr[0] == null) {
                        strArr[0] = getProcessNameInternal(context);
                    }
                } finally {
                }
            }
        }
        String str = strArr[0];
        return str != null ? str : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getProcessNameInternal(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.getProcessNameInternal(android.content.Context):java.lang.String");
    }

    public static int getSafeModeCount(Context context) {
        DataInputStream dataInputStream;
        String str = "safemode_count_rec_" + getProcessName(context);
        File file = new File(SharePatchFileUtil.getPatchDirectory(context), str);
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));
        } catch (Throwable unused) {
        }
        try {
            String readUTF = dataInputStream.readUTF();
            if (!"safe_mode_count_1.9.15.2".equals(readUTF)) {
                ShareTinkerLog.w("Tinker.TinkerInternals", "getSafeModeCount: key is not equal, expt: %s, actul: %s, return 0 instead.", "safe_mode_count_1.9.15.2", readUTF);
                SharePatchFileUtil.closeQuietly(dataInputStream);
                return 0;
            }
            int readInt = dataInputStream.readInt();
            ShareTinkerLog.i("Tinker.TinkerInternals", "getSafeModeCount: count: %s", Integer.valueOf(readInt));
            SharePatchFileUtil.closeQuietly(dataInputStream);
            return readInt;
        } catch (Throwable unused2) {
            dataInputStream2 = dataInputStream;
            try {
                ShareTinkerLog.w("Tinker.TinkerInternals", "getSafeModeCount: recFileName:" + str + " failed, return 0 instead.", new Object[0]);
                return 0;
            } finally {
                SharePatchFileUtil.closeQuietly(dataInputStream2);
            }
        }
    }

    private static String getTinkerSwitchSPKey(Context context) {
        String manifestTinkerID = getManifestTinkerID(context);
        if (isNullOrNil(manifestTinkerID)) {
            manifestTinkerID = "@@";
        }
        return "tinker_enable_1.9.15.2_" + manifestTinkerID;
    }

    public static String getTypeString(int i11) {
        switch (i11) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return "dex";
            case 4:
                return "dex_opt";
            case 5:
                return "lib";
            case 6:
                return "resource";
            default:
                return TmcConstants.ROUTE_UNKNOWN;
        }
    }

    public static boolean is32BitEnv() {
        String currentInstructionSet2 = getCurrentInstructionSet();
        return "arm".equals(currentInstructionSet2) || "x86".equals(currentInstructionSet2) || "mips".equals(currentInstructionSet2);
    }

    public static boolean isAfterAndroidO() {
        return Build.VERSION.SDK_INT > 25;
    }

    public static boolean isArkHotRuning() {
        Boolean bool = isARKHotRunning;
        if (bool != null) {
            return bool.booleanValue();
        }
        isARKHotRunning = Boolean.FALSE;
        try {
            Method declaredMethod = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.app.ArkApplicationInfo").getDeclaredMethod("isRunningInArk", null);
            declaredMethod.setAccessible(true);
            isARKHotRunning = (Boolean) declaredMethod.invoke(null, null);
        } catch (ClassNotFoundException unused) {
            ShareTinkerLog.i("Tinker.TinkerInternals", "class not found exception", new Object[0]);
        } catch (IllegalAccessException unused2) {
            ShareTinkerLog.i("Tinker.TinkerInternals", "illegal access exception", new Object[0]);
        } catch (IllegalArgumentException unused3) {
            ShareTinkerLog.i("Tinker.TinkerInternals", "illegal argument exception", new Object[0]);
        } catch (NoSuchMethodException unused4) {
            ShareTinkerLog.i("Tinker.TinkerInternals", "no such method exception", new Object[0]);
        } catch (SecurityException unused5) {
            ShareTinkerLog.i("Tinker.TinkerInternals", "security exception", new Object[0]);
        } catch (InvocationTargetException unused6) {
            ShareTinkerLog.i("Tinker.TinkerInternals", "invocation target exception", new Object[0]);
        }
        return isARKHotRunning.booleanValue();
    }

    public static boolean isInMainProcess(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String str = applicationInfo != null ? applicationInfo.processName : null;
        if (isNullOrNil(str)) {
            str = context.getPackageName();
        }
        String processName2 = getProcessName(context);
        if (processName2 == null || processName2.length() == 0) {
            processName2 = "";
        }
        return str.equals(processName2);
    }

    public static boolean isInPatchProcess(Context context) {
        Boolean bool = isPatchProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(getProcessName(context).endsWith(":patch"));
        isPatchProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isNewerOrEqualThanVersion(int i11, boolean z10) {
        if (!z10) {
            return Build.VERSION.SDK_INT >= i11;
        }
        int i12 = Build.VERSION.SDK_INT;
        return i12 >= i11 || (i12 == i11 - 1 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }

    public static boolean isNullOrNil(String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean isOlderOrEqualThanVersion(int i11, boolean z10) {
        if (!z10) {
            return Build.VERSION.SDK_INT <= i11;
        }
        int i12 = Build.VERSION.SDK_INT;
        return i12 <= i11 || (i12 == i11 - 1 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }

    public static boolean isSystemOTA(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            ShareTinkerLog.d("Tinker.TinkerInternals", "fingerprint empty:" + str + ",current:" + str2, new Object[0]);
            return false;
        }
        if (str.equals(str2)) {
            ShareTinkerLog.d("Tinker.TinkerInternals", "same fingerprint:" + str2, new Object[0]);
            return false;
        }
        ShareTinkerLog.d("Tinker.TinkerInternals", "system OTA,fingerprint not equal:" + str + "," + str2, new Object[0]);
        return true;
    }

    public static boolean isTinkerEnableWithSharedPreferences(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("tinker_share_config", 4).getBoolean(getTinkerSwitchSPKey(context), true);
    }

    public static boolean isTinkerEnabled(int i11) {
        return i11 != 0;
    }

    public static boolean isTinkerEnabledAll(int i11) {
        return i11 == 15;
    }

    public static boolean isTinkerEnabledForArkHot(int i11) {
        return (i11 & 8) != 0;
    }

    public static boolean isTinkerEnabledForDex(int i11) {
        return (i11 & 1) != 0;
    }

    public static boolean isTinkerEnabledForNativeLib(int i11) {
        return (i11 & 2) != 0;
    }

    public static boolean isTinkerEnabledForResource(int i11) {
        return (i11 & 4) != 0;
    }

    public static boolean isVersionInRange(int i11, int i12, boolean z10) {
        return isNewerOrEqualThanVersion(i11, z10) && isOlderOrEqualThanVersion(i12, z10);
    }

    public static boolean isVmArt() {
        return true;
    }

    private static boolean isVmArt(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            return parseInt > 2 || (parseInt == 2 && Integer.parseInt(matcher.group(2)) >= 1);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isVmJit() {
        return VM_IS_JIT && Build.VERSION.SDK_INT < 24;
    }

    private static boolean isVmJitInternal() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            String str = (String) declaredMethod.invoke(null, "dalvik.vm.usejit");
            String str2 = (String) declaredMethod.invoke(null, "dalvik.vm.usejitprofiles");
            if (!isNullOrNil(str) && isNullOrNil(str2)) {
                if (str.equals("true")) {
                    return true;
                }
            }
        } catch (Throwable th2) {
            ShareTinkerLog.e("Tinker.TinkerInternals", "isVmJitInternal ex:" + th2, new Object[0]);
        }
        return false;
    }

    public static void killProcessExceptMain(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.uid == Process.myUid() && !runningAppProcessInfo.processName.equals(context.getPackageName())) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public static void setSafeModeCount(Context context, int i11) {
        String str = "safemode_count_rec_" + getProcessName(context);
        File file = new File(SharePatchFileUtil.getPatchDirectory(context), str);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream2.writeUTF("safe_mode_count_1.9.15.2");
                dataOutputStream2.writeInt(i11);
                ShareTinkerLog.i("Tinker.TinkerInternals", "setSafeModeCount: count: %s", Integer.valueOf(i11));
                SharePatchFileUtil.closeQuietly(dataOutputStream2);
            } catch (Throwable unused) {
                dataOutputStream = dataOutputStream2;
                try {
                    ShareTinkerLog.w("Tinker.TinkerInternals", "setSafeModeCount: recFileName:" + str + " failed, return 0 instead.", new Object[0]);
                } finally {
                    SharePatchFileUtil.closeQuietly(dataOutputStream);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void setTinkerDisableWithSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tinker_share_config", 4);
        sharedPreferences.edit().putBoolean(getTinkerSwitchSPKey(context), false).commit();
    }

    public static String toVisualString(String str) {
        char[] charArray;
        if (str == null || (charArray = str.toCharArray()) == null) {
            return null;
        }
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (charArray[i11] > 127) {
                charArray[i11] = 0;
                return new String(charArray, 0, i11);
            }
        }
        return str;
    }
}
