package com.transsion.athena.ehanat;

import android.annotation.TargetApi;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@TargetApi(17)
/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    public static aethna f42759a = new aethna();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class aethna implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        private HostnameVerifier f42760a = HttpsURLConnection.getDefaultHostnameVerifier();

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.f42760a.verify(str, sSLSession);
        }
    }

    /* renamed from: com.transsion.athena.ehanat.athena$athena, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0605athena implements X509TrustManager {
        C0605athena() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
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
            sSLContext.init(null, new TrustManager[]{new C0605athena()}, new SecureRandom());
            return sSLContext;
        } catch (Exception unused2) {
            sSLContext2 = sSLContext;
            return sSLContext2;
        }
    }
}
