package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.n;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.q;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.sync.f;

/* loaded from: classes7.dex */
public class f extends SemaphoreAndMutexImpl implements kotlinx.coroutines.sync.a {

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f68104i = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "owner$volatile");

    /* renamed from: h, reason: collision with root package name */
    private final Function3 f68105h;
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class a implements n, s2 {

        /* renamed from: a, reason: collision with root package name */
        public final CancellableContinuationImpl f68106a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f68107b;

        public a(CancellableContinuationImpl cancellableContinuationImpl, Object obj) {
            this.f68106a = cancellableContinuationImpl;
            this.f68107b = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(f fVar, a aVar, Throwable th2) {
            fVar.unlock(aVar.f68107b);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(f fVar, a aVar, Throwable th2, Unit unit, CoroutineContext coroutineContext) {
            f.x().set(fVar, aVar.f68107b);
            fVar.unlock(aVar.f68107b);
            return Unit.f67184a;
        }

        @Override // kotlinx.coroutines.n
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void resume(Unit unit, Function1 function1) {
            this.f68106a.resume((CancellableContinuationImpl) unit, (Function1<? super Throwable, Unit>) function1);
        }

        @Override // kotlinx.coroutines.n
        public boolean cancel(Throwable th2) {
            return this.f68106a.cancel(th2);
        }

        @Override // kotlinx.coroutines.n
        public void completeResume(Object obj) {
            this.f68106a.completeResume(obj);
        }

        @Override // kotlinx.coroutines.n
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void resume(Unit unit, Function3 function3) {
            f.x().set(f.this, this.f68107b);
            CancellableContinuationImpl cancellableContinuationImpl = this.f68106a;
            final f fVar = f.this;
            cancellableContinuationImpl.resume((CancellableContinuationImpl) unit, new Function1() { // from class: kotlinx.coroutines.sync.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit e11;
                    e11 = f.a.e(f.this, this, (Throwable) obj);
                    return e11;
                }
            });
        }

        @Override // kotlinx.coroutines.n
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void resumeUndispatched(i0 i0Var, Unit unit) {
            this.f68106a.resumeUndispatched(i0Var, unit);
        }

        @Override // kotlinx.coroutines.n
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object tryResume(Unit unit, Object obj, Function3 function3) {
            final f fVar = f.this;
            Object tryResume = this.f68106a.tryResume(unit, obj, new Function3() { // from class: kotlinx.coroutines.sync.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit h11;
                    h11 = f.a.h(f.this, this, (Throwable) obj2, (Unit) obj3, (CoroutineContext) obj4);
                    return h11;
                }
            });
            if (tryResume != null) {
                f.x().set(f.this, this.f68107b);
            }
            return tryResume;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f68106a.getContext();
        }

        @Override // kotlinx.coroutines.n
        public void invokeOnCancellation(Function1 function1) {
            this.f68106a.invokeOnCancellation(function1);
        }

        @Override // kotlinx.coroutines.s2
        public void invokeOnCancellation(w wVar, int i11) {
            this.f68106a.invokeOnCancellation(wVar, i11);
        }

        @Override // kotlinx.coroutines.n
        public boolean isActive() {
            return this.f68106a.isActive();
        }

        @Override // kotlinx.coroutines.n
        public boolean isCompleted() {
            return this.f68106a.isCompleted();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            this.f68106a.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.n
        public Object tryResumeWithException(Throwable th2) {
            return this.f68106a.tryResumeWithException(th2);
        }
    }

    public f(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner$volatile = z10 ? null : g.f68109a;
        this.f68105h = new Function3() { // from class: kotlinx.coroutines.sync.b
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Function3 C;
                f fVar = f.this;
                android.support.v4.media.session.c.a(obj);
                C = f.C(fVar, null, obj2, obj3);
                return C;
            }
        };
    }

    static /* synthetic */ Object A(f fVar, Object obj, Continuation continuation) {
        Object B;
        return (!fVar.b(obj) && (B = fVar.B(obj, continuation)) == IntrinsicsKt.f()) ? B : Unit.f67184a;
    }

    private final Object B(Object obj, Continuation continuation) {
        CancellableContinuationImpl b11 = q.b(IntrinsicsKt.c(continuation));
        try {
            g(new a(b11, obj));
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
    public static final Function3 C(final f fVar, kotlinx.coroutines.selects.f fVar2, final Object obj, Object obj2) {
        return new Function3() { // from class: kotlinx.coroutines.sync.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                Unit D;
                D = f.D(f.this, obj, (Throwable) obj3, obj4, (CoroutineContext) obj5);
                return D;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(f fVar, Object obj, Throwable th2, Object obj2, CoroutineContext coroutineContext) {
        fVar.unlock(obj);
        return Unit.f67184a;
    }

    private final int E(Object obj) {
        while (!s()) {
            if (obj == null) {
                return 1;
            }
            int z10 = z(obj);
            if (z10 == 1) {
                return 2;
            }
            if (z10 == 2) {
                return 1;
            }
        }
        f68104i.set(this, obj);
        return 0;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater x() {
        return f68104i;
    }

    private final int z(Object obj) {
        z zVar;
        while (d()) {
            Object obj2 = f68104i.get(this);
            zVar = g.f68109a;
            if (obj2 != zVar) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean b(Object obj) {
        int E = E(obj);
        if (E == 0) {
            return true;
        }
        if (E == 1) {
            return false;
        }
        if (E != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean d() {
        return a() == 0;
    }

    @Override // kotlinx.coroutines.sync.a
    public Object h(Object obj, Continuation continuation) {
        return A(this, obj, continuation);
    }

    public String toString() {
        return "Mutex@" + p0.b(this) + "[isLocked=" + d() + ",owner=" + f68104i.get(this) + ']';
    }

    @Override // kotlinx.coroutines.sync.a
    public void unlock(Object obj) {
        z zVar;
        z zVar2;
        while (d()) {
            Object obj2 = f68104i.get(this);
            zVar = g.f68109a;
            if (obj2 != zVar) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f68104i;
                zVar2 = g.f68109a;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj2, zVar2)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}
