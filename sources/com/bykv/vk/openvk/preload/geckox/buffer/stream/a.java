package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.buffer.a f20729a;

    /* renamed from: b, reason: collision with root package name */
    private long f20730b;

    public a(com.bykv.vk.openvk.preload.geckox.buffer.a aVar) {
        this.f20729a = aVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long b11 = this.f20729a.b() - this.f20729a.c();
        if (b11 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) b11;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i11) {
        this.f20730b = i11;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f20729a.d();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return this.f20729a.b(bArr);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f20729a.b(bArr, i11, i12);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.f20729a.b(this.f20730b);
    }

    @Override // java.io.InputStream
    public final long skip(long j11) throws IOException {
        return this.f20729a.a(j11);
    }
}
