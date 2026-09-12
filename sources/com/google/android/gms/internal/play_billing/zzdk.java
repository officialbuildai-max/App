package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzdk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i11, zzdj zzdjVar) throws zzff {
        int zzh = zzh(bArr, i11, zzdjVar);
        int i12 = zzdjVar.zza;
        if (i12 < 0) {
            throw zzff.zzd();
        }
        if (i12 > bArr.length - zzh) {
            throw zzff.zzg();
        }
        if (i12 == 0) {
            zzdjVar.zzc = zzdw.zzb;
            return zzh;
        }
        zzdjVar.zzc = zzdw.zzl(bArr, zzh, i12);
        return zzh + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i11) {
        int i12 = bArr[i11] & 255;
        int i13 = bArr[i11 + 1] & 255;
        int i14 = bArr[i11 + 2] & 255;
        return ((bArr[i11 + 3] & 255) << 24) | (i13 << 8) | i12 | (i14 << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzgm zzgmVar, byte[] bArr, int i11, int i12, int i13, zzdj zzdjVar) throws IOException {
        Object zze = zzgmVar.zze();
        int zzl = zzl(zze, zzgmVar, bArr, i11, i12, i13, zzdjVar);
        zzgmVar.zzf(zze);
        zzdjVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzgm zzgmVar, byte[] bArr, int i11, int i12, zzdj zzdjVar) throws IOException {
        Object zze = zzgmVar.zze();
        int zzm = zzm(zze, zzgmVar, bArr, i11, i12, zzdjVar);
        zzgmVar.zzf(zze);
        zzdjVar.zzc = zze;
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzgm zzgmVar, int i11, byte[] bArr, int i12, int i13, zzfc zzfcVar, zzdj zzdjVar) throws IOException {
        int zzd = zzd(zzgmVar, bArr, i12, i13, zzdjVar);
        zzfcVar.add(zzdjVar.zzc);
        while (zzd < i13) {
            int zzh = zzh(bArr, zzd, zzdjVar);
            if (i11 != zzdjVar.zza) {
                break;
            }
            zzd = zzd(zzgmVar, bArr, zzh, i13, zzdjVar);
            zzfcVar.add(zzdjVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i11, zzfc zzfcVar, zzdj zzdjVar) throws IOException {
        zzey zzeyVar = (zzey) zzfcVar;
        int zzh = zzh(bArr, i11, zzdjVar);
        int i12 = zzdjVar.zza + zzh;
        while (zzh < i12) {
            zzh = zzh(bArr, zzh, zzdjVar);
            zzeyVar.zzf(zzdjVar.zza);
        }
        if (zzh == i12) {
            return zzh;
        }
        throw zzff.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i11, byte[] bArr, int i12, int i13, zzhe zzheVar, zzdj zzdjVar) throws zzff {
        if ((i11 >>> 3) == 0) {
            throw zzff.zzb();
        }
        int i14 = i11 & 7;
        if (i14 == 0) {
            int zzk = zzk(bArr, i12, zzdjVar);
            zzheVar.zzj(i11, Long.valueOf(zzdjVar.zzb));
            return zzk;
        }
        if (i14 == 1) {
            zzheVar.zzj(i11, Long.valueOf(zzn(bArr, i12)));
            return i12 + 8;
        }
        if (i14 == 2) {
            int zzh = zzh(bArr, i12, zzdjVar);
            int i15 = zzdjVar.zza;
            if (i15 < 0) {
                throw zzff.zzd();
            }
            if (i15 > bArr.length - zzh) {
                throw zzff.zzg();
            }
            if (i15 == 0) {
                zzheVar.zzj(i11, zzdw.zzb);
            } else {
                zzheVar.zzj(i11, zzdw.zzl(bArr, zzh, i15));
            }
            return zzh + i15;
        }
        if (i14 != 3) {
            if (i14 != 5) {
                throw zzff.zzb();
            }
            zzheVar.zzj(i11, Integer.valueOf(zzb(bArr, i12)));
            return i12 + 4;
        }
        int i16 = (i11 & (-8)) | 4;
        zzhe zzf = zzhe.zzf();
        int i17 = 0;
        while (true) {
            if (i12 >= i13) {
                break;
            }
            int zzh2 = zzh(bArr, i12, zzdjVar);
            int i18 = zzdjVar.zza;
            i17 = i18;
            if (i18 == i16) {
                i12 = zzh2;
                break;
            }
            int zzg = zzg(i17, bArr, zzh2, i13, zzf, zzdjVar);
            i17 = i18;
            i12 = zzg;
        }
        if (i12 > i13 || i17 != i16) {
            throw zzff.zze();
        }
        zzheVar.zzj(i11, zzf);
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i11, zzdj zzdjVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzi(b11, bArr, i12, zzdjVar);
        }
        zzdjVar.zza = b11;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i11, byte[] bArr, int i12, zzdj zzdjVar) {
        byte b11 = bArr[i12];
        int i13 = i12 + 1;
        int i14 = i11 & 127;
        if (b11 >= 0) {
            zzdjVar.zza = i14 | (b11 << 7);
            return i13;
        }
        int i15 = i14 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i12 + 2;
        byte b12 = bArr[i13];
        if (b12 >= 0) {
            zzdjVar.zza = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << 14);
        int i18 = i12 + 3;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzdjVar.zza = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << 21);
        int i20 = i12 + 4;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzdjVar.zza = i19 | (b14 << 28);
            return i20;
        }
        int i21 = i19 | ((b14 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i22 = i20 + 1;
            if (bArr[i20] >= 0) {
                zzdjVar.zza = i21;
                return i22;
            }
            i20 = i22;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i11, byte[] bArr, int i12, int i13, zzfc zzfcVar, zzdj zzdjVar) {
        zzey zzeyVar = (zzey) zzfcVar;
        int zzh = zzh(bArr, i12, zzdjVar);
        zzeyVar.zzf(zzdjVar.zza);
        while (zzh < i13) {
            int zzh2 = zzh(bArr, zzh, zzdjVar);
            if (i11 != zzdjVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzdjVar);
            zzeyVar.zzf(zzdjVar.zza);
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(byte[] bArr, int i11, zzdj zzdjVar) {
        long j11 = bArr[i11];
        int i12 = i11 + 1;
        if (j11 >= 0) {
            zzdjVar.zzb = j11;
            return i12;
        }
        int i13 = i11 + 2;
        byte b11 = bArr[i12];
        long j12 = (j11 & 127) | ((b11 & Byte.MAX_VALUE) << 7);
        int i14 = 7;
        while (b11 < 0) {
            int i15 = i13 + 1;
            i14 += 7;
            j12 |= (r10 & Byte.MAX_VALUE) << i14;
            b11 = bArr[i13];
            i13 = i15;
        }
        zzdjVar.zzb = j12;
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(Object obj, zzgm zzgmVar, byte[] bArr, int i11, int i12, int i13, zzdj zzdjVar) throws IOException {
        int zzc = ((zzgf) zzgmVar).zzc(obj, bArr, i11, i12, i13, zzdjVar);
        zzdjVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(Object obj, zzgm zzgmVar, byte[] bArr, int i11, int i12, zzdj zzdjVar) throws IOException {
        int i13 = i11 + 1;
        int i14 = bArr[i11];
        if (i14 < 0) {
            i13 = zzi(i14, bArr, i13, zzdjVar);
            i14 = zzdjVar.zza;
        }
        int i15 = i13;
        if (i14 < 0 || i14 > i12 - i15) {
            throw zzff.zzg();
        }
        int i16 = i14 + i15;
        zzgmVar.zzh(obj, bArr, i15, i16, zzdjVar);
        zzdjVar.zzc = obj;
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i11) {
        return (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48) | ((bArr[i11 + 7] & 255) << 56);
    }
}
