package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public final class a implements r {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.k f38038a;

    public a(com.mbridge.msdk.thrid.okhttp.k kVar) {
        this.f38038a = kVar;
    }

    private String a(List<com.mbridge.msdk.thrid.okhttp.j> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                sb2.append("; ");
            }
            com.mbridge.msdk.thrid.okhttp.j jVar = list.get(i11);
            sb2.append(jVar.a());
            sb2.append('=');
            sb2.append(jVar.b());
        }
        return sb2.toString();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        w d11 = aVar.d();
        w.a f11 = d11.f();
        x a11 = d11.a();
        if (a11 != null) {
            a11.b();
            long a12 = a11.a();
            if (a12 != -1) {
                f11.b(HttpHeaders.CONTENT_LENGTH, Long.toString(a12));
                f11.a("Transfer-Encoding");
            } else {
                f11.b("Transfer-Encoding", "chunked");
                f11.a(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z10 = false;
        if (d11.a(HttpHeaders.HOST) == null) {
            f11.b(HttpHeaders.HOST, com.mbridge.msdk.thrid.okhttp.internal.c.a(d11.g(), false));
        }
        if (d11.a("Connection") == null) {
            f11.b("Connection", "Keep-Alive");
        }
        if (d11.a("Accept-Encoding") == null && d11.a("Range") == null) {
            f11.b("Accept-Encoding", "gzip");
            z10 = true;
        }
        List<com.mbridge.msdk.thrid.okhttp.j> a13 = this.f38038a.a(d11.g());
        if (!a13.isEmpty()) {
            f11.b("Cookie", a(a13));
        }
        if (d11.a("User-Agent") == null) {
            f11.b("User-Agent", com.mbridge.msdk.thrid.okhttp.internal.d.a());
        }
        y a14 = aVar.a(f11.a());
        e.a(this.f38038a, d11.g(), a14.m());
        y.a a15 = a14.o().a(d11);
        if (z10 && "gzip".equalsIgnoreCase(a14.b(HttpHeaders.CONTENT_ENCODING)) && e.b(a14)) {
            com.mbridge.msdk.thrid.okio.j jVar = new com.mbridge.msdk.thrid.okio.j(a14.d().k());
            a15.a(a14.m().a().b(HttpHeaders.CONTENT_ENCODING).b(HttpHeaders.CONTENT_LENGTH).a());
            a15.a(new h(a14.b(HttpHeaders.CONTENT_TYPE), -1L, l.a(jVar)));
        }
        return a15.a();
    }
}
