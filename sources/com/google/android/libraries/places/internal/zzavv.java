package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzavv {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzawn zzc;
    private static final zzawn zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzawn zzawnVar = null;
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
                zzawnVar = (zzawn) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzawnVar;
        zzd = new zzawp();
    }

    public static void zzA(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzs(i11, list, z10);
    }

    public static void zzB(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzu(i11, list, z10);
    }

    public static void zzC(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzy(i11, list, z10);
    }

    public static void zzD(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzA(i11, list, z10);
    }

    public static void zzE(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzC(i11, list, z10);
    }

    public static void zzF(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzE(i11, list, z10);
    }

    public static void zzG(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzJ(i11, list, z10);
    }

    public static void zzH(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzL(i11, list, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzC(zzatvVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzC(((Integer) list.get(i12)).intValue());
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
        return size * (zzasx.zzB(i11 << 3) + 4);
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
        return size * (zzasx.zzB(i11 << 3) + 8);
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
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzC(zzatvVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzC(((Integer) list.get(i12)).intValue());
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
        if (list instanceof zzauu) {
            zzauu zzauuVar = (zzauu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzC(zzauuVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzC(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i11, Object obj, zzavt zzavtVar) {
        int i12 = i11 << 3;
        if (!(obj instanceof zzaul)) {
            return zzasx.zzB(i12) + zzasx.zzz((zzavf) obj, zzavtVar);
        }
        int zzB = zzasx.zzB(i12);
        int zza2 = ((zzaul) obj).zza();
        return zzB + zzasx.zzB(zza2) + zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            i11 = 0;
            while (i12 < size) {
                int zze = zzatvVar.zze(i12);
                i11 += zzasx.zzB((zze >> 31) ^ (zze + zze));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                int intValue = ((Integer) list.get(i12)).intValue();
                i11 += zzasx.zzB((intValue >> 31) ^ (intValue + intValue));
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
        if (list instanceof zzauu) {
            zzauu zzauuVar = (zzauu) list;
            i11 = 0;
            while (i12 < size) {
                long zze = zzauuVar.zze(i12);
                i11 += zzasx.zzC((zze >> 63) ^ (zze + zze));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                long longValue = ((Long) list.get(i12)).longValue();
                i11 += zzasx.zzC((longValue >> 63) ^ (longValue + longValue));
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
        if (list instanceof zzatv) {
            zzatv zzatvVar = (zzatv) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzB(zzatvVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzB(((Integer) list.get(i12)).intValue());
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
        if (list instanceof zzauu) {
            zzauu zzauuVar = (zzauu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzC(zzauuVar.zze(i12));
                i12++;
            }
        } else {
            i11 = 0;
            while (i12 < size) {
                i11 += zzasx.zzC(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static zzawn zzm() {
        return zzc;
    }

    public static zzawn zzn() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i11, List list, zzaty zzatyVar, Object obj2, zzawn zzawnVar) {
        if (zzatyVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                Integer num = (Integer) list.get(i13);
                int intValue = num.intValue();
                if (zzatyVar.zza(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, num);
                    }
                    i12++;
                } else {
                    obj2 = zzp(obj, i11, intValue, obj2, zzawnVar);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzatyVar.zza(intValue2)) {
                    obj2 = zzp(obj, i11, intValue2, obj2, zzawnVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzp(Object obj, int i11, int i12, Object obj2, zzawn zzawnVar) {
        if (obj2 == null) {
            obj2 = zzawnVar.zzc(obj);
        }
        zzawnVar.zzl(obj2, i11, i12);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(zzatg zzatgVar, Object obj, Object obj2) {
        zzatk zzb2 = zzatgVar.zzb(obj2);
        if (zzb2.zza.isEmpty()) {
            return;
        }
        zzatgVar.zzc(obj).zzh(zzb2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzr(zzawn zzawnVar, Object obj, Object obj2) {
        zzawnVar.zzo(obj, zzawnVar.zze(zzawnVar.zzd(obj), zzawnVar.zzd(obj2)));
    }

    public static void zzs(Class cls) {
        Class cls2;
        if (!zzatu.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzt(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzu(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzc(i11, list, z10);
    }

    public static void zzv(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzg(i11, list, z10);
    }

    public static void zzw(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzj(i11, list, z10);
    }

    public static void zzx(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzl(i11, list, z10);
    }

    public static void zzy(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzn(i11, list, z10);
    }

    public static void zzz(int i11, List list, zzasy zzasyVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzasyVar.zzp(i11, list, z10);
    }
}
