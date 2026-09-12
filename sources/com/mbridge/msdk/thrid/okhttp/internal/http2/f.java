package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import com.mbridge.msdk.thrid.okio.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.Header;

/* loaded from: classes5.dex */
public final class f implements com.mbridge.msdk.thrid.okhttp.internal.http.c {

    /* renamed from: f, reason: collision with root package name */
    private static final List<String> f38140f = com.mbridge.msdk.thrid.okhttp.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: g, reason: collision with root package name */
    private static final List<String> f38141g = com.mbridge.msdk.thrid.okhttp.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    private final r.a f38142a;

    /* renamed from: b, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.internal.connection.g f38143b;

    /* renamed from: c, reason: collision with root package name */
    private final g f38144c;

    /* renamed from: d, reason: collision with root package name */
    private i f38145d;

    /* renamed from: e, reason: collision with root package name */
    private final u f38146e;

    /* loaded from: classes5.dex */
    class a extends com.mbridge.msdk.thrid.okio.h {

        /* renamed from: b, reason: collision with root package name */
        boolean f38147b;

        /* renamed from: c, reason: collision with root package name */
        long f38148c;

        a(s sVar) {
            super(sVar);
            this.f38147b = false;
            this.f38148c = 0L;
        }

        private void a(IOException iOException) {
            if (this.f38147b) {
                return;
            }
            this.f38147b = true;
            f fVar = f.this;
            fVar.f38143b.a(false, fVar, this.f38148c, iOException);
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            try {
                long b11 = d().b(cVar, j11);
                if (b11 > 0) {
                    this.f38148c += b11;
                }
                return b11;
            } catch (IOException e11) {
                a(e11);
                throw e11;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.h, com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }
    }

    public f(t tVar, r.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, g gVar2) {
        this.f38142a = aVar;
        this.f38143b = gVar;
        this.f38144c = gVar2;
        List<u> u11 = tVar.u();
        u uVar = u.H2_PRIOR_KNOWLEDGE;
        this.f38146e = u11.contains(uVar) ? uVar : u.HTTP_2;
    }

    public static y.a a(p pVar, u uVar) throws IOException {
        p.a aVar = new p.a();
        int b11 = pVar.b();
        com.mbridge.msdk.thrid.okhttp.internal.http.k kVar = null;
        for (int i11 = 0; i11 < b11; i11++) {
            String a11 = pVar.a(i11);
            String b12 = pVar.b(i11);
            if (a11.equals(Header.RESPONSE_STATUS_UTF8)) {
                kVar = com.mbridge.msdk.thrid.okhttp.internal.http.k.a("HTTP/1.1 " + b12);
            } else if (!f38141g.contains(a11)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(aVar, a11, b12);
            }
        }
        if (kVar != null) {
            return new y.a().a(uVar).a(kVar.f38067b).a(kVar.f38068c).a(aVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<c> b(w wVar) {
        p c11 = wVar.c();
        ArrayList arrayList = new ArrayList(c11.b() + 4);
        arrayList.add(new c(c.f38109f, wVar.e()));
        arrayList.add(new c(c.f38110g, com.mbridge.msdk.thrid.okhttp.internal.http.i.a(wVar.g())));
        String a11 = wVar.a(HttpHeaders.HOST);
        if (a11 != null) {
            arrayList.add(new c(c.f38112i, a11));
        }
        arrayList.add(new c(c.f38111h, wVar.g().l()));
        int b11 = c11.b();
        for (int i11 = 0; i11 < b11; i11++) {
            com.mbridge.msdk.thrid.okio.f c12 = com.mbridge.msdk.thrid.okio.f.c(c11.a(i11).toLowerCase(Locale.US));
            if (!f38140f.contains(c12.h())) {
                arrayList.add(new c(c12, c11.b(i11)));
            }
        }
        return arrayList;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public y.a a(boolean z10) throws IOException {
        y.a a11 = a(this.f38145d.j(), this.f38146e);
        if (z10 && com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(a11) == 100) {
            return null;
        }
        return a11;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public z a(y yVar) throws IOException {
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = this.f38143b;
        gVar.f38028f.responseBodyStart(gVar.f38027e);
        return new com.mbridge.msdk.thrid.okhttp.internal.http.h(yVar.b(HttpHeaders.CONTENT_TYPE), com.mbridge.msdk.thrid.okhttp.internal.http.e.a(yVar), com.mbridge.msdk.thrid.okio.l.a(new a(this.f38145d.e())));
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public com.mbridge.msdk.thrid.okio.r a(w wVar, long j11) {
        return this.f38145d.d();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void a() throws IOException {
        this.f38145d.d().close();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void a(w wVar) throws IOException {
        if (this.f38145d != null) {
            return;
        }
        i a11 = this.f38144c.a(b(wVar), wVar.a() != null);
        this.f38145d = a11;
        com.mbridge.msdk.thrid.okio.t h11 = a11.h();
        long b11 = this.f38142a.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h11.a(b11, timeUnit);
        this.f38145d.l().a(this.f38142a.c(), timeUnit);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void b() throws IOException {
        this.f38144c.flush();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void cancel() {
        i iVar = this.f38145d;
        if (iVar != null) {
            iVar.c(b.CANCEL);
        }
    }
}
