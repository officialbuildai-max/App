package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

/* loaded from: classes7.dex */
public final class h0 implements m2 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f67982a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadLocal f67983b;

    /* renamed from: c, reason: collision with root package name */
    private final CoroutineContext.Key f67984c;

    public h0(Object obj, ThreadLocal threadLocal) {
        this.f67982a = obj;
        this.f67983b = threadLocal;
        this.f67984c = new i0(threadLocal);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return m2.a.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        if (!Intrinsics.c(getKey(), key)) {
            return null;
        }
        Intrinsics.f(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key getKey() {
        return this.f67984c;
    }

    @Override // kotlinx.coroutines.m2
    public void m(CoroutineContext coroutineContext, Object obj) {
        this.f67983b.set(obj);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return Intrinsics.c(getKey(), key) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return m2.a.b(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.m2
    public Object r(CoroutineContext coroutineContext) {
        Object obj = this.f67983b.get();
        this.f67983b.set(this.f67982a);
        return obj;
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f67982a + ", threadLocal = " + this.f67983b + ')';
    }
}
