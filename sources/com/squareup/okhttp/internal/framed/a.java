package com.squareup.okhttp.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    long f40396b;

    /* renamed from: c, reason: collision with root package name */
    private final int f40397c;

    /* renamed from: d, reason: collision with root package name */
    private final FramedConnection f40398d;

    /* renamed from: e, reason: collision with root package name */
    private final List f40399e;

    /* renamed from: f, reason: collision with root package name */
    private List f40400f;

    /* renamed from: g, reason: collision with root package name */
    private final c f40401g;

    /* renamed from: h, reason: collision with root package name */
    final b f40402h;

    /* renamed from: a, reason: collision with root package name */
    long f40395a = 0;

    /* renamed from: i, reason: collision with root package name */
    private final d f40403i = new d();

    /* renamed from: j, reason: collision with root package name */
    private final d f40404j = new d();

    /* renamed from: k, reason: collision with root package name */
    private ErrorCode f40405k = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class b implements Sink {

        /* renamed from: a, reason: collision with root package name */
        private final Buffer f40406a = new Buffer();

        /* renamed from: b, reason: collision with root package name */
        private boolean f40407b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f40408c;

        b() {
        }

        private void i(boolean z10) {
            long min;
            a aVar;
            synchronized (a.this) {
                a.this.f40404j.enter();
                while (true) {
                    try {
                        a aVar2 = a.this;
                        if (aVar2.f40396b > 0 || this.f40408c || this.f40407b || aVar2.f40405k != null) {
                            break;
                        } else {
                            a.this.z();
                        }
                    } finally {
                        a.this.f40404j.exitAndThrowIfTimedOut();
                    }
                }
                a.this.f40404j.exitAndThrowIfTimedOut();
                a.this.k();
                min = Math.min(a.this.f40396b, this.f40406a.size());
                aVar = a.this;
                aVar.f40396b -= min;
            }
            aVar.f40404j.enter();
            try {
                a.this.f40398d.B0(a.this.f40397c, z10 && min == this.f40406a.size(), this.f40406a, min);
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (a.this) {
                try {
                    if (this.f40407b) {
                        return;
                    }
                    if (!a.this.f40402h.f40408c) {
                        if (this.f40406a.size() > 0) {
                            while (this.f40406a.size() > 0) {
                                i(true);
                            }
                        } else {
                            a.this.f40398d.B0(a.this.f40397c, true, null, 0L);
                        }
                    }
                    synchronized (a.this) {
                        this.f40407b = true;
                    }
                    a.this.f40398d.flush();
                    a.this.j();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            synchronized (a.this) {
                a.this.k();
            }
            while (this.f40406a.size() > 0) {
                i(false);
                a.this.f40398d.flush();
            }
        }

        @Override // okio.Sink
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return a.this.f40404j;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j11) {
            this.f40406a.write(buffer, j11);
            while (this.f40406a.size() >= 16384) {
                i(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class c implements Source {

        /* renamed from: a, reason: collision with root package name */
        private final Buffer f40410a;

        /* renamed from: b, reason: collision with root package name */
        private final Buffer f40411b;

        /* renamed from: c, reason: collision with root package name */
        private final long f40412c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f40413d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f40414e;

        private c(long j11) {
            this.f40410a = new Buffer();
            this.f40411b = new Buffer();
            this.f40412c = j11;
        }

        private void k() {
            if (this.f40413d) {
                throw new IOException("stream closed");
            }
            if (a.this.f40405k == null) {
                return;
            }
            throw new IOException("stream was reset: " + a.this.f40405k);
        }

        private void m() {
            a.this.f40403i.enter();
            while (this.f40411b.size() == 0 && !this.f40414e && !this.f40413d && a.this.f40405k == null) {
                try {
                    a.this.z();
                } finally {
                    a.this.f40403i.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (a.this) {
                this.f40413d = true;
                this.f40411b.clear();
                a.this.notifyAll();
            }
            a.this.j();
        }

        void l(BufferedSource bufferedSource, long j11) {
            boolean z10;
            boolean z11;
            while (j11 > 0) {
                synchronized (a.this) {
                    z10 = this.f40414e;
                    z11 = this.f40411b.size() + j11 > this.f40412c;
                }
                if (z11) {
                    bufferedSource.skip(j11);
                    a.this.n(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    bufferedSource.skip(j11);
                    return;
                }
                long read = bufferedSource.read(this.f40410a, j11);
                if (read == -1) {
                    throw new EOFException();
                }
                j11 -= read;
                synchronized (a.this) {
                    try {
                        boolean z12 = this.f40411b.size() == 0;
                        this.f40411b.writeAll(this.f40410a);
                        if (z12) {
                            a.this.notifyAll();
                        }
                    } finally {
                    }
                }
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            synchronized (a.this) {
                try {
                    m();
                    k();
                    if (this.f40411b.size() == 0) {
                        return -1L;
                    }
                    Buffer buffer2 = this.f40411b;
                    long read = buffer2.read(buffer, Math.min(j11, buffer2.size()));
                    a aVar = a.this;
                    long j12 = aVar.f40395a + read;
                    aVar.f40395a = j12;
                    if (j12 >= aVar.f40398d.f40378p.e(65536) / 2) {
                        a.this.f40398d.H0(a.this.f40397c, a.this.f40395a);
                        a.this.f40395a = 0L;
                    }
                    synchronized (a.this.f40398d) {
                        try {
                            a.this.f40398d.f40376n += read;
                            if (a.this.f40398d.f40376n >= a.this.f40398d.f40378p.e(65536) / 2) {
                                a.this.f40398d.H0(0, a.this.f40398d.f40376n);
                                a.this.f40398d.f40376n = 0L;
                            }
                        } finally {
                        }
                    }
                    return read;
                } finally {
                }
            }
        }

        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return a.this.f40403i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends AsyncTimeout {
        d() {
        }

        public void exitAndThrowIfTimedOut() {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            a.this.n(ErrorCode.CANCEL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i11, FramedConnection framedConnection, boolean z10, boolean z11, List list) {
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f40397c = i11;
        this.f40398d = framedConnection;
        this.f40396b = framedConnection.f40379q.e(65536);
        c cVar = new c(framedConnection.f40378p.e(65536));
        this.f40401g = cVar;
        b bVar = new b();
        this.f40402h = bVar;
        cVar.f40414e = z11;
        bVar.f40408c = z10;
        this.f40399e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        boolean z10;
        boolean t11;
        synchronized (this) {
            try {
                if (this.f40401g.f40414e || !this.f40401g.f40413d || (!this.f40402h.f40408c && !this.f40402h.f40407b)) {
                    z10 = false;
                    t11 = t();
                }
                z10 = true;
                t11 = t();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            l(ErrorCode.CANCEL);
        } else {
            if (t11) {
                return;
            }
            this.f40398d.v0(this.f40397c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f40402h.f40407b) {
            throw new IOException("stream closed");
        }
        if (this.f40402h.f40408c) {
            throw new IOException("stream finished");
        }
        if (this.f40405k == null) {
            return;
        }
        throw new IOException("stream was reset: " + this.f40405k);
    }

    private boolean m(ErrorCode errorCode) {
        synchronized (this) {
            try {
                if (this.f40405k != null) {
                    return false;
                }
                if (this.f40401g.f40414e && this.f40402h.f40408c) {
                    return false;
                }
                this.f40405k = errorCode;
                notifyAll();
                this.f40398d.v0(this.f40397c);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public Timeout A() {
        return this.f40404j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(long j11) {
        this.f40396b += j11;
        if (j11 > 0) {
            notifyAll();
        }
    }

    public void l(ErrorCode errorCode) {
        if (m(errorCode)) {
            this.f40398d.F0(this.f40397c, errorCode);
        }
    }

    public void n(ErrorCode errorCode) {
        if (m(errorCode)) {
            this.f40398d.G0(this.f40397c, errorCode);
        }
    }

    public int o() {
        return this.f40397c;
    }

    public synchronized List p() {
        List list;
        try {
            this.f40403i.enter();
            while (this.f40400f == null && this.f40405k == null) {
                try {
                    z();
                } catch (Throwable th2) {
                    this.f40403i.exitAndThrowIfTimedOut();
                    throw th2;
                }
            }
            this.f40403i.exitAndThrowIfTimedOut();
            list = this.f40400f;
            if (list == null) {
                throw new IOException("stream was reset: " + this.f40405k);
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return list;
    }

    public Sink q() {
        synchronized (this) {
            try {
                if (this.f40400f == null && !s()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f40402h;
    }

    public Source r() {
        return this.f40401g;
    }

    public boolean s() {
        return this.f40398d.f40364b == ((this.f40397c & 1) == 1);
    }

    public synchronized boolean t() {
        try {
            if (this.f40405k != null) {
                return false;
            }
            if (!this.f40401g.f40414e) {
                if (this.f40401g.f40413d) {
                }
                return true;
            }
            if (this.f40402h.f40408c || this.f40402h.f40407b) {
                if (this.f40400f != null) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public Timeout u() {
        return this.f40403i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(BufferedSource bufferedSource, int i11) {
        this.f40401g.l(bufferedSource, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        boolean t11;
        synchronized (this) {
            this.f40401g.f40414e = true;
            t11 = t();
            notifyAll();
        }
        if (t11) {
            return;
        }
        this.f40398d.v0(this.f40397c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(List list, HeadersMode headersMode) {
        ErrorCode errorCode;
        boolean z10;
        synchronized (this) {
            try {
                errorCode = null;
                z10 = true;
                if (this.f40400f == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.f40400f = list;
                        z10 = t();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f40400f);
                    arrayList.addAll(list);
                    this.f40400f = arrayList;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (errorCode != null) {
            n(errorCode);
        } else {
            if (z10) {
                return;
            }
            this.f40398d.v0(this.f40397c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void y(ErrorCode errorCode) {
        if (this.f40405k == null) {
            this.f40405k = errorCode;
            notifyAll();
        }
    }
}
