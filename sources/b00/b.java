package b00;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.x1;

/* loaded from: classes6.dex */
public abstract class b {
    public static final void a(Function2 function2, Object obj, Continuation continuation) {
        Continuation a11 = DebugProbesKt.a(continuation);
        try {
            CoroutineContext context = a11.getContext();
            Object i11 = g0.i(context, null);
            try {
                DebugProbesKt.b(a11);
                Object d11 = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.d(function2, obj, a11) : ((Function2) TypeIntrinsics.e(function2, 2)).invoke(obj, a11);
                g0.f(context, i11);
                if (d11 != IntrinsicsKt.f()) {
                    a11.resumeWith(Result.m1185constructorimpl(d11));
                }
            } catch (Throwable th2) {
                g0.f(context, i11);
                throw th2;
            }
        } catch (Throwable th3) {
            Result.Companion companion = Result.INSTANCE;
            a11.resumeWith(Result.m1185constructorimpl(ResultKt.a(th3)));
        }
    }

    public static final Object b(v vVar, Object obj, Function2 function2) {
        Object b0Var;
        Object makeCompletingOnce$kotlinx_coroutines_core;
        try {
            b0Var = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.d(function2, obj, vVar) : ((Function2) TypeIntrinsics.e(function2, 2)).invoke(obj, vVar);
        } catch (Throwable th2) {
            b0Var = new b0(th2, false, 2, null);
        }
        if (b0Var != IntrinsicsKt.f() && (makeCompletingOnce$kotlinx_coroutines_core = vVar.makeCompletingOnce$kotlinx_coroutines_core(b0Var)) != x1.f68129b) {
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof b0) {
                throw ((b0) makeCompletingOnce$kotlinx_coroutines_core).f67764a;
            }
            return x1.h(makeCompletingOnce$kotlinx_coroutines_core);
        }
        return IntrinsicsKt.f();
    }

    public static final Object c(v vVar, Object obj, Function2 function2) {
        Object b0Var;
        Object makeCompletingOnce$kotlinx_coroutines_core;
        try {
            b0Var = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.d(function2, obj, vVar) : ((Function2) TypeIntrinsics.e(function2, 2)).invoke(obj, vVar);
        } catch (Throwable th2) {
            b0Var = new b0(th2, false, 2, null);
        }
        if (b0Var != IntrinsicsKt.f() && (makeCompletingOnce$kotlinx_coroutines_core = vVar.makeCompletingOnce$kotlinx_coroutines_core(b0Var)) != x1.f68129b) {
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof b0) {
                Throwable th3 = ((b0) makeCompletingOnce$kotlinx_coroutines_core).f67764a;
                if (!(th3 instanceof TimeoutCancellationException)) {
                    throw th3;
                }
                if (((TimeoutCancellationException) th3).coroutine != vVar) {
                    throw th3;
                }
                if (b0Var instanceof b0) {
                    throw ((b0) b0Var).f67764a;
                }
            } else {
                b0Var = x1.h(makeCompletingOnce$kotlinx_coroutines_core);
            }
            return b0Var;
        }
        return IntrinsicsKt.f();
    }
}
