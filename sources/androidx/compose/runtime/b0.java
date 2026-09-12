package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b0 implements b2 {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f3747a;

    /* renamed from: b, reason: collision with root package name */
    private c0 f3748b;

    public b0(Function1 function1) {
        this.f3747a = function1;
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        c0 c0Var = this.f3748b;
        if (c0Var != null) {
            c0Var.dispose();
        }
        this.f3748b = null;
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        d0 d0Var;
        Function1 function1 = this.f3747a;
        d0Var = g0.f3808a;
        this.f3748b = (c0) function1.invoke(d0Var);
    }
}
