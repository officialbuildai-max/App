package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class SerialExecutorImpl implements j4.a {

    /* renamed from: b, reason: collision with root package name */
    private final Executor f16018b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f16019c;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayDeque f16017a = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    final Object f16020d = new Object();

    /* loaded from: classes.dex */
    static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutorImpl mSerialExecutor;

        Task(SerialExecutorImpl serialExecutorImpl, Runnable runnable) {
            this.mSerialExecutor = serialExecutorImpl;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mRunnable.run();
                synchronized (this.mSerialExecutor.f16020d) {
                    this.mSerialExecutor.a();
                }
            } catch (Throwable th2) {
                synchronized (this.mSerialExecutor.f16020d) {
                    this.mSerialExecutor.a();
                    throw th2;
                }
            }
        }
    }

    public SerialExecutorImpl(Executor executor) {
        this.f16018b = executor;
    }

    void a() {
        Runnable runnable = (Runnable) this.f16017a.poll();
        this.f16019c = runnable;
        if (runnable != null) {
            this.f16018b.execute(runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f16020d) {
            try {
                this.f16017a.add(new Task(this, runnable));
                if (this.f16019c == null) {
                    a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
