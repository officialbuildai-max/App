package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kb.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class c implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ d f31113a;

    public c(d dVar) {
        this.f31113a = dVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzjl
    public final void onEvent(String str, String str2, Bundle bundle, long j11) {
        a.b bVar;
        if (this.f31113a.f31114a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", a.b(str2));
            bVar = this.f31113a.f31115b;
            bVar.a(2, bundle2);
        }
    }
}
