package n00;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes7.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static b f70204a = new b();

    /* loaded from: classes7.dex */
    class a implements X509TrustManager {
        a() {
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

    /* loaded from: classes7.dex */
    static class b implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private HostnameVerifier f70205a = HttpsURLConnection.getDefaultHostnameVerifier();

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f70205a.verify(str, sSLSession);
        }
    }

    public static SSLContext a() {
        SSLContext sSLContext;
        SSLContext sSLContext2 = null;
        try {
            sSLContext = SSLContext.getInstance("TLS");
        } catch (Exception unused) {
        }
        try {
            sSLContext.init(null, new TrustManager[]{new a()}, new SecureRandom());
            return sSLContext;
        } catch (Exception unused2) {
            sSLContext2 = sSLContext;
            return sSLContext2;
        }
    }
}
