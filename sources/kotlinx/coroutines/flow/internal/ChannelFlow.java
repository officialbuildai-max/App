package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;

/* loaded from: classes.dex */
public abstract class ChannelFlow implements j {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f67910a;

    /* renamed from: b, reason: collision with root package name */
    public final int f67911b;

    /* renamed from: c, reason: collision with root package name */
    public final BufferOverflow f67912c;

    public ChannelFlow(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        this.f67910a = coroutineContext;
        this.f67911b = i11;
        this.f67912c = bufferOverflow;
    }

    static /* synthetic */ Object h(ChannelFlow channelFlow, kotlinx.coroutines.flow.c cVar, Continuation continuation) {
        Object e11 = o0.e(new ChannelFlow$collect$2(cVar, channelFlow, null), continuation);
        return e11 == IntrinsicsKt.f() ? e11 : Unit.f67184a;
    }

    @Override // kotlinx.coroutines.flow.b
    public Object a(kotlinx.coroutines.flow.c cVar, Continuation continuation) {
        return h(this, cVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.j
    public kotlinx.coroutines.flow.b d(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        CoroutineContext plus = coroutineContext.plus(this.f67910a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i12 = this.f67911b;
            if (i12 != -3) {
                if (i11 != -3) {
                    if (i12 != -2) {
                        if (i11 != -2) {
                            i11 += i12;
                            if (i11 < 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i11 = i12;
            }
            bufferOverflow = this.f67912c;
        }
        return (Intrinsics.c(plus, this.f67910a) && i11 == this.f67911b && bufferOverflow == this.f67912c) ? this : j(plus, i11, bufferOverflow);
    }

    protected String g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object i(kotlinx.coroutines.channels.o oVar, Continuation continuation);

    protected abstract ChannelFlow j(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow);

    public kotlinx.coroutines.flow.b k() {
        return null;
    }

    public final Function2 l() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int m() {
        int i11 = this.f67911b;
        if (i11 == -3) {
            return -2;
        }
        return i11;
    }

    public kotlinx.coroutines.channels.q n(n0 n0Var) {
        return ProduceKt.d(n0Var, this.f67910a, m(), this.f67912c, CoroutineStart.ATOMIC, null, l(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String g11 = g();
        if (g11 != null) {
            arrayList.add(g11);
        }
        if (this.f67910a != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.f67910a);
        }
        if (this.f67911b != -3) {
            arrayList.add("capacity=" + this.f67911b);
        }
        if (this.f67912c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f67912c);
        }
        return p0.a(this) + '[' + CollectionsKt.s0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
