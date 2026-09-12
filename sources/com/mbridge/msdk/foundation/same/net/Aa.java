package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.i0;

/* loaded from: classes5.dex */
public class Aa {
    private static final String C_END = "_mv_end";
    private static final String C_START = "mv_channel_";

    /* renamed from: a, reason: collision with root package name */
    private static String f35477a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.killProcess(Process.myPid());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static String a() {
        return f35477a;
    }

    public static String b() {
        return null;
    }

    private static void b(String str) {
        String str2;
        Integer c11;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            str2 = i0.a(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith(C_START) && str2.endsWith(C_END) && (c11 = c(str2)) != null) {
            f35477a = String.valueOf(c11);
        } else {
            if (MBridgeConstans.DEBUG) {
                g();
                throw new RuntimeException("please don't update this value");
            }
            f35477a = "";
        }
    }

    private static Integer c(String str) {
        Throwable th2;
        Integer num;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(C_START);
        int indexOf2 = str.indexOf(C_END);
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
            return null;
        }
        try {
            num = Integer.valueOf(str.substring(indexOf + 11, indexOf2));
            try {
                if (num.intValue() > 0) {
                    return num;
                }
                return null;
            } catch (Throwable th3) {
                th2 = th3;
                th2.printStackTrace();
                return num;
            }
        } catch (Throwable th4) {
            th2 = th4;
            num = null;
        }
    }

    private static void g() {
        new Handler().postDelayed(new a(), 500L);
    }
}
