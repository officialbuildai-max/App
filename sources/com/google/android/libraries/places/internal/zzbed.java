package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbed implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbfs zzb;
    final /* synthetic */ zzbcf zzc;
    final /* synthetic */ zzbee zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbed(zzbee zzbeeVar, zzbdo zzbdoVar, zzbfs zzbfsVar, zzbcf zzbcfVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbfsVar;
        this.zzc = zzbcfVar;
        this.zzd = zzbeeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zzA(this.zza, this.zzb, this.zzc);
    }
}
