package com.transsion.transfer.androidasync.http;

import android.net.Uri;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.transfer.androidasync.AsyncSSLException;
import java.util.Locale;

/* loaded from: classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private String f55486a;

    /* renamed from: b, reason: collision with root package name */
    private String f55487b;

    /* renamed from: c, reason: collision with root package name */
    Uri f55488c;

    /* renamed from: d, reason: collision with root package name */
    private Headers f55489d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f55490e;

    /* renamed from: f, reason: collision with root package name */
    private cv.a f55491f;

    /* renamed from: g, reason: collision with root package name */
    int f55492g;

    /* renamed from: h, reason: collision with root package name */
    String f55493h;

    /* renamed from: i, reason: collision with root package name */
    int f55494i;

    /* renamed from: j, reason: collision with root package name */
    String f55495j;

    /* renamed from: k, reason: collision with root package name */
    int f55496k;

    /* renamed from: l, reason: collision with root package name */
    long f55497l;

    /* loaded from: classes6.dex */
    class a implements y {
        a() {
        }

        public String toString() {
            j jVar = j.this;
            if (jVar.f55493h != null) {
                return String.format(Locale.ENGLISH, "%s %s %s", jVar.f55487b, j.this.p(), j.this.f55486a);
            }
            String k11 = jVar.k();
            if (k11 == null || k11.length() == 0) {
                k11 = "/";
            }
            String encodedQuery = j.this.p().getEncodedQuery();
            if (encodedQuery != null && encodedQuery.length() != 0) {
                k11 = k11 + UrlUtils.QUESTION_MARK + encodedQuery;
            }
            return String.format(Locale.ENGLISH, "%s %s %s", j.this.f55487b, k11, j.this.f55486a);
        }
    }

    public j(Uri uri, String str) {
        this(uri, str, null);
    }

    public j(Uri uri, String str, Headers headers) {
        this.f55486a = "HTTP/1.1";
        this.f55489d = new Headers();
        this.f55490e = true;
        this.f55492g = 5000;
        this.f55494i = -1;
        this.f55487b = str;
        this.f55488c = uri;
        if (headers == null) {
            this.f55489d = new Headers();
        } else {
            this.f55489d = headers;
        }
        if (headers == null) {
            x(this.f55489d, uri);
        }
    }

    protected static String f() {
        String property = System.getProperty("http.agent");
        if (property != null) {
            return property;
        }
        return "Java" + System.getProperty("java.version");
    }

    private String i(String str) {
        return String.format(Locale.ENGLISH, "(%d ms) %s: %s", Long.valueOf(this.f55497l != 0 ? System.currentTimeMillis() - this.f55497l : 0L), p(), str);
    }

    public static void x(Headers headers, Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (uri.getPort() != -1) {
                host = host + ":" + uri.getPort();
            }
            if (host != null) {
                headers.f(HttpHeaders.HOST, host);
            }
        }
        headers.f("User-Agent", f());
        headers.f("Accept-Encoding", "gzip, deflate");
        headers.f("Connection", "keep-alive");
        headers.f("Accept", "*/*");
    }

    public j c(String str, String str2) {
        h().a(str, str2);
        return this;
    }

    public void d(String str, int i11) {
        this.f55493h = str;
        this.f55494i = i11;
    }

    public cv.a e() {
        return this.f55491f;
    }

    public boolean g() {
        return this.f55490e;
    }

    public Headers h() {
        return this.f55489d;
    }

    public String j() {
        return this.f55487b;
    }

    public String k() {
        return p().getEncodedPath();
    }

    public String l() {
        return this.f55493h;
    }

    public int m() {
        return this.f55494i;
    }

    public y n() {
        return new a();
    }

    public int o() {
        return this.f55492g;
    }

    public Uri p() {
        return this.f55488c;
    }

    public boolean q() {
        return true;
    }

    public void r(String str) {
        if (this.f55495j != null && this.f55496k <= 3) {
            i(str);
        }
    }

    public void s(String str, Exception exc) {
        String str2 = this.f55495j;
        if (str2 != null && this.f55496k <= 6) {
            Log.e(str2, i(str));
            Log.e(this.f55495j, exc.getMessage(), exc);
        }
    }

    public void t(String str) {
        if (this.f55495j != null && this.f55496k <= 4) {
            i(str);
        }
    }

    public String toString() {
        Headers headers = this.f55489d;
        return headers == null ? super.toString() : headers.g(this.f55488c.toString());
    }

    public void u(String str) {
        String str2 = this.f55495j;
        if (str2 != null && this.f55496k <= 2) {
            Log.v(str2, i(str));
        }
    }

    public void v(AsyncSSLException asyncSSLException) {
    }

    public void w(cv.a aVar) {
        this.f55491f = aVar;
    }

    public j y(int i11) {
        this.f55492g = i11;
        return this;
    }
}
