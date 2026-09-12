package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zznx implements Runnable {
    private final /* synthetic */ zzok zza;
    private final /* synthetic */ zznv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznx(zznv zznvVar, zzok zzokVar) {
        this.zza = zzokVar;
        this.zzb = zznvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznv.zza(this.zzb, this.zza);
        this.zzb.zzv();
    }
}
