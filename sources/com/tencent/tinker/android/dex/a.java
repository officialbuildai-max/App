package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public final class a extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public byte f40623b;

    /* renamed from: c, reason: collision with root package name */
    public l f40624c;

    public a(int i11, byte b11, l lVar) {
        super(i11);
        this.f40623b = b11;
        this.f40624c = lVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        int compareTo = this.f40624c.compareTo(aVar.f40624c);
        return compareTo != 0 ? compareTo : gf.c.g(this.f40623b, aVar.f40623b);
    }

    public n b() {
        return new n(this.f40624c, 29);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof a) && compareTo((a) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(Byte.valueOf(this.f40623b), this.f40624c);
    }
}
