package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbod implements Runnable {
    final /* synthetic */ zzboe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbod(zzboe zzboeVar, zzboc zzbocVar) {
        this.zza = zzboeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Executor executor;
        zzboe zzboeVar = this.zza;
        executor = zzboeVar.zzb;
        zzbdw zzbdwVar = (zzbdw) executor;
        zzbdwVar.zzc(new zzbob(zzboeVar, null));
        zzbdwVar.zzb();
    }
}
