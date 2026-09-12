package com.amazonaws.metrics;

/* loaded from: classes2.dex */
public abstract class ByteThroughputProvider {

    /* renamed from: a, reason: collision with root package name */
    private long f18519a;

    /* renamed from: b, reason: collision with root package name */
    private int f18520b;

    /* renamed from: c, reason: collision with root package name */
    private final ThroughputMetricType f18521c;

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteThroughputProvider(ThroughputMetricType throughputMetricType) {
        this.f18521c = throughputMetricType;
    }

    public int a() {
        return this.f18520b;
    }

    public long b() {
        return this.f18519a;
    }

    public String c() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i11, long j11) {
        this.f18520b += i11;
        this.f18519a += System.nanoTime() - j11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f18520b = 0;
        this.f18519a = 0L;
    }

    public String toString() {
        return String.format("providerId=%s, throughputType=%s, byteCount=%d, duration=%d", c(), this.f18521c, Integer.valueOf(this.f18520b), Long.valueOf(this.f18519a));
    }
}
