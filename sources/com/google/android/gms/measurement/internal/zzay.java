package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzay implements Runnable {
    private final /* synthetic */ zzjc zza;
    private final /* synthetic */ zzav zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(zzav zzavVar, zzjc zzjcVar) {
        this.zza = zzjcVar;
        this.zzb = zzavVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzd();
        if (zzab.zza()) {
            this.zza.zzl().zzb(this);
            return;
        }
        boolean zzc = this.zzb.zzc();
        this.zzb.zzd = 0L;
        if (zzc) {
            this.zzb.zzb();
        }
    }
}
