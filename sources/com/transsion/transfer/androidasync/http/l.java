package com.transsion.transfer.androidasync.http;

import bv.d;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.http.g;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class l extends com.transsion.transfer.androidasync.t implements com.transsion.transfer.androidasync.p, k, g.i {

    /* renamed from: h, reason: collision with root package name */
    private j f55500h;

    /* renamed from: i, reason: collision with root package name */
    private com.transsion.transfer.androidasync.j f55501i;

    /* renamed from: j, reason: collision with root package name */
    protected Headers f55502j;

    /* renamed from: l, reason: collision with root package name */
    int f55504l;

    /* renamed from: m, reason: collision with root package name */
    String f55505m;

    /* renamed from: n, reason: collision with root package name */
    String f55506n;

    /* renamed from: p, reason: collision with root package name */
    com.transsion.transfer.androidasync.s f55508p;

    /* renamed from: g, reason: collision with root package name */
    private bv.a f55499g = new b();

    /* renamed from: k, reason: collision with root package name */
    boolean f55503k = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f55507o = true;

    /* loaded from: classes6.dex */
    class a implements bv.a {
        a() {
        }

        @Override // bv.a
        public void g(Exception exc) {
            l.this.R(exc);
        }
    }

    /* loaded from: classes6.dex */
    class b implements bv.a {
        b() {
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (l.this.e() == null) {
                l.this.M(new ConnectionClosedException("connection closed before headers received.", exc));
                return;
            }
            if (exc != null) {
                l lVar = l.this;
                if (!lVar.f55503k) {
                    lVar.M(new ConnectionClosedException("connection closed before response completed.", exc));
                    return;
                }
            }
            l.this.M(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends d.a {
        c() {
        }

        @Override // bv.d.a, bv.d
        public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            super.F(pVar, byteBufferList);
            l.this.f55501i.close();
        }
    }

    public l(j jVar) {
        this.f55500h = jVar;
    }

    private void T() {
        this.f55501i.t(new c());
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public com.transsion.transfer.androidasync.s H() {
        return this.f55508p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.transfer.androidasync.q
    public void M(Exception exc) {
        super.M(exc);
        T();
        this.f55501i.o(null);
        this.f55501i.p(null);
        this.f55501i.s(null);
        this.f55503k = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q() {
        cv.a e11 = this.f55500h.e();
        if (e11 != null) {
            e11.C(this.f55500h, this.f55508p, new a());
        } else {
            R(null);
        }
    }

    protected abstract void R(Exception exc);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(com.transsion.transfer.androidasync.j jVar) {
        this.f55501i = jVar;
        if (jVar == null) {
            return;
        }
        jVar.s(this.f55499g);
    }

    @Override // com.transsion.transfer.androidasync.t, com.transsion.transfer.androidasync.p, com.transsion.transfer.androidasync.s
    public AsyncServer a() {
        return this.f55501i.a();
    }

    @Override // com.transsion.transfer.androidasync.http.k, com.transsion.transfer.androidasync.http.g.i
    public int b() {
        return this.f55504l;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i c(int i11) {
        this.f55504l = i11;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.t, com.transsion.transfer.androidasync.p
    public void close() {
        super.close();
        T();
    }

    @Override // com.transsion.transfer.androidasync.http.k, com.transsion.transfer.androidasync.http.g.i
    public Headers e() {
        return this.f55502j;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i f(com.transsion.transfer.androidasync.s sVar) {
        this.f55508p = sVar;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i k(String str) {
        this.f55505m = str;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i m(com.transsion.transfer.androidasync.p pVar) {
        N(pVar);
        return this;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public String protocol() {
        return this.f55505m;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public com.transsion.transfer.androidasync.j socket() {
        return this.f55501i;
    }

    public String toString() {
        Headers headers = this.f55502j;
        if (headers == null) {
            return super.toString();
        }
        return headers.g(this.f55505m + " " + this.f55504l + " " + this.f55506n);
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i u(String str) {
        this.f55506n = str;
        return this;
    }

    @Override // com.transsion.transfer.androidasync.t, com.transsion.transfer.androidasync.q, com.transsion.transfer.androidasync.p
    public String v() {
        String string;
        Multimap parseSemicolonDelimited = Multimap.parseSemicolonDelimited(e().c(HttpHeaders.CONTENT_TYPE));
        if (parseSemicolonDelimited == null || (string = parseSemicolonDelimited.getString("charset")) == null || !Charset.isSupported(string)) {
            return null;
        }
        return string;
    }

    @Override // com.transsion.transfer.androidasync.http.g.i
    public g.i y(Headers headers) {
        this.f55502j = headers;
        return this;
    }
}
