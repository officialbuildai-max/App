package com.google.android.libraries.places.internal;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzblg extends zzbbd {
    zzbeq zza;
    final /* synthetic */ zzbma zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzblg(zzbma zzbmaVar, zzblf zzblfVar) {
        this.zzb = zzbmaVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final /* bridge */ /* synthetic */ zzbbj zza(zzbba zzbbaVar) {
        boolean z10;
        this.zzb.zzf.zzd();
        z10 = this.zzb.zzQ;
        zzmt.zzp(!z10, "Channel is being terminated");
        return new zzblx(this.zzb, zzbbaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final zzbdw zzb() {
        return this.zzb.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final ScheduledExecutorService zzc() {
        zzblu zzbluVar;
        zzbluVar = this.zzb.zzs;
        return zzbluVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final void zzd() {
        this.zzb.zzf.zzd();
        zzbld zzbldVar = new zzbld(this);
        zzbdw zzbdwVar = this.zzb.zzf;
        zzbdwVar.zzc(zzbldVar);
        zzbdwVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbbd
    public final void zze(zzaze zzazeVar, zzbbk zzbbkVar) {
        this.zzb.zzf.zzd();
        zzmt.zzc(zzazeVar, "newState");
        zzble zzbleVar = new zzble(this, zzbbkVar, zzazeVar);
        zzbdw zzbdwVar = this.zzb.zzf;
        zzbdwVar.zzc(zzbleVar);
        zzbdwVar.zzb();
    }
}
