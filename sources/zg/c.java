package zg;

import ah.a;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import com.transsion.api.gateway.interceptor.GatewayInterceptor;
import java.net.Proxy;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.chromium.net.CronetEngine;
import retrofit2.k0;
import v10.g;
import xg.e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f79537e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f79538f = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: zg.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            c i11;
            i11 = c.i();
            return i11;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private static final String f79539g = "one_room_net_thread";

    /* renamed from: b, reason: collision with root package name */
    private OkHttpClient f79541b;

    /* renamed from: c, reason: collision with root package name */
    private k0 f79542c;

    /* renamed from: a, reason: collision with root package name */
    private final String f79540a = "NetServiceGenerator";

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f79543d = new AtomicInteger(1);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return (c) c.f79538f.getValue();
        }
    }

    public c() {
        CacheIpPool.f40879a.h();
        this.f79541b = j();
        k0.b c11 = new k0.b().c(vg.a.f77447a.a());
        OkHttpClient okHttpClient = this.f79541b;
        Intrinsics.e(okHttpClient);
        this.f79542c = c11.g(okHttpClient).b(ug.a.f()).a(g.e(qz.a.a(Executors.newFixedThreadPool(6, new ThreadFactory() { // from class: zg.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread c12;
                c12 = c.c(c.this, runnable);
                return c12;
            }
        })))).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread c(c cVar, Runnable runnable) {
        Thread thread = new Thread(runnable, f79539g + "-" + cVar.f79543d.incrementAndGet());
        thread.setPriority(10);
        return thread;
    }

    private final Object e(Class cls) {
        return new k0.b().e().b(cls);
    }

    private final Interceptor f() {
        try {
            CronetEngine.Builder builder = new CronetEngine.Builder(Utils.a());
            builder.enableQuic(true).enableBrotli(true).addQuicHint("api3.aoneroom.com", 443, 443).addQuicHint("api4.aoneroom.com", 443, 443).addQuicHint("api4sg.aoneroom.com", 443, 443).addQuicHint("api5.aoneroom.com", 443, 443).addQuicHint("api6.aoneroom.com", 443, 443).addQuicHint(" api7.aoneroom.com ", 443, 443).addQuicHint(" api8.aoneroom.com", 443, 443).addQuicHint("api6sg.aoneroom.com", 443, 443).addQuicHint("api.inmoviebox.com", 443, 443).addQuicHint("test-mse-api.aoneroom.com", 443, 443);
            CronetEngine build = builder.build();
            Intrinsics.g(build, "build(...)");
            return (Interceptor) com.google.net.cronet.okhttptransport.a.i(build).a();
        } catch (Throwable th2) {
            Log.e("error", "e " + th2.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c i() {
        return new c();
    }

    private final OkHttpClient j() {
        Proxy proxy = pg.a.f72569a.c() ? null : Proxy.NO_PROXY;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory a11 = ah.a.a();
        Intrinsics.g(a11, "createSSLSocketFactory(...)");
        builder.sslSocketFactory(a11, new ah.a()).hostnameVerifier(new a.C0008a());
        OkHttpClient.Builder proxy2 = builder.proxy(proxy);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        proxy2.connectTimeout(40L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).callTimeout(40L, timeUnit).addInterceptor(yg.a.f79131a.a()).addInterceptor(new xg.c()).addInterceptor(new GatewayInterceptor()).addInterceptor(new xg.a());
        Iterator it = e.f78426a.b().iterator();
        while (it.hasNext()) {
            builder.addInterceptor((Interceptor) it.next());
        }
        if (pg.a.f72569a.c()) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new com.tn.lib.net.interceptor.a());
            httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        Interceptor f11 = f();
        if (f11 != null) {
            builder.addInterceptor(f11);
        }
        return builder.build();
    }

    private final void k() {
        qg.a aVar = qg.a.f73732a;
        aVar.a(0);
        aVar.b(0L);
    }

    public final OkHttpClient g() {
        return this.f79541b;
    }

    public final Object h(Class service) {
        Object e11;
        Intrinsics.h(service, "service");
        k0 k0Var = this.f79542c;
        if (k0Var == null || (e11 = k0Var.b(service)) == null) {
            e11 = e(service);
        }
        try {
            k();
            return e11;
        } catch (Exception e12) {
            e12.printStackTrace();
            return e11;
        }
    }
}
