package androidx.compose.ui.modifier;

import androidx.compose.ui.f;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.s0;
import androidx.compose.ui.node.y0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class ModifierLocalManager {

    /* renamed from: a, reason: collision with root package name */
    private final y0 f5273a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5274b = new androidx.compose.runtime.collection.b(new BackwardsCompatNode[16], 0);

    /* renamed from: c, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5275c = new androidx.compose.runtime.collection.b(new c[16], 0);

    /* renamed from: d, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5276d = new androidx.compose.runtime.collection.b(new LayoutNode[16], 0);

    /* renamed from: e, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5277e = new androidx.compose.runtime.collection.b(new c[16], 0);

    /* renamed from: f, reason: collision with root package name */
    private boolean f5278f;

    public ModifierLocalManager(y0 y0Var) {
        this.f5273a = y0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    private final void c(f.c cVar, c cVar2, Set set) {
        int a11 = s0.a(32);
        if (!cVar.getNode().k1()) {
            g0.a.b("visitSubtreeIf called on an unattached node");
        }
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new f.c[16], 0);
        f.c b12 = cVar.getNode().b1();
        if (b12 == null) {
            androidx.compose.ui.node.g.c(bVar, cVar.getNode());
        } else {
            bVar.b(b12);
        }
        while (bVar.q()) {
            f.c cVar3 = (f.c) bVar.v(bVar.n() - 1);
            if ((cVar3.a1() & a11) != 0) {
                for (f.c cVar4 = cVar3; cVar4 != null; cVar4 = cVar4.b1()) {
                    if ((cVar4.f1() & a11) != 0) {
                        androidx.compose.ui.node.i iVar = cVar4;
                        ?? r82 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof h) {
                                h hVar = (h) iVar;
                                if (hVar instanceof BackwardsCompatNode) {
                                    BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) hVar;
                                    if ((backwardsCompatNode.D1() instanceof d) && backwardsCompatNode.E1().contains(cVar2)) {
                                        set.add(hVar);
                                    }
                                }
                                if (hVar.V().a(cVar2)) {
                                    break;
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                                f.c E1 = iVar.E1();
                                int i11 = 0;
                                iVar = iVar;
                                r82 = r82;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        r82 = r82;
                                        if (i11 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r82 == 0) {
                                                r82 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r82.b(iVar);
                                                iVar = 0;
                                            }
                                            r82.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r82 = r82;
                                }
                                if (i11 == 1) {
                                }
                            }
                            iVar = androidx.compose.ui.node.g.g(r82);
                        }
                    }
                }
            }
            androidx.compose.ui.node.g.c(bVar, cVar3);
        }
    }

    public final void a(BackwardsCompatNode backwardsCompatNode, c cVar) {
        this.f5274b.b(backwardsCompatNode);
        this.f5275c.b(cVar);
        b();
    }

    public final void b() {
        if (this.f5278f) {
            return;
        }
        this.f5278f = true;
        this.f5273a.registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager$invalidate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m120invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m120invoke() {
                ModifierLocalManager.this.e();
            }
        });
    }

    public final void d(BackwardsCompatNode backwardsCompatNode, c cVar) {
        this.f5276d.b(androidx.compose.ui.node.g.m(backwardsCompatNode));
        this.f5277e.b(cVar);
        b();
    }

    public final void e() {
        int i11 = 0;
        this.f5278f = false;
        HashSet hashSet = new HashSet();
        androidx.compose.runtime.collection.b bVar = this.f5276d;
        int n11 = bVar.n();
        if (n11 > 0) {
            Object[] m11 = bVar.m();
            int i12 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) m11[i12];
                c cVar = (c) this.f5277e.m()[i12];
                if (layoutNode.e0().k().k1()) {
                    c(layoutNode.e0().k(), cVar, hashSet);
                }
                i12++;
            } while (i12 < n11);
        }
        this.f5276d.h();
        this.f5277e.h();
        androidx.compose.runtime.collection.b bVar2 = this.f5274b;
        int n12 = bVar2.n();
        if (n12 > 0) {
            Object[] m12 = bVar2.m();
            do {
                BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) m12[i11];
                c cVar2 = (c) this.f5275c.m()[i11];
                if (backwardsCompatNode.k1()) {
                    c(backwardsCompatNode, cVar2, hashSet);
                }
                i11++;
            } while (i11 < n12);
        }
        this.f5274b.h();
        this.f5275c.h();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((BackwardsCompatNode) it.next()).J1();
        }
    }

    public final void f(BackwardsCompatNode backwardsCompatNode, c cVar) {
        this.f5274b.b(backwardsCompatNode);
        this.f5275c.b(cVar);
        b();
    }
}
