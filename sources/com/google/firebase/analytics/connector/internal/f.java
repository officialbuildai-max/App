package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kb.a;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private a.b f31119a;

    /* renamed from: b, reason: collision with root package name */
    private AppMeasurementSdk f31120b;

    /* renamed from: c, reason: collision with root package name */
    private e f31121c;

    public f(AppMeasurementSdk appMeasurementSdk, a.b bVar) {
        this.f31119a = bVar;
        this.f31120b = appMeasurementSdk;
        e eVar = new e(this);
        this.f31121c = eVar;
        this.f31120b.registerOnMeasurementEventListener(eVar);
    }
}
