package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class a implements r {

    /* renamed from: a, reason: collision with root package name */
    public final t f37990a;

    public a(t tVar) {
        this.f37990a = tVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        com.mbridge.msdk.thrid.okhttp.internal.http.g gVar = (com.mbridge.msdk.thrid.okhttp.internal.http.g) aVar;
        w d11 = gVar.d();
        g i11 = gVar.i();
        return gVar.a(d11, i11, i11.a(this.f37990a, aVar, !d11.e().equals("GET")), i11.c());
    }
}
