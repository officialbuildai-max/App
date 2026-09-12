package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbpa implements Runnable {
    final zzboy zza;
    final /* synthetic */ zzbpo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpa(zzbpo zzbpoVar, zzboy zzboyVar) {
        this.zzb = zzbpoVar;
        this.zza = zzboyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbpd zzbpdVar;
        zzbpm zzaf;
        Executor executor;
        zzbpdVar = this.zzb.zzs;
        zzaf = this.zzb.zzaf(zzbpdVar.zze, false);
        if (zzaf == null) {
            return;
        }
        executor = this.zzb.zzd;
        executor.execute(new zzboz(this, zzaf));
    }
}
