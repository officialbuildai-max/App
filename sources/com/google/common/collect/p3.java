package com.google.common.collect;

import java.util.Arrays;

/* loaded from: classes4.dex */
class p3 extends o3 {

    /* renamed from: i, reason: collision with root package name */
    transient long[] f30898i;

    /* renamed from: j, reason: collision with root package name */
    private transient int f30899j;

    /* renamed from: k, reason: collision with root package name */
    private transient int f30900k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p3(int i11) {
        this(i11, 1.0f);
    }

    p3(int i11, float f11) {
        super(i11, f11);
    }

    private int E(int i11) {
        return (int) (this.f30898i[i11] >>> 32);
    }

    private int F(int i11) {
        return (int) this.f30898i[i11];
    }

    private void G(int i11, int i12) {
        long[] jArr = this.f30898i;
        jArr[i11] = (jArr[i11] & 4294967295L) | (i12 << 32);
    }

    private void H(int i11, int i12) {
        if (i11 == -2) {
            this.f30899j = i12;
        } else {
            I(i11, i12);
        }
        if (i12 == -2) {
            this.f30900k = i11;
        } else {
            G(i12, i11);
        }
    }

    private void I(int i11, int i12) {
        long[] jArr = this.f30898i;
        jArr[i11] = (jArr[i11] & (-4294967296L)) | (i12 & 4294967295L);
    }

    @Override // com.google.common.collect.o3
    public void a() {
        super.a();
        this.f30899j = -2;
        this.f30900k = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.o3
    public int e() {
        int i11 = this.f30899j;
        if (i11 == -2) {
            return -1;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.o3
    public void n(int i11, float f11) {
        super.n(i11, f11);
        this.f30899j = -2;
        this.f30900k = -2;
        long[] jArr = new long[i11];
        this.f30898i = jArr;
        Arrays.fill(jArr, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.o3
    public void o(int i11, Object obj, int i12, int i13) {
        super.o(i11, obj, i12, i13);
        H(this.f30900k, i11);
        H(i11, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.o3
    public void p(int i11) {
        int C = C() - 1;
        H(E(i11), F(i11));
        if (i11 < C) {
            H(E(C), i11);
            H(i11, F(C));
        }
        super.p(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.o3
    public int s(int i11) {
        int F = F(i11);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.o3
    public int t(int i11, int i12) {
        return i11 == C() ? i12 : i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.o3
    public void y(int i11) {
        super.y(i11);
        long[] jArr = this.f30898i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i11);
        this.f30898i = copyOf;
        Arrays.fill(copyOf, length, i11, -1L);
    }
}
