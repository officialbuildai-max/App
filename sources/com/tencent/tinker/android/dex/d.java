package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class d extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public int f40627b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f40628c;

    /* renamed from: d, reason: collision with root package name */
    public int[][] f40629d;

    /* renamed from: e, reason: collision with root package name */
    public int[][] f40630e;

    public d(int i11, int i12, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i11);
        this.f40627b = i12;
        this.f40628c = iArr;
        this.f40629d = iArr2;
        this.f40630e = iArr3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        int i11 = this.f40627b;
        int i12 = dVar.f40627b;
        if (i11 != i12) {
            return gf.c.h(i11, i12);
        }
        int length = this.f40628c.length;
        int length2 = this.f40629d.length;
        int length3 = this.f40630e.length;
        int length4 = dVar.f40628c.length;
        int length5 = dVar.f40629d.length;
        int length6 = dVar.f40630e.length;
        if (length != length4) {
            return gf.c.c(length, length4);
        }
        if (length2 != length5) {
            return gf.c.c(length2, length5);
        }
        if (length3 != length6) {
            return gf.c.c(length3, length6);
        }
        for (int i13 = 0; i13 < length; i13++) {
            int[] iArr = this.f40628c[i13];
            int i14 = iArr[0];
            int i15 = iArr[1];
            int[] iArr2 = dVar.f40628c[i13];
            int i16 = iArr2[0];
            int i17 = iArr2[1];
            if (i14 != i16) {
                return gf.c.h(i14, i16);
            }
            if (i15 != i17) {
                return gf.c.c(i15, i17);
            }
        }
        for (int i18 = 0; i18 < length2; i18++) {
            int[] iArr3 = this.f40629d[i18];
            int i19 = iArr3[0];
            int i20 = iArr3[1];
            int[] iArr4 = dVar.f40629d[i18];
            int i21 = iArr4[0];
            int i22 = iArr4[1];
            if (i19 != i21) {
                return gf.c.h(i19, i21);
            }
            if (i20 != i22) {
                return gf.c.c(i20, i22);
            }
        }
        for (int i23 = 0; i23 < length3; i23++) {
            int[] iArr5 = this.f40630e[i23];
            int i24 = iArr5[0];
            int i25 = iArr5[1];
            int[] iArr6 = dVar.f40630e[i23];
            int i26 = iArr6[0];
            int i27 = iArr6[1];
            if (i24 != i26) {
                return gf.c.h(i24, i26);
            }
            if (i25 != i27) {
                return gf.c.c(i25, i27);
            }
        }
        return 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof d) && compareTo((d) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(Integer.valueOf(this.f40627b), this.f40628c, this.f40629d, this.f40630e);
    }
}
