package com.squareup.okhttp.internal.framed;

import java.util.Arrays;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private int f40471a;

    /* renamed from: b, reason: collision with root package name */
    private int f40472b;

    /* renamed from: c, reason: collision with root package name */
    private int f40473c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f40474d = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f40473c = 0;
        this.f40472b = 0;
        this.f40471a = 0;
        Arrays.fill(this.f40474d, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i11) {
        int i12 = h(i11) ? 2 : 0;
        return k(i11) ? i12 | 1 : i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i11) {
        return this.f40474d[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if ((this.f40471a & 2) != 0) {
            return this.f40474d[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(int i11) {
        return (this.f40471a & 128) != 0 ? this.f40474d[7] : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i11) {
        return (this.f40471a & 16) != 0 ? this.f40474d[4] : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(int i11) {
        return (this.f40471a & 32) != 0 ? this.f40474d[5] : i11;
    }

    boolean h(int i11) {
        return ((1 << i11) & this.f40473c) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i11) {
        return ((1 << i11) & this.f40471a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(h hVar) {
        for (int i11 = 0; i11 < 10; i11++) {
            if (hVar.i(i11)) {
                l(i11, hVar.b(i11), hVar.c(i11));
            }
        }
    }

    boolean k(int i11) {
        return ((1 << i11) & this.f40472b) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h l(int i11, int i12, int i13) {
        int[] iArr = this.f40474d;
        if (i11 >= iArr.length) {
            return this;
        }
        int i14 = 1 << i11;
        this.f40471a |= i14;
        if ((i12 & 1) != 0) {
            this.f40472b |= i14;
        } else {
            this.f40472b &= ~i14;
        }
        if ((i12 & 2) != 0) {
            this.f40473c |= i14;
        } else {
            this.f40473c &= ~i14;
        }
        iArr[i11] = i13;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return Integer.bitCount(this.f40471a);
    }
}
