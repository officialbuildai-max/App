package com.transsion.transfer.androidasync.http.server;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.t;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class p extends t {

    /* renamed from: g, reason: collision with root package name */
    private byte[] f55613g;

    /* renamed from: h, reason: collision with root package name */
    int f55614h = 2;

    @Override // com.transsion.transfer.androidasync.t, bv.d
    public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
        if (this.f55614h > 0) {
            ByteBuffer t11 = ByteBufferList.t(this.f55613g.length);
            t11.put(this.f55613g, 0, this.f55614h);
            t11.flip();
            byteBufferList.c(t11);
            this.f55614h = 0;
        }
        int C = byteBufferList.C();
        byte[] bArr = new byte[C];
        byteBufferList.h(bArr);
        int i11 = 0;
        int i12 = 0;
        while (i11 < C) {
            int i13 = this.f55614h;
            if (i13 >= 0) {
                byte b11 = bArr[i11];
                byte[] bArr2 = this.f55613g;
                if (b11 == bArr2[i13]) {
                    int i14 = i13 + 1;
                    this.f55614h = i14;
                    if (i14 == bArr2.length) {
                        this.f55614h = -1;
                    }
                } else if (i13 > 0) {
                    i11 -= i13;
                    this.f55614h = 0;
                }
            } else if (i13 == -1) {
                byte b12 = bArr[i11];
                if (b12 == 13) {
                    this.f55614h = -4;
                    int length = (i11 - i12) - this.f55613g.length;
                    if (i12 != 0 || length != 0) {
                        ByteBuffer put = ByteBufferList.t(length).put(bArr, i12, length);
                        put.flip();
                        ByteBufferList byteBufferList2 = new ByteBufferList();
                        byteBufferList2.a(put);
                        super.F(this, byteBufferList2);
                    }
                    S();
                } else {
                    if (b12 != 45) {
                        M(new MimeEncodingException("Invalid multipart/form-data. Expected \r or -"));
                        return;
                    }
                    this.f55614h = -2;
                }
            } else if (i13 == -2) {
                if (bArr[i11] != 45) {
                    M(new MimeEncodingException("Invalid multipart/form-data. Expected -"));
                    return;
                }
                this.f55614h = -3;
            } else if (i13 == -3) {
                if (bArr[i11] != 13) {
                    M(new MimeEncodingException("Invalid multipart/form-data. Expected \r"));
                    return;
                }
                this.f55614h = -4;
                int i15 = i11 - i12;
                ByteBuffer put2 = ByteBufferList.t((i15 - this.f55613g.length) - 2).put(bArr, i12, (i15 - this.f55613g.length) - 2);
                put2.flip();
                ByteBufferList byteBufferList3 = new ByteBufferList();
                byteBufferList3.a(put2);
                super.F(this, byteBufferList3);
                R();
            } else if (i13 != -4) {
                M(new MimeEncodingException("Invalid multipart/form-data. Unknown state?"));
            } else if (bArr[i11] == 10) {
                i12 = i11 + 1;
                this.f55614h = 0;
            } else {
                M(new MimeEncodingException("Invalid multipart/form-data. Expected \n"));
            }
            i11++;
        }
        if (i12 < C) {
            int max = (C - i12) - Math.max(this.f55614h, 0);
            ByteBuffer put3 = ByteBufferList.t(max).put(bArr, i12, max);
            put3.flip();
            ByteBufferList byteBufferList4 = new ByteBufferList();
            byteBufferList4.a(put3);
            super.F(this, byteBufferList4);
        }
    }

    public String O() {
        byte[] bArr = this.f55613g;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, 4, bArr.length - 4);
    }

    public String P() {
        return Q() + "--\r\n";
    }

    public String Q() {
        byte[] bArr = this.f55613g;
        return new String(bArr, 2, bArr.length - 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R() {
    }

    protected void S() {
    }

    public void T(String str) {
        this.f55613g = ("\r\n--" + str).getBytes();
    }
}
