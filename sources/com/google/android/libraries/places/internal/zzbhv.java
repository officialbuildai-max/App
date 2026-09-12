package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbhv implements Runnable {
    final /* synthetic */ zzbcf zza;
    final /* synthetic */ zzbhx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhv(zzbhx zzbhxVar, zzbcf zzbcfVar) {
        this.zza = zzbcfVar;
        this.zzb = zzbhxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbft zzbftVar;
        zzbftVar = this.zzb.zza;
        zzbftVar.zze(this.zza);
    }
}
