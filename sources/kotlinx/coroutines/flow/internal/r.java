package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes7.dex */
public final class r implements kotlinx.coroutines.flow.c {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.channels.r f67940a;

    public r(kotlinx.coroutines.channels.r rVar) {
        this.f67940a = rVar;
    }

    @Override // kotlinx.coroutines.flow.c
    public Object emit(Object obj, Continuation continuation) {
        Object p11 = this.f67940a.p(obj, continuation);
        return p11 == IntrinsicsKt.f() ? p11 : Unit.f67184a;
    }
}
