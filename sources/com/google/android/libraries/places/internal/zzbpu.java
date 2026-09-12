package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbpu extends zzbcr {
    final /* synthetic */ zzbpv zza;
    private final zzbcr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpu(zzbpv zzbpvVar, zzbcr zzbcrVar) {
        this.zza = zzbpvVar;
        this.zzb = zzbcrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbcr
    public final void zza(zzbdo zzbdoVar) {
        zzbdw zzbdwVar;
        this.zzb.zza(zzbdoVar);
        zzbdwVar = this.zza.zzd;
        zzbdwVar.zzc(new Runnable() { // from class: com.google.android.libraries.places.internal.zzbpt
            @Override // java.lang.Runnable
            public final void run() {
                zzbpq zzbpqVar;
                zzbpv zzbpvVar = zzbpu.this.zza;
                zzbpqVar = zzbpvVar.zzc;
                zzbpqVar.zzc(new zzbpr(zzbpvVar));
            }
        });
        zzbdwVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbcr
    public final void zzb(zzbct zzbctVar) {
        zzaye zza = zzbctVar.zza();
        zzayc zzaycVar = zzbpv.zza;
        if (zza.zzc(zzaycVar) != null) {
            throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
        }
        zzbcr zzbcrVar = this.zzb;
        zzbcs zzd = zzbctVar.zzd();
        zzayb zzb = zzbctVar.zza().zzb();
        zzb.zzb(zzaycVar, new zzbps(this.zza));
        zzd.zzb(zzb.zzc());
        zzblj zzbljVar = (zzblj) zzbcrVar;
        zzbli zzbliVar = new zzbli(zzbljVar, zzd.zzd());
        zzbdw zzbdwVar = zzbljVar.zzc.zzf;
        zzbdwVar.zzc(zzbliVar);
        zzbdwVar.zzb();
    }
}
