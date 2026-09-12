package com.google.android.exoplayer2.mediacodec;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private int f25441a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f25442b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f25443c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int[] f25444d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    private int f25445e;

    public k() {
        this.f25445e = r0.length - 1;
    }

    private void c() {
        int[] iArr = this.f25444d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i11 = this.f25441a;
        int i12 = length2 - i11;
        System.arraycopy(iArr, i11, iArr2, 0, i12);
        System.arraycopy(this.f25444d, 0, iArr2, i12, i11);
        this.f25441a = 0;
        this.f25442b = this.f25443c - 1;
        this.f25444d = iArr2;
        this.f25445e = iArr2.length - 1;
    }

    public void a(int i11) {
        if (this.f25443c == this.f25444d.length) {
            c();
        }
        int i12 = (this.f25442b + 1) & this.f25445e;
        this.f25442b = i12;
        this.f25444d[i12] = i11;
        this.f25443c++;
    }

    public void b() {
        this.f25441a = 0;
        this.f25442b = -1;
        this.f25443c = 0;
    }

    public boolean d() {
        return this.f25443c == 0;
    }

    public int e() {
        int i11 = this.f25443c;
        if (i11 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f25444d;
        int i12 = this.f25441a;
        int i13 = iArr[i12];
        this.f25441a = (i12 + 1) & this.f25445e;
        this.f25443c = i11 - 1;
        return i13;
    }
}
