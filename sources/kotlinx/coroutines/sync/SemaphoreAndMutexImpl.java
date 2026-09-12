package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.n;
import kotlinx.coroutines.q;
import kotlinx.coroutines.s2;

/* loaded from: classes7.dex */
public class SemaphoreAndMutexImpl {

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f68090c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f68091d = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f68092e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f68093f = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f68094g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    private final int f68095a;

    /* renamed from: b, reason: collision with root package name */
    private final Function3 f68096b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public SemaphoreAndMutexImpl(int i11, int i12) {
        this.f68095a = i11;
        if (i11 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i11).toString());
        }
        if (i12 < 0 || i12 > i11) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i11).toString());
        }
        l lVar = new l(0L, null, 2);
        this.head$volatile = lVar;
        this.tail$volatile = lVar;
        this._availablePermits$volatile = i11 - i12;
        this.f68096b = new Function3() { // from class: kotlinx.coroutines.sync.i
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit r11;
                r11 = SemaphoreAndMutexImpl.r(SemaphoreAndMutexImpl.this, (Throwable) obj, (Unit) obj2, (CoroutineContext) obj3);
                return r11;
            }
        };
    }

    private final Object i(Continuation continuation) {
        CancellableContinuationImpl b11 = q.b(IntrinsicsKt.c(continuation));
        try {
            if (!j(b11)) {
                g(b11);
            }
            Object result = b11.getResult();
            if (result == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return result == IntrinsicsKt.f() ? result : Unit.f67184a;
        } catch (Throwable th2) {
            b11.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(s2 s2Var) {
        Object c11;
        l lVar = (l) f68092e.get(this);
        long andIncrement = f68093f.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f68092e;
        long h11 = andIncrement / k.h();
        loop0: while (true) {
            c11 = kotlinx.coroutines.internal.a.c(lVar, h11, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (!x.c(c11)) {
                w b11 = x.b(c11);
                while (true) {
                    w wVar = (w) atomicReferenceFieldUpdater.get(this);
                    if (wVar.f68010c >= b11.f68010c) {
                        break loop0;
                    }
                    if (!b11.u()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, wVar, b11)) {
                        if (wVar.p()) {
                            wVar.n();
                        }
                    } else if (b11.p()) {
                        b11.n();
                    }
                }
            } else {
                break;
            }
        }
        l lVar2 = (l) x.b(c11);
        int h12 = (int) (andIncrement % k.h());
        if (kotlinx.coroutines.channels.i.a(lVar2.v(), h12, null, s2Var)) {
            s2Var.invokeOnCancellation(lVar2, h12);
            return true;
        }
        if (!kotlinx.coroutines.channels.i.a(lVar2.v(), h12, k.g(), k.i())) {
            return false;
        }
        if (s2Var instanceof n) {
            Intrinsics.f(s2Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((n) s2Var).resume(Unit.f67184a, this.f68096b);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + s2Var).toString());
    }

    private final void k() {
        int i11;
        do {
            i11 = f68094g.get(this);
            if (i11 <= this.f68095a) {
                return;
            }
        } while (!f68094g.compareAndSet(this, i11, this.f68095a));
    }

    private final int l() {
        int andDecrement;
        do {
            andDecrement = f68094g.getAndDecrement(this);
        } while (andDecrement > this.f68095a);
        return andDecrement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(SemaphoreAndMutexImpl semaphoreAndMutexImpl, Throwable th2, Unit unit, CoroutineContext coroutineContext) {
        semaphoreAndMutexImpl.release();
        return Unit.f67184a;
    }

    private final boolean t(Object obj) {
        if (!(obj instanceof n)) {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n nVar = (n) obj;
        Object tryResume = nVar.tryResume(Unit.f67184a, null, this.f68096b);
        if (tryResume == null) {
            return false;
        }
        nVar.completeResume(tryResume);
        return true;
    }

    private final boolean u() {
        Object c11;
        l lVar = (l) f68090c.get(this);
        long andIncrement = f68091d.getAndIncrement(this);
        long h11 = andIncrement / k.h();
        SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f68090c;
        loop0: while (true) {
            c11 = kotlinx.coroutines.internal.a.c(lVar, h11, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (x.c(c11)) {
                break;
            }
            w b11 = x.b(c11);
            while (true) {
                w wVar = (w) atomicReferenceFieldUpdater.get(this);
                if (wVar.f68010c >= b11.f68010c) {
                    break loop0;
                }
                if (!b11.u()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, wVar, b11)) {
                    if (wVar.p()) {
                        wVar.n();
                    }
                } else if (b11.p()) {
                    b11.n();
                }
            }
        }
        l lVar2 = (l) x.b(c11);
        lVar2.c();
        if (lVar2.f68010c > h11) {
            return false;
        }
        int h12 = (int) (andIncrement % k.h());
        Object andSet = lVar2.v().getAndSet(h12, k.g());
        if (andSet != null) {
            if (andSet == k.e()) {
                return false;
            }
            return t(andSet);
        }
        int f11 = k.f();
        for (int i11 = 0; i11 < f11; i11++) {
            if (lVar2.v().get(h12) == k.i()) {
                return true;
            }
        }
        return !kotlinx.coroutines.channels.i.a(lVar2.v(), h12, k.g(), k.d());
    }

    public final int a() {
        return Math.max(f68094g.get(this), 0);
    }

    public final Object c(Continuation continuation) {
        Object i11;
        return (l() <= 0 && (i11 = i(continuation)) == IntrinsicsKt.f()) ? i11 : Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(n nVar) {
        while (l() <= 0) {
            Intrinsics.f(nVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (j((s2) nVar)) {
                return;
            }
        }
        nVar.resume(Unit.f67184a, this.f68096b);
    }

    public final void release() {
        do {
            int andIncrement = f68094g.getAndIncrement(this);
            if (andIncrement >= this.f68095a) {
                k();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f68095a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!u());
    }

    public final boolean s() {
        while (true) {
            int i11 = f68094g.get(this);
            if (i11 > this.f68095a) {
                k();
            } else {
                if (i11 <= 0) {
                    return false;
                }
                if (f68094g.compareAndSet(this, i11, i11 - 1)) {
                    return true;
                }
            }
        }
    }
}
