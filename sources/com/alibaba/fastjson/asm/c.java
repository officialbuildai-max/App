package com.alibaba.fastjson.asm;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    int f18161a;

    /* renamed from: b, reason: collision with root package name */
    int f18162b;

    /* renamed from: c, reason: collision with root package name */
    final a f18163c;

    /* renamed from: d, reason: collision with root package name */
    e[] f18164d;

    /* renamed from: e, reason: collision with root package name */
    int f18165e;

    /* renamed from: f, reason: collision with root package name */
    final e f18166f;

    /* renamed from: g, reason: collision with root package name */
    final e f18167g;

    /* renamed from: h, reason: collision with root package name */
    final e f18168h;

    /* renamed from: i, reason: collision with root package name */
    private int f18169i;

    /* renamed from: j, reason: collision with root package name */
    private int f18170j;

    /* renamed from: k, reason: collision with root package name */
    String f18171k;

    /* renamed from: l, reason: collision with root package name */
    private int f18172l;

    /* renamed from: m, reason: collision with root package name */
    private int f18173m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f18174n;

    /* renamed from: o, reason: collision with root package name */
    d f18175o;

    /* renamed from: p, reason: collision with root package name */
    d f18176p;

    /* renamed from: q, reason: collision with root package name */
    i f18177q;

    /* renamed from: r, reason: collision with root package name */
    i f18178r;

    public c() {
        this(0);
    }

    private c(int i11) {
        this.f18162b = 1;
        this.f18163c = new a();
        this.f18164d = new e[256];
        this.f18165e = (int) (r5.length * 0.75d);
        this.f18166f = new e();
        this.f18167g = new e();
        this.f18168h = new e();
    }

    private e a(e eVar) {
        e[] eVarArr = this.f18164d;
        e eVar2 = eVarArr[eVar.f18190h % eVarArr.length];
        while (eVar2 != null && (eVar2.f18184b != eVar.f18184b || !eVar.a(eVar2))) {
            eVar2 = eVar2.f18191i;
        }
        return eVar2;
    }

    private e g(String str) {
        this.f18167g.c(8, str, null, null);
        e a11 = a(this.f18167g);
        if (a11 != null) {
            return a11;
        }
        this.f18163c.c(8, h(str));
        int i11 = this.f18162b;
        this.f18162b = i11 + 1;
        e eVar = new e(i11, this.f18167g);
        i(eVar);
        return eVar;
    }

    private void i(e eVar) {
        if (this.f18162b > this.f18165e) {
            int length = this.f18164d.length;
            int i11 = (length * 2) + 1;
            e[] eVarArr = new e[i11];
            for (int i12 = length - 1; i12 >= 0; i12--) {
                e eVar2 = this.f18164d[i12];
                while (eVar2 != null) {
                    int i13 = eVar2.f18190h % i11;
                    e eVar3 = eVar2.f18191i;
                    eVar2.f18191i = eVarArr[i13];
                    eVarArr[i13] = eVar2;
                    eVar2 = eVar3;
                }
            }
            this.f18164d = eVarArr;
            this.f18165e = (int) (i11 * 0.75d);
        }
        int i14 = eVar.f18190h;
        e[] eVarArr2 = this.f18164d;
        int length2 = i14 % eVarArr2.length;
        eVar.f18191i = eVarArr2[length2];
        eVarArr2[length2] = eVar;
    }

    public e b(String str) {
        this.f18167g.c(7, str, null, null);
        e a11 = a(this.f18167g);
        if (a11 != null) {
            return a11;
        }
        this.f18163c.c(7, h(str));
        int i11 = this.f18162b;
        this.f18162b = i11 + 1;
        e eVar = new e(i11, this.f18167g);
        i(eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e c(Object obj) {
        if (!(obj instanceof Integer)) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                return b(jVar.f18220a == 10 ? jVar.f() : jVar.d());
            }
            throw new IllegalArgumentException("value " + obj);
        }
        int intValue = ((Integer) obj).intValue();
        this.f18166f.b(intValue);
        e a11 = a(this.f18166f);
        if (a11 != null) {
            return a11;
        }
        this.f18163c.d(3).f(intValue);
        int i11 = this.f18162b;
        this.f18162b = i11 + 1;
        e eVar = new e(i11, this.f18166f);
        i(eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e d(String str, String str2, String str3) {
        this.f18168h.c(9, str, str2, str3);
        e a11 = a(this.f18168h);
        if (a11 != null) {
            return a11;
        }
        int i11 = b(str).f18183a;
        this.f18163c.c(9, i11).g(f(str2, str3).f18183a);
        int i12 = this.f18162b;
        this.f18162b = i12 + 1;
        e eVar = new e(i12, this.f18168h);
        i(eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e e(String str, String str2, String str3, boolean z10) {
        int i11 = z10 ? 11 : 10;
        this.f18168h.c(i11, str, str2, str3);
        e a11 = a(this.f18168h);
        if (a11 != null) {
            return a11;
        }
        this.f18163c.c(i11, b(str).f18183a).g(f(str2, str3).f18183a);
        int i12 = this.f18162b;
        this.f18162b = i12 + 1;
        e eVar = new e(i12, this.f18168h);
        i(eVar);
        return eVar;
    }

    public e f(String str, String str2) {
        this.f18167g.c(12, str, str2, null);
        e a11 = a(this.f18167g);
        if (a11 != null) {
            return a11;
        }
        int h11 = h(str);
        this.f18163c.c(12, h11).g(h(str2));
        int i11 = this.f18162b;
        this.f18162b = i11 + 1;
        e eVar = new e(i11, this.f18167g);
        i(eVar);
        return eVar;
    }

    public int h(String str) {
        this.f18166f.c(1, str, null, null);
        e a11 = a(this.f18166f);
        if (a11 == null) {
            this.f18163c.d(1).h(str);
            int i11 = this.f18162b;
            this.f18162b = i11 + 1;
            a11 = new e(i11, this.f18166f);
            i(a11);
        }
        return a11.f18183a;
    }

    public byte[] j() {
        int i11 = (this.f18173m * 2) + 24;
        int i12 = 0;
        for (d dVar = this.f18175o; dVar != null; dVar = dVar.f18179a) {
            i12++;
            i11 += dVar.a();
        }
        int i13 = 0;
        for (i iVar = this.f18177q; iVar != null; iVar = iVar.f18201a) {
            i13++;
            i11 += iVar.m();
        }
        a aVar = new a(i11 + this.f18163c.f18154b);
        aVar.f(-889275714).f(this.f18161a);
        a g11 = aVar.g(this.f18162b);
        a aVar2 = this.f18163c;
        g11.e(aVar2.f18153a, 0, aVar2.f18154b);
        aVar.g(this.f18169i & (-393217)).g(this.f18170j).g(this.f18172l);
        aVar.g(this.f18173m);
        for (int i14 = 0; i14 < this.f18173m; i14++) {
            aVar.g(this.f18174n[i14]);
        }
        aVar.g(i12);
        for (d dVar2 = this.f18175o; dVar2 != null; dVar2 = dVar2.f18179a) {
            dVar2.b(aVar);
        }
        aVar.g(i13);
        for (i iVar2 = this.f18177q; iVar2 != null; iVar2 = iVar2.f18201a) {
            iVar2.n(aVar);
        }
        aVar.g(0);
        return aVar.f18153a;
    }

    public void k(int i11, int i12, String str, String str2, String[] strArr) {
        this.f18161a = i11;
        this.f18169i = i12;
        this.f18170j = b(str).f18183a;
        this.f18171k = str;
        this.f18172l = str2 == null ? 0 : b(str2).f18183a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f18173m = length;
        this.f18174n = new int[length];
        for (int i13 = 0; i13 < this.f18173m; i13++) {
            this.f18174n[i13] = b(strArr[i13]).f18183a;
        }
    }
}
