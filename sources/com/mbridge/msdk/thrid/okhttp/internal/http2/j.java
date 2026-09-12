package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.http2.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
final class j implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    private static final Logger f38256g = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okio.d f38257a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f38258b;

    /* renamed from: c, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okio.c f38259c;

    /* renamed from: d, reason: collision with root package name */
    private int f38260d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f38261e;

    /* renamed from: f, reason: collision with root package name */
    final d.b f38262f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.mbridge.msdk.thrid.okio.d dVar, boolean z10) {
        this.f38257a = dVar;
        this.f38258b = z10;
        com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
        this.f38259c = cVar;
        this.f38262f = new d.b(cVar);
        this.f38260d = 16384;
    }

    private static void a(com.mbridge.msdk.thrid.okio.d dVar, int i11) throws IOException {
        dVar.writeByte((i11 >>> 16) & 255);
        dVar.writeByte((i11 >>> 8) & 255);
        dVar.writeByte(i11 & 255);
    }

    private void b(int i11, long j11) throws IOException {
        while (j11 > 0) {
            int min = (int) Math.min(this.f38260d, j11);
            long j12 = min;
            j11 -= j12;
            a(i11, min, (byte) 9, j11 == 0 ? (byte) 4 : (byte) 0);
            this.f38257a.a(this.f38259c, j12);
        }
    }

    void a(int i11, byte b11, com.mbridge.msdk.thrid.okio.c cVar, int i12) throws IOException {
        a(i11, i12, (byte) 0, b11);
        if (i12 > 0) {
            this.f38257a.a(cVar, i12);
        }
    }

    public void a(int i11, int i12, byte b11, byte b12) throws IOException {
        Logger logger = f38256g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.a(false, i11, i12, b11, b12));
        }
        int i13 = this.f38260d;
        if (i12 > i13) {
            throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i13), Integer.valueOf(i12));
        }
        if ((Integer.MIN_VALUE & i11) != 0) {
            throw e.a("reserved bit set: %s", Integer.valueOf(i11));
        }
        a(this.f38257a, i12);
        this.f38257a.writeByte(b11 & 255);
        this.f38257a.writeByte(b12 & 255);
        this.f38257a.writeInt(i11 & Integer.MAX_VALUE);
    }

    public synchronized void a(int i11, int i12, List<c> list) throws IOException {
        if (this.f38261e) {
            throw new IOException("closed");
        }
        this.f38262f.a(list);
        long size = this.f38259c.size();
        int min = (int) Math.min(this.f38260d - 4, size);
        long j11 = min;
        a(i11, min + 4, (byte) 5, size == j11 ? (byte) 4 : (byte) 0);
        this.f38257a.writeInt(i12 & Integer.MAX_VALUE);
        this.f38257a.a(this.f38259c, j11);
        if (size > j11) {
            b(i11, size - j11);
        }
    }

    public synchronized void a(int i11, long j11) throws IOException {
        if (this.f38261e) {
            throw new IOException("closed");
        }
        if (j11 == 0 || j11 > 2147483647L) {
            throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j11));
        }
        a(i11, 4, (byte) 8, (byte) 0);
        this.f38257a.writeInt((int) j11);
        this.f38257a.flush();
    }

    public synchronized void a(int i11, b bVar) throws IOException {
        if (this.f38261e) {
            throw new IOException("closed");
        }
        if (bVar.f38106a == -1) {
            throw new IllegalArgumentException();
        }
        a(i11, 4, (byte) 3, (byte) 0);
        this.f38257a.writeInt(bVar.f38106a);
        this.f38257a.flush();
    }

    public synchronized void a(int i11, b bVar, byte[] bArr) throws IOException {
        try {
            if (this.f38261e) {
                throw new IOException("closed");
            }
            if (bVar.f38106a == -1) {
                throw e.a("errorCode.httpCode == -1", new Object[0]);
            }
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f38257a.writeInt(i11);
            this.f38257a.writeInt(bVar.f38106a);
            if (bArr.length > 0) {
                this.f38257a.write(bArr);
            }
            this.f38257a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(m mVar) throws IOException {
        try {
            if (this.f38261e) {
                throw new IOException("closed");
            }
            this.f38260d = mVar.c(this.f38260d);
            if (mVar.b() != -1) {
                this.f38262f.b(mVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f38257a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(boolean z10, int i11, int i12) throws IOException {
        if (this.f38261e) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
        this.f38257a.writeInt(i11);
        this.f38257a.writeInt(i12);
        this.f38257a.flush();
    }

    public synchronized void a(boolean z10, int i11, int i12, List<c> list) throws IOException {
        if (this.f38261e) {
            throw new IOException("closed");
        }
        a(z10, i11, list);
    }

    public synchronized void a(boolean z10, int i11, com.mbridge.msdk.thrid.okio.c cVar, int i12) throws IOException {
        if (this.f38261e) {
            throw new IOException("closed");
        }
        a(i11, z10 ? (byte) 1 : (byte) 0, cVar, i12);
    }

    void a(boolean z10, int i11, List<c> list) throws IOException {
        if (this.f38261e) {
            throw new IOException("closed");
        }
        this.f38262f.a(list);
        long size = this.f38259c.size();
        int min = (int) Math.min(this.f38260d, size);
        long j11 = min;
        byte b11 = size == j11 ? (byte) 4 : (byte) 0;
        if (z10) {
            b11 = (byte) (b11 | 1);
        }
        a(i11, min, (byte) 1, b11);
        this.f38257a.a(this.f38259c, j11);
        if (size > j11) {
            b(i11, size - j11);
        }
    }

    public synchronized void b(m mVar) throws IOException {
        try {
            if (this.f38261e) {
                throw new IOException("closed");
            }
            int i11 = 0;
            a(0, mVar.d() * 6, (byte) 4, (byte) 0);
            while (i11 < 10) {
                if (mVar.d(i11)) {
                    this.f38257a.writeShort(i11 == 4 ? 3 : i11 == 7 ? 4 : i11);
                    this.f38257a.writeInt(mVar.a(i11));
                }
                i11++;
            }
            this.f38257a.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f38261e = true;
        this.f38257a.close();
    }

    public synchronized void d() throws IOException {
        try {
            if (this.f38261e) {
                throw new IOException("closed");
            }
            if (this.f38258b) {
                Logger logger = f38256g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(com.mbridge.msdk.thrid.okhttp.internal.c.a(">> CONNECTION %s", e.f38136a.b()));
                }
                this.f38257a.write(e.f38136a.g());
                this.f38257a.flush();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void flush() throws IOException {
        if (this.f38261e) {
            throw new IOException("closed");
        }
        this.f38257a.flush();
    }

    public int h() {
        return this.f38260d;
    }
}
