package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzmj implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzbf zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzls zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmj(zzls zzlsVar, boolean z10, zzo zzoVar, boolean z11, zzbf zzbfVar, String str) {
        this.zza = z10;
        this.zzb = zzoVar;
        this.zzc = z11;
        this.zzd = zzbfVar;
        this.zze = str;
        this.zzf = zzlsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgb zzgbVar;
        long j11;
        long j12;
        long j13;
        zzgbVar = this.zzf.zzb;
        if (zzgbVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzgbVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            boolean zza = this.zzf.zze().zza(zzbh.zzce);
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    Preconditions.checkNotNull(this.zzb);
                    if (zza) {
                        j13 = this.zzf.zzu.zzb().currentTimeMillis();
                        try {
                            j11 = this.zzf.zzu.zzb().elapsedRealtime();
                        } catch (RemoteException e11) {
                            e = e11;
                            j11 = 0;
                            j12 = j13;
                            this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
                            if (zza) {
                                zzgm.zza(this.zzf.zzu).zza(36301, 13, j12, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - j11));
                            }
                            this.zzf.zzar();
                        }
                    } else {
                        j13 = 0;
                        j11 = 0;
                    }
                    try {
                        zzgbVar.zza(this.zzd, this.zzb);
                        if (zza) {
                            this.zzf.zzj().zzp().zza("Logging telemetry for logEvent");
                            zzgm.zza(this.zzf.zzu).zza(36301, 0, j13, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - j11));
                        }
                    } catch (RemoteException e12) {
                        e = e12;
                        j12 = j13;
                        this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
                        if (zza && j12 != 0) {
                            zzgm.zza(this.zzf.zzu).zza(36301, 13, j12, this.zzf.zzu.zzb().currentTimeMillis(), (int) (this.zzf.zzu.zzb().elapsedRealtime() - j11));
                        }
                        this.zzf.zzar();
                    }
                } else {
                    zzgbVar.zza(this.zzd, this.zze, this.zzf.zzj().zzx());
                }
            } catch (RemoteException e13) {
                e = e13;
                j11 = 0;
                j12 = 0;
            }
        }
        this.zzf.zzar();
    }
}
