package p;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.x0;

/* loaded from: classes2.dex */
final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private final x0 f72340a = d1.b(0, 16, BufferOverflow.DROP_OLDEST, 1, null);

    @Override // p.i
    public boolean a(f fVar) {
        return b().b(fVar);
    }

    @Override // p.i
    public Object c(f fVar, Continuation continuation) {
        Object emit = b().emit(fVar, continuation);
        return emit == IntrinsicsKt.f() ? emit : Unit.f67184a;
    }

    @Override // p.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public x0 b() {
        return this.f72340a;
    }
}
