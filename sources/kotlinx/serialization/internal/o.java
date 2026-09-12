package kotlinx.serialization.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f68298a;

    static {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1192isSuccessimpl(m1185constructorimpl)) {
            m1185constructorimpl = Boolean.TRUE;
        }
        Object m1185constructorimpl2 = Result.m1185constructorimpl(m1185constructorimpl);
        Boolean bool = Boolean.FALSE;
        if (Result.m1191isFailureimpl(m1185constructorimpl2)) {
            m1185constructorimpl2 = bool;
        }
        f68298a = ((Boolean) m1185constructorimpl2).booleanValue();
    }

    public static final x1 a(Function1 factory) {
        Intrinsics.h(factory, "factory");
        return f68298a ? new t(factory) : new y(factory);
    }

    public static final j1 b(Function2 factory) {
        Intrinsics.h(factory, "factory");
        return f68298a ? new v(factory) : new z(factory);
    }
}
