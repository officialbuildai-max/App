package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* loaded from: classes7.dex */
public abstract class c0 {
    public static final Object a(Object obj, Continuation continuation) {
        if (!(obj instanceof b0)) {
            return Result.m1185constructorimpl(obj);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m1185constructorimpl(ResultKt.a(((b0) obj).f67764a));
    }

    public static final Object b(Object obj) {
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(obj);
        return m1188exceptionOrNullimpl == null ? obj : new b0(m1188exceptionOrNullimpl, false, 2, null);
    }

    public static final Object c(Object obj, n nVar) {
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(obj);
        return m1188exceptionOrNullimpl == null ? obj : new b0(m1188exceptionOrNullimpl, false, 2, null);
    }
}
