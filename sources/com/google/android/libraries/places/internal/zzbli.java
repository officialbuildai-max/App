package com.google.android.libraries.places.internal;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/* loaded from: classes4.dex */
final class zzbli implements Runnable {
    final /* synthetic */ zzbct zza;
    final /* synthetic */ zzblj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbli(zzblj zzbljVar, zzbct zzbctVar) {
        this.zza = zzbctVar;
        this.zzb = zzbljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcv zzbcvVar;
        zzaym zzaymVar;
        int i11;
        boolean z10;
        zzbls zzblsVar;
        boolean z11;
        zzaym zzaymVar2;
        zzbmj zzbmjVar;
        zzbmj zzbmjVar2;
        zzaym zzaymVar3;
        zzbmj zzbmjVar3;
        zzbkt zzbktVar;
        zzbls zzblsVar2;
        zzbls zzblsVar3;
        zzaym zzaymVar4;
        zzblg zzblgVar;
        zzbls zzblsVar4;
        zzaym zzaymVar5;
        zzaym zzaymVar6;
        zzaym zzaymVar7;
        zzblj zzbljVar = this.zzb;
        zzbma zzbmaVar = zzbljVar.zzc;
        zzbcvVar = zzbmaVar.zzE;
        if (zzbcvVar != zzbljVar.zzb) {
            return;
        }
        zzbct zzbctVar = this.zza;
        List zze = zzbctVar.zze();
        zzaymVar = zzbmaVar.zzW;
        zzaymVar.zzb(1, "Resolved address: {0}, config={1}", zze, zzbctVar.zza());
        zzbma zzbmaVar2 = this.zzb.zzc;
        i11 = zzbmaVar2.zzak;
        if (i11 != 2) {
            zzaymVar7 = zzbmaVar2.zzW;
            zzaymVar7.zzb(2, "Address resolved: {0}", zze);
            this.zzb.zzc.zzak = 2;
        }
        zzbct zzbctVar2 = this.zza;
        zzbcp zzb = zzbctVar2.zzb();
        zzbps zzbpsVar = (zzbps) zzbctVar2.zza().zzc(zzbpv.zza);
        zzbam zzbamVar = (zzbam) this.zza.zza().zzc(zzbam.zza);
        zzbmj zzbmjVar4 = (zzb == null || zzb.zzd() == null) ? null : (zzbmj) zzb.zzd();
        zzbdo zzc = zzb != null ? zzb.zzc() : null;
        zzbma zzbmaVar3 = this.zzb.zzc;
        z10 = zzbmaVar3.zzab;
        if (z10) {
            if (zzbmjVar4 != null) {
                if (zzbamVar != null) {
                    zzblsVar3 = zzbmaVar3.zzY;
                    zzblsVar3.zzg(zzbamVar);
                    if (zzbmjVar4.zza() != null) {
                        zzaymVar4 = this.zzb.zzc.zzW;
                        zzaymVar4.zza(1, "Method configs in service config will be discarded due to presence ofconfig-selector");
                    }
                } else {
                    zzblsVar2 = zzbmaVar3.zzY;
                    zzblsVar2.zzg(zzbmjVar4.zza());
                }
            } else if (zzc != null) {
                z11 = zzbmaVar3.zzaa;
                if (!z11) {
                    zzaymVar2 = zzbmaVar3.zzW;
                    zzaymVar2.zza(2, "Fallback to error due to invalid first service config without default config");
                    this.zzb.zza(zzb.zzc());
                    if (zzbpsVar != null) {
                        zzbpsVar.zza(zzb.zzc());
                        return;
                    }
                    return;
                }
                zzbmjVar4 = zzbmaVar3.zzZ;
            } else {
                zzbmjVar4 = zzbma.zzh;
                zzblsVar = zzbmaVar3.zzY;
                zzblsVar.zzg(null);
            }
            zzbmjVar = this.zzb.zzc.zzZ;
            if (!zzbmjVar4.equals(zzbmjVar)) {
                zzaymVar3 = this.zzb.zzc.zzW;
                zzbmjVar3 = zzbma.zzh;
                zzaymVar3.zzb(2, "Service config changed{0}", zzbmjVar4 == zzbmjVar3 ? " to empty" : "");
                this.zzb.zzc.zzZ = zzbmjVar4;
                zzbktVar = this.zzb.zzc.zzai;
                zzbktVar.zza = zzbmjVar4.zzc();
            }
            try {
                this.zzb.zzc.zzaa = true;
            } catch (RuntimeException e11) {
                zzbma zzbmaVar4 = this.zzb.zzc;
                zzbma.zza.logp(Level.WARNING, "io.grpc.internal.ManagedChannelImpl$NameResolverListener$1NamesResolved", "run", "[" + String.valueOf(zzbmaVar4.zzc()) + "] Unexpected exception from parsing service config", (Throwable) e11);
            }
            zzbmjVar2 = zzbmjVar4;
        } else {
            if (zzbmjVar4 != null) {
                zzaymVar6 = zzbmaVar3.zzW;
                zzaymVar6.zza(2, "Service config from name resolver discarded by channel settings");
            }
            zzblj zzbljVar2 = this.zzb;
            zzbmjVar2 = zzbma.zzh;
            if (zzbamVar != null) {
                zzaymVar5 = zzbljVar2.zzc.zzW;
                zzaymVar5.zza(2, "Config selector from name resolver discarded by channel settings");
            }
            zzblsVar4 = this.zzb.zzc.zzY;
            zzblsVar4.zzg(zzbmjVar2.zza());
        }
        zzbct zzbctVar3 = this.zza;
        zzblj zzbljVar3 = this.zzb;
        zzbma zzbmaVar5 = zzbljVar3.zzc;
        zzaye zza = zzbctVar3.zza();
        zzblg zzblgVar2 = zzbljVar3.zza;
        zzblgVar = zzbmaVar5.zzG;
        if (zzblgVar2 == zzblgVar) {
            zzayb zzb2 = zza.zzb();
            zzb2.zza(zzbam.zza);
            Map zze2 = zzbmjVar2.zze();
            if (zze2 != null) {
                zzb2.zzb(zzbbm.zza, zze2);
                zzb2.zzc();
            }
            zzaye zzc2 = zzb2.zzc();
            zzbeq zzbeqVar = this.zzb.zza.zza;
            zzbbg zzb3 = zzbbi.zzb();
            zzb3.zza(zze);
            zzb3.zzb(zzc2);
            zzb3.zzc(zzbmjVar2.zzd());
            zzbdo zzb4 = zzbeqVar.zzb(zzb3.zzd());
            if (zzbpsVar != null) {
                zzbpsVar.zza(zzb4);
            }
        }
    }
}
