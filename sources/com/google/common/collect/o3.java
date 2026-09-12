package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.l3;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class o3 {

    /* renamed from: a, reason: collision with root package name */
    transient Object[] f30886a;

    /* renamed from: b, reason: collision with root package name */
    transient int[] f30887b;

    /* renamed from: c, reason: collision with root package name */
    transient int f30888c;

    /* renamed from: d, reason: collision with root package name */
    transient int f30889d;

    /* renamed from: e, reason: collision with root package name */
    private transient int[] f30890e;

    /* renamed from: f, reason: collision with root package name */
    transient long[] f30891f;

    /* renamed from: g, reason: collision with root package name */
    private transient float f30892g;

    /* renamed from: h, reason: collision with root package name */
    private transient int f30893h;

    /* loaded from: classes4.dex */
    class a extends Multisets.b {

        /* renamed from: a, reason: collision with root package name */
        final Object f30894a;

        /* renamed from: b, reason: collision with root package name */
        int f30895b;

        a(int i11) {
            this.f30894a = o3.this.f30886a[i11];
            this.f30895b = i11;
        }

        void a() {
            int i11 = this.f30895b;
            if (i11 == -1 || i11 >= o3.this.C() || !com.google.common.base.j.a(this.f30894a, o3.this.f30886a[this.f30895b])) {
                this.f30895b = o3.this.m(this.f30894a);
            }
        }

        @Override // com.google.common.collect.l3.a
        public int getCount() {
            a();
            int i11 = this.f30895b;
            if (i11 == -1) {
                return 0;
            }
            return o3.this.f30887b[i11];
        }

        @Override // com.google.common.collect.l3.a
        public Object getElement() {
            return this.f30894a;
        }
    }

    o3() {
        n(3, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o3(int i11) {
        this(i11, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o3(int i11, float f11) {
        n(i11, f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o3(o3 o3Var) {
        n(o3Var.C(), 1.0f);
        int e11 = o3Var.e();
        while (e11 != -1) {
            u(o3Var.i(e11), o3Var.k(e11));
            e11 = o3Var.s(e11);
        }
    }

    private void A(int i11) {
        if (this.f30890e.length >= 1073741824) {
            this.f30893h = Integer.MAX_VALUE;
            return;
        }
        int i12 = ((int) (i11 * this.f30892g)) + 1;
        int[] r11 = r(i11);
        long[] jArr = this.f30891f;
        int length = r11.length - 1;
        for (int i13 = 0; i13 < this.f30888c; i13++) {
            int h11 = h(jArr[i13]);
            int i14 = h11 & length;
            int i15 = r11[i14];
            r11[i14] = i13;
            jArr[i13] = (h11 << 32) | (i15 & 4294967295L);
        }
        this.f30893h = i12;
        this.f30890e = r11;
    }

    private static long D(long j11, int i11) {
        return (j11 & (-4294967296L)) | (4294967295L & i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o3 b() {
        return new o3();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o3 c(int i11) {
        return new o3(i11);
    }

    private static int h(long j11) {
        return (int) (j11 >>> 32);
    }

    private static int j(long j11) {
        return (int) j11;
    }

    private int l() {
        return this.f30890e.length - 1;
    }

    private static long[] q(int i11) {
        long[] jArr = new long[i11];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] r(int i11) {
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int w(Object obj, int i11) {
        int l11 = l() & i11;
        int i12 = this.f30890e[l11];
        if (i12 == -1) {
            return 0;
        }
        int i13 = -1;
        while (true) {
            if (h(this.f30891f[i12]) == i11 && com.google.common.base.j.a(obj, this.f30886a[i12])) {
                int i14 = this.f30887b[i12];
                if (i13 == -1) {
                    this.f30890e[l11] = j(this.f30891f[i12]);
                } else {
                    long[] jArr = this.f30891f;
                    jArr[i13] = D(jArr[i13], j(jArr[i12]));
                }
                p(i12);
                this.f30888c--;
                this.f30889d++;
                return i14;
            }
            int j11 = j(this.f30891f[i12]);
            if (j11 == -1) {
                return 0;
            }
            i13 = i12;
            i12 = j11;
        }
    }

    private void z(int i11) {
        int length = this.f30891f.length;
        if (i11 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i11, int i12) {
        com.google.common.base.m.m(i11, this.f30888c);
        this.f30887b[i11] = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.f30888c;
    }

    public void a() {
        this.f30889d++;
        Arrays.fill(this.f30886a, 0, this.f30888c, (Object) null);
        Arrays.fill(this.f30887b, 0, this.f30888c, 0);
        Arrays.fill(this.f30890e, -1);
        Arrays.fill(this.f30891f, -1L);
        this.f30888c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i11) {
        if (i11 > this.f30891f.length) {
            y(i11);
        }
        if (i11 >= this.f30893h) {
            A(Math.max(2, Integer.highestOneBit(i11 - 1) << 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f30888c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int m11 = m(obj);
        if (m11 == -1) {
            return 0;
        }
        return this.f30887b[m11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l3.a g(int i11) {
        com.google.common.base.m.m(i11, this.f30888c);
        return new a(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object i(int i11) {
        com.google.common.base.m.m(i11, this.f30888c);
        return this.f30886a[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(int i11) {
        com.google.common.base.m.m(i11, this.f30888c);
        return this.f30887b[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(Object obj) {
        int d11 = v2.d(obj);
        int i11 = this.f30890e[l() & d11];
        while (i11 != -1) {
            long j11 = this.f30891f[i11];
            if (h(j11) == d11 && com.google.common.base.j.a(obj, this.f30886a[i11])) {
                return i11;
            }
            i11 = j(j11);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i11, float f11) {
        com.google.common.base.m.e(i11 >= 0, "Initial capacity must be non-negative");
        com.google.common.base.m.e(f11 > 0.0f, "Illegal load factor");
        int a11 = v2.a(i11, f11);
        this.f30890e = r(a11);
        this.f30892g = f11;
        this.f30886a = new Object[i11];
        this.f30887b = new int[i11];
        this.f30891f = q(i11);
        this.f30893h = Math.max(1, (int) (a11 * f11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i11, Object obj, int i12, int i13) {
        this.f30891f[i11] = (i13 << 32) | 4294967295L;
        this.f30886a[i11] = obj;
        this.f30887b[i11] = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i11) {
        int C = C() - 1;
        if (i11 >= C) {
            this.f30886a[i11] = null;
            this.f30887b[i11] = 0;
            this.f30891f[i11] = -1;
            return;
        }
        Object[] objArr = this.f30886a;
        objArr[i11] = objArr[C];
        int[] iArr = this.f30887b;
        iArr[i11] = iArr[C];
        objArr[C] = null;
        iArr[C] = 0;
        long[] jArr = this.f30891f;
        long j11 = jArr[C];
        jArr[i11] = j11;
        jArr[C] = -1;
        int h11 = h(j11) & l();
        int[] iArr2 = this.f30890e;
        int i12 = iArr2[h11];
        if (i12 == C) {
            iArr2[h11] = i11;
            return;
        }
        while (true) {
            long j12 = this.f30891f[i12];
            int j13 = j(j12);
            if (j13 == C) {
                this.f30891f[i12] = D(j12, i11);
                return;
            }
            i12 = j13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.f30888c) {
            return i12;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(int i11, int i12) {
        return i11 - 1;
    }

    public int u(Object obj, int i11) {
        e2.d(i11, "count");
        long[] jArr = this.f30891f;
        Object[] objArr = this.f30886a;
        int[] iArr = this.f30887b;
        int d11 = v2.d(obj);
        int l11 = l() & d11;
        int i12 = this.f30888c;
        int[] iArr2 = this.f30890e;
        int i13 = iArr2[l11];
        if (i13 == -1) {
            iArr2[l11] = i12;
        } else {
            while (true) {
                long j11 = jArr[i13];
                if (h(j11) == d11 && com.google.common.base.j.a(obj, objArr[i13])) {
                    int i14 = iArr[i13];
                    iArr[i13] = i11;
                    return i14;
                }
                int j12 = j(j11);
                if (j12 == -1) {
                    jArr[i13] = D(j11, i12);
                    break;
                }
                i13 = j12;
            }
        }
        if (i12 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i15 = i12 + 1;
        z(i15);
        o(i12, obj, i11, d11);
        this.f30888c = i15;
        if (i12 >= this.f30893h) {
            A(this.f30890e.length * 2);
        }
        this.f30889d++;
        return 0;
    }

    public int v(Object obj) {
        return w(obj, v2.d(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(int i11) {
        return w(this.f30886a[i11], h(this.f30891f[i11]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i11) {
        this.f30886a = Arrays.copyOf(this.f30886a, i11);
        this.f30887b = Arrays.copyOf(this.f30887b, i11);
        long[] jArr = this.f30891f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i11);
        if (i11 > length) {
            Arrays.fill(copyOf, length, i11, -1L);
        }
        this.f30891f = copyOf;
    }
}
