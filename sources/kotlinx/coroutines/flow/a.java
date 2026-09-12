package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class a extends ChannelFlow {

    /* renamed from: d, reason: collision with root package name */
    private final Function2 f67895d;

    public a(Function2 function2, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f67895d = function2;
    }

    static /* synthetic */ Object o(a aVar, kotlinx.coroutines.channels.o oVar, Continuation continuation) {
        Object invoke = aVar.f67895d.invoke(oVar, continuation);
        return invoke == IntrinsicsKt.f() ? invoke : Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(kotlinx.coroutines.channels.o oVar, Continuation continuation) {
        return o(this, oVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.f67895d + "] -> " + super.toString();
    }
}
