package com.cloud.sdk.commonutil.pool;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f23234b;

    /* renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f23235c;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f23236a;

    public static b b() {
        if (f23234b == null) {
            synchronized (b.class) {
                try {
                    if (f23234b == null) {
                        f23234b = new b();
                        b bVar = f23234b;
                        ThreadPoolExecutor threadPoolExecutor = f23235c;
                        if (threadPoolExecutor == null) {
                            threadPoolExecutor = HSPoolExecutor.b();
                        }
                        bVar.f23236a = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return f23234b;
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.f23236a;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor.isShutdown()) {
                this.f23236a.prestartAllCoreThreads();
            }
            this.f23236a.execute(runnable);
        }
    }
}
