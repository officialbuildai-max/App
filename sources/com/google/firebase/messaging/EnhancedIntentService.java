package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.g1;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes.dex */
public abstract class EnhancedIntentService extends Service {

    /* renamed from: b, reason: collision with root package name */
    private Binder f32013b;

    /* renamed from: d, reason: collision with root package name */
    private int f32015d;

    /* renamed from: a, reason: collision with root package name */
    final ExecutorService f32012a = n.d();

    /* renamed from: c, reason: collision with root package name */
    private final Object f32014c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private int f32016e = 0;

    /* loaded from: classes4.dex */
    class a implements g1.a {
        a() {
        }

        @Override // com.google.firebase.messaging.g1.a
        public Task a(Intent intent) {
            return EnhancedIntentService.this.j(intent);
        }
    }

    private void d(Intent intent) {
        if (intent != null) {
            e1.c(intent);
        }
        synchronized (this.f32014c) {
            try {
                int i11 = this.f32016e - 1;
                this.f32016e = i11;
                if (i11 == 0) {
                    k(this.f32015d);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Intent intent, Task task) {
        d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            f(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task j(final Intent intent) {
        if (g(intent)) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f32012a.execute(new Runnable() { // from class: com.google.firebase.messaging.h
            @Override // java.lang.Runnable
            public final void run() {
                EnhancedIntentService.this.i(intent, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    protected Intent e(Intent intent) {
        return intent;
    }

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    boolean k(int i11) {
        return stopSelfResult(i11);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            Log.isLoggable("EnhancedIntentService", 3);
            if (this.f32013b == null) {
                this.f32013b = new g1(new a());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f32013b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f32012a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i11, int i12) {
        synchronized (this.f32014c) {
            this.f32015d = i12;
            this.f32016e++;
        }
        Intent e11 = e(intent);
        if (e11 == null) {
            d(intent);
            return 2;
        }
        Task j11 = j(e11);
        if (j11.isComplete()) {
            d(intent);
            return 2;
        }
        j11.addOnCompleteListener(new w3.m(), new OnCompleteListener() { // from class: com.google.firebase.messaging.g
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                EnhancedIntentService.this.h(intent, task);
            }
        });
        return 3;
    }
}
