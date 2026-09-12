package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbpl implements zzbft {
    final zzbpm zza;
    final /* synthetic */ zzbpo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpl(zzbpo zzbpoVar, zzbpm zzbpmVar) {
        this.zzb = zzbpoVar;
        this.zza = zzbpmVar;
    }

    private static final Integer zza(zzbcf zzbcfVar) {
        String str = (String) zzbcfVar.zzb(zzbpo.zzi);
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f9, code lost:
    
        if (r4.compareAndSet(false, true) != false) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0276  */
    @Override // com.google.android.libraries.places.internal.zzbft
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(com.google.android.libraries.places.internal.zzbdo r21, com.google.android.libraries.places.internal.zzbfs r22, com.google.android.libraries.places.internal.zzbcf r23) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbpl.zzd(com.google.android.libraries.places.internal.zzbdo, com.google.android.libraries.places.internal.zzbfs, com.google.android.libraries.places.internal.zzbcf):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbft
    public final void zze(zzbcf zzbcfVar) {
        zzbpd zzbpdVar;
        zzbpn zzbpnVar;
        Executor executor;
        zzbpn zzbpnVar2;
        int i11;
        int i12;
        if (this.zza.zzd > 0) {
            zzbca zzbcaVar = zzbpo.zzh;
            zzbcfVar.zzd(zzbcaVar);
            zzbcfVar.zzf(zzbcaVar, String.valueOf(this.zza.zzd));
        }
        zzbpo.zzW(this.zzb, this.zza);
        zzbpdVar = this.zzb.zzs;
        if (zzbpdVar.zzf == this.zza) {
            zzbpo zzbpoVar = this.zzb;
            zzbpnVar = zzbpoVar.zzq;
            if (zzbpnVar != null) {
                zzbpnVar2 = zzbpoVar.zzq;
                do {
                    i11 = zzbpnVar2.zzd.get();
                    i12 = zzbpnVar2.zza;
                    if (i11 == i12) {
                        break;
                    }
                } while (!zzbpnVar2.zzd.compareAndSet(i11, Math.min(zzbpnVar2.zzc + i11, i12)));
            }
            executor = this.zzb.zze;
            zzbdw zzbdwVar = (zzbdw) executor;
            zzbdwVar.zzc(new zzbpe(this, zzbcfVar));
            zzbdwVar.zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbqr
    public final void zzf(zzbqq zzbqqVar) {
        zzbpd zzbpdVar;
        Executor executor;
        zzbpdVar = this.zzb.zzs;
        zzmt.zzp(zzbpdVar.zzf != null, "Headers should be received prior to messages.");
        if (zzbpdVar.zzf != this.zza) {
            zzbjd.zzh(zzbqqVar);
            return;
        }
        executor = this.zzb.zze;
        zzbdw zzbdwVar = (zzbdw) executor;
        zzbdwVar.zzc(new zzbpj(this, zzbqqVar));
        zzbdwVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbqr
    public final void zzg() {
        Executor executor;
        if (this.zzb.zzp()) {
            executor = this.zzb.zze;
            zzbdw zzbdwVar = (zzbdw) executor;
            zzbdwVar.zzc(new zzbpk(this));
            zzbdwVar.zzb();
        }
    }
}
