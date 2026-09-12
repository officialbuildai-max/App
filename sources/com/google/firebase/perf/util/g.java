package com.google.firebase.perf.util;

import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private long f32428a;

    /* renamed from: b, reason: collision with root package name */
    private long f32429b;

    /* renamed from: c, reason: collision with root package name */
    private TimeUnit f32430c;

    /* loaded from: classes4.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32431a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f32431a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32431a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32431a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(long j11, long j12, TimeUnit timeUnit) {
        this.f32428a = j11;
        this.f32429b = j12;
        this.f32430c = timeUnit;
    }

    public double a() {
        int i11 = a.f32431a[this.f32430c.ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? this.f32428a / this.f32430c.toSeconds(this.f32429b) : (this.f32428a / this.f32429b) * TimeUnit.SECONDS.toMillis(1L) : (this.f32428a / this.f32429b) * TimeUnit.SECONDS.toMicros(1L) : (this.f32428a / this.f32429b) * TimeUnit.SECONDS.toNanos(1L);
    }
}
