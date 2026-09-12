package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class LengthCheckInputStream extends SdkFilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final long f19078a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f19079b;

    /* renamed from: c, reason: collision with root package name */
    private long f19080c;

    /* renamed from: d, reason: collision with root package name */
    private long f19081d;

    public LengthCheckInputStream(InputStream inputStream, long j11, boolean z10) {
        super(inputStream);
        if (j11 < 0) {
            throw new IllegalArgumentException();
        }
        this.f19078a = j11;
        this.f19079b = z10;
    }

    private void l(boolean z10) {
        if (z10) {
            if (this.f19080c == this.f19078a) {
                return;
            }
            throw new AmazonClientException("Data read (" + this.f19080c + ") has a different length than the expected (" + this.f19078a + ")");
        }
        if (this.f19080c <= this.f19078a) {
            return;
        }
        throw new AmazonClientException("More data read (" + this.f19080c + ") than expected (" + this.f19078a + ")");
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i11) {
        super.mark(i11);
        this.f19081d = this.f19080c;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read >= 0) {
            this.f19080c++;
        }
        l(read == -1);
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        int read = super.read(bArr, i11, i12);
        this.f19080c += read >= 0 ? read : 0L;
        l(read == -1);
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        if (super.markSupported()) {
            this.f19080c = this.f19081d;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j11) {
        long skip = super.skip(j11);
        if (this.f19079b && skip > 0) {
            this.f19080c += skip;
            l(false);
        }
        return skip;
    }
}
