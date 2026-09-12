package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzbkv extends zzazv {
    private final zzbam zza;
    private final zzayk zzb;
    private final Executor zzc;
    private final zzbcl zzd;
    private final zzazj zze;
    private zzayj zzf;
    private zzayo zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkv(zzbam zzbamVar, zzayk zzaykVar, Executor executor, zzbcl zzbclVar, zzayj zzayjVar) {
        this.zza = zzbamVar;
        this.zzb = zzaykVar;
        this.zzd = zzbclVar;
        executor = zzayjVar.zzn() != null ? zzayjVar.zzn() : executor;
        this.zzc = executor;
        this.zzf = zzayjVar.zzb(executor);
        this.zze = zzazj.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbdc, com.google.android.libraries.places.internal.zzayo
    public final void zza(String str, Throwable th2) {
        zzayo zzayoVar = this.zzg;
        if (zzayoVar != null) {
            zzayoVar.zza(str, th2);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzazv, com.google.android.libraries.places.internal.zzayo
    public final void zze(zzayn zzaynVar, zzbcf zzbcfVar) {
        zzayo zzayoVar;
        zzbal zza = this.zza.zza(new zzbnr(this.zzd, zzbcfVar, this.zzf));
        zzbdo zzb = zza.zzb();
        if (!zzb.zzl()) {
            this.zzc.execute(new zzbku(this, zzaynVar, zzbjd.zzb(zzb)));
            zzayoVar = zzbma.zzj;
            this.zzg = zzayoVar;
            return;
        }
        zzbmg zzb2 = ((zzbmj) zza.zzc()).zzb(this.zzd);
        if (zzb2 != null) {
            this.zzf = this.zzf.zze(zzbmg.zza, zzb2);
        }
        zzayo zza2 = this.zzb.zza(this.zzd, this.zzf);
        this.zzg = zza2;
        zza2.zze(zzaynVar, zzbcfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.places.internal.zzazv, com.google.android.libraries.places.internal.zzbdc
    public final zzayo zzf() {
        return this.zzg;
    }
}
