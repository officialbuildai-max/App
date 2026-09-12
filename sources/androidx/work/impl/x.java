package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16099a = androidx.work.t.i("Schedulers");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u c(Context context, WorkDatabase workDatabase, androidx.work.b bVar) {
        h4.q qVar = new h4.q(context, workDatabase, bVar);
        androidx.work.impl.utils.y.c(context, SystemJobService.class, true);
        androidx.work.t.e().a(f16099a, "Created SystemJobScheduler and enabled SystemJobService");
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(List list, androidx.work.impl.model.x xVar, androidx.work.b bVar, WorkDatabase workDatabase) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((u) it.next()).a(xVar.b());
        }
        h(bVar, workDatabase, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Executor executor, final List list, final androidx.work.b bVar, final WorkDatabase workDatabase, final androidx.work.impl.model.x xVar, boolean z10) {
        executor.execute(new Runnable() { // from class: androidx.work.impl.w
            @Override // java.lang.Runnable
            public final void run() {
                x.d(list, xVar, bVar, workDatabase);
            }
        });
    }

    private static void f(androidx.work.impl.model.k0 k0Var, androidx.work.a aVar, List list) {
        if (list.size() > 0) {
            long currentTimeMillis = aVar.currentTimeMillis();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k0Var.o(((androidx.work.impl.model.j0) it.next()).f15846a, currentTimeMillis);
            }
        }
    }

    public static void g(final List list, s sVar, final Executor executor, final WorkDatabase workDatabase, final androidx.work.b bVar) {
        sVar.e(new e() { // from class: androidx.work.impl.v
            @Override // androidx.work.impl.e
            public final void c(androidx.work.impl.model.x xVar, boolean z10) {
                x.e(executor, list, bVar, workDatabase, xVar, z10);
            }
        });
    }

    public static void h(androidx.work.b bVar, WorkDatabase workDatabase, List list) {
        List list2;
        if (list == null || list.size() == 0) {
            return;
        }
        androidx.work.impl.model.k0 l02 = workDatabase.l0();
        workDatabase.k();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                list2 = l02.w();
                f(l02, bVar.a(), list2);
            } else {
                list2 = null;
            }
            List r11 = l02.r(bVar.h());
            f(l02, bVar.a(), r11);
            if (list2 != null) {
                r11.addAll(list2);
            }
            List m11 = l02.m(200);
            workDatabase.e0();
            workDatabase.t();
            if (r11.size() > 0) {
                androidx.work.impl.model.j0[] j0VarArr = (androidx.work.impl.model.j0[]) r11.toArray(new androidx.work.impl.model.j0[r11.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    u uVar = (u) it.next();
                    if (uVar.d()) {
                        uVar.b(j0VarArr);
                    }
                }
            }
            if (m11.size() > 0) {
                androidx.work.impl.model.j0[] j0VarArr2 = (androidx.work.impl.model.j0[]) m11.toArray(new androidx.work.impl.model.j0[m11.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    u uVar2 = (u) it2.next();
                    if (!uVar2.d()) {
                        uVar2.b(j0VarArr2);
                    }
                }
            }
        } catch (Throwable th2) {
            workDatabase.t();
            throw th2;
        }
    }
}
