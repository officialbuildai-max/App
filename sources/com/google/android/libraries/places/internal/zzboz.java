package com.google.android.libraries.places.internal;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzboz implements Runnable {
    final /* synthetic */ zzbpm zza;
    final /* synthetic */ zzbpa zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboz(zzbpa zzbpaVar, zzbpm zzbpmVar) {
        this.zza = zzbpmVar;
        this.zzb = zzbpaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzboy zzboyVar;
        zzbpd zzbpdVar;
        zzbpd zzbpdVar2;
        boolean zzal;
        zzbpd zzbpdVar3;
        boolean z10;
        zzbpn zzbpnVar;
        Object obj2;
        zzbpn zzbpnVar2;
        ScheduledExecutorService scheduledExecutorService;
        zzbje zzbjeVar;
        obj = this.zzb.zzb.zzm;
        synchronized (obj) {
            try {
                zzbpa zzbpaVar = this.zzb;
                zzboyVar = null;
                if (zzbpaVar.zza.zzc) {
                    z10 = true;
                } else {
                    zzbpo zzbpoVar = zzbpaVar.zzb;
                    zzbpdVar = zzbpoVar.zzs;
                    zzbpoVar.zzs = zzbpdVar.zza(this.zza);
                    zzbpo zzbpoVar2 = this.zzb.zzb;
                    zzbpdVar2 = zzbpoVar2.zzs;
                    zzal = zzbpoVar2.zzal(zzbpdVar2);
                    if (zzal) {
                        zzbpo zzbpoVar3 = this.zzb.zzb;
                        zzbpnVar = zzbpoVar3.zzq;
                        if (zzbpnVar != null) {
                            zzbpnVar2 = zzbpoVar3.zzq;
                            if (zzbpnVar2.zza()) {
                            }
                        }
                        zzbpo zzbpoVar4 = this.zzb.zzb;
                        obj2 = zzbpoVar4.zzm;
                        zzboyVar = new zzboy(obj2);
                        zzbpoVar4.zzA = zzboyVar;
                        z10 = false;
                    }
                    zzbpo zzbpoVar5 = this.zzb.zzb;
                    zzbpdVar3 = zzbpoVar5.zzs;
                    zzbpoVar5.zzs = zzbpdVar3.zzb();
                    this.zzb.zzb.zzA = null;
                    z10 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            zzbpm zzbpmVar = this.zza;
            zzbpmVar.zza.zzo(new zzbpl(this.zzb.zzb, zzbpmVar));
            this.zza.zza.zzh(zzbdo.zzb.zzg("Unneeded hedging"));
            return;
        }
        if (zzboyVar != null) {
            zzbpo zzbpoVar6 = this.zzb.zzb;
            scheduledExecutorService = zzbpoVar6.zzf;
            zzbpa zzbpaVar2 = new zzbpa(zzbpoVar6, zzboyVar);
            zzbjeVar = zzbpoVar6.zzk;
            zzboyVar.zzb(scheduledExecutorService.schedule(zzbpaVar2, zzbjeVar.zzb, TimeUnit.NANOSECONDS));
        }
        this.zzb.zzb.zzai(this.zza);
    }
}
