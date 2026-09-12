package com.amazonaws.auth;

/* loaded from: classes2.dex */
class ChunkContentIterator {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f18437a;

    /* renamed from: b, reason: collision with root package name */
    private int f18438b;

    public ChunkContentIterator(byte[] bArr) {
        this.f18437a = bArr;
    }

    public boolean a() {
        return this.f18438b < this.f18437a.length;
    }

    public int b(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (!a()) {
            return -1;
        }
        int min = Math.min(this.f18437a.length - this.f18438b, i12);
        System.arraycopy(this.f18437a, this.f18438b, bArr, i11, min);
        this.f18438b += min;
        return min;
    }
}
