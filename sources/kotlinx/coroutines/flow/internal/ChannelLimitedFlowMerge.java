package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.n0;

/* loaded from: classes7.dex */
public final class ChannelLimitedFlowMerge extends ChannelFlow {

    /* renamed from: d, reason: collision with root package name */
    private final Iterable f67919d;

    public ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f67919d = iterable;
    }

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(iterable, (i12 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 4) != 0 ? -2 : i11, (i12 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(kotlinx.coroutines.channels.o oVar, Continuation continuation) {
        r rVar = new r(oVar);
        Iterator it = this.f67919d.iterator();
        while (it.hasNext()) {
            kotlinx.coroutines.k.d(oVar, null, null, new ChannelLimitedFlowMerge$collectTo$2$1((kotlinx.coroutines.flow.b) it.next(), rVar, null), 3, null);
        }
        return Unit.f67184a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow j(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.f67919d, coroutineContext, i11, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public kotlinx.coroutines.channels.q n(n0 n0Var) {
        return ProduceKt.b(n0Var, this.f67910a, this.f67911b, l());
    }
}
