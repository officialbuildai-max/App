package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
abstract class zzawn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzb(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zzc(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zzd(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i11, int i12);

    abstract void zzi(Object obj, int i11, long j11);

    abstract void zzj(Object obj, int i11, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzk(Object obj, int i11, zzask zzaskVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(Object obj, int i11, long j11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzm(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzo(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(Object obj, zzavs zzavsVar) throws IOException {
        int zzd = zzavsVar.zzd();
        int i11 = zzd >>> 3;
        int i12 = zzd & 7;
        if (i12 == 0) {
            zzl(obj, i11, zzavsVar.zzl());
            return true;
        }
        if (i12 == 1) {
            zzi(obj, i11, zzavsVar.zzk());
            return true;
        }
        if (i12 == 2) {
            zzk(obj, i11, zzavsVar.zzp());
            return true;
        }
        if (i12 != 3) {
            if (i12 == 4) {
                return false;
            }
            if (i12 != 5) {
                throw zzauf.zza();
            }
            zzh(obj, i11, zzavsVar.zzf());
            return true;
        }
        Object zzf = zzf();
        int i13 = i11 << 3;
        while (zzavsVar.zzc() != Integer.MAX_VALUE && zzp(zzf, zzavsVar)) {
        }
        if ((4 | i13) != zzavsVar.zzd()) {
            throw zzauf.zzb();
        }
        zzg(zzf);
        zzj(obj, i11, zzf);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzq(zzavs zzavsVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzr(Object obj, zzasy zzasyVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzs(Object obj, zzasy zzasyVar) throws IOException;
}
