package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzbsq {
    final /* synthetic */ zzbsu zza;
    private final int zzc;
    private int zzd;
    private int zze;
    private final zzbsp zzf;
    private final zzbwb zzb = new zzbwb();
    private boolean zzg = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbsq(zzbsu zzbsuVar, int i11, int i12, zzbsp zzbspVar) {
        this.zza = zzbsuVar;
        this.zzc = i11;
        this.zzd = i12;
        this.zzf = zzbspVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(int i11) {
        if (i11 <= 0 || Integer.MAX_VALUE - i11 >= this.zzd) {
            int i12 = this.zzd + i11;
            this.zzd = i12;
            return i12;
        }
        throw new IllegalArgumentException("Window size overflow for stream: " + this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzc() {
        return Math.max(0, Math.min(this.zzd, (int) this.zzb.zzg())) - this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzd() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zze() {
        zzbsq zzbsqVar;
        int i11 = this.zzd;
        zzbsqVar = this.zza.zzd;
        return Math.min(i11, zzbsqVar.zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzf(int i11, zzbst zzbstVar) {
        int min = Math.min(i11, zze());
        int i12 = 0;
        while (zzk() && min > 0) {
            zzbwb zzbwbVar = this.zzb;
            if (min >= zzbwbVar.zzg()) {
                i12 += (int) zzbwbVar.zzg();
                zzj(zzbwbVar, (int) zzbwbVar.zzg(), this.zzg);
            } else {
                i12 += min;
                zzj(zzbwbVar, min, false);
            }
            zzbstVar.zza++;
            min = Math.min(i11 - i12, zze());
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(int i11) {
        this.zze += i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh() {
        this.zze = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(zzbwb zzbwbVar, int i11, boolean z10) {
        this.zzb.zzn(zzbwbVar, i11);
        this.zzg |= z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(zzbwb zzbwbVar, int i11, boolean z10) {
        zzbts zzbtsVar;
        zzbsq zzbsqVar;
        zzbts zzbtsVar2;
        do {
            zzbtsVar = this.zza.zzb;
            int min = Math.min(i11, zzbtsVar.zzd());
            int i12 = -min;
            zzbsqVar = this.zza.zzd;
            zzbsqVar.zzb(i12);
            zzb(i12);
            try {
                boolean z11 = false;
                if (zzbwbVar.zzg() == min && z10) {
                    z11 = true;
                }
                zzbtsVar2 = this.zza.zzb;
                zzbtsVar2.zzf(z11, this.zzc, zzbwbVar, min);
                this.zzf.zzs(min);
                i11 -= min;
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        } while (i11 > 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk() {
        return this.zzb.zzg() > 0;
    }
}
