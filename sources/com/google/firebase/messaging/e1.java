package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    static final long f32127a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    private static final Object f32128b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static WakeLock f32129c;

    private static void b(Context context) {
        if (f32129c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f32129c = wakeLock;
            wakeLock.setReferenceCounted(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Intent intent) {
        synchronized (f32128b) {
            try {
                if (f32129c != null && d(intent)) {
                    g(intent, false);
                    f32129c.release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Context context, j1 j1Var, final Intent intent) {
        synchronized (f32128b) {
            try {
                b(context);
                boolean d11 = d(intent);
                g(intent, true);
                if (!d11) {
                    f32129c.acquire(f32127a);
                }
                j1Var.d(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.d1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        e1.c(intent);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void g(Intent intent, boolean z10) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComponentName h(Context context, Intent intent) {
        synchronized (f32128b) {
            try {
                b(context);
                boolean d11 = d(intent);
                g(intent, true);
                ComponentName startService = context.startService(intent);
                if (startService == null) {
                    return null;
                }
                if (!d11) {
                    f32129c.acquire(f32127a);
                }
                return startService;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
