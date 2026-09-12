package ia;

import android.text.Layout;

/* loaded from: classes4.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private String f65250a;

    /* renamed from: b, reason: collision with root package name */
    private int f65251b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f65252c;

    /* renamed from: d, reason: collision with root package name */
    private int f65253d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f65254e;

    /* renamed from: k, reason: collision with root package name */
    private float f65260k;

    /* renamed from: l, reason: collision with root package name */
    private String f65261l;

    /* renamed from: o, reason: collision with root package name */
    private Layout.Alignment f65264o;

    /* renamed from: p, reason: collision with root package name */
    private Layout.Alignment f65265p;

    /* renamed from: r, reason: collision with root package name */
    private b f65267r;

    /* renamed from: f, reason: collision with root package name */
    private int f65255f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f65256g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f65257h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f65258i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f65259j = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f65262m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f65263n = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f65266q = -1;

    /* renamed from: s, reason: collision with root package name */
    private float f65268s = Float.MAX_VALUE;

    private g r(g gVar, boolean z10) {
        int i11;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f65252c && gVar.f65252c) {
                w(gVar.f65251b);
            }
            if (this.f65257h == -1) {
                this.f65257h = gVar.f65257h;
            }
            if (this.f65258i == -1) {
                this.f65258i = gVar.f65258i;
            }
            if (this.f65250a == null && (str = gVar.f65250a) != null) {
                this.f65250a = str;
            }
            if (this.f65255f == -1) {
                this.f65255f = gVar.f65255f;
            }
            if (this.f65256g == -1) {
                this.f65256g = gVar.f65256g;
            }
            if (this.f65263n == -1) {
                this.f65263n = gVar.f65263n;
            }
            if (this.f65264o == null && (alignment2 = gVar.f65264o) != null) {
                this.f65264o = alignment2;
            }
            if (this.f65265p == null && (alignment = gVar.f65265p) != null) {
                this.f65265p = alignment;
            }
            if (this.f65266q == -1) {
                this.f65266q = gVar.f65266q;
            }
            if (this.f65259j == -1) {
                this.f65259j = gVar.f65259j;
                this.f65260k = gVar.f65260k;
            }
            if (this.f65267r == null) {
                this.f65267r = gVar.f65267r;
            }
            if (this.f65268s == Float.MAX_VALUE) {
                this.f65268s = gVar.f65268s;
            }
            if (z10 && !this.f65254e && gVar.f65254e) {
                u(gVar.f65253d);
            }
            if (z10 && this.f65262m == -1 && (i11 = gVar.f65262m) != -1) {
                this.f65262m = i11;
            }
        }
        return this;
    }

    public g A(String str) {
        this.f65261l = str;
        return this;
    }

    public g B(boolean z10) {
        this.f65258i = z10 ? 1 : 0;
        return this;
    }

    public g C(boolean z10) {
        this.f65255f = z10 ? 1 : 0;
        return this;
    }

    public g D(Layout.Alignment alignment) {
        this.f65265p = alignment;
        return this;
    }

    public g E(int i11) {
        this.f65263n = i11;
        return this;
    }

    public g F(int i11) {
        this.f65262m = i11;
        return this;
    }

    public g G(float f11) {
        this.f65268s = f11;
        return this;
    }

    public g H(Layout.Alignment alignment) {
        this.f65264o = alignment;
        return this;
    }

    public g I(boolean z10) {
        this.f65266q = z10 ? 1 : 0;
        return this;
    }

    public g J(b bVar) {
        this.f65267r = bVar;
        return this;
    }

    public g K(boolean z10) {
        this.f65256g = z10 ? 1 : 0;
        return this;
    }

    public g a(g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.f65254e) {
            return this.f65253d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f65252c) {
            return this.f65251b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String d() {
        return this.f65250a;
    }

    public float e() {
        return this.f65260k;
    }

    public int f() {
        return this.f65259j;
    }

    public String g() {
        return this.f65261l;
    }

    public Layout.Alignment h() {
        return this.f65265p;
    }

    public int i() {
        return this.f65263n;
    }

    public int j() {
        return this.f65262m;
    }

    public float k() {
        return this.f65268s;
    }

    public int l() {
        int i11 = this.f65257h;
        if (i11 == -1 && this.f65258i == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f65258i == 1 ? 2 : 0);
    }

    public Layout.Alignment m() {
        return this.f65264o;
    }

    public boolean n() {
        return this.f65266q == 1;
    }

    public b o() {
        return this.f65267r;
    }

    public boolean p() {
        return this.f65254e;
    }

    public boolean q() {
        return this.f65252c;
    }

    public boolean s() {
        return this.f65255f == 1;
    }

    public boolean t() {
        return this.f65256g == 1;
    }

    public g u(int i11) {
        this.f65253d = i11;
        this.f65254e = true;
        return this;
    }

    public g v(boolean z10) {
        this.f65257h = z10 ? 1 : 0;
        return this;
    }

    public g w(int i11) {
        this.f65251b = i11;
        this.f65252c = true;
        return this;
    }

    public g x(String str) {
        this.f65250a = str;
        return this;
    }

    public g y(float f11) {
        this.f65260k = f11;
        return this;
    }

    public g z(int i11) {
        this.f65259j = i11;
        return this;
    }
}
