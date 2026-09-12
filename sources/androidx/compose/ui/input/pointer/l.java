package androidx.compose.ui.input.pointer;

import androidx.compose.ui.f;
import androidx.compose.ui.node.e1;
import androidx.compose.ui.node.s0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class l extends m {

    /* renamed from: c, reason: collision with root package name */
    private final f.c f5081c;

    /* renamed from: f, reason: collision with root package name */
    private androidx.compose.ui.layout.l f5084f;

    /* renamed from: g, reason: collision with root package name */
    private o f5085g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5086h;

    /* renamed from: d, reason: collision with root package name */
    private final e0.b f5082d = new e0.b();

    /* renamed from: e, reason: collision with root package name */
    private final androidx.collection.x f5083e = new androidx.collection.x(2);

    /* renamed from: i, reason: collision with root package name */
    private boolean f5087i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5088j = true;

    public l(f.c cVar) {
        this.f5081c = cVar;
    }

    private final void j() {
        this.f5083e.b();
        this.f5084f = null;
    }

    private final boolean m(o oVar, o oVar2) {
        if (oVar == null || oVar.b().size() != oVar2.b().size()) {
            return true;
        }
        int size = oVar2.b().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!y.g.j(((w) oVar.b().get(i11)).h(), ((w) oVar2.b().get(i11)).h())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01fb  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    @Override // androidx.compose.ui.input.pointer.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(androidx.collection.x r37, androidx.compose.ui.layout.l r38, androidx.compose.ui.input.pointer.g r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.l.a(androidx.collection.x, androidx.compose.ui.layout.l, androidx.compose.ui.input.pointer.g, boolean):boolean");
    }

    @Override // androidx.compose.ui.input.pointer.m
    public void b(g gVar) {
        super.b(gVar);
        o oVar = this.f5085g;
        if (oVar == null) {
            return;
        }
        this.f5086h = this.f5087i;
        List b11 = oVar.b();
        int size = b11.size();
        for (int i11 = 0; i11 < size; i11++) {
            w wVar = (w) b11.get(i11);
            boolean i12 = wVar.i();
            boolean a11 = gVar.a(wVar.f());
            boolean z10 = this.f5087i;
            if ((!i12 && !a11) || (!i12 && !z10)) {
                this.f5082d.i(wVar.f());
            }
        }
        this.f5087i = false;
        this.f5088j = q.i(oVar.e(), q.f5098a.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // androidx.compose.ui.input.pointer.m
    public void d() {
        androidx.compose.runtime.collection.b g11 = g();
        int n11 = g11.n();
        if (n11 > 0) {
            Object[] m11 = g11.m();
            int i11 = 0;
            do {
                ((l) m11[i11]).d();
                i11++;
            } while (i11 < n11);
        }
        androidx.compose.ui.node.i iVar = this.f5081c;
        int a11 = s0.a(16);
        ?? r62 = 0;
        while (iVar != 0) {
            if (iVar instanceof e1) {
                ((e1) iVar).t0();
            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                f.c E1 = iVar.E1();
                int i12 = 0;
                iVar = iVar;
                r62 = r62;
                while (E1 != null) {
                    if ((E1.f1() & a11) != 0) {
                        i12++;
                        r62 = r62;
                        if (i12 == 1) {
                            iVar = E1;
                        } else {
                            if (r62 == 0) {
                                r62 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                            }
                            if (iVar != 0) {
                                r62.b(iVar);
                                iVar = 0;
                            }
                            r62.b(E1);
                        }
                    }
                    E1 = E1.b1();
                    iVar = iVar;
                    r62 = r62;
                }
                if (i12 == 1) {
                }
            }
            iVar = androidx.compose.ui.node.g.g(r62);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
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
    @Override // androidx.compose.ui.input.pointer.m
    public boolean e(g gVar) {
        androidx.compose.runtime.collection.b g11;
        int n11;
        boolean z10 = false;
        int i11 = 0;
        z10 = false;
        if (!this.f5083e.i() && this.f5081c.k1()) {
            o oVar = this.f5085g;
            Intrinsics.e(oVar);
            androidx.compose.ui.layout.l lVar = this.f5084f;
            Intrinsics.e(lVar);
            long k11 = lVar.k();
            androidx.compose.ui.node.i iVar = this.f5081c;
            int a11 = s0.a(16);
            ?? r82 = 0;
            while (iVar != 0) {
                if (iVar instanceof e1) {
                    ((e1) iVar).M(oVar, PointerEventPass.Final, k11);
                } else if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                    f.c E1 = iVar.E1();
                    int i12 = 0;
                    iVar = iVar;
                    r82 = r82;
                    while (E1 != null) {
                        if ((E1.f1() & a11) != 0) {
                            i12++;
                            r82 = r82;
                            if (i12 == 1) {
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
                    if (i12 == 1) {
                    }
                }
                iVar = androidx.compose.ui.node.g.g(r82);
            }
            if (this.f5081c.k1() && (n11 = (g11 = g()).n()) > 0) {
                Object[] m11 = g11.m();
                do {
                    ((l) m11[i11]).e(gVar);
                    i11++;
                } while (i11 < n11);
            }
            z10 = true;
        }
        b(gVar);
        j();
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r14v4, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // androidx.compose.ui.input.pointer.m
    public boolean f(androidx.collection.x xVar, androidx.compose.ui.layout.l lVar, g gVar, boolean z10) {
        androidx.compose.runtime.collection.b g11;
        int n11;
        if (this.f5083e.i() || !this.f5081c.k1()) {
            return false;
        }
        o oVar = this.f5085g;
        Intrinsics.e(oVar);
        androidx.compose.ui.layout.l lVar2 = this.f5084f;
        Intrinsics.e(lVar2);
        long k11 = lVar2.k();
        androidx.compose.ui.node.i iVar = this.f5081c;
        int a11 = s0.a(16);
        ?? r62 = 0;
        while (iVar != 0) {
            if (iVar instanceof e1) {
                ((e1) iVar).M(oVar, PointerEventPass.Initial, k11);
            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                f.c E1 = iVar.E1();
                int i11 = 0;
                iVar = iVar;
                r62 = r62;
                while (E1 != null) {
                    if ((E1.f1() & a11) != 0) {
                        i11++;
                        r62 = r62;
                        if (i11 == 1) {
                            iVar = E1;
                        } else {
                            if (r62 == 0) {
                                r62 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                            }
                            if (iVar != 0) {
                                r62.b(iVar);
                                iVar = 0;
                            }
                            r62.b(E1);
                        }
                    }
                    E1 = E1.b1();
                    iVar = iVar;
                    r62 = r62;
                }
                if (i11 == 1) {
                }
            }
            iVar = androidx.compose.ui.node.g.g(r62);
        }
        if (this.f5081c.k1() && (n11 = (g11 = g()).n()) > 0) {
            Object[] m11 = g11.m();
            int i12 = 0;
            do {
                l lVar3 = (l) m11[i12];
                androidx.collection.x xVar2 = this.f5083e;
                androidx.compose.ui.layout.l lVar4 = this.f5084f;
                Intrinsics.e(lVar4);
                lVar3.f(xVar2, lVar4, gVar, z10);
                i12++;
            } while (i12 < n11);
        }
        if (this.f5081c.k1()) {
            androidx.compose.ui.node.i iVar2 = this.f5081c;
            int a12 = s0.a(16);
            ?? r22 = 0;
            while (iVar2 != 0) {
                if (iVar2 instanceof e1) {
                    ((e1) iVar2).M(oVar, PointerEventPass.Main, k11);
                } else if ((iVar2.f1() & a12) != 0 && (iVar2 instanceof androidx.compose.ui.node.i)) {
                    f.c E12 = iVar2.E1();
                    int i13 = 0;
                    r22 = r22;
                    iVar2 = iVar2;
                    while (E12 != null) {
                        if ((E12.f1() & a12) != 0) {
                            i13++;
                            r22 = r22;
                            if (i13 == 1) {
                                iVar2 = E12;
                            } else {
                                if (r22 == 0) {
                                    r22 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                }
                                if (iVar2 != 0) {
                                    r22.b(iVar2);
                                    iVar2 = 0;
                                }
                                r22.b(E12);
                            }
                        }
                        E12 = E12.b1();
                        r22 = r22;
                        iVar2 = iVar2;
                    }
                    if (i13 == 1) {
                    }
                }
                iVar2 = androidx.compose.ui.node.g.g(r22);
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.m
    public void i(long j11, androidx.collection.l0 l0Var) {
        if (this.f5082d.d(j11) && !l0Var.a(this)) {
            this.f5082d.h(j11);
            this.f5083e.l(j11);
        }
        androidx.compose.runtime.collection.b g11 = g();
        int n11 = g11.n();
        if (n11 > 0) {
            Object[] m11 = g11.m();
            int i11 = 0;
            do {
                ((l) m11[i11]).i(j11, l0Var);
                i11++;
            } while (i11 < n11);
        }
    }

    public final f.c k() {
        return this.f5081c;
    }

    public final e0.b l() {
        return this.f5082d;
    }

    public final void n() {
        this.f5087i = true;
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.f5081c + ", children=" + g() + ", pointerIds=" + this.f5082d + ')';
    }
}
