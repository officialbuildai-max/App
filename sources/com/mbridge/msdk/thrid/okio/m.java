package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    public final c f38511a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final r f38512b;

    /* renamed from: c, reason: collision with root package name */
    boolean f38513c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f38512b = rVar;
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public c a() {
        return this.f38511a;
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d a(long j11) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        this.f38511a.a(j11);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d a(String str) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        this.f38511a.a(str);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public void a(c cVar, long j11) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        this.f38511a.a(cVar, j11);
        d();
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public t b() {
        return this.f38512b.b();
    }

    @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f38513c) {
            return;
        }
        try {
            c cVar = this.f38511a;
            long j11 = cVar.f38486b;
            if (j11 > 0) {
                this.f38512b.a(cVar, j11);
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f38512b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f38513c = true;
        if (th != null) {
            u.a(th);
        }
    }

    public d d() throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        long m11 = this.f38511a.m();
        if (m11 > 0) {
            this.f38512b.a(this.f38511a, m11);
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.d, com.mbridge.msdk.thrid.okio.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f38511a;
        long j11 = cVar.f38486b;
        if (j11 > 0) {
            this.f38512b.a(cVar, j11);
        }
        this.f38512b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f38513c;
    }

    public String toString() {
        return "buffer(" + this.f38512b + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        int write = this.f38511a.write(byteBuffer);
        d();
        return write;
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d write(byte[] bArr) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        this.f38511a.write(bArr);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d write(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        this.f38511a.write(bArr, i11, i12);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d writeByte(int i11) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        this.f38511a.writeByte(i11);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d writeInt(int i11) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        this.f38511a.writeInt(i11);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d writeShort(int i11) throws IOException {
        if (this.f38513c) {
            throw new IllegalStateException("closed");
        }
        this.f38511a.writeShort(i11);
        return d();
    }
}
