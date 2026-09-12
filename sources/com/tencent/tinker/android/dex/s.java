package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public final class s extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public int f40704b;

    /* renamed from: c, reason: collision with root package name */
    public int f40705c;

    /* renamed from: d, reason: collision with root package name */
    public int f40706d;

    public s(int i11, int i12, int i13, int i14) {
        super(i11);
        this.f40704b = i12;
        this.f40705c = i13;
        this.f40706d = i14;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(s sVar) {
        int h11 = gf.c.h(this.f40704b, sVar.f40704b);
        if (h11 != 0) {
            return h11;
        }
        int h12 = gf.c.h(this.f40705c, sVar.f40705c);
        return h12 != 0 ? h12 : gf.c.c(this.f40706d, sVar.f40706d);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof s) && compareTo((s) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(Integer.valueOf(this.f40704b), Integer.valueOf(this.f40705c), Integer.valueOf(this.f40706d));
    }
}
