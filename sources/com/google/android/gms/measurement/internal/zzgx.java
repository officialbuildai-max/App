package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzgx implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgx(zzgy zzgyVar, boolean z10) {
        this.zza = z10;
        this.zzb = zzgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznv zznvVar;
        zznvVar = this.zzb.zza;
        zznvVar.zza(this.zza);
    }
}
