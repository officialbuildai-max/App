package androidx.compose.ui;

import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.v1;

/* loaded from: classes.dex */
public interface f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4253a = a.f4254b;

    /* loaded from: classes.dex */
    public static final class a implements f {

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ a f4254b = new a();

        private a() {
        }

        @Override // androidx.compose.ui.f
        public Object b(Object obj, Function2 function2) {
            return obj;
        }

        @Override // androidx.compose.ui.f
        public boolean c(Function1 function1) {
            return true;
        }

        @Override // androidx.compose.ui.f
        public f e(f fVar) {
            return fVar;
        }

        public String toString() {
            return "Modifier";
        }
    }

    /* loaded from: classes.dex */
    public interface b extends f {
    }

    /* loaded from: classes.dex */
    public static abstract class c implements androidx.compose.ui.node.f {

        /* renamed from: b, reason: collision with root package name */
        private n0 f4256b;

        /* renamed from: c, reason: collision with root package name */
        private int f4257c;

        /* renamed from: e, reason: collision with root package name */
        private c f4259e;

        /* renamed from: f, reason: collision with root package name */
        private c f4260f;

        /* renamed from: g, reason: collision with root package name */
        private ObserverNodeOwnerScope f4261g;

        /* renamed from: h, reason: collision with root package name */
        private NodeCoordinator f4262h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f4263i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f4264j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f4265k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f4266l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f4267m;

        /* renamed from: a, reason: collision with root package name */
        private c f4255a = this;

        /* renamed from: d, reason: collision with root package name */
        private int f4258d = -1;

        public final void A1(boolean z10) {
            this.f4264j = z10;
        }

        public final void B1(Function0 function0) {
            androidx.compose.ui.node.g.n(this).registerOnEndApplyChangesListener(function0);
        }

        public void C1(NodeCoordinator nodeCoordinator) {
            this.f4262h = nodeCoordinator;
        }

        public final int a1() {
            return this.f4258d;
        }

        public final c b1() {
            return this.f4260f;
        }

        public final NodeCoordinator c1() {
            return this.f4262h;
        }

        public final n0 d1() {
            n0 n0Var = this.f4256b;
            if (n0Var != null) {
                return n0Var;
            }
            n0 a11 = o0.a(androidx.compose.ui.node.g.n(this).getCoroutineContext().plus(v1.a((t1) androidx.compose.ui.node.g.n(this).getCoroutineContext().get(t1.f68119l1))));
            this.f4256b = a11;
            return a11;
        }

        public final boolean e1() {
            return this.f4263i;
        }

        public final int f1() {
            return this.f4257c;
        }

        public final ObserverNodeOwnerScope g1() {
            return this.f4261g;
        }

        @Override // androidx.compose.ui.node.f
        public final c getNode() {
            return this.f4255a;
        }

        public final c h1() {
            return this.f4259e;
        }

        public boolean i1() {
            return true;
        }

        public final boolean j1() {
            return this.f4264j;
        }

        public final boolean k1() {
            return this.f4267m;
        }

        public void l1() {
            if (this.f4267m) {
                g0.a.b("node attached multiple times");
            }
            if (!(this.f4262h != null)) {
                g0.a.b("attach invoked on a node without a coordinator");
            }
            this.f4267m = true;
            this.f4265k = true;
        }

        public void m1() {
            if (!this.f4267m) {
                g0.a.b("Cannot detach a node that is not attached");
            }
            if (this.f4265k) {
                g0.a.b("Must run runAttachLifecycle() before markAsDetached()");
            }
            if (this.f4266l) {
                g0.a.b("Must run runDetachLifecycle() before markAsDetached()");
            }
            this.f4267m = false;
            n0 n0Var = this.f4256b;
            if (n0Var != null) {
                o0.c(n0Var, new ModifierNodeDetachedCancellationException());
                this.f4256b = null;
            }
        }

        public void n1() {
        }

        public void o1() {
        }

        public void p1() {
        }

        public void q1() {
            if (!this.f4267m) {
                g0.a.b("reset() called on an unattached node");
            }
            p1();
        }

        public void r1() {
            if (!this.f4267m) {
                g0.a.b("Must run markAsAttached() prior to runAttachLifecycle");
            }
            if (!this.f4265k) {
                g0.a.b("Must run runAttachLifecycle() only once after markAsAttached()");
            }
            this.f4265k = false;
            n1();
            this.f4266l = true;
        }

        public void s1() {
            if (!this.f4267m) {
                g0.a.b("node detached multiple times");
            }
            if (!(this.f4262h != null)) {
                g0.a.b("detach invoked on a node without a coordinator");
            }
            if (!this.f4266l) {
                g0.a.b("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }
            this.f4266l = false;
            o1();
        }

        public final void t1(int i11) {
            this.f4258d = i11;
        }

        public void u1(c cVar) {
            this.f4255a = cVar;
        }

        public final void v1(c cVar) {
            this.f4260f = cVar;
        }

        public final void w1(boolean z10) {
            this.f4263i = z10;
        }

        public final void x1(int i11) {
            this.f4257c = i11;
        }

        public final void y1(ObserverNodeOwnerScope observerNodeOwnerScope) {
            this.f4261g = observerNodeOwnerScope;
        }

        public final void z1(c cVar) {
            this.f4259e = cVar;
        }
    }

    Object b(Object obj, Function2 function2);

    boolean c(Function1 function1);

    f e(f fVar);
}
