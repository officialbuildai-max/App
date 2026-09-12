package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class z0 implements c1, b, kotlinx.coroutines.flow.internal.j {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ c1 f67951a;

    /* renamed from: b, reason: collision with root package name */
    private final t1 f67952b;

    public z0(c1 c1Var, t1 t1Var) {
        this.f67951a = c1Var;
        this.f67952b = t1Var;
    }

    @Override // kotlinx.coroutines.flow.c1, kotlinx.coroutines.flow.b
    public Object a(c cVar, Continuation continuation) {
        return this.f67951a.a(cVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.j
    public b d(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return d1.e(this, coroutineContext, i11, bufferOverflow);
    }
}
