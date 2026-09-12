package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.r;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractFuture implements r {

    /* renamed from: d, reason: collision with root package name */
    static final boolean f16046d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    private static final Logger f16047e = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: f, reason: collision with root package name */
    static final b f16048f;

    /* renamed from: g, reason: collision with root package name */
    private static final Object f16049g;

    /* renamed from: a, reason: collision with root package name */
    volatile Object f16050a;

    /* renamed from: b, reason: collision with root package name */
    volatile d f16051b;

    /* renamed from: c, reason: collision with root package name */
    volatile g f16052c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        static final Failure f16053b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        final Throwable f16054a;

        Failure(Throwable th2) {
            this.f16054a = (Throwable) AbstractFuture.g(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SetFuture<V> implements Runnable {
        final r future;
        final AbstractFuture owner;

        SetFuture(AbstractFuture abstractFuture, r rVar) {
            this.owner = abstractFuture;
            this.future = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.f16050a != this) {
                return;
            }
            if (AbstractFuture.f16048f.b(this.owner, this, AbstractFuture.n(this.future))) {
                AbstractFuture.k(this.owner);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class b {
        private b() {
        }

        abstract boolean a(AbstractFuture abstractFuture, d dVar, d dVar2);

        abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        abstract boolean c(AbstractFuture abstractFuture, g gVar, g gVar2);

        abstract void d(g gVar, g gVar2);

        abstract void e(g gVar, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f16055c;

        /* renamed from: d, reason: collision with root package name */
        static final c f16056d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f16057a;

        /* renamed from: b, reason: collision with root package name */
        final Throwable f16058b;

        static {
            if (AbstractFuture.f16046d) {
                f16056d = null;
                f16055c = null;
            } else {
                f16056d = new c(false, null);
                f16055c = new c(true, null);
            }
        }

        c(boolean z10, Throwable th2) {
            this.f16057a = z10;
            this.f16058b = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        static final d f16059d = new d(null, null);

        /* renamed from: a, reason: collision with root package name */
        final Runnable f16060a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f16061b;

        /* renamed from: c, reason: collision with root package name */
        d f16062c;

        d(Runnable runnable, Executor executor) {
            this.f16060a = runnable;
            this.f16061b = executor;
        }
    }

    /* loaded from: classes2.dex */
    private static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f16063a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f16064b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f16065c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f16066d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f16067e;

        e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f16063a = atomicReferenceFieldUpdater;
            this.f16064b = atomicReferenceFieldUpdater2;
            this.f16065c = atomicReferenceFieldUpdater3;
            this.f16066d = atomicReferenceFieldUpdater4;
            this.f16067e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean a(AbstractFuture abstractFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f16066d, abstractFuture, dVar, dVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f16067e, abstractFuture, obj, obj2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean c(AbstractFuture abstractFuture, g gVar, g gVar2) {
            return androidx.concurrent.futures.a.a(this.f16065c, abstractFuture, gVar, gVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        void d(g gVar, g gVar2) {
            this.f16064b.lazySet(gVar, gVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        void e(g gVar, Thread thread) {
            this.f16063a.lazySet(gVar, thread);
        }
    }

    /* loaded from: classes2.dex */
    private static final class f extends b {
        f() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean a(AbstractFuture abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f16051b != dVar) {
                        return false;
                    }
                    abstractFuture.f16051b = dVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f16050a != obj) {
                        return false;
                    }
                    abstractFuture.f16050a = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean c(AbstractFuture abstractFuture, g gVar, g gVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f16052c != gVar) {
                        return false;
                    }
                    abstractFuture.f16052c = gVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        void d(g gVar, g gVar2) {
            gVar.f16070b = gVar2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        void e(g gVar, Thread thread) {
            gVar.f16069a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class g {

        /* renamed from: c, reason: collision with root package name */
        static final g f16068c = new g(false);

        /* renamed from: a, reason: collision with root package name */
        volatile Thread f16069a;

        /* renamed from: b, reason: collision with root package name */
        volatile g f16070b;

        g() {
            AbstractFuture.f16048f.e(this, Thread.currentThread());
        }

        g(boolean z10) {
        }

        void a(g gVar) {
            AbstractFuture.f16048f.d(this, gVar);
        }

        void b() {
            Thread thread = this.f16069a;
            if (thread != null) {
                this.f16069a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            fVar = new f();
        }
        f16048f = fVar;
        if (th != null) {
            f16047e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f16049g = new Object();
    }

    private void b(StringBuilder sb2) {
        try {
            Object o11 = o(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(t(o11));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e11) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e11.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e12) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e12.getCause());
            sb2.append("]");
        }
    }

    private static CancellationException d(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    static Object g(Object obj) {
        obj.getClass();
        return obj;
    }

    private d i(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f16051b;
        } while (!f16048f.a(this, dVar2, d.f16059d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f16062c;
            dVar4.f16062c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    static void k(AbstractFuture abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.r();
            abstractFuture.c();
            d i11 = abstractFuture.i(dVar);
            while (i11 != null) {
                dVar = i11.f16062c;
                Runnable runnable = i11.f16060a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.owner;
                    if (abstractFuture.f16050a == setFuture) {
                        if (f16048f.b(abstractFuture, setFuture, n(setFuture.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    l(runnable, i11.f16061b);
                }
                i11 = dVar;
            }
            return;
        }
    }

    private static void l(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            f16047e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    private Object m(Object obj) {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).f16058b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f16054a);
        }
        if (obj == f16049g) {
            return null;
        }
        return obj;
    }

    static Object n(r rVar) {
        if (rVar instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) rVar).f16050a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f16057a ? cVar.f16058b != null ? new c(false, cVar.f16058b) : c.f16056d : obj;
        }
        boolean isCancelled = rVar.isCancelled();
        if ((!f16046d) && isCancelled) {
            return c.f16056d;
        }
        try {
            Object o11 = o(rVar);
            return o11 == null ? f16049g : o11;
        } catch (CancellationException e11) {
            if (isCancelled) {
                return new c(false, e11);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + rVar, e11));
        } catch (ExecutionException e12) {
            return new Failure(e12.getCause());
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

    private static Object o(Future future) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void r() {
        g gVar;
        do {
            gVar = this.f16052c;
        } while (!f16048f.c(this, gVar, g.f16068c));
        while (gVar != null) {
            gVar.b();
            gVar = gVar.f16070b;
        }
    }

    private void s(g gVar) {
        gVar.f16069a = null;
        while (true) {
            g gVar2 = this.f16052c;
            if (gVar2 == g.f16068c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f16070b;
                if (gVar2.f16069a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f16070b = gVar4;
                    if (gVar3.f16069a == null) {
                        break;
                    }
                } else if (!f16048f.c(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    private String t(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.r
    public final void addListener(Runnable runnable, Executor executor) {
        g(runnable);
        g(executor);
        d dVar = this.f16051b;
        if (dVar != d.f16059d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f16062c = dVar;
                if (f16048f.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f16051b;
                }
            } while (dVar != d.f16059d);
        }
        l(runnable, executor);
    }

    protected void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f16050a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        c cVar = f16046d ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f16055c : c.f16056d;
        AbstractFuture abstractFuture = this;
        boolean z11 = false;
        while (true) {
            if (f16048f.b(abstractFuture, obj, cVar)) {
                if (z10) {
                    abstractFuture.p();
                }
                k(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                r rVar = ((SetFuture) obj).future;
                if (!(rVar instanceof AbstractFuture)) {
                    rVar.cancel(z10);
                    return true;
                }
                abstractFuture = (AbstractFuture) rVar;
                obj = abstractFuture.f16050a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = abstractFuture.f16050a;
                if (!(obj instanceof SetFuture)) {
                    return z11;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f16050a;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return m(obj2);
        }
        g gVar = this.f16052c;
        if (gVar != g.f16068c) {
            g gVar2 = new g();
            do {
                gVar2.a(gVar);
                if (f16048f.c(this, gVar, gVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            s(gVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f16050a;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return m(obj);
                }
                gVar = this.f16052c;
            } while (gVar != g.f16068c);
        }
        return m(this.f16050a);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j11, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j11);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f16050a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return m(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar = this.f16052c;
            if (gVar != g.f16068c) {
                g gVar2 = new g();
                do {
                    gVar2.a(gVar);
                    if (f16048f.c(this, gVar, gVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                s(gVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f16050a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return m(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        s(gVar2);
                    } else {
                        gVar = this.f16052c;
                    }
                } while (gVar != g.f16068c);
            }
            return m(this.f16050a);
        }
        while (nanos > 0) {
            Object obj3 = this.f16050a;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return m(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String abstractFuture = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j11 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j12 = -nanos;
            long convert = timeUnit.convert(j12, TimeUnit.NANOSECONDS);
            long nanos2 = j12 - timeUnit.toNanos(convert);
            boolean z10 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z10) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + abstractFuture);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f16050a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.f16050a != null);
    }

    protected void p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String q() {
        Object obj = this.f16050a;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + t(((SetFuture) obj).future) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                str = q();
            } catch (RuntimeException e11) {
                str = "Exception thrown from implementation: " + e11.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                b(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
