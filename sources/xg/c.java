package xg;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tn.lib.net.dns.or.CacheIpPool;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes.dex */
public final class c implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public static final a f78424b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f78425a = LazyKt.b(new Function0() { // from class: xg.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Handler b11;
            b11 = c.b();
            return b11;
        }
    });

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler b() {
        return new Handler(Looper.getMainLooper());
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        Request request = chain.request();
        HttpUrl.Builder newBuilder = request.url().newBuilder();
        String host = request.url().host();
        CacheIpPool cacheIpPool = CacheIpPool.f40879a;
        if (TextUtils.equals(host, cacheIpPool.l()) && TextUtils.equals(request.url().scheme(), cacheIpPool.m())) {
            newBuilder.removeAllQueryParameters("host");
        } else {
            newBuilder.scheme(cacheIpPool.m()).host(cacheIpPool.l()).removeAllQueryParameters("host");
        }
        Request build = request.newBuilder().url(newBuilder.build()).build();
        Response proceed = chain.proceed(build);
        lg.a.f68962a.p("HttpTag", new String[]{"DynamicHostInterceptor response " + proceed.code() + " : " + build.url() + " protocol: " + proceed.protocol() + " "}, true);
        return proceed;
    }
}
