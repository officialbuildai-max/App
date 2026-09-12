package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.k0;
import androidx.collection.n0;
import androidx.collection.p0;
import androidx.compose.animation.core.j0;
import androidx.compose.runtime.o1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.runtime.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
public final class SnapshotStateObserver {

    /* renamed from: k, reason: collision with root package name */
    public static final int f4013k = 8;

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f4014a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4016c;

    /* renamed from: g, reason: collision with root package name */
    private e f4020g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4021h;

    /* renamed from: i, reason: collision with root package name */
    private a f4022i;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference f4015b = new AtomicReference(null);

    /* renamed from: d, reason: collision with root package name */
    private final Function2 f4017d = new Function2<Set<? extends Object>, j, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Set<? extends Object>) obj, (j) obj2);
            return Unit.f67184a;
        }

        public final void invoke(Set<? extends Object> set, j jVar) {
            boolean m11;
            SnapshotStateObserver.this.i(set);
            m11 = SnapshotStateObserver.this.m();
            if (m11) {
                SnapshotStateObserver.this.r();
            }
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final Function1 f4018e = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m98invoke(obj);
            return Unit.f67184a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m98invoke(Object obj) {
            boolean z10;
            androidx.compose.runtime.collection.b bVar;
            SnapshotStateObserver.a aVar;
            z10 = SnapshotStateObserver.this.f4021h;
            if (z10) {
                return;
            }
            bVar = SnapshotStateObserver.this.f4019f;
            SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
            synchronized (bVar) {
                aVar = snapshotStateObserver.f4022i;
                Intrinsics.e(aVar);
                aVar.k(obj);
                Unit unit = Unit.f67184a;
            }
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f4019f = new androidx.compose.runtime.collection.b(new a[16], 0);

    /* renamed from: j, reason: collision with root package name */
    private long f4023j = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Function1 f4024a;

        /* renamed from: b, reason: collision with root package name */
        private Object f4025b;

        /* renamed from: c, reason: collision with root package name */
        private k0 f4026c;

        /* renamed from: j, reason: collision with root package name */
        private int f4033j;

        /* renamed from: d, reason: collision with root package name */
        private int f4027d = -1;

        /* renamed from: e, reason: collision with root package name */
        private final androidx.compose.runtime.collection.e f4028e = new androidx.compose.runtime.collection.e();

        /* renamed from: f, reason: collision with root package name */
        private final n0 f4029f = new n0(0, 1, null);

        /* renamed from: g, reason: collision with root package name */
        private final MutableScatterSet f4030g = new MutableScatterSet(0, 1, null);

        /* renamed from: h, reason: collision with root package name */
        private final androidx.compose.runtime.collection.b f4031h = new androidx.compose.runtime.collection.b(new androidx.compose.runtime.z[16], 0);

        /* renamed from: i, reason: collision with root package name */
        private final androidx.compose.runtime.a0 f4032i = new C0043a();

        /* renamed from: k, reason: collision with root package name */
        private final androidx.compose.runtime.collection.e f4034k = new androidx.compose.runtime.collection.e();

        /* renamed from: l, reason: collision with root package name */
        private final HashMap f4035l = new HashMap();

        /* renamed from: androidx.compose.runtime.snapshots.SnapshotStateObserver$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0043a implements androidx.compose.runtime.a0 {
            C0043a() {
            }

            @Override // androidx.compose.runtime.a0
            public void a(androidx.compose.runtime.z zVar) {
                a aVar = a.this;
                aVar.f4033j--;
            }

            @Override // androidx.compose.runtime.a0
            public void b(androidx.compose.runtime.z zVar) {
                a.this.f4033j++;
            }
        }

        public a(Function1 function1) {
            this.f4024a = function1;
        }

        private final void d(Object obj) {
            int i11 = this.f4027d;
            k0 k0Var = this.f4026c;
            if (k0Var == null) {
                return;
            }
            long[] jArr = k0Var.f2389a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i12 = 0;
            while (true) {
                long j11 = jArr[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            int i15 = (i12 << 3) + i14;
                            Object obj2 = k0Var.f2390b[i15];
                            boolean z10 = k0Var.f2391c[i15] != i11;
                            if (z10) {
                                m(obj, obj2);
                            }
                            if (z10) {
                                k0Var.p(i15);
                            }
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        return;
                    }
                }
                if (i12 == length) {
                    return;
                } else {
                    i12++;
                }
            }
        }

        private final void l(Object obj, int i11, Object obj2, k0 k0Var) {
            int i12;
            int i13;
            if (this.f4033j > 0) {
                return;
            }
            int o11 = k0Var.o(obj, i11, -1);
            if (!(obj instanceof androidx.compose.runtime.z) || o11 == i11) {
                i12 = -1;
            } else {
                z.a b11 = ((androidx.compose.runtime.z) obj).b();
                this.f4035l.put(obj, b11.a());
                p0 b12 = b11.b();
                androidx.compose.runtime.collection.e eVar = this.f4034k;
                eVar.g(obj);
                Object[] objArr = b12.f2390b;
                long[] jArr = b12.f2389a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i14 = 0;
                    while (true) {
                        long j11 = jArr[i14];
                        if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i15 = 8;
                            int i16 = 8 - ((~(i14 - length)) >>> 31);
                            int i17 = 0;
                            while (i17 < i16) {
                                if ((j11 & 255) < 128) {
                                    c0 c0Var = (c0) objArr[(i14 << 3) + i17];
                                    if (c0Var instanceof d0) {
                                        ((d0) c0Var).m101recordReadInh_f27i8$runtime_release(f.a(2));
                                    }
                                    eVar.a(c0Var, obj);
                                    i13 = 8;
                                } else {
                                    i13 = i15;
                                }
                                j11 >>= i13;
                                i17++;
                                i15 = i13;
                            }
                            if (i16 != i15) {
                                break;
                            }
                        }
                        if (i14 == length) {
                            break;
                        } else {
                            i14++;
                        }
                    }
                }
                i12 = -1;
            }
            if (o11 == i12) {
                if (obj instanceof d0) {
                    ((d0) obj).m101recordReadInh_f27i8$runtime_release(f.a(2));
                }
                this.f4028e.a(obj, obj2);
            }
        }

        private final void m(Object obj, Object obj2) {
            this.f4028e.f(obj2, obj);
            if (!(obj2 instanceof androidx.compose.runtime.z) || this.f4028e.c(obj2)) {
                return;
            }
            this.f4034k.g(obj2);
            this.f4035l.remove(obj2);
        }

        public final void c() {
            this.f4028e.b();
            this.f4029f.h();
            this.f4034k.b();
            this.f4035l.clear();
        }

        public final void e(Object obj) {
            k0 k0Var = (k0) this.f4029f.o(obj);
            if (k0Var == null) {
                return;
            }
            Object[] objArr = k0Var.f2390b;
            int[] iArr = k0Var.f2391c;
            long[] jArr = k0Var.f2389a;
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
                            int i14 = (i11 << 3) + i13;
                            Object obj2 = objArr[i14];
                            int i15 = iArr[i14];
                            m(obj, obj2);
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

        public final Function1 f() {
            return this.f4024a;
        }

        public final boolean g() {
            return this.f4029f.f();
        }

        public final void h() {
            MutableScatterSet mutableScatterSet = this.f4030g;
            Function1 function1 = this.f4024a;
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
                                function1.invoke(objArr[(i11 << 3) + i13]);
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
            mutableScatterSet.m();
        }

        public final void i(Object obj, Function1 function1, Function0 function0) {
            Object obj2 = this.f4025b;
            k0 k0Var = this.f4026c;
            int i11 = this.f4027d;
            this.f4025b = obj;
            this.f4026c = (k0) this.f4029f.b(obj);
            if (this.f4027d == -1) {
                this.f4027d = SnapshotKt.H().f();
            }
            androidx.compose.runtime.a0 a0Var = this.f4032i;
            androidx.compose.runtime.collection.b a11 = r2.a();
            try {
                a11.b(a0Var);
                j.f4079e.h(function1, null, function0);
                a11.v(a11.n() - 1);
                Object obj3 = this.f4025b;
                Intrinsics.e(obj3);
                d(obj3);
                this.f4025b = obj2;
                this.f4026c = k0Var;
                this.f4027d = i11;
            } catch (Throwable th2) {
                a11.v(a11.n() - 1);
                throw th2;
            }
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
            */
        public final boolean j(java.util.Set r43) {
            /*
                Method dump skipped, instructions count: 1699
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.a.j(java.util.Set):boolean");
        }

        public final void k(Object obj) {
            Object obj2 = this.f4025b;
            Intrinsics.e(obj2);
            int i11 = this.f4027d;
            k0 k0Var = this.f4026c;
            if (k0Var == null) {
                k0Var = new k0(0, 1, null);
                this.f4026c = k0Var;
                this.f4029f.r(obj2, k0Var);
                Unit unit = Unit.f67184a;
            }
            l(obj, i11, obj2, k0Var);
        }

        public final void n(Function1 function1) {
            long[] jArr;
            int i11;
            long[] jArr2;
            int i12;
            long j11;
            int i13;
            long j12;
            int i14;
            n0 n0Var = this.f4029f;
            long[] jArr3 = n0Var.f2419a;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i15 = 0;
            while (true) {
                long j13 = jArr3[i15];
                long j14 = -9187201950435737472L;
                if ((((~j13) << 7) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i16 = 8;
                    int i17 = 8 - ((~(i15 - length)) >>> 31);
                    int i18 = 0;
                    while (i18 < i17) {
                        if ((j13 & 255) < 128) {
                            int i19 = (i15 << 3) + i18;
                            Object obj = n0Var.f2420b[i19];
                            k0 k0Var = (k0) n0Var.f2421c[i19];
                            Boolean bool = (Boolean) function1.invoke(obj);
                            if (bool.booleanValue()) {
                                Object[] objArr = k0Var.f2390b;
                                int[] iArr = k0Var.f2391c;
                                long[] jArr4 = k0Var.f2389a;
                                int length2 = jArr4.length - 2;
                                jArr2 = jArr3;
                                if (length2 >= 0) {
                                    i13 = i17;
                                    int i20 = 0;
                                    while (true) {
                                        long j15 = jArr4[i20];
                                        i12 = i15;
                                        j11 = j13;
                                        j12 = -9187201950435737472L;
                                        if ((((~j15) << 7) & j15 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i21 = 8 - ((~(i20 - length2)) >>> 31);
                                            for (int i22 = 0; i22 < i21; i22++) {
                                                if ((j15 & 255) < 128) {
                                                    int i23 = (i20 << 3) + i22;
                                                    Object obj2 = objArr[i23];
                                                    int i24 = iArr[i23];
                                                    m(obj, obj2);
                                                }
                                                j15 >>= 8;
                                            }
                                            if (i21 != 8) {
                                                break;
                                            }
                                        }
                                        if (i20 == length2) {
                                            break;
                                        }
                                        i20++;
                                        i15 = i12;
                                        j13 = j11;
                                    }
                                } else {
                                    i12 = i15;
                                    j11 = j13;
                                    i13 = i17;
                                    j12 = -9187201950435737472L;
                                }
                            } else {
                                jArr2 = jArr3;
                                i12 = i15;
                                j11 = j13;
                                i13 = i17;
                                j12 = j14;
                            }
                            if (bool.booleanValue()) {
                                n0Var.p(i19);
                            }
                            i14 = 8;
                        } else {
                            jArr2 = jArr3;
                            i12 = i15;
                            j11 = j13;
                            i13 = i17;
                            j12 = j14;
                            i14 = i16;
                        }
                        j13 = j11 >> i14;
                        i18++;
                        i16 = i14;
                        j14 = j12;
                        jArr3 = jArr2;
                        i17 = i13;
                        i15 = i12;
                    }
                    jArr = jArr3;
                    int i25 = i15;
                    if (i17 != i16) {
                        return;
                    } else {
                        i11 = i25;
                    }
                } else {
                    jArr = jArr3;
                    i11 = i15;
                }
                if (i11 == length) {
                    return;
                }
                i15 = i11 + 1;
                jArr3 = jArr;
            }
        }

        public final void o(androidx.compose.runtime.z zVar) {
            long[] jArr;
            long[] jArr2;
            int i11;
            k0 k0Var;
            n0 n0Var = this.f4029f;
            int f11 = SnapshotKt.H().f();
            Object b11 = this.f4028e.d().b(zVar);
            if (b11 == null) {
                return;
            }
            if (!(b11 instanceof MutableScatterSet)) {
                k0 k0Var2 = (k0) n0Var.b(b11);
                if (k0Var2 == null) {
                    k0Var2 = new k0(0, 1, null);
                    n0Var.r(b11, k0Var2);
                    Unit unit = Unit.f67184a;
                }
                l(zVar, f11, b11, k0Var2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) b11;
            Object[] objArr = mutableScatterSet.f2322b;
            long[] jArr3 = mutableScatterSet.f2321a;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i12 = 0;
            while (true) {
                long j11 = jArr3[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8;
                    int i14 = 8 - ((~(i12 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((j11 & 255) < 128) {
                            Object obj = objArr[(i12 << 3) + i15];
                            k0 k0Var3 = (k0) n0Var.b(obj);
                            jArr2 = jArr3;
                            if (k0Var3 == null) {
                                k0Var = new k0(0, 1, null);
                                n0Var.r(obj, k0Var);
                                Unit unit2 = Unit.f67184a;
                            } else {
                                k0Var = k0Var3;
                            }
                            l(zVar, f11, obj, k0Var);
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
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i12 == length) {
                    return;
                }
                i12++;
                jArr3 = jArr;
            }
        }
    }

    public SnapshotStateObserver(Function1 function1) {
        this.f4014a = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Set set) {
        Object obj;
        List B0;
        do {
            obj = this.f4015b.get();
            if (obj == null) {
                B0 = set;
            } else if (obj instanceof Set) {
                B0 = CollectionsKt.o(obj, set);
            } else {
                if (!(obj instanceof List)) {
                    q();
                    throw new KotlinNothingValueException();
                }
                B0 = CollectionsKt.B0((Collection) obj, CollectionsKt.e(set));
            }
        } while (!j0.a(this.f4015b, obj, B0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m() {
        boolean z10;
        synchronized (this.f4019f) {
            z10 = this.f4016c;
        }
        if (z10) {
            return false;
        }
        boolean z11 = false;
        while (true) {
            Set p11 = p();
            if (p11 == null) {
                return z11;
            }
            synchronized (this.f4019f) {
                try {
                    androidx.compose.runtime.collection.b bVar = this.f4019f;
                    int n11 = bVar.n();
                    if (n11 > 0) {
                        Object[] m11 = bVar.m();
                        int i11 = 0;
                        do {
                            if (!((a) m11[i11]).j(p11) && !z11) {
                                z11 = false;
                                i11++;
                            }
                            z11 = true;
                            i11++;
                        } while (i11 < n11);
                    }
                    Unit unit = Unit.f67184a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private final a n(Function1 function1) {
        Object obj;
        androidx.compose.runtime.collection.b bVar = this.f4019f;
        int n11 = bVar.n();
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i11 = 0;
            do {
                obj = m11[i11];
                if (((a) obj).f() == function1) {
                    break;
                }
                i11++;
            } while (i11 < n11);
        }
        obj = null;
        a aVar = (a) obj;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.f(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        a aVar2 = new a((Function1) TypeIntrinsics.e(function1, 1));
        this.f4019f.b(aVar2);
        return aVar2;
    }

    private final Set p() {
        Object obj;
        Object obj2;
        Set set;
        do {
            obj = this.f4015b.get();
            obj2 = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    q();
                    throw new KotlinNothingValueException();
                }
                List list = (List) obj;
                Set set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    obj2 = list.get(1);
                } else if (list.size() > 2) {
                    obj2 = list.subList(1, list.size());
                }
                set = set2;
            }
        } while (!j0.a(this.f4015b, obj, obj2));
        return set;
    }

    private final Void q() {
        androidx.compose.runtime.k.s("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        this.f4014a.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m99invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m99invoke() {
                androidx.compose.runtime.collection.b bVar;
                boolean z10;
                boolean m11;
                androidx.compose.runtime.collection.b bVar2;
                do {
                    bVar = SnapshotStateObserver.this.f4019f;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (bVar) {
                        try {
                            z10 = snapshotStateObserver.f4016c;
                            if (!z10) {
                                snapshotStateObserver.f4016c = true;
                                try {
                                    bVar2 = snapshotStateObserver.f4019f;
                                    int n11 = bVar2.n();
                                    if (n11 > 0) {
                                        Object[] m12 = bVar2.m();
                                        int i11 = 0;
                                        do {
                                            ((SnapshotStateObserver.a) m12[i11]).h();
                                            i11++;
                                        } while (i11 < n11);
                                    }
                                    snapshotStateObserver.f4016c = false;
                                } finally {
                                }
                            }
                            Unit unit = Unit.f67184a;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    m11 = SnapshotStateObserver.this.m();
                } while (m11);
            }
        });
    }

    public final void j() {
        synchronized (this.f4019f) {
            try {
                androidx.compose.runtime.collection.b bVar = this.f4019f;
                int n11 = bVar.n();
                if (n11 > 0) {
                    Object[] m11 = bVar.m();
                    int i11 = 0;
                    do {
                        ((a) m11[i11]).c();
                        i11++;
                    } while (i11 < n11);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k(Object obj) {
        synchronized (this.f4019f) {
            try {
                androidx.compose.runtime.collection.b bVar = this.f4019f;
                int n11 = bVar.n();
                int i11 = 0;
                for (int i12 = 0; i12 < n11; i12++) {
                    a aVar = (a) bVar.m()[i12];
                    aVar.e(obj);
                    if (!aVar.g()) {
                        i11++;
                    } else if (i11 > 0) {
                        bVar.m()[i12 - i11] = bVar.m()[i12];
                    }
                }
                int i13 = n11 - i11;
                ArraysKt.w(bVar.m(), null, i13, n11);
                bVar.z(i13);
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l(Function1 function1) {
        synchronized (this.f4019f) {
            try {
                androidx.compose.runtime.collection.b bVar = this.f4019f;
                int n11 = bVar.n();
                int i11 = 0;
                for (int i12 = 0; i12 < n11; i12++) {
                    a aVar = (a) bVar.m()[i12];
                    aVar.n(function1);
                    if (!aVar.g()) {
                        i11++;
                    } else if (i11 > 0) {
                        bVar.m()[i12 - i11] = bVar.m()[i12];
                    }
                }
                int i13 = n11 - i11;
                ArraysKt.w(bVar.m(), null, i13, n11);
                bVar.z(i13);
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void o(Object obj, Function1 function1, Function0 function0) {
        a n11;
        synchronized (this.f4019f) {
            n11 = n(function1);
        }
        boolean z10 = this.f4021h;
        a aVar = this.f4022i;
        long j11 = this.f4023j;
        if (j11 != -1) {
            if (!(j11 == androidx.compose.runtime.b.a())) {
                o1.a("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j11 + "), currentThread={id=" + androidx.compose.runtime.b.a() + ", name=" + androidx.compose.runtime.b.b() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.f4021h = false;
            this.f4022i = n11;
            this.f4023j = androidx.compose.runtime.b.a();
            n11.i(obj, this.f4018e, function0);
        } finally {
            this.f4022i = aVar;
            this.f4021h = z10;
            this.f4023j = j11;
        }
    }

    public final void s() {
        this.f4020g = j.f4079e.i(this.f4017d);
    }

    public final void t() {
        e eVar = this.f4020g;
        if (eVar != null) {
            eVar.dispose();
        }
    }
}
