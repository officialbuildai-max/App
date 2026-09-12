package o8;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class a implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f70863b = new a("GENERAL_EXECUTOR", 4, 32);

    /* renamed from: c, reason: collision with root package name */
    public static final ScheduledExecutorService f70864c = Executors.newScheduledThreadPool(4);

    /* renamed from: d, reason: collision with root package name */
    private static int f70865d = 32;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f70866a;

    /* renamed from: o8.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class ThreadFactoryC0885a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f70867a = new AtomicInteger(1);

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f70868b;

        ThreadFactoryC0885a(String str) {
            this.f70868b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format(Locale.US, "BiddingKit:%s #%d", this.f70868b, Integer.valueOf(this.f70867a.getAndIncrement())));
        }
    }

    a(String str, int i11, int i12) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i12, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0885a(str));
        this.f70866a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        int size = this.f70866a.getQueue().size();
        synchronized (a.class) {
            try {
                int i11 = f70865d;
                if (size == i11) {
                    f70865d = i11 * 2;
                    com.facebook.biddingkit.logging.b.a("MultiAsyncTaskExecutor", "Tasks queue too long. Size = " + i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f70866a.execute(runnable);
    }
}
