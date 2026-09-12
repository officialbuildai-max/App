package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3861a = new l1("provider");

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3862b = new l1("provider");

    /* renamed from: c, reason: collision with root package name */
    private static final Object f3863c = new l1("compositionLocalMap");

    /* renamed from: d, reason: collision with root package name */
    private static final Object f3864d = new l1("providerValues");

    /* renamed from: e, reason: collision with root package name */
    private static final Object f3865e = new l1("providers");

    /* renamed from: f, reason: collision with root package name */
    private static final Object f3866f = new l1("reference");

    /* renamed from: g, reason: collision with root package name */
    private static final Comparator f3867g = new Comparator() { // from class: androidx.compose.runtime.j
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int b11;
            b11 = k.b((o0) obj, (o0) obj2);
            return b11;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object A(q0 q0Var) {
        return q0Var.d() != null ? new p0(Integer.valueOf(q0Var.a()), q0Var.d()) : Integer.valueOf(q0Var.a());
    }

    public static final Object B() {
        return f3862b;
    }

    public static final Object C() {
        return f3865e;
    }

    public static final Object D() {
        return f3866f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(List list, int i11, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int w11 = w(list, i11);
        if (w11 < 0) {
            int i12 = -(w11 + 1);
            if (!(obj instanceof z)) {
                obj = null;
            }
            list.add(i12, new o0(recomposeScopeImpl, i11, obj));
            return;
        }
        o0 o0Var = (o0) list.get(w11);
        if (!(obj instanceof z)) {
            o0Var.e(null);
            return;
        }
        Object a11 = o0Var.a();
        if (a11 == null) {
            o0Var.e(obj);
        } else if (a11 instanceof MutableScatterSet) {
            ((MutableScatterSet) a11).h(obj);
        } else {
            o0Var.e(androidx.collection.w0.b(a11, obj));
        }
    }

    public static final boolean F(i2 i2Var) {
        return i2Var.k() > i2Var.u() + 1;
    }

    public static final boolean G(m2 m2Var) {
        return m2Var.a0() > m2Var.c0() + 1;
    }

    public static final boolean H() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.collection.n0 I(int i11) {
        return h1.b(new androidx.collection.n0(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J(i2 i2Var, int i11, int i12, int i13) {
        if (i11 == i12) {
            return i11;
        }
        if (i11 == i13 || i12 == i13) {
            return i13;
        }
        if (i2Var.P(i11) == i12) {
            return i12;
        }
        if (i2Var.P(i12) == i11) {
            return i11;
        }
        if (i2Var.P(i11) == i2Var.P(i12)) {
            return i2Var.P(i11);
        }
        int u11 = u(i2Var, i11, i13);
        int u12 = u(i2Var, i12, i13);
        int i14 = u11 - u12;
        for (int i15 = 0; i15 < i14; i15++) {
            i11 = i2Var.P(i11);
        }
        int i16 = u12 - u11;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = i2Var.P(i12);
        }
        while (i11 != i12) {
            i11 = i2Var.P(i11);
            i12 = i2Var.P(i12);
        }
        return i11;
    }

    public static final void K(m2 m2Var, a2 a2Var) {
        int h02;
        int h03;
        int R;
        int i11;
        h02 = m2Var.h0(m2Var.a0());
        int[] iArr = m2Var.f3884b;
        h03 = m2Var.h0(m2Var.a0() + m2Var.k0(m2Var.a0()));
        int Q = m2Var.Q(iArr, h03);
        for (int Q2 = m2Var.Q(m2Var.f3884b, h02); Q2 < Q; Q2++) {
            Object[] objArr = m2Var.f3885c;
            R = m2Var.R(Q2);
            Object obj = objArr[R];
            int i12 = -1;
            if (obj instanceof h) {
                a2Var.b((h) obj, m2Var.e0() - Q2, -1, -1);
            }
            if (obj instanceof c2) {
                int e02 = m2Var.e0() - Q2;
                c2 c2Var = (c2) obj;
                c a11 = c2Var.a();
                if (a11 == null || !a11.b()) {
                    i11 = -1;
                } else {
                    i12 = m2Var.F(a11);
                    i11 = m2Var.e0() - m2Var.b1(i12);
                }
                a2Var.e(c2Var.b(), e02, i12, i11);
            }
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).x();
            }
        }
        m2Var.L0();
    }

    private static final void L(m2 m2Var, int i11, int i12, Object obj) {
        if (obj == m2Var.R0(i11, i12, i.f3811a.a())) {
            return;
        }
        r("Slot table is out of sync");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o0 M(List list, int i11) {
        int w11 = w(list, i11);
        if (w11 >= 0) {
            return (o0) list.remove(w11);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(List list, int i11, int i12) {
        int v11 = v(list, i11);
        while (v11 < list.size() && ((o0) list.get(v11)).b() < i12) {
            list.remove(v11);
        }
    }

    public static final void O(boolean z10) {
        if (z10) {
            return;
        }
        r("Check failed");
    }

    public static final void P() {
    }

    public static final void Q(int i11, int i12, int i13, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(o0 o0Var, o0 o0Var2) {
        return Intrinsics.j(o0Var.b(), o0Var2.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(int i11) {
        return i11 != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(boolean z10) {
        return z10 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List p(j2 j2Var, c cVar) {
        ArrayList arrayList = new ArrayList();
        i2 w11 = j2Var.w();
        try {
            q(w11, arrayList, j2Var.c(cVar));
            Unit unit = Unit.f67184a;
            return arrayList;
        } finally {
            w11.d();
        }
    }

    private static final void q(i2 i2Var, List list, int i11) {
        if (i2Var.J(i11)) {
            list.add(i2Var.L(i11));
            return;
        }
        int i12 = i11 + 1;
        int E = i11 + i2Var.E(i11);
        while (i12 < E) {
            q(i2Var, list, i12);
            i12 += i2Var.E(i12);
        }
    }

    public static final void r(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final Void s(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void t(m2 m2Var, a2 a2Var) {
        int h02;
        int Z0;
        int h03;
        int R;
        int i11;
        int i12;
        int a02 = m2Var.a0();
        int b02 = m2Var.b0();
        while (a02 < b02) {
            Object A0 = m2Var.A0(a02);
            if (A0 instanceof h) {
                a2Var.d((h) A0, m2Var.e0() - m2Var.d1(a02), -1, -1);
            }
            h02 = m2Var.h0(a02);
            Z0 = m2Var.Z0(m2Var.f3884b, h02);
            int[] iArr = m2Var.f3884b;
            int i13 = a02 + 1;
            h03 = m2Var.h0(i13);
            int Q = m2Var.Q(iArr, h03);
            for (int i14 = Z0; i14 < Q; i14++) {
                int i15 = i14 - Z0;
                Object[] objArr = m2Var.f3885c;
                R = m2Var.R(i14);
                Object obj = objArr[R];
                if (obj instanceof c2) {
                    c2 c2Var = (c2) obj;
                    b2 b11 = c2Var.b();
                    if (!(b11 instanceof e2)) {
                        L(m2Var, a02, i15, obj);
                        int e02 = m2Var.e0() - i15;
                        c a11 = c2Var.a();
                        if (a11 == null || !a11.b()) {
                            i11 = -1;
                            i12 = -1;
                        } else {
                            i11 = m2Var.F(a11);
                            i12 = m2Var.e0() - m2Var.b1(i11);
                        }
                        a2Var.e(b11, e02, i11, i12);
                    }
                } else if (obj instanceof RecomposeScopeImpl) {
                    L(m2Var, a02, i15, obj);
                    ((RecomposeScopeImpl) obj).x();
                }
            }
            a02 = i13;
        }
    }

    private static final int u(i2 i2Var, int i11, int i12) {
        int i13 = 0;
        while (i11 > 0 && i11 != i12) {
            i11 = i2Var.P(i11);
            i13++;
        }
        return i13;
    }

    private static final int v(List list, int i11) {
        int w11 = w(list, i11);
        return w11 < 0 ? -(w11 + 1) : w11;
    }

    private static final int w(List list, int i11) {
        int size = list.size() - 1;
        int i12 = 0;
        while (i12 <= size) {
            int i13 = (i12 + size) >>> 1;
            int j11 = Intrinsics.j(((o0) list.get(i13)).b(), i11);
            if (j11 < 0) {
                i12 = i13 + 1;
            } else {
                if (j11 <= 0) {
                    return i13;
                }
                size = i13 - 1;
            }
        }
        return -(i12 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o0 x(List list, int i11, int i12) {
        int v11 = v(list, i11);
        if (v11 >= list.size()) {
            return null;
        }
        o0 o0Var = (o0) list.get(v11);
        if (o0Var.b() < i12) {
            return o0Var;
        }
        return null;
    }

    public static final Object y() {
        return f3863c;
    }

    public static final Object z() {
        return f3861a;
    }
}
