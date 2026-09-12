package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class m0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f14795a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque f14796b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f14797c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f14798d;

    public m0(Executor executor) {
        Intrinsics.h(executor, "executor");
        this.f14795a = executor;
        this.f14796b = new ArrayDeque();
        this.f14798d = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Runnable runnable, m0 m0Var) {
        try {
            runnable.run();
        } finally {
            m0Var.c();
        }
    }

    public final void c() {
        synchronized (this.f14798d) {
            try {
                Object poll = this.f14796b.poll();
                Runnable runnable = (Runnable) poll;
                this.f14797c = runnable;
                if (poll != null) {
                    this.f14795a.execute(runnable);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable command) {
        Intrinsics.h(command, "command");
        synchronized (this.f14798d) {
            try {
                this.f14796b.offer(new Runnable() { // from class: androidx.room.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        m0.b(command, this);
                    }
                });
                if (this.f14797c == null) {
                    c();
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
