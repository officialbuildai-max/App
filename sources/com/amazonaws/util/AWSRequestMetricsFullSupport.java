package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes2.dex */
public class AWSRequestMetricsFullSupport extends AWSRequestMetrics {

    /* renamed from: d, reason: collision with root package name */
    private static final Log f19061d = LogFactory.c("com.amazonaws.latency");

    /* renamed from: e, reason: collision with root package name */
    private static final Object f19062e = UrlUtils.EQUAL_MARK;

    /* renamed from: f, reason: collision with root package name */
    private static final Object f19063f = ", ";

    /* renamed from: b, reason: collision with root package name */
    private final Map f19064b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f19065c;

    public AWSRequestMetricsFullSupport() {
        super(TimingInfo.n());
        this.f19064b = new HashMap();
        this.f19065c = new HashMap();
    }

    private void k(Object obj, Object obj2, StringBuilder sb2) {
        sb2.append(obj);
        sb2.append(f19062e);
        sb2.append(obj2);
        sb2.append(f19063f);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void a(MetricType metricType, Object obj) {
        h(metricType.name(), obj);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void b(MetricType metricType) {
        i(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void d(MetricType metricType) {
        j(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void e() {
        if (f19061d.c()) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry entry : this.f19064b.entrySet()) {
                k(entry.getKey(), entry.getValue(), sb2);
            }
            for (Map.Entry entry2 : this.f19060a.d().entrySet()) {
                k(entry2.getKey(), entry2.getValue(), sb2);
            }
            for (Map.Entry entry3 : this.f19060a.g().entrySet()) {
                k(entry3.getKey(), entry3.getValue(), sb2);
            }
            f19061d.d(sb2.toString());
        }
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void f(MetricType metricType, long j11) {
        l(metricType.name(), j11);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    public void g(MetricType metricType) {
        m(metricType.name());
    }

    public void h(String str, Object obj) {
        List list = (List) this.f19064b.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f19064b.put(str, list);
        }
        list.add(obj);
    }

    public void i(String str) {
        TimingInfo timingInfo = (TimingInfo) this.f19065c.get(str);
        if (timingInfo != null) {
            timingInfo.c();
            this.f19060a.a(str, TimingInfo.p(timingInfo.f(), Long.valueOf(timingInfo.e())));
            return;
        }
        LogFactory.b(getClass()).j("Trying to end an event which was never started: " + str);
    }

    public void j(String str) {
        this.f19060a.j(str);
    }

    public void l(String str, long j11) {
        this.f19060a.l(str, j11);
    }

    public void m(String str) {
        this.f19065c.put(str, TimingInfo.o(System.nanoTime()));
    }
}
