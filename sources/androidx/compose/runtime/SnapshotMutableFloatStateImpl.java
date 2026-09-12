package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class SnapshotMutableFloatStateImpl extends androidx.compose.runtime.snapshots.d0 implements c1, androidx.compose.runtime.snapshots.r {
    public static final int $stable = 0;
    private a next;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends androidx.compose.runtime.snapshots.e0 {

        /* renamed from: c, reason: collision with root package name */
        private float f3740c;

        public a(float f11) {
            this.f3740c = f11;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(androidx.compose.runtime.snapshots.e0 e0Var) {
            Intrinsics.f(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
            this.f3740c = ((a) e0Var).f3740c;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public androidx.compose.runtime.snapshots.e0 d() {
            return new a(this.f3740c);
        }

        public final float i() {
            return this.f3740c;
        }

        public final void j(float f11) {
            this.f3740c = f11;
        }
    }

    public SnapshotMutableFloatStateImpl(float f11) {
        a aVar = new a(f11);
        if (androidx.compose.runtime.snapshots.j.f4079e.e()) {
            a aVar2 = new a(f11);
            aVar2.h(1);
            aVar.g(aVar2);
        }
        this.next = aVar;
    }

    /* renamed from: component1, reason: merged with bridge method [inline-methods] */
    public Float m90component1() {
        return Float.valueOf(getFloatValue());
    }

    public Function1<Float, Unit> component2() {
        return new Function1<Float, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableFloatStateImpl$component2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).floatValue());
                return Unit.f67184a;
            }

            public final void invoke(float f11) {
                SnapshotMutableFloatStateImpl.this.setFloatValue(f11);
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.c1, androidx.compose.runtime.h0
    public float getFloatValue() {
        return ((a) SnapshotKt.X(this.next, this)).i();
    }

    @Override // androidx.compose.runtime.snapshots.r
    public q2 getPolicy() {
        return r2.j();
    }

    @Override // androidx.compose.runtime.snapshots.d0, androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 mergeRecords(androidx.compose.runtime.snapshots.e0 e0Var, androidx.compose.runtime.snapshots.e0 e0Var2, androidx.compose.runtime.snapshots.e0 e0Var3) {
        Intrinsics.f(e0Var2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        Intrinsics.f(e0Var3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        if (((a) e0Var2).i() == ((a) e0Var3).i()) {
            return e0Var2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(androidx.compose.runtime.snapshots.e0 e0Var) {
        Intrinsics.f(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.next = (a) e0Var;
    }

    @Override // androidx.compose.runtime.c1
    public void setFloatValue(float f11) {
        androidx.compose.runtime.snapshots.j c11;
        a aVar = (a) SnapshotKt.F(this.next);
        if (aVar.i() == f11) {
            return;
        }
        a aVar2 = this.next;
        SnapshotKt.J();
        synchronized (SnapshotKt.I()) {
            c11 = androidx.compose.runtime.snapshots.j.f4079e.c();
            ((a) SnapshotKt.S(aVar2, this, c11, aVar)).j(f11);
            Unit unit = Unit.f67184a;
        }
        SnapshotKt.Q(c11, this);
    }

    public String toString() {
        return "MutableFloatState(value=" + ((a) SnapshotKt.F(this.next)).i() + ")@" + hashCode();
    }
}
