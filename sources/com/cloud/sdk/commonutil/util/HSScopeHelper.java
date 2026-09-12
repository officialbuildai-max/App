package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.Looper;
import com.cloud.sdk.commonutil.util.f;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes3.dex */
public final class HSScopeHelper {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f23250b;

    /* renamed from: a, reason: collision with root package name */
    public static final HSScopeHelper f23249a = new HSScopeHelper();

    /* renamed from: c, reason: collision with root package name */
    private static final j0 f23251c = new a(j0.f68015k1);

    /* renamed from: d, reason: collision with root package name */
    private static final n0 f23252d = o0.a(y0.c());

    /* renamed from: e, reason: collision with root package name */
    private static final n0 f23253e = o0.a(y0.b());

    /* renamed from: f, reason: collision with root package name */
    private static final n0 f23254f = o0.a(y0.a());

    /* loaded from: classes3.dex */
    public static final class a extends AbstractCoroutineContextElement implements j0 {
        public a(j0.a aVar) {
            super(aVar);
        }

        @Override // kotlinx.coroutines.j0
        public void o(CoroutineContext coroutineContext, Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CoroutineExceptionHandler: ");
            sb2.append(th2.getMessage());
        }
    }

    private HSScopeHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function0 runnable, Function1 callback) {
        Intrinsics.h(runnable, "$runnable");
        Intrinsics.h(callback, "$callback");
        try {
            callback.invoke(new f.b(runnable.invoke()));
        } catch (Throwable th2) {
            callback.invoke(new f.a(th2));
        }
    }

    public final n0 b() {
        return f23254f;
    }

    public final boolean c() {
        return Intrinsics.c(Looper.myLooper(), Looper.getMainLooper());
    }

    public final void d(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        try {
            Handler a11 = j.f23283a.a("hs_fetch_ad_thread");
            if (a11 != null) {
                a11.removeCallbacks(runnable);
            }
        } catch (Throwable unused) {
        }
    }

    public final void e(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        Looper myLooper = Looper.myLooper();
        j jVar = j.f23283a;
        Handler a11 = jVar.a("hs_fetch_ad_thread");
        if (Intrinsics.c(myLooper, a11 != null ? a11.getLooper() : null)) {
            runnable.run();
            return;
        }
        Handler a12 = jVar.a("hs_fetch_ad_thread");
        if (a12 != null) {
            a12.post(runnable);
        }
    }

    public final void f(Runnable runnable, long j11) {
        Intrinsics.h(runnable, "runnable");
        Handler a11 = j.f23283a.a("hs_fetch_ad_thread");
        if (a11 != null) {
            a11.postDelayed(runnable, j11);
        }
    }

    public final void g(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        if (f23250b) {
            com.cloud.sdk.commonutil.pool.b.b().a(runnable);
        } else {
            kotlinx.coroutines.i.d(f23253e, f23251c, null, new HSScopeHelper$runIOThread$2(runnable, null), 2, null);
        }
    }

    public final void h(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        if (c()) {
            runnable.run();
        } else {
            kotlinx.coroutines.i.d(f23252d, null, null, new HSScopeHelper$runUIThread$1(runnable, null), 3, null);
        }
    }

    public final void i(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        Looper myLooper = Looper.myLooper();
        j jVar = j.f23283a;
        Handler a11 = jVar.a("hs_work_thread");
        if (Intrinsics.c(myLooper, a11 != null ? a11.getLooper() : null)) {
            runnable.run();
            return;
        }
        Handler a12 = jVar.a("hs_work_thread");
        if (a12 != null) {
            a12.post(runnable);
        }
    }

    public final void j(Runnable runnable, long j11) {
        Intrinsics.h(runnable, "runnable");
        Handler a11 = j.f23283a.a("hs_work_thread");
        if (a11 != null) {
            a11.postDelayed(runnable, j11);
        }
    }

    public final void k(final Function0 runnable, final Function1 callback) {
        Intrinsics.h(runnable, "runnable");
        Intrinsics.h(callback, "callback");
        Looper myLooper = Looper.myLooper();
        j jVar = j.f23283a;
        Handler a11 = jVar.a("hs_work_thread");
        if (Intrinsics.c(myLooper, a11 != null ? a11.getLooper() : null)) {
            try {
                callback.invoke(new f.b(runnable.invoke()));
                return;
            } catch (Throwable th2) {
                callback.invoke(new f.a(th2));
                return;
            }
        }
        Handler a12 = jVar.a("hs_work_thread");
        if (a12 != null) {
            a12.post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.g
                @Override // java.lang.Runnable
                public final void run() {
                    HSScopeHelper.l(Function0.this, callback);
                }
            });
        }
    }
}
