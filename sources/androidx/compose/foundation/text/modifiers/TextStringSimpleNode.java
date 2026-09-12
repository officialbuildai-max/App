package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.modifiers.TextStringSimpleNode;
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
import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.k;
import androidx.compose.ui.text.l;
import androidx.compose.ui.text.style.j;
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
import o0.w;

/* loaded from: classes.dex */
public final class TextStringSimpleNode extends f.c implements x, n, i1 {

    /* renamed from: n, reason: collision with root package name */
    private String f3332n;

    /* renamed from: o, reason: collision with root package name */
    private d0 f3333o;

    /* renamed from: p, reason: collision with root package name */
    private h.b f3334p;

    /* renamed from: q, reason: collision with root package name */
    private int f3335q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f3336r;

    /* renamed from: s, reason: collision with root package name */
    private int f3337s;

    /* renamed from: t, reason: collision with root package name */
    private int f3338t;

    /* renamed from: u, reason: collision with root package name */
    private x1 f3339u;

    /* renamed from: v, reason: collision with root package name */
    private Map f3340v;

    /* renamed from: w, reason: collision with root package name */
    private f f3341w;

    /* renamed from: x, reason: collision with root package name */
    private Function1 f3342x;

    /* renamed from: y, reason: collision with root package name */
    private a f3343y;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f3344a;

        /* renamed from: b, reason: collision with root package name */
        private String f3345b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3346c;

        /* renamed from: d, reason: collision with root package name */
        private f f3347d;

        public a(String str, String str2, boolean z10, f fVar) {
            this.f3344a = str;
            this.f3345b = str2;
            this.f3346c = z10;
            this.f3347d = fVar;
        }

        public /* synthetic */ a(String str, String str2, boolean z10, f fVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? null : fVar);
        }

        public final f a() {
            return this.f3347d;
        }

        public final String b() {
            return this.f3345b;
        }

        public final boolean c() {
            return this.f3346c;
        }

        public final void d(f fVar) {
            this.f3347d = fVar;
        }

        public final void e(boolean z10) {
            this.f3346c = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f3344a, aVar.f3344a) && Intrinsics.c(this.f3345b, aVar.f3345b) && this.f3346c == aVar.f3346c && Intrinsics.c(this.f3347d, aVar.f3347d);
        }

        public final void f(String str) {
            this.f3345b = str;
        }

        public int hashCode() {
            int hashCode = ((((this.f3344a.hashCode() * 31) + this.f3345b.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f3346c)) * 31;
            f fVar = this.f3347d;
            return hashCode + (fVar == null ? 0 : fVar.hashCode());
        }

        public String toString() {
            return "TextSubstitution(layoutCache=" + this.f3347d + ", isShowingSubstitution=" + this.f3346c + ')';
        }
    }

    private TextStringSimpleNode(String str, d0 d0Var, h.b bVar, int i11, boolean z10, int i12, int i13, x1 x1Var) {
        this.f3332n = str;
        this.f3333o = d0Var;
        this.f3334p = bVar;
        this.f3335q = i11;
        this.f3336r = z10;
        this.f3337s = i12;
        this.f3338t = i13;
        this.f3339u = x1Var;
    }

    public /* synthetic */ TextStringSimpleNode(String str, d0 d0Var, h.b bVar, int i11, boolean z10, int i12, int i13, x1 x1Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d0Var, bVar, i11, z10, i12, i13, x1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        this.f3343y = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f M1() {
        if (this.f3341w == null) {
            this.f3341w = new f(this.f3332n, this.f3333o, this.f3334p, this.f3335q, this.f3336r, this.f3337s, this.f3338t, null);
        }
        f fVar = this.f3341w;
        Intrinsics.e(fVar);
        return fVar;
    }

    private final f N1(o0.e eVar) {
        f a11;
        a aVar = this.f3343y;
        if (aVar != null && aVar.c() && (a11 = aVar.a()) != null) {
            a11.j(eVar);
            return a11;
        }
        f M1 = M1();
        M1.j(eVar);
        return M1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1() {
        j1.b(this);
        a0.b(this);
        o.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P1(String str) {
        Unit unit;
        a aVar = this.f3343y;
        if (aVar == null) {
            a aVar2 = new a(this.f3332n, str, false, null, 12, null);
            f fVar = new f(str, this.f3333o, this.f3334p, this.f3335q, this.f3336r, this.f3337s, this.f3338t, null);
            fVar.j(M1().a());
            aVar2.d(fVar);
            this.f3343y = aVar2;
            return true;
        }
        if (Intrinsics.c(str, aVar.b())) {
            return false;
        }
        aVar.f(str);
        f a11 = aVar.a();
        if (a11 != null) {
            a11.m(str, this.f3333o, this.f3334p, this.f3335q, this.f3336r, this.f3337s, this.f3338t);
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        return unit != null;
    }

    public final void L1(boolean z10, boolean z11, boolean z12) {
        if (z11 || z12) {
            M1().m(this.f3332n, this.f3333o, this.f3334p, this.f3335q, this.f3336r, this.f3337s, this.f3338t);
        }
        if (k1()) {
            if (z11 || (z10 && this.f3342x != null)) {
                j1.b(this);
            }
            if (z11 || z12) {
                a0.b(this);
                o.a(this);
            }
            if (z10) {
                o.a(this);
            }
        }
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean O() {
        return h1.a(this);
    }

    public final boolean Q1(x1 x1Var, d0 d0Var) {
        boolean c11 = Intrinsics.c(x1Var, this.f3339u);
        this.f3339u = x1Var;
        return (c11 && d0Var.F(this.f3333o)) ? false : true;
    }

    @Override // androidx.compose.ui.node.i1
    public void R0(androidx.compose.ui.semantics.n nVar) {
        Function1<List<z>, Boolean> function1 = this.f3342x;
        if (function1 == null) {
            function1 = new Function1<List<z>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(List<z> list) {
                    f M1;
                    d0 d0Var;
                    x1 x1Var;
                    d0 I;
                    M1 = TextStringSimpleNode.this.M1();
                    d0Var = TextStringSimpleNode.this.f3333o;
                    x1Var = TextStringSimpleNode.this.f3339u;
                    I = d0Var.I((r58 & 1) != 0 ? u1.f4733b.e() : x1Var != null ? x1Var.a() : u1.f4733b.e(), (r58 & 2) != 0 ? w.f70751b.a() : 0L, (r58 & 4) != 0 ? null : null, (r58 & 8) != 0 ? null : null, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : null, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? w.f70751b.a() : 0L, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? u1.f4733b.e() : 0L, (r58 & 4096) != 0 ? null : null, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? androidx.compose.ui.text.style.h.f6475b.g() : 0, (r58 & 65536) != 0 ? j.f6489b.f() : 0, (r58 & 131072) != 0 ? w.f70751b.a() : 0L, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? androidx.compose.ui.text.style.e.f6441a.b() : 0, (r58 & 2097152) != 0 ? androidx.compose.ui.text.style.d.f6437a.c() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                    z l11 = M1.l(I);
                    if (l11 != null) {
                        list.add(l11);
                    } else {
                        l11 = null;
                    }
                    return Boolean.valueOf(l11 != null);
                }
            };
            this.f3342x = function1;
        }
        SemanticsPropertiesKt.E(nVar, new AnnotatedString(this.f3332n, null, null, 6, null));
        a aVar = this.f3343y;
        if (aVar != null) {
            SemanticsPropertiesKt.D(nVar, aVar.c());
            SemanticsPropertiesKt.F(nVar, new AnnotatedString(aVar.b(), null, null, 6, null));
        }
        SemanticsPropertiesKt.H(nVar, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString annotatedString) {
                TextStringSimpleNode.this.P1(annotatedString.i());
                TextStringSimpleNode.this.O1();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.M(nVar, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Boolean invoke(boolean z10) {
                TextStringSimpleNode.a aVar2;
                TextStringSimpleNode.a aVar3;
                aVar2 = TextStringSimpleNode.this.f3343y;
                if (aVar2 == null) {
                    return Boolean.FALSE;
                }
                aVar3 = TextStringSimpleNode.this.f3343y;
                if (aVar3 != null) {
                    aVar3.e(z10);
                }
                TextStringSimpleNode.this.O1();
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Boolean) obj).booleanValue());
            }
        }, 1, null);
        SemanticsPropertiesKt.d(nVar, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextStringSimpleNode.this.K1();
                TextStringSimpleNode.this.O1();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.j(nVar, null, function1, 1, null);
    }

    public final boolean R1(d0 d0Var, int i11, int i12, boolean z10, h.b bVar, int i13) {
        boolean z11 = !this.f3333o.G(d0Var);
        this.f3333o = d0Var;
        if (this.f3338t != i11) {
            this.f3338t = i11;
            z11 = true;
        }
        if (this.f3337s != i12) {
            this.f3337s = i12;
            z11 = true;
        }
        if (this.f3336r != z10) {
            this.f3336r = z10;
            z11 = true;
        }
        if (!Intrinsics.c(this.f3334p, bVar)) {
            this.f3334p = bVar;
            z11 = true;
        }
        if (p.e(this.f3335q, i13)) {
            return z11;
        }
        this.f3335q = i13;
        return true;
    }

    public final boolean S1(String str) {
        if (Intrinsics.c(this.f3332n, str)) {
            return false;
        }
        this.f3332n = str;
        K1();
        return true;
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean W0() {
        return h1.b(this);
    }

    @Override // androidx.compose.ui.node.n
    public void n(z.c cVar) {
        if (k1()) {
            f N1 = N1(cVar);
            l e11 = N1.e();
            if (e11 == null) {
                throw new IllegalArgumentException(("no paragraph (layoutCache=" + this.f3341w + ", textSubstitution=" + this.f3343y + ')').toString());
            }
            m1 e12 = cVar.H0().e();
            boolean b11 = N1.b();
            if (b11) {
                float g11 = t.g(N1.c());
                float f11 = t.f(N1.c());
                e12.n();
                l1.d(e12, 0.0f, 0.0f, g11, f11, 0, 16, null);
            }
            try {
                androidx.compose.ui.text.style.i A = this.f3333o.A();
                if (A == null) {
                    A = androidx.compose.ui.text.style.i.f6484b.c();
                }
                androidx.compose.ui.text.style.i iVar = A;
                z4 x10 = this.f3333o.x();
                if (x10 == null) {
                    x10 = z4.f4996d.a();
                }
                z4 z4Var = x10;
                z.h i11 = this.f3333o.i();
                if (i11 == null) {
                    i11 = z.l.f79237a;
                }
                z.h hVar = i11;
                androidx.compose.ui.graphics.j1 g12 = this.f3333o.g();
                if (g12 != null) {
                    k.b(e11, e12, g12, this.f3333o.d(), z4Var, iVar, hVar, 0, 64, null);
                } else {
                    x1 x1Var = this.f3339u;
                    long a11 = x1Var != null ? x1Var.a() : u1.f4733b.e();
                    if (a11 == 16) {
                        a11 = this.f3333o.h() != 16 ? this.f3333o.h() : u1.f4733b.a();
                    }
                    k.a(e11, e12, a11, z4Var, iVar, hVar, 0, 32, null);
                }
                if (b11) {
                    e12.j();
                }
            } catch (Throwable th2) {
                if (b11) {
                    e12.j();
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
        f N1 = N1(xVar);
        boolean g11 = N1.g(j11, xVar.getLayoutDirection());
        N1.d();
        l e11 = N1.e();
        Intrinsics.e(e11);
        long c11 = N1.c();
        if (g11) {
            a0.a(this);
            Map map = this.f3340v;
            if (map == null) {
                map = new LinkedHashMap(2);
            }
            map.put(AlignmentLineKt.a(), Integer.valueOf(Math.round(e11.e())));
            map.put(AlignmentLineKt.b(), Integer.valueOf(Math.round(e11.o())));
            this.f3340v = map;
        }
        final g0 P = sVar.P(o0.b.f70719b.b(t.g(c11), t.g(c11), t.f(c11), t.f(c11)));
        int g12 = t.g(c11);
        int f11 = t.f(c11);
        Map map2 = this.f3340v;
        Intrinsics.e(map2);
        return xVar.p0(g12, f11, map2, new Function1<g0.a, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$measure$1
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
