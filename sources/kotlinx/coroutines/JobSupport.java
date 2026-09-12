package kotlinx.coroutines;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public class JobSupport implements t1, v, f2 {
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/JobSupport;", "job", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "Lkotlinx/coroutines/t1;", "parent", "", "getContinuationCancellationCause", "(Lkotlinx/coroutines/t1;)Ljava/lang/Throwable;", "", "nameString", "()Ljava/lang/String;", "Lkotlinx/coroutines/JobSupport;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @SourceDebugExtension
    /* loaded from: classes.dex */
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(t1 parent) {
            Throwable e11;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof b) || (e11 = ((b) state$kotlinx_coroutines_core).e()) == null) ? state$kotlinx_coroutines_core instanceof b0 ? ((b0) state$kotlinx_coroutines_core).f67764a : parent.getCancellationException() : e11;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class a extends w1 {

        /* renamed from: e, reason: collision with root package name */
        private final JobSupport f67738e;

        /* renamed from: f, reason: collision with root package name */
        private final b f67739f;

        /* renamed from: g, reason: collision with root package name */
        private final u f67740g;

        /* renamed from: h, reason: collision with root package name */
        private final Object f67741h;

        public a(JobSupport jobSupport, b bVar, u uVar, Object obj) {
            this.f67738e = jobSupport;
            this.f67739f = bVar;
            this.f67740g = uVar;
            this.f67741h = obj;
        }

        @Override // kotlinx.coroutines.w1
        public boolean u() {
            return false;
        }

        @Override // kotlinx.coroutines.w1
        public void v(Throwable th2) {
            this.f67738e.x(this.f67739f, this.f67740g, this.f67741h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements p1 {

        /* renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f67742b = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isCompleting$volatile");

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f67743c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_rootCause$volatile");

        /* renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f67744d = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* renamed from: a, reason: collision with root package name */
        private final b2 f67745a;

        public b(b2 b2Var, boolean z10, Throwable th2) {
            this.f67745a = b2Var;
            this._isCompleting$volatile = z10 ? 1 : 0;
            this._rootCause$volatile = th2;
        }

        private final ArrayList c() {
            return new ArrayList(4);
        }

        private final Object d() {
            return f67744d.get(this);
        }

        private final void n(Object obj) {
            f67744d.set(this, obj);
        }

        public final void a(Throwable th2) {
            Throwable e11 = e();
            if (e11 == null) {
                o(th2);
                return;
            }
            if (th2 == e11) {
                return;
            }
            Object d11 = d();
            if (d11 == null) {
                n(th2);
                return;
            }
            if (d11 instanceof Throwable) {
                if (th2 == d11) {
                    return;
                }
                ArrayList c11 = c();
                c11.add(d11);
                c11.add(th2);
                n(c11);
                return;
            }
            if (d11 instanceof ArrayList) {
                ((ArrayList) d11).add(th2);
                return;
            }
            throw new IllegalStateException(("State is " + d11).toString());
        }

        @Override // kotlinx.coroutines.p1
        public b2 b() {
            return this.f67745a;
        }

        public final Throwable e() {
            return (Throwable) f67743c.get(this);
        }

        public final boolean i() {
            return e() != null;
        }

        @Override // kotlinx.coroutines.p1
        public boolean isActive() {
            return e() == null;
        }

        public final boolean j() {
            return f67742b.get(this) != 0;
        }

        public final boolean k() {
            kotlinx.coroutines.internal.z zVar;
            Object d11 = d();
            zVar = x1.f68132e;
            return d11 == zVar;
        }

        public final List l(Throwable th2) {
            ArrayList arrayList;
            kotlinx.coroutines.internal.z zVar;
            Object d11 = d();
            if (d11 == null) {
                arrayList = c();
            } else if (d11 instanceof Throwable) {
                ArrayList c11 = c();
                c11.add(d11);
                arrayList = c11;
            } else {
                if (!(d11 instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + d11).toString());
                }
                arrayList = (ArrayList) d11;
            }
            Throwable e11 = e();
            if (e11 != null) {
                arrayList.add(0, e11);
            }
            if (th2 != null && !Intrinsics.c(th2, e11)) {
                arrayList.add(th2);
            }
            zVar = x1.f68132e;
            n(zVar);
            return arrayList;
        }

        public final void m(boolean z10) {
            f67742b.set(this, z10 ? 1 : 0);
        }

        public final void o(Throwable th2) {
            f67743c.set(this, th2);
        }

        public String toString() {
            return "Finishing[cancelling=" + i() + ", completing=" + j() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + b() + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class c extends w1 {
        public c(kotlinx.coroutines.selects.f fVar) {
        }

        @Override // kotlinx.coroutines.w1
        public boolean u() {
            return false;
        }

        @Override // kotlinx.coroutines.w1
        public void v(Throwable th2) {
            Object state$kotlinx_coroutines_core = JobSupport.this.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof b0)) {
                x1.h(state$kotlinx_coroutines_core);
            }
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class d extends w1 {
        public d(kotlinx.coroutines.selects.f fVar) {
        }

        @Override // kotlinx.coroutines.w1
        public boolean u() {
            return false;
        }

        @Override // kotlinx.coroutines.w1
        public void v(Throwable th2) {
            Unit unit = Unit.f67184a;
            throw null;
        }
    }

    public JobSupport(boolean z10) {
        this._state$volatile = z10 ? x1.f68134g : x1.f68133f;
    }

    private final Throwable A(Object obj) {
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null) {
            return b0Var.f67764a;
        }
        return null;
    }

    private final Throwable B(b bVar, List list) {
        Object obj;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (bVar.i()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th2 = (Throwable) obj;
        if (th2 != null) {
            return th2;
        }
        Throwable th3 = (Throwable) list.get(0);
        if (th3 instanceof TimeoutCancellationException) {
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th4 = (Throwable) next;
                if (th4 != th3 && (th4 instanceof TimeoutCancellationException)) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th5 = (Throwable) obj2;
            if (th5 != null) {
                return th5;
            }
        }
        return th3;
    }

    private final b2 C(p1 p1Var) {
        b2 b11 = p1Var.b();
        if (b11 != null) {
            return b11;
        }
        if (p1Var instanceof d1) {
            return new b2();
        }
        if (p1Var instanceof w1) {
            O((w1) p1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + p1Var).toString());
    }

    private final boolean F() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof p1)) {
                return false;
            }
        } while (Q(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object G(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        q.a(cancellableContinuationImpl, v1.m(this, false, new h2(cancellableContinuationImpl), 1, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    private final Object H(Object obj) {
        kotlinx.coroutines.internal.z zVar;
        kotlinx.coroutines.internal.z zVar2;
        kotlinx.coroutines.internal.z zVar3;
        kotlinx.coroutines.internal.z zVar4;
        kotlinx.coroutines.internal.z zVar5;
        kotlinx.coroutines.internal.z zVar6;
        Throwable th2 = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof b) {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((b) state$kotlinx_coroutines_core).k()) {
                        zVar2 = x1.f68131d;
                        return zVar2;
                    }
                    boolean i11 = ((b) state$kotlinx_coroutines_core).i();
                    if (obj != null || !i11) {
                        if (th2 == null) {
                            th2 = y(obj);
                        }
                        ((b) state$kotlinx_coroutines_core).a(th2);
                    }
                    Throwable e11 = i11 ? null : ((b) state$kotlinx_coroutines_core).e();
                    if (e11 != null) {
                        J(((b) state$kotlinx_coroutines_core).b(), e11);
                    }
                    zVar = x1.f68128a;
                    return zVar;
                }
            }
            if (!(state$kotlinx_coroutines_core instanceof p1)) {
                zVar3 = x1.f68131d;
                return zVar3;
            }
            if (th2 == null) {
                th2 = y(obj);
            }
            p1 p1Var = (p1) state$kotlinx_coroutines_core;
            if (!p1Var.isActive()) {
                Object U = U(state$kotlinx_coroutines_core, new b0(th2, false, 2, null));
                zVar5 = x1.f68128a;
                if (U == zVar5) {
                    throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core).toString());
                }
                zVar6 = x1.f68130c;
                if (U != zVar6) {
                    return U;
                }
            } else if (T(p1Var, th2)) {
                zVar4 = x1.f68128a;
                return zVar4;
            }
        }
    }

    private final u I(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.p()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.l();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
            if (!lockFreeLinkedListNode.p()) {
                if (lockFreeLinkedListNode instanceof u) {
                    return (u) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof b2) {
                    return null;
                }
            }
        }
    }

    private final void J(b2 b2Var, Throwable th2) {
        onCancelling(th2);
        b2Var.f(4);
        Object j11 = b2Var.j();
        Intrinsics.f(j11, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) j11; !Intrinsics.c(lockFreeLinkedListNode, b2Var); lockFreeLinkedListNode = lockFreeLinkedListNode.k()) {
            if ((lockFreeLinkedListNode instanceof w1) && ((w1) lockFreeLinkedListNode).u()) {
                try {
                    ((w1) lockFreeLinkedListNode).v(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNode + " for " + this, th3);
                        Unit unit = Unit.f67184a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        v(th2);
    }

    private final void K(b2 b2Var, Throwable th2) {
        b2Var.f(1);
        Object j11 = b2Var.j();
        Intrinsics.f(j11, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) j11; !Intrinsics.c(lockFreeLinkedListNode, b2Var); lockFreeLinkedListNode = lockFreeLinkedListNode.k()) {
            if (lockFreeLinkedListNode instanceof w1) {
                try {
                    ((w1) lockFreeLinkedListNode).v(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNode + " for " + this, th3);
                        Unit unit = Unit.f67184a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object L(Object obj, Object obj2) {
        if (obj2 instanceof b0) {
            throw ((b0) obj2).f67764a;
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(kotlinx.coroutines.selects.f fVar, Object obj) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof p1)) {
                if (!(state$kotlinx_coroutines_core instanceof b0)) {
                    state$kotlinx_coroutines_core = x1.h(state$kotlinx_coroutines_core);
                }
                fVar.a(state$kotlinx_coroutines_core);
                return;
            }
        } while (Q(state$kotlinx_coroutines_core) < 0);
        fVar.b(v1.m(this, false, new c(fVar), 1, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.o1] */
    private final void N(d1 d1Var) {
        b2 b2Var = new b2();
        if (!d1Var.isActive()) {
            b2Var = new o1(b2Var);
        }
        androidx.concurrent.futures.a.a(_state$volatile$FU, this, d1Var, b2Var);
    }

    private final void O(w1 w1Var) {
        w1Var.e(new b2());
        androidx.concurrent.futures.a.a(_state$volatile$FU, this, w1Var, w1Var.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(kotlinx.coroutines.selects.f fVar, Object obj) {
        if (F()) {
            fVar.b(v1.m(this, false, new d(fVar), 1, null));
        } else {
            fVar.a(Unit.f67184a);
        }
    }

    private final int Q(Object obj) {
        d1 d1Var;
        if (!(obj instanceof d1)) {
            if (!(obj instanceof o1)) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(_state$volatile$FU, this, obj, ((o1) obj).b())) {
                return -1;
            }
            onStart();
            return 1;
        }
        if (((d1) obj).isActive()) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        d1Var = x1.f68134g;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, d1Var)) {
            return -1;
        }
        onStart();
        return 1;
    }

    private final String R(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof p1 ? ((p1) obj).isActive() ? "Active" : "New" : obj instanceof b0 ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.i() ? "Cancelling" : bVar.j() ? "Completing" : "Active";
    }

    private final boolean S(p1 p1Var, Object obj) {
        if (!androidx.concurrent.futures.a.a(_state$volatile$FU, this, p1Var, x1.g(obj))) {
            return false;
        }
        onCancelling(null);
        onCompletionInternal(obj);
        w(p1Var, obj);
        return true;
    }

    private final boolean T(p1 p1Var, Throwable th2) {
        b2 C = C(p1Var);
        if (C == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(_state$volatile$FU, this, p1Var, new b(C, false, th2))) {
            return false;
        }
        J(C, th2);
        return true;
    }

    private final Object U(Object obj, Object obj2) {
        kotlinx.coroutines.internal.z zVar;
        kotlinx.coroutines.internal.z zVar2;
        if (!(obj instanceof p1)) {
            zVar2 = x1.f68128a;
            return zVar2;
        }
        if ((!(obj instanceof d1) && !(obj instanceof w1)) || (obj instanceof u) || (obj2 instanceof b0)) {
            return V((p1) obj, obj2);
        }
        if (S((p1) obj, obj2)) {
            return obj2;
        }
        zVar = x1.f68130c;
        return zVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object V(p1 p1Var, Object obj) {
        kotlinx.coroutines.internal.z zVar;
        kotlinx.coroutines.internal.z zVar2;
        kotlinx.coroutines.internal.z zVar3;
        b2 C = C(p1Var);
        if (C == null) {
            zVar3 = x1.f68130c;
            return zVar3;
        }
        b bVar = p1Var instanceof b ? (b) p1Var : null;
        if (bVar == null) {
            bVar = new b(C, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (bVar) {
            if (bVar.j()) {
                zVar2 = x1.f68128a;
                return zVar2;
            }
            bVar.m(true);
            if (bVar != p1Var && !androidx.concurrent.futures.a.a(_state$volatile$FU, this, p1Var, bVar)) {
                zVar = x1.f68130c;
                return zVar;
            }
            boolean i11 = bVar.i();
            b0 b0Var = obj instanceof b0 ? (b0) obj : null;
            if (b0Var != null) {
                bVar.a(b0Var.f67764a);
            }
            ?? e11 = i11 ? 0 : bVar.e();
            objectRef.element = e11;
            Unit unit = Unit.f67184a;
            if (e11 != 0) {
                J(C, e11);
            }
            u I = I(C);
            if (I != null && W(bVar, I, obj)) {
                return x1.f68129b;
            }
            C.f(2);
            u I2 = I(C);
            return (I2 == null || !W(bVar, I2, obj)) ? z(bVar, obj) : x1.f68129b;
        }
    }

    private final boolean W(b bVar, u uVar, Object obj) {
        while (v1.l(uVar.f68123e, false, new a(this, bVar, uVar, obj)) == d2.f67825a) {
            uVar = I(uVar);
            if (uVar == null) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        if (str == null) {
            str = jobSupport.cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th2, jobSupport);
    }

    protected static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    private final void s(Throwable th2, List list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th3 = (Throwable) it.next();
            if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                ExceptionsKt.a(th2, th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t(Continuation continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.c(continuation), this);
        awaitContinuation.initCancellability();
        q.a(awaitContinuation, v1.m(this, false, new g2(awaitContinuation), 1, null));
        Object result = awaitContinuation.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th2, String str, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i11 & 1) != 0) {
            str = null;
        }
        return jobSupport.toCancellationException(th2, str);
    }

    private final Object u(Object obj) {
        kotlinx.coroutines.internal.z zVar;
        Object U;
        kotlinx.coroutines.internal.z zVar2;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof p1) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).j())) {
                zVar = x1.f68128a;
                return zVar;
            }
            U = U(state$kotlinx_coroutines_core, new b0(y(obj), false, 2, null));
            zVar2 = x1.f68130c;
        } while (U == zVar2);
        return U;
    }

    private final boolean v(Throwable th2) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z10 = th2 instanceof CancellationException;
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        return (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == d2.f67825a) ? z10 : parentHandle$kotlinx_coroutines_core.a(th2) || z10;
    }

    private final void w(p1 p1Var, Object obj) {
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(d2.f67825a);
        }
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        Throwable th2 = b0Var != null ? b0Var.f67764a : null;
        if (!(p1Var instanceof w1)) {
            b2 b11 = p1Var.b();
            if (b11 != null) {
                K(b11, th2);
                return;
            }
            return;
        }
        try {
            ((w1) p1Var).v(th2);
        } catch (Throwable th3) {
            handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + p1Var + " for " + this, th3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(b bVar, u uVar, Object obj) {
        u I = I(uVar);
        if (I == null || !W(bVar, I, obj)) {
            bVar.b().f(2);
            u I2 = I(uVar);
            if (I2 == null || !W(bVar, I2, obj)) {
                afterCompletion(z(bVar, obj));
            }
        }
    }

    private final Throwable y(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            return th2 == null ? new JobCancellationException(cancellationExceptionMessage(), null, this) : th2;
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((f2) obj).getChildJobCancellationCause();
    }

    private final Object z(b bVar, Object obj) {
        boolean i11;
        Throwable B;
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        Throwable th2 = b0Var != null ? b0Var.f67764a : null;
        synchronized (bVar) {
            i11 = bVar.i();
            List l11 = bVar.l(th2);
            B = B(bVar, l11);
            if (B != null) {
                s(B, l11);
            }
        }
        if (B != null && B != th2) {
            obj = new b0(B, false, 2, null);
        }
        if (B != null && (v(B) || handleJobException(B))) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((b0) obj).c();
        }
        if (!i11) {
            onCancelling(B);
        }
        onCompletionInternal(obj);
        androidx.concurrent.futures.a.a(_state$volatile$FU, this, bVar, x1.g(obj));
        w(bVar, obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterCompletion(Object obj) {
    }

    @Override // kotlinx.coroutines.t1
    public final t attachChild(v vVar) {
        u uVar = new u(vVar);
        uVar.w(this);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof d1) {
                d1 d1Var = (d1) state$kotlinx_coroutines_core;
                if (!d1Var.isActive()) {
                    N(d1Var);
                } else if (androidx.concurrent.futures.a.a(_state$volatile$FU, this, state$kotlinx_coroutines_core, uVar)) {
                    break;
                }
            } else {
                if (!(state$kotlinx_coroutines_core instanceof p1)) {
                    Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
                    b0 b0Var = state$kotlinx_coroutines_core2 instanceof b0 ? (b0) state$kotlinx_coroutines_core2 : null;
                    uVar.v(b0Var != null ? b0Var.f67764a : null);
                    return d2.f67825a;
                }
                b2 b11 = ((p1) state$kotlinx_coroutines_core).b();
                if (b11 == null) {
                    Intrinsics.f(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    O((w1) state$kotlinx_coroutines_core);
                } else if (!b11.c(uVar, 7)) {
                    boolean c11 = b11.c(uVar, 3);
                    Object state$kotlinx_coroutines_core3 = getState$kotlinx_coroutines_core();
                    if (state$kotlinx_coroutines_core3 instanceof b) {
                        r2 = ((b) state$kotlinx_coroutines_core3).e();
                    } else {
                        b0 b0Var2 = state$kotlinx_coroutines_core3 instanceof b0 ? (b0) state$kotlinx_coroutines_core3 : null;
                        if (b0Var2 != null) {
                            r2 = b0Var2.f67764a;
                        }
                    }
                    uVar.v(r2);
                    if (!c11) {
                        return d2.f67825a;
                    }
                }
            }
        }
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object awaitInternal(Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof p1)) {
                if (state$kotlinx_coroutines_core instanceof b0) {
                    throw ((b0) state$kotlinx_coroutines_core).f67764a;
                }
                return x1.h(state$kotlinx_coroutines_core);
            }
        } while (Q(state$kotlinx_coroutines_core) < 0);
        return t(continuation);
    }

    @Deprecated
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // kotlinx.coroutines.t1
    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Deprecated
    public /* synthetic */ boolean cancel(Throwable th2) {
        Throwable jobCancellationException;
        if (th2 == null || (jobCancellationException = toCancellationException$default(this, th2, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(jobCancellationException);
        return true;
    }

    public final boolean cancelCoroutine(Throwable th2) {
        return cancelImpl$kotlinx_coroutines_core(th2);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.z zVar;
        kotlinx.coroutines.internal.z zVar2;
        kotlinx.coroutines.internal.z zVar3;
        obj2 = x1.f68128a;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (obj2 = u(obj)) == x1.f68129b) {
            return true;
        }
        zVar = x1.f68128a;
        if (obj2 == zVar) {
            obj2 = H(obj);
        }
        zVar2 = x1.f68128a;
        if (obj2 == zVar2 || obj2 == x1.f68129b) {
            return true;
        }
        zVar3 = x1.f68131d;
        if (obj2 == zVar3) {
            return false;
        }
        afterCompletion(obj2);
        return true;
    }

    public void cancelInternal(Throwable th2) {
        cancelImpl$kotlinx_coroutines_core(th2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th2) && getHandlesException$kotlinx_coroutines_core();
    }

    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String str, Throwable th2) {
        if (str == null) {
            str = cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th2, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) t1.a.c(this, r11, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) t1.a.d(this, key);
    }

    @Override // kotlinx.coroutines.t1
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof b)) {
            if (state$kotlinx_coroutines_core instanceof p1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (state$kotlinx_coroutines_core instanceof b0) {
                return toCancellationException$default(this, ((b0) state$kotlinx_coroutines_core).f67764a, null, 1, null);
            }
            return new JobCancellationException(p0.a(this) + " has completed normally", null, this);
        }
        Throwable e11 = ((b) state$kotlinx_coroutines_core).e();
        if (e11 != null) {
            CancellationException cancellationException = toCancellationException(e11, p0.a(this) + " is cancelling");
            if (cancellationException != null) {
                return cancellationException;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.f2
    public CancellationException getChildJobCancellationCause() {
        CancellationException cancellationException;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            cancellationException = ((b) state$kotlinx_coroutines_core).e();
        } else if (state$kotlinx_coroutines_core instanceof b0) {
            cancellationException = ((b0) state$kotlinx_coroutines_core).f67764a;
        } else {
            if (state$kotlinx_coroutines_core instanceof p1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new JobCancellationException("Parent job is " + R(state$kotlinx_coroutines_core), cancellationException, this);
    }

    @Override // kotlinx.coroutines.t1
    public final Sequence<t1> getChildren() {
        return SequencesKt.b(new JobSupport$children$1(this, null));
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof p1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (state$kotlinx_coroutines_core instanceof b0) {
            throw ((b0) state$kotlinx_coroutines_core).f67764a;
        }
        return x1.h(state$kotlinx_coroutines_core);
    }

    protected final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            Throwable e11 = ((b) state$kotlinx_coroutines_core).e();
            if (e11 != null) {
                return e11;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(state$kotlinx_coroutines_core instanceof p1)) {
            if (state$kotlinx_coroutines_core instanceof b0) {
                return ((b0) state$kotlinx_coroutines_core).f67764a;
            }
            return null;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    protected final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof b0) && ((b0) state$kotlinx_coroutines_core).a();
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof p1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        return A(state$kotlinx_coroutines_core);
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return t1.f68119l1;
    }

    protected final kotlinx.coroutines.selects.d getOnAwaitInternal() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.INSTANCE;
        Intrinsics.f(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.e(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.INSTANCE;
        Intrinsics.f(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new kotlinx.coroutines.selects.e(this, function3, (Function3) TypeIntrinsics.e(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    public final kotlinx.coroutines.selects.b getOnJoin() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.f(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new kotlinx.coroutines.selects.c(this, (Function3) TypeIntrinsics.e(jobSupport$onJoin$1, 3), null, 4, null);
    }

    public t1 getParent() {
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    public final t getParentHandle$kotlinx_coroutines_core() {
        return (t) _parentHandle$volatile$FU.get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        return _state$volatile$FU.get(this);
    }

    protected boolean handleJobException(Throwable th2) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable th2) {
        throw th2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initParentJob(t1 t1Var) {
        if (t1Var == null) {
            setParentHandle$kotlinx_coroutines_core(d2.f67825a);
            return;
        }
        t1Var.start();
        t attachChild = t1Var.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(d2.f67825a);
        }
    }

    @Override // kotlinx.coroutines.t1
    public final a1 invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(true, new s1(function1));
    }

    @Override // kotlinx.coroutines.t1
    public final a1 invokeOnCompletion(boolean z10, boolean z11, Function1<? super Throwable, Unit> function1) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(z11, z10 ? new r1(function1) : new s1(function1));
    }

    public final a1 invokeOnCompletionInternal$kotlinx_coroutines_core(boolean z10, w1 w1Var) {
        boolean z11;
        boolean c11;
        w1Var.w(this);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            z11 = true;
            if (!(state$kotlinx_coroutines_core instanceof d1)) {
                if (!(state$kotlinx_coroutines_core instanceof p1)) {
                    z11 = false;
                    break;
                }
                p1 p1Var = (p1) state$kotlinx_coroutines_core;
                b2 b11 = p1Var.b();
                if (b11 == null) {
                    Intrinsics.f(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    O((w1) state$kotlinx_coroutines_core);
                } else {
                    if (w1Var.u()) {
                        b bVar = p1Var instanceof b ? (b) p1Var : null;
                        Throwable e11 = bVar != null ? bVar.e() : null;
                        if (e11 != null) {
                            if (z10) {
                                w1Var.v(e11);
                            }
                            return d2.f67825a;
                        }
                        c11 = b11.c(w1Var, 5);
                    } else {
                        c11 = b11.c(w1Var, 1);
                    }
                    if (c11) {
                        break;
                    }
                }
            } else {
                d1 d1Var = (d1) state$kotlinx_coroutines_core;
                if (!d1Var.isActive()) {
                    N(d1Var);
                } else if (androidx.concurrent.futures.a.a(_state$volatile$FU, this, state$kotlinx_coroutines_core, w1Var)) {
                    break;
                }
            }
        }
        if (z11) {
            return w1Var;
        }
        if (z10) {
            Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
            b0 b0Var = state$kotlinx_coroutines_core2 instanceof b0 ? (b0) state$kotlinx_coroutines_core2 : null;
            w1Var.v(b0Var != null ? b0Var.f67764a : null);
        }
        return d2.f67825a;
    }

    @Override // kotlinx.coroutines.t1
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof p1) && ((p1) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kotlinx.coroutines.t1
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof b0) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).i());
    }

    @Override // kotlinx.coroutines.t1
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof p1);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof b0;
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    @Override // kotlinx.coroutines.t1
    public final Object join(Continuation<? super Unit> continuation) {
        if (F()) {
            Object G = G(continuation);
            return G == IntrinsicsKt.f() ? G : Unit.f67184a;
        }
        v1.i(continuation.getContext());
        return Unit.f67184a;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) {
        Object U;
        kotlinx.coroutines.internal.z zVar;
        kotlinx.coroutines.internal.z zVar2;
        do {
            U = U(getState$kotlinx_coroutines_core(), obj);
            zVar = x1.f68128a;
            if (U == zVar) {
                return false;
            }
            if (U == x1.f68129b) {
                return true;
            }
            zVar2 = x1.f68130c;
        } while (U == zVar2);
        afterCompletion(U);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object U;
        kotlinx.coroutines.internal.z zVar;
        kotlinx.coroutines.internal.z zVar2;
        do {
            U = U(getState$kotlinx_coroutines_core(), obj);
            zVar = x1.f68128a;
            if (U == zVar) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, A(obj));
            }
            zVar2 = x1.f68130c;
        } while (U == zVar2);
        return U;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return t1.a.e(this, key);
    }

    public String nameString$kotlinx_coroutines_core() {
        return p0.a(this);
    }

    protected void onCancelling(Throwable th2) {
    }

    protected void onCompletionInternal(Object obj) {
    }

    protected void onStart() {
    }

    @Override // kotlinx.coroutines.v
    public final void parentCancelled(f2 f2Var) {
        cancelImpl$kotlinx_coroutines_core(f2Var);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return t1.a.f(this, coroutineContext);
    }

    @Deprecated
    public t1 plus(t1 t1Var) {
        return t1.a.g(this, t1Var);
    }

    public final void removeNode$kotlinx_coroutines_core(w1 w1Var) {
        Object state$kotlinx_coroutines_core;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        d1 d1Var;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof w1)) {
                if (!(state$kotlinx_coroutines_core instanceof p1) || ((p1) state$kotlinx_coroutines_core).b() == null) {
                    return;
                }
                w1Var.q();
                return;
            }
            if (state$kotlinx_coroutines_core != w1Var) {
                return;
            }
            atomicReferenceFieldUpdater = _state$volatile$FU;
            d1Var = x1.f68134g;
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, state$kotlinx_coroutines_core, d1Var));
    }

    public final void setParentHandle$kotlinx_coroutines_core(t tVar) {
        _parentHandle$volatile$FU.set(this, tVar);
    }

    @Override // kotlinx.coroutines.t1
    public final boolean start() {
        int Q;
        do {
            Q = Q(getState$kotlinx_coroutines_core());
            if (Q == 0) {
                return false;
            }
        } while (Q != 1);
        return true;
    }

    protected final CancellationException toCancellationException(Throwable th2, String str) {
        CancellationException cancellationException = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(str, th2, this);
        }
        return cancellationException;
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + R(getState$kotlinx_coroutines_core()) + '}';
    }

    public String toString() {
        return toDebugString() + '@' + p0.b(this);
    }
}
