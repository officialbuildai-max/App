package com.android.volley.toolbox;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.android.volley.Request;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public class g extends com.android.volley.toolbox.a {

    /* renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f19387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private final HttpURLConnection f19388a;

        a(HttpURLConnection httpURLConnection) {
            super(g.j(httpURLConnection));
            this.f19388a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.f19388a.disconnect();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
    }

    public g() {
        this(null);
    }

    public g(b bVar) {
        this(bVar, null);
    }

    public g(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f19387a = sSLSocketFactory;
    }

    private void c(HttpURLConnection httpURLConnection, Request request, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey(HttpHeaders.CONTENT_TYPE)) {
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, request.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(h(request, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private void d(HttpURLConnection httpURLConnection, Request request) {
        byte[] body = request.getBody();
        if (body != null) {
            c(httpURLConnection, request, body);
        }
    }

    static List e(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.android.volley.e((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    private static boolean i(int i11, int i12) {
        return (i11 == 4 || (100 <= i12 && i12 < 200) || i12 == 204 || i12 == 304) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream j(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private HttpURLConnection k(URL url, Request request) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection f11 = f(url);
        int timeoutMs = request.getTimeoutMs();
        f11.setConnectTimeout(timeoutMs);
        f11.setReadTimeout(timeoutMs);
        f11.setUseCaches(false);
        f11.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f19387a) != null) {
            ((HttpsURLConnection) f11).setSSLSocketFactory(sSLSocketFactory);
        }
        return f11;
    }

    @Override // com.android.volley.toolbox.a
    public e a(Request request, Map map) {
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(request.getHeaders());
        HttpURLConnection k11 = k(new URL(url), request);
        try {
            for (String str : hashMap.keySet()) {
                k11.setRequestProperty(str, (String) hashMap.get(str));
            }
            l(k11, request);
            int responseCode = k11.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (i(request.getMethod(), responseCode)) {
                return new e(responseCode, e(k11.getHeaderFields()), k11.getContentLength(), g(request, k11));
            }
            e eVar = new e(responseCode, e(k11.getHeaderFields()));
            k11.disconnect();
            return eVar;
        } catch (Throwable th2) {
            if (0 == 0) {
                k11.disconnect();
            }
            throw th2;
        }
    }

    protected HttpURLConnection f(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    protected InputStream g(Request request, HttpURLConnection httpURLConnection) {
        return new a(httpURLConnection);
    }

    protected OutputStream h(Request request, HttpURLConnection httpURLConnection, int i11) {
        return httpURLConnection.getOutputStream();
    }

    void l(HttpURLConnection httpURLConnection, Request request) {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    c(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                d(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                d(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                d(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
