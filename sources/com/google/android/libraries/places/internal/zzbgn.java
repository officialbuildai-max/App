package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbgn implements Runnable {
    final /* synthetic */ zzayn zza;
    final /* synthetic */ zzbcf zzb;
    final /* synthetic */ zzbgz zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgn(zzbgz zzbgzVar, zzayn zzaynVar, zzbcf zzbcfVar) {
        this.zza = zzaynVar;
        this.zzb = zzbcfVar;
        this.zzc = zzbgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayo zzayoVar;
        zzayoVar = this.zzc.zzh;
        zzayoVar.zze(this.zza, this.zzb);
    }
}
