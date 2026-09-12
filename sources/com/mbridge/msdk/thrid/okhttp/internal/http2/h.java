package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.http2.d;
import com.mbridge.msdk.thrid.okio.s;
import com.mbridge.msdk.thrid.okio.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class h implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    static final Logger f38220e = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okio.e f38221a;

    /* renamed from: b, reason: collision with root package name */
    private final a f38222b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f38223c;

    /* renamed from: d, reason: collision with root package name */
    final d.a f38224d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements s {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.e f38225a;

        /* renamed from: b, reason: collision with root package name */
        int f38226b;

        /* renamed from: c, reason: collision with root package name */
        byte f38227c;

        /* renamed from: d, reason: collision with root package name */
        int f38228d;

        /* renamed from: e, reason: collision with root package name */
        int f38229e;

        /* renamed from: f, reason: collision with root package name */
        short f38230f;

        a(com.mbridge.msdk.thrid.okio.e eVar) {
            this.f38225a = eVar;
        }

        private void d() throws IOException {
            int i11 = this.f38228d;
            int a11 = h.a(this.f38225a);
            this.f38229e = a11;
            this.f38226b = a11;
            byte readByte = (byte) (this.f38225a.readByte() & 255);
            this.f38227c = (byte) (this.f38225a.readByte() & 255);
            Logger logger = h.f38220e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, this.f38228d, this.f38226b, readByte, this.f38227c));
            }
            int readInt = this.f38225a.readInt() & Integer.MAX_VALUE;
            this.f38228d = readInt;
            if (readByte != 9) {
                throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i11) {
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            while (true) {
                int i11 = this.f38229e;
                if (i11 != 0) {
                    long b11 = this.f38225a.b(cVar, Math.min(j11, i11));
                    if (b11 == -1) {
                        return -1L;
                    }
                    this.f38229e = (int) (this.f38229e - b11);
                    return b11;
                }
                this.f38225a.skip(this.f38230f);
                this.f38230f = (short) 0;
                if ((this.f38227c & 4) != 0) {
                    return -1L;
                }
                d();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public t b() {
            return this.f38225a.b();
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void a(int i11, int i12, int i13, boolean z10);

        void a(int i11, int i12, List<c> list) throws IOException;

        void a(int i11, long j11);

        void a(int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar);

        void a(int i11, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar, com.mbridge.msdk.thrid.okio.f fVar);

        void a(boolean z10, int i11, int i12);

        void a(boolean z10, int i11, int i12, List<c> list);

        void a(boolean z10, int i11, com.mbridge.msdk.thrid.okio.e eVar, int i12) throws IOException;

        void a(boolean z10, m mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.mbridge.msdk.thrid.okio.e eVar, boolean z10) {
        this.f38221a = eVar;
        this.f38223c = z10;
        a aVar = new a(eVar);
        this.f38222b = aVar;
        this.f38224d = new d.a(4096, aVar);
    }

    static int a(int i11, byte b11, short s11) throws IOException {
        if ((b11 & 8) != 0) {
            i11--;
        }
        if (s11 <= i11) {
            return (short) (i11 - s11);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s11), Integer.valueOf(i11));
    }

    static int a(com.mbridge.msdk.thrid.okio.e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    private List<c> a(int i11, short s11, byte b11, int i12) throws IOException {
        a aVar = this.f38222b;
        aVar.f38229e = i11;
        aVar.f38226b = i11;
        aVar.f38230f = s11;
        aVar.f38227c = b11;
        aVar.f38228d = i12;
        this.f38224d.f();
        return this.f38224d.c();
    }

    private void a(b bVar, int i11) throws IOException {
        int readInt = this.f38221a.readInt();
        bVar.a(i11, readInt & Integer.MAX_VALUE, (this.f38221a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void a(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i12 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z10 = (b11 & 1) != 0;
        if ((b11 & 32) != 0) {
            throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short readByte = (b11 & 8) != 0 ? (short) (this.f38221a.readByte() & 255) : (short) 0;
        bVar.a(z10, i12, this.f38221a, a(i11, b11, readByte));
        this.f38221a.skip(readByte);
    }

    private void b(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i11 < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i11));
        }
        if (i12 != 0) {
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int readInt = this.f38221a.readInt();
        int readInt2 = this.f38221a.readInt();
        int i13 = i11 - 8;
        com.mbridge.msdk.thrid.okhttp.internal.http2.b a11 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.a(readInt2);
        if (a11 == null) {
            throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        }
        com.mbridge.msdk.thrid.okio.f fVar = com.mbridge.msdk.thrid.okio.f.f38489e;
        if (i13 > 0) {
            fVar = this.f38221a.b(i13);
        }
        bVar.a(readInt, a11, fVar);
    }

    private void c(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i12 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z10 = (b11 & 1) != 0;
        short readByte = (b11 & 8) != 0 ? (short) (this.f38221a.readByte() & 255) : (short) 0;
        if ((b11 & 32) != 0) {
            a(bVar, i12);
            i11 -= 5;
        }
        bVar.a(z10, i12, -1, a(a(i11, b11, readByte), readByte, b11, i12));
    }

    private void d(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i11 != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i11));
        }
        if (i12 != 0) {
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.a((b11 & 1) != 0, this.f38221a.readInt(), this.f38221a.readInt());
    }

    private void e(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i11 != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i11));
        }
        if (i12 == 0) {
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(bVar, i12);
    }

    private void f(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i12 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short readByte = (b11 & 8) != 0 ? (short) (this.f38221a.readByte() & 255) : (short) 0;
        bVar.a(i12, this.f38221a.readInt() & Integer.MAX_VALUE, a(a(i11 - 4, b11, readByte), readByte, b11, i12));
    }

    private void g(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i11 != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i11));
        }
        if (i12 == 0) {
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int readInt = this.f38221a.readInt();
        com.mbridge.msdk.thrid.okhttp.internal.http2.b a11 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.a(readInt);
        if (a11 == null) {
            throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        }
        bVar.a(i12, a11);
    }

    private void h(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i12 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b11 & 1) != 0) {
            if (i11 != 0) {
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.a();
            return;
        }
        if (i11 % 6 != 0) {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i11));
        }
        m mVar = new m();
        for (int i13 = 0; i13 < i11; i13 += 6) {
            int readShort = this.f38221a.readShort() & 65535;
            int readInt = this.f38221a.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    if (readInt < 0) {
                        throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    readShort = 7;
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                }
            } else if (readInt != 0 && readInt != 1) {
                throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
            mVar.a(readShort, readInt);
        }
        bVar.a(false, mVar);
    }

    private void i(b bVar, int i11, byte b11, int i12) throws IOException {
        if (i11 != 4) {
            throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i11));
        }
        long readInt = this.f38221a.readInt() & 2147483647L;
        if (readInt == 0) {
            throw e.b("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        bVar.a(i12, readInt);
    }

    public void a(b bVar) throws IOException {
        if (this.f38223c) {
            if (!a(true, bVar)) {
                throw e.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.mbridge.msdk.thrid.okio.e eVar = this.f38221a;
        com.mbridge.msdk.thrid.okio.f fVar = e.f38136a;
        com.mbridge.msdk.thrid.okio.f b11 = eVar.b(fVar.e());
        Logger logger = f38220e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.mbridge.msdk.thrid.okhttp.internal.c.a("<< CONNECTION %s", b11.b()));
        }
        if (!fVar.equals(b11)) {
            throw e.b("Expected a connection header but was %s", b11.h());
        }
    }

    public boolean a(boolean z10, b bVar) throws IOException {
        try {
            this.f38221a.e(9L);
            int a11 = a(this.f38221a);
            if (a11 < 0 || a11 > 16384) {
                throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a11));
            }
            byte readByte = (byte) (this.f38221a.readByte() & 255);
            if (z10 && readByte != 4) {
                throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            }
            byte readByte2 = (byte) (this.f38221a.readByte() & 255);
            int readInt = this.f38221a.readInt() & Integer.MAX_VALUE;
            Logger logger = f38220e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, readInt, a11, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    a(bVar, a11, readByte2, readInt);
                    return true;
                case 1:
                    c(bVar, a11, readByte2, readInt);
                    return true;
                case 2:
                    e(bVar, a11, readByte2, readInt);
                    return true;
                case 3:
                    g(bVar, a11, readByte2, readInt);
                    return true;
                case 4:
                    h(bVar, a11, readByte2, readInt);
                    return true;
                case 5:
                    f(bVar, a11, readByte2, readInt);
                    return true;
                case 6:
                    d(bVar, a11, readByte2, readInt);
                    return true;
                case 7:
                    b(bVar, a11, readByte2, readInt);
                    return true;
                case 8:
                    i(bVar, a11, readByte2, readInt);
                    return true;
                default:
                    this.f38221a.skip(a11);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38221a.close();
    }
}
