package ak;

import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.os.Looper;
import android.os.StatFs;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f702a = new a0();

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f703b;

    private a0() {
    }

    private final boolean b(Context context) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(new StatFs(context.getFilesDir().getAbsolutePath()).getAvailableBytes() >= 67108864));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            lg.a.f68962a.x("WorkManagerStorageGuard", "Unable to read storage state, allow WorkManager scheduling: " + m1188exceptionOrNullimpl.getMessage(), false);
            m1185constructorimpl = Boolean.TRUE;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    private final boolean c(Throwable th2) {
        Throwable th3 = th2;
        while (true) {
            if (th3 == null) {
                while (th2 != null) {
                    if (!(th2 instanceof SQLiteDatabaseLockedException)) {
                        th2 = th2.getCause();
                    }
                }
                return false;
            }
            if (th3 instanceof SQLiteFullException) {
                break;
            }
            th3 = th3.getCause();
        }
        return true;
    }

    private final boolean d(Throwable th2) {
        while (th2 != null) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            Intrinsics.g(stackTrace, "getStackTrace(...)");
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                Intrinsics.g(className, "getClassName(...)");
                if (StringsKt.W(className, "androidx.work.", false, 2, null)) {
                    return true;
                }
            }
            th2 = th2.getCause();
        }
        return false;
    }

    private final boolean e(Throwable th2) {
        if (!c(th2)) {
            Throwable th3 = th2;
            while (true) {
                if (th3 == null) {
                    Throwable th4 = th2;
                    while (true) {
                        if (th4 == null) {
                            while (th2 != null) {
                                if (!(th2 instanceof SQLiteReadOnlyDatabaseException)) {
                                    th2 = th2.getCause();
                                }
                            }
                            return false;
                        }
                        if (th4 instanceof SQLiteDiskIOException) {
                            break;
                        }
                        th4 = th4.getCause();
                    }
                } else {
                    if (th3 instanceof SQLiteCantOpenDatabaseException) {
                        break;
                    }
                    th3 = th3.getCause();
                }
            }
        }
        return true;
    }

    public final boolean a(Context context) {
        Intrinsics.h(context, "context");
        if (f703b) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        return b(applicationContext);
    }

    public final void f(Throwable throwable) {
        Intrinsics.h(throwable, "throwable");
        f703b = true;
        lg.a.f68962a.x("WorkManagerStorageGuard", "WorkManager initialization failed, disable scheduling for current process: " + throwable.getClass().getSimpleName() + " - " + throwable.getMessage(), false);
    }

    public final void g(Throwable throwable) {
        Intrinsics.h(throwable, "throwable");
        Throwable th2 = throwable;
        while (true) {
            if (th2 != null) {
                if (th2 instanceof SQLiteFullException) {
                    break;
                } else {
                    th2 = th2.getCause();
                }
            } else if (!d(throwable) || !e(throwable)) {
                return;
            }
        }
        f703b = true;
    }

    public final boolean h(Throwable throwable) {
        Intrinsics.h(throwable, "throwable");
        Throwable th2 = throwable;
        while (true) {
            if (th2 == null) {
                while (throwable != null) {
                    if (!(throwable instanceof SQLiteDiskIOException)) {
                        throwable = throwable.getCause();
                    }
                }
                return false;
            }
            if (th2 instanceof SQLiteFullException) {
                break;
            }
            th2 = th2.getCause();
        }
        return true;
    }

    public final boolean i(Thread thread, Throwable throwable) {
        Intrinsics.h(thread, "thread");
        Intrinsics.h(throwable, "throwable");
        if (thread == Looper.getMainLooper().getThread()) {
            return false;
        }
        for (Throwable th2 = throwable; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof SQLiteFullException) {
                return true;
            }
        }
        if (!d(throwable)) {
            return false;
        }
        while (throwable != null) {
            if (throwable instanceof SQLiteDatabaseLockedException) {
                return true;
            }
            throwable = throwable.getCause();
        }
        return false;
    }
}
