package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbgo implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbgz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgo(zzbgz zzbgzVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayo zzayoVar;
        zzbdo zzbdoVar = this.zza;
        zzayoVar = this.zzb.zzh;
        zzayoVar.zza(zzbdoVar.zzi(), zzbdoVar.zzj());
    }
}
