package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;

/* loaded from: classes2.dex */
public class ExecutionContext {

    /* renamed from: a, reason: collision with root package name */
    private final AWSRequestMetrics f18466a;

    /* renamed from: b, reason: collision with root package name */
    private final List f18467b;

    /* renamed from: c, reason: collision with root package name */
    private String f18468c;

    /* renamed from: d, reason: collision with root package name */
    private final AmazonWebServiceClient f18469d;

    /* renamed from: e, reason: collision with root package name */
    private AWSCredentials f18470e;

    public ExecutionContext() {
        this(null, false, null);
    }

    public ExecutionContext(List list, boolean z10, AmazonWebServiceClient amazonWebServiceClient) {
        this.f18467b = list;
        this.f18466a = z10 ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics();
        this.f18469d = amazonWebServiceClient;
    }

    public AWSRequestMetrics a() {
        return this.f18466a;
    }

    public String b() {
        return this.f18468c;
    }

    public AWSCredentials c() {
        return this.f18470e;
    }

    public List d() {
        return this.f18467b;
    }

    public Signer e(URI uri) {
        AmazonWebServiceClient amazonWebServiceClient = this.f18469d;
        if (amazonWebServiceClient == null) {
            return null;
        }
        return amazonWebServiceClient.p(uri);
    }

    public void f(AWSCredentials aWSCredentials) {
        this.f18470e = aWSCredentials;
    }

    public void g(Signer signer) {
    }
}
