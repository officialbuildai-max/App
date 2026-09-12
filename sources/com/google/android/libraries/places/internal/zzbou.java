package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbou implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbfs zzb;
    final /* synthetic */ zzbcf zzc;
    final /* synthetic */ zzbpo zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbou(zzbpo zzbpoVar, zzbdo zzbdoVar, zzbfs zzbfsVar, zzbcf zzbcfVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbfsVar;
        this.zzc = zzbcfVar;
        this.zzd = zzbpoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbft zzbftVar;
        this.zzd.zzD = true;
        zzbftVar = this.zzd.zzy;
        zzbftVar.zzd(this.zza, this.zzb, this.zzc);
    }
}
