package am;

import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected static SSLSocketFactory f739a;

    /* loaded from: classes5.dex */
    class a implements X509TrustManager {
        a(b bVar) {
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

    public SSLSocketFactory a() {
        if (f739a == null) {
            synchronized (this) {
                try {
                    if (f739a == null) {
                        TrustManager[] trustManagerArr = {new a(this)};
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, trustManagerArr, null);
                        f739a = sSLContext.getSocketFactory();
                    }
                } catch (Throwable th2) {
                    bm.a.f16706a.e("SSL", th2.getMessage());
                } finally {
                }
            }
        }
        return f739a;
    }
}
