package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbgp implements Runnable {
    final /* synthetic */ Object zza;
    final /* synthetic */ zzbgz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgp(zzbgz zzbgzVar, Object obj) {
        this.zza = obj;
        this.zzb = zzbgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayo zzayoVar;
        zzayoVar = this.zzb.zzh;
        zzayoVar.zzd(this.zza);
    }
}
