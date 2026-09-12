package androidx.view;

import androidx.view.Lifecycle;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final Lifecycle f9716a;

    /* renamed from: b, reason: collision with root package name */
    private final Lifecycle.State f9717b;

    /* renamed from: c, reason: collision with root package name */
    private final i f9718c;

    /* renamed from: d, reason: collision with root package name */
    private final r f9719d;

    public p(Lifecycle lifecycle, Lifecycle.State minState, i dispatchQueue, final t1 parentJob) {
        Intrinsics.h(lifecycle, "lifecycle");
        Intrinsics.h(minState, "minState");
        Intrinsics.h(dispatchQueue, "dispatchQueue");
        Intrinsics.h(parentJob, "parentJob");
        this.f9716a = lifecycle;
        this.f9717b = minState;
        this.f9718c = dispatchQueue;
        r rVar = new r() { // from class: androidx.lifecycle.o
            @Override // androidx.view.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                p.c(p.this, parentJob, uVar, event);
            }
        };
        this.f9719d = rVar;
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            lifecycle.a(rVar);
        } else {
            t1.a.b(parentJob, null, 1, null);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(p this$0, t1 parentJob, u source, Lifecycle.Event event) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(parentJob, "$parentJob");
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "<anonymous parameter 1>");
        if (source.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            t1.a.b(parentJob, null, 1, null);
            this$0.b();
        } else if (source.getLifecycle().b().compareTo(this$0.f9717b) < 0) {
            this$0.f9718c.h();
        } else {
            this$0.f9718c.i();
        }
    }

    public final void b() {
        this.f9716a.d(this.f9719d);
        this.f9718c.g();
    }
}
