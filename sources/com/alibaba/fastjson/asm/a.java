package com.alibaba.fastjson.asm;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f18153a;

    /* renamed from: b, reason: collision with root package name */
    public int f18154b;

    public a() {
        this.f18153a = new byte[64];
    }

    public a(int i11) {
        this.f18153a = new byte[i11];
    }

    private void a(int i11) {
        byte[] bArr = this.f18153a;
        int length = bArr.length * 2;
        int i12 = this.f18154b;
        int i13 = i11 + i12;
        if (length <= i13) {
            length = i13;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i12);
        this.f18153a = bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b(int i11, int i12) {
        int i13 = this.f18154b;
        if (i13 + 2 > this.f18153a.length) {
            a(2);
        }
        byte[] bArr = this.f18153a;
        bArr[i13] = (byte) i11;
        bArr[i13 + 1] = (byte) i12;
        this.f18154b = i13 + 2;
        return this;
    }

    public a c(int i11, int i12) {
        int i13 = this.f18154b;
        if (i13 + 3 > this.f18153a.length) {
            a(3);
        }
        byte[] bArr = this.f18153a;
        bArr[i13] = (byte) i11;
        bArr[i13 + 1] = (byte) (i12 >>> 8);
        bArr[i13 + 2] = (byte) i12;
        this.f18154b = i13 + 3;
        return this;
    }

    public a d(int i11) {
        int i12 = this.f18154b;
        int i13 = i12 + 1;
        if (i13 > this.f18153a.length) {
            a(1);
        }
        this.f18153a[i12] = (byte) i11;
        this.f18154b = i13;
        return this;
    }

    public a e(byte[] bArr, int i11, int i12) {
        if (this.f18154b + i12 > this.f18153a.length) {
            a(i12);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i11, this.f18153a, this.f18154b, i12);
        }
        this.f18154b += i12;
        return this;
    }

    public a f(int i11) {
        int i12 = this.f18154b;
        if (i12 + 4 > this.f18153a.length) {
            a(4);
        }
        byte[] bArr = this.f18153a;
        bArr[i12] = (byte) (i11 >>> 24);
        bArr[i12 + 1] = (byte) (i11 >>> 16);
        bArr[i12 + 2] = (byte) (i11 >>> 8);
        bArr[i12 + 3] = (byte) i11;
        this.f18154b = i12 + 4;
        return this;
    }

    public a g(int i11) {
        int i12 = this.f18154b;
        if (i12 + 2 > this.f18153a.length) {
            a(2);
        }
        byte[] bArr = this.f18153a;
        bArr[i12] = (byte) (i11 >>> 8);
        bArr[i12 + 1] = (byte) i11;
        this.f18154b = i12 + 2;
        return this;
    }

    public a h(String str) {
        int length = str.length();
        int i11 = this.f18154b;
        if (i11 + 2 + length > this.f18153a.length) {
            a(length + 2);
        }
        byte[] bArr = this.f18153a;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (length >>> 8);
        int i13 = i11 + 2;
        bArr[i12] = (byte) length;
        int i14 = 0;
        while (i14 < length) {
            char charAt = str.charAt(i14);
            if ((charAt < 1 || charAt > 127) && (charAt < 19968 || charAt > 40959)) {
                throw new UnsupportedOperationException();
            }
            bArr[i13] = (byte) charAt;
            i14++;
            i13++;
        }
        this.f18154b = i13;
        return this;
    }
}
