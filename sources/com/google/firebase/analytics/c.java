package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzdy;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAnalytics f31106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FirebaseAnalytics firebaseAnalytics) {
        this.f31106a = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        zzdy zzdyVar;
        zzdyVar = this.f31106a.f31103a;
        return zzdyVar.zze();
    }
}
