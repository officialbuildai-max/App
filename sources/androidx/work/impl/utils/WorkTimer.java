package androidx.work.impl.utils;

/* loaded from: classes2.dex */
public abstract class WorkTimer {

    /* loaded from: classes2.dex */
    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final androidx.work.impl.model.x mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(WorkTimer workTimer, androidx.work.impl.model.x xVar) {
            this.mWorkGenerationalId = xVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
