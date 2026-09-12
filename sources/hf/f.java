package hf;

import com.tencent.tinker.android.dex.DexException;

/* loaded from: classes5.dex */
public final class f extends e {

    /* renamed from: b, reason: collision with root package name */
    private final i f64557b;

    /* renamed from: c, reason: collision with root package name */
    private final c f64558c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f64559d;

    /* renamed from: e, reason: collision with root package name */
    int f64560e;

    /* renamed from: f, reason: collision with root package name */
    int f64561f;

    /* renamed from: g, reason: collision with root package name */
    int f64562g;

    /* renamed from: h, reason: collision with root package name */
    long f64563h;

    /* renamed from: i, reason: collision with root package name */
    int f64564i;

    /* renamed from: j, reason: collision with root package name */
    int f64565j;

    /* renamed from: k, reason: collision with root package name */
    int f64566k;

    /* renamed from: l, reason: collision with root package name */
    int f64567l;

    /* renamed from: m, reason: collision with root package name */
    int f64568m;

    /* renamed from: n, reason: collision with root package name */
    int f64569n;

    /* renamed from: o, reason: collision with root package name */
    int f64570o;

    /* renamed from: p, reason: collision with root package name */
    int f64571p;

    /* renamed from: q, reason: collision with root package name */
    int f64572q;

    /* renamed from: r, reason: collision with root package name */
    int[] f64573r;

    /* renamed from: s, reason: collision with root package name */
    int[] f64574s;

    /* renamed from: t, reason: collision with root package name */
    int f64575t;

    /* renamed from: u, reason: collision with root package name */
    int f64576u;

    /* renamed from: v, reason: collision with root package name */
    Object f64577v;

    /* renamed from: w, reason: collision with root package name */
    int f64578w;

    public f(i iVar, c cVar) {
        super(null);
        this.f64560e = 0;
        this.f64561f = 0;
        this.f64562g = 0;
        this.f64563h = 0L;
        this.f64564i = 0;
        this.f64565j = 0;
        this.f64566k = 0;
        this.f64567l = 0;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        this.f64572q = 0;
        this.f64573r = null;
        this.f64574s = null;
        this.f64575t = 0;
        this.f64576u = 0;
        this.f64577v = null;
        this.f64578w = 0;
        this.f64557b = iVar;
        this.f64558c = cVar;
        this.f64559d = cVar != null;
    }

    @Override // hf.e
    public void a(int i11, int i12, Object obj, int i13, int i14) {
        this.f64560e = i12;
        this.f64577v = obj;
        this.f64578w = i13;
        this.f64576u = i14;
        this.f64564i = 0;
        this.f64565j = 0;
        this.f64566k = 0;
        this.f64567l = 0;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void b(int i11, int i12, int i13, int i14, int i15, long j11, int i16, int i17, int i18, int i19, int i20) {
        this.f64560e = i12;
        this.f64561f = i13;
        this.f64562g = i15;
        this.f64563h = j11;
        this.f64564i = 5;
        this.f64565j = i16;
        this.f64566k = i17;
        this.f64567l = i18;
        this.f64568m = i19;
        this.f64569n = i20;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void c(int i11, int i12, int i13, int i14, int i15, long j11, int i16, int i17, int i18, int i19) {
        this.f64560e = i12;
        this.f64561f = i13;
        this.f64562g = i15;
        this.f64563h = j11;
        this.f64564i = 4;
        this.f64565j = i16;
        this.f64566k = i17;
        this.f64567l = i18;
        this.f64568m = i19;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void d(int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        this.f64560e = i12;
        this.f64561f = i13;
        this.f64572q = i15;
        this.f64564i = iArr.length;
        this.f64565j = 0;
        this.f64566k = 0;
        this.f64567l = iArr.length > 0 ? iArr[0] : 0;
        this.f64568m = iArr.length > 1 ? iArr[1] : 0;
        this.f64569n = iArr.length > 2 ? iArr[2] : 0;
        this.f64570o = iArr.length > 3 ? iArr[3] : 0;
        this.f64571p = iArr.length > 4 ? iArr[4] : 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void e(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f64560e = i12;
        this.f64561f = i13;
        this.f64564i = i16;
        this.f64565j = 0;
        this.f64566k = 0;
        this.f64567l = i15;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        this.f64572q = i17;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void f(int i11, int i12, int i13, int i14, int i15, long j11, int i16) {
        if (this.f64559d) {
            i15 = this.f64558c.m(i15);
        }
        if (i12 == 26) {
            if (this.f64559d) {
                if (i13 > 65535) {
                    i12 = 27;
                }
            } else if (i13 > 65535) {
                throw new DexException("string index out of bound: " + p008if.a.d(i13) + ", perhaps you need to enable force jumbo mode.");
            }
        }
        this.f64560e = i12;
        this.f64561f = i13;
        this.f64562g = i15;
        this.f64563h = j11;
        this.f64564i = 1;
        this.f64565j = i16;
        this.f64566k = 0;
        this.f64567l = 0;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void g(int i11, int i12, int i13, int[] iArr) {
        this.f64560e = i12;
        this.f64575t = i13;
        if (this.f64559d) {
            this.f64574s = new int[iArr.length];
            for (int i14 = 0; i14 < iArr.length; i14++) {
                this.f64574s[i14] = this.f64558c.m(iArr[i14]);
            }
        } else {
            this.f64574s = iArr;
        }
        this.f64564i = 0;
        this.f64565j = 0;
        this.f64566k = 0;
        this.f64567l = 0;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void h(int i11, int i12, int i13, int i14, int i15, long j11, int i16, int i17) {
        this.f64560e = i12;
        this.f64561f = i13;
        this.f64562g = i15;
        this.f64563h = j11;
        this.f64564i = i17;
        this.f64565j = i16;
        this.f64566k = 0;
        this.f64567l = 0;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void i(int i11, int i12, int[] iArr, int[] iArr2) {
        this.f64560e = i12;
        this.f64573r = iArr;
        if (this.f64559d) {
            this.f64574s = new int[iArr2.length];
            for (int i13 = 0; i13 < iArr2.length; i13++) {
                this.f64574s[i13] = this.f64558c.m(iArr2[i13]);
            }
        } else {
            this.f64574s = iArr2;
        }
        this.f64564i = 0;
        this.f64565j = 0;
        this.f64566k = 0;
        this.f64567l = 0;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void j(int i11, int i12, int i13, int i14, int i15, long j11, int i16, int i17, int i18) {
        this.f64560e = i12;
        this.f64561f = i13;
        this.f64562g = i15;
        this.f64563h = j11;
        this.f64564i = 3;
        this.f64565j = i16;
        this.f64566k = i17;
        this.f64567l = i18;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    @Override // hf.e
    public void k(int i11, int i12, int i13, int i14, int i15, long j11, int i16, int i17) {
        if (this.f64559d) {
            i15 = this.f64558c.m(i15);
        }
        this.f64560e = i12;
        this.f64561f = i13;
        this.f64562g = i15;
        this.f64563h = j11;
        this.f64564i = 2;
        this.f64565j = i16;
        this.f64566k = i17;
        this.f64567l = 0;
        this.f64568m = 0;
        this.f64569n = 0;
        this.f64570o = 0;
        this.f64571p = 0;
        b.g(this.f64557b, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        if (r3 != ((short) r3)) goto L10;
     */
    @Override // hf.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(int r3, int r4, int r5, int r6, int r7, long r8) {
        /*
            r2 = this;
            boolean r3 = r2.f64559d
            if (r3 == 0) goto L35
            hf.c r3 = r2.f64558c
            int r7 = r3.m(r7)
            r3 = 40
            r6 = 42
            r0 = 41
            if (r4 == r3) goto L24
            if (r4 == r0) goto L15
            goto L35
        L15:
            hf.i r3 = r2.f64557b
            int r3 = r3.c()
            int r3 = hf.b.q(r7, r3)
            short r0 = (short) r3
            if (r3 == r0) goto L35
        L22:
            r4 = r6
            goto L35
        L24:
            hf.i r3 = r2.f64557b
            int r3 = r3.c()
            int r3 = hf.b.q(r7, r3)
            byte r1 = (byte) r3
            if (r3 == r1) goto L35
            short r4 = (short) r3
            if (r3 != r4) goto L22
            r4 = r0
        L35:
            r2.f64560e = r4
            r2.f64561f = r5
            r2.f64562g = r7
            r2.f64563h = r8
            r3 = 0
            r2.f64564i = r3
            r2.f64565j = r3
            r2.f64566k = r3
            r2.f64567l = r3
            r2.f64568m = r3
            r2.f64569n = r3
            r2.f64570o = r3
            r2.f64571p = r3
            hf.i r3 = r2.f64557b
            hf.b.g(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hf.f.l(int, int, int, int, int, long):void");
    }
}
