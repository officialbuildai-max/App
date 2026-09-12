package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class i extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public int f40663b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f40664c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f40665d;

    public i(int i11, int i12, int[] iArr, byte[] bArr) {
        super(i11);
        this.f40663b = i12;
        this.f40664c = iArr;
        this.f40665d = bArr;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        int i11 = this.f40663b;
        int i12 = iVar.f40663b;
        if (i11 != i12) {
            return i11 - i12;
        }
        int e11 = gf.c.e(this.f40664c, iVar.f40664c);
        return e11 != 0 ? e11 : gf.c.d(this.f40665d, iVar.f40665d);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof i) && compareTo((i) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(Integer.valueOf(this.f40663b), this.f40664c, this.f40665d);
    }
}
