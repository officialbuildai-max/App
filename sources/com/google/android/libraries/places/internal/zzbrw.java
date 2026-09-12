package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbrw implements zzbec {
    final /* synthetic */ zzbry zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbrw(zzbry zzbryVar) {
        this.zza = zzbryVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zza(zzbdo zzbdoVar) {
        zzbrx zzbrxVar;
        Object obj;
        zzbrx zzbrxVar2;
        int i11 = zzbvr.zza;
        zzbrxVar = this.zza.zzf;
        obj = zzbrxVar.zzc;
        synchronized (obj) {
            zzbrxVar2 = this.zza.zzf;
            zzbrxVar2.zzQ(zzbdoVar, true, null);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zzb(zzbra zzbraVar, boolean z10, boolean z11, int i11) {
        zzbwb zze;
        zzbrx zzbrxVar;
        Object obj;
        zzbrx zzbrxVar2;
        zzbqz zze2;
        int i12 = zzbvr.zza;
        if (zzbraVar == null) {
            zze = zzbry.zza;
        } else {
            zze = ((zzbsn) zzbraVar).zze();
            int zzg = (int) zze.zzg();
            if (zzg > 0) {
                this.zza.zzs(zzg);
            }
        }
        zzbrxVar = this.zza.zzf;
        obj = zzbrxVar.zzc;
        synchronized (obj) {
            zzbrxVar2 = this.zza.zzf;
            zzbrx.zzL(zzbrxVar2, zze, z10, z11);
            zze2 = this.zza.zze();
            zze2.zzd(i11);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zzc(zzbcf zzbcfVar, byte[] bArr) {
        zzbcl zzbclVar;
        zzbrx zzbrxVar;
        Object obj;
        zzbrx zzbrxVar2;
        int i11 = zzbvr.zza;
        zzbclVar = this.zza.zzb;
        String str = "/" + zzbclVar.zzf();
        zzbrxVar = this.zza.zzf;
        obj = zzbrxVar.zzc;
        synchronized (obj) {
            zzbrxVar2 = this.zza.zzf;
            zzbrx.zzM(zzbrxVar2, zzbcfVar, str);
        }
    }
}
