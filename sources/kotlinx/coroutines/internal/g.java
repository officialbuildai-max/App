package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.t1;

/* loaded from: classes7.dex */
public abstract class g {

    /* renamed from: a */
    private static final z f67976a = new z("UNDEFINED");

    /* renamed from: b */
    public static final z f67977b = new z("REUSABLE_CLAIMED");

    public static final void b(Continuation continuation, Object obj) {
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Object b11 = kotlinx.coroutines.c0.b(obj);
        if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
            dispatchedContinuation._state = b11;
            dispatchedContinuation.resumeMode = 1;
            dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
            return;
        }
        e1 b12 = o2.f68027a.b();
        if (b12.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = b11;
            dispatchedContinuation.resumeMode = 1;
            b12.dispatchUnconfined(dispatchedContinuation);
            return;
        }
        b12.incrementUseCount(true);
        try {
            t1 t1Var = (t1) dispatchedContinuation.getContext().get(t1.f68119l1);
            if (t1Var == null || t1Var.isActive()) {
                Continuation<T> continuation2 = dispatchedContinuation.continuation;
                Object obj2 = dispatchedContinuation.countOrElement;
                CoroutineContext context = continuation2.getContext();
                Object i11 = g0.i(context, obj2);
                q2 m11 = i11 != g0.f67978a ? kotlinx.coroutines.g0.m(continuation2, context, i11) : null;
                try {
                    dispatchedContinuation.continuation.resumeWith(obj);
                    Unit unit = Unit.f67184a;
                } finally {
                    if (m11 == null || m11.X()) {
                        g0.f(context, i11);
                    }
                }
            } else {
                CancellationException cancellationException = t1Var.getCancellationException();
                dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(b11, cancellationException);
                Result.Companion companion = Result.INSTANCE;
                dispatchedContinuation.resumeWith(Result.m1185constructorimpl(ResultKt.a(cancellationException)));
            }
            do {
            } while (b12.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final boolean c(DispatchedContinuation dispatchedContinuation) {
        Unit unit = Unit.f67184a;
        e1 b11 = o2.f68027a.b();
        if (b11.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (b11.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            b11.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        b11.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (b11.processUnconfinedEvent());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
