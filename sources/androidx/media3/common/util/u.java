package androidx.media3.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public abstract class u {

    /* renamed from: b, reason: collision with root package name */
    private static int f10543b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f10544c = true;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f10542a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static a f10545d = a.f10546a;

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10546a = new C0097a();

        /* renamed from: androidx.media3.common.util.u$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0097a implements a {
            C0097a() {
            }

            @Override // androidx.media3.common.util.u.a
            public void a(String str, String str2, Throwable th2) {
                u.a(str2, th2);
            }

            @Override // androidx.media3.common.util.u.a
            public void b(String str, String str2, Throwable th2) {
                u.a(str2, th2);
            }

            @Override // androidx.media3.common.util.u.a
            public void e(String str, String str2, Throwable th2) {
                Log.e(str, u.a(str2, th2));
            }

            @Override // androidx.media3.common.util.u.a
            public void w(String str, String str2, Throwable th2) {
                Log.w(str, u.a(str2, th2));
            }
        }

        void a(String str, String str2, Throwable th2);

        void b(String str, String str2, Throwable th2);

        void e(String str, String str2, Throwable th2);

        void w(String str, String str2, Throwable th2);
    }

    public static String a(String str, Throwable th2) {
        String e11 = e(th2);
        if (TextUtils.isEmpty(e11)) {
            return str;
        }
        return str + "\n  " + e11.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (f10542a) {
            try {
                if (f10543b == 0) {
                    f10545d.a(str, str2, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void c(String str, String str2) {
        synchronized (f10542a) {
            try {
                if (f10543b <= 3) {
                    f10545d.e(str, str2, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        synchronized (f10542a) {
            try {
                if (f10543b <= 3) {
                    f10545d.e(str, str2, th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static String e(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        synchronized (f10542a) {
            try {
                if (g(th2)) {
                    return "UnknownHostException (no network)";
                }
                if (f10544c) {
                    return Log.getStackTraceString(th2).trim().replace("\t", "    ");
                }
                return th2.getMessage();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static void f(String str, String str2) {
        synchronized (f10542a) {
            try {
                if (f10543b <= 1) {
                    f10545d.b(str, str2, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean g(Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof UnknownHostException) {
                return true;
            }
            th2 = th2.getCause();
        }
        return false;
    }

    public static void h(String str, String str2) {
        synchronized (f10542a) {
            try {
                if (f10543b <= 2) {
                    f10545d.w(str, str2, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        synchronized (f10542a) {
            try {
                if (f10543b <= 2) {
                    f10545d.w(str, str2, th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
