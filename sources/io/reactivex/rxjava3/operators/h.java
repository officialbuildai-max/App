package io.reactivex.rxjava3.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes7.dex */
public final class h implements f {

    /* renamed from: i, reason: collision with root package name */
    static final int f65680i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f65681j = new Object();

    /* renamed from: b, reason: collision with root package name */
    int f65683b;

    /* renamed from: c, reason: collision with root package name */
    long f65684c;

    /* renamed from: d, reason: collision with root package name */
    final int f65685d;

    /* renamed from: e, reason: collision with root package name */
    AtomicReferenceArray f65686e;

    /* renamed from: f, reason: collision with root package name */
    final int f65687f;

    /* renamed from: g, reason: collision with root package name */
    AtomicReferenceArray f65688g;

    /* renamed from: a, reason: collision with root package name */
    final AtomicLong f65682a = new AtomicLong();

    /* renamed from: h, reason: collision with root package name */
    final AtomicLong f65689h = new AtomicLong();

    public h(int i11) {
        int a11 = io.reactivex.rxjava3.internal.util.g.a(Math.max(8, i11));
        int i12 = a11 - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(a11 + 1);
        this.f65686e = atomicReferenceArray;
        this.f65685d = i12;
        a(a11);
        this.f65688g = atomicReferenceArray;
        this.f65687f = i12;
        this.f65684c = a11 - 2;
        o(0L);
    }

    private void a(int i11) {
        this.f65683b = Math.min(i11 / 4, f65680i);
    }

    private static int b(int i11) {
        return i11;
    }

    private static int c(long j11, int i11) {
        return b(((int) j11) & i11);
    }

    private long d() {
        return this.f65689h.get();
    }

    private long e() {
        return this.f65682a.get();
    }

    private long f() {
        return this.f65689h.get();
    }

    private static Object g(AtomicReferenceArray atomicReferenceArray, int i11) {
        return atomicReferenceArray.get(i11);
    }

    private AtomicReferenceArray h(AtomicReferenceArray atomicReferenceArray, int i11) {
        int b11 = b(i11);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b11);
        m(atomicReferenceArray, b11, null);
        return atomicReferenceArray2;
    }

    private long i() {
        return this.f65682a.get();
    }

    private Object j(AtomicReferenceArray atomicReferenceArray, long j11, int i11) {
        this.f65688g = atomicReferenceArray;
        int c11 = c(j11, i11);
        Object g11 = g(atomicReferenceArray, c11);
        if (g11 != null) {
            m(atomicReferenceArray, c11, null);
            l(j11 + 1);
        }
        return g11;
    }

    private void k(AtomicReferenceArray atomicReferenceArray, long j11, int i11, Object obj, long j12) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f65686e = atomicReferenceArray2;
        this.f65684c = (j12 + j11) - 1;
        m(atomicReferenceArray2, i11, obj);
        n(atomicReferenceArray, atomicReferenceArray2);
        m(atomicReferenceArray, i11, f65681j);
        o(j11 + 1);
    }

    private void l(long j11) {
        this.f65689h.lazySet(j11);
    }

    private static void m(AtomicReferenceArray atomicReferenceArray, int i11, Object obj) {
        atomicReferenceArray.lazySet(i11, obj);
    }

    private void n(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        m(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void o(long j11) {
        this.f65682a.lazySet(j11);
    }

    private boolean p(AtomicReferenceArray atomicReferenceArray, Object obj, long j11, int i11) {
        m(atomicReferenceArray, i11, obj);
        o(j11 + 1);
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean isEmpty() {
        return i() == f();
    }

    @Override // io.reactivex.rxjava3.operators.g
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f65686e;
        long e11 = e();
        int i11 = this.f65685d;
        int c11 = c(e11, i11);
        if (e11 < this.f65684c) {
            return p(atomicReferenceArray, obj, e11, c11);
        }
        long j11 = this.f65683b + e11;
        if (g(atomicReferenceArray, c(j11, i11)) == null) {
            this.f65684c = j11 - 1;
            return p(atomicReferenceArray, obj, e11, c11);
        }
        if (g(atomicReferenceArray, c(1 + e11, i11)) == null) {
            return p(atomicReferenceArray, obj, e11, c11);
        }
        k(atomicReferenceArray, e11, c11, obj, i11);
        return true;
    }

    @Override // io.reactivex.rxjava3.operators.f, io.reactivex.rxjava3.operators.g
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f65688g;
        long d11 = d();
        int i11 = this.f65687f;
        int c11 = c(d11, i11);
        Object g11 = g(atomicReferenceArray, c11);
        boolean z10 = g11 == f65681j;
        if (g11 == null || z10) {
            if (z10) {
                return j(h(atomicReferenceArray, i11 + 1), d11, i11);
            }
            return null;
        }
        m(atomicReferenceArray, c11, null);
        l(d11 + 1);
        return g11;
    }
}
