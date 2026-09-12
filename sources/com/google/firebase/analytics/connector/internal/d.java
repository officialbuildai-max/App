package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashSet;
import java.util.Set;
import kb.a;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    Set f31114a;

    /* renamed from: b, reason: collision with root package name */
    private a.b f31115b;

    /* renamed from: c, reason: collision with root package name */
    private AppMeasurementSdk f31116c;

    /* renamed from: d, reason: collision with root package name */
    private c f31117d;

    public d(AppMeasurementSdk appMeasurementSdk, a.b bVar) {
        this.f31115b = bVar;
        this.f31116c = appMeasurementSdk;
        c cVar = new c(this);
        this.f31117d = cVar;
        this.f31116c.registerOnMeasurementEventListener(cVar);
        this.f31114a = new HashSet();
    }
}
