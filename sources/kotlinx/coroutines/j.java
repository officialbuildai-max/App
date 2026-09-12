package kotlinx.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: classes7.dex */
public abstract /* synthetic */ class j {
    public static final Object a(CoroutineContext coroutineContext, Function2 function2) {
        e1 a11;
        CoroutineContext k11;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.INSTANCE);
        if (continuationInterceptor == null) {
            a11 = o2.f68027a.b();
            k11 = g0.k(n1.f68024a, coroutineContext.plus(a11));
        } else {
            e1 e1Var = continuationInterceptor instanceof e1 ? (e1) continuationInterceptor : null;
            if (e1Var != null) {
                e1 e1Var2 = e1Var.shouldBeProcessedFromContext() ? e1Var : null;
                if (e1Var2 != null) {
                    a11 = e1Var2;
                    k11 = g0.k(n1.f68024a, coroutineContext);
                }
            }
            a11 = o2.f68027a.a();
            k11 = g0.k(n1.f68024a, coroutineContext);
        }
        g gVar = new g(k11, currentThread, a11);
        gVar.start(CoroutineStart.DEFAULT, gVar, function2);
        return gVar.X();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return i.e(coroutineContext, function2);
    }
}
