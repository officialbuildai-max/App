package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.g0;

/* loaded from: classes7.dex */
public abstract class ChannelFlowOperator extends ChannelFlow {

    /* renamed from: d, reason: collision with root package name */
    protected final kotlinx.coroutines.flow.b f67913d;

    public ChannelFlowOperator(kotlinx.coroutines.flow.b bVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f67913d = bVar;
    }

    static /* synthetic */ Object o(ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.flow.c cVar, Continuation continuation) {
        if (channelFlowOperator.f67911b == -3) {
            CoroutineContext f67151a = continuation.getF67151a();
            CoroutineContext j11 = g0.j(f67151a, channelFlowOperator.f67910a);
            if (Intrinsics.c(j11, f67151a)) {
                Object r11 = channelFlowOperator.r(cVar, continuation);
                return r11 == IntrinsicsKt.f() ? r11 : Unit.f67184a;
            }
            ContinuationInterceptor.Companion companion = ContinuationInterceptor.INSTANCE;
            if (Intrinsics.c(j11.get(companion), f67151a.get(companion))) {
                Object q11 = channelFlowOperator.q(cVar, j11, continuation);
                return q11 == IntrinsicsKt.f() ? q11 : Unit.f67184a;
            }
        }
        Object a11 = super.a(cVar, continuation);
        return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
    }

    static /* synthetic */ Object p(ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.channels.o oVar, Continuation continuation) {
        Object r11 = channelFlowOperator.r(new r(oVar), continuation);
        return r11 == IntrinsicsKt.f() ? r11 : Unit.f67184a;
    }

    private final Object q(kotlinx.coroutines.flow.c cVar, CoroutineContext coroutineContext, Continuation continuation) {
        return d.c(coroutineContext, d.a(cVar, continuation.getF67151a()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.b
    public Object a(kotlinx.coroutines.flow.c cVar, Continuation continuation) {
        return o(this, cVar, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(kotlinx.coroutines.channels.o oVar, Continuation continuation) {
        return p(this, oVar, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object r(kotlinx.coroutines.flow.c cVar, Continuation continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.f67913d + " -> " + super.toString();
    }
}
