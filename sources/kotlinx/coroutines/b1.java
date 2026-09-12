package kotlinx.coroutines;

/* loaded from: classes7.dex */
final class b1 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final a1 f67765a;

    public b1(a1 a1Var) {
        this.f67765a = a1Var;
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable th2) {
        this.f67765a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f67765a + ']';
    }
}
