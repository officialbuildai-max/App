package com.apm.insight.b;

import android.os.SystemClock;
import com.apm.insight.runtime.m;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static long f19436b;

    /* renamed from: a, reason: collision with root package name */
    private final b f19437a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f19438c = false;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f19439d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        Runnable runnable = new Runnable() { // from class: com.apm.insight.b.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.f19438c) {
                    return;
                }
                c.this.f19437a.d();
                long unused = c.f19436b = SystemClock.uptimeMillis();
                if (com.apm.insight.runtime.i.a().b()) {
                    m.a().a(c.this.f19439d, 500L);
                } else {
                    m.a().a(c.this.f19439d, 500L);
                }
                com.apm.insight.runtime.b.a(c.f19436b);
            }
        };
        this.f19439d = runnable;
        this.f19437a = bVar;
        m.a().a(runnable, 5000L);
    }

    public static boolean c() {
        return SystemClock.uptimeMillis() - f19436b <= MBInterstitialActivity.WEB_LOAD_TIME;
    }

    public final void a() {
        if (this.f19438c) {
            return;
        }
        m.a().a(this.f19439d, 5000L);
    }

    public final void b() {
        this.f19438c = true;
    }
}
