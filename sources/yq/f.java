package yq;

import ah.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import com.transsion.search.net.GoogleSuggestConfig;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import pg.a;
import retrofit2.k0;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f79171a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f79172b = LazyKt.b(new Function0() { // from class: yq.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            OkHttpClient j11;
            j11 = f.j();
            return j11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f79173c = LazyKt.b(new Function0() { // from class: yq.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            k0 k11;
            k11 = f.k();
            return k11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f79174d = LazyKt.b(new Function0() { // from class: yq.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a d11;
            d11 = f.d();
            return d11;
        }
    });

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a d() {
        return (a) f79171a.h().b(a.class);
    }

    private final a e() {
        Object value = f79174d.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (a) value;
    }

    private final OkHttpClient g() {
        return (OkHttpClient) f79172b.getValue();
    }

    private final k0 h() {
        Object value = f79173c.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (k0) value;
    }

    private final OkHttpClient i() {
        a.C0912a c0912a = pg.a.f72569a;
        Proxy proxy = c0912a.c() ? null : Proxy.NO_PROXY;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory a11 = ah.a.a();
        Intrinsics.g(a11, "createSSLSocketFactory(...)");
        builder.sslSocketFactory(a11, new ah.a()).hostnameVerifier(new a.C0008a());
        OkHttpClient.Builder proxy2 = builder.proxy(proxy);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        proxy2.connectTimeout(40L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).callTimeout(40L, timeUnit);
        if (c0912a.c()) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new com.tn.lib.net.interceptor.a());
            httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient j() {
        return f79171a.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 k() {
        return new k0.b().c("https://www.google.com/").g(f79171a.g()).b(ug.a.f()).a(v10.g.d()).e();
    }

    public final io.reactivex.rxjava3.core.j f(String keyword) {
        Intrinsics.h(keyword, "keyword");
        h hVar = h.f79175a;
        GoogleSuggestConfig c11 = hVar.c();
        Map c12 = MapsKt.c();
        Map<String, String> queryParams = c11.getQueryParams();
        if (queryParams != null && !queryParams.isEmpty()) {
            c12.putAll(c11.getQueryParams());
        }
        Map<String, String> queryParams2 = c11.getQueryParams();
        if (queryParams2 != null && queryParams2.containsKey("hl")) {
            c12.put("hl", hVar.a());
        }
        c12.put(CampaignEx.JSON_KEY_AD_Q, keyword);
        Map<String, String> b11 = MapsKt.b(c12);
        Map<String, String> headers = c11.getHeaders();
        if (headers == null) {
            headers = MapsKt.h();
        }
        return e().a(headers, b11);
    }
}
