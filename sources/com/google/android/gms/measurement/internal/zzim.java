package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzim implements Runnable {
    private final /* synthetic */ zzae zza;
    private final /* synthetic */ zzic zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzim(zzic zzicVar, zzae zzaeVar) {
        this.zza = zzaeVar;
        this.zzb = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznv zznvVar;
        zznv zznvVar2;
        zznv zznvVar3;
        zznvVar = this.zzb.zza;
        zznvVar.zzr();
        if (this.zza.zzc.zza() == null) {
            zznvVar3 = this.zzb.zza;
            zznvVar3.zza(this.zza);
        } else {
            zznvVar2 = this.zzb.zza;
            zznvVar2.zzb(this.zza);
        }
    }
}
