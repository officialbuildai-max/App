package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.w0;
import androidx.compose.runtime.o1;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public class b extends j {

    /* renamed from: p, reason: collision with root package name */
    private static final a f4037p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f4038q = 8;

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f4039r = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private final Function1 f4040g;

    /* renamed from: h, reason: collision with root package name */
    private final Function1 f4041h;

    /* renamed from: i, reason: collision with root package name */
    private int f4042i;

    /* renamed from: j, reason: collision with root package name */
    private MutableScatterSet f4043j;

    /* renamed from: k, reason: collision with root package name */
    private List f4044k;

    /* renamed from: l, reason: collision with root package name */
    private SnapshotIdSet f4045l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f4046m;

    /* renamed from: n, reason: collision with root package name */
    private int f4047n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4048o;

    /* loaded from: classes.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(int i11, SnapshotIdSet snapshotIdSet, Function1 function1, Function1 function12) {
        super(i11, snapshotIdSet, null);
        this.f4040g = function1;
        this.f4041h = function12;
        this.f4045l = SnapshotIdSet.f3991e.a();
        this.f4046m = f4039r;
        this.f4047n = 1;
    }

    private final void A() {
        MutableScatterSet E = E();
        if (E != null) {
            R();
            P(null);
            int f11 = f();
            Object[] objArr = E.f2322b;
            long[] jArr = E.f2321a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                for (e0 firstStateRecord = ((c0) objArr[(i11 << 3) + i13]).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.e()) {
                                    if (firstStateRecord.f() == f11 || CollectionsKt.b0(this.f4045l, Integer.valueOf(firstStateRecord.f()))) {
                                        firstStateRecord.h(0);
                                    }
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
                    } else {
                        i11++;
                    }
                }
            }
        }
        b();
    }

    private final void N() {
        int length = this.f4046m.length;
        for (int i11 = 0; i11 < length; i11++) {
            SnapshotKt.Y(this.f4046m[i11]);
        }
    }

    private final void R() {
        if (this.f4048o) {
            o1.b("Unsupported operation on a snapshot that has been applied");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void S() {
        /*
            r1 = this;
            boolean r0 = r1.f4048o
            if (r0 == 0) goto Ld
            int r0 = androidx.compose.runtime.snapshots.j.a(r1)
            if (r0 < 0) goto Lb
            goto Ld
        Lb:
            r0 = 0
            goto Le
        Ld:
            r0 = 1
        Le:
            if (r0 != 0) goto L15
            java.lang.String r0 = "Unsupported operation on a disposed or applied snapshot"
            androidx.compose.runtime.o1.b(r0)
        L15:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.b.S():void");
    }

    public final void B() {
        int i11;
        SnapshotIdSet snapshotIdSet;
        J(f());
        Unit unit = Unit.f67184a;
        if (D() || e()) {
            return;
        }
        int f11 = f();
        synchronized (SnapshotKt.I()) {
            i11 = SnapshotKt.f4001e;
            SnapshotKt.f4001e = i11 + 1;
            u(i11);
            snapshotIdSet = SnapshotKt.f4000d;
            SnapshotKt.f4000d = snapshotIdSet.p(f());
        }
        v(SnapshotKt.z(g(), f11 + 1, f()));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8 A[LOOP:1: B:32:0x00e6->B:33:0x00e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.snapshots.k C() {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.b.C():androidx.compose.runtime.snapshots.k");
    }

    public final boolean D() {
        return this.f4048o;
    }

    public MutableScatterSet E() {
        return this.f4043j;
    }

    public final SnapshotIdSet F() {
        return this.f4045l;
    }

    public final int[] G() {
        return this.f4046m;
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* renamed from: H */
    public Function1 h() {
        return this.f4040g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        r5 = androidx.compose.runtime.snapshots.SnapshotKt.W(r2, f(), r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.runtime.snapshots.k I(int r24, java.util.Map r25, androidx.compose.runtime.snapshots.SnapshotIdSet r26) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.b.I(int, java.util.Map, androidx.compose.runtime.snapshots.SnapshotIdSet):androidx.compose.runtime.snapshots.k");
    }

    public final void J(int i11) {
        synchronized (SnapshotKt.I()) {
            this.f4045l = this.f4045l.p(i11);
            Unit unit = Unit.f67184a;
        }
    }

    public final void K(SnapshotIdSet snapshotIdSet) {
        synchronized (SnapshotKt.I()) {
            this.f4045l = this.f4045l.o(snapshotIdSet);
            Unit unit = Unit.f67184a;
        }
    }

    public final void L(int i11) {
        if (i11 >= 0) {
            this.f4046m = ArraysKt.C(this.f4046m, i11);
        }
    }

    public final void M(int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        int[] iArr2 = this.f4046m;
        if (iArr2.length != 0) {
            iArr = ArraysKt.D(iArr2, iArr);
        }
        this.f4046m = iArr;
    }

    public final void O(boolean z10) {
        this.f4048o = z10;
    }

    public void P(MutableScatterSet mutableScatterSet) {
        this.f4043j = mutableScatterSet;
    }

    public b Q(Function1 function1, Function1 function12) {
        int i11;
        SnapshotIdSet snapshotIdSet;
        c cVar;
        Function1 M;
        int i12;
        SnapshotIdSet snapshotIdSet2;
        z();
        S();
        J(f());
        synchronized (SnapshotKt.I()) {
            i11 = SnapshotKt.f4001e;
            SnapshotKt.f4001e = i11 + 1;
            snapshotIdSet = SnapshotKt.f4000d;
            SnapshotKt.f4000d = snapshotIdSet.p(i11);
            SnapshotIdSet g11 = g();
            v(g11.p(i11));
            SnapshotIdSet z10 = SnapshotKt.z(g11, f() + 1, i11);
            Function1 L = SnapshotKt.L(function1, h(), false, 4, null);
            M = SnapshotKt.M(function12, k());
            cVar = new c(i11, z10, L, M, this);
        }
        if (!D() && !e()) {
            int f11 = f();
            synchronized (SnapshotKt.I()) {
                i12 = SnapshotKt.f4001e;
                SnapshotKt.f4001e = i12 + 1;
                u(i12);
                snapshotIdSet2 = SnapshotKt.f4000d;
                SnapshotKt.f4000d = snapshotIdSet2.p(f());
                Unit unit = Unit.f67184a;
            }
            v(SnapshotKt.z(g(), f11 + 1, f()));
        }
        return cVar;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void c() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.f4000d;
        SnapshotKt.f4000d = snapshotIdSet.l(f()).j(this.f4045l);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void d() {
        if (e()) {
            return;
        }
        super.d();
        n(this);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public boolean i() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public int j() {
        return this.f4042i;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public Function1 k() {
        return this.f4041h;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void m(j jVar) {
        this.f4047n++;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void n(j jVar) {
        if (!(this.f4047n > 0)) {
            o1.a("no pending nested snapshots");
        }
        int i11 = this.f4047n - 1;
        this.f4047n = i11;
        if (i11 != 0 || this.f4048o) {
            return;
        }
        A();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void o() {
        if (this.f4048o || e()) {
            return;
        }
        B();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void p(c0 c0Var) {
        MutableScatterSet E = E();
        if (E == null) {
            E = w0.a();
            P(E);
        }
        E.h(c0Var);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void r() {
        N();
        super.r();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void w(int i11) {
        this.f4042i = i11;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public j x(Function1 function1) {
        int i11;
        SnapshotIdSet snapshotIdSet;
        d dVar;
        int i12;
        SnapshotIdSet snapshotIdSet2;
        z();
        S();
        int f11 = f();
        J(f());
        synchronized (SnapshotKt.I()) {
            i11 = SnapshotKt.f4001e;
            SnapshotKt.f4001e = i11 + 1;
            snapshotIdSet = SnapshotKt.f4000d;
            SnapshotKt.f4000d = snapshotIdSet.p(i11);
            dVar = new d(i11, SnapshotKt.z(g(), f11 + 1, i11), SnapshotKt.L(function1, h(), false, 4, null), this);
        }
        if (!D() && !e()) {
            int f12 = f();
            synchronized (SnapshotKt.I()) {
                i12 = SnapshotKt.f4001e;
                SnapshotKt.f4001e = i12 + 1;
                u(i12);
                snapshotIdSet2 = SnapshotKt.f4000d;
                SnapshotKt.f4000d = snapshotIdSet2.p(f());
                Unit unit = Unit.f67184a;
            }
            v(SnapshotKt.z(g(), f12 + 1, f()));
        }
        return dVar;
    }
}
