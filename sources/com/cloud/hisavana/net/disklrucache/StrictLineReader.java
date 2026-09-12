package com.cloud.hisavana.net.disklrucache;

import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
class StrictLineReader implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f21474a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f21475b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f21476c;

    /* renamed from: d, reason: collision with root package name */
    private int f21477d;

    /* renamed from: e, reason: collision with root package name */
    private int f21478e;

    public StrictLineReader(InputStream inputStream, int i11, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(DiskLruCacheUtil.f21490a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f21474a = inputStream;
        this.f21475b = charset;
        this.f21476c = new byte[i11];
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void d() {
        InputStream inputStream = this.f21474a;
        byte[] bArr = this.f21476c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f21477d = 0;
        this.f21478e = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f21474a) {
            try {
                if (this.f21476c != null) {
                    this.f21476c = null;
                    this.f21474a.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean h() {
        return this.f21478e == -1;
    }

    public String k() {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f21474a) {
            try {
                if (this.f21476c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f21477d >= this.f21478e) {
                    d();
                }
                for (int i13 = this.f21477d; i13 != this.f21478e; i13++) {
                    byte[] bArr2 = this.f21476c;
                    if (bArr2[i13] == 10) {
                        int i14 = this.f21477d;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] == 13) {
                                String str = new String(bArr2, i14, i12 - i14, this.f21475b.name());
                                this.f21477d = i13 + 1;
                                return str;
                            }
                        }
                        i12 = i13;
                        String str2 = new String(bArr2, i14, i12 - i14, this.f21475b.name());
                        this.f21477d = i13 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f21478e - this.f21477d) + 80) { // from class: com.cloud.hisavana.net.disklrucache.StrictLineReader.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i15 = ((ByteArrayOutputStream) this).count;
                        if (i15 > 0 && ((ByteArrayOutputStream) this).buf[i15 - 1] == 13) {
                            i15--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i15, StrictLineReader.this.f21475b.name());
                        } catch (UnsupportedEncodingException e11) {
                            throw new AssertionError(e11);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.f21476c;
                    int i15 = this.f21477d;
                    byteArrayOutputStream.write(bArr3, i15, this.f21478e - i15);
                    this.f21478e = -1;
                    d();
                    i11 = this.f21477d;
                    while (i11 != this.f21478e) {
                        bArr = this.f21476c;
                        if (bArr[i11] == 10) {
                            break loop1;
                        }
                        i11++;
                    }
                }
                int i16 = this.f21477d;
                if (i11 != i16) {
                    byteArrayOutputStream.write(bArr, i16, i11 - i16);
                }
                this.f21477d = i11 + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
