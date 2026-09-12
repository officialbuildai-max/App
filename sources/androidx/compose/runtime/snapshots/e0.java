package androidx.compose.runtime.snapshots;

/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    private int f4053a = SnapshotKt.H().f();

    /* renamed from: b, reason: collision with root package name */
    private e0 f4054b;

    public abstract void c(e0 e0Var);

    public abstract e0 d();

    public final e0 e() {
        return this.f4054b;
    }

    public final int f() {
        return this.f4053a;
    }

    public final void g(e0 e0Var) {
        this.f4054b = e0Var;
    }

    public final void h(int i11) {
        this.f4053a = i11;
    }
}
