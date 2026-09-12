package com.google.android.libraries.places.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbeh implements Runnable {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbei zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbeh(zzbei zzbeiVar, zzbvq zzbvqVar, int i11) {
        this.zza = zzbvqVar;
        this.zzb = zzbeiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgj zzbgjVar;
        try {
            int i11 = zzbvr.zza;
            zzbgjVar = this.zzb.zzr;
            zzbgjVar.zzc(2);
        } catch (Throwable th2) {
            this.zzb.zzF(th2);
        }
    }
}
