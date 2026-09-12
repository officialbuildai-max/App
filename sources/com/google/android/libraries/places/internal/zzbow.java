package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbow extends zzayx {
    long zzb;
    final /* synthetic */ zzbpo zzc;
    private final zzbpm zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbow(zzbpo zzbpoVar, zzbpm zzbpmVar) {
        this.zzc = zzbpoVar;
        this.zzd = zzbpmVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdr
    public final void zza(long j11) {
        zzbpd zzbpdVar;
        Object obj;
        zzbpd zzbpdVar2;
        long j12;
        long j13;
        zzbox zzboxVar;
        long j14;
        long j15;
        zzbpdVar = this.zzc.zzs;
        if (zzbpdVar.zzf != null) {
            return;
        }
        obj = this.zzc.zzm;
        synchronized (obj) {
            try {
                zzbpdVar2 = this.zzc.zzs;
                if (zzbpdVar2.zzf == null) {
                    zzbpm zzbpmVar = this.zzd;
                    if (!zzbpmVar.zzb) {
                        long j16 = this.zzb + j11;
                        this.zzb = j16;
                        zzbpo zzbpoVar = this.zzc;
                        j12 = zzbpoVar.zzx;
                        if (j16 <= j12) {
                            return;
                        }
                        j13 = zzbpoVar.zzo;
                        if (j16 > j13) {
                            zzbpmVar.zzc = true;
                        } else {
                            zzboxVar = zzbpoVar.zzn;
                            j14 = zzbpoVar.zzx;
                            long zza = zzboxVar.zza(j16 - j14);
                            this.zzc.zzx = this.zzb;
                            j15 = this.zzc.zzp;
                            if (zza > j15) {
                                this.zzd.zzc = true;
                            }
                        }
                        zzbpm zzbpmVar2 = this.zzd;
                        Runnable zzag = zzbpmVar2.zzc ? this.zzc.zzag(zzbpmVar2) : null;
                        if (zzag != null) {
                            zzag.run();
                        }
                    }
                }
            } finally {
            }
        }
    }
}
