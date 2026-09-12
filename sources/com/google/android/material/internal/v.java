package com.google.android.material.internal;

import android.animation.TimeInterpolator;

/* loaded from: classes4.dex */
public class v implements TimeInterpolator {

    /* renamed from: a, reason: collision with root package name */
    private final TimeInterpolator f29324a;

    public v(TimeInterpolator timeInterpolator) {
        this.f29324a = timeInterpolator;
    }

    public static TimeInterpolator a(boolean z10, TimeInterpolator timeInterpolator) {
        return z10 ? timeInterpolator : new v(timeInterpolator);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f11) {
        return 1.0f - this.f29324a.getInterpolation(f11);
    }
}
