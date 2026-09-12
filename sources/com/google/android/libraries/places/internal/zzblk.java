package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzblk extends zzayk {
    final /* synthetic */ zzbls zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblk(zzbls zzblsVar) {
        this.zza = zzblsVar;
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final zzayo zza(zzbcl zzbclVar, zzayj zzayjVar) {
        zzbkt zzbktVar;
        boolean z10;
        zzbfw zzbfwVar;
        ScheduledExecutorService zzb;
        zzbfg zzbfgVar;
        zzazq zzazqVar;
        zzazd zzazdVar;
        zzbma zzbmaVar = this.zza.zza;
        Executor zzJ = zzbma.zzJ(zzbmaVar, zzayjVar);
        zzbktVar = zzbmaVar.zzai;
        z10 = zzbmaVar.zzR;
        if (z10) {
            zzb = null;
        } else {
            zzbfwVar = this.zza.zza.zzq;
            zzb = zzbfwVar.zzb();
        }
        ScheduledExecutorService scheduledExecutorService = zzb;
        zzbfgVar = this.zza.zza.zzU;
        zzbfq zzbfqVar = new zzbfq(zzbclVar, zzJ, zzayjVar, zzbktVar, scheduledExecutorService, zzbfgVar, null);
        zzazqVar = this.zza.zza.zzx;
        zzbfqVar.zzn(zzazqVar);
        zzazdVar = this.zza.zza.zzy;
        zzbfqVar.zzm(zzazdVar);
        return zzbfqVar;
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final String zzb() {
        String str;
        str = this.zza.zzc;
        return str;
    }
}
