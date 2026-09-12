package com.tn.tranpay.network;

import com.tn.tranpay.TranPayConfiguration;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.k0;

/* loaded from: classes4.dex */
public final class RetrofitClient {

    /* renamed from: a, reason: collision with root package name */
    public static final RetrofitClient f41709a = new RetrofitClient();

    /* renamed from: b, reason: collision with root package name */
    private static String f41710b;

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f41711c;

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f41712d;

    static {
        f41710b = TranPayConfiguration.f41544a.u() ? "https://api.paynicorn.com" : "https://test.paynicorn.com/";
        f41711c = LazyKt.b(new Function0<OkHttpClient>() { // from class: com.tn.tranpay.network.RetrofitClient$okHttpClient$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder addNetworkInterceptor = new OkHttpClient.Builder().addNetworkInterceptor(new a()).addNetworkInterceptor(httpLoggingInterceptor);
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return addNetworkInterceptor.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
            }
        });
        f41712d = LazyKt.b(new Function0<k0>() { // from class: com.tn.tranpay.network.RetrofitClient$retrofit$2
            @Override // kotlin.jvm.functions.Function0
            public final k0 invoke() {
                String str;
                OkHttpClient c11;
                k0.b bVar = new k0.b();
                str = RetrofitClient.f41710b;
                k0.b c12 = bVar.c(str);
                c11 = RetrofitClient.f41709a.c();
                return c12.g(c11).b(w10.a.f()).e();
            }
        });
    }

    private RetrofitClient() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient c() {
        return (OkHttpClient) f41711c.getValue();
    }

    public final k0 d() {
        Object value = f41712d.getValue();
        Intrinsics.g(value, "<get-retrofit>(...)");
        return (k0) value;
    }
}
