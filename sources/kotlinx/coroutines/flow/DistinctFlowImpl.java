package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* loaded from: classes7.dex */
final class DistinctFlowImpl implements b {

    /* renamed from: a, reason: collision with root package name */
    private final b f67837a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f67838b;

    /* renamed from: c, reason: collision with root package name */
    public final Function2 f67839c;

    public DistinctFlowImpl(b bVar, Function1 function1, Function2 function2) {
        this.f67837a = bVar;
        this.f67838b = function1;
        this.f67839c = function2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlinx.coroutines.internal.z] */
    @Override // kotlinx.coroutines.flow.b
    public Object a(c cVar, Continuation continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = kotlinx.coroutines.flow.internal.m.f67936a;
        Object a11 = this.f67837a.a(new DistinctFlowImpl$collect$2(this, objectRef, cVar), continuation);
        return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
    }
}
