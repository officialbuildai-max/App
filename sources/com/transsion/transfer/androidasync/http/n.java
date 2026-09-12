package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import android.text.TextUtils;
import com.transsion.transfer.androidasync.AsyncSSLSocketWrapper;
import com.transsion.transfer.androidasync.http.g;
import com.transsion.transfer.androidasync.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;

/* loaded from: classes6.dex */
public class n extends t {

    /* renamed from: j, reason: collision with root package name */
    protected SSLContext f55512j;

    /* renamed from: k, reason: collision with root package name */
    protected TrustManager[] f55513k;

    /* renamed from: l, reason: collision with root package name */
    protected HostnameVerifier f55514l;

    /* renamed from: m, reason: collision with root package name */
    protected List f55515m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements AsyncSSLSocketWrapper.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bv.b f55516a;

        a(bv.b bVar) {
            this.f55516a = bVar;
        }

        @Override // com.transsion.transfer.androidasync.AsyncSSLSocketWrapper.g
        public void a(Exception exc, com.transsion.transfer.androidasync.a aVar) {
            this.f55516a.a(exc, aVar);
        }
    }

    /* loaded from: classes6.dex */
    class b implements bv.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bv.b f55518a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f55519b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g.a f55520c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f55521d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f55522e;

        /* loaded from: classes6.dex */
        class a implements bv.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.transsion.transfer.androidasync.j f55524a;

            /* renamed from: com.transsion.transfer.androidasync.http.n$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            class C0700a implements v.a {

                /* renamed from: a, reason: collision with root package name */
                String f55526a;

                C0700a() {
                }

                @Override // com.transsion.transfer.androidasync.v.a
                public void a(String str) {
                    b.this.f55520c.f55484b.u(str);
                    if (this.f55526a != null) {
                        if (TextUtils.isEmpty(str.trim())) {
                            a.this.f55524a.t(null);
                            a.this.f55524a.s(null);
                            a aVar = a.this;
                            b bVar = b.this;
                            n.this.E(aVar.f55524a, bVar.f55520c, bVar.f55521d, bVar.f55522e, bVar.f55518a);
                            return;
                        }
                        return;
                    }
                    String trim = str.trim();
                    this.f55526a = trim;
                    if (trim.matches("HTTP/1.\\d 2\\d\\d .*")) {
                        return;
                    }
                    a.this.f55524a.t(null);
                    a.this.f55524a.s(null);
                    b.this.f55518a.a(new IOException("non 2xx status line: " + this.f55526a), a.this.f55524a);
                }
            }

            /* renamed from: com.transsion.transfer.androidasync.http.n$b$a$b, reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            class C0701b implements bv.a {
                C0701b() {
                }

                @Override // bv.a
                public void g(Exception exc) {
                    if (!a.this.f55524a.isOpen() && exc == null) {
                        exc = new IOException("socket closed before proxy connect response");
                    }
                    a aVar = a.this;
                    b.this.f55518a.a(exc, aVar.f55524a);
                }
            }

            a(com.transsion.transfer.androidasync.j jVar) {
                this.f55524a = jVar;
            }

            @Override // bv.a
            public void g(Exception exc) {
                if (exc != null) {
                    b.this.f55518a.a(exc, this.f55524a);
                    return;
                }
                com.transsion.transfer.androidasync.v vVar = new com.transsion.transfer.androidasync.v();
                vVar.a(new C0700a());
                this.f55524a.t(vVar);
                this.f55524a.s(new C0701b());
            }
        }

        b(bv.b bVar, boolean z10, g.a aVar, Uri uri, int i11) {
            this.f55518a = bVar;
            this.f55519b = z10;
            this.f55520c = aVar;
            this.f55521d = uri;
            this.f55522e = i11;
        }

        @Override // bv.b
        public void a(Exception exc, com.transsion.transfer.androidasync.j jVar) {
            if (exc != null) {
                this.f55518a.a(exc, jVar);
                return;
            }
            if (!this.f55519b) {
                n.this.E(jVar, this.f55520c, this.f55521d, this.f55522e, this.f55518a);
                return;
            }
            String format = String.format(Locale.ENGLISH, "CONNECT %s:%s HTTP/1.1\r\nHost: %s\r\n\r\n", this.f55521d.getHost(), Integer.valueOf(this.f55522e), this.f55521d.getHost());
            this.f55520c.f55484b.u("Proxying: " + format);
            com.transsion.transfer.androidasync.a0.h(jVar, format.getBytes(), new a(jVar));
        }
    }

    public n(AsyncHttpClient asyncHttpClient) {
        super(asyncHttpClient, "https", 443);
        this.f55515m = new ArrayList();
    }

    public void A(m mVar) {
        this.f55515m.add(mVar);
    }

    protected SSLEngine B(g.a aVar, String str, int i11) {
        SSLContext D = D();
        Iterator it = this.f55515m.iterator();
        SSLEngine sSLEngine = null;
        while (it.hasNext() && (sSLEngine = ((m) it.next()).a(D, str, i11)) == null) {
        }
        Iterator it2 = this.f55515m.iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).b(sSLEngine, aVar, str, i11);
        }
        return sSLEngine;
    }

    protected AsyncSSLSocketWrapper.g C(g.a aVar, bv.b bVar) {
        return new a(bVar);
    }

    public SSLContext D() {
        SSLContext sSLContext = this.f55512j;
        return sSLContext != null ? sSLContext : AsyncSSLSocketWrapper.q();
    }

    protected void E(com.transsion.transfer.androidasync.j jVar, g.a aVar, Uri uri, int i11, bv.b bVar) {
        AsyncSSLSocketWrapper.w(jVar, uri.getHost(), i11, B(aVar, uri.getHost(), i11), this.f55513k, this.f55514l, true, C(aVar, bVar));
    }

    @Override // com.transsion.transfer.androidasync.http.t
    protected bv.b z(g.a aVar, Uri uri, int i11, boolean z10, bv.b bVar) {
        return new b(bVar, z10, aVar, uri, i11);
    }
}
