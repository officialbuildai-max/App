package com.google.firebase.sessions;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final DataCollectionState f32734a;

    /* renamed from: b, reason: collision with root package name */
    private final DataCollectionState f32735b;

    /* renamed from: c, reason: collision with root package name */
    private final double f32736c;

    public d() {
        this(null, null, 0.0d, 7, null);
    }

    public d(DataCollectionState performance, DataCollectionState crashlytics, double d11) {
        Intrinsics.h(performance, "performance");
        Intrinsics.h(crashlytics, "crashlytics");
        this.f32734a = performance;
        this.f32735b = crashlytics;
        this.f32736c = d11;
    }

    public /* synthetic */ d(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState, (i11 & 2) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState2, (i11 & 4) != 0 ? 1.0d : d11);
    }

    public final DataCollectionState a() {
        return this.f32735b;
    }

    public final DataCollectionState b() {
        return this.f32734a;
    }

    public final double c() {
        return this.f32736c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f32734a == dVar.f32734a && this.f32735b == dVar.f32735b && Double.compare(this.f32736c, dVar.f32736c) == 0;
    }

    public int hashCode() {
        return (((this.f32734a.hashCode() * 31) + this.f32735b.hashCode()) * 31) + androidx.compose.animation.core.r.a(this.f32736c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.f32734a + ", crashlytics=" + this.f32735b + ", sessionSamplingRate=" + this.f32736c + ')';
    }
}
