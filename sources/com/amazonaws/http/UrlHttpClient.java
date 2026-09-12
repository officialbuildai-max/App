package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: classes2.dex */
public class UrlHttpClient implements HttpClient {

    /* renamed from: c, reason: collision with root package name */
    private static final Log f18485c = LogFactory.b(UrlHttpClient.class);

    /* renamed from: a, reason: collision with root package name */
    private final ClientConfiguration f18486a;

    /* renamed from: b, reason: collision with root package name */
    private SSLContext f18487b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class CurlBuilder {

        /* renamed from: a, reason: collision with root package name */
        private final URL f18488a;

        /* renamed from: b, reason: collision with root package name */
        private String f18489b = null;

        /* renamed from: c, reason: collision with root package name */
        private final HashMap f18490c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        private String f18491d = null;

        /* renamed from: e, reason: collision with root package name */
        private boolean f18492e = false;

        public CurlBuilder(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("Must have a valid url");
            }
            this.f18488a = url;
        }

        public String a() {
            if (!b()) {
                throw new IllegalStateException("Invalid state, cannot create curl command");
            }
            StringBuilder sb2 = new StringBuilder("curl");
            if (this.f18489b != null) {
                sb2.append(" -X ");
                sb2.append(this.f18489b);
            }
            for (Map.Entry entry : this.f18490c.entrySet()) {
                sb2.append(" -H \"");
                sb2.append((String) entry.getKey());
                sb2.append(":");
                sb2.append((String) entry.getValue());
                sb2.append("\"");
            }
            if (this.f18491d != null) {
                sb2.append(" -d '");
                sb2.append(this.f18491d);
                sb2.append("'");
            }
            sb2.append(" ");
            sb2.append(this.f18488a.toString());
            return sb2.toString();
        }

        public boolean b() {
            return !this.f18492e;
        }

        public CurlBuilder c(String str) {
            this.f18491d = str;
            return this;
        }

        public CurlBuilder d(boolean z10) {
            this.f18492e = z10;
            return this;
        }

        public CurlBuilder e(Map map) {
            this.f18490c.clear();
            this.f18490c.putAll(map);
            return this;
        }

        public CurlBuilder f(String str) {
            this.f18489b = str;
            return this;
        }
    }

    public UrlHttpClient(ClientConfiguration clientConfiguration) {
        this.f18486a = clientConfiguration;
    }

    private void e(HttpsURLConnection httpsURLConnection) {
        if (this.f18487b == null) {
            TrustManager[] trustManagerArr = {this.f18486a.g()};
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                this.f18487b = sSLContext;
                sSLContext.init(null, trustManagerArr, null);
            } catch (GeneralSecurityException e11) {
                throw new RuntimeException(e11);
            }
        }
        httpsURLConnection.setSSLSocketFactory(this.f18487b.getSocketFactory());
    }

    private void g(InputStream inputStream, OutputStream outputStream, CurlBuilder curlBuilder, ByteBuffer byteBuffer) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            if (byteBuffer != null) {
                try {
                    byteBuffer.put(bArr, 0, read);
                } catch (BufferOverflowException unused) {
                    curlBuilder.d(true);
                }
            }
            outputStream.write(bArr, 0, read);
        }
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse a(HttpRequest httpRequest) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(httpRequest.e().toURL().openConnection()));
        CurlBuilder curlBuilder = this.f18486a.j() ? new CurlBuilder(httpRequest.e().toURL()) : null;
        c(httpRequest, httpURLConnection);
        b(httpRequest, httpURLConnection, curlBuilder);
        h(httpRequest, httpURLConnection, curlBuilder);
        if (curlBuilder != null) {
            if (curlBuilder.b()) {
                f(curlBuilder.a());
            } else {
                f("Failed to create curl, content too long");
            }
        }
        return d(httpRequest, httpURLConnection);
    }

    HttpURLConnection b(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) {
        if (httpRequest.c() != null && !httpRequest.c().isEmpty()) {
            if (curlBuilder != null) {
                curlBuilder.e(httpRequest.c());
            }
            for (Map.Entry entry : httpRequest.c().entrySet()) {
                String str = (String) entry.getKey();
                if (!str.equals(HttpHeaders.CONTENT_LENGTH) && !str.equals(HttpHeaders.HOST)) {
                    str.equals("Expect");
                    httpURLConnection.setRequestProperty(str, (String) entry.getValue());
                }
            }
        }
        String d11 = httpRequest.d();
        httpURLConnection.setRequestMethod(d11);
        if (curlBuilder != null) {
            curlBuilder.f(d11);
        }
        return httpURLConnection;
    }

    void c(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(this.f18486a.a());
        httpURLConnection.setReadTimeout(this.f18486a.f());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        if (httpRequest.f()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (this.f18486a.g() != null) {
                e(httpsURLConnection);
            }
        }
    }

    HttpResponse d(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        String responseMessage = httpURLConnection.getResponseMessage();
        int responseCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null && !"HEAD".equals(httpRequest.d())) {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
            }
        }
        HttpResponse.Builder b11 = HttpResponse.a().d(responseCode).e(responseMessage).b(errorStream);
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                b11.c(entry.getKey(), entry.getValue().get(0));
            }
        }
        return b11.a();
    }

    protected void f(String str) {
        f18485c.a(str);
    }

    void h(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) {
        ByteBuffer byteBuffer;
        if (httpRequest.a() == null || httpRequest.b() < 0) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (!httpRequest.f()) {
            httpURLConnection.setFixedLengthStreamingMode((int) httpRequest.b());
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (curlBuilder != null) {
            if (httpRequest.b() < 2147483647L) {
                byteBuffer = ByteBuffer.allocate((int) httpRequest.b());
                g(httpRequest.a(), outputStream, curlBuilder, byteBuffer);
                if (curlBuilder != null && byteBuffer != null && byteBuffer.position() != 0) {
                    curlBuilder.c(new String(byteBuffer.array(), "UTF-8"));
                }
                outputStream.flush();
                outputStream.close();
            }
            curlBuilder.d(true);
        }
        byteBuffer = null;
        g(httpRequest.a(), outputStream, curlBuilder, byteBuffer);
        if (curlBuilder != null) {
            curlBuilder.c(new String(byteBuffer.array(), "UTF-8"));
        }
        outputStream.flush();
        outputStream.close();
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
    }
}
