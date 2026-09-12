package androidx.view;

import androidx.view.Lifecycle;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;

/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements r {

    /* renamed from: a, reason: collision with root package name */
    private final Lifecycle f9614a;

    /* renamed from: b, reason: collision with root package name */
    private final CoroutineContext f9615b;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Intrinsics.h(lifecycle, "lifecycle");
        Intrinsics.h(coroutineContext, "coroutineContext");
        this.f9614a = lifecycle;
        this.f9615b = coroutineContext;
        if (a().b() == Lifecycle.State.DESTROYED) {
            JobKt__JobKt.e(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.view.LifecycleCoroutineScope
    public Lifecycle a() {
        return this.f9614a;
    }

    public final void c() {
        k.d(this, y0.c().q(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }

    @Override // kotlinx.coroutines.n0
    public CoroutineContext getCoroutineContext() {
        return this.f9615b;
    }

    @Override // androidx.view.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        if (a().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            a().d(this);
            JobKt__JobKt.e(getCoroutineContext(), null, 1, null);
        }
    }
}
