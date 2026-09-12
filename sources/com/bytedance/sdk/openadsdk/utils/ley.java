package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class ley {
    private static volatile boolean EjP = true;
    private static String Sj;
    private static String TKC;
    private static String sP;

    /* loaded from: classes3.dex */
    public static class Sj extends com.bytedance.sdk.component.Dq.Dq {
        public static AtomicBoolean Sj = new AtomicBoolean(false);
        private static final AtomicLong sP = new AtomicLong(0);

        public Sj(String str, int i11) {
            super(str, i11);
        }

        public static void Sj() {
            if (Sj.get()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = sP;
            if (currentTimeMillis - atomicLong.get() < 600000) {
                return;
            }
            atomicLong.set(currentTimeMillis);
            JcM.sP((com.bytedance.sdk.component.Dq.Dq) new Sj("UpdateSimStatusTask", 5));
        }

        @Override // java.lang.Runnable
        public void run() {
            Sj.set(true);
            ley.HiB();
            Sj.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void HiB() {
        String str;
        String str2;
        String str3;
        if (com.bytedance.sdk.openadsdk.core.dNu.Sj() == null) {
            return;
        }
        EjP = true;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.dNu.Sj().getSystemService("phone");
            try {
                int simState = telephonyManager.getSimState();
                if (simState == 0) {
                    EjP = false;
                } else if (simState == 1) {
                    EjP = false;
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.sP("SimUtils", th2.getMessage());
            }
            String str4 = null;
            try {
                str = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                str = null;
            }
            try {
                str2 = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                str2 = null;
            }
            if (str2 == null || str2.length() < 5) {
                try {
                    str2 = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                str3 = null;
            } else {
                String substring = str2.substring(0, 3);
                str3 = str2.substring(3);
                str4 = substring;
            }
            if (!TextUtils.isEmpty(str)) {
                Sj = str;
            }
            if (!TextUtils.isEmpty(str4)) {
                sP = str4;
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            TKC = str3;
        } catch (Throwable unused4) {
        }
    }

    public static String Sj() {
        Sj.Sj();
        return Sj;
    }

    public static String TKC() {
        Sj.Sj();
        return TKC;
    }

    public static String sP() {
        try {
            Sj.Sj();
            if (!EjP) {
                StringBuilder sb2 = new StringBuilder("getMCC");
                sb2.append(EjP ? "Have SIM card" : "No SIM card, MCC returns null");
                com.bytedance.sdk.component.utils.sU.sP("MCC", sb2.toString());
                return null;
            }
            Configuration configuration = com.bytedance.sdk.openadsdk.core.dNu.Sj().getResources().getConfiguration();
            int i11 = configuration.mcc;
            String valueOf = i11 != 0 ? String.valueOf(i11) : sP;
            com.bytedance.sdk.component.utils.sU.sP("MCC", "config=" + configuration.mcc + ",sMCC=" + sP);
            return valueOf;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("SimUtils", th2.getMessage());
            return null;
        }
    }
}
