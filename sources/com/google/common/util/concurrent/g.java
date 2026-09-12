package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    private static final q f31081c = new q(g.class);

    /* renamed from: a, reason: collision with root package name */
    private a f31082a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f31083b;

    /* loaded from: classes4.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f31084a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f31085b;

        /* renamed from: c, reason: collision with root package name */
        a f31086c;

        a(Runnable runnable, Executor executor, a aVar) {
            this.f31084a = runnable;
            this.f31085b = executor;
            this.f31086c = aVar;
        }
    }

    private static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e11) {
            f31081c.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.common.base.m.p(runnable, "Runnable was null.");
        com.google.common.base.m.p(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (this.f31083b) {
                    c(runnable, executor);
                } else {
                    this.f31082a = new a(runnable, executor, this.f31082a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f31083b) {
                    return;
                }
                this.f31083b = true;
                a aVar = this.f31082a;
                a aVar2 = null;
                this.f31082a = null;
                while (aVar != null) {
                    a aVar3 = aVar.f31086c;
                    aVar.f31086c = aVar2;
                    aVar2 = aVar;
                    aVar = aVar3;
                }
                while (aVar2 != null) {
                    c(aVar2.f31084a, aVar2.f31085b);
                    aVar2 = aVar2.f31086c;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
