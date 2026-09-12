package com.transsion.startup;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.List;

/* loaded from: classes6.dex */
public class f {
    private static void a(File file, boolean z10) {
        if (z10) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static String b(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static void c(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            String str = "";
            String b11 = b(context);
            if (!TextUtils.equals(context.getPackageName(), b11)) {
                if (TextUtils.isEmpty(b11)) {
                    b11 = context.getPackageName();
                }
                WebView.setDataDirectorySuffix(b11);
                str = "_" + b11;
            }
            d(context, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private static void d(Context context, String str) {
        File dataDir;
        StringBuilder sb2 = new StringBuilder();
        dataDir = context.getDataDir();
        sb2.append(dataDir.getAbsolutePath());
        sb2.append("/app_webview");
        sb2.append(str);
        sb2.append("/webview_data.lock");
        File file = new File(sb2.toString());
        if (file.exists()) {
            try {
                FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
                if (tryLock != null) {
                    tryLock.close();
                } else {
                    a(file, file.delete());
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                a(file, file.exists() ? file.delete() : false);
            }
        }
    }
}
