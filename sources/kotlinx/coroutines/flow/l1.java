package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* loaded from: classes7.dex */
public final class l1 implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f67946a;

    public l1(Throwable th2) {
        this.f67946a = th2;
    }

    @Override // kotlinx.coroutines.flow.c
    public Object emit(Object obj, Continuation continuation) {
        throw this.f67946a;
    }
}
