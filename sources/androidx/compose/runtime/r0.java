package androidx.compose.runtime;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt__JobKt;

/* loaded from: classes.dex */
public final class r0 implements b2 {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f3952a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f3953b;

    /* renamed from: c, reason: collision with root package name */
    private kotlinx.coroutines.t1 f3954c;

    public r0(CoroutineContext coroutineContext, Function2 function2) {
        this.f3952a = function2;
        this.f3953b = kotlinx.coroutines.o0.a(coroutineContext);
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        kotlinx.coroutines.t1 t1Var = this.f3954c;
        if (t1Var != null) {
            t1Var.cancel(new LeftCompositionCancellationException());
        }
        this.f3954c = null;
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        kotlinx.coroutines.t1 t1Var = this.f3954c;
        if (t1Var != null) {
            t1Var.cancel(new LeftCompositionCancellationException());
        }
        this.f3954c = null;
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        kotlinx.coroutines.t1 d11;
        kotlinx.coroutines.t1 t1Var = this.f3954c;
        if (t1Var != null) {
            JobKt__JobKt.f(t1Var, "Old job was still running!", null, 2, null);
        }
        d11 = kotlinx.coroutines.k.d(this.f3953b, null, null, this.f3952a, 3, null);
        this.f3954c = d11;
    }
}
