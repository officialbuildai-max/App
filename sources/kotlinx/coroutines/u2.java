package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* loaded from: classes7.dex */
public abstract class u2 {
    public static final Object a(Continuation continuation) {
        Object f11;
        CoroutineContext context = continuation.getContext();
        v1.i(context);
        Continuation c11 = IntrinsicsKt.c(continuation);
        DispatchedContinuation dispatchedContinuation = c11 instanceof DispatchedContinuation ? (DispatchedContinuation) c11 : null;
        if (dispatchedContinuation == null) {
            f11 = Unit.f67184a;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, Unit.f67184a);
            } else {
                t2 t2Var = new t2();
                CoroutineContext plus = context.plus(t2Var);
                Unit unit = Unit.f67184a;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(plus, unit);
                if (t2Var.f68122a) {
                    f11 = kotlinx.coroutines.internal.g.c(dispatchedContinuation) ? IntrinsicsKt.f() : unit;
                }
            }
            f11 = IntrinsicsKt.f();
        }
        if (f11 == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return f11 == IntrinsicsKt.f() ? f11 : Unit.f67184a;
    }
}
