package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzgn implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzgo zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgn(zzgo zzgoVar, int i11, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i11;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        this.zzf = zzgoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c11;
        long j11;
        char c12;
        long j12;
        zzha zzn = this.zzf.zzu.zzn();
        if (!zzn.zzaf()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c11 = this.zzf.zza;
        if (c11 == 0) {
            if (this.zzf.zze().zzz()) {
                this.zzf.zza = 'C';
            } else {
                this.zzf.zza = 'c';
            }
        }
        j11 = this.zzf.zzb;
        if (j11 < 0) {
            this.zzf.zzb = 106000L;
        }
        char charAt = "01VDIWEA?".charAt(this.zza);
        c12 = this.zzf.zza;
        j12 = this.zzf.zzb;
        String str = "2" + charAt + c12 + j12 + ":" + zzgo.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        if (str.length() > 1024) {
            str = this.zzb.substring(0, 1024);
        }
        zzhe zzheVar = zzn.zzb;
        if (zzheVar != null) {
            zzheVar.zza(str, 1L);
        }
    }
}
