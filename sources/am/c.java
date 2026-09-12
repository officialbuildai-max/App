package am;

import am.e;
import com.transsion.http.d.h;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected final String f740a;

    /* renamed from: b, reason: collision with root package name */
    protected final Object f741b;

    /* renamed from: c, reason: collision with root package name */
    protected final h f742c;

    /* renamed from: d, reason: collision with root package name */
    protected final boolean f743d;

    /* renamed from: e, reason: collision with root package name */
    protected final Map f744e;

    /* renamed from: f, reason: collision with root package name */
    protected int f745f;

    /* renamed from: g, reason: collision with root package name */
    protected int f746g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f747h;

    /* renamed from: i, reason: collision with root package name */
    protected SSLSocketFactory f748i;

    /* renamed from: j, reason: collision with root package name */
    protected HostnameVerifier f749j;

    /* renamed from: k, reason: collision with root package name */
    protected e.a f750k;

    public c(String str, Object obj, h hVar, Map map, boolean z10, int i11, int i12, boolean z11, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        e.a aVar = new e.a();
        this.f750k = aVar;
        this.f740a = str;
        this.f741b = obj;
        this.f742c = hVar;
        this.f744e = map;
        this.f743d = z10;
        this.f745f = i11;
        this.f746g = i12;
        this.f747h = z11;
        this.f748i = sSLSocketFactory;
        this.f749j = hostnameVerifier;
        aVar.n(str).e(obj).d(hVar).f(map).o(z10).b(this.f745f).l(this.f746g).i(this.f747h).h(this.f748i).g(this.f749j);
    }

    public wl.b a() {
        return new wl.b(this);
    }

    protected abstract e b();

    public e c() {
        return b();
    }
}
