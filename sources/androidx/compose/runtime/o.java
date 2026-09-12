package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class o implements y, d2, w1 {

    /* renamed from: a, reason: collision with root package name */
    private final m f3908a;

    /* renamed from: b, reason: collision with root package name */
    private final f f3909b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicReference f3910c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f3911d;

    /* renamed from: e, reason: collision with root package name */
    private final Set f3912e;

    /* renamed from: f, reason: collision with root package name */
    private final j2 f3913f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.compose.runtime.collection.e f3914g;

    /* renamed from: h, reason: collision with root package name */
    private final MutableScatterSet f3915h;

    /* renamed from: i, reason: collision with root package name */
    private final MutableScatterSet f3916i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.compose.runtime.collection.e f3917j;

    /* renamed from: k, reason: collision with root package name */
    private final s.a f3918k;

    /* renamed from: l, reason: collision with root package name */
    private final s.a f3919l;

    /* renamed from: m, reason: collision with root package name */
    private final androidx.compose.runtime.collection.e f3920m;

    /* renamed from: n, reason: collision with root package name */
    private androidx.compose.runtime.collection.e f3921n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3922o;

    /* renamed from: p, reason: collision with root package name */
    private o f3923p;

    /* renamed from: q, reason: collision with root package name */
    private int f3924q;

    /* renamed from: r, reason: collision with root package name */
    private final u f3925r;

    /* renamed from: s, reason: collision with root package name */
    private final ComposerImpl f3926s;

    /* renamed from: t, reason: collision with root package name */
    private final CoroutineContext f3927t;

    /* renamed from: u, reason: collision with root package name */
    private final boolean f3928u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f3929v;

    /* renamed from: w, reason: collision with root package name */
    private Function2 f3930w;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements a2 {

        /* renamed from: a, reason: collision with root package name */
        private final Set f3931a;

        /* renamed from: e, reason: collision with root package name */
        private MutableScatterSet f3935e;

        /* renamed from: b, reason: collision with root package name */
        private final List f3932b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private final List f3933c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private final List f3934d = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        private final List f3936f = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        private final androidx.collection.d0 f3937g = new androidx.collection.d0(0, 1, null);

        /* renamed from: h, reason: collision with root package name */
        private final androidx.collection.d0 f3938h = new androidx.collection.d0(0, 1, null);

        public a(Set set) {
            this.f3931a = set;
        }

        private final void i(int i11) {
            int i12 = 0;
            if (this.f3936f.isEmpty()) {
                return;
            }
            int i13 = 0;
            List list = null;
            androidx.collection.d0 d0Var = null;
            androidx.collection.d0 d0Var2 = null;
            while (i13 < this.f3938h.b()) {
                if (i11 <= this.f3938h.a(i13)) {
                    Object remove = this.f3936f.remove(i13);
                    int i14 = this.f3938h.i(i13);
                    int i15 = this.f3937g.i(i13);
                    if (list == null) {
                        list = CollectionsKt.q(remove);
                        d0Var2 = new androidx.collection.d0(0, 1, null);
                        d0Var2.e(i14);
                        d0Var = new androidx.collection.d0(0, 1, null);
                        d0Var.e(i15);
                    } else {
                        Intrinsics.f(d0Var, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        Intrinsics.f(d0Var2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        list.add(remove);
                        d0Var2.e(i14);
                        d0Var.e(i15);
                    }
                } else {
                    i13++;
                }
            }
            if (list != null) {
                Intrinsics.f(d0Var, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                Intrinsics.f(d0Var2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                int size = list.size() - 1;
                while (i12 < size) {
                    int i16 = i12 + 1;
                    int size2 = list.size();
                    for (int i17 = i16; i17 < size2; i17++) {
                        int a11 = d0Var2.a(i12);
                        int a12 = d0Var2.a(i17);
                        if (a11 < a12 || (a12 == a11 && d0Var.a(i12) < d0Var.a(i17))) {
                            p.g(list, i12, i17);
                            p.f(d0Var, i12, i17);
                            p.f(d0Var2, i12, i17);
                        }
                    }
                    i12 = i16;
                }
                this.f3933c.addAll(list);
            }
        }

        private final void j(Object obj, int i11, int i12, int i13) {
            i(i11);
            if (i13 < 0 || i13 >= i11) {
                this.f3933c.add(obj);
                return;
            }
            this.f3936f.add(obj);
            this.f3937g.e(i12);
            this.f3938h.e(i13);
        }

        @Override // androidx.compose.runtime.a2
        public void a(Function0 function0) {
            this.f3934d.add(function0);
        }

        @Override // androidx.compose.runtime.a2
        public void b(h hVar, int i11, int i12, int i13) {
            MutableScatterSet mutableScatterSet = this.f3935e;
            if (mutableScatterSet == null) {
                mutableScatterSet = androidx.collection.w0.a();
                this.f3935e = mutableScatterSet;
            }
            mutableScatterSet.w(hVar);
            j(hVar, i11, i12, i13);
        }

        @Override // androidx.compose.runtime.a2
        public void c(b2 b2Var) {
            this.f3932b.add(b2Var);
        }

        @Override // androidx.compose.runtime.a2
        public void d(h hVar, int i11, int i12, int i13) {
            j(hVar, i11, i12, i13);
        }

        @Override // androidx.compose.runtime.a2
        public void e(b2 b2Var, int i11, int i12, int i13) {
            j(b2Var, i11, i12, i13);
        }

        public final void f() {
            if (this.f3931a.isEmpty()) {
                return;
            }
            Object a11 = e3.f3769a.a("Compose:abandons");
            try {
                Iterator it = this.f3931a.iterator();
                while (it.hasNext()) {
                    b2 b2Var = (b2) it.next();
                    it.remove();
                    b2Var.onAbandoned();
                }
                Unit unit = Unit.f67184a;
                e3.f3769a.b(a11);
            } catch (Throwable th2) {
                e3.f3769a.b(a11);
                throw th2;
            }
        }

        public final void g() {
            Object a11;
            i(Integer.MIN_VALUE);
            if (!this.f3933c.isEmpty()) {
                a11 = e3.f3769a.a("Compose:onForgotten");
                try {
                    MutableScatterSet mutableScatterSet = this.f3935e;
                    for (int size = this.f3933c.size() - 1; -1 < size; size--) {
                        Object obj = this.f3933c.get(size);
                        if (obj instanceof b2) {
                            this.f3931a.remove(obj);
                            ((b2) obj).onForgotten();
                        }
                        if (obj instanceof h) {
                            if (mutableScatterSet == null || !mutableScatterSet.a(obj)) {
                                ((h) obj).onDeactivate();
                            } else {
                                ((h) obj).onRelease();
                            }
                        }
                    }
                    Unit unit = Unit.f67184a;
                    e3.f3769a.b(a11);
                } finally {
                }
            }
            if (this.f3932b.isEmpty()) {
                return;
            }
            a11 = e3.f3769a.a("Compose:onRemembered");
            try {
                List list = this.f3932b;
                int size2 = list.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    b2 b2Var = (b2) list.get(i11);
                    this.f3931a.remove(b2Var);
                    b2Var.onRemembered();
                }
                Unit unit2 = Unit.f67184a;
                e3.f3769a.b(a11);
            } finally {
            }
        }

        public final void h() {
            if (this.f3934d.isEmpty()) {
                return;
            }
            Object a11 = e3.f3769a.a("Compose:sideeffects");
            try {
                List list = this.f3934d;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((Function0) list.get(i11)).invoke();
                }
                this.f3934d.clear();
                Unit unit = Unit.f67184a;
                e3.f3769a.b(a11);
            } catch (Throwable th2) {
                e3.f3769a.b(a11);
                throw th2;
            }
        }
    }

    public o(m mVar, f fVar, CoroutineContext coroutineContext) {
        this.f3908a = mVar;
        this.f3909b = fVar;
        this.f3910c = new AtomicReference(null);
        this.f3911d = new Object();
        Set l11 = new MutableScatterSet(0, 1, null).l();
        this.f3912e = l11;
        j2 j2Var = new j2();
        if (mVar.c()) {
            j2Var.h();
        }
        if (mVar.e()) {
            j2Var.j();
        }
        this.f3913f = j2Var;
        this.f3914g = new androidx.compose.runtime.collection.e();
        this.f3915h = new MutableScatterSet(0, 1, null);
        this.f3916i = new MutableScatterSet(0, 1, null);
        this.f3917j = new androidx.compose.runtime.collection.e();
        s.a aVar = new s.a();
        this.f3918k = aVar;
        s.a aVar2 = new s.a();
        this.f3919l = aVar2;
        this.f3920m = new androidx.compose.runtime.collection.e();
        this.f3921n = new androidx.compose.runtime.collection.e();
        this.f3925r = new u(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(fVar, mVar, j2Var, l11, aVar, aVar2, this);
        mVar.n(composerImpl);
        this.f3926s = composerImpl;
        this.f3927t = coroutineContext;
        this.f3928u = mVar instanceof Recomposer;
        this.f3930w = ComposableSingletons$CompositionKt.f3634a.a();
    }

    public /* synthetic */ o(m mVar, f fVar, CoroutineContext coroutineContext, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(mVar, fVar, (i11 & 4) != 0 ? null : coroutineContext);
    }

    private final void A(Function2 function2) {
        if (this.f3929v) {
            o1.b("The composition is disposed");
        }
        this.f3930w = function2;
        this.f3908a.a(this, function2);
    }

    private final void B() {
        Object obj;
        Object obj2;
        AtomicReference atomicReference = this.f3910c;
        obj = p.f3942a;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            obj2 = p.f3942a;
            if (Intrinsics.c(andSet, obj2)) {
                k.s("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                x((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                k.s("corrupt pendingModifications drain: " + this.f3910c);
                throw new KotlinNothingValueException();
            }
            for (Set set : (Set[]) andSet) {
                x(set, true);
            }
        }
    }

    private final void C() {
        Object obj;
        Object andSet = this.f3910c.getAndSet(null);
        obj = p.f3942a;
        if (Intrinsics.c(andSet, obj)) {
            return;
        }
        if (andSet instanceof Set) {
            x((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                x(set, false);
            }
            return;
        }
        if (andSet == null) {
            k.s("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        k.s("corrupt pendingModifications drain: " + this.f3910c);
        throw new KotlinNothingValueException();
    }

    private final boolean D() {
        return this.f3926s.z0();
    }

    private final InvalidationResult F(RecomposeScopeImpl recomposeScopeImpl, c cVar, Object obj) {
        int i11;
        synchronized (this.f3911d) {
            try {
                o oVar = this.f3923p;
                o oVar2 = null;
                if (oVar != null) {
                    if (!this.f3913f.v(this.f3924q, cVar)) {
                        oVar = null;
                    }
                    oVar2 = oVar;
                }
                if (oVar2 == null) {
                    if (L(recomposeScopeImpl, obj)) {
                        return InvalidationResult.IMMINENT;
                    }
                    H();
                    if (obj == null) {
                        this.f3921n.h(recomposeScopeImpl, f2.f3807a);
                    } else if (obj instanceof z) {
                        Object b11 = this.f3921n.d().b(recomposeScopeImpl);
                        if (b11 != null) {
                            if (b11 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) b11;
                                Object[] objArr = mutableScatterSet.f2322b;
                                long[] jArr = mutableScatterSet.f2321a;
                                int length = jArr.length - 2;
                                if (length >= 0) {
                                    int i12 = 0;
                                    loop0: while (true) {
                                        long j11 = jArr[i12];
                                        if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i13 = 8;
                                            int i14 = 8 - ((~(i12 - length)) >>> 31);
                                            int i15 = 0;
                                            while (i15 < i14) {
                                                if ((j11 & 255) >= 128) {
                                                    i11 = i13;
                                                } else {
                                                    if (objArr[(i12 << 3) + i15] == f2.f3807a) {
                                                        break loop0;
                                                    }
                                                    i11 = 8;
                                                }
                                                j11 >>= i11;
                                                i15++;
                                                i13 = i11;
                                            }
                                            if (i14 != i13) {
                                                break;
                                            }
                                        }
                                        if (i12 == length) {
                                            break;
                                        }
                                        i12++;
                                    }
                                }
                            } else if (b11 == f2.f3807a) {
                            }
                        }
                        this.f3921n.a(recomposeScopeImpl, obj);
                    } else {
                        this.f3921n.h(recomposeScopeImpl, f2.f3807a);
                    }
                }
                if (oVar2 != null) {
                    return oVar2.F(recomposeScopeImpl, cVar, obj);
                }
                this.f3908a.k(this);
                return o() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void G(Object obj) {
        Object b11 = this.f3914g.d().b(obj);
        if (b11 == null) {
            return;
        }
        if (!(b11 instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) b11;
            if (recomposeScopeImpl.s(obj) == InvalidationResult.IMMINENT) {
                this.f3920m.a(obj, recomposeScopeImpl);
                return;
            }
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) b11;
        Object[] objArr = mutableScatterSet.f2322b;
        long[] jArr = mutableScatterSet.f2321a;
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
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i11 << 3) + i13];
                        if (recomposeScopeImpl2.s(obj) == InvalidationResult.IMMINENT) {
                            this.f3920m.a(obj, recomposeScopeImpl2);
                        }
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

    private final androidx.compose.runtime.tooling.c H() {
        u uVar = this.f3925r;
        if (uVar.b()) {
            uVar.a();
        } else {
            u i11 = this.f3908a.i();
            if (i11 != null) {
                i11.a();
            }
            uVar.a();
            if (!Intrinsics.c(null, null)) {
                uVar.c(null);
            }
        }
        return null;
    }

    private final androidx.compose.runtime.collection.e K() {
        androidx.compose.runtime.collection.e eVar = this.f3921n;
        this.f3921n = new androidx.compose.runtime.collection.e();
        return eVar;
    }

    private final boolean L(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return o() && this.f3926s.o1(recomposeScopeImpl, obj);
    }

    private final void w(Object obj, boolean z10) {
        Object b11 = this.f3914g.d().b(obj);
        if (b11 == null) {
            return;
        }
        if (!(b11 instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) b11;
            if (this.f3920m.f(obj, recomposeScopeImpl) || recomposeScopeImpl.s(obj) == InvalidationResult.IGNORED) {
                return;
            }
            if (!recomposeScopeImpl.t() || z10) {
                this.f3915h.h(recomposeScopeImpl);
                return;
            } else {
                this.f3916i.h(recomposeScopeImpl);
                return;
            }
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) b11;
        Object[] objArr = mutableScatterSet.f2322b;
        long[] jArr = mutableScatterSet.f2321a;
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
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i11 << 3) + i13];
                        if (!this.f3920m.f(obj, recomposeScopeImpl2) && recomposeScopeImpl2.s(obj) != InvalidationResult.IGNORED) {
                            if (!recomposeScopeImpl2.t() || z10) {
                                this.f3915h.h(recomposeScopeImpl2);
                            } else {
                                this.f3916i.h(recomposeScopeImpl2);
                            }
                        }
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

    private final void x(Set set, boolean z10) {
        int i11;
        long[] jArr;
        String str;
        int i12;
        long[] jArr2;
        int i13;
        int i14;
        String str2;
        int i15;
        boolean a11;
        Object[] objArr;
        long[] jArr3;
        Object[] objArr2;
        long[] jArr4;
        String str3;
        long[] jArr5;
        int i16;
        String str4;
        long[] jArr6;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z11;
        Object[] objArr3;
        long[] jArr7;
        Object[] objArr4;
        long[] jArr8;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        char c11 = 7;
        long j11 = -9187201950435737472L;
        int i27 = 8;
        if (set instanceof ScatterSetWrapper) {
            ScatterSet a12 = ((ScatterSetWrapper) set).a();
            Object[] objArr5 = a12.f2322b;
            long[] jArr9 = a12.f2321a;
            int length = jArr9.length - 2;
            if (length >= 0) {
                int i28 = 0;
                while (true) {
                    long j12 = jArr9[i28];
                    if ((((~j12) << c11) & j12 & j11) != j11) {
                        int i29 = 8 - ((~(i28 - length)) >>> 31);
                        int i30 = 0;
                        while (i30 < i29) {
                            if ((j12 & 255) < 128) {
                                Object obj = objArr5[(i28 << 3) + i30];
                                if (obj instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj).s(null);
                                } else {
                                    w(obj, z10);
                                    Object b11 = this.f3917j.d().b(obj);
                                    if (b11 != null) {
                                        if (b11 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) b11;
                                            Object[] objArr6 = mutableScatterSet.f2322b;
                                            long[] jArr10 = mutableScatterSet.f2321a;
                                            int length2 = jArr10.length - 2;
                                            if (length2 >= 0) {
                                                i24 = length;
                                                i25 = i28;
                                                int i31 = 0;
                                                while (true) {
                                                    long j13 = jArr10[i31];
                                                    i22 = i29;
                                                    i23 = i30;
                                                    if ((((~j13) << c11) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i32 = 8 - ((~(i31 - length2)) >>> 31);
                                                        for (int i33 = 0; i33 < i32; i33++) {
                                                            if ((j13 & 255) < 128) {
                                                                w((z) objArr6[(i31 << 3) + i33], z10);
                                                            }
                                                            j13 >>= 8;
                                                        }
                                                        if (i32 != 8) {
                                                            break;
                                                        }
                                                    }
                                                    if (i31 == length2) {
                                                        break;
                                                    }
                                                    i31++;
                                                    i29 = i22;
                                                    i30 = i23;
                                                    c11 = 7;
                                                }
                                            }
                                        } else {
                                            i22 = i29;
                                            i23 = i30;
                                            i24 = length;
                                            i25 = i28;
                                            w((z) b11, z10);
                                        }
                                        i26 = 8;
                                    }
                                }
                                i22 = i29;
                                i23 = i30;
                                i24 = length;
                                i25 = i28;
                                i26 = 8;
                            } else {
                                i22 = i29;
                                i23 = i30;
                                i24 = length;
                                i25 = i28;
                                i26 = i27;
                            }
                            j12 >>= i26;
                            i30 = i23 + 1;
                            length = i24;
                            i27 = i26;
                            i28 = i25;
                            i29 = i22;
                            c11 = 7;
                        }
                        int i34 = length;
                        i21 = i28;
                        if (i29 != i27) {
                            break;
                        } else {
                            length = i34;
                        }
                    } else {
                        i21 = i28;
                    }
                    if (i21 == length) {
                        break;
                    }
                    i28 = i21 + 1;
                    c11 = 7;
                    j11 = -9187201950435737472L;
                    i27 = 8;
                }
            }
        } else {
            for (Object obj2 : set) {
                if (obj2 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj2).s(null);
                } else {
                    w(obj2, z10);
                    Object b12 = this.f3917j.d().b(obj2);
                    if (b12 != null) {
                        if (b12 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) b12;
                            Object[] objArr7 = mutableScatterSet2.f2322b;
                            long[] jArr11 = mutableScatterSet2.f2321a;
                            int length3 = jArr11.length - 2;
                            if (length3 >= 0) {
                                while (true) {
                                    long j14 = jArr11[i11];
                                    if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i35 = 8 - ((~(i11 - length3)) >>> 31);
                                        for (int i36 = 0; i36 < i35; i36++) {
                                            if ((j14 & 255) < 128) {
                                                w((z) objArr7[(i11 << 3) + i36], z10);
                                            }
                                            j14 >>= 8;
                                        }
                                        if (i35 != 8) {
                                            break;
                                        }
                                    }
                                    i11 = i11 != length3 ? i11 + 1 : 0;
                                }
                            }
                        } else {
                            w((z) b12, z10);
                        }
                    }
                }
            }
        }
        MutableScatterSet mutableScatterSet3 = this.f3916i;
        MutableScatterSet mutableScatterSet4 = this.f3915h;
        String str5 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
        if (!z10 || !mutableScatterSet3.e()) {
            String str6 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
            if (mutableScatterSet4.e()) {
                androidx.collection.n0 d11 = this.f3914g.d();
                long[] jArr12 = d11.f2419a;
                int length4 = jArr12.length - 2;
                if (length4 >= 0) {
                    int i37 = 0;
                    while (true) {
                        long j15 = jArr12[i37];
                        if ((((~j15) << 7) & j15 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i38 = 8 - ((~(i37 - length4)) >>> 31);
                            int i39 = 0;
                            while (i39 < i38) {
                                if ((j15 & 255) < 128) {
                                    int i40 = (i37 << 3) + i39;
                                    Object obj3 = d11.f2420b[i40];
                                    Object obj4 = d11.f2421c[i40];
                                    if (obj4 instanceof MutableScatterSet) {
                                        String str7 = str6;
                                        Intrinsics.f(obj4, str7);
                                        MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj4;
                                        Object[] objArr8 = mutableScatterSet5.f2322b;
                                        long[] jArr13 = mutableScatterSet5.f2321a;
                                        int length5 = jArr13.length - 2;
                                        jArr2 = jArr12;
                                        i13 = length4;
                                        i15 = i37;
                                        if (length5 >= 0) {
                                            int i41 = 0;
                                            while (true) {
                                                long j16 = jArr13[i41];
                                                str2 = str7;
                                                i14 = i38;
                                                if ((((~j16) << 7) & j16 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i42 = 8 - ((~(i41 - length5)) >>> 31);
                                                    int i43 = 0;
                                                    while (i43 < i42) {
                                                        if ((j16 & 255) < 128) {
                                                            jArr4 = jArr13;
                                                            int i44 = (i41 << 3) + i43;
                                                            objArr2 = objArr8;
                                                            if (mutableScatterSet4.a((RecomposeScopeImpl) objArr8[i44])) {
                                                                mutableScatterSet5.y(i44);
                                                            }
                                                        } else {
                                                            objArr2 = objArr8;
                                                            jArr4 = jArr13;
                                                        }
                                                        j16 >>= 8;
                                                        i43++;
                                                        jArr13 = jArr4;
                                                        objArr8 = objArr2;
                                                    }
                                                    objArr = objArr8;
                                                    jArr3 = jArr13;
                                                    if (i42 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    objArr = objArr8;
                                                    jArr3 = jArr13;
                                                }
                                                if (i41 == length5) {
                                                    break;
                                                }
                                                i41++;
                                                i38 = i14;
                                                str7 = str2;
                                                jArr13 = jArr3;
                                                objArr8 = objArr;
                                            }
                                        } else {
                                            str2 = str7;
                                            i14 = i38;
                                        }
                                        a11 = mutableScatterSet5.d();
                                    } else {
                                        jArr2 = jArr12;
                                        i13 = length4;
                                        i14 = i38;
                                        str2 = str6;
                                        i15 = i37;
                                        Intrinsics.f(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                        a11 = mutableScatterSet4.a((RecomposeScopeImpl) obj4);
                                    }
                                    if (a11) {
                                        d11.p(i40);
                                    }
                                } else {
                                    jArr2 = jArr12;
                                    i13 = length4;
                                    i14 = i38;
                                    str2 = str6;
                                    i15 = i37;
                                }
                                j15 >>= 8;
                                i39++;
                                length4 = i13;
                                jArr12 = jArr2;
                                i37 = i15;
                                i38 = i14;
                                str6 = str2;
                            }
                            jArr = jArr12;
                            int i45 = length4;
                            str = str6;
                            int i46 = i37;
                            if (i38 != 8) {
                                break;
                            }
                            length4 = i45;
                            i12 = i46;
                        } else {
                            jArr = jArr12;
                            str = str6;
                            i12 = i37;
                        }
                        if (i12 == length4) {
                            break;
                        }
                        i37 = i12 + 1;
                        jArr12 = jArr;
                        str6 = str;
                    }
                }
                z();
                mutableScatterSet4.m();
                return;
            }
            return;
        }
        androidx.collection.n0 d12 = this.f3914g.d();
        long[] jArr14 = d12.f2419a;
        int length6 = jArr14.length - 2;
        if (length6 >= 0) {
            int i47 = 0;
            while (true) {
                long j17 = jArr14[i47];
                if ((((~j17) << 7) & j17 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i48 = 8 - ((~(i47 - length6)) >>> 31);
                    int i49 = 0;
                    while (i49 < i48) {
                        if ((j17 & 255) < 128) {
                            int i50 = (i47 << 3) + i49;
                            Object obj5 = d12.f2420b[i50];
                            Object obj6 = d12.f2421c[i50];
                            if (obj6 instanceof MutableScatterSet) {
                                Intrinsics.f(obj6, str5);
                                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj6;
                                Object[] objArr9 = mutableScatterSet6.f2322b;
                                jArr6 = jArr14;
                                long[] jArr15 = mutableScatterSet6.f2321a;
                                str4 = str5;
                                int length7 = jArr15.length - 2;
                                i17 = length6;
                                i18 = i47;
                                if (length7 >= 0) {
                                    int i51 = 0;
                                    while (true) {
                                        long j18 = jArr15[i51];
                                        i19 = i48;
                                        i20 = i49;
                                        if ((((~j18) << 7) & j18 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i52 = 8 - ((~(i51 - length7)) >>> 31);
                                            int i53 = 0;
                                            while (i53 < i52) {
                                                if ((j18 & 255) < 128) {
                                                    jArr8 = jArr15;
                                                    int i54 = (i51 << 3) + i53;
                                                    objArr4 = objArr9;
                                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr9[i54];
                                                    if (mutableScatterSet3.a(recomposeScopeImpl) || mutableScatterSet4.a(recomposeScopeImpl)) {
                                                        mutableScatterSet6.y(i54);
                                                    }
                                                } else {
                                                    objArr4 = objArr9;
                                                    jArr8 = jArr15;
                                                }
                                                j18 >>= 8;
                                                i53++;
                                                jArr15 = jArr8;
                                                objArr9 = objArr4;
                                            }
                                            objArr3 = objArr9;
                                            jArr7 = jArr15;
                                            if (i52 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr3 = objArr9;
                                            jArr7 = jArr15;
                                        }
                                        if (i51 == length7) {
                                            break;
                                        }
                                        i51++;
                                        i48 = i19;
                                        i49 = i20;
                                        jArr15 = jArr7;
                                        objArr9 = objArr3;
                                    }
                                } else {
                                    i19 = i48;
                                    i20 = i49;
                                }
                                z11 = mutableScatterSet6.d();
                            } else {
                                str4 = str5;
                                jArr6 = jArr14;
                                i17 = length6;
                                i18 = i47;
                                i19 = i48;
                                i20 = i49;
                                Intrinsics.f(obj6, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj6;
                                z11 = mutableScatterSet3.a(recomposeScopeImpl2) || mutableScatterSet4.a(recomposeScopeImpl2);
                            }
                            if (z11) {
                                d12.p(i50);
                            }
                        } else {
                            str4 = str5;
                            jArr6 = jArr14;
                            i17 = length6;
                            i18 = i47;
                            i19 = i48;
                            i20 = i49;
                        }
                        j17 >>= 8;
                        i49 = i20 + 1;
                        length6 = i17;
                        jArr14 = jArr6;
                        str5 = str4;
                        i47 = i18;
                        i48 = i19;
                    }
                    str3 = str5;
                    jArr5 = jArr14;
                    int i55 = length6;
                    int i56 = i47;
                    if (i48 != 8) {
                        break;
                    }
                    length6 = i55;
                    i16 = i56;
                } else {
                    str3 = str5;
                    jArr5 = jArr14;
                    i16 = i47;
                }
                if (i16 == length6) {
                    break;
                }
                i47 = i16 + 1;
                jArr14 = jArr5;
                str5 = str3;
            }
        }
        mutableScatterSet3.m();
        z();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void y(s.a r31) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.o.y(s.a):void");
    }

    private final void z() {
        long[] jArr;
        int i11;
        long[] jArr2;
        int i12;
        int i13;
        int i14;
        boolean z10;
        Object[] objArr;
        long[] jArr3;
        long[] jArr4;
        androidx.collection.n0 d11 = this.f3917j.d();
        long[] jArr5 = d11.f2419a;
        int length = jArr5.length - 2;
        char c11 = 7;
        long j11 = -9187201950435737472L;
        int i15 = 8;
        if (length >= 0) {
            int i16 = 0;
            while (true) {
                long j12 = jArr5[i16];
                if ((((~j12) << c11) & j12 & j11) != j11) {
                    int i17 = 8 - ((~(i16 - length)) >>> 31);
                    int i18 = 0;
                    while (i18 < i17) {
                        if ((j12 & 255) < 128) {
                            int i19 = (i16 << 3) + i18;
                            Object obj = d11.f2420b[i19];
                            Object obj2 = d11.f2421c[i19];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.f(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr2 = mutableScatterSet.f2322b;
                                long[] jArr6 = mutableScatterSet.f2321a;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                i12 = length;
                                if (length2 >= 0) {
                                    int i20 = 0;
                                    while (true) {
                                        long j13 = jArr6[i20];
                                        i13 = i16;
                                        Object[] objArr3 = objArr2;
                                        if ((((~j13) << c11) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i21 = 8 - ((~(i20 - length2)) >>> 31);
                                            int i22 = 0;
                                            while (i22 < i21) {
                                                int i23 = i22;
                                                Object[] objArr4 = objArr3;
                                                if ((j13 & 255) < 128) {
                                                    int i24 = (i20 << 3) + i23;
                                                    jArr4 = jArr6;
                                                    if (!this.f3914g.c((z) objArr4[i24])) {
                                                        mutableScatterSet.y(i24);
                                                    }
                                                } else {
                                                    jArr4 = jArr6;
                                                }
                                                j13 >>= 8;
                                                i22 = i23 + 1;
                                                jArr6 = jArr4;
                                                objArr3 = objArr4;
                                            }
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            if (i21 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                        }
                                        if (i20 == length2) {
                                            break;
                                        }
                                        i20++;
                                        jArr6 = jArr3;
                                        objArr2 = objArr;
                                        i16 = i13;
                                        c11 = 7;
                                    }
                                } else {
                                    i13 = i16;
                                }
                                z10 = mutableScatterSet.d();
                            } else {
                                jArr2 = jArr5;
                                i12 = length;
                                i13 = i16;
                                Intrinsics.f(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                z10 = !this.f3914g.c((z) obj2);
                            }
                            if (z10) {
                                d11.p(i19);
                            }
                            i14 = 8;
                        } else {
                            jArr2 = jArr5;
                            i12 = length;
                            i13 = i16;
                            i14 = i15;
                        }
                        j12 >>= i14;
                        i18++;
                        i15 = i14;
                        jArr5 = jArr2;
                        length = i12;
                        i16 = i13;
                        c11 = 7;
                    }
                    jArr = jArr5;
                    int i25 = length;
                    int i26 = i16;
                    if (i17 != i15) {
                        break;
                    }
                    length = i25;
                    i11 = i26;
                } else {
                    jArr = jArr5;
                    i11 = i16;
                }
                if (i11 == length) {
                    break;
                }
                i16 = i11 + 1;
                jArr5 = jArr;
                c11 = 7;
                j11 = -9187201950435737472L;
                i15 = 8;
            }
        }
        if (!this.f3916i.e()) {
            return;
        }
        MutableScatterSet mutableScatterSet2 = this.f3916i;
        Object[] objArr5 = mutableScatterSet2.f2322b;
        long[] jArr7 = mutableScatterSet2.f2321a;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i27 = 0;
        while (true) {
            long j14 = jArr7[i27];
            if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i28 = 8 - ((~(i27 - length3)) >>> 31);
                for (int i29 = 0; i29 < i28; i29++) {
                    if ((j14 & 255) < 128) {
                        int i30 = (i27 << 3) + i29;
                        if (!((RecomposeScopeImpl) objArr5[i30]).t()) {
                            mutableScatterSet2.y(i30);
                        }
                    }
                    j14 >>= 8;
                }
                if (i28 != 8) {
                    return;
                }
            }
            if (i27 == length3) {
                return;
            } else {
                i27++;
            }
        }
    }

    public final u E() {
        return this.f3925r;
    }

    public final void I(z zVar) {
        if (this.f3914g.c(zVar)) {
            return;
        }
        this.f3917j.g(zVar);
    }

    public final void J(Object obj, RecomposeScopeImpl recomposeScopeImpl) {
        this.f3914g.f(obj, recomposeScopeImpl);
    }

    @Override // androidx.compose.runtime.y, androidx.compose.runtime.w1
    public void a(Object obj) {
        RecomposeScopeImpl B0;
        long[] jArr;
        long[] jArr2;
        int i11;
        if (D() || (B0 = this.f3926s.B0()) == null) {
            return;
        }
        B0.H(true);
        if (B0.w(obj)) {
            return;
        }
        if (obj instanceof androidx.compose.runtime.snapshots.d0) {
            ((androidx.compose.runtime.snapshots.d0) obj).m101recordReadInh_f27i8$runtime_release(androidx.compose.runtime.snapshots.f.a(1));
        }
        this.f3914g.a(obj, B0);
        if (obj instanceof z) {
            z zVar = (z) obj;
            z.a b11 = zVar.b();
            this.f3917j.g(obj);
            androidx.collection.p0 b12 = b11.b();
            Object[] objArr = b12.f2390b;
            long[] jArr3 = b12.f2389a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i12 = 0;
                while (true) {
                    long j11 = jArr3[i12];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i13 = 8;
                        int i14 = 8 - ((~(i12 - length)) >>> 31);
                        int i15 = 0;
                        while (i15 < i14) {
                            if ((j11 & 255) < 128) {
                                androidx.compose.runtime.snapshots.c0 c0Var = (androidx.compose.runtime.snapshots.c0) objArr[(i12 << 3) + i15];
                                if (c0Var instanceof androidx.compose.runtime.snapshots.d0) {
                                    jArr2 = jArr3;
                                    ((androidx.compose.runtime.snapshots.d0) c0Var).m101recordReadInh_f27i8$runtime_release(androidx.compose.runtime.snapshots.f.a(1));
                                } else {
                                    jArr2 = jArr3;
                                }
                                this.f3917j.a(c0Var, obj);
                                i11 = 8;
                            } else {
                                jArr2 = jArr3;
                                i11 = i13;
                            }
                            j11 >>= i11;
                            i15++;
                            i13 = i11;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i14 != i13) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i12 == length) {
                        break;
                    }
                    i12++;
                    jArr3 = jArr;
                }
            }
            B0.v(zVar, b11.a());
        }
    }

    @Override // androidx.compose.runtime.y
    public void b(Function2 function2) {
        try {
            synchronized (this.f3911d) {
                B();
                androidx.compose.runtime.collection.e K = K();
                try {
                    H();
                    this.f3926s.g0(K, function2);
                } catch (Exception e11) {
                    this.f3921n = K;
                    throw e11;
                }
            }
        } catch (Throwable th2) {
            try {
                if (!this.f3912e.isEmpty()) {
                    new a(this.f3912e).f();
                }
                throw th2;
            } catch (Exception e12) {
                s();
                throw e12;
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public void c() {
        synchronized (this.f3911d) {
            try {
                if (this.f3919l.d()) {
                    y(this.f3919l);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                try {
                    try {
                        if (!this.f3912e.isEmpty()) {
                            new a(this.f3912e).f();
                        }
                        throw th2;
                    } catch (Exception e11) {
                        s();
                        throw e11;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.l
    public void d(Function2 function2) {
        A(function2);
    }

    @Override // androidx.compose.runtime.d2
    public void deactivate() {
        e3 e3Var;
        Object a11;
        synchronized (this.f3911d) {
            try {
                boolean z10 = this.f3913f.p() > 0;
                try {
                    if (!z10) {
                        if (!this.f3912e.isEmpty()) {
                        }
                        this.f3914g.b();
                        this.f3917j.b();
                        this.f3921n.b();
                        this.f3918k.a();
                        this.f3919l.a();
                        this.f3926s.l0();
                        Unit unit = Unit.f67184a;
                    }
                    a aVar = new a(this.f3912e);
                    if (z10) {
                        this.f3909b.k();
                        m2 x10 = this.f3913f.x();
                        try {
                            k.t(x10, aVar);
                            Unit unit2 = Unit.f67184a;
                            x10.L(true);
                            this.f3909b.h();
                            aVar.g();
                        } catch (Throwable th2) {
                            x10.L(false);
                            throw th2;
                        }
                    }
                    aVar.f();
                    Unit unit3 = Unit.f67184a;
                    e3Var.b(a11);
                    this.f3914g.b();
                    this.f3917j.b();
                    this.f3921n.b();
                    this.f3918k.a();
                    this.f3919l.a();
                    this.f3926s.l0();
                    Unit unit4 = Unit.f67184a;
                } catch (Throwable th3) {
                    e3.f3769a.b(a11);
                    throw th3;
                }
                e3Var = e3.f3769a;
                a11 = e3Var.a("Compose:deactivate");
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    @Override // androidx.compose.runtime.l
    public void dispose() {
        synchronized (this.f3911d) {
            try {
                if (this.f3926s.K0()) {
                    o1.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (!this.f3929v) {
                    this.f3929v = true;
                    this.f3930w = ComposableSingletons$CompositionKt.f3634a.b();
                    s.a C0 = this.f3926s.C0();
                    if (C0 != null) {
                        y(C0);
                    }
                    boolean z10 = this.f3913f.p() > 0;
                    if (z10 || !this.f3912e.isEmpty()) {
                        a aVar = new a(this.f3912e);
                        if (z10) {
                            this.f3909b.k();
                            m2 x10 = this.f3913f.x();
                            try {
                                k.K(x10, aVar);
                                Unit unit = Unit.f67184a;
                                x10.L(true);
                                this.f3909b.clear();
                                this.f3909b.h();
                                aVar.g();
                            } catch (Throwable th2) {
                                x10.L(false);
                                throw th2;
                            }
                        }
                        aVar.f();
                    }
                    this.f3926s.m0();
                }
                Unit unit2 = Unit.f67184a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        this.f3908a.r(this);
    }

    @Override // androidx.compose.runtime.y
    public void e(x0 x0Var) {
        a aVar = new a(this.f3912e);
        m2 x10 = x0Var.a().x();
        try {
            k.K(x10, aVar);
            Unit unit = Unit.f67184a;
            x10.L(true);
            aVar.g();
        } catch (Throwable th2) {
            x10.L(false);
            throw th2;
        }
    }

    @Override // androidx.compose.runtime.y
    public void f(List list) {
        boolean z10 = true;
        int size = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            if (!Intrinsics.c(((y0) ((Pair) list.get(i11)).getFirst()).b(), this)) {
                z10 = false;
                break;
            }
            i11++;
        }
        k.O(z10);
        try {
            this.f3926s.H0(list);
            Unit unit = Unit.f67184a;
        } finally {
        }
    }

    @Override // androidx.compose.runtime.y
    public Object g(y yVar, int i11, Function0 function0) {
        if (yVar == null || Intrinsics.c(yVar, this) || i11 < 0) {
            return function0.invoke();
        }
        this.f3923p = (o) yVar;
        this.f3924q = i11;
        try {
            return function0.invoke();
        } finally {
            this.f3923p = null;
            this.f3924q = 0;
        }
    }

    @Override // androidx.compose.runtime.w1
    public void h(RecomposeScopeImpl recomposeScopeImpl) {
        this.f3922o = true;
    }

    @Override // androidx.compose.runtime.y
    public boolean i() {
        boolean R0;
        synchronized (this.f3911d) {
            try {
                B();
                try {
                    androidx.compose.runtime.collection.e K = K();
                    try {
                        H();
                        R0 = this.f3926s.R0(K);
                        if (!R0) {
                            C();
                        }
                    } catch (Exception e11) {
                        this.f3921n = K;
                        throw e11;
                    }
                } catch (Throwable th2) {
                    try {
                        if (!this.f3912e.isEmpty()) {
                            new a(this.f3912e).f();
                        }
                        throw th2;
                    } catch (Exception e12) {
                        s();
                        throw e12;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return R0;
    }

    @Override // androidx.compose.runtime.l
    public boolean isDisposed() {
        return this.f3929v;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    @Override // androidx.compose.runtime.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j(java.util.Set r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5c
            androidx.compose.runtime.collection.ScatterSetWrapper r15 = (androidx.compose.runtime.collection.ScatterSetWrapper) r15
            androidx.collection.ScatterSet r15 = r15.a()
            java.lang.Object[] r0 = r15.f2322b
            long[] r15 = r15.f2321a
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7d
            r4 = r1
        L16:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L30:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.32E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.compose.runtime.collection.e r11 = r14.f3914g
            boolean r11 = r11.c(r10)
            if (r11 != 0) goto L50
            androidx.compose.runtime.collection.e r11 = r14.f3917j
            boolean r10 = r11.c(r10)
            if (r10 == 0) goto L51
        L50:
            return r2
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L55:
            if (r7 != r8) goto L7d
        L57:
            if (r4 == r3) goto L7d
            int r4 = r4 + 1
            goto L16
        L5c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L62:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r15.next()
            androidx.compose.runtime.collection.e r3 = r14.f3914g
            boolean r3 = r3.c(r0)
            if (r3 != 0) goto L7c
            androidx.compose.runtime.collection.e r3 = r14.f3917j
            boolean r0 = r3.c(r0)
            if (r0 == 0) goto L62
        L7c:
            return r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.o.j(java.util.Set):boolean");
    }

    @Override // androidx.compose.runtime.w1
    public InvalidationResult k(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        o oVar;
        if (recomposeScopeImpl.k()) {
            recomposeScopeImpl.C(true);
        }
        c i11 = recomposeScopeImpl.i();
        if (i11 == null || !i11.b()) {
            return InvalidationResult.IGNORED;
        }
        if (this.f3913f.y(i11)) {
            return !recomposeScopeImpl.j() ? InvalidationResult.IGNORED : F(recomposeScopeImpl, i11, obj);
        }
        synchronized (this.f3911d) {
            oVar = this.f3923p;
        }
        return (oVar == null || !oVar.L(recomposeScopeImpl, obj)) ? InvalidationResult.IGNORED : InvalidationResult.IMMINENT;
    }

    @Override // androidx.compose.runtime.y
    public void l(Function0 function0) {
        this.f3926s.P0(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.y
    public void m(Set set) {
        Object obj;
        Object obj2;
        boolean c11;
        Set set2;
        do {
            obj = this.f3910c.get();
            if (obj == null) {
                c11 = true;
            } else {
                obj2 = p.f3942a;
                c11 = Intrinsics.c(obj, obj2);
            }
            if (c11) {
                set2 = set;
            } else if (obj instanceof Set) {
                set2 = new Set[]{obj, set};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.f3910c).toString());
                }
                Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                set2 = ArraysKt.E((Set[]) obj, set);
            }
        } while (!androidx.compose.animation.core.j0.a(this.f3910c, obj, set2));
        if (obj == null) {
            synchronized (this.f3911d) {
                C();
                Unit unit = Unit.f67184a;
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public void n() {
        synchronized (this.f3911d) {
            try {
                y(this.f3918k);
                C();
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                try {
                    try {
                        if (!this.f3912e.isEmpty()) {
                            new a(this.f3912e).f();
                        }
                        throw th2;
                    } catch (Exception e11) {
                        s();
                        throw e11;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public boolean o() {
        return this.f3926s.K0();
    }

    @Override // androidx.compose.runtime.d2
    public void p(Function2 function2) {
        this.f3926s.m1();
        A(function2);
        this.f3926s.s0();
    }

    @Override // androidx.compose.runtime.y
    public void q(Object obj) {
        synchronized (this.f3911d) {
            try {
                G(obj);
                Object b11 = this.f3917j.d().b(obj);
                if (b11 != null) {
                    if (b11 instanceof MutableScatterSet) {
                        MutableScatterSet mutableScatterSet = (MutableScatterSet) b11;
                        Object[] objArr = mutableScatterSet.f2322b;
                        long[] jArr = mutableScatterSet.f2321a;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i11 = 0;
                            while (true) {
                                long j11 = jArr[i11];
                                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                                    for (int i13 = 0; i13 < i12; i13++) {
                                        if ((255 & j11) < 128) {
                                            G((z) objArr[(i11 << 3) + i13]);
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
                    } else {
                        G((z) b11);
                    }
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.l
    public boolean r() {
        boolean z10;
        synchronized (this.f3911d) {
            z10 = this.f3921n.e() > 0;
        }
        return z10;
    }

    @Override // androidx.compose.runtime.y
    public void s() {
        this.f3910c.set(null);
        this.f3918k.a();
        this.f3919l.a();
        if (this.f3912e.isEmpty()) {
            return;
        }
        new a(this.f3912e).f();
    }

    @Override // androidx.compose.runtime.y
    public void t() {
        synchronized (this.f3911d) {
            try {
                this.f3926s.d0();
                if (!this.f3912e.isEmpty()) {
                    new a(this.f3912e).f();
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                try {
                    try {
                        if (!this.f3912e.isEmpty()) {
                            new a(this.f3912e).f();
                        }
                        throw th2;
                    } catch (Exception e11) {
                        s();
                        throw e11;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public void u() {
        synchronized (this.f3911d) {
            try {
                for (Object obj : this.f3913f.q()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
