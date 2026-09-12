package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzit implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzic zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzit(zzic zzicVar, zzo zzoVar) {
        this.zza = zzoVar;
        this.zzb = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznv zznvVar;
        zznv zznvVar2;
        zznvVar = this.zzb.zza;
        zznvVar.zzr();
        zznvVar2 = this.zzb.zza;
        zznvVar2.zze(this.zza);
    }
}
