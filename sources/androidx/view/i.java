package androidx.view;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.y0;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    private boolean f9691b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9692c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f9690a = true;

    /* renamed from: d, reason: collision with root package name */
    private final Queue f9693d = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(i this$0, Runnable runnable) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(runnable, "$runnable");
        this$0.f(runnable);
    }

    private final void f(Runnable runnable) {
        if (!this.f9693d.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables");
        }
        e();
    }

    public final boolean b() {
        return this.f9691b || !this.f9690a;
    }

    public final void c(CoroutineContext context, final Runnable runnable) {
        Intrinsics.h(context, "context");
        Intrinsics.h(runnable, "runnable");
        a2 q11 = y0.c().q();
        if (q11.isDispatchNeeded(context) || b()) {
            q11.dispatch(context, new Runnable() { // from class: androidx.lifecycle.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.d(i.this, runnable);
                }
            });
        } else {
            f(runnable);
        }
    }

    public final void e() {
        if (this.f9692c) {
            return;
        }
        try {
            this.f9692c = true;
            while (!this.f9693d.isEmpty() && b()) {
                Runnable runnable = (Runnable) this.f9693d.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        } finally {
            this.f9692c = false;
        }
    }

    public final void g() {
        this.f9691b = true;
        e();
    }

    public final void h() {
        this.f9690a = true;
    }

    public final void i() {
        if (this.f9690a) {
            if (this.f9691b) {
                throw new IllegalStateException("Cannot resume a finished dispatcher");
            }
            this.f9690a = false;
            e();
        }
    }
}
