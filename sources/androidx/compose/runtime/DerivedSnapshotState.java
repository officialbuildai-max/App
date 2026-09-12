package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.j;
import androidx.compose.runtime.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DerivedSnapshotState extends androidx.compose.runtime.snapshots.d0 implements z {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f3677a;

    /* renamed from: b, reason: collision with root package name */
    private final q2 f3678b;

    /* renamed from: c, reason: collision with root package name */
    private a f3679c = new a();

    /* loaded from: classes.dex */
    public static final class a extends androidx.compose.runtime.snapshots.e0 implements z.a {

        /* renamed from: h, reason: collision with root package name */
        public static final C0039a f3680h = new C0039a(null);

        /* renamed from: i, reason: collision with root package name */
        public static final int f3681i = 8;

        /* renamed from: j, reason: collision with root package name */
        private static final Object f3682j = new Object();

        /* renamed from: c, reason: collision with root package name */
        private int f3683c;

        /* renamed from: d, reason: collision with root package name */
        private int f3684d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.collection.p0 f3685e = androidx.collection.q0.a();

        /* renamed from: f, reason: collision with root package name */
        private Object f3686f = f3682j;

        /* renamed from: g, reason: collision with root package name */
        private int f3687g;

        /* renamed from: androidx.compose.runtime.DerivedSnapshotState$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0039a {
            private C0039a() {
            }

            public /* synthetic */ C0039a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object a() {
                return a.f3682j;
            }
        }

        @Override // androidx.compose.runtime.z.a
        public Object a() {
            return this.f3686f;
        }

        @Override // androidx.compose.runtime.z.a
        public androidx.collection.p0 b() {
            return this.f3685e;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(androidx.compose.runtime.snapshots.e0 e0Var) {
            Intrinsics.f(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            a aVar = (a) e0Var;
            m(aVar.b());
            this.f3686f = aVar.f3686f;
            this.f3687g = aVar.f3687g;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public androidx.compose.runtime.snapshots.e0 d() {
            return new a();
        }

        public final Object j() {
            return this.f3686f;
        }

        public final boolean k(z zVar, androidx.compose.runtime.snapshots.j jVar) {
            boolean z10;
            boolean z11;
            synchronized (SnapshotKt.I()) {
                z10 = true;
                if (this.f3683c == jVar.f()) {
                    if (this.f3684d == jVar.j()) {
                        z11 = false;
                    }
                }
                z11 = true;
            }
            if (this.f3686f == f3682j || (z11 && this.f3687g != l(zVar, jVar))) {
                z10 = false;
            }
            if (z10 && z11) {
                synchronized (SnapshotKt.I()) {
                    this.f3683c = jVar.f();
                    this.f3684d = jVar.j();
                    Unit unit = Unit.f67184a;
                }
            }
            return z10;
        }

        public final int l(z zVar, androidx.compose.runtime.snapshots.j jVar) {
            androidx.collection.p0 b11;
            int i11;
            int i12;
            synchronized (SnapshotKt.I()) {
                b11 = b();
            }
            char c11 = 7;
            if (!b11.g()) {
                return 7;
            }
            androidx.compose.runtime.collection.b a11 = r2.a();
            int n11 = a11.n();
            if (n11 > 0) {
                Object[] m11 = a11.m();
                int i13 = 0;
                do {
                    ((a0) m11[i13]).b(zVar);
                    i13++;
                } while (i13 < n11);
            }
            try {
                Object[] objArr = b11.f2390b;
                int[] iArr = b11.f2391c;
                long[] jArr = b11.f2389a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i14 = 7;
                    int i15 = 0;
                    while (true) {
                        long j11 = jArr[i15];
                        if ((((~j11) << c11) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i16 = 8;
                            int i17 = 8 - ((~(i15 - length)) >>> 31);
                            int i18 = 0;
                            while (i18 < i17) {
                                if ((j11 & 255) < 128) {
                                    int i19 = (i15 << 3) + i18;
                                    androidx.compose.runtime.snapshots.c0 c0Var = (androidx.compose.runtime.snapshots.c0) objArr[i19];
                                    if (iArr[i19] == 1) {
                                        androidx.compose.runtime.snapshots.e0 c12 = c0Var instanceof DerivedSnapshotState ? ((DerivedSnapshotState) c0Var).c(jVar) : SnapshotKt.G(c0Var.getFirstStateRecord(), jVar);
                                        i14 = (((i14 * 31) + b.c(c12)) * 31) + c12.f();
                                    }
                                    i12 = 8;
                                } else {
                                    i12 = i16;
                                }
                                j11 >>= i12;
                                i18++;
                                i16 = i12;
                            }
                            if (i17 != i16) {
                                break;
                            }
                        }
                        if (i15 == length) {
                            break;
                        }
                        i15++;
                        c11 = 7;
                    }
                    i11 = i14;
                } else {
                    i11 = 7;
                }
                Unit unit = Unit.f67184a;
                int n12 = a11.n();
                if (n12 <= 0) {
                    return i11;
                }
                Object[] m12 = a11.m();
                int i20 = 0;
                do {
                    ((a0) m12[i20]).a(zVar);
                    i20++;
                } while (i20 < n12);
                return i11;
            } catch (Throwable th2) {
                int n13 = a11.n();
                if (n13 > 0) {
                    Object[] m13 = a11.m();
                    int i21 = 0;
                    do {
                        ((a0) m13[i21]).a(zVar);
                        i21++;
                    } while (i21 < n13);
                }
                throw th2;
            }
        }

        public void m(androidx.collection.p0 p0Var) {
            this.f3685e = p0Var;
        }

        public final void n(Object obj) {
            this.f3686f = obj;
        }

        public final void o(int i11) {
            this.f3687g = i11;
        }

        public final void p(int i11) {
            this.f3683c = i11;
        }

        public final void q(int i11) {
            this.f3684d = i11;
        }
    }

    public DerivedSnapshotState(Function0 function0, q2 q2Var) {
        this.f3677a = function0;
        this.f3678b = q2Var;
    }

    /* JADX WARN: Finally extract failed */
    private final a d(a aVar, androidx.compose.runtime.snapshots.j jVar, boolean z10, Function0 function0) {
        v2 v2Var;
        j.a aVar2;
        v2 v2Var2;
        q2 policy;
        v2 v2Var3;
        v2 v2Var4;
        int i11;
        int i12;
        v2 v2Var5;
        a aVar3 = aVar;
        int i13 = 1;
        if (!aVar3.k(this, jVar)) {
            int i14 = 0;
            final androidx.collection.k0 k0Var = new androidx.collection.k0(0, 1, null);
            v2Var = s2.f3959a;
            final androidx.compose.runtime.internal.c cVar = (androidx.compose.runtime.internal.c) v2Var.a();
            if (cVar == null) {
                cVar = new androidx.compose.runtime.internal.c(0);
                v2Var3 = s2.f3959a;
                v2Var3.b(cVar);
            }
            final int a11 = cVar.a();
            androidx.compose.runtime.collection.b a12 = r2.a();
            int n11 = a12.n();
            if (n11 > 0) {
                Object[] m11 = a12.m();
                int i15 = 0;
                while (true) {
                    ((a0) m11[i15]).b(this);
                    int i16 = i15 + 1;
                    if (i16 >= n11) {
                        break;
                    }
                    i15 = i16;
                }
            }
            try {
                cVar.b(a11 + 1);
                Object h11 = androidx.compose.runtime.snapshots.j.f4079e.h(new Function1<Object, Unit>() { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$1$result$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m83invoke(obj);
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m83invoke(Object obj) {
                        if (obj == DerivedSnapshotState.this) {
                            throw new IllegalStateException("A derived state calculation cannot read itself");
                        }
                        if (obj instanceof androidx.compose.runtime.snapshots.c0) {
                            int a13 = cVar.a();
                            androidx.collection.k0 k0Var2 = k0Var;
                            k0Var2.r(obj, Math.min(a13 - a11, k0Var2.d(obj, Integer.MAX_VALUE)));
                        }
                    }
                }, null, function0);
                cVar.b(a11);
                int n12 = a12.n();
                if (n12 > 0) {
                    Object[] m12 = a12.m();
                    do {
                        ((a0) m12[i14]).a(this);
                        i14++;
                    } while (i14 < n12);
                }
                synchronized (SnapshotKt.I()) {
                    try {
                        aVar2 = androidx.compose.runtime.snapshots.j.f4079e;
                        androidx.compose.runtime.snapshots.j c11 = aVar2.c();
                        if (aVar.j() == a.f3680h.a() || (policy = getPolicy()) == null || !policy.b(h11, aVar.j())) {
                            aVar3 = (a) SnapshotKt.O(this.f3679c, this, c11);
                            aVar3.m(k0Var);
                            aVar3.o(aVar3.l(this, c11));
                            aVar3.n(h11);
                        } else {
                            aVar3.m(k0Var);
                            aVar3.o(aVar3.l(this, c11));
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                v2Var2 = s2.f3959a;
                androidx.compose.runtime.internal.c cVar2 = (androidx.compose.runtime.internal.c) v2Var2.a();
                if (cVar2 != null && cVar2.a() == 0) {
                    aVar2.g();
                    synchronized (SnapshotKt.I()) {
                        androidx.compose.runtime.snapshots.j c12 = aVar2.c();
                        aVar3.p(c12.f());
                        aVar3.q(c12.j());
                        Unit unit = Unit.f67184a;
                    }
                }
                return aVar3;
            } catch (Throwable th3) {
                int n13 = a12.n();
                if (n13 > 0) {
                    Object[] m13 = a12.m();
                    do {
                        ((a0) m13[i14]).a(this);
                        i14++;
                    } while (i14 < n13);
                }
                throw th3;
            }
        }
        if (z10) {
            androidx.compose.runtime.collection.b a13 = r2.a();
            int n14 = a13.n();
            if (n14 > 0) {
                Object[] m14 = a13.m();
                int i17 = 0;
                do {
                    ((a0) m14[i17]).b(this);
                    i17++;
                } while (i17 < n14);
            }
            try {
                androidx.collection.p0 b11 = aVar.b();
                v2Var4 = s2.f3959a;
                androidx.compose.runtime.internal.c cVar3 = (androidx.compose.runtime.internal.c) v2Var4.a();
                if (cVar3 == null) {
                    cVar3 = new androidx.compose.runtime.internal.c(0);
                    v2Var5 = s2.f3959a;
                    v2Var5.b(cVar3);
                }
                int a14 = cVar3.a();
                Object[] objArr = b11.f2390b;
                int[] iArr = b11.f2391c;
                long[] jArr = b11.f2389a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i18 = 0;
                    while (true) {
                        long j11 = jArr[i18];
                        long[] jArr2 = jArr;
                        if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i19 = 8;
                            int i20 = 8 - ((~(i18 - length)) >>> 31);
                            int i21 = 0;
                            while (i21 < i20) {
                                if ((j11 & 255) < 128) {
                                    int i22 = (i18 << 3) + i21;
                                    androidx.compose.runtime.snapshots.c0 c0Var = (androidx.compose.runtime.snapshots.c0) objArr[i22];
                                    cVar3.b(a14 + iArr[i22]);
                                    Function1 h12 = jVar.h();
                                    if (h12 != null) {
                                        h12.invoke(c0Var);
                                    }
                                    i12 = 8;
                                } else {
                                    i12 = i19;
                                }
                                j11 >>= i12;
                                i21++;
                                i19 = i12;
                                i13 = 1;
                            }
                            int i23 = i19;
                            i11 = i13;
                            if (i20 != i23) {
                                break;
                            }
                        } else {
                            i11 = i13;
                        }
                        if (i18 == length) {
                            break;
                        }
                        i18 += i11;
                        i13 = i11;
                        jArr = jArr2;
                    }
                }
                cVar3.b(a14);
                Unit unit2 = Unit.f67184a;
                int n15 = a13.n();
                if (n15 > 0) {
                    Object[] m15 = a13.m();
                    int i24 = 0;
                    do {
                        ((a0) m15[i24]).a(this);
                        i24++;
                    } while (i24 < n15);
                }
            } catch (Throwable th4) {
                int n16 = a13.n();
                if (n16 > 0) {
                    Object[] m16 = a13.m();
                    int i25 = 0;
                    do {
                        ((a0) m16[i25]).a(this);
                        i25++;
                    } while (i25 < n16);
                }
                throw th4;
            }
        }
        return aVar3;
    }

    private final String e() {
        a aVar = (a) SnapshotKt.F(this.f3679c);
        return aVar.k(this, androidx.compose.runtime.snapshots.j.f4079e.c()) ? String.valueOf(aVar.j()) : "<Not calculated>";
    }

    @Override // androidx.compose.runtime.z
    public z.a b() {
        androidx.compose.runtime.snapshots.j c11 = androidx.compose.runtime.snapshots.j.f4079e.c();
        return d((a) SnapshotKt.G(this.f3679c, c11), c11, false, this.f3677a);
    }

    public final androidx.compose.runtime.snapshots.e0 c(androidx.compose.runtime.snapshots.j jVar) {
        return d((a) SnapshotKt.G(this.f3679c, jVar), jVar, false, this.f3677a);
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 getFirstStateRecord() {
        return this.f3679c;
    }

    @Override // androidx.compose.runtime.z
    public q2 getPolicy() {
        return this.f3678b;
    }

    @Override // androidx.compose.runtime.a3
    public Object getValue() {
        j.a aVar = androidx.compose.runtime.snapshots.j.f4079e;
        Function1 h11 = aVar.c().h();
        if (h11 != null) {
            h11.invoke(this);
        }
        androidx.compose.runtime.snapshots.j c11 = aVar.c();
        return d((a) SnapshotKt.G(this.f3679c, c11), c11, true, this.f3677a).j();
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(androidx.compose.runtime.snapshots.e0 e0Var) {
        Intrinsics.f(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.f3679c = (a) e0Var;
    }

    public String toString() {
        return "DerivedState(value=" + e() + ")@" + hashCode();
    }
}
