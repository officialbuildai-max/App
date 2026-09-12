package fh;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class i implements dh.b, dh.a {

    /* renamed from: a, reason: collision with root package name */
    private dh.b f62534a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f62535b;

    /* renamed from: c, reason: collision with root package name */
    private dh.a f62536c;

    public i(dh.b bVar, Executor executor, dh.a aVar) {
        this.f62534a = bVar;
        this.f62535b = executor;
        this.f62536c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(i iVar, String str) {
        dh.b bVar = iVar.f62534a;
        if (bVar != null) {
            bVar.onCompleted(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(i iVar, String str, Throwable th2) {
        dh.b bVar = iVar.f62534a;
        if (bVar != null) {
            bVar.b(str, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(i iVar, Throwable th2) {
        dh.a aVar = iVar.f62536c;
        if (aVar != null) {
            aVar.c(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(i iVar, String str) {
        dh.b bVar = iVar.f62534a;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(i iVar) {
        try {
            dh.a aVar = iVar.f62536c;
            if (aVar != null) {
                aVar.onSuccess();
            }
        } catch (Throwable th2) {
            iVar.c(th2);
        }
    }

    @Override // dh.b
    public void a(final String threadName) {
        Executor executor;
        Intrinsics.h(threadName, "threadName");
        if (this.f62534a == null || (executor = this.f62535b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: fh.d
            @Override // java.lang.Runnable
            public final void run() {
                i.l(i.this, threadName);
            }
        });
    }

    @Override // dh.b
    public void b(final String threadName, final Throwable throwable) {
        Executor executor;
        Intrinsics.h(threadName, "threadName");
        Intrinsics.h(throwable, "throwable");
        c(throwable);
        if (this.f62534a == null || (executor = this.f62535b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: fh.f
            @Override // java.lang.Runnable
            public final void run() {
                i.j(i.this, threadName, throwable);
            }
        });
    }

    @Override // dh.a
    public void c(final Throwable t11) {
        Executor executor;
        Intrinsics.h(t11, "t");
        if (this.f62536c == null || (executor = this.f62535b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: fh.h
            @Override // java.lang.Runnable
            public final void run() {
                i.k(i.this, t11);
            }
        });
    }

    @Override // dh.b
    public void onCompleted(final String threadName) {
        Executor executor;
        Intrinsics.h(threadName, "threadName");
        if (this.f62534a == null || (executor = this.f62535b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: fh.g
            @Override // java.lang.Runnable
            public final void run() {
                i.i(i.this, threadName);
            }
        });
    }

    @Override // dh.a
    public void onSuccess() {
        Executor executor;
        if (this.f62536c == null || (executor = this.f62535b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: fh.e
            @Override // java.lang.Runnable
            public final void run() {
                i.m(i.this);
            }
        });
    }
}
