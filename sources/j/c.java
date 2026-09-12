package j;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class c extends e {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f65816c;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f65817d = new Executor() { // from class: j.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.i(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f65818e = new Executor() { // from class: j.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.j(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private e f65819a;

    /* renamed from: b, reason: collision with root package name */
    private final e f65820b;

    private c() {
        d dVar = new d();
        this.f65820b = dVar;
        this.f65819a = dVar;
    }

    public static Executor g() {
        return f65818e;
    }

    public static c h() {
        if (f65816c != null) {
            return f65816c;
        }
        synchronized (c.class) {
            try {
                if (f65816c == null) {
                    f65816c = new c();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f65816c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Runnable runnable) {
        h().d(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Runnable runnable) {
        h().a(runnable);
    }

    @Override // j.e
    public void a(Runnable runnable) {
        this.f65819a.a(runnable);
    }

    @Override // j.e
    public boolean c() {
        return this.f65819a.c();
    }

    @Override // j.e
    public void d(Runnable runnable) {
        this.f65819a.d(runnable);
    }
}
