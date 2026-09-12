package b00;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.g;

/* loaded from: classes6.dex */
public abstract class a {
    private static final void a(Continuation continuation, Throwable th2) {
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m1185constructorimpl(ResultKt.a(th2)));
        throw th2;
    }

    public static final void b(Continuation continuation, Continuation continuation2) {
        try {
            Continuation c11 = IntrinsicsKt.c(continuation);
            Result.Companion companion = Result.INSTANCE;
            g.b(c11, Result.m1185constructorimpl(Unit.f67184a));
        } catch (Throwable th2) {
            a(continuation2, th2);
        }
    }

    public static final void c(Function2 function2, Object obj, Continuation continuation) {
        try {
            Continuation c11 = IntrinsicsKt.c(IntrinsicsKt.a(function2, obj, continuation));
            Result.Companion companion = Result.INSTANCE;
            g.b(c11, Result.m1185constructorimpl(Unit.f67184a));
        } catch (Throwable th2) {
            a(continuation, th2);
        }
    }
}
