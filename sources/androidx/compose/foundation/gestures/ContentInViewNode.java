package androidx.compose.foundation.gestures;

import androidx.compose.ui.f;
import androidx.compose.ui.node.v;
import androidx.compose.ui.node.w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import o0.t;
import o0.u;

/* loaded from: classes.dex */
public final class ContentInViewNode extends f.c implements androidx.compose.foundation.relocation.d, w, androidx.compose.ui.node.d {

    /* renamed from: n, reason: collision with root package name */
    private Orientation f2710n;

    /* renamed from: o, reason: collision with root package name */
    private final ScrollingLogic f2711o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f2712p;

    /* renamed from: q, reason: collision with root package name */
    private d f2713q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f2714r;

    /* renamed from: t, reason: collision with root package name */
    private androidx.compose.ui.layout.l f2716t;

    /* renamed from: u, reason: collision with root package name */
    private y.i f2717u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f2718v;

    /* renamed from: x, reason: collision with root package name */
    private boolean f2720x;

    /* renamed from: s, reason: collision with root package name */
    private final BringIntoViewRequestPriorityQueue f2715s = new BringIntoViewRequestPriorityQueue();

    /* renamed from: w, reason: collision with root package name */
    private long f2719w = t.f70747b.a();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Function0 f2721a;

        /* renamed from: b, reason: collision with root package name */
        private final kotlinx.coroutines.n f2722b;

        public a(Function0 function0, kotlinx.coroutines.n nVar) {
            this.f2721a = function0;
            this.f2722b = nVar;
        }

        public final kotlinx.coroutines.n a() {
            return this.f2722b;
        }

        public final Function0 b() {
            return this.f2721a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x004e, code lost:
        
            if (r0 == null) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r4 = this;
                kotlinx.coroutines.n r0 = r4.f2722b
                kotlin.coroutines.CoroutineContext r0 = r0.getContext()
                kotlinx.coroutines.m0$a r1 = kotlinx.coroutines.m0.f68022b
                kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
                kotlinx.coroutines.m0 r0 = (kotlinx.coroutines.m0) r0
                if (r0 == 0) goto L15
                java.lang.String r0 = r0.d()
                goto L16
            L15:
                r0 = 0
            L16:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Request@"
                r1.append(r2)
                int r2 = r4.hashCode()
                r3 = 16
                int r3 = kotlin.text.CharsKt.a(r3)
                java.lang.String r2 = java.lang.Integer.toString(r2, r3)
                java.lang.String r3 = "toString(this, checkRadix(radix))"
                kotlin.jvm.internal.Intrinsics.g(r2, r3)
                r1.append(r2)
                if (r0 == 0) goto L50
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r3 = 91
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = "]("
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                if (r0 != 0) goto L52
            L50:
                java.lang.String r0 = "("
            L52:
                r1.append(r0)
                java.lang.String r0 = "currentBounds()="
                r1.append(r0)
                kotlin.jvm.functions.Function0 r0 = r4.f2721a
                java.lang.Object r0 = r0.invoke()
                r1.append(r0)
                java.lang.String r0 = ", continuation="
                r1.append(r0)
                kotlinx.coroutines.n r0 = r4.f2722b
                r1.append(r0)
                r0 = 41
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewNode.a.toString():java.lang.String");
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2723a;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f2723a = iArr;
        }
    }

    public ContentInViewNode(Orientation orientation, ScrollingLogic scrollingLogic, boolean z10, d dVar) {
        this.f2710n = orientation;
        this.f2711o = scrollingLogic;
        this.f2712p = z10;
        this.f2713q = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float N1(d dVar) {
        if (t.e(this.f2719w, t.f70747b.a())) {
            return 0.0f;
        }
        y.i R1 = R1();
        if (R1 == null) {
            R1 = this.f2718v ? S1() : null;
            if (R1 == null) {
                return 0.0f;
            }
        }
        long d11 = u.d(this.f2719w);
        int i11 = b.f2723a[this.f2710n.ordinal()];
        if (i11 == 1) {
            return dVar.a(R1.i(), R1.c() - R1.i(), y.m.g(d11));
        }
        if (i11 == 2) {
            return dVar.a(R1.f(), R1.g() - R1.f(), y.m.i(d11));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int O1(long j11, long j12) {
        int i11 = b.f2723a[this.f2710n.ordinal()];
        if (i11 == 1) {
            return Intrinsics.j(t.f(j11), t.f(j12));
        }
        if (i11 == 2) {
            return Intrinsics.j(t.g(j11), t.g(j12));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int P1(long j11, long j12) {
        int i11 = b.f2723a[this.f2710n.ordinal()];
        if (i11 == 1) {
            return Float.compare(y.m.g(j11), y.m.g(j12));
        }
        if (i11 == 2) {
            return Float.compare(y.m.i(j11), y.m.i(j12));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final y.i Q1(y.i iVar, long j11) {
        return iVar.q(y.g.u(Y1(iVar, j11)));
    }

    private final y.i R1() {
        androidx.compose.runtime.collection.b bVar;
        bVar = this.f2715s.f2704a;
        int n11 = bVar.n();
        y.i iVar = null;
        if (n11 > 0) {
            int i11 = n11 - 1;
            Object[] m11 = bVar.m();
            do {
                y.i iVar2 = (y.i) ((a) m11[i11]).b().invoke();
                if (iVar2 != null) {
                    if (P1(iVar2.h(), u.d(this.f2719w)) > 0) {
                        return iVar == null ? iVar2 : iVar;
                    }
                    iVar = iVar2;
                }
                i11--;
            } while (i11 >= 0);
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y.i S1() {
        if (!k1()) {
            return null;
        }
        androidx.compose.ui.layout.l k11 = androidx.compose.ui.node.g.k(this);
        androidx.compose.ui.layout.l lVar = this.f2716t;
        if (lVar != null) {
            if (!lVar.F()) {
                lVar = null;
            }
            if (lVar != null) {
                return k11.O(lVar, false);
            }
        }
        return null;
    }

    private final boolean U1(y.i iVar, long j11) {
        long Y1 = Y1(iVar, j11);
        return Math.abs(y.g.m(Y1)) <= 0.5f && Math.abs(y.g.n(Y1)) <= 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean V1(ContentInViewNode contentInViewNode, y.i iVar, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = contentInViewNode.f2719w;
        }
        return contentInViewNode.U1(iVar, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1() {
        d Z1 = Z1();
        if (this.f2720x) {
            throw new IllegalStateException("launchAnimation called when previous animation was running");
        }
        kotlinx.coroutines.k.d(d1(), null, CoroutineStart.UNDISPATCHED, new ContentInViewNode$launchAnimation$2(this, new UpdatableAnimationState(Z1.b()), Z1, null), 1, null);
    }

    private final long Y1(y.i iVar, long j11) {
        long d11 = u.d(j11);
        int i11 = b.f2723a[this.f2710n.ordinal()];
        if (i11 == 1) {
            return y.h.a(0.0f, Z1().a(iVar.i(), iVar.c() - iVar.i(), y.m.g(d11)));
        }
        if (i11 == 2) {
            return y.h.a(Z1().a(iVar.f(), iVar.g() - iVar.f(), y.m.i(d11)), 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final d Z1() {
        d dVar = this.f2713q;
        return dVar == null ? (d) androidx.compose.ui.node.e.a(this, BringIntoViewSpec_androidKt.a()) : dVar;
    }

    @Override // androidx.compose.ui.node.w
    public void F(long j11) {
        y.i S1;
        long j12 = this.f2719w;
        this.f2719w = j11;
        if (O1(j11, j12) < 0 && (S1 = S1()) != null) {
            y.i iVar = this.f2717u;
            if (iVar == null) {
                iVar = S1;
            }
            if (!this.f2720x && !this.f2718v && U1(iVar, j12) && !U1(S1, j11)) {
                this.f2718v = true;
                W1();
            }
            this.f2717u = S1;
        }
    }

    @Override // androidx.compose.foundation.relocation.d
    public Object F0(Function0 function0, Continuation continuation) {
        y.i iVar = (y.i) function0.invoke();
        if (iVar == null || V1(this, iVar, 0L, 1, null)) {
            return Unit.f67184a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (this.f2715s.c(new a(function0, cancellableContinuationImpl)) && !this.f2720x) {
            W1();
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result == IntrinsicsKt.f() ? result : Unit.f67184a;
    }

    @Override // androidx.compose.ui.node.w
    public /* synthetic */ void I(androidx.compose.ui.layout.l lVar) {
        v.a(this, lVar);
    }

    public final long T1() {
        return this.f2719w;
    }

    public final void X1(androidx.compose.ui.layout.l lVar) {
        this.f2716t = lVar;
    }

    @Override // androidx.compose.foundation.relocation.d
    public y.i Y(y.i iVar) {
        if (t.e(this.f2719w, t.f70747b.a())) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
        }
        return Q1(iVar, this.f2719w);
    }

    public final void a2(Orientation orientation, boolean z10, d dVar) {
        this.f2710n = orientation;
        this.f2712p = z10;
        this.f2713q = dVar;
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return this.f2714r;
    }
}
