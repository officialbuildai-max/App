package io.reactivex.rxjava3.internal.schedulers;

import androidx.compose.animation.core.j0;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class a extends Scheduler {

    /* renamed from: e, reason: collision with root package name */
    static final b f65620e;

    /* renamed from: f, reason: collision with root package name */
    static final RxThreadFactory f65621f;

    /* renamed from: g, reason: collision with root package name */
    static final int f65622g = g(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());

    /* renamed from: h, reason: collision with root package name */
    static final c f65623h;

    /* renamed from: c, reason: collision with root package name */
    final ThreadFactory f65624c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference f65625d;

    /* renamed from: io.reactivex.rxjava3.internal.schedulers.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static final class C0820a extends Scheduler.Worker {

        /* renamed from: a, reason: collision with root package name */
        private final mz.a f65626a;

        /* renamed from: b, reason: collision with root package name */
        private final io.reactivex.rxjava3.disposables.a f65627b;

        /* renamed from: c, reason: collision with root package name */
        private final mz.a f65628c;

        /* renamed from: d, reason: collision with root package name */
        private final c f65629d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f65630e;

        C0820a(c cVar) {
            this.f65629d = cVar;
            mz.a aVar = new mz.a();
            this.f65626a = aVar;
            io.reactivex.rxjava3.disposables.a aVar2 = new io.reactivex.rxjava3.disposables.a();
            this.f65627b = aVar2;
            mz.a aVar3 = new mz.a();
            this.f65628c = aVar3;
            aVar3.b(aVar);
            aVar3.b(aVar2);
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public void dispose() {
            if (this.f65630e) {
                return;
            }
            this.f65630e = true;
            this.f65628c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.c
        public boolean isDisposed() {
            return this.f65630e;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable) {
            return this.f65630e ? EmptyDisposable.INSTANCE : this.f65629d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f65626a);
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public io.reactivex.rxjava3.disposables.c schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
            return this.f65630e ? EmptyDisposable.INSTANCE : this.f65629d.a(runnable, j11, timeUnit, this.f65627b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f65631a;

        /* renamed from: b, reason: collision with root package name */
        final c[] f65632b;

        /* renamed from: c, reason: collision with root package name */
        long f65633c;

        b(int i11, ThreadFactory threadFactory) {
            this.f65631a = i11;
            this.f65632b = new c[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                this.f65632b[i12] = new c(threadFactory);
            }
        }

        public c a() {
            int i11 = this.f65631a;
            if (i11 == 0) {
                return a.f65623h;
            }
            c[] cVarArr = this.f65632b;
            long j11 = this.f65633c;
            this.f65633c = 1 + j11;
            return cVarArr[(int) (j11 % i11)];
        }

        public void b() {
            for (c cVar : this.f65632b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f65623h = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        f65621f = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f65620e = bVar;
        bVar.b();
    }

    public a() {
        this(f65621f);
    }

    public a(ThreadFactory threadFactory) {
        this.f65624c = threadFactory;
        this.f65625d = new AtomicReference(f65620e);
        h();
    }

    static int g(int i11, int i12) {
        return (i12 <= 0 || i12 > i11) ? i11 : i12;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new C0820a(((b) this.f65625d.get()).a());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c e(Runnable runnable, long j11, TimeUnit timeUnit) {
        return ((b) this.f65625d.get()).a().b(runnable, j11, timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public io.reactivex.rxjava3.disposables.c f(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        return ((b) this.f65625d.get()).a().c(runnable, j11, j12, timeUnit);
    }

    public void h() {
        b bVar = new b(f65622g, this.f65624c);
        if (j0.a(this.f65625d, f65620e, bVar)) {
            return;
        }
        bVar.b();
    }
}
