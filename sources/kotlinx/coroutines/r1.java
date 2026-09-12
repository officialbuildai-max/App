package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.functions.Function1;

/* loaded from: classes7.dex */
final class r1 extends w1 {

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f68036f = AtomicIntegerFieldUpdater.newUpdater(r1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* renamed from: e, reason: collision with root package name */
    private final Function1 f68037e;

    public r1(Function1 function1) {
        this.f68037e = function1;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return true;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th2) {
        if (f68036f.compareAndSet(this, 0, 1)) {
            this.f68037e.invoke(th2);
        }
    }
}
