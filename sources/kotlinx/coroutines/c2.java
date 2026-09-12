package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes7.dex */
public final class c2 extends AbstractCoroutineContextElement implements t1 {

    /* renamed from: a, reason: collision with root package name */
    public static final c2 f67768a = new c2();

    private c2() {
        super(t1.f68119l1);
    }

    @Override // kotlinx.coroutines.t1
    public t attachChild(v vVar) {
        return d2.f67825a;
    }

    @Override // kotlinx.coroutines.t1
    public void cancel(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.t1
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.t1
    public a1 invokeOnCompletion(Function1 function1) {
        return d2.f67825a;
    }

    @Override // kotlinx.coroutines.t1
    public a1 invokeOnCompletion(boolean z10, boolean z11, Function1 function1) {
        return d2.f67825a;
    }

    @Override // kotlinx.coroutines.t1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.t1
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.t1
    public Object join(Continuation continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.t1
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }
}
