package androidx.compose.runtime;

import androidx.collection.ScatterSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements g2, u1 {

    /* renamed from: h, reason: collision with root package name */
    public static final a f3700h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f3701i = 8;

    /* renamed from: a, reason: collision with root package name */
    private int f3702a;

    /* renamed from: b, reason: collision with root package name */
    private w1 f3703b;

    /* renamed from: c, reason: collision with root package name */
    private c f3704c;

    /* renamed from: d, reason: collision with root package name */
    private Function2 f3705d;

    /* renamed from: e, reason: collision with root package name */
    private int f3706e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.collection.k0 f3707f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.collection.n0 f3708g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(m2 m2Var, List list, w1 w1Var) {
            if (list.isEmpty()) {
                return;
            }
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object Y0 = m2Var.Y0((c) list.get(i11), 0);
                RecomposeScopeImpl recomposeScopeImpl = Y0 instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) Y0 : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.e(w1Var);
                }
            }
        }
    }

    public RecomposeScopeImpl(w1 w1Var) {
        this.f3703b = w1Var;
    }

    private final void F(boolean z10) {
        if (z10) {
            this.f3702a |= 32;
        } else {
            this.f3702a &= -33;
        }
    }

    private final void G(boolean z10) {
        if (z10) {
            this.f3702a |= 16;
        } else {
            this.f3702a &= -17;
        }
    }

    private final boolean f(z zVar, androidx.collection.n0 n0Var) {
        Intrinsics.f(zVar, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        q2 policy = zVar.getPolicy();
        if (policy == null) {
            policy = r2.j();
        }
        return !policy.b(zVar.b().a(), n0Var.b(zVar));
    }

    private final boolean o() {
        return (this.f3702a & 32) != 0;
    }

    public final void A(c cVar) {
        this.f3704c = cVar;
    }

    public final void B(boolean z10) {
        if (z10) {
            this.f3702a |= 2;
        } else {
            this.f3702a &= -3;
        }
    }

    public final void C(boolean z10) {
        if (z10) {
            this.f3702a |= 4;
        } else {
            this.f3702a &= -5;
        }
    }

    public final void D(boolean z10) {
        if (z10) {
            this.f3702a |= 64;
        } else {
            this.f3702a &= -65;
        }
    }

    public final void E(boolean z10) {
        if (z10) {
            this.f3702a |= 8;
        } else {
            this.f3702a &= -9;
        }
    }

    public final void H(boolean z10) {
        if (z10) {
            this.f3702a |= 1;
        } else {
            this.f3702a &= -2;
        }
    }

    public final void I(int i11) {
        this.f3706e = i11;
        G(false);
    }

    @Override // androidx.compose.runtime.g2
    public void a(Function2 function2) {
        this.f3705d = function2;
    }

    public final void e(w1 w1Var) {
        this.f3703b = w1Var;
    }

    public final void g(i iVar) {
        Unit unit;
        Function2 function2 = this.f3705d;
        if (function2 != null) {
            function2.invoke(iVar, 1);
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope");
        }
    }

    public final Function1 h(final int i11) {
        final androidx.collection.k0 k0Var = this.f3707f;
        if (k0Var == null || p()) {
            return null;
        }
        Object[] objArr = k0Var.f2390b;
        int[] iArr = k0Var.f2391c;
        long[] jArr = k0Var.f2389a;
        int length = jArr.length - 2;
        if (length < 0) {
            return null;
        }
        int i12 = 0;
        while (true) {
            long j11 = jArr[i12];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i13 = 8 - ((~(i12 - length)) >>> 31);
                for (int i14 = 0; i14 < i13; i14++) {
                    if ((255 & j11) < 128) {
                        int i15 = (i12 << 3) + i14;
                        Object obj = objArr[i15];
                        if (iArr[i15] != i11) {
                            return new Function1<l, Unit>() { // from class: androidx.compose.runtime.RecomposeScopeImpl$end$1$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((l) obj2);
                                    return Unit.f67184a;
                                }

                                public final void invoke(l lVar) {
                                    int i16;
                                    androidx.collection.k0 k0Var2;
                                    int i17;
                                    androidx.collection.n0 n0Var;
                                    i16 = RecomposeScopeImpl.this.f3706e;
                                    if (i16 != i11) {
                                        return;
                                    }
                                    androidx.collection.k0 k0Var3 = k0Var;
                                    k0Var2 = RecomposeScopeImpl.this.f3707f;
                                    if (!Intrinsics.c(k0Var3, k0Var2) || !(lVar instanceof o)) {
                                        return;
                                    }
                                    androidx.collection.k0 k0Var4 = k0Var;
                                    int i18 = i11;
                                    RecomposeScopeImpl recomposeScopeImpl = RecomposeScopeImpl.this;
                                    long[] jArr2 = k0Var4.f2389a;
                                    int length2 = jArr2.length - 2;
                                    if (length2 < 0) {
                                        return;
                                    }
                                    int i19 = 0;
                                    while (true) {
                                        long j12 = jArr2[i19];
                                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i20 = 8;
                                            int i21 = 8 - ((~(i19 - length2)) >>> 31);
                                            int i22 = 0;
                                            while (i22 < i21) {
                                                if ((255 & j12) < 128) {
                                                    int i23 = (i19 << 3) + i22;
                                                    Object obj2 = k0Var4.f2390b[i23];
                                                    boolean z10 = k0Var4.f2391c[i23] != i18;
                                                    if (z10) {
                                                        o oVar = (o) lVar;
                                                        oVar.J(obj2, recomposeScopeImpl);
                                                        if (obj2 instanceof z) {
                                                            oVar.I((z) obj2);
                                                            n0Var = recomposeScopeImpl.f3708g;
                                                            if (n0Var != null) {
                                                                n0Var.o(obj2);
                                                            }
                                                        }
                                                    }
                                                    if (z10) {
                                                        k0Var4.p(i23);
                                                    }
                                                    i17 = 8;
                                                } else {
                                                    i17 = i20;
                                                }
                                                j12 >>= i17;
                                                i22++;
                                                i20 = i17;
                                            }
                                            if (i21 != i20) {
                                                return;
                                            }
                                        }
                                        if (i19 == length2) {
                                            return;
                                        } else {
                                            i19++;
                                        }
                                    }
                                }
                            };
                        }
                    }
                    j11 >>= 8;
                }
                if (i13 != 8) {
                    return null;
                }
            }
            if (i12 == length) {
                return null;
            }
            i12++;
        }
    }

    public final c i() {
        return this.f3704c;
    }

    @Override // androidx.compose.runtime.u1
    public void invalidate() {
        w1 w1Var = this.f3703b;
        if (w1Var != null) {
            w1Var.k(this, null);
        }
    }

    public final boolean j() {
        return this.f3705d != null;
    }

    public final boolean k() {
        return (this.f3702a & 2) != 0;
    }

    public final boolean l() {
        return (this.f3702a & 4) != 0;
    }

    public final boolean m() {
        return (this.f3702a & 64) != 0;
    }

    public final boolean n() {
        return (this.f3702a & 8) != 0;
    }

    public final boolean p() {
        return (this.f3702a & 16) != 0;
    }

    public final boolean q() {
        return (this.f3702a & 1) != 0;
    }

    public final boolean r() {
        if (this.f3703b == null) {
            return false;
        }
        c cVar = this.f3704c;
        return cVar != null ? cVar.b() : false;
    }

    public final InvalidationResult s(Object obj) {
        InvalidationResult k11;
        w1 w1Var = this.f3703b;
        return (w1Var == null || (k11 = w1Var.k(this, obj)) == null) ? InvalidationResult.IGNORED : k11;
    }

    public final boolean t() {
        return this.f3708g != null;
    }

    public final boolean u(Object obj) {
        androidx.collection.n0 n0Var;
        if (obj == null || (n0Var = this.f3708g) == null) {
            return true;
        }
        if (obj instanceof z) {
            return f((z) obj, n0Var);
        }
        if (!(obj instanceof ScatterSet)) {
            return true;
        }
        ScatterSet scatterSet = (ScatterSet) obj;
        if (scatterSet.e()) {
            Object[] objArr = scatterSet.f2322b;
            long[] jArr = scatterSet.f2321a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                Object obj2 = objArr[(i11 << 3) + i13];
                                if (!(obj2 instanceof z) || f((z) obj2, n0Var)) {
                                    return true;
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            break;
                        }
                    }
                    if (i11 == length) {
                        break;
                    }
                    i11++;
                }
            }
        }
        return false;
    }

    public final void v(z zVar, Object obj) {
        androidx.collection.n0 n0Var = this.f3708g;
        if (n0Var == null) {
            n0Var = new androidx.collection.n0(0, 1, null);
            this.f3708g = n0Var;
        }
        n0Var.r(zVar, obj);
    }

    public final boolean w(Object obj) {
        if (o()) {
            return false;
        }
        androidx.collection.k0 k0Var = this.f3707f;
        if (k0Var == null) {
            k0Var = new androidx.collection.k0(0, 1, null);
            this.f3707f = k0Var;
        }
        return k0Var.o(obj, this.f3706e, -1) == this.f3706e;
    }

    public final void x() {
        w1 w1Var = this.f3703b;
        if (w1Var != null) {
            w1Var.h(this);
        }
        this.f3703b = null;
        this.f3707f = null;
        this.f3708g = null;
    }

    public final void y() {
        androidx.collection.k0 k0Var;
        w1 w1Var = this.f3703b;
        if (w1Var == null || (k0Var = this.f3707f) == null) {
            return;
        }
        F(true);
        try {
            Object[] objArr = k0Var.f2390b;
            int[] iArr = k0Var.f2391c;
            long[] jArr = k0Var.f2389a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                int i14 = (i11 << 3) + i13;
                                Object obj = objArr[i14];
                                int i15 = iArr[i14];
                                w1Var.a(obj);
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            break;
                        }
                    }
                    if (i11 == length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        } finally {
            F(false);
        }
    }

    public final void z() {
        G(true);
    }
}
