package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.o0;

/* loaded from: classes7.dex */
public final class ChannelFlowTransformLatest extends ChannelFlowOperator {

    /* renamed from: e, reason: collision with root package name */
    private final Function3 f67914e;

    public ChannelFlowTransformLatest(Function3 function3, kotlinx.coroutines.flow.b bVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(bVar, coroutineContext, i11, bufferOverflow);
        this.f67914e = function3;
    }

    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, kotlinx.coroutines.flow.b bVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(function3, bVar, (i12 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 8) != 0 ? -2 : i11, (i12 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow j(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f67914e, this.f67913d, coroutineContext, i11, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object r(kotlinx.coroutines.flow.c cVar, Continuation continuation) {
        Object e11 = o0.e(new ChannelFlowTransformLatest$flowCollect$3(this, cVar, null), continuation);
        return e11 == IntrinsicsKt.f() ? e11 : Unit.f67184a;
    }
}
