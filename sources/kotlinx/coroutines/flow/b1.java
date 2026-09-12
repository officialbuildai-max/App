package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: classes7.dex */
final class b1 extends AbstractFlow {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f67898a;

    public b1(Function2 function2) {
        this.f67898a = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object g(c cVar, Continuation continuation) {
        Object invoke = this.f67898a.invoke(cVar, continuation);
        return invoke == IntrinsicsKt.f() ? invoke : Unit.f67184a;
    }
}
