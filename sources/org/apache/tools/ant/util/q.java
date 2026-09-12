package org.apache.tools.ant.util;

import java.io.OutputStream;

/* loaded from: classes7.dex */
public class q extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private OutputStream f71727a;

    /* renamed from: b, reason: collision with root package name */
    private OutputStream f71728b;

    public q(OutputStream outputStream, OutputStream outputStream2) {
        this.f71727a = outputStream;
        this.f71728b = outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f71727a.close();
        } finally {
            this.f71728b.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f71727a.flush();
        this.f71728b.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i11) {
        this.f71727a.write(i11);
        this.f71728b.write(i11);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f71727a.write(bArr);
        this.f71728b.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) {
        this.f71727a.write(bArr, i11, i12);
        this.f71728b.write(bArr, i11, i12);
    }
}
