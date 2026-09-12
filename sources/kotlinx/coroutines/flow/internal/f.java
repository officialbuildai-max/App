package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: classes7.dex */
public final class f implements CoroutineContext {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CoroutineContext f67931a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f67932b;

    public f(Throwable th2, CoroutineContext coroutineContext) {
        this.f67931a = coroutineContext;
        this.f67932b = th2;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return this.f67931a.fold(obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return this.f67931a.get(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return this.f67931a.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.f67931a.plus(coroutineContext);
    }
}
