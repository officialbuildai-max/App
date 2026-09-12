package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzblo implements Runnable {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzblq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblo(zzblq zzblqVar, Runnable runnable) {
        this.zza = runnable;
        this.zzb = zzblqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.run();
        zzblq zzblqVar = this.zzb;
        zzblp zzblpVar = new zzblp(zzblqVar);
        zzbdw zzbdwVar = zzblqVar.zzd.zza.zzf;
        zzbdwVar.zzc(zzblpVar);
        zzbdwVar.zzb();
    }
}
