package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class TransferThreadPool {

    /* renamed from: a, reason: collision with root package name */
    private static final Log f18604a = LogFactory.b(TransferService.class);

    /* renamed from: b, reason: collision with root package name */
    private static ExecutorService f18605b;

    /* renamed from: c, reason: collision with root package name */
    private static ExecutorService f18606c;

    private static ExecutorService a(int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b(int i11) {
        synchronized (TransferThreadPool.class) {
            try {
                f18604a.a("Initializing the thread pool of size: " + i11);
                int max = Math.max((int) Math.ceil(((double) i11) / 2.0d), 1);
                if (f18605b == null) {
                    f18605b = a(max);
                }
                if (f18606c == null) {
                    f18606c = a(max);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static Future c(Callable callable) {
        b(TransferUtilityOptions.getDefaultThreadPoolSize());
        return callable instanceof UploadPartTask ? f18606c.submit(callable) : f18605b.submit(callable);
    }
}
