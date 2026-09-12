package com.mbridge.msdk.thrid.okhttp.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.internal.http.h;
import com.mbridge.msdk.thrid.okhttp.internal.http.k;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import com.mbridge.msdk.thrid.okio.i;
import com.mbridge.msdk.thrid.okio.l;
import com.mbridge.msdk.thrid.okio.r;
import com.mbridge.msdk.thrid.okio.s;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class a implements com.mbridge.msdk.thrid.okhttp.internal.http.c {

    /* renamed from: a, reason: collision with root package name */
    final t f38069a;

    /* renamed from: b, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.internal.connection.g f38070b;

    /* renamed from: c, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okio.e f38071c;

    /* renamed from: d, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okio.d f38072d;

    /* renamed from: e, reason: collision with root package name */
    int f38073e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f38074f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public abstract class b implements s {

        /* renamed from: a, reason: collision with root package name */
        protected final i f38075a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f38076b;

        /* renamed from: c, reason: collision with root package name */
        protected long f38077c;

        private b() {
            this.f38075a = new i(a.this.f38071c.b());
            this.f38077c = 0L;
        }

        protected final void a(boolean z10, IOException iOException) throws IOException {
            a aVar = a.this;
            int i11 = aVar.f38073e;
            if (i11 == 6) {
                return;
            }
            if (i11 != 5) {
                throw new IllegalStateException("state: " + a.this.f38073e);
            }
            aVar.a(this.f38075a);
            a aVar2 = a.this;
            aVar2.f38073e = 6;
            com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = aVar2.f38070b;
            if (gVar != null) {
                gVar.a(!z10, aVar2, this.f38077c, iOException);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            try {
                long b11 = a.this.f38071c.b(cVar, j11);
                if (b11 > 0) {
                    this.f38077c += b11;
                }
                return b11;
            } catch (IOException e11) {
                a(false, e11);
                throw e11;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public com.mbridge.msdk.thrid.okio.t b() {
            return this.f38075a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class c implements r {

        /* renamed from: a, reason: collision with root package name */
        private final i f38079a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f38080b;

        c() {
            this.f38079a = new i(a.this.f38072d.b());
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            if (this.f38080b) {
                throw new IllegalStateException("closed");
            }
            if (j11 == 0) {
                return;
            }
            a.this.f38072d.a(j11);
            a.this.f38072d.a("\r\n");
            a.this.f38072d.a(cVar, j11);
            a.this.f38072d.a("\r\n");
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public com.mbridge.msdk.thrid.okio.t b() {
            return this.f38079a;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f38080b) {
                return;
            }
            this.f38080b = true;
            a.this.f38072d.a("0\r\n\r\n");
            a.this.a(this.f38079a);
            a.this.f38073e = 3;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f38080b) {
                return;
            }
            a.this.f38072d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d extends b {

        /* renamed from: e, reason: collision with root package name */
        private final q f38082e;

        /* renamed from: f, reason: collision with root package name */
        private long f38083f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f38084g;

        d(q qVar) {
            super();
            this.f38083f = -1L;
            this.f38084g = true;
            this.f38082e = qVar;
        }

        private void d() throws IOException {
            if (this.f38083f != -1) {
                a.this.f38071c.c();
            }
            try {
                this.f38083f = a.this.f38071c.i();
                String trim = a.this.f38071c.c().trim();
                if (this.f38083f < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f38083f + trim + "\"");
                }
                if (this.f38083f == 0) {
                    this.f38084g = false;
                    com.mbridge.msdk.thrid.okhttp.internal.http.e.a(a.this.f38069a.i(), this.f38082e, a.this.f());
                    a(true, null);
                }
            } catch (NumberFormatException e11) {
                throw new ProtocolException(e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http1.a.b, com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f38076b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f38084g) {
                return -1L;
            }
            long j12 = this.f38083f;
            if (j12 == 0 || j12 == -1) {
                d();
                if (!this.f38084g) {
                    return -1L;
                }
            }
            long b11 = super.b(cVar, Math.min(j11, this.f38083f));
            if (b11 != -1) {
                this.f38083f -= b11;
                return b11;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, protocolException);
            throw protocolException;
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f38076b) {
                return;
            }
            if (this.f38084g && !com.mbridge.msdk.thrid.okhttp.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f38076b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class e implements r {

        /* renamed from: a, reason: collision with root package name */
        private final i f38086a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f38087b;

        /* renamed from: c, reason: collision with root package name */
        private long f38088c;

        e(long j11) {
            this.f38086a = new i(a.this.f38072d.b());
            this.f38088c = j11;
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            if (this.f38087b) {
                throw new IllegalStateException("closed");
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(cVar.size(), 0L, j11);
            if (j11 <= this.f38088c) {
                a.this.f38072d.a(cVar, j11);
                this.f38088c -= j11;
                return;
            }
            throw new ProtocolException("expected " + this.f38088c + " bytes but received " + j11);
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public com.mbridge.msdk.thrid.okio.t b() {
            return this.f38086a;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f38087b) {
                return;
            }
            this.f38087b = true;
            if (this.f38088c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.a(this.f38086a);
            a.this.f38073e = 3;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
        public void flush() throws IOException {
            if (this.f38087b) {
                return;
            }
            a.this.f38072d.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class f extends b {

        /* renamed from: e, reason: collision with root package name */
        private long f38090e;

        f(long j11) throws IOException {
            super();
            this.f38090e = j11;
            if (j11 == 0) {
                a(true, null);
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http1.a.b, com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f38076b) {
                throw new IllegalStateException("closed");
            }
            long j12 = this.f38090e;
            if (j12 == 0) {
                return -1L;
            }
            long b11 = super.b(cVar, Math.min(j12, j11));
            if (b11 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
            long j13 = this.f38090e - b11;
            this.f38090e = j13;
            if (j13 == 0) {
                a(true, null);
            }
            return b11;
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f38076b) {
                return;
            }
            if (this.f38090e != 0 && !com.mbridge.msdk.thrid.okhttp.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f38076b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class g extends b {

        /* renamed from: e, reason: collision with root package name */
        private boolean f38092e;

        g() {
            super();
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http1.a.b, com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            if (j11 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j11);
            }
            if (this.f38076b) {
                throw new IllegalStateException("closed");
            }
            if (this.f38092e) {
                return -1L;
            }
            long b11 = super.b(cVar, j11);
            if (b11 != -1) {
                return b11;
            }
            this.f38092e = true;
            a(true, null);
            return -1L;
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f38076b) {
                return;
            }
            if (!this.f38092e) {
                a(false, null);
            }
            this.f38076b = true;
        }
    }

    public a(t tVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, com.mbridge.msdk.thrid.okio.e eVar, com.mbridge.msdk.thrid.okio.d dVar) {
        this.f38069a = tVar;
        this.f38070b = gVar;
        this.f38071c = eVar;
        this.f38072d = dVar;
    }

    private String e() throws IOException {
        String d11 = this.f38071c.d(this.f38074f);
        this.f38074f -= d11.length();
        return d11;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public y.a a(boolean z10) throws IOException {
        int i11 = this.f38073e;
        if (i11 != 1 && i11 != 3) {
            throw new IllegalStateException("state: " + this.f38073e);
        }
        try {
            k a11 = k.a(e());
            y.a a12 = new y.a().a(a11.f38066a).a(a11.f38067b).a(a11.f38068c).a(f());
            if (z10 && a11.f38067b == 100) {
                return null;
            }
            if (a11.f38067b == 100) {
                this.f38073e = 3;
                return a12;
            }
            this.f38073e = 4;
            return a12;
        } catch (EOFException e11) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f38070b);
            iOException.initCause(e11);
            throw iOException;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public z a(y yVar) throws IOException {
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = this.f38070b;
        gVar.f38028f.responseBodyStart(gVar.f38027e);
        String b11 = yVar.b(HttpHeaders.CONTENT_TYPE);
        if (!com.mbridge.msdk.thrid.okhttp.internal.http.e.b(yVar)) {
            return new h(b11, 0L, l.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(yVar.b("Transfer-Encoding"))) {
            return new h(b11, -1L, l.a(a(yVar.r().g())));
        }
        long a11 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(yVar);
        return a11 != -1 ? new h(b11, a11, l.a(b(a11))) : new h(b11, -1L, l.a(d()));
    }

    public r a(long j11) {
        if (this.f38073e == 1) {
            this.f38073e = 2;
            return new e(j11);
        }
        throw new IllegalStateException("state: " + this.f38073e);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public r a(w wVar, long j11) {
        if ("chunked".equalsIgnoreCase(wVar.a("Transfer-Encoding"))) {
            return c();
        }
        if (j11 != -1) {
            return a(j11);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public s a(q qVar) throws IOException {
        if (this.f38073e == 4) {
            this.f38073e = 5;
            return new d(qVar);
        }
        throw new IllegalStateException("state: " + this.f38073e);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void a() throws IOException {
        this.f38072d.flush();
    }

    public void a(p pVar, String str) throws IOException {
        if (this.f38073e != 0) {
            throw new IllegalStateException("state: " + this.f38073e);
        }
        this.f38072d.a(str).a("\r\n");
        int b11 = pVar.b();
        for (int i11 = 0; i11 < b11; i11++) {
            this.f38072d.a(pVar.a(i11)).a(": ").a(pVar.b(i11)).a("\r\n");
        }
        this.f38072d.a("\r\n");
        this.f38073e = 1;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void a(w wVar) throws IOException {
        a(wVar.c(), com.mbridge.msdk.thrid.okhttp.internal.http.i.a(wVar, this.f38070b.c().c().b().type()));
    }

    void a(i iVar) {
        com.mbridge.msdk.thrid.okio.t g11 = iVar.g();
        iVar.a(com.mbridge.msdk.thrid.okio.t.f38529d);
        g11.a();
        g11.b();
    }

    public s b(long j11) throws IOException {
        if (this.f38073e == 4) {
            this.f38073e = 5;
            return new f(j11);
        }
        throw new IllegalStateException("state: " + this.f38073e);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void b() throws IOException {
        this.f38072d.flush();
    }

    public r c() {
        if (this.f38073e == 1) {
            this.f38073e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f38073e);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void cancel() {
        com.mbridge.msdk.thrid.okhttp.internal.connection.c c11 = this.f38070b.c();
        if (c11 != null) {
            c11.d();
        }
    }

    public s d() throws IOException {
        if (this.f38073e != 4) {
            throw new IllegalStateException("state: " + this.f38073e);
        }
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = this.f38070b;
        if (gVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f38073e = 5;
        gVar.e();
        return new g();
    }

    public p f() throws IOException {
        p.a aVar = new p.a();
        while (true) {
            String e11 = e();
            if (e11.length() == 0) {
                return aVar.a();
            }
            com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(aVar, e11);
        }
    }
}
