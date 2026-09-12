package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.g0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class UndispatchedContextCollector implements kotlinx.coroutines.flow.c {

    /* renamed from: a, reason: collision with root package name */
    private final CoroutineContext f67923a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f67924b;

    /* renamed from: c, reason: collision with root package name */
    private final Function2 f67925c;

    public UndispatchedContextCollector(kotlinx.coroutines.flow.c cVar, CoroutineContext coroutineContext) {
        this.f67923a = coroutineContext;
        this.f67924b = g0.g(coroutineContext);
        this.f67925c = new UndispatchedContextCollector$emitRef$1(cVar, null);
    }

    @Override // kotlinx.coroutines.flow.c
    public Object emit(Object obj, Continuation continuation) {
        Object b11 = d.b(this.f67923a, obj, this.f67924b, this.f67925c, continuation);
        return b11 == IntrinsicsKt.f() ? b11 : Unit.f67184a;
    }
}
