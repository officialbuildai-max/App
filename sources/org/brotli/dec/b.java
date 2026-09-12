package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class b extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f71744a;

    /* renamed from: b, reason: collision with root package name */
    private int f71745b;

    /* renamed from: c, reason: collision with root package name */
    private int f71746c;

    /* renamed from: d, reason: collision with root package name */
    private final j f71747d;

    public b(InputStream inputStream) {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i11, byte[] bArr) {
        j jVar = new j();
        this.f71747d = jVar;
        if (i11 <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i11);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.f71744a = new byte[i11];
        this.f71745b = 0;
        this.f71746c = 0;
        try {
            j.c(jVar, inputStream);
            if (bArr != null) {
                d.s(jVar, bArr);
            }
        } catch (BrotliRuntimeException e11) {
            throw new IOException("Brotli decoder initialization failed", e11);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        j.a(this.f71747d);
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f71746c >= this.f71745b) {
            byte[] bArr = this.f71744a;
            int read = read(bArr, 0, bArr.length);
            this.f71745b = read;
            this.f71746c = 0;
            if (read == -1) {
                return -1;
            }
        }
        byte[] bArr2 = this.f71744a;
        int i11 = this.f71746c;
        this.f71746c = i11 + 1;
        return bArr2[i11] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Bad offset: " + i11);
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("Bad length: " + i12);
        }
        int i13 = i11 + i12;
        if (i13 > bArr.length) {
            throw new IllegalArgumentException("Buffer overflow: " + i13 + " > " + bArr.length);
        }
        if (i12 == 0) {
            return 0;
        }
        int max = Math.max(this.f71745b - this.f71746c, 0);
        if (max != 0) {
            max = Math.min(max, i12);
            System.arraycopy(this.f71744a, this.f71746c, bArr, i11, max);
            this.f71746c += max;
            i11 += max;
            i12 -= max;
            if (i12 == 0) {
                return max;
            }
        }
        try {
            j jVar = this.f71747d;
            jVar.Z = bArr;
            jVar.U = i11;
            jVar.V = i12;
            jVar.W = 0;
            d.i(jVar);
            int i14 = this.f71747d.W;
            if (i14 == 0) {
                return -1;
            }
            return i14 + max;
        } catch (BrotliRuntimeException e11) {
            throw new IOException("Brotli stream decoding failed", e11);
        }
    }
}
