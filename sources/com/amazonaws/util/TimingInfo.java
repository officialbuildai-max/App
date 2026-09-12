package com.amazonaws.util;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class TimingInfo {

    /* renamed from: a, reason: collision with root package name */
    private final Long f19087a;

    /* renamed from: b, reason: collision with root package name */
    private final long f19088b;

    /* renamed from: c, reason: collision with root package name */
    private Long f19089c;

    /* JADX INFO: Access modifiers changed from: protected */
    public TimingInfo(Long l11, long j11, Long l12) {
        this.f19087a = l11;
        this.f19088b = j11;
        this.f19089c = l12;
    }

    public static double b(long j11, long j12) {
        return TimeUnit.NANOSECONDS.toMicros(j12 - j11) / 1000.0d;
    }

    public static TimingInfo m() {
        return new TimingInfo(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo n() {
        return new TimingInfoFullSupport(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo o(long j11) {
        return new TimingInfoFullSupport(null, j11, null);
    }

    public static TimingInfo p(long j11, Long l11) {
        return new TimingInfoUnmodifiable(null, j11, l11);
    }

    public void a(String str, TimingInfo timingInfo) {
    }

    public TimingInfo c() {
        this.f19089c = Long.valueOf(System.nanoTime());
        return this;
    }

    public Map d() {
        return Collections.emptyMap();
    }

    public final long e() {
        Long l11 = this.f19089c;
        if (l11 == null) {
            return -1L;
        }
        return l11.longValue();
    }

    public final long f() {
        return this.f19088b;
    }

    public Map g() {
        return Collections.emptyMap();
    }

    public final double h() {
        Double i11 = i();
        if (i11 == null) {
            return -1.0d;
        }
        return i11.doubleValue();
    }

    public final Double i() {
        if (k()) {
            return Double.valueOf(b(this.f19088b, this.f19089c.longValue()));
        }
        return null;
    }

    public void j(String str) {
    }

    public final boolean k() {
        return this.f19089c != null;
    }

    public void l(String str, long j11) {
    }

    public final String toString() {
        return String.valueOf(h());
    }
}
