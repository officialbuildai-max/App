package com.mbridge.msdk.tracker.network.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes5.dex */
public class n extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final c f38732a;

    public n(c cVar, int i11) {
        this.f38732a = cVar;
        ((ByteArrayOutputStream) this).buf = cVar.a(Math.max(i11, 256));
    }

    private void a(int i11) {
        int i12 = ((ByteArrayOutputStream) this).count + i11;
        if (i12 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] a11 = this.f38732a.a(i12 * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a11, 0, ((ByteArrayOutputStream) this).count);
        this.f38732a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = a11;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38732a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f38732a.a(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i11) {
        a(1);
        super.write(i11);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i11, int i12) {
        a(i12);
        if (bArr != null) {
            super.write(bArr, i11, i12);
        }
    }
}
