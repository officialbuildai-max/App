package com.apm.insight.l;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f19742a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f19743b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f19744c = Pattern.compile("^0-([\\d]+)$");

    public static String a() {
        return b("ro.build.version.emui");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = b("ro.build.version.emui");
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return e();
        }
        return true;
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            bufferedReader.close();
            com.apm.insight.a.a((Closeable) bufferedReader);
            return str2;
        } catch (Throwable unused2) {
            com.apm.insight.a.a((Closeable) bufferedReader);
            return str2;
        }
    }

    public static boolean b() {
        if (!f19742a) {
            try {
                Class.forName("miui.os.Build");
                com.apm.insight.k.e.f19696a = true;
                f19742a = true;
                return true;
            } catch (Exception unused) {
                f19742a = true;
            }
        }
        return com.apm.insight.k.e.f19696a;
    }

    private static int c(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                int d11 = d(readLine);
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                return d11;
            }
        } catch (Throwable unused3) {
            if (bufferedReader == null) {
                return -1;
            }
            bufferedReader.close();
        }
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
            return -1;
        }
    }

    public static boolean c() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static int d() {
        int i11 = f19743b;
        if (i11 > 0) {
            return i11;
        }
        int c11 = c("/sys/devices/system/cpu/possible");
        if (c11 <= 0) {
            c11 = c("/sys/devices/system/cpu/present");
        }
        if (c11 <= 0) {
            c11 = e("/sys/devices/system/cpu/");
        }
        if (c11 <= 0) {
            c11 = Runtime.getRuntime().availableProcessors();
        }
        if (c11 <= 0) {
            c11 = 1;
        }
        f19743b = c11;
        return c11;
    }

    private static int d(String str) {
        Matcher matcher = f19744c.matcher(str);
        if (matcher.matches()) {
            try {
                return Integer.parseInt(matcher.group(1)) + 1;
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    private static int e(String str) {
        try {
            File[] listFiles = new File(str).listFiles(new FilenameFilter() { // from class: com.apm.insight.l.d.1

                /* renamed from: a, reason: collision with root package name */
                private final Pattern f19745a = Pattern.compile("^cpu[\\d]+$");

                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str2) {
                    return this.f19745a.matcher(str2).matches();
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                return -1;
            }
            return listFiles.length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static boolean e() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
