package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.j1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g1 extends Binder {

    /* renamed from: a, reason: collision with root package name */
    private final a f32141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        Task a(Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(a aVar) {
        this.f32141a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final j1.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        Log.isLoggable("FirebaseMessaging", 3);
        this.f32141a.a(aVar.f32163a).addOnCompleteListener(new w3.m(), new OnCompleteListener() { // from class: com.google.firebase.messaging.f1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                j1.a.this.d();
            }
        });
    }
}
