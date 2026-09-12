package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzbpg implements Runnable {
    final /* synthetic */ zzboy zza;
    final /* synthetic */ zzbpm zzb;
    final /* synthetic */ zzbpl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpg(zzbpl zzbplVar, zzboy zzboyVar, zzbpm zzbpmVar) {
        this.zza = zzboyVar;
        this.zzb = zzbpmVar;
        this.zzc = zzbplVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Executor executor;
        synchronized (this.zza.zza) {
            zzboy zzboyVar = this.zza;
            if (zzboyVar.zzc) {
                return;
            }
            zzboyVar.zza();
            executor = this.zzc.zzb.zzd;
            executor.execute(new zzbpf(this));
        }
    }
}
