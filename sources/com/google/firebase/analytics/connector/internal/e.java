package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kb.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class e implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ f f31118a;

    public e(f fVar) {
        this.f31118a = fVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzjl
    public final void onEvent(String str, String str2, Bundle bundle, long j11) {
        a.b bVar;
        if (str == null || !a.i(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j11);
        bundle2.putBundle("params", bundle);
        bVar = this.f31118a.f31119a;
        bVar.a(3, bundle2);
    }
}
