package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
final class t0 implements s0 {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f2570a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f2571b;

    public t0(Function1 function1, Function1 function12) {
        this.f2570a = function1;
        this.f2571b = function12;
    }

    @Override // androidx.compose.animation.core.s0
    public Function1 a() {
        return this.f2570a;
    }

    @Override // androidx.compose.animation.core.s0
    public Function1 b() {
        return this.f2571b;
    }
}
