package com.google.common.collect;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class n4 {

    /* renamed from: a, reason: collision with root package name */
    private final int f30881a;

    /* renamed from: b, reason: collision with root package name */
    private final Comparator f30882b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f30883c;

    /* renamed from: d, reason: collision with root package name */
    private int f30884d;

    /* renamed from: e, reason: collision with root package name */
    private Object f30885e;

    private n4(Comparator comparator, int i11) {
        this.f30882b = (Comparator) com.google.common.base.m.p(comparator, "comparator");
        this.f30881a = i11;
        com.google.common.base.m.f(i11 >= 0, "k (%s) must be >= 0", i11);
        com.google.common.base.m.f(i11 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i11);
        this.f30883c = new Object[com.google.common.math.d.b(i11, 2)];
        this.f30884d = 0;
        this.f30885e = null;
    }

    public static n4 a(int i11, Comparator comparator) {
        return new n4(comparator, i11);
    }

    private int d(int i11, int i12, int i13) {
        Object a11 = m3.a(this.f30883c[i13]);
        Object[] objArr = this.f30883c;
        objArr[i13] = objArr[i12];
        int i14 = i11;
        while (i11 < i12) {
            if (this.f30882b.compare(m3.a(this.f30883c[i11]), a11) < 0) {
                e(i14, i11);
                i14++;
            }
            i11++;
        }
        Object[] objArr2 = this.f30883c;
        objArr2[i12] = objArr2[i14];
        objArr2[i14] = a11;
        return i14;
    }

    private void e(int i11, int i12) {
        Object[] objArr = this.f30883c;
        Object obj = objArr[i11];
        objArr[i11] = objArr[i12];
        objArr[i12] = obj;
    }

    private void g() {
        int i11 = (this.f30881a * 2) - 1;
        int f11 = com.google.common.math.d.f(i11, RoundingMode.CEILING) * 3;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            int d11 = d(i12, i11, ((i12 + i11) + 1) >>> 1);
            int i15 = this.f30881a;
            if (d11 <= i15) {
                if (d11 >= i15) {
                    break;
                }
                i12 = Math.max(d11, i12 + 1);
                i14 = d11;
            } else {
                i11 = d11 - 1;
            }
            i13++;
            if (i13 >= f11) {
                Arrays.sort(this.f30883c, i12, i11 + 1, this.f30882b);
                break;
            }
        }
        this.f30884d = this.f30881a;
        this.f30885e = m3.a(this.f30883c[i14]);
        while (true) {
            i14++;
            if (i14 >= this.f30881a) {
                return;
            }
            if (this.f30882b.compare(m3.a(this.f30883c[i14]), m3.a(this.f30885e)) > 0) {
                this.f30885e = this.f30883c[i14];
            }
        }
    }

    public void b(Object obj) {
        int i11 = this.f30881a;
        if (i11 == 0) {
            return;
        }
        int i12 = this.f30884d;
        if (i12 == 0) {
            this.f30883c[0] = obj;
            this.f30885e = obj;
            this.f30884d = 1;
            return;
        }
        if (i12 < i11) {
            Object[] objArr = this.f30883c;
            this.f30884d = i12 + 1;
            objArr[i12] = obj;
            if (this.f30882b.compare(obj, m3.a(this.f30885e)) > 0) {
                this.f30885e = obj;
                return;
            }
            return;
        }
        if (this.f30882b.compare(obj, m3.a(this.f30885e)) < 0) {
            Object[] objArr2 = this.f30883c;
            int i13 = this.f30884d;
            int i14 = i13 + 1;
            this.f30884d = i14;
            objArr2[i13] = obj;
            if (i14 == this.f30881a * 2) {
                g();
            }
        }
    }

    public void c(Iterator it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public List f() {
        Object[] objArr = this.f30883c;
        Arrays.sort(objArr, 0, this.f30884d, this.f30882b);
        int i11 = this.f30884d;
        int i12 = this.f30881a;
        if (i11 > i12) {
            Object[] objArr2 = this.f30883c;
            Arrays.fill(objArr2, i12, objArr2.length, (Object) null);
            int i13 = this.f30881a;
            this.f30884d = i13;
            this.f30885e = this.f30883c[i13 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, this.f30884d)));
    }
}
