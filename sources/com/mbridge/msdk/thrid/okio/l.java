package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f38505a = Logger.getLogger(l.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f38506a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OutputStream f38507b;

        a(t tVar, OutputStream outputStream) {
            this.f38506a = tVar;
            this.f38507b = outputStream;
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            u.a(cVar.f38486b, 0L, j11);
            while (j11 > 0) {
                this.f38506a.e();
                o oVar = cVar.f38485a;
                int min = (int) Math.min(j11, oVar.f38520c - oVar.f38519b);
                this.f38507b.write(oVar.f38518a, oVar.f38519b, min);
                int i11 = oVar.f38519b + min;
                oVar.f38519b = i11;
                long j12 = min;
                j11 -= j12;
                cVar.f38486b -= j12;
                if (i11 == oVar.f38520c) {
                    cVar.f38485a = oVar.b();
                    p.a(oVar);
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public t b() {
            return this.f38506a;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f38507b.close();
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
        public void flush() throws IOException {
            this.f38507b.flush();
        }

        public String toString() {
            return "sink(" + this.f38507b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f38508a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InputStream f38509b;

        b(t tVar, InputStream inputStream) {
            this.f38508a = tVar;
            this.f38509b = inputStream;
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (j11 == 0) {
                return 0L;
            }
            try {
                this.f38508a.e();
                o b11 = cVar.b(1);
                int read = this.f38509b.read(b11.f38518a, b11.f38520c, (int) Math.min(j11, 8192 - b11.f38520c));
                if (read == -1) {
                    return -1L;
                }
                b11.f38520c += read;
                long j12 = read;
                cVar.f38486b += j12;
                return j12;
            } catch (AssertionError e11) {
                if (l.a(e11)) {
                    throw new IOException(e11);
                }
                throw e11;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public t b() {
            return this.f38508a;
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f38509b.close();
        }

        public String toString() {
            return "source(" + this.f38509b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class c extends com.mbridge.msdk.thrid.okio.a {

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Socket f38510k;

        c(Socket socket) {
            this.f38510k = socket;
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected IOException b(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected void j() {
            try {
                this.f38510k.close();
            } catch (AssertionError e11) {
                if (!l.a(e11)) {
                    throw e11;
                }
                l.f38505a.log(Level.WARNING, "Failed to close timed out socket " + this.f38510k, (Throwable) e11);
            } catch (Exception e12) {
                l.f38505a.log(Level.WARNING, "Failed to close timed out socket " + this.f38510k, (Throwable) e12);
            }
        }
    }

    private l() {
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    private static r a(OutputStream outputStream, t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar != null) {
            return new a(tVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static r a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        com.mbridge.msdk.thrid.okio.a c11 = c(socket);
        return c11.a(a(socket.getOutputStream(), c11));
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(InputStream inputStream, t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar != null) {
            return new b(tVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        com.mbridge.msdk.thrid.okio.a c11 = c(socket);
        return c11.a(a(socket.getInputStream(), c11));
    }

    private static com.mbridge.msdk.thrid.okio.a c(Socket socket) {
        return new c(socket);
    }
}
