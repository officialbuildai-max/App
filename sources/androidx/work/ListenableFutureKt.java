package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;

/* loaded from: classes2.dex */
public abstract class ListenableFutureKt {
    public static final com.google.common.util.concurrent.r f(final Executor executor, final String debugTag, final Function0 block) {
        Intrinsics.h(executor, "<this>");
        Intrinsics.h(debugTag, "debugTag");
        Intrinsics.h(block, "block");
        com.google.common.util.concurrent.r a11 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.work.p
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                Object g11;
                g11 = ListenableFutureKt.g(executor, debugTag, block, aVar);
                return g11;
            }
        });
        Intrinsics.g(a11, "getFuture(...)");
        return a11;
    }

    public static final Object g(Executor executor, String str, final Function0 function0, final CallbackToFutureAdapter.a completer) {
        Intrinsics.h(completer, "completer");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.a(new Runnable() { // from class: androidx.work.q
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFutureKt.h(atomicBoolean);
            }
        }, DirectExecutor.INSTANCE);
        executor.execute(new Runnable() { // from class: androidx.work.r
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFutureKt.i(atomicBoolean, completer, function0);
            }
        });
        return str;
    }

    public static final void h(AtomicBoolean atomicBoolean) {
        atomicBoolean.set(true);
    }

    public static final void i(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.a aVar, Function0 function0) {
        if (atomicBoolean.get()) {
            return;
        }
        try {
            aVar.c(function0.invoke());
        } catch (Throwable th2) {
            aVar.f(th2);
        }
    }

    public static final com.google.common.util.concurrent.r j(final CoroutineContext context, final CoroutineStart start, final Function2 block) {
        Intrinsics.h(context, "context");
        Intrinsics.h(start, "start");
        Intrinsics.h(block, "block");
        com.google.common.util.concurrent.r a11 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.work.n
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                Object l11;
                l11 = ListenableFutureKt.l(CoroutineContext.this, start, block, aVar);
                return l11;
            }
        });
        Intrinsics.g(a11, "getFuture(...)");
        return a11;
    }

    public static /* synthetic */ com.google.common.util.concurrent.r k(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return j(coroutineContext, coroutineStart, function2);
    }

    public static final Object l(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, CallbackToFutureAdapter.a completer) {
        t1 d11;
        Intrinsics.h(completer, "completer");
        final t1 t1Var = (t1) coroutineContext.get(t1.f68119l1);
        completer.a(new Runnable() { // from class: androidx.work.o
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFutureKt.m(t1.this);
            }
        }, DirectExecutor.INSTANCE);
        d11 = kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(coroutineContext), null, coroutineStart, new ListenableFutureKt$launchFuture$1$2(function2, completer, null), 1, null);
        return d11;
    }

    public static final void m(t1 t1Var) {
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
    }
}
