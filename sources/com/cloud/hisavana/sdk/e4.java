package com.cloud.hisavana.sdk;

import android.util.Log;

/* loaded from: classes3.dex */
public class e4 extends com.cloud.sdk.commonutil.util.c {

    /* renamed from: a, reason: collision with root package name */
    private static e4 f22513a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f22514b = Log.isLoggable("ADSDK", 3);

    public static synchronized e4 b() {
        e4 e4Var;
        synchronized (e4.class) {
            try {
                if (f22513a == null) {
                    synchronized (e4.class) {
                        try {
                            if (f22513a == null) {
                                f22513a = new e4();
                            }
                        } finally {
                        }
                    }
                }
                e4Var = f22513a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return e4Var;
    }

    public static boolean c() {
        return f22514b;
    }

    @Override // com.cloud.sdk.commonutil.util.c
    public String getGlobalTag() {
        return "ADSDK_S";
    }
}
