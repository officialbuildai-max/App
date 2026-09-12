package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.framed.FrameReader;
import com.squareup.okhttp.internal.framed.c;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: classes5.dex */
public final class d implements Variant {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f40438a = Logger.getLogger(b.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final ByteString f40439b = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Source {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedSource f40440a;

        /* renamed from: b, reason: collision with root package name */
        int f40441b;

        /* renamed from: c, reason: collision with root package name */
        byte f40442c;

        /* renamed from: d, reason: collision with root package name */
        int f40443d;

        /* renamed from: e, reason: collision with root package name */
        int f40444e;

        /* renamed from: f, reason: collision with root package name */
        short f40445f;

        public a(BufferedSource bufferedSource) {
            this.f40440a = bufferedSource;
        }

        private void d() {
            int i11 = this.f40443d;
            int k11 = d.k(this.f40440a);
            this.f40444e = k11;
            this.f40441b = k11;
            byte readByte = (byte) (this.f40440a.readByte() & 255);
            this.f40442c = (byte) (this.f40440a.readByte() & 255);
            if (d.f40438a.isLoggable(Level.FINE)) {
                d.f40438a.fine(b.b(true, this.f40443d, this.f40441b, readByte, this.f40442c));
            }
            int readInt = this.f40440a.readInt() & Integer.MAX_VALUE;
            this.f40443d = readInt;
            if (readByte != 9) {
                throw d.i("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i11) {
                throw d.i("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) {
            while (true) {
                int i11 = this.f40444e;
                if (i11 != 0) {
                    long read = this.f40440a.read(buffer, Math.min(j11, i11));
                    if (read == -1) {
                        return -1L;
                    }
                    this.f40444e = (int) (this.f40444e - read);
                    return read;
                }
                this.f40440a.skip(this.f40445f);
                this.f40445f = (short) 0;
                if ((this.f40442c & 4) != 0) {
                    return -1L;
                }
                d();
            }
        }

        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return this.f40440a.getTimeout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f40446a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f40447b = new String[64];

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f40448c = new String[256];

        static {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                String[] strArr = f40448c;
                if (i12 >= strArr.length) {
                    break;
                }
                strArr[i12] = String.format("%8s", Integer.toBinaryString(i12)).replace(' ', '0');
                i12++;
            }
            String[] strArr2 = f40447b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            int i13 = iArr[0];
            strArr2[i13 | 8] = strArr2[i13] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i14 = 0; i14 < 3; i14++) {
                int i15 = iArr2[i14];
                int i16 = iArr[0];
                String[] strArr3 = f40447b;
                int i17 = i16 | i15;
                strArr3[i17] = strArr3[i16] + '|' + strArr3[i15];
                strArr3[i17 | 8] = strArr3[i16] + '|' + strArr3[i15] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f40447b;
                if (i11 >= strArr4.length) {
                    return;
                }
                if (strArr4[i11] == null) {
                    strArr4[i11] = f40448c[i11];
                }
                i11++;
            }
        }

        static String a(byte b11, byte b12) {
            if (b12 == 0) {
                return "";
            }
            if (b11 != 2 && b11 != 3) {
                if (b11 == 4 || b11 == 6) {
                    return b12 == 1 ? "ACK" : f40448c[b12];
                }
                if (b11 != 7 && b11 != 8) {
                    String[] strArr = f40447b;
                    String str = b12 < strArr.length ? strArr[b12] : f40448c[b12];
                    return (b11 != 5 || (b12 & 4) == 0) ? (b11 != 0 || (b12 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f40448c[b12];
        }

        static String b(boolean z10, int i11, int i12, byte b11, byte b12) {
            String[] strArr = f40446a;
            return String.format("%s 0x%08x %5d %-13s %s", z10 ? "<<" : ">>", Integer.valueOf(i11), Integer.valueOf(i12), b11 < strArr.length ? strArr[b11] : String.format("0x%02x", Byte.valueOf(b11)), a(b11, b12));
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements FrameReader {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedSource f40449a;

        /* renamed from: b, reason: collision with root package name */
        private final a f40450b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f40451c;

        /* renamed from: d, reason: collision with root package name */
        final c.a f40452d;

        c(BufferedSource bufferedSource, int i11, boolean z10) {
            this.f40449a = bufferedSource;
            this.f40451c = z10;
            a aVar = new a(bufferedSource);
            this.f40450b = aVar;
            this.f40452d = new c.a(i11, aVar);
        }

        private void b(FrameReader.Handler handler, int i11, byte b11, int i12) {
            boolean z10 = (b11 & 1) != 0;
            if ((b11 & 32) != 0) {
                throw d.i("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short readByte = (b11 & 8) != 0 ? (short) (this.f40449a.readByte() & 255) : (short) 0;
            handler.data(z10, i12, this.f40449a, d.j(i11, b11, readByte));
            this.f40449a.skip(readByte);
        }

        private void d(FrameReader.Handler handler, int i11, byte b11, int i12) {
            if (i11 < 8) {
                throw d.i("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i11));
            }
            if (i12 != 0) {
                throw d.i("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int readInt = this.f40449a.readInt();
            int readInt2 = this.f40449a.readInt();
            int i13 = i11 - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 == null) {
                throw d.i("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            }
            ByteString byteString = ByteString.EMPTY;
            if (i13 > 0) {
                byteString = this.f40449a.readByteString(i13);
            }
            handler.goAway(readInt, fromHttp2, byteString);
        }

        private List h(int i11, short s11, byte b11, int i12) {
            a aVar = this.f40450b;
            aVar.f40444e = i11;
            aVar.f40441b = i11;
            aVar.f40445f = s11;
            aVar.f40442c = b11;
            aVar.f40443d = i12;
            this.f40452d.l();
            return this.f40452d.e();
        }

        private void i(FrameReader.Handler handler, int i11, byte b11, int i12) {
            if (i12 == 0) {
                throw d.i("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z10 = (b11 & 1) != 0;
            short readByte = (b11 & 8) != 0 ? (short) (this.f40449a.readByte() & 255) : (short) 0;
            if ((b11 & 32) != 0) {
                l(handler, i12);
                i11 -= 5;
            }
            handler.headers(false, z10, i12, -1, h(d.j(i11, b11, readByte), readByte, b11, i12), HeadersMode.HTTP_20_HEADERS);
        }

        private void k(FrameReader.Handler handler, int i11, byte b11, int i12) {
            if (i11 != 8) {
                throw d.i("TYPE_PING length != 8: %s", Integer.valueOf(i11));
            }
            if (i12 != 0) {
                throw d.i("TYPE_PING streamId != 0", new Object[0]);
            }
            handler.ping((b11 & 1) != 0, this.f40449a.readInt(), this.f40449a.readInt());
        }

        private void l(FrameReader.Handler handler, int i11) {
            int readInt = this.f40449a.readInt();
            handler.priority(i11, readInt & Integer.MAX_VALUE, (this.f40449a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }

        private void m(FrameReader.Handler handler, int i11, byte b11, int i12) {
            if (i11 != 5) {
                throw d.i("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i11));
            }
            if (i12 == 0) {
                throw d.i("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            l(handler, i12);
        }

        private void n(FrameReader.Handler handler, int i11, byte b11, int i12) {
            if (i12 == 0) {
                throw d.i("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short readByte = (b11 & 8) != 0 ? (short) (this.f40449a.readByte() & 255) : (short) 0;
            handler.pushPromise(i12, this.f40449a.readInt() & Integer.MAX_VALUE, h(d.j(i11 - 4, b11, readByte), readByte, b11, i12));
        }

        private void o(FrameReader.Handler handler, int i11, byte b11, int i12) {
            if (i11 != 4) {
                throw d.i("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i11));
            }
            if (i12 == 0) {
                throw d.i("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int readInt = this.f40449a.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 == null) {
                throw d.i("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
            handler.rstStream(i12, fromHttp2);
        }

        private void p(FrameReader.Handler handler, int i11, byte b11, int i12) {
            if (i12 != 0) {
                throw d.i("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b11 & 1) != 0) {
                if (i11 != 0) {
                    throw d.i("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                handler.ackSettings();
                return;
            }
            if (i11 % 6 != 0) {
                throw d.i("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i11));
            }
            h hVar = new h();
            for (int i13 = 0; i13 < i11; i13 += 6) {
                short readShort = this.f40449a.readShort();
                int readInt = this.f40449a.readInt();
                switch (readShort) {
                    case 1:
                    case 6:
                        break;
                    case 2:
                        if (readInt != 0 && readInt != 1) {
                            throw d.i("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        if (readInt < 0) {
                            throw d.i("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        readShort = 7;
                        break;
                    case 5:
                        if (readInt < 16384 || readInt > 16777215) {
                            throw d.i("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                        break;
                        break;
                    default:
                        throw d.i("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(readShort));
                }
                hVar.l(readShort, 0, readInt);
            }
            handler.settings(false, hVar);
            if (hVar.d() >= 0) {
                this.f40452d.g(hVar.d());
            }
        }

        private void q(FrameReader.Handler handler, int i11, byte b11, int i12) {
            if (i11 != 4) {
                throw d.i("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i11));
            }
            long readInt = this.f40449a.readInt() & 2147483647L;
            if (readInt == 0) {
                throw d.i("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
            handler.windowUpdate(i12, readInt);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f40449a.close();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) {
            try {
                this.f40449a.require(9L);
                int k11 = d.k(this.f40449a);
                if (k11 < 0 || k11 > 16384) {
                    throw d.i("FRAME_SIZE_ERROR: %s", Integer.valueOf(k11));
                }
                byte readByte = (byte) (this.f40449a.readByte() & 255);
                byte readByte2 = (byte) (this.f40449a.readByte() & 255);
                int readInt = this.f40449a.readInt() & Integer.MAX_VALUE;
                if (d.f40438a.isLoggable(Level.FINE)) {
                    d.f40438a.fine(b.b(true, readInt, k11, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        b(handler, k11, readByte2, readInt);
                        return true;
                    case 1:
                        i(handler, k11, readByte2, readInt);
                        return true;
                    case 2:
                        m(handler, k11, readByte2, readInt);
                        return true;
                    case 3:
                        o(handler, k11, readByte2, readInt);
                        return true;
                    case 4:
                        p(handler, k11, readByte2, readInt);
                        return true;
                    case 5:
                        n(handler, k11, readByte2, readInt);
                        return true;
                    case 6:
                        k(handler, k11, readByte2, readInt);
                        return true;
                    case 7:
                        d(handler, k11, readByte2, readInt);
                        return true;
                    case 8:
                        q(handler, k11, readByte2, readInt);
                        return true;
                    default:
                        this.f40449a.skip(k11);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public void readConnectionPreface() {
            if (this.f40451c) {
                return;
            }
            ByteString readByteString = this.f40449a.readByteString(d.f40439b.size());
            if (d.f40438a.isLoggable(Level.FINE)) {
                d.f40438a.fine(String.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!d.f40439b.equals(readByteString)) {
                throw d.i("Expected a connection header but was %s", readByteString.utf8());
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.framed.d$d, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0580d implements FrameWriter {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedSink f40453a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f40454b;

        /* renamed from: c, reason: collision with root package name */
        private final Buffer f40455c;

        /* renamed from: d, reason: collision with root package name */
        private final c.b f40456d;

        /* renamed from: e, reason: collision with root package name */
        private int f40457e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f40458f;

        C0580d(BufferedSink bufferedSink, boolean z10) {
            this.f40453a = bufferedSink;
            this.f40454b = z10;
            Buffer buffer = new Buffer();
            this.f40455c = buffer;
            this.f40456d = new c.b(buffer);
            this.f40457e = 16384;
        }

        private void i(int i11, long j11) {
            while (j11 > 0) {
                int min = (int) Math.min(this.f40457e, j11);
                long j12 = min;
                j11 -= j12;
                d(i11, min, (byte) 9, j11 == 0 ? (byte) 4 : (byte) 0);
                this.f40453a.write(this.f40455c, j12);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ackSettings(h hVar) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            this.f40457e = hVar.g(this.f40457e);
            d(0, 0, (byte) 4, (byte) 1);
            this.f40453a.flush();
        }

        void b(int i11, byte b11, Buffer buffer, int i12) {
            d(i11, i12, (byte) 0, b11);
            if (i12 > 0) {
                this.f40453a.write(buffer, i12);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f40458f = true;
            this.f40453a.close();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void connectionPreface() {
            try {
                if (this.f40458f) {
                    throw new IOException("closed");
                }
                if (this.f40454b) {
                    if (d.f40438a.isLoggable(Level.FINE)) {
                        d.f40438a.fine(String.format(">> CONNECTION %s", d.f40439b.hex()));
                    }
                    this.f40453a.write(d.f40439b.toByteArray());
                    this.f40453a.flush();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }

        void d(int i11, int i12, byte b11, byte b12) {
            if (d.f40438a.isLoggable(Level.FINE)) {
                d.f40438a.fine(b.b(false, i11, i12, b11, b12));
            }
            int i13 = this.f40457e;
            if (i12 > i13) {
                throw d.h("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i13), Integer.valueOf(i12));
            }
            if ((Integer.MIN_VALUE & i11) != 0) {
                throw d.h("reserved bit set: %s", Integer.valueOf(i11));
            }
            d.l(this.f40453a, i12);
            this.f40453a.writeByte(b11 & 255);
            this.f40453a.writeByte(b12 & 255);
            this.f40453a.writeInt(i11 & Integer.MAX_VALUE);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void data(boolean z10, int i11, Buffer buffer, int i12) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            b(i11, z10 ? (byte) 1 : (byte) 0, buffer, i12);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void flush() {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            this.f40453a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void goAway(int i11, ErrorCode errorCode, byte[] bArr) {
            try {
                if (this.f40458f) {
                    throw new IOException("closed");
                }
                if (errorCode.httpCode == -1) {
                    throw d.h("errorCode.httpCode == -1", new Object[0]);
                }
                d(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f40453a.writeInt(i11);
                this.f40453a.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.f40453a.write(bArr);
                }
                this.f40453a.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        void h(boolean z10, int i11, List list) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            this.f40456d.b(list);
            long size = this.f40455c.size();
            int min = (int) Math.min(this.f40457e, size);
            long j11 = min;
            byte b11 = size == j11 ? (byte) 4 : (byte) 0;
            if (z10) {
                b11 = (byte) (b11 | 1);
            }
            d(i11, min, (byte) 1, b11);
            this.f40453a.write(this.f40455c, j11);
            if (size > j11) {
                i(i11, size - j11);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void headers(int i11, List list) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            h(false, i11, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public int maxDataLength() {
            return this.f40457e;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ping(boolean z10, int i11, int i12) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            d(0, 8, (byte) 6, z10 ? (byte) 1 : (byte) 0);
            this.f40453a.writeInt(i11);
            this.f40453a.writeInt(i12);
            this.f40453a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void pushPromise(int i11, int i12, List list) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            this.f40456d.b(list);
            long size = this.f40455c.size();
            int min = (int) Math.min(this.f40457e - 4, size);
            long j11 = min;
            d(i11, min + 4, (byte) 5, size == j11 ? (byte) 4 : (byte) 0);
            this.f40453a.writeInt(i12 & Integer.MAX_VALUE);
            this.f40453a.write(this.f40455c, j11);
            if (size > j11) {
                i(i11, size - j11);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void rstStream(int i11, ErrorCode errorCode) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode == -1) {
                throw new IllegalArgumentException();
            }
            d(i11, 4, (byte) 3, (byte) 0);
            this.f40453a.writeInt(errorCode.httpCode);
            this.f40453a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void settings(h hVar) {
            try {
                if (this.f40458f) {
                    throw new IOException("closed");
                }
                int i11 = 0;
                d(0, hVar.m() * 6, (byte) 4, (byte) 0);
                while (i11 < 10) {
                    if (hVar.i(i11)) {
                        this.f40453a.writeShort(i11 == 4 ? 3 : i11 == 7 ? 4 : i11);
                        this.f40453a.writeInt(hVar.c(i11));
                    }
                    i11++;
                }
                this.f40453a.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synReply(boolean z10, int i11, List list) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            h(z10, i11, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synStream(boolean z10, boolean z11, int i11, int i12, List list) {
            if (z11) {
                throw new UnsupportedOperationException();
            }
            if (this.f40458f) {
                throw new IOException("closed");
            }
            h(z10, i11, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void windowUpdate(int i11, long j11) {
            if (this.f40458f) {
                throw new IOException("closed");
            }
            if (j11 == 0 || j11 > 2147483647L) {
                throw d.h("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j11));
            }
            d(i11, 4, (byte) 8, (byte) 0);
            this.f40453a.writeInt((int) j11);
            this.f40453a.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IllegalArgumentException h(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException i(String str, Object... objArr) {
        throw new IOException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(int i11, byte b11, short s11) {
        if ((b11 & 8) != 0) {
            i11--;
        }
        if (s11 <= i11) {
            return (short) (i11 - s11);
        }
        throw i("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s11), Integer.valueOf(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(BufferedSink bufferedSink, int i11) {
        bufferedSink.writeByte((i11 >>> 16) & 255);
        bufferedSink.writeByte((i11 >>> 8) & 255);
        bufferedSink.writeByte(i11 & 255);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameReader newReader(BufferedSource bufferedSource, boolean z10) {
        return new c(bufferedSource, 4096, z10);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z10) {
        return new C0580d(bufferedSink, z10);
    }
}
