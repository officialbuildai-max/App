package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzbfo implements zzbft {
    final /* synthetic */ zzbfq zza;
    private final zzayn zzb;
    private zzbdo zzc;

    public zzbfo(zzbfq zzbfqVar, zzayn zzaynVar) {
        this.zza = zzbfqVar;
        this.zzb = zzaynVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(zzbfo zzbfoVar, zzbdo zzbdoVar) {
        zzbfr zzbfrVar;
        zzbfoVar.zzc = zzbdoVar;
        zzbfrVar = zzbfoVar.zza.zzm;
        zzbfrVar.zzh(zzbdoVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbft
    public final void zzd(zzbdo zzbdoVar, zzbfs zzbfsVar, zzbcf zzbcfVar) {
        zzazn zzr;
        Executor executor;
        zzbfj zzbfjVar;
        int i11 = zzbvr.zza;
        zzr = this.zza.zzr();
        if (zzbdoVar.zza() == zzbdj.CANCELLED && zzr != null && zzr.zze()) {
            zzbfjVar = this.zza.zzj;
            zzbdoVar = zzbfjVar.zzb();
            zzbcfVar = new zzbcf();
        }
        zzbvq zza = zzbvr.zza();
        executor = this.zza.zzf;
        executor.execute(new zzbfm(this, zza, zzbdoVar, zzbcfVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbft
    public final void zze(zzbcf zzbcfVar) {
        Executor executor;
        zzbvq zza = zzbvr.zza();
        executor = this.zza.zzf;
        executor.execute(new zzbfk(this, zza, zzbcfVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbqr
    public final void zzf(zzbqq zzbqqVar) {
        Executor executor;
        zzbvq zza = zzbvr.zza();
        executor = this.zza.zzf;
        executor.execute(new zzbfl(this, zza, zzbqqVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbqr
    public final void zzg() {
        zzbcl zzbclVar;
        Executor executor;
        zzbclVar = this.zza.zzd;
        zzbcj zzb = zzbclVar.zzb();
        if (zzb == zzbcj.UNARY || zzb == zzbcj.SERVER_STREAMING) {
            return;
        }
        zzbvq zza = zzbvr.zza();
        executor = this.zza.zzf;
        executor.execute(new zzbfn(this, zza));
    }
}
