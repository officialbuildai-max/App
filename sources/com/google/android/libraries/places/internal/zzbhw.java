package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbhw implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbfs zzb;
    final /* synthetic */ zzbcf zzc;
    final /* synthetic */ zzbhx zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhw(zzbhx zzbhxVar, zzbdo zzbdoVar, zzbfs zzbfsVar, zzbcf zzbcfVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbfsVar;
        this.zzc = zzbcfVar;
        this.zzd = zzbhxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbft zzbftVar;
        zzbftVar = this.zzd.zza;
        zzbftVar.zzd(this.zza, this.zzb, this.zzc);
    }
}
