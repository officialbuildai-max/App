package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public final class o extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public int f40698b;

    /* renamed from: c, reason: collision with root package name */
    public int f40699c;

    /* renamed from: d, reason: collision with root package name */
    public int f40700d;

    public o(int i11, int i12, int i13, int i14) {
        super(i11);
        this.f40698b = i12;
        this.f40699c = i13;
        this.f40700d = i14;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(o oVar) {
        int i11 = this.f40698b;
        int i12 = oVar.f40698b;
        if (i11 != i12) {
            return gf.c.h(i11, i12);
        }
        int i13 = this.f40700d;
        int i14 = oVar.f40700d;
        return i13 != i14 ? gf.c.h(i13, i14) : gf.c.h(this.f40699c, oVar.f40699c);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof o) && compareTo((o) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(Integer.valueOf(this.f40698b), Integer.valueOf(this.f40699c), Integer.valueOf(this.f40700d));
    }
}
