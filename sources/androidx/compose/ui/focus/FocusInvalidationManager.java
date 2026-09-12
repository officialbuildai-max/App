package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.w0;
import androidx.compose.ui.f;
import androidx.compose.ui.node.s0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class FocusInvalidationManager {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f4268a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f4269b;

    /* renamed from: c, reason: collision with root package name */
    private final MutableScatterSet f4270c = w0.a();

    /* renamed from: d, reason: collision with root package name */
    private final MutableScatterSet f4271d = w0.a();

    /* renamed from: e, reason: collision with root package name */
    private final MutableScatterSet f4272e = w0.a();

    /* renamed from: f, reason: collision with root package name */
    private final MutableScatterSet f4273f = w0.a();

    public FocusInvalidationManager(Function1 function1, Function0 function0) {
        this.f4268a = function1;
        this.f4269b = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        int i11;
        long[] jArr;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        r rVar;
        androidx.compose.runtime.collection.b bVar;
        int i12;
        int i13;
        int i14;
        long[] jArr3;
        Object[] objArr3;
        boolean z10;
        Object[] objArr4;
        boolean z11;
        int i15;
        androidx.compose.runtime.collection.b bVar2;
        long[] jArr4;
        long[] jArr5;
        int i16;
        long[] jArr6;
        long[] jArr7;
        MutableScatterSet mutableScatterSet = this.f4272e;
        Object[] objArr5 = mutableScatterSet.f2322b;
        long[] jArr8 = mutableScatterSet.f2321a;
        int length = jArr8.length - 2;
        char c11 = 7;
        long j11 = -9187201950435737472L;
        int i17 = 8;
        int i18 = 1;
        if (length >= 0) {
            int i19 = 0;
            while (true) {
                long j12 = jArr8[i19];
                if ((((~j12) << c11) & j12 & j11) != j11) {
                    int i20 = 8 - ((~(i19 - length)) >>> 31);
                    int i21 = 0;
                    while (i21 < i20) {
                        if ((j12 & 255) < 128) {
                            m mVar = (m) objArr5[(i19 << 3) + i21];
                            if (mVar.getNode().k1()) {
                                int a11 = s0.a(1024);
                                f.c node = mVar.getNode();
                                androidx.compose.runtime.collection.b bVar3 = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        this.f4270c.h((FocusTargetNode) node);
                                    } else if ((node.f1() & a11) != 0 && (node instanceof androidx.compose.ui.node.i)) {
                                        f.c E1 = ((androidx.compose.ui.node.i) node).E1();
                                        int i22 = 0;
                                        while (E1 != null) {
                                            if ((E1.f1() & a11) != 0) {
                                                i22++;
                                                if (i22 == i18) {
                                                    jArr7 = jArr8;
                                                    node = E1;
                                                } else {
                                                    if (bVar3 == null) {
                                                        jArr7 = jArr8;
                                                        bVar3 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                    } else {
                                                        jArr7 = jArr8;
                                                    }
                                                    if (node != null) {
                                                        bVar3.b(node);
                                                        node = null;
                                                    }
                                                    bVar3.b(E1);
                                                }
                                            } else {
                                                jArr7 = jArr8;
                                            }
                                            E1 = E1.b1();
                                            jArr8 = jArr7;
                                            i18 = 1;
                                        }
                                        jArr6 = jArr8;
                                        int i23 = i18;
                                        if (i22 == i23) {
                                            i18 = i23;
                                            jArr8 = jArr6;
                                        }
                                        node = androidx.compose.ui.node.g.g(bVar3);
                                        jArr8 = jArr6;
                                        i18 = 1;
                                    }
                                    jArr6 = jArr8;
                                    node = androidx.compose.ui.node.g.g(bVar3);
                                    jArr8 = jArr6;
                                    i18 = 1;
                                }
                                jArr5 = jArr8;
                                if (!mVar.getNode().k1()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                androidx.compose.runtime.collection.b bVar4 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                f.c b12 = mVar.getNode().b1();
                                if (b12 == null) {
                                    androidx.compose.ui.node.g.c(bVar4, mVar.getNode());
                                } else {
                                    bVar4.b(b12);
                                }
                                while (bVar4.q()) {
                                    f.c cVar = (f.c) bVar4.v(bVar4.n() - 1);
                                    if ((cVar.a1() & a11) == 0) {
                                        androidx.compose.ui.node.g.c(bVar4, cVar);
                                    } else {
                                        while (true) {
                                            if (cVar == null) {
                                                break;
                                            }
                                            if ((cVar.f1() & a11) != 0) {
                                                androidx.compose.runtime.collection.b bVar5 = null;
                                                while (cVar != null) {
                                                    if (cVar instanceof FocusTargetNode) {
                                                        this.f4270c.h((FocusTargetNode) cVar);
                                                    } else if ((cVar.f1() & a11) != 0 && (cVar instanceof androidx.compose.ui.node.i)) {
                                                        int i24 = 0;
                                                        for (f.c E12 = ((androidx.compose.ui.node.i) cVar).E1(); E12 != null; E12 = E12.b1()) {
                                                            if ((E12.f1() & a11) != 0) {
                                                                i24++;
                                                                if (i24 == 1) {
                                                                    cVar = E12;
                                                                } else {
                                                                    if (bVar5 == null) {
                                                                        bVar5 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                                    }
                                                                    if (cVar != null) {
                                                                        bVar5.b(cVar);
                                                                        cVar = null;
                                                                    }
                                                                    bVar5.b(E12);
                                                                }
                                                            }
                                                        }
                                                        if (i24 == 1) {
                                                        }
                                                    }
                                                    cVar = androidx.compose.ui.node.g.g(bVar5);
                                                }
                                            } else {
                                                cVar = cVar.b1();
                                            }
                                        }
                                    }
                                }
                            } else {
                                jArr5 = jArr8;
                            }
                            i16 = 8;
                        } else {
                            jArr5 = jArr8;
                            i16 = i17;
                        }
                        j12 >>= i16;
                        i21++;
                        i17 = i16;
                        jArr8 = jArr5;
                        i18 = 1;
                    }
                    jArr4 = jArr8;
                    if (i20 != i17) {
                        break;
                    }
                } else {
                    jArr4 = jArr8;
                }
                if (i19 == length) {
                    break;
                }
                i19++;
                jArr8 = jArr4;
                c11 = 7;
                j11 = -9187201950435737472L;
                i18 = 1;
                i17 = 8;
            }
        }
        this.f4272e.m();
        MutableScatterSet mutableScatterSet2 = this.f4271d;
        Object[] objArr6 = mutableScatterSet2.f2322b;
        long[] jArr9 = mutableScatterSet2.f2321a;
        int length2 = jArr9.length - 2;
        if (length2 >= 0) {
            int i25 = 0;
            while (true) {
                long j13 = jArr9[i25];
                if ((((~j13) << 7) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i26 = 8 - ((~(i25 - length2)) >>> 31);
                    int i27 = 0;
                    while (i27 < i26) {
                        if ((j13 & 255) < 128) {
                            c cVar2 = (c) objArr6[(i25 << 3) + i27];
                            if (cVar2.getNode().k1()) {
                                int a12 = s0.a(1024);
                                f.c node2 = cVar2.getNode();
                                boolean z12 = false;
                                boolean z13 = true;
                                FocusTargetNode focusTargetNode = null;
                                androidx.compose.runtime.collection.b bVar6 = null;
                                while (node2 != null) {
                                    if (node2 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node2;
                                        if (focusTargetNode != null) {
                                            z12 = true;
                                        }
                                        if (this.f4270c.a(focusTargetNode2)) {
                                            this.f4273f.h(focusTargetNode2);
                                            z13 = false;
                                        }
                                        jArr3 = jArr9;
                                        objArr3 = objArr6;
                                        focusTargetNode = focusTargetNode2;
                                    } else {
                                        if ((node2.f1() & a12) == 0 || !(node2 instanceof androidx.compose.ui.node.i)) {
                                            jArr3 = jArr9;
                                            objArr3 = objArr6;
                                            z10 = z12;
                                        } else {
                                            f.c E13 = ((androidx.compose.ui.node.i) node2).E1();
                                            jArr3 = jArr9;
                                            int i28 = 0;
                                            while (E13 != null) {
                                                if ((E13.f1() & a12) != 0) {
                                                    i28++;
                                                    objArr4 = objArr6;
                                                    if (i28 == 1) {
                                                        node2 = E13;
                                                    } else {
                                                        if (bVar6 == null) {
                                                            i15 = i28;
                                                            z11 = z12;
                                                            bVar2 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                        } else {
                                                            i15 = i28;
                                                            z11 = z12;
                                                            bVar2 = bVar6;
                                                        }
                                                        if (node2 != null) {
                                                            bVar2.b(node2);
                                                            node2 = null;
                                                        }
                                                        bVar2.b(E13);
                                                        bVar6 = bVar2;
                                                        i28 = i15;
                                                        E13 = E13.b1();
                                                        objArr6 = objArr4;
                                                        z12 = z11;
                                                    }
                                                } else {
                                                    objArr4 = objArr6;
                                                }
                                                z11 = z12;
                                                E13 = E13.b1();
                                                objArr6 = objArr4;
                                                z12 = z11;
                                            }
                                            objArr3 = objArr6;
                                            z10 = z12;
                                            if (i28 == 1) {
                                                jArr9 = jArr3;
                                                objArr6 = objArr3;
                                                z12 = z10;
                                            }
                                        }
                                        z12 = z10;
                                    }
                                    node2 = androidx.compose.ui.node.g.g(bVar6);
                                    jArr9 = jArr3;
                                    objArr6 = objArr3;
                                }
                                jArr2 = jArr9;
                                objArr2 = objArr6;
                                boolean z14 = z12;
                                if (!cVar2.getNode().k1()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                androidx.compose.runtime.collection.b bVar7 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                f.c b13 = cVar2.getNode().b1();
                                if (b13 == null) {
                                    androidx.compose.ui.node.g.c(bVar7, cVar2.getNode());
                                } else {
                                    bVar7.b(b13);
                                }
                                boolean z15 = z14;
                                while (bVar7.q()) {
                                    f.c cVar3 = (f.c) bVar7.v(bVar7.n() - 1);
                                    if ((cVar3.a1() & a12) == 0) {
                                        androidx.compose.ui.node.g.c(bVar7, cVar3);
                                    } else {
                                        while (cVar3 != null) {
                                            if ((cVar3.f1() & a12) != 0) {
                                                androidx.compose.runtime.collection.b bVar8 = null;
                                                while (cVar3 != null) {
                                                    if (cVar3 instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) cVar3;
                                                        if (focusTargetNode != null) {
                                                            z15 = true;
                                                        }
                                                        if (this.f4270c.a(focusTargetNode3)) {
                                                            this.f4273f.h(focusTargetNode3);
                                                            z13 = false;
                                                        }
                                                        bVar = bVar7;
                                                        focusTargetNode = focusTargetNode3;
                                                    } else if ((cVar3.f1() & a12) == 0 || !(cVar3 instanceof androidx.compose.ui.node.i)) {
                                                        bVar = bVar7;
                                                    } else {
                                                        f.c E14 = ((androidx.compose.ui.node.i) cVar3).E1();
                                                        bVar = bVar7;
                                                        int i29 = 0;
                                                        while (E14 != null) {
                                                            if ((E14.f1() & a12) != 0) {
                                                                i29++;
                                                                i13 = a12;
                                                                if (i29 == 1) {
                                                                    cVar3 = E14;
                                                                } else {
                                                                    if (bVar8 == null) {
                                                                        i14 = i29;
                                                                        bVar8 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                                                    } else {
                                                                        i14 = i29;
                                                                    }
                                                                    if (cVar3 != null) {
                                                                        bVar8.b(cVar3);
                                                                        cVar3 = null;
                                                                    }
                                                                    bVar8.b(E14);
                                                                    i29 = i14;
                                                                    E14 = E14.b1();
                                                                    a12 = i13;
                                                                }
                                                            } else {
                                                                i13 = a12;
                                                            }
                                                            E14 = E14.b1();
                                                            a12 = i13;
                                                        }
                                                        i12 = a12;
                                                        if (i29 == 1) {
                                                            bVar7 = bVar;
                                                            a12 = i12;
                                                        }
                                                        cVar3 = androidx.compose.ui.node.g.g(bVar8);
                                                        bVar7 = bVar;
                                                        a12 = i12;
                                                    }
                                                    i12 = a12;
                                                    cVar3 = androidx.compose.ui.node.g.g(bVar8);
                                                    bVar7 = bVar;
                                                    a12 = i12;
                                                }
                                            } else {
                                                cVar3 = cVar3.b1();
                                                a12 = a12;
                                            }
                                        }
                                    }
                                    bVar7 = bVar7;
                                    a12 = a12;
                                }
                                if (z13) {
                                    if (z15) {
                                        rVar = d.a(cVar2);
                                    } else if (focusTargetNode == null || (rVar = focusTargetNode.K1()) == null) {
                                        rVar = FocusStateImpl.Inactive;
                                    }
                                    cVar2.S0(rVar);
                                }
                                j13 >>= 8;
                                i27++;
                                jArr9 = jArr2;
                                objArr6 = objArr2;
                            } else {
                                cVar2.S0(FocusStateImpl.Inactive);
                            }
                        }
                        jArr2 = jArr9;
                        objArr2 = objArr6;
                        j13 >>= 8;
                        i27++;
                        jArr9 = jArr2;
                        objArr6 = objArr2;
                    }
                    jArr = jArr9;
                    objArr = objArr6;
                    i11 = 0;
                    if (i26 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr9;
                    objArr = objArr6;
                    i11 = 0;
                }
                if (i25 == length2) {
                    break;
                }
                i25++;
                jArr9 = jArr;
                objArr6 = objArr;
            }
        } else {
            i11 = 0;
        }
        this.f4271d.m();
        MutableScatterSet mutableScatterSet3 = this.f4270c;
        Object[] objArr7 = mutableScatterSet3.f2322b;
        long[] jArr10 = mutableScatterSet3.f2321a;
        int length3 = jArr10.length - 2;
        if (length3 >= 0) {
            int i30 = i11;
            while (true) {
                long j14 = jArr10[i30];
                if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i31 = 8 - ((~(i30 - length3)) >>> 31);
                    for (int i32 = i11; i32 < i31; i32++) {
                        if ((j14 & 255) < 128) {
                            FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr7[(i30 << 3) + i32];
                            if (focusTargetNode4.k1()) {
                                FocusStateImpl K1 = focusTargetNode4.K1();
                                focusTargetNode4.P1();
                                if (K1 != focusTargetNode4.K1() || this.f4273f.a(focusTargetNode4)) {
                                    d.c(focusTargetNode4);
                                }
                            }
                        }
                        j14 >>= 8;
                    }
                    if (i31 != 8) {
                        break;
                    }
                }
                if (i30 == length3) {
                    break;
                } else {
                    i30++;
                }
            }
        }
        this.f4270c.m();
        this.f4273f.m();
        this.f4269b.invoke();
        if (!this.f4272e.d()) {
            g0.a.b("Unprocessed FocusProperties nodes");
        }
        if (!this.f4271d.d()) {
            g0.a.b("Unprocessed FocusEvent nodes");
        }
        if (this.f4270c.d()) {
            return;
        }
        g0.a.b("Unprocessed FocusTarget nodes");
    }

    private final void d(MutableScatterSet mutableScatterSet, Object obj) {
        if (mutableScatterSet.h(obj) && this.f4270c.c() + this.f4271d.c() + this.f4272e.c() == 1) {
            this.f4268a.invoke(new FocusInvalidationManager$scheduleInvalidation$1(this));
        }
    }

    public final boolean b() {
        return this.f4270c.e() || this.f4272e.e() || this.f4271d.e();
    }

    public final void e(c cVar) {
        d(this.f4271d, cVar);
    }

    public final void f(m mVar) {
        d(this.f4272e, mVar);
    }

    public final void g(FocusTargetNode focusTargetNode) {
        d(this.f4270c, focusTargetNode);
    }
}
