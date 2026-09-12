package androidx.compose.runtime;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    private final RecomposeScopeImpl f3939a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3940b;

    /* renamed from: c, reason: collision with root package name */
    private Object f3941c;

    public o0(RecomposeScopeImpl recomposeScopeImpl, int i11, Object obj) {
        this.f3939a = recomposeScopeImpl;
        this.f3940b = i11;
        this.f3941c = obj;
    }

    public final Object a() {
        return this.f3941c;
    }

    public final int b() {
        return this.f3940b;
    }

    public final RecomposeScopeImpl c() {
        return this.f3939a;
    }

    public final boolean d() {
        return this.f3939a.u(this.f3941c);
    }

    public final void e(Object obj) {
        this.f3941c = obj;
    }
}
