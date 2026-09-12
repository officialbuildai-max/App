package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbgw implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbcf zzb;
    final /* synthetic */ zzbgy zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgw(zzbgy zzbgyVar, zzbdo zzbdoVar, zzbcf zzbcfVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbcfVar;
        this.zzc = zzbgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayn zzaynVar;
        zzaynVar = this.zzc.zza;
        zzaynVar.zza(this.zza, this.zzb);
    }
}
