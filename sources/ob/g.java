package ob;

import android.util.Log;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    static final g f71078c = new g("FirebaseCrashlytics");

    /* renamed from: a, reason: collision with root package name */
    private final String f71079a;

    /* renamed from: b, reason: collision with root package name */
    private int f71080b = 4;

    public g(String str) {
        this.f71079a = str;
    }

    private boolean a(int i11) {
        return this.f71080b <= i11 || Log.isLoggable(this.f71079a, i11);
    }

    public static g f() {
        return f71078c;
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th2) {
        a(3);
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th2) {
        if (a(6)) {
            Log.e(this.f71079a, str, th2);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th2) {
        a(4);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th2) {
        if (a(2)) {
            Log.v(this.f71079a, str, th2);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th2) {
        if (a(5)) {
            Log.w(this.f71079a, str, th2);
        }
    }
}
