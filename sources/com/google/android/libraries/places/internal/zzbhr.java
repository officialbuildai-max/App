package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbhr implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbhy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhr(zzbhy zzbhyVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfr zzbfrVar;
        zzbfrVar = this.zzb.zzc;
        zzbfrVar.zzh(this.zza);
    }
}
