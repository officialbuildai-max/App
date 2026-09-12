package com.transsion.transfer.androidasync.http.server;

import android.util.Log;
import bv.a;
import bv.d;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.HttpUtil;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.b0;
import com.transsion.transfer.androidasync.http.server.n;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class AsyncHttpServer extends n {

    /* renamed from: h, reason: collision with root package name */
    private static Hashtable f55544h;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f55545e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    bv.f f55546f = new AnonymousClass1();

    /* renamed from: g, reason: collision with root package name */
    bv.a f55547g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements bv.f {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C07021 extends n.a {
            final bv.i A;
            final /* synthetic */ com.transsion.transfer.androidasync.j B;

            /* renamed from: q, reason: collision with root package name */
            n.a f55549q;

            /* renamed from: r, reason: collision with root package name */
            q f55550r;

            /* renamed from: s, reason: collision with root package name */
            String f55551s;

            /* renamed from: t, reason: collision with root package name */
            String f55552t;

            /* renamed from: u, reason: collision with root package name */
            boolean f55553u;

            /* renamed from: v, reason: collision with root package name */
            boolean f55554v;

            /* renamed from: w, reason: collision with root package name */
            k f55555w;

            /* renamed from: x, reason: collision with root package name */
            boolean f55556x;

            /* renamed from: y, reason: collision with root package name */
            boolean f55557y;

            /* renamed from: z, reason: collision with root package name */
            final Runnable f55558z;

            /* renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1$a */
            /* loaded from: classes6.dex */
            class a implements bv.i {
                a() {
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1$b */
            /* loaded from: classes6.dex */
            public class b implements bv.a {
                b() {
                }

                @Override // bv.a
                public void g(Exception exc) {
                    C07021.this.resume();
                    if (exc != null) {
                        C07021.this.M(exc);
                        return;
                    }
                    C07021 c07021 = C07021.this;
                    c07021.f55556x = true;
                    c07021.V();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1$c */
            /* loaded from: classes6.dex */
            public class c extends k {
                c(com.transsion.transfer.androidasync.j jVar, com.transsion.transfer.androidasync.http.server.c cVar) {
                    super(jVar, cVar);
                }

                @Override // com.transsion.transfer.androidasync.http.server.k
                protected void C() {
                    C07021.this.f55553u = true;
                    super.C();
                    this.f55587d.s(null);
                    AsyncHttpServer.this.r(r(), C07021.this.f55555w);
                    C07021.this.b0();
                }

                @Override // com.transsion.transfer.androidasync.http.server.k
                protected void D(Exception exc) {
                    super.D(exc);
                    if (exc != null) {
                        C07021.this.B.t(new d.a());
                        C07021.this.B.s(new a.C0157a());
                        C07021.this.B.close();
                    }
                }
            }

            /* renamed from: com.transsion.transfer.androidasync.http.server.AsyncHttpServer$1$1$d */
            /* loaded from: classes6.dex */
            class d extends d.a {
                d() {
                }

                @Override // bv.d.a, bv.d
                public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
                    super.F(pVar, byteBufferList);
                    C07021.this.f55565i.close();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C07021(com.transsion.transfer.androidasync.j jVar) {
                super();
                this.B = jVar;
                this.f55549q = this;
                this.f55558z = new Runnable() { // from class: com.transsion.transfer.androidasync.http.server.AsyncHttpServer.1.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                };
                this.A = new a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b0() {
                if (this.f55554v && this.f55553u && !AsyncHttpServer.this.n(this.f55555w)) {
                    if (AsyncHttpServer.this.m(this.f55549q, this.f55555w)) {
                        AnonymousClass1.this.w(this.B);
                    } else {
                        this.B.close();
                    }
                }
            }

            @Override // com.transsion.transfer.androidasync.http.server.c
            protected cv.a U(Headers headers) {
                String[] split = T().split(" ");
                String str = split[1];
                this.f55551s = str;
                String decode = URLDecoder.decode(str.split("\\?")[0]);
                this.f55552t = decode;
                String str2 = split[0];
                this.f55569m = str2;
                n.d a11 = AsyncHttpServer.this.a(str2, decode);
                if (a11 == null) {
                    return null;
                }
                this.f55603o = a11.f55611c;
                this.f55550r = a11.f55612d;
                return null;
            }

            @Override // com.transsion.transfer.androidasync.http.server.c
            protected void V() {
                Headers headers = getHeaders();
                if (!this.f55556x && "100-continue".equals(headers.c("Expect"))) {
                    pause();
                    a0.h(this.f55565i, "HTTP/1.1 100 Continue\r\n\r\n".getBytes(), new b());
                    return;
                }
                c cVar = new c(this.B, this);
                this.f55555w = cVar;
                boolean q11 = AsyncHttpServer.this.q(this, cVar);
                this.f55557y = q11;
                if (q11) {
                    return;
                }
                if (this.f55550r == null) {
                    this.f55555w.c(TTAdConstant.DEEPLINK_FALLBACK_CODE);
                    this.f55555w.d();
                } else if (!D().K() || this.f55554v) {
                    c0();
                }
            }

            @Override // com.transsion.transfer.androidasync.http.server.c
            protected cv.a X(Headers headers) {
                return AsyncHttpServer.this.s(headers);
            }

            void c0() {
                AsyncHttpServer.this.p(this.f55550r, this, this.f55555w);
            }

            @Override // com.transsion.transfer.androidasync.http.server.c, bv.a
            public void g(Exception exc) {
                if (AsyncHttpServer.this.n(this.f55555w)) {
                    return;
                }
                this.f55554v = true;
                super.g(exc);
                this.f55565i.t(new d());
                if (exc != null) {
                    this.f55565i.close();
                    return;
                }
                b0();
                if (!D().K() || this.f55557y) {
                    return;
                }
                c0();
            }

            @Override // com.transsion.transfer.androidasync.http.server.b
            public String getPath() {
                return this.f55552t;
            }

            @Override // com.transsion.transfer.androidasync.http.server.b
            public Multimap h() {
                String[] split = this.f55551s.split("\\?", 2);
                return split.length < 2 ? new Multimap() : Multimap.parseQuery(split[1]);
            }
        }

        AnonymousClass1() {
        }

        @Override // bv.a
        public void g(Exception exc) {
            AsyncHttpServer.this.t(exc);
        }

        @Override // bv.f
        public void q(com.transsion.transfer.androidasync.i iVar) {
            AsyncHttpServer.this.f55545e.add(iVar);
        }

        @Override // bv.f
        public void w(com.transsion.transfer.androidasync.j jVar) {
            new C07021(jVar).Y(jVar);
            jVar.resume();
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        void a(b0 b0Var, b bVar);
    }

    static {
        Hashtable hashtable = new Hashtable();
        f55544h = hashtable;
        hashtable.put(200, "OK");
        f55544h.put(Integer.valueOf(Sdk$SDKError.Reason.AD_CONSUMED_VALUE), "Accepted");
        f55544h.put(Integer.valueOf(Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE), "Partial Content");
        f55544h.put(101, "Switching Protocols");
        f55544h.put(Integer.valueOf(Sdk$SDKError.Reason.MRAID_ERROR_VALUE), "Moved Permanently");
        f55544h.put(Integer.valueOf(Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE), "Found");
        f55544h.put(Integer.valueOf(Sdk$SDKError.Reason.AD_EXPIRED_VALUE), "Not Modified");
        f55544h.put(400, "Bad Request");
        f55544h.put(401, "Unauthorized");
        f55544h.put(Integer.valueOf(TTAdConstant.DEEPLINK_FALLBACK_CODE), "Not Found");
        f55544h.put(500, "Internal Server Error");
    }

    public static String l(int i11) {
        String str = (String) f55544h.get(Integer.valueOf(i11));
        return str == null ? "Unknown" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        bv.a aVar = this.f55547g;
        if (aVar != null) {
            aVar.g(exc);
        }
    }

    protected boolean m(b bVar, d dVar) {
        return HttpUtil.e(dVar.E(), bVar.getHeaders());
    }

    protected boolean n(d dVar) {
        return dVar.b() == 101;
    }

    public com.transsion.transfer.androidasync.i o(AsyncServer asyncServer, int i11) {
        return asyncServer.y(null, i11, this.f55546f);
    }

    protected void p(q qVar, b bVar, d dVar) {
        if (qVar != null) {
            try {
                qVar.b(bVar, dVar);
            } catch (Exception e11) {
                Log.e("AsyncHttpServer", "request callback raised uncaught exception. Catching versus crashing process", e11);
                dVar.c(500);
                dVar.d();
            }
        }
    }

    protected boolean q(b bVar, d dVar) {
        return false;
    }

    protected void r(b bVar, d dVar) {
    }

    protected cv.a s(Headers headers) {
        return new s(headers.c(HttpHeaders.CONTENT_TYPE));
    }

    public void u() {
        ArrayList arrayList = this.f55545e;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.androidasync.i) it.next()).stop();
            }
        }
    }
}
