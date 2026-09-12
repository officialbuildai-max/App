package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class n implements e {

    /* renamed from: a, reason: collision with root package name */
    public final c f38514a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final s f38515b;

    /* renamed from: c, reason: collision with root package name */
    boolean f38516c;

    /* loaded from: classes5.dex */
    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            n nVar = n.this;
            if (nVar.f38516c) {
                throw new IOException("closed");
            }
            return (int) Math.min(nVar.f38514a.f38486b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            n.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            n nVar = n.this;
            if (nVar.f38516c) {
                throw new IOException("closed");
            }
            c cVar = nVar.f38514a;
            if (cVar.f38486b == 0 && nVar.f38515b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return n.this.f38514a.readByte() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            if (n.this.f38516c) {
                throw new IOException("closed");
            }
            u.a(bArr.length, i11, i12);
            n nVar = n.this;
            c cVar = nVar.f38514a;
            if (cVar.f38486b == 0 && nVar.f38515b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return n.this.f38514a.read(bArr, i11, i12);
        }

        public String toString() {
            return n.this + ".inputStream()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f38515b = sVar;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public long a(byte b11) throws IOException {
        return a(b11, 0L, Long.MAX_VALUE);
    }

    public long a(byte b11, long j11, long j12) throws IOException {
        if (this.f38516c) {
            throw new IllegalStateException("closed");
        }
        if (j11 < 0 || j12 < j11) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j11), Long.valueOf(j12)));
        }
        while (j11 < j12) {
            long a11 = this.f38514a.a(b11, j11, j12);
            if (a11 == -1) {
                c cVar = this.f38514a;
                long j13 = cVar.f38486b;
                if (j13 >= j12 || this.f38515b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    break;
                }
                j11 = Math.max(j11, j13);
            } else {
                return a11;
            }
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.e, com.mbridge.msdk.thrid.okio.d
    public c a() {
        return this.f38514a;
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public long b(c cVar, long j11) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        if (this.f38516c) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.f38514a;
        if (cVar2.f38486b == 0 && this.f38515b.b(cVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.f38514a.b(cVar, Math.min(j11, this.f38514a.f38486b));
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public f b(long j11) throws IOException {
        e(j11);
        return this.f38514a.b(j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public t b() {
        return this.f38515b.b();
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public String c() throws IOException {
        return d(Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public byte[] c(long j11) throws IOException {
        e(j11);
        return this.f38514a.c(j11);
    }

    @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f38516c) {
            return;
        }
        this.f38516c = true;
        this.f38515b.close();
        this.f38514a.k();
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public String d(long j11) throws IOException {
        if (j11 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j11);
        }
        long j12 = j11 == Long.MAX_VALUE ? Long.MAX_VALUE : j11 + 1;
        long a11 = a((byte) 10, 0L, j12);
        if (a11 != -1) {
            return this.f38514a.h(a11);
        }
        if (j12 < Long.MAX_VALUE && f(j12) && this.f38514a.f(j12 - 1) == 13 && f(1 + j12) && this.f38514a.f(j12) == 10) {
            return this.f38514a.h(j12);
        }
        c cVar = new c();
        c cVar2 = this.f38514a;
        cVar2.a(cVar, 0L, Math.min(32L, cVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f38514a.size(), j11) + " content=" + cVar.o().b() + (char) 8230);
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public int e() throws IOException {
        e(4L);
        return this.f38514a.e();
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void e(long j11) throws IOException {
        if (!f(j11)) {
            throw new EOFException();
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public boolean f() throws IOException {
        if (this.f38516c) {
            throw new IllegalStateException("closed");
        }
        return this.f38514a.f() && this.f38515b.b(this.f38514a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    public boolean f(long j11) throws IOException {
        c cVar;
        if (j11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j11);
        }
        if (this.f38516c) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.f38514a;
            if (cVar.f38486b >= j11) {
                return true;
            }
        } while (this.f38515b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public short g() throws IOException {
        e(2L);
        return this.f38514a.g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r2 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r4)));
     */
    @Override // com.mbridge.msdk.thrid.okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long i() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 1
            r1 = 1
            r7.e(r1)
            r1 = 0
            r2 = r1
        L8:
            int r3 = r2 + 1
            long r4 = (long) r3
            boolean r4 = r7.f(r4)
            if (r4 == 0) goto L4a
            com.mbridge.msdk.thrid.okio.c r4 = r7.f38514a
            long r5 = (long) r2
            byte r4 = r4.f(r5)
            r5 = 48
            if (r4 < r5) goto L20
            r5 = 57
            if (r4 <= r5) goto L31
        L20:
            r5 = 97
            if (r4 < r5) goto L28
            r5 = 102(0x66, float:1.43E-43)
            if (r4 <= r5) goto L31
        L28:
            r5 = 65
            if (r4 < r5) goto L33
            r5 = 70
            if (r4 <= r5) goto L31
            goto L33
        L31:
            r2 = r3
            goto L8
        L33:
            if (r2 == 0) goto L36
            goto L4a
        L36:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.Byte r3 = java.lang.Byte.valueOf(r4)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r3
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r2.<init>(r0)
            throw r2
        L4a:
            com.mbridge.msdk.thrid.okio.c r0 = r7.f38514a
            long r0 = r0.i()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.n.i():long");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f38516c;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public InputStream j() {
        return new a();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f38514a;
        if (cVar.f38486b == 0 && this.f38515b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f38514a.read(byteBuffer);
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public byte readByte() throws IOException {
        e(1L);
        return this.f38514a.readByte();
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            e(bArr.length);
            this.f38514a.readFully(bArr);
        } catch (EOFException e11) {
            int i11 = 0;
            while (true) {
                c cVar = this.f38514a;
                long j11 = cVar.f38486b;
                if (j11 <= 0) {
                    throw e11;
                }
                int read = cVar.read(bArr, i11, (int) j11);
                if (read == -1) {
                    throw new AssertionError();
                }
                i11 += read;
            }
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public int readInt() throws IOException {
        e(4L);
        return this.f38514a.readInt();
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public short readShort() throws IOException {
        e(2L);
        return this.f38514a.readShort();
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void skip(long j11) throws IOException {
        if (this.f38516c) {
            throw new IllegalStateException("closed");
        }
        while (j11 > 0) {
            c cVar = this.f38514a;
            if (cVar.f38486b == 0 && this.f38515b.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j11, this.f38514a.size());
            this.f38514a.skip(min);
            j11 -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.f38515b + ")";
    }
}
