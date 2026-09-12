package com.amazonaws.metrics;

/* loaded from: classes2.dex */
public class SimpleServiceMetricType extends SimpleMetricType implements ServiceMetricType {

    /* renamed from: a, reason: collision with root package name */
    private final String f18526a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18527b;

    public SimpleServiceMetricType(String str, String str2) {
        this.f18526a = str;
        this.f18527b = str2;
    }

    @Override // com.amazonaws.metrics.SimpleMetricType, com.amazonaws.metrics.MetricType
    public String name() {
        return this.f18526a;
    }
}
