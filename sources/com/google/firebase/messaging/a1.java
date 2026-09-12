package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class a1 {

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference f32092d;

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f32093a;

    /* renamed from: b, reason: collision with root package name */
    private x0 f32094b;

    /* renamed from: c, reason: collision with root package name */
    private final Executor f32095c;

    private a1(SharedPreferences sharedPreferences, Executor executor) {
        this.f32095c = executor;
        this.f32093a = sharedPreferences;
    }

    public static synchronized a1 b(Context context, Executor executor) {
        a1 a1Var;
        synchronized (a1.class) {
            try {
                WeakReference weakReference = f32092d;
                a1Var = weakReference != null ? (a1) weakReference.get() : null;
                if (a1Var == null) {
                    a1Var = new a1(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                    a1Var.d();
                    f32092d = new WeakReference(a1Var);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return a1Var;
    }

    private synchronized void d() {
        this.f32094b = x0.d(this.f32093a, "topic_operation_queue", ",", this.f32095c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean a(z0 z0Var) {
        return this.f32094b.b(z0Var.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized z0 c() {
        return z0.a(this.f32094b.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean e(z0 z0Var) {
        return this.f32094b.g(z0Var.e());
    }
}
