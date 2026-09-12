package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public final class h extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public int f40649b;

    /* renamed from: c, reason: collision with root package name */
    public int f40650c;

    /* renamed from: d, reason: collision with root package name */
    public int f40651d;

    /* renamed from: e, reason: collision with root package name */
    public int f40652e;

    /* renamed from: f, reason: collision with root package name */
    public short[] f40653f;

    /* renamed from: g, reason: collision with root package name */
    public b[] f40654g;

    /* renamed from: h, reason: collision with root package name */
    public a[] f40655h;

    /* loaded from: classes5.dex */
    public static class a implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public int[] f40656a;

        /* renamed from: b, reason: collision with root package name */
        public int[] f40657b;

        /* renamed from: c, reason: collision with root package name */
        public int f40658c;

        /* renamed from: d, reason: collision with root package name */
        public int f40659d;

        public a(int[] iArr, int[] iArr2, int i11, int i12) {
            this.f40656a = iArr;
            this.f40657b = iArr2;
            this.f40658c = i11;
            this.f40659d = i12;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int b11 = gf.c.b(this.f40656a, aVar.f40656a);
            if (b11 != 0) {
                return b11;
            }
            int b12 = gf.c.b(this.f40657b, aVar.f40657b);
            return b12 != 0 ? b12 : gf.c.c(this.f40658c, aVar.f40658c);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public int f40660a;

        /* renamed from: b, reason: collision with root package name */
        public int f40661b;

        /* renamed from: c, reason: collision with root package name */
        public int f40662c;

        public b(int i11, int i12, int i13) {
            this.f40660a = i11;
            this.f40661b = i12;
            this.f40662c = i13;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int c11 = gf.c.c(this.f40660a, bVar.f40660a);
            if (c11 != 0) {
                return c11;
            }
            int c12 = gf.c.c(this.f40661b, bVar.f40661b);
            return c12 != 0 ? c12 : gf.c.c(this.f40662c, bVar.f40662c);
        }
    }

    public h(int i11, int i12, int i13, int i14, int i15, short[] sArr, b[] bVarArr, a[] aVarArr) {
        super(i11);
        this.f40649b = i12;
        this.f40650c = i13;
        this.f40651d = i14;
        this.f40652e = i15;
        this.f40653f = sArr;
        this.f40654g = bVarArr;
        this.f40655h = aVarArr;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        int c11 = gf.c.c(this.f40649b, hVar.f40649b);
        if (c11 != 0) {
            return c11;
        }
        int c12 = gf.c.c(this.f40650c, hVar.f40650c);
        if (c12 != 0) {
            return c12;
        }
        int c13 = gf.c.c(this.f40651d, hVar.f40651d);
        if (c13 != 0) {
            return c13;
        }
        int c14 = gf.c.c(this.f40652e, hVar.f40652e);
        if (c14 != 0) {
            return c14;
        }
        int f11 = gf.c.f(this.f40653f, hVar.f40653f);
        if (f11 != 0) {
            return f11;
        }
        int a11 = gf.c.a(this.f40654g, hVar.f40654g);
        return a11 != 0 ? a11 : gf.c.a(this.f40655h, hVar.f40655h);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof h) && compareTo((h) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(Integer.valueOf(this.f40649b), Integer.valueOf(this.f40650c), Integer.valueOf(this.f40651d), Integer.valueOf(this.f40652e), this.f40653f, this.f40654g, this.f40655h);
    }
}
