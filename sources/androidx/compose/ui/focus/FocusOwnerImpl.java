package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.i0;
import androidx.compose.ui.f;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.node.q0;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.unit.LayoutDirection;
import d0.c;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class FocusOwnerImpl implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f4274a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f4275b;

    /* renamed from: c, reason: collision with root package name */
    private final Function0 f4276c;

    /* renamed from: d, reason: collision with root package name */
    private final Function0 f4277d;

    /* renamed from: e, reason: collision with root package name */
    private final Function0 f4278e;

    /* renamed from: g, reason: collision with root package name */
    private final FocusInvalidationManager f4280g;

    /* renamed from: j, reason: collision with root package name */
    private i0 f4283j;

    /* renamed from: f, reason: collision with root package name */
    private FocusTargetNode f4279f = new FocusTargetNode();

    /* renamed from: h, reason: collision with root package name */
    private final v f4281h = new v();

    /* renamed from: i, reason: collision with root package name */
    private final androidx.compose.ui.f f4282i = l.a(androidx.compose.ui.f.f4253a, new Function1<k, Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((k) obj);
            return Unit.f67184a;
        }

        public final void invoke(k kVar) {
            kVar.r(false);
        }
    }).e(new l0() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$2
        public boolean equals(Object other) {
            return other == this;
        }

        public int hashCode() {
            return FocusOwnerImpl.this.q().hashCode();
        }

        @Override // androidx.compose.ui.node.l0
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public FocusTargetNode a() {
            return FocusOwnerImpl.this.q();
        }

        @Override // androidx.compose.ui.node.l0
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(FocusTargetNode node) {
        }
    });

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4284a;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f4284a = iArr;
        }
    }

    public FocusOwnerImpl(Function1 function1, Function2 function2, Function1 function12, Function0 function0, Function0 function02, Function0 function03) {
        this.f4274a = function2;
        this.f4275b = function12;
        this.f4276c = function0;
        this.f4277d = function02;
        this.f4278e = function03;
        this.f4280g = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        if (this.f4279f.K1() == FocusStateImpl.Inactive) {
            this.f4276c.invoke();
        }
    }

    private final f.c s(androidx.compose.ui.node.f fVar) {
        int a11 = s0.a(1024) | s0.a(8192);
        if (!fVar.getNode().k1()) {
            g0.a.b("visitLocalDescendants called on an unattached node");
        }
        f.c node = fVar.getNode();
        f.c cVar = null;
        if ((node.a1() & a11) != 0) {
            for (f.c b12 = node.b1(); b12 != null; b12 = b12.b1()) {
                if ((b12.f1() & a11) != 0) {
                    if ((s0.a(1024) & b12.f1()) != 0) {
                        return cVar;
                    }
                    cVar = b12;
                }
            }
        }
        return cVar;
    }

    private final boolean t(KeyEvent keyEvent) {
        long a11 = d0.d.a(keyEvent);
        int b11 = d0.d.b(keyEvent);
        c.a aVar = d0.c.f61245a;
        if (d0.c.e(b11, aVar.a())) {
            i0 i0Var = this.f4283j;
            if (i0Var == null) {
                i0Var = new i0(3);
                this.f4283j = i0Var;
            }
            i0Var.l(a11);
        } else if (d0.c.e(b11, aVar.b())) {
            i0 i0Var2 = this.f4283j;
            if (i0Var2 == null || !i0Var2.a(a11)) {
                return false;
            }
            i0 i0Var3 = this.f4283j;
            if (i0Var3 != null) {
                i0Var3.m(a11);
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.focus.i
    public void a(c cVar) {
        this.f4280g.e(cVar);
    }

    @Override // androidx.compose.ui.focus.i
    public boolean b(b bVar, y.i iVar) {
        return ((Boolean) this.f4274a.invoke(bVar, iVar)).booleanValue();
    }

    @Override // androidx.compose.ui.focus.i
    public v c() {
        return this.f4281h;
    }

    @Override // androidx.compose.ui.focus.i
    public boolean d(KeyEvent keyEvent) {
        q0 e02;
        if (this.f4280g.b()) {
            throw new IllegalStateException("Dispatching intercepted soft keyboard event while focus system is invalidated.");
        }
        FocusTargetNode b11 = w.b(this.f4279f);
        if (b11 != null) {
            int a11 = s0.a(131072);
            if (!b11.getNode().k1()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            f.c node = b11.getNode();
            LayoutNode m11 = androidx.compose.ui.node.g.m(b11);
            while (m11 != null) {
                if ((m11.e0().k().a1() & a11) != 0) {
                    while (node != null) {
                        if ((node.f1() & a11) != 0) {
                            f.c cVar = node;
                            androidx.compose.runtime.collection.b bVar = null;
                            while (cVar != null) {
                                if ((cVar.f1() & a11) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                    int i11 = 0;
                                    for (f.c E1 = ((androidx.compose.ui.node.i) cVar).E1(); E1 != null; E1 = E1.b1()) {
                                        if ((E1.f1() & a11) != 0) {
                                            i11++;
                                            if (i11 == 1) {
                                                cVar = E1;
                                            } else {
                                                if (bVar == null) {
                                                    bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                }
                                                if (cVar != null) {
                                                    bVar.b(cVar);
                                                    cVar = null;
                                                }
                                                bVar.b(E1);
                                            }
                                        }
                                    }
                                    if (i11 == 1) {
                                    }
                                }
                                cVar = androidx.compose.ui.node.g.g(bVar);
                            }
                        }
                        node = node.h1();
                    }
                }
                m11 = m11.h0();
                node = (m11 == null || (e02 = m11.e0()) == null) ? null : e02.o();
            }
            android.support.v4.media.session.c.a(null);
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.i
    public Boolean e(int i11, y.i iVar, final Function1 function1) {
        final FocusTargetNode b11 = w.b(this.f4279f);
        if (b11 != null) {
            FocusRequester a11 = w.a(b11, i11, (LayoutDirection) this.f4278e.invoke());
            FocusRequester.a aVar = FocusRequester.f4298b;
            if (Intrinsics.c(a11, aVar.a())) {
                return null;
            }
            if (!Intrinsics.c(a11, aVar.b())) {
                return Boolean.valueOf(a11.c(function1));
            }
        } else {
            b11 = null;
        }
        return w.e(this.f4279f, i11, (LayoutDirection) this.f4278e.invoke(), iVar, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean booleanValue;
                if (Intrinsics.c(focusTargetNode, FocusTargetNode.this)) {
                    booleanValue = false;
                } else {
                    if (Intrinsics.c(focusTargetNode, this.q())) {
                        throw new IllegalStateException("Focus search landed at the root.");
                    }
                    booleanValue = ((Boolean) function1.invoke(focusTargetNode)).booleanValue();
                }
                return Boolean.valueOf(booleanValue);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // androidx.compose.ui.focus.i
    public boolean f(f0.b bVar) {
        f0.a aVar;
        int size;
        q0 e02;
        androidx.compose.ui.node.i iVar;
        q0 e03;
        if (this.f4280g.b()) {
            throw new IllegalStateException("Dispatching rotary event while focus system is invalidated.");
        }
        FocusTargetNode b11 = w.b(this.f4279f);
        if (b11 != null) {
            int a11 = s0.a(16384);
            if (!b11.getNode().k1()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            f.c node = b11.getNode();
            LayoutNode m11 = androidx.compose.ui.node.g.m(b11);
            loop0: while (true) {
                if (m11 == null) {
                    iVar = 0;
                    break;
                }
                if ((m11.e0().k().a1() & a11) != 0) {
                    while (node != null) {
                        if ((node.f1() & a11) != 0) {
                            ?? r102 = 0;
                            iVar = node;
                            while (iVar != 0) {
                                if (iVar instanceof f0.a) {
                                    break loop0;
                                }
                                if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                                    f.c E1 = iVar.E1();
                                    int i11 = 0;
                                    iVar = iVar;
                                    r102 = r102;
                                    while (E1 != null) {
                                        if ((E1.f1() & a11) != 0) {
                                            i11++;
                                            r102 = r102;
                                            if (i11 == 1) {
                                                iVar = E1;
                                            } else {
                                                if (r102 == 0) {
                                                    r102 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                }
                                                if (iVar != 0) {
                                                    r102.b(iVar);
                                                    iVar = 0;
                                                }
                                                r102.b(E1);
                                            }
                                        }
                                        E1 = E1.b1();
                                        iVar = iVar;
                                        r102 = r102;
                                    }
                                    if (i11 == 1) {
                                    }
                                }
                                iVar = androidx.compose.ui.node.g.g(r102);
                            }
                        }
                        node = node.h1();
                    }
                }
                m11 = m11.h0();
                node = (m11 == null || (e03 = m11.e0()) == null) ? null : e03.o();
            }
            aVar = (f0.a) iVar;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            int a12 = s0.a(16384);
            if (!aVar.getNode().k1()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            f.c h12 = aVar.getNode().h1();
            LayoutNode m12 = androidx.compose.ui.node.g.m(aVar);
            ArrayList arrayList = null;
            while (m12 != null) {
                if ((m12.e0().k().a1() & a12) != 0) {
                    while (h12 != null) {
                        if ((h12.f1() & a12) != 0) {
                            f.c cVar = h12;
                            androidx.compose.runtime.collection.b bVar2 = null;
                            while (cVar != null) {
                                if (cVar instanceof f0.a) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(cVar);
                                } else if ((cVar.f1() & a12) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                    int i12 = 0;
                                    for (f.c E12 = ((androidx.compose.ui.node.i) cVar).E1(); E12 != null; E12 = E12.b1()) {
                                        if ((E12.f1() & a12) != 0) {
                                            i12++;
                                            if (i12 == 1) {
                                                cVar = E12;
                                            } else {
                                                if (bVar2 == null) {
                                                    bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                }
                                                if (cVar != null) {
                                                    bVar2.b(cVar);
                                                    cVar = null;
                                                }
                                                bVar2.b(E12);
                                            }
                                        }
                                    }
                                    if (i12 == 1) {
                                    }
                                }
                                cVar = androidx.compose.ui.node.g.g(bVar2);
                            }
                        }
                        h12 = h12.h1();
                    }
                }
                m12 = m12.h0();
                h12 = (m12 == null || (e02 = m12.e0()) == null) ? null : e02.o();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i13 = size - 1;
                    if (((f0.a) arrayList.get(size)).J0(bVar)) {
                        return true;
                    }
                    if (i13 < 0) {
                        break;
                    }
                    size = i13;
                }
            }
            androidx.compose.ui.node.i node2 = aVar.getNode();
            ?? r22 = 0;
            while (node2 != 0) {
                if (node2 instanceof f0.a) {
                    if (((f0.a) node2).J0(bVar)) {
                        return true;
                    }
                } else if ((node2.f1() & a12) != 0 && (node2 instanceof androidx.compose.ui.node.i)) {
                    f.c E13 = node2.E1();
                    int i14 = 0;
                    node2 = node2;
                    r22 = r22;
                    while (E13 != null) {
                        if ((E13.f1() & a12) != 0) {
                            i14++;
                            r22 = r22;
                            if (i14 == 1) {
                                node2 = E13;
                            } else {
                                if (r22 == 0) {
                                    r22 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                }
                                if (node2 != 0) {
                                    r22.b(node2);
                                    node2 = 0;
                                }
                                r22.b(E13);
                            }
                        }
                        E13 = E13.b1();
                        node2 = node2;
                        r22 = r22;
                    }
                    if (i14 == 1) {
                    }
                }
                node2 = androidx.compose.ui.node.g.g(r22);
            }
            androidx.compose.ui.node.i node3 = aVar.getNode();
            ?? r23 = 0;
            while (node3 != 0) {
                if (node3 instanceof f0.a) {
                    if (((f0.a) node3).X0(bVar)) {
                        return true;
                    }
                } else if ((node3.f1() & a12) != 0 && (node3 instanceof androidx.compose.ui.node.i)) {
                    f.c E14 = node3.E1();
                    int i15 = 0;
                    node3 = node3;
                    r23 = r23;
                    while (E14 != null) {
                        if ((E14.f1() & a12) != 0) {
                            i15++;
                            r23 = r23;
                            if (i15 == 1) {
                                node3 = E14;
                            } else {
                                if (r23 == 0) {
                                    r23 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                }
                                if (node3 != 0) {
                                    r23.b(node3);
                                    node3 = 0;
                                }
                                r23.b(E14);
                            }
                        }
                        E14 = E14.b1();
                        node3 = node3;
                        r23 = r23;
                    }
                    if (i15 == 1) {
                    }
                }
                node3 = androidx.compose.ui.node.g.g(r23);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    if (((f0.a) arrayList.get(i16)).X0(bVar)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.i
    public void g(FocusTargetNode focusTargetNode) {
        this.f4280g.g(focusTargetNode);
    }

    @Override // androidx.compose.ui.focus.i
    public androidx.compose.ui.f h() {
        return this.f4282i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r11v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v64 */
    /* JADX WARN: Type inference failed for: r11v65 */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v67 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r5v10, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v9, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    @Override // androidx.compose.ui.focus.i
    public boolean i(KeyEvent keyEvent, Function0 function0) {
        androidx.compose.ui.node.i iVar;
        f.c node;
        q0 e02;
        androidx.compose.ui.node.i iVar2;
        q0 e03;
        q0 e04;
        if (this.f4280g.b()) {
            throw new IllegalStateException("Dispatching key event while focus system is invalidated.");
        }
        if (!t(keyEvent)) {
            return false;
        }
        FocusTargetNode b11 = w.b(this.f4279f);
        if (b11 == null || (node = s(b11)) == null) {
            if (b11 != null) {
                int a11 = s0.a(8192);
                if (!b11.getNode().k1()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                f.c node2 = b11.getNode();
                LayoutNode m11 = androidx.compose.ui.node.g.m(b11);
                loop10: while (true) {
                    if (m11 == null) {
                        iVar2 = 0;
                        break;
                    }
                    if ((m11.e0().k().a1() & a11) != 0) {
                        while (node2 != null) {
                            if ((node2.f1() & a11) != 0) {
                                ?? r12 = 0;
                                iVar2 = node2;
                                while (iVar2 != 0) {
                                    if (iVar2 instanceof d0.e) {
                                        break loop10;
                                    }
                                    if ((iVar2.f1() & a11) != 0 && (iVar2 instanceof androidx.compose.ui.node.i)) {
                                        f.c E1 = iVar2.E1();
                                        int i11 = 0;
                                        iVar2 = iVar2;
                                        r12 = r12;
                                        while (E1 != null) {
                                            if ((E1.f1() & a11) != 0) {
                                                i11++;
                                                r12 = r12;
                                                if (i11 == 1) {
                                                    iVar2 = E1;
                                                } else {
                                                    if (r12 == 0) {
                                                        r12 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                    }
                                                    if (iVar2 != 0) {
                                                        r12.b(iVar2);
                                                        iVar2 = 0;
                                                    }
                                                    r12.b(E1);
                                                }
                                            }
                                            E1 = E1.b1();
                                            iVar2 = iVar2;
                                            r12 = r12;
                                        }
                                        if (i11 == 1) {
                                        }
                                    }
                                    iVar2 = androidx.compose.ui.node.g.g(r12);
                                }
                            }
                            node2 = node2.h1();
                        }
                    }
                    m11 = m11.h0();
                    node2 = (m11 == null || (e03 = m11.e0()) == null) ? null : e03.o();
                }
                d0.e eVar = (d0.e) iVar2;
                if (eVar != null) {
                    node = eVar.getNode();
                }
            }
            FocusTargetNode focusTargetNode = this.f4279f;
            int a12 = s0.a(8192);
            if (!focusTargetNode.getNode().k1()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            f.c h12 = focusTargetNode.getNode().h1();
            LayoutNode m12 = androidx.compose.ui.node.g.m(focusTargetNode);
            loop14: while (true) {
                if (m12 == null) {
                    iVar = 0;
                    break;
                }
                if ((m12.e0().k().a1() & a12) != 0) {
                    while (h12 != null) {
                        if ((h12.f1() & a12) != 0) {
                            ?? r122 = 0;
                            iVar = h12;
                            while (iVar != 0) {
                                if (iVar instanceof d0.e) {
                                    break loop14;
                                }
                                if ((iVar.f1() & a12) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                                    f.c E12 = iVar.E1();
                                    int i12 = 0;
                                    iVar = iVar;
                                    r122 = r122;
                                    while (E12 != null) {
                                        if ((E12.f1() & a12) != 0) {
                                            i12++;
                                            r122 = r122;
                                            if (i12 == 1) {
                                                iVar = E12;
                                            } else {
                                                if (r122 == 0) {
                                                    r122 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                }
                                                if (iVar != 0) {
                                                    r122.b(iVar);
                                                    iVar = 0;
                                                }
                                                r122.b(E12);
                                            }
                                        }
                                        E12 = E12.b1();
                                        iVar = iVar;
                                        r122 = r122;
                                    }
                                    if (i12 == 1) {
                                    }
                                }
                                iVar = androidx.compose.ui.node.g.g(r122);
                            }
                        }
                        h12 = h12.h1();
                    }
                }
                m12 = m12.h0();
                h12 = (m12 == null || (e02 = m12.e0()) == null) ? null : e02.o();
            }
            d0.e eVar2 = (d0.e) iVar;
            node = eVar2 != null ? eVar2.getNode() : null;
        }
        if (node != null) {
            int a13 = s0.a(8192);
            if (!node.getNode().k1()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            f.c h13 = node.getNode().h1();
            LayoutNode m13 = androidx.compose.ui.node.g.m(node);
            ArrayList arrayList = null;
            while (m13 != null) {
                if ((m13.e0().k().a1() & a13) != 0) {
                    while (h13 != null) {
                        if ((h13.f1() & a13) != 0) {
                            f.c cVar = h13;
                            androidx.compose.runtime.collection.b bVar = null;
                            while (cVar != null) {
                                if (cVar instanceof d0.e) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(cVar);
                                } else if ((cVar.f1() & a13) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                    int i13 = 0;
                                    for (f.c E13 = ((androidx.compose.ui.node.i) cVar).E1(); E13 != null; E13 = E13.b1()) {
                                        if ((E13.f1() & a13) != 0) {
                                            i13++;
                                            if (i13 == 1) {
                                                cVar = E13;
                                            } else {
                                                if (bVar == null) {
                                                    bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                }
                                                if (cVar != null) {
                                                    bVar.b(cVar);
                                                    cVar = null;
                                                }
                                                bVar.b(E13);
                                            }
                                        }
                                    }
                                    if (i13 == 1) {
                                    }
                                }
                                cVar = androidx.compose.ui.node.g.g(bVar);
                            }
                        }
                        h13 = h13.h1();
                    }
                }
                m13 = m13.h0();
                h13 = (m13 == null || (e04 = m13.e0()) == null) ? null : e04.o();
            }
            if (arrayList != null) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i14 = size - 1;
                        if (((d0.e) arrayList.get(size)).l0(keyEvent)) {
                            return true;
                        }
                        if (i14 < 0) {
                            break;
                        }
                        size = i14;
                    }
                }
                Unit unit = Unit.f67184a;
            }
            androidx.compose.ui.node.i node3 = node.getNode();
            ?? r62 = 0;
            while (node3 != 0) {
                if (node3 instanceof d0.e) {
                    if (((d0.e) node3).l0(keyEvent)) {
                        return true;
                    }
                } else if ((node3.f1() & a13) != 0 && (node3 instanceof androidx.compose.ui.node.i)) {
                    f.c E14 = node3.E1();
                    int i15 = 0;
                    node3 = node3;
                    r62 = r62;
                    while (E14 != null) {
                        if ((E14.f1() & a13) != 0) {
                            i15++;
                            r62 = r62;
                            if (i15 == 1) {
                                node3 = E14;
                            } else {
                                if (r62 == 0) {
                                    r62 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                }
                                if (node3 != 0) {
                                    r62.b(node3);
                                    node3 = 0;
                                }
                                r62.b(E14);
                            }
                        }
                        E14 = E14.b1();
                        node3 = node3;
                        r62 = r62;
                    }
                    if (i15 == 1) {
                    }
                }
                node3 = androidx.compose.ui.node.g.g(r62);
            }
            if (((Boolean) function0.invoke()).booleanValue()) {
                return true;
            }
            androidx.compose.ui.node.i node4 = node.getNode();
            ?? r63 = 0;
            while (node4 != 0) {
                if (node4 instanceof d0.e) {
                    if (((d0.e) node4).s0(keyEvent)) {
                        return true;
                    }
                } else if ((node4.f1() & a13) != 0 && (node4 instanceof androidx.compose.ui.node.i)) {
                    f.c E15 = node4.E1();
                    int i16 = 0;
                    node4 = node4;
                    r63 = r63;
                    while (E15 != null) {
                        if ((E15.f1() & a13) != 0) {
                            i16++;
                            r63 = r63;
                            if (i16 == 1) {
                                node4 = E15;
                            } else {
                                if (r63 == 0) {
                                    r63 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                }
                                if (node4 != 0) {
                                    r63.b(node4);
                                    node4 = 0;
                                }
                                r63.b(E15);
                            }
                        }
                        E15 = E15.b1();
                        node4 = node4;
                        r63 = r63;
                    }
                    if (i16 == 1) {
                    }
                }
                node4 = androidx.compose.ui.node.g.g(r63);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    if (((d0.e) arrayList.get(i17)).s0(keyEvent)) {
                        return true;
                    }
                }
                Unit unit2 = Unit.f67184a;
            }
            Unit unit3 = Unit.f67184a;
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.i
    public boolean j(boolean z10, boolean z11, boolean z12, int i11) {
        boolean z13;
        boolean c11;
        androidx.compose.runtime.collection.b bVar;
        v c12 = c();
        FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m104invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m104invoke() {
            }
        };
        try {
            z13 = c12.f4330c;
            if (z13) {
                c12.g();
            }
            c12.f();
            if (focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 != null) {
                bVar = c12.f4329b;
                bVar.b(focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1);
            }
            if (!z10) {
                int i12 = a.f4284a[FocusTransactionsKt.e(this.f4279f, i11).ordinal()];
                if (i12 == 1 || i12 == 2 || i12 == 3) {
                    c11 = false;
                    if (c11 && z12) {
                        this.f4276c.invoke();
                    }
                    return c11;
                }
            }
            c11 = FocusTransactionsKt.c(this.f4279f, z10, z11);
            if (c11) {
                this.f4276c.invoke();
            }
            return c11;
        } finally {
            c12.h();
        }
    }

    @Override // androidx.compose.ui.focus.i
    public r k() {
        return this.f4279f.K1();
    }

    @Override // androidx.compose.ui.focus.i
    public void l(m mVar) {
        this.f4280g.f(mVar);
    }

    @Override // androidx.compose.ui.focus.i
    public y.i m() {
        FocusTargetNode b11 = w.b(this.f4279f);
        if (b11 != null) {
            return w.d(b11);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.i
    public void n() {
        boolean z10;
        v c11 = c();
        z10 = c11.f4330c;
        if (z10) {
            FocusTransactionsKt.c(this.f4279f, true, true);
            return;
        }
        try {
            c11.f();
            FocusTransactionsKt.c(this.f4279f, true, true);
        } finally {
            c11.h();
        }
    }

    @Override // androidx.compose.ui.focus.g
    public void o(boolean z10) {
        j(z10, true, true, b.f4312b.c());
    }

    public final FocusTargetNode q() {
        return this.f4279f;
    }
}
