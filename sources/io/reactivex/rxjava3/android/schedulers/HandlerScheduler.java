package io.reactivex.rxjava3.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.c;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class HandlerScheduler extends Scheduler {

    /* renamed from: c, reason: collision with root package name */
    private final Handler f65426c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f65427d;

    /* loaded from: classes.dex */
    private static final class ScheduledRunnable implements Runnable, c {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.delegate = runnable;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable th2) {
                pz.a.r(th2);
            }
        }
    }

    /* loaded from: classes7.dex */
    private static final class a extends Scheduler.Worker {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f65428a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f65429b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f65430c;

        a(Handler handler, boolean z10) {
            this.f65428a = handler;
            this.f65429b = z10;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f65430c = true;
            this.f65428a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65430c;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public c schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f65430c) {
                return io.reactivex.rxjava3.disposables.b.a();
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f65428a, pz.a.t(runnable));
            Message obtain = Message.obtain(this.f65428a, scheduledRunnable);
            obtain.obj = this;
            if (this.f65429b) {
                obtain.setAsynchronous(true);
            }
            this.f65428a.sendMessageDelayed(obtain, timeUnit.toMillis(j11));
            if (!this.f65430c) {
                return scheduledRunnable;
            }
            this.f65428a.removeCallbacks(scheduledRunnable);
            return io.reactivex.rxjava3.disposables.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerScheduler(Handler handler, boolean z10) {
        this.f65426c = handler;
        this.f65427d = z10;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new a(this.f65426c, this.f65427d);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public c e(Runnable runnable, long j11, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.f65426c, pz.a.t(runnable));
        Message obtain = Message.obtain(this.f65426c, scheduledRunnable);
        if (this.f65427d) {
            obtain.setAsynchronous(true);
        }
        this.f65426c.sendMessageDelayed(obtain, timeUnit.toMillis(j11));
        return scheduledRunnable;
    }
}
