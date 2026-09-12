package com.tn.lib.thread;

import com.tn.lib.thread.wrapper.RunnableWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class c implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public static final a f40924f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f40925a;

    /* renamed from: b, reason: collision with root package name */
    private String f40926b;

    /* renamed from: c, reason: collision with root package name */
    private dh.b f40927c;

    /* renamed from: d, reason: collision with root package name */
    private Executor f40928d;

    /* renamed from: e, reason: collision with root package name */
    private ThreadLocal f40929e;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final eh.a a(int i11) {
            return new eh.a(i11, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final int f40930a;

        public b(int i11) {
            this.f40930a = i11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f40930a);
            return thread;
        }
    }

    public c(int i11, int i12, int i13, String threadName, dh.b bVar, Executor executor, ExecutorService executorService) {
        Intrinsics.h(threadName, "threadName");
        this.f40926b = threadName;
        this.f40927c = bVar;
        this.f40928d = executor;
        this.f40925a = executorService == null ? a(i11, i12, i13) : executorService;
        this.f40926b = threadName;
        this.f40927c = bVar;
        this.f40928d = executor;
        this.f40929e = new ThreadLocal();
    }

    private final ExecutorService a(int i11, int i12, int i13) {
        if (i11 == 1) {
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i12, new b(i13));
            Intrinsics.g(newFixedThreadPool, "newFixedThreadPool(...)");
            return newFixedThreadPool;
        }
        if (i11 == 2) {
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new b(i13));
            Intrinsics.g(newCachedThreadPool, "newCachedThreadPool(...)");
            return newCachedThreadPool;
        }
        if (i11 == 3) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(i12, new b(i13));
            Intrinsics.g(newScheduledThreadPool, "newScheduledThreadPool(...)");
            return newScheduledThreadPool;
        }
        if (i11 != 4) {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new b(i13));
            Intrinsics.g(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
            return newSingleThreadExecutor;
        }
        ExecutorService newSingleThreadExecutor2 = Executors.newSingleThreadExecutor(new b(i13));
        Intrinsics.g(newSingleThreadExecutor2, "newSingleThreadExecutor(...)");
        return newSingleThreadExecutor2;
    }

    private final eh.d b() {
        ThreadLocal threadLocal = this.f40929e;
        eh.d dVar = threadLocal != null ? (eh.d) threadLocal.get() : null;
        if (dVar == null) {
            dVar = new eh.d();
            dVar.h(this.f40926b);
            dVar.g(this.f40927c);
            dVar.f(this.f40928d);
            ThreadLocal threadLocal2 = this.f40929e;
            if (threadLocal2 != null) {
                threadLocal2.set(dVar);
            }
        }
        return dVar;
    }

    public final void c() {
        ThreadLocal threadLocal = this.f40929e;
        if (threadLocal != null) {
            threadLocal.set(null);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        Intrinsics.h(command, "command");
        eh.d b11 = b();
        fh.c.f62521b.a().e(b11.b(), this.f40925a, new RunnableWrapper(b11).setRunnable(command));
        c();
    }
}
