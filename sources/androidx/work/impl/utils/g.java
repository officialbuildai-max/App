package androidx.work.impl.utils;

import android.os.Build;
import androidx.work.f;
import androidx.work.i0;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.j0;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class g {
    public static final void a(WorkDatabase workDatabase, androidx.work.b configuration, androidx.work.impl.e0 continuation) {
        int i11;
        Intrinsics.h(workDatabase, "workDatabase");
        Intrinsics.h(configuration, "configuration");
        Intrinsics.h(continuation, "continuation");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        List q11 = CollectionsKt.q(continuation);
        int i12 = 0;
        while (!q11.isEmpty()) {
            androidx.work.impl.e0 e0Var = (androidx.work.impl.e0) CollectionsKt.L(q11);
            List g11 = e0Var.g();
            Intrinsics.g(g11, "getWork(...)");
            List list = g11;
            if ((list instanceof Collection) && list.isEmpty()) {
                i11 = 0;
            } else {
                Iterator it = list.iterator();
                i11 = 0;
                while (it.hasNext()) {
                    if (((i0) it.next()).d().f15855j.g() && (i11 = i11 + 1) < 0) {
                        CollectionsKt.t();
                    }
                }
            }
            i12 += i11;
            List f11 = e0Var.f();
            if (f11 != null) {
                q11.addAll(f11);
            }
        }
        if (i12 == 0) {
            return;
        }
        int A = workDatabase.l0().A();
        int b11 = configuration.b();
        if (A + i12 <= b11) {
            return;
        }
        throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: " + b11 + ";\nalready enqueued count: " + A + ";\ncurrent enqueue operation count: " + i12 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
    }

    public static final j0 b(j0 workSpec) {
        Intrinsics.h(workSpec, "workSpec");
        androidx.work.d dVar = workSpec.f15855j;
        String str = workSpec.f15848c;
        if (Intrinsics.c(str, ConstraintTrackingWorker.class.getName())) {
            return workSpec;
        }
        if (!dVar.h() && !dVar.k()) {
            return workSpec;
        }
        androidx.work.f a11 = new f.a().c(workSpec.f15850e).f("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str).a();
        String name = ConstraintTrackingWorker.class.getName();
        Intrinsics.g(name, "getName(...)");
        return j0.e(workSpec, null, null, name, null, a11, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554411, null);
    }

    public static final j0 c(j0 workSpec) {
        Intrinsics.h(workSpec, "workSpec");
        boolean h11 = workSpec.f15850e.h("androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME", String.class);
        boolean h12 = workSpec.f15850e.h("androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME", String.class);
        boolean h13 = workSpec.f15850e.h("androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME", String.class);
        if (h11 || !h12 || !h13) {
            return workSpec;
        }
        return j0.e(workSpec, null, null, "androidx.work.multiprocess.RemoteListenableDelegatingWorker", null, new f.a().c(workSpec.f15850e).f("androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME", workSpec.f15848c).a(), null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554411, null);
    }

    public static final j0 d(List schedulers, j0 workSpec) {
        Intrinsics.h(schedulers, "schedulers");
        Intrinsics.h(workSpec, "workSpec");
        j0 c11 = c(workSpec);
        return Build.VERSION.SDK_INT <= 25 ? b(c11) : c11;
    }
}
