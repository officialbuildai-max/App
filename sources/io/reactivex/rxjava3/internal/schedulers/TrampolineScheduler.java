package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class TrampolineScheduler extends Scheduler {

    /* renamed from: c, reason: collision with root package name */
    private static final TrampolineScheduler f65611c = new TrampolineScheduler();

    /* loaded from: classes7.dex */
    static final class SleepingRunnable implements Runnable {
        private final long execTime;
        private final Runnable run;
        private final TrampolineWorker worker;

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j11) {
            this.run = runnable;
            this.worker = trampolineWorker;
            this.execTime = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.worker.f65615d) {
                return;
            }
            long now = this.worker.now(TimeUnit.MILLISECONDS);
            long j11 = this.execTime;
            if (j11 > now) {
                try {
                    Thread.sleep(j11 - now);
                } catch (InterruptedException e11) {
                    Thread.currentThread().interrupt();
                    pz.a.r(e11);
                    return;
                }
            }
            if (this.worker.f65615d) {
                return;
            }
            this.run.run();
        }
    }

    /* loaded from: classes7.dex */
    static final class TrampolineWorker extends Scheduler.Worker {

        /* renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue f65612a = new PriorityBlockingQueue();

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f65613b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f65614c = new AtomicInteger();

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f65615d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public final class AppendToQueueTask implements Runnable {
            final a timedRunnable;

            AppendToQueueTask(a aVar) {
                this.timedRunnable = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.timedRunnable.f65619d = true;
                TrampolineWorker.this.f65612a.remove(this.timedRunnable);
            }
        }

        TrampolineWorker() {
        }

        io.reactivex.rxjava3.disposables.c a(Runnable runnable, long j11) {
            if (this.f65615d) {
                return EmptyDisposable.INSTANCE;
            }
            a aVar = new a(runnable, Long.valueOf(j11), this.f65614c.incrementAndGet());
            this.f65612a.add(aVar);
            if (this.f65613b.getAndIncrement() != 0) {
                return io.reactivex.rxjava3.disposables.b.b(new AppendToQueueTask(aVar));
            }
            int i11 = 1;
            while (!this.f65615d) {
                a aVar2 = (a) this.f65612a.poll();
                if (aVar2 == null) {
                    i11 = this.f65613b.addAndGet(-i11);
                    if (i11 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!aVar2.f65619d) {
                    aVar2.f65616a.run();
                }
            }
            this.f65612a.clear();
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            this.f65615d = true;
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65615d;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable) {
            return a(runnable, now(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            long now = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j11);
            return a(new SleepingRunnable(runnable, this, now), now);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f65616a;

        /* renamed from: b, reason: collision with root package name */
        final long f65617b;

        /* renamed from: c, reason: collision with root package name */
        final int f65618c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f65619d;

        a(Runnable runnable, Long l11, int i11) {
            this.f65616a = runnable;
            this.f65617b = l11.longValue();
            this.f65618c = i11;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int compare = Long.compare(this.f65617b, aVar.f65617b);
            return compare == 0 ? Integer.compare(this.f65618c, aVar.f65618c) : compare;
        }
    }

    TrampolineScheduler() {
    }

    public static TrampolineScheduler g() {
        return f65611c;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new TrampolineWorker();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c d(Runnable runnable) {
        pz.a.t(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c e(Runnable runnable, long j11, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j11);
            pz.a.t(runnable).run();
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            pz.a.r(e11);
        }
        return EmptyDisposable.INSTANCE;
    }
}
