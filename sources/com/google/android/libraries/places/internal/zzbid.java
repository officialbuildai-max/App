package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbid implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzbie zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbid(zzbie zzbieVar, boolean z10) {
        this.zza = z10;
        this.zzb = zzbieVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j11;
        zzna zznaVar;
        if (this.zza) {
            zzbih zzbihVar = this.zzb.zza;
            zzbihVar.zzf = true;
            j11 = zzbihVar.zzt;
            if (j11 > 0) {
                zznaVar = zzbihVar.zzv;
                zznaVar.zzc();
                zznaVar.zzd();
            }
        }
        this.zzb.zza.zzA = false;
    }
}
