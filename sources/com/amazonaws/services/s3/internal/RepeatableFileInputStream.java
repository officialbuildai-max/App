package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class RepeatableFileInputStream extends SdkInputStream {

    /* renamed from: e, reason: collision with root package name */
    private static final Log f18736e = LogFactory.c("RepeatableFIS");

    /* renamed from: a, reason: collision with root package name */
    private final File f18737a;

    /* renamed from: b, reason: collision with root package name */
    private FileInputStream f18738b;

    /* renamed from: c, reason: collision with root package name */
    private long f18739c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f18740d = 0;

    public RepeatableFileInputStream(File file) {
        this.f18738b = null;
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        this.f18738b = new FileInputStream(file);
        this.f18737a = file;
    }

    @Override // java.io.InputStream
    public int available() {
        k();
        return this.f18738b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18738b.close();
        k();
    }

    @Override // com.amazonaws.internal.SdkInputStream
    public InputStream l() {
        return this.f18738b;
    }

    @Override // java.io.InputStream
    public void mark(int i11) {
        k();
        this.f18740d += this.f18739c;
        this.f18739c = 0L;
        Log log = f18736e;
        if (log.b()) {
            log.a("Input stream marked at " + this.f18740d + " bytes");
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        k();
        int read = this.f18738b.read();
        if (read == -1) {
            return -1;
        }
        this.f18739c++;
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        k();
        int read = this.f18738b.read(bArr, i11, i12);
        this.f18739c += read;
        return read;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f18738b.close();
        k();
        this.f18738b = new FileInputStream(this.f18737a);
        long j11 = this.f18740d;
        while (j11 > 0) {
            j11 -= this.f18738b.skip(j11);
        }
        Log log = f18736e;
        if (log.b()) {
            log.a("Reset to mark point " + this.f18740d + " after returning " + this.f18739c + " bytes");
        }
        this.f18739c = 0L;
    }

    @Override // java.io.InputStream
    public long skip(long j11) {
        k();
        long skip = this.f18738b.skip(j11);
        this.f18739c += skip;
        return skip;
    }
}
