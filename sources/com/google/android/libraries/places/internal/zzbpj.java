package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbpj implements Runnable {
    final /* synthetic */ zzbqq zza;
    final /* synthetic */ zzbpl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpj(zzbpl zzbplVar, zzbqq zzbqqVar) {
        this.zza = zzbqqVar;
        this.zzb = zzbplVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbft zzbftVar;
        zzbftVar = this.zzb.zzb.zzy;
        zzbftVar.zzf(this.zza);
    }
}
