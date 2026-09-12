package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.t;
import i4.e;
import i4.g;
import j4.c;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class BroadcastReceiverConstraintTracker extends g {

    /* renamed from: f, reason: collision with root package name */
    private final BroadcastReceiver f15713f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastReceiverConstraintTracker(Context context, c taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.h(context, "context");
        Intrinsics.h(taskExecutor, "taskExecutor");
        this.f15713f = new BroadcastReceiver() { // from class: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$broadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.h(context2, "context");
                Intrinsics.h(intent, "intent");
                BroadcastReceiverConstraintTracker.this.l(intent);
            }
        };
    }

    @Override // i4.g
    public void i() {
        String str;
        t e11 = t.e();
        str = e.f65069a;
        e11.a(str, getClass().getSimpleName() + ": registering receiver");
        d().registerReceiver(this.f15713f, k());
    }

    @Override // i4.g
    public void j() {
        String str;
        t e11 = t.e();
        str = e.f65069a;
        e11.a(str, getClass().getSimpleName() + ": unregistering receiver");
        d().unregisterReceiver(this.f15713f);
    }

    public abstract IntentFilter k();

    public abstract void l(Intent intent);
}
