package androidx.compose.runtime;

/* loaded from: classes.dex */
public final class v implements b2 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f4128a;

    public v(kotlinx.coroutines.n0 n0Var) {
        this.f4128a = n0Var;
    }

    public final kotlinx.coroutines.n0 a() {
        return this.f4128a;
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        kotlinx.coroutines.o0.c(this.f4128a, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        kotlinx.coroutines.o0.c(this.f4128a, new LeftCompositionCancellationException());
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
    }
}
