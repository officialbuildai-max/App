package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* loaded from: classes7.dex */
public abstract class u0 {
    public static final Object a(long j11, Continuation continuation) {
        if (j11 <= 0) {
            return Unit.f67184a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (j11 < Long.MAX_VALUE) {
            b(cancellableContinuationImpl.getF67151a()).scheduleResumeAfterDelay(j11, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    public static final t0 b(CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.INSTANCE);
        t0 t0Var = element instanceof t0 ? (t0) element : null;
        return t0Var == null ? q0.a() : t0Var;
    }

    public static final long c(long j11) {
        boolean E = Duration.E(j11);
        if (E) {
            return Duration.q(Duration.G(j11, DurationKt.t(999999L, DurationUnit.NANOSECONDS)));
        }
        if (E) {
            throw new NoWhenBranchMatchedException();
        }
        return 0L;
    }
}
