package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes4.dex */
abstract class zzmk<T, B> {
    private static volatile int zza = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(T t11);

    abstract B zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zza(T t11, T t12);

    abstract void zza(B b11, int i11, int i12);

    abstract void zza(B b11, int i11, long j11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b11, int i11, zzik zzikVar);

    abstract void zza(B b11, int i11, T t11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(T t11, zznb zznbVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzlr zzlrVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(B b11, zzlr zzlrVar, int i11) throws IOException {
        int zzd = zzlrVar.zzd();
        int i12 = zzd >>> 3;
        int i13 = zzd & 7;
        if (i13 == 0) {
            zzb(b11, i12, zzlrVar.zzl());
            return true;
        }
        if (i13 == 1) {
            zza((zzmk<T, B>) b11, i12, zzlrVar.zzk());
            return true;
        }
        if (i13 == 2) {
            zza((zzmk<T, B>) b11, i12, zzlrVar.zzp());
            return true;
        }
        if (i13 != 3) {
            if (i13 == 4) {
                return false;
            }
            if (i13 != 5) {
                throw zzkb.zza();
            }
            zza((zzmk<T, B>) b11, i12, zzlrVar.zzf());
            return true;
        }
        B zza2 = zza();
        int i14 = 4 | (i12 << 3);
        int i15 = i11 + 1;
        if (i15 >= zza) {
            throw zzkb.zzh();
        }
        while (zzlrVar.zzc() != Integer.MAX_VALUE && zza((zzmk<T, B>) zza2, zzlrVar, i15)) {
        }
        if (i14 != zzlrVar.zzd()) {
            throw zzkb.zzb();
        }
        zza((zzmk<T, B>) b11, i12, (int) zze(zza2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzb(T t11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(B b11, int i11, long j11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(T t11, zznb zznbVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(Object obj, T t11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzd(Object obj);

    abstract T zze(B b11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzf(Object obj);
}
