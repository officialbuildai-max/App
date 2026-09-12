package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzgo {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzhd zzc;
    private static final zzhd zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzhd zzhdVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzhdVar = (zzhd) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzhdVar;
        zzd = new zzhf();
    }

    public static void zzA(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzz(i11, list, z10);
    }

    public static void zzB(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzB(i11, list, z10);
    }

    public static void zzC(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzD(i11, list, z10);
    }

    public static void zzD(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzI(i11, list, z10);
    }

    public static void zzE(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzK(i11, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzu(zzeyVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzu(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzee.zzx(i11 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i11, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzee.zzx(i11 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzu(zzeyVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzu(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzy(zzfrVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzy(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i11, Object obj, zzgm zzgmVar) {
        int i12 = i11 << 3;
        if (!(obj instanceof zzfi)) {
            return zzee.zzx(i12) + zzee.zzv((zzgc) obj, zzgmVar);
        }
        int i13 = zzee.zzb;
        int zza2 = ((zzfi) obj).zza();
        return zzee.zzx(i12) + zzee.zzx(zza2) + zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i11 = 0;
            while (i12 < size) {
                int zze = zzeyVar.zze(i12);
                i11 += zzee.zzx((zze >> 31) ^ (zze + zze));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                int intValue = ((Integer) list.get(i12)).intValue();
                i11 += zzee.zzx((intValue >> 31) ^ (intValue + intValue));
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i11 = 0;
            while (i12 < size) {
                long zze = zzfrVar.zze(i12);
                i11 += zzee.zzy((zze >> 63) ^ (zze + zze));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                long longValue = ((Long) list.get(i12)).longValue();
                i11 += zzee.zzy((longValue >> 63) ^ (longValue + longValue));
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzx(zzeyVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzx(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzy(zzfrVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzee.zzy(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static zzhd zzm() {
        return zzc;
    }

    public static zzhd zzn() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i11, int i12, Object obj2, zzhd zzhdVar) {
        if (obj2 == null) {
            obj2 = zzhdVar.zzc(obj);
        }
        zzhdVar.zzf(obj2, i11, i12);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(zzhd zzhdVar, Object obj, Object obj2) {
        zzhdVar.zzh(obj, zzhdVar.zze(zzhdVar.zzd(obj), zzhdVar.zzd(obj2)));
    }

    public static void zzq(Class cls) {
        Class cls2;
        if (!zzex.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzr(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzc(i11, list, z10);
    }

    public static void zzs(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzg(i11, list, z10);
    }

    public static void zzt(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzj(i11, list, z10);
    }

    public static void zzu(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzl(i11, list, z10);
    }

    public static void zzv(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzn(i11, list, z10);
    }

    public static void zzw(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzp(i11, list, z10);
    }

    public static void zzx(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzs(i11, list, z10);
    }

    public static void zzy(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzu(i11, list, z10);
    }

    public static void zzz(int i11, List list, zzhv zzhvVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzx(i11, list, z10);
    }
}
