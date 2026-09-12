package androidx.work.impl;

import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.impl.model.j0;
import androidx.work.impl.model.v1;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class m1 {
    public static final androidx.work.w e(final f1 f1Var, final String name, final androidx.work.i0 workRequest) {
        Intrinsics.h(f1Var, "<this>");
        Intrinsics.h(name, "name");
        Intrinsics.h(workRequest, "workRequest");
        androidx.work.f0 n11 = f1Var.m().n();
        String str = "enqueueUniquePeriodic_" + name;
        j4.a c11 = f1Var.u().c();
        Intrinsics.g(c11, "getSerialTaskExecutor(...)");
        return androidx.work.a0.c(n11, str, c11, new Function0() { // from class: androidx.work.impl.i1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit f11;
                f11 = m1.f(f1.this, name, workRequest);
                return f11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(final f1 f1Var, final String str, final androidx.work.i0 i0Var) {
        Function0 function0 = new Function0() { // from class: androidx.work.impl.j1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit g11;
                g11 = m1.g(androidx.work.i0.this, f1Var, str);
                return g11;
            }
        };
        androidx.work.impl.model.k0 l02 = f1Var.t().l0();
        List p11 = l02.p(str);
        if (p11.size() > 1) {
            throw new UnsupportedOperationException("Can't apply UPDATE policy to the chains of work.");
        }
        j0.b bVar = (j0.b) CollectionsKt.k0(p11);
        if (bVar == null) {
            function0.invoke();
            return Unit.f67184a;
        }
        androidx.work.impl.model.j0 j11 = l02.j(bVar.f15871a);
        if (j11 == null) {
            throw new IllegalStateException("WorkSpec with " + bVar.f15871a + ", that matches a name \"" + str + "\", wasn't found");
        }
        if (!j11.o()) {
            throw new UnsupportedOperationException("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
        }
        if (bVar.f15872b == WorkInfo.State.CANCELLED) {
            l02.b(bVar.f15871a);
            function0.invoke();
            return Unit.f67184a;
        }
        androidx.work.impl.model.j0 e11 = androidx.work.impl.model.j0.e(i0Var.d(), bVar.f15871a, null, null, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554430, null);
        s q11 = f1Var.q();
        Intrinsics.g(q11, "getProcessor(...)");
        WorkDatabase t11 = f1Var.t();
        Intrinsics.g(t11, "getWorkDatabase(...)");
        androidx.work.b m11 = f1Var.m();
        Intrinsics.g(m11, "<get-configuration>(...)");
        List r11 = f1Var.r();
        Intrinsics.g(r11, "getSchedulers(...)");
        h(q11, t11, m11, r11, e11, i0Var.c());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(androidx.work.i0 i0Var, f1 f1Var, String str) {
        androidx.work.impl.utils.f.b(new e0(f1Var, str, ExistingWorkPolicy.KEEP, CollectionsKt.e(i0Var)));
        return Unit.f67184a;
    }

    private static final WorkManager.UpdateResult h(s sVar, final WorkDatabase workDatabase, androidx.work.b bVar, final List list, final androidx.work.impl.model.j0 j0Var, final Set set) {
        final String str = j0Var.f15846a;
        final androidx.work.impl.model.j0 j11 = workDatabase.l0().j(str);
        if (j11 == null) {
            throw new IllegalArgumentException("Worker with " + str + " doesn't exist");
        }
        if (j11.f15847b.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        }
        if (j11.o() ^ j0Var.o()) {
            Function1 function1 = new Function1() { // from class: androidx.work.impl.k1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    String i11;
                    i11 = m1.i((androidx.work.impl.model.j0) obj);
                    return i11;
                }
            };
            throw new UnsupportedOperationException("Can't update " + ((String) function1.invoke(j11)) + " Worker to " + ((String) function1.invoke(j0Var)) + " Worker. Update operation must preserve worker's type.");
        }
        final boolean k11 = sVar.k(str);
        if (!k11) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((u) it.next()).a(str);
            }
        }
        workDatabase.a0(new Runnable() { // from class: androidx.work.impl.l1
            @Override // java.lang.Runnable
            public final void run() {
                m1.j(WorkDatabase.this, j11, j0Var, list, str, set, k11);
            }
        });
        if (!k11) {
            x.h(bVar, workDatabase, list);
        }
        return k11 ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(androidx.work.impl.model.j0 spec) {
        Intrinsics.h(spec, "spec");
        return spec.o() ? "Periodic" : "OneTime";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(WorkDatabase workDatabase, androidx.work.impl.model.j0 j0Var, androidx.work.impl.model.j0 j0Var2, List list, String str, Set set, boolean z10) {
        androidx.work.impl.model.k0 l02 = workDatabase.l0();
        v1 m02 = workDatabase.m0();
        androidx.work.impl.model.j0 e11 = androidx.work.impl.model.j0.e(j0Var2, null, j0Var.f15847b, null, null, null, null, 0L, 0L, 0L, null, j0Var.f15856k, null, 0L, j0Var.f15859n, 0L, 0L, false, null, j0Var.j(), j0Var.g() + 1, j0Var.h(), j0Var.i(), 0, null, null, 29613053, null);
        if (j0Var2.i() == 1) {
            e11.p(j0Var2.h());
            e11.q(e11.i() + 1);
        }
        l02.c(androidx.work.impl.utils.g.d(list, e11));
        m02.b(str);
        m02.d(str, set);
        if (z10) {
            return;
        }
        l02.o(str, -1L);
        workDatabase.k0().b(str);
    }
}
