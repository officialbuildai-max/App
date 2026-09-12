package com.mbridge.msdk.foundation.same.report.crashreport;

import android.annotation.TargetApi;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

/* loaded from: classes5.dex */
public class c extends Thread {

    /* renamed from: e, reason: collision with root package name */
    private static volatile c f35578e;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f35579a;

    /* renamed from: b, reason: collision with root package name */
    private volatile b f35580b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.crashreport.a f35581c;

    /* renamed from: d, reason: collision with root package name */
    private int f35582d;

    /* loaded from: classes5.dex */
    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private long f35583a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f35584b;

        /* renamed from: c, reason: collision with root package name */
        private long f35585c;

        private b() {
            this.f35583a = SystemClock.uptimeMillis();
        }

        boolean a() {
            return !this.f35584b || this.f35583a - this.f35585c >= ((long) c.this.f35582d);
        }

        void b() {
            this.f35584b = false;
            this.f35585c = SystemClock.uptimeMillis();
            c.this.f35579a.postAtFrontOfQueue(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                this.f35584b = true;
                this.f35583a = SystemClock.uptimeMillis();
            }
        }
    }

    private c() {
        super("AnrMonitor-Thread");
        this.f35579a = new Handler(Looper.getMainLooper());
        this.f35582d = 5000;
    }

    public static c a() {
        if (f35578e == null) {
            synchronized (c.class) {
                try {
                    if (f35578e == null) {
                        f35578e = new c();
                    }
                } finally {
                }
            }
        }
        return f35578e;
    }

    public c a(int i11, com.mbridge.msdk.foundation.same.report.crashreport.a aVar) {
        this.f35582d = i11;
        this.f35581c = aVar;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    @TargetApi(16)
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            if (isInterrupted() || !(this.f35580b == null || this.f35580b.f35584b)) {
                try {
                    Thread.sleep(this.f35582d);
                } catch (Exception unused) {
                }
            } else {
                synchronized (this) {
                    try {
                        if (this.f35580b == null) {
                            this.f35580b = new b();
                        }
                        this.f35580b.b();
                        long j11 = this.f35582d;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        while (j11 > 0) {
                            try {
                                wait(j11);
                            } catch (InterruptedException e11) {
                                Log.w("AnrMonitor", e11.toString());
                            }
                            j11 = this.f35582d - (SystemClock.uptimeMillis() - uptimeMillis);
                        }
                        if (!this.f35580b.a()) {
                            com.mbridge.msdk.foundation.same.report.crashreport.a aVar = this.f35581c;
                            if (aVar != null) {
                                aVar.a();
                            }
                        } else if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.f35581c != null) {
                            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                            this.f35581c.a(d.b(stackTrace), stackTrace);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }
}
