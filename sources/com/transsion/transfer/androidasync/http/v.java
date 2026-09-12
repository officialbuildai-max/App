package com.transsion.transfer.androidasync.http;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.http.HttpUtil;
import com.transsion.transfer.androidasync.http.g;
import com.transsion.transfer.androidasync.v;
import java.io.IOException;

/* loaded from: classes6.dex */
public class v extends a0 {

    /* loaded from: classes6.dex */
    class a implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bv.a f55643a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.transsion.transfer.androidasync.n f55644b;

        a(bv.a aVar, com.transsion.transfer.androidasync.n nVar) {
            this.f55643a = aVar;
            this.f55644b = nVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            com.transsion.transfer.androidasync.a0.b(this.f55643a, exc);
            com.transsion.transfer.androidasync.n nVar = this.f55644b;
            if (nVar != null) {
                nVar.g(false);
                this.f55644b.q(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements v.a {

        /* renamed from: a, reason: collision with root package name */
        Headers f55646a = new Headers();

        /* renamed from: b, reason: collision with root package name */
        String f55647b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g.c f55648c;

        b(g.c cVar) {
            this.f55648c = cVar;
        }

        @Override // com.transsion.transfer.androidasync.v.a
        public void a(String str) {
            try {
                String trim = str.trim();
                if (this.f55647b == null) {
                    this.f55647b = trim;
                    return;
                }
                if (!TextUtils.isEmpty(trim)) {
                    this.f55646a.b(trim);
                    return;
                }
                String[] split = this.f55647b.split(" ", 3);
                if (split.length < 2) {
                    throw new Exception(new IOException("Not HTTP"));
                }
                this.f55648c.f55480g.y(this.f55646a);
                String str2 = split[0];
                this.f55648c.f55480g.k(str2);
                this.f55648c.f55480g.c(Integer.parseInt(split[1]));
                this.f55648c.f55480g.u(split.length == 3 ? split[2] : "");
                this.f55648c.f55482i.g(null);
                com.transsion.transfer.androidasync.j socket = this.f55648c.f55480g.socket();
                if (socket == null) {
                    return;
                }
                this.f55648c.f55480g.m(!this.f55648c.f55484b.q() ? HttpUtil.EndEmitter.P(socket.a(), null) : v.i(this.f55648c.f55480g.b()) ? HttpUtil.EndEmitter.P(socket.a(), null) : HttpUtil.c(socket, Protocol.get(str2), this.f55646a, false));
            } catch (Exception e11) {
                this.f55648c.f55482i.g(e11);
            }
        }
    }

    static boolean i(int i11) {
        return (i11 >= 100 && i11 <= 199) || i11 == 204 || i11 == 304;
    }

    @Override // com.transsion.transfer.androidasync.http.a0, com.transsion.transfer.androidasync.http.g
    public void c(g.f fVar) {
        Protocol protocol = Protocol.get(fVar.f55477e);
        if ((protocol == null || protocol == Protocol.HTTP_1_0 || protocol == Protocol.HTTP_1_1) && (fVar.f55480g.H() instanceof ev.a)) {
            fVar.f55480g.H().d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.transfer.androidasync.http.a0, com.transsion.transfer.androidasync.http.g
    public boolean f(g.c cVar) {
        com.transsion.transfer.androidasync.n nVar;
        com.transsion.transfer.androidasync.j jVar;
        Protocol protocol = Protocol.get(cVar.f55477e);
        if (protocol != null && protocol != Protocol.HTTP_1_0 && protocol != Protocol.HTTP_1_1) {
            return super.f(cVar);
        }
        j jVar2 = cVar.f55484b;
        cv.a e11 = jVar2.e();
        if (e11 != null) {
            if (e11.length() >= 0) {
                jVar2.h().f(HttpHeaders.CONTENT_LENGTH, String.valueOf(e11.length()));
                cVar.f55480g.f(cVar.f55479f);
            } else if ("close".equals(jVar2.h().c("Connection"))) {
                cVar.f55480g.f(cVar.f55479f);
            } else {
                jVar2.h().f("Transfer-Encoding", "Chunked");
                cVar.f55480g.f(new ev.a(cVar.f55479f));
            }
        }
        String g11 = jVar2.h().g(jVar2.n().toString());
        byte[] bytes = g11.getBytes();
        if (e11 == null || e11.length() < 0 || e11.length() + bytes.length >= 1024) {
            nVar = null;
            jVar = cVar.f55479f;
        } else {
            com.transsion.transfer.androidasync.n nVar2 = new com.transsion.transfer.androidasync.n(cVar.f55480g.H());
            nVar2.g(true);
            cVar.f55480g.f(nVar2);
            nVar = nVar2;
            jVar = nVar2;
        }
        jVar2.u("\n" + g11);
        com.transsion.transfer.androidasync.a0.h(jVar, bytes, new a(cVar.f55481h, nVar));
        b bVar = new b(cVar);
        com.transsion.transfer.androidasync.v vVar = new com.transsion.transfer.androidasync.v();
        cVar.f55479f.t(vVar);
        vVar.a(bVar);
        return true;
    }
}
