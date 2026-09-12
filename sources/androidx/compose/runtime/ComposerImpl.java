package androidx.compose.runtime;

import androidx.compose.runtime.n1;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
public final class ComposerImpl implements i {
    private int B;
    private int C;
    private boolean D;
    private final c E;
    private final z2 F;
    private boolean G;
    private boolean H;
    private i2 I;
    private j2 J;
    private m2 K;
    private boolean L;
    private n1 M;
    private s.a N;
    private final s.b O;
    private androidx.compose.runtime.c P;
    private s.c Q;
    private boolean R;
    private int S;

    /* renamed from: b, reason: collision with root package name */
    private final f f3637b;

    /* renamed from: c, reason: collision with root package name */
    private final m f3638c;

    /* renamed from: d, reason: collision with root package name */
    private final j2 f3639d;

    /* renamed from: e, reason: collision with root package name */
    private final Set f3640e;

    /* renamed from: f, reason: collision with root package name */
    private s.a f3641f;

    /* renamed from: g, reason: collision with root package name */
    private s.a f3642g;

    /* renamed from: h, reason: collision with root package name */
    private final y f3643h;

    /* renamed from: j, reason: collision with root package name */
    private Pending f3645j;

    /* renamed from: k, reason: collision with root package name */
    private int f3646k;

    /* renamed from: l, reason: collision with root package name */
    private int f3647l;

    /* renamed from: m, reason: collision with root package name */
    private int f3648m;

    /* renamed from: o, reason: collision with root package name */
    private int[] f3650o;

    /* renamed from: p, reason: collision with root package name */
    private androidx.collection.c0 f3651p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3652q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f3653r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f3654s;

    /* renamed from: w, reason: collision with root package name */
    private androidx.compose.runtime.collection.a f3658w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f3659x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3661z;

    /* renamed from: i, reason: collision with root package name */
    private final z2 f3644i = new z2();

    /* renamed from: n, reason: collision with root package name */
    private final m0 f3649n = new m0();

    /* renamed from: t, reason: collision with root package name */
    private final List f3655t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    private final m0 f3656u = new m0();

    /* renamed from: v, reason: collision with root package name */
    private n1 f3657v = androidx.compose.runtime.internal.e.a();

    /* renamed from: y, reason: collision with root package name */
    private final m0 f3660y = new m0();
    private int A = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements e2 {

        /* renamed from: a, reason: collision with root package name */
        private final b f3662a;

        public a(b bVar) {
            this.f3662a = bVar;
        }

        public final b a() {
            return this.f3662a;
        }

        @Override // androidx.compose.runtime.b2
        public void onAbandoned() {
            this.f3662a.s();
        }

        @Override // androidx.compose.runtime.b2
        public void onForgotten() {
            this.f3662a.s();
        }

        @Override // androidx.compose.runtime.b2
        public void onRemembered() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b extends m {

        /* renamed from: a, reason: collision with root package name */
        private final int f3663a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f3664b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f3665c;

        /* renamed from: d, reason: collision with root package name */
        private final u f3666d;

        /* renamed from: e, reason: collision with root package name */
        private Set f3667e;

        /* renamed from: f, reason: collision with root package name */
        private final Set f3668f = new LinkedHashSet();

        /* renamed from: g, reason: collision with root package name */
        private final i1 f3669g = r2.e(androidx.compose.runtime.internal.e.a(), r2.h());

        public b(int i11, boolean z10, boolean z11, u uVar) {
            this.f3663a = i11;
            this.f3664b = z10;
            this.f3665c = z11;
            this.f3666d = uVar;
        }

        private final n1 u() {
            return (n1) this.f3669g.getValue();
        }

        private final void v(n1 n1Var) {
            this.f3669g.setValue(n1Var);
        }

        @Override // androidx.compose.runtime.m
        public void a(y yVar, Function2 function2) {
            ComposerImpl.this.f3638c.a(yVar, function2);
        }

        @Override // androidx.compose.runtime.m
        public void b() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.B--;
        }

        @Override // androidx.compose.runtime.m
        public boolean c() {
            return ComposerImpl.this.f3638c.c();
        }

        @Override // androidx.compose.runtime.m
        public boolean d() {
            return this.f3664b;
        }

        @Override // androidx.compose.runtime.m
        public boolean e() {
            return this.f3665c;
        }

        @Override // androidx.compose.runtime.m
        public n1 f() {
            return u();
        }

        @Override // androidx.compose.runtime.m
        public int g() {
            return this.f3663a;
        }

        @Override // androidx.compose.runtime.m
        public CoroutineContext h() {
            return ComposerImpl.this.f3638c.h();
        }

        @Override // androidx.compose.runtime.m
        public u i() {
            return this.f3666d;
        }

        @Override // androidx.compose.runtime.m
        public void j(y0 y0Var) {
            ComposerImpl.this.f3638c.j(y0Var);
        }

        @Override // androidx.compose.runtime.m
        public void k(y yVar) {
            ComposerImpl.this.f3638c.k(ComposerImpl.this.A0());
            ComposerImpl.this.f3638c.k(yVar);
        }

        @Override // androidx.compose.runtime.m
        public x0 l(y0 y0Var) {
            return ComposerImpl.this.f3638c.l(y0Var);
        }

        @Override // androidx.compose.runtime.m
        public void m(Set set) {
            Set set2 = this.f3667e;
            if (set2 == null) {
                set2 = new HashSet();
                this.f3667e = set2;
            }
            set2.add(set);
        }

        @Override // androidx.compose.runtime.m
        public void n(i iVar) {
            Intrinsics.f(iVar, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.n((ComposerImpl) iVar);
            this.f3668f.add(iVar);
        }

        @Override // androidx.compose.runtime.m
        public void o(y yVar) {
            ComposerImpl.this.f3638c.o(yVar);
        }

        @Override // androidx.compose.runtime.m
        public void p() {
            ComposerImpl.this.B++;
        }

        @Override // androidx.compose.runtime.m
        public void q(i iVar) {
            Set<Set> set = this.f3667e;
            if (set != null) {
                for (Set set2 : set) {
                    Intrinsics.f(iVar, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    set2.remove(((ComposerImpl) iVar).f3639d);
                }
            }
            TypeIntrinsics.a(this.f3668f).remove(iVar);
        }

        @Override // androidx.compose.runtime.m
        public void r(y yVar) {
            ComposerImpl.this.f3638c.r(yVar);
        }

        public final void s() {
            if (this.f3668f.isEmpty()) {
                return;
            }
            Set set = this.f3667e;
            if (set != null) {
                for (ComposerImpl composerImpl : this.f3668f) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        ((Set) it.next()).remove(composerImpl.f3639d);
                    }
                }
            }
            this.f3668f.clear();
        }

        public final Set t() {
            return this.f3668f;
        }

        public final void w(n1 n1Var) {
            v(n1Var);
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements a0 {
        c() {
        }

        @Override // androidx.compose.runtime.a0
        public void a(z zVar) {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.B--;
        }

        @Override // androidx.compose.runtime.a0
        public void b(z zVar) {
            ComposerImpl.this.B++;
        }
    }

    public ComposerImpl(f fVar, m mVar, j2 j2Var, Set set, s.a aVar, s.a aVar2, y yVar) {
        this.f3637b = fVar;
        this.f3638c = mVar;
        this.f3639d = j2Var;
        this.f3640e = set;
        this.f3641f = aVar;
        this.f3642g = aVar2;
        this.f3643h = yVar;
        this.D = mVar.e() || mVar.c();
        this.E = new c();
        this.F = new z2();
        i2 w11 = j2Var.w();
        w11.d();
        this.I = w11;
        j2 j2Var2 = new j2();
        if (mVar.e()) {
            j2Var2.j();
        }
        if (mVar.c()) {
            j2Var2.h();
        }
        this.J = j2Var2;
        m2 x10 = j2Var2.x();
        x10.L(true);
        this.K = x10;
        this.O = new s.b(this, this.f3641f);
        i2 w12 = this.J.w();
        try {
            androidx.compose.runtime.c a11 = w12.a(0);
            w12.d();
            this.P = a11;
            this.Q = new s.c();
        } catch (Throwable th2) {
            w12.d();
            throw th2;
        }
    }

    private final Object D0(i2 i2Var) {
        return i2Var.L(i2Var.u());
    }

    private final int F0(i2 i2Var, int i11) {
        Object z10;
        if (i2Var.G(i11)) {
            Object D = i2Var.D(i11);
            if (D != null) {
                return D instanceof Enum ? ((Enum) D).ordinal() : D.hashCode();
            }
            return 0;
        }
        int C = i2Var.C(i11);
        if (C == 207 && (z10 = i2Var.z(i11)) != null && !Intrinsics.c(z10, i.f3811a.a())) {
            C = z10.hashCode();
        }
        return C;
    }

    private final void G0(List list) {
        s.b bVar;
        s.a aVar;
        s.b bVar2;
        s.a aVar2;
        List p11;
        i2 i2Var;
        i2 E0;
        int[] iArr;
        androidx.compose.runtime.collection.a aVar3;
        s.a aVar4;
        s.b bVar3;
        int i11;
        int i12;
        i2 i2Var2;
        int i13 = 1;
        s.b bVar4 = this.O;
        s.a aVar5 = this.f3642g;
        s.a n11 = bVar4.n();
        try {
            bVar4.R(aVar5);
            this.O.P();
            int size = list.size();
            int i14 = 0;
            int i15 = 0;
            while (i15 < size) {
                try {
                    Pair pair = (Pair) list.get(i15);
                    final y0 y0Var = (y0) pair.component1();
                    y0 y0Var2 = (y0) pair.component2();
                    androidx.compose.runtime.c a11 = y0Var.a();
                    int c11 = y0Var.g().c(a11);
                    androidx.compose.runtime.internal.c cVar = new androidx.compose.runtime.internal.c(i14, i13, null);
                    this.O.e(cVar, a11);
                    if (y0Var2 == null) {
                        if (Intrinsics.c(y0Var.g(), this.J)) {
                            i0();
                        }
                        final i2 w11 = y0Var.g().w();
                        try {
                            w11.Q(c11);
                            this.O.y(c11);
                            final s.a aVar6 = new s.a();
                            i2Var2 = w11;
                            try {
                                T0(this, null, null, null, null, new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m81invoke();
                                        return Unit.f67184a;
                                    }

                                    /* renamed from: invoke, reason: collision with other method in class */
                                    public final void m81invoke() {
                                        s.b bVar5;
                                        s.b bVar6;
                                        bVar5 = ComposerImpl.this.O;
                                        s.a aVar7 = aVar6;
                                        ComposerImpl composerImpl = ComposerImpl.this;
                                        i2 i2Var3 = w11;
                                        y0 y0Var3 = y0Var;
                                        s.a n12 = bVar5.n();
                                        try {
                                            bVar5.R(aVar7);
                                            i2 E02 = composerImpl.E0();
                                            int[] iArr2 = composerImpl.f3650o;
                                            androidx.compose.runtime.collection.a aVar8 = composerImpl.f3658w;
                                            composerImpl.f3650o = null;
                                            composerImpl.f3658w = null;
                                            try {
                                                composerImpl.d1(i2Var3);
                                                bVar6 = composerImpl.O;
                                                boolean o11 = bVar6.o();
                                                try {
                                                    bVar6.S(false);
                                                    y0Var3.c();
                                                    composerImpl.J0(null, y0Var3.e(), y0Var3.f(), true);
                                                    bVar6.S(o11);
                                                    Unit unit = Unit.f67184a;
                                                } catch (Throwable th2) {
                                                    bVar6.S(o11);
                                                    throw th2;
                                                }
                                            } finally {
                                                composerImpl.d1(E02);
                                                composerImpl.f3650o = iArr2;
                                                composerImpl.f3658w = aVar8;
                                            }
                                        } finally {
                                            bVar5.R(n12);
                                        }
                                    }
                                }, 15, null);
                                this.O.r(aVar6, cVar);
                                Unit unit = Unit.f67184a;
                                i2Var2.d();
                                bVar2 = bVar4;
                                aVar2 = n11;
                                i11 = size;
                                i12 = i15;
                            } catch (Throwable th2) {
                                th = th2;
                                i2Var2.d();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i2Var2 = w11;
                        }
                    } else {
                        x0 l11 = this.f3638c.l(y0Var2);
                        j2 g11 = y0Var2.g();
                        androidx.compose.runtime.c a12 = y0Var2.a();
                        p11 = k.p(g11, a12);
                        if (!p11.isEmpty()) {
                            this.O.b(p11, cVar);
                            if (Intrinsics.c(y0Var.g(), this.f3639d)) {
                                int c12 = this.f3639d.c(a11);
                                q1(c12, v1(c12) + p11.size());
                            }
                        }
                        this.O.c(l11, this.f3638c, y0Var2, y0Var);
                        i2 w12 = g11.w();
                        try {
                            E0 = E0();
                            int[] iArr2 = this.f3650o;
                            androidx.compose.runtime.collection.a aVar7 = this.f3658w;
                            this.f3650o = null;
                            this.f3658w = null;
                            try {
                                d1(w12);
                                int c13 = g11.c(a12);
                                w12.Q(c13);
                                this.O.y(c13);
                                s.a aVar8 = new s.a();
                                s.b bVar5 = this.O;
                                s.a n12 = bVar5.n();
                                try {
                                    bVar5.R(aVar8);
                                    i11 = size;
                                    s.b bVar6 = this.O;
                                    boolean o11 = bVar6.o();
                                    try {
                                        bVar6.S(false);
                                        y b11 = y0Var2.b();
                                        y b12 = y0Var.b();
                                        Integer valueOf = Integer.valueOf(w12.k());
                                        bVar2 = bVar4;
                                        aVar3 = aVar7;
                                        aVar2 = n11;
                                        aVar4 = n12;
                                        i12 = i15;
                                        iArr = iArr2;
                                        i2Var = w12;
                                        bVar3 = bVar5;
                                        try {
                                            S0(b11, b12, valueOf, y0Var2.d(), new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Object invoke() {
                                                    m82invoke();
                                                    return Unit.f67184a;
                                                }

                                                /* renamed from: invoke, reason: collision with other method in class */
                                                public final void m82invoke() {
                                                    ComposerImpl composerImpl = ComposerImpl.this;
                                                    y0Var.c();
                                                    composerImpl.J0(null, y0Var.e(), y0Var.f(), true);
                                                }
                                            });
                                            try {
                                                bVar6.S(o11);
                                                try {
                                                    bVar3.R(aVar4);
                                                    this.O.r(aVar8, cVar);
                                                    Unit unit2 = Unit.f67184a;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    d1(E0);
                                                    this.f3650o = iArr;
                                                    this.f3658w = aVar3;
                                                    throw th;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                bVar3.R(aVar4);
                                                throw th;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            bVar6.S(o11);
                                            throw th;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        iArr = iArr2;
                                        i2Var = w12;
                                        aVar3 = aVar7;
                                        bVar3 = bVar5;
                                        aVar4 = n12;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    iArr = iArr2;
                                    i2Var = w12;
                                    aVar3 = aVar7;
                                    aVar4 = n12;
                                    bVar3 = bVar5;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                iArr = iArr2;
                                i2Var = w12;
                                aVar3 = aVar7;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            i2Var = w12;
                        }
                        try {
                            d1(E0);
                            this.f3650o = iArr;
                            this.f3658w = aVar3;
                            try {
                                i2Var.d();
                            } catch (Throwable th11) {
                                th = th11;
                                aVar = aVar2;
                                bVar = bVar2;
                                bVar.R(aVar);
                                throw th;
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            i2Var.d();
                            throw th;
                        }
                    }
                    this.O.U();
                    i13 = 1;
                    i15 = i12 + 1;
                    size = i11;
                    n11 = aVar2;
                    bVar4 = bVar2;
                    i14 = 0;
                } catch (Throwable th13) {
                    th = th13;
                    bVar2 = bVar4;
                    aVar2 = n11;
                }
            }
            s.b bVar7 = bVar4;
            s.a aVar9 = n11;
            this.O.h();
            this.O.y(0);
            bVar7.R(aVar9);
        } catch (Throwable th14) {
            th = th14;
            bVar = bVar4;
            aVar = n11;
        }
    }

    private final int I0(int i11) {
        return (-2) - i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0037, code lost:
    
        X0(r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J0(final androidx.compose.runtime.w0 r12, androidx.compose.runtime.n1 r13, final java.lang.Object r14, boolean r15) {
        /*
            r11 = this;
            r0 = 126665345(0x78cc281, float:2.1179178E-34)
            r11.k1(r0, r12)
            r11.t1(r14)
            int r1 = r11.L()
            r2 = 0
            r11.S = r0     // Catch: java.lang.Throwable -> L1e
            boolean r0 = r11.e()     // Catch: java.lang.Throwable -> L1e
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L21
            androidx.compose.runtime.m2 r0 = r11.K     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.m2.t0(r0, r3, r4, r2)     // Catch: java.lang.Throwable -> L1e
            goto L21
        L1e:
            r12 = move-exception
            goto L9f
        L21:
            boolean r0 = r11.e()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L28
            goto L35
        L28:
            androidx.compose.runtime.i2 r0 = r11.I     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r0 = r0.l()     // Catch: java.lang.Throwable -> L1e
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r13)     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L35
            r3 = r4
        L35:
            if (r3 == 0) goto L3a
            r11.X0(r13)     // Catch: java.lang.Throwable -> L1e
        L3a:
            java.lang.Object r0 = androidx.compose.runtime.k.y()     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.k0$a r5 = androidx.compose.runtime.k0.f3868a     // Catch: java.lang.Throwable -> L1e
            int r5 = r5.a()     // Catch: java.lang.Throwable -> L1e
            r6 = 202(0xca, float:2.83E-43)
            r11.h1(r6, r0, r5, r13)     // Catch: java.lang.Throwable -> L1e
            r11.M = r2     // Catch: java.lang.Throwable -> L1e
            boolean r13 = r11.e()     // Catch: java.lang.Throwable -> L1e
            if (r13 == 0) goto L7f
            if (r15 != 0) goto L7f
            r11.L = r4     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.m2 r13 = r11.K     // Catch: java.lang.Throwable -> L1e
            int r15 = r13.c0()     // Catch: java.lang.Throwable -> L1e
            int r15 = r13.E0(r15)     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.c r8 = r13.E(r15)     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.y0 r13 = new androidx.compose.runtime.y0     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.y r6 = r11.A0()     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.j2 r7 = r11.J     // Catch: java.lang.Throwable -> L1e
            java.util.List r9 = kotlin.collections.CollectionsKt.l()     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.n1 r10 = r11.j0()     // Catch: java.lang.Throwable -> L1e
            r3 = r13
            r4 = r12
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.m r12 = r11.f3638c     // Catch: java.lang.Throwable -> L1e
            r12.j(r13)     // Catch: java.lang.Throwable -> L1e
            goto L94
        L7f:
            boolean r13 = r11.f3659x     // Catch: java.lang.Throwable -> L1e
            r11.f3659x = r3     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1 r15 = new androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1     // Catch: java.lang.Throwable -> L1e
            r15.<init>(r12, r14)     // Catch: java.lang.Throwable -> L1e
            r12 = 316014703(0x12d6006f, float:1.3505406E-27)
            androidx.compose.runtime.internal.a r12 = androidx.compose.runtime.internal.b.b(r12, r4, r15)     // Catch: java.lang.Throwable -> L1e
            androidx.compose.runtime.b.d(r11, r12)     // Catch: java.lang.Throwable -> L1e
            r11.f3659x = r13     // Catch: java.lang.Throwable -> L1e
        L94:
            r11.q0()
            r11.M = r2
            r11.S = r1
            r11.r0()
            return
        L9f:
            r11.q0()
            r11.M = r2
            r11.S = r1
            r11.r0()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.J0(androidx.compose.runtime.w0, androidx.compose.runtime.n1, java.lang.Object, boolean):void");
    }

    private final Object N0(i2 i2Var, int i11) {
        return i2Var.L(i11);
    }

    private final int O0(int i11, int i12, int i13, int i14) {
        int P = this.I.P(i12);
        while (P != i13 && !this.I.J(P)) {
            P = this.I.P(P);
        }
        if (this.I.J(P)) {
            i14 = 0;
        }
        if (P == i12) {
            return i14;
        }
        int v12 = (v1(P) - this.I.N(i12)) + i14;
        loop1: while (i14 < v12 && P != i11) {
            P++;
            while (P < i11) {
                int E = this.I.E(P) + P;
                if (i11 >= E) {
                    i14 += this.I.J(P) ? 1 : v1(P);
                    P = E;
                }
            }
            break loop1;
        }
        return i14;
    }

    private final int Q0(int i11) {
        int P = this.I.P(i11) + 1;
        int i12 = 0;
        while (P < i11) {
            if (!this.I.G(P)) {
                i12++;
            }
            P += this.I.E(P);
        }
        return i12;
    }

    private final void R() {
        e0();
        this.f3644i.a();
        this.f3649n.a();
        this.f3656u.a();
        this.f3660y.a();
        this.f3658w = null;
        this.Q.a();
        this.S = 0;
        this.B = 0;
        this.f3654s = false;
        this.R = false;
        this.f3661z = false;
        this.G = false;
        this.f3653r = false;
        this.A = -1;
        if (!this.I.i()) {
            this.I.d();
        }
        if (this.K.Z()) {
            return;
        }
        y0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (r7 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object S0(androidx.compose.runtime.y r7, androidx.compose.runtime.y r8, java.lang.Integer r9, java.util.List r10, kotlin.jvm.functions.Function0 r11) {
        /*
            r6 = this;
            boolean r0 = r6.G
            int r1 = r6.f3646k
            r2 = 1
            r6.G = r2     // Catch: java.lang.Throwable -> L26
            r2 = 0
            r6.f3646k = r2     // Catch: java.lang.Throwable -> L26
            int r3 = r10.size()     // Catch: java.lang.Throwable -> L26
        Le:
            if (r2 >= r3) goto L2f
            java.lang.Object r4 = r10.get(r2)     // Catch: java.lang.Throwable -> L26
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch: java.lang.Throwable -> L26
            java.lang.Object r5 = r4.component1()     // Catch: java.lang.Throwable -> L26
            androidx.compose.runtime.RecomposeScopeImpl r5 = (androidx.compose.runtime.RecomposeScopeImpl) r5     // Catch: java.lang.Throwable -> L26
            java.lang.Object r4 = r4.component2()     // Catch: java.lang.Throwable -> L26
            if (r4 == 0) goto L28
            r6.o1(r5, r4)     // Catch: java.lang.Throwable -> L26
            goto L2c
        L26:
            r7 = move-exception
            goto L48
        L28:
            r4 = 0
            r6.o1(r5, r4)     // Catch: java.lang.Throwable -> L26
        L2c:
            int r2 = r2 + 1
            goto Le
        L2f:
            if (r7 == 0) goto L3f
            if (r9 == 0) goto L38
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L26
            goto L39
        L38:
            r9 = -1
        L39:
            java.lang.Object r7 = r7.g(r8, r9, r11)     // Catch: java.lang.Throwable -> L26
            if (r7 != 0) goto L43
        L3f:
            java.lang.Object r7 = r11.invoke()     // Catch: java.lang.Throwable -> L26
        L43:
            r6.G = r0
            r6.f3646k = r1
            return r7
        L48:
            r6.G = r0
            r6.f3646k = r1
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.S0(androidx.compose.runtime.y, androidx.compose.runtime.y, java.lang.Integer, java.util.List, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    static /* synthetic */ Object T0(ComposerImpl composerImpl, y yVar, y yVar2, Integer num, List list, Function0 function0, int i11, Object obj) {
        y yVar3 = (i11 & 1) != 0 ? null : yVar;
        y yVar4 = (i11 & 2) != 0 ? null : yVar2;
        Integer num2 = (i11 & 4) != 0 ? null : num;
        if ((i11 & 8) != 0) {
            list = CollectionsKt.l();
        }
        return composerImpl.S0(yVar3, yVar4, num2, list, function0);
    }

    private final void U0() {
        o0 x10;
        boolean z10 = this.G;
        this.G = true;
        int u11 = this.I.u();
        int E = this.I.E(u11) + u11;
        int i11 = this.f3646k;
        int L = L();
        int i12 = this.f3647l;
        int i13 = this.f3648m;
        x10 = k.x(this.f3655t, this.I.k(), E);
        boolean z11 = false;
        int i14 = u11;
        while (x10 != null) {
            int b11 = x10.b();
            k.M(this.f3655t, b11);
            if (x10.d()) {
                this.I.Q(b11);
                int k11 = this.I.k();
                Y0(i14, k11, u11);
                this.f3646k = O0(b11, k11, u11, i11);
                this.f3648m = Q0(k11);
                int P = this.I.P(k11);
                this.S = h0(P, Q0(P), u11, L);
                this.M = null;
                x10.c().g(this);
                this.M = null;
                this.I.R(u11);
                i14 = k11;
                z11 = true;
            } else {
                this.F.h(x10.c());
                x10.c().y();
                this.F.g();
            }
            x10 = k.x(this.f3655t, this.I.k(), E);
        }
        if (z11) {
            Y0(i14, u11, u11);
            this.I.T();
            int v12 = v1(u11);
            this.f3646k = i11 + v12;
            this.f3647l = i12 + v12;
            this.f3648m = i13;
        } else {
            g1();
        }
        this.S = L;
        this.G = z10;
    }

    private final void V0() {
        b1(this.I.k());
        this.O.N();
    }

    private final void W0(androidx.compose.runtime.c cVar) {
        if (this.Q.e()) {
            this.O.s(cVar, this.J);
        } else {
            this.O.t(cVar, this.J, this.Q);
            this.Q = new s.c();
        }
    }

    private final void X0(n1 n1Var) {
        androidx.compose.runtime.collection.a aVar = this.f3658w;
        if (aVar == null) {
            aVar = new androidx.compose.runtime.collection.a(0, 1, null);
            this.f3658w = aVar;
        }
        aVar.b(this.I.k(), n1Var);
    }

    private final void Y0(int i11, int i12, int i13) {
        int J;
        i2 i2Var = this.I;
        J = k.J(i2Var, i11, i12, i13);
        while (i11 > 0 && i11 != J) {
            if (i2Var.J(i11)) {
                this.O.z();
            }
            i11 = i2Var.P(i11);
        }
        o0(i12, J);
    }

    private final androidx.compose.runtime.c Z0() {
        int i11;
        int i12;
        if (e()) {
            if (!k.G(this.K)) {
                return null;
            }
            int a02 = this.K.a0() - 1;
            int E0 = this.K.E0(a02);
            while (true) {
                int i13 = E0;
                i12 = a02;
                a02 = i13;
                if (a02 == this.K.c0() || a02 < 0) {
                    break;
                }
                E0 = this.K.E0(a02);
            }
            return this.K.E(i12);
        }
        if (!k.F(this.I)) {
            return null;
        }
        int k11 = this.I.k() - 1;
        int P = this.I.P(k11);
        while (true) {
            int i14 = P;
            i11 = k11;
            k11 = i14;
            if (k11 == this.I.u() || k11 < 0) {
                break;
            }
            P = this.I.P(k11);
        }
        return this.I.a(i11);
    }

    private final void a1() {
        if (this.f3639d.l()) {
            s.a aVar = new s.a();
            this.N = aVar;
            i2 w11 = this.f3639d.w();
            try {
                this.I = w11;
                s.b bVar = this.O;
                s.a n11 = bVar.n();
                try {
                    bVar.R(aVar);
                    b1(0);
                    this.O.L();
                    bVar.R(n11);
                    Unit unit = Unit.f67184a;
                } catch (Throwable th2) {
                    bVar.R(n11);
                    throw th2;
                }
            } finally {
                w11.d();
            }
        }
    }

    private final void b1(int i11) {
        c1(this, i11, false, 0);
        this.O.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0067, code lost:
    
        if (r0 != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void c0() {
        /*
            r4 = this;
            boolean r0 = r4.e()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl"
            if (r0 == 0) goto L24
            androidx.compose.runtime.RecomposeScopeImpl r0 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.y r2 = r4.A0()
            kotlin.jvm.internal.Intrinsics.f(r2, r1)
            androidx.compose.runtime.o r2 = (androidx.compose.runtime.o) r2
            r0.<init>(r2)
            androidx.compose.runtime.z2 r1 = r4.F
            r1.h(r0)
            r4.u1(r0)
            int r1 = r4.C
            r0.I(r1)
            goto L77
        L24:
            java.util.List r0 = r4.f3655t
            androidx.compose.runtime.i2 r2 = r4.I
            int r2 = r2.u()
            androidx.compose.runtime.o0 r0 = androidx.compose.runtime.k.l(r0, r2)
            androidx.compose.runtime.i2 r2 = r4.I
            java.lang.Object r2 = r2.K()
            androidx.compose.runtime.i$a r3 = androidx.compose.runtime.i.f3811a
            java.lang.Object r3 = r3.a()
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r2, r3)
            if (r3 == 0) goto L54
            androidx.compose.runtime.RecomposeScopeImpl r2 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.y r3 = r4.A0()
            kotlin.jvm.internal.Intrinsics.f(r3, r1)
            androidx.compose.runtime.o r3 = (androidx.compose.runtime.o) r3
            r2.<init>(r3)
            r4.u1(r2)
            goto L5b
        L54:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.Intrinsics.f(r2, r1)
            androidx.compose.runtime.RecomposeScopeImpl r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2
        L5b:
            if (r0 != 0) goto L69
            boolean r0 = r2.m()
            r1 = 0
            if (r0 == 0) goto L67
            r2.D(r1)
        L67:
            if (r0 == 0) goto L6a
        L69:
            r1 = 1
        L6a:
            r2.E(r1)
            androidx.compose.runtime.z2 r0 = r4.F
            r0.h(r2)
            int r0 = r4.C
            r2.I(r0)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.c0():void");
    }

    private static final int c1(ComposerImpl composerImpl, int i11, boolean z10, int i12) {
        i2 i2Var = composerImpl.I;
        if (i2Var.F(i11)) {
            int C = i2Var.C(i11);
            Object D = i2Var.D(i11);
            if (C != 206 || !Intrinsics.c(D, k.D())) {
                if (i2Var.J(i11)) {
                    return 1;
                }
                return i2Var.N(i11);
            }
            Object B = i2Var.B(i11, 0);
            a aVar = B instanceof a ? (a) B : null;
            if (aVar != null) {
                for (ComposerImpl composerImpl2 : aVar.a().t()) {
                    composerImpl2.a1();
                    composerImpl.f3638c.o(composerImpl2.A0());
                }
            }
            return i2Var.N(i11);
        }
        if (!i2Var.e(i11)) {
            if (i2Var.J(i11)) {
                return 1;
            }
            return i2Var.N(i11);
        }
        int E = i2Var.E(i11) + i11;
        int i13 = 0;
        for (int i14 = i11 + 1; i14 < E; i14 += i2Var.E(i14)) {
            boolean J = i2Var.J(i14);
            if (J) {
                composerImpl.O.i();
                composerImpl.O.v(i2Var.L(i14));
            }
            i13 += c1(composerImpl, i14, J || z10, J ? 0 : i12 + i13);
            if (J) {
                composerImpl.O.i();
                composerImpl.O.z();
            }
        }
        if (i2Var.J(i11)) {
            return 1;
        }
        return i13;
    }

    private final void e0() {
        this.f3645j = null;
        this.f3646k = 0;
        this.f3647l = 0;
        this.S = 0;
        this.f3654s = false;
        this.O.Q();
        this.F.a();
        f0();
    }

    private final void f0() {
        this.f3650o = null;
        this.f3651p = null;
    }

    private final void f1() {
        this.f3647l += this.I.S();
    }

    private final void g1() {
        this.f3647l = this.I.v();
        this.I.T();
    }

    private final int h0(int i11, int i12, int i13, int i14) {
        if (i11 == i13) {
            return i14;
        }
        int F0 = F0(this.I, i11);
        if (F0 == 126665345) {
            return F0;
        }
        int P = this.I.P(i11);
        if (P != i13) {
            i14 = h0(P, Q0(P), i13, i14);
        }
        if (this.I.G(i11)) {
            i12 = 0;
        }
        return Integer.rotateLeft(Integer.rotateLeft(i14, 3) ^ F0, 3) ^ i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h1(int r14, java.lang.Object r15, int r16, java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.h1(int, java.lang.Object, int, java.lang.Object):void");
    }

    private final void i0() {
        k.O(this.K.Z());
        y0();
    }

    private final void i1(int i11) {
        h1(i11, null, k0.f3868a.a(), null);
    }

    private final n1 j0() {
        n1 n1Var = this.M;
        return n1Var != null ? n1Var : k0(this.I.u());
    }

    private final void j1(int i11, Object obj) {
        h1(i11, obj, k0.f3868a.a(), null);
    }

    private final n1 k0(int i11) {
        n1 n1Var;
        if (e() && this.L) {
            int c02 = this.K.c0();
            while (c02 > 0) {
                if (this.K.i0(c02) == 202 && Intrinsics.c(this.K.j0(c02), k.y())) {
                    Object g02 = this.K.g0(c02);
                    Intrinsics.f(g02, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    n1 n1Var2 = (n1) g02;
                    this.M = n1Var2;
                    return n1Var2;
                }
                c02 = this.K.E0(c02);
            }
        }
        if (this.I.x() > 0) {
            while (i11 > 0) {
                if (this.I.C(i11) == 202 && Intrinsics.c(this.I.D(i11), k.y())) {
                    androidx.compose.runtime.collection.a aVar = this.f3658w;
                    if (aVar == null || (n1Var = (n1) aVar.a(i11)) == null) {
                        Object z10 = this.I.z(i11);
                        Intrinsics.f(z10, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        n1Var = (n1) z10;
                    }
                    this.M = n1Var;
                    return n1Var;
                }
                i11 = this.I.P(i11);
            }
        }
        n1 n1Var3 = this.f3657v;
        this.M = n1Var3;
        return n1Var3;
    }

    private final void l1(boolean z10, Object obj) {
        if (z10) {
            this.I.V();
            return;
        }
        if (obj != null && this.I.l() != obj) {
            this.O.X(obj);
        }
        this.I.U();
    }

    private final void n0(androidx.compose.runtime.collection.e eVar, Function2 function2) {
        Comparator comparator;
        long[] jArr;
        int i11;
        long[] jArr2;
        int i12;
        if (this.G) {
            k.r("Reentrant composition is not supported");
        }
        Object a11 = e3.f3769a.a("Compose:recompose");
        try {
            this.C = SnapshotKt.H().f();
            this.f3658w = null;
            androidx.collection.n0 d11 = eVar.d();
            Object[] objArr = d11.f2420b;
            Object[] objArr2 = d11.f2421c;
            long[] jArr3 = d11.f2419a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i13 = 0;
                while (true) {
                    long j11 = jArr3[i13];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i14 = 8;
                        int i15 = 8 - ((~(i13 - length)) >>> 31);
                        int i16 = 0;
                        while (i16 < i15) {
                            if ((j11 & 255) < 128) {
                                int i17 = (i13 << 3) + i16;
                                Object obj = objArr[i17];
                                Object obj2 = objArr2[i17];
                                Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                                androidx.compose.runtime.c i18 = ((RecomposeScopeImpl) obj).i();
                                if (i18 != null) {
                                    int a12 = i18.a();
                                    List list = this.f3655t;
                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                    jArr2 = jArr3;
                                    if (obj2 == f2.f3807a) {
                                        obj2 = null;
                                    }
                                    list.add(new o0(recomposeScopeImpl, a12, obj2));
                                } else {
                                    jArr2 = jArr3;
                                }
                                i12 = 8;
                            } else {
                                jArr2 = jArr3;
                                i12 = i14;
                            }
                            j11 >>= i12;
                            i16++;
                            i14 = i12;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        i11 = 1;
                        if (i15 != i14) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                        i11 = 1;
                    }
                    if (i13 == length) {
                        break;
                    }
                    i13 += i11;
                    jArr3 = jArr;
                }
            }
            List list2 = this.f3655t;
            comparator = k.f3867g;
            CollectionsKt.A(list2, comparator);
            this.f3646k = 0;
            this.G = true;
            try {
                n1();
                Object L0 = L0();
                if (L0 != function2 && function2 != null) {
                    u1(function2);
                }
                c cVar = this.E;
                androidx.compose.runtime.collection.b a13 = r2.a();
                try {
                    a13.b(cVar);
                    if (function2 != null) {
                        j1(200, k.z());
                        androidx.compose.runtime.b.d(this, function2);
                        q0();
                    } else if ((!this.f3653r && !this.f3659x) || L0 == null || Intrinsics.c(L0, i.f3811a.a())) {
                        e1();
                    } else {
                        j1(200, k.z());
                        androidx.compose.runtime.b.d(this, (Function2) TypeIntrinsics.e(L0, 2));
                        q0();
                    }
                    a13.v(a13.n() - 1);
                    t0();
                    this.G = false;
                    this.f3655t.clear();
                    i0();
                    Unit unit = Unit.f67184a;
                    e3.f3769a.b(a11);
                } finally {
                    a13.v(a13.n() - 1);
                }
            } catch (Throwable th2) {
                this.G = false;
                this.f3655t.clear();
                R();
                i0();
                throw th2;
            }
        } catch (Throwable th3) {
            e3.f3769a.b(a11);
            throw th3;
        }
    }

    private final void n1() {
        int o11;
        this.f3648m = 0;
        this.I = this.f3639d.w();
        i1(100);
        this.f3638c.p();
        this.f3657v = this.f3638c.f();
        m0 m0Var = this.f3660y;
        o11 = k.o(this.f3659x);
        m0Var.j(o11);
        this.f3659x = O(this.f3657v);
        this.M = null;
        if (!this.f3652q) {
            this.f3652q = this.f3638c.d();
        }
        if (!this.D) {
            this.D = this.f3638c.e();
        }
        Set set = (Set) t.b(this.f3657v, InspectionTablesKt.a());
        if (set != null) {
            set.add(this.f3639d);
            this.f3638c.m(set);
        }
        i1(this.f3638c.g());
    }

    private final void o0(int i11, int i12) {
        if (i11 <= 0 || i11 == i12) {
            return;
        }
        o0(this.I.P(i11), i12);
        if (this.I.J(i11)) {
            this.O.v(N0(this.I, i11));
        }
    }

    private final void p0(boolean z10) {
        int ordinal;
        Set set;
        List list;
        int ordinal2;
        int g11 = this.f3649n.g() - 1;
        if (e()) {
            int c02 = this.K.c0();
            int i02 = this.K.i0(c02);
            Object j02 = this.K.j0(c02);
            Object g02 = this.K.g0(c02);
            if (j02 != null) {
                ordinal2 = (j02 instanceof Enum ? ((Enum) j02).ordinal() : j02.hashCode()) ^ Integer.rotateRight(L(), 3);
            } else if (g02 == null || i02 != 207 || Intrinsics.c(g02, i.f3811a.a())) {
                ordinal2 = Integer.rotateRight(g11 ^ L(), 3) ^ i02;
            } else {
                this.S = Integer.rotateRight(Integer.rotateRight(g11 ^ L(), 3) ^ g02.hashCode(), 3);
            }
            this.S = Integer.rotateRight(ordinal2, 3);
        } else {
            int u11 = this.I.u();
            int C = this.I.C(u11);
            Object D = this.I.D(u11);
            Object z11 = this.I.z(u11);
            if (D != null) {
                ordinal = (D instanceof Enum ? ((Enum) D).ordinal() : D.hashCode()) ^ Integer.rotateRight(L(), 3);
            } else if (z11 == null || C != 207 || Intrinsics.c(z11, i.f3811a.a())) {
                ordinal = Integer.rotateRight(g11 ^ L(), 3) ^ C;
            } else {
                this.S = Integer.rotateRight(Integer.rotateRight(g11 ^ L(), 3) ^ z11.hashCode(), 3);
            }
            this.S = Integer.rotateRight(ordinal, 3);
        }
        int i11 = this.f3647l;
        Pending pending = this.f3645j;
        if (pending != null && pending.b().size() > 0) {
            List b11 = pending.b();
            List f11 = pending.f();
            Set e11 = androidx.compose.runtime.snapshots.a.e(f11);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = f11.size();
            int size2 = b11.size();
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i12 < size2) {
                q0 q0Var = (q0) b11.get(i12);
                if (e11.contains(q0Var)) {
                    set = e11;
                    if (!linkedHashSet.contains(q0Var)) {
                        if (i13 < size) {
                            q0 q0Var2 = (q0) f11.get(i13);
                            if (q0Var2 != q0Var) {
                                int g12 = pending.g(q0Var2);
                                linkedHashSet.add(q0Var2);
                                if (g12 != i14) {
                                    int o11 = pending.o(q0Var2);
                                    list = f11;
                                    this.O.w(pending.e() + g12, i14 + pending.e(), o11);
                                    pending.j(g12, i14, o11);
                                } else {
                                    list = f11;
                                }
                            } else {
                                list = f11;
                                i12++;
                            }
                            i13++;
                            i14 += pending.o(q0Var2);
                            e11 = set;
                            f11 = list;
                        }
                        e11 = set;
                    }
                } else {
                    this.O.O(pending.g(q0Var) + pending.e(), q0Var.c());
                    pending.n(q0Var.b(), 0);
                    this.O.x(q0Var.b());
                    this.I.Q(q0Var.b());
                    V0();
                    this.I.S();
                    set = e11;
                    k.N(this.f3655t, q0Var.b(), q0Var.b() + this.I.E(q0Var.b()));
                }
                i12++;
                e11 = set;
            }
            this.O.i();
            if (b11.size() > 0) {
                this.O.x(this.I.m());
                this.I.T();
            }
        }
        int i15 = this.f3646k;
        while (!this.I.H()) {
            int k11 = this.I.k();
            V0();
            this.O.O(i15, this.I.S());
            k.N(this.f3655t, k11, this.I.k());
        }
        boolean e12 = e();
        if (e12) {
            if (z10) {
                this.Q.c();
                i11 = 1;
            }
            this.I.f();
            int c03 = this.K.c0();
            this.K.T();
            if (!this.I.t()) {
                int I0 = I0(c03);
                this.K.U();
                this.K.L(true);
                W0(this.P);
                this.R = false;
                if (!this.f3639d.isEmpty()) {
                    q1(I0, 0);
                    r1(I0, i11);
                }
            }
        } else {
            if (z10) {
                this.O.z();
            }
            int w11 = this.I.w();
            if (w11 > 0) {
                this.O.V(w11);
            }
            this.O.g();
            int u12 = this.I.u();
            if (i11 != v1(u12)) {
                r1(u12, i11);
            }
            if (z10) {
                i11 = 1;
            }
            this.I.g();
            this.O.i();
        }
        w0(i11, e12);
    }

    private final void q0() {
        p0(false);
    }

    private final void q1(int i11, int i12) {
        if (v1(i11) != i12) {
            if (i11 < 0) {
                androidx.collection.c0 c0Var = this.f3651p;
                if (c0Var == null) {
                    c0Var = new androidx.collection.c0(0, 1, null);
                    this.f3651p = c0Var;
                }
                c0Var.q(i11, i12);
                return;
            }
            int[] iArr = this.f3650o;
            if (iArr == null) {
                iArr = new int[this.I.x()];
                ArraysKt.y(iArr, -1, 0, 0, 6, null);
                this.f3650o = iArr;
            }
            iArr[i11] = i12;
        }
    }

    private final void r1(int i11, int i12) {
        int v12 = v1(i11);
        if (v12 != i12) {
            int i13 = i12 - v12;
            int b11 = this.f3644i.b() - 1;
            while (i11 != -1) {
                int v13 = v1(i11) + i13;
                q1(i11, v13);
                int i14 = b11;
                while (true) {
                    if (-1 < i14) {
                        Pending pending = (Pending) this.f3644i.f(i14);
                        if (pending != null && pending.n(i11, v13)) {
                            b11 = i14 - 1;
                            break;
                        }
                        i14--;
                    } else {
                        break;
                    }
                }
                if (i11 < 0) {
                    i11 = this.I.u();
                } else if (this.I.J(i11)) {
                    return;
                } else {
                    i11 = this.I.P(i11);
                }
            }
        }
    }

    private final n1 s1(n1 n1Var, n1 n1Var2) {
        n1.a builder = n1Var.builder();
        builder.putAll(n1Var2);
        n1 build = builder.build();
        j1(Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE, k.C());
        t1(build);
        t1(n1Var2);
        q0();
        return build;
    }

    private final void t0() {
        boolean n11;
        q0();
        this.f3638c.b();
        q0();
        this.O.j();
        x0();
        this.I.d();
        this.f3653r = false;
        n11 = k.n(this.f3660y.i());
        this.f3659x = n11;
    }

    private final void t1(Object obj) {
        L0();
        u1(obj);
    }

    private final void u0() {
        if (this.K.Z()) {
            m2 x10 = this.J.x();
            this.K = x10;
            x10.W0();
            this.L = false;
            this.M = null;
        }
    }

    private final void v0(boolean z10, Pending pending) {
        this.f3644i.h(this.f3645j);
        this.f3645j = pending;
        this.f3649n.j(this.f3647l);
        this.f3649n.j(this.f3648m);
        this.f3649n.j(this.f3646k);
        if (z10) {
            this.f3646k = 0;
        }
        this.f3647l = 0;
        this.f3648m = 0;
    }

    private final int v1(int i11) {
        int i12;
        if (i11 >= 0) {
            int[] iArr = this.f3650o;
            return (iArr == null || (i12 = iArr[i11]) < 0) ? this.I.N(i11) : i12;
        }
        androidx.collection.c0 c0Var = this.f3651p;
        if (c0Var == null || !c0Var.a(i11)) {
            return 0;
        }
        return c0Var.c(i11);
    }

    private final void w0(int i11, boolean z10) {
        Pending pending = (Pending) this.f3644i.g();
        if (pending != null && !z10) {
            pending.l(pending.a() + 1);
        }
        this.f3645j = pending;
        this.f3646k = this.f3649n.i() + i11;
        this.f3648m = this.f3649n.i();
        this.f3647l = this.f3649n.i() + i11;
    }

    private final void w1() {
        if (!this.f3654s) {
            k.r("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.f3654s = false;
    }

    private final void x0() {
        this.O.m();
        if (!this.f3644i.c()) {
            k.r("Start/end imbalance");
        }
        e0();
    }

    private final void x1() {
        if (this.f3654s) {
            k.r("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    private final void y0() {
        j2 j2Var = new j2();
        if (this.D) {
            j2Var.j();
        }
        if (this.f3638c.c()) {
            j2Var.h();
        }
        this.J = j2Var;
        m2 x10 = j2Var.x();
        x10.L(true);
        this.K = x10;
    }

    @Override // androidx.compose.runtime.i
    public boolean A(Object obj) {
        if (L0() == obj) {
            return false;
        }
        u1(obj);
        return true;
    }

    public y A0() {
        return this.f3643h;
    }

    @Override // androidx.compose.runtime.i
    public void B() {
        h1(-127, null, k0.f3868a.a(), null);
    }

    public final RecomposeScopeImpl B0() {
        z2 z2Var = this.F;
        if (this.B == 0 && z2Var.d()) {
            return (RecomposeScopeImpl) z2Var.e();
        }
        return null;
    }

    @Override // androidx.compose.runtime.i
    public void C() {
        h1(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, null, k0.f3868a.c(), null);
        this.f3654s = true;
    }

    public final s.a C0() {
        return this.N;
    }

    @Override // androidx.compose.runtime.i
    public void D(t1 t1Var) {
        g3 g3Var;
        int o11;
        n1 j02 = j0();
        j1(201, k.B());
        Object y10 = y();
        if (Intrinsics.c(y10, i.f3811a.a())) {
            g3Var = null;
        } else {
            Intrinsics.f(y10, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            g3Var = (g3) y10;
        }
        q b11 = t1Var.b();
        Intrinsics.f(b11, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.f(t1Var, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        g3 b12 = b11.b(t1Var, g3Var);
        boolean c11 = Intrinsics.c(b12, g3Var);
        if (!c11) {
            p(b12);
        }
        boolean z10 = true;
        boolean z11 = false;
        if (e()) {
            if (t1Var.a() || !t.a(j02, b11)) {
                j02 = j02.b(b11, b12);
            }
            this.L = true;
        } else {
            i2 i2Var = this.I;
            Object z12 = i2Var.z(i2Var.k());
            Intrinsics.f(z12, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            n1 n1Var = (n1) z12;
            j02 = (!(h() && c11) && (t1Var.a() || !t.a(j02, b11))) ? j02.b(b11, b12) : n1Var;
            if (!this.f3661z && n1Var == j02) {
                z10 = false;
            }
            z11 = z10;
        }
        if (z11 && !e()) {
            X0(j02);
        }
        m0 m0Var = this.f3660y;
        o11 = k.o(this.f3659x);
        m0Var.j(o11);
        this.f3659x = z11;
        this.M = j02;
        h1(Sdk$SDKError.Reason.AD_CONSUMED_VALUE, k.y(), k0.f3868a.a(), j02);
    }

    @Override // androidx.compose.runtime.i
    public void E(int i11, Object obj) {
        if (!e() && this.I.n() == i11 && !Intrinsics.c(this.I.l(), obj) && this.A < 0) {
            this.A = this.I.k();
            this.f3661z = true;
        }
        h1(i11, null, k0.f3868a.a(), obj);
    }

    public final i2 E0() {
        return this.I;
    }

    @Override // androidx.compose.runtime.i
    public void F(Function0 function0) {
        w1();
        if (!e()) {
            k.r("createNode() can only be called when inserting");
        }
        int e11 = this.f3649n.e();
        m2 m2Var = this.K;
        androidx.compose.runtime.c E = m2Var.E(m2Var.c0());
        this.f3647l++;
        this.Q.b(function0, e11, E);
    }

    @Override // androidx.compose.runtime.i
    public void G() {
        if (!(this.f3647l == 0)) {
            k.r("No nodes can be emitted before calling skipAndEndGroup");
        }
        RecomposeScopeImpl B0 = B0();
        if (B0 != null) {
            B0.z();
        }
        if (this.f3655t.isEmpty()) {
            g1();
        } else {
            U0();
        }
    }

    @Override // androidx.compose.runtime.i
    public void H() {
        boolean n11;
        q0();
        q0();
        n11 = k.n(this.f3660y.i());
        this.f3659x = n11;
        this.M = null;
    }

    public void H0(List list) {
        try {
            G0(list);
            e0();
        } catch (Throwable th2) {
            R();
            throw th2;
        }
    }

    @Override // androidx.compose.runtime.i
    public boolean I() {
        if (!h() || this.f3659x) {
            return true;
        }
        RecomposeScopeImpl B0 = B0();
        return B0 != null && B0.l();
    }

    @Override // androidx.compose.runtime.i
    public void J(u1 u1Var) {
        RecomposeScopeImpl recomposeScopeImpl = u1Var instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) u1Var : null;
        if (recomposeScopeImpl == null) {
            return;
        }
        recomposeScopeImpl.H(true);
    }

    @Override // androidx.compose.runtime.i
    public void K() {
        q0();
    }

    public final boolean K0() {
        return this.G;
    }

    @Override // androidx.compose.runtime.i
    public int L() {
        return this.S;
    }

    public final Object L0() {
        if (e()) {
            x1();
            return i.f3811a.a();
        }
        Object K = this.I.K();
        return (!this.f3661z || (K instanceof e2)) ? K : i.f3811a.a();
    }

    @Override // androidx.compose.runtime.i
    public m M() {
        j1(Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE, k.D());
        if (e()) {
            m2.t0(this.K, 0, 1, null);
        }
        Object L0 = L0();
        a aVar = L0 instanceof a ? (a) L0 : null;
        if (aVar == null) {
            int L = L();
            boolean z10 = this.f3652q;
            boolean z11 = this.D;
            y A0 = A0();
            o oVar = A0 instanceof o ? (o) A0 : null;
            aVar = new a(new b(L, z10, z11, oVar != null ? oVar.E() : null));
            u1(aVar);
        }
        aVar.a().w(j0());
        q0();
        return aVar.a();
    }

    public final Object M0() {
        if (e()) {
            x1();
            return i.f3811a.a();
        }
        Object K = this.I.K();
        return (!this.f3661z || (K instanceof e2)) ? K instanceof c2 ? ((c2) K).b() : K : i.f3811a.a();
    }

    @Override // androidx.compose.runtime.i
    public void N() {
        q0();
    }

    @Override // androidx.compose.runtime.i
    public boolean O(Object obj) {
        if (Intrinsics.c(L0(), obj)) {
            return false;
        }
        u1(obj);
        return true;
    }

    @Override // androidx.compose.runtime.i
    public void P(int i11) {
        if (this.f3645j != null) {
            h1(i11, null, k0.f3868a.a(), null);
            return;
        }
        x1();
        this.S = this.f3648m ^ Integer.rotateLeft(Integer.rotateLeft(L(), 3) ^ i11, 3);
        this.f3648m++;
        i2 i2Var = this.I;
        if (e()) {
            i2Var.c();
            this.K.h1(i11, i.f3811a.a());
            v0(false, null);
            return;
        }
        if (i2Var.n() == i11 && !i2Var.s()) {
            i2Var.U();
            v0(false, null);
            return;
        }
        if (!i2Var.H()) {
            int i12 = this.f3646k;
            int k11 = i2Var.k();
            V0();
            this.O.O(i12, i2Var.S());
            k.N(this.f3655t, k11, i2Var.k());
        }
        i2Var.c();
        this.R = true;
        this.M = null;
        u0();
        m2 m2Var = this.K;
        m2Var.I();
        int a02 = m2Var.a0();
        m2Var.h1(i11, i.f3811a.a());
        this.P = m2Var.E(a02);
        v0(false, null);
    }

    public final void P0(Function0 function0) {
        if (this.G) {
            k.r("Preparing a composition while composing is not supported");
        }
        this.G = true;
        try {
            function0.invoke();
        } finally {
            this.G = false;
        }
    }

    @Override // androidx.compose.runtime.i
    public void Q(t1[] t1VarArr) {
        n1 s12;
        int o11;
        n1 j02 = j0();
        j1(201, k.B());
        boolean z10 = true;
        boolean z11 = false;
        if (e()) {
            s12 = s1(j02, t.d(t1VarArr, j02, null, 4, null));
            this.L = true;
        } else {
            Object A = this.I.A(0);
            Intrinsics.f(A, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            n1 n1Var = (n1) A;
            Object A2 = this.I.A(1);
            Intrinsics.f(A2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            n1 n1Var2 = (n1) A2;
            n1 c11 = t.c(t1VarArr, j02, n1Var2);
            if (h() && !this.f3661z && Intrinsics.c(n1Var2, c11)) {
                f1();
                s12 = n1Var;
            } else {
                s12 = s1(j02, c11);
                if (!this.f3661z && Intrinsics.c(s12, n1Var)) {
                    z10 = false;
                }
                z11 = z10;
            }
        }
        if (z11 && !e()) {
            X0(s12);
        }
        m0 m0Var = this.f3660y;
        o11 = k.o(this.f3659x);
        m0Var.j(o11);
        this.f3659x = z11;
        this.M = s12;
        h1(Sdk$SDKError.Reason.AD_CONSUMED_VALUE, k.y(), k0.f3868a.a(), s12);
    }

    public final boolean R0(androidx.compose.runtime.collection.e eVar) {
        if (!this.f3641f.c()) {
            k.r("Expected applyChanges() to have been called");
        }
        if (eVar.e() <= 0 && this.f3655t.isEmpty() && !this.f3653r) {
            return false;
        }
        n0(eVar, null);
        return this.f3641f.d();
    }

    @Override // androidx.compose.runtime.i
    public boolean a(boolean z10) {
        Object L0 = L0();
        if ((L0 instanceof Boolean) && z10 == ((Boolean) L0).booleanValue()) {
            return false;
        }
        u1(Boolean.valueOf(z10));
        return true;
    }

    @Override // androidx.compose.runtime.i
    public boolean b(float f11) {
        Object L0 = L0();
        if ((L0 instanceof Float) && f11 == ((Number) L0).floatValue()) {
            return false;
        }
        u1(Float.valueOf(f11));
        return true;
    }

    @Override // androidx.compose.runtime.i
    public boolean c(int i11) {
        Object L0 = L0();
        if ((L0 instanceof Integer) && i11 == ((Number) L0).intValue()) {
            return false;
        }
        u1(Integer.valueOf(i11));
        return true;
    }

    @Override // androidx.compose.runtime.i
    public boolean d(long j11) {
        Object L0 = L0();
        if ((L0 instanceof Long) && j11 == ((Number) L0).longValue()) {
            return false;
        }
        u1(Long.valueOf(j11));
        return true;
    }

    public final void d0() {
        this.f3658w = null;
    }

    public final void d1(i2 i2Var) {
        this.I = i2Var;
    }

    @Override // androidx.compose.runtime.i
    public boolean e() {
        return this.R;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e1() {
        /*
            r9 = this;
            java.util.List r0 = r9.f3655t
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Ld
            r9.f1()
            goto Ld5
        Ld:
            androidx.compose.runtime.i2 r0 = r9.I
            int r1 = r0.n()
            java.lang.Object r2 = r0.o()
            java.lang.Object r3 = r0.l()
            int r4 = r9.f3648m
            r5 = 207(0xcf, float:2.9E-43)
            r6 = 3
            if (r2 != 0) goto L58
            if (r3 == 0) goto L47
            if (r1 != r5) goto L47
            androidx.compose.runtime.i$a r7 = androidx.compose.runtime.i.f3811a
            java.lang.Object r7 = r7.a()
            boolean r7 = kotlin.jvm.internal.Intrinsics.c(r3, r7)
            if (r7 != 0) goto L47
            int r7 = r3.hashCode()
            int r8 = r9.L()
            int r8 = java.lang.Integer.rotateLeft(r8, r6)
            r7 = r7 ^ r8
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r4
            r9.S = r7
            goto L76
        L47:
            int r7 = r9.L()
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r1
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            r7 = r7 ^ r4
        L55:
            r9.S = r7
            goto L76
        L58:
            boolean r7 = r2 instanceof java.lang.Enum
            if (r7 == 0) goto L71
            r7 = r2
            java.lang.Enum r7 = (java.lang.Enum) r7
            int r7 = r7.ordinal()
        L63:
            int r8 = r9.L()
            int r8 = java.lang.Integer.rotateLeft(r8, r6)
            r7 = r7 ^ r8
            int r7 = java.lang.Integer.rotateLeft(r7, r6)
            goto L55
        L71:
            int r7 = r2.hashCode()
            goto L63
        L76:
            boolean r7 = r0.I()
            r8 = 0
            r9.l1(r7, r8)
            r9.U0()
            r0.g()
            if (r2 != 0) goto Lbc
            if (r3 == 0) goto Lab
            if (r1 != r5) goto Lab
            androidx.compose.runtime.i$a r0 = androidx.compose.runtime.i.f3811a
            java.lang.Object r0 = r0.a()
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r3, r0)
            if (r0 != 0) goto Lab
            int r0 = r3.hashCode()
            int r1 = r9.L()
            r1 = r1 ^ r4
            int r1 = java.lang.Integer.rotateRight(r1, r6)
            r0 = r0 ^ r1
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r9.S = r0
            goto Ld5
        Lab:
            int r0 = r9.L()
            r0 = r0 ^ r4
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r0 = r0 ^ r1
        Lb5:
            int r0 = java.lang.Integer.rotateRight(r0, r6)
            r9.S = r0
            goto Ld5
        Lbc:
            boolean r0 = r2 instanceof java.lang.Enum
            if (r0 == 0) goto Ld0
            java.lang.Enum r2 = (java.lang.Enum) r2
            int r0 = r2.ordinal()
        Lc6:
            int r1 = r9.L()
            int r1 = java.lang.Integer.rotateRight(r1, r6)
            r0 = r0 ^ r1
            goto Lb5
        Ld0:
            int r0 = r2.hashCode()
            goto Lc6
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.e1():void");
    }

    @Override // androidx.compose.runtime.i
    public void f(boolean z10) {
        if (!(this.f3647l == 0)) {
            k.r("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (e()) {
            return;
        }
        if (!z10) {
            g1();
            return;
        }
        int k11 = this.I.k();
        int j11 = this.I.j();
        this.O.d();
        k.N(this.f3655t, k11, j11);
        this.I.T();
    }

    @Override // androidx.compose.runtime.i
    public i g(int i11) {
        P(i11);
        c0();
        return this;
    }

    public final void g0(androidx.compose.runtime.collection.e eVar, Function2 function2) {
        if (!this.f3641f.c()) {
            k.r("Expected applyChanges() to have been called");
        }
        n0(eVar, function2);
    }

    @Override // androidx.compose.runtime.i
    public boolean h() {
        RecomposeScopeImpl B0;
        return (e() || this.f3661z || this.f3659x || (B0 = B0()) == null || B0.n() || this.f3653r) ? false : true;
    }

    @Override // androidx.compose.runtime.i
    public f i() {
        return this.f3637b;
    }

    @Override // androidx.compose.runtime.i
    public g2 j() {
        androidx.compose.runtime.c a11;
        Function1 h11;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImpl2 = this.F.d() ? (RecomposeScopeImpl) this.F.g() : null;
        if (recomposeScopeImpl2 != null) {
            recomposeScopeImpl2.E(false);
        }
        if (recomposeScopeImpl2 != null && (h11 = recomposeScopeImpl2.h(this.C)) != null) {
            this.O.f(h11, A0());
        }
        if (recomposeScopeImpl2 != null && !recomposeScopeImpl2.p() && (recomposeScopeImpl2.q() || this.f3652q)) {
            if (recomposeScopeImpl2.i() == null) {
                if (e()) {
                    m2 m2Var = this.K;
                    a11 = m2Var.E(m2Var.c0());
                } else {
                    i2 i2Var = this.I;
                    a11 = i2Var.a(i2Var.u());
                }
                recomposeScopeImpl2.A(a11);
            }
            recomposeScopeImpl2.C(false);
            recomposeScopeImpl = recomposeScopeImpl2;
        }
        p0(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.i
    public void k(Object obj, Function2 function2) {
        if (e()) {
            this.Q.f(obj, function2);
        } else {
            this.O.Y(obj, function2);
        }
    }

    public void k1(int i11, Object obj) {
        h1(i11, obj, k0.f3868a.a(), null);
    }

    @Override // androidx.compose.runtime.i
    public Object l(q qVar) {
        return t.b(j0(), qVar);
    }

    public final void l0() {
        this.F.a();
        this.f3655t.clear();
        this.f3641f.a();
        this.f3658w = null;
    }

    @Override // androidx.compose.runtime.i
    public CoroutineContext m() {
        return this.f3638c.h();
    }

    public final void m0() {
        e3 e3Var = e3.f3769a;
        Object a11 = e3Var.a("Compose:Composer.dispose");
        try {
            this.f3638c.q(this);
            l0();
            i().clear();
            this.H = true;
            Unit unit = Unit.f67184a;
            e3Var.b(a11);
        } catch (Throwable th2) {
            e3.f3769a.b(a11);
            throw th2;
        }
    }

    public final void m1() {
        this.A = 100;
        this.f3661z = true;
    }

    @Override // androidx.compose.runtime.i
    public s n() {
        return j0();
    }

    @Override // androidx.compose.runtime.i
    public void o() {
        w1();
        if (e()) {
            k.r("useNode() called while inserting");
        }
        Object D0 = D0(this.I);
        this.O.v(D0);
        if (this.f3661z && (D0 instanceof h)) {
            this.O.a0(D0);
        }
    }

    public final boolean o1(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        androidx.compose.runtime.c i11 = recomposeScopeImpl.i();
        if (i11 == null) {
            return false;
        }
        int d11 = i11.d(this.I.y());
        if (!this.G || d11 < this.I.k()) {
            return false;
        }
        k.E(this.f3655t, d11, recomposeScopeImpl, obj);
        return true;
    }

    @Override // androidx.compose.runtime.i
    public void p(Object obj) {
        p1(obj);
    }

    public final void p1(Object obj) {
        if (obj instanceof b2) {
            if (e()) {
                this.O.M((b2) obj);
            }
            this.f3640e.add(obj);
            obj = new c2((b2) obj, Z0());
        }
        u1(obj);
    }

    @Override // androidx.compose.runtime.i
    public void q() {
        boolean n11;
        q0();
        q0();
        n11 = k.n(this.f3660y.i());
        this.f3659x = n11;
        this.M = null;
    }

    @Override // androidx.compose.runtime.i
    public void r() {
        p0(true);
    }

    public void r0() {
        q0();
    }

    @Override // androidx.compose.runtime.i
    public void s() {
        q0();
        RecomposeScopeImpl B0 = B0();
        if (B0 == null || !B0.q()) {
            return;
        }
        B0.B(true);
    }

    public final void s0() {
        if (!(!this.G && this.A == 100)) {
            o1.a("Cannot disable reuse from root if it was caused by other groups");
        }
        this.A = -1;
        this.f3661z = false;
    }

    @Override // androidx.compose.runtime.i
    public void t(Function0 function0) {
        this.O.T(function0);
    }

    @Override // androidx.compose.runtime.i
    public void u() {
        this.f3652q = true;
        this.D = true;
        this.f3639d.j();
        this.J.j();
        this.K.v1();
    }

    public final void u1(Object obj) {
        if (e()) {
            this.K.m1(obj);
            return;
        }
        if (!this.I.r()) {
            s.b bVar = this.O;
            i2 i2Var = this.I;
            bVar.a(i2Var.a(i2Var.u()), obj);
            return;
        }
        int q11 = this.I.q() - 1;
        if (!this.O.p()) {
            this.O.Z(obj, q11);
            return;
        }
        s.b bVar2 = this.O;
        i2 i2Var2 = this.I;
        bVar2.W(obj, i2Var2.a(i2Var2.u()), q11);
    }

    @Override // androidx.compose.runtime.i
    public u1 v() {
        return B0();
    }

    @Override // androidx.compose.runtime.i
    public void w() {
        if (this.f3661z && this.I.u() == this.A) {
            this.A = -1;
            this.f3661z = false;
        }
        p0(false);
    }

    @Override // androidx.compose.runtime.i
    public void x(int i11) {
        h1(i11, null, k0.f3868a.a(), null);
    }

    @Override // androidx.compose.runtime.i
    public Object y() {
        return M0();
    }

    @Override // androidx.compose.runtime.i
    public androidx.compose.runtime.tooling.a z() {
        return this.f3639d;
    }

    public final boolean z0() {
        return this.B > 0;
    }
}
