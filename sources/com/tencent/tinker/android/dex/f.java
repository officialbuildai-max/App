package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public final class f extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public a[] f40632b;

    /* renamed from: c, reason: collision with root package name */
    public a[] f40633c;

    /* renamed from: d, reason: collision with root package name */
    public b[] f40634d;

    /* renamed from: e, reason: collision with root package name */
    public b[] f40635e;

    /* loaded from: classes5.dex */
    public static class a implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public int f40636a;

        /* renamed from: b, reason: collision with root package name */
        public int f40637b;

        public a(int i11, int i12) {
            this.f40636a = i11;
            this.f40637b = i12;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int h11 = gf.c.h(this.f40636a, aVar.f40636a);
            return h11 != 0 ? h11 : gf.c.c(this.f40637b, aVar.f40637b);
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && compareTo((a) obj) == 0;
        }

        public int hashCode() {
            return gf.e.a(Integer.valueOf(this.f40636a), Integer.valueOf(this.f40637b));
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public int f40638a;

        /* renamed from: b, reason: collision with root package name */
        public int f40639b;

        /* renamed from: c, reason: collision with root package name */
        public int f40640c;

        public b(int i11, int i12, int i13) {
            this.f40638a = i11;
            this.f40639b = i12;
            this.f40640c = i13;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int h11 = gf.c.h(this.f40638a, bVar.f40638a);
            if (h11 != 0) {
                return h11;
            }
            int c11 = gf.c.c(this.f40639b, bVar.f40639b);
            return c11 != 0 ? c11 : gf.c.c(this.f40640c, bVar.f40640c);
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && compareTo((b) obj) == 0;
        }

        public int hashCode() {
            return gf.e.a(Integer.valueOf(this.f40638a), Integer.valueOf(this.f40639b), Integer.valueOf(this.f40640c));
        }
    }

    public f(int i11, a[] aVarArr, a[] aVarArr2, b[] bVarArr, b[] bVarArr2) {
        super(i11);
        this.f40632b = aVarArr;
        this.f40633c = aVarArr2;
        this.f40634d = bVarArr;
        this.f40635e = bVarArr2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int a11 = gf.c.a(this.f40632b, fVar.f40632b);
        if (a11 != 0) {
            return a11;
        }
        int a12 = gf.c.a(this.f40633c, fVar.f40633c);
        if (a12 != 0) {
            return a12;
        }
        int a13 = gf.c.a(this.f40634d, fVar.f40634d);
        return a13 != 0 ? a13 : gf.c.a(this.f40635e, fVar.f40635e);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return gf.e.a(this.f40632b, this.f40633c, this.f40634d, this.f40635e);
    }
}
