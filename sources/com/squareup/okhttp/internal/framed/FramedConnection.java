package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes5.dex */
public final class FramedConnection implements Closeable {

    /* renamed from: x, reason: collision with root package name */
    private static final ExecutorService f40362x = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.squareup.okhttp.internal.g.s("OkHttp FramedConnection", true));

    /* renamed from: a, reason: collision with root package name */
    final Protocol f40363a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f40364b;

    /* renamed from: c, reason: collision with root package name */
    private final b f40365c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f40366d;

    /* renamed from: e, reason: collision with root package name */
    private final String f40367e;

    /* renamed from: f, reason: collision with root package name */
    private int f40368f;

    /* renamed from: g, reason: collision with root package name */
    private int f40369g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f40370h;

    /* renamed from: i, reason: collision with root package name */
    private long f40371i;

    /* renamed from: j, reason: collision with root package name */
    private final ExecutorService f40372j;

    /* renamed from: k, reason: collision with root package name */
    private Map f40373k;

    /* renamed from: l, reason: collision with root package name */
    private final PushObserver f40374l;

    /* renamed from: m, reason: collision with root package name */
    private int f40375m;

    /* renamed from: n, reason: collision with root package name */
    long f40376n;

    /* renamed from: o, reason: collision with root package name */
    long f40377o;

    /* renamed from: p, reason: collision with root package name */
    h f40378p;

    /* renamed from: q, reason: collision with root package name */
    final h f40379q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f40380r;

    /* renamed from: s, reason: collision with root package name */
    final Variant f40381s;

    /* renamed from: t, reason: collision with root package name */
    final Socket f40382t;

    /* renamed from: u, reason: collision with root package name */
    final FrameWriter f40383u;

    /* renamed from: v, reason: collision with root package name */
    final Reader f40384v;

    /* renamed from: w, reason: collision with root package name */
    private final Set f40385w;

    /* loaded from: classes5.dex */
    class Reader extends NamedRunnable implements FrameReader.Handler {
        final FrameReader frameReader;

        private Reader(FrameReader frameReader) {
            super("OkHttp %s", FramedConnection.this.f40367e);
            this.frameReader = frameReader;
        }

        private void ackSettingsLater(final h hVar) {
            FramedConnection.f40362x.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{FramedConnection.this.f40367e}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.3
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        FramedConnection.this.f40383u.ackSettings(hVar);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i11, String str, ByteString byteString, String str2, int i12, long j11) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z10, int i11, BufferedSource bufferedSource, int i12) throws IOException {
            if (FramedConnection.this.r0(i11)) {
                FramedConnection.this.m0(i11, bufferedSource, i12, z10);
                return;
            }
            com.squareup.okhttp.internal.framed.a g02 = FramedConnection.this.g0(i11);
            if (g02 == null) {
                FramedConnection.this.G0(i11, ErrorCode.INVALID_STREAM);
                bufferedSource.skip(i12);
            } else {
                g02.v(bufferedSource, i12);
                if (z10) {
                    g02.w();
                }
            }
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    if (!FramedConnection.this.f40364b) {
                        this.frameReader.readConnectionPreface();
                    }
                    do {
                    } while (this.frameReader.nextFrame(this));
                    errorCode2 = ErrorCode.NO_ERROR;
                    try {
                        try {
                            FramedConnection.this.c0(errorCode2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                            FramedConnection.this.c0(errorCode4, errorCode4);
                            com.squareup.okhttp.internal.g.c(this.frameReader);
                        }
                    } catch (Throwable th2) {
                        errorCode = errorCode2;
                        th = th2;
                        try {
                            FramedConnection.this.c0(errorCode, errorCode3);
                        } catch (IOException unused2) {
                        }
                        com.squareup.okhttp.internal.g.c(this.frameReader);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                errorCode2 = errorCode3;
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode3;
                FramedConnection.this.c0(errorCode, errorCode3);
                com.squareup.okhttp.internal.g.c(this.frameReader);
                throw th;
            }
            com.squareup.okhttp.internal.g.c(this.frameReader);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i11, ErrorCode errorCode, ByteString byteString) {
            com.squareup.okhttp.internal.framed.a[] aVarArr;
            byteString.size();
            synchronized (FramedConnection.this) {
                aVarArr = (com.squareup.okhttp.internal.framed.a[]) FramedConnection.this.f40366d.values().toArray(new com.squareup.okhttp.internal.framed.a[FramedConnection.this.f40366d.size()]);
                FramedConnection.this.f40370h = true;
            }
            for (com.squareup.okhttp.internal.framed.a aVar : aVarArr) {
                if (aVar.o() > i11 && aVar.s()) {
                    aVar.y(ErrorCode.REFUSED_STREAM);
                    FramedConnection.this.v0(aVar.o());
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z10, boolean z11, int i11, int i12, List<com.squareup.okhttp.internal.framed.b> list, HeadersMode headersMode) {
            if (FramedConnection.this.r0(i11)) {
                FramedConnection.this.o0(i11, list, z11);
                return;
            }
            synchronized (FramedConnection.this) {
                try {
                    if (FramedConnection.this.f40370h) {
                        return;
                    }
                    com.squareup.okhttp.internal.framed.a g02 = FramedConnection.this.g0(i11);
                    if (g02 != null) {
                        if (headersMode.failIfStreamPresent()) {
                            g02.n(ErrorCode.PROTOCOL_ERROR);
                            FramedConnection.this.v0(i11);
                            return;
                        } else {
                            g02.x(list, headersMode);
                            if (z11) {
                                g02.w();
                                return;
                            }
                            return;
                        }
                    }
                    if (headersMode.failIfStreamAbsent()) {
                        FramedConnection.this.G0(i11, ErrorCode.INVALID_STREAM);
                        return;
                    }
                    if (i11 <= FramedConnection.this.f40368f) {
                        return;
                    }
                    if (i11 % 2 == FramedConnection.this.f40369g % 2) {
                        return;
                    }
                    final com.squareup.okhttp.internal.framed.a aVar = new com.squareup.okhttp.internal.framed.a(i11, FramedConnection.this, z10, z11, list);
                    FramedConnection.this.f40368f = i11;
                    FramedConnection.this.f40366d.put(Integer.valueOf(i11), aVar);
                    FramedConnection.f40362x.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{FramedConnection.this.f40367e, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.1
                        @Override // com.squareup.okhttp.internal.NamedRunnable
                        public void execute() {
                            try {
                                FramedConnection.this.f40365c.b(aVar);
                            } catch (IOException e11) {
                                com.squareup.okhttp.internal.c.logger.log(Level.INFO, "FramedConnection.Listener failure for " + FramedConnection.this.f40367e, (Throwable) e11);
                                try {
                                    aVar.l(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z10, int i11, int i12) {
            if (z10) {
                FramedConnection.w(FramedConnection.this, i11);
            } else {
                FramedConnection.this.E0(true, i11, i12, null);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i11, int i12, int i13, boolean z10) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i11, int i12, List<com.squareup.okhttp.internal.framed.b> list) {
            FramedConnection.this.p0(i12, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i11, ErrorCode errorCode) {
            if (FramedConnection.this.r0(i11)) {
                FramedConnection.this.q0(i11, errorCode);
                return;
            }
            com.squareup.okhttp.internal.framed.a v02 = FramedConnection.this.v0(i11);
            if (v02 != null) {
                v02.y(errorCode);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z10, h hVar) {
            com.squareup.okhttp.internal.framed.a[] aVarArr;
            long j11;
            synchronized (FramedConnection.this) {
                try {
                    int e11 = FramedConnection.this.f40379q.e(65536);
                    if (z10) {
                        FramedConnection.this.f40379q.a();
                    }
                    FramedConnection.this.f40379q.j(hVar);
                    if (FramedConnection.this.d0() == Protocol.HTTP_2) {
                        ackSettingsLater(hVar);
                    }
                    int e12 = FramedConnection.this.f40379q.e(65536);
                    aVarArr = null;
                    if (e12 == -1 || e12 == e11) {
                        j11 = 0;
                    } else {
                        j11 = e12 - e11;
                        if (!FramedConnection.this.f40380r) {
                            FramedConnection.this.a0(j11);
                            FramedConnection.this.f40380r = true;
                        }
                        if (!FramedConnection.this.f40366d.isEmpty()) {
                            aVarArr = (com.squareup.okhttp.internal.framed.a[]) FramedConnection.this.f40366d.values().toArray(new com.squareup.okhttp.internal.framed.a[FramedConnection.this.f40366d.size()]);
                        }
                    }
                    FramedConnection.f40362x.execute(new NamedRunnable("OkHttp %s settings", FramedConnection.this.f40367e) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.2
                        @Override // com.squareup.okhttp.internal.NamedRunnable
                        public void execute() {
                            FramedConnection.this.f40365c.a(FramedConnection.this);
                        }
                    });
                } finally {
                }
            }
            if (aVarArr == null || j11 == 0) {
                return;
            }
            for (com.squareup.okhttp.internal.framed.a aVar : aVarArr) {
                synchronized (aVar) {
                    aVar.i(j11);
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i11, long j11) {
            if (i11 == 0) {
                synchronized (FramedConnection.this) {
                    FramedConnection framedConnection = FramedConnection.this;
                    framedConnection.f40377o += j11;
                    framedConnection.notifyAll();
                }
                return;
            }
            com.squareup.okhttp.internal.framed.a g02 = FramedConnection.this.g0(i11);
            if (g02 != null) {
                synchronized (g02) {
                    g02.i(j11);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Socket f40386a;

        /* renamed from: b, reason: collision with root package name */
        private String f40387b;

        /* renamed from: c, reason: collision with root package name */
        private BufferedSource f40388c;

        /* renamed from: d, reason: collision with root package name */
        private BufferedSink f40389d;

        /* renamed from: e, reason: collision with root package name */
        private b f40390e = b.f40394a;

        /* renamed from: f, reason: collision with root package name */
        private Protocol f40391f = Protocol.SPDY_3;

        /* renamed from: g, reason: collision with root package name */
        private PushObserver f40392g = PushObserver.CANCEL;

        /* renamed from: h, reason: collision with root package name */
        private boolean f40393h;

        public a(boolean z10) {
            this.f40393h = z10;
        }

        public FramedConnection i() {
            return new FramedConnection(this);
        }

        public a j(Protocol protocol) {
            this.f40391f = protocol;
            return this;
        }

        public a k(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f40386a = socket;
            this.f40387b = str;
            this.f40388c = bufferedSource;
            this.f40389d = bufferedSink;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f40394a = new a();

        /* loaded from: classes5.dex */
        static class a extends b {
            a() {
            }

            @Override // com.squareup.okhttp.internal.framed.FramedConnection.b
            public void b(com.squareup.okhttp.internal.framed.a aVar) {
                aVar.l(ErrorCode.REFUSED_STREAM);
            }
        }

        public void a(FramedConnection framedConnection) {
        }

        public abstract void b(com.squareup.okhttp.internal.framed.a aVar);
    }

    private FramedConnection(a aVar) {
        this.f40366d = new HashMap();
        this.f40371i = System.nanoTime();
        this.f40376n = 0L;
        this.f40378p = new h();
        h hVar = new h();
        this.f40379q = hVar;
        this.f40380r = false;
        this.f40385w = new LinkedHashSet();
        Protocol protocol = aVar.f40391f;
        this.f40363a = protocol;
        this.f40374l = aVar.f40392g;
        boolean z10 = aVar.f40393h;
        this.f40364b = z10;
        this.f40365c = aVar.f40390e;
        this.f40369g = aVar.f40393h ? 1 : 2;
        if (aVar.f40393h && protocol == Protocol.HTTP_2) {
            this.f40369g += 2;
        }
        this.f40375m = aVar.f40393h ? 1 : 2;
        if (aVar.f40393h) {
            this.f40378p.l(7, 0, 16777216);
        }
        String str = aVar.f40387b;
        this.f40367e = str;
        if (protocol == Protocol.HTTP_2) {
            this.f40381s = new d();
            this.f40372j = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.squareup.okhttp.internal.g.s(String.format("OkHttp %s Push Observer", str), true));
            hVar.l(7, 0, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            hVar.l(5, 0, 16384);
        } else {
            if (protocol != Protocol.SPDY_3) {
                throw new AssertionError(protocol);
            }
            this.f40381s = new i();
            this.f40372j = null;
        }
        this.f40377o = hVar.e(65536);
        this.f40382t = aVar.f40386a;
        this.f40383u = this.f40381s.newWriter(aVar.f40389d, z10);
        Reader reader = new Reader(this.f40381s.newReader(aVar.f40388c, z10));
        this.f40384v = reader;
        new Thread(reader).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(boolean z10, int i11, int i12, g gVar) {
        synchronized (this.f40383u) {
            this.f40383u.ping(z10, i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(boolean z10, int i11, int i12, g gVar) {
        f40362x.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.f40367e, Integer.valueOf(i11), Integer.valueOf(i12)}, z10, i11, i12, gVar) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.3
            final /* synthetic */ int val$payload1;
            final /* synthetic */ int val$payload2;
            final /* synthetic */ g val$ping;
            final /* synthetic */ boolean val$reply;

            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.C0(this.val$reply, this.val$payload1, this.val$payload2, null);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(ErrorCode errorCode, ErrorCode errorCode2) {
        com.squareup.okhttp.internal.framed.a[] aVarArr;
        g[] gVarArr;
        try {
            z0(errorCode);
            e = null;
        } catch (IOException e11) {
            e = e11;
        }
        synchronized (this) {
            try {
                if (this.f40366d.isEmpty()) {
                    aVarArr = null;
                } else {
                    aVarArr = (com.squareup.okhttp.internal.framed.a[]) this.f40366d.values().toArray(new com.squareup.okhttp.internal.framed.a[this.f40366d.size()]);
                    this.f40366d.clear();
                    y0(false);
                }
                Map map = this.f40373k;
                if (map != null) {
                    gVarArr = (g[]) map.values().toArray(new g[this.f40373k.size()]);
                    this.f40373k = null;
                } else {
                    gVarArr = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (aVarArr != null) {
            for (com.squareup.okhttp.internal.framed.a aVar : aVarArr) {
                try {
                    aVar.l(errorCode2);
                } catch (IOException e12) {
                    if (e != null) {
                        e = e12;
                    }
                }
            }
        }
        if (gVarArr != null && gVarArr.length > 0) {
            g gVar = gVarArr[0];
            throw null;
        }
        try {
            this.f40383u.close();
        } catch (IOException e13) {
            if (e == null) {
                e = e13;
            }
        }
        try {
            this.f40382t.close();
        } catch (IOException e14) {
            e = e14;
        }
        if (e != null) {
            throw e;
        }
    }

    private com.squareup.okhttp.internal.framed.a k0(int i11, List list, boolean z10, boolean z11) {
        int i12;
        com.squareup.okhttp.internal.framed.a aVar;
        boolean z12 = !z10;
        boolean z13 = !z11;
        synchronized (this.f40383u) {
            try {
                synchronized (this) {
                    try {
                        if (this.f40370h) {
                            throw new IOException("shutdown");
                        }
                        i12 = this.f40369g;
                        this.f40369g = i12 + 2;
                        aVar = new com.squareup.okhttp.internal.framed.a(i12, this, z12, z13, list);
                        if (aVar.t()) {
                            this.f40366d.put(Integer.valueOf(i12), aVar);
                            y0(false);
                        }
                    } finally {
                    }
                }
                if (i11 == 0) {
                    this.f40383u.synStream(z12, z13, i12, i11, list);
                } else {
                    if (this.f40364b) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.f40383u.pushPromise(i11, i12, list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!z10) {
            this.f40383u.flush();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(final int i11, BufferedSource bufferedSource, final int i12, final boolean z10) {
        final Buffer buffer = new Buffer();
        long j11 = i12;
        bufferedSource.require(j11);
        bufferedSource.read(buffer, j11);
        if (buffer.size() == j11) {
            this.f40372j.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f40367e, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.6
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = FramedConnection.this.f40374l.onData(i11, buffer, i12, z10);
                        if (onData) {
                            FramedConnection.this.f40383u.rstStream(i11, ErrorCode.CANCEL);
                        }
                        if (onData || z10) {
                            synchronized (FramedConnection.this) {
                                FramedConnection.this.f40385w.remove(Integer.valueOf(i11));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(final int i11, final List list, final boolean z10) {
        this.f40372j.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f40367e, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.5
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                boolean onHeaders = FramedConnection.this.f40374l.onHeaders(i11, list, z10);
                if (onHeaders) {
                    try {
                        FramedConnection.this.f40383u.rstStream(i11, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (onHeaders || z10) {
                    synchronized (FramedConnection.this) {
                        FramedConnection.this.f40385w.remove(Integer.valueOf(i11));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(final int i11, final List list) {
        synchronized (this) {
            try {
                if (this.f40385w.contains(Integer.valueOf(i11))) {
                    G0(i11, ErrorCode.PROTOCOL_ERROR);
                } else {
                    this.f40385w.add(Integer.valueOf(i11));
                    this.f40372j.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f40367e, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.4
                        @Override // com.squareup.okhttp.internal.NamedRunnable
                        public void execute() {
                            if (FramedConnection.this.f40374l.onRequest(i11, list)) {
                                try {
                                    FramedConnection.this.f40383u.rstStream(i11, ErrorCode.CANCEL);
                                    synchronized (FramedConnection.this) {
                                        FramedConnection.this.f40385w.remove(Integer.valueOf(i11));
                                    }
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(final int i11, final ErrorCode errorCode) {
        this.f40372j.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f40367e, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.7
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                FramedConnection.this.f40374l.onReset(i11, errorCode);
                synchronized (FramedConnection.this) {
                    FramedConnection.this.f40385w.remove(Integer.valueOf(i11));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r0(int i11) {
        return this.f40363a == Protocol.HTTP_2 && i11 != 0 && (i11 & 1) == 0;
    }

    private synchronized g u0(int i11) {
        Map map = this.f40373k;
        if (map != null) {
            android.support.v4.media.session.c.a(map.remove(Integer.valueOf(i11)));
        }
        return null;
    }

    static /* synthetic */ g w(FramedConnection framedConnection, int i11) {
        framedConnection.u0(i11);
        return null;
    }

    private synchronized void y0(boolean z10) {
        long nanoTime;
        if (z10) {
            try {
                nanoTime = System.nanoTime();
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            nanoTime = Long.MAX_VALUE;
        }
        this.f40371i = nanoTime;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f40383u.maxDataLength());
        r6 = r2;
        r8.f40377o -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B0(int r9, boolean r10, okio.Buffer r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            com.squareup.okhttp.internal.framed.FrameWriter r12 = r8.f40383u
            r12.data(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r4 = r8.f40377o     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.Map r2 = r8.f40366d     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L5e
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            com.squareup.okhttp.internal.framed.FrameWriter r4 = r8.f40383u     // Catch: java.lang.Throwable -> L28
            int r4 = r4.maxDataLength()     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f40377o     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f40377o = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.squareup.okhttp.internal.framed.FrameWriter r4 = r8.f40383u
            if (r10 == 0) goto L53
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = r3
        L54:
            r4.data(r5, r9, r11, r2)
            goto Ld
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedConnection.B0(int, boolean, okio.Buffer, long):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0(int i11, ErrorCode errorCode) {
        this.f40383u.rstStream(i11, errorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0(final int i11, final ErrorCode errorCode) {
        f40362x.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f40367e, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.1
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.F0(i11, errorCode);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H0(final int i11, final long j11) {
        f40362x.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f40367e, Integer.valueOf(i11)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.2
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    FramedConnection.this.f40383u.windowUpdate(i11, j11);
                } catch (IOException unused) {
                }
            }
        });
    }

    void a0(long j11) {
        this.f40377o += j11;
        if (j11 > 0) {
            notifyAll();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c0(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public Protocol d0() {
        return this.f40363a;
    }

    public void flush() {
        this.f40383u.flush();
    }

    synchronized com.squareup.okhttp.internal.framed.a g0(int i11) {
        return (com.squareup.okhttp.internal.framed.a) this.f40366d.get(Integer.valueOf(i11));
    }

    public synchronized int h0() {
        return this.f40379q.f(Integer.MAX_VALUE);
    }

    public com.squareup.okhttp.internal.framed.a l0(List list, boolean z10, boolean z11) {
        return k0(0, list, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.squareup.okhttp.internal.framed.a v0(int i11) {
        com.squareup.okhttp.internal.framed.a aVar;
        try {
            aVar = (com.squareup.okhttp.internal.framed.a) this.f40366d.remove(Integer.valueOf(i11));
            if (aVar != null && this.f40366d.isEmpty()) {
                y0(true);
            }
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
        return aVar;
    }

    public void x0() {
        this.f40383u.connectionPreface();
        this.f40383u.settings(this.f40378p);
        if (this.f40378p.e(65536) != 65536) {
            this.f40383u.windowUpdate(0, r0 - 65536);
        }
    }

    public void z0(ErrorCode errorCode) {
        synchronized (this.f40383u) {
            synchronized (this) {
                if (this.f40370h) {
                    return;
                }
                this.f40370h = true;
                this.f40383u.goAway(this.f40368f, errorCode, com.squareup.okhttp.internal.g.f40484a);
            }
        }
    }
}
