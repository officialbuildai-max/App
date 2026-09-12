package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class u0 {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f32219a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f32220b = new androidx.collection.a();

    /* loaded from: classes4.dex */
    interface a {
        Task start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(Executor executor) {
        this.f32219a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task c(String str, Task task) {
        synchronized (this) {
            this.f32220b.remove(str);
        }
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Task b(final String str, a aVar) {
        Task task = (Task) this.f32220b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Joining ongoing request for: ");
                sb2.append(str);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Making new request for: ");
            sb3.append(str);
        }
        Task continueWithTask = aVar.start().continueWithTask(this.f32219a, new Continuation() { // from class: com.google.firebase.messaging.t0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Task c11;
                c11 = u0.this.c(str, task2);
                return c11;
            }
        });
        this.f32220b.put(str, continueWithTask);
        return continueWithTask;
    }
}
