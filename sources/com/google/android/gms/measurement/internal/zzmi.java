package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzmi implements Runnable {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdo zzc;
    private final /* synthetic */ zzls zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmi(zzls zzlsVar, zzbf zzbfVar, String str, com.google.android.gms.internal.measurement.zzdo zzdoVar) {
        this.zza = zzbfVar;
        this.zzb = str;
        this.zzc = zzdoVar;
        this.zzd = zzlsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgb zzgbVar;
        try {
            zzgbVar = this.zzd.zzb;
            if (zzgbVar == null) {
                this.zzd.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] zza = zzgbVar.zza(this.zza, this.zzb);
            this.zzd.zzar();
            this.zzd.zzq().zza(this.zzc, zza);
        } catch (RemoteException e11) {
            this.zzd.zzj().zzg().zza("Failed to send event to the service to bundle", e11);
        } finally {
            this.zzd.zzq().zza(this.zzc, (byte[]) null);
        }
    }
}
