package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.layout.s;
import androidx.compose.ui.layout.v;
import androidx.compose.ui.node.a0;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.node.m;
import androidx.compose.ui.node.n;
import androidx.compose.ui.node.o;
import androidx.compose.ui.node.x;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.z;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.t;
import y.j;
import z.l;

/* loaded from: classes.dex */
public final class TextAnnotatedStringNode extends f.c implements x, n, i1 {
    private Map A;
    private e B;
    private Function1 C;
    private a D;

    /* renamed from: n, reason: collision with root package name */
    private AnnotatedString f3307n;

    /* renamed from: o, reason: collision with root package name */
    private d0 f3308o;

    /* renamed from: p, reason: collision with root package name */
    private h.b f3309p;

    /* renamed from: q, reason: collision with root package name */
    private Function1 f3310q;

    /* renamed from: r, reason: collision with root package name */
    private int f3311r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f3312s;

    /* renamed from: t, reason: collision with root package name */
    private int f3313t;

    /* renamed from: u, reason: collision with root package name */
    private int f3314u;

    /* renamed from: v, reason: collision with root package name */
    private List f3315v;

    /* renamed from: w, reason: collision with root package name */
    private Function1 f3316w;

    /* renamed from: x, reason: collision with root package name */
    private h f3317x;

    /* renamed from: y, reason: collision with root package name */
    private x1 f3318y;

    /* renamed from: z, reason: collision with root package name */
    private Function1 f3319z;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final AnnotatedString f3320a;

        /* renamed from: b, reason: collision with root package name */
        private AnnotatedString f3321b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3322c;

        /* renamed from: d, reason: collision with root package name */
        private e f3323d;

        public a(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z10, e eVar) {
            this.f3320a = annotatedString;
            this.f3321b = annotatedString2;
            this.f3322c = z10;
            this.f3323d = eVar;
        }

        public /* synthetic */ a(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z10, e eVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(annotatedString, annotatedString2, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? null : eVar);
        }

        public final e a() {
            return this.f3323d;
        }

        public final AnnotatedString b() {
            return this.f3321b;
        }

        public final boolean c() {
            return this.f3322c;
        }

        public final void d(e eVar) {
            this.f3323d = eVar;
        }

        public final void e(boolean z10) {
            this.f3322c = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f3320a, aVar.f3320a) && Intrinsics.c(this.f3321b, aVar.f3321b) && this.f3322c == aVar.f3322c && Intrinsics.c(this.f3323d, aVar.f3323d);
        }

        public final void f(AnnotatedString annotatedString) {
            this.f3321b = annotatedString;
        }

        public int hashCode() {
            int hashCode = ((((this.f3320a.hashCode() * 31) + this.f3321b.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f3322c)) * 31;
            e eVar = this.f3323d;
            return hashCode + (eVar == null ? 0 : eVar.hashCode());
        }

        public String toString() {
            return "TextSubstitutionValue(original=" + ((Object) this.f3320a) + ", substitution=" + ((Object) this.f3321b) + ", isShowingSubstitution=" + this.f3322c + ", layoutCache=" + this.f3323d + ')';
        }
    }

    private TextAnnotatedStringNode(AnnotatedString annotatedString, d0 d0Var, h.b bVar, Function1 function1, int i11, boolean z10, int i12, int i13, List list, Function1 function12, h hVar, x1 x1Var, Function1 function13) {
        this.f3307n = annotatedString;
        this.f3308o = d0Var;
        this.f3309p = bVar;
        this.f3310q = function1;
        this.f3311r = i11;
        this.f3312s = z10;
        this.f3313t = i12;
        this.f3314u = i13;
        this.f3315v = list;
        this.f3316w = function12;
        this.f3318y = x1Var;
        this.f3319z = function13;
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, d0 d0Var, h.b bVar, Function1 function1, int i11, boolean z10, int i12, int i13, List list, Function1 function12, h hVar, x1 x1Var, Function1 function13, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, d0Var, bVar, function1, i11, z10, i12, i13, list, function12, hVar, x1Var, function13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e M1() {
        if (this.B == null) {
            this.B = new e(this.f3307n, this.f3308o, this.f3309p, this.f3311r, this.f3312s, this.f3313t, this.f3314u, this.f3315v, null);
        }
        e eVar = this.B;
        Intrinsics.e(eVar);
        return eVar;
    }

    private final e N1(o0.e eVar) {
        e a11;
        a aVar = this.D;
        if (aVar != null && aVar.c() && (a11 = aVar.a()) != null) {
            a11.h(eVar);
            return a11;
        }
        e M1 = M1();
        M1.h(eVar);
        return M1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1() {
        j1.b(this);
        a0.b(this);
        o.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R1(AnnotatedString annotatedString) {
        Unit unit;
        a aVar = this.D;
        if (aVar == null) {
            a aVar2 = new a(this.f3307n, annotatedString, false, null, 12, null);
            e eVar = new e(annotatedString, this.f3308o, this.f3309p, this.f3311r, this.f3312s, this.f3313t, this.f3314u, this.f3315v, null);
            eVar.h(M1().a());
            aVar2.d(eVar);
            this.D = aVar2;
            return true;
        }
        if (Intrinsics.c(annotatedString, aVar.b())) {
            return false;
        }
        aVar.f(annotatedString);
        e a11 = aVar.a();
        if (a11 != null) {
            a11.k(annotatedString, this.f3308o, this.f3309p, this.f3311r, this.f3312s, this.f3313t, this.f3314u, this.f3315v);
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        return unit != null;
    }

    public final void J1() {
        this.D = null;
    }

    public final void K1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (z11 || z12 || z13) {
            M1().k(this.f3307n, this.f3308o, this.f3309p, this.f3311r, this.f3312s, this.f3313t, this.f3314u, this.f3315v);
        }
        if (k1()) {
            if (z11 || (z10 && this.C != null)) {
                j1.b(this);
            }
            if (z11 || z12 || z13) {
                a0.b(this);
                o.a(this);
            }
            if (z10) {
                o.a(this);
            }
        }
    }

    public final void L1(z.c cVar) {
        n(cVar);
    }

    @Override // androidx.compose.ui.node.i1
    public boolean O() {
        return true;
    }

    public final a O1() {
        return this.D;
    }

    public final v Q1(androidx.compose.ui.layout.x xVar, s sVar, long j11) {
        return z(xVar, sVar, j11);
    }

    @Override // androidx.compose.ui.node.i1
    public void R0(androidx.compose.ui.semantics.n nVar) {
        Function1<List<z>, Boolean> function1 = this.C;
        if (function1 == null) {
            function1 = new Function1<List<z>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x00bb  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x00bd  */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(java.util.List<androidx.compose.ui.text.z> r38) {
                    /*
                        r37 = this;
                        r0 = r37
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.this
                        androidx.compose.foundation.text.modifiers.e r1 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.D1(r1)
                        androidx.compose.ui.text.z r2 = r1.b()
                        if (r2 == 0) goto Lb8
                        androidx.compose.ui.text.y r1 = new androidx.compose.ui.text.y
                        androidx.compose.ui.text.y r3 = r2.k()
                        androidx.compose.ui.text.AnnotatedString r4 = r3.j()
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r3 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.this
                        androidx.compose.ui.text.d0 r5 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.G1(r3)
                        androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r3 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.this
                        androidx.compose.ui.graphics.x1 r3 = androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.F1(r3)
                        if (r3 == 0) goto L2b
                        long r6 = r3.a()
                        goto L31
                    L2b:
                        androidx.compose.ui.graphics.u1$a r3 = androidx.compose.ui.graphics.u1.f4733b
                        long r6 = r3.e()
                    L31:
                        r35 = 16777214(0xfffffe, float:2.3509884E-38)
                        r36 = 0
                        r8 = 0
                        r10 = 0
                        r11 = 0
                        r12 = 0
                        r13 = 0
                        r14 = 0
                        r15 = 0
                        r17 = 0
                        r18 = 0
                        r19 = 0
                        r20 = 0
                        r22 = 0
                        r23 = 0
                        r24 = 0
                        r25 = 0
                        r26 = 0
                        r27 = 0
                        r29 = 0
                        r30 = 0
                        r31 = 0
                        r32 = 0
                        r33 = 0
                        r34 = 0
                        androidx.compose.ui.text.d0 r5 = androidx.compose.ui.text.d0.J(r5, r6, r8, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r33, r34, r35, r36)
                        androidx.compose.ui.text.y r3 = r2.k()
                        java.util.List r6 = r3.g()
                        androidx.compose.ui.text.y r3 = r2.k()
                        int r7 = r3.e()
                        androidx.compose.ui.text.y r3 = r2.k()
                        boolean r8 = r3.h()
                        androidx.compose.ui.text.y r3 = r2.k()
                        int r9 = r3.f()
                        androidx.compose.ui.text.y r3 = r2.k()
                        o0.e r10 = r3.b()
                        androidx.compose.ui.text.y r3 = r2.k()
                        androidx.compose.ui.unit.LayoutDirection r11 = r3.d()
                        androidx.compose.ui.text.y r3 = r2.k()
                        androidx.compose.ui.text.font.h$b r12 = r3.c()
                        androidx.compose.ui.text.y r3 = r2.k()
                        long r13 = r3.a()
                        r15 = 0
                        r3 = r1
                        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15)
                        r6 = 2
                        r7 = 0
                        r4 = 0
                        androidx.compose.ui.text.z r1 = androidx.compose.ui.text.z.b(r2, r3, r4, r6, r7)
                        if (r1 == 0) goto Lb8
                        r2 = r38
                        r2.add(r1)
                        goto Lb9
                    Lb8:
                        r1 = 0
                    Lb9:
                        if (r1 == 0) goto Lbd
                        r1 = 1
                        goto Lbe
                    Lbd:
                        r1 = 0
                    Lbe:
                        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1.invoke(java.util.List):java.lang.Boolean");
                }
            };
            this.C = function1;
        }
        SemanticsPropertiesKt.E(nVar, this.f3307n);
        a aVar = this.D;
        if (aVar != null) {
            SemanticsPropertiesKt.F(nVar, aVar.b());
            SemanticsPropertiesKt.D(nVar, aVar.c());
        }
        SemanticsPropertiesKt.H(nVar, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString annotatedString) {
                TextAnnotatedStringNode.this.R1(annotatedString);
                TextAnnotatedStringNode.this.P1();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.M(nVar, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Boolean invoke(boolean z10) {
                Function1 function12;
                if (TextAnnotatedStringNode.this.O1() == null) {
                    return Boolean.FALSE;
                }
                function12 = TextAnnotatedStringNode.this.f3319z;
                if (function12 != null) {
                    TextAnnotatedStringNode.a O1 = TextAnnotatedStringNode.this.O1();
                    Intrinsics.e(O1);
                    function12.invoke(O1);
                }
                TextAnnotatedStringNode.a O12 = TextAnnotatedStringNode.this.O1();
                if (O12 != null) {
                    O12.e(z10);
                }
                TextAnnotatedStringNode.this.P1();
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Boolean) obj).booleanValue());
            }
        }, 1, null);
        SemanticsPropertiesKt.d(nVar, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextAnnotatedStringNode.this.J1();
                TextAnnotatedStringNode.this.P1();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.j(nVar, null, function1, 1, null);
    }

    public final boolean S1(Function1 function1, Function1 function12, h hVar, Function1 function13) {
        boolean z10;
        if (this.f3310q != function1) {
            this.f3310q = function1;
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f3316w != function12) {
            this.f3316w = function12;
            z10 = true;
        }
        if (!Intrinsics.c(this.f3317x, hVar)) {
            z10 = true;
        }
        if (this.f3319z == function13) {
            return z10;
        }
        this.f3319z = function13;
        return true;
    }

    public final boolean T1(x1 x1Var, d0 d0Var) {
        boolean c11 = Intrinsics.c(x1Var, this.f3318y);
        this.f3318y = x1Var;
        return (c11 && d0Var.F(this.f3308o)) ? false : true;
    }

    public final boolean U1(d0 d0Var, List list, int i11, int i12, boolean z10, h.b bVar, int i13) {
        boolean z11 = !this.f3308o.G(d0Var);
        this.f3308o = d0Var;
        if (!Intrinsics.c(this.f3315v, list)) {
            this.f3315v = list;
            z11 = true;
        }
        if (this.f3314u != i11) {
            this.f3314u = i11;
            z11 = true;
        }
        if (this.f3313t != i12) {
            this.f3313t = i12;
            z11 = true;
        }
        if (this.f3312s != z10) {
            this.f3312s = z10;
            z11 = true;
        }
        if (!Intrinsics.c(this.f3309p, bVar)) {
            this.f3309p = bVar;
            z11 = true;
        }
        if (p.e(this.f3311r, i13)) {
            return z11;
        }
        this.f3311r = i13;
        return true;
    }

    public final boolean V1(AnnotatedString annotatedString) {
        boolean c11 = Intrinsics.c(this.f3307n.i(), annotatedString.i());
        boolean z10 = (c11 && Intrinsics.c(this.f3307n.g(), annotatedString.g()) && Intrinsics.c(this.f3307n.e(), annotatedString.e()) && this.f3307n.l(annotatedString)) ? false : true;
        if (z10) {
            this.f3307n = annotatedString;
        }
        if (!c11) {
            J1();
        }
        return z10;
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean W0() {
        return h1.b(this);
    }

    @Override // androidx.compose.ui.node.n
    public void n(z.c cVar) {
        if (k1()) {
            m1 e11 = cVar.H0().e();
            z c11 = N1(cVar).c();
            MultiParagraph v11 = c11.v();
            boolean z10 = true;
            boolean z11 = c11.i() && !p.e(this.f3311r, p.f6517a.c());
            if (z11) {
                y.i a11 = j.a(y.g.f78593b.c(), y.n.a(t.g(c11.y()), t.f(c11.y())));
                e11.n();
                l1.e(e11, a11, 0, 2, null);
            }
            try {
                androidx.compose.ui.text.style.i A = this.f3308o.A();
                if (A == null) {
                    A = androidx.compose.ui.text.style.i.f6484b.c();
                }
                androidx.compose.ui.text.style.i iVar = A;
                z4 x10 = this.f3308o.x();
                if (x10 == null) {
                    x10 = z4.f4996d.a();
                }
                z4 z4Var = x10;
                z.h i11 = this.f3308o.i();
                if (i11 == null) {
                    i11 = l.f79237a;
                }
                z.h hVar = i11;
                androidx.compose.ui.graphics.j1 g11 = this.f3308o.g();
                if (g11 != null) {
                    v11.z(e11, g11, (r17 & 4) != 0 ? Float.NaN : this.f3308o.d(), (r17 & 8) != 0 ? null : z4Var, (r17 & 16) != 0 ? null : iVar, (r17 & 32) != 0 ? null : hVar, (r17 & 64) != 0 ? z.g.f79233o1.a() : 0);
                } else {
                    x1 x1Var = this.f3318y;
                    long a12 = x1Var != null ? x1Var.a() : u1.f4733b.e();
                    if (a12 == 16) {
                        a12 = this.f3308o.h() != 16 ? this.f3308o.h() : u1.f4733b.a();
                    }
                    v11.x(e11, (r14 & 2) != 0 ? u1.f4733b.e() : a12, (r14 & 4) != 0 ? null : z4Var, (r14 & 8) != 0 ? null : iVar, (r14 & 16) == 0 ? hVar : null, (r14 & 32) != 0 ? z.g.f79233o1.a() : 0);
                }
                if (z11) {
                    e11.j();
                }
                a aVar = this.D;
                if (!((aVar == null || !aVar.c()) ? i.a(this.f3307n) : false)) {
                    List list = this.f3315v;
                    if (list != null && !list.isEmpty()) {
                        z10 = false;
                    }
                    if (z10) {
                        return;
                    }
                }
                cVar.Y0();
            } catch (Throwable th2) {
                if (z11) {
                    e11.j();
                }
                throw th2;
            }
        }
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void w0() {
        m.a(this);
    }

    @Override // androidx.compose.ui.node.x
    public v z(androidx.compose.ui.layout.x xVar, s sVar, long j11) {
        e N1 = N1(xVar);
        boolean e11 = N1.e(j11, xVar.getLayoutDirection());
        z c11 = N1.c();
        c11.v().i().b();
        if (e11) {
            a0.a(this);
            Function1 function1 = this.f3310q;
            if (function1 != null) {
                function1.invoke(c11);
            }
            Map map = this.A;
            if (map == null) {
                map = new LinkedHashMap(2);
            }
            map.put(AlignmentLineKt.a(), Integer.valueOf(Math.round(c11.h())));
            map.put(AlignmentLineKt.b(), Integer.valueOf(Math.round(c11.j())));
            this.A = map;
        }
        Function1 function12 = this.f3316w;
        if (function12 != null) {
            function12.invoke(c11.x());
        }
        final g0 P = sVar.P(o0.b.f70719b.b(t.g(c11.y()), t.g(c11.y()), t.f(c11.y()), t.f(c11.y())));
        int g11 = t.g(c11.y());
        int f11 = t.f(c11.y());
        Map map2 = this.A;
        Intrinsics.e(map2);
        return xVar.p0(g11, f11, map2, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((g0.a) obj);
                return Unit.f67184a;
            }

            public final void invoke(g0.a aVar) {
                g0.a.h(aVar, g0.this, 0, 0, 0.0f, 4, null);
            }
        });
    }
}
