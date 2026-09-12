package com.amazonaws.metrics;

/* loaded from: classes2.dex */
public class SimpleThroughputMetricType extends SimpleServiceMetricType implements ThroughputMetricType {

    /* renamed from: c, reason: collision with root package name */
    private final ServiceMetricType f18528c;

    public SimpleThroughputMetricType(String str, String str2, String str3) {
        super(str, str2);
        this.f18528c = new SimpleServiceMetricType(str3, str2);
    }
}
