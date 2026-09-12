package androidx.appcompat.widget;

/* loaded from: classes.dex */
class d0 {

    /* renamed from: a, reason: collision with root package name */
    private int f2049a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f2050b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f2051c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f2052d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f2053e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f2054f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2055g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2056h = false;

    public int a() {
        return this.f2055g ? this.f2049a : this.f2050b;
    }

    public int b() {
        return this.f2049a;
    }

    public int c() {
        return this.f2050b;
    }

    public int d() {
        return this.f2055g ? this.f2050b : this.f2049a;
    }

    public void e(int i11, int i12) {
        this.f2056h = false;
        if (i11 != Integer.MIN_VALUE) {
            this.f2053e = i11;
            this.f2049a = i11;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.f2054f = i12;
            this.f2050b = i12;
        }
    }

    public void f(boolean z10) {
        if (z10 == this.f2055g) {
            return;
        }
        this.f2055g = z10;
        if (!this.f2056h) {
            this.f2049a = this.f2053e;
            this.f2050b = this.f2054f;
            return;
        }
        if (z10) {
            int i11 = this.f2052d;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f2053e;
            }
            this.f2049a = i11;
            int i12 = this.f2051c;
            if (i12 == Integer.MIN_VALUE) {
                i12 = this.f2054f;
            }
            this.f2050b = i12;
            return;
        }
        int i13 = this.f2051c;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f2053e;
        }
        this.f2049a = i13;
        int i14 = this.f2052d;
        if (i14 == Integer.MIN_VALUE) {
            i14 = this.f2054f;
        }
        this.f2050b = i14;
    }

    public void g(int i11, int i12) {
        this.f2051c = i11;
        this.f2052d = i12;
        this.f2056h = true;
        if (this.f2055g) {
            if (i12 != Integer.MIN_VALUE) {
                this.f2049a = i12;
            }
            if (i11 != Integer.MIN_VALUE) {
                this.f2050b = i11;
                return;
            }
            return;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f2049a = i11;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.f2050b = i12;
        }
    }
}
