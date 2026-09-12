package androidx.media3.common.util;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    private long[] f10514a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f10515b;

    /* renamed from: c, reason: collision with root package name */
    private int f10516c;

    /* renamed from: d, reason: collision with root package name */
    private int f10517d;

    public o0() {
        this(10);
    }

    public o0(int i11) {
        this.f10514a = new long[i11];
        this.f10515b = f(i11);
    }

    private void b(long j11, Object obj) {
        int i11 = this.f10516c;
        int i12 = this.f10517d;
        Object[] objArr = this.f10515b;
        int length = (i11 + i12) % objArr.length;
        this.f10514a[length] = j11;
        objArr[length] = obj;
        this.f10517d = i12 + 1;
    }

    private void d(long j11) {
        if (this.f10517d > 0) {
            if (j11 <= this.f10514a[((this.f10516c + r0) - 1) % this.f10515b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f10515b.length;
        if (this.f10517d < length) {
            return;
        }
        int i11 = length * 2;
        long[] jArr = new long[i11];
        Object[] f11 = f(i11);
        int i12 = this.f10516c;
        int i13 = length - i12;
        System.arraycopy(this.f10514a, i12, jArr, 0, i13);
        System.arraycopy(this.f10515b, this.f10516c, f11, 0, i13);
        int i14 = this.f10516c;
        if (i14 > 0) {
            System.arraycopy(this.f10514a, 0, jArr, i13, i14);
            System.arraycopy(this.f10515b, 0, f11, i13, this.f10516c);
        }
        this.f10514a = jArr;
        this.f10515b = f11;
        this.f10516c = 0;
    }

    private static Object[] f(int i11) {
        return new Object[i11];
    }

    private Object h(long j11, boolean z10) {
        Object obj = null;
        long j12 = Long.MAX_VALUE;
        while (this.f10517d > 0) {
            long j13 = j11 - this.f10514a[this.f10516c];
            if (j13 < 0 && (z10 || (-j13) >= j12)) {
                break;
            }
            obj = k();
            j12 = j13;
        }
        return obj;
    }

    private Object k() {
        a.g(this.f10517d > 0);
        Object[] objArr = this.f10515b;
        int i11 = this.f10516c;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f10516c = (i11 + 1) % objArr.length;
        this.f10517d--;
        return obj;
    }

    public synchronized void a(long j11, Object obj) {
        d(j11);
        e();
        b(j11, obj);
    }

    public synchronized void c() {
        this.f10516c = 0;
        this.f10517d = 0;
        Arrays.fill(this.f10515b, (Object) null);
    }

    public synchronized Object g(long j11) {
        return h(j11, false);
    }

    public synchronized Object i() {
        return this.f10517d == 0 ? null : k();
    }

    public synchronized Object j(long j11) {
        return h(j11, true);
    }

    public synchronized int l() {
        return this.f10517d;
    }
}
