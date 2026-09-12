package oc;

import com.google.firebase.messaging.threads.ThreadPriority;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final oc.a f71084a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile oc.a f71085b;

    /* renamed from: oc.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0888b implements oc.a {
        private C0888b() {
        }

        @Override // oc.a
        public ExecutorService a(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return b(1, threadFactory, threadPriority);
        }

        public ExecutorService b(int i11, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        C0888b c0888b = new C0888b();
        f71084a = c0888b;
        f71085b = c0888b;
    }

    public static oc.a a() {
        return f71085b;
    }
}
