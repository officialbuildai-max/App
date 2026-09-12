package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(b bVar, Continuation continuation) {
        Object a11 = bVar.a(kotlinx.coroutines.flow.internal.l.f67935a, continuation);
        return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
    }

    public static final Object b(b bVar, Function2 function2, Continuation continuation) {
        b b11;
        b11 = r.b(d.w(bVar, function2), 0, null, 2, null);
        Object h11 = d.h(b11, continuation);
        return h11 == IntrinsicsKt.f() ? h11 : Unit.f67184a;
    }

    public static final Object c(c cVar, b bVar, Continuation continuation) {
        d.o(cVar);
        Object a11 = bVar.a(cVar, continuation);
        return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
    }

    public static final t1 d(b bVar, kotlinx.coroutines.n0 n0Var) {
        t1 d11;
        d11 = kotlinx.coroutines.k.d(n0Var, null, null, new FlowKt__CollectKt$launchIn$1(bVar, null), 3, null);
        return d11;
    }
}
