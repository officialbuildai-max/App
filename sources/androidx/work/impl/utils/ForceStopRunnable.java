package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.f1;
import androidx.work.impl.h0;
import androidx.work.impl.model.j0;
import androidx.work.impl.model.k0;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.mvel2.ast.ASTNode;

/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {
    static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300;
    static final int MAX_ATTEMPTS = 3;
    private static final String TAG = androidx.work.t.i("ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    private final Context mContext;
    private final z mPreferenceUtils;
    private int mRetryCount = 0;
    private final f1 mWorkManager;

    /* loaded from: classes2.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private static final String f16011a = androidx.work.t.i("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !ForceStopRunnable.ACTION_FORCE_STOP_RESCHEDULE.equals(intent.getAction())) {
                return;
            }
            androidx.work.t.e().j(f16011a, "Rescheduling alarm that keeps track of force-stops.");
            ForceStopRunnable.setAlarm(context);
        }
    }

    public ForceStopRunnable(Context context, f1 f1Var) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = f1Var;
        this.mPreferenceUtils = f1Var.p();
    }

    static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return intent;
    }

    private static PendingIntent getPendingIntent(Context context, int i11) {
        return PendingIntent.getBroadcast(context, -1, getIntent(context), i11);
    }

    static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = getPendingIntent(context, Build.VERSION.SDK_INT >= 31 ? 167772160 : ASTNode.NOJIT);
        long currentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, pendingIntent);
        }
    }

    public boolean cleanUp() {
        boolean i11 = h4.q.i(this.mContext, this.mWorkManager.t());
        WorkDatabase t11 = this.mWorkManager.t();
        k0 l02 = t11.l0();
        androidx.work.impl.model.e0 k02 = t11.k0();
        t11.k();
        try {
            List<j0> v11 = l02.v();
            boolean z10 = (v11 == null || v11.isEmpty()) ? false : true;
            if (z10) {
                for (j0 j0Var : v11) {
                    l02.s(WorkInfo.State.ENQUEUED, j0Var.f15846a);
                    l02.a(j0Var.f15846a, -512);
                    l02.o(j0Var.f15846a, -1L);
                }
            }
            k02.c();
            t11.e0();
            t11.t();
            return z10 || i11;
        } catch (Throwable th2) {
            t11.t();
            throw th2;
        }
    }

    public void forceStopRunnable() {
        boolean cleanUp = cleanUp();
        if (shouldRescheduleWorkers()) {
            androidx.work.t.e().a(TAG, "Rescheduling Workers.");
            this.mWorkManager.x();
            this.mWorkManager.p().e(false);
        } else if (isForceStopped()) {
            androidx.work.t.e().a(TAG, "Application was force-stopped, rescheduling.");
            this.mWorkManager.x();
            this.mPreferenceUtils.d(this.mWorkManager.m().a().currentTimeMillis());
        } else if (cleanUp) {
            androidx.work.t.e().a(TAG, "Found unfinished work, scheduling it.");
            androidx.work.impl.x.h(this.mWorkManager.m(), this.mWorkManager.t(), this.mWorkManager.r());
        }
    }

    public boolean isForceStopped() {
        List historicalProcessExitReasons;
        int reason;
        long timestamp;
        try {
            int i11 = Build.VERSION.SDK_INT;
            PendingIntent pendingIntent = getPendingIntent(this.mContext, i11 >= 31 ? 570425344 : ASTNode.DISCARD);
            if (i11 >= 30) {
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                historicalProcessExitReasons = ((ActivityManager) this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    long a11 = this.mPreferenceUtils.a();
                    for (int i12 = 0; i12 < historicalProcessExitReasons.size(); i12++) {
                        ApplicationExitInfo a12 = i.a(historicalProcessExitReasons.get(i12));
                        reason = a12.getReason();
                        if (reason == 10) {
                            timestamp = a12.getTimestamp();
                            if (timestamp >= a11) {
                                return true;
                            }
                        }
                    }
                }
            } else if (pendingIntent == null) {
                setAlarm(this.mContext);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e11) {
            e = e11;
            androidx.work.t.e().l(TAG, "Ignoring exception", e);
            return true;
        } catch (SecurityException e12) {
            e = e12;
            androidx.work.t.e().l(TAG, "Ignoring exception", e);
            return true;
        }
    }

    public boolean multiProcessChecks() {
        androidx.work.b m11 = this.mWorkManager.m();
        if (TextUtils.isEmpty(m11.c())) {
            androidx.work.t.e().a(TAG, "The default process name was not specified.");
            return true;
        }
        boolean b11 = a0.b(this.mContext, m11);
        androidx.work.t.e().a(TAG, "Is default app process = " + b11);
        return b11;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i11;
        try {
            if (multiProcessChecks()) {
                while (true) {
                    try {
                        h0.c(this.mContext);
                        androidx.work.t.e().a(TAG, "Performing cleanup operations.");
                        try {
                            forceStopRunnable();
                            break;
                        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteFullException | SQLiteTableLockedException e11) {
                            i11 = this.mRetryCount + 1;
                            this.mRetryCount = i11;
                            if (i11 >= 3) {
                                String str = androidx.core.os.t.a(this.mContext) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                                androidx.work.t e12 = androidx.work.t.e();
                                String str2 = TAG;
                                e12.d(str2, str, e11);
                                IllegalStateException illegalStateException = new IllegalStateException(str, e11);
                                androidx.core.util.a e13 = this.mWorkManager.m().e();
                                if (e13 == null) {
                                    throw illegalStateException;
                                }
                                androidx.work.t.e().b(str2, "Routing exception to the specified exception handler", illegalStateException);
                                e13.accept(illegalStateException);
                            } else {
                                long j11 = i11 * BACKOFF_DURATION_MS;
                                androidx.work.t.e().b(TAG, "Retrying after " + j11, e11);
                                sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
                            }
                        }
                        long j112 = i11 * BACKOFF_DURATION_MS;
                        androidx.work.t.e().b(TAG, "Retrying after " + j112, e11);
                        sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
                    } catch (SQLiteException e14) {
                        androidx.work.t.e().c(TAG, "Unexpected SQLite exception during migrations");
                        IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e14);
                        androidx.core.util.a e15 = this.mWorkManager.m().e();
                        if (e15 == null) {
                            throw illegalStateException2;
                        }
                        e15.accept(illegalStateException2);
                    }
                }
            }
        } finally {
            this.mWorkManager.w();
        }
    }

    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.p().b();
    }

    public void sleep(long j11) {
        try {
            Thread.sleep(j11);
        } catch (InterruptedException unused) {
        }
    }
}
