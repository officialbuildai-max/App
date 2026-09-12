package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes7.dex */
public class n extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private Reader f71720a;

    /* renamed from: b, reason: collision with root package name */
    private String f71721b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f71722c;

    /* renamed from: d, reason: collision with root package name */
    private int f71723d;

    public n(Reader reader) {
        this.f71721b = System.getProperty("file.encoding");
        this.f71720a = reader;
    }

    public n(Reader reader, String str) {
        this(reader);
        if (str == null) {
            throw new IllegalArgumentException("encoding must not be null");
        }
        this.f71721b = str;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        Reader reader = this.f71720a;
        if (reader == null) {
            throw new IOException("Stream Closed");
        }
        byte[] bArr = this.f71722c;
        if (bArr != null) {
            return bArr.length - this.f71723d;
        }
        return reader.ready() ? 1 : 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Reader reader = this.f71720a;
        if (reader != null) {
            reader.close();
            this.f71722c = null;
            this.f71720a = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i11) {
        try {
            this.f71720a.mark(i11);
        } catch (IOException e11) {
            throw new RuntimeException(e11.getMessage());
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        byte b11;
        int i11;
        try {
            if (this.f71720a == null) {
                throw new IOException("Stream Closed");
            }
            byte[] bArr = this.f71722c;
            if (bArr == null || (i11 = this.f71723d) >= bArr.length) {
                byte[] bArr2 = new byte[1];
                if (read(bArr2, 0, 1) <= 0) {
                    return -1;
                }
                b11 = bArr2[0];
            } else {
                b11 = bArr[i11];
                int i12 = i11 + 1;
                this.f71723d = i12;
                if (i12 == bArr.length) {
                    this.f71722c = null;
                }
            }
            return b11 & 255;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i11, int i12) {
        try {
            if (this.f71720a == null) {
                throw new IOException("Stream Closed");
            }
            if (i12 == 0) {
                return 0;
            }
            while (true) {
                byte[] bArr2 = this.f71722c;
                if (bArr2 != null) {
                    int length = bArr2.length;
                    int i13 = this.f71723d;
                    if (i12 > length - i13) {
                        i12 = bArr2.length - i13;
                    }
                    System.arraycopy(bArr2, i13, bArr, i11, i12);
                    int i14 = this.f71723d + i12;
                    this.f71723d = i14;
                    if (i14 >= this.f71722c.length) {
                        this.f71722c = null;
                    }
                    return i12;
                }
                char[] cArr = new char[i12];
                int read = this.f71720a.read(cArr);
                if (read == -1) {
                    return -1;
                }
                if (read > 0) {
                    this.f71722c = new String(cArr, 0, read).getBytes(this.f71721b);
                    this.f71723d = 0;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        Reader reader = this.f71720a;
        if (reader == null) {
            throw new IOException("Stream Closed");
        }
        this.f71722c = null;
        reader.reset();
    }
}
