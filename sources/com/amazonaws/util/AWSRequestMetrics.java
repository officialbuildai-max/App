package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;

@Deprecated
/* loaded from: classes2.dex */
public class AWSRequestMetrics {

    /* renamed from: a, reason: collision with root package name */
    protected final TimingInfo f19060a;

    /* loaded from: classes2.dex */
    public enum Field implements MetricType {
        AWSErrorCode,
        AWSRequestID,
        BytesProcessed,
        ClientExecuteTime,
        CredentialsRequestTime,
        Exception,
        HttpRequestTime,
        RedirectLocation,
        RequestMarshallTime,
        RequestSigningTime,
        ResponseProcessingTime,
        RequestCount,
        RetryCount,
        HttpClientRetryCount,
        HttpClientSendRequestTime,
        HttpClientReceiveResponseTime,
        RetryPauseTime,
        ServiceEndpoint,
        ServiceName,
        StatusCode
    }

    public AWSRequestMetrics() {
        this.f19060a = TimingInfo.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AWSRequestMetrics(TimingInfo timingInfo) {
        this.f19060a = timingInfo;
    }

    public void a(MetricType metricType, Object obj) {
    }

    public void b(MetricType metricType) {
    }

    public final TimingInfo c() {
        return this.f19060a;
    }

    public void d(MetricType metricType) {
    }

    public void e() {
    }

    public void f(MetricType metricType, long j11) {
    }

    public void g(MetricType metricType) {
    }
}
