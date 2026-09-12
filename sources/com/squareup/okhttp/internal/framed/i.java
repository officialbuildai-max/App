package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;
import okio.Sink;

/* loaded from: classes5.dex */
public final class i implements Variant {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f40475a;

    /* loaded from: classes5.dex */
    static final class a implements FrameReader {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedSource f40476a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f40477b;

        /* renamed from: c, reason: collision with root package name */
        private final f f40478c;

        a(BufferedSource bufferedSource, boolean z10) {
            this.f40476a = bufferedSource;
            this.f40478c = new f(bufferedSource);
            this.f40477b = z10;
        }

        private static IOException b(String str, Object... objArr) {
            throw new IOException(String.format(str, objArr));
        }

        private void d(FrameReader.Handler handler, int i11, int i12) {
            if (i12 != 8) {
                throw b("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i12));
            }
            int readInt = this.f40476a.readInt() & Integer.MAX_VALUE;
            int readInt2 = this.f40476a.readInt();
            ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(readInt2);
            if (fromSpdyGoAway == null) {
                throw b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            }
            handler.goAway(readInt, fromSpdyGoAway, ByteString.EMPTY);
        }

        private void h(FrameReader.Handler handler, int i11, int i12) {
            handler.headers(false, false, this.f40476a.readInt() & Integer.MAX_VALUE, -1, this.f40478c.f(i12 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void i(FrameReader.Handler handler, int i11, int i12) {
            if (i12 != 4) {
                throw b("TYPE_PING length: %d != 4", Integer.valueOf(i12));
            }
            int readInt = this.f40476a.readInt();
            handler.ping(this.f40477b == ((readInt & 1) == 1), readInt, 0);
        }

        private void k(FrameReader.Handler handler, int i11, int i12) {
            if (i12 != 8) {
                throw b("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i12));
            }
            int readInt = this.f40476a.readInt() & Integer.MAX_VALUE;
            int readInt2 = this.f40476a.readInt();
            ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(readInt2);
            if (fromSpdy3Rst == null) {
                throw b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt2));
            }
            handler.rstStream(readInt, fromSpdy3Rst);
        }

        private void l(FrameReader.Handler handler, int i11, int i12) {
            int readInt = this.f40476a.readInt();
            if (i12 != (readInt * 8) + 4) {
                throw b("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i12), Integer.valueOf(readInt));
            }
            h hVar = new h();
            for (int i13 = 0; i13 < readInt; i13++) {
                int readInt2 = this.f40476a.readInt();
                hVar.l(readInt2 & 16777215, ((-16777216) & readInt2) >>> 24, this.f40476a.readInt());
            }
            handler.settings((i11 & 1) != 0, hVar);
        }

        private void m(FrameReader.Handler handler, int i11, int i12) {
            handler.headers(false, (i11 & 1) != 0, this.f40476a.readInt() & Integer.MAX_VALUE, -1, this.f40478c.f(i12 - 4), HeadersMode.SPDY_REPLY);
        }

        private void n(FrameReader.Handler handler, int i11, int i12) {
            int readInt = this.f40476a.readInt() & Integer.MAX_VALUE;
            int readInt2 = this.f40476a.readInt() & Integer.MAX_VALUE;
            this.f40476a.readShort();
            handler.headers((i11 & 2) != 0, (i11 & 1) != 0, readInt, readInt2, this.f40478c.f(i12 - 10), HeadersMode.SPDY_SYN_STREAM);
        }

        private void o(FrameReader.Handler handler, int i11, int i12) {
            if (i12 != 8) {
                throw b("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i12));
            }
            int readInt = this.f40476a.readInt() & Integer.MAX_VALUE;
            long readInt2 = this.f40476a.readInt() & Integer.MAX_VALUE;
            if (readInt2 == 0) {
                throw b("windowSizeIncrement was 0", Long.valueOf(readInt2));
            }
            handler.windowUpdate(readInt, readInt2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f40478c.c();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) {
            try {
                int readInt = this.f40476a.readInt();
                int readInt2 = this.f40476a.readInt();
                int i11 = ((-16777216) & readInt2) >>> 24;
                int i12 = readInt2 & 16777215;
                if (!((Integer.MIN_VALUE & readInt) != 0)) {
                    handler.data((i11 & 1) != 0, readInt & Integer.MAX_VALUE, this.f40476a, i12);
                    return true;
                }
                int i13 = (2147418112 & readInt) >>> 16;
                int i14 = readInt & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                if (i13 != 3) {
                    throw new ProtocolException("version != 3: " + i13);
                }
                switch (i14) {
                    case 1:
                        n(handler, i11, i12);
                        return true;
                    case 2:
                        m(handler, i11, i12);
                        return true;
                    case 3:
                        k(handler, i11, i12);
                        return true;
                    case 4:
                        l(handler, i11, i12);
                        return true;
                    case 5:
                    default:
                        this.f40476a.skip(i12);
                        return true;
                    case 6:
                        i(handler, i11, i12);
                        return true;
                    case 7:
                        d(handler, i11, i12);
                        return true;
                    case 8:
                        h(handler, i11, i12);
                        return true;
                    case 9:
                        o(handler, i11, i12);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public void readConnectionPreface() {
        }
    }

    /* loaded from: classes5.dex */
    static final class b implements FrameWriter {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedSink f40479a;

        /* renamed from: b, reason: collision with root package name */
        private final Buffer f40480b;

        /* renamed from: c, reason: collision with root package name */
        private final BufferedSink f40481c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f40482d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f40483e;

        b(BufferedSink bufferedSink, boolean z10) {
            this.f40479a = bufferedSink;
            this.f40482d = z10;
            Deflater deflater = new Deflater();
            deflater.setDictionary(i.f40475a);
            Buffer buffer = new Buffer();
            this.f40480b = buffer;
            this.f40481c = Okio.buffer(new DeflaterSink((Sink) buffer, deflater));
        }

        private void d(List list) {
            this.f40481c.writeInt(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                ByteString byteString = ((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40424a;
                this.f40481c.writeInt(byteString.size());
                this.f40481c.write(byteString);
                ByteString byteString2 = ((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40425b;
                this.f40481c.writeInt(byteString2.size());
                this.f40481c.write(byteString2);
            }
            this.f40481c.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public void ackSettings(h hVar) {
        }

        void b(int i11, int i12, Buffer buffer, int i13) {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            long j11 = i13;
            if (j11 > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i13);
            }
            this.f40479a.writeInt(i11 & Integer.MAX_VALUE);
            this.f40479a.writeInt(((i12 & 255) << 24) | (16777215 & i13));
            if (i13 > 0) {
                this.f40479a.write(buffer, j11);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f40483e = true;
            com.squareup.okhttp.internal.g.b(this.f40479a, this.f40481c);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void connectionPreface() {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void data(boolean z10, int i11, Buffer buffer, int i12) {
            b(i11, z10 ? 1 : 0, buffer, i12);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void flush() {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            this.f40479a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void goAway(int i11, ErrorCode errorCode, byte[] bArr) {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            if (errorCode.spdyGoAwayCode == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            this.f40479a.writeInt(-2147287033);
            this.f40479a.writeInt(8);
            this.f40479a.writeInt(i11);
            this.f40479a.writeInt(errorCode.spdyGoAwayCode);
            this.f40479a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void headers(int i11, List list) {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            d(list);
            int size = (int) (this.f40480b.size() + 4);
            this.f40479a.writeInt(-2147287032);
            this.f40479a.writeInt(size & 16777215);
            this.f40479a.writeInt(i11 & Integer.MAX_VALUE);
            this.f40479a.writeAll(this.f40480b);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public int maxDataLength() {
            return 16383;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void ping(boolean z10, int i11, int i12) {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            if (z10 != (this.f40482d != ((i11 & 1) == 1))) {
                throw new IllegalArgumentException("payload != reply");
            }
            this.f40479a.writeInt(-2147287034);
            this.f40479a.writeInt(4);
            this.f40479a.writeInt(i11);
            this.f40479a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public void pushPromise(int i11, int i12, List list) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void rstStream(int i11, ErrorCode errorCode) {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            if (errorCode.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            }
            this.f40479a.writeInt(-2147287037);
            this.f40479a.writeInt(8);
            this.f40479a.writeInt(i11 & Integer.MAX_VALUE);
            this.f40479a.writeInt(errorCode.spdyRstCode);
            this.f40479a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void settings(h hVar) {
            try {
                if (this.f40483e) {
                    throw new IOException("closed");
                }
                int m11 = hVar.m();
                this.f40479a.writeInt(-2147287036);
                this.f40479a.writeInt(((m11 * 8) + 4) & 16777215);
                this.f40479a.writeInt(m11);
                for (int i11 = 0; i11 <= 10; i11++) {
                    if (hVar.i(i11)) {
                        this.f40479a.writeInt(((hVar.b(i11) & 255) << 24) | (i11 & 16777215));
                        this.f40479a.writeInt(hVar.c(i11));
                    }
                }
                this.f40479a.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synReply(boolean z10, int i11, List list) {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            d(list);
            int size = (int) (this.f40480b.size() + 4);
            this.f40479a.writeInt(-2147287038);
            this.f40479a.writeInt((((z10 ? 1 : 0) & 255) << 24) | (size & 16777215));
            this.f40479a.writeInt(i11 & Integer.MAX_VALUE);
            this.f40479a.writeAll(this.f40480b);
            this.f40479a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void synStream(boolean z10, boolean z11, int i11, int i12, List list) {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            d(list);
            int size = (int) (this.f40480b.size() + 10);
            int i13 = (z10 ? 1 : 0) | (z11 ? 2 : 0);
            this.f40479a.writeInt(-2147287039);
            this.f40479a.writeInt(((i13 & 255) << 24) | (size & 16777215));
            this.f40479a.writeInt(i11 & Integer.MAX_VALUE);
            this.f40479a.writeInt(Integer.MAX_VALUE & i12);
            this.f40479a.writeShort(0);
            this.f40479a.writeAll(this.f40480b);
            this.f40479a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void windowUpdate(int i11, long j11) {
            if (this.f40483e) {
                throw new IOException("closed");
            }
            if (j11 == 0 || j11 > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j11);
            }
            this.f40479a.writeInt(-2147287031);
            this.f40479a.writeInt(8);
            this.f40479a.writeInt(i11);
            this.f40479a.writeInt((int) j11);
            this.f40479a.flush();
        }
    }

    static {
        try {
            f40475a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(com.squareup.okhttp.internal.g.f40486c.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public Protocol getProtocol() {
        return Protocol.SPDY_3;
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameReader newReader(BufferedSource bufferedSource, boolean z10) {
        return new a(bufferedSource, z10);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameWriter newWriter(BufferedSink bufferedSink, boolean z10) {
        return new b(bufferedSink, z10);
    }
}
