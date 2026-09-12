package h10;

import org.mvel2.optimizers.OptimizationNotSupported;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    final g f64360a;

    /* renamed from: b, reason: collision with root package name */
    private final e f64361b;

    /* renamed from: c, reason: collision with root package name */
    private int f64362c;

    /* renamed from: d, reason: collision with root package name */
    private String f64363d;

    /* renamed from: e, reason: collision with root package name */
    private int f64364e;

    /* renamed from: f, reason: collision with root package name */
    private a[] f64365f;

    /* renamed from: g, reason: collision with root package name */
    private int f64366g;

    /* renamed from: h, reason: collision with root package name */
    private d f64367h;

    /* renamed from: i, reason: collision with root package name */
    private int f64368i;

    /* renamed from: j, reason: collision with root package name */
    private d f64369j;

    /* renamed from: k, reason: collision with root package name */
    private int f64370k;

    /* renamed from: l, reason: collision with root package name */
    private a[] f64371l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends w {

        /* renamed from: h, reason: collision with root package name */
        final int f64372h;

        /* renamed from: i, reason: collision with root package name */
        a f64373i;

        a(int i11, int i12, long j11, int i13) {
            super(i11, i12, null, null, null, j11);
            this.f64372h = i13;
        }

        a(int i11, int i12, String str, int i13) {
            super(i11, i12, null, null, str, 0L);
            this.f64372h = i13;
        }

        a(int i11, int i12, String str, long j11, int i13) {
            super(i11, i12, null, null, str, j11);
            this.f64372h = i13;
        }

        a(int i11, int i12, String str, String str2, int i13) {
            super(i11, i12, null, str, str2, 0L);
            this.f64372h = i13;
        }

        a(int i11, int i12, String str, String str2, String str3, long j11, int i13) {
            super(i11, i12, str, str2, str3, j11);
            this.f64372h = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(g gVar) {
        this.f64360a = gVar;
        this.f64361b = null;
        this.f64365f = new a[256];
        this.f64366g = 1;
        this.f64367h = new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(g gVar, e eVar) {
        this.f64360a = gVar;
        this.f64361b = eVar;
        byte[] bArr = eVar.f64192a;
        int f11 = eVar.f(1) - 1;
        int i11 = eVar.f64198g - f11;
        this.f64366g = eVar.g();
        d dVar = new d(i11);
        this.f64367h = dVar;
        dVar.h(bArr, f11, i11);
        this.f64365f = new a[this.f64366g * 2];
        char[] cArr = new char[eVar.h()];
        boolean z10 = false;
        int i12 = 1;
        while (i12 < this.f64366g) {
            int f12 = eVar.f(i12);
            byte b11 = bArr[f12 - 1];
            switch (b11) {
                case 1:
                    E(i12, eVar.J(i12, cArr));
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                    n(i12, b11, eVar.t(f12));
                    break;
                case 5:
                case 6:
                    r(i12, b11, eVar.v(f12));
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    G(i12, b11, eVar.G(f12, cArr));
                    break;
                case 9:
                case 10:
                case 11:
                    int f13 = eVar.f(eVar.H(f12 + 2));
                    t(i12, b11, eVar.m(f12, cArr), eVar.G(f13, cArr), eVar.G(f13 + 2, cArr));
                    break;
                case 12:
                    A(i12, eVar.G(f12, cArr), eVar.G(f12 + 2, cArr));
                    break;
                case 15:
                    int f14 = eVar.f(eVar.H(f12 + 1));
                    int f15 = eVar.f(eVar.H(f14 + 2));
                    v(i12, eVar.l(f12), eVar.m(f14, cArr), eVar.G(f15, cArr), eVar.G(f15 + 2, cArr));
                    break;
                case 17:
                case 18:
                    int f16 = eVar.f(eVar.H(f12 + 2));
                    i(b11, i12, eVar.G(f16, cArr), eVar.G(f16 + 2, cArr), eVar.H(f12));
                    z10 = true;
                    break;
            }
            i12 += (b11 == 5 || b11 == 6) ? 2 : 1;
        }
        if (z10) {
            M(eVar, cArr);
        }
    }

    private void A(int i11, String str, String str2) {
        a(new a(i11, 12, str, str2, Y(12, str, str2)));
    }

    private void E(int i11, String str) {
        a(new a(i11, 1, str, W(1, str)));
    }

    private w F(int i11, String str) {
        int W = W(i11, str);
        for (a N = N(W); N != null; N = N.f64373i) {
            if (N.f64354b == i11 && N.f64372h == W && N.f64357e.equals(str)) {
                return N;
            }
        }
        this.f64367h.e(i11, D(str));
        int i12 = this.f64366g;
        this.f64366g = i12 + 1;
        return c0(new a(i12, i11, str, W));
    }

    private void G(int i11, int i12, String str) {
        a(new a(i11, i12, str, W(i12, str)));
    }

    private int J(a aVar) {
        if (this.f64371l == null) {
            this.f64371l = new a[16];
        }
        int i11 = this.f64370k;
        a[] aVarArr = this.f64371l;
        if (i11 == aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length * 2];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            this.f64371l = aVarArr2;
        }
        a[] aVarArr3 = this.f64371l;
        int i12 = this.f64370k;
        this.f64370k = i12 + 1;
        aVarArr3[i12] = aVar;
        return c0(aVar).f64353a;
    }

    private void M(e eVar, char[] cArr) {
        byte[] bArr = eVar.f64192a;
        int e11 = eVar.e();
        int H = eVar.H(e11 - 2);
        while (true) {
            if (H <= 0) {
                break;
            }
            if ("BootstrapMethods".equals(eVar.G(e11, cArr))) {
                this.f64368i = eVar.H(e11 + 6);
                break;
            } else {
                e11 += eVar.t(e11 + 2) + 6;
                H--;
            }
        }
        if (this.f64368i > 0) {
            int i11 = e11 + 8;
            int t11 = eVar.t(e11 + 2) - 2;
            d dVar = new d(t11);
            this.f64369j = dVar;
            dVar.h(bArr, i11, t11);
            int i12 = i11;
            for (int i13 = 0; i13 < this.f64368i; i13++) {
                int i14 = i12 - i11;
                int H2 = eVar.H(i12);
                int H3 = eVar.H(i12 + 2);
                i12 += 4;
                int hashCode = eVar.o(H2, cArr).hashCode();
                while (true) {
                    int i15 = H3 - 1;
                    if (H3 > 0) {
                        int H4 = eVar.H(i12);
                        i12 += 2;
                        hashCode ^= eVar.o(H4, cArr).hashCode();
                        H3 = i15;
                    }
                }
                a(new a(i13, 64, i14, hashCode & Integer.MAX_VALUE));
            }
        }
    }

    private a N(int i11) {
        a[] aVarArr = this.f64365f;
        return aVarArr[i11 % aVarArr.length];
    }

    private static int U(int i11, int i12) {
        return (i11 + i12) & Integer.MAX_VALUE;
    }

    private static int V(int i11, long j11) {
        return (i11 + ((int) j11) + ((int) (j11 >>> 32))) & Integer.MAX_VALUE;
    }

    private static int W(int i11, String str) {
        return (i11 + str.hashCode()) & Integer.MAX_VALUE;
    }

    private static int X(int i11, String str, int i12) {
        return (i11 + str.hashCode() + i12) & Integer.MAX_VALUE;
    }

    private static int Y(int i11, String str, String str2) {
        return (i11 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
    }

    private static int Z(int i11, String str, String str2, int i12) {
        return (i11 + (str.hashCode() * str2.hashCode() * (i12 + 1))) & Integer.MAX_VALUE;
    }

    private void a(a aVar) {
        this.f64364e++;
        int i11 = aVar.f64372h;
        a[] aVarArr = this.f64365f;
        int length = i11 % aVarArr.length;
        aVar.f64373i = aVarArr[length];
        aVarArr[length] = aVar;
    }

    private static int a0(int i11, String str, String str2, String str3) {
        return (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
    }

    private w b(int i11, int i12, int i13) {
        byte[] bArr = this.f64369j.f64190a;
        for (a N = N(i13); N != null; N = N.f64373i) {
            if (N.f64354b == 64 && N.f64372h == i13) {
                int i14 = (int) N.f64358f;
                for (int i15 = 0; i15 < i12; i15++) {
                    if (bArr[i11 + i15] != bArr[i14 + i15]) {
                        break;
                    }
                }
                this.f64369j.f64191b = i11;
                return N;
            }
        }
        int i16 = this.f64368i;
        this.f64368i = i16 + 1;
        return c0(new a(i16, 64, i11, i13));
    }

    private static int b0(int i11, String str, String str2, String str3, int i12) {
        return (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode() * i12)) & Integer.MAX_VALUE;
    }

    private a c0(a aVar) {
        int i11 = this.f64364e;
        a[] aVarArr = this.f64365f;
        if (i11 > (aVarArr.length * 3) / 4) {
            int length = aVarArr.length;
            int i12 = (length * 2) + 1;
            a[] aVarArr2 = new a[i12];
            for (int i13 = length - 1; i13 >= 0; i13--) {
                a aVar2 = this.f64365f[i13];
                while (aVar2 != null) {
                    int i14 = aVar2.f64372h % i12;
                    a aVar3 = aVar2.f64373i;
                    aVar2.f64373i = aVarArr2[i14];
                    aVarArr2[i14] = aVar2;
                    aVar2 = aVar3;
                }
            }
            this.f64365f = aVarArr2;
        }
        this.f64364e++;
        int i15 = aVar.f64372h;
        a[] aVarArr3 = this.f64365f;
        int length2 = i15 % aVarArr3.length;
        aVar.f64373i = aVarArr3[length2];
        aVarArr3[length2] = aVar;
        return aVar;
    }

    private w h(int i11, String str, String str2, int i12) {
        int Z = Z(i11, str, str2, i12);
        for (a N = N(Z); N != null; N = N.f64373i) {
            if (N.f64354b == i11 && N.f64372h == Z && N.f64358f == i12 && N.f64356d.equals(str) && N.f64357e.equals(str2)) {
                return N;
            }
        }
        this.f64367h.f(i11, i12, z(str, str2));
        int i13 = this.f64366g;
        this.f64366g = i13 + 1;
        return c0(new a(i13, i11, null, str, str2, i12, Z));
    }

    private void i(int i11, int i12, String str, String str2, int i13) {
        a(new a(i12, i11, null, str, str2, i13, Z(i11, str, str2, i13)));
    }

    private w m(int i11, int i12) {
        int U = U(i11, i12);
        for (a N = N(U); N != null; N = N.f64373i) {
            if (N.f64354b == i11 && N.f64372h == U && N.f64358f == i12) {
                return N;
            }
        }
        this.f64367h.g(i11).i(i12);
        int i13 = this.f64366g;
        this.f64366g = i13 + 1;
        return c0(new a(i13, i11, i12, U));
    }

    private void n(int i11, int i12, int i13) {
        a(new a(i11, i12, i13, U(i12, i13)));
    }

    private w q(int i11, long j11) {
        int V = V(i11, j11);
        for (a N = N(V); N != null; N = N.f64373i) {
            if (N.f64354b == i11 && N.f64372h == V && N.f64358f == j11) {
                return N;
            }
        }
        int i12 = this.f64366g;
        this.f64367h.g(i11).j(j11);
        this.f64366g += 2;
        return c0(new a(i12, i11, j11, V));
    }

    private void r(int i11, int i12, long j11) {
        a(new a(i11, i12, j11, V(i12, j11)));
    }

    private a s(int i11, String str, String str2, String str3) {
        int a02 = a0(i11, str, str2, str3);
        for (a N = N(a02); N != null; N = N.f64373i) {
            if (N.f64354b == i11 && N.f64372h == a02 && N.f64355c.equals(str) && N.f64356d.equals(str2) && N.f64357e.equals(str3)) {
                return N;
            }
        }
        this.f64367h.f(i11, e(str).f64353a, z(str2, str3));
        int i12 = this.f64366g;
        this.f64366g = i12 + 1;
        return c0(new a(i12, i11, str, str2, str3, 0L, a02));
    }

    private void t(int i11, int i12, String str, String str2, String str3) {
        a(new a(i11, i12, str, str2, str3, 0L, a0(i12, str, str2, str3)));
    }

    private void v(int i11, int i12, String str, String str2, String str3) {
        a(new a(i11, 15, str, str2, str3, i12, b0(15, str, str2, str3, i12)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w B(String str) {
        return F(20, str);
    }

    w C(String str) {
        return F(8, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int D(String str) {
        int W = W(1, str);
        for (a N = N(W); N != null; N = N.f64373i) {
            if (N.f64354b == 1 && N.f64372h == W && N.f64357e.equals(str)) {
                return N.f64353a;
            }
        }
        this.f64367h.g(1).l(str);
        int i11 = this.f64366g;
        this.f64366g = i11 + 1;
        return c0(new a(i11, 1, str, W)).f64353a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int H(int i11, int i12) {
        long j11 = i11 | (i12 << 32);
        int U = U(130, i11 + i12);
        for (a N = N(U); N != null; N = N.f64373i) {
            if (N.f64354b == 130 && N.f64372h == U && N.f64358f == j11) {
                return N.f64359g;
            }
        }
        a[] aVarArr = this.f64371l;
        int I = I(this.f64360a.p(aVarArr[i11].f64357e, aVarArr[i12].f64357e));
        c0(new a(this.f64370k, 130, j11, U)).f64359g = I;
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int I(String str) {
        int W = W(128, str);
        for (a N = N(W); N != null; N = N.f64373i) {
            if (N.f64354b == 128 && N.f64372h == W && N.f64357e.equals(str)) {
                return N.f64353a;
            }
        }
        return J(new a(this.f64370k, 128, str, W));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int K(String str, int i11) {
        int X = X(129, str, i11);
        for (a N = N(X); N != null; N = N.f64373i) {
            if (N.f64354b == 129 && N.f64372h == X && N.f64358f == i11 && N.f64357e.equals(str)) {
                return N.f64353a;
            }
        }
        return J(new a(this.f64370k, 129, str, i11, X));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int L() {
        if (this.f64369j == null) {
            return 0;
        }
        D("BootstrapMethods");
        return this.f64369j.f64191b + 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String O() {
        return this.f64363d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int P() {
        return this.f64366g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Q() {
        return this.f64367h.f64191b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int R() {
        return this.f64362c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e S() {
        return this.f64361b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w T(int i11) {
        return this.f64371l[i11];
    }

    w c(o oVar, Object... objArr) {
        d dVar = this.f64369j;
        if (dVar == null) {
            dVar = new d();
            this.f64369j = dVar;
        }
        for (Object obj : objArr) {
            d(obj);
        }
        int i11 = dVar.f64191b;
        dVar.k(u(oVar.d(), oVar.c(), oVar.b(), oVar.a(), oVar.e()).f64353a);
        dVar.k(objArr.length);
        for (Object obj2 : objArr) {
            dVar.k(d(obj2).f64353a);
        }
        int i12 = dVar.f64191b - i11;
        int hashCode = oVar.hashCode();
        for (Object obj3 : objArr) {
            hashCode ^= obj3.hashCode();
        }
        return b(i11, i12, hashCode & Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w d(Object obj) {
        if (obj instanceof Integer) {
            return l(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return l(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return l(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return l(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return l(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return k(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return p(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return f(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return C((String) obj);
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            int l11 = yVar.l();
            return l11 == 10 ? e(yVar.g()) : l11 == 11 ? w(yVar.e()) : e(yVar.e());
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return u(oVar.d(), oVar.c(), oVar.b(), oVar.a(), oVar.e());
        }
        if (!(obj instanceof h)) {
            throw new OptimizationNotSupported();
        }
        h hVar = (h) obj;
        return g(hVar.d(), hVar.c(), hVar.a(), hVar.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(d dVar) {
        if (this.f64369j != null) {
            d k11 = dVar.k(D("BootstrapMethods")).i(this.f64369j.f64191b + 2).k(this.f64368i);
            d dVar2 = this.f64369j;
            k11.h(dVar2.f64190a, 0, dVar2.f64191b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w e(String str) {
        return F(7, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(d dVar) {
        d k11 = dVar.k(this.f64366g);
        d dVar2 = this.f64367h;
        k11.h(dVar2.f64190a, 0, dVar2.f64191b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w f(double d11) {
        return q(6, Double.doubleToRawLongBits(d11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f0(int i11, String str) {
        this.f64362c = i11;
        this.f64363d = str;
        return e(str).f64353a;
    }

    w g(String str, String str2, o oVar, Object... objArr) {
        return h(17, str, str2, c(oVar, objArr).f64353a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w j(String str, String str2, String str3) {
        return s(9, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w k(float f11) {
        return m(4, Float.floatToRawIntBits(f11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w l(int i11) {
        return m(3, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w o(String str, String str2, o oVar, Object... objArr) {
        return h(18, str, str2, c(oVar, objArr).f64353a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w p(long j11) {
        return q(5, j11);
    }

    w u(int i11, String str, String str2, String str3, boolean z10) {
        int b02 = b0(15, str, str2, str3, i11);
        for (a N = N(b02); N != null; N = N.f64373i) {
            if (N.f64354b == 15 && N.f64372h == b02 && N.f64358f == i11 && N.f64355c.equals(str) && N.f64356d.equals(str2) && N.f64357e.equals(str3)) {
                return N;
            }
        }
        if (i11 <= 4) {
            this.f64367h.d(15, i11, j(str, str2, str3).f64353a);
        } else {
            this.f64367h.d(15, i11, x(str, str2, str3, z10).f64353a);
        }
        int i12 = this.f64366g;
        this.f64366g = i12 + 1;
        return c0(new a(i12, 15, str, str2, str3, i11, b02));
    }

    w w(String str) {
        return F(16, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w x(String str, String str2, String str3, boolean z10) {
        return s(z10 ? 11 : 10, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w y(String str) {
        return F(19, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z(String str, String str2) {
        int Y = Y(12, str, str2);
        for (a N = N(Y); N != null; N = N.f64373i) {
            if (N.f64354b == 12 && N.f64372h == Y && N.f64356d.equals(str) && N.f64357e.equals(str2)) {
                return N.f64353a;
            }
        }
        this.f64367h.f(12, D(str), D(str2));
        int i11 = this.f64366g;
        this.f64366g = i11 + 1;
        return c0(new a(i11, 12, str, str2, Y)).f64353a;
    }
}
