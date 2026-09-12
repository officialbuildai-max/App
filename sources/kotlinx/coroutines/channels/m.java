package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* loaded from: classes7.dex */
public class m extends BufferedChannel {

    /* renamed from: m, reason: collision with root package name */
    private final int f67819m;

    /* renamed from: n, reason: collision with root package name */
    private final BufferOverflow f67820n;

    public m(int i11, BufferOverflow bufferOverflow, Function1 function1) {
        super(i11, function1);
        this.f67819m = i11;
        this.f67820n = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.b(BufferedChannel.class).g() + " instead").toString());
        }
        if (i11 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i11 + " was specified").toString());
    }

    static /* synthetic */ Object n1(m mVar, Object obj, Continuation continuation) {
        UndeliveredElementException c11;
        Object p12 = mVar.p1(obj, true);
        if (!(p12 instanceof h.a)) {
            return Unit.f67184a;
        }
        h.e(p12);
        Function1 function1 = mVar.f67779b;
        if (function1 == null || (c11 = kotlinx.coroutines.internal.s.c(function1, obj, null, 2, null)) == null) {
            throw mVar.i0();
        }
        ExceptionsKt.a(c11, mVar.i0());
        throw c11;
    }

    private final Object o1(Object obj, boolean z10) {
        Function1 function1;
        UndeliveredElementException c11;
        Object c12 = super.c(obj);
        if (h.i(c12) || h.h(c12)) {
            return c12;
        }
        if (!z10 || (function1 = this.f67779b) == null || (c11 = kotlinx.coroutines.internal.s.c(function1, obj, null, 2, null)) == null) {
            return h.f67813b.c(Unit.f67184a);
        }
        throw c11;
    }

    private final Object p1(Object obj, boolean z10) {
        return this.f67820n == BufferOverflow.DROP_LATEST ? o1(obj, z10) : d1(obj);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.r
    public Object c(Object obj) {
        return p1(obj, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.r
    public Object p(Object obj, Continuation continuation) {
        return n1(this, obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean w0() {
        return this.f67820n == BufferOverflow.DROP_OLDEST;
    }
}
