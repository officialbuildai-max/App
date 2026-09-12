package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzjz implements Executor {
    private final /* synthetic */ zzjq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjz(zzjq zzjqVar) {
        this.zza = zzjqVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.zzl().zzb(runnable);
    }
}
