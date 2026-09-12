package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class uP {
    private static String HiB = null;
    public static boolean Sj = false;
    public static boolean sP = false;
    private static int vS = Integer.MAX_VALUE;
    private static final CharSequence TKC = "amigo";
    private static final CharSequence EjP = "funtouch";
    private static final ConcurrentHashMap<String, String> Jcg = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public static class Sj implements Callable<String> {
        private final String Sj;

        public Sj(String str) {
            this.Sj = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            String str = (String) uP.Jcg.get(this.Sj);
            if (str != null) {
                return str;
            }
            System.currentTimeMillis();
            String TKC = uP.TKC(this.Sj);
            System.currentTimeMillis();
            if (TKC != null) {
                uP.Jcg.put(this.Sj, TKC);
            }
            return TKC;
        }
    }

    public static boolean Dq() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(TKC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String EjP(java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r1 = com.bytedance.sdk.openadsdk.utils.uP.Jcg
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto Ld
            return r1
        Ld:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L34
            com.bytedance.sdk.openadsdk.utils.uP$Sj r1 = new com.bytedance.sdk.openadsdk.utils.uP$Sj     // Catch: java.lang.Throwable -> L34
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L34
            com.bytedance.sdk.component.Dq.Jcg r4 = new com.bytedance.sdk.component.Dq.Jcg     // Catch: java.lang.Throwable -> L34
            r2 = 5
            r3 = 2
            r4.<init>(r1, r2, r3)     // Catch: java.lang.Throwable -> L34
            com.bytedance.sdk.openadsdk.utils.uP$1 r1 = new com.bytedance.sdk.openadsdk.utils.uP$1     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "_getSystemPropertyTask"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L34
            com.bytedance.sdk.openadsdk.utils.JcM.sP(r1)     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L34
            r2 = 1
            java.lang.Object r4 = r4.get(r2, r1)     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L34
            goto L35
        L34:
            r4 = r0
        L35:
            if (r4 != 0) goto L38
            goto L39
        L38:
            r0 = r4
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.uP.EjP(java.lang.String):java.lang.String");
    }

    public static boolean EjP() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String Fmk() {
        String sef = sef();
        if (sef == null || !sef.toLowerCase().contains("emotionui")) {
            return "";
        }
        return sef + "_" + Build.DISPLAY;
    }

    public static boolean HiB() {
        if (!sP) {
            try {
                Class.forName("miui.os.Build");
                Sj = true;
                sP = true;
                return true;
            } catch (Exception unused) {
                sP = true;
            }
        }
        return Sj;
    }

    public static boolean Jcg() {
        String EjP2 = EjP("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(EjP2) && EjP2.toLowerCase().contains(EjP);
    }

    public static String RiZ() {
        if (!TzV()) {
            return "";
        }
        return "coloros_" + EjP(Mts.Jcg("ro.build.version.kllkrom")) + "_" + Build.DISPLAY;
    }

    public static String Sj() {
        if (!TextUtils.isEmpty(HiB)) {
            return HiB;
        }
        String Sj2 = com.bytedance.sdk.openadsdk.core.uA.Sj("sdk_local_rom_info", 604800000L);
        HiB = Sj2;
        if (TextUtils.isEmpty(Sj2)) {
            String zR = zR();
            HiB = zR;
            com.bytedance.sdk.openadsdk.core.uA.Sj("sdk_local_rom_info", zR);
        }
        return HiB;
    }

    public static boolean Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            str = sef();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || sU();
    }

    public static String TEQ() {
        if (!Ym()) {
            return "";
        }
        return "eui_" + EjP("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String TKC() {
        return EjP("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String TKC(String str) {
        BufferedReader bufferedReader;
        Throwable th2;
        Process exec;
        String str2 = "";
        Process process = null;
        try {
            try {
                try {
                    exec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                    } catch (IllegalThreadStateException unused) {
                        bufferedReader = null;
                    }
                } catch (IOException e11) {
                    com.bytedance.sdk.component.utils.sU.Sj("ToolUtils", "Exception while closing InputStream", e11);
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th2 = th3;
            }
        } catch (IllegalThreadStateException unused2) {
            bufferedReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            exec.exitValue();
            bufferedReader.close();
        } catch (IllegalThreadStateException unused3) {
            process = exec;
            try {
                process.destroy();
            } catch (Throwable unused4) {
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str2;
        } catch (Throwable th4) {
            th2 = th4;
            try {
                com.bytedance.sdk.component.utils.sU.Sj("ToolUtils", "Unable to read sysprop ".concat(String.valueOf(str)), th2);
                return str2;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        com.bytedance.sdk.component.utils.sU.Sj("ToolUtils", "Exception while closing InputStream", e12);
                    }
                }
            }
        }
        return str2;
    }

    public static boolean TzV() {
        if (vS == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String Jcg2 = Mts.Jcg("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(Jcg2)) {
                vS = 0;
            } else {
                vS = 1;
            }
        }
        return vS == 1;
    }

    public static boolean Ym() {
        return !TextUtils.isEmpty(EjP("ro.letv.release.version"));
    }

    public static boolean Zq() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String aa() {
        if (!HiB()) {
            return "";
        }
        return "miui_" + EjP("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String dNu() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean sP() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean sU() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String sef() {
        return EjP("ro.build.version.emui");
    }

    public static String uA() {
        return Build.DISPLAY + "_" + EjP("ro.gn.sv.version");
    }

    public static String uvD() {
        if (Zq()) {
            try {
                return "smartisan_".concat(String.valueOf(EjP("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String vS() {
        return EjP("ro.vivo.os.build.display.id") + "_" + EjP("ro.vivo.product.version");
    }

    private static String zR() {
        if (Zq()) {
            return uvD();
        }
        if (HiB()) {
            return aa();
        }
        if (sP()) {
            return dNu();
        }
        if (TzV()) {
            return RiZ();
        }
        String Fmk = Fmk();
        if (!TextUtils.isEmpty(Fmk)) {
            return Fmk;
        }
        if (Jcg()) {
            return vS();
        }
        if (Dq()) {
            return uA();
        }
        if (EjP()) {
            return TKC();
        }
        String TEQ = TEQ();
        return !TextUtils.isEmpty(TEQ) ? TEQ : Build.DISPLAY;
    }
}
