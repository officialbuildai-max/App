package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbpe implements Runnable {
    final /* synthetic */ zzbcf zza;
    final /* synthetic */ zzbpl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpe(zzbpl zzbplVar, zzbcf zzbcfVar) {
        this.zza = zzbcfVar;
        this.zzb = zzbplVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbft zzbftVar;
        zzbftVar = this.zzb.zzb.zzy;
        zzbftVar.zze(this.zza);
    }
}
