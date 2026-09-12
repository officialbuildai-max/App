package com.google.android.libraries.places.internal;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzbob implements Runnable {
    final /* synthetic */ zzboe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbob(zzboe zzboeVar, zzboa zzboaVar) {
        this.zza = zzboeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        long zzk;
        long j11;
        Runnable runnable;
        ScheduledExecutorService scheduledExecutorService;
        long j12;
        zzboe zzboeVar = this.zza;
        z10 = zzboeVar.zzf;
        zzboc zzbocVar = null;
        if (!z10) {
            zzboeVar.zzg = null;
            return;
        }
        zzk = zzboeVar.zzk();
        j11 = zzboeVar.zze;
        if (j11 - zzk <= 0) {
            this.zza.zzf = false;
            this.zza.zzg = null;
            runnable = this.zza.zzc;
            runnable.run();
            return;
        }
        zzboe zzboeVar2 = this.zza;
        scheduledExecutorService = zzboeVar2.zza;
        zzbod zzbodVar = new zzbod(zzboeVar2, zzbocVar);
        j12 = zzboeVar2.zze;
        zzboeVar2.zzg = scheduledExecutorService.schedule(zzbodVar, j12 - zzk, TimeUnit.NANOSECONDS);
    }
}
