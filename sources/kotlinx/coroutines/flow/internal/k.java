package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: classes7.dex */
final class k implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public static final k f67933a = new k();

    /* renamed from: b, reason: collision with root package name */
    private static final CoroutineContext f67934b = EmptyCoroutineContext.INSTANCE;

    private k() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return f67934b;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
    }
}
