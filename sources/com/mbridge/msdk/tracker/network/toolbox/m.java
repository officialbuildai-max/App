package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.foundation.same.net.MBridgeHostnameVerifier;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import com.mbridge.msdk.tracker.network.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class m extends a {

    /* renamed from: a, reason: collision with root package name */
    private final t f38731a = a();

    private int a(z zVar) {
        if (zVar == null) {
            return 0;
        }
        if (zVar.h() > 2147483647L) {
            return -1;
        }
        return (int) zVar.h();
    }

    private t a() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        com.mbridge.msdk.thrid.okhttp.l lVar = new com.mbridge.msdk.thrid.okhttp.l(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, new SynchronousQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp Dispatcher", false)));
        lVar.b(50);
        lVar.a(256);
        t.b bVar = new t.b();
        bVar.d(30L, timeUnit);
        bVar.b(30L, timeUnit);
        bVar.e(30L, timeUnit);
        bVar.a(true);
        bVar.a(new com.mbridge.msdk.thrid.okhttp.h(32, 5L, TimeUnit.MINUTES));
        bVar.a(lVar);
        return bVar.a();
    }

    private static x a(com.mbridge.msdk.tracker.network.t tVar) {
        byte[] b11;
        if (tVar == null || (b11 = tVar.b()) == null) {
            return null;
        }
        return x.a(null, b11);
    }

    private static void a(w.a aVar, com.mbridge.msdk.tracker.network.t<?> tVar) throws IOException {
        switch (tVar.g()) {
            case 0:
                aVar.c();
                return;
            case 1:
                x a11 = a(tVar);
                if (a11 == null) {
                    throw new IOException("can't create request body for post");
                }
                aVar.c(a11);
                return;
            case 2:
                x a12 = a(tVar);
                if (a12 == null) {
                    throw new IOException("can't create request body for put");
                }
                aVar.d(a12);
                return;
            case 3:
                aVar.b();
                return;
            case 4:
                aVar.d();
                return;
            case 5:
                aVar.a("OPTIONS", (x) null);
                return;
            case 6:
                aVar.a("TRACE", (x) null);
                return;
            case 7:
                x a13 = a(tVar);
                if (a13 == null) {
                    throw new IOException("can't create request body for patch");
                }
                aVar.b(a13);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void a(p pVar, t.b bVar) {
        if (pVar == null || bVar == null) {
            return;
        }
        try {
            bVar.a(new OKHTTPEventListener(pVar));
        } catch (Exception unused) {
        }
    }

    private static void a(com.mbridge.msdk.tracker.network.t<?> tVar, p pVar) {
        if (pVar == null || tVar == null) {
            return;
        }
        try {
            pVar.g(tVar.m());
        } catch (Exception unused) {
        }
    }

    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    public g a(com.mbridge.msdk.tracker.network.t<?> tVar, Map<String, String> map) throws IOException {
        p h11 = tVar.h();
        if (this.f38731a == null) {
            throw new IOException("okhttp client is null");
        }
        int q11 = tVar.q() <= 0 ? 30000 : tVar.q();
        long r11 = tVar.r();
        String a11 = tVar.g() == 0 ? d.a(tVar.t(), tVar) : tVar.t();
        if (h11 != null) {
            h11.f(a11);
            long j11 = q11;
            h11.e(j11);
            h11.f(j11);
            h11.j(j11);
            h11.a(tVar.n());
        }
        a(tVar, h11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(u.HTTP_1_1);
        arrayList.add(u.HTTP_2);
        t.b a12 = this.f38731a.s().a(arrayList).a(new MBridgeHostnameVerifier(a11));
        long j12 = q11;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        t.b a13 = a12.d(j12, timeUnit).b(j12, timeUnit).a(h11 == null ? com.mbridge.msdk.thrid.okhttp.m.f38335a : new j(h11.H(), h11.b(), h11)).e(j12, timeUnit).a(Math.max(r11, 0L), timeUnit);
        a(h11, a13);
        w.a aVar = new w.a();
        for (Map.Entry<String, String> entry : tVar.f().entrySet()) {
            aVar.a(entry.getKey(), entry.getValue());
        }
        aVar.a("Connection", "close");
        a(aVar, tVar);
        y d11 = a13.a().a(aVar.b(a11).a()).d();
        com.mbridge.msdk.thrid.okhttp.p m11 = d11.m();
        ArrayList arrayList2 = new ArrayList();
        int b11 = m11.b();
        for (int i11 = 0; i11 < b11; i11++) {
            String a14 = m11.a(i11);
            String b12 = m11.b(i11);
            if (a14 != null) {
                arrayList2.add(new com.mbridge.msdk.tracker.network.g(a14, b12));
            }
        }
        z d12 = d11.d();
        return d12 == null ? new g(d11.k(), arrayList2) : new g(d11.k(), arrayList2, a(d12), d12.d());
    }
}
