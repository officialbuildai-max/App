package com.google.common.util.concurrent;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
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
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class AbstractFuture extends gb.a implements r {
    private static final b ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    static final q log;
    private volatile d listeners;
    private volatile Object value;
    private volatile j waiters;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        static final Failure f31024b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        final Throwable f31025a;

        Failure(Throwable th2) {
            this.f31025a = (Throwable) com.google.common.base.m.o(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SetFuture<V> implements Runnable {
        final r future;
        final AbstractFuture owner;

        SetFuture(AbstractFuture abstractFuture, r rVar) {
            this.owner = abstractFuture;
            this.future = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.b(this.owner, this, AbstractFuture.o(this.future))) {
                AbstractFuture.l(this.owner, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class b {
        private b() {
        }

        abstract boolean a(AbstractFuture abstractFuture, d dVar, d dVar2);

        abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        abstract boolean c(AbstractFuture abstractFuture, j jVar, j jVar2);

        abstract d d(AbstractFuture abstractFuture, d dVar);

        abstract j e(AbstractFuture abstractFuture, j jVar);

        abstract void f(j jVar, j jVar2);

        abstract void g(j jVar, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f31026c;

        /* renamed from: d, reason: collision with root package name */
        static final c f31027d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f31028a;

        /* renamed from: b, reason: collision with root package name */
        final Throwable f31029b;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                f31027d = null;
                f31026c = null;
            } else {
                f31027d = new c(false, null);
                f31026c = new c(true, null);
            }
        }

        c(boolean z10, Throwable th2) {
            this.f31028a = z10;
            this.f31029b = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        static final d f31030d = new d();

        /* renamed from: a, reason: collision with root package name */
        final Runnable f31031a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f31032b;

        /* renamed from: c, reason: collision with root package name */
        d f31033c;

        d() {
            this.f31031a = null;
            this.f31032b = null;
        }

        d(Runnable runnable, Executor executor) {
            this.f31031a = runnable;
            this.f31032b = executor;
        }
    }

    /* loaded from: classes4.dex */
    private static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f31034a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f31035b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f31036c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f31037d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f31038e;

        e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f31034a = atomicReferenceFieldUpdater;
            this.f31035b = atomicReferenceFieldUpdater2;
            this.f31036c = atomicReferenceFieldUpdater3;
            this.f31037d = atomicReferenceFieldUpdater4;
            this.f31038e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean a(AbstractFuture abstractFuture, d dVar, d dVar2) {
            return androidx.concurrent.futures.a.a(this.f31037d, abstractFuture, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f31038e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean c(AbstractFuture abstractFuture, j jVar, j jVar2) {
            return androidx.concurrent.futures.a.a(this.f31036c, abstractFuture, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        d d(AbstractFuture abstractFuture, d dVar) {
            return (d) this.f31037d.getAndSet(abstractFuture, dVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        j e(AbstractFuture abstractFuture, j jVar) {
            return (j) this.f31036c.getAndSet(abstractFuture, jVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void f(j jVar, j jVar2) {
            this.f31035b.lazySet(jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void g(j jVar, Thread thread) {
            this.f31034a.lazySet(jVar, thread);
        }
    }

    /* loaded from: classes4.dex */
    private static final class f extends b {
        private f() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean a(AbstractFuture abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.listeners != dVar) {
                        return false;
                    }
                    abstractFuture.listeners = dVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.value != obj) {
                        return false;
                    }
                    abstractFuture.value = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean c(AbstractFuture abstractFuture, j jVar, j jVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.waiters != jVar) {
                        return false;
                    }
                    abstractFuture.waiters = jVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        d d(AbstractFuture abstractFuture, d dVar) {
            d dVar2;
            synchronized (abstractFuture) {
                try {
                    dVar2 = abstractFuture.listeners;
                    if (dVar2 != dVar) {
                        abstractFuture.listeners = dVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        j e(AbstractFuture abstractFuture, j jVar) {
            j jVar2;
            synchronized (abstractFuture) {
                try {
                    jVar2 = abstractFuture.waiters;
                    if (jVar2 != jVar) {
                        abstractFuture.waiters = jVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return jVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void f(j jVar, j jVar2) {
            jVar.f31047b = jVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void g(j jVar, Thread thread) {
            jVar.f31046a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface g extends r {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class h extends AbstractFuture implements g {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.r
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z10) {
            return super.cancel(z10);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public Object get() throws InterruptedException, ExecutionException {
            return super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final Object get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return super.get(j11, timeUnit);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    /* loaded from: classes4.dex */
    private static final class i extends b {

        /* renamed from: a, reason: collision with root package name */
        static final Unsafe f31039a;

        /* renamed from: b, reason: collision with root package name */
        static final long f31040b;

        /* renamed from: c, reason: collision with root package name */
        static final long f31041c;

        /* renamed from: d, reason: collision with root package name */
        static final long f31042d;

        /* renamed from: e, reason: collision with root package name */
        static final long f31043e;

        /* renamed from: f, reason: collision with root package name */
        static final long f31044f;

        /* loaded from: classes4.dex */
        class a implements PrivilegedExceptionAction {
            a() {
            }

            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e11) {
                    throw new RuntimeException("Could not initialize intrinsics", e11.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                f31041c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                f31040b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                f31042d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                f31043e = unsafe.objectFieldOffset(j.class.getDeclaredField("a"));
                f31044f = unsafe.objectFieldOffset(j.class.getDeclaredField(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
                f31039a = unsafe;
            } catch (NoSuchFieldException e12) {
                throw new RuntimeException(e12);
            }
        }

        private i() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean a(AbstractFuture abstractFuture, d dVar, d dVar2) {
            return com.google.android.libraries.places.internal.a.a(f31039a, abstractFuture, f31040b, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return com.google.android.libraries.places.internal.a.a(f31039a, abstractFuture, f31042d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean c(AbstractFuture abstractFuture, j jVar, j jVar2) {
            return com.google.android.libraries.places.internal.a.a(f31039a, abstractFuture, f31041c, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        d d(AbstractFuture abstractFuture, d dVar) {
            d dVar2;
            do {
                dVar2 = abstractFuture.listeners;
                if (dVar == dVar2) {
                    return dVar2;
                }
            } while (!a(abstractFuture, dVar2, dVar));
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        j e(AbstractFuture abstractFuture, j jVar) {
            j jVar2;
            do {
                jVar2 = abstractFuture.waiters;
                if (jVar == jVar2) {
                    return jVar2;
                }
            } while (!c(abstractFuture, jVar2, jVar));
            return jVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void f(j jVar, j jVar2) {
            f31039a.putObject(jVar, f31044f, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void g(j jVar, Thread thread) {
            f31039a.putObject(jVar, f31043e, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class j {

        /* renamed from: c, reason: collision with root package name */
        static final j f31045c = new j(false);

        /* renamed from: a, reason: collision with root package name */
        volatile Thread f31046a;

        /* renamed from: b, reason: collision with root package name */
        volatile j f31047b;

        j() {
            AbstractFuture.ATOMIC_HELPER.g(this, Thread.currentThread());
        }

        j(boolean z10) {
        }

        void a(j jVar) {
            AbstractFuture.ATOMIC_HELPER.f(this, jVar);
        }

        void b() {
            Thread thread = this.f31046a;
            if (thread != null) {
                this.f31046a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.common.util.concurrent.AbstractFuture$e] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.common.util.concurrent.AbstractFuture$a] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.common.util.concurrent.AbstractFuture$i] */
    static {
        boolean z10;
        f fVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        GENERATE_CANCELLATION_CAUSES = z10;
        log = new q(AbstractFuture.class);
        ?? r12 = 0;
        r12 = 0;
        try {
            fVar = new i();
            e = null;
        } catch (Error | Exception e11) {
            e = e11;
            try {
                fVar = new e(AtomicReferenceFieldUpdater.newUpdater(j.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(j.class, j.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, j.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, AppMeasurementSdk.ConditionalUserProperty.VALUE));
            } catch (Error | Exception e12) {
                fVar = new f();
                r12 = e12;
            }
        }
        ATOMIC_HELPER = fVar;
        if (r12 != 0) {
            q qVar = log;
            Logger a11 = qVar.a();
            Level level = Level.SEVERE;
            a11.log(level, "UnsafeAtomicHelper is broken!", e);
            qVar.a().log(level, "SafeAtomicHelper is broken!", r12);
        }
        NULL = new Object();
    }

    private void b(StringBuilder sb2) {
        try {
            Object p11 = p(this);
            sb2.append("SUCCESS, result=[");
            d(sb2, p11);
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        } catch (Exception e12) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e12.getClass());
            sb2.append(" thrown from get()]");
        }
    }

    private void c(StringBuilder sb2) {
        String str;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            sb2.append(", setFuture=[");
            g(sb2, ((SetFuture) obj).future);
            sb2.append("]");
        } else {
            try {
                str = com.google.common.base.p.a(pendingToString());
            } catch (Exception | StackOverflowError e11) {
                str = "Exception thrown from implementation: " + e11.getClass();
            }
            if (str != null) {
                sb2.append(", info=[");
                sb2.append(str);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            b(sb2);
        }
    }

    private void d(StringBuilder sb2, Object obj) {
        if (obj == null) {
            sb2.append("null");
        } else {
            if (obj == this) {
                sb2.append("this future");
                return;
            }
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void g(StringBuilder sb2, Object obj) {
        try {
            if (obj == this) {
                sb2.append("this future");
            } else {
                sb2.append(obj);
            }
        } catch (Exception e11) {
            e = e11;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        } catch (StackOverflowError e12) {
            e = e12;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        }
    }

    private static CancellationException i(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    private d k(d dVar) {
        d dVar2 = dVar;
        d d11 = ATOMIC_HELPER.d(this, d.f31030d);
        while (d11 != null) {
            d dVar3 = d11.f31033c;
            d11.f31033c = dVar2;
            dVar2 = d11;
            d11 = dVar3;
        }
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(AbstractFuture abstractFuture, boolean z10) {
        d dVar = null;
        while (true) {
            abstractFuture.q();
            if (z10) {
                abstractFuture.interruptTask();
                z10 = false;
            }
            abstractFuture.afterDone();
            d k11 = abstractFuture.k(dVar);
            while (k11 != null) {
                dVar = k11.f31033c;
                Runnable runnable = k11.f31031a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable2;
                    abstractFuture = setFuture.owner;
                    if (abstractFuture.value == setFuture) {
                        if (ATOMIC_HELPER.b(abstractFuture, setFuture, o(setFuture.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = k11.f31032b;
                    Objects.requireNonNull(executor);
                    m(runnable2, executor);
                }
                k11 = dVar;
            }
            return;
        }
    }

    private static void m(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e11) {
            log.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e11);
        }
    }

    private Object n(Object obj) {
        if (obj instanceof c) {
            throw i("Task was cancelled.", ((c) obj).f31029b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f31025a);
        }
        return obj == NULL ? u.b() : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object o(r rVar) {
        Throwable a11;
        if (rVar instanceof g) {
            Object obj = ((AbstractFuture) rVar).value;
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f31028a) {
                    obj = cVar.f31029b != null ? new c(false, cVar.f31029b) : c.f31027d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        }
        if ((rVar instanceof gb.a) && (a11 = gb.b.a((gb.a) rVar)) != null) {
            return new Failure(a11);
        }
        boolean isCancelled = rVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            c cVar2 = c.f31027d;
            Objects.requireNonNull(cVar2);
            return cVar2;
        }
        try {
            Object p11 = p(rVar);
            if (!isCancelled) {
                return p11 == null ? NULL : p11;
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + rVar));
        } catch (Error e11) {
            e = e11;
            return new Failure(e);
        } catch (CancellationException e12) {
            if (isCancelled) {
                return new c(false, e12);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + rVar, e12));
        } catch (ExecutionException e13) {
            if (!isCancelled) {
                return new Failure(e13.getCause());
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + rVar, e13));
        } catch (Exception e14) {
            e = e14;
            return new Failure(e);
        }
    }

    private static Object p(Future future) {
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

    private void q() {
        for (j e11 = ATOMIC_HELPER.e(this, j.f31045c); e11 != null; e11 = e11.f31047b) {
            e11.b();
        }
    }

    private void r(j jVar) {
        jVar.f31046a = null;
        while (true) {
            j jVar2 = this.waiters;
            if (jVar2 == j.f31045c) {
                return;
            }
            j jVar3 = null;
            while (jVar2 != null) {
                j jVar4 = jVar2.f31047b;
                if (jVar2.f31046a != null) {
                    jVar3 = jVar2;
                } else if (jVar3 != null) {
                    jVar3.f31047b = jVar4;
                    if (jVar3.f31046a == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.c(this, jVar2, jVar4)) {
                    break;
                }
                jVar2 = jVar4;
            }
            return;
        }
    }

    @Override // com.google.common.util.concurrent.r
    public void addListener(Runnable runnable, Executor executor) {
        d dVar;
        com.google.common.base.m.p(runnable, "Runnable was null.");
        com.google.common.base.m.p(executor, "Executor was null.");
        if (!isDone() && (dVar = this.listeners) != d.f31030d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f31033c = dVar;
                if (ATOMIC_HELPER.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.listeners;
                }
            } while (dVar != d.f31030d);
        }
        m(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        c cVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cVar = new c(z10, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z10 ? c.f31026c : c.f31027d;
            Objects.requireNonNull(cVar);
        }
        AbstractFuture abstractFuture = this;
        boolean z11 = false;
        while (true) {
            if (ATOMIC_HELPER.b(abstractFuture, obj, cVar)) {
                l(abstractFuture, z10);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                r rVar = ((SetFuture) obj).future;
                if (!(rVar instanceof g)) {
                    rVar.cancel(z10);
                    return true;
                }
                abstractFuture = (AbstractFuture) rVar;
                obj = abstractFuture.value;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z11;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return n(obj2);
        }
        j jVar = this.waiters;
        if (jVar != j.f31045c) {
            j jVar2 = new j();
            do {
                jVar2.a(jVar);
                if (ATOMIC_HELPER.c(this, jVar, jVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            r(jVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return n(obj);
                }
                jVar = this.waiters;
            } while (jVar != j.f31045c);
        }
        Object obj3 = this.value;
        Objects.requireNonNull(obj3);
        return n(obj3);
    }

    @Override // java.util.concurrent.Future
    public Object get(long j11, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j11);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return n(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            j jVar = this.waiters;
            if (jVar != j.f31045c) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (ATOMIC_HELPER.c(this, jVar, jVar2)) {
                        do {
                            v.a(this, nanos);
                            if (Thread.interrupted()) {
                                r(jVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return n(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        r(jVar2);
                    } else {
                        jVar = this.waiters;
                    }
                } while (jVar != j.f31045c);
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return n(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.value;
            if ((obj4 != null) && (!(obj4 instanceof SetFuture))) {
                return n(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String abstractFuture = toString();
        String obj5 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj5.toLowerCase(locale);
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

    protected void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.value != null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean set(Object obj) {
        if (obj == null) {
            obj = NULL;
        }
        if (!ATOMIC_HELPER.b(this, null, obj)) {
            return false;
        }
        l(this, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.b(this, null, new Failure((Throwable) com.google.common.base.m.o(th2)))) {
            return false;
        }
        l(this, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setFuture(r rVar) {
        Failure failure;
        com.google.common.base.m.o(rVar);
        Object obj = this.value;
        if (obj == null) {
            if (rVar.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, o(rVar))) {
                    return false;
                }
                l(this, false);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, rVar);
            if (ATOMIC_HELPER.b(this, null, setFuture)) {
                try {
                    rVar.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th2) {
                    try {
                        failure = new Failure(th2);
                    } catch (Error | Exception unused) {
                        failure = Failure.f31024b;
                    }
                    ATOMIC_HELPER.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            rVar.cancel(((c) obj).f31028a);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            c(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gb.a
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof g)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).f31025a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).f31028a;
    }
}
