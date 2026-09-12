package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* loaded from: classes2.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f20179a = {"huawei"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f20180b = {"vivo"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f20181c = {"xiaomi"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f20182d = {"oppo"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f20183e = {"leeco", "letv"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f20184f = {"360", "qiku"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f20185g = {"zte"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f20186h = {"oneplus"};

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f20187i = {"nubia"};

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f20188j = {"coolpad", "yulong"};

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f20189k = {"lg", "lge"};

    /* renamed from: l, reason: collision with root package name */
    private static final String[] f20190l = {"google"};

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f20191m = {"samsung"};

    /* renamed from: n, reason: collision with root package name */
    private static final String[] f20192n = {"meizu"};

    /* renamed from: o, reason: collision with root package name */
    private static final String[] f20193o = {"lenovo"};

    /* renamed from: p, reason: collision with root package name */
    private static final String[] f20194p = {"smartisan", "deltainno"};

    /* renamed from: q, reason: collision with root package name */
    private static final String[] f20195q = {"htc"};

    /* renamed from: r, reason: collision with root package name */
    private static final String[] f20196r = {"sony"};

    /* renamed from: s, reason: collision with root package name */
    private static final String[] f20197s = {"gionee", "amigo"};

    /* renamed from: t, reason: collision with root package name */
    private static final String[] f20198t = {"motorola"};

    /* renamed from: u, reason: collision with root package name */
    private static a f20199u = null;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f20200a;

        /* renamed from: b, reason: collision with root package name */
        private String f20201b;

        public String toString() {
            return "RomInfo{name=" + this.f20200a + ", version=" + this.f20201b + "}";
        }
    }

    private static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : TmcConstants.ROUTE_UNKNOWN;
        } catch (Throwable unused) {
            return TmcConstants.ROUTE_UNKNOWN;
        }
    }

    private static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : TmcConstants.ROUTE_UNKNOWN;
        } catch (Throwable unused) {
            return TmcConstants.ROUTE_UNKNOWN;
        }
    }

    public static a c() {
        a aVar = f20199u;
        if (aVar != null) {
            return aVar;
        }
        f20199u = new a();
        String a11 = a();
        String b11 = b();
        String[] strArr = f20179a;
        if (i(a11, b11, strArr)) {
            f20199u.f20200a = strArr[0];
            String d11 = d("ro.build.version.emui");
            String[] split = d11.split("_");
            if (split.length > 1) {
                f20199u.f20201b = split[1];
            } else {
                f20199u.f20201b = d11;
            }
            return f20199u;
        }
        String[] strArr2 = f20180b;
        if (i(a11, b11, strArr2)) {
            f20199u.f20200a = strArr2[0];
            f20199u.f20201b = d("ro.vivo.os.build.display.id");
            return f20199u;
        }
        String[] strArr3 = f20181c;
        if (i(a11, b11, strArr3)) {
            f20199u.f20200a = strArr3[0];
            f20199u.f20201b = d("ro.build.version.incremental");
            return f20199u;
        }
        String[] strArr4 = f20182d;
        if (i(a11, b11, strArr4)) {
            f20199u.f20200a = strArr4[0];
            f20199u.f20201b = d("ro.build.version.opporom");
            return f20199u;
        }
        String[] strArr5 = f20183e;
        if (i(a11, b11, strArr5)) {
            f20199u.f20200a = strArr5[0];
            f20199u.f20201b = d("ro.letv.release.version");
            return f20199u;
        }
        String[] strArr6 = f20184f;
        if (i(a11, b11, strArr6)) {
            f20199u.f20200a = strArr6[0];
            f20199u.f20201b = d("ro.build.uiversion");
            return f20199u;
        }
        String[] strArr7 = f20185g;
        if (i(a11, b11, strArr7)) {
            f20199u.f20200a = strArr7[0];
            f20199u.f20201b = d("ro.build.MiFavor_version");
            return f20199u;
        }
        String[] strArr8 = f20186h;
        if (i(a11, b11, strArr8)) {
            f20199u.f20200a = strArr8[0];
            f20199u.f20201b = d("ro.rom.version");
            return f20199u;
        }
        String[] strArr9 = f20187i;
        if (i(a11, b11, strArr9)) {
            f20199u.f20200a = strArr9[0];
            f20199u.f20201b = d("ro.build.rom.id");
            return f20199u;
        }
        String[] strArr10 = f20188j;
        if (i(a11, b11, strArr10)) {
            f20199u.f20200a = strArr10[0];
        } else {
            String[] strArr11 = f20189k;
            if (i(a11, b11, strArr11)) {
                f20199u.f20200a = strArr11[0];
            } else {
                String[] strArr12 = f20190l;
                if (i(a11, b11, strArr12)) {
                    f20199u.f20200a = strArr12[0];
                } else {
                    String[] strArr13 = f20191m;
                    if (i(a11, b11, strArr13)) {
                        f20199u.f20200a = strArr13[0];
                    } else {
                        String[] strArr14 = f20192n;
                        if (i(a11, b11, strArr14)) {
                            f20199u.f20200a = strArr14[0];
                        } else {
                            String[] strArr15 = f20193o;
                            if (i(a11, b11, strArr15)) {
                                f20199u.f20200a = strArr15[0];
                            } else {
                                String[] strArr16 = f20194p;
                                if (i(a11, b11, strArr16)) {
                                    f20199u.f20200a = strArr16[0];
                                } else {
                                    String[] strArr17 = f20195q;
                                    if (i(a11, b11, strArr17)) {
                                        f20199u.f20200a = strArr17[0];
                                    } else {
                                        String[] strArr18 = f20196r;
                                        if (i(a11, b11, strArr18)) {
                                            f20199u.f20200a = strArr18[0];
                                        } else {
                                            String[] strArr19 = f20197s;
                                            if (i(a11, b11, strArr19)) {
                                                f20199u.f20200a = strArr19[0];
                                            } else {
                                                String[] strArr20 = f20198t;
                                                if (i(a11, b11, strArr20)) {
                                                    f20199u.f20200a = strArr20[0];
                                                } else {
                                                    f20199u.f20200a = b11;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        f20199u.f20201b = d("");
        return f20199u;
    }

    private static String d(String str) {
        String e11 = !TextUtils.isEmpty(str) ? e(str) : "";
        if (TextUtils.isEmpty(e11) || e11.equals(TmcConstants.ROUTE_UNKNOWN)) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    e11 = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(e11) ? TmcConstants.ROUTE_UNKNOWN : e11;
    }

    private static String e(String str) {
        String g11 = g(str);
        if (!TextUtils.isEmpty(g11)) {
            return g11;
        }
        String h11 = h(str);
        return (TextUtils.isEmpty(h11) && Build.VERSION.SDK_INT < 28) ? f(str) : h11;
    }

    private static String f(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String g(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException unused) {
                return "";
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            readLine = bufferedReader.readLine();
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                return "";
            }
            bufferedReader2.close();
            return "";
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        if (readLine != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return readLine;
        }
        bufferedReader.close();
        return "";
    }

    private static String h(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean i(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j() {
        return f20191m[0].equals(c().f20200a);
    }
}
