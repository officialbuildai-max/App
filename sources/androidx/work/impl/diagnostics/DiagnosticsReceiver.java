package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;
import androidx.work.t;
import androidx.work.v;

/* loaded from: classes2.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15719a = t.i("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        t.e().a(f15719a, "Requesting diagnostics");
        try {
            WorkManager.f(context).c(v.e(DiagnosticsWorker.class));
        } catch (IllegalStateException e11) {
            t.e().d(f15719a, "WorkManager is not initialized", e11);
        }
    }
}
