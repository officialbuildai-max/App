package kotlinx.coroutines;

/* loaded from: classes7.dex */
public final class d2 implements a1, t {

    /* renamed from: a, reason: collision with root package name */
    public static final d2 f67825a = new d2();

    private d2() {
    }

    @Override // kotlinx.coroutines.t
    public boolean a(Throwable th2) {
        return false;
    }

    @Override // kotlinx.coroutines.a1
    public void dispose() {
    }

    @Override // kotlinx.coroutines.t
    public t1 getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
