package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.h3;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.j;
import androidx.compose.runtime.v2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class SnapshotKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Function1 f3997a = new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SnapshotIdSet) obj);
            return Unit.f67184a;
        }

        public final void invoke(SnapshotIdSet snapshotIdSet) {
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final v2 f3998b = new v2();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f3999c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static SnapshotIdSet f4000d;

    /* renamed from: e, reason: collision with root package name */
    private static int f4001e;

    /* renamed from: f, reason: collision with root package name */
    private static final l f4002f;

    /* renamed from: g, reason: collision with root package name */
    private static final v f4003g;

    /* renamed from: h, reason: collision with root package name */
    private static List f4004h;

    /* renamed from: i, reason: collision with root package name */
    private static List f4005i;

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicReference f4006j;

    /* renamed from: k, reason: collision with root package name */
    private static final j f4007k;

    /* renamed from: l, reason: collision with root package name */
    private static AtomicInt f4008l;

    static {
        SnapshotIdSet.a aVar = SnapshotIdSet.f3991e;
        f4000d = aVar.a();
        f4001e = 2;
        f4002f = new l();
        f4003g = new v();
        f4004h = CollectionsKt.l();
        f4005i = CollectionsKt.l();
        int i11 = f4001e;
        f4001e = i11 + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i11, aVar.a());
        f4000d = f4000d.p(globalSnapshot.f());
        AtomicReference atomicReference = new AtomicReference(globalSnapshot);
        f4006j = atomicReference;
        f4007k = (j) atomicReference.get();
        f4008l = new AtomicInt(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object A(Function1 function1) {
        Object obj;
        MutableScatterSet E;
        Object a02;
        j jVar = f4007k;
        Intrinsics.f(jVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        synchronized (I()) {
            try {
                obj = f4006j.get();
                E = ((GlobalSnapshot) obj).E();
                if (E != null) {
                    f4008l.add(1);
                }
                a02 = a0((j) obj, function1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (E != null) {
            try {
                List list = f4004h;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((Function2) list.get(i11)).invoke(androidx.compose.runtime.collection.d.a(E), obj);
                }
            } finally {
                f4008l.add(-1);
            }
        }
        synchronized (I()) {
            try {
                C();
                if (E != null) {
                    Object[] objArr = E.f2322b;
                    long[] jArr = E.f2321a;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i12 = 0;
                        while (true) {
                            long j11 = jArr[i12];
                            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i13 = 8 - ((~(i12 - length)) >>> 31);
                                for (int i14 = 0; i14 < i13; i14++) {
                                    if ((255 & j11) < 128) {
                                        U((c0) objArr[(i12 << 3) + i14]);
                                    }
                                    j11 >>= 8;
                                }
                                if (i13 != 8) {
                                    break;
                                }
                            }
                            if (i12 == length) {
                                break;
                            }
                            i12++;
                        }
                    }
                    Unit unit = Unit.f67184a;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return a02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B() {
        A(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SnapshotIdSet) obj);
                return Unit.f67184a;
            }

            public final void invoke(SnapshotIdSet snapshotIdSet) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C() {
        v vVar = f4003g;
        int e11 = vVar.e();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= e11) {
                break;
            }
            h3 h3Var = vVar.f()[i11];
            Object obj = h3Var != null ? h3Var.get() : null;
            if (obj != null && T((c0) obj)) {
                if (i12 != i11) {
                    vVar.f()[i12] = h3Var;
                    vVar.d()[i12] = vVar.d()[i11];
                }
                i12++;
            }
            i11++;
        }
        for (int i13 = i12; i13 < e11; i13++) {
            vVar.f()[i13] = null;
            vVar.d()[i13] = 0;
        }
        if (i12 != e11) {
            vVar.g(i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j D(j jVar, Function1 function1, boolean z10) {
        boolean z11 = jVar instanceof b;
        if (z11 || jVar == null) {
            return new g0(z11 ? (b) jVar : null, function1, null, false, z10);
        }
        return new h0(jVar, function1, false, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ j E(j jVar, Function1 function1, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return D(jVar, function1, z10);
    }

    public static final e0 F(e0 e0Var) {
        e0 W;
        j.a aVar = j.f4079e;
        j c11 = aVar.c();
        e0 W2 = W(e0Var, c11.f(), c11.g());
        if (W2 != null) {
            return W2;
        }
        synchronized (I()) {
            j c12 = aVar.c();
            W = W(e0Var, c12.f(), c12.g());
        }
        if (W != null) {
            return W;
        }
        V();
        throw new KotlinNothingValueException();
    }

    public static final e0 G(e0 e0Var, j jVar) {
        e0 W = W(e0Var, jVar.f(), jVar.g());
        if (W != null) {
            return W;
        }
        V();
        throw new KotlinNothingValueException();
    }

    public static final j H() {
        j jVar = (j) f3998b.a();
        return jVar == null ? (j) f4006j.get() : jVar;
    }

    public static final Object I() {
        return f3999c;
    }

    public static final j J() {
        return f4007k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 K(final Function1 function1, final Function1 function12, boolean z10) {
        if (!z10) {
            function12 = null;
        }
        return (function1 == null || function12 == null || function1 == function12) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m96invoke(obj);
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m96invoke(Object obj) {
                function1.invoke(obj);
                function12.invoke(obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Function1 L(Function1 function1, Function1 function12, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return K(function1, function12, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 M(final Function1 function1, final Function1 function12) {
        return (function1 == null || function12 == null || function1 == function12) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m97invoke(obj);
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m97invoke(Object obj) {
                function1.invoke(obj);
                function12.invoke(obj);
            }
        };
    }

    public static final e0 N(e0 e0Var, c0 c0Var) {
        e0 d02 = d0(c0Var);
        if (d02 != null) {
            d02.h(Integer.MAX_VALUE);
            return d02;
        }
        e0 d11 = e0Var.d();
        d11.h(Integer.MAX_VALUE);
        d11.g(c0Var.getFirstStateRecord());
        Intrinsics.f(d11, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$16");
        c0Var.prependStateRecord(d11);
        Intrinsics.f(d11, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return d11;
    }

    public static final e0 O(e0 e0Var, c0 c0Var, j jVar) {
        e0 P;
        synchronized (I()) {
            P = P(e0Var, c0Var, jVar);
        }
        return P;
    }

    private static final e0 P(e0 e0Var, c0 c0Var, j jVar) {
        e0 N = N(e0Var, c0Var);
        N.c(e0Var);
        N.h(jVar.f());
        return N;
    }

    public static final void Q(j jVar, c0 c0Var) {
        jVar.w(jVar.j() + 1);
        Function1 k11 = jVar.k();
        if (k11 != null) {
            k11.invoke(c0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map R(b bVar, b bVar2, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        int i11;
        HashMap hashMap;
        long[] jArr2;
        int i12;
        HashMap hashMap2;
        int i13;
        e0 W;
        MutableScatterSet E = bVar2.E();
        int f11 = bVar.f();
        HashMap hashMap3 = null;
        if (E == null) {
            return null;
        }
        SnapshotIdSet o11 = bVar2.g().p(bVar2.f()).o(bVar2.F());
        Object[] objArr = E.f2322b;
        long[] jArr3 = E.f2321a;
        int length = jArr3.length - 2;
        if (length >= 0) {
            HashMap hashMap4 = null;
            int i14 = 0;
            while (true) {
                long j11 = jArr3[i14];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i15 = 8;
                    int i16 = 8 - ((~(i14 - length)) >>> 31);
                    int i17 = 0;
                    while (i17 < i16) {
                        if ((255 & j11) < 128) {
                            c0 c0Var = (c0) objArr[(i14 << 3) + i17];
                            e0 firstStateRecord = c0Var.getFirstStateRecord();
                            e0 W2 = W(firstStateRecord, f11, snapshotIdSet);
                            if (W2 == null || (W = W(firstStateRecord, f11, o11)) == null || Intrinsics.c(W2, W)) {
                                jArr2 = jArr3;
                                i12 = f11;
                            } else {
                                jArr2 = jArr3;
                                i12 = f11;
                                e0 W3 = W(firstStateRecord, bVar2.f(), bVar2.g());
                                if (W3 == null) {
                                    V();
                                    throw new KotlinNothingValueException();
                                }
                                e0 mergeRecords = c0Var.mergeRecords(W, W2, W3);
                                if (mergeRecords == null) {
                                    return null;
                                }
                                if (hashMap4 == null) {
                                    hashMap4 = new HashMap();
                                }
                                hashMap4.put(W2, mergeRecords);
                                hashMap4 = hashMap4;
                            }
                            hashMap2 = null;
                            i13 = 8;
                        } else {
                            jArr2 = jArr3;
                            i12 = f11;
                            hashMap2 = hashMap3;
                            i13 = i15;
                        }
                        j11 >>= i13;
                        i17++;
                        hashMap3 = hashMap2;
                        i15 = i13;
                        jArr3 = jArr2;
                        f11 = i12;
                    }
                    jArr = jArr3;
                    i11 = f11;
                    hashMap = hashMap3;
                    if (i16 != i15) {
                        return hashMap4;
                    }
                } else {
                    jArr = jArr3;
                    i11 = f11;
                    hashMap = hashMap3;
                }
                if (i14 == length) {
                    hashMap3 = hashMap4;
                    break;
                }
                i14++;
                hashMap3 = hashMap;
                jArr3 = jArr;
                f11 = i11;
            }
        }
        return hashMap3;
    }

    public static final e0 S(e0 e0Var, c0 c0Var, j jVar, e0 e0Var2) {
        e0 N;
        if (jVar.i()) {
            jVar.p(c0Var);
        }
        int f11 = jVar.f();
        if (e0Var2.f() == f11) {
            return e0Var2;
        }
        synchronized (I()) {
            N = N(e0Var, c0Var);
        }
        N.h(f11);
        if (e0Var2.f() != 1) {
            jVar.p(c0Var);
        }
        return N;
    }

    private static final boolean T(c0 c0Var) {
        e0 e0Var;
        int e11 = f4002f.e(f4001e);
        e0 e0Var2 = null;
        e0 e0Var3 = null;
        int i11 = 0;
        for (e0 firstStateRecord = c0Var.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.e()) {
            int f11 = firstStateRecord.f();
            if (f11 != 0) {
                if (f11 >= e11) {
                    i11++;
                } else if (e0Var2 == null) {
                    i11++;
                    e0Var2 = firstStateRecord;
                } else {
                    if (firstStateRecord.f() < e0Var2.f()) {
                        e0Var = e0Var2;
                        e0Var2 = firstStateRecord;
                    } else {
                        e0Var = firstStateRecord;
                    }
                    if (e0Var3 == null) {
                        e0Var3 = c0Var.getFirstStateRecord();
                        e0 e0Var4 = e0Var3;
                        while (true) {
                            if (e0Var3 == null) {
                                e0Var3 = e0Var4;
                                break;
                            }
                            if (e0Var3.f() >= e11) {
                                break;
                            }
                            if (e0Var4.f() < e0Var3.f()) {
                                e0Var4 = e0Var3;
                            }
                            e0Var3 = e0Var3.e();
                        }
                    }
                    e0Var2.h(0);
                    e0Var2.c(e0Var3);
                    e0Var2 = e0Var;
                }
            }
        }
        return i11 > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(c0 c0Var) {
        if (T(c0Var)) {
            f4003g.a(c0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void V() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e0 W(e0 e0Var, int i11, SnapshotIdSet snapshotIdSet) {
        e0 e0Var2 = null;
        while (e0Var != null) {
            if (f0(e0Var, i11, snapshotIdSet) && (e0Var2 == null || e0Var2.f() < e0Var.f())) {
                e0Var2 = e0Var;
            }
            e0Var = e0Var.e();
        }
        if (e0Var2 != null) {
            return e0Var2;
        }
        return null;
    }

    public static final e0 X(e0 e0Var, c0 c0Var) {
        e0 W;
        j.a aVar = j.f4079e;
        j c11 = aVar.c();
        Function1 h11 = c11.h();
        if (h11 != null) {
            h11.invoke(c0Var);
        }
        e0 W2 = W(e0Var, c11.f(), c11.g());
        if (W2 != null) {
            return W2;
        }
        synchronized (I()) {
            j c12 = aVar.c();
            e0 firstStateRecord = c0Var.getFirstStateRecord();
            Intrinsics.f(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            W = W(firstStateRecord, c12.f(), c12.g());
            if (W == null) {
                V();
                throw new KotlinNothingValueException();
            }
        }
        return W;
    }

    public static final void Y(int i11) {
        f4002f.f(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void Z() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object a0(j jVar, Function1 function1) {
        Object invoke = function1.invoke(f4000d.l(jVar.f()));
        synchronized (I()) {
            int i11 = f4001e;
            f4001e = i11 + 1;
            f4000d = f4000d.l(jVar.f());
            f4006j.set(new GlobalSnapshot(i11, f4000d));
            jVar.d();
            f4000d = f4000d.p(i11);
            Unit unit = Unit.f67184a;
        }
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j b0(final Function1 function1) {
        return (j) A(new Function1<SnapshotIdSet, j>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$takeNewSnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final j invoke(SnapshotIdSet snapshotIdSet) {
                SnapshotIdSet snapshotIdSet2;
                j jVar = (j) function1.invoke(snapshotIdSet);
                synchronized (SnapshotKt.I()) {
                    snapshotIdSet2 = SnapshotKt.f4000d;
                    SnapshotKt.f4000d = snapshotIdSet2.p(jVar.f());
                    Unit unit = Unit.f67184a;
                }
                return jVar;
            }
        });
    }

    public static final int c0(int i11, SnapshotIdSet snapshotIdSet) {
        int a11;
        int n11 = snapshotIdSet.n(i11);
        synchronized (I()) {
            a11 = f4002f.a(n11);
        }
        return a11;
    }

    private static final e0 d0(c0 c0Var) {
        int e11 = f4002f.e(f4001e) - 1;
        SnapshotIdSet a11 = SnapshotIdSet.f3991e.a();
        e0 e0Var = null;
        for (e0 firstStateRecord = c0Var.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.e()) {
            if (firstStateRecord.f() == 0) {
                return firstStateRecord;
            }
            if (f0(firstStateRecord, e11, a11)) {
                if (e0Var != null) {
                    return firstStateRecord.f() < e0Var.f() ? firstStateRecord : e0Var;
                }
                e0Var = firstStateRecord;
            }
        }
        return null;
    }

    private static final boolean e0(int i11, int i12, SnapshotIdSet snapshotIdSet) {
        return (i12 == 0 || i12 > i11 || snapshotIdSet.m(i12)) ? false : true;
    }

    private static final boolean f0(e0 e0Var, int i11, SnapshotIdSet snapshotIdSet) {
        return e0(i11, e0Var.f(), snapshotIdSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(j jVar) {
        int e11;
        if (f4000d.m(jVar.f())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Snapshot is not open: id=");
        sb2.append(jVar.f());
        sb2.append(", disposed=");
        sb2.append(jVar.e());
        sb2.append(", applied=");
        b bVar = jVar instanceof b ? (b) jVar : null;
        sb2.append(bVar != null ? Boolean.valueOf(bVar.D()) : "read-only");
        sb2.append(", lowestPin=");
        synchronized (I()) {
            e11 = f4002f.e(-1);
        }
        sb2.append(e11);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public static final e0 h0(e0 e0Var, c0 c0Var, j jVar) {
        e0 W;
        if (jVar.i()) {
            jVar.p(c0Var);
        }
        int f11 = jVar.f();
        e0 W2 = W(e0Var, f11, jVar.g());
        if (W2 == null) {
            V();
            throw new KotlinNothingValueException();
        }
        if (W2.f() == jVar.f()) {
            return W2;
        }
        synchronized (I()) {
            W = W(c0Var.getFirstStateRecord(), f11, jVar.g());
            if (W == null) {
                V();
                throw new KotlinNothingValueException();
            }
            if (W.f() != f11) {
                W = P(W, c0Var, jVar);
            }
        }
        Intrinsics.f(W, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (W2.f() != 1) {
            jVar.p(c0Var);
        }
        return W;
    }

    public static final SnapshotIdSet z(SnapshotIdSet snapshotIdSet, int i11, int i12) {
        while (i11 < i12) {
            snapshotIdSet = snapshotIdSet.p(i11);
            i11++;
        }
        return snapshotIdSet;
    }
}
