package ni;

import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import okhttp3.OkHttpClient;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f70598a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final HttpLoggingInterceptor f70599b;

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f70600c;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
        f70599b = httpLoggingInterceptor;
        f70600c = LazyKt.b(new Function0() { // from class: ni.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                OkHttpClient b11;
                b11 = b.b();
                return b11;
            }
        });
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient b() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).cache(null).addInterceptor(f70599b).build();
    }

    private final OkHttpClient c() {
        return (OkHttpClient) f70600c.getValue();
    }

    public final OkHttpClient d() {
        return c();
    }
}
