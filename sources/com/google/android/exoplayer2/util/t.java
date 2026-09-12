package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private int f27712a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f27713b;

    public t() {
        this(32);
    }

    public t(int i11) {
        this.f27713b = new long[i11];
    }

    public void a(long j11) {
        int i11 = this.f27712a;
        long[] jArr = this.f27713b;
        if (i11 == jArr.length) {
            this.f27713b = Arrays.copyOf(jArr, i11 * 2);
        }
        long[] jArr2 = this.f27713b;
        int i12 = this.f27712a;
        this.f27712a = i12 + 1;
        jArr2[i12] = j11;
    }

    public long b(int i11) {
        if (i11 >= 0 && i11 < this.f27712a) {
            return this.f27713b[i11];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i11 + ", size is " + this.f27712a);
    }

    public int c() {
        return this.f27712a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f27713b, this.f27712a);
    }
}
