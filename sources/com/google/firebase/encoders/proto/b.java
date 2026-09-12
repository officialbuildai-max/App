package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* loaded from: classes4.dex */
final class b extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private long f31875a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.f31875a;
    }

    @Override // java.io.OutputStream
    public void write(int i11) {
        this.f31875a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f31875a += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) {
        int i13;
        if (i11 < 0 || i11 > bArr.length || i12 < 0 || (i13 = i11 + i12) > bArr.length || i13 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f31875a += i12;
    }
}
