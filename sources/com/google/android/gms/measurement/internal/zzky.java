package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzky implements Runnable {
    private final /* synthetic */ zzax zza;
    private final /* synthetic */ zzjq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzky(zzjq zzjqVar, zzax zzaxVar) {
        this.zza = zzaxVar;
        this.zzb = zzjqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zzb.zzk().zza(this.zza)) {
            this.zzb.zzj().zzo().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.zza.zza()));
            return;
        }
        this.zzb.zzj().zzp().zza("Setting DMA consent(FE)", this.zza);
        if (this.zzb.zzo().zzao()) {
            this.zzb.zzo().zzaj();
        } else {
            this.zzb.zzo().zza(false);
        }
    }
}
