package com.therouter;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class TheRouterThreadPool {

    /* renamed from: a, reason: collision with root package name */
    private static final int f40766a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f40767b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f40768c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f40769d;

    /* renamed from: e, reason: collision with root package name */
    private static long f40770e;

    /* renamed from: f, reason: collision with root package name */
    private static int f40771f;

    /* renamed from: g, reason: collision with root package name */
    private static ExecutorService f40772g;

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f40773h;

    /* renamed from: i, reason: collision with root package name */
    private static ThreadPoolExecutor f40774i;

    /* loaded from: classes5.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f40775a = new AtomicInteger(1);

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f40776b;

        a(String str) {
            this.f40776b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r11) {
            Intrinsics.h(r11, "r");
            return new Thread(r11, this.f40776b + " #" + this.f40775a.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f40766a = availableProcessors;
        int max = Math.max(3, Math.min(availableProcessors - 1, 6));
        f40767b = max;
        f40768c = availableProcessors * 4;
        f40769d = availableProcessors * 8;
        f40770e = 30L;
        f40771f = 10;
        f40772g = new BufferExecutor();
        f40773h = new Handler(Looper.getMainLooper());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, Integer.MAX_VALUE, f40770e, TimeUnit.SECONDS, new LinkedBlockingDeque(f40771f), k("TheRouterLibThread"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f40774i = threadPoolExecutor;
    }

    public static final void f(Runnable command) {
        Intrinsics.h(command, "command");
        try {
            f40772g.execute(command);
        } catch (Exception e11) {
            TheRouterKt.c("TheRouterThreadPool", "rejected execute runnable", new Function0<Unit>() { // from class: com.therouter.TheRouterThreadPool$execute$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m848invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m848invoke() {
                    e11.printStackTrace();
                }
            });
        }
    }

    public static final boolean g(Runnable command) {
        Intrinsics.h(command, "command");
        if (!Intrinsics.c(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            return f40773h.post(command);
        }
        command.run();
        return true;
    }

    public static final long h() {
        return f40770e;
    }

    public static final int i() {
        return f40771f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb2.append(stackTraceElement);
            sb2.append('\n');
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return sb3;
    }

    public static final ThreadFactory k(String threadName) {
        Intrinsics.h(threadName, "threadName");
        return new a(threadName);
    }
}
