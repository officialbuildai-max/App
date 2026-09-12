package com.mbridge.msdk.foundation.same.task;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f35694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("mb-task-loader-thread");
            return thread;
        }
    }

    private static int a(int i11, String str) {
        try {
            int b11 = q0.a().b(str, i11);
            return b11 <= 0 ? i11 : b11;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return i11;
            }
            o0.b("CommonTaskLoaderThreadPool", e11.getMessage());
            return i11;
        }
    }

    private static ThreadFactory a() {
        return new a();
    }

    public static ThreadPoolExecutor b() {
        c();
        if (f35694a == null) {
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f35694a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), a(), new ThreadPoolExecutor.DiscardPolicy());
            f35694a.allowCoreThreadTimeOut(true);
        }
        return f35694a;
    }

    private static void c() {
        if (f35694a != null) {
            return;
        }
        int a11 = a(10, "c_t_l_t_p_c");
        int a12 = a(50, "c_t_l_t_p_m");
        int a13 = a(5, "c_t_l_t_p_t");
        int i11 = a12 < a11 ? a11 : a12;
        try {
            if (MBridgeConstans.DEBUG) {
                o0.a("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor for core " + a11 + " max " + i11 + " timeout " + a13);
            }
            long j11 = a13;
            if (j11 <= 0) {
                j11 = 1;
            }
            f35694a = new ThreadPoolExecutor(a11, i11, j11, TimeUnit.SECONDS, new LinkedBlockingDeque(), a(), new ThreadPoolExecutor.DiscardPolicy());
            f35694a.allowCoreThreadTimeOut(true);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor failed ", e11);
            }
        }
    }
}
