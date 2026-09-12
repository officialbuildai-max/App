package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final HandlerThread f19926a;

    /* renamed from: d, reason: collision with root package name */
    private volatile Handler f19929d;

    /* renamed from: b, reason: collision with root package name */
    private final Queue<c> f19927b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    private final Queue<Message> f19928c = new ConcurrentLinkedQueue();

    /* renamed from: e, reason: collision with root package name */
    private final Object f19930e = new Object();

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!p.this.f19928c.isEmpty()) {
                if (p.this.f19929d != null) {
                    try {
                        p.this.f19929d.sendMessageAtFrontOfQueue((Message) p.this.f19928c.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
            while (!p.this.f19927b.isEmpty()) {
                c cVar = (c) p.this.f19927b.poll();
                if (p.this.f19929d != null) {
                    try {
                        p.this.f19929d.sendMessageAtTime(cVar.f19935a, cVar.f19936b);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends HandlerThread {

        /* renamed from: a, reason: collision with root package name */
        private volatile int f19932a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f19933b;

        b(String str) {
            super(str);
            this.f19932a = 0;
            this.f19933b = false;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (p.this.f19930e) {
                p.this.f19929d = new Handler();
            }
            p.this.f19929d.post(new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th2) {
                    try {
                        com.apm.insight.b.f.a(com.apm.insight.e.g()).a().c();
                        if (this.f19932a < 5) {
                            com.apm.insight.c.a();
                            j.a(th2, "NPTH_CATCH");
                        } else if (!this.f19933b) {
                            this.f19933b = true;
                            com.apm.insight.c.a();
                            j.a(new RuntimeException(), "NPTH_ERR_MAX");
                        }
                        this.f19932a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        Message f19935a;

        /* renamed from: b, reason: collision with root package name */
        long f19936b;

        c(Message message, long j11) {
            this.f19935a = message;
            this.f19936b = j11;
        }
    }

    static {
        new Object() { // from class: com.apm.insight.runtime.p.1
        };
        new Object() { // from class: com.apm.insight.runtime.p.2
        };
    }

    public p(String str) {
        this.f19926a = new b(str);
    }

    private boolean a(Message message, long j11) {
        if (j11 < 0) {
            j11 = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j11);
    }

    private Message b(Runnable runnable) {
        return Message.obtain(this.f19929d, runnable);
    }

    private boolean b(Message message, long j11) {
        if (this.f19929d == null) {
            synchronized (this.f19930e) {
                try {
                    if (this.f19929d == null) {
                        this.f19927b.add(new c(message, j11));
                        return true;
                    }
                } finally {
                }
            }
        }
        try {
            return this.f19929d.sendMessageAtTime(message, j11);
        } catch (Throwable unused) {
            return true;
        }
    }

    @Nullable
    public final Handler a() {
        return this.f19929d;
    }

    public final boolean a(Runnable runnable) {
        return a(b(runnable), 0L);
    }

    public final boolean a(Runnable runnable, long j11) {
        return a(b(runnable), j11);
    }

    public final void b() {
        this.f19926a.start();
    }

    public final HandlerThread c() {
        return this.f19926a;
    }
}
