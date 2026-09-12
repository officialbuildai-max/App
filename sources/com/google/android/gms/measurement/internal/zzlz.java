package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzlz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzls zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlz(zzls zzlsVar, AtomicReference atomicReference, zzo zzoVar) {
        this.zza = atomicReference;
        this.zzb = zzoVar;
        this.zzc = zzlsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgb zzgbVar;
        synchronized (this.zza) {
            try {
                try {
                } catch (RemoteException e11) {
                    this.zzc.zzj().zzg().zza("Failed to get app instance id", e11);
                }
                if (!this.zzc.zzk().zzo().zzh()) {
                    this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzm().zzc((String) null);
                    this.zzc.zzk().zze.zza(null);
                    this.zza.set(null);
                    return;
                }
                zzgbVar = this.zzc.zzb;
                if (zzgbVar == null) {
                    this.zzc.zzj().zzg().zza("Failed to get app instance id");
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzgbVar.zzb(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzm().zzc(str);
                    this.zzc.zzk().zze.zza(str);
                }
                this.zzc.zzar();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
