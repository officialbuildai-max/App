package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: classes5.dex */
public final class b implements r {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f38039a;

    /* loaded from: classes5.dex */
    static final class a extends com.mbridge.msdk.thrid.okio.g {

        /* renamed from: b, reason: collision with root package name */
        long f38040b;

        a(com.mbridge.msdk.thrid.okio.r rVar) {
            super(rVar);
        }

        @Override // com.mbridge.msdk.thrid.okio.g, com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            super.a(cVar, j11);
            this.f38040b += j11;
        }
    }

    public b(boolean z10) {
        this.f38039a = z10;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        g gVar = (g) aVar;
        c h11 = gVar.h();
        com.mbridge.msdk.thrid.okhttp.internal.connection.g i11 = gVar.i();
        com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar = (com.mbridge.msdk.thrid.okhttp.internal.connection.c) gVar.f();
        w d11 = gVar.d();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.g().requestHeadersStart(gVar.e());
        h11.a(d11);
        gVar.g().requestHeadersEnd(gVar.e(), d11);
        y.a aVar2 = null;
        if (f.a(d11.e()) && d11.a() != null) {
            if ("100-continue".equalsIgnoreCase(d11.a("Expect"))) {
                h11.b();
                gVar.g().responseHeadersStart(gVar.e());
                aVar2 = h11.a(true);
            }
            if (aVar2 == null) {
                gVar.g().requestBodyStart(gVar.e());
                a aVar3 = new a(h11.a(d11, d11.a().a()));
                com.mbridge.msdk.thrid.okio.d a11 = l.a(aVar3);
                d11.a().a(a11);
                a11.close();
                gVar.g().requestBodyEnd(gVar.e(), aVar3.f38040b);
            } else if (!cVar.f()) {
                i11.e();
            }
        }
        h11.a();
        if (aVar2 == null) {
            gVar.g().responseHeadersStart(gVar.e());
            aVar2 = h11.a(false);
        }
        y a12 = aVar2.a(d11).a(i11.c().b()).b(currentTimeMillis).a(System.currentTimeMillis()).a();
        int k11 = a12.k();
        if (k11 == 100) {
            a12 = h11.a(false).a(d11).a(i11.c().b()).b(currentTimeMillis).a(System.currentTimeMillis()).a();
            k11 = a12.k();
        }
        gVar.g().responseHeadersEnd(gVar.e(), a12);
        y a13 = (this.f38039a && k11 == 101) ? a12.o().a(com.mbridge.msdk.thrid.okhttp.internal.c.f37957c).a() : a12.o().a(h11.a(a12)).a();
        if ("close".equalsIgnoreCase(a13.r().a("Connection")) || "close".equalsIgnoreCase(a13.b("Connection"))) {
            i11.e();
        }
        if ((k11 != 204 && k11 != 205) || a13.d().h() <= 0) {
            return a13;
        }
        throw new ProtocolException("HTTP " + k11 + " had non-zero Content-Length: " + a13.d().h());
    }
}
