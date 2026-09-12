package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f7009a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private a f7010b = new a();

    /* renamed from: c, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.d f7011c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: k, reason: collision with root package name */
        public static int f7012k = 0;

        /* renamed from: l, reason: collision with root package name */
        public static int f7013l = 1;

        /* renamed from: m, reason: collision with root package name */
        public static int f7014m = 2;

        /* renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f7015a;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f7016b;

        /* renamed from: c, reason: collision with root package name */
        public int f7017c;

        /* renamed from: d, reason: collision with root package name */
        public int f7018d;

        /* renamed from: e, reason: collision with root package name */
        public int f7019e;

        /* renamed from: f, reason: collision with root package name */
        public int f7020f;

        /* renamed from: g, reason: collision with root package name */
        public int f7021g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f7022h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f7023i;

        /* renamed from: j, reason: collision with root package name */
        public int f7024j;
    }

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060b {
        void a();

        void b(ConstraintWidget constraintWidget, a aVar);
    }

    public b(androidx.constraintlayout.core.widgets.d dVar) {
        this.f7011c = dVar;
    }

    private boolean a(InterfaceC0060b interfaceC0060b, ConstraintWidget constraintWidget, int i11) {
        this.f7010b.f7015a = constraintWidget.C();
        this.f7010b.f7016b = constraintWidget.V();
        this.f7010b.f7017c = constraintWidget.Y();
        this.f7010b.f7018d = constraintWidget.z();
        a aVar = this.f7010b;
        aVar.f7023i = false;
        aVar.f7024j = i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f7015a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f7016b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.f6942f0 > 0.0f;
        boolean z13 = z11 && constraintWidget.f6942f0 > 0.0f;
        if (z12 && constraintWidget.f6979y[0] == 4) {
            aVar.f7015a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z13 && constraintWidget.f6979y[1] == 4) {
            aVar.f7016b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        interfaceC0060b.b(constraintWidget, aVar);
        constraintWidget.o1(this.f7010b.f7019e);
        constraintWidget.P0(this.f7010b.f7020f);
        constraintWidget.O0(this.f7010b.f7022h);
        constraintWidget.E0(this.f7010b.f7021g);
        a aVar2 = this.f7010b;
        aVar2.f7024j = a.f7012k;
        return aVar2.f7023i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
    
        if (r8 != r9) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0095, code lost:
    
        if (r5.f6942f0 <= 0.0f) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(androidx.constraintlayout.core.widgets.d r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = r13.V0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.Y1(r1)
            androidx.constraintlayout.core.widgets.analyzer.b$b r2 = r13.N1()
            r3 = 0
            r4 = r3
        L12:
            if (r4 >= r0) goto Lb0
            java.util.ArrayList r5 = r13.V0
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.f
            if (r6 == 0) goto L22
            goto Lac
        L22:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.a
            if (r6 == 0) goto L28
            goto Lac
        L28:
            boolean r6 = r5.n0()
            if (r6 == 0) goto L30
            goto Lac
        L30:
            if (r1 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.j r6 = r5.f6939e
            if (r6 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.l r7 = r5.f6941f
            if (r7 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r6.f7002e
            boolean r6 = r6.f6995j
            if (r6 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r7.f7002e
            boolean r6 = r6.f6995j
            if (r6 == 0) goto L48
            goto Lac
        L48:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.w(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.w(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L61
            int r10 = r5.f6975w
            if (r10 == r7) goto L61
            if (r8 != r9) goto L61
            int r10 = r5.f6977x
            if (r10 == r7) goto L61
            r10 = r7
            goto L62
        L61:
            r10 = r3
        L62:
            if (r10 != 0) goto L98
            boolean r11 = r13.Y1(r7)
            if (r11 == 0) goto L98
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.i
            if (r11 != 0) goto L98
            if (r6 != r9) goto L7d
            int r11 = r5.f6975w
            if (r11 != 0) goto L7d
            if (r8 == r9) goto L7d
            boolean r11 = r5.k0()
            if (r11 != 0) goto L7d
            r10 = r7
        L7d:
            if (r8 != r9) goto L8c
            int r11 = r5.f6977x
            if (r11 != 0) goto L8c
            if (r6 == r9) goto L8c
            boolean r11 = r5.k0()
            if (r11 != 0) goto L8c
            r10 = r7
        L8c:
            if (r6 == r9) goto L90
            if (r8 != r9) goto L98
        L90:
            float r6 = r5.f6942f0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L98
            goto L99
        L98:
            r7 = r10
        L99:
            if (r7 == 0) goto L9c
            goto Lac
        L9c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.b.a.f7012k
            r12.a(r2, r5, r6)
            androidx.constraintlayout.core.e r5 = r13.f7091b1
            if (r5 == 0) goto Lac
            long r6 = r5.f6748a
            r8 = 1
            long r6 = r6 + r8
            r5.f6748a = r6
        Lac:
            int r4 = r4 + 1
            goto L12
        Lb0:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.b.b(androidx.constraintlayout.core.widgets.d):void");
    }

    private void c(androidx.constraintlayout.core.widgets.d dVar, String str, int i11, int i12, int i13) {
        int K = dVar.K();
        int J = dVar.J();
        dVar.e1(0);
        dVar.d1(0);
        dVar.o1(i12);
        dVar.P0(i13);
        dVar.e1(K);
        dVar.d1(J);
        this.f7011c.c2(i11);
        this.f7011c.w1();
    }

    public long d(androidx.constraintlayout.core.widgets.d dVar, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        boolean z10;
        int i20;
        int i21;
        boolean z11;
        int i22;
        InterfaceC0060b interfaceC0060b;
        int i23;
        int i24;
        int i25;
        boolean z12;
        androidx.constraintlayout.core.e eVar;
        InterfaceC0060b N1 = dVar.N1();
        int size = dVar.V0.size();
        int Y = dVar.Y();
        int z13 = dVar.z();
        boolean b11 = androidx.constraintlayout.core.widgets.g.b(i11, 128);
        boolean z14 = b11 || androidx.constraintlayout.core.widgets.g.b(i11, 64);
        if (z14) {
            for (int i26 = 0; i26 < size; i26++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) dVar.V0.get(i26);
                ConstraintWidget.DimensionBehaviour C = constraintWidget.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z15 = (C == dimensionBehaviour) && (constraintWidget.V() == dimensionBehaviour) && constraintWidget.x() > 0.0f;
                if ((constraintWidget.k0() && z15) || ((constraintWidget.m0() && z15) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.i) || constraintWidget.k0() || constraintWidget.m0())) {
                    z14 = false;
                    break;
                }
            }
        }
        if (z14 && (eVar = androidx.constraintlayout.core.d.f6727x) != null) {
            eVar.f6750c++;
        }
        boolean z16 = z14 & ((i14 == 1073741824 && i16 == 1073741824) || b11);
        int i27 = 2;
        if (z16) {
            int min = Math.min(dVar.I(), i15);
            int min2 = Math.min(dVar.H(), i17);
            if (i14 == 1073741824 && dVar.Y() != min) {
                dVar.o1(min);
                dVar.R1();
            }
            if (i16 == 1073741824 && dVar.z() != min2) {
                dVar.P0(min2);
                dVar.R1();
            }
            if (i14 == 1073741824 && i16 == 1073741824) {
                z10 = dVar.J1(b11);
                i20 = 2;
            } else {
                boolean K1 = dVar.K1(b11);
                if (i14 == 1073741824) {
                    K1 &= dVar.L1(b11, 0);
                    i20 = 1;
                } else {
                    i20 = 0;
                }
                if (i16 == 1073741824) {
                    z10 = dVar.L1(b11, 1) & K1;
                    i20++;
                } else {
                    z10 = K1;
                }
            }
            if (z10) {
                dVar.t1(i14 == 1073741824, i16 == 1073741824);
            }
        } else {
            z10 = false;
            i20 = 0;
        }
        if (z10 && i20 == 2) {
            return 0L;
        }
        int O1 = dVar.O1();
        if (size > 0) {
            b(dVar);
        }
        e(dVar);
        int size2 = this.f7009a.size();
        if (size > 0) {
            c(dVar, "First pass", 0, Y, z13);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour C2 = dVar.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z17 = C2 == dimensionBehaviour2;
            boolean z18 = dVar.V() == dimensionBehaviour2;
            int max = Math.max(dVar.Y(), this.f7011c.K());
            int max2 = Math.max(dVar.z(), this.f7011c.J());
            int i28 = 0;
            boolean z19 = false;
            while (i28 < size2) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.f7009a.get(i28);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.i) {
                    int Y2 = constraintWidget2.Y();
                    i23 = O1;
                    int z20 = constraintWidget2.z();
                    i24 = z13;
                    boolean a11 = a(N1, constraintWidget2, a.f7013l) | z19;
                    androidx.constraintlayout.core.e eVar2 = dVar.f7091b1;
                    i25 = Y;
                    if (eVar2 != null) {
                        eVar2.f6749b++;
                    }
                    int Y3 = constraintWidget2.Y();
                    int z21 = constraintWidget2.z();
                    if (Y3 != Y2) {
                        constraintWidget2.o1(Y3);
                        if (z17 && constraintWidget2.O() > max) {
                            max = Math.max(max, constraintWidget2.O() + constraintWidget2.q(ConstraintAnchor.Type.RIGHT).f());
                        }
                        z12 = true;
                    } else {
                        z12 = a11;
                    }
                    if (z21 != z20) {
                        constraintWidget2.P0(z21);
                        if (z18 && constraintWidget2.t() > max2) {
                            max2 = Math.max(max2, constraintWidget2.t() + constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).f());
                        }
                        z12 = true;
                    }
                    z19 = z12 | ((androidx.constraintlayout.core.widgets.i) constraintWidget2).J1();
                } else {
                    i23 = O1;
                    i25 = Y;
                    i24 = z13;
                }
                i28++;
                O1 = i23;
                z13 = i24;
                Y = i25;
                i27 = 2;
            }
            int i29 = O1;
            int i30 = Y;
            int i31 = z13;
            int i32 = i27;
            int i33 = 0;
            while (i33 < i32) {
                int i34 = 0;
                while (i34 < size2) {
                    ConstraintWidget constraintWidget3 = (ConstraintWidget) this.f7009a.get(i34);
                    if (((constraintWidget3 instanceof t0.a) && !(constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i)) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.f) || constraintWidget3.X() == 8 || ((z16 && constraintWidget3.f6939e.f7002e.f6995j && constraintWidget3.f6941f.f7002e.f6995j) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i))) {
                        z11 = z16;
                        i22 = size2;
                        interfaceC0060b = N1;
                    } else {
                        int Y4 = constraintWidget3.Y();
                        int z22 = constraintWidget3.z();
                        int r11 = constraintWidget3.r();
                        int i35 = a.f7013l;
                        z11 = z16;
                        if (i33 == 1) {
                            i35 = a.f7014m;
                        }
                        boolean a12 = a(N1, constraintWidget3, i35) | z19;
                        androidx.constraintlayout.core.e eVar3 = dVar.f7091b1;
                        i22 = size2;
                        interfaceC0060b = N1;
                        if (eVar3 != null) {
                            eVar3.f6749b++;
                        }
                        int Y5 = constraintWidget3.Y();
                        int z23 = constraintWidget3.z();
                        if (Y5 != Y4) {
                            constraintWidget3.o1(Y5);
                            if (z17 && constraintWidget3.O() > max) {
                                max = Math.max(max, constraintWidget3.O() + constraintWidget3.q(ConstraintAnchor.Type.RIGHT).f());
                            }
                            a12 = true;
                        }
                        if (z23 != z22) {
                            constraintWidget3.P0(z23);
                            if (z18 && constraintWidget3.t() > max2) {
                                max2 = Math.max(max2, constraintWidget3.t() + constraintWidget3.q(ConstraintAnchor.Type.BOTTOM).f());
                            }
                            a12 = true;
                        }
                        z19 = (!constraintWidget3.b0() || r11 == constraintWidget3.r()) ? a12 : true;
                    }
                    i34++;
                    N1 = interfaceC0060b;
                    z16 = z11;
                    size2 = i22;
                }
                boolean z24 = z16;
                int i36 = size2;
                InterfaceC0060b interfaceC0060b2 = N1;
                if (!z19) {
                    break;
                }
                i33++;
                c(dVar, "intermediate pass", i33, i30, i31);
                N1 = interfaceC0060b2;
                z16 = z24;
                size2 = i36;
                i32 = 2;
                z19 = false;
            }
            i21 = i29;
        } else {
            i21 = O1;
        }
        dVar.b2(i21);
        return 0L;
    }

    public void e(androidx.constraintlayout.core.widgets.d dVar) {
        this.f7009a.clear();
        int size = dVar.V0.size();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) dVar.V0.get(i11);
            ConstraintWidget.DimensionBehaviour C = constraintWidget.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (C == dimensionBehaviour || constraintWidget.V() == dimensionBehaviour) {
                this.f7009a.add(constraintWidget);
            }
        }
        dVar.R1();
    }
}
