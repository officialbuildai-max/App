package androidx.compose.ui.draganddrop;

import androidx.compose.ui.f;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.m1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class DragAndDropNode extends f.c implements m1, d {

    /* renamed from: r, reason: collision with root package name */
    public static final a f4208r = new a(null);

    /* renamed from: s, reason: collision with root package name */
    public static final int f4209s = 8;

    /* renamed from: n, reason: collision with root package name */
    private final Function1 f4210n;

    /* renamed from: o, reason: collision with root package name */
    private final Object f4211o = a.C0045a.f4214a;

    /* renamed from: p, reason: collision with root package name */
    private d f4212p;

    /* renamed from: q, reason: collision with root package name */
    private f f4213q;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: androidx.compose.ui.draganddrop.DragAndDropNode$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C0045a {

            /* renamed from: a, reason: collision with root package name */
            public static final C0045a f4214a = new C0045a();

            private C0045a() {
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DragAndDropNode(Function1 function1) {
        this.f4210n = function1;
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void B(b bVar) {
        f fVar = this.f4213q;
        if (fVar != null) {
            fVar.B(bVar);
            return;
        }
        d dVar = this.f4212p;
        if (dVar != null) {
            dVar.B(bVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    @Override // androidx.compose.ui.draganddrop.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(final androidx.compose.ui.draganddrop.b r4) {
        /*
            r3 = this;
            androidx.compose.ui.draganddrop.d r0 = r3.f4212p
            if (r0 == 0) goto L11
            long r1 = androidx.compose.ui.draganddrop.h.a(r4)
            boolean r1 = androidx.compose.ui.draganddrop.e.a(r0, r1)
            r2 = 1
            if (r1 != r2) goto L11
            r1 = r0
            goto L30
        L11:
            androidx.compose.ui.f$c r1 = r3.getNode()
            boolean r1 = r1.k1()
            if (r1 != 0) goto L1d
            r1 = 0
            goto L2e
        L1d:
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1 r2 = new androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1
            r2.<init>()
            androidx.compose.ui.node.n1.e(r3, r2)
            T r1 = r1.element
            androidx.compose.ui.node.m1 r1 = (androidx.compose.ui.node.m1) r1
        L2e:
            androidx.compose.ui.draganddrop.d r1 = (androidx.compose.ui.draganddrop.d) r1
        L30:
            if (r1 == 0) goto L3f
            if (r0 != 0) goto L3f
            androidx.compose.ui.draganddrop.e.b(r1, r4)
            androidx.compose.ui.draganddrop.f r0 = r3.f4213q
            if (r0 == 0) goto L6c
            r0.L(r4)
            goto L6c
        L3f:
            if (r1 != 0) goto L4e
            if (r0 == 0) goto L4e
            androidx.compose.ui.draganddrop.f r2 = r3.f4213q
            if (r2 == 0) goto L4a
            androidx.compose.ui.draganddrop.e.b(r2, r4)
        L4a:
            r0.L(r4)
            goto L6c
        L4e:
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r1, r0)
            if (r2 != 0) goto L5f
            if (r1 == 0) goto L59
            androidx.compose.ui.draganddrop.e.b(r1, r4)
        L59:
            if (r0 == 0) goto L6c
            r0.L(r4)
            goto L6c
        L5f:
            if (r1 == 0) goto L65
            r1.C(r4)
            goto L6c
        L65:
            androidx.compose.ui.draganddrop.f r0 = r3.f4213q
            if (r0 == 0) goto L6c
            r0.C(r4)
        L6c:
            r3.f4212p = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draganddrop.DragAndDropNode.C(androidx.compose.ui.draganddrop.b):void");
    }

    @Override // androidx.compose.ui.node.m1
    public Object D() {
        return this.f4211o;
    }

    public boolean D1(final b bVar) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        e.f(this, new Function1<DragAndDropNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$acceptDragAndDropTransfer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode$Companion$TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                f fVar;
                Function1 function1;
                f fVar2;
                if (!dragAndDropNode.k1()) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                fVar = dragAndDropNode.f4213q;
                if (!(fVar == null)) {
                    g0.a.b("DragAndDropTarget self reference must be null at the start of a drag and drop session");
                }
                function1 = dragAndDropNode.f4210n;
                dragAndDropNode.f4213q = (f) function1.invoke(b.this);
                fVar2 = dragAndDropNode.f4213q;
                boolean z10 = fVar2 != null;
                if (z10) {
                    androidx.compose.ui.node.g.n(this).getDragAndDropManager().b(dragAndDropNode);
                }
                Ref.BooleanRef booleanRef2 = booleanRef;
                booleanRef2.element = booleanRef2.element || z10;
                return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
            }
        });
        return booleanRef.element;
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void L(b bVar) {
        f fVar = this.f4213q;
        if (fVar != null) {
            fVar.L(bVar);
        }
        d dVar = this.f4212p;
        if (dVar != null) {
            dVar.L(bVar);
        }
        this.f4212p = null;
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void Z0(final b bVar) {
        e.f(this, new Function1<DragAndDropNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onEnded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode$Companion$TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                f fVar;
                if (!dragAndDropNode.getNode().k1()) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                fVar = dragAndDropNode.f4213q;
                if (fVar != null) {
                    fVar.Z0(b.this);
                }
                dragAndDropNode.f4213q = null;
                dragAndDropNode.f4212p = null;
                return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
            }
        });
    }

    @Override // androidx.compose.ui.draganddrop.f
    public void a0(b bVar) {
        f fVar = this.f4213q;
        if (fVar != null) {
            fVar.a0(bVar);
            return;
        }
        d dVar = this.f4212p;
        if (dVar != null) {
            dVar.a0(bVar);
        }
    }

    @Override // androidx.compose.ui.draganddrop.f
    public boolean k0(b bVar) {
        d dVar = this.f4212p;
        if (dVar != null) {
            return dVar.k0(bVar);
        }
        f fVar = this.f4213q;
        if (fVar != null) {
            return fVar.k0(bVar);
        }
        return false;
    }

    @Override // androidx.compose.ui.f.c
    public void o1() {
        this.f4213q = null;
        this.f4212p = null;
    }
}
