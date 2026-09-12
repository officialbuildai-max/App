package com.amazonaws.services.s3.metrics;

import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.SimpleMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

/* loaded from: classes2.dex */
public class S3ServiceMetric extends SimpleMetricType implements ServiceMetricType {

    /* renamed from: b, reason: collision with root package name */
    public static final S3ThroughputMetric f18761b;

    /* renamed from: c, reason: collision with root package name */
    public static final S3ServiceMetric f18762c;

    /* renamed from: d, reason: collision with root package name */
    public static final S3ThroughputMetric f18763d;

    /* renamed from: e, reason: collision with root package name */
    public static final S3ServiceMetric f18764e;

    /* renamed from: f, reason: collision with root package name */
    private static final S3ServiceMetric[] f18765f;

    /* renamed from: a, reason: collision with root package name */
    private final String f18766a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class S3ThroughputMetric extends S3ServiceMetric implements ThroughputMetricType {
        private S3ThroughputMetric(String str) {
            super(str);
        }
    }

    static {
        S3ThroughputMetric s3ThroughputMetric = new S3ThroughputMetric(a("DownloadThroughput")) { // from class: com.amazonaws.services.s3.metrics.S3ServiceMetric.1
        };
        f18761b = s3ThroughputMetric;
        S3ServiceMetric s3ServiceMetric = new S3ServiceMetric(a("DownloadByteCount"));
        f18762c = s3ServiceMetric;
        S3ThroughputMetric s3ThroughputMetric2 = new S3ThroughputMetric(a("UploadThroughput")) { // from class: com.amazonaws.services.s3.metrics.S3ServiceMetric.2
        };
        f18763d = s3ThroughputMetric2;
        S3ServiceMetric s3ServiceMetric2 = new S3ServiceMetric(a("UploadByteCount"));
        f18764e = s3ServiceMetric2;
        f18765f = new S3ServiceMetric[]{s3ThroughputMetric, s3ServiceMetric, s3ThroughputMetric2, s3ServiceMetric2};
    }

    private S3ServiceMetric(String str) {
        this.f18766a = str;
    }

    private static final String a(String str) {
        return "S3" + str;
    }

    public static S3ServiceMetric[] b() {
        return (S3ServiceMetric[]) f18765f.clone();
    }

    @Override // com.amazonaws.metrics.SimpleMetricType, com.amazonaws.metrics.MetricType
    public String name() {
        return this.f18766a;
    }
}
