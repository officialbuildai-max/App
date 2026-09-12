package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class InputSubstream extends SdkFilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private long f18708a;

    /* renamed from: b, reason: collision with root package name */
    private final long f18709b;

    /* renamed from: c, reason: collision with root package name */
    private final long f18710c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f18711d;

    /* renamed from: e, reason: collision with root package name */
    private long f18712e;

    public InputSubstream(InputStream inputStream, long j11, long j12, boolean z10) {
        super(inputStream);
        this.f18712e = 0L;
        this.f18708a = 0L;
        this.f18710c = j12;
        this.f18709b = j11;
        this.f18711d = z10;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() {
        long j11 = this.f18708a;
        long j12 = this.f18709b;
        return (int) Math.min(j11 < j12 ? this.f18710c : (this.f18710c + j12) - j11, super.available());
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18711d) {
            super.close();
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i11) {
        this.f18712e = this.f18708a;
        super.mark(i11);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        return read == -1 ? read : bArr[0];
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        long j11;
        long j12;
        while (true) {
            j11 = this.f18708a;
            j12 = this.f18709b;
            if (j11 >= j12) {
                break;
            }
            this.f18708a += super.skip(j12 - j11);
        }
        long j13 = (this.f18710c + j12) - j11;
        if (j13 <= 0) {
            return -1;
        }
        int read = super.read(bArr, i11, (int) Math.min(i12, j13));
        this.f18708a += read;
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        this.f18708a = this.f18712e;
        super.reset();
    }
}
