package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public final class g extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public int f40641b;

    /* renamed from: c, reason: collision with root package name */
    public int f40642c;

    /* renamed from: d, reason: collision with root package name */
    public int f40643d;

    /* renamed from: e, reason: collision with root package name */
    public int f40644e;

    /* renamed from: f, reason: collision with root package name */
    public int f40645f;

    /* renamed from: g, reason: collision with root package name */
    public int f40646g;

    /* renamed from: h, reason: collision with root package name */
    public int f40647h;

    /* renamed from: i, reason: collision with root package name */
    public int f40648i;

    public g(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        super(i11);
        this.f40641b = i12;
        this.f40642c = i13;
        this.f40643d = i14;
        this.f40644e = i15;
        this.f40645f = i16;
        this.f40646g = i17;
        this.f40647h = i18;
        this.f40648i = i19;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        int h11 = gf.c.h(this.f40641b, gVar.f40641b);
        if (h11 != 0) {
            return h11;
        }
        int c11 = gf.c.c(this.f40642c, gVar.f40642c);
        if (c11 != 0) {
            return c11;
        }
        int h12 = gf.c.h(this.f40643d, gVar.f40643d);
        if (h12 != 0) {
            return h12;
        }
        int c12 = gf.c.c(this.f40644e, gVar.f40644e);
        if (c12 != 0) {
            return c12;
        }
        int h13 = gf.c.h(this.f40645f, gVar.f40645f);
        if (h13 != 0) {
            return h13;
        }
        int c13 = gf.c.c(this.f40646g, gVar.f40646g);
        if (c13 != 0) {
            return c13;
        }
        int c14 = gf.c.c(this.f40647h, gVar.f40647h);
        return c14 != 0 ? c14 : gf.c.c(this.f40648i, gVar.f40648i);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof g) && compareTo((g) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(Integer.valueOf(this.f40641b), Integer.valueOf(this.f40642c), Integer.valueOf(this.f40643d), Integer.valueOf(this.f40644e), Integer.valueOf(this.f40645f), Integer.valueOf(this.f40646g), Integer.valueOf(this.f40647h), Integer.valueOf(this.f40648i));
    }
}
