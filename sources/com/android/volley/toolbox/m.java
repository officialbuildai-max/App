package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
public class m extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayPool f19391a;

    public m(ByteArrayPool byteArrayPool, int i11) {
        this.f19391a = byteArrayPool;
        ((ByteArrayOutputStream) this).buf = byteArrayPool.a(Math.max(i11, 256));
    }

    private void b(int i11) {
        int i12 = ((ByteArrayOutputStream) this).count;
        if (i12 + i11 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] a11 = this.f19391a.a((i12 + i11) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a11, 0, ((ByteArrayOutputStream) this).count);
        this.f19391a.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = a11;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19391a.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f19391a.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i11) {
        b(1);
        super.write(i11);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i11, int i12) {
        b(i12);
        super.write(bArr, i11, i12);
    }
}
