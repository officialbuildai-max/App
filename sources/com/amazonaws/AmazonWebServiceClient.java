package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.HttpClient;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.amazonaws.util.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class AmazonWebServiceClient {

    /* renamed from: k, reason: collision with root package name */
    private static final Log f18351k = LogFactory.b(AmazonWebServiceClient.class);

    /* renamed from: a, reason: collision with root package name */
    protected volatile URI f18352a;

    /* renamed from: b, reason: collision with root package name */
    private volatile String f18353b;

    /* renamed from: c, reason: collision with root package name */
    protected ClientConfiguration f18354c;

    /* renamed from: d, reason: collision with root package name */
    protected AmazonHttpClient f18355d;

    /* renamed from: e, reason: collision with root package name */
    protected final List f18356e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    protected int f18357f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Signer f18358g;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f18359h;

    /* renamed from: i, reason: collision with root package name */
    protected volatile String f18360i;

    /* renamed from: j, reason: collision with root package name */
    private volatile Region f18361j;

    /* JADX INFO: Access modifiers changed from: protected */
    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.f18354c = clientConfiguration;
        this.f18355d = new AmazonHttpClient(clientConfiguration, httpClient);
    }

    private String g() {
        int i11;
        String simpleName = Classes.childClassOf(AmazonWebServiceClient.class, this).getSimpleName();
        String serviceName = ServiceNameFactory.getServiceName(simpleName);
        if (serviceName != null) {
            return serviceName;
        }
        int indexOf = simpleName.indexOf("JavaClient");
        if (indexOf == -1 && (indexOf = simpleName.indexOf("Client")) == -1) {
            throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + simpleName);
        }
        int indexOf2 = simpleName.indexOf("Amazon");
        if (indexOf2 == -1) {
            indexOf2 = simpleName.indexOf("AWS");
            if (indexOf2 == -1) {
                throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + simpleName);
            }
            i11 = 3;
        } else {
            i11 = 6;
        }
        if (indexOf2 < indexOf) {
            return StringUtils.b(simpleName.substring(indexOf2 + i11, indexOf));
        }
        throw new IllegalStateException("Unrecognized AWS http client class name " + simpleName);
    }

    private Signer h(String str, String str2, String str3, boolean z10) {
        String e11 = this.f18354c.e();
        Signer b11 = e11 == null ? SignerFactory.b(str, str2) : SignerFactory.c(e11, str);
        if (b11 instanceof RegionAwareSigner) {
            RegionAwareSigner regionAwareSigner = (RegionAwareSigner) b11;
            if (str3 != null) {
                regionAwareSigner.c(str3);
            } else if (str2 != null && z10) {
                regionAwareSigner.c(str2);
            }
        }
        synchronized (this) {
            this.f18361j = Region.f(str2);
        }
        return b11;
    }

    private Signer i(URI uri, String str, boolean z10) {
        if (uri == null) {
            throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
        }
        String o11 = o();
        return h(o11, AwsHostNameUtils.a(uri.getHost(), o11), str, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean r() {
        return System.getProperty("com.amazonaws.sdk.enableRuntimeProfiling") != null;
    }

    private boolean s() {
        RequestMetricCollector u11 = u();
        return u11 != null && u11.b();
    }

    private URI x(String str) {
        if (!str.contains("://")) {
            str = this.f18354c.c().toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(AWSRequestMetrics aWSRequestMetrics, Request request, Response response) {
        k(aWSRequestMetrics, request, response, false);
    }

    protected final void k(AWSRequestMetrics aWSRequestMetrics, Request request, Response response, boolean z10) {
        if (request != null) {
            aWSRequestMetrics.b(AWSRequestMetrics.Field.ClientExecuteTime);
            aWSRequestMetrics.c().c();
            l(request).a(request, response);
        }
        if (z10) {
            aWSRequestMetrics.e();
        }
    }

    protected final RequestMetricCollector l(Request request) {
        RequestMetricCollector requestMetricCollector = request.l().getRequestMetricCollector();
        if (requestMetricCollector != null) {
            return requestMetricCollector;
        }
        RequestMetricCollector n11 = n();
        return n11 == null ? AwsSdkMetrics.getRequestMetricCollector() : n11;
    }

    public String m() {
        return this.f18360i;
    }

    public RequestMetricCollector n() {
        return this.f18355d.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String o() {
        if (this.f18359h == null) {
            synchronized (this) {
                try {
                    if (this.f18359h == null) {
                        this.f18359h = g();
                        return this.f18359h;
                    }
                } finally {
                }
            }
        }
        return this.f18359h;
    }

    public Signer p(URI uri) {
        return i(uri, this.f18353b, true);
    }

    public final String q() {
        return this.f18353b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean t(AmazonWebServiceRequest amazonWebServiceRequest) {
        RequestMetricCollector requestMetricCollector = amazonWebServiceRequest.getRequestMetricCollector();
        if (requestMetricCollector == null || !requestMetricCollector.b()) {
            return s();
        }
        return true;
    }

    protected RequestMetricCollector u() {
        RequestMetricCollector f11 = this.f18355d.f();
        return f11 == null ? AwsSdkMetrics.getRequestMetricCollector() : f11;
    }

    public void v(String str) {
        URI x10 = x(str);
        Signer i11 = i(x10, this.f18353b, false);
        synchronized (this) {
            this.f18352a = x10;
            this.f18358g = i11;
        }
    }

    public void w(Region region) {
        String format;
        if (region == null) {
            throw new IllegalArgumentException("No region provided");
        }
        String o11 = o();
        if (region.i(o11)) {
            format = region.g(o11);
            int indexOf = format.indexOf("://");
            if (indexOf >= 0) {
                format = format.substring(indexOf + 3);
            }
        } else {
            format = String.format("%s.%s.%s", m(), region.d(), region.a());
        }
        URI x10 = x(format);
        Signer h11 = h(o11, region.d(), this.f18353b, false);
        synchronized (this) {
            this.f18352a = x10;
            this.f18358g = h11;
        }
    }
}
