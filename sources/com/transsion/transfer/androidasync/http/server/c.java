package com.transsion.transfer.androidasync.http.server;

import bv.a;
import bv.d;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.HttpUtil;
import com.transsion.transfer.androidasync.http.Protocol;
import com.transsion.transfer.androidasync.t;
import com.transsion.transfer.androidasync.v;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes6.dex */
public abstract class c extends t implements com.transsion.transfer.androidasync.http.server.b, bv.a {

    /* renamed from: g, reason: collision with root package name */
    private String f55563g;

    /* renamed from: i, reason: collision with root package name */
    com.transsion.transfer.androidasync.j f55565i;

    /* renamed from: m, reason: collision with root package name */
    String f55569m;

    /* renamed from: n, reason: collision with root package name */
    cv.a f55570n;

    /* renamed from: h, reason: collision with root package name */
    private Headers f55564h = new Headers();

    /* renamed from: j, reason: collision with root package name */
    private HashMap f55566j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private bv.a f55567k = new a();

    /* renamed from: l, reason: collision with root package name */
    v.a f55568l = new b();

    /* loaded from: classes6.dex */
    class a implements bv.a {
        a() {
        }

        @Override // bv.a
        public void g(Exception exc) {
            c.this.g(exc);
        }
    }

    /* loaded from: classes6.dex */
    class b implements v.a {
        b() {
        }

        @Override // com.transsion.transfer.androidasync.v.a
        public void a(String str) {
            if (c.this.f55563g == null) {
                c.this.f55563g = str;
                if (c.this.f55563g.contains("HTTP/")) {
                    return;
                }
                c.this.W();
                c.this.f55565i.t(new d.a());
                c.this.M(new IOException("data/header received was not not http"));
                return;
            }
            if (!"\r".equals(str)) {
                c.this.f55564h.b(str);
                return;
            }
            c cVar = c.this;
            com.transsion.transfer.androidasync.p c11 = HttpUtil.c(cVar.f55565i, Protocol.HTTP_1_1, cVar.f55564h, true);
            c cVar2 = c.this;
            cVar2.f55570n = cVar2.U(cVar2.f55564h);
            c cVar3 = c.this;
            if (cVar3.f55570n == null) {
                cVar3.f55570n = HttpUtil.b(c11, cVar3.f55567k, c.this.f55564h);
                c cVar4 = c.this;
                if (cVar4.f55570n == null) {
                    cVar4.f55570n = cVar4.X(cVar4.f55564h);
                    c cVar5 = c.this;
                    if (cVar5.f55570n == null) {
                        cVar5.f55570n = new s(cVar5.f55564h.c(HttpHeaders.CONTENT_TYPE));
                    }
                }
            }
            c cVar6 = c.this;
            cVar6.f55570n.r(c11, cVar6.f55567k);
            c.this.V();
        }
    }

    @Override // com.transsion.transfer.androidasync.http.server.b
    public String B() {
        return this.f55569m;
    }

    @Override // com.transsion.transfer.androidasync.http.server.b
    public cv.a D() {
        return this.f55570n;
    }

    @Override // com.transsion.transfer.androidasync.q, com.transsion.transfer.androidasync.p
    public bv.d I() {
        return this.f55565i.I();
    }

    public String T() {
        return this.f55563g;
    }

    protected cv.a U(Headers headers) {
        return null;
    }

    protected abstract void V();

    protected void W() {
        System.out.println("not http!");
    }

    protected cv.a X(Headers headers) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(com.transsion.transfer.androidasync.j jVar) {
        this.f55565i = jVar;
        v vVar = new v();
        this.f55565i.t(vVar);
        vVar.a(this.f55568l);
        this.f55565i.s(new a.C0157a());
    }

    public void g(Exception exc) {
        M(exc);
    }

    @Override // com.transsion.transfer.androidasync.http.server.b
    public Headers getHeaders() {
        return this.f55564h;
    }

    @Override // com.transsion.transfer.androidasync.http.server.b
    public com.transsion.transfer.androidasync.j getSocket() {
        return this.f55565i;
    }

    @Override // com.transsion.transfer.androidasync.t, com.transsion.transfer.androidasync.p
    public boolean isPaused() {
        return this.f55565i.isPaused();
    }

    @Override // com.transsion.transfer.androidasync.t, com.transsion.transfer.androidasync.p
    public void pause() {
        this.f55565i.pause();
    }

    @Override // com.transsion.transfer.androidasync.t, com.transsion.transfer.androidasync.p
    public void resume() {
        this.f55565i.resume();
    }

    @Override // com.transsion.transfer.androidasync.q, com.transsion.transfer.androidasync.p
    public void t(bv.d dVar) {
        this.f55565i.t(dVar);
    }

    public String toString() {
        Headers headers = this.f55564h;
        return headers == null ? super.toString() : headers.g(this.f55563g);
    }
}
