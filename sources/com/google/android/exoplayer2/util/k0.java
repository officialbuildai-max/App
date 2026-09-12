package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private long[] f27653a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f27654b;

    /* renamed from: c, reason: collision with root package name */
    private int f27655c;

    /* renamed from: d, reason: collision with root package name */
    private int f27656d;

    public k0() {
        this(10);
    }

    public k0(int i11) {
        this.f27653a = new long[i11];
        this.f27654b = f(i11);
    }

    private void b(long j11, Object obj) {
        int i11 = this.f27655c;
        int i12 = this.f27656d;
        Object[] objArr = this.f27654b;
        int length = (i11 + i12) % objArr.length;
        this.f27653a[length] = j11;
        objArr[length] = obj;
        this.f27656d = i12 + 1;
    }

    private void d(long j11) {
        if (this.f27656d > 0) {
            if (j11 <= this.f27653a[((this.f27655c + r0) - 1) % this.f27654b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f27654b.length;
        if (this.f27656d < length) {
            return;
        }
        int i11 = length * 2;
        long[] jArr = new long[i11];
        Object[] f11 = f(i11);
        int i12 = this.f27655c;
        int i13 = length - i12;
        System.arraycopy(this.f27653a, i12, jArr, 0, i13);
        System.arraycopy(this.f27654b, this.f27655c, f11, 0, i13);
        int i14 = this.f27655c;
        if (i14 > 0) {
            System.arraycopy(this.f27653a, 0, jArr, i13, i14);
            System.arraycopy(this.f27654b, 0, f11, i13, this.f27655c);
        }
        this.f27653a = jArr;
        this.f27654b = f11;
        this.f27655c = 0;
    }

    private static Object[] f(int i11) {
        return new Object[i11];
    }

    private Object h(long j11, boolean z10) {
        Object obj = null;
        long j12 = Long.MAX_VALUE;
        while (this.f27656d > 0) {
            long j13 = j11 - this.f27653a[this.f27655c];
            if (j13 < 0 && (z10 || (-j13) >= j12)) {
                break;
            }
            obj = k();
            j12 = j13;
        }
        return obj;
    }

    private Object k() {
        a.g(this.f27656d > 0);
        Object[] objArr = this.f27654b;
        int i11 = this.f27655c;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f27655c = (i11 + 1) % objArr.length;
        this.f27656d--;
        return obj;
    }

    public synchronized void a(long j11, Object obj) {
        d(j11);
        e();
        b(j11, obj);
    }

    public synchronized void c() {
        this.f27655c = 0;
        this.f27656d = 0;
        Arrays.fill(this.f27654b, (Object) null);
    }

    public synchronized Object g(long j11) {
        return h(j11, false);
    }

    public synchronized Object i() {
        return this.f27656d == 0 ? null : k();
    }

    public synchronized Object j(long j11) {
        return h(j11, true);
    }

    public synchronized int l() {
        return this.f27656d;
    }
}
