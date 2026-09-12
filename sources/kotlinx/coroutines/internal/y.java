package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: classes7.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f68011a = new b.a().a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f68012b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f68013c;

    static {
        Object m1185constructorimpl;
        Object m1185constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f68012b = (String) m1185constructorimpl;
        try {
            m1185constructorimpl2 = Result.m1185constructorimpl(y.class.getCanonicalName());
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl2 = Result.m1185constructorimpl(ResultKt.a(th3));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl2) != null) {
            m1185constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f68013c = (String) m1185constructorimpl2;
    }

    public static final Throwable a(Throwable th2) {
        return th2;
    }
}
