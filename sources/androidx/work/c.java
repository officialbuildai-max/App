package androidx.work;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m1;

/* loaded from: classes2.dex */
public abstract class c {

    /* loaded from: classes2.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f15541a = new AtomicInteger(0);

        /* renamed from: b */
        final /* synthetic */ boolean f15542b;

        a(boolean z10) {
            this.f15542b = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Intrinsics.h(runnable, "runnable");
            return new Thread(runnable, (this.f15542b ? "WM.task-" : "androidx.work-") + this.f15541a.incrementAndGet());
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements f0 {
        b() {
        }

        @Override // androidx.work.f0
        public void a(String label) {
            Intrinsics.h(label, "label");
            f4.a.c(label);
        }

        @Override // androidx.work.f0
        public void b(String methodName, int i11) {
            Intrinsics.h(methodName, "methodName");
            f4.a.d(methodName, i11);
        }

        @Override // androidx.work.f0
        public void c(String methodName, int i11) {
            Intrinsics.h(methodName, "methodName");
            f4.a.a(methodName, i11);
        }

        @Override // androidx.work.f0
        public void d() {
            f4.a.f();
        }

        @Override // androidx.work.f0
        public boolean isEnabled() {
            return f4.a.h();
        }
    }

    public static final Executor d(CoroutineContext coroutineContext) {
        ContinuationInterceptor continuationInterceptor = coroutineContext != null ? (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.INSTANCE) : null;
        kotlinx.coroutines.i0 i0Var = continuationInterceptor instanceof kotlinx.coroutines.i0 ? (kotlinx.coroutines.i0) continuationInterceptor : null;
        if (i0Var != null) {
            return m1.a(i0Var);
        }
        return null;
    }

    public static final Executor e(boolean z10) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new a(z10));
        Intrinsics.g(newFixedThreadPool, "newFixedThreadPool(...)");
        return newFixedThreadPool;
    }

    public static final f0 f() {
        return new b();
    }
}
