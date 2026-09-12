package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.snapshots.j;
import androidx.compose.runtime.snapshots.k;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.n;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public final class Recomposer extends m {

    /* renamed from: a, reason: collision with root package name */
    private long f3711a;

    /* renamed from: b, reason: collision with root package name */
    private final BroadcastFrameClock f3712b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f3713c;

    /* renamed from: d, reason: collision with root package name */
    private kotlinx.coroutines.t1 f3714d;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f3715e;

    /* renamed from: f, reason: collision with root package name */
    private final List f3716f;

    /* renamed from: g, reason: collision with root package name */
    private List f3717g;

    /* renamed from: h, reason: collision with root package name */
    private MutableScatterSet f3718h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f3719i;

    /* renamed from: j, reason: collision with root package name */
    private final List f3720j;

    /* renamed from: k, reason: collision with root package name */
    private final List f3721k;

    /* renamed from: l, reason: collision with root package name */
    private final Map f3722l;

    /* renamed from: m, reason: collision with root package name */
    private final Map f3723m;

    /* renamed from: n, reason: collision with root package name */
    private List f3724n;

    /* renamed from: o, reason: collision with root package name */
    private Set f3725o;

    /* renamed from: p, reason: collision with root package name */
    private kotlinx.coroutines.n f3726p;

    /* renamed from: q, reason: collision with root package name */
    private int f3727q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f3728r;

    /* renamed from: s, reason: collision with root package name */
    private b f3729s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f3730t;

    /* renamed from: u, reason: collision with root package name */
    private final kotlinx.coroutines.flow.y0 f3731u;

    /* renamed from: v, reason: collision with root package name */
    private final kotlinx.coroutines.z f3732v;

    /* renamed from: w, reason: collision with root package name */
    private final CoroutineContext f3733w;

    /* renamed from: x, reason: collision with root package name */
    private final c f3734x;

    /* renamed from: y, reason: collision with root package name */
    public static final a f3709y = new a(null);

    /* renamed from: z, reason: collision with root package name */
    public static final int f3710z = 8;
    private static final kotlinx.coroutines.flow.y0 A = kotlinx.coroutines.flow.j1.a(t.a.c());
    private static final AtomicReference B = new AtomicReference(Boolean.FALSE);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(c cVar) {
            t.h hVar;
            t.h add;
            do {
                hVar = (t.h) Recomposer.A.getValue();
                add = hVar.add((Object) cVar);
                if (hVar == add) {
                    return;
                }
            } while (!Recomposer.A.e(hVar, add));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(c cVar) {
            t.h hVar;
            t.h remove;
            do {
                hVar = (t.h) Recomposer.A.getValue();
                remove = hVar.remove((Object) cVar);
                if (hVar == remove) {
                    return;
                }
            } while (!Recomposer.A.e(hVar, remove));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f3735a;

        /* renamed from: b, reason: collision with root package name */
        private final Exception f3736b;

        public b(boolean z10, Exception exc) {
            this.f3735a = z10;
            this.f3736b = exc;
        }

        public Exception a() {
            return this.f3736b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c {
        public c() {
        }
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m85invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m85invoke() {
                kotlinx.coroutines.n a02;
                kotlinx.coroutines.flow.y0 y0Var;
                Throwable th2;
                Object obj = Recomposer.this.f3713c;
                Recomposer recomposer = Recomposer.this;
                synchronized (obj) {
                    a02 = recomposer.a0();
                    y0Var = recomposer.f3731u;
                    if (((Recomposer.State) y0Var.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        th2 = recomposer.f3715e;
                        throw kotlinx.coroutines.i1.a("Recomposer shutdown; frame clock awaiter will never resume", th2);
                    }
                }
                if (a02 != null) {
                    Result.Companion companion = Result.INSTANCE;
                    a02.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
                }
            }
        });
        this.f3712b = broadcastFrameClock;
        this.f3713c = new Object();
        this.f3716f = new ArrayList();
        this.f3718h = new MutableScatterSet(0, 1, null);
        this.f3719i = new androidx.compose.runtime.collection.b(new y[16], 0);
        this.f3720j = new ArrayList();
        this.f3721k = new ArrayList();
        this.f3722l = new LinkedHashMap();
        this.f3723m = new LinkedHashMap();
        this.f3731u = kotlinx.coroutines.flow.j1.a(State.Inactive);
        kotlinx.coroutines.z a11 = kotlinx.coroutines.v1.a((kotlinx.coroutines.t1) coroutineContext.get(kotlinx.coroutines.t1.f68119l1));
        a11.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f67184a;
            }

            public final void invoke(final Throwable th2) {
                kotlinx.coroutines.t1 t1Var;
                kotlinx.coroutines.n nVar;
                kotlinx.coroutines.flow.y0 y0Var;
                kotlinx.coroutines.flow.y0 y0Var2;
                boolean z10;
                kotlinx.coroutines.n nVar2;
                kotlinx.coroutines.n nVar3;
                CancellationException a12 = kotlinx.coroutines.i1.a("Recomposer effect job completed", th2);
                Object obj = Recomposer.this.f3713c;
                final Recomposer recomposer = Recomposer.this;
                synchronized (obj) {
                    try {
                        t1Var = recomposer.f3714d;
                        nVar = null;
                        if (t1Var != null) {
                            y0Var2 = recomposer.f3731u;
                            y0Var2.setValue(Recomposer.State.ShuttingDown);
                            z10 = recomposer.f3728r;
                            if (z10) {
                                nVar2 = recomposer.f3726p;
                                if (nVar2 != null) {
                                    nVar3 = recomposer.f3726p;
                                    recomposer.f3726p = null;
                                    t1Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((Throwable) obj2);
                                            return Unit.f67184a;
                                        }

                                        public final void invoke(Throwable th3) {
                                            kotlinx.coroutines.flow.y0 y0Var3;
                                            Object obj2 = Recomposer.this.f3713c;
                                            Recomposer recomposer2 = Recomposer.this;
                                            Throwable th4 = th2;
                                            synchronized (obj2) {
                                                if (th4 == null) {
                                                    th4 = null;
                                                } else if (th3 != null) {
                                                    try {
                                                        if (th3 instanceof CancellationException) {
                                                            th3 = null;
                                                        }
                                                        if (th3 != null) {
                                                            ExceptionsKt.a(th4, th3);
                                                        }
                                                    } catch (Throwable th5) {
                                                        throw th5;
                                                    }
                                                }
                                                recomposer2.f3715e = th4;
                                                y0Var3 = recomposer2.f3731u;
                                                y0Var3.setValue(Recomposer.State.ShutDown);
                                                Unit unit = Unit.f67184a;
                                            }
                                        }
                                    });
                                    nVar = nVar3;
                                }
                            } else {
                                t1Var.cancel(a12);
                            }
                            nVar3 = null;
                            recomposer.f3726p = null;
                            t1Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((Throwable) obj2);
                                    return Unit.f67184a;
                                }

                                public final void invoke(Throwable th3) {
                                    kotlinx.coroutines.flow.y0 y0Var3;
                                    Object obj2 = Recomposer.this.f3713c;
                                    Recomposer recomposer2 = Recomposer.this;
                                    Throwable th4 = th2;
                                    synchronized (obj2) {
                                        if (th4 == null) {
                                            th4 = null;
                                        } else if (th3 != null) {
                                            try {
                                                if (th3 instanceof CancellationException) {
                                                    th3 = null;
                                                }
                                                if (th3 != null) {
                                                    ExceptionsKt.a(th4, th3);
                                                }
                                            } catch (Throwable th5) {
                                                throw th5;
                                            }
                                        }
                                        recomposer2.f3715e = th4;
                                        y0Var3 = recomposer2.f3731u;
                                        y0Var3.setValue(Recomposer.State.ShutDown);
                                        Unit unit = Unit.f67184a;
                                    }
                                }
                            });
                            nVar = nVar3;
                        } else {
                            recomposer.f3715e = a12;
                            y0Var = recomposer.f3731u;
                            y0Var.setValue(Recomposer.State.ShutDown);
                            Unit unit = Unit.f67184a;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (nVar != null) {
                    Result.Companion companion = Result.INSTANCE;
                    nVar.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
                }
            }
        });
        this.f3732v = a11;
        this.f3733w = coroutineContext.plus(broadcastFrameClock).plus(a11);
        this.f3734x = new c();
    }

    private final Function1 A0(final y yVar, final MutableScatterSet mutableScatterSet) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$writeObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m88invoke(obj);
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m88invoke(Object obj) {
                y.this.q(obj);
                MutableScatterSet mutableScatterSet2 = mutableScatterSet;
                if (mutableScatterSet2 != null) {
                    mutableScatterSet2.h(obj);
                }
            }
        };
    }

    private final void V(y yVar) {
        this.f3716f.add(yVar);
        this.f3717g = null;
    }

    private final void W(androidx.compose.runtime.snapshots.b bVar) {
        try {
            if (bVar.C() instanceof k.a) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        if (h0()) {
            return Unit.f67184a;
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl2.initCancellability();
        synchronized (this.f3713c) {
            if (h0()) {
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                this.f3726p = cancellableContinuationImpl2;
                cancellableContinuationImpl = null;
            }
        }
        if (cancellableContinuationImpl != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
        }
        Object result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    private final void Z() {
        this.f3716f.clear();
        this.f3717g = CollectionsKt.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.n a0() {
        State state;
        if (((State) this.f3731u.getValue()).compareTo(State.ShuttingDown) <= 0) {
            Z();
            this.f3718h = new MutableScatterSet(0, 1, null);
            this.f3719i.h();
            this.f3720j.clear();
            this.f3721k.clear();
            this.f3724n = null;
            kotlinx.coroutines.n nVar = this.f3726p;
            if (nVar != null) {
                n.a.a(nVar, null, 1, null);
            }
            this.f3726p = null;
            this.f3729s = null;
            return null;
        }
        if (this.f3729s != null) {
            state = State.Inactive;
        } else if (this.f3714d == null) {
            this.f3718h = new MutableScatterSet(0, 1, null);
            this.f3719i.h();
            state = f0() ? State.InactivePendingWork : State.Inactive;
        } else {
            state = (this.f3719i.q() || this.f3718h.e() || !this.f3720j.isEmpty() || !this.f3721k.isEmpty() || this.f3727q > 0 || f0()) ? State.PendingWork : State.Idle;
        }
        this.f3731u.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        kotlinx.coroutines.n nVar2 = this.f3726p;
        this.f3726p = null;
        return nVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        int i11;
        List l11;
        synchronized (this.f3713c) {
            try {
                if (this.f3722l.isEmpty()) {
                    l11 = CollectionsKt.l();
                } else {
                    List x10 = CollectionsKt.x(this.f3722l.values());
                    this.f3722l.clear();
                    l11 = new ArrayList(x10.size());
                    int size = x10.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        y0 y0Var = (y0) x10.get(i12);
                        l11.add(TuplesKt.a(y0Var, this.f3723m.get(y0Var)));
                    }
                    this.f3723m.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int size2 = l11.size();
        for (i11 = 0; i11 < size2; i11++) {
            Pair pair = (Pair) l11.get(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e0() {
        boolean f02;
        synchronized (this.f3713c) {
            f02 = f0();
        }
        return f02;
    }

    private final boolean f0() {
        return !this.f3730t && this.f3712b.p();
    }

    private final boolean g0() {
        return this.f3719i.q() || f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h0() {
        boolean z10;
        synchronized (this.f3713c) {
            if (!this.f3718h.e() && !this.f3719i.q()) {
                z10 = f0();
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List i0() {
        List list = this.f3717g;
        if (list == null) {
            List list2 = this.f3716f;
            list = list2.isEmpty() ? CollectionsKt.l() : new ArrayList(list2);
            this.f3717g = list;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j0() {
        boolean z10;
        synchronized (this.f3713c) {
            z10 = this.f3728r;
        }
        if (z10) {
            Iterator f67553a = this.f3732v.getChildren().getF67553a();
            while (f67553a.hasNext()) {
                if (((kotlinx.coroutines.t1) f67553a.next()).isActive()) {
                }
            }
            return false;
        }
        return true;
    }

    private final void m0(y yVar) {
        synchronized (this.f3713c) {
            List list = this.f3721k;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (Intrinsics.c(((y0) list.get(i11)).b(), yVar)) {
                    Unit unit = Unit.f67184a;
                    ArrayList arrayList = new ArrayList();
                    n0(arrayList, this, yVar);
                    while (!arrayList.isEmpty()) {
                        o0(arrayList, null);
                        n0(arrayList, this, yVar);
                    }
                    return;
                }
            }
        }
    }

    private static final void n0(List list, Recomposer recomposer, y yVar) {
        list.clear();
        synchronized (recomposer.f3713c) {
            try {
                Iterator it = recomposer.f3721k.iterator();
                while (it.hasNext()) {
                    y0 y0Var = (y0) it.next();
                    if (Intrinsics.c(y0Var.b(), yVar)) {
                        list.add(y0Var);
                        it.remove();
                    }
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b4, code lost:
    
        r1 = r7.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        if (r6 >= r1) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c5, code lost:
    
        if (((kotlin.Pair) r7.get(r6)).getSecond() == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c7, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:
    
        r1 = new java.util.ArrayList(r7.size());
        r6 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d8, code lost:
    
        if (r8 >= r6) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00da, code lost:
    
        r9 = (kotlin.Pair) r7.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e4, code lost:
    
        if (r9.getSecond() != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e6, code lost:
    
        r9 = (androidx.compose.runtime.y0) r9.getFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (r9 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f2, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f5, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ef, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f8, code lost:
    
        r6 = r13.f3713c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fa, code lost:
    
        monitor-enter(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fb, code lost:
    
        kotlin.collections.CollectionsKt.B(r13.f3721k, r1);
        r1 = kotlin.Unit.f67184a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0104, code lost:
    
        monitor-exit(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0105, code lost:
    
        r1 = new java.util.ArrayList(r7.size());
        r6 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0113, code lost:
    
        if (r8 >= r6) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0115, code lost:
    
        r9 = r7.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0120, code lost:
    
        if (((kotlin.Pair) r9).getSecond() == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0122, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0125, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0128, code lost:
    
        r7 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List o0(java.util.List r14, androidx.collection.MutableScatterSet r15) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.o0(java.util.List, androidx.collection.MutableScatterSet):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y p0(final y yVar, final MutableScatterSet mutableScatterSet) {
        Set set;
        if (yVar.o() || yVar.isDisposed() || ((set = this.f3725o) != null && set.contains(yVar))) {
            return null;
        }
        androidx.compose.runtime.snapshots.b o11 = androidx.compose.runtime.snapshots.j.f4079e.o(s0(yVar), A0(yVar, mutableScatterSet));
        try {
            androidx.compose.runtime.snapshots.j l11 = o11.l();
            if (mutableScatterSet != null) {
                try {
                    if (mutableScatterSet.e()) {
                        yVar.l(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m86invoke();
                                return Unit.f67184a;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m86invoke() {
                                MutableScatterSet mutableScatterSet2 = MutableScatterSet.this;
                                y yVar2 = yVar;
                                Object[] objArr = mutableScatterSet2.f2322b;
                                long[] jArr = mutableScatterSet2.f2321a;
                                int length = jArr.length - 2;
                                if (length < 0) {
                                    return;
                                }
                                int i11 = 0;
                                while (true) {
                                    long j11 = jArr[i11];
                                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                                        for (int i13 = 0; i13 < i12; i13++) {
                                            if ((255 & j11) < 128) {
                                                yVar2.q(objArr[(i11 << 3) + i13]);
                                            }
                                            j11 >>= 8;
                                        }
                                        if (i12 != 8) {
                                            return;
                                        }
                                    }
                                    if (i11 == length) {
                                        return;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                        });
                    }
                } catch (Throwable th2) {
                    o11.s(l11);
                    throw th2;
                }
            }
            boolean i11 = yVar.i();
            o11.s(l11);
            if (i11) {
                return yVar;
            }
            return null;
        } finally {
            W(o11);
        }
    }

    private final void q0(Exception exc, y yVar, boolean z10) {
        if (!((Boolean) B.get()).booleanValue() || (exc instanceof ComposeRuntimeError)) {
            synchronized (this.f3713c) {
                b bVar = this.f3729s;
                if (bVar != null) {
                    throw bVar.a();
                }
                this.f3729s = new b(false, exc);
                Unit unit = Unit.f67184a;
            }
            throw exc;
        }
        synchronized (this.f3713c) {
            try {
                ActualAndroid_androidKt.e("Error was captured in composition while live edit was enabled.", exc);
                this.f3720j.clear();
                this.f3719i.h();
                this.f3718h = new MutableScatterSet(0, 1, null);
                this.f3721k.clear();
                this.f3722l.clear();
                this.f3723m.clear();
                this.f3729s = new b(z10, exc);
                if (yVar != null) {
                    v0(yVar);
                }
                a0();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r0(Recomposer recomposer, Exception exc, y yVar, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            yVar = null;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        recomposer.q0(exc, yVar, z10);
    }

    private final Function1 s0(final y yVar) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$readObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m87invoke(obj);
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m87invoke(Object obj) {
                y.this.a(obj);
            }
        };
    }

    private final Object t0(Function3 function3, Continuation continuation) {
        Object g11 = kotlinx.coroutines.i.g(this.f3712b, new Recomposer$recompositionRunner$2(this, function3, v0.a(continuation.getContext()), null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u0() {
        List i02;
        boolean g02;
        synchronized (this.f3713c) {
            if (this.f3718h.d()) {
                return g0();
            }
            Set a11 = androidx.compose.runtime.collection.d.a(this.f3718h);
            this.f3718h = new MutableScatterSet(0, 1, null);
            synchronized (this.f3713c) {
                i02 = i0();
            }
            try {
                int size = i02.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((y) i02.get(i11)).m(a11);
                    if (((State) this.f3731u.getValue()).compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.f3713c) {
                    this.f3718h = new MutableScatterSet(0, 1, null);
                    Unit unit = Unit.f67184a;
                }
                synchronized (this.f3713c) {
                    if (a0() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    g02 = g0();
                }
                return g02;
            } catch (Throwable th2) {
                synchronized (this.f3713c) {
                    this.f3718h.j(a11);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(y yVar) {
        List list = this.f3724n;
        if (list == null) {
            list = new ArrayList();
            this.f3724n = list;
        }
        if (!list.contains(yVar)) {
            list.add(yVar);
        }
        x0(yVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(kotlinx.coroutines.t1 t1Var) {
        synchronized (this.f3713c) {
            Throwable th2 = this.f3715e;
            if (th2 != null) {
                throw th2;
            }
            if (((State) this.f3731u.getValue()).compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down");
            }
            if (this.f3714d != null) {
                throw new IllegalStateException("Recomposer already running");
            }
            this.f3714d = t1Var;
            a0();
        }
    }

    private final void x0(y yVar) {
        this.f3716f.remove(yVar);
        this.f3717g = null;
    }

    public final void Y() {
        synchronized (this.f3713c) {
            try {
                if (((State) this.f3731u.getValue()).compareTo(State.Idle) >= 0) {
                    this.f3731u.setValue(State.ShuttingDown);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        t1.a.b(this.f3732v, null, 1, null);
    }

    @Override // androidx.compose.runtime.m
    public void a(y yVar, Function2 function2) {
        boolean o11 = yVar.o();
        try {
            j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
            androidx.compose.runtime.snapshots.b o12 = aVar.o(s0(yVar), A0(yVar, null));
            try {
                androidx.compose.runtime.snapshots.j l11 = o12.l();
                try {
                    yVar.b(function2);
                    Unit unit = Unit.f67184a;
                    if (!o11) {
                        aVar.g();
                    }
                    synchronized (this.f3713c) {
                        if (((State) this.f3731u.getValue()).compareTo(State.ShuttingDown) > 0 && !i0().contains(yVar)) {
                            V(yVar);
                        }
                    }
                    try {
                        m0(yVar);
                        try {
                            yVar.n();
                            yVar.c();
                            if (o11) {
                                return;
                            }
                            aVar.g();
                        } catch (Exception e11) {
                            r0(this, e11, null, false, 6, null);
                        }
                    } catch (Exception e12) {
                        q0(e12, yVar, true);
                    }
                } finally {
                    o12.s(l11);
                }
            } finally {
                W(o12);
            }
        } catch (Exception e13) {
            q0(e13, yVar, true);
        }
    }

    @Override // androidx.compose.runtime.m
    public boolean c() {
        return ((Boolean) B.get()).booleanValue();
    }

    public final long c0() {
        return this.f3711a;
    }

    @Override // androidx.compose.runtime.m
    public boolean d() {
        return false;
    }

    public final kotlinx.coroutines.flow.i1 d0() {
        return this.f3731u;
    }

    @Override // androidx.compose.runtime.m
    public boolean e() {
        return false;
    }

    @Override // androidx.compose.runtime.m
    public int g() {
        return 1000;
    }

    @Override // androidx.compose.runtime.m
    public CoroutineContext h() {
        return this.f3733w;
    }

    @Override // androidx.compose.runtime.m
    public void j(y0 y0Var) {
        kotlinx.coroutines.n a02;
        synchronized (this.f3713c) {
            this.f3721k.add(y0Var);
            a02 = a0();
        }
        if (a02 != null) {
            Result.Companion companion = Result.INSTANCE;
            a02.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
        }
    }

    @Override // androidx.compose.runtime.m
    public void k(y yVar) {
        kotlinx.coroutines.n nVar;
        synchronized (this.f3713c) {
            if (this.f3719i.i(yVar)) {
                nVar = null;
            } else {
                this.f3719i.b(yVar);
                nVar = a0();
            }
        }
        if (nVar != null) {
            Result.Companion companion = Result.INSTANCE;
            nVar.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
        }
    }

    public final Object k0(Continuation continuation) {
        Object q11 = kotlinx.coroutines.flow.d.q(d0(), new Recomposer$join$2(null), continuation);
        return q11 == IntrinsicsKt.f() ? q11 : Unit.f67184a;
    }

    @Override // androidx.compose.runtime.m
    public x0 l(y0 y0Var) {
        x0 x0Var;
        synchronized (this.f3713c) {
            x0Var = (x0) this.f3723m.remove(y0Var);
        }
        return x0Var;
    }

    public final void l0() {
        synchronized (this.f3713c) {
            this.f3730t = true;
            Unit unit = Unit.f67184a;
        }
    }

    @Override // androidx.compose.runtime.m
    public void m(Set set) {
    }

    @Override // androidx.compose.runtime.m
    public void o(y yVar) {
        synchronized (this.f3713c) {
            try {
                Set set = this.f3725o;
                if (set == null) {
                    set = new LinkedHashSet();
                    this.f3725o = set;
                }
                set.add(yVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.m
    public void r(y yVar) {
        synchronized (this.f3713c) {
            x0(yVar);
            this.f3719i.t(yVar);
            this.f3720j.remove(yVar);
            Unit unit = Unit.f67184a;
        }
    }

    public final void y0() {
        kotlinx.coroutines.n nVar;
        synchronized (this.f3713c) {
            if (this.f3730t) {
                this.f3730t = false;
                nVar = a0();
            } else {
                nVar = null;
            }
        }
        if (nVar != null) {
            Result.Companion companion = Result.INSTANCE;
            nVar.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
        }
    }

    public final Object z0(Continuation continuation) {
        Object t02 = t0(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        return t02 == IntrinsicsKt.f() ? t02 : Unit.f67184a;
    }
}
