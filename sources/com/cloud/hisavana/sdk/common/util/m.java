package com.cloud.hisavana.sdk.common.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.cloud.hisavana.net.utils.StorageUtils;
import com.cloud.hisavana.sdk.e4;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* loaded from: classes3.dex */
public class m {
    public static void a(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                file2.delete();
            } else if (file2.isDirectory()) {
                a(file2);
            }
        }
        file.delete();
    }

    public static String b(Context context) {
        File e11 = StorageUtils.e(context);
        return (e11 == null || !e11.exists()) ? "" : e11.getAbsolutePath();
    }

    public static byte[] c(File file) {
        Path path;
        byte[] readAllBytes;
        if (file != null && file.exists()) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    path = Paths.get(file.getAbsolutePath(), new String[0]);
                    readAllBytes = Files.readAllBytes(path);
                    return readAllBytes;
                } catch (Exception e11) {
                    e4.b().w("ssp", "getDataFromFile failed, error=" + e11.getMessage());
                }
            } else {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[l.a(file.length())];
                        fileInputStream.read(bArr);
                        fileInputStream.close();
                        return bArr;
                    } finally {
                    }
                } catch (Exception e12) {
                    e4.b().w("ssp", "getDataFromFile failed, error=" + e12.getMessage());
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.util.m.d(java.lang.String):java.lang.String");
    }

    public static Uri e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            if (Build.VERSION.SDK_INT <= 24) {
                return Uri.fromFile(file);
            }
            return FileProvider.getUriForFile(com.cloud.sdk.commonutil.util.e.a(), com.cloud.sdk.commonutil.util.e.a().getApplicationContext().getPackageName() + ".HisavanaFileProvider", file);
        } catch (Exception e11) {
            e4.b().e("ssp", Log.getStackTraceString(e11));
            return null;
        }
    }

    public static String f(String str) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return "";
        }
        for (File file2 : listFiles) {
            if (file2 != null) {
                if (file2.isDirectory()) {
                    String f11 = f(file2.getAbsolutePath());
                    if (!TextUtils.isEmpty(f11)) {
                        return f11;
                    }
                } else if (file2.getName().equals(com.vungle.ads.internal.b.AD_INDEX_FILE_NAME)) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return "";
    }
}
