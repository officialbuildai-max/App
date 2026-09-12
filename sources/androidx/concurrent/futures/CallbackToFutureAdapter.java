package androidx.concurrent.futures;

import com.google.common.util.concurrent.r;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class CallbackToFutureAdapter {

    /* loaded from: classes.dex */
    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        Object f6665a;

        /* renamed from: b, reason: collision with root package name */
        c f6666b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.concurrent.futures.b f6667c = androidx.concurrent.futures.b.y();

        /* renamed from: d, reason: collision with root package name */
        private boolean f6668d;

        a() {
        }

        private void e() {
            this.f6665a = null;
            this.f6666b = null;
            this.f6667c = null;
        }

        public void a(Runnable runnable, Executor executor) {
            androidx.concurrent.futures.b bVar = this.f6667c;
            if (bVar != null) {
                bVar.addListener(runnable, executor);
            }
        }

        void b() {
            this.f6665a = null;
            this.f6666b = null;
            this.f6667c.u(null);
        }

        public boolean c(Object obj) {
            this.f6668d = true;
            c cVar = this.f6666b;
            boolean z10 = cVar != null && cVar.c(obj);
            if (z10) {
                e();
            }
            return z10;
        }

        public boolean d() {
            this.f6668d = true;
            c cVar = this.f6666b;
            boolean z10 = cVar != null && cVar.b(true);
            if (z10) {
                e();
            }
            return z10;
        }

        public boolean f(Throwable th2) {
            this.f6668d = true;
            c cVar = this.f6666b;
            boolean z10 = cVar != null && cVar.d(th2);
            if (z10) {
                e();
            }
            return z10;
        }

        protected void finalize() {
            androidx.concurrent.futures.b bVar;
            c cVar = this.f6666b;
            if (cVar != null && !cVar.isDone()) {
                cVar.d(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f6665a));
            }
            if (this.f6668d || (bVar = this.f6667c) == null) {
                return;
            }
            bVar.u(null);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        Object a(a aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements r {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference f6669a;

        /* renamed from: b, reason: collision with root package name */
        private final AbstractResolvableFuture f6670b = new a();

        /* loaded from: classes.dex */
        class a extends AbstractResolvableFuture {
            a() {
            }

            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            protected String r() {
                a aVar = (a) c.this.f6669a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f6665a + "]";
            }
        }

        c(a aVar) {
            this.f6669a = new WeakReference(aVar);
        }

        @Override // com.google.common.util.concurrent.r
        public void addListener(Runnable runnable, Executor executor) {
            this.f6670b.addListener(runnable, executor);
        }

        boolean b(boolean z10) {
            return this.f6670b.cancel(z10);
        }

        boolean c(Object obj) {
            return this.f6670b.u(obj);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            a aVar = (a) this.f6669a.get();
            boolean cancel = this.f6670b.cancel(z10);
            if (cancel && aVar != null) {
                aVar.b();
            }
            return cancel;
        }

        boolean d(Throwable th2) {
            return this.f6670b.v(th2);
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.f6670b.get();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j11, TimeUnit timeUnit) {
            return this.f6670b.get(j11, timeUnit);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f6670b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f6670b.isDone();
        }

        public String toString() {
            return this.f6670b.toString();
        }
    }

    public static r a(b bVar) {
        a aVar = new a();
        c cVar = new c(aVar);
        aVar.f6666b = cVar;
        aVar.f6665a = bVar.getClass();
        try {
            Object a11 = bVar.a(aVar);
            if (a11 != null) {
                aVar.f6665a = a11;
            }
        } catch (Exception e11) {
            cVar.d(e11);
        }
        return cVar;
    }
}
