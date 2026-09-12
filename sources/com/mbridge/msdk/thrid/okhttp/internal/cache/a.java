package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.internal.cache.b;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class a implements r {
    public a(c cVar) {
    }

    private static p a(p pVar, p pVar2) {
        p.a aVar = new p.a();
        int b11 = pVar.b();
        for (int i11 = 0; i11 < b11; i11++) {
            String a11 = pVar.a(i11);
            String b12 = pVar.b(i11);
            if ((!"Warning".equalsIgnoreCase(a11) || !b12.startsWith("1")) && (a(a11) || !b(a11) || pVar2.b(a11) == null)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(aVar, a11, b12);
            }
        }
        int b13 = pVar2.b();
        for (int i12 = 0; i12 < b13; i12++) {
            String a12 = pVar2.a(i12);
            if (!a(a12) && b(a12)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(aVar, a12, pVar2.b(i12));
            }
        }
        return aVar.a();
    }

    private static y a(y yVar) {
        return (yVar == null || yVar.d() == null) ? yVar : yVar.o().a((z) null).a();
    }

    static boolean a(String str) {
        return HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str) || HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(str) || HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str);
    }

    static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        b c11 = new b.a(System.currentTimeMillis(), aVar.d(), null).c();
        w wVar = c11.f37976a;
        y yVar = c11.f37977b;
        if (wVar == null && yVar == null) {
            return new y.a().a(aVar.d()).a(u.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(com.mbridge.msdk.thrid.okhttp.internal.c.f37957c).b(-1L).a(System.currentTimeMillis()).a();
        }
        if (wVar == null) {
            return yVar.o().a(a(yVar)).a();
        }
        y a11 = aVar.a(wVar);
        if (yVar != null) {
            if (a11.k() == 304) {
                yVar.o().a(a(yVar.m(), a11.m())).b(a11.s()).a(a11.q()).a(a(yVar)).c(a(a11)).a();
                a11.d().close();
                throw null;
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(yVar.d());
        }
        return a11.o().a(a(yVar)).c(a(a11)).a();
    }
}
