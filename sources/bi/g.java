package bi;

import okhttp3.Call;
import okhttp3.EventListener;

/* loaded from: classes5.dex */
public class g implements EventListener.Factory {

    /* renamed from: a, reason: collision with root package name */
    private EventListener.Factory f16607a;

    /* renamed from: b, reason: collision with root package name */
    private int f16608b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f16609c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f16610d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16611e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f16612f;

    /* renamed from: g, reason: collision with root package name */
    private String f16613g;

    /* renamed from: h, reason: collision with root package name */
    private String f16614h;

    public g() {
        this.f16608b = 0;
        this.f16609c = false;
        this.f16610d = false;
        this.f16611e = false;
        this.f16612f = false;
        this.f16614h = "All";
    }

    public g(EventListener.Factory factory, int i11, boolean z10) {
        this.f16610d = false;
        this.f16611e = false;
        this.f16612f = false;
        this.f16614h = "All";
        this.f16607a = factory;
        this.f16608b = i11;
        this.f16609c = z10;
    }

    public void a(String str) {
        this.f16613g = str;
    }

    public void b(boolean z10) {
        this.f16612f = z10;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        EventListener.Factory factory = this.f16607a;
        EventListener create = factory != null ? factory.create(call) : null;
        String host = call.request().url().host();
        if (d.d() || d.a(host)) {
            o.f16629a.h("NetworkMonitor", "==== MonitorFactory host : ${host} matches ====");
            return new f(create, this.f16608b, this.f16609c, this.f16614h, this.f16612f, this.f16613g, this.f16610d, this.f16611e);
        }
        o.f16629a.h("NetworkMonitor", "==== MonitorFactory host : ${host} does not matche ====");
        return create == null ? EventListener.NONE : create;
    }
}
