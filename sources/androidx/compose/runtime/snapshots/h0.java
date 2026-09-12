package androidx.compose.runtime.snapshots;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class h0 extends j {

    /* renamed from: g, reason: collision with root package name */
    private final j f4071g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f4072h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f4073i;

    /* renamed from: j, reason: collision with root package name */
    private Function1 f4074j;

    /* renamed from: k, reason: collision with root package name */
    private final Function1 f4075k;

    /* renamed from: l, reason: collision with root package name */
    private final long f4076l;

    /* renamed from: m, reason: collision with root package name */
    private final j f4077m;

    public h0(j jVar, Function1 function1, boolean z10, boolean z11) {
        super(0, SnapshotIdSet.f3991e.a(), null);
        AtomicReference atomicReference;
        Function1 h11;
        Function1 K;
        this.f4071g = jVar;
        this.f4072h = z10;
        this.f4073i = z11;
        if (jVar == null || (h11 = jVar.h()) == null) {
            atomicReference = SnapshotKt.f4006j;
            h11 = ((GlobalSnapshot) atomicReference.get()).h();
        }
        K = SnapshotKt.K(function1, h11, z10);
        this.f4074j = K;
        this.f4076l = androidx.compose.runtime.b.a();
        this.f4077m = this;
    }

    private final j A() {
        AtomicReference atomicReference;
        j jVar = this.f4071g;
        if (jVar != null) {
            return jVar;
        }
        atomicReference = SnapshotKt.f4006j;
        return (j) atomicReference.get();
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Function1 h() {
        return this.f4074j;
    }

    public final long C() {
        return this.f4076l;
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Void m(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public Void n(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    public void F(Function1 function1) {
        this.f4074j = function1;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void d() {
        j jVar;
        t(true);
        if (!this.f4073i || (jVar = this.f4071g) == null) {
            return;
        }
        jVar.d();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public int f() {
        return A().f();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public SnapshotIdSet g() {
        return A().g();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public boolean i() {
        return A().i();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public Function1 k() {
        return this.f4075k;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void o() {
        A().o();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void p(c0 c0Var) {
        A().p(c0Var);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public j x(Function1 function1) {
        j D;
        Function1 L = SnapshotKt.L(function1, h(), false, 4, null);
        if (this.f4072h) {
            return A().x(L);
        }
        D = SnapshotKt.D(A().x(null), L, true);
        return D;
    }
}
