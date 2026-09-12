package o3;

import android.text.Layout;

/* loaded from: classes2.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private String f70824a;

    /* renamed from: b, reason: collision with root package name */
    private int f70825b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f70826c;

    /* renamed from: d, reason: collision with root package name */
    private int f70827d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f70828e;

    /* renamed from: k, reason: collision with root package name */
    private float f70834k;

    /* renamed from: l, reason: collision with root package name */
    private String f70835l;

    /* renamed from: o, reason: collision with root package name */
    private Layout.Alignment f70838o;

    /* renamed from: p, reason: collision with root package name */
    private Layout.Alignment f70839p;

    /* renamed from: r, reason: collision with root package name */
    private b f70841r;

    /* renamed from: t, reason: collision with root package name */
    private String f70843t;

    /* renamed from: u, reason: collision with root package name */
    private String f70844u;

    /* renamed from: f, reason: collision with root package name */
    private int f70829f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f70830g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f70831h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f70832i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f70833j = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f70836m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f70837n = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f70840q = -1;

    /* renamed from: s, reason: collision with root package name */
    private float f70842s = Float.MAX_VALUE;

    private g t(g gVar, boolean z10) {
        int i11;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f70826c && gVar.f70826c) {
                z(gVar.f70825b);
            }
            if (this.f70831h == -1) {
                this.f70831h = gVar.f70831h;
            }
            if (this.f70832i == -1) {
                this.f70832i = gVar.f70832i;
            }
            if (this.f70824a == null && (str = gVar.f70824a) != null) {
                this.f70824a = str;
            }
            if (this.f70829f == -1) {
                this.f70829f = gVar.f70829f;
            }
            if (this.f70830g == -1) {
                this.f70830g = gVar.f70830g;
            }
            if (this.f70837n == -1) {
                this.f70837n = gVar.f70837n;
            }
            if (this.f70838o == null && (alignment2 = gVar.f70838o) != null) {
                this.f70838o = alignment2;
            }
            if (this.f70839p == null && (alignment = gVar.f70839p) != null) {
                this.f70839p = alignment;
            }
            if (this.f70840q == -1) {
                this.f70840q = gVar.f70840q;
            }
            if (this.f70833j == -1) {
                this.f70833j = gVar.f70833j;
                this.f70834k = gVar.f70834k;
            }
            if (this.f70841r == null) {
                this.f70841r = gVar.f70841r;
            }
            if (this.f70842s == Float.MAX_VALUE) {
                this.f70842s = gVar.f70842s;
            }
            if (this.f70843t == null) {
                this.f70843t = gVar.f70843t;
            }
            if (this.f70844u == null) {
                this.f70844u = gVar.f70844u;
            }
            if (z10 && !this.f70828e && gVar.f70828e) {
                w(gVar.f70827d);
            }
            if (z10 && this.f70836m == -1 && (i11 = gVar.f70836m) != -1) {
                this.f70836m = i11;
            }
        }
        return this;
    }

    public g A(String str) {
        this.f70824a = str;
        return this;
    }

    public g B(float f11) {
        this.f70834k = f11;
        return this;
    }

    public g C(int i11) {
        this.f70833j = i11;
        return this;
    }

    public g D(String str) {
        this.f70835l = str;
        return this;
    }

    public g E(boolean z10) {
        this.f70832i = z10 ? 1 : 0;
        return this;
    }

    public g F(boolean z10) {
        this.f70829f = z10 ? 1 : 0;
        return this;
    }

    public g G(Layout.Alignment alignment) {
        this.f70839p = alignment;
        return this;
    }

    public g H(String str) {
        this.f70843t = str;
        return this;
    }

    public g I(int i11) {
        this.f70837n = i11;
        return this;
    }

    public g J(int i11) {
        this.f70836m = i11;
        return this;
    }

    public g K(float f11) {
        this.f70842s = f11;
        return this;
    }

    public g L(Layout.Alignment alignment) {
        this.f70838o = alignment;
        return this;
    }

    public g M(boolean z10) {
        this.f70840q = z10 ? 1 : 0;
        return this;
    }

    public g N(b bVar) {
        this.f70841r = bVar;
        return this;
    }

    public g O(boolean z10) {
        this.f70830g = z10 ? 1 : 0;
        return this;
    }

    public g a(g gVar) {
        return t(gVar, true);
    }

    public int b() {
        if (this.f70828e) {
            return this.f70827d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public String c() {
        return this.f70844u;
    }

    public int d() {
        if (this.f70826c) {
            return this.f70825b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String e() {
        return this.f70824a;
    }

    public float f() {
        return this.f70834k;
    }

    public int g() {
        return this.f70833j;
    }

    public String h() {
        return this.f70835l;
    }

    public Layout.Alignment i() {
        return this.f70839p;
    }

    public String j() {
        return this.f70843t;
    }

    public int k() {
        return this.f70837n;
    }

    public int l() {
        return this.f70836m;
    }

    public float m() {
        return this.f70842s;
    }

    public int n() {
        int i11 = this.f70831h;
        if (i11 == -1 && this.f70832i == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f70832i == 1 ? 2 : 0);
    }

    public Layout.Alignment o() {
        return this.f70838o;
    }

    public boolean p() {
        return this.f70840q == 1;
    }

    public b q() {
        return this.f70841r;
    }

    public boolean r() {
        return this.f70828e;
    }

    public boolean s() {
        return this.f70826c;
    }

    public boolean u() {
        return this.f70829f == 1;
    }

    public boolean v() {
        return this.f70830g == 1;
    }

    public g w(int i11) {
        this.f70827d = i11;
        this.f70828e = true;
        return this;
    }

    public g x(boolean z10) {
        this.f70831h = z10 ? 1 : 0;
        return this;
    }

    public g y(String str) {
        this.f70844u = str;
        return this;
    }

    public g z(int i11) {
        this.f70825b = i11;
        this.f70826c = true;
        return this;
    }
}
