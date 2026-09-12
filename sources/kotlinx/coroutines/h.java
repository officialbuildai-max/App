package kotlinx.coroutines;

/* loaded from: classes7.dex */
public final class h extends EventLoopImplBase {

    /* renamed from: a, reason: collision with root package name */
    private final Thread f67956a;

    public h(Thread thread) {
        this.f67956a = thread;
    }

    @Override // kotlinx.coroutines.f1
    protected Thread getThread() {
        return this.f67956a;
    }
}
