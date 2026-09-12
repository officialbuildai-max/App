package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import androidx.view.LifecycleService;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.t;

/* loaded from: classes2.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f15760e = t.i("SystemFgService");

    /* renamed from: f, reason: collision with root package name */
    private static SystemForegroundService f15761f = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f15762b;

    /* renamed from: c, reason: collision with root package name */
    SystemForegroundDispatcher f15763c;

    /* renamed from: d, reason: collision with root package name */
    NotificationManager f15764d;

    /* loaded from: classes2.dex */
    static class a {
        static void a(Service service, int i11, Notification notification, int i12) {
            service.startForeground(i11, notification, i12);
        }
    }

    /* loaded from: classes2.dex */
    static class b {
        static void a(Service service, int i11, Notification notification, int i12) {
            try {
                service.startForeground(i11, notification, i12);
            } catch (ForegroundServiceStartNotAllowedException e11) {
                t.e().l(SystemForegroundService.f15760e, "Unable to start foreground service", e11);
            } catch (SecurityException e12) {
                t.e().l(SystemForegroundService.f15760e, "Unable to start foreground service", e12);
            }
        }
    }

    private void f() {
        this.f15764d = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.f15763c = systemForegroundDispatcher;
        systemForegroundDispatcher.o(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void a(int i11, Notification notification) {
        this.f15764d.notify(i11, notification);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void b(int i11) {
        this.f15762b = true;
        t.e().a(f15760e, "Shutting down.");
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f15761f = null;
        stopSelf(i11);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void c(int i11, int i12, Notification notification) {
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 31) {
            b.a(this, i11, notification, i12);
        } else if (i13 >= 29) {
            a.a(this, i11, notification, i12);
        } else {
            startForeground(i11, notification);
        }
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.a
    public void d(int i11) {
        this.f15764d.cancel(i11);
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f15761f = this;
        f();
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f15763c.l();
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        super.onStartCommand(intent, i11, i12);
        if (this.f15762b) {
            t.e().f(f15760e, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f15763c.l();
            f();
            this.f15762b = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f15763c.m(intent, i12);
        return 3;
    }

    @Override // android.app.Service
    public void onTimeout(int i11) {
        if (Build.VERSION.SDK_INT >= 35) {
            return;
        }
        this.f15763c.n(i11, 2048);
    }

    public void onTimeout(int i11, int i12) {
        this.f15763c.n(i11, i12);
    }
}
