package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class OwnerSnapshotObserver {

    /* renamed from: i, reason: collision with root package name */
    public static final int f5446i = SnapshotStateObserver.f4013k;

    /* renamed from: a, reason: collision with root package name */
    private final SnapshotStateObserver f5447a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f5448b = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.d1(layoutNode, false, false, false, 7, null);
            }
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final Function1 f5449c = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingMeasure$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.h1(layoutNode, false, false, false, 7, null);
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private final Function1 f5450d = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingSemantics$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                layoutNode.B0();
            }
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final Function1 f5451e = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.f1(layoutNode, false, 1, null);
            }
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private final Function1 f5452f = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.f1(layoutNode, false, 1, null);
            }
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private final Function1 f5453g = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.b1(layoutNode, false, 1, null);
            }
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private final Function1 f5454h = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookahead$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(LayoutNode layoutNode) {
            if (layoutNode.isValidOwnerScope()) {
                LayoutNode.b1(layoutNode, false, 1, null);
            }
        }
    };

    public OwnerSnapshotObserver(Function1 function1) {
        this.f5447a = new SnapshotStateObserver(function1);
    }

    public static /* synthetic */ void d(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z10, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        ownerSnapshotObserver.c(layoutNode, z10, function0);
    }

    public static /* synthetic */ void f(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z10, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        ownerSnapshotObserver.e(layoutNode, z10, function0);
    }

    public static /* synthetic */ void h(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z10, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        ownerSnapshotObserver.g(layoutNode, z10, function0);
    }

    public final void a(Object obj) {
        this.f5447a.k(obj);
    }

    public final void b() {
        this.f5447a.l(new Function1<Object, Boolean>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$clearInvalidObservations$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.ui.node.OwnerScope");
                return Boolean.valueOf(!((z0) obj).isValidOwnerScope());
            }
        });
    }

    public final void c(LayoutNode layoutNode, boolean z10, Function0 function0) {
        if (!z10 || layoutNode.V() == null) {
            i(layoutNode, this.f5452f, function0);
        } else {
            i(layoutNode, this.f5453g, function0);
        }
    }

    public final void e(LayoutNode layoutNode, boolean z10, Function0 function0) {
        if (!z10 || layoutNode.V() == null) {
            i(layoutNode, this.f5451e, function0);
        } else {
            i(layoutNode, this.f5454h, function0);
        }
    }

    public final void g(LayoutNode layoutNode, boolean z10, Function0 function0) {
        if (!z10 || layoutNode.V() == null) {
            i(layoutNode, this.f5449c, function0);
        } else {
            i(layoutNode, this.f5448b, function0);
        }
    }

    public final void i(z0 z0Var, Function1 function1, Function0 function0) {
        this.f5447a.o(z0Var, function1, function0);
    }

    public final void j(LayoutNode layoutNode, Function0 function0) {
        i(layoutNode, this.f5450d, function0);
    }

    public final void k() {
        this.f5447a.s();
    }

    public final void l() {
        this.f5447a.t();
        this.f5447a.j();
    }
}
