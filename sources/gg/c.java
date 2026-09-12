package gg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final a f63695c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f63696a;

    /* renamed from: b, reason: collision with root package name */
    private ScheduledExecutorService f63697b;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return b.f63698a.a();
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f63698a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final c f63699b = new c(null);

        private b() {
        }

        public final c a() {
            return f63699b;
        }
    }

    private c() {
        c();
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void c() {
        if (this.f63696a == null) {
            this.f63696a = Executors.newCachedThreadPool();
        }
        if (this.f63697b == null) {
            this.f63697b = Executors.newSingleThreadScheduledExecutor();
        }
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService;
        try {
            ExecutorService executorService2 = this.f63696a;
            Boolean valueOf = executorService2 == null ? null : Boolean.valueOf(executorService2.isShutdown());
            Intrinsics.e(valueOf);
            if (!valueOf.booleanValue() && (executorService = this.f63696a) != null) {
                executorService.execute(runnable);
            }
        } catch (RejectedExecutionException e11) {
            gg.b.f63690a.e(e11);
        }
    }

    public final void b(Runnable runnable) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f63697b;
            if (scheduledExecutorService != null && scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService2 = this.f63697b;
            if (scheduledExecutorService2 == null) {
                return;
            }
            scheduledExecutorService2.execute(runnable);
        } catch (Throwable th2) {
            gg.b.f63690a.e(th2);
        }
    }

    public final void d(Runnable runnable, long j11, TimeUnit unit) {
        Intrinsics.h(unit, "unit");
        try {
            ScheduledExecutorService scheduledExecutorService = this.f63697b;
            if (scheduledExecutorService != null && scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService2 = this.f63697b;
            if (scheduledExecutorService2 == null) {
                return;
            }
            scheduledExecutorService2.schedule(runnable, j11, unit);
        } catch (Throwable th2) {
            gg.b.f63690a.e(th2);
        }
    }
}
