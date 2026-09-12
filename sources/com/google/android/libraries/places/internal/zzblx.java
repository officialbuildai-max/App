package com.google.android.libraries.places.internal;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzblx extends zzbek {
    final zzbba zza;
    final zzbap zzb;
    final zzbfh zzc;
    final zzbfi zzd;
    List zze;
    zzbkd zzf;
    boolean zzg;
    boolean zzh;
    zzbdv zzi;
    final /* synthetic */ zzbma zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblx(zzbma zzbmaVar, zzbba zzbbaVar) {
        zzbqt zzbqtVar;
        zzbqt zzbqtVar2;
        this.zzj = zzbmaVar;
        this.zze = zzbbaVar.zzc();
        this.zza = zzbbaVar;
        zzbap zzc = zzbap.zzc("Subchannel", zzbmaVar.zzb());
        this.zzb = zzc;
        zzbqtVar = zzbmaVar.zzw;
        zzbfi zzbfiVar = new zzbfi(zzc, 0, zzbqtVar.zza(), "Subchannel for ".concat(zzbbaVar.zzc().toString()));
        this.zzd = zzbfiVar;
        zzbqtVar2 = zzbmaVar.zzw;
        this.zzc = new zzbfh(zzbfiVar, zzbqtVar2);
    }

    public final String toString() {
        return this.zzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbbj
    public final void zza() {
        this.zzj.zzf.zzd();
        zzmt.zzp(this.zzg, "not started");
        this.zzf.zzh();
    }

    @Override // com.google.android.libraries.places.internal.zzbbj
    public final void zzb() {
        boolean z10;
        zzbfw zzbfwVar;
        boolean z11;
        zzbdv zzbdvVar;
        this.zzj.zzf.zzd();
        if (this.zzf == null) {
            this.zzh = true;
            return;
        }
        if (this.zzh) {
            z11 = this.zzj.zzQ;
            if (!z11 || (zzbdvVar = this.zzi) == null) {
                return;
            }
            zzbdvVar.zza();
            this.zzi = null;
        } else {
            this.zzh = true;
        }
        zzbma zzbmaVar = this.zzj;
        z10 = zzbmaVar.zzQ;
        if (z10) {
            this.zzf.zzF(zzbma.zzd);
            return;
        }
        zzbki zzbkiVar = new zzbki(new zzblw(this));
        zzbma zzbmaVar2 = this.zzj;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        zzbfwVar = zzbmaVar2.zzq;
        this.zzi = zzbmaVar.zzf.zza(zzbkiVar, 5L, timeUnit, zzbfwVar.zzb());
    }

    @Override // com.google.android.libraries.places.internal.zzbbj
    public final void zzc(zzbbl zzbblVar) {
        boolean z10;
        zzbij zzbijVar;
        zzbfw zzbfwVar;
        zzbfw zzbfwVar2;
        zznc zzncVar;
        zzbah zzbahVar;
        zzbff zzbffVar;
        List list;
        zzbfi zzbfiVar;
        zzbqt zzbqtVar;
        zzbah zzbahVar2;
        Set set;
        this.zzj.zzf.zzd();
        zzmt.zzp(!this.zzg, "already started");
        zzmt.zzp(!this.zzh, "already shutdown");
        z10 = this.zzj.zzQ;
        zzmt.zzp(!z10, "Channel is being terminated");
        this.zzg = true;
        zzbma zzbmaVar = this.zzj;
        List zzc = this.zza.zzc();
        String zzb = zzbmaVar.zzb();
        zzbijVar = zzbmaVar.zzan;
        zzbfwVar = zzbmaVar.zzq;
        zzbfwVar2 = zzbmaVar.zzq;
        ScheduledExecutorService zzb2 = zzbfwVar2.zzb();
        zzncVar = this.zzj.zzz;
        zzblv zzblvVar = new zzblv(this, zzbblVar);
        zzbma zzbmaVar2 = this.zzj;
        zzbahVar = zzbmaVar2.zzX;
        zzbffVar = zzbmaVar2.zzT;
        zzbfg zza = zzbffVar.zza();
        zzbfi zzbfiVar2 = this.zzd;
        zzbap zzbapVar = this.zzb;
        zzbfh zzbfhVar = this.zzc;
        zzbma zzbmaVar3 = this.zzj;
        list = zzbmaVar3.zzD;
        zzbkd zzbkdVar = new zzbkd(zzc, zzb, null, zzbijVar, zzbfwVar, zzb2, zzncVar, zzbmaVar3.zzf, zzblvVar, zzbahVar, zza, zzbfiVar2, zzbapVar, zzbfhVar, list);
        zzbfiVar = this.zzj.zzV;
        zzbab zzbabVar = new zzbab();
        zzbabVar.zza("Child Subchannel started");
        zzbabVar.zzb(zzbac.CT_INFO);
        zzbqtVar = this.zzj.zzw;
        zzbabVar.zzd(zzbqtVar.zza());
        zzbabVar.zzc(zzbkdVar);
        zzbfiVar.zzc(zzbabVar.zze());
        this.zzf = zzbkdVar;
        zzbahVar2 = this.zzj.zzX;
        zzbahVar2.zze(zzbkdVar);
        set = this.zzj.zzJ;
        set.add(zzbkdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbbj
    public final void zzd(List list) {
        this.zzj.zzf.zzd();
        this.zze = list;
        this.zzf.zzG(list);
    }
}
