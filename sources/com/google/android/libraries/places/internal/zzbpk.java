package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
final class zzbpk implements Runnable {
    final /* synthetic */ zzbpl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpk(zzbpl zzbplVar) {
        this.zza = zzbplVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        zzbft zzbftVar;
        zzbpo zzbpoVar = this.zza.zzb;
        z10 = zzbpoVar.zzD;
        if (z10) {
            return;
        }
        zzbftVar = zzbpoVar.zzy;
        zzbftVar.zzg();
    }
}
