package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class g0 extends b {

    /* renamed from: s, reason: collision with root package name */
    private final b f4064s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f4065t;

    /* renamed from: u, reason: collision with root package name */
    private final boolean f4066u;

    /* renamed from: v, reason: collision with root package name */
    private Function1 f4067v;

    /* renamed from: w, reason: collision with root package name */
    private Function1 f4068w;

    /* renamed from: x, reason: collision with root package name */
    private final long f4069x;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g0(androidx.compose.runtime.snapshots.b r3, kotlin.jvm.functions.Function1 r4, kotlin.jvm.functions.Function1 r5, boolean r6, boolean r7) {
        /*
            r2 = this;
            androidx.compose.runtime.snapshots.SnapshotIdSet$a r0 = androidx.compose.runtime.snapshots.SnapshotIdSet.f3991e
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.a()
            if (r3 == 0) goto Le
            kotlin.jvm.functions.Function1 r1 = r3.h()
            if (r1 != 0) goto L1c
        Le:
            java.util.concurrent.atomic.AtomicReference r1 = androidx.compose.runtime.snapshots.SnapshotKt.f()
            java.lang.Object r1 = r1.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r1 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r1
            kotlin.jvm.functions.Function1 r1 = r1.h()
        L1c:
            kotlin.jvm.functions.Function1 r4 = androidx.compose.runtime.snapshots.SnapshotKt.l(r4, r1, r6)
            if (r3 == 0) goto L28
            kotlin.jvm.functions.Function1 r1 = r3.k()
            if (r1 != 0) goto L36
        L28:
            java.util.concurrent.atomic.AtomicReference r1 = androidx.compose.runtime.snapshots.SnapshotKt.f()
            java.lang.Object r1 = r1.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r1 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r1
            kotlin.jvm.functions.Function1 r1 = r1.k()
        L36:
            kotlin.jvm.functions.Function1 r5 = androidx.compose.runtime.snapshots.SnapshotKt.m(r5, r1)
            r1 = 0
            r2.<init>(r1, r0, r4, r5)
            r2.f4064s = r3
            r2.f4065t = r6
            r2.f4066u = r7
            kotlin.jvm.functions.Function1 r3 = super.h()
            r2.f4067v = r3
            kotlin.jvm.functions.Function1 r3 = super.k()
            r2.f4068w = r3
            long r3 = androidx.compose.runtime.b.a()
            r2.f4069x = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.g0.<init>(androidx.compose.runtime.snapshots.b, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, boolean):void");
    }

    private final b T() {
        AtomicReference atomicReference;
        b bVar = this.f4064s;
        if (bVar != null) {
            return bVar;
        }
        atomicReference = SnapshotKt.f4006j;
        return (b) atomicReference.get();
    }

    @Override // androidx.compose.runtime.snapshots.b
    public k C() {
        return T().C();
    }

    @Override // androidx.compose.runtime.snapshots.b
    public MutableScatterSet E() {
        return T().E();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public Function1 h() {
        return this.f4067v;
    }

    @Override // androidx.compose.runtime.snapshots.b
    public void P(MutableScatterSet mutableScatterSet) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b
    public b Q(Function1 function1, Function1 function12) {
        Function1 M;
        Function1 L = SnapshotKt.L(function1, h(), false, 4, null);
        M = SnapshotKt.M(function12, k());
        return !this.f4065t ? new g0(T().Q(null, M), L, M, false, true) : T().Q(L, M);
    }

    public final long U() {
        return this.f4069x;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public Void m(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public Void n(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public void X(Function1 function1) {
        this.f4067v = function1;
    }

    public void Y(Function1 function1) {
        this.f4068w = function1;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void d() {
        b bVar;
        t(true);
        if (!this.f4066u || (bVar = this.f4064s) == null) {
            return;
        }
        bVar.d();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public int f() {
        return T().f();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public SnapshotIdSet g() {
        return T().g();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public boolean i() {
        return T().i();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public int j() {
        return T().j();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public Function1 k() {
        return this.f4068w;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void o() {
        T().o();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void p(c0 c0Var) {
        T().p(c0Var);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void u(int i11) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void v(SnapshotIdSet snapshotIdSet) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void w(int i11) {
        T().w(i11);
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public j x(Function1 function1) {
        j D;
        Function1 L = SnapshotKt.L(function1, h(), false, 4, null);
        if (this.f4065t) {
            return T().x(L);
        }
        D = SnapshotKt.D(T().x(null), L, true);
        return D;
    }
}
