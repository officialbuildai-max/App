package xu;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.transsion.tinker.lib.custom.api.PatchState;
import java.lang.Thread;

/* loaded from: classes7.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f78569a;

    public static void b(final Context context, final b bVar, final ou.c cVar) {
        if (f78569a || context == null || bVar == null || !bVar.f78561a) {
            return;
        }
        synchronized (d.class) {
            try {
                if (f78569a) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: xu.c
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(Thread thread, Throwable th2) {
                        d.c(context, bVar, cVar, defaultUncaughtExceptionHandler, thread, th2);
                    }
                });
                f78569a = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, b bVar, ou.c cVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th2) {
        try {
        } catch (Throwable th3) {
            try {
                ShareTinkerLog.e("Tinker.CrashRollback", "crash monitor error: %s", th3.getMessage());
                if (uncaughtExceptionHandler == null) {
                    return;
                }
            } finally {
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th2);
                }
            }
        }
        if (context == null) {
            ShareTinkerLog.e("Tinker.CrashRollback", "crash monitor skipped: context is null", new Object[0]);
            if (uncaughtExceptionHandler != null) {
                return;
            } else {
                return;
            }
        }
        PatchState e11 = yu.a.e(context);
        String d11 = yu.a.d(context);
        if (e11 == PatchState.INSTALLED && d11 != null && !d11.isEmpty()) {
            int g11 = yu.a.g(context, System.currentTimeMillis(), bVar.f78563c);
            ShareTinkerLog.w("Tinker.CrashRollback", "patch crash count=%d/%d, patchId=%s", Integer.valueOf(g11), Integer.valueOf(bVar.f78562b), d11);
            if (g11 >= bVar.f78562b) {
                a.a(context, d11, "crash_threshold", cVar);
            }
        }
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th2);
    }
}
