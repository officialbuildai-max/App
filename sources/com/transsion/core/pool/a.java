package com.transsion.core.pool;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f44123b;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f44124a;

    public static a b() {
        if (f44123b == null) {
            synchronized (a.class) {
                try {
                    if (f44123b == null) {
                        f44123b = new a();
                        f44123b.f44124a = TranssionPoolExecutor.c();
                    }
                } finally {
                }
            }
        }
        return f44123b;
    }

    @Override // com.transsion.core.pool.b
    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.f44124a;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor.isShutdown()) {
                this.f44124a.prestartAllCoreThreads();
            }
            this.f44124a.execute(runnable);
        }
    }
}
