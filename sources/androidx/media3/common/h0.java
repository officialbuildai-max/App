package androidx.media3.common;

import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class h0 {
    public static final h0 F;
    public static final h0 G;
    private static final String H;
    private static final String I;
    private static final String J;
    private static final String K;
    private static final String L;
    private static final String M;
    private static final String N;
    private static final String O;
    private static final String P;
    private static final String Q;
    private static final String R;
    private static final String S;
    private static final String T;
    private static final String U;
    private static final String V;
    private static final String W;
    private static final String X;
    private static final String Y;
    private static final String Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final String f10068a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final String f10069b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final String f10070c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final String f10071d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final String f10072e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final String f10073f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final String f10074g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final String f10075h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final String f10076i0;

    /* renamed from: j0, reason: collision with root package name */
    private static final String f10077j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final String f10078k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final String f10079l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final String f10080m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final String f10081n0;

    /* renamed from: o0, reason: collision with root package name */
    private static final String f10082o0;
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final ImmutableMap D;
    public final ImmutableSet E;

    /* renamed from: a, reason: collision with root package name */
    public final int f10083a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10084b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10085c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10086d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10087e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10088f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10089g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10090h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10091i;

    /* renamed from: j, reason: collision with root package name */
    public final int f10092j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10093k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f10094l;

    /* renamed from: m, reason: collision with root package name */
    public final ImmutableList f10095m;

    /* renamed from: n, reason: collision with root package name */
    public final ImmutableList f10096n;

    /* renamed from: o, reason: collision with root package name */
    public final int f10097o;

    /* renamed from: p, reason: collision with root package name */
    public final ImmutableList f10098p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10099q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10100r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10101s;

    /* renamed from: t, reason: collision with root package name */
    public final ImmutableList f10102t;

    /* renamed from: u, reason: collision with root package name */
    public final b f10103u;

    /* renamed from: v, reason: collision with root package name */
    public final ImmutableList f10104v;

    /* renamed from: w, reason: collision with root package name */
    public final int f10105w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f10106x;

    /* renamed from: y, reason: collision with root package name */
    public final int f10107y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f10108z;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        public static final b f10109d = new a().d();

        /* renamed from: e, reason: collision with root package name */
        private static final String f10110e = a1.C0(1);

        /* renamed from: f, reason: collision with root package name */
        private static final String f10111f = a1.C0(2);

        /* renamed from: g, reason: collision with root package name */
        private static final String f10112g = a1.C0(3);

        /* renamed from: a, reason: collision with root package name */
        public final int f10113a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10114b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10115c;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private int f10116a = 0;

            /* renamed from: b, reason: collision with root package name */
            private boolean f10117b = false;

            /* renamed from: c, reason: collision with root package name */
            private boolean f10118c = false;

            public b d() {
                return new b(this);
            }
        }

        private b(a aVar) {
            this.f10113a = aVar.f10116a;
            this.f10114b = aVar.f10117b;
            this.f10115c = aVar.f10118c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f10113a == bVar.f10113a && this.f10114b == bVar.f10114b && this.f10115c == bVar.f10115c;
        }

        public int hashCode() {
            return ((((this.f10113a + 31) * 31) + (this.f10114b ? 1 : 0)) * 31) + (this.f10115c ? 1 : 0);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        private boolean A;
        private boolean B;
        private boolean C;
        private HashMap D;
        private HashSet E;

        /* renamed from: a, reason: collision with root package name */
        private int f10119a;

        /* renamed from: b, reason: collision with root package name */
        private int f10120b;

        /* renamed from: c, reason: collision with root package name */
        private int f10121c;

        /* renamed from: d, reason: collision with root package name */
        private int f10122d;

        /* renamed from: e, reason: collision with root package name */
        private int f10123e;

        /* renamed from: f, reason: collision with root package name */
        private int f10124f;

        /* renamed from: g, reason: collision with root package name */
        private int f10125g;

        /* renamed from: h, reason: collision with root package name */
        private int f10126h;

        /* renamed from: i, reason: collision with root package name */
        private int f10127i;

        /* renamed from: j, reason: collision with root package name */
        private int f10128j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f10129k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f10130l;

        /* renamed from: m, reason: collision with root package name */
        private ImmutableList f10131m;

        /* renamed from: n, reason: collision with root package name */
        private ImmutableList f10132n;

        /* renamed from: o, reason: collision with root package name */
        private int f10133o;

        /* renamed from: p, reason: collision with root package name */
        private ImmutableList f10134p;

        /* renamed from: q, reason: collision with root package name */
        private int f10135q;

        /* renamed from: r, reason: collision with root package name */
        private int f10136r;

        /* renamed from: s, reason: collision with root package name */
        private int f10137s;

        /* renamed from: t, reason: collision with root package name */
        private ImmutableList f10138t;

        /* renamed from: u, reason: collision with root package name */
        private b f10139u;

        /* renamed from: v, reason: collision with root package name */
        private ImmutableList f10140v;

        /* renamed from: w, reason: collision with root package name */
        private int f10141w;

        /* renamed from: x, reason: collision with root package name */
        private boolean f10142x;

        /* renamed from: y, reason: collision with root package name */
        private int f10143y;

        /* renamed from: z, reason: collision with root package name */
        private boolean f10144z;

        public c() {
            this.f10119a = Integer.MAX_VALUE;
            this.f10120b = Integer.MAX_VALUE;
            this.f10121c = Integer.MAX_VALUE;
            this.f10122d = Integer.MAX_VALUE;
            this.f10127i = Integer.MAX_VALUE;
            this.f10128j = Integer.MAX_VALUE;
            this.f10129k = true;
            this.f10130l = true;
            this.f10131m = ImmutableList.of();
            this.f10132n = ImmutableList.of();
            this.f10133o = 0;
            this.f10134p = ImmutableList.of();
            this.f10135q = 0;
            this.f10136r = Integer.MAX_VALUE;
            this.f10137s = Integer.MAX_VALUE;
            this.f10138t = ImmutableList.of();
            this.f10139u = b.f10109d;
            this.f10140v = ImmutableList.of();
            this.f10141w = 0;
            this.f10142x = true;
            this.f10143y = 0;
            this.f10144z = false;
            this.A = false;
            this.B = false;
            this.C = false;
            this.D = new HashMap();
            this.E = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public c(h0 h0Var) {
            H(h0Var);
        }

        private void H(h0 h0Var) {
            this.f10119a = h0Var.f10083a;
            this.f10120b = h0Var.f10084b;
            this.f10121c = h0Var.f10085c;
            this.f10122d = h0Var.f10086d;
            this.f10123e = h0Var.f10087e;
            this.f10124f = h0Var.f10088f;
            this.f10125g = h0Var.f10089g;
            this.f10126h = h0Var.f10090h;
            this.f10127i = h0Var.f10091i;
            this.f10128j = h0Var.f10092j;
            this.f10129k = h0Var.f10093k;
            this.f10130l = h0Var.f10094l;
            this.f10131m = h0Var.f10095m;
            this.f10132n = h0Var.f10096n;
            this.f10133o = h0Var.f10097o;
            this.f10134p = h0Var.f10098p;
            this.f10135q = h0Var.f10099q;
            this.f10136r = h0Var.f10100r;
            this.f10137s = h0Var.f10101s;
            this.f10138t = h0Var.f10102t;
            this.f10139u = h0Var.f10103u;
            this.f10140v = h0Var.f10104v;
            this.f10141w = h0Var.f10105w;
            this.f10142x = h0Var.f10106x;
            this.f10143y = h0Var.f10107y;
            this.f10144z = h0Var.f10108z;
            this.A = h0Var.A;
            this.B = h0Var.B;
            this.C = h0Var.C;
            this.E = new HashSet(h0Var.E);
            this.D = new HashMap(h0Var.D);
        }

        private static ImmutableList I(String[] strArr) {
            ImmutableList.a builder = ImmutableList.builder();
            for (String str : (String[]) androidx.media3.common.util.a.e(strArr)) {
                builder.a(a1.U0((String) androidx.media3.common.util.a.e(str)));
            }
            return builder.e();
        }

        public h0 F() {
            return new h0(this);
        }

        public c G(int i11) {
            Iterator it = this.D.values().iterator();
            while (it.hasNext()) {
                if (((g0) it.next()).a() == i11) {
                    it.remove();
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public c J(h0 h0Var) {
            H(h0Var);
            return this;
        }

        public c K(int i11) {
            this.f10143y = i11;
            return this;
        }

        public c L(g0 g0Var) {
            G(g0Var.a());
            this.D.put(g0Var.f10061a, g0Var);
            return this;
        }

        public c M(String str) {
            return str == null ? N(new String[0]) : N(str);
        }

        public c N(String... strArr) {
            this.f10140v = I(strArr);
            this.f10142x = false;
            return this;
        }

        public c O(int i11) {
            this.f10141w = i11;
            this.f10142x = false;
            return this;
        }

        public c P(int i11, boolean z10) {
            if (z10) {
                this.E.add(Integer.valueOf(i11));
            } else {
                this.E.remove(Integer.valueOf(i11));
            }
            return this;
        }
    }

    static {
        h0 F2 = new c().F();
        F = F2;
        G = F2;
        H = a1.C0(1);
        I = a1.C0(2);
        J = a1.C0(3);
        K = a1.C0(4);
        L = a1.C0(5);
        M = a1.C0(6);
        N = a1.C0(7);
        O = a1.C0(8);
        P = a1.C0(9);
        Q = a1.C0(10);
        R = a1.C0(11);
        S = a1.C0(12);
        T = a1.C0(13);
        U = a1.C0(14);
        V = a1.C0(15);
        W = a1.C0(16);
        X = a1.C0(17);
        Y = a1.C0(18);
        Z = a1.C0(19);
        f10068a0 = a1.C0(20);
        f10069b0 = a1.C0(21);
        f10070c0 = a1.C0(22);
        f10071d0 = a1.C0(23);
        f10072e0 = a1.C0(24);
        f10073f0 = a1.C0(25);
        f10074g0 = a1.C0(26);
        f10075h0 = a1.C0(27);
        f10076i0 = a1.C0(28);
        f10077j0 = a1.C0(29);
        f10078k0 = a1.C0(30);
        f10079l0 = a1.C0(31);
        f10080m0 = a1.C0(32);
        f10081n0 = a1.C0(33);
        f10082o0 = a1.C0(34);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h0(c cVar) {
        this.f10083a = cVar.f10119a;
        this.f10084b = cVar.f10120b;
        this.f10085c = cVar.f10121c;
        this.f10086d = cVar.f10122d;
        this.f10087e = cVar.f10123e;
        this.f10088f = cVar.f10124f;
        this.f10089g = cVar.f10125g;
        this.f10090h = cVar.f10126h;
        this.f10091i = cVar.f10127i;
        this.f10092j = cVar.f10128j;
        this.f10093k = cVar.f10129k;
        this.f10094l = cVar.f10130l;
        this.f10095m = cVar.f10131m;
        this.f10096n = cVar.f10132n;
        this.f10097o = cVar.f10133o;
        this.f10098p = cVar.f10134p;
        this.f10099q = cVar.f10135q;
        this.f10100r = cVar.f10136r;
        this.f10101s = cVar.f10137s;
        this.f10102t = cVar.f10138t;
        this.f10103u = cVar.f10139u;
        this.f10104v = cVar.f10140v;
        this.f10105w = cVar.f10141w;
        this.f10106x = cVar.f10142x;
        this.f10107y = cVar.f10143y;
        this.f10108z = cVar.f10144z;
        this.A = cVar.A;
        this.B = cVar.B;
        this.C = cVar.C;
        this.D = ImmutableMap.copyOf((Map) cVar.D);
        this.E = ImmutableSet.copyOf((Collection) cVar.E);
    }

    public c a() {
        return new c(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.f10083a == h0Var.f10083a && this.f10084b == h0Var.f10084b && this.f10085c == h0Var.f10085c && this.f10086d == h0Var.f10086d && this.f10087e == h0Var.f10087e && this.f10088f == h0Var.f10088f && this.f10089g == h0Var.f10089g && this.f10090h == h0Var.f10090h && this.f10094l == h0Var.f10094l && this.f10091i == h0Var.f10091i && this.f10092j == h0Var.f10092j && this.f10093k == h0Var.f10093k && this.f10095m.equals(h0Var.f10095m) && this.f10096n.equals(h0Var.f10096n) && this.f10097o == h0Var.f10097o && this.f10098p.equals(h0Var.f10098p) && this.f10099q == h0Var.f10099q && this.f10100r == h0Var.f10100r && this.f10101s == h0Var.f10101s && this.f10102t.equals(h0Var.f10102t) && this.f10103u.equals(h0Var.f10103u) && this.f10104v.equals(h0Var.f10104v) && this.f10105w == h0Var.f10105w && this.f10106x == h0Var.f10106x && this.f10107y == h0Var.f10107y && this.f10108z == h0Var.f10108z && this.A == h0Var.A && this.B == h0Var.B && this.C == h0Var.C && this.D.equals(h0Var.D) && this.E.equals(h0Var.E);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.f10083a + 31) * 31) + this.f10084b) * 31) + this.f10085c) * 31) + this.f10086d) * 31) + this.f10087e) * 31) + this.f10088f) * 31) + this.f10089g) * 31) + this.f10090h) * 31) + (this.f10094l ? 1 : 0)) * 31) + this.f10091i) * 31) + this.f10092j) * 31) + (this.f10093k ? 1 : 0)) * 31) + this.f10095m.hashCode()) * 31) + this.f10096n.hashCode()) * 31) + this.f10097o) * 31) + this.f10098p.hashCode()) * 31) + this.f10099q) * 31) + this.f10100r) * 31) + this.f10101s) * 31) + this.f10102t.hashCode()) * 31) + this.f10103u.hashCode()) * 31) + this.f10104v.hashCode()) * 31) + this.f10105w) * 31) + (this.f10106x ? 1 : 0)) * 31) + this.f10107y) * 31) + (this.f10108z ? 1 : 0)) * 31) + (this.A ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0)) * 31) + this.D.hashCode()) * 31) + this.E.hashCode();
    }
}
