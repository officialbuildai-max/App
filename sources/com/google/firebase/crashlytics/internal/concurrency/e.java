package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class e implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f31361a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f31362b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private Task f31363c = Tasks.forResult(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ExecutorService executorService) {
        this.f31361a = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task d(Runnable runnable, Task task) {
        runnable.run();
        return Tasks.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task e(Callable callable, Task task) {
        return (Task) callable.call();
    }

    public ExecutorService c() {
        return this.f31361a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f31361a.execute(runnable);
    }

    public Task f(final Runnable runnable) {
        Task continueWithTask;
        synchronized (this.f31362b) {
            continueWithTask = this.f31363c.continueWithTask(this.f31361a, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.d
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Task d11;
                    d11 = e.d(runnable, task);
                    return d11;
                }
            });
            this.f31363c = continueWithTask;
        }
        return continueWithTask;
    }

    public Task g(final Callable callable) {
        Task continueWithTask;
        synchronized (this.f31362b) {
            continueWithTask = this.f31363c.continueWithTask(this.f31361a, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.c
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Task e11;
                    e11 = e.e(callable, task);
                    return e11;
                }
            });
            this.f31363c = continueWithTask;
        }
        return continueWithTask;
    }
}
