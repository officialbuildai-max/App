package androidx.work.impl.constraints;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import androidx.work.impl.model.j0;
import androidx.work.t;
import i4.n;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;

/* loaded from: classes2.dex */
public abstract class WorkConstraintsTrackerKt {

    /* renamed from: a */
    private static final String f15671a;

    static {
        String i11 = t.i("WorkConstraintsTracker");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f15671a = i11;
    }

    public static final NetworkRequestConstraintController a(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return new NetworkRequestConstraintController((ConnectivityManager) systemService, 0L, 2, null);
    }

    public static final /* synthetic */ List b(n nVar) {
        return d(nVar);
    }

    public static final /* synthetic */ String c() {
        return f15671a;
    }

    public static final List d(n nVar) {
        List q11 = CollectionsKt.q(new androidx.work.impl.constraints.controllers.b(nVar.a()), new androidx.work.impl.constraints.controllers.c(nVar.b()), new androidx.work.impl.constraints.controllers.i(nVar.e()));
        if (Build.VERSION.SDK_INT >= 28) {
            q11.add(a(nVar.c()));
        } else {
            i4.g d11 = nVar.d();
            Intrinsics.e(d11);
            q11.addAll(CollectionsKt.o(new androidx.work.impl.constraints.controllers.e(d11), new androidx.work.impl.constraints.controllers.h(nVar.d()), new androidx.work.impl.constraints.controllers.g(nVar.d()), new androidx.work.impl.constraints.controllers.f(nVar.d())));
        }
        return q11;
    }

    public static final t1 e(WorkConstraintsTracker workConstraintsTracker, j0 spec, i0 dispatcher, h listener) {
        t1 d11;
        Intrinsics.h(workConstraintsTracker, "<this>");
        Intrinsics.h(spec, "spec");
        Intrinsics.h(dispatcher, "dispatcher");
        Intrinsics.h(listener, "listener");
        d11 = kotlinx.coroutines.k.d(o0.a(dispatcher), null, null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, spec, listener, null), 3, null);
        return d11;
    }
}
