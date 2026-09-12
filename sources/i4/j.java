package i4;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;
import androidx.work.t;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class j extends BroadcastReceiverConstraintTracker {

    /* renamed from: g, reason: collision with root package name */
    private final ConnectivityManager f65079g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, j4.c taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.h(context, "context");
        Intrinsics.h(taskExecutor, "taskExecutor");
        Object systemService = d().getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f65079g = (ConnectivityManager) systemService;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter k() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void l(Intent intent) {
        String str;
        Intrinsics.h(intent, "intent");
        if (Intrinsics.c(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            t e11 = t.e();
            str = i.f65078a;
            e11.a(str, "Network broadcast received");
            h(i.c(this.f65079g, false));
        }
    }

    @Override // i4.g
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public androidx.work.impl.constraints.g f() {
        return i.c(this.f65079g, false);
    }
}
