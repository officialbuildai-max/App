package pz;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.b;
import io.reactivex.rxjava3.core.e;
import io.reactivex.rxjava3.core.g;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.core.p;
import io.reactivex.rxjava3.core.q;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.QueueOverflowException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;
import java.util.concurrent.Executor;
import lz.c;
import lz.f;
import lz.h;
import lz.k;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile f f73139a;

    /* renamed from: b, reason: collision with root package name */
    static volatile h f73140b;

    /* renamed from: c, reason: collision with root package name */
    static volatile h f73141c;

    /* renamed from: d, reason: collision with root package name */
    static volatile h f73142d;

    /* renamed from: e, reason: collision with root package name */
    static volatile h f73143e;

    /* renamed from: f, reason: collision with root package name */
    static volatile h f73144f;

    /* renamed from: g, reason: collision with root package name */
    static volatile h f73145g;

    /* renamed from: h, reason: collision with root package name */
    static volatile h f73146h;

    /* renamed from: i, reason: collision with root package name */
    static volatile h f73147i;

    /* renamed from: j, reason: collision with root package name */
    static volatile h f73148j;

    /* renamed from: k, reason: collision with root package name */
    static volatile h f73149k;

    /* renamed from: l, reason: collision with root package name */
    static volatile h f73150l;

    /* renamed from: m, reason: collision with root package name */
    static volatile h f73151m;

    /* renamed from: n, reason: collision with root package name */
    static volatile c f73152n;

    /* renamed from: o, reason: collision with root package name */
    static volatile c f73153o;

    /* renamed from: p, reason: collision with root package name */
    static volatile c f73154p;

    /* renamed from: q, reason: collision with root package name */
    static volatile c f73155q;

    /* renamed from: r, reason: collision with root package name */
    static volatile c f73156r;

    /* renamed from: s, reason: collision with root package name */
    static volatile boolean f73157s;

    static void A(Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    static Object a(c cVar, Object obj, Object obj2) {
        try {
            return cVar.apply(obj, obj2);
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    static Object b(h hVar, Object obj) {
        try {
            return hVar.apply(obj);
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    static Scheduler c(h hVar, k kVar) {
        Object b11 = b(hVar, kVar);
        Objects.requireNonNull(b11, "Scheduler Supplier result can't be null");
        return (Scheduler) b11;
    }

    static Scheduler d(k kVar) {
        try {
            Object obj = kVar.get();
            Objects.requireNonNull(obj, "Scheduler Supplier result can't be null");
            return (Scheduler) obj;
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }

    public static Scheduler e(Executor executor, boolean z10, boolean z11) {
        return new ExecutorScheduler(executor, z10, z11);
    }

    public static Scheduler f(k kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h hVar = f73141c;
        return hVar == null ? d(kVar) : c(hVar, kVar);
    }

    public static Scheduler g(k kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h hVar = f73143e;
        return hVar == null ? d(kVar) : c(hVar, kVar);
    }

    public static Scheduler h(k kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h hVar = f73144f;
        return hVar == null ? d(kVar) : c(hVar, kVar);
    }

    public static Scheduler i(k kVar) {
        Objects.requireNonNull(kVar, "Scheduler Supplier can't be null");
        h hVar = f73142d;
        return hVar == null ? d(kVar) : c(hVar, kVar);
    }

    static boolean j(Throwable th2) {
        return (th2 instanceof OnErrorNotImplementedException) || (th2 instanceof MissingBackpressureException) || (th2 instanceof QueueOverflowException) || (th2 instanceof IllegalStateException) || (th2 instanceof NullPointerException) || (th2 instanceof IllegalArgumentException) || (th2 instanceof CompositeException);
    }

    public static boolean k() {
        return f73157s;
    }

    public static io.reactivex.rxjava3.core.a l(io.reactivex.rxjava3.core.a aVar) {
        h hVar = f73151m;
        return hVar != null ? (io.reactivex.rxjava3.core.a) b(hVar, aVar) : aVar;
    }

    public static e m(e eVar) {
        h hVar = f73147i;
        return hVar != null ? (e) b(hVar, eVar) : eVar;
    }

    public static g n(g gVar) {
        h hVar = f73149k;
        return hVar != null ? (g) b(hVar, gVar) : gVar;
    }

    public static j o(j jVar) {
        h hVar = f73148j;
        return hVar != null ? (j) b(hVar, jVar) : jVar;
    }

    public static p p(p pVar) {
        h hVar = f73150l;
        return hVar != null ? (p) b(hVar, pVar) : pVar;
    }

    public static boolean q() {
        return false;
    }

    public static void r(Throwable th2) {
        f fVar = f73139a;
        if (th2 == null) {
            th2 = ExceptionHelper.b("onError called with a null Throwable.");
        } else if (!j(th2)) {
            th2 = new UndeliverableException(th2);
        }
        if (fVar != null) {
            try {
                fVar.accept(th2);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                A(th3);
            }
        }
        th2.printStackTrace();
        A(th2);
    }

    public static Scheduler s(Scheduler scheduler) {
        h hVar = f73146h;
        return hVar == null ? scheduler : (Scheduler) b(hVar, scheduler);
    }

    public static Runnable t(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        h hVar = f73140b;
        return hVar == null ? runnable : (Runnable) b(hVar, runnable);
    }

    public static Scheduler u(Scheduler scheduler) {
        h hVar = f73145g;
        return hVar == null ? scheduler : (Scheduler) b(hVar, scheduler);
    }

    public static b v(io.reactivex.rxjava3.core.a aVar, b bVar) {
        c cVar = f73156r;
        return cVar != null ? (b) a(cVar, aVar, bVar) : bVar;
    }

    public static io.reactivex.rxjava3.core.h w(g gVar, io.reactivex.rxjava3.core.h hVar) {
        c cVar = f73153o;
        return cVar != null ? (io.reactivex.rxjava3.core.h) a(cVar, gVar, hVar) : hVar;
    }

    public static o x(j jVar, o oVar) {
        c cVar = f73154p;
        return cVar != null ? (o) a(cVar, jVar, oVar) : oVar;
    }

    public static q y(p pVar, q qVar) {
        c cVar = f73155q;
        return cVar != null ? (q) a(cVar, pVar, qVar) : qVar;
    }

    public static u10.c z(e eVar, u10.c cVar) {
        c cVar2 = f73152n;
        return cVar2 != null ? (u10.c) a(cVar2, eVar, cVar) : cVar;
    }
}
