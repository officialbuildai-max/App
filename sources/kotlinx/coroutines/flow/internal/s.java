package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* loaded from: classes7.dex */
final class s implements Continuation, CoroutineStackFrame {

    /* renamed from: a, reason: collision with root package name */
    private final Continuation f67941a;

    /* renamed from: b, reason: collision with root package name */
    private final CoroutineContext f67942b;

    public s(Continuation continuation, CoroutineContext coroutineContext) {
        this.f67941a = continuation;
        this.f67942b = coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f67941a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f67942b;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.f67941a.resumeWith(obj);
    }
}
