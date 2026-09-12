package kotlinx.coroutines;

/* loaded from: classes7.dex */
final class c1 extends w1 {

    /* renamed from: e, reason: collision with root package name */
    private final a1 f67767e;

    public c1(a1 a1Var) {
        this.f67767e = a1Var;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th2) {
        this.f67767e.dispose();
    }
}
