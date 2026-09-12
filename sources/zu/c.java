package zu;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.transsion.tinker.lib.custom.api.PatchState;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ScheduledExecutorService f79589a = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: zu.b
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread f11;
            f11 = c.f(runnable);
            return f11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledFuture f79590b;

    public static void c(final Context context, long j11) {
        if (context == null || j11 <= 0) {
            return;
        }
        long max = Math.max(1000L, j11);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        d();
        ShareTinkerLog.i("Tinker.StartupWatchdog", "watchdog armed, timeout=%dms", Long.valueOf(max));
        f79590b = f79589a.schedule(new Runnable() { // from class: zu.a
            @Override // java.lang.Runnable
            public final void run() {
                c.e(context);
            }
        }, max, TimeUnit.MILLISECONDS);
    }

    public static void d() {
        ScheduledFuture scheduledFuture = f79590b;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
            ShareTinkerLog.i("Tinker.StartupWatchdog", "watchdog disarmed", new Object[0]);
        }
        f79590b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Context context) {
        try {
            PatchState e11 = yu.a.e(context);
            if (e11 != PatchState.INSTALLED) {
                ShareTinkerLog.i("Tinker.StartupWatchdog", "watchdog fired but state=%s, skip rollback", e11);
                return;
            }
            String d11 = yu.a.d(context);
            ShareTinkerLog.w("Tinker.StartupWatchdog", "startup timeout detected! patchId=%s, triggering rollback", d11);
            xu.a.a(context, d11, "startup_timeout", null);
        } catch (Throwable th2) {
            ShareTinkerLog.e("Tinker.StartupWatchdog", "watchdog error: %s", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread f(Runnable runnable) {
        Thread thread = new Thread(runnable, "tinker-watchdog");
        thread.setDaemon(true);
        return thread;
    }
}
