package com.apm.insight.runtime;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import com.apm.insight.b.h;
import com.apm.insight.b.i;
import com.apm.insight.nativecrash.NativeImpl;
import java.io.File;
import java.util.Map;

/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f19896a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f19897b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f19898c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f19899d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f19900e;

    /* renamed from: f, reason: collision with root package name */
    private static c f19901f = new c();

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f19902g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f19903h = false;

    public static c a() {
        return f19901f;
    }

    public static void a(long j11) {
        NativeImpl.a(j11);
    }

    public static synchronized void a(@NonNull Application application, @NonNull Context context) {
        synchronized (l.class) {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (f19896a) {
                    return;
                }
                f19896a = true;
                if (context == null || application == null) {
                    throw new IllegalArgumentException("context or Application must be not null.");
                }
                com.apm.insight.e.a(application, context);
                if (!com.apm.insight.e.u() || (!b(application) && !c(application))) {
                    com.apm.insight.g.a a11 = com.apm.insight.g.a.a();
                    a11.a(new com.apm.insight.i.b(context));
                    a11.b(new com.apm.insight.g.d(context));
                    f19897b = true;
                    NativeImpl.a();
                    boolean a12 = NativeImpl.a(context);
                    f19899d = a12;
                    if (!a12) {
                        f19900e = true;
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        f19902g = true;
                        NativeImpl.i();
                    }
                    m.a().a(new Runnable() { // from class: com.apm.insight.runtime.l.2

                        /* renamed from: a, reason: collision with root package name */
                        private /* synthetic */ boolean f19906a = true;

                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!l.f19902g) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.apm.insight.runtime.l.2.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        l.r();
                                        NativeImpl.i();
                                    }
                                });
                            }
                            l.e(this.f19906a);
                        }
                    }, 0L);
                    com.apm.insight.a.a((Object) ("Npth.init takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms."));
                    return;
                }
                Log.e("apminsight", "Inner npth checked.");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static synchronized void a(@NonNull Context context) {
        Application application;
        synchronized (l.class) {
            try {
                if (com.apm.insight.e.h() != null) {
                    application = com.apm.insight.e.h();
                } else if (context instanceof Application) {
                    application = (Application) context;
                    if (application.getBaseContext() == null) {
                        throw new IllegalArgumentException("The Application passed in when init has not been attached, please pass a attachBaseContext as param and call Npth.setApplication(Application) before init.");
                    }
                } else {
                    application = (Application) context.getApplicationContext();
                    if (application == null) {
                        throw new IllegalArgumentException("Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.");
                    }
                    if (application.getBaseContext() != null) {
                        context = application.getBaseContext();
                    }
                }
                a(application, context);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(ICrashCallback iCrashCallback, CrashType crashType) {
        f19901f.a(iCrashCallback, crashType);
    }

    public static void a(IOOMCallback iOOMCallback) {
        f19901f.a(iOOMCallback);
    }

    public static void a(h.a aVar) {
        h.a(aVar);
    }

    public static void a(@NonNull i.a aVar) {
        com.apm.insight.e.i().setEncryptImpl$22f2d42e(aVar);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str);
    }

    public static void a(final String str, final h.a aVar) {
        m.a().a(new Runnable() { // from class: com.apm.insight.runtime.l.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                    com.apm.insight.b.d.a(str, aVar);
                }
            }
        });
    }

    public static void a(String str, i.a aVar, i.a aVar2) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return;
        }
        com.apm.insight.a.a.a().a(str, aVar, aVar2);
    }

    public static void a(String str, @Nullable Map<? extends String, ? extends String> map, @Nullable Map<String, String> map2, @Nullable h.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, aVar);
    }

    public static void a(String str, @Nullable Map<? extends String, ? extends String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @Nullable h.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, map3, aVar);
    }

    @Deprecated
    public static void a(@NonNull Throwable th2) {
        if (com.apm.insight.e.i().isReportErrorEnable()) {
            com.apm.insight.g.a.a(th2);
        }
    }

    public static void a(boolean z10) {
        com.apm.insight.e.a(z10);
    }

    public static void b(long j11) {
        NativeImpl.b(j11);
    }

    public static void b(ICrashCallback iCrashCallback, CrashType crashType) {
        f19901f.b(iCrashCallback, crashType);
    }

    public static void b(IOOMCallback iOOMCallback) {
        f19901f.b(iOOMCallback);
    }

    public static void b(h.a aVar) {
        com.apm.insight.k.e.a(aVar);
    }

    @Deprecated
    public static void b(String str) {
        if (com.apm.insight.e.i().isReportErrorEnable()) {
            com.apm.insight.g.a.c(str);
        }
    }

    public static void b(boolean z10) {
        com.apm.insight.e.b(z10);
    }

    public static boolean b() {
        return f19897b;
    }

    private static boolean b(Context context) {
        try {
            return new File(com.apm.insight.l.j.j(context), "npth").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c(String str) {
        NativeImpl.b(str);
    }

    public static void c(boolean z10) {
        com.apm.insight.e.c(z10);
    }

    public static boolean c() {
        return f19898c;
    }

    private static boolean c(Context context) {
        try {
            return new File(context.getApplicationInfo().nativeLibraryDir, "libapminsighta.so").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void d(boolean z10) {
        com.apm.insight.e.d(z10);
    }

    public static boolean d() {
        return f19899d;
    }

    static /* synthetic */ void e(boolean z10) {
        Context g11 = com.apm.insight.e.g();
        com.apm.insight.runtime.a.f.a();
        j.a();
        int b11 = NativeImpl.b();
        NativeImpl.d();
        if (f19900e) {
            com.apm.insight.c.a();
            com.apm.insight.b.a.a("NativeLibraryLoad faild");
        } else if (b11 < 0) {
            com.apm.insight.c.a();
            com.apm.insight.b.a.a("createCallbackThread faild");
        }
        com.apm.insight.e.a.a().a(g11);
        com.apm.insight.c.a();
        com.apm.insight.k.h.a(g11);
        if (z10) {
            com.apm.insight.b.f.a(g11).c();
            f19898c = z10;
        }
        com.apm.insight.k.g.a().b();
        NativeImpl.g();
        com.apm.insight.k.j.d();
        NativeImpl.k();
        n.a("afterNpthInitAsync", "noValue");
    }

    public static boolean e() {
        return f19896a;
    }

    public static void f() {
        if (!f19896a || f19897b) {
            return;
        }
        Context g11 = com.apm.insight.e.g();
        com.apm.insight.g.a a11 = com.apm.insight.g.a.a();
        a11.a(new com.apm.insight.i.b(g11));
        a11.b(new com.apm.insight.g.d(g11));
    }

    public static void g() {
        if (f19896a) {
            com.apm.insight.b.f.a(com.apm.insight.e.g()).c();
            f19898c = true;
        }
    }

    public static boolean h() {
        if (f19896a && !f19899d) {
            boolean a11 = NativeImpl.a(com.apm.insight.e.g());
            f19899d = a11;
            if (!a11) {
                f19900e = true;
            }
        }
        return f19899d;
    }

    public static boolean i() {
        return com.apm.insight.b.c.c();
    }

    public static void j() {
        if (f19896a) {
            com.apm.insight.b.f.a(com.apm.insight.e.g()).d();
            f19898c = false;
        }
    }

    public static void k() {
        NativeImpl.c();
    }

    public static boolean l() {
        return com.apm.insight.g.a.b() || NativeImpl.e();
    }

    public static boolean m() {
        return com.apm.insight.g.a.c() || NativeImpl.e();
    }

    public static boolean n() {
        return com.apm.insight.g.a.b();
    }

    public static boolean o() {
        return f19903h;
    }

    public static void p() {
        f19903h = true;
    }

    static /* synthetic */ boolean r() {
        f19902g = true;
        return true;
    }
}
