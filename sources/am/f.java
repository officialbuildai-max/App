package am;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.http.d.h;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes5.dex */
public class f implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    protected final e f783a;

    /* renamed from: b, reason: collision with root package name */
    private HttpURLConnection f784b = null;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f785c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f786d = 480;

    public f(e eVar) {
        this.f783a = eVar;
    }

    public void a() {
        InputStream inputStream = this.f785c;
        if (inputStream != null) {
            cm.d.a(inputStream);
            this.f785c = null;
        }
        HttpURLConnection httpURLConnection = this.f784b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public long b() {
        int available;
        HttpURLConnection httpURLConnection = this.f784b;
        long j11 = 0;
        try {
            if (httpURLConnection != null) {
                try {
                    j11 = httpURLConnection.getContentLength();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (j11 >= 1) {
                    return j11;
                }
                available = c().available();
            } else {
                available = c().available();
            }
            j11 = available;
            return j11;
        } catch (Throwable unused) {
            return j11;
        }
    }

    public InputStream c() {
        HttpURLConnection httpURLConnection = this.f784b;
        if (httpURLConnection != null && this.f785c == null) {
            this.f785c = httpURLConnection.getResponseCode() >= 400 ? this.f784b.getErrorStream() : this.f784b.getInputStream();
        }
        return this.f785c;
    }

    public e e() {
        return this.f783a;
    }

    public int f() {
        return this.f784b != null ? this.f786d : TTAdConstant.DEEPLINK_FALLBACK_CODE;
    }

    public void g() {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new wl.c(this.f783a.n()).b().openConnection()));
        this.f784b = httpURLConnection;
        httpURLConnection.setReadTimeout(this.f783a.j());
        this.f784b.setConnectTimeout(this.f783a.a());
        HttpURLConnection httpURLConnection2 = this.f784b;
        if (httpURLConnection2 instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(this.f783a.l());
            ((HttpsURLConnection) this.f784b).setHostnameVerifier(this.f783a.g());
        }
        h h11 = this.f783a.h();
        this.f784b.setRequestMethod(h11.toString());
        if (this.f783a.f() != null) {
            for (String str : this.f783a.f().keySet()) {
                this.f784b.setRequestProperty(str, (String) this.f783a.f().get(str));
            }
        }
        if (h11 == h.f45986b || h11 == h.f45987c || h11 == h.f45988d || h11 == h.f45992h) {
            this.f784b.setRequestProperty("connection", "Keep-Alive");
            this.f784b.setRequestProperty("charset", "utf-8");
            this.f784b.setRequestProperty(HttpHeaders.CONTENT_TYPE, this.f783a.d().toString());
            long length = this.f783a.c().getBytes().length;
            if (length < 0) {
                this.f784b.setChunkedStreamingMode(262144);
            } else if (length < 2147483647L) {
                this.f784b.setFixedLengthStreamingMode((int) length);
            } else {
                this.f784b.setFixedLengthStreamingMode(length);
            }
            this.f784b.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(length));
            this.f784b.setDoOutput(true);
            OutputStream outputStream = this.f784b.getOutputStream();
            this.f786d = 481;
            outputStream.write(this.f783a.c().getBytes());
            outputStream.flush();
            outputStream.close();
        }
        int responseCode = this.f784b.getResponseCode();
        this.f786d = responseCode;
        if (302 == responseCode || 301 == responseCode) {
            String headerField = this.f784b.getHeaderField(HttpHeaders.LOCATION);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            a();
            this.f783a.b(headerField);
            g();
        }
    }
}
