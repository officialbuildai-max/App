package com.transsnet.downloader.core;

import ah.a;
import com.blankj.utilcode.util.o;
import com.tn.lib.net.cons.PrefetchDnsUrls;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f58736c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f58737d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b d11;
            d11 = b.d();
            return d11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private volatile OkHttpClient f58738a;

    /* renamed from: b, reason: collision with root package name */
    private List f58739b = CollectionsKt.q("vcdn.hakunaymatata.com", "v2cdn.hakunaymatata.com");

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return (b) b.f58737d.getValue();
        }
    }

    public b() {
        PrefetchDnsUrls prefetchDnsUrls;
        ConfigBean c11 = sm.f.f75530c.a().c("prefetch_dns_hosts", false);
        String value = c11 != null ? c11.getValue() : null;
        if (value != null) {
            try {
                if (value.length() <= 0 || (prefetchDnsUrls = (PrefetchDnsUrls) o.d(value, PrefetchDnsUrls.class)) == null || prefetchDnsUrls.getHosts().isEmpty()) {
                    return;
                }
                this.f58739b.clear();
                this.f58739b.addAll(prefetchDnsUrls.getHosts());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b d() {
        return new b();
    }

    private final OkHttpClient e() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory a11 = ah.a.a();
        Intrinsics.g(a11, "createSSLSocketFactory(...)");
        OkHttpClient.Builder hostnameVerifier = builder.sslSocketFactory(a11, new ah.a()).hostnameVerifier(new a.C0008a());
        TimeUnit timeUnit = TimeUnit.MINUTES;
        OkHttpClient.Builder readTimeout = hostnameVerifier.connectionPool(new ConnectionPool(16, 5L, timeUnit)).connectTimeout(1L, timeUnit).retryOnConnectionFailure(true).writeTimeout(1L, timeUnit).readTimeout(1L, timeUnit);
        List<? extends Protocol> singletonList = Collections.singletonList(Protocol.HTTP_1_1);
        Intrinsics.g(singletonList, "singletonList(...)");
        return readTimeout.protocols(singletonList).build();
    }

    public final OkHttpClient c() {
        OkHttpClient okHttpClient = this.f58738a;
        if (okHttpClient == null) {
            synchronized (this) {
                okHttpClient = this.f58738a;
                if (okHttpClient == null) {
                    okHttpClient = e();
                    this.f58738a = okHttpClient;
                }
            }
        }
        return okHttpClient;
    }
}
