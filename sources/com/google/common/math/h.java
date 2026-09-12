package com.google.common.math;

import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private long f30964a = 0;

    /* renamed from: b, reason: collision with root package name */
    private double f30965b = 0.0d;

    /* renamed from: c, reason: collision with root package name */
    private double f30966c = 0.0d;

    /* renamed from: d, reason: collision with root package name */
    private double f30967d = Double.NaN;

    /* renamed from: e, reason: collision with root package name */
    private double f30968e = Double.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double g(double d11, double d12) {
        if (Doubles.f(d11)) {
            return d12;
        }
        if (Doubles.f(d12) || d11 == d12) {
            return d11;
        }
        return Double.NaN;
    }

    public void a(double d11) {
        long j11 = this.f30964a;
        if (j11 == 0) {
            this.f30964a = 1L;
            this.f30965b = d11;
            this.f30967d = d11;
            this.f30968e = d11;
            if (Doubles.f(d11)) {
                return;
            }
            this.f30966c = Double.NaN;
            return;
        }
        this.f30964a = j11 + 1;
        if (Doubles.f(d11) && Doubles.f(this.f30965b)) {
            double d12 = this.f30965b;
            double d13 = d11 - d12;
            double d14 = d12 + (d13 / this.f30964a);
            this.f30965b = d14;
            this.f30966c += d13 * (d11 - d14);
        } else {
            this.f30965b = g(this.f30965b, d11);
            this.f30966c = Double.NaN;
        }
        this.f30967d = Math.min(this.f30967d, d11);
        this.f30968e = Math.max(this.f30968e, d11);
    }

    public void b(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            a(((Number) it.next()).doubleValue());
        }
    }

    public void c(Iterator it) {
        while (it.hasNext()) {
            a(((Number) it.next()).doubleValue());
        }
    }

    public void d(double... dArr) {
        for (double d11 : dArr) {
            a(d11);
        }
    }

    public void e(int... iArr) {
        for (int i11 : iArr) {
            a(i11);
        }
    }

    public void f(long... jArr) {
        for (long j11 : jArr) {
            a(j11);
        }
    }

    public Stats h() {
        return new Stats(this.f30964a, this.f30965b, this.f30966c, this.f30967d, this.f30968e);
    }
}
