package androidx.compose.runtime;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class s0 implements g3 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f3958a;

    public s0(Function0 function0) {
        this.f3958a = LazyKt.b(function0);
    }

    private final Object b() {
        return this.f3958a.getValue();
    }

    @Override // androidx.compose.runtime.g3
    public Object a(n1 n1Var) {
        return b();
    }
}
