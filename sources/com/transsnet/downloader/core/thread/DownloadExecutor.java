package com.transsnet.downloader.core.thread;

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

/* loaded from: classes.dex */
public final class DownloadExecutor {

    /* renamed from: a, reason: collision with root package name */
    public static final b f58756a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f58757b = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.downloader.core.thread.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadExecutor b11;
            b11 = DownloadExecutor.b();
            return b11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final int f58758c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f58759d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f58760e;

    /* renamed from: f, reason: collision with root package name */
    private static final BlockingQueue f58761f;

    /* renamed from: g, reason: collision with root package name */
    private static final ThreadFactory f58762g;

    /* renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f58763h;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/transsnet/downloader/core/thread/DownloadExecutor$BackgroundThread;", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "name", "", "<init>", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes7.dex */
    private static final class BackgroundThread extends Thread {
        public BackgroundThread(Runnable runnable, String str) {
            super(runnable, str);
            setPriority(5);
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f58764a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            return new BackgroundThread(runnable, "or_download_" + this.f58764a.getAndIncrement());
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return DownloadExecutor.f58759d;
        }

        public final DownloadExecutor b() {
            return (DownloadExecutor) DownloadExecutor.f58757b.getValue();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f58758c = availableProcessors;
        f58759d = RangesKt.f(availableProcessors, 8);
        f58760e = RangesKt.f(availableProcessors, 8);
        f58761f = new LinkedBlockingQueue(64);
        f58762g = new a();
    }

    private DownloadExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f58759d, f58760e, 20L, TimeUnit.SECONDS, f58761f, f58762g, new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f58763h = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadExecutor b() {
        return new DownloadExecutor();
    }

    public final void e(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = f58763h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        }
    }
}
