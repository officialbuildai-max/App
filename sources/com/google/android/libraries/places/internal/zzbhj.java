package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbhj implements Runnable {
    final /* synthetic */ zzazc zza;
    final /* synthetic */ zzbhy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhj(zzbhy zzbhyVar, zzazc zzazcVar) {
        this.zza = zzazcVar;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfr zzbfrVar;
        zzbfrVar = this.zzb.zzc;
        zzbfrVar.zzv(this.zza);
    }
}
