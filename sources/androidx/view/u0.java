package androidx.view;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import q1.a;
import q1.b;
import q1.e;

/* loaded from: classes.dex */
public abstract class u0 {

    /* renamed from: a, reason: collision with root package name */
    private static final e f9730a = new e();

    public static final n0 a(t0 t0Var) {
        a aVar;
        Intrinsics.h(t0Var, "<this>");
        synchronized (f9730a) {
            aVar = (a) t0Var.getCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if (aVar == null) {
                aVar = b.a();
                t0Var.addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", aVar);
            }
        }
        return aVar;
    }
}
