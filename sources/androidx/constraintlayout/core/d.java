package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d {

    /* renamed from: r, reason: collision with root package name */
    public static boolean f6721r = false;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f6722s = true;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f6723t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f6724u = true;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f6725v = false;

    /* renamed from: w, reason: collision with root package name */
    private static int f6726w = 1000;

    /* renamed from: x, reason: collision with root package name */
    public static e f6727x;

    /* renamed from: y, reason: collision with root package name */
    public static long f6728y;

    /* renamed from: z, reason: collision with root package name */
    public static long f6729z;

    /* renamed from: d, reason: collision with root package name */
    private a f6733d;

    /* renamed from: g, reason: collision with root package name */
    androidx.constraintlayout.core.b[] f6736g;

    /* renamed from: n, reason: collision with root package name */
    final c f6743n;

    /* renamed from: q, reason: collision with root package name */
    private a f6746q;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6730a = false;

    /* renamed from: b, reason: collision with root package name */
    int f6731b = 0;

    /* renamed from: c, reason: collision with root package name */
    private HashMap f6732c = null;

    /* renamed from: e, reason: collision with root package name */
    private int f6734e = 32;

    /* renamed from: f, reason: collision with root package name */
    private int f6735f = 32;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6737h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6738i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean[] f6739j = new boolean[32];

    /* renamed from: k, reason: collision with root package name */
    int f6740k = 1;

    /* renamed from: l, reason: collision with root package name */
    int f6741l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f6742m = 32;

    /* renamed from: o, reason: collision with root package name */
    private SolverVariable[] f6744o = new SolverVariable[f6726w];

    /* renamed from: p, reason: collision with root package name */
    private int f6745p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(a aVar);

        SolverVariable b(d dVar, boolean[] zArr);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends androidx.constraintlayout.core.b {
        public b(c cVar) {
            this.f6715e = new h(this, cVar);
        }
    }

    public d() {
        this.f6736g = null;
        this.f6736g = new androidx.constraintlayout.core.b[32];
        D();
        c cVar = new c();
        this.f6743n = cVar;
        this.f6733d = new PriorityGoalRow(cVar);
        if (f6725v) {
            this.f6746q = new b(cVar);
        } else {
            this.f6746q = new androidx.constraintlayout.core.b(cVar);
        }
    }

    private final int C(a aVar, boolean z10) {
        e eVar = f6727x;
        if (eVar != null) {
            eVar.f6755h++;
        }
        for (int i11 = 0; i11 < this.f6740k; i11++) {
            this.f6739j[i11] = false;
        }
        boolean z11 = false;
        int i12 = 0;
        while (!z11) {
            e eVar2 = f6727x;
            if (eVar2 != null) {
                eVar2.f6756i++;
            }
            i12++;
            if (i12 >= this.f6740k * 2) {
                return i12;
            }
            if (aVar.getKey() != null) {
                this.f6739j[aVar.getKey().f6684c] = true;
            }
            SolverVariable b11 = aVar.b(this, this.f6739j);
            if (b11 != null) {
                boolean[] zArr = this.f6739j;
                int i13 = b11.f6684c;
                if (zArr[i13]) {
                    return i12;
                }
                zArr[i13] = true;
            }
            if (b11 != null) {
                float f11 = Float.MAX_VALUE;
                int i14 = -1;
                for (int i15 = 0; i15 < this.f6741l; i15++) {
                    androidx.constraintlayout.core.b bVar = this.f6736g[i15];
                    if (bVar.f6711a.f6691j != SolverVariable.Type.UNRESTRICTED && !bVar.f6716f && bVar.t(b11)) {
                        float i16 = bVar.f6715e.i(b11);
                        if (i16 < 0.0f) {
                            float f12 = (-bVar.f6712b) / i16;
                            if (f12 < f11) {
                                i14 = i15;
                                f11 = f12;
                            }
                        }
                    }
                }
                if (i14 > -1) {
                    androidx.constraintlayout.core.b bVar2 = this.f6736g[i14];
                    bVar2.f6711a.f6685d = -1;
                    e eVar3 = f6727x;
                    if (eVar3 != null) {
                        eVar3.f6757j++;
                    }
                    bVar2.x(b11);
                    SolverVariable solverVariable = bVar2.f6711a;
                    solverVariable.f6685d = i14;
                    solverVariable.i(this, bVar2);
                }
            } else {
                z11 = true;
            }
        }
        return i12;
    }

    private void D() {
        int i11 = 0;
        if (f6725v) {
            while (i11 < this.f6741l) {
                androidx.constraintlayout.core.b bVar = this.f6736g[i11];
                if (bVar != null) {
                    this.f6743n.f6717a.release(bVar);
                }
                this.f6736g[i11] = null;
                i11++;
            }
            return;
        }
        while (i11 < this.f6741l) {
            androidx.constraintlayout.core.b bVar2 = this.f6736g[i11];
            if (bVar2 != null) {
                this.f6743n.f6718b.release(bVar2);
            }
            this.f6736g[i11] = null;
            i11++;
        }
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.f6743n.f6719c.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, str);
            solverVariable.h(type, str);
        } else {
            solverVariable.f();
            solverVariable.h(type, str);
        }
        int i11 = this.f6745p;
        int i12 = f6726w;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            f6726w = i13;
            this.f6744o = (SolverVariable[]) Arrays.copyOf(this.f6744o, i13);
        }
        SolverVariable[] solverVariableArr = this.f6744o;
        int i14 = this.f6745p;
        this.f6745p = i14 + 1;
        solverVariableArr[i14] = solverVariable;
        return solverVariable;
    }

    private final void l(androidx.constraintlayout.core.b bVar) {
        int i11;
        if (f6723t && bVar.f6716f) {
            bVar.f6711a.g(this, bVar.f6712b);
        } else {
            androidx.constraintlayout.core.b[] bVarArr = this.f6736g;
            int i12 = this.f6741l;
            bVarArr[i12] = bVar;
            SolverVariable solverVariable = bVar.f6711a;
            solverVariable.f6685d = i12;
            this.f6741l = i12 + 1;
            solverVariable.i(this, bVar);
        }
        if (f6723t && this.f6730a) {
            int i13 = 0;
            while (i13 < this.f6741l) {
                if (this.f6736g[i13] == null) {
                    System.out.println("WTF");
                }
                androidx.constraintlayout.core.b bVar2 = this.f6736g[i13];
                if (bVar2 != null && bVar2.f6716f) {
                    bVar2.f6711a.g(this, bVar2.f6712b);
                    if (f6725v) {
                        this.f6743n.f6717a.release(bVar2);
                    } else {
                        this.f6743n.f6718b.release(bVar2);
                    }
                    this.f6736g[i13] = null;
                    int i14 = i13 + 1;
                    int i15 = i14;
                    while (true) {
                        i11 = this.f6741l;
                        if (i14 >= i11) {
                            break;
                        }
                        androidx.constraintlayout.core.b[] bVarArr2 = this.f6736g;
                        int i16 = i14 - 1;
                        androidx.constraintlayout.core.b bVar3 = bVarArr2[i14];
                        bVarArr2[i16] = bVar3;
                        SolverVariable solverVariable2 = bVar3.f6711a;
                        if (solverVariable2.f6685d == i14) {
                            solverVariable2.f6685d = i16;
                        }
                        i15 = i14;
                        i14++;
                    }
                    if (i15 < i11) {
                        this.f6736g[i15] = null;
                    }
                    this.f6741l = i11 - 1;
                    i13--;
                }
                i13++;
            }
            this.f6730a = false;
        }
    }

    private void n() {
        for (int i11 = 0; i11 < this.f6741l; i11++) {
            androidx.constraintlayout.core.b bVar = this.f6736g[i11];
            bVar.f6711a.f6687f = bVar.f6712b;
        }
    }

    public static androidx.constraintlayout.core.b s(d dVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f11) {
        return dVar.r().j(solverVariable, solverVariable2, f11);
    }

    private int u(a aVar) {
        for (int i11 = 0; i11 < this.f6741l; i11++) {
            androidx.constraintlayout.core.b bVar = this.f6736g[i11];
            if (bVar.f6711a.f6691j != SolverVariable.Type.UNRESTRICTED && bVar.f6712b < 0.0f) {
                boolean z10 = false;
                int i12 = 0;
                while (!z10) {
                    e eVar = f6727x;
                    if (eVar != null) {
                        eVar.f6758k++;
                    }
                    i12++;
                    float f11 = Float.MAX_VALUE;
                    int i13 = 0;
                    int i14 = -1;
                    int i15 = -1;
                    int i16 = 0;
                    while (true) {
                        if (i13 >= this.f6741l) {
                            break;
                        }
                        androidx.constraintlayout.core.b bVar2 = this.f6736g[i13];
                        if (bVar2.f6711a.f6691j != SolverVariable.Type.UNRESTRICTED && !bVar2.f6716f && bVar2.f6712b < 0.0f) {
                            int i17 = 9;
                            if (f6724u) {
                                int currentSize = bVar2.f6715e.getCurrentSize();
                                int i18 = 0;
                                while (i18 < currentSize) {
                                    SolverVariable b11 = bVar2.f6715e.b(i18);
                                    float i19 = bVar2.f6715e.i(b11);
                                    if (i19 > 0.0f) {
                                        int i20 = 0;
                                        while (i20 < i17) {
                                            float f12 = b11.f6689h[i20] / i19;
                                            if ((f12 < f11 && i20 == i16) || i20 > i16) {
                                                i16 = i20;
                                                i15 = b11.f6684c;
                                                i14 = i13;
                                                f11 = f12;
                                            }
                                            i20++;
                                            i17 = 9;
                                        }
                                    }
                                    i18++;
                                    i17 = 9;
                                }
                            } else {
                                for (int i21 = 1; i21 < this.f6740k; i21++) {
                                    SolverVariable solverVariable = this.f6743n.f6720d[i21];
                                    float i22 = bVar2.f6715e.i(solverVariable);
                                    if (i22 > 0.0f) {
                                        for (int i23 = 0; i23 < 9; i23++) {
                                            float f13 = solverVariable.f6689h[i23] / i22;
                                            if ((f13 < f11 && i23 == i16) || i23 > i16) {
                                                i16 = i23;
                                                i14 = i13;
                                                i15 = i21;
                                                f11 = f13;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i13++;
                    }
                    if (i14 != -1) {
                        androidx.constraintlayout.core.b bVar3 = this.f6736g[i14];
                        bVar3.f6711a.f6685d = -1;
                        e eVar2 = f6727x;
                        if (eVar2 != null) {
                            eVar2.f6757j++;
                        }
                        bVar3.x(this.f6743n.f6720d[i15]);
                        SolverVariable solverVariable2 = bVar3.f6711a;
                        solverVariable2.f6685d = i14;
                        solverVariable2.i(this, bVar3);
                    } else {
                        z10 = true;
                    }
                    if (i12 > this.f6740k / 2) {
                        z10 = true;
                    }
                }
                return i12;
            }
        }
        return 0;
    }

    public static e x() {
        return f6727x;
    }

    private void z() {
        int i11 = this.f6734e * 2;
        this.f6734e = i11;
        this.f6736g = (androidx.constraintlayout.core.b[]) Arrays.copyOf(this.f6736g, i11);
        c cVar = this.f6743n;
        cVar.f6720d = (SolverVariable[]) Arrays.copyOf(cVar.f6720d, this.f6734e);
        int i12 = this.f6734e;
        this.f6739j = new boolean[i12];
        this.f6735f = i12;
        this.f6742m = i12;
        e eVar = f6727x;
        if (eVar != null) {
            eVar.f6751d++;
            eVar.f6762o = Math.max(eVar.f6762o, i12);
            e eVar2 = f6727x;
            eVar2.f6772y = eVar2.f6762o;
        }
    }

    public void A() {
        e eVar = f6727x;
        if (eVar != null) {
            eVar.f6752e++;
        }
        if (this.f6733d.isEmpty()) {
            n();
            return;
        }
        if (!this.f6737h && !this.f6738i) {
            B(this.f6733d);
            return;
        }
        e eVar2 = f6727x;
        if (eVar2 != null) {
            eVar2.f6764q++;
        }
        for (int i11 = 0; i11 < this.f6741l; i11++) {
            if (!this.f6736g[i11].f6716f) {
                B(this.f6733d);
                return;
            }
        }
        e eVar3 = f6727x;
        if (eVar3 != null) {
            eVar3.f6763p++;
        }
        n();
    }

    void B(a aVar) {
        e eVar = f6727x;
        if (eVar != null) {
            eVar.f6767t++;
            eVar.f6768u = Math.max(eVar.f6768u, this.f6740k);
            e eVar2 = f6727x;
            eVar2.f6769v = Math.max(eVar2.f6769v, this.f6741l);
        }
        u(aVar);
        C(aVar, false);
        n();
    }

    public void E() {
        c cVar;
        int i11 = 0;
        while (true) {
            cVar = this.f6743n;
            SolverVariable[] solverVariableArr = cVar.f6720d;
            if (i11 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i11];
            if (solverVariable != null) {
                solverVariable.f();
            }
            i11++;
        }
        cVar.f6719c.a(this.f6744o, this.f6745p);
        this.f6745p = 0;
        Arrays.fill(this.f6743n.f6720d, (Object) null);
        HashMap hashMap = this.f6732c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f6731b = 0;
        this.f6733d.clear();
        this.f6740k = 1;
        for (int i12 = 0; i12 < this.f6741l; i12++) {
            androidx.constraintlayout.core.b bVar = this.f6736g[i12];
            if (bVar != null) {
                bVar.f6713c = false;
            }
        }
        D();
        this.f6741l = 0;
        if (f6725v) {
            this.f6746q = new b(this.f6743n);
        } else {
            this.f6746q = new androidx.constraintlayout.core.b(this.f6743n);
        }
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f11, int i11) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable q11 = q(constraintWidget.q(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable q12 = q(constraintWidget.q(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable q13 = q(constraintWidget.q(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable q14 = q(constraintWidget.q(type4));
        SolverVariable q15 = q(constraintWidget2.q(type));
        SolverVariable q16 = q(constraintWidget2.q(type2));
        SolverVariable q17 = q(constraintWidget2.q(type3));
        SolverVariable q18 = q(constraintWidget2.q(type4));
        androidx.constraintlayout.core.b r11 = r();
        double d11 = f11;
        double d12 = i11;
        r11.q(q12, q14, q16, q18, (float) (Math.sin(d11) * d12));
        d(r11);
        androidx.constraintlayout.core.b r12 = r();
        r12.q(q11, q13, q15, q17, (float) (Math.cos(d11) * d12));
        d(r12);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, float f11, SolverVariable solverVariable3, SolverVariable solverVariable4, int i12, int i13) {
        androidx.constraintlayout.core.b r11 = r();
        r11.h(solverVariable, solverVariable2, i11, f11, solverVariable3, solverVariable4, i12);
        if (i13 != 8) {
            r11.d(this, i13);
        }
        d(r11);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(androidx.constraintlayout.core.b r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L3
            return
        L3:
            androidx.constraintlayout.core.e r0 = androidx.constraintlayout.core.d.f6727x
            r1 = 1
            if (r0 == 0) goto L17
            long r3 = r0.f6753f
            long r3 = r3 + r1
            r0.f6753f = r3
            boolean r3 = r8.f6716f
            if (r3 == 0) goto L17
            long r3 = r0.f6754g
            long r3 = r3 + r1
            r0.f6754g = r3
        L17:
            int r0 = r7.f6741l
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.f6742m
            if (r0 >= r4) goto L26
            int r0 = r7.f6740k
            int r0 = r0 + r3
            int r4 = r7.f6735f
            if (r0 < r4) goto L29
        L26:
            r7.z()
        L29:
            boolean r0 = r8.f6716f
            r4 = 0
            if (r0 != 0) goto La1
            r8.D(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L38
            return
        L38:
            r8.r()
            boolean r0 = r8.f(r7)
            if (r0 == 0) goto L98
            androidx.constraintlayout.core.SolverVariable r0 = r7.p()
            r8.f6711a = r0
            int r5 = r7.f6741l
            r7.l(r8)
            int r6 = r7.f6741l
            int r5 = r5 + r3
            if (r6 != r5) goto L98
            androidx.constraintlayout.core.d$a r4 = r7.f6746q
            r4.a(r8)
            androidx.constraintlayout.core.d$a r4 = r7.f6746q
            r7.C(r4, r3)
            int r4 = r0.f6685d
            r5 = -1
            if (r4 != r5) goto L99
            androidx.constraintlayout.core.SolverVariable r4 = r8.f6711a
            if (r4 != r0) goto L76
            androidx.constraintlayout.core.SolverVariable r0 = r8.v(r0)
            if (r0 == 0) goto L76
            androidx.constraintlayout.core.e r4 = androidx.constraintlayout.core.d.f6727x
            if (r4 == 0) goto L73
            long r5 = r4.f6757j
            long r5 = r5 + r1
            r4.f6757j = r5
        L73:
            r8.x(r0)
        L76:
            boolean r0 = r8.f6716f
            if (r0 != 0) goto L7f
            androidx.constraintlayout.core.SolverVariable r0 = r8.f6711a
            r0.i(r7, r8)
        L7f:
            boolean r0 = androidx.constraintlayout.core.d.f6725v
            if (r0 == 0) goto L8b
            androidx.constraintlayout.core.c r0 = r7.f6743n
            androidx.constraintlayout.core.f r0 = r0.f6717a
            r0.release(r8)
            goto L92
        L8b:
            androidx.constraintlayout.core.c r0 = r7.f6743n
            androidx.constraintlayout.core.f r0 = r0.f6718b
            r0.release(r8)
        L92:
            int r0 = r7.f6741l
            int r0 = r0 - r3
            r7.f6741l = r0
            goto L99
        L98:
            r3 = r4
        L99:
            boolean r0 = r8.s()
            if (r0 != 0) goto La0
            return
        La0:
            r4 = r3
        La1:
            if (r4 != 0) goto La6
            r7.l(r8)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.d.d(androidx.constraintlayout.core.b):void");
    }

    public androidx.constraintlayout.core.b e(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        if (f6722s && i12 == 8 && solverVariable2.f6688g && solverVariable.f6685d == -1) {
            solverVariable.g(this, solverVariable2.f6687f + i11);
            return null;
        }
        androidx.constraintlayout.core.b r11 = r();
        r11.n(solverVariable, solverVariable2, i11);
        if (i12 != 8) {
            r11.d(this, i12);
        }
        d(r11);
        return r11;
    }

    public void f(SolverVariable solverVariable, int i11) {
        if (f6722s && solverVariable.f6685d == -1) {
            float f11 = i11;
            solverVariable.g(this, f11);
            for (int i12 = 0; i12 < this.f6731b + 1; i12++) {
                SolverVariable solverVariable2 = this.f6743n.f6720d[i12];
                if (solverVariable2 != null && solverVariable2.f6695n && solverVariable2.f6696o == solverVariable.f6684c) {
                    solverVariable2.g(this, solverVariable2.f6697p + f11);
                }
            }
            return;
        }
        int i13 = solverVariable.f6685d;
        if (i13 == -1) {
            androidx.constraintlayout.core.b r11 = r();
            r11.i(solverVariable, i11);
            d(r11);
            return;
        }
        androidx.constraintlayout.core.b bVar = this.f6736g[i13];
        if (bVar.f6716f) {
            bVar.f6712b = i11;
            return;
        }
        if (bVar.f6715e.getCurrentSize() == 0) {
            bVar.f6716f = true;
            bVar.f6712b = i11;
        } else {
            androidx.constraintlayout.core.b r12 = r();
            r12.m(solverVariable, i11);
            d(r12);
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, boolean z10) {
        androidx.constraintlayout.core.b r11 = r();
        SolverVariable t11 = t();
        t11.f6686e = 0;
        r11.o(solverVariable, solverVariable2, t11, i11);
        d(r11);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        androidx.constraintlayout.core.b r11 = r();
        SolverVariable t11 = t();
        t11.f6686e = 0;
        r11.o(solverVariable, solverVariable2, t11, i11);
        if (i12 != 8) {
            m(r11, (int) (r11.f6715e.i(t11) * (-1.0f)), i12);
        }
        d(r11);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, boolean z10) {
        androidx.constraintlayout.core.b r11 = r();
        SolverVariable t11 = t();
        t11.f6686e = 0;
        r11.p(solverVariable, solverVariable2, t11, i11);
        d(r11);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i11, int i12) {
        androidx.constraintlayout.core.b r11 = r();
        SolverVariable t11 = t();
        t11.f6686e = 0;
        r11.p(solverVariable, solverVariable2, t11, i11);
        if (i12 != 8) {
            m(r11, (int) (r11.f6715e.i(t11) * (-1.0f)), i12);
        }
        d(r11);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f11, int i11) {
        androidx.constraintlayout.core.b r11 = r();
        r11.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f11);
        if (i11 != 8) {
            r11.d(this, i11);
        }
        d(r11);
    }

    void m(androidx.constraintlayout.core.b bVar, int i11, int i12) {
        bVar.e(o(i12, null), i11);
    }

    public SolverVariable o(int i11, String str) {
        e eVar = f6727x;
        if (eVar != null) {
            eVar.f6759l++;
        }
        if (this.f6740k + 1 >= this.f6735f) {
            z();
        }
        SolverVariable a11 = a(SolverVariable.Type.ERROR, str);
        int i12 = this.f6731b + 1;
        this.f6731b = i12;
        this.f6740k++;
        a11.f6684c = i12;
        a11.f6686e = i11;
        this.f6743n.f6720d[i12] = a11;
        this.f6733d.c(a11);
        return a11;
    }

    public SolverVariable p() {
        e eVar = f6727x;
        if (eVar != null) {
            eVar.f6761n++;
        }
        if (this.f6740k + 1 >= this.f6735f) {
            z();
        }
        SolverVariable a11 = a(SolverVariable.Type.SLACK, null);
        int i11 = this.f6731b + 1;
        this.f6731b = i11;
        this.f6740k++;
        a11.f6684c = i11;
        this.f6743n.f6720d[i11] = a11;
        return a11;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f6740k + 1 >= this.f6735f) {
            z();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.i();
            if (solverVariable == null) {
                constraintAnchor.s(this.f6743n);
                solverVariable = constraintAnchor.i();
            }
            int i11 = solverVariable.f6684c;
            if (i11 == -1 || i11 > this.f6731b || this.f6743n.f6720d[i11] == null) {
                if (i11 != -1) {
                    solverVariable.f();
                }
                int i12 = this.f6731b + 1;
                this.f6731b = i12;
                this.f6740k++;
                solverVariable.f6684c = i12;
                solverVariable.f6691j = SolverVariable.Type.UNRESTRICTED;
                this.f6743n.f6720d[i12] = solverVariable;
            }
        }
        return solverVariable;
    }

    public androidx.constraintlayout.core.b r() {
        androidx.constraintlayout.core.b bVar;
        if (f6725v) {
            bVar = (androidx.constraintlayout.core.b) this.f6743n.f6717a.acquire();
            if (bVar == null) {
                bVar = new b(this.f6743n);
                f6729z++;
            } else {
                bVar.y();
            }
        } else {
            bVar = (androidx.constraintlayout.core.b) this.f6743n.f6718b.acquire();
            if (bVar == null) {
                bVar = new androidx.constraintlayout.core.b(this.f6743n);
                f6728y++;
            } else {
                bVar.y();
            }
        }
        SolverVariable.d();
        return bVar;
    }

    public SolverVariable t() {
        e eVar = f6727x;
        if (eVar != null) {
            eVar.f6760m++;
        }
        if (this.f6740k + 1 >= this.f6735f) {
            z();
        }
        SolverVariable a11 = a(SolverVariable.Type.SLACK, null);
        int i11 = this.f6731b + 1;
        this.f6731b = i11;
        this.f6740k++;
        a11.f6684c = i11;
        this.f6743n.f6720d[i11] = a11;
        return a11;
    }

    public void v(e eVar) {
        f6727x = eVar;
    }

    public c w() {
        return this.f6743n;
    }

    public int y(Object obj) {
        SolverVariable i11 = ((ConstraintAnchor) obj).i();
        if (i11 != null) {
            return (int) (i11.f6687f + 0.5f);
        }
        return 0;
    }
}
