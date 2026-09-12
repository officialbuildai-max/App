package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.d;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f32130a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f32131b;

    /* renamed from: c, reason: collision with root package name */
    private final k0 f32132c;

    public f(Context context, k0 k0Var, ExecutorService executorService) {
        this.f32130a = executorService;
        this.f32131b = context;
        this.f32132c = k0Var;
    }

    private boolean b() {
        if (((KeyguardManager) this.f32131b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.isAtLeastLollipop()) {
            SystemClock.sleep(10L);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f32131b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    private void c(d.a aVar) {
        Log.isLoggable("FirebaseMessaging", 3);
        ((NotificationManager) this.f32131b.getSystemService("notification")).notify(aVar.f32116b, aVar.f32117c, aVar.f32115a.c());
    }

    private g0 d() {
        g0 i11 = g0.i(this.f32132c.p("gcm.n.image"));
        if (i11 != null) {
            i11.m(this.f32130a);
        }
        return i11;
    }

    private void e(NotificationCompat.m mVar, g0 g0Var) {
        if (g0Var == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(g0Var.k(), 5L, TimeUnit.SECONDS);
            mVar.A(bitmap);
            mVar.L(new NotificationCompat.j().r(bitmap).q(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            g0Var.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e11) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e11.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            g0Var.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.f32132c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        g0 d11 = d();
        d.a e11 = d.e(this.f32131b, this.f32132c);
        e(e11.f32115a, d11);
        c(e11);
        return true;
    }
}
