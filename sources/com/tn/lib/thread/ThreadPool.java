package com.tn.lib.thread;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes4.dex */
public final class ThreadPool {

    /* renamed from: a, reason: collision with root package name */
    public static final b f40910a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f40911b = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.tn.lib.thread.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ThreadPool b11;
            b11 = ThreadPool.b();
            return b11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final int f40912c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f40913d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f40914e;

    /* renamed from: f, reason: collision with root package name */
    private static final BlockingQueue f40915f;

    /* renamed from: g, reason: collision with root package name */
    private static final ThreadFactory f40916g;

    /* renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f40917h;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/tn/lib/thread/ThreadPool$BackgroundThread;", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "name", "", "<init>", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "thread_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes4.dex */
    private static final class BackgroundThread extends Thread {
        public BackgroundThread(Runnable runnable, String str) {
            super(runnable, str);
            setPriority(5);
        }
    }

    /* loaded from: classes4.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f40918a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            return new BackgroundThread(runnable, "or_threadpool_" + this.f40918a.getAndIncrement());
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ThreadPool a() {
            return (ThreadPool) ThreadPool.f40911b.getValue();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f40912c = availableProcessors;
        f40913d = RangesKt.i(availableProcessors - 1, 4);
        f40914e = RangesKt.i((availableProcessors * 2) + 1, 8);
        f40915f = new LinkedBlockingQueue(64);
        f40916g = new a();
    }

    private ThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f40913d, f40914e, 30L, TimeUnit.SECONDS, f40915f, f40916g, new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f40917h = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadPool b() {
        return new ThreadPool();
    }

    public static final ThreadPool e() {
        return f40910a.a();
    }

    public final void d(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = f40917h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }
}
