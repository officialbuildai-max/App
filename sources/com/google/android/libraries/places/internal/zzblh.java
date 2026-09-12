package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzblh implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzblj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblh(zzblj zzbljVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbls zzblsVar;
        int i11;
        zzblg zzblgVar;
        zzaym zzaymVar;
        Logger logger = zzbma.zza;
        Level level = Level.WARNING;
        zzblj zzbljVar = this.zzb;
        zzbap zzc = zzbljVar.zzc.zzc();
        zzbdo zzbdoVar = this.zza;
        logger.logp(level, "io.grpc.internal.ManagedChannelImpl$NameResolverListener", "handleErrorInSyncContext", "[{0}] Failed to resolve name. status={1}", new Object[]{zzc, zzbdoVar});
        zzblsVar = zzbljVar.zzc.zzY;
        zzblsVar.zzf();
        zzbma zzbmaVar = zzbljVar.zzc;
        i11 = zzbmaVar.zzak;
        if (i11 != 3) {
            zzaymVar = zzbmaVar.zzW;
            zzaymVar.zzb(3, "Failed to resolve name: {0}", zzbdoVar);
            zzbljVar.zzc.zzak = 3;
        }
        zzblg zzblgVar2 = zzbljVar.zza;
        zzblgVar = zzbljVar.zzc.zzG;
        if (zzblgVar2 != zzblgVar) {
            return;
        }
        zzblgVar2.zza.zza().zzb(zzbdoVar);
    }
}
