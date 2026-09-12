package com.amazonaws.metrics;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class MetricFilterInputStream extends SdkFilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final ByteThroughputHelper f18523a;

    public MetricFilterInputStream(ThroughputMetricType throughputMetricType, InputStream inputStream) {
        super(inputStream);
        this.f18523a = new ByteThroughputHelper(throughputMetricType);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18523a.f();
        ((FilterInputStream) this).in.close();
        k();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, com.amazonaws.internal.MetricAware
    public final boolean d() {
        return true;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        k();
        long g11 = this.f18523a.g();
        int read = ((FilterInputStream) this).in.read(bArr, i11, i12);
        if (read > 0) {
            this.f18523a.d(read, g11);
        }
        return read;
    }
}
