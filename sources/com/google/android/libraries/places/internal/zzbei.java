package com.google.android.libraries.places.internal;

/* loaded from: classes4.dex */
public abstract class zzbei implements zzbel, zzbmm {
    private zzbgj zzr;
    private final Object zzs = new Object();
    private final zzbqo zzt;
    private final zzbqz zzu;
    private final zzbmq zzv;
    private int zzw;
    private boolean zzx;
    private boolean zzy;
    private final int zzz;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbei(int i11, zzbqo zzbqoVar, zzbqz zzbqzVar) {
        this.zzt = zzbqoVar;
        this.zzu = zzbqzVar;
        zzbmq zzbmqVar = new zzbmq(this, zzaza.zza, i11, zzbqoVar, zzbqzVar);
        this.zzv = zzbmqVar;
        this.zzr = zzbmqVar;
        this.zzz = 32768;
    }

    private final void zzb() {
        boolean zzc;
        synchronized (this.zzs) {
            zzc = zzc();
        }
        if (zzc) {
            zza().zzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc() {
        boolean z10;
        synchronized (this.zzs) {
            try {
                z10 = false;
                if (this.zzx && this.zzw < this.zzz && !this.zzy) {
                    z10 = true;
                }
            } finally {
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzn(zzbei zzbeiVar, int i11) {
        synchronized (zzbeiVar.zzs) {
            zzbeiVar.zzw += i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzo(zzbei zzbeiVar, int i11) {
        zzbgj zzbgjVar = zzbeiVar.zzr;
        zzbeiVar.zzz(new zzbeh(zzbeiVar, zzbvr.zza(), 2));
    }

    protected abstract zzbqr zza();

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbqz zzm() {
        return this.zzu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzp(boolean z10) {
        if (z10) {
            this.zzr.close();
        } else {
            this.zzr.zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzq(zzbnv zzbnvVar) {
        try {
            this.zzr.zzb(zzbnvVar);
        } catch (Throwable th2) {
            zzF(th2);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmm
    public final void zzr(zzbqq zzbqqVar) {
        zza().zzf(zzbqqVar);
    }

    public final void zzs(int i11) {
        boolean z10;
        synchronized (this.zzs) {
            zzmt.zzp(this.zzx, "onStreamAllocated was not called, but it seems the stream is active");
            int i12 = this.zzw;
            int i13 = this.zzz;
            int i14 = i12 - i11;
            this.zzw = i14;
            z10 = false;
            if (i12 >= i13 && i14 < i13) {
                z10 = true;
            }
        }
        if (z10) {
            zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzt() {
        zzmt.zzo(zza() != null);
        synchronized (this.zzs) {
            zzmt.zzp(!this.zzx, "Already allocated");
            this.zzx = true;
        }
        zzb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzu() {
        synchronized (this.zzs) {
            this.zzy = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv() {
        this.zzv.zzf(this);
        this.zzr = this.zzv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw(zzazo zzazoVar) {
        this.zzr.zzd(zzazoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzx(int i11) {
        this.zzr.zze(i11);
    }
}
