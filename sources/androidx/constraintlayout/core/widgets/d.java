package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import androidx.core.view.InputDeviceCompat;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class d extends t0.c {
    private int Y0;

    /* renamed from: b1, reason: collision with root package name */
    public androidx.constraintlayout.core.e f7091b1;

    /* renamed from: d1, reason: collision with root package name */
    int f7093d1;

    /* renamed from: e1, reason: collision with root package name */
    int f7094e1;

    /* renamed from: f1, reason: collision with root package name */
    int f7095f1;

    /* renamed from: g1, reason: collision with root package name */
    int f7096g1;
    androidx.constraintlayout.core.widgets.analyzer.b W0 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
    public androidx.constraintlayout.core.widgets.analyzer.d X0 = new androidx.constraintlayout.core.widgets.analyzer.d(this);
    protected b.InterfaceC0060b Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f7090a1 = false;

    /* renamed from: c1, reason: collision with root package name */
    protected androidx.constraintlayout.core.d f7092c1 = new androidx.constraintlayout.core.d();

    /* renamed from: h1, reason: collision with root package name */
    public int f7097h1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    public int f7098i1 = 0;

    /* renamed from: j1, reason: collision with root package name */
    c[] f7099j1 = new c[4];

    /* renamed from: k1, reason: collision with root package name */
    c[] f7100k1 = new c[4];

    /* renamed from: l1, reason: collision with root package name */
    public boolean f7101l1 = false;

    /* renamed from: m1, reason: collision with root package name */
    public boolean f7102m1 = false;

    /* renamed from: n1, reason: collision with root package name */
    public boolean f7103n1 = false;

    /* renamed from: o1, reason: collision with root package name */
    public int f7104o1 = 0;

    /* renamed from: p1, reason: collision with root package name */
    public int f7105p1 = 0;

    /* renamed from: q1, reason: collision with root package name */
    private int f7106q1 = InputDeviceCompat.SOURCE_KEYBOARD;

    /* renamed from: r1, reason: collision with root package name */
    public boolean f7107r1 = false;

    /* renamed from: s1, reason: collision with root package name */
    private boolean f7108s1 = false;

    /* renamed from: t1, reason: collision with root package name */
    private boolean f7109t1 = false;

    /* renamed from: u1, reason: collision with root package name */
    int f7110u1 = 0;

    /* renamed from: v1, reason: collision with root package name */
    private WeakReference f7111v1 = null;

    /* renamed from: w1, reason: collision with root package name */
    private WeakReference f7112w1 = null;

    /* renamed from: x1, reason: collision with root package name */
    private WeakReference f7113x1 = null;

    /* renamed from: y1, reason: collision with root package name */
    private WeakReference f7114y1 = null;

    /* renamed from: z1, reason: collision with root package name */
    HashSet f7115z1 = new HashSet();
    public b.a A1 = new b.a();

    private void B1(ConstraintWidget constraintWidget) {
        int i11 = this.f7097h1 + 1;
        c[] cVarArr = this.f7100k1;
        if (i11 >= cVarArr.length) {
            this.f7100k1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f7100k1[this.f7097h1] = new c(constraintWidget, 0, U1());
        this.f7097h1++;
    }

    private void E1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f7092c1.h(solverVariable, this.f7092c1.q(constraintAnchor), 0, 5);
    }

    private void F1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f7092c1.h(this.f7092c1.q(constraintAnchor), solverVariable, 0, 5);
    }

    private void G1(ConstraintWidget constraintWidget) {
        int i11 = this.f7098i1 + 1;
        c[] cVarArr = this.f7099j1;
        if (i11 >= cVarArr.length) {
            this.f7099j1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f7099j1[this.f7098i1] = new c(constraintWidget, 1, U1());
        this.f7098i1++;
    }

    public static boolean X1(int i11, ConstraintWidget constraintWidget, b.InterfaceC0060b interfaceC0060b, b.a aVar, int i12) {
        int i13;
        int i14;
        if (interfaceC0060b == null) {
            return false;
        }
        if (constraintWidget.X() == 8 || (constraintWidget instanceof f) || (constraintWidget instanceof a)) {
            aVar.f7019e = 0;
            aVar.f7020f = 0;
            return false;
        }
        aVar.f7015a = constraintWidget.C();
        aVar.f7016b = constraintWidget.V();
        aVar.f7017c = constraintWidget.Y();
        aVar.f7018d = constraintWidget.z();
        aVar.f7023i = false;
        aVar.f7024j = i12;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f7015a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f7016b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.f6942f0 > 0.0f;
        boolean z13 = z11 && constraintWidget.f6942f0 > 0.0f;
        if (z10 && constraintWidget.c0(0) && constraintWidget.f6975w == 0 && !z12) {
            aVar.f7015a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.f6977x == 0) {
                aVar.f7015a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z10 = false;
        }
        if (z11 && constraintWidget.c0(1) && constraintWidget.f6977x == 0 && !z13) {
            aVar.f7016b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z10 && constraintWidget.f6975w == 0) {
                aVar.f7016b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (constraintWidget.p0()) {
            aVar.f7015a = ConstraintWidget.DimensionBehaviour.FIXED;
            z10 = false;
        }
        if (constraintWidget.q0()) {
            aVar.f7016b = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (z12) {
            if (constraintWidget.f6979y[0] == 4) {
                aVar.f7015a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = aVar.f7016b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i14 = aVar.f7018d;
                } else {
                    aVar.f7015a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0060b.b(constraintWidget, aVar);
                    i14 = aVar.f7020f;
                }
                aVar.f7015a = dimensionBehaviour4;
                aVar.f7017c = (int) (constraintWidget.x() * i14);
            }
        }
        if (z13) {
            if (constraintWidget.f6979y[1] == 4) {
                aVar.f7016b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z10) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = aVar.f7015a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i13 = aVar.f7017c;
                } else {
                    aVar.f7016b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0060b.b(constraintWidget, aVar);
                    i13 = aVar.f7019e;
                }
                aVar.f7016b = dimensionBehaviour6;
                if (constraintWidget.y() == -1) {
                    aVar.f7018d = (int) (i13 / constraintWidget.x());
                } else {
                    aVar.f7018d = (int) (constraintWidget.x() * i13);
                }
            }
        }
        interfaceC0060b.b(constraintWidget, aVar);
        constraintWidget.o1(aVar.f7019e);
        constraintWidget.P0(aVar.f7020f);
        constraintWidget.O0(aVar.f7022h);
        constraintWidget.E0(aVar.f7021g);
        aVar.f7024j = b.a.f7012k;
        return aVar.f7023i;
    }

    private void Z1() {
        this.f7097h1 = 0;
        this.f7098i1 = 0;
    }

    public boolean A1(androidx.constraintlayout.core.d dVar) {
        boolean Y1 = Y1(64);
        g(dVar, Y1);
        int size = this.V0.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i11);
            constraintWidget.W0(0, false);
            constraintWidget.W0(1, false);
            if (constraintWidget instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.V0.get(i12);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).C1();
                }
            }
        }
        this.f7115z1.clear();
        for (int i13 = 0; i13 < size; i13++) {
            ConstraintWidget constraintWidget3 = (ConstraintWidget) this.V0.get(i13);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof i) {
                    this.f7115z1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(dVar, Y1);
                }
            }
        }
        while (this.f7115z1.size() > 0) {
            int size2 = this.f7115z1.size();
            Iterator it = this.f7115z1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i iVar = (i) ((ConstraintWidget) it.next());
                if (iVar.z1(this.f7115z1)) {
                    iVar.g(dVar, Y1);
                    this.f7115z1.remove(iVar);
                    break;
                }
            }
            if (size2 == this.f7115z1.size()) {
                Iterator it2 = this.f7115z1.iterator();
                while (it2.hasNext()) {
                    ((ConstraintWidget) it2.next()).g(dVar, Y1);
                }
                this.f7115z1.clear();
            }
        }
        if (androidx.constraintlayout.core.d.f6721r) {
            HashSet hashSet = new HashSet();
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget4 = (ConstraintWidget) this.V0.get(i14);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            e(this, dVar, hashSet, C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) it3.next();
                g.a(this, dVar, constraintWidget5);
                constraintWidget5.g(dVar, Y1);
            }
        } else {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) this.V0.get(i15);
                if (constraintWidget6 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.f6934b0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(dVar, Y1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.T0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.k1(dimensionBehaviour2);
                    }
                } else {
                    g.a(this, dVar, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(dVar, Y1);
                    }
                }
            }
        }
        if (this.f7097h1 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.f7098i1 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    public void C1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f7114y1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f7114y1.get()).e()) {
            this.f7114y1 = new WeakReference(constraintAnchor);
        }
    }

    public void D1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f7112w1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f7112w1.get()).e()) {
            this.f7112w1 = new WeakReference(constraintAnchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f7113x1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f7113x1.get()).e()) {
            this.f7113x1 = new WeakReference(constraintAnchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.f7111v1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.f7111v1.get()).e()) {
            this.f7111v1 = new WeakReference(constraintAnchor);
        }
    }

    public boolean J1(boolean z10) {
        return this.X0.f(z10);
    }

    public boolean K1(boolean z10) {
        return this.X0.g(z10);
    }

    public boolean L1(boolean z10, int i11) {
        return this.X0.h(z10, i11);
    }

    public void M1(androidx.constraintlayout.core.e eVar) {
        this.f7091b1 = eVar;
        this.f7092c1.v(eVar);
    }

    public b.InterfaceC0060b N1() {
        return this.Z0;
    }

    public int O1() {
        return this.f7106q1;
    }

    public androidx.constraintlayout.core.d P1() {
        return this.f7092c1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void Q(StringBuilder sb2) {
        sb2.append(this.f6959o + ":{\n");
        sb2.append("  actualWidth:" + this.f6938d0);
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.f6940e0);
        sb2.append("\n");
        Iterator it = v1().iterator();
        while (it.hasNext()) {
            ((ConstraintWidget) it.next()).Q(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }

    public boolean Q1() {
        return false;
    }

    public void R1() {
        this.X0.j();
    }

    public void S1() {
        this.X0.k();
    }

    public boolean T1() {
        return this.f7109t1;
    }

    public boolean U1() {
        return this.f7090a1;
    }

    public boolean V1() {
        return this.f7108s1;
    }

    public long W1(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.f7093d1 = i18;
        this.f7094e1 = i19;
        return this.W0.d(this, i11, i18, i19, i12, i13, i14, i15, i16, i17);
    }

    public boolean Y1(int i11) {
        return (this.f7106q1 & i11) == i11;
    }

    public void a2(b.InterfaceC0060b interfaceC0060b) {
        this.Z0 = interfaceC0060b;
        this.X0.n(interfaceC0060b);
    }

    public void b2(int i11) {
        this.f7106q1 = i11;
        androidx.constraintlayout.core.d.f6721r = Y1(512);
    }

    public void c2(int i11) {
        this.Y0 = i11;
    }

    public void d2(boolean z10) {
        this.f7090a1 = z10;
    }

    public boolean e2(androidx.constraintlayout.core.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean Y1 = Y1(64);
        u1(dVar, Y1);
        int size = this.V0.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i11);
            constraintWidget.u1(dVar, Y1);
            if (constraintWidget.e0()) {
                z10 = true;
            }
        }
        return z10;
    }

    public void f2() {
        this.W0.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void t1(boolean z10, boolean z11) {
        super.t1(z10, z11);
        int size = this.V0.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((ConstraintWidget) this.V0.get(i11)).t1(z10, z11);
        }
    }

    @Override // t0.c, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void v0() {
        this.f7092c1.E();
        this.f7093d1 = 0;
        this.f7095f1 = 0;
        this.f7094e1 = 0;
        this.f7096g1 = 0;
        this.f7107r1 = false;
        super.v0();
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x031b  */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // t0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w1() {
        /*
            Method dump skipped, instructions count: 824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.d.w1():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z1(ConstraintWidget constraintWidget, int i11) {
        if (i11 == 0) {
            B1(constraintWidget);
        } else if (i11 == 1) {
            G1(constraintWidget);
        }
    }
}
