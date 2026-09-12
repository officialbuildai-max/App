package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DefaultRequest<T> implements Request<T> {

    /* renamed from: a, reason: collision with root package name */
    private String f18386a;

    /* renamed from: e, reason: collision with root package name */
    private URI f18390e;

    /* renamed from: f, reason: collision with root package name */
    private String f18391f;

    /* renamed from: g, reason: collision with root package name */
    private final AmazonWebServiceRequest f18392g;

    /* renamed from: i, reason: collision with root package name */
    private InputStream f18394i;

    /* renamed from: j, reason: collision with root package name */
    private int f18395j;

    /* renamed from: k, reason: collision with root package name */
    private AWSRequestMetrics f18396k;

    /* renamed from: l, reason: collision with root package name */
    private String f18397l;

    /* renamed from: b, reason: collision with root package name */
    private boolean f18387b = false;

    /* renamed from: c, reason: collision with root package name */
    private final Map f18388c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map f18389d = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private HttpMethodName f18393h = HttpMethodName.POST;

    public DefaultRequest(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        this.f18391f = str;
        this.f18392g = amazonWebServiceRequest;
    }

    @Override // com.amazonaws.Request
    public void a(InputStream inputStream) {
        this.f18394i = inputStream;
    }

    @Override // com.amazonaws.Request
    public void addHeader(String str, String str2) {
        this.f18389d.put(str, str2);
    }

    @Override // com.amazonaws.Request
    public AWSRequestMetrics b() {
        return this.f18396k;
    }

    @Override // com.amazonaws.Request
    public void c(String str) {
        this.f18386a = str;
    }

    @Override // com.amazonaws.Request
    public String d() {
        return this.f18391f;
    }

    @Override // com.amazonaws.Request
    public void e(int i11) {
        this.f18395j = i11;
    }

    @Override // com.amazonaws.Request
    public int f() {
        return this.f18395j;
    }

    @Override // com.amazonaws.Request
    public void g(String str, String str2) {
        this.f18388c.put(str, str2);
    }

    @Override // com.amazonaws.Request
    public InputStream getContent() {
        return this.f18394i;
    }

    @Override // com.amazonaws.Request
    public Map getHeaders() {
        return this.f18389d;
    }

    @Override // com.amazonaws.Request
    public Map getParameters() {
        return this.f18388c;
    }

    @Override // com.amazonaws.Request
    public void h(AWSRequestMetrics aWSRequestMetrics) {
        if (this.f18396k != null) {
            throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
        }
        this.f18396k = aWSRequestMetrics;
    }

    @Override // com.amazonaws.Request
    public void i(Map map) {
        this.f18389d.clear();
        this.f18389d.putAll(map);
    }

    @Override // com.amazonaws.Request
    public String j() {
        return this.f18397l;
    }

    @Override // com.amazonaws.Request
    public boolean k() {
        return this.f18387b;
    }

    @Override // com.amazonaws.Request
    public AmazonWebServiceRequest l() {
        return this.f18392g;
    }

    @Override // com.amazonaws.Request
    public HttpMethodName m() {
        return this.f18393h;
    }

    @Override // com.amazonaws.Request
    public void n(boolean z10) {
        this.f18387b = z10;
    }

    @Override // com.amazonaws.Request
    public void o(HttpMethodName httpMethodName) {
        this.f18393h = httpMethodName;
    }

    @Override // com.amazonaws.Request
    public String p() {
        return this.f18386a;
    }

    @Override // com.amazonaws.Request
    public void q(Map map) {
        this.f18388c.clear();
        this.f18388c.putAll(map);
    }

    @Override // com.amazonaws.Request
    public URI r() {
        return this.f18390e;
    }

    @Override // com.amazonaws.Request
    public void s(URI uri) {
        this.f18390e = uri;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m());
        sb2.append(" ");
        sb2.append(r());
        sb2.append(" ");
        String p11 = p();
        if (p11 == null) {
            sb2.append("/");
        } else {
            if (!p11.startsWith("/")) {
                sb2.append("/");
            }
            sb2.append(p11);
        }
        sb2.append(" ");
        if (!getParameters().isEmpty()) {
            sb2.append("Parameters: (");
            for (String str : getParameters().keySet()) {
                String str2 = (String) getParameters().get(str);
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str2);
                sb2.append(", ");
            }
            sb2.append(") ");
        }
        if (!getHeaders().isEmpty()) {
            sb2.append("Headers: (");
            for (String str3 : getHeaders().keySet()) {
                String str4 = (String) getHeaders().get(str3);
                sb2.append(str3);
                sb2.append(": ");
                sb2.append(str4);
                sb2.append(", ");
            }
            sb2.append(") ");
        }
        return sb2.toString();
    }
}
