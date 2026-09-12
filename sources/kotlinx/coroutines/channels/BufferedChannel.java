package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.s2;

/* loaded from: classes7.dex */
public class BufferedChannel implements d {

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f67769d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f67770e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f67771f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f67772g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67773h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67774i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67775j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67776k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f67777l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    private final int f67778a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f67779b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* renamed from: c, reason: collision with root package name */
    private final Function3 f67780c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class a implements f, s2 {

        /* renamed from: a, reason: collision with root package name */
        private Object f67781a;

        /* renamed from: b, reason: collision with root package name */
        private CancellableContinuationImpl f67782b;

        public a() {
            z zVar;
            zVar = BufferedChannelKt.f67799p;
            this.f67781a = zVar;
        }

        private final Object e(j jVar, int i11, long j11, Continuation continuation) {
            z zVar;
            z zVar2;
            Boolean a11;
            z zVar3;
            z zVar4;
            z zVar5;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl b11 = kotlinx.coroutines.q.b(IntrinsicsKt.c(continuation));
            try {
                this.f67782b = b11;
                Object g12 = bufferedChannel.g1(jVar, i11, j11, this);
                zVar = BufferedChannelKt.f67796m;
                if (g12 == zVar) {
                    bufferedChannel.O0(this, jVar, i11);
                } else {
                    zVar2 = BufferedChannelKt.f67798o;
                    Function3 function3 = null;
                    if (g12 == zVar2) {
                        if (j11 < bufferedChannel.l0()) {
                            jVar.c();
                        }
                        j jVar2 = (j) BufferedChannel.s().get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.t0()) {
                                g();
                                break;
                            }
                            long andIncrement = BufferedChannel.t().getAndIncrement(bufferedChannel);
                            int i12 = BufferedChannelKt.f67785b;
                            long j12 = andIncrement / i12;
                            int i13 = (int) (andIncrement % i12);
                            if (jVar2.f68010c != j12) {
                                j W = bufferedChannel.W(j12, jVar2);
                                if (W != null) {
                                    jVar2 = W;
                                }
                            }
                            Object g13 = bufferedChannel.g1(jVar2, i13, andIncrement, this);
                            zVar3 = BufferedChannelKt.f67796m;
                            if (g13 == zVar3) {
                                bufferedChannel.O0(this, jVar2, i13);
                                break;
                            }
                            zVar4 = BufferedChannelKt.f67798o;
                            if (g13 != zVar4) {
                                zVar5 = BufferedChannelKt.f67797n;
                                if (g13 == zVar5) {
                                    throw new IllegalStateException("unexpected");
                                }
                                jVar2.c();
                                this.f67781a = g13;
                                this.f67782b = null;
                                a11 = Boxing.a(true);
                                Function1 function1 = bufferedChannel.f67779b;
                                if (function1 != null) {
                                    function3 = bufferedChannel.H(function1, g13);
                                }
                            } else if (andIncrement < bufferedChannel.l0()) {
                                jVar2.c();
                            }
                        }
                    } else {
                        jVar.c();
                        this.f67781a = g12;
                        this.f67782b = null;
                        a11 = Boxing.a(true);
                        Function1 function12 = bufferedChannel.f67779b;
                        if (function12 != null) {
                            function3 = bufferedChannel.H(function12, g12);
                        }
                    }
                    b11.resume((CancellableContinuationImpl) a11, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, Unit>) function3);
                }
                Object result = b11.getResult();
                if (result == IntrinsicsKt.f()) {
                    DebugProbesKt.c(continuation);
                }
                return result;
            } catch (Throwable th2) {
                b11.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th2;
            }
        }

        private final boolean f() {
            this.f67781a = BufferedChannelKt.z();
            Throwable b02 = BufferedChannel.this.b0();
            if (b02 == null) {
                return false;
            }
            throw y.a(b02);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            CancellableContinuationImpl cancellableContinuationImpl = this.f67782b;
            Intrinsics.e(cancellableContinuationImpl);
            this.f67782b = null;
            this.f67781a = BufferedChannelKt.z();
            Throwable b02 = BufferedChannel.this.b0();
            if (b02 == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(ResultKt.a(b02)));
            }
        }

        @Override // kotlinx.coroutines.channels.f
        public Object a(Continuation continuation) {
            z zVar;
            z zVar2;
            z zVar3;
            z zVar4;
            Object obj = this.f67781a;
            zVar = BufferedChannelKt.f67799p;
            boolean z10 = true;
            if (obj == zVar || this.f67781a == BufferedChannelKt.z()) {
                BufferedChannel bufferedChannel = BufferedChannel.this;
                j jVar = (j) BufferedChannel.s().get(bufferedChannel);
                while (true) {
                    if (bufferedChannel.t0()) {
                        z10 = f();
                        break;
                    }
                    long andIncrement = BufferedChannel.t().getAndIncrement(bufferedChannel);
                    int i11 = BufferedChannelKt.f67785b;
                    long j11 = andIncrement / i11;
                    int i12 = (int) (andIncrement % i11);
                    if (jVar.f68010c != j11) {
                        j W = bufferedChannel.W(j11, jVar);
                        if (W == null) {
                            continue;
                        } else {
                            jVar = W;
                        }
                    }
                    Object g12 = bufferedChannel.g1(jVar, i12, andIncrement, null);
                    zVar2 = BufferedChannelKt.f67796m;
                    if (g12 == zVar2) {
                        throw new IllegalStateException("unreachable");
                    }
                    zVar3 = BufferedChannelKt.f67798o;
                    if (g12 != zVar3) {
                        zVar4 = BufferedChannelKt.f67797n;
                        if (g12 == zVar4) {
                            return e(jVar, i12, andIncrement, continuation);
                        }
                        jVar.c();
                        this.f67781a = g12;
                    } else if (andIncrement < bufferedChannel.l0()) {
                        jVar.c();
                    }
                }
            }
            return Boxing.a(z10);
        }

        public final boolean h(Object obj) {
            boolean B;
            CancellableContinuationImpl cancellableContinuationImpl = this.f67782b;
            Intrinsics.e(cancellableContinuationImpl);
            this.f67782b = null;
            this.f67781a = obj;
            Boolean bool = Boolean.TRUE;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            Function1 function1 = bufferedChannel.f67779b;
            B = BufferedChannelKt.B(cancellableContinuationImpl, bool, function1 != null ? bufferedChannel.H(function1, obj) : null);
            return B;
        }

        public final void i() {
            CancellableContinuationImpl cancellableContinuationImpl = this.f67782b;
            Intrinsics.e(cancellableContinuationImpl);
            this.f67782b = null;
            this.f67781a = BufferedChannelKt.z();
            Throwable b02 = BufferedChannel.this.b0();
            if (b02 == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(ResultKt.a(b02)));
            }
        }

        @Override // kotlinx.coroutines.s2
        public void invokeOnCancellation(w wVar, int i11) {
            CancellableContinuationImpl cancellableContinuationImpl = this.f67782b;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(wVar, i11);
            }
        }

        @Override // kotlinx.coroutines.channels.f
        public Object next() {
            z zVar;
            z zVar2;
            Object obj = this.f67781a;
            zVar = BufferedChannelKt.f67799p;
            if (obj == zVar) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            zVar2 = BufferedChannelKt.f67799p;
            this.f67781a = zVar2;
            if (obj != BufferedChannelKt.z()) {
                return obj;
            }
            throw y.a(BufferedChannel.this.e0());
        }
    }

    public BufferedChannel(int i11, Function1 function1) {
        long A;
        z zVar;
        this.f67778a = i11;
        this.f67779b = function1;
        if (i11 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i11 + ", should be >=0").toString());
        }
        A = BufferedChannelKt.A(i11);
        this.bufferEnd$volatile = A;
        this.completedExpandBuffersAndPauseFlag$volatile = Z();
        j jVar = new j(0L, null, this, 3);
        this.sendSegment$volatile = jVar;
        this.receiveSegment$volatile = jVar;
        if (x0()) {
            jVar = BufferedChannelKt.f67784a;
            Intrinsics.f(jVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = jVar;
        this.f67780c = function1 != null ? new Function3() { // from class: kotlinx.coroutines.channels.a
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Function3 M0;
                BufferedChannel bufferedChannel = BufferedChannel.this;
                android.support.v4.media.session.c.a(obj);
                M0 = BufferedChannel.M0(bufferedChannel, null, obj2, obj3);
                return M0;
            }
        } : null;
        zVar = BufferedChannelKt.f67802s;
        this._closeCause$volatile = zVar;
    }

    private final void A0() {
        long j11;
        long w11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67769d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            w11 = BufferedChannelKt.w(1152921504606846975L & j11, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, w11));
    }

    private final void B0() {
        long j11;
        long w11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67769d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            int i11 = (int) (j11 >> 60);
            if (i11 == 0) {
                w11 = BufferedChannelKt.w(j11 & 1152921504606846975L, 2);
            } else if (i11 != 1) {
                return;
            } else {
                w11 = BufferedChannelKt.w(j11 & 1152921504606846975L, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, w11));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void C0(long r5, kotlinx.coroutines.channels.j r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f68010c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            kotlinx.coroutines.internal.b r0 = r7.f()
            kotlinx.coroutines.channels.j r0 = (kotlinx.coroutines.channels.j) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.k()
            if (r5 == 0) goto L22
            kotlinx.coroutines.internal.b r5 = r7.f()
            kotlinx.coroutines.channels.j r5 = (kotlinx.coroutines.channels.j) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = a0()
        L26:
            java.lang.Object r6 = r5.get(r4)
            kotlinx.coroutines.internal.w r6 = (kotlinx.coroutines.internal.w) r6
            long r0 = r6.f68010c
            long r2 = r7.f68010c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L35
            goto L4b
        L35:
            boolean r0 = r7.u()
            if (r0 != 0) goto L3c
            goto L11
        L3c:
            boolean r0 = androidx.concurrent.futures.a.a(r5, r4, r6, r7)
            if (r0 == 0) goto L4c
            boolean r5 = r6.p()
            if (r5 == 0) goto L4b
            r6.n()
        L4b:
            return
        L4c:
            boolean r6 = r7.p()
            if (r6 == 0) goto L26
            r7.n()
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.C0(long, kotlinx.coroutines.channels.j):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(Throwable th2, Object obj, CoroutineContext coroutineContext) {
        Function1 function1 = this.f67779b;
        Intrinsics.e(function1);
        Object f11 = h.f(obj);
        Intrinsics.e(f11);
        kotlinx.coroutines.internal.s.a(function1, f11, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(Throwable th2, Object obj, CoroutineContext coroutineContext) {
        Function1 function1 = this.f67779b;
        Intrinsics.e(function1);
        kotlinx.coroutines.internal.s.a(function1, obj, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(kotlinx.coroutines.n nVar) {
        Result.Companion companion = Result.INSTANCE;
        nVar.resumeWith(Result.m1185constructorimpl(h.b(h.f67813b.a(b0()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function3 H(final Function1 function1, final Object obj) {
        return new Function3() { // from class: kotlinx.coroutines.channels.b
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                Unit J;
                J = BufferedChannel.J(Function1.this, obj, (Throwable) obj2, obj3, (CoroutineContext) obj4);
                return J;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(kotlinx.coroutines.n nVar) {
        Result.Companion companion = Result.INSTANCE;
        nVar.resumeWith(Result.m1185constructorimpl(ResultKt.a(e0())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KFunction I(Function1 function1) {
        return new BufferedChannel$bindCancellationFun$2(this);
    }

    private final Object I0(Object obj, Continuation continuation) {
        UndeliveredElementException c11;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Function1 function1 = this.f67779b;
        if (function1 == null || (c11 = kotlinx.coroutines.internal.s.c(function1, obj, null, 2, null)) == null) {
            Throwable i02 = i0();
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(ResultKt.a(i02)));
        } else {
            ExceptionsKt.a(c11, i0());
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(ResultKt.a(c11)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function1 function1, Object obj, Throwable th2, Object obj2, CoroutineContext coroutineContext) {
        kotlinx.coroutines.internal.s.a(function1, obj, coroutineContext);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(Object obj, kotlinx.coroutines.n nVar) {
        Function1 function1 = this.f67779b;
        if (function1 != null) {
            kotlinx.coroutines.internal.s.a(function1, obj, nVar.getContext());
        }
        Throwable i02 = i0();
        Result.Companion companion = Result.INSTANCE;
        nVar.resumeWith(Result.m1185constructorimpl(ResultKt.a(i02)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KFunction K(Function1 function1) {
        return new BufferedChannel$bindCancellationFunResult$1(this);
    }

    private final boolean L(long j11) {
        return j11 < Z() || j11 < h0() + ((long) this.f67778a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 M0(final BufferedChannel bufferedChannel, final kotlinx.coroutines.selects.f fVar, Object obj, final Object obj2) {
        return new Function3(obj2, bufferedChannel, fVar) { // from class: kotlinx.coroutines.channels.c

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f67807a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BufferedChannel f67808b;

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                Unit N0;
                N0 = BufferedChannel.N0(this.f67807a, this.f67808b, null, (Throwable) obj3, obj4, (CoroutineContext) obj5);
                return N0;
            }
        };
    }

    private final void N(j jVar, long j11) {
        z zVar;
        Object b11 = kotlinx.coroutines.internal.h.b(null, 1, null);
        loop0: while (jVar != null) {
            for (int i11 = BufferedChannelKt.f67785b - 1; -1 < i11; i11--) {
                if ((jVar.f68010c * BufferedChannelKt.f67785b) + i11 < j11) {
                    break loop0;
                }
                while (true) {
                    Object B = jVar.B(i11);
                    if (B != null) {
                        zVar = BufferedChannelKt.f67788e;
                        if (B != zVar) {
                            if (!(B instanceof s)) {
                                if (!(B instanceof s2)) {
                                    break;
                                }
                                if (jVar.v(i11, B, BufferedChannelKt.z())) {
                                    b11 = kotlinx.coroutines.internal.h.c(b11, B);
                                    jVar.C(i11, true);
                                    break;
                                }
                            } else {
                                if (jVar.v(i11, B, BufferedChannelKt.z())) {
                                    b11 = kotlinx.coroutines.internal.h.c(b11, ((s) B).f67822a);
                                    jVar.C(i11, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (jVar.v(i11, B, BufferedChannelKt.z())) {
                        jVar.t();
                        break;
                    }
                }
            }
            jVar = (j) jVar.h();
        }
        if (b11 != null) {
            if (!(b11 instanceof ArrayList)) {
                V0((s2) b11);
                return;
            }
            Intrinsics.f(b11, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            ArrayList arrayList = (ArrayList) b11;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                V0((s2) arrayList.get(size));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(Object obj, BufferedChannel bufferedChannel, kotlinx.coroutines.selects.f fVar, Throwable th2, Object obj2, CoroutineContext coroutineContext) {
        if (obj != BufferedChannelKt.z()) {
            kotlinx.coroutines.internal.s.a(bufferedChannel.f67779b, obj, fVar.getContext());
        }
        return Unit.f67184a;
    }

    private final j O() {
        Object obj = f67775j.get(this);
        j jVar = (j) f67773h.get(this);
        if (jVar.f68010c > ((j) obj).f68010c) {
            obj = jVar;
        }
        j jVar2 = (j) f67774i.get(this);
        if (jVar2.f68010c > ((j) obj).f68010c) {
            obj = jVar2;
        }
        return (j) kotlinx.coroutines.internal.a.b((kotlinx.coroutines.internal.b) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(s2 s2Var, j jVar, int i11) {
        L0();
        s2Var.invokeOnCancellation(jVar, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(s2 s2Var, j jVar, int i11) {
        s2Var.invokeOnCancellation(jVar, i11 + BufferedChannelKt.f67785b);
    }

    private final void Q(long j11) {
        U0(R(j11));
    }

    static /* synthetic */ Object Q0(BufferedChannel bufferedChannel, Continuation continuation) {
        z zVar;
        z zVar2;
        z zVar3;
        j jVar = (j) s().get(bufferedChannel);
        while (!bufferedChannel.t0()) {
            long andIncrement = t().getAndIncrement(bufferedChannel);
            int i11 = BufferedChannelKt.f67785b;
            long j11 = andIncrement / i11;
            int i12 = (int) (andIncrement % i11);
            if (jVar.f68010c != j11) {
                j W = bufferedChannel.W(j11, jVar);
                if (W == null) {
                    continue;
                } else {
                    jVar = W;
                }
            }
            Object g12 = bufferedChannel.g1(jVar, i12, andIncrement, null);
            zVar = BufferedChannelKt.f67796m;
            if (g12 == zVar) {
                throw new IllegalStateException("unexpected");
            }
            zVar2 = BufferedChannelKt.f67798o;
            if (g12 != zVar2) {
                zVar3 = BufferedChannelKt.f67797n;
                if (g12 == zVar3) {
                    return bufferedChannel.T0(jVar, i12, andIncrement, continuation);
                }
                jVar.c();
                return g12;
            }
            if (andIncrement < bufferedChannel.l0()) {
                jVar.c();
            }
        }
        throw y.a(bufferedChannel.e0());
    }

    private final j R(long j11) {
        j O = O();
        if (w0()) {
            long y02 = y0(O);
            if (y02 != -1) {
                T(y02);
            }
        }
        N(O, j11);
        return O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object R0(kotlinx.coroutines.channels.BufferedChannel r13, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L14
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            kotlin.ResultKt.b(r14)
            kotlinx.coroutines.channels.h r14 = (kotlinx.coroutines.channels.h) r14
            java.lang.Object r13 = r14.k()
            goto Lb2
        L32:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3a:
            kotlin.ResultKt.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = s()
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.j r14 = (kotlinx.coroutines.channels.j) r14
        L47:
            boolean r1 = r13.t0()
            if (r1 == 0) goto L58
            kotlinx.coroutines.channels.h$b r14 = kotlinx.coroutines.channels.h.f67813b
            java.lang.Throwable r13 = r13.b0()
            java.lang.Object r13 = r14.a(r13)
            goto Lb2
        L58:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = t()
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f67785b
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.f68010c
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L77
            kotlinx.coroutines.channels.j r1 = n(r13, r7, r14)
            if (r1 != 0) goto L76
            goto L47
        L76:
            r14 = r1
        L77:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = F(r7, r8, r9, r10, r12)
            kotlinx.coroutines.internal.z r7 = kotlinx.coroutines.channels.BufferedChannelKt.r()
            if (r1 == r7) goto Lb3
            kotlinx.coroutines.internal.z r7 = kotlinx.coroutines.channels.BufferedChannelKt.h()
            if (r1 != r7) goto L98
            long r7 = r13.l0()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L47
            r14.c()
            goto L47
        L98:
            kotlinx.coroutines.internal.z r7 = kotlinx.coroutines.channels.BufferedChannelKt.s()
            if (r1 != r7) goto La9
            r6.label = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.S0(r2, r3, r4, r6)
            if (r13 != r0) goto Lb2
            return r0
        La9:
            r14.c()
            kotlinx.coroutines.channels.h$b r13 = kotlinx.coroutines.channels.h.f67813b
            java.lang.Object r13 = r13.c(r1)
        Lb2:
            return r13
        Lb3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.R0(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void S() {
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S0(kotlinx.coroutines.channels.j r11, int r12, long r13, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.S0(kotlinx.coroutines.channels.j, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object T0(j jVar, int i11, long j11, Continuation continuation) {
        z zVar;
        z zVar2;
        Function3 function3;
        z zVar3;
        z zVar4;
        z zVar5;
        CancellableContinuationImpl b11 = kotlinx.coroutines.q.b(IntrinsicsKt.c(continuation));
        try {
            Object g12 = g1(jVar, i11, j11, b11);
            zVar = BufferedChannelKt.f67796m;
            if (g12 == zVar) {
                O0(b11, jVar, i11);
            } else {
                zVar2 = BufferedChannelKt.f67798o;
                if (g12 == zVar2) {
                    if (j11 < l0()) {
                        jVar.c();
                    }
                    j jVar2 = (j) s().get(this);
                    while (true) {
                        if (t0()) {
                            H0(b11);
                            break;
                        }
                        long andIncrement = t().getAndIncrement(this);
                        int i12 = BufferedChannelKt.f67785b;
                        long j12 = andIncrement / i12;
                        int i13 = (int) (andIncrement % i12);
                        if (jVar2.f68010c != j12) {
                            j W = W(j12, jVar2);
                            if (W != null) {
                                jVar2 = W;
                            }
                        }
                        g12 = g1(jVar2, i13, andIncrement, b11);
                        zVar3 = BufferedChannelKt.f67796m;
                        if (g12 == zVar3) {
                            CancellableContinuationImpl cancellableContinuationImpl = b11 instanceof s2 ? b11 : null;
                            if (cancellableContinuationImpl != null) {
                                O0(cancellableContinuationImpl, jVar2, i13);
                            }
                        } else {
                            zVar4 = BufferedChannelKt.f67798o;
                            if (g12 != zVar4) {
                                zVar5 = BufferedChannelKt.f67797n;
                                if (g12 == zVar5) {
                                    throw new IllegalStateException("unexpected");
                                }
                                jVar2.c();
                                Function1 function1 = this.f67779b;
                                function3 = (Function3) (function1 != null ? I(function1) : null);
                            } else if (andIncrement < l0()) {
                                jVar2.c();
                            }
                        }
                    }
                } else {
                    jVar.c();
                    Function1 function12 = this.f67779b;
                    function3 = (Function3) (function12 != null ? I(function12) : null);
                }
                b11.resume((CancellableContinuationImpl) g12, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, Unit>) function3);
            }
            Object result = b11.getResult();
            if (result == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return result;
        } catch (Throwable th2) {
            b11.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th2;
        }
    }

    private final void U() {
        if (x0()) {
            return;
        }
        j jVar = (j) f67775j.get(this);
        while (true) {
            long andIncrement = f67771f.getAndIncrement(this);
            int i11 = BufferedChannelKt.f67785b;
            long j11 = andIncrement / i11;
            if (l0() <= andIncrement) {
                if (jVar.f68010c < j11 && jVar.f() != null) {
                    C0(j11, jVar);
                }
                p0(this, 0L, 1, null);
                return;
            }
            if (jVar.f68010c != j11) {
                j V = V(j11, jVar, andIncrement);
                if (V == null) {
                    continue;
                } else {
                    jVar = V;
                }
            }
            if (e1(jVar, (int) (andIncrement % i11), andIncrement)) {
                p0(this, 0L, 1, null);
                return;
            }
            p0(this, 0L, 1, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b3, code lost:
    
        r12 = (kotlinx.coroutines.channels.j) r12.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void U0(kotlinx.coroutines.channels.j r12) {
        /*
            r11 = this;
            kotlin.jvm.functions.Function1 r0 = r11.f67779b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.h.b(r1, r2, r1)
        L8:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.f67785b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb3
            long r6 = r12.f68010c
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.f67785b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L16:
            java.lang.Object r8 = r12.B(r4)
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r8 == r9) goto Lbb
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.channels.BufferedChannelKt.f67787d
            if (r8 != r9) goto L48
            long r9 = r11.h0()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.v(r4, r8, r9)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L40
            java.lang.Object r5 = r12.A(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.s.b(r0, r5, r1)
        L40:
            r12.w(r4)
            r12.t()
            goto Laf
        L48:
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r8 == r9) goto La2
            if (r8 != 0) goto L51
            goto La2
        L51:
            boolean r9 = r8 instanceof kotlinx.coroutines.s2
            if (r9 != 0) goto L6e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.s
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r8 == r9) goto Lbb
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r8 != r9) goto L67
            goto Lbb
        L67:
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r8 == r9) goto L16
            goto Laf
        L6e:
            long r9 = r11.h0()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.s
            if (r9 == 0) goto L80
            r9 = r8
            kotlinx.coroutines.channels.s r9 = (kotlinx.coroutines.channels.s) r9
            kotlinx.coroutines.s2 r9 = r9.f67822a
            goto L83
        L80:
            r9 = r8
            kotlinx.coroutines.s2 r9 = (kotlinx.coroutines.s2) r9
        L83:
            kotlinx.coroutines.internal.z r10 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.v(r4, r8, r10)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L97
            java.lang.Object r5 = r12.A(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.s.b(r0, r5, r1)
        L97:
            java.lang.Object r3 = kotlinx.coroutines.internal.h.c(r3, r9)
            r12.w(r4)
            r12.t()
            goto Laf
        La2:
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.v(r4, r8, r9)
            if (r8 == 0) goto L16
            r12.t()
        Laf:
            int r4 = r4 + (-1)
            goto Lb
        Lb3:
            kotlinx.coroutines.internal.b r12 = r12.h()
            kotlinx.coroutines.channels.j r12 = (kotlinx.coroutines.channels.j) r12
            if (r12 != 0) goto L8
        Lbb:
            if (r3 == 0) goto Le1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto Lc7
            kotlinx.coroutines.s2 r3 = (kotlinx.coroutines.s2) r3
            r11.W0(r3)
            goto Le1
        Lc7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>"
            kotlin.jvm.internal.Intrinsics.f(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        Ld3:
            if (r5 >= r12) goto Le1
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.s2 r0 = (kotlinx.coroutines.s2) r0
            r11.W0(r0)
            int r12 = r12 + (-1)
            goto Ld3
        Le1:
            if (r1 != 0) goto Le4
            return
        Le4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.U0(kotlinx.coroutines.channels.j):void");
    }

    private final j V(long j11, j jVar, long j12) {
        Object c11;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67775j;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            c11 = kotlinx.coroutines.internal.a.c(jVar, j11, function2);
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
        if (x.c(c11)) {
            S();
            C0(j11, jVar);
            p0(this, 0L, 1, null);
            return null;
        }
        j jVar2 = (j) x.b(c11);
        if (jVar2.f68010c <= j11) {
            return jVar2;
        }
        long j13 = jVar2.f68010c;
        int i11 = BufferedChannelKt.f67785b;
        if (f67771f.compareAndSet(this, j12 + 1, j13 * i11)) {
            o0((jVar2.f68010c * i11) - j12);
            return null;
        }
        p0(this, 0L, 1, null);
        return null;
    }

    private final void V0(s2 s2Var) {
        X0(s2Var, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j W(long j11, j jVar) {
        Object c11;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67774i;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            c11 = kotlinx.coroutines.internal.a.c(jVar, j11, function2);
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
        if (x.c(c11)) {
            S();
            if (jVar.f68010c * BufferedChannelKt.f67785b >= l0()) {
                return null;
            }
            jVar.c();
            return null;
        }
        j jVar2 = (j) x.b(c11);
        if (!x0() && j11 <= Z() / BufferedChannelKt.f67785b) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f67775j;
            while (true) {
                w wVar2 = (w) atomicReferenceFieldUpdater2.get(this);
                if (wVar2.f68010c >= jVar2.f68010c || !jVar2.u()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, wVar2, jVar2)) {
                    if (wVar2.p()) {
                        wVar2.n();
                    }
                } else if (jVar2.p()) {
                    jVar2.n();
                }
            }
        }
        long j12 = jVar2.f68010c;
        if (j12 <= j11) {
            return jVar2;
        }
        int i11 = BufferedChannelKt.f67785b;
        k1(j12 * i11);
        if (jVar2.f68010c * i11 >= l0()) {
            return null;
        }
        jVar2.c();
        return null;
    }

    private final void W0(s2 s2Var) {
        X0(s2Var, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j X(long j11, j jVar) {
        Object c11;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67773h;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            c11 = kotlinx.coroutines.internal.a.c(jVar, j11, function2);
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
        if (x.c(c11)) {
            S();
            if (jVar.f68010c * BufferedChannelKt.f67785b >= h0()) {
                return null;
            }
            jVar.c();
            return null;
        }
        j jVar2 = (j) x.b(c11);
        long j12 = jVar2.f68010c;
        if (j12 <= j11) {
            return jVar2;
        }
        int i11 = BufferedChannelKt.f67785b;
        l1(j12 * i11);
        if (jVar2.f68010c * i11 >= h0()) {
            return null;
        }
        jVar2.c();
        return null;
    }

    private final void X0(s2 s2Var, boolean z10) {
        if (s2Var instanceof kotlinx.coroutines.n) {
            Continuation continuation = (Continuation) s2Var;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m1185constructorimpl(ResultKt.a(z10 ? e0() : i0())));
        } else if (s2Var instanceof p) {
            CancellableContinuationImpl cancellableContinuationImpl = ((p) s2Var).f67821a;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(h.b(h.f67813b.a(b0()))));
        } else {
            if (s2Var instanceof a) {
                ((a) s2Var).i();
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + s2Var).toString());
        }
    }

    static /* synthetic */ Object Y0(BufferedChannel bufferedChannel, Object obj, Continuation continuation) {
        j jVar = (j) u().get(bufferedChannel);
        while (true) {
            long andIncrement = v().getAndIncrement(bufferedChannel);
            long j11 = 1152921504606846975L & andIncrement;
            boolean v02 = bufferedChannel.v0(andIncrement);
            int i11 = BufferedChannelKt.f67785b;
            long j12 = j11 / i11;
            int i12 = (int) (j11 % i11);
            if (jVar.f68010c != j12) {
                j X = bufferedChannel.X(j12, jVar);
                if (X != null) {
                    jVar = X;
                } else if (v02) {
                    Object I0 = bufferedChannel.I0(obj, continuation);
                    if (I0 == IntrinsicsKt.f()) {
                        return I0;
                    }
                }
            }
            int i13 = bufferedChannel.i1(jVar, i12, obj, j11, null, v02);
            if (i13 == 0) {
                jVar.c();
                break;
            }
            if (i13 == 1) {
                break;
            }
            if (i13 != 2) {
                if (i13 == 3) {
                    Object Z0 = bufferedChannel.Z0(jVar, i12, obj, j11, continuation);
                    if (Z0 == IntrinsicsKt.f()) {
                        return Z0;
                    }
                } else if (i13 == 4) {
                    if (j11 < bufferedChannel.h0()) {
                        jVar.c();
                    }
                    Object I02 = bufferedChannel.I0(obj, continuation);
                    if (I02 == IntrinsicsKt.f()) {
                        return I02;
                    }
                } else if (i13 == 5) {
                    jVar.c();
                }
            } else if (v02) {
                jVar.t();
                Object I03 = bufferedChannel.I0(obj, continuation);
                if (I03 == IntrinsicsKt.f()) {
                    return I03;
                }
            }
        }
        return Unit.f67184a;
    }

    private final long Z() {
        return f67771f.get(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object Z0(kotlinx.coroutines.channels.j r21, int r22, java.lang.Object r23, long r24, kotlin.coroutines.Continuation r26) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.Z0(kotlinx.coroutines.channels.j, int, java.lang.Object, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean a1(long j11) {
        if (v0(j11)) {
            return false;
        }
        return !L(j11 & 1152921504606846975L);
    }

    private final boolean b1(Object obj, Object obj2) {
        boolean B;
        boolean B2;
        if (obj instanceof p) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuationImpl cancellableContinuationImpl = ((p) obj).f67821a;
            h b11 = h.b(h.f67813b.c(obj2));
            Function1 function1 = this.f67779b;
            B2 = BufferedChannelKt.B(cancellableContinuationImpl, b11, (Function3) (function1 != null ? K(function1) : null));
            return B2;
        }
        if (obj instanceof a) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).h(obj2);
        }
        if (!(obj instanceof kotlinx.coroutines.n)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.n nVar = (kotlinx.coroutines.n) obj;
        Function1 function12 = this.f67779b;
        B = BufferedChannelKt.B(nVar, obj2, (Function3) (function12 != null ? I(function12) : null));
        return B;
    }

    private final boolean c1(Object obj, j jVar, int i11) {
        if (obj instanceof kotlinx.coroutines.n) {
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.C((kotlinx.coroutines.n) obj, Unit.f67184a, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable e0() {
        Throwable b02 = b0();
        return b02 == null ? new ClosedReceiveChannelException("Channel was closed") : b02;
    }

    private final boolean e1(j jVar, int i11, long j11) {
        z zVar;
        z zVar2;
        Object B = jVar.B(i11);
        if ((B instanceof s2) && j11 >= f67770e.get(this)) {
            zVar = BufferedChannelKt.f67790g;
            if (jVar.v(i11, B, zVar)) {
                if (c1(B, jVar, i11)) {
                    jVar.F(i11, BufferedChannelKt.f67787d);
                    return true;
                }
                zVar2 = BufferedChannelKt.f67793j;
                jVar.F(i11, zVar2);
                jVar.C(i11, false);
                return false;
            }
        }
        return f1(jVar, i11, j11);
    }

    private final boolean f1(j jVar, int i11, long j11) {
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5;
        z zVar6;
        z zVar7;
        z zVar8;
        while (true) {
            Object B = jVar.B(i11);
            if (!(B instanceof s2)) {
                zVar3 = BufferedChannelKt.f67793j;
                if (B != zVar3) {
                    if (B != null) {
                        if (B != BufferedChannelKt.f67787d) {
                            zVar5 = BufferedChannelKt.f67791h;
                            if (B == zVar5) {
                                break;
                            }
                            zVar6 = BufferedChannelKt.f67792i;
                            if (B == zVar6) {
                                break;
                            }
                            zVar7 = BufferedChannelKt.f67794k;
                            if (B == zVar7 || B == BufferedChannelKt.z()) {
                                return true;
                            }
                            zVar8 = BufferedChannelKt.f67789f;
                            if (B != zVar8) {
                                throw new IllegalStateException(("Unexpected cell state: " + B).toString());
                            }
                        } else {
                            return true;
                        }
                    } else {
                        zVar4 = BufferedChannelKt.f67788e;
                        if (jVar.v(i11, B, zVar4)) {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            } else if (j11 >= f67770e.get(this)) {
                zVar = BufferedChannelKt.f67790g;
                if (jVar.v(i11, B, zVar)) {
                    if (c1(B, jVar, i11)) {
                        jVar.F(i11, BufferedChannelKt.f67787d);
                        return true;
                    }
                    zVar2 = BufferedChannelKt.f67793j;
                    jVar.F(i11, zVar2);
                    jVar.C(i11, false);
                    return false;
                }
            } else if (jVar.v(i11, B, new s((s2) B))) {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g1(j jVar, int i11, long j11, Object obj) {
        z zVar;
        z zVar2;
        z zVar3;
        Object B = jVar.B(i11);
        if (B == null) {
            if (j11 >= (f67769d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    zVar3 = BufferedChannelKt.f67797n;
                    return zVar3;
                }
                if (jVar.v(i11, B, obj)) {
                    U();
                    zVar2 = BufferedChannelKt.f67796m;
                    return zVar2;
                }
            }
        } else if (B == BufferedChannelKt.f67787d) {
            zVar = BufferedChannelKt.f67792i;
            if (jVar.v(i11, B, zVar)) {
                U();
                return jVar.D(i11);
            }
        }
        return h1(jVar, i11, j11, obj);
    }

    private final Object h1(j jVar, int i11, long j11, Object obj) {
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5;
        z zVar6;
        z zVar7;
        z zVar8;
        z zVar9;
        z zVar10;
        z zVar11;
        z zVar12;
        z zVar13;
        z zVar14;
        z zVar15;
        z zVar16;
        while (true) {
            Object B = jVar.B(i11);
            if (B != null) {
                zVar5 = BufferedChannelKt.f67788e;
                if (B != zVar5) {
                    if (B == BufferedChannelKt.f67787d) {
                        zVar6 = BufferedChannelKt.f67792i;
                        if (jVar.v(i11, B, zVar6)) {
                            U();
                            return jVar.D(i11);
                        }
                    } else {
                        zVar7 = BufferedChannelKt.f67793j;
                        if (B == zVar7) {
                            zVar8 = BufferedChannelKt.f67798o;
                            return zVar8;
                        }
                        zVar9 = BufferedChannelKt.f67791h;
                        if (B == zVar9) {
                            zVar10 = BufferedChannelKt.f67798o;
                            return zVar10;
                        }
                        if (B == BufferedChannelKt.z()) {
                            U();
                            zVar11 = BufferedChannelKt.f67798o;
                            return zVar11;
                        }
                        zVar12 = BufferedChannelKt.f67790g;
                        if (B != zVar12) {
                            zVar13 = BufferedChannelKt.f67789f;
                            if (jVar.v(i11, B, zVar13)) {
                                boolean z10 = B instanceof s;
                                if (z10) {
                                    B = ((s) B).f67822a;
                                }
                                if (c1(B, jVar, i11)) {
                                    zVar16 = BufferedChannelKt.f67792i;
                                    jVar.F(i11, zVar16);
                                    U();
                                    return jVar.D(i11);
                                }
                                zVar14 = BufferedChannelKt.f67793j;
                                jVar.F(i11, zVar14);
                                jVar.C(i11, false);
                                if (z10) {
                                    U();
                                }
                                zVar15 = BufferedChannelKt.f67798o;
                                return zVar15;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (j11 < (f67769d.get(this) & 1152921504606846975L)) {
                zVar = BufferedChannelKt.f67791h;
                if (jVar.v(i11, B, zVar)) {
                    U();
                    zVar2 = BufferedChannelKt.f67798o;
                    return zVar2;
                }
            } else {
                if (obj == null) {
                    zVar3 = BufferedChannelKt.f67797n;
                    return zVar3;
                }
                if (jVar.v(i11, B, obj)) {
                    U();
                    zVar4 = BufferedChannelKt.f67796m;
                    return zVar4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i1(j jVar, int i11, Object obj, long j11, Object obj2, boolean z10) {
        z zVar;
        z zVar2;
        z zVar3;
        jVar.G(i11, obj);
        if (z10) {
            return j1(jVar, i11, obj, j11, obj2, z10);
        }
        Object B = jVar.B(i11);
        if (B == null) {
            if (L(j11)) {
                if (jVar.v(i11, null, BufferedChannelKt.f67787d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (jVar.v(i11, null, obj2)) {
                    return 2;
                }
            }
        } else if (B instanceof s2) {
            jVar.w(i11);
            if (b1(B, obj)) {
                zVar3 = BufferedChannelKt.f67792i;
                jVar.F(i11, zVar3);
                K0();
                return 0;
            }
            zVar = BufferedChannelKt.f67794k;
            Object x10 = jVar.x(i11, zVar);
            zVar2 = BufferedChannelKt.f67794k;
            if (x10 != zVar2) {
                jVar.C(i11, true);
            }
            return 5;
        }
        return j1(jVar, i11, obj, j11, obj2, z10);
    }

    private final int j1(j jVar, int i11, Object obj, long j11, Object obj2, boolean z10) {
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5;
        z zVar6;
        z zVar7;
        while (true) {
            Object B = jVar.B(i11);
            if (B != null) {
                zVar2 = BufferedChannelKt.f67788e;
                if (B != zVar2) {
                    zVar3 = BufferedChannelKt.f67794k;
                    if (B == zVar3) {
                        jVar.w(i11);
                        return 5;
                    }
                    zVar4 = BufferedChannelKt.f67791h;
                    if (B == zVar4) {
                        jVar.w(i11);
                        return 5;
                    }
                    if (B == BufferedChannelKt.z()) {
                        jVar.w(i11);
                        S();
                        return 4;
                    }
                    jVar.w(i11);
                    if (B instanceof s) {
                        B = ((s) B).f67822a;
                    }
                    if (b1(B, obj)) {
                        zVar7 = BufferedChannelKt.f67792i;
                        jVar.F(i11, zVar7);
                        K0();
                        return 0;
                    }
                    zVar5 = BufferedChannelKt.f67794k;
                    Object x10 = jVar.x(i11, zVar5);
                    zVar6 = BufferedChannelKt.f67794k;
                    if (x10 != zVar6) {
                        jVar.C(i11, true);
                    }
                    return 5;
                }
                if (jVar.v(i11, B, BufferedChannelKt.f67787d)) {
                    return 1;
                }
            } else if (!L(j11) || z10) {
                if (z10) {
                    zVar = BufferedChannelKt.f67793j;
                    if (jVar.v(i11, null, zVar)) {
                        jVar.C(i11, false);
                        return 4;
                    }
                } else {
                    if (obj2 == null) {
                        return 3;
                    }
                    if (jVar.v(i11, null, obj2)) {
                        return 2;
                    }
                }
            } else if (jVar.v(i11, null, BufferedChannelKt.f67787d)) {
                return 1;
            }
        }
    }

    private final void k1(long j11) {
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67770e;
        do {
            j12 = atomicLongFieldUpdater.get(this);
            if (j12 >= j11) {
                return;
            }
        } while (!f67770e.compareAndSet(this, j12, j11));
    }

    private final void l1(long j11) {
        long j12;
        long w11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67769d;
        do {
            j12 = atomicLongFieldUpdater.get(this);
            long j13 = 1152921504606846975L & j12;
            if (j13 >= j11) {
                return;
            } else {
                w11 = BufferedChannelKt.w(j13, (int) (j12 >> 60));
            }
        } while (!f67769d.compareAndSet(this, j12, w11));
    }

    private final void o0(long j11) {
        if ((f67772g.addAndGet(this, j11) & 4611686018427387904L) == 0) {
            return;
        }
        do {
        } while ((f67772g.get(this) & 4611686018427387904L) != 0);
    }

    static /* synthetic */ void p0(BufferedChannel bufferedChannel, long j11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i11 & 1) != 0) {
            j11 = 1;
        }
        bufferedChannel.o0(j11);
    }

    private final void q0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67777l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.f67800q : BufferedChannelKt.f67801r));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(b0());
    }

    private final boolean r0(j jVar, int i11, long j11) {
        Object B;
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5;
        z zVar6;
        z zVar7;
        do {
            B = jVar.B(i11);
            if (B != null) {
                zVar2 = BufferedChannelKt.f67788e;
                if (B != zVar2) {
                    if (B == BufferedChannelKt.f67787d) {
                        return true;
                    }
                    zVar3 = BufferedChannelKt.f67793j;
                    if (B == zVar3 || B == BufferedChannelKt.z()) {
                        return false;
                    }
                    zVar4 = BufferedChannelKt.f67792i;
                    if (B == zVar4) {
                        return false;
                    }
                    zVar5 = BufferedChannelKt.f67791h;
                    if (B == zVar5) {
                        return false;
                    }
                    zVar6 = BufferedChannelKt.f67790g;
                    if (B == zVar6) {
                        return true;
                    }
                    zVar7 = BufferedChannelKt.f67789f;
                    return B != zVar7 && j11 == h0();
                }
            }
            zVar = BufferedChannelKt.f67791h;
        } while (!jVar.v(i11, B, zVar));
        U();
        return false;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater s() {
        return f67774i;
    }

    private final boolean s0(long j11, boolean z10) {
        int i11 = (int) (j11 >> 60);
        if (i11 == 0 || i11 == 1) {
            return false;
        }
        if (i11 == 2) {
            R(j11 & 1152921504606846975L);
            if (z10 && n0()) {
                return false;
            }
        } else {
            if (i11 != 3) {
                throw new IllegalStateException(("unexpected close status: " + i11).toString());
            }
            Q(j11 & 1152921504606846975L);
        }
        return true;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater t() {
        return f67770e;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater u() {
        return f67773h;
    }

    private final boolean u0(long j11) {
        return s0(j11, true);
    }

    public static final /* synthetic */ AtomicLongFieldUpdater v() {
        return f67769d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v0(long j11) {
        return s0(j11, false);
    }

    private final boolean x0() {
        long Z = Z();
        return Z == 0 || Z == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        r8 = (kotlinx.coroutines.channels.j) r8.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long y0(kotlinx.coroutines.channels.j r8) {
        /*
            r7 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f67785b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f68010c
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f67785b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.h0()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.B(r0)
            if (r1 == 0) goto L2c
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.f67787d
            if (r1 != r2) goto L39
            return r3
        L2c:
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r1 = r8.v(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.t()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            kotlinx.coroutines.internal.b r8 = r8.h()
            kotlinx.coroutines.channels.j r8 = (kotlinx.coroutines.channels.j) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.y0(kotlinx.coroutines.channels.j):long");
    }

    private final void z0() {
        long j11;
        long w11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67769d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (((int) (j11 >> 60)) != 0) {
                return;
            } else {
                w11 = BufferedChannelKt.w(1152921504606846975L & j11, 1);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, w11));
    }

    protected void F0() {
    }

    protected void K0() {
    }

    protected void L0() {
    }

    public boolean M(Throwable th2) {
        if (th2 == null) {
            th2 = new CancellationException("Channel was cancelled");
        }
        return P(th2, true);
    }

    protected boolean P(Throwable th2, boolean z10) {
        z zVar;
        if (z10) {
            z0();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f67776k;
        zVar = BufferedChannelKt.f67802s;
        boolean a11 = androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, th2);
        if (z10) {
            A0();
        } else {
            B0();
        }
        S();
        F0();
        if (a11) {
            q0();
        }
        return a11;
    }

    protected final void T(long j11) {
        z zVar;
        UndeliveredElementException c11;
        j jVar = (j) f67774i.get(this);
        while (true) {
            long j12 = f67770e.get(this);
            if (j11 < Math.max(this.f67778a + j12, Z())) {
                return;
            }
            if (f67770e.compareAndSet(this, j12, j12 + 1)) {
                int i11 = BufferedChannelKt.f67785b;
                long j13 = j12 / i11;
                int i12 = (int) (j12 % i11);
                if (jVar.f68010c != j13) {
                    j W = W(j13, jVar);
                    if (W == null) {
                        continue;
                    } else {
                        jVar = W;
                    }
                }
                Object g12 = g1(jVar, i12, j12, null);
                zVar = BufferedChannelKt.f67798o;
                if (g12 != zVar) {
                    jVar.c();
                    Function1 function1 = this.f67779b;
                    if (function1 != null && (c11 = kotlinx.coroutines.internal.s.c(function1, g12, null, 2, null)) != null) {
                        throw c11;
                    }
                } else if (j12 < l0()) {
                    jVar.c();
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.r
    public void a(Function1 function1) {
        z zVar;
        z zVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        z zVar3;
        z zVar4;
        if (androidx.concurrent.futures.a.a(f67777l, this, null, function1)) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f67777l;
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            zVar = BufferedChannelKt.f67800q;
            if (obj != zVar) {
                zVar2 = BufferedChannelKt.f67801r;
                if (obj == zVar2) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            atomicReferenceFieldUpdater = f67777l;
            zVar3 = BufferedChannelKt.f67800q;
            zVar4 = BufferedChannelKt.f67801r;
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar3, zVar4));
        function1.invoke(b0());
    }

    protected final Throwable b0() {
        return (Throwable) f67776k.get(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return kotlinx.coroutines.channels.h.f67813b.c(kotlin.Unit.f67184a);
     */
    @Override // kotlinx.coroutines.channels.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.Object r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = k0()
            long r0 = r0.get(r14)
            boolean r0 = r14.a1(r0)
            if (r0 == 0) goto L15
            kotlinx.coroutines.channels.h$b r15 = kotlinx.coroutines.channels.h.f67813b
            java.lang.Object r15 = r15.b()
            return r15
        L15:
            kotlinx.coroutines.internal.z r8 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = u()
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.j r0 = (kotlinx.coroutines.channels.j) r0
        L23:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = v()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = w(r14, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f67785b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f68010c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L5b
            kotlinx.coroutines.channels.j r1 = o(r14, r2, r0)
            if (r1 != 0) goto L59
            if (r11 == 0) goto L23
        L4d:
            kotlinx.coroutines.channels.h$b r15 = kotlinx.coroutines.channels.h.f67813b
            java.lang.Throwable r0 = r14.i0()
            java.lang.Object r15 = r15.a(r0)
            goto Lbc
        L59:
            r13 = r1
            goto L5c
        L5b:
            r13 = r0
        L5c:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = G(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb8
            r1 = 1
            if (r0 == r1) goto Laf
            r1 = 2
            if (r0 == r1) goto L92
            r1 = 3
            if (r0 == r1) goto L8a
            r1 = 4
            if (r0 == r1) goto L7e
            r1 = 5
            if (r0 == r1) goto L79
            goto L7c
        L79:
            r13.c()
        L7c:
            r0 = r13
            goto L23
        L7e:
            long r0 = r14.h0()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L4d
            r13.c()
            goto L4d
        L8a:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            r15.<init>(r0)
            throw r15
        L92:
            if (r11 == 0) goto L98
            r13.t()
            goto L4d
        L98:
            boolean r15 = r8 instanceof kotlinx.coroutines.s2
            if (r15 == 0) goto L9f
            kotlinx.coroutines.s2 r8 = (kotlinx.coroutines.s2) r8
            goto La0
        L9f:
            r8 = 0
        La0:
            if (r8 == 0) goto La5
            D(r14, r8, r13, r12)
        La5:
            r13.t()
            kotlinx.coroutines.channels.h$b r15 = kotlinx.coroutines.channels.h.f67813b
            java.lang.Object r15 = r15.b()
            goto Lbc
        Laf:
            kotlinx.coroutines.channels.h$b r15 = kotlinx.coroutines.channels.h.f67813b
            kotlin.Unit r0 = kotlin.Unit.f67184a
            java.lang.Object r15 = r15.c(r0)
            goto Lbc
        Lb8:
            r13.c()
            goto Laf
        Lbc:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.c(java.lang.Object):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.q
    public final void cancel(CancellationException cancellationException) {
        M(cancellationException);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object d1(Object obj) {
        j jVar;
        Object obj2 = BufferedChannelKt.f67787d;
        j jVar2 = (j) u().get(this);
        while (true) {
            long andIncrement = v().getAndIncrement(this);
            long j11 = andIncrement & 1152921504606846975L;
            boolean v02 = v0(andIncrement);
            int i11 = BufferedChannelKt.f67785b;
            long j12 = j11 / i11;
            int i12 = (int) (j11 % i11);
            if (jVar2.f68010c != j12) {
                j X = X(j12, jVar2);
                if (X != null) {
                    jVar = X;
                } else if (v02) {
                    return h.f67813b.a(i0());
                }
            } else {
                jVar = jVar2;
            }
            int i13 = i1(jVar, i12, obj, j11, obj2, v02);
            if (i13 == 0) {
                jVar.c();
                return h.f67813b.c(Unit.f67184a);
            }
            if (i13 == 1) {
                return h.f67813b.c(Unit.f67184a);
            }
            if (i13 == 2) {
                if (v02) {
                    jVar.t();
                    return h.f67813b.a(i0());
                }
                s2 s2Var = obj2 instanceof s2 ? (s2) obj2 : null;
                if (s2Var != null) {
                    P0(s2Var, jVar, i12);
                }
                T((jVar.f68010c * i11) + i12);
                return h.f67813b.c(Unit.f67184a);
            }
            if (i13 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (i13 == 4) {
                if (j11 < h0()) {
                    jVar.c();
                }
                return h.f67813b.a(i0());
            }
            if (i13 == 5) {
                jVar.c();
            }
            jVar2 = jVar;
        }
    }

    @Override // kotlinx.coroutines.channels.q
    public Object e() {
        Object obj;
        j jVar;
        z zVar;
        z zVar2;
        z zVar3;
        long j11 = f67770e.get(this);
        long j12 = f67769d.get(this);
        if (u0(j12)) {
            return h.f67813b.a(b0());
        }
        if (j11 >= (j12 & 1152921504606846975L)) {
            return h.f67813b.b();
        }
        obj = BufferedChannelKt.f67794k;
        j jVar2 = (j) s().get(this);
        while (!t0()) {
            long andIncrement = t().getAndIncrement(this);
            int i11 = BufferedChannelKt.f67785b;
            long j13 = andIncrement / i11;
            int i12 = (int) (andIncrement % i11);
            if (jVar2.f68010c != j13) {
                j W = W(j13, jVar2);
                if (W == null) {
                    continue;
                } else {
                    jVar = W;
                }
            } else {
                jVar = jVar2;
            }
            Object g12 = g1(jVar, i12, andIncrement, obj);
            zVar = BufferedChannelKt.f67796m;
            if (g12 == zVar) {
                s2 s2Var = obj instanceof s2 ? (s2) obj : null;
                if (s2Var != null) {
                    O0(s2Var, jVar, i12);
                }
                m1(andIncrement);
                jVar.t();
                return h.f67813b.b();
            }
            zVar2 = BufferedChannelKt.f67798o;
            if (g12 != zVar2) {
                zVar3 = BufferedChannelKt.f67797n;
                if (g12 == zVar3) {
                    throw new IllegalStateException("unexpected");
                }
                jVar.c();
                return h.f67813b.c(g12);
            }
            if (andIncrement < l0()) {
                jVar.c();
            }
            jVar2 = jVar;
        }
        return h.f67813b.a(b0());
    }

    @Override // kotlinx.coroutines.channels.q
    public Object f(Continuation continuation) {
        return R0(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.q
    public Object g(Continuation continuation) {
        return Q0(this, continuation);
    }

    public final long h0() {
        return f67770e.get(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Throwable i0() {
        Throwable b02 = b0();
        return b02 == null ? new ClosedSendChannelException("Channel was closed") : b02;
    }

    @Override // kotlinx.coroutines.channels.q
    public f iterator() {
        return new a();
    }

    @Override // kotlinx.coroutines.channels.r
    public boolean j(Throwable th2) {
        return P(th2, false);
    }

    public final long l0() {
        return f67769d.get(this) & 1152921504606846975L;
    }

    public final void m1(long j11) {
        int i11;
        long j12;
        long v11;
        long v12;
        long j13;
        long v13;
        if (x0()) {
            return;
        }
        do {
        } while (Z() <= j11);
        i11 = BufferedChannelKt.f67786c;
        for (int i12 = 0; i12 < i11; i12++) {
            long Z = Z();
            if (Z == (f67772g.get(this) & 4611686018427387903L) && Z == Z()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f67772g;
        do {
            j12 = atomicLongFieldUpdater.get(this);
            v11 = BufferedChannelKt.v(j12 & 4611686018427387903L, true);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j12, v11));
        while (true) {
            long Z2 = Z();
            long j14 = f67772g.get(this);
            long j15 = j14 & 4611686018427387903L;
            boolean z10 = (4611686018427387904L & j14) != 0;
            if (Z2 == j15 && Z2 == Z()) {
                break;
            }
            if (!z10) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = f67772g;
                v12 = BufferedChannelKt.v(j15, true);
                atomicLongFieldUpdater2.compareAndSet(this, j14, v12);
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater3 = f67772g;
        do {
            j13 = atomicLongFieldUpdater3.get(this);
            v13 = BufferedChannelKt.v(j13 & 4611686018427387903L, false);
        } while (!atomicLongFieldUpdater3.compareAndSet(this, j13, v13));
    }

    public final boolean n0() {
        while (true) {
            j jVar = (j) f67774i.get(this);
            long h02 = h0();
            if (l0() <= h02) {
                return false;
            }
            int i11 = BufferedChannelKt.f67785b;
            long j11 = h02 / i11;
            if (jVar.f68010c == j11 || (jVar = W(j11, jVar)) != null) {
                jVar.c();
                if (r0(jVar, (int) (h02 % i11), h02)) {
                    return true;
                }
                f67770e.compareAndSet(this, h02, 1 + h02);
            } else if (((j) f67774i.get(this)).f68010c < j11) {
                return false;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.r
    public Object p(Object obj, Continuation continuation) {
        return Y0(this, obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.r
    public boolean q() {
        return v0(f67769d.get(this));
    }

    public boolean t0() {
        return u0(f67769d.get(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b5, code lost:
    
        r3 = (kotlinx.coroutines.channels.j) r3.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01bc, code lost:
    
        if (r3 != null) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    protected boolean w0() {
        return false;
    }
}
