package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.x0;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f9062g = new ThreadLocal();

    /* renamed from: d, reason: collision with root package name */
    private c f9066d;

    /* renamed from: a, reason: collision with root package name */
    private final x0 f9063a = new x0();

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f9064b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final C0083a f9065c = new C0083a();

    /* renamed from: e, reason: collision with root package name */
    long f9067e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9068f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.dynamicanimation.animation.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0083a {
        C0083a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            a.this.f9067e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f9067e);
            if (a.this.f9064b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(long j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final C0083a f9070a;

        c(C0083a c0083a) {
            this.f9070a = c0083a;
        }

        abstract void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        long f9071b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends c {

        /* renamed from: b, reason: collision with root package name */
        private final Choreographer f9072b;

        /* renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f9073c;

        /* renamed from: androidx.dynamicanimation.animation.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ChoreographerFrameCallbackC0084a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0084a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j11) {
                e.this.f9070a.a();
            }
        }

        e(C0083a c0083a) {
            super(c0083a);
            this.f9072b = Choreographer.getInstance();
            this.f9073c = new ChoreographerFrameCallbackC0084a();
        }

        @Override // androidx.dynamicanimation.animation.a.c
        void a() {
            this.f9072b.postFrameCallback(this.f9073c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f9068f) {
            for (int size = this.f9064b.size() - 1; size >= 0; size--) {
                if (this.f9064b.get(size) == null) {
                    this.f9064b.remove(size);
                }
            }
            this.f9068f = false;
        }
    }

    public static a d() {
        ThreadLocal threadLocal = f9062g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return (a) threadLocal.get();
    }

    private boolean f(b bVar, long j11) {
        Long l11 = (Long) this.f9063a.get(bVar);
        if (l11 == null) {
            return true;
        }
        if (l11.longValue() >= j11) {
            return false;
        }
        this.f9063a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j11) {
        if (this.f9064b.size() == 0) {
            e().a();
        }
        if (!this.f9064b.contains(bVar)) {
            this.f9064b.add(bVar);
        }
        if (j11 > 0) {
            this.f9063a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j11));
        }
    }

    void c(long j11) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i11 = 0; i11 < this.f9064b.size(); i11++) {
            b bVar = (b) this.f9064b.get(i11);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.a(j11);
            }
        }
        b();
    }

    c e() {
        if (this.f9066d == null) {
            this.f9066d = new e(this.f9065c);
        }
        return this.f9066d;
    }

    public void g(b bVar) {
        this.f9063a.remove(bVar);
        int indexOf = this.f9064b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f9064b.set(indexOf, null);
            this.f9068f = true;
        }
    }
}
