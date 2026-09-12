package co;

import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.c;
import co.d;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import x1.a;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f17629a = new d();

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f17630a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Lazy f17631b = LazyKt.b(new Function0() { // from class: co.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                OkHttpClient e11;
                e11 = d.a.e();
                return e11;
            }
        });

        /* renamed from: co.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0178a implements X509TrustManager {
            C0178a() {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }

        private a() {
        }

        private final OkHttpClient c() {
            C0178a c0178a = new C0178a();
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new C0178a[]{c0178a}, new SecureRandom());
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            Intrinsics.g(socketFactory, "getSocketFactory(...)");
            return builder.sslSocketFactory(socketFactory, c0178a).hostnameVerifier(new HostnameVerifier() { // from class: co.c
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    boolean d11;
                    d11 = d.a.d(str, sSLSession);
                    return d11;
                }
            }).build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(String str, SSLSession sSLSession) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final OkHttpClient e() {
            return f17630a.c();
        }

        public final OkHttpClient f() {
            return (OkHttpClient) f17631b.getValue();
        }
    }

    private d() {
    }

    public final HttpDataSource.a a(boolean z10, Map map) {
        HttpDataSource.a bVar = z10 ? new a.b(a.f17630a.f()) : new c.b();
        if (map != null) {
            if (map.isEmpty()) {
                map = null;
            }
            if (map != null) {
                bVar.a(map);
            }
        }
        return bVar;
    }
}
