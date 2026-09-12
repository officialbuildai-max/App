package com.mbridge.msdk.thrid.okhttp.internal.http2;

import java.util.Arrays;
import okhttp3.internal.http2.Settings;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private int f38271a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f38272b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i11) {
        return this.f38272b[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m a(int i11, int i12) {
        if (i11 >= 0) {
            int[] iArr = this.f38272b;
            if (i11 < iArr.length) {
                this.f38271a = (1 << i11) | this.f38271a;
                iArr[i11] = i12;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f38271a = 0;
        Arrays.fill(this.f38272b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(m mVar) {
        for (int i11 = 0; i11 < 10; i11++) {
            if (mVar.d(i11)) {
                a(i11, mVar.a(i11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        if ((this.f38271a & 2) != 0) {
            return this.f38272b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i11) {
        return (this.f38271a & 16) != 0 ? this.f38272b[4] : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return (this.f38271a & 128) != 0 ? this.f38272b[7] : Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i11) {
        return (this.f38271a & 32) != 0 ? this.f38272b[5] : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return Integer.bitCount(this.f38271a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i11) {
        return ((1 << i11) & this.f38271a) != 0;
    }
}
