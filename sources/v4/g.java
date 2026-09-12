package v4;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class g implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f77147d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f77148a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f77149b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private final String f77150c;

    public g() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f77148a = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
        this.f77150c = "lottie-" + f77147d.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f77148a, runnable, this.f77150c + this.f77149b.getAndIncrement(), 0L);
        thread.setDaemon(false);
        thread.setPriority(10);
        return thread;
    }
}
