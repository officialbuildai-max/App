package com.mbridge.msdk.tracker;

import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private volatile ThreadPoolExecutor f38580a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MBridgeTrackThread");
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f38582a;

        public b(Runnable runnable) {
            this.f38582a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y.b(this.f38582a)) {
                return;
            }
            try {
                this.f38582a.run();
            } catch (Exception e11) {
                if (com.mbridge.msdk.tracker.a.f38550a) {
                    Log.e("TrackManager", "execute error", e11);
                }
            }
        }
    }

    private ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
    }

    public void a(Runnable runnable) {
        if (this.f38580a == null) {
            this.f38580a = a();
        }
        if (this.f38580a.isShutdown()) {
            return;
        }
        this.f38580a.execute(new b(runnable));
    }
}
