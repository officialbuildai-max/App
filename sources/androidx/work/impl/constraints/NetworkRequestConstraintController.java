package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import androidx.work.NetworkType;
import androidx.work.impl.model.j0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class NetworkRequestConstraintController implements androidx.work.impl.constraints.controllers.d {

    /* renamed from: a, reason: collision with root package name */
    private final ConnectivityManager f15666a;

    /* renamed from: b, reason: collision with root package name */
    private final long f15667b;

    public NetworkRequestConstraintController(ConnectivityManager connManager, long j11) {
        Intrinsics.h(connManager, "connManager");
        this.f15666a = connManager;
        this.f15667b = j11;
    }

    public /* synthetic */ NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(connectivityManager, (i11 & 2) != 0 ? 1000L : j11);
    }

    @Override // androidx.work.impl.constraints.controllers.d
    public boolean a(j0 workSpec) {
        Intrinsics.h(workSpec, "workSpec");
        if (c(workSpec)) {
            throw new IllegalStateException("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.d
    public kotlinx.coroutines.flow.b b(androidx.work.d constraints) {
        Intrinsics.h(constraints, "constraints");
        return kotlinx.coroutines.flow.d.e(new NetworkRequestConstraintController$track$1(constraints, this, null));
    }

    @Override // androidx.work.impl.constraints.controllers.d
    public boolean c(j0 workSpec) {
        Intrinsics.h(workSpec, "workSpec");
        return (workSpec.f15855j.d() == null && workSpec.f15855j.f() == NetworkType.NOT_REQUIRED) ? false : true;
    }
}
