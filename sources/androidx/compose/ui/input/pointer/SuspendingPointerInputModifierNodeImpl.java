package androidx.compose.ui.input.pointer;

import androidx.compose.ui.f;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.d1;
import androidx.compose.ui.platform.o2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public final class SuspendingPointerInputModifierNodeImpl extends f.c implements n0, e0, o0.e {

    /* renamed from: n, reason: collision with root package name */
    private Object f5031n;

    /* renamed from: o, reason: collision with root package name */
    private Object f5032o;

    /* renamed from: p, reason: collision with root package name */
    private Object[] f5033p;

    /* renamed from: q, reason: collision with root package name */
    private Function2 f5034q;

    /* renamed from: r, reason: collision with root package name */
    private t1 f5035r;

    /* renamed from: s, reason: collision with root package name */
    private o f5036s;

    /* renamed from: t, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5037t;

    /* renamed from: u, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5038u;

    /* renamed from: v, reason: collision with root package name */
    private o f5039v;

    /* renamed from: w, reason: collision with root package name */
    private long f5040w;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class PointerEventHandlerCoroutine implements c, o0.e, Continuation {

        /* renamed from: a, reason: collision with root package name */
        private final Continuation f5041a;

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ SuspendingPointerInputModifierNodeImpl f5042b;

        /* renamed from: c, reason: collision with root package name */
        private kotlinx.coroutines.n f5043c;

        /* renamed from: d, reason: collision with root package name */
        private PointerEventPass f5044d = PointerEventPass.Main;

        /* renamed from: e, reason: collision with root package name */
        private final CoroutineContext f5045e = EmptyCoroutineContext.INSTANCE;

        public PointerEventHandlerCoroutine(Continuation continuation) {
            this.f5041a = continuation;
            this.f5042b = SuspendingPointerInputModifierNodeImpl.this;
        }

        public final void B(Throwable th2) {
            kotlinx.coroutines.n nVar = this.f5043c;
            if (nVar != null) {
                nVar.cancel(th2);
            }
            this.f5043c = null;
        }

        public final void C(o oVar, PointerEventPass pointerEventPass) {
            kotlinx.coroutines.n nVar;
            if (pointerEventPass != this.f5044d || (nVar = this.f5043c) == null) {
                return;
            }
            this.f5043c = null;
            nVar.resumeWith(Result.m1185constructorimpl(oVar));
        }

        @Override // o0.n
        public float C0() {
            return this.f5042b.C0();
        }

        @Override // o0.e
        public float E0(float f11) {
            return this.f5042b.E0(f11);
        }

        @Override // o0.n
        public long H(float f11) {
            return this.f5042b.H(f11);
        }

        @Override // o0.n
        public float J(long j11) {
            return this.f5042b.J(j11);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        @Override // androidx.compose.ui.input.pointer.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object N(long r5, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.b(r8)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                goto L3e
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.ResultKt.b(r8)
                r0.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                java.lang.Object r8 = r4.e0(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                if (r8 != r1) goto L3e
                return r1
            L3d:
                r8 = 0
            L3e:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.N(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // o0.e
        public long Q(float f11) {
            return this.f5042b.Q(f11);
        }

        @Override // o0.e
        public long Q0(long j11) {
            return this.f5042b.Q0(j11);
        }

        @Override // androidx.compose.ui.input.pointer.c
        public long X() {
            return SuspendingPointerInputModifierNodeImpl.this.X();
        }

        @Override // o0.e
        public int c0(float f11) {
            return this.f5042b.c0(f11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /* JADX WARN: Type inference failed for: r11v0, types: [long] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.t1] */
        /* JADX WARN: Type inference failed for: r11v3, types: [kotlinx.coroutines.t1] */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function2] */
        @Override // androidx.compose.ui.input.pointer.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object e0(long r11, kotlin.jvm.functions.Function2 r13, kotlin.coroutines.Continuation r14) {
            /*
                r10 = this;
                boolean r0 = r14 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                r0.<init>(r10, r14)
            L18:
                java.lang.Object r14 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r11 = r0.L$0
                kotlinx.coroutines.t1 r11 = (kotlinx.coroutines.t1) r11
                kotlin.ResultKt.b(r14)     // Catch: java.lang.Throwable -> L2d
                goto L75
            L2d:
                r12 = move-exception
                goto L7b
            L2f:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L37:
                kotlin.ResultKt.b(r14)
                r4 = 0
                int r14 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r14 > 0) goto L56
                kotlinx.coroutines.n r14 = r10.f5043c
                if (r14 == 0) goto L56
                kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r2 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r2.<init>(r11)
                java.lang.Object r2 = kotlin.ResultKt.a(r2)
                java.lang.Object r2 = kotlin.Result.m1185constructorimpl(r2)
                r14.resumeWith(r2)
            L56:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r14 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
                kotlinx.coroutines.n0 r4 = r14.d1()
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 r7 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1
                r14 = 0
                r7.<init>(r11, r10, r14)
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                kotlinx.coroutines.t1 r11 = kotlinx.coroutines.i.d(r4, r5, r6, r7, r8, r9)
                r0.L$0 = r11     // Catch: java.lang.Throwable -> L2d
                r0.label = r3     // Catch: java.lang.Throwable -> L2d
                java.lang.Object r14 = r13.invoke(r10, r0)     // Catch: java.lang.Throwable -> L2d
                if (r14 != r1) goto L75
                return r1
            L75:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r12 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.INSTANCE
                r11.cancel(r12)
                return r14
            L7b:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r13 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.INSTANCE
                r11.cancel(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.e0(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f5045e;
        }

        @Override // o0.e
        public float getDensity() {
            return this.f5042b.getDensity();
        }

        @Override // androidx.compose.ui.input.pointer.c
        public o2 getViewConfiguration() {
            return SuspendingPointerInputModifierNodeImpl.this.getViewConfiguration();
        }

        @Override // o0.e
        public float h0(long j11) {
            return this.f5042b.h0(j11);
        }

        @Override // androidx.compose.ui.input.pointer.c
        public long k() {
            return SuspendingPointerInputModifierNodeImpl.this.f5040w;
        }

        @Override // androidx.compose.ui.input.pointer.c
        public Object m0(PointerEventPass pointerEventPass, Continuation continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f5044d = pointerEventPass;
            this.f5043c = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return result;
        }

        @Override // androidx.compose.ui.input.pointer.c
        public o n0() {
            return SuspendingPointerInputModifierNodeImpl.this.f5036s;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            androidx.compose.runtime.collection.b bVar = SuspendingPointerInputModifierNodeImpl.this.f5037t;
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (bVar) {
                suspendingPointerInputModifierNodeImpl.f5037t.t(this);
                Unit unit = Unit.f67184a;
            }
            this.f5041a.resumeWith(obj);
        }

        @Override // o0.e
        public float x0(int i11) {
            return this.f5042b.x0(i11);
        }

        @Override // o0.e
        public float y0(float f11) {
            return this.f5042b.y0(f11);
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5047a;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5047a = iArr;
        }
    }

    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, Function2 function2) {
        o oVar;
        this.f5031n = obj;
        this.f5032o = obj2;
        this.f5033p = objArr;
        this.f5034q = function2;
        oVar = l0.f5089a;
        this.f5036s = oVar;
        this.f5037t = new androidx.compose.runtime.collection.b(new PointerEventHandlerCoroutine[16], 0);
        this.f5038u = new androidx.compose.runtime.collection.b(new PointerEventHandlerCoroutine[16], 0);
        this.f5040w = o0.t.f70747b.a();
    }

    private final void G1(o oVar, PointerEventPass pointerEventPass) {
        androidx.compose.runtime.collection.b bVar;
        int n11;
        synchronized (this.f5037t) {
            androidx.compose.runtime.collection.b bVar2 = this.f5038u;
            bVar2.c(bVar2.n(), this.f5037t);
        }
        try {
            int i11 = a.f5047a[pointerEventPass.ordinal()];
            if (i11 == 1 || i11 == 2) {
                androidx.compose.runtime.collection.b bVar3 = this.f5038u;
                int n12 = bVar3.n();
                if (n12 > 0) {
                    Object[] m11 = bVar3.m();
                    int i12 = 0;
                    do {
                        ((PointerEventHandlerCoroutine) m11[i12]).C(oVar, pointerEventPass);
                        i12++;
                    } while (i12 < n12);
                }
            } else if (i11 == 3 && (n11 = (bVar = this.f5038u).n()) > 0) {
                int i13 = n11 - 1;
                Object[] m12 = bVar.m();
                do {
                    ((PointerEventHandlerCoroutine) m12[i13]).C(oVar, pointerEventPass);
                    i13--;
                } while (i13 >= 0);
            }
        } finally {
            this.f5038u.h();
        }
    }

    @Override // o0.n
    public float C0() {
        return androidx.compose.ui.node.g.m(this).H().C0();
    }

    @Override // o0.e
    public /* synthetic */ float E0(float f11) {
        return o0.d.e(this, f11);
    }

    @Override // o0.n
    public /* synthetic */ long H(float f11) {
        return o0.m.b(this, f11);
    }

    public Function2 H1() {
        return this.f5034q;
    }

    public final void I1(Object obj, Object obj2, Object[] objArr, Function2 function2) {
        boolean z10 = !Intrinsics.c(this.f5031n, obj);
        this.f5031n = obj;
        if (!Intrinsics.c(this.f5032o, obj2)) {
            z10 = true;
        }
        this.f5032o = obj2;
        Object[] objArr2 = this.f5033p;
        if (objArr2 != null && objArr == null) {
            z10 = true;
        }
        if (objArr2 == null && objArr != null) {
            z10 = true;
        }
        boolean z11 = (objArr2 == null || objArr == null || Arrays.equals(objArr, objArr2)) ? z10 : true;
        this.f5033p = objArr;
        if (z11) {
            j0();
        }
        this.f5034q = function2;
    }

    @Override // o0.n
    public /* synthetic */ float J(long j11) {
        return o0.m.a(this, j11);
    }

    @Override // androidx.compose.ui.input.pointer.e0
    public Object K(Function2 function2, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl);
        synchronized (this.f5037t) {
            this.f5037t.b(pointerEventHandlerCoroutine);
            Continuation a11 = ContinuationKt.a(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            Result.Companion companion = Result.INSTANCE;
            a11.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f67184a;
            }

            public final void invoke(Throwable th2) {
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.this.B(th2);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    @Override // androidx.compose.ui.node.e1
    public void M(o oVar, PointerEventPass pointerEventPass, long j11) {
        t1 d11;
        this.f5040w = j11;
        if (pointerEventPass == PointerEventPass.Initial) {
            this.f5036s = oVar;
        }
        if (this.f5035r == null) {
            d11 = kotlinx.coroutines.k.d(d1(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
            this.f5035r = d11;
        }
        G1(oVar, pointerEventPass);
        List b11 = oVar.b();
        int size = b11.size();
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                z10 = true;
                break;
            } else if (!p.d((w) b11.get(i11))) {
                break;
            } else {
                i11++;
            }
        }
        if (z10) {
            oVar = null;
        }
        this.f5039v = oVar;
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean P0() {
        return d1.d(this);
    }

    @Override // o0.e
    public /* synthetic */ long Q(float f11) {
        return o0.d.g(this, f11);
    }

    @Override // o0.e
    public /* synthetic */ long Q0(long j11) {
        return o0.d.f(this, j11);
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean R() {
        return d1.a(this);
    }

    @Override // androidx.compose.ui.node.e1
    public void T0() {
        j0();
    }

    public long X() {
        long Q0 = Q0(getViewConfiguration().d());
        long k11 = k();
        return y.n.a(Math.max(0.0f, y.m.i(Q0) - o0.t.g(k11)) / 2.0f, Math.max(0.0f, y.m.g(Q0) - o0.t.f(k11)) / 2.0f);
    }

    @Override // o0.e
    public /* synthetic */ int c0(float f11) {
        return o0.d.a(this, f11);
    }

    @Override // o0.e
    public float getDensity() {
        return androidx.compose.ui.node.g.m(this).H().getDensity();
    }

    public o2 getViewConfiguration() {
        return androidx.compose.ui.node.g.m(this).l0();
    }

    @Override // o0.e
    public /* synthetic */ float h0(long j11) {
        return o0.d.d(this, j11);
    }

    @Override // androidx.compose.ui.input.pointer.n0
    public void j0() {
        t1 t1Var = this.f5035r;
        if (t1Var != null) {
            t1Var.cancel(new PointerInputResetException());
            this.f5035r = null;
        }
    }

    public long k() {
        return this.f5040w;
    }

    @Override // androidx.compose.ui.f.c
    public void o1() {
        j0();
        super.o1();
    }

    @Override // androidx.compose.ui.node.e1
    public void t0() {
        o oVar = this.f5039v;
        if (oVar == null) {
            return;
        }
        List b11 = oVar.b();
        int size = b11.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((w) b11.get(i11)).i()) {
                List b12 = oVar.b();
                ArrayList arrayList = new ArrayList(b12.size());
                int size2 = b12.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    w wVar = (w) b12.get(i12);
                    arrayList.add(new w(wVar.f(), wVar.o(), wVar.h(), false, wVar.j(), wVar.o(), wVar.h(), wVar.i(), wVar.i(), 0, 0L, 1536, (DefaultConstructorMarker) null));
                }
                o oVar2 = new o(arrayList);
                this.f5036s = oVar2;
                G1(oVar2, PointerEventPass.Initial);
                G1(oVar2, PointerEventPass.Main);
                G1(oVar2, PointerEventPass.Final);
                this.f5039v = null;
                return;
            }
        }
    }

    @Override // o0.e
    public /* synthetic */ float x0(int i11) {
        return o0.d.c(this, i11);
    }

    @Override // o0.e
    public /* synthetic */ float y0(float f11) {
        return o0.d.b(this, f11);
    }

    @Override // androidx.compose.ui.node.e1
    public void z0() {
        j0();
    }
}
