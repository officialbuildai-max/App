package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbhn implements Runnable {
    final /* synthetic */ zzazn zza;
    final /* synthetic */ zzbhy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhn(zzbhy zzbhyVar, zzazn zzaznVar) {
        this.zza = zzaznVar;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfr zzbfrVar;
        zzbfrVar = this.zzb.zzc;
        zzbfrVar.zzk(this.zza);
    }
}
