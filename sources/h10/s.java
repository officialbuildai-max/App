package h10;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import h10.c;
import org.mvel2.asm.MethodTooLargeException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class s extends r {

    /* renamed from: c0, reason: collision with root package name */
    private static final int[] f64300c0 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    private final int A;
    private b B;
    private b C;
    private int D;
    private b[] E;
    private int F;
    private b[] G;
    private b H;
    private b I;
    private d J;
    private int K;
    private d L;
    private c M;
    private final int N;
    private q O;
    private q P;
    private q Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int[] V;
    private int[] W;
    private boolean X;
    private boolean Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f64301a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f64302b0;

    /* renamed from: c, reason: collision with root package name */
    private final x f64303c;

    /* renamed from: d, reason: collision with root package name */
    private final int f64304d;

    /* renamed from: e, reason: collision with root package name */
    private final int f64305e;

    /* renamed from: f, reason: collision with root package name */
    private final String f64306f;

    /* renamed from: g, reason: collision with root package name */
    private final int f64307g;

    /* renamed from: h, reason: collision with root package name */
    private final String f64308h;

    /* renamed from: i, reason: collision with root package name */
    private int f64309i;

    /* renamed from: j, reason: collision with root package name */
    private int f64310j;

    /* renamed from: k, reason: collision with root package name */
    private final d f64311k;

    /* renamed from: l, reason: collision with root package name */
    private p f64312l;

    /* renamed from: m, reason: collision with root package name */
    private p f64313m;

    /* renamed from: n, reason: collision with root package name */
    private int f64314n;

    /* renamed from: o, reason: collision with root package name */
    private d f64315o;

    /* renamed from: p, reason: collision with root package name */
    private int f64316p;

    /* renamed from: q, reason: collision with root package name */
    private d f64317q;

    /* renamed from: r, reason: collision with root package name */
    private int f64318r;

    /* renamed from: s, reason: collision with root package name */
    private d f64319s;

    /* renamed from: t, reason: collision with root package name */
    private int f64320t;

    /* renamed from: u, reason: collision with root package name */
    private d f64321u;

    /* renamed from: v, reason: collision with root package name */
    private b f64322v;

    /* renamed from: w, reason: collision with root package name */
    private b f64323w;

    /* renamed from: x, reason: collision with root package name */
    private c f64324x;

    /* renamed from: y, reason: collision with root package name */
    private final int f64325y;

    /* renamed from: z, reason: collision with root package name */
    private final int[] f64326z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(x xVar, int i11, String str, String str2, String str3, String[] strArr, int i12) {
        super(458752);
        this.f64311k = new d();
        this.f64303c = xVar;
        this.f64304d = "<init>".equals(str) ? 262144 | i11 : i11;
        this.f64305e = xVar.D(str);
        this.f64306f = str;
        this.f64307g = xVar.D(str2);
        this.f64308h = str2;
        this.A = str3 == null ? 0 : xVar.D(str3);
        if (strArr == null || strArr.length <= 0) {
            this.f64325y = 0;
            this.f64326z = null;
        } else {
            int length = strArr.length;
            this.f64325y = length;
            this.f64326z = new int[length];
            for (int i13 = 0; i13 < this.f64325y; i13++) {
                this.f64326z[i13] = xVar.e(strArr[i13]).f64353a;
            }
        }
        this.N = i12;
        if (i12 != 0) {
            int c11 = y.c(str2) >> 2;
            c11 = (i11 & 8) != 0 ? c11 - 1 : c11;
            this.f64310j = c11;
            this.T = c11;
            q qVar = new q();
            this.O = qVar;
            o(qVar);
        }
    }

    private void G(int i11, q qVar) {
        q qVar2 = this.Q;
        qVar2.f64296l = new k(i11, qVar, qVar2.f64296l);
    }

    private void J() {
        p pVar = this.f64312l;
        while (true) {
            if (pVar == null) {
                break;
            }
            String str = pVar.f64282e;
            int g11 = n.g(this.f64303c, str != null ? str : "java/lang/Throwable");
            q e11 = pVar.f64280c.e();
            e11.f64285a = (short) (e11.f64285a | 2);
            q e12 = pVar.f64279b.e();
            for (q e13 = pVar.f64278a.e(); e13 != e12; e13 = e13.f64295k) {
                e13.f64296l = new k(g11, e11, e13.f64296l);
            }
            pVar = pVar.f64283f;
        }
        n nVar = this.O.f64294j;
        nVar.t(this.f64303c, this.f64304d, this.f64308h, this.f64310j);
        nVar.a(this);
        q qVar = this.O;
        qVar.f64297m = q.f64284n;
        int i11 = 0;
        while (qVar != q.f64284n) {
            q qVar2 = qVar.f64297m;
            qVar.f64297m = null;
            qVar.f64285a = (short) (qVar.f64285a | 8);
            int i12 = qVar.f64294j.i() + qVar.f64292h;
            if (i12 > i11) {
                i11 = i12;
            }
            for (k kVar = qVar.f64296l; kVar != null; kVar = kVar.f64250c) {
                q e14 = kVar.f64249b.e();
                if (qVar.f64294j.l(this.f64303c, e14.f64294j, kVar.f64248a) && e14.f64297m == null) {
                    e14.f64297m = qVar2;
                    qVar2 = e14;
                }
            }
            qVar = qVar2;
        }
        for (q qVar3 = this.O; qVar3 != null; qVar3 = qVar3.f64295k) {
            if ((qVar3.f64285a & 10) == 10) {
                qVar3.f64294j.a(this);
            }
            if ((qVar3.f64285a & 8) == 0) {
                q qVar4 = qVar3.f64295k;
                int i13 = qVar3.f64288d;
                int i14 = (qVar4 == null ? this.f64311k.f64191b : qVar4.f64288d) - 1;
                if (i14 >= i13) {
                    for (int i15 = i13; i15 < i14; i15++) {
                        this.f64311k.f64190a[i15] = 0;
                    }
                    this.f64311k.f64190a[i14] = -65;
                    this.W[V(i13, 0, 1)] = n.g(this.f64303c, "java/lang/Throwable");
                    U();
                    this.f64312l = p.d(this.f64312l, qVar3, qVar4);
                    i11 = Math.max(i11, 1);
                }
            }
        }
        this.f64309i = i11;
    }

    private void K() {
        for (p pVar = this.f64312l; pVar != null; pVar = pVar.f64283f) {
            q qVar = pVar.f64280c;
            q qVar2 = pVar.f64279b;
            for (q qVar3 = pVar.f64278a; qVar3 != qVar2; qVar3 = qVar3.f64295k) {
                if ((qVar3.f64285a & 16) == 0) {
                    qVar3.f64296l = new k(Integer.MAX_VALUE, qVar, qVar3.f64296l);
                } else {
                    k kVar = qVar3.f64296l.f64250c;
                    kVar.f64250c = new k(Integer.MAX_VALUE, qVar, kVar.f64250c);
                }
            }
        }
        if (this.X) {
            this.O.f((short) 1);
            short s11 = 1;
            for (short s12 = 1; s12 <= s11; s12 = (short) (s12 + 1)) {
                for (q qVar4 = this.O; qVar4 != null; qVar4 = qVar4.f64295k) {
                    if ((qVar4.f64285a & 16) != 0 && qVar4.f64293i == s12) {
                        q qVar5 = qVar4.f64296l.f64250c.f64249b;
                        if (qVar5.f64293i == 0) {
                            s11 = (short) (s11 + 1);
                            qVar5.f(s11);
                        }
                    }
                }
            }
            for (q qVar6 = this.O; qVar6 != null; qVar6 = qVar6.f64295k) {
                if ((qVar6.f64285a & 16) != 0) {
                    qVar6.f64296l.f64250c.f64249b.d(qVar6);
                }
            }
        }
        q qVar7 = this.O;
        qVar7.f64297m = q.f64284n;
        int i11 = this.f64309i;
        while (qVar7 != q.f64284n) {
            q qVar8 = qVar7.f64297m;
            short s13 = qVar7.f64290f;
            int i12 = qVar7.f64292h + s13;
            if (i12 > i11) {
                i11 = i12;
            }
            k kVar2 = qVar7.f64296l;
            if ((qVar7.f64285a & 16) != 0) {
                kVar2 = kVar2.f64250c;
            }
            qVar7 = qVar8;
            while (kVar2 != null) {
                q qVar9 = kVar2.f64249b;
                if (qVar9.f64297m == null) {
                    int i13 = kVar2.f64248a;
                    qVar9.f64290f = (short) (i13 == Integer.MAX_VALUE ? 1 : i13 + s13);
                    qVar9.f64297m = qVar7;
                    qVar7 = qVar9;
                }
                kVar2 = kVar2.f64250c;
            }
        }
        this.f64309i = i11;
    }

    private void M() {
        int i11 = this.N;
        if (i11 != 4) {
            if (i11 == 1) {
                this.Q.f64292h = (short) this.S;
                this.Q = null;
                return;
            }
            return;
        }
        q qVar = new q();
        qVar.f64294j = new n(qVar);
        d dVar = this.f64311k;
        qVar.i(dVar.f64190a, dVar.f64191b);
        this.P.f64295k = qVar;
        this.P = qVar;
        this.Q = null;
    }

    private void P(int i11, int i12) {
        while (i11 < i12) {
            n.r(this.f64303c, this.W[i11], this.f64321u);
            i11++;
        }
    }

    private void Q() {
        char c11;
        int[] iArr = this.W;
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = 0;
        if (this.f64303c.R() < 50) {
            this.f64321u.k(this.W[0]).k(i11);
            int i14 = i11 + 3;
            P(3, i14);
            this.f64321u.k(i12);
            P(i14, i12 + i14);
            return;
        }
        int i15 = this.f64320t == 0 ? this.W[0] : (this.W[0] - this.V[0]) - 1;
        int i16 = this.V[1];
        int i17 = i11 - i16;
        if (i12 == 0) {
            switch (i17) {
                case -3:
                case -2:
                case -1:
                    c11 = 248;
                    break;
                case 0:
                    if (i15 >= 64) {
                        c11 = 251;
                        break;
                    } else {
                        c11 = 0;
                        break;
                    }
                case 1:
                case 2:
                case 3:
                    c11 = 252;
                    break;
                default:
                    c11 = 255;
                    break;
            }
        } else {
            if (i17 == 0 && i12 == 1) {
                c11 = i15 < 63 ? '@' : (char) 247;
            }
            c11 = 255;
        }
        if (c11 != 255) {
            int i18 = 3;
            while (true) {
                if (i13 < i16 && i13 < i11) {
                    if (this.W[i18] != this.V[i18]) {
                        c11 = 255;
                    } else {
                        i18++;
                        i13++;
                    }
                }
            }
        }
        if (c11 == 0) {
            this.f64321u.g(i15);
            return;
        }
        if (c11 == '@') {
            this.f64321u.g(i15 + 64);
            P(i11 + 3, i11 + 4);
            return;
        }
        if (c11 == 247) {
            this.f64321u.g(247).k(i15);
            P(i11 + 3, i11 + 4);
            return;
        }
        if (c11 == 248) {
            this.f64321u.g(i17 + 251).k(i15);
            return;
        }
        if (c11 == 251) {
            this.f64321u.g(251).k(i15);
            return;
        }
        if (c11 == 252) {
            this.f64321u.g(i17 + 251).k(i15);
            P(i16 + 3, i11 + 3);
            return;
        }
        this.f64321u.g(255).k(i15).k(i11);
        int i19 = i11 + 3;
        P(3, i19);
        this.f64321u.k(i12);
        P(i19, i12 + i19);
    }

    private void R(Object obj) {
        if (obj instanceof Integer) {
            this.f64321u.g(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.f64321u.g(7).k(this.f64303c.e((String) obj).f64353a);
        } else {
            this.f64321u.g(8).k(((q) obj).f64288d);
        }
    }

    private void W(q qVar, q[] qVarArr) {
        q qVar2 = this.Q;
        if (qVar2 != null) {
            int i11 = this.N;
            if (i11 == 4) {
                qVar2.f64294j.d(171, 0, null, null);
                G(0, qVar);
                q e11 = qVar.e();
                e11.f64285a = (short) (e11.f64285a | 2);
                for (q qVar3 : qVarArr) {
                    G(0, qVar3);
                    q e12 = qVar3.e();
                    e12.f64285a = (short) (e12.f64285a | 2);
                }
            } else if (i11 == 1) {
                int i12 = this.R - 1;
                this.R = i12;
                G(i12, qVar);
                for (q qVar4 : qVarArr) {
                    G(this.R, qVar4);
                }
            }
            M();
        }
    }

    @Override // h10.r
    public void A(int i11, int i12, q qVar, q... qVarArr) {
        d dVar = this.f64311k;
        this.Z = dVar.f64191b;
        dVar.g(170).h(null, 0, (4 - (this.f64311k.f64191b % 4)) % 4);
        qVar.h(this.f64311k, this.Z, true);
        this.f64311k.i(i11).i(i12);
        for (q qVar2 : qVarArr) {
            qVar2.h(this.f64311k, this.Z, true);
        }
        W(qVar, qVarArr);
    }

    @Override // h10.r
    public a B(int i11, z zVar, String str, boolean z10) {
        d dVar = new d();
        a0.a(i11, dVar);
        z.d(zVar, dVar);
        dVar.k(this.f64303c.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64303c, dVar, this.f64322v);
            this.f64322v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64303c, dVar, this.f64323w);
        this.f64323w = bVar2;
        return bVar2;
    }

    @Override // h10.r
    public void C(q qVar, q qVar2, q qVar3, String str) {
        p pVar = new p(qVar, qVar2, qVar3, str != null ? this.f64303c.e(str).f64353a : 0, str);
        if (this.f64312l == null) {
            this.f64312l = pVar;
        } else {
            this.f64313m.f64283f = pVar;
        }
        this.f64313m = pVar;
    }

    @Override // h10.r
    public a D(int i11, z zVar, String str, boolean z10) {
        d dVar = new d();
        a0.a(i11, dVar);
        z.d(zVar, dVar);
        dVar.k(this.f64303c.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64303c, dVar, this.H);
            this.H = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64303c, dVar, this.I);
        this.I = bVar2;
        return bVar2;
    }

    @Override // h10.r
    public void E(int i11, String str) {
        this.Z = this.f64311k.f64191b;
        w e11 = this.f64303c.e(str);
        this.f64311k.e(i11, e11.f64353a);
        q qVar = this.Q;
        if (qVar != null) {
            int i12 = this.N;
            if (i12 == 4 || i12 == 3) {
                qVar.f64294j.d(i11, this.Z, e11, this.f64303c);
            } else if (i11 == 187) {
                int i13 = this.R + 1;
                if (i13 > this.S) {
                    this.S = i13;
                }
                this.R = i13;
            }
        }
    }

    @Override // h10.r
    public void F(int i11, int i12) {
        d dVar = this.f64311k;
        this.Z = dVar.f64191b;
        if (i12 < 4 && i11 != 169) {
            dVar.g((i11 < 54 ? ((i11 - 21) << 2) + 26 : ((i11 - 54) << 2) + 59) + i12);
        } else if (i12 >= 256) {
            dVar.g(196).e(i11, i12);
        } else {
            dVar.c(i11, i12);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i13 = this.N;
            if (i13 == 4 || i13 == 3) {
                qVar.f64294j.d(i11, i12, null, null);
            } else if (i11 == 169) {
                qVar.f64285a = (short) (qVar.f64285a | 64);
                qVar.f64291g = (short) this.R;
                M();
            } else {
                int i14 = this.R + f64300c0[i11];
                if (i14 > this.S) {
                    this.S = i14;
                }
                this.R = i14;
            }
        }
        int i15 = this.N;
        if (i15 != 0) {
            int i16 = (i11 == 22 || i11 == 24 || i11 == 55 || i11 == 57) ? i12 + 2 : i12 + 1;
            if (i16 > this.f64310j) {
                this.f64310j = i16;
            }
        }
        if (i11 < 54 || i15 != 4 || this.f64312l == null) {
            return;
        }
        o(new q());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H(e eVar, int i11, int i12, boolean z10, boolean z11, int i13, int i14, int i15) {
        if (eVar == this.f64303c.S() && i13 == this.f64307g && i14 == this.A) {
            if (z11 == ((this.f64304d & 131072) != 0)) {
                if (z10 != (this.f64303c.R() < 49 && (this.f64304d & 4096) != 0)) {
                    return false;
                }
                if (i15 == 0) {
                    if (this.f64325y != 0) {
                        return false;
                    }
                } else if (eVar.H(i15) == this.f64325y) {
                    int i16 = i15 + 2;
                    for (int i17 = 0; i17 < this.f64325y; i17++) {
                        if (eVar.H(i16) != this.f64326z[i17]) {
                            return false;
                        }
                        i16 += 2;
                    }
                }
                this.f64301a0 = i11 + 6;
                this.f64302b0 = i12 - 6;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void I(c.a aVar) {
        aVar.b(this.M);
        aVar.b(this.f64324x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int L() {
        int i11;
        if (this.f64301a0 != 0) {
            return this.f64302b0 + 6;
        }
        int i12 = this.f64311k.f64191b;
        if (i12 <= 0) {
            i11 = 8;
        } else {
            if (i12 > 65535) {
                throw new MethodTooLargeException(this.f64303c.O(), this.f64306f, this.f64308h, this.f64311k.f64191b);
            }
            this.f64303c.D("Code");
            i11 = this.f64311k.f64191b + 16 + p.b(this.f64312l) + 8;
            if (this.f64321u != null) {
                this.f64303c.D(this.f64303c.R() >= 50 ? "StackMapTable" : "StackMap");
                i11 += this.f64321u.f64191b + 8;
            }
            if (this.f64315o != null) {
                this.f64303c.D("LineNumberTable");
                i11 += this.f64315o.f64191b + 8;
            }
            if (this.f64317q != null) {
                this.f64303c.D("LocalVariableTable");
                i11 += this.f64317q.f64191b + 8;
            }
            if (this.f64319s != null) {
                this.f64303c.D("LocalVariableTypeTable");
                i11 += this.f64319s.f64191b + 8;
            }
            b bVar = this.f64322v;
            if (bVar != null) {
                i11 += bVar.f("RuntimeVisibleTypeAnnotations");
            }
            b bVar2 = this.f64323w;
            if (bVar2 != null) {
                i11 += bVar2.f("RuntimeInvisibleTypeAnnotations");
            }
            c cVar = this.f64324x;
            if (cVar != null) {
                x xVar = this.f64303c;
                d dVar = this.f64311k;
                i11 += cVar.b(xVar, dVar.f64190a, dVar.f64191b, this.f64309i, this.f64310j);
            }
        }
        if (this.f64325y > 0) {
            this.f64303c.D("Exceptions");
            i11 += (this.f64325y * 2) + 8;
        }
        boolean z10 = this.f64303c.R() < 49;
        if ((this.f64304d & 4096) != 0 && z10) {
            this.f64303c.D("Synthetic");
            i11 += 6;
        }
        if (this.A != 0) {
            this.f64303c.D(RequestParameters.SIGNATURE);
            i11 += 8;
        }
        if ((this.f64304d & 131072) != 0) {
            this.f64303c.D("Deprecated");
            i11 += 6;
        }
        b bVar3 = this.B;
        if (bVar3 != null) {
            i11 += bVar3.f("RuntimeVisibleAnnotations");
        }
        b bVar4 = this.C;
        if (bVar4 != null) {
            i11 += bVar4.f("RuntimeInvisibleAnnotations");
        }
        b[] bVarArr = this.E;
        if (bVarArr != null) {
            int i13 = this.D;
            if (i13 == 0) {
                i13 = bVarArr.length;
            }
            i11 += b.g("RuntimeVisibleParameterAnnotations", bVarArr, i13);
        }
        b[] bVarArr2 = this.G;
        if (bVarArr2 != null) {
            int i14 = this.F;
            if (i14 == 0) {
                i14 = bVarArr2.length;
            }
            i11 += b.g("RuntimeInvisibleParameterAnnotations", bVarArr2, i14);
        }
        b bVar5 = this.H;
        if (bVar5 != null) {
            i11 += bVar5.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar6 = this.I;
        if (bVar6 != null) {
            i11 += bVar6.f("RuntimeInvisibleTypeAnnotations");
        }
        if (this.J != null) {
            this.f64303c.D("AnnotationDefault");
            i11 += this.J.f64191b + 6;
        }
        if (this.L != null) {
            this.f64303c.D("MethodParameters");
            i11 += this.L.f64191b + 7;
        }
        c cVar2 = this.M;
        return cVar2 != null ? i11 + cVar2.a(this.f64303c) : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N() {
        return this.Y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O() {
        return this.f64320t > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S(h10.d r23) {
        /*
            Method dump skipped, instructions count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h10.s.S(h10.d):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i11, int i12) {
        this.W[i11] = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        if (this.V != null) {
            if (this.f64321u == null) {
                this.f64321u = new d();
            }
            Q();
            this.f64320t++;
        }
        this.V = this.W;
        this.W = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int V(int i11, int i12, int i13) {
        int i14 = i12 + 3 + i13;
        int[] iArr = this.W;
        if (iArr == null || iArr.length < i14) {
            this.W = new int[i14];
        }
        int[] iArr2 = this.W;
        iArr2[0] = i11;
        iArr2[1] = i12;
        iArr2[2] = i13;
        return 3;
    }

    @Override // h10.r
    public void a(int i11, boolean z10) {
        if (z10) {
            this.D = i11;
        } else {
            this.F = i11;
        }
    }

    @Override // h10.r
    public a b(String str, boolean z10) {
        d dVar = new d();
        dVar.k(this.f64303c.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64303c, dVar, this.B);
            this.B = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64303c, dVar, this.C);
        this.C = bVar2;
        return bVar2;
    }

    @Override // h10.r
    public a c() {
        d dVar = new d();
        this.J = dVar;
        return new b(this.f64303c, false, dVar, null);
    }

    @Override // h10.r
    public void d(c cVar) {
        if (cVar.d()) {
            cVar.f64187c = this.f64324x;
            this.f64324x = cVar;
        } else {
            cVar.f64187c = this.M;
            this.M = cVar;
        }
    }

    @Override // h10.r
    public void e() {
    }

    @Override // h10.r
    public void f() {
    }

    @Override // h10.r
    public void g(int i11, String str, String str2, String str3) {
        int i12;
        int i13;
        this.Z = this.f64311k.f64191b;
        w j11 = this.f64303c.j(str, str2, str3);
        this.f64311k.e(i11, j11.f64353a);
        q qVar = this.Q;
        if (qVar != null) {
            int i14 = this.N;
            if (i14 == 4 || i14 == 3) {
                qVar.f64294j.d(i11, 0, j11, this.f64303c);
                return;
            }
            char charAt = str3.charAt(0);
            int i15 = -2;
            switch (i11) {
                case 178:
                    i12 = this.R + ((charAt == 'D' || charAt == 'J') ? 2 : 1);
                    break;
                case 179:
                    i13 = this.R;
                    if (charAt != 'D' && charAt != 'J') {
                        i15 = -1;
                    }
                    i12 = i13 + i15;
                    break;
                case 180:
                    i12 = this.R + ((charAt == 'D' || charAt == 'J') ? 1 : 0);
                    break;
                default:
                    i13 = this.R;
                    if (charAt == 'D' || charAt == 'J') {
                        i15 = -3;
                    }
                    i12 = i13 + i15;
                    break;
            }
            if (i12 > this.S) {
                this.S = i12;
            }
            this.R = i12;
        }
    }

    @Override // h10.r
    public void h(int i11, int i12, Object[] objArr, int i13, Object[] objArr2) {
        int i14;
        int i15 = this.N;
        if (i15 == 4) {
            return;
        }
        if (i15 == 3) {
            q qVar = this.Q;
            n nVar = qVar.f64294j;
            if (nVar == null) {
                qVar.f64294j = new j(qVar);
                this.Q.f64294j.t(this.f64303c, this.f64304d, this.f64308h, i12);
                this.Q.f64294j.a(this);
            } else {
                if (i11 == -1) {
                    nVar.s(this.f64303c, i12, objArr, i13, objArr2);
                }
                this.Q.f64294j.a(this);
            }
        } else if (i11 == -1) {
            if (this.V == null) {
                int c11 = y.c(this.f64308h) >> 2;
                n nVar2 = new n(new q());
                nVar2.t(this.f64303c, this.f64304d, this.f64308h, c11);
                nVar2.a(this);
            }
            this.T = i12;
            int V = V(this.f64311k.f64191b, i12, i13);
            int i16 = 0;
            while (i16 < i12) {
                this.W[V] = n.e(this.f64303c, objArr[i16]);
                i16++;
                V++;
            }
            int i17 = 0;
            while (i17 < i13) {
                this.W[V] = n.e(this.f64303c, objArr2[i17]);
                i17++;
                V++;
            }
            U();
        } else {
            if (this.f64321u == null) {
                this.f64321u = new d();
                i14 = this.f64311k.f64191b;
            } else {
                i14 = (this.f64311k.f64191b - this.U) - 1;
                if (i14 < 0) {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i11 == 0) {
                this.T = i12;
                this.f64321u.g(255).k(i14).k(i12);
                for (int i18 = 0; i18 < i12; i18++) {
                    R(objArr[i18]);
                }
                this.f64321u.k(i13);
                for (int i19 = 0; i19 < i13; i19++) {
                    R(objArr2[i19]);
                }
            } else if (i11 == 1) {
                this.T += i12;
                this.f64321u.g(i12 + 251).k(i14);
                for (int i20 = 0; i20 < i12; i20++) {
                    R(objArr[i20]);
                }
            } else if (i11 == 2) {
                this.T -= i12;
                this.f64321u.g(251 - i12).k(i14);
            } else if (i11 != 3) {
                if (i11 != 4) {
                    throw new IllegalArgumentException();
                }
                if (i14 < 64) {
                    this.f64321u.g(i14 + 64);
                } else {
                    this.f64321u.g(247).k(i14);
                }
                R(objArr2[0]);
            } else if (i14 < 64) {
                this.f64321u.g(i14);
            } else {
                this.f64321u.g(251).k(i14);
            }
            this.U = this.f64311k.f64191b;
            this.f64320t++;
        }
        if (this.N == 2) {
            this.R = i13;
            for (int i21 = 0; i21 < i13; i21++) {
                Object obj = objArr2[i21];
                if (obj == v.f64350e || obj == v.f64349d) {
                    this.R++;
                }
            }
            int i22 = this.R;
            if (i22 > this.S) {
                this.S = i22;
            }
        }
        this.f64309i = Math.max(this.f64309i, i13);
        this.f64310j = Math.max(this.f64310j, this.T);
    }

    @Override // h10.r
    public void i(int i11, int i12) {
        int i13;
        int i14;
        d dVar = this.f64311k;
        this.Z = dVar.f64191b;
        if (i11 > 255 || i12 > 127 || i12 < -128) {
            dVar.g(196).e(Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, i11).k(i12);
        } else {
            dVar.g(Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE).c(i11, i12);
        }
        q qVar = this.Q;
        if (qVar != null && ((i14 = this.N) == 4 || i14 == 3)) {
            qVar.f64294j.d(Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, i11, null, null);
        }
        if (this.N == 0 || (i13 = i11 + 1) <= this.f64310j) {
            return;
        }
        this.f64310j = i13;
    }

    @Override // h10.r
    public void j(int i11) {
        d dVar = this.f64311k;
        this.Z = dVar.f64191b;
        dVar.g(i11);
        q qVar = this.Q;
        if (qVar != null) {
            int i12 = this.N;
            if (i12 == 4 || i12 == 3) {
                qVar.f64294j.d(i11, 0, null, null);
            } else {
                int i13 = this.R + f64300c0[i11];
                if (i13 > this.S) {
                    this.S = i13;
                }
                this.R = i13;
            }
            if ((i11 < 172 || i11 > 177) && i11 != 191) {
                return;
            }
            M();
        }
    }

    @Override // h10.r
    public a k(int i11, z zVar, String str, boolean z10) {
        d dVar = new d();
        a0.a((i11 & (-16776961)) | (this.Z << 8), dVar);
        z.d(zVar, dVar);
        dVar.k(this.f64303c.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64303c, dVar, this.f64322v);
            this.f64322v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64303c, dVar, this.f64323w);
        this.f64323w = bVar2;
        return bVar2;
    }

    @Override // h10.r
    public void l(int i11, int i12) {
        d dVar = this.f64311k;
        this.Z = dVar.f64191b;
        if (i11 == 17) {
            dVar.e(i11, i12);
        } else {
            dVar.c(i11, i12);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i13 = this.N;
            if (i13 == 4 || i13 == 3) {
                qVar.f64294j.d(i11, i12, null, null);
            } else if (i11 != 188) {
                int i14 = this.R + 1;
                if (i14 > this.S) {
                    this.S = i14;
                }
                this.R = i14;
            }
        }
    }

    @Override // h10.r
    public void m(String str, String str2, o oVar, Object... objArr) {
        this.Z = this.f64311k.f64191b;
        w o11 = this.f64303c.o(str, str2, oVar, objArr);
        this.f64311k.e(186, o11.f64353a);
        this.f64311k.k(0);
        q qVar = this.Q;
        if (qVar != null) {
            int i11 = this.N;
            if (i11 == 4 || i11 == 3) {
                qVar.f64294j.d(186, 0, o11, this.f64303c);
                return;
            }
            int a11 = o11.a();
            int i12 = this.R + ((a11 & 3) - (a11 >> 2)) + 1;
            if (i12 > this.S) {
                this.S = i12;
            }
            this.R = i12;
        }
    }

    @Override // h10.r
    public void n(int i11, q qVar) {
        boolean z10;
        d dVar = this.f64311k;
        int i12 = dVar.f64191b;
        this.Z = i12;
        int i13 = i11 >= 200 ? i11 - 33 : i11;
        if ((qVar.f64285a & 4) == 0 || qVar.f64288d - i12 >= -32768) {
            if (i13 != i11) {
                dVar.g(i11);
                d dVar2 = this.f64311k;
                qVar.h(dVar2, dVar2.f64191b - 1, true);
            } else {
                dVar.g(i13);
                d dVar3 = this.f64311k;
                qVar.h(dVar3, dVar3.f64191b - 1, false);
            }
            z10 = false;
        } else {
            if (i13 == 167) {
                dVar.g(200);
            } else if (i13 == 168) {
                dVar.g(201);
            } else {
                dVar.g(i13 >= 198 ? i13 ^ 1 : ((i13 + 1) ^ 1) - 1);
                this.f64311k.k(8);
                this.f64311k.g(Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE);
                this.Y = true;
                z10 = true;
                d dVar4 = this.f64311k;
                qVar.h(dVar4, dVar4.f64191b - 1, true);
            }
            z10 = false;
            d dVar42 = this.f64311k;
            qVar.h(dVar42, dVar42.f64191b - 1, true);
        }
        q qVar2 = this.Q;
        if (qVar2 != null) {
            int i14 = this.N;
            q qVar3 = null;
            if (i14 == 4) {
                qVar2.f64294j.d(i13, 0, null, null);
                q e11 = qVar.e();
                e11.f64285a = (short) (e11.f64285a | 2);
                G(0, qVar);
                if (i13 != 167) {
                    qVar3 = new q();
                }
            } else if (i14 == 3) {
                qVar2.f64294j.d(i13, 0, null, null);
            } else if (i14 == 2) {
                this.R += f64300c0[i13];
            } else if (i13 == 168) {
                short s11 = qVar.f64285a;
                if ((s11 & 32) == 0) {
                    qVar.f64285a = (short) (s11 | 32);
                    this.X = true;
                }
                qVar2.f64285a = (short) (qVar2.f64285a | 16);
                G(this.R + 1, qVar);
                qVar3 = new q();
            } else {
                int i15 = this.R + f64300c0[i13];
                this.R = i15;
                G(i15, qVar);
            }
            if (qVar3 != null) {
                if (z10) {
                    qVar3.f64285a = (short) (qVar3.f64285a | 2);
                }
                o(qVar3);
            }
            if (i13 == 167) {
                M();
            }
        }
    }

    @Override // h10.r
    public void o(q qVar) {
        boolean z10 = this.Y;
        d dVar = this.f64311k;
        this.Y = z10 | qVar.i(dVar.f64190a, dVar.f64191b);
        short s11 = qVar.f64285a;
        if ((s11 & 1) != 0) {
            return;
        }
        int i11 = this.N;
        if (i11 == 4) {
            q qVar2 = this.Q;
            if (qVar2 != null) {
                if (qVar.f64288d == qVar2.f64288d) {
                    qVar2.f64285a = (short) ((s11 & 2) | qVar2.f64285a);
                    qVar.f64294j = qVar2.f64294j;
                    return;
                }
                G(0, qVar);
            }
            q qVar3 = this.P;
            if (qVar3 != null) {
                if (qVar.f64288d == qVar3.f64288d) {
                    qVar3.f64285a = (short) (qVar3.f64285a | (qVar.f64285a & 2));
                    qVar.f64294j = qVar3.f64294j;
                    this.Q = qVar3;
                    return;
                }
                qVar3.f64295k = qVar;
            }
            this.P = qVar;
            this.Q = qVar;
            qVar.f64294j = new n(qVar);
            return;
        }
        if (i11 == 3) {
            q qVar4 = this.Q;
            if (qVar4 == null) {
                this.Q = qVar;
                return;
            } else {
                qVar4.f64294j.f64264a = qVar;
                return;
            }
        }
        if (i11 != 1) {
            if (i11 == 2 && this.Q == null) {
                this.Q = qVar;
                return;
            }
            return;
        }
        q qVar5 = this.Q;
        if (qVar5 != null) {
            qVar5.f64292h = (short) this.S;
            G(this.R, qVar);
        }
        this.Q = qVar;
        this.R = 0;
        this.S = 0;
        q qVar6 = this.P;
        if (qVar6 != null) {
            qVar6.f64295k = qVar;
        }
        this.P = qVar;
    }

    @Override // h10.r
    public void p(Object obj) {
        char charAt;
        this.Z = this.f64311k.f64191b;
        w d11 = this.f64303c.d(obj);
        int i11 = d11.f64353a;
        int i12 = d11.f64354b;
        boolean z10 = i12 == 5 || i12 == 6 || (i12 == 17 && ((charAt = d11.f64357e.charAt(0)) == 'J' || charAt == 'D'));
        if (z10) {
            this.f64311k.e(20, i11);
        } else if (i11 >= 256) {
            this.f64311k.e(19, i11);
        } else {
            this.f64311k.c(18, i11);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i13 = this.N;
            if (i13 == 4 || i13 == 3) {
                qVar.f64294j.d(18, 0, d11, this.f64303c);
                return;
            }
            int i14 = this.R + (z10 ? 2 : 1);
            if (i14 > this.S) {
                this.S = i14;
            }
            this.R = i14;
        }
    }

    @Override // h10.r
    public void q(int i11, q qVar) {
        if (this.f64315o == null) {
            this.f64315o = new d();
        }
        this.f64314n++;
        this.f64315o.k(qVar.f64288d);
        this.f64315o.k(i11);
    }

    @Override // h10.r
    public void r(String str, String str2, String str3, q qVar, q qVar2, int i11) {
        if (str3 != null) {
            if (this.f64319s == null) {
                this.f64319s = new d();
            }
            this.f64318r++;
            this.f64319s.k(qVar.f64288d).k(qVar2.f64288d - qVar.f64288d).k(this.f64303c.D(str)).k(this.f64303c.D(str3)).k(i11);
        }
        if (this.f64317q == null) {
            this.f64317q = new d();
        }
        this.f64316p++;
        this.f64317q.k(qVar.f64288d).k(qVar2.f64288d - qVar.f64288d).k(this.f64303c.D(str)).k(this.f64303c.D(str2)).k(i11);
        if (this.N != 0) {
            char charAt = str2.charAt(0);
            int i12 = i11 + ((charAt == 'J' || charAt == 'D') ? 2 : 1);
            if (i12 > this.f64310j) {
                this.f64310j = i12;
            }
        }
    }

    @Override // h10.r
    public a s(int i11, z zVar, q[] qVarArr, q[] qVarArr2, int[] iArr, String str, boolean z10) {
        d dVar = new d();
        dVar.g(i11 >>> 24).k(qVarArr.length);
        for (int i12 = 0; i12 < qVarArr.length; i12++) {
            dVar.k(qVarArr[i12].f64288d).k(qVarArr2[i12].f64288d - qVarArr[i12].f64288d).k(iArr[i12]);
        }
        z.d(zVar, dVar);
        dVar.k(this.f64303c.D(str)).k(0);
        if (z10) {
            b bVar = new b(this.f64303c, dVar, this.f64322v);
            this.f64322v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.f64303c, dVar, this.f64323w);
        this.f64323w = bVar2;
        return bVar2;
    }

    @Override // h10.r
    public void t(q qVar, int[] iArr, q[] qVarArr) {
        d dVar = this.f64311k;
        this.Z = dVar.f64191b;
        dVar.g(171).h(null, 0, (4 - (this.f64311k.f64191b % 4)) % 4);
        qVar.h(this.f64311k, this.Z, true);
        this.f64311k.i(qVarArr.length);
        for (int i11 = 0; i11 < qVarArr.length; i11++) {
            this.f64311k.i(iArr[i11]);
            qVarArr[i11].h(this.f64311k, this.Z, true);
        }
        W(qVar, qVarArr);
    }

    @Override // h10.r
    public void u(int i11, int i12) {
        int i13 = this.N;
        if (i13 == 4) {
            J();
            return;
        }
        if (i13 == 1) {
            K();
        } else if (i13 == 2) {
            this.f64309i = this.S;
        } else {
            this.f64309i = i11;
            this.f64310j = i12;
        }
    }

    @Override // h10.r
    public void w(int i11, String str, String str2, String str3, boolean z10) {
        this.Z = this.f64311k.f64191b;
        w x10 = this.f64303c.x(str, str2, str3, z10);
        if (i11 == 185) {
            this.f64311k.e(185, x10.f64353a).c(x10.a() >> 2, 0);
        } else {
            this.f64311k.e(i11, x10.f64353a);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i12 = this.N;
            if (i12 == 4 || i12 == 3) {
                qVar.f64294j.d(i11, 0, x10, this.f64303c);
                return;
            }
            int a11 = x10.a();
            int i13 = (a11 & 3) - (a11 >> 2);
            int i14 = i11 == 184 ? this.R + i13 + 1 : this.R + i13;
            if (i14 > this.S) {
                this.S = i14;
            }
            this.R = i14;
        }
    }

    @Override // h10.r
    public void x(String str, int i11) {
        this.Z = this.f64311k.f64191b;
        w e11 = this.f64303c.e(str);
        this.f64311k.e(197, e11.f64353a).g(i11);
        q qVar = this.Q;
        if (qVar != null) {
            int i12 = this.N;
            if (i12 == 4 || i12 == 3) {
                qVar.f64294j.d(197, i11, e11, this.f64303c);
            } else {
                this.R += 1 - i11;
            }
        }
    }

    @Override // h10.r
    public void y(String str, int i11) {
        if (this.L == null) {
            this.L = new d();
        }
        this.K++;
        this.L.k(str == null ? 0 : this.f64303c.D(str)).k(i11);
    }

    @Override // h10.r
    public a z(int i11, String str, boolean z10) {
        d dVar = new d();
        dVar.k(this.f64303c.D(str)).k(0);
        if (z10) {
            if (this.E == null) {
                this.E = new b[y.b(this.f64308h).length];
            }
            b[] bVarArr = this.E;
            b bVar = new b(this.f64303c, dVar, bVarArr[i11]);
            bVarArr[i11] = bVar;
            return bVar;
        }
        if (this.G == null) {
            this.G = new b[y.b(this.f64308h).length];
        }
        b[] bVarArr2 = this.G;
        b bVar2 = new b(this.f64303c, dVar, bVarArr2[i11]);
        bVarArr2[i11] = bVar2;
        return bVar2;
    }
}
