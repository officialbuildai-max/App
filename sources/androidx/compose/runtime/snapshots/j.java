package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.o1;
import androidx.compose.runtime.snapshots.j;
import androidx.compose.runtime.v2;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4079e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final int f4080f = 8;

    /* renamed from: a, reason: collision with root package name */
    private SnapshotIdSet f4081a;

    /* renamed from: b, reason: collision with root package name */
    private int f4082b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4083c;

    /* renamed from: d, reason: collision with root package name */
    private int f4084d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(Function2 function2) {
            List list;
            synchronized (SnapshotKt.I()) {
                list = SnapshotKt.f4004h;
                SnapshotKt.f4004h = CollectionsKt.z0(list, function2);
                Unit unit = Unit.f67184a;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(Function1 function1) {
            List list;
            synchronized (SnapshotKt.I()) {
                list = SnapshotKt.f4005i;
                SnapshotKt.f4005i = CollectionsKt.z0(list, function1);
                Unit unit = Unit.f67184a;
            }
            SnapshotKt.B();
        }

        public final j c() {
            return SnapshotKt.H();
        }

        public final j d() {
            v2 v2Var;
            v2Var = SnapshotKt.f3998b;
            return (j) v2Var.a();
        }

        public final boolean e() {
            v2 v2Var;
            v2Var = SnapshotKt.f3998b;
            return v2Var.a() != null;
        }

        public final j f(j jVar) {
            if (jVar instanceof g0) {
                g0 g0Var = (g0) jVar;
                if (g0Var.U() == androidx.compose.runtime.b.a()) {
                    g0Var.X(null);
                    return jVar;
                }
            }
            if (jVar instanceof h0) {
                h0 h0Var = (h0) jVar;
                if (h0Var.C() == androidx.compose.runtime.b.a()) {
                    h0Var.F(null);
                    return jVar;
                }
            }
            j E = SnapshotKt.E(jVar, null, false, 6, null);
            E.l();
            return E;
        }

        public final void g() {
            SnapshotKt.H().o();
        }

        public final Object h(Function1 function1, Function1 function12, Function0 function0) {
            v2 v2Var;
            j g0Var;
            Function1 M;
            if (function1 == null && function12 == null) {
                return function0.invoke();
            }
            v2Var = SnapshotKt.f3998b;
            j jVar = (j) v2Var.a();
            if (jVar instanceof g0) {
                g0 g0Var2 = (g0) jVar;
                if (g0Var2.U() == androidx.compose.runtime.b.a()) {
                    Function1 h11 = g0Var2.h();
                    Function1 k11 = g0Var2.k();
                    try {
                        ((g0) jVar).X(SnapshotKt.L(function1, h11, false, 4, null));
                        M = SnapshotKt.M(function12, k11);
                        ((g0) jVar).Y(M);
                        return function0.invoke();
                    } finally {
                        g0Var2.X(h11);
                        g0Var2.Y(k11);
                    }
                }
            }
            if (jVar == null || (jVar instanceof b)) {
                g0Var = new g0(jVar instanceof b ? (b) jVar : null, function1, function12, true, false);
            } else {
                if (function1 == null) {
                    return function0.invoke();
                }
                g0Var = jVar.x(function1);
            }
            try {
                j l11 = g0Var.l();
                try {
                    return function0.invoke();
                } finally {
                    g0Var.s(l11);
                }
            } finally {
                g0Var.d();
            }
        }

        public final e i(final Function2 function2) {
            Function1 function1;
            List list;
            function1 = SnapshotKt.f3997a;
            SnapshotKt.A(function1);
            synchronized (SnapshotKt.I()) {
                list = SnapshotKt.f4004h;
                SnapshotKt.f4004h = CollectionsKt.C0(list, function2);
                Unit unit = Unit.f67184a;
            }
            return new e() { // from class: androidx.compose.runtime.snapshots.h
                @Override // androidx.compose.runtime.snapshots.e
                public final void dispose() {
                    j.a.j(Function2.this);
                }
            };
        }

        public final e k(final Function1 function1) {
            List list;
            synchronized (SnapshotKt.I()) {
                list = SnapshotKt.f4005i;
                SnapshotKt.f4005i = CollectionsKt.C0(list, function1);
                Unit unit = Unit.f67184a;
            }
            SnapshotKt.B();
            return new e() { // from class: androidx.compose.runtime.snapshots.i
                @Override // androidx.compose.runtime.snapshots.e
                public final void dispose() {
                    j.a.l(Function1.this);
                }
            };
        }

        public final void m(j jVar, j jVar2, Function1 function1) {
            if (jVar != jVar2) {
                jVar2.s(jVar);
                jVar2.d();
            } else if (jVar instanceof g0) {
                ((g0) jVar).X(function1);
            } else {
                if (jVar instanceof h0) {
                    ((h0) jVar).F(function1);
                    return;
                }
                throw new IllegalStateException(("Non-transparent snapshot was reused: " + jVar).toString());
            }
        }

        public final void n() {
            AtomicReference atomicReference;
            boolean z10;
            synchronized (SnapshotKt.I()) {
                atomicReference = SnapshotKt.f4006j;
                MutableScatterSet E = ((GlobalSnapshot) atomicReference.get()).E();
                z10 = false;
                if (E != null) {
                    if (E.e()) {
                        z10 = true;
                    }
                }
            }
            if (z10) {
                SnapshotKt.B();
            }
        }

        public final b o(Function1 function1, Function1 function12) {
            b Q;
            j H = SnapshotKt.H();
            b bVar = H instanceof b ? (b) H : null;
            if (bVar == null || (Q = bVar.Q(function1, function12)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            return Q;
        }
    }

    private j(int i11, SnapshotIdSet snapshotIdSet) {
        this.f4081a = snapshotIdSet;
        this.f4082b = i11;
        this.f4084d = i11 != 0 ? SnapshotKt.c0(i11, g()) : -1;
    }

    public /* synthetic */ j(int i11, SnapshotIdSet snapshotIdSet, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, snapshotIdSet);
    }

    public final void b() {
        synchronized (SnapshotKt.I()) {
            c();
            r();
            Unit unit = Unit.f67184a;
        }
    }

    public void c() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.f4000d;
        SnapshotKt.f4000d = snapshotIdSet.l(f());
    }

    public void d() {
        this.f4083c = true;
        synchronized (SnapshotKt.I()) {
            q();
            Unit unit = Unit.f67184a;
        }
    }

    public final boolean e() {
        return this.f4083c;
    }

    public int f() {
        return this.f4082b;
    }

    public SnapshotIdSet g() {
        return this.f4081a;
    }

    public abstract Function1 h();

    public abstract boolean i();

    public int j() {
        return 0;
    }

    public abstract Function1 k();

    public j l() {
        v2 v2Var;
        v2 v2Var2;
        v2Var = SnapshotKt.f3998b;
        j jVar = (j) v2Var.a();
        v2Var2 = SnapshotKt.f3998b;
        v2Var2.b(this);
        return jVar;
    }

    public abstract void m(j jVar);

    public abstract void n(j jVar);

    public abstract void o();

    public abstract void p(c0 c0Var);

    public final void q() {
        int i11 = this.f4084d;
        if (i11 >= 0) {
            SnapshotKt.Y(i11);
            this.f4084d = -1;
        }
    }

    public void r() {
        q();
    }

    public void s(j jVar) {
        v2 v2Var;
        v2Var = SnapshotKt.f3998b;
        v2Var.b(jVar);
    }

    public final void t(boolean z10) {
        this.f4083c = z10;
    }

    public void u(int i11) {
        this.f4082b = i11;
    }

    public void v(SnapshotIdSet snapshotIdSet) {
        this.f4081a = snapshotIdSet;
    }

    public void w(int i11) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract j x(Function1 function1);

    public final int y() {
        int i11 = this.f4084d;
        this.f4084d = -1;
        return i11;
    }

    public final void z() {
        if (this.f4083c) {
            o1.a("Cannot use a disposed snapshot");
        }
    }
}
