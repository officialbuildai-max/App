package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public final class q extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public int f40701b;

    /* renamed from: c, reason: collision with root package name */
    public int f40702c;

    /* renamed from: d, reason: collision with root package name */
    public int f40703d;

    public q(int i11, int i12, int i13, int i14) {
        super(i11);
        this.f40701b = i12;
        this.f40702c = i13;
        this.f40703d = i14;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(q qVar) {
        int i11 = this.f40701b;
        int i12 = qVar.f40701b;
        if (i11 != i12) {
            return gf.c.h(i11, i12);
        }
        int i13 = this.f40703d;
        int i14 = qVar.f40703d;
        return i13 != i14 ? gf.c.h(i13, i14) : gf.c.h(this.f40702c, qVar.f40702c);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof q) && compareTo((q) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(Integer.valueOf(this.f40701b), Integer.valueOf(this.f40702c), Integer.valueOf(this.f40703d));
    }
}
