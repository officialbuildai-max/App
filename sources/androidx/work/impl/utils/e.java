package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.f1;
import androidx.work.impl.model.k0;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class e {
    private static final void d(f1 f1Var, String str) {
        WorkDatabase t11 = f1Var.t();
        Intrinsics.g(t11, "getWorkDatabase(...)");
        j(t11, str);
        androidx.work.impl.s q11 = f1Var.q();
        Intrinsics.g(q11, "getProcessor(...)");
        q11.s(str, 1);
        Iterator it = f1Var.r().iterator();
        while (it.hasNext()) {
            ((androidx.work.impl.u) it.next()).a(str);
        }
    }

    public static final androidx.work.w e(final UUID id2, final f1 workManagerImpl) {
        Intrinsics.h(id2, "id");
        Intrinsics.h(workManagerImpl, "workManagerImpl");
        androidx.work.f0 n11 = workManagerImpl.m().n();
        j4.a c11 = workManagerImpl.u().c();
        Intrinsics.g(c11, "getSerialTaskExecutor(...)");
        return androidx.work.a0.c(n11, "CancelWorkById", c11, new Function0() { // from class: androidx.work.impl.utils.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit f11;
                f11 = e.f(f1.this, id2);
                return f11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(final f1 f1Var, final UUID uuid) {
        WorkDatabase t11 = f1Var.t();
        Intrinsics.g(t11, "getWorkDatabase(...)");
        t11.a0(new Runnable() { // from class: androidx.work.impl.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                e.g(f1.this, uuid);
            }
        });
        k(f1Var);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(f1 f1Var, UUID uuid) {
        String uuid2 = uuid.toString();
        Intrinsics.g(uuid2, "toString(...)");
        d(f1Var, uuid2);
    }

    public static final void h(final String name, final f1 workManagerImpl) {
        Intrinsics.h(name, "name");
        Intrinsics.h(workManagerImpl, "workManagerImpl");
        final WorkDatabase t11 = workManagerImpl.t();
        Intrinsics.g(t11, "getWorkDatabase(...)");
        t11.a0(new Runnable() { // from class: androidx.work.impl.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                e.i(WorkDatabase.this, name, workManagerImpl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(WorkDatabase workDatabase, String str, f1 f1Var) {
        Iterator it = workDatabase.l0().h(str).iterator();
        while (it.hasNext()) {
            d(f1Var, (String) it.next());
        }
    }

    private static final void j(WorkDatabase workDatabase, String str) {
        k0 l02 = workDatabase.l0();
        androidx.work.impl.model.b g02 = workDatabase.g0();
        List q11 = CollectionsKt.q(str);
        while (!q11.isEmpty()) {
            String str2 = (String) CollectionsKt.L(q11);
            WorkInfo.State i11 = l02.i(str2);
            if (i11 != WorkInfo.State.SUCCEEDED && i11 != WorkInfo.State.FAILED) {
                l02.k(str2);
            }
            q11.addAll(g02.b(str2));
        }
    }

    private static final void k(f1 f1Var) {
        androidx.work.impl.x.h(f1Var.m(), f1Var.t(), f1Var.r());
    }
}
