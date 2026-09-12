package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import android.text.TextUtils;
import bv.a;
import bv.d;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.AsyncSSLException;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.http.AsyncHttpClient;
import com.transsion.transfer.androidasync.http.g;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class AsyncHttpClient {

    /* renamed from: f, reason: collision with root package name */
    private static AsyncHttpClient f55361f;

    /* renamed from: a, reason: collision with root package name */
    final List f55362a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    n f55363b;

    /* renamed from: c, reason: collision with root package name */
    t f55364c;

    /* renamed from: d, reason: collision with root package name */
    v f55365d;

    /* renamed from: e, reason: collision with root package name */
    AsyncServer f55366e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements bv.b {

        /* renamed from: a, reason: collision with root package name */
        boolean f55367a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.transsion.transfer.androidasync.http.j f55368b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f55369c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ dv.a f55370d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g.C0699g f55371e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f55372f;

        a(com.transsion.transfer.androidasync.http.j jVar, h hVar, dv.a aVar, g.C0699g c0699g, int i11) {
            this.f55368b = jVar;
            this.f55369c = hVar;
            this.f55370d = aVar;
            this.f55371e = c0699g;
            this.f55372f = i11;
        }

        @Override // bv.b
        public void a(Exception exc, com.transsion.transfer.androidasync.j jVar) {
            if (this.f55367a && jVar != null) {
                jVar.t(new d.a());
                jVar.s(new a.C0157a());
                jVar.close();
                throw new AssertionError("double connect callback");
            }
            this.f55367a = true;
            this.f55368b.u("socket connected");
            if (this.f55369c.isCancelled()) {
                if (jVar != null) {
                    jVar.close();
                    return;
                }
                return;
            }
            h hVar = this.f55369c;
            if (hVar.f55401h != null) {
                hVar.f55400g.cancel();
            }
            if (exc != null) {
                AsyncHttpClient.this.H(this.f55369c, exc, null, this.f55368b, this.f55370d);
                return;
            }
            g.C0699g c0699g = this.f55371e;
            c0699g.f55479f = jVar;
            h hVar2 = this.f55369c;
            hVar2.f55399f = jVar;
            AsyncHttpClient.this.u(this.f55368b, this.f55372f, hVar2, this.f55370d, c0699g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends l {

        /* renamed from: q, reason: collision with root package name */
        final /* synthetic */ h f55374q;

        /* renamed from: r, reason: collision with root package name */
        final /* synthetic */ com.transsion.transfer.androidasync.http.j f55375r;

        /* renamed from: s, reason: collision with root package name */
        final /* synthetic */ dv.a f55376s;

        /* renamed from: t, reason: collision with root package name */
        final /* synthetic */ g.C0699g f55377t;

        /* renamed from: u, reason: collision with root package name */
        final /* synthetic */ int f55378u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.transsion.transfer.androidasync.http.j jVar, h hVar, com.transsion.transfer.androidasync.http.j jVar2, dv.a aVar, g.C0699g c0699g, int i11) {
            super(jVar);
            this.f55374q = hVar;
            this.f55375r = jVar2;
            this.f55376s = aVar;
            this.f55377t = c0699g;
            this.f55378u = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void W(com.transsion.transfer.androidasync.http.j jVar, int i11, h hVar, dv.a aVar) {
            AsyncHttpClient.this.r(jVar, i11, hVar, aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void X(com.transsion.transfer.androidasync.http.j jVar, int i11, h hVar, dv.a aVar) {
            AsyncHttpClient.this.r(jVar, i11 + 1, hVar, aVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.transsion.transfer.androidasync.http.l, com.transsion.transfer.androidasync.q
        public void M(Exception exc) {
            if (exc != null) {
                this.f55375r.s("exception during response", exc);
            }
            if (this.f55374q.isCancelled()) {
                return;
            }
            if (exc instanceof AsyncSSLException) {
                this.f55375r.s("SSL Exception", exc);
                AsyncSSLException asyncSSLException = (AsyncSSLException) exc;
                this.f55375r.v(asyncSSLException);
                if (asyncSSLException.getIgnore()) {
                    return;
                }
            }
            com.transsion.transfer.androidasync.j socket = socket();
            if (socket == null) {
                return;
            }
            super.M(exc);
            if ((!socket.isOpen() || exc != null) && e() == null && exc != null) {
                AsyncHttpClient.this.H(this.f55374q, exc, null, this.f55375r, this.f55376s);
            }
            this.f55377t.f55485k = exc;
            Iterator it = AsyncHttpClient.this.f55362a.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.androidasync.http.g) it.next()).b(this.f55377t);
            }
        }

        @Override // com.transsion.transfer.androidasync.t
        public void N(com.transsion.transfer.androidasync.p pVar) {
            this.f55377t.f55478j = pVar;
            Iterator it = AsyncHttpClient.this.f55362a.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.androidasync.http.g) it.next()).d(this.f55377t);
            }
            super.N(this.f55377t.f55478j);
            Iterator it2 = AsyncHttpClient.this.f55362a.iterator();
            while (it2.hasNext()) {
                final com.transsion.transfer.androidasync.http.j h11 = ((com.transsion.transfer.androidasync.http.g) it2.next()).h(this.f55377t);
                if (h11 != null) {
                    com.transsion.transfer.androidasync.http.j jVar = this.f55375r;
                    h11.f55497l = jVar.f55497l;
                    h11.f55496k = jVar.f55496k;
                    h11.f55495j = jVar.f55495j;
                    h11.f55493h = jVar.f55493h;
                    h11.f55494i = jVar.f55494i;
                    AsyncHttpClient.I(h11);
                    this.f55375r.t("Response intercepted by middleware");
                    h11.t("Request initiated by middleware intercept by middleware");
                    AsyncServer asyncServer = AsyncHttpClient.this.f55366e;
                    final int i11 = this.f55378u;
                    final h hVar = this.f55374q;
                    final dv.a aVar = this.f55376s;
                    asyncServer.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            AsyncHttpClient.b.this.W(h11, i11, hVar, aVar);
                        }
                    });
                    t(new d.a());
                    return;
                }
            }
            Headers headers = this.f55502j;
            int b11 = b();
            if ((b11 != 301 && b11 != 302 && b11 != 307) || !this.f55375r.g()) {
                this.f55375r.u("Final (post cache response) headers:\n" + toString());
                AsyncHttpClient.this.H(this.f55374q, null, this, this.f55375r, this.f55376s);
                return;
            }
            String c11 = headers.c(HttpHeaders.LOCATION);
            try {
                Uri parse = Uri.parse(c11);
                if (parse.getScheme() == null) {
                    parse = Uri.parse(new URL(new URL(this.f55375r.p().toString()), c11).toString());
                }
                final com.transsion.transfer.androidasync.http.j jVar2 = new com.transsion.transfer.androidasync.http.j(parse, this.f55375r.j().equals("HEAD") ? "HEAD" : "GET");
                com.transsion.transfer.androidasync.http.j jVar3 = this.f55375r;
                jVar2.f55497l = jVar3.f55497l;
                jVar2.f55496k = jVar3.f55496k;
                jVar2.f55495j = jVar3.f55495j;
                jVar2.f55493h = jVar3.f55493h;
                jVar2.f55494i = jVar3.f55494i;
                AsyncHttpClient.I(jVar2);
                AsyncHttpClient.o(this.f55375r, jVar2, "User-Agent");
                AsyncHttpClient.o(this.f55375r, jVar2, "Range");
                this.f55375r.t("Redirecting");
                jVar2.t("Redirected");
                AsyncServer asyncServer2 = AsyncHttpClient.this.f55366e;
                final int i12 = this.f55378u;
                final h hVar2 = this.f55374q;
                final dv.a aVar2 = this.f55376s;
                asyncServer2.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncHttpClient.b.this.X(jVar2, i12, hVar2, aVar2);
                    }
                });
                t(new d.a());
            } catch (Exception e11) {
                AsyncHttpClient.this.H(this.f55374q, e11, this, this.f55375r, this.f55376s);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.transsion.transfer.androidasync.http.l
        public void P() {
            super.P();
            if (this.f55374q.isCancelled()) {
                return;
            }
            h hVar = this.f55374q;
            if (hVar.f55401h != null) {
                hVar.f55400g.cancel();
            }
            this.f55375r.u("Received headers:\n" + toString());
            Iterator it = AsyncHttpClient.this.f55362a.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.androidasync.http.g) it.next()).g(this.f55377t);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.l
        protected void R(Exception exc) {
            if (exc != null) {
                AsyncHttpClient.this.H(this.f55374q, exc, null, this.f55375r, this.f55376s);
                return;
            }
            this.f55375r.u("request completed");
            if (this.f55374q.isCancelled()) {
                return;
            }
            h hVar = this.f55374q;
            if (hVar.f55401h != null && this.f55502j == null) {
                hVar.f55400g.cancel();
                h hVar2 = this.f55374q;
                hVar2.f55400g = AsyncHttpClient.this.f55366e.E(hVar2.f55401h, AsyncHttpClient.y(this.f55375r));
            }
            Iterator it = AsyncHttpClient.this.f55362a.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.androidasync.http.g) it.next()).c(this.f55377t);
            }
        }

        @Override // com.transsion.transfer.androidasync.http.k
        public com.transsion.transfer.androidasync.j z() {
            this.f55375r.r("Detaching socket");
            com.transsion.transfer.androidasync.j socket = socket();
            if (socket == null) {
                return null;
            }
            socket.o(null);
            socket.p(null);
            socket.s(null);
            socket.t(null);
            S(null);
            return socket;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f55380a;

        c(l lVar) {
            this.f55380a = lVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (exc != null) {
                this.f55380a.M(exc);
            } else {
                this.f55380a.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements bv.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f55382a;

        d(l lVar) {
            this.f55382a = lVar;
        }

        @Override // bv.a
        public void g(Exception exc) {
            if (exc != null) {
                this.f55382a.M(exc);
            } else {
                this.f55382a.P();
            }
        }
    }

    /* loaded from: classes6.dex */
    class e extends com.transsion.transfer.androidasync.future.w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f55384f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ OutputStream f55385g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ File f55386h;

        e(h hVar, OutputStream outputStream, File file) {
            this.f55384f = hVar;
            this.f55385g = outputStream;
            this.f55386h = file;
        }

        @Override // com.transsion.transfer.androidasync.future.n
        public void cancelCleanup() {
            try {
                ((com.transsion.transfer.androidasync.http.k) this.f55384f.get()).t(new d.a());
                ((com.transsion.transfer.androidasync.http.k) this.f55384f.get()).close();
            } catch (Exception unused) {
            }
            try {
                this.f55385g.close();
            } catch (Exception unused2) {
            }
            this.f55386h.delete();
        }
    }

    /* loaded from: classes6.dex */
    class f implements dv.a {

        /* renamed from: a, reason: collision with root package name */
        long f55388a = 0;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OutputStream f55389b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ File f55390c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f55391d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.transsion.transfer.androidasync.future.w f55392e;

        /* loaded from: classes6.dex */
        class a extends com.transsion.transfer.androidasync.stream.a {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.transsion.transfer.androidasync.http.k f55394b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f55395c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(OutputStream outputStream, com.transsion.transfer.androidasync.http.k kVar, long j11) {
                super(outputStream);
                this.f55394b = kVar;
                this.f55395c = j11;
            }

            @Override // com.transsion.transfer.androidasync.stream.a, bv.d
            public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
                f.this.f55388a += byteBufferList.C();
                super.F(pVar, byteBufferList);
                f fVar = f.this;
                AsyncHttpClient.this.C(fVar.f55391d, this.f55394b, fVar.f55388a, this.f55395c);
            }
        }

        /* loaded from: classes6.dex */
        class b implements bv.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.transsion.transfer.androidasync.http.k f55397a;

            b(com.transsion.transfer.androidasync.http.k kVar) {
                this.f55397a = kVar;
            }

            @Override // bv.a
            public void g(Exception e11) {
                try {
                    f.this.f55389b.close();
                } catch (IOException e12) {
                    e11 = e12;
                }
                Exception exc = e11;
                if (exc == null) {
                    f fVar = f.this;
                    AsyncHttpClient.this.E(fVar.f55391d, fVar.f55392e, this.f55397a, null, fVar.f55390c);
                } else {
                    f.this.f55390c.delete();
                    f fVar2 = f.this;
                    AsyncHttpClient.this.E(fVar2.f55391d, fVar2.f55392e, this.f55397a, exc, null);
                }
            }
        }

        f(OutputStream outputStream, File file, g gVar, com.transsion.transfer.androidasync.future.w wVar) {
            this.f55389b = outputStream;
            this.f55390c = file;
            this.f55391d = gVar;
            this.f55392e = wVar;
        }

        @Override // dv.a
        public void a(Exception exc, com.transsion.transfer.androidasync.http.k kVar) {
            if (exc != null) {
                try {
                    this.f55389b.close();
                } catch (IOException unused) {
                }
                this.f55390c.delete();
                AsyncHttpClient.this.E(this.f55391d, this.f55392e, kVar, exc, null);
            } else {
                AsyncHttpClient.this.B(this.f55391d, kVar);
                kVar.t(new a(this.f55389b, kVar, HttpUtil.a(kVar.e())));
                kVar.s(new b(kVar));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class g extends i {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class h extends com.transsion.transfer.androidasync.future.w {

        /* renamed from: f, reason: collision with root package name */
        public com.transsion.transfer.androidasync.j f55399f;

        /* renamed from: g, reason: collision with root package name */
        public com.transsion.transfer.androidasync.future.a f55400g;

        /* renamed from: h, reason: collision with root package name */
        public Runnable f55401h;

        private h() {
        }

        @Override // com.transsion.transfer.androidasync.future.w, com.transsion.transfer.androidasync.future.n, com.transsion.transfer.androidasync.future.a
        public boolean cancel() {
            if (!super.cancel()) {
                return false;
            }
            com.transsion.transfer.androidasync.j jVar = this.f55399f;
            if (jVar != null) {
                jVar.t(new d.a());
                this.f55399f.close();
            }
            com.transsion.transfer.androidasync.future.a aVar = this.f55400g;
            if (aVar == null) {
                return true;
            }
            aVar.cancel();
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class i implements dv.b {
        @Override // dv.b
        public void a(com.transsion.transfer.androidasync.http.k kVar, long j11, long j12) {
        }

        @Override // dv.b
        public void b(com.transsion.transfer.androidasync.http.k kVar) {
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class j extends i {
    }

    /* loaded from: classes6.dex */
    public interface k {
        void a(Exception exc, b0 b0Var);
    }

    public AsyncHttpClient(AsyncServer asyncServer) {
        this.f55366e = asyncServer;
        t tVar = new t(this);
        this.f55364c = tVar;
        z(tVar);
        n nVar = new n(this);
        this.f55363b = nVar;
        z(nVar);
        v vVar = new v();
        this.f55365d = vVar;
        z(vVar);
        this.f55363b.A(new z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void E(final dv.b bVar, final com.transsion.transfer.androidasync.future.w wVar, final com.transsion.transfer.androidasync.http.k kVar, final Exception exc, final Object obj) {
        this.f55366e.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.AsyncHttpClient.7
            @Override // java.lang.Runnable
            public void run() {
                AsyncHttpClient.this.D(bVar, wVar, kVar, exc, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(dv.b bVar, com.transsion.transfer.androidasync.http.k kVar) {
        if (bVar != null) {
            bVar.b(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(dv.b bVar, com.transsion.transfer.androidasync.http.k kVar, long j11, long j12) {
        if (bVar != null) {
            bVar.a(kVar, j11, j12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(dv.b bVar, com.transsion.transfer.androidasync.future.w wVar, com.transsion.transfer.androidasync.http.k kVar, Exception exc, Object obj) {
        if ((exc != null ? wVar.G(exc) : wVar.J(obj)) && bVar != null) {
            bVar.c(exc, kVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(final dv.b bVar, final com.transsion.transfer.androidasync.future.w wVar, fv.a aVar, Exception exc, final com.transsion.transfer.androidasync.http.k kVar) {
        if (exc != null) {
            E(bVar, wVar, kVar, exc, null);
            return;
        }
        B(bVar, kVar);
        com.transsion.transfer.androidasync.future.f a11 = aVar.a(kVar);
        a11.f(new com.transsion.transfer.androidasync.future.g() { // from class: com.transsion.transfer.androidasync.http.b
            @Override // com.transsion.transfer.androidasync.future.g
            public final void a(Exception exc2, Object obj) {
                AsyncHttpClient.this.E(bVar, wVar, kVar, exc2, obj);
            }
        });
        wVar.setParent(a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(com.transsion.transfer.androidasync.future.w wVar, k kVar, com.transsion.transfer.androidasync.http.j jVar, Exception exc, com.transsion.transfer.androidasync.http.k kVar2) {
        if (exc != null) {
            if (!wVar.G(exc) || kVar == null) {
                return;
            }
            kVar.a(exc, null);
            return;
        }
        b0 F = f0.F(jVar.h(), kVar2);
        if (F == null) {
            exc = new WebSocketHandshakeException("Unable to complete websocket handshake");
            kVar2.close();
            if (!wVar.G(exc)) {
                return;
            }
        } else if (!wVar.J(F)) {
            return;
        }
        if (kVar != null) {
            kVar.a(exc, F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(h hVar, Exception exc, l lVar, com.transsion.transfer.androidasync.http.j jVar, dv.a aVar) {
        boolean J;
        hVar.f55400g.cancel();
        if (exc != null) {
            jVar.s("Connection error", exc);
            J = hVar.G(exc);
        } else {
            jVar.r("Connection successful");
            J = hVar.J(lVar);
        }
        if (J) {
            aVar.a(exc, lVar);
        } else if (lVar != null) {
            lVar.t(new d.a());
            lVar.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(com.transsion.transfer.androidasync.http.j jVar) {
        if (jVar.f55493h != null) {
            return;
        }
        try {
            List<Proxy> select = ProxySelector.getDefault().select(URI.create(jVar.p().toString()));
            if (select.isEmpty()) {
                return;
            }
            Proxy proxy = select.get(0);
            if (proxy.type() == Proxy.Type.HTTP && (proxy.address() instanceof InetSocketAddress)) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                jVar.d(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(com.transsion.transfer.androidasync.http.j jVar, com.transsion.transfer.androidasync.http.j jVar2, String str) {
        String c11 = jVar.h().c(str);
        if (TextUtils.isEmpty(c11)) {
            return;
        }
        jVar2.h().f(str, c11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final com.transsion.transfer.androidasync.http.j jVar, final int i11, final h hVar, final dv.a aVar) {
        if (this.f55366e.t()) {
            s(jVar, i11, hVar, aVar);
        } else {
            this.f55366e.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.AsyncHttpClient.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncHttpClient.this.s(jVar, i11, hVar, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final com.transsion.transfer.androidasync.http.j jVar, int i11, final h hVar, final dv.a aVar) {
        if (i11 > 15) {
            H(hVar, new RedirectLimitExceededException("too many redirects"), null, jVar, aVar);
            return;
        }
        jVar.p();
        final g.C0699g c0699g = new g.C0699g();
        jVar.f55497l = System.currentTimeMillis();
        c0699g.f55484b = jVar;
        jVar.r("Executing request.");
        Iterator it = this.f55362a.iterator();
        while (it.hasNext()) {
            ((com.transsion.transfer.androidasync.http.g) it.next()).a(c0699g);
        }
        if (jVar.o() > 0) {
            Runnable runnable = new Runnable() { // from class: com.transsion.transfer.androidasync.http.AsyncHttpClient.2
                @Override // java.lang.Runnable
                public void run() {
                    com.transsion.transfer.androidasync.future.a aVar2 = c0699g.f55476d;
                    if (aVar2 != null) {
                        aVar2.cancel();
                        com.transsion.transfer.androidasync.j jVar2 = c0699g.f55479f;
                        if (jVar2 != null) {
                            jVar2.close();
                        }
                    }
                    AsyncHttpClient.this.H(hVar, new TimeoutException(), null, jVar, aVar);
                }
            };
            hVar.f55401h = runnable;
            hVar.f55400g = this.f55366e.E(runnable, y(jVar));
        }
        c0699g.f55475c = new a(jVar, hVar, aVar, c0699g, i11);
        I(jVar);
        if (jVar.e() != null && jVar.h().c(HttpHeaders.CONTENT_TYPE) == null) {
            jVar.h().f(HttpHeaders.CONTENT_TYPE, jVar.e().j());
        }
        Iterator it2 = this.f55362a.iterator();
        while (it2.hasNext()) {
            com.transsion.transfer.androidasync.future.a e11 = ((com.transsion.transfer.androidasync.http.g) it2.next()).e(c0699g);
            if (e11 != null) {
                c0699g.f55476d = e11;
                hVar.setParent(e11);
                return;
            }
        }
        H(hVar, new IllegalArgumentException("invalid uri=" + jVar.p() + " middlewares=" + this.f55362a), null, jVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.transsion.transfer.androidasync.http.j jVar, int i11, h hVar, dv.a aVar, g.C0699g c0699g) {
        b bVar = new b(jVar, hVar, jVar, aVar, c0699g, i11);
        c0699g.f55481h = new c(bVar);
        c0699g.f55482i = new d(bVar);
        c0699g.f55480g = bVar;
        bVar.S(c0699g.f55479f);
        Iterator it = this.f55362a.iterator();
        while (it.hasNext() && !((com.transsion.transfer.androidasync.http.g) it.next()).f(c0699g)) {
        }
    }

    public static AsyncHttpClient w() {
        if (f55361f == null) {
            f55361f = new AsyncHttpClient(AsyncServer.r());
        }
        return f55361f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long y(com.transsion.transfer.androidasync.http.j jVar) {
        return jVar.o();
    }

    public com.transsion.transfer.androidasync.future.f J(com.transsion.transfer.androidasync.http.j jVar, String str, k kVar) {
        return K(jVar, str != null ? new String[]{str} : null, kVar);
    }

    public com.transsion.transfer.androidasync.future.f K(final com.transsion.transfer.androidasync.http.j jVar, String[] strArr, final k kVar) {
        f0.C(jVar, strArr);
        final com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        wVar.setParent(p(jVar, new dv.a() { // from class: com.transsion.transfer.androidasync.http.c
            @Override // dv.a
            public final void a(Exception exc, k kVar2) {
                AsyncHttpClient.G(com.transsion.transfer.androidasync.future.w.this, kVar, jVar, exc, kVar2);
            }
        }));
        return wVar;
    }

    public com.transsion.transfer.androidasync.future.f L(String str, String str2, k kVar) {
        return J(new com.transsion.transfer.androidasync.http.h(str.replace("ws://", "http://").replace("wss://", "https://")), str2, kVar);
    }

    public com.transsion.transfer.androidasync.future.f p(com.transsion.transfer.androidasync.http.j jVar, dv.a aVar) {
        h hVar = new h();
        r(jVar, 0, hVar, aVar);
        return hVar;
    }

    public com.transsion.transfer.androidasync.future.w q(com.transsion.transfer.androidasync.http.j jVar, final fv.a aVar, final dv.b bVar) {
        h hVar = new h();
        final com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        r(jVar, 0, hVar, new dv.a() { // from class: com.transsion.transfer.androidasync.http.a
            @Override // dv.a
            public final void a(Exception exc, k kVar) {
                AsyncHttpClient.this.F(bVar, wVar, aVar, exc, kVar);
            }
        });
        wVar.setParent(hVar);
        return wVar;
    }

    public com.transsion.transfer.androidasync.future.f t(com.transsion.transfer.androidasync.http.j jVar, String str, g gVar) {
        File file = new File(str);
        file.getParentFile().mkdirs();
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
            h hVar = new h();
            e eVar = new e(hVar, bufferedOutputStream, file);
            eVar.setParent(hVar);
            r(jVar, 0, hVar, new f(bufferedOutputStream, file, gVar, eVar));
            return eVar;
        } catch (FileNotFoundException e11) {
            com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
            wVar.G(e11);
            return wVar;
        }
    }

    public com.transsion.transfer.androidasync.future.f v(com.transsion.transfer.androidasync.http.j jVar, j jVar2) {
        return q(jVar, new fv.f(), jVar2);
    }

    public AsyncServer x() {
        return this.f55366e;
    }

    public void z(com.transsion.transfer.androidasync.http.g gVar) {
        this.f55362a.add(0, gVar);
    }
}
