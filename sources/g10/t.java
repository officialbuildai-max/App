package g10;

/* loaded from: classes7.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    y[] f63293a;

    /* renamed from: b, reason: collision with root package name */
    l[] f63294b;

    /* renamed from: c, reason: collision with root package name */
    k f63295c;

    /* renamed from: d, reason: collision with root package name */
    byte[] f63296d;

    /* renamed from: e, reason: collision with root package name */
    int[] f63297e;

    /* renamed from: f, reason: collision with root package name */
    int f63298f;

    /* renamed from: g, reason: collision with root package name */
    int f63299g;

    /* renamed from: h, reason: collision with root package name */
    boolean f63300h;

    /* renamed from: i, reason: collision with root package name */
    boolean f63301i;

    /* renamed from: j, reason: collision with root package name */
    boolean f63302j;

    public t() {
        this.f63295c = new k();
        this.f63296d = new byte[16];
        this.f63297e = new int[16];
        h(0);
        d();
    }

    public t(int i11) {
        this.f63295c = new k();
        this.f63296d = new byte[16];
        this.f63297e = new int[16];
        h(i11);
        d();
    }

    public void a() {
        y yVar;
        if (this.f63300h) {
            return;
        }
        if (this.f63298f == 2) {
            if (this.f63293a[this.f63297e[0]].b().equals("GB18030")) {
                yVar = this.f63293a[this.f63297e[1]];
            } else if (this.f63293a[this.f63297e[1]].b().equals("GB18030")) {
                yVar = this.f63293a[this.f63297e[0]];
            }
            c(yVar.b());
            this.f63300h = true;
        }
        if (this.f63301i) {
            f(null, 0, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0016, code lost:
    
        if (r4 > 1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002c, code lost:
    
        r2 = 0;
        r3 = 0;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0031, code lost:
    
        if (r2 < r8.f63298f) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r8.f63293a[r8.f63297e[r2]].d() != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
    
        if (r8.f63293a[r8.f63297e[r2]].d() != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
    
        r3 = r3 + 1;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0033, code lost:
    
        if (1 != r3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0047, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0035, code lost:
    
        r9 = r8.f63293a[r8.f63297e[r4]];
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0018, code lost:
    
        if (1 != r4) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x001a, code lost:
    
        c(r8.f63293a[r8.f63297e[0]].b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0029, code lost:
    
        r8.f63300h = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x002b, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(byte[] r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L2:
            if (r1 < r10) goto Le
            boolean r0 = r8.f63301i
            if (r0 == 0) goto Lb
            r8.e(r9, r10)
        Lb:
            boolean r9 = r8.f63300h
            return r9
        Le:
            r2 = r9[r1]
            r3 = r0
        L11:
            int r4 = r8.f63298f
            r5 = 1
            if (r3 < r4) goto L6c
            if (r4 > r5) goto L2c
            if (r5 != r4) goto L29
            g10.y[] r9 = r8.f63293a
            int[] r10 = r8.f63297e
            r10 = r10[r0]
            r9 = r9[r10]
            java.lang.String r9 = r9.b()
            r8.c(r9)
        L29:
            r8.f63300h = r5
            return r5
        L2c:
            r2 = r0
            r3 = r2
            r4 = r3
        L2f:
            int r6 = r8.f63298f
            if (r2 < r6) goto L4a
            if (r5 != r3) goto L47
            g10.y[] r9 = r8.f63293a
            int[] r10 = r8.f63297e
            r10 = r10[r4]
            r9 = r9[r10]
        L3d:
            java.lang.String r9 = r9.b()
            r8.c(r9)
            r8.f63300h = r5
            return r5
        L47:
            int r1 = r1 + 1
            goto L2
        L4a:
            g10.y[] r6 = r8.f63293a
            int[] r7 = r8.f63297e
            r7 = r7[r2]
            r6 = r6[r7]
            boolean r6 = r6.d()
            if (r6 != 0) goto L69
            g10.y[] r6 = r8.f63293a
            int[] r7 = r8.f63297e
            r7 = r7[r2]
            r6 = r6[r7]
            boolean r6 = r6.d()
            if (r6 != 0) goto L69
            int r3 = r3 + 1
            r4 = r2
        L69:
            int r2 = r2 + 1
            goto L2f
        L6c:
            g10.y[] r4 = r8.f63293a
            int[] r6 = r8.f63297e
            r6 = r6[r3]
            r4 = r4[r6]
            byte[] r6 = r8.f63296d
            r6 = r6[r3]
            byte r4 = g10.y.c(r4, r2, r6)
            r6 = 2
            if (r4 != r6) goto L88
            g10.y[] r9 = r8.f63293a
            int[] r10 = r8.f63297e
            r10 = r10[r3]
            r9 = r9[r10]
            goto L3d
        L88:
            if (r4 != r5) goto L9f
            int r4 = r8.f63298f
            int r4 = r4 - r5
            r8.f63298f = r4
            if (r3 >= r4) goto L11
            int[] r5 = r8.f63297e
            r6 = r5[r4]
            r5[r3] = r6
            byte[] r5 = r8.f63296d
            r4 = r5[r4]
            r5[r3] = r4
            goto L11
        L9f:
            byte[] r5 = r8.f63296d
            int r6 = r3 + 1
            r5[r3] = r4
            r3 = r6
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: g10.t.b(byte[], int):boolean");
    }

    public abstract void c(String str);

    public void d() {
        this.f63301i = this.f63302j;
        this.f63300h = false;
        this.f63298f = this.f63299g;
        for (int i11 = 0; i11 < this.f63298f; i11++) {
            this.f63296d[i11] = 0;
            this.f63297e[i11] = i11;
        }
        this.f63295c.f();
    }

    public void e(byte[] bArr, int i11) {
        f(bArr, i11, false);
    }

    public void f(byte[] bArr, int i11, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < this.f63298f; i14++) {
            l[] lVarArr = this.f63294b;
            int i15 = this.f63297e[i14];
            if (lVarArr[i15] != null) {
                i12++;
            }
            if (!this.f63293a[i15].d() && !this.f63293a[this.f63297e[i14]].b().equals("GB18030")) {
                i13++;
            }
        }
        boolean z11 = i12 > 1;
        this.f63301i = z11;
        if (z11) {
            this.f63301i = this.f63295c.g(bArr, i11);
            if (((z10 && this.f63295c.e()) || this.f63295c.b()) && i12 == i13) {
                this.f63295c.a();
                int i16 = -1;
                float f11 = 0.0f;
                int i17 = 0;
                for (int i18 = 0; i18 < this.f63298f; i18++) {
                    l[] lVarArr2 = this.f63294b;
                    int i19 = this.f63297e[i18];
                    if (lVarArr2[i19] != null && !this.f63293a[i19].b().equals("Big5")) {
                        float c11 = this.f63295c.c(this.f63294b[this.f63297e[i18]].a(), this.f63294b[this.f63297e[i18]].b(), this.f63294b[this.f63297e[i18]].c(), this.f63294b[this.f63297e[i18]].d());
                        int i20 = i17 + 1;
                        if (i17 == 0 || f11 > c11) {
                            i16 = i18;
                            f11 = c11;
                        }
                        i17 = i20;
                    }
                }
                if (i16 >= 0) {
                    c(this.f63293a[this.f63297e[i16]].b());
                    this.f63300h = true;
                }
            }
        }
    }

    public String[] g() {
        int i11 = this.f63298f;
        if (i11 <= 0) {
            return new String[]{"nomatch"};
        }
        String[] strArr = new String[i11];
        for (int i12 = 0; i12 < this.f63298f; i12++) {
            strArr[i12] = this.f63293a[this.f63297e[i12]].b();
        }
        return strArr;
    }

    protected void h(int i11) {
        int i12 = i11;
        if (i12 < 0 || i12 >= 6) {
            i12 = 0;
        }
        this.f63293a = null;
        this.f63294b = null;
        if (i12 == 4) {
            this.f63293a = new y[]{new x(), new f(), new q(), new m(), new g(), new v(), new w()};
            this.f63294b = new l[]{null, new a(), null, new d(), null, null, null};
        } else if (i12 == 5) {
            this.f63293a = new y[]{new x(), new j(), new s(), new g(), new v(), new w()};
        } else if (i12 == 3) {
            this.f63293a = new y[]{new x(), new o(), new n(), new q(), new p(), new g(), new v(), new w()};
        } else if (i12 == 1) {
            this.f63293a = new y[]{new x(), new u(), new i(), new r(), new g(), new v(), new w()};
        } else if (i12 == 2) {
            this.f63293a = new y[]{new x(), new o(), new n(), new f(), new q(), new p(), new m(), new g(), new v(), new w()};
            this.f63294b = new l[]{null, new e(), null, new a(), null, null, new d(), null, null, null};
        } else if (i12 == 0) {
            this.f63293a = new y[]{new x(), new u(), new i(), new r(), new j(), new s(), new f(), new m(), new o(), new n(), new q(), new p(), new g(), new v(), new w()};
            this.f63294b = new l[]{null, null, new b(), null, new c(), null, new a(), new d(), new e(), null, null, null, null, null, null};
        }
        this.f63302j = this.f63294b != null;
        this.f63299g = this.f63293a.length;
    }
}
