package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
public abstract class s {

    /* renamed from: b, reason: collision with root package name */
    private static int f27708b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f27709c = true;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f27707a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static a f27710d = a.f27711a;

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f27711a = new C0384a();

        /* renamed from: com.google.android.exoplayer2.util.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0384a implements a {
            C0384a() {
            }

            @Override // com.google.android.exoplayer2.util.s.a
            public void d(String str, String str2) {
            }

            @Override // com.google.android.exoplayer2.util.s.a
            public void e(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // com.google.android.exoplayer2.util.s.a
            public void i(String str, String str2) {
            }

            @Override // com.google.android.exoplayer2.util.s.a
            public void w(String str, String str2) {
                Log.w(str, str2);
            }
        }

        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    private static String a(String str, Throwable th2) {
        String e11 = e(th2);
        if (TextUtils.isEmpty(e11)) {
            return str;
        }
        return str + "\n  " + e11.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (f27707a) {
            try {
                if (f27708b == 0) {
                    f27710d.d(str, str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void c(String str, String str2) {
        synchronized (f27707a) {
            try {
                if (f27708b <= 3) {
                    f27710d.e(str, str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        c(str, a(str2, th2));
    }

    public static String e(Throwable th2) {
        synchronized (f27707a) {
            try {
                if (th2 == null) {
                    return null;
                }
                if (h(th2)) {
                    return "UnknownHostException (no network)";
                }
                if (f27709c) {
                    return Log.getStackTraceString(th2).trim().replace("\t", "    ");
                }
                return th2.getMessage();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static void f(String str, String str2) {
        synchronized (f27707a) {
            try {
                if (f27708b <= 1) {
                    f27710d.i(str, str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void g(String str, String str2, Throwable th2) {
        f(str, a(str2, th2));
    }

    private static boolean h(Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof UnknownHostException) {
                return true;
            }
            th2 = th2.getCause();
        }
        return false;
    }

    public static void i(String str, String str2) {
        synchronized (f27707a) {
            try {
                if (f27708b <= 2) {
                    f27710d.w(str, str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void j(String str, String str2, Throwable th2) {
        i(str, a(str2, th2));
    }
}
