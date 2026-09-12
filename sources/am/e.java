package am;

import android.content.Context;
import com.transsion.http.d.h;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f753a;

    /* renamed from: b, reason: collision with root package name */
    private final int f754b;

    /* renamed from: c, reason: collision with root package name */
    private String f755c;

    /* renamed from: d, reason: collision with root package name */
    private final String f756d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f757e;

    /* renamed from: f, reason: collision with root package name */
    private final h f758f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f759g;

    /* renamed from: h, reason: collision with root package name */
    private final Map f760h;

    /* renamed from: i, reason: collision with root package name */
    private final Context f761i;

    /* renamed from: j, reason: collision with root package name */
    private final String f762j;

    /* renamed from: k, reason: collision with root package name */
    private final com.transsion.http.d.a f763k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f764l;

    /* renamed from: m, reason: collision with root package name */
    private final SSLSocketFactory f765m;

    /* renamed from: n, reason: collision with root package name */
    private final HostnameVerifier f766n;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f767a;

        /* renamed from: b, reason: collision with root package name */
        private int f768b;

        /* renamed from: c, reason: collision with root package name */
        private int f769c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f770d;

        /* renamed from: e, reason: collision with root package name */
        private String f771e;

        /* renamed from: f, reason: collision with root package name */
        private String f772f;

        /* renamed from: g, reason: collision with root package name */
        private Object f773g;

        /* renamed from: h, reason: collision with root package name */
        private h f774h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f775i;

        /* renamed from: j, reason: collision with root package name */
        private Context f776j;

        /* renamed from: k, reason: collision with root package name */
        private String f777k;

        /* renamed from: l, reason: collision with root package name */
        private com.transsion.http.d.a f778l;

        /* renamed from: m, reason: collision with root package name */
        private Map f779m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f780n;

        /* renamed from: o, reason: collision with root package name */
        private SSLSocketFactory f781o;

        /* renamed from: p, reason: collision with root package name */
        private HostnameVerifier f782p;

        public a() {
            bm.a.f16706a.a(this.f767a);
        }

        public a b(int i11) {
            this.f768b = i11;
            return this;
        }

        public a c(Context context) {
            this.f776j = context;
            return this;
        }

        public a d(h hVar) {
            this.f774h = hVar;
            return this;
        }

        public a e(Object obj) {
            this.f773g = obj;
            return this;
        }

        public a f(Map map) {
            this.f779m = map;
            return this;
        }

        public a g(HostnameVerifier hostnameVerifier) {
            this.f782p = hostnameVerifier;
            return this;
        }

        public a h(SSLSocketFactory sSLSocketFactory) {
            this.f781o = sSLSocketFactory;
            return this;
        }

        public a i(boolean z10) {
            this.f770d = z10;
            return this;
        }

        public e j() {
            if (this.f771e == null) {
                throw new IllegalStateException("url == null");
            }
            if (this.f781o == null) {
                this.f781o = new b().a();
            }
            if (this.f782p == null) {
                this.f782p = new am.a().a();
            }
            return new e(this);
        }

        public a l(int i11) {
            this.f769c = i11;
            return this;
        }

        public a m(boolean z10) {
            this.f775i = z10;
            return this;
        }

        public a n(String str) {
            this.f771e = str;
            return this;
        }

        public a o(boolean z10) {
            this.f767a = z10;
            bm.a.f16706a.a(z10);
            return this;
        }
    }

    public e(a aVar) {
        this.f753a = aVar.f768b;
        this.f754b = aVar.f769c;
        boolean unused = aVar.f770d;
        this.f755c = aVar.f771e;
        this.f756d = aVar.f772f;
        this.f757e = aVar.f773g != null ? aVar.f773g : this;
        this.f758f = aVar.f774h;
        this.f760h = aVar.f779m;
        this.f759g = aVar.f775i;
        this.f761i = aVar.f776j;
        this.f762j = aVar.f777k;
        this.f763k = aVar.f778l;
        this.f764l = aVar.f780n;
        this.f765m = aVar.f781o;
        this.f766n = aVar.f782p;
    }

    public int a() {
        return this.f753a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.f755c = str;
    }

    public String c() {
        return this.f756d;
    }

    public com.transsion.http.d.a d() {
        return this.f763k;
    }

    public Context e() {
        return this.f761i;
    }

    public Map f() {
        return this.f760h;
    }

    public HostnameVerifier g() {
        return this.f766n;
    }

    public h h() {
        return this.f758f;
    }

    public String i() {
        return this.f762j;
    }

    public int j() {
        return this.f754b;
    }

    public boolean k() {
        return this.f764l;
    }

    public SSLSocketFactory l() {
        return this.f765m;
    }

    public Object m() {
        return this.f757e;
    }

    public String n() {
        return this.f755c;
    }

    public boolean o() {
        return this.f759g;
    }
}
