package com.tencent.tinker.android.dex;

import androidx.core.view.InputDeviceCompat;
import com.tencent.tinker.android.dex.j;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class v {
    public int A;
    public int B;
    public int C;

    /* renamed from: a, reason: collision with root package name */
    public final a f40708a;

    /* renamed from: b, reason: collision with root package name */
    public final a f40709b;

    /* renamed from: c, reason: collision with root package name */
    public final a f40710c;

    /* renamed from: d, reason: collision with root package name */
    public final a f40711d;

    /* renamed from: e, reason: collision with root package name */
    public final a f40712e;

    /* renamed from: f, reason: collision with root package name */
    public final a f40713f;

    /* renamed from: g, reason: collision with root package name */
    public final a f40714g;

    /* renamed from: h, reason: collision with root package name */
    public final a f40715h;

    /* renamed from: i, reason: collision with root package name */
    public final a f40716i;

    /* renamed from: j, reason: collision with root package name */
    public final a f40717j;

    /* renamed from: k, reason: collision with root package name */
    public final a f40718k;

    /* renamed from: l, reason: collision with root package name */
    public final a f40719l;

    /* renamed from: m, reason: collision with root package name */
    public final a f40720m;

    /* renamed from: n, reason: collision with root package name */
    public final a f40721n;

    /* renamed from: o, reason: collision with root package name */
    public final a f40722o;

    /* renamed from: p, reason: collision with root package name */
    public final a f40723p;

    /* renamed from: q, reason: collision with root package name */
    public final a f40724q;

    /* renamed from: r, reason: collision with root package name */
    public final a f40725r;

    /* renamed from: s, reason: collision with root package name */
    public final a f40726s;

    /* renamed from: t, reason: collision with root package name */
    public final a f40727t;

    /* renamed from: u, reason: collision with root package name */
    public final a[] f40728u;

    /* renamed from: v, reason: collision with root package name */
    public int f40729v;

    /* renamed from: w, reason: collision with root package name */
    public int f40730w;

    /* renamed from: x, reason: collision with root package name */
    public byte[] f40731x;

    /* renamed from: y, reason: collision with root package name */
    public int f40732y;

    /* renamed from: z, reason: collision with root package name */
    public int f40733z;

    /* loaded from: classes5.dex */
    public static class a implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final short f40734a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f40735b;

        /* renamed from: c, reason: collision with root package name */
        public int f40736c;

        /* renamed from: d, reason: collision with root package name */
        public int f40737d;

        /* renamed from: e, reason: collision with root package name */
        public int f40738e;

        /* renamed from: com.tencent.tinker.android.dex.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static abstract class AbstractC0584a implements Comparable {

            /* renamed from: a, reason: collision with root package name */
            public int f40739a;

            public AbstractC0584a(int i11) {
                this.f40739a = i11;
            }

            public boolean equals(Object obj) {
                return compareTo(obj) == 0;
            }

            public int hashCode() {
                return super.hashCode();
            }
        }

        public a(int i11, boolean z10) {
            this.f40736c = 0;
            this.f40737d = -1;
            this.f40738e = 0;
            this.f40734a = (short) i11;
            this.f40735b = z10;
            if (i11 == 0) {
                this.f40737d = 0;
                this.f40736c = 1;
                this.f40738e = 112;
            } else if (i11 == 4096) {
                this.f40736c = 1;
            }
        }

        private int d(int i11) {
            switch (i11) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 7;
                case 7:
                    return 18;
                case 8:
                    return 6;
                default:
                    switch (i11) {
                        case 4096:
                            return 19;
                        case 4097:
                            return 9;
                        case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                            return 12;
                        case 4099:
                            return 11;
                        default:
                            switch (i11) {
                                case 8192:
                                    return 16;
                                case 8193:
                                    return 15;
                                case InputDeviceCompat.SOURCE_MOUSE /* 8194 */:
                                    return 8;
                                case 8195:
                                    return 14;
                                case 8196:
                                    return 10;
                                case 8197:
                                    return 17;
                                case 8198:
                                    return 13;
                                default:
                                    throw new IllegalArgumentException("unknown section type: " + i11);
                            }
                    }
            }
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i11 = this.f40737d;
            int i12 = aVar.f40737d;
            if (i11 != i12) {
                return i11 < i12 ? -1 : 1;
            }
            int d11 = d(this.f40734a);
            int d12 = d(aVar.f40734a);
            if (d11 != d12) {
                return d11 < d12 ? -1 : 1;
            }
            return 0;
        }

        public boolean b() {
            return this.f40736c > 0;
        }

        public String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x,byteCount=%#x]", Short.valueOf(this.f40734a), Integer.valueOf(this.f40737d), Integer.valueOf(this.f40736c), Integer.valueOf(this.f40738e));
        }
    }

    public v() {
        a aVar = new a(0, true);
        this.f40708a = aVar;
        a aVar2 = new a(1, true);
        this.f40709b = aVar2;
        a aVar3 = new a(2, true);
        this.f40710c = aVar3;
        a aVar4 = new a(3, true);
        this.f40711d = aVar4;
        a aVar5 = new a(4, true);
        this.f40712e = aVar5;
        a aVar6 = new a(5, true);
        this.f40713f = aVar6;
        a aVar7 = new a(6, true);
        this.f40714g = aVar7;
        a aVar8 = new a(7, true);
        this.f40715h = aVar8;
        a aVar9 = new a(8, true);
        this.f40716i = aVar9;
        a aVar10 = new a(4096, true);
        this.f40717j = aVar10;
        a aVar11 = new a(4097, true);
        this.f40718k = aVar11;
        a aVar12 = new a(InputDeviceCompat.SOURCE_TOUCHSCREEN, true);
        this.f40719l = aVar12;
        a aVar13 = new a(4099, true);
        this.f40720m = aVar13;
        a aVar14 = new a(8192, false);
        this.f40721n = aVar14;
        a aVar15 = new a(8193, true);
        this.f40722o = aVar15;
        a aVar16 = new a(InputDeviceCompat.SOURCE_MOUSE, false);
        this.f40723p = aVar16;
        a aVar17 = new a(8195, false);
        this.f40724q = aVar17;
        a aVar18 = new a(8196, false);
        this.f40725r = aVar18;
        a aVar19 = new a(8197, false);
        this.f40726s = aVar19;
        a aVar20 = new a(8198, true);
        this.f40727t = aVar20;
        this.f40728u = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar10, aVar8, aVar9, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16, aVar17, aVar18, aVar19, aVar20};
        this.f40729v = 13;
        this.f40731x = new byte[20];
    }

    private a b(short s11) {
        for (a aVar : this.f40728u) {
            if (aVar.f40734a == s11) {
                return aVar;
            }
        }
        throw new IllegalArgumentException("No such map item: " + ((int) s11));
    }

    private void d(j.h hVar) {
        byte[] l11 = hVar.l(8);
        int b11 = k.b(l11);
        this.f40729v = b11;
        if (b11 == -1) {
            throw new DexException("Unexpected magic: " + Arrays.toString(l11));
        }
        this.f40730w = hVar.w();
        this.f40731x = hVar.l(20);
        this.f40732y = hVar.w();
        int w11 = hVar.w();
        if (w11 != 112) {
            throw new DexException("Unexpected header: 0x" + Integer.toHexString(w11));
        }
        int w12 = hVar.w();
        if (w12 != 305419896) {
            throw new DexException("Unexpected endian tag: 0x" + Integer.toHexString(w12));
        }
        this.f40733z = hVar.w();
        this.A = hVar.w();
        this.f40717j.f40737d = hVar.w();
        if (this.f40717j.f40737d == 0) {
            throw new DexException("Cannot merge dex files that do not contain a map");
        }
        this.f40709b.f40736c = hVar.w();
        this.f40709b.f40737d = hVar.w();
        this.f40710c.f40736c = hVar.w();
        this.f40710c.f40737d = hVar.w();
        this.f40711d.f40736c = hVar.w();
        this.f40711d.f40737d = hVar.w();
        this.f40712e.f40736c = hVar.w();
        this.f40712e.f40737d = hVar.w();
        this.f40713f.f40736c = hVar.w();
        this.f40713f.f40737d = hVar.w();
        this.f40714g.f40736c = hVar.w();
        this.f40714g.f40737d = hVar.w();
        this.B = hVar.w();
        this.C = hVar.w();
    }

    private void e(j.h hVar) {
        int i11;
        int w11 = hVar.w();
        a aVar = null;
        int i12 = 0;
        while (i12 < w11) {
            short B = hVar.B();
            hVar.B();
            a b11 = b(B);
            int w12 = hVar.w();
            int w13 = hVar.w();
            int i13 = b11.f40736c;
            if ((i13 != 0 && i13 != w12) || ((i11 = b11.f40737d) != -1 && i11 != w13)) {
                throw new DexException("Unexpected map value for 0x" + Integer.toHexString(B));
            }
            b11.f40736c = w12;
            b11.f40737d = w13;
            if (aVar != null && aVar.f40737d > w13) {
                throw new DexException("Map is unsorted at " + aVar + ", " + b11);
            }
            i12++;
            aVar = b11;
        }
        this.f40708a.f40737d = 0;
        Arrays.sort(this.f40728u);
        int i14 = 1;
        while (true) {
            a[] aVarArr = this.f40728u;
            if (i14 >= aVarArr.length) {
                return;
            }
            a aVar2 = aVarArr[i14];
            if (aVar2.f40737d == -1) {
                aVar2.f40737d = aVarArr[i14 - 1].f40737d;
            }
            i14++;
        }
    }

    public void a() {
        int i11 = this.f40732y;
        for (int length = this.f40728u.length - 1; length >= 0; length--) {
            a aVar = this.f40728u[length];
            int i12 = aVar.f40737d;
            if (i12 != -1) {
                if (i12 > i11) {
                    throw new DexException("Map is unsorted at " + aVar);
                }
                aVar.f40738e = i11 - i12;
                i11 = i12;
            }
        }
        int i13 = this.f40708a.f40738e + this.f40709b.f40738e + this.f40710c.f40738e + this.f40711d.f40738e + this.f40712e.f40738e + this.f40713f.f40738e + this.f40714g.f40738e;
        this.C = i13;
        this.B = this.f40732y - i13;
    }

    public void c(j jVar) {
        d(jVar.m(this.f40708a));
        e(jVar.l(this.f40717j.f40737d));
        a();
    }

    public void f(j.h hVar) {
        hVar.M(k.a(this.f40729v).getBytes("UTF-8"));
        hVar.c0(this.f40730w);
        hVar.M(this.f40731x);
        hVar.c0(this.f40732y);
        hVar.c0(112);
        hVar.c0(305419896);
        hVar.c0(this.f40733z);
        hVar.c0(this.A);
        hVar.c0(this.f40717j.f40737d);
        hVar.c0(this.f40709b.f40736c);
        hVar.c0(this.f40709b.b() ? this.f40709b.f40737d : 0);
        hVar.c0(this.f40710c.f40736c);
        hVar.c0(this.f40710c.b() ? this.f40710c.f40737d : 0);
        hVar.c0(this.f40711d.f40736c);
        hVar.c0(this.f40711d.b() ? this.f40711d.f40737d : 0);
        hVar.c0(this.f40712e.f40736c);
        hVar.c0(this.f40712e.b() ? this.f40712e.f40737d : 0);
        hVar.c0(this.f40713f.f40736c);
        hVar.c0(this.f40713f.b() ? this.f40713f.f40737d : 0);
        hVar.c0(this.f40714g.f40736c);
        hVar.c0(this.f40714g.b() ? this.f40714g.f40737d : 0);
        hVar.c0(this.B);
        hVar.c0(this.C);
    }

    public void g(j.h hVar) {
        int i11 = 0;
        for (a aVar : this.f40728u) {
            if (aVar.b()) {
                i11++;
            }
        }
        hVar.c0(i11);
        for (a aVar2 : this.f40728u) {
            if (aVar2.b()) {
                hVar.h0(aVar2.f40734a);
                hVar.h0((short) 0);
                hVar.c0(aVar2.f40736c);
                hVar.c0(aVar2.f40737d);
            }
        }
    }
}
