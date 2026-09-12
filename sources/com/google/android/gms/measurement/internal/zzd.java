package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzd implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(zzb zzbVar, String str, long j11) {
        this.zza = str;
        this.zzb = j11;
        this.zzc = zzbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb.zzb(this.zzc, this.zza, this.zzb);
    }
}
