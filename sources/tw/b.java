package tw;

import ah.a;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import java.net.Proxy;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.k0;
import v10.g;
import xg.e;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f76528c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f76529d = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: tw.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b f11;
            f11 = b.f();
            return f11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private OkHttpClient f76530a;

    /* renamed from: b, reason: collision with root package name */
    private k0 f76531b;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return (b) b.f76529d.getValue();
        }
    }

    public b() {
        CacheIpPool.f40879a.h();
        this.f76530a = g();
        k0.b c11 = new k0.b().c(d());
        OkHttpClient okHttpClient = this.f76530a;
        Intrinsics.e(okHttpClient);
        this.f76531b = c11.g(okHttpClient).b(ug.a.f()).a(g.e(qz.a.a(com.tn.lib.thread.c.f40924f.a(6).b("one_room_net_thread").c(10).a()))).e();
    }

    private final Object c(Class cls) {
        return new k0.b().e().b(cls);
    }

    private final String d() {
        return pg.a.f72569a.d() ? "https://test.paynicorn.com" : "https://api.paynicorn.com";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b f() {
        return new b();
    }

    private final OkHttpClient g() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new com.tn.lib.net.interceptor.a());
        httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
        Proxy proxy = pg.a.f72569a.c() ? null : Proxy.NO_PROXY;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory a11 = ah.a.a();
        Intrinsics.g(a11, "createSSLSocketFactory(...)");
        builder.sslSocketFactory(a11, new ah.a()).hostnameVerifier(new a.C0008a());
        OkHttpClient.Builder proxy2 = builder.proxy(proxy);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        proxy2.connectTimeout(40L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).addInterceptor(yg.a.f79131a.a()).addInterceptor(new xg.a());
        Iterator it = e.f78426a.b().iterator();
        while (it.hasNext()) {
            builder.addInterceptor((Interceptor) it.next());
        }
        return builder.addInterceptor(httpLoggingInterceptor).build();
    }

    private final void h() {
        qg.a aVar = qg.a.f73732a;
        aVar.a(0);
        aVar.b(0L);
    }

    public final Object e(Class service) {
        Object c11;
        Intrinsics.h(service, "service");
        k0 k0Var = this.f76531b;
        if (k0Var == null || (c11 = k0Var.b(service)) == null) {
            c11 = c(service);
        }
        try {
            h();
            return c11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return c11;
        }
    }
}
