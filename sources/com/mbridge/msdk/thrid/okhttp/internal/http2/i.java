package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.http2.c;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okio.r;
import com.mbridge.msdk.thrid.okio.s;
import com.mbridge.msdk.thrid.okio.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ boolean f38231l = true;

    /* renamed from: a, reason: collision with root package name */
    long f38232a = 0;

    /* renamed from: b, reason: collision with root package name */
    long f38233b;

    /* renamed from: c, reason: collision with root package name */
    final int f38234c;

    /* renamed from: d, reason: collision with root package name */
    final g f38235d;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<p> f38236e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f38237f;

    /* renamed from: g, reason: collision with root package name */
    private final b f38238g;

    /* renamed from: h, reason: collision with root package name */
    final a f38239h;

    /* renamed from: i, reason: collision with root package name */
    final c f38240i;

    /* renamed from: j, reason: collision with root package name */
    final c f38241j;

    /* renamed from: k, reason: collision with root package name */
    com.mbridge.msdk.thrid.okhttp.internal.http2.b f38242k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class a implements r {

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ boolean f38243e = true;

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.c f38244a = new com.mbridge.msdk.thrid.okio.c();

        /* renamed from: b, reason: collision with root package name */
        boolean f38245b;

        /* renamed from: c, reason: collision with root package name */
        boolean f38246c;

        a() {
        }

        private void a(boolean z10) throws IOException {
            i iVar;
            long min;
            i iVar2;
            synchronized (i.this) {
                i.this.f38241j.h();
                while (true) {
                    try {
                        iVar = i.this;
                        if (iVar.f38233b > 0 || this.f38246c || this.f38245b || iVar.f38242k != null) {
                            break;
                        } else {
                            iVar.k();
                        }
                    } finally {
                        i.this.f38241j.k();
                    }
                }
                iVar.f38241j.k();
                i.this.b();
                min = Math.min(i.this.f38233b, this.f38244a.size());
                iVar2 = i.this;
                iVar2.f38233b -= min;
            }
            iVar2.f38241j.h();
            try {
                i iVar3 = i.this;
                iVar3.f38235d.a(iVar3.f38234c, z10 && min == this.f38244a.size(), this.f38244a, min);
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            if (!f38243e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.f38244a.a(cVar, j11);
            while (this.f38244a.size() >= 16384) {
                a(false);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public t b() {
            return i.this.f38241j;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f38243e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                try {
                    if (this.f38245b) {
                        return;
                    }
                    if (!i.this.f38239h.f38246c) {
                        if (this.f38244a.size() > 0) {
                            while (this.f38244a.size() > 0) {
                                a(true);
                            }
                        } else {
                            i iVar = i.this;
                            iVar.f38235d.a(iVar.f38234c, true, (com.mbridge.msdk.thrid.okio.c) null, 0L);
                        }
                    }
                    synchronized (i.this) {
                        this.f38245b = true;
                    }
                    i.this.f38235d.flush();
                    i.this.a();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
        public void flush() throws IOException {
            if (!f38243e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.b();
            }
            while (this.f38244a.size() > 0) {
                a(false);
                i.this.f38235d.flush();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class b implements s {

        /* renamed from: g, reason: collision with root package name */
        static final /* synthetic */ boolean f38248g = true;

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.c f38249a = new com.mbridge.msdk.thrid.okio.c();

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.c f38250b = new com.mbridge.msdk.thrid.okio.c();

        /* renamed from: c, reason: collision with root package name */
        private final long f38251c;

        /* renamed from: d, reason: collision with root package name */
        boolean f38252d;

        /* renamed from: e, reason: collision with root package name */
        boolean f38253e;

        b(long j11) {
            this.f38251c = j11;
        }

        private void f(long j11) {
            if (!f38248g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            i.this.f38235d.g(j11);
        }

        void a(com.mbridge.msdk.thrid.okio.e eVar, long j11) throws IOException {
            boolean z10;
            boolean z11;
            long j12;
            if (!f38248g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j11 > 0) {
                synchronized (i.this) {
                    z10 = this.f38253e;
                    z11 = this.f38250b.size() + j11 > this.f38251c;
                }
                if (z11) {
                    eVar.skip(j11);
                    i.this.c(com.mbridge.msdk.thrid.okhttp.internal.http2.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    eVar.skip(j11);
                    return;
                }
                long b11 = eVar.b(this.f38249a, j11);
                if (b11 == -1) {
                    throw new EOFException();
                }
                j11 -= b11;
                synchronized (i.this) {
                    try {
                        if (this.f38252d) {
                            j12 = this.f38249a.size();
                            this.f38249a.k();
                        } else {
                            boolean z12 = this.f38250b.size() == 0;
                            this.f38250b.a(this.f38249a);
                            if (z12) {
                                i.this.notifyAll();
                            }
                            j12 = 0;
                        }
                    } finally {
                    }
                }
                if (j12 > 0) {
                    f(j12);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        
            r12 = -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        
            r11.f38254f.f38240i.k();
         */
        @Override // com.mbridge.msdk.thrid.okio.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long b(com.mbridge.msdk.thrid.okio.c r12, long r13) throws java.io.IOException {
            /*
                r11 = this;
                r0 = 0
                int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
                if (r2 < 0) goto Lb3
            L6:
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r2 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this
                monitor-enter(r2)
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L85
                com.mbridge.msdk.thrid.okhttp.internal.http2.i$c r3 = r3.f38240i     // Catch: java.lang.Throwable -> L85
                r3.h()     // Catch: java.lang.Throwable -> L85
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L2c
                com.mbridge.msdk.thrid.okhttp.internal.http2.b r4 = r3.f38242k     // Catch: java.lang.Throwable -> L2c
                if (r4 == 0) goto L17
                goto L18
            L17:
                r4 = 0
            L18:
                boolean r5 = r11.f38252d     // Catch: java.lang.Throwable -> L2c
                if (r5 != 0) goto La1
                java.util.Deque r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.a(r3)     // Catch: java.lang.Throwable -> L2c
                boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L2c
                if (r3 != 0) goto L2f
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L2c
                com.mbridge.msdk.thrid.okhttp.internal.http2.i.b(r3)     // Catch: java.lang.Throwable -> L2c
                goto L2f
            L2c:
                r12 = move-exception
                goto La9
            L2f:
                com.mbridge.msdk.thrid.okio.c r3 = r11.f38250b     // Catch: java.lang.Throwable -> L2c
                long r5 = r3.size()     // Catch: java.lang.Throwable -> L2c
                int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                r5 = -1
                if (r3 <= 0) goto L71
                com.mbridge.msdk.thrid.okio.c r3 = r11.f38250b     // Catch: java.lang.Throwable -> L2c
                long r7 = r3.size()     // Catch: java.lang.Throwable -> L2c
                long r13 = java.lang.Math.min(r13, r7)     // Catch: java.lang.Throwable -> L2c
                long r12 = r3.b(r12, r13)     // Catch: java.lang.Throwable -> L2c
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r14 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L2c
                long r7 = r14.f38232a     // Catch: java.lang.Throwable -> L2c
                long r7 = r7 + r12
                r14.f38232a = r7     // Catch: java.lang.Throwable -> L2c
                if (r4 != 0) goto L88
                com.mbridge.msdk.thrid.okhttp.internal.http2.g r14 = r14.f38235d     // Catch: java.lang.Throwable -> L2c
                com.mbridge.msdk.thrid.okhttp.internal.http2.m r14 = r14.f38170t     // Catch: java.lang.Throwable -> L2c
                int r14 = r14.c()     // Catch: java.lang.Throwable -> L2c
                int r14 = r14 / 2
                long r9 = (long) r14     // Catch: java.lang.Throwable -> L2c
                int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r14 < 0) goto L88
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r14 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L2c
                com.mbridge.msdk.thrid.okhttp.internal.http2.g r3 = r14.f38235d     // Catch: java.lang.Throwable -> L2c
                int r7 = r14.f38234c     // Catch: java.lang.Throwable -> L2c
                long r8 = r14.f38232a     // Catch: java.lang.Throwable -> L2c
                r3.a(r7, r8)     // Catch: java.lang.Throwable -> L2c
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r14 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L2c
                r14.f38232a = r0     // Catch: java.lang.Throwable -> L2c
                goto L88
            L71:
                boolean r3 = r11.f38253e     // Catch: java.lang.Throwable -> L2c
                if (r3 != 0) goto L87
                if (r4 != 0) goto L87
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L2c
                r3.k()     // Catch: java.lang.Throwable -> L2c
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L85
                com.mbridge.msdk.thrid.okhttp.internal.http2.i$c r3 = r3.f38240i     // Catch: java.lang.Throwable -> L85
                r3.k()     // Catch: java.lang.Throwable -> L85
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                goto L6
            L85:
                r12 = move-exception
                goto Lb1
            L87:
                r12 = r5
            L88:
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r14 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L85
                com.mbridge.msdk.thrid.okhttp.internal.http2.i$c r14 = r14.f38240i     // Catch: java.lang.Throwable -> L85
                r14.k()     // Catch: java.lang.Throwable -> L85
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r14 == 0) goto L98
                r11.f(r12)
                return r12
            L98:
                if (r4 != 0) goto L9b
                return r5
            L9b:
                com.mbridge.msdk.thrid.okhttp.internal.http2.n r12 = new com.mbridge.msdk.thrid.okhttp.internal.http2.n
                r12.<init>(r4)
                throw r12
            La1:
                java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L2c
                java.lang.String r13 = "stream closed"
                r12.<init>(r13)     // Catch: java.lang.Throwable -> L2c
                throw r12     // Catch: java.lang.Throwable -> L2c
            La9:
                com.mbridge.msdk.thrid.okhttp.internal.http2.i r13 = com.mbridge.msdk.thrid.okhttp.internal.http2.i.this     // Catch: java.lang.Throwable -> L85
                com.mbridge.msdk.thrid.okhttp.internal.http2.i$c r13 = r13.f38240i     // Catch: java.lang.Throwable -> L85
                r13.k()     // Catch: java.lang.Throwable -> L85
                throw r12     // Catch: java.lang.Throwable -> L85
            Lb1:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L85
                throw r12
            Lb3:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r13)
                java.lang.String r13 = r0.toString()
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.i.b.b(com.mbridge.msdk.thrid.okio.c, long):long");
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public t b() {
            return i.this.f38240i;
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            synchronized (i.this) {
                try {
                    this.f38252d = true;
                    size = this.f38250b.size();
                    this.f38250b.k();
                    if (!i.this.f38236e.isEmpty()) {
                        i.b(i.this);
                    }
                    i.this.notifyAll();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (size > 0) {
                f(size);
            }
            i.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends com.mbridge.msdk.thrid.okio.a {
        c() {
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected void j() {
            i.this.c(com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
            i.this.f38235d.l();
        }

        public void k() throws IOException {
            if (i()) {
                throw b((IOException) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i11, g gVar, boolean z10, boolean z11, p pVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f38236e = arrayDeque;
        this.f38240i = new c();
        this.f38241j = new c();
        this.f38242k = null;
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.f38234c = i11;
        this.f38235d = gVar;
        this.f38233b = gVar.f38171u.c();
        b bVar = new b(gVar.f38170t.c());
        this.f38238g = bVar;
        a aVar = new a();
        this.f38239h = aVar;
        bVar.f38253e = z11;
        aVar.f38246c = z10;
        if (pVar != null) {
            arrayDeque.add(pVar);
        }
        if (f() && pVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!f() && pVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    static /* synthetic */ c.a b(i iVar) {
        iVar.getClass();
        return null;
    }

    private boolean b(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        if (!f38231l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                if (this.f38242k != null) {
                    return false;
                }
                if (this.f38238g.f38253e && this.f38239h.f38246c) {
                    return false;
                }
                this.f38242k = bVar;
                notifyAll();
                this.f38235d.c(this.f38234c);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    void a() throws IOException {
        boolean z10;
        boolean g11;
        if (!f38231l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                b bVar = this.f38238g;
                if (!bVar.f38253e && bVar.f38252d) {
                    a aVar = this.f38239h;
                    if (!aVar.f38246c) {
                        if (aVar.f38245b) {
                        }
                    }
                    z10 = true;
                    g11 = g();
                }
                z10 = false;
                g11 = g();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
        } else {
            if (g11) {
                return;
            }
            this.f38235d.c(this.f38234c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j11) {
        this.f38233b += j11;
        if (j11 > 0) {
            notifyAll();
        }
    }

    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) throws IOException {
        if (b(bVar)) {
            this.f38235d.b(this.f38234c, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.mbridge.msdk.thrid.okio.e eVar, int i11) throws IOException {
        if (!f38231l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f38238g.a(eVar, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
        boolean g11;
        if (!f38231l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f38237f = true;
            this.f38236e.add(com.mbridge.msdk.thrid.okhttp.internal.c.b(list));
            g11 = g();
            notifyAll();
        }
        if (g11) {
            return;
        }
        this.f38235d.c(this.f38234c);
    }

    void b() throws IOException {
        a aVar = this.f38239h;
        if (aVar.f38245b) {
            throw new IOException("stream closed");
        }
        if (aVar.f38246c) {
            throw new IOException("stream finished");
        }
        if (this.f38242k != null) {
            throw new n(this.f38242k);
        }
    }

    public int c() {
        return this.f38234c;
    }

    public void c(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        if (b(bVar)) {
            this.f38235d.c(this.f38234c, bVar);
        }
    }

    public r d() {
        synchronized (this) {
            try {
                if (!this.f38237f && !f()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f38239h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        if (this.f38242k == null) {
            this.f38242k = bVar;
            notifyAll();
        }
    }

    public s e() {
        return this.f38238g;
    }

    public boolean f() {
        return this.f38235d.f38151a == ((this.f38234c & 1) == 1);
    }

    public synchronized boolean g() {
        try {
            if (this.f38242k != null) {
                return false;
            }
            b bVar = this.f38238g;
            if (!bVar.f38253e) {
                if (bVar.f38252d) {
                }
                return true;
            }
            a aVar = this.f38239h;
            if (aVar.f38246c || aVar.f38245b) {
                if (this.f38237f) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public t h() {
        return this.f38240i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        boolean g11;
        if (!f38231l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f38238g.f38253e = true;
            g11 = g();
            notifyAll();
        }
        if (g11) {
            return;
        }
        this.f38235d.c(this.f38234c);
    }

    public synchronized p j() throws IOException {
        this.f38240i.h();
        while (this.f38236e.isEmpty() && this.f38242k == null) {
            try {
                k();
            } catch (Throwable th2) {
                this.f38240i.k();
                throw th2;
            }
        }
        this.f38240i.k();
        if (this.f38236e.isEmpty()) {
            throw new n(this.f38242k);
        }
        return this.f38236e.removeFirst();
    }

    void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public t l() {
        return this.f38241j;
    }
}
