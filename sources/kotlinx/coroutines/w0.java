package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* loaded from: classes7.dex */
public abstract class w0 {
    public static final void a(DispatchedTask dispatchedTask, int i11) {
        Continuation delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        boolean z10 = i11 == 4;
        if (z10 || !(delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) || b(i11) != b(dispatchedTask.resumeMode)) {
            d(dispatchedTask, delegate$kotlinx_coroutines_core, z10);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
        i0 i0Var = dispatchedContinuation.dispatcher;
        CoroutineContext context = dispatchedContinuation.getContext();
        if (i0Var.isDispatchNeeded(context)) {
            i0Var.dispatch(context, dispatchedTask);
        } else {
            e(dispatchedTask);
        }
    }

    public static final boolean b(int i11) {
        return i11 == 1 || i11 == 2;
    }

    public static final boolean c(int i11) {
        return i11 == 2;
    }

    public static final void d(DispatchedTask dispatchedTask, Continuation continuation, boolean z10) {
        Object successfulResult$kotlinx_coroutines_core;
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Result.Companion companion = Result.INSTANCE;
            successfulResult$kotlinx_coroutines_core = ResultKt.a(exceptionalResult$kotlinx_coroutines_core);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            successfulResult$kotlinx_coroutines_core = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object m1185constructorimpl = Result.m1185constructorimpl(successfulResult$kotlinx_coroutines_core);
        if (!z10) {
            continuation.resumeWith(m1185constructorimpl);
            return;
        }
        Intrinsics.f(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Continuation<T> continuation2 = dispatchedContinuation.continuation;
        Object obj = dispatchedContinuation.countOrElement;
        CoroutineContext context = continuation2.getContext();
        Object i11 = kotlinx.coroutines.internal.g0.i(context, obj);
        q2 m11 = i11 != kotlinx.coroutines.internal.g0.f67978a ? g0.m(continuation2, context, i11) : null;
        try {
            dispatchedContinuation.continuation.resumeWith(m1185constructorimpl);
            Unit unit = Unit.f67184a;
        } finally {
            if (m11 == null || m11.X()) {
                kotlinx.coroutines.internal.g0.f(context, i11);
            }
        }
    }

    private static final void e(DispatchedTask dispatchedTask) {
        e1 b11 = o2.f68027a.b();
        if (b11.isUnconfinedLoopActive()) {
            b11.dispatchUnconfined(dispatchedTask);
            return;
        }
        b11.incrementUseCount(true);
        try {
            d(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (b11.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
    }
}
