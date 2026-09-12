package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static final Map f32548d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f32549e = new w3.m();

    /* renamed from: a, reason: collision with root package name */
    private final Executor f32550a;

    /* renamed from: b, reason: collision with root package name */
    private final r f32551b;

    /* renamed from: c, reason: collision with root package name */
    private Task f32552c = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements OnSuccessListener, OnFailureListener, OnCanceledListener {

        /* renamed from: a, reason: collision with root package name */
        private final CountDownLatch f32553a;

        private b() {
            this.f32553a = new CountDownLatch(1);
        }

        public boolean a(long j11, TimeUnit timeUnit) {
            return this.f32553a.await(j11, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            this.f32553a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.f32553a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(Object obj) {
            this.f32553a.countDown();
        }
    }

    private e(Executor executor, r rVar) {
        this.f32550a = executor;
        this.f32551b = rVar;
    }

    private static Object c(Task task, long j11, TimeUnit timeUnit) {
        b bVar = new b();
        Executor executor = f32549e;
        task.addOnSuccessListener(executor, bVar);
        task.addOnFailureListener(executor, bVar);
        task.addOnCanceledListener(executor, bVar);
        if (!bVar.a(j11, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static synchronized e h(Executor executor, r rVar) {
        e eVar;
        synchronized (e.class) {
            try {
                String b11 = rVar.b();
                Map map = f32548d;
                if (!map.containsKey(b11)) {
                    map.put(b11, new e(executor, rVar));
                }
                eVar = (e) map.get(b11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void i(f fVar) {
        return this.f32551b.e(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task j(boolean z10, f fVar, Void r32) {
        if (z10) {
            m(fVar);
        }
        return Tasks.forResult(fVar);
    }

    private synchronized void m(f fVar) {
        this.f32552c = Tasks.forResult(fVar);
    }

    public void d() {
        synchronized (this) {
            this.f32552c = Tasks.forResult(null);
        }
        this.f32551b.a();
    }

    public synchronized Task e() {
        try {
            Task task = this.f32552c;
            if (task != null) {
                if (task.isComplete() && !this.f32552c.isSuccessful()) {
                }
            }
            Executor executor = this.f32550a;
            final r rVar = this.f32551b;
            Objects.requireNonNull(rVar);
            this.f32552c = Tasks.call(executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return r.this.d();
                }
            });
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f32552c;
    }

    public f f() {
        return g(5L);
    }

    f g(long j11) {
        synchronized (this) {
            try {
                Task task = this.f32552c;
                if (task == null || !task.isSuccessful()) {
                    try {
                        return (f) c(e(), j11, TimeUnit.SECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                        return null;
                    }
                }
                return (f) this.f32552c.getResult();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Task k(f fVar) {
        return l(fVar, true);
    }

    public Task l(final f fVar, final boolean z10) {
        return Tasks.call(this.f32550a, new Callable() { // from class: com.google.firebase.remoteconfig.internal.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void i11;
                i11 = e.this.i(fVar);
                return i11;
            }
        }).onSuccessTask(this.f32550a, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task j11;
                j11 = e.this.j(z10, fVar, (Void) obj);
                return j11;
            }
        });
    }
}
