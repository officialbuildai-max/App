package com.cloud.tmc.miniutils.util;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.tmc.miniutils.constant.RegexConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.model.AdPayload;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public final class FileUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    /* loaded from: classes3.dex */
    public interface OnReplaceListener {
        boolean onReplace(File file, File file2);
    }

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @SuppressLint({"DefaultLocale"})
    public static String byte2FitMemorySize(long j11) {
        return byte2FitMemorySize(j11, 3);
    }

    @SuppressLint({"DefaultLocale"})
    public static String byte2FitMemorySize(long j11, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("precision shouldn't be less than zero!");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        }
        if (j11 < 1024) {
            return String.format("%." + i11 + "fB", Double.valueOf(j11));
        }
        if (j11 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return String.format("%." + i11 + "fKB", Double.valueOf(j11 / 1024.0d));
        }
        if (j11 < 1073741824) {
            return String.format("%." + i11 + "fMB", Double.valueOf(j11 / 1048576.0d));
        }
        return String.format("%." + i11 + "fGB", Double.valueOf(j11 / 1.073741824E9d));
    }

    public static boolean copy(File file, File file2) {
        return copy(file, file2, (OnReplaceListener) null);
    }

    public static boolean copy(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? copyDir(file, file2, onReplaceListener) : copyFile(file, file2, onReplaceListener);
    }

    public static boolean copy(String str, String str2) {
        return copy(getFileByPath(str), getFileByPath(str2), (OnReplaceListener) null);
    }

    public static boolean copy(String str, String str2, OnReplaceListener onReplaceListener) {
        return copy(getFileByPath(str), getFileByPath(str2), onReplaceListener);
    }

    private static boolean copyDir(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveDir(file, file2, onReplaceListener, false);
    }

    private static boolean copyFile(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveFile(file, file2, onReplaceListener, false);
    }

    private static boolean copyOrMoveDir(File file, File file2, OnReplaceListener onReplaceListener, boolean z10) {
        if (file == null || file2 == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getPath());
        String str = File.separator;
        sb2.append(str);
        String sb3 = sb2.toString();
        String str2 = file2.getPath() + str;
        if (str2.contains(sb3) || !file.exists() || !file.isDirectory() || !createOrExistsDir(file2)) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file3 : listFiles) {
                File file4 = new File(str2 + file3.getName());
                if (file3.isFile()) {
                    if (!copyOrMoveFile(file3, file4, onReplaceListener, z10)) {
                        return false;
                    }
                } else if (file3.isDirectory() && !copyOrMoveDir(file3, file4, onReplaceListener, z10)) {
                    return false;
                }
            }
        }
        return !z10 || deleteDir(file);
    }

    private static boolean copyOrMoveFile(File file, File file2, OnReplaceListener onReplaceListener, boolean z10) {
        if (file != null && file2 != null && !file.equals(file2) && file.exists() && file.isFile()) {
            if (file2.exists()) {
                if (onReplaceListener != null && !onReplaceListener.onReplace(file, file2)) {
                    return true;
                }
                if (!file2.delete()) {
                    return false;
                }
            }
            if (!createOrExistsDir(file2.getParentFile())) {
                return false;
            }
            try {
                if (!UtilsBridge.writeFileFromIS(file2.getAbsolutePath(), new FileInputStream(file))) {
                    return false;
                }
                if (z10) {
                    if (!deleteFile(file)) {
                        return false;
                    }
                }
                return true;
            } catch (FileNotFoundException e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean createFileByDeleteOldFile(String str) {
        return createFileByDeleteOldFile(getFileByPath(str));
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? deleteDir(file) : deleteFile(file);
    }

    public static boolean delete(String str) {
        return delete(getFileByPath(str));
    }

    public static boolean deleteAllInDir(File file) {
        return deleteFilesInDirWithFilter(file, new FileFilter() { // from class: com.cloud.tmc.miniutils.util.FileUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return true;
            }
        });
    }

    public static boolean deleteAllInDir(String str) {
        return deleteAllInDir(getFileByPath(str));
    }

    private static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean deleteFilesInDir(File file) {
        return deleteFilesInDirWithFilter(file, new FileFilter() { // from class: com.cloud.tmc.miniutils.util.FileUtils.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isFile();
            }
        });
    }

    public static boolean deleteFilesInDir(String str) {
        return deleteFilesInDir(getFileByPath(str));
    }

    public static boolean deleteFilesInDirWithFilter(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !deleteDir(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean deleteFilesInDirWithFilter(String str, FileFilter fileFilter) {
        return deleteFilesInDirWithFilter(getFileByPath(str), fileFilter);
    }

    private static long getDirLength(File file) {
        long j11 = 0;
        if (!isDir(file)) {
            return 0L;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                j11 += file2.isDirectory() ? getDirLength(file2) : file2.length();
            }
        }
        return j11;
    }

    public static String getDirName(File file) {
        return file == null ? "" : getDirName(file.getAbsolutePath());
    }

    public static String getDirName(String str) {
        int lastIndexOf;
        return (UtilsBridge.isSpace(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? "" : str.substring(0, lastIndexOf + 1);
    }

    private static String getDirSize(File file) {
        long dirLength = getDirLength(file);
        return dirLength == -1 ? "" : UtilsBridge.byte2FitMemorySize(dirLength);
    }

    public static File getFileByPath(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getFileCharsetSimple(java.io.File r3) {
        /*
            if (r3 != 0) goto L5
            java.lang.String r3 = ""
            return r3
        L5:
            boolean r0 = isUtf8(r3)
            if (r0 == 0) goto Le
            java.lang.String r3 = "UTF-8"
            return r3
        Le:
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35
            int r3 = r1.read()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
            int r3 = r3 << 8
            int r0 = r1.read()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
            int r3 = r3 + r0
            r1.close()     // Catch: java.io.IOException -> L28
            goto L44
        L28:
            r0 = move-exception
            r0.printStackTrace()
            goto L44
        L2d:
            r3 = move-exception
            r0 = r1
            goto L57
        L30:
            r3 = move-exception
            r0 = r1
            goto L36
        L33:
            r3 = move-exception
            goto L57
        L35:
            r3 = move-exception
        L36:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L43
            r0.close()     // Catch: java.io.IOException -> L3f
            goto L43
        L3f:
            r3 = move-exception
            r3.printStackTrace()
        L43:
            r3 = 0
        L44:
            r0 = 65279(0xfeff, float:9.1475E-41)
            if (r3 == r0) goto L54
            r0 = 65534(0xfffe, float:9.1833E-41)
            if (r3 == r0) goto L51
            java.lang.String r3 = "GBK"
            return r3
        L51:
            java.lang.String r3 = "Unicode"
            return r3
        L54:
            java.lang.String r3 = "UTF-16BE"
            return r3
        L57:
            if (r0 == 0) goto L61
            r0.close()     // Catch: java.io.IOException -> L5d
            goto L61
        L5d:
            r0 = move-exception
            r0.printStackTrace()
        L61:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniutils.util.FileUtils.getFileCharsetSimple(java.io.File):java.lang.String");
    }

    public static String getFileCharsetSimple(String str) {
        return getFileCharsetSimple(getFileByPath(str));
    }

    public static String getFileExtension(File file) {
        return file == null ? "" : getFileExtension(file.getPath());
    }

    public static String getFileExtension(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || str.lastIndexOf(File.separator) >= lastIndexOf) ? "" : str.substring(lastIndexOf + 1);
    }

    public static long getFileLastModified(File file) {
        if (file == null) {
            return -1L;
        }
        return file.lastModified();
    }

    public static long getFileLastModified(String str) {
        return getFileLastModified(getFileByPath(str));
    }

    private static long getFileLength(File file) {
        if (isFile(file)) {
            return file.length();
        }
        return -1L;
    }

    public static long getFileLength(String str) {
        if (str.matches(RegexConstants.REGEX_URL)) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
                httpsURLConnection.setRequestProperty("Accept-Encoding", "identity");
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    return httpsURLConnection.getContentLength();
                }
                return -1L;
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return getFileLength(getFileByPath(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r3 == (-1)) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r6 >= r3) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r1[r6] != 10) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        r2.close();
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0036, code lost:
    
        r3 = r2.read(r1, 0, 1024);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003a, code lost:
    
        if (r3 == (-1)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003c, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003d, code lost:
    
        if (r6 >= r3) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0043, code lost:
    
        if (r1[r6] != 13) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0045, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0047, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (com.cloud.tmc.miniutils.util.FileUtils.LINE_SEP.endsWith("\n") != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        r3 = r2.read(r1, 0, 1024);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x004f -> B:18:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getFileLines(java.io.File r9) {
        /*
            r0 = 1
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r9]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            java.lang.String r3 = com.cloud.tmc.miniutils.util.FileUtils.LINE_SEP     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            java.lang.String r4 = "\n"
            boolean r3 = r3.endsWith(r4)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            r4 = -1
            r5 = 0
            if (r3 == 0) goto L36
        L1c:
            int r3 = r2.read(r1, r5, r9)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            if (r3 == r4) goto L4a
            r6 = r5
        L23:
            if (r6 >= r3) goto L1c
            r7 = r1[r6]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            r8 = 10
            if (r7 != r8) goto L2d
            int r0 = r0 + 1
        L2d:
            int r6 = r6 + 1
            goto L23
        L30:
            r9 = move-exception
            r1 = r2
            goto L5f
        L33:
            r9 = move-exception
            r1 = r2
            goto L56
        L36:
            int r3 = r2.read(r1, r5, r9)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            if (r3 == r4) goto L4a
            r6 = r5
        L3d:
            if (r6 >= r3) goto L36
            r7 = r1[r6]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            r8 = 13
            if (r7 != r8) goto L47
            int r0 = r0 + 1
        L47:
            int r6 = r6 + 1
            goto L3d
        L4a:
            r2.close()     // Catch: java.io.IOException -> L4e
            goto L5e
        L4e:
            r9 = move-exception
            r9.printStackTrace()
            goto L5e
        L53:
            r9 = move-exception
            goto L5f
        L55:
            r9 = move-exception
        L56:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.io.IOException -> L4e
        L5e:
            return r0
        L5f:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.io.IOException -> L65
            goto L69
        L65:
            r0 = move-exception
            r0.printStackTrace()
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniutils.util.FileUtils.getFileLines(java.io.File):int");
    }

    public static int getFileLines(String str) {
        return getFileLines(getFileByPath(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] getFileMD5(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L6
            byte[] r4 = new byte[r0]
            return r4
        L6:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49 java.security.NoSuchAlgorithmException -> L4b
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49 java.security.NoSuchAlgorithmException -> L4b
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch: java.lang.Throwable -> L3d
            java.security.DigestInputStream r3 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L3d
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L3d
            r2.close()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38 java.security.NoSuchAlgorithmException -> L3b
            r4 = 262144(0x40000, float:3.67342E-40)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38 java.security.NoSuchAlgorithmException -> L3b
        L1e:
            int r1 = r3.read(r4)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38 java.security.NoSuchAlgorithmException -> L3b
            if (r1 > 0) goto L1e
            java.security.MessageDigest r4 = r3.getMessageDigest()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38 java.security.NoSuchAlgorithmException -> L3b
            byte[] r4 = r4.digest()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38 java.security.NoSuchAlgorithmException -> L3b
            r3.close()     // Catch: java.io.IOException -> L30
            goto L34
        L30:
            r0 = move-exception
            r0.printStackTrace()
        L34:
            return r4
        L35:
            r4 = move-exception
            r1 = r3
            goto L5c
        L38:
            r4 = move-exception
        L39:
            r1 = r3
            goto L4c
        L3b:
            r4 = move-exception
            goto L39
        L3d:
            r4 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> L42
            goto L46
        L42:
            r2 = move-exception
            r4.addSuppressed(r2)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49 java.security.NoSuchAlgorithmException -> L4b
        L46:
            throw r4     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49 java.security.NoSuchAlgorithmException -> L4b
        L47:
            r4 = move-exception
            goto L5c
        L49:
            r4 = move-exception
            goto L4c
        L4b:
            r4 = move-exception
        L4c:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r4 = move-exception
            r4.printStackTrace()
        L59:
            byte[] r4 = new byte[r0]
            return r4
        L5c:
            if (r1 == 0) goto L66
            r1.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r0 = move-exception
            r0.printStackTrace()
        L66:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniutils.util.FileUtils.getFileMD5(java.io.File):byte[]");
    }

    @NonNull
    public static byte[] getFileMD5(String str) {
        return getFileMD5(getFileByPath(str));
    }

    public static String getFileMD5ToString(File file) {
        return UtilsBridge.bytes2HexString(getFileMD5(file));
    }

    public static String getFileMD5ToString(String str) {
        return getFileMD5ToString(UtilsBridge.isSpace(str) ? null : new File(str));
    }

    public static String getFileName(File file) {
        return file == null ? "" : getFileName(file.getAbsolutePath());
    }

    public static String getFileName(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public static String getFileNameNoExtension(File file) {
        return file == null ? "" : getFileNameNoExtension(file.getPath());
    }

    public static String getFileNameNoExtension(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        return lastIndexOf2 == -1 ? lastIndexOf == -1 ? str : str.substring(0, lastIndexOf) : (lastIndexOf == -1 || lastIndexOf2 > lastIndexOf) ? str.substring(lastIndexOf2 + 1) : str.substring(lastIndexOf2 + 1, lastIndexOf);
    }

    private static String getFileSize(File file) {
        long fileLength = getFileLength(file);
        return fileLength == -1 ? "" : UtilsBridge.byte2FitMemorySize(fileLength);
    }

    public static long getFsAvailableSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static long getFsTotalSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static long getLength(File file) {
        if (file == null) {
            return 0L;
        }
        return file.isDirectory() ? getDirLength(file) : getFileLength(file);
    }

    public static long getLength(String str) {
        return getLength(getFileByPath(str));
    }

    public static String getSize(File file) {
        return file == null ? "" : file.isDirectory() ? getDirSize(file) : getFileSize(file);
    }

    public static String getSize(String str) {
        return getSize(getFileByPath(str));
    }

    public static boolean isDir(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFileExists(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return isFileExists(file.getAbsolutePath());
    }

    public static boolean isFileExists(String str) {
        File fileByPath = getFileByPath(str);
        if (fileByPath == null) {
            return false;
        }
        if (fileByPath.exists()) {
            return true;
        }
        return isFileExistsApi29(str);
    }

    private static boolean isFileExistsApi29(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = Utils.getApp().getContentResolver().openAssetFileDescriptor(Uri.parse(str), CampaignEx.JSON_KEY_AD_R);
                if (openAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    openAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    private static int isUtf8(byte[] bArr) {
        if (bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return 100;
        }
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 < length) {
            byte b11 = bArr[i11];
            if (b11 == -1 || (b11 & (-2)) == -2) {
                return 0;
            }
            if (i14 == 0) {
                if ((b11 & Byte.MAX_VALUE) == b11 && b11 != 0) {
                    i12++;
                } else if ((b11 & (-64)) == -64) {
                    int i15 = i14;
                    for (int i16 = 0; i16 < 8; i16++) {
                        byte b12 = (byte) (128 >> i16);
                        if ((bArr[i11] & b12) != b12) {
                            break;
                        }
                        i15 = i16;
                    }
                    i13++;
                    i14 = i15;
                }
                i11++;
            } else {
                if (bArr.length - i11 <= i14) {
                    i14 = bArr.length - i11;
                }
                boolean z10 = false;
                for (int i17 = 0; i17 < i14; i17++) {
                    byte b13 = bArr[i11 + i17];
                    if ((b13 & Byte.MIN_VALUE) != -128) {
                        if ((b13 & Byte.MAX_VALUE) == b13 && bArr[i11] != 0) {
                            i12++;
                        }
                        z10 = true;
                    }
                }
                if (z10) {
                    i13--;
                    i11++;
                } else {
                    i13 += i14;
                    i11 += i14;
                }
                i14 = 0;
            }
        }
        if (i12 == length) {
            return 100;
        }
        return (int) (((i13 + i12) / length) * 100.0f);
    }

    public static boolean isUtf8(File file) {
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        if (file == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bArr = new byte[24];
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e11) {
            e = e11;
        }
        try {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                return false;
            }
            byte[] bArr2 = new byte[read];
            System.arraycopy(bArr, 0, bArr2, 0, read);
            boolean z10 = isUtf8(bArr2) == 100;
            try {
                bufferedInputStream.close();
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            return z10;
        } catch (IOException e14) {
            e = e14;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isUtf8(String str) {
        return isUtf8(getFileByPath(str));
    }

    public static List<File> listFilesInDir(File file) {
        return listFilesInDir(file, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(File file, Comparator<File> comparator) {
        return listFilesInDir(file, false, comparator);
    }

    public static List<File> listFilesInDir(File file, boolean z10) {
        return listFilesInDir(file, z10, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(File file, boolean z10, Comparator<File> comparator) {
        return listFilesInDirWithFilter(file, new FileFilter() { // from class: com.cloud.tmc.miniutils.util.FileUtils.3
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return true;
            }
        }, z10, comparator);
    }

    public static List<File> listFilesInDir(String str) {
        return listFilesInDir(str, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(String str, Comparator<File> comparator) {
        return listFilesInDir(getFileByPath(str), false, comparator);
    }

    public static List<File> listFilesInDir(String str, boolean z10) {
        return listFilesInDir(getFileByPath(str), z10);
    }

    public static List<File> listFilesInDir(String str, boolean z10, Comparator<File> comparator) {
        return listFilesInDir(getFileByPath(str), z10, comparator);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter) {
        return listFilesInDirWithFilter(file, fileFilter, false, (Comparator<File>) null);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, Comparator<File> comparator) {
        return listFilesInDirWithFilter(file, fileFilter, false, comparator);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, boolean z10) {
        return listFilesInDirWithFilter(file, fileFilter, z10, (Comparator<File>) null);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, boolean z10, Comparator<File> comparator) {
        List<File> listFilesInDirWithFilterInner = listFilesInDirWithFilterInner(file, fileFilter, z10);
        if (comparator != null) {
            Collections.sort(listFilesInDirWithFilterInner, comparator);
        }
        return listFilesInDirWithFilterInner;
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, Comparator<File> comparator) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, comparator);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, boolean z10) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, z10);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, boolean z10, Comparator<File> comparator) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, z10, comparator);
    }

    private static List<File> listFilesInDirWithFilterInner(File file, FileFilter fileFilter, boolean z10) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (isDir(file) && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z10 && file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilterInner(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }

    public static boolean move(File file, File file2) {
        return move(file, file2, (OnReplaceListener) null);
    }

    public static boolean move(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? moveDir(file, file2, onReplaceListener) : moveFile(file, file2, onReplaceListener);
    }

    public static boolean move(String str, String str2) {
        return move(getFileByPath(str), getFileByPath(str2), (OnReplaceListener) null);
    }

    public static boolean move(String str, String str2, OnReplaceListener onReplaceListener) {
        return move(getFileByPath(str), getFileByPath(str2), onReplaceListener);
    }

    public static boolean moveDir(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveDir(file, file2, onReplaceListener, true);
    }

    public static boolean moveFile(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveFile(file, file2, onReplaceListener, true);
    }

    public static void notifySystemToScan(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.parse(AdPayload.FILE_SCHEME + file.getAbsolutePath()));
        Utils.getApp().sendBroadcast(intent);
    }

    public static void notifySystemToScan(String str) {
        notifySystemToScan(getFileByPath(str));
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || UtilsBridge.isSpace(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }
}
