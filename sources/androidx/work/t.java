package androidx.work;

import android.util.Log;

/* loaded from: classes2.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f16134a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile t f16135b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final int f16136c = 20;

    /* loaded from: classes2.dex */
    public static class a extends t {

        /* renamed from: d, reason: collision with root package name */
        private final int f16137d;

        public a(int i11) {
            super(i11);
            this.f16137d = i11;
        }

        @Override // androidx.work.t
        public void a(String str, String str2) {
        }

        @Override // androidx.work.t
        public void b(String str, String str2, Throwable th2) {
        }

        @Override // androidx.work.t
        public void c(String str, String str2) {
            if (this.f16137d <= 6) {
                Log.e(str, str2);
            }
        }

        @Override // androidx.work.t
        public void d(String str, String str2, Throwable th2) {
            if (this.f16137d <= 6) {
                Log.e(str, str2, th2);
            }
        }

        @Override // androidx.work.t
        public void f(String str, String str2) {
        }

        @Override // androidx.work.t
        public void g(String str, String str2, Throwable th2) {
        }

        @Override // androidx.work.t
        public void j(String str, String str2) {
            if (this.f16137d <= 2) {
                Log.v(str, str2);
            }
        }

        @Override // androidx.work.t
        public void k(String str, String str2) {
            if (this.f16137d <= 5) {
                Log.w(str, str2);
            }
        }

        @Override // androidx.work.t
        public void l(String str, String str2, Throwable th2) {
            if (this.f16137d <= 5) {
                Log.w(str, str2, th2);
            }
        }
    }

    public t(int i11) {
    }

    public static t e() {
        t tVar;
        synchronized (f16134a) {
            try {
                if (f16135b == null) {
                    f16135b = new a(3);
                }
                tVar = f16135b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tVar;
    }

    public static void h(t tVar) {
        synchronized (f16134a) {
            try {
                if (f16135b == null) {
                    f16135b = tVar;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String i(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        int i11 = f16136c;
        if (length >= i11) {
            sb2.append(str.substring(0, i11));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public abstract void a(String str, String str2);

    public abstract void b(String str, String str2, Throwable th2);

    public abstract void c(String str, String str2);

    public abstract void d(String str, String str2, Throwable th2);

    public abstract void f(String str, String str2);

    public abstract void g(String str, String str2, Throwable th2);

    public abstract void j(String str, String str2);

    public abstract void k(String str, String str2);

    public abstract void l(String str, String str2, Throwable th2);
}
