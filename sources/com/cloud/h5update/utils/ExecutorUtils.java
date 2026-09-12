package com.cloud.h5update.utils;

import android.os.Handler;
import android.os.Looper;
import com.cloud.h5update.utils.ExecutorUtils$mainE$2;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class ExecutorUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final int f21362a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b, reason: collision with root package name */
    private static AtomicInteger f21363b = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f21364c = LazyKt.b(ExecutorUtils$ioE$2.INSTANCE);

    /* renamed from: d, reason: collision with root package name */
    private static AtomicInteger f21365d = new AtomicInteger();

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f21366e = LazyKt.b(ExecutorUtils$computationE$2.INSTANCE);

    /* renamed from: f, reason: collision with root package name */
    private static AtomicInteger f21367f = new AtomicInteger();

    /* renamed from: g, reason: collision with root package name */
    private static final Lazy f21368g = LazyKt.b(ExecutorUtils$newE$2.INSTANCE);

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f21369h = LazyKt.b(ExecutorUtils$singleE$2.INSTANCE);

    /* renamed from: i, reason: collision with root package name */
    private static AtomicInteger f21370i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private static final Lazy f21371j = LazyKt.b(ExecutorUtils$scheduledE$2.INSTANCE);

    /* renamed from: k, reason: collision with root package name */
    private static final Lazy f21372k = LazyKt.b(new Function0<ExecutorUtils$mainE$2.a>() { // from class: com.cloud.h5update.utils.ExecutorUtils$mainE$2

        /* loaded from: classes3.dex */
        public static final class a extends AbstractExecutorService {

            /* renamed from: a, reason: collision with root package name */
            private final Handler f21373a = new Handler(Looper.getMainLooper());

            a() {
            }

            @Override // java.util.concurrent.ExecutorService
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void shutdown() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean awaitTermination(long j11, TimeUnit unit) {
                Intrinsics.h(unit, "unit");
                return false;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable command) {
                Intrinsics.h(command, "command");
                this.f21373a.post(command);
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean isShutdown() {
                return false;
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean isTerminated() {
                return false;
            }

            @Override // java.util.concurrent.ExecutorService
            public List shutdownNow() {
                throw new UnsupportedOperationException();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    private static final ExecutorService f() {
        return (ExecutorService) f21364c.getValue();
    }

    public static final ExecutorService g() {
        return f();
    }
}
