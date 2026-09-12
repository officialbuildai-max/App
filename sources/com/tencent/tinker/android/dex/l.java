package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class l extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public byte[] f40691b;

    /* loaded from: classes5.dex */
    class a implements gf.a {

        /* renamed from: a, reason: collision with root package name */
        private int f40692a = 0;

        a() {
        }

        @Override // gf.a
        public byte readByte() {
            byte[] bArr = l.this.f40691b;
            int i11 = this.f40692a;
            this.f40692a = i11 + 1;
            return bArr[i11];
        }
    }

    public l(int i11, byte[] bArr) {
        super(i11);
        this.f40691b = bArr;
    }

    public gf.a a() {
        return new a();
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return gf.c.d(this.f40691b, lVar.f40691b);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof l) && compareTo((l) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return Arrays.hashCode(this.f40691b);
    }
}
