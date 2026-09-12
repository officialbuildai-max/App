package androidx.concurrent.futures;

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
public abstract class AbstractResolvableFuture implements r {

    /* renamed from: d, reason: collision with root package name */
    static final boolean f6640d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    private static final Logger f6641e = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* renamed from: f, reason: collision with root package name */
    static final b f6642f;

    /* renamed from: g, reason: collision with root package name */
    private static final Object f6643g;

    /* renamed from: a, reason: collision with root package name */
    volatile Object f6644a;

    /* renamed from: b, reason: collision with root package name */
    volatile d f6645b;

    /* renamed from: c, reason: collision with root package name */
    volatile g f6646c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        static final Failure f6647b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        final Throwable f6648a;

        Failure(Throwable th2) {
            this.f6648a = (Throwable) AbstractResolvableFuture.i(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SetFuture<V> implements Runnable {
        final r future;
        final AbstractResolvableFuture owner;

        SetFuture(AbstractResolvableFuture abstractResolvableFuture, r rVar) {
            this.owner = abstractResolvableFuture;
            this.future = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.f6644a != this) {
                return;
            }
            if (AbstractResolvableFuture.f6642f.b(this.owner, this, AbstractResolvableFuture.o(this.future))) {
                AbstractResolvableFuture.l(this.owner);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b {
        private b() {
        }

        abstract boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2);

        abstract boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

        abstract boolean c(AbstractResolvableFuture abstractResolvableFuture, g gVar, g gVar2);

        abstract void d(g gVar, g gVar2);

        abstract void e(g gVar, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f6649c;

        /* renamed from: d, reason: collision with root package name */
        static final c f6650d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f6651a;

        /* renamed from: b, reason: collision with root package name */
        final Throwable f6652b;

        static {
            if (AbstractResolvableFuture.f6640d) {
                f6650d = null;
                f6649c = null;
            } else {
                f6650d = new c(false, null);
                f6649c = new c(true, null);
            }
        }

        c(boolean z10, Throwable th2) {
            this.f6651a = z10;
            this.f6652b = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        static final d f6653d = new d(null, null);

        /* renamed from: a, reason: collision with root package name */
        final Runnable f6654a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f6655b;

        /* renamed from: c, reason: collision with root package name */
        d f6656c;

        d(Runnable runnable, Executor executor) {
            this.f6654a = runnable;
            this.f6655b = executor;
        }
    }

    /* loaded from: classes.dex */
    private static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f6657a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f6658b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f6659c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f6660d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f6661e;

        e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f6657a = atomicReferenceFieldUpdater;
            this.f6658b = atomicReferenceFieldUpdater2;
            this.f6659c = atomicReferenceFieldUpdater3;
            this.f6660d = atomicReferenceFieldUpdater4;
            this.f6661e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f6660d, abstractResolvableFuture, dVar, dVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f6661e, abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        boolean c(AbstractResolvableFuture abstractResolvableFuture, g gVar, g gVar2) {
            return androidx.concurrent.futures.a.a(this.f6659c, abstractResolvableFuture, gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        void d(g gVar, g gVar2) {
            this.f6658b.lazySet(gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        void e(g gVar, Thread thread) {
            this.f6657a.lazySet(gVar, thread);
        }
    }

    /* loaded from: classes.dex */
    private static final class f extends b {
        f() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        boolean a(AbstractResolvableFuture abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f6645b != dVar) {
                        return false;
                    }
                    abstractResolvableFuture.f6645b = dVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        boolean b(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f6644a != obj) {
                        return false;
                    }
                    abstractResolvableFuture.f6644a = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        boolean c(AbstractResolvableFuture abstractResolvableFuture, g gVar, g gVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f6646c != gVar) {
                        return false;
                    }
                    abstractResolvableFuture.f6646c = gVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        void d(g gVar, g gVar2) {
            gVar.f6664b = gVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        void e(g gVar, Thread thread) {
            gVar.f6663a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: c, reason: collision with root package name */
        static final g f6662c = new g(false);

        /* renamed from: a, reason: collision with root package name */
        volatile Thread f6663a;

        /* renamed from: b, reason: collision with root package name */
        volatile g f6664b;

        g() {
            AbstractResolvableFuture.f6642f.e(this, Thread.currentThread());
        }

        g(boolean z10) {
        }

        void a(g gVar) {
            AbstractResolvableFuture.f6642f.d(this, gVar);
        }

        void b() {
            Thread thread = this.f6663a;
            if (thread != null) {
                this.f6663a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            fVar = new f();
        }
        f6642f = fVar;
        if (th != null) {
            f6641e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f6643g = new Object();
    }

    private void b(StringBuilder sb2) {
        try {
            Object p11 = p(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(w(p11));
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

    private static CancellationException g(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    static Object i(Object obj) {
        obj.getClass();
        return obj;
    }

    private d k(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f6645b;
        } while (!f6642f.a(this, dVar2, d.f6653d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f6656c;
            dVar4.f6656c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    static void l(AbstractResolvableFuture abstractResolvableFuture) {
        d dVar = null;
        while (true) {
            abstractResolvableFuture.s();
            abstractResolvableFuture.d();
            d k11 = abstractResolvableFuture.k(dVar);
            while (k11 != null) {
                dVar = k11.f6656c;
                Runnable runnable = k11.f6654a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractResolvableFuture = setFuture.owner;
                    if (abstractResolvableFuture.f6644a == setFuture) {
                        if (f6642f.b(abstractResolvableFuture, setFuture, o(setFuture.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    m(runnable, k11.f6655b);
                }
                k11 = dVar;
            }
            return;
        }
    }

    private static void m(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            f6641e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    private Object n(Object obj) {
        if (obj instanceof c) {
            throw g("Task was cancelled.", ((c) obj).f6652b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f6648a);
        }
        if (obj == f6643g) {
            return null;
        }
        return obj;
    }

    static Object o(r rVar) {
        if (rVar instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) rVar).f6644a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f6651a ? cVar.f6652b != null ? new c(false, cVar.f6652b) : c.f6650d : obj;
        }
        boolean isCancelled = rVar.isCancelled();
        if ((!f6640d) && isCancelled) {
            return c.f6650d;
        }
        try {
            Object p11 = p(rVar);
            return p11 == null ? f6643g : p11;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object p(Future future) {
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

    private void s() {
        g gVar;
        do {
            gVar = this.f6646c;
        } while (!f6642f.c(this, gVar, g.f6662c));
        while (gVar != null) {
            gVar.b();
            gVar = gVar.f6664b;
        }
    }

    private void t(g gVar) {
        gVar.f6663a = null;
        while (true) {
            g gVar2 = this.f6646c;
            if (gVar2 == g.f6662c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f6664b;
                if (gVar2.f6663a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f6664b = gVar4;
                    if (gVar3.f6663a == null) {
                        break;
                    }
                } else if (!f6642f.c(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    private String w(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.r
    public final void addListener(Runnable runnable, Executor executor) {
        i(runnable);
        i(executor);
        d dVar = this.f6645b;
        if (dVar != d.f6653d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f6656c = dVar;
                if (f6642f.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f6645b;
                }
            } while (dVar != d.f6653d);
        }
        m(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f6644a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        c cVar = f6640d ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f6649c : c.f6650d;
        AbstractResolvableFuture abstractResolvableFuture = this;
        boolean z11 = false;
        while (true) {
            if (f6642f.b(abstractResolvableFuture, obj, cVar)) {
                if (z10) {
                    abstractResolvableFuture.q();
                }
                l(abstractResolvableFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                r rVar = ((SetFuture) obj).future;
                if (!(rVar instanceof AbstractResolvableFuture)) {
                    rVar.cancel(z10);
                    return true;
                }
                abstractResolvableFuture = (AbstractResolvableFuture) rVar;
                obj = abstractResolvableFuture.f6644a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = abstractResolvableFuture.f6644a;
                if (!(obj instanceof SetFuture)) {
                    return z11;
                }
            }
        }
    }

    protected void d() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f6644a;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return n(obj2);
        }
        g gVar = this.f6646c;
        if (gVar != g.f6662c) {
            g gVar2 = new g();
            do {
                gVar2.a(gVar);
                if (f6642f.c(this, gVar, gVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            t(gVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f6644a;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return n(obj);
                }
                gVar = this.f6646c;
            } while (gVar != g.f6662c);
        }
        return n(this.f6644a);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j11, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j11);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f6644a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return n(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar = this.f6646c;
            if (gVar != g.f6662c) {
                g gVar2 = new g();
                do {
                    gVar2.a(gVar);
                    if (f6642f.c(this, gVar, gVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                t(gVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f6644a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return n(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        t(gVar2);
                    } else {
                        gVar = this.f6646c;
                    }
                } while (gVar != g.f6662c);
            }
            return n(this.f6644a);
        }
        while (nanos > 0) {
            Object obj3 = this.f6644a;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return n(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String abstractResolvableFuture = toString();
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
        throw new TimeoutException(str + " for " + abstractResolvableFuture);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f6644a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.f6644a != null);
    }

    protected void q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String r() {
        Object obj = this.f6644a;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + w(((SetFuture) obj).future) + "]";
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
                str = r();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u(Object obj) {
        if (obj == null) {
            obj = f6643g;
        }
        if (!f6642f.b(this, null, obj)) {
            return false;
        }
        l(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v(Throwable th2) {
        if (!f6642f.b(this, null, new Failure((Throwable) i(th2)))) {
            return false;
        }
        l(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x() {
        Object obj = this.f6644a;
        return (obj instanceof c) && ((c) obj).f6651a;
    }
}
