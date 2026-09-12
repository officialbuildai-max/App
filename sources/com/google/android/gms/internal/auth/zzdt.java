package com.google.android.gms.internal.auth;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzdt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i11, zzds zzdsVar) throws zzfa {
        int zzj = zzj(bArr, i11, zzdsVar);
        int i12 = zzdsVar.zza;
        if (i12 < 0) {
            throw zzfa.zzc();
        }
        if (i12 > bArr.length - zzj) {
            throw zzfa.zzf();
        }
        if (i12 == 0) {
            zzdsVar.zzc = zzee.zzb;
            return zzj;
        }
        zzdsVar.zzc = zzee.zzk(bArr, zzj, i12);
        return zzj + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzgh zzghVar, byte[] bArr, int i11, int i12, int i13, zzds zzdsVar) throws IOException {
        zzfz zzfzVar = (zzfz) zzghVar;
        Object zzd = zzfzVar.zzd();
        int zzb = zzfzVar.zzb(zzd, bArr, i11, i12, i13, zzdsVar);
        zzfzVar.zze(zzd);
        zzdsVar.zzc = zzd;
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzgh zzghVar, byte[] bArr, int i11, int i12, zzds zzdsVar) throws IOException {
        int i13 = i11 + 1;
        int i14 = bArr[i11];
        if (i14 < 0) {
            i13 = zzk(i14, bArr, i13, zzdsVar);
            i14 = zzdsVar.zza;
        }
        int i15 = i13;
        if (i14 < 0 || i14 > i12 - i15) {
            throw zzfa.zzf();
        }
        Object zzd = zzghVar.zzd();
        int i16 = i14 + i15;
        zzghVar.zzg(zzd, bArr, i15, i16, zzdsVar);
        zzghVar.zze(zzd);
        zzdsVar.zzc = zzd;
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzgh zzghVar, int i11, byte[] bArr, int i12, int i13, zzey zzeyVar, zzds zzdsVar) throws IOException {
        int zzd = zzd(zzghVar, bArr, i12, i13, zzdsVar);
        zzeyVar.add(zzdsVar.zzc);
        while (zzd < i13) {
            int zzj = zzj(bArr, zzd, zzdsVar);
            if (i11 != zzdsVar.zza) {
                break;
            }
            zzd = zzd(zzghVar, bArr, zzj, i13, zzdsVar);
            zzeyVar.add(zzdsVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i11, zzey zzeyVar, zzds zzdsVar) throws IOException {
        zzev zzevVar = (zzev) zzeyVar;
        int zzj = zzj(bArr, i11, zzdsVar);
        int i12 = zzdsVar.zza + zzj;
        while (zzj < i12) {
            zzj = zzj(bArr, zzj, zzdsVar);
            zzevVar.zze(zzdsVar.zza);
        }
        if (zzj == i12) {
            return zzj;
        }
        throw zzfa.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i11, zzds zzdsVar) throws zzfa {
        int zzj = zzj(bArr, i11, zzdsVar);
        int i12 = zzdsVar.zza;
        if (i12 < 0) {
            throw zzfa.zzc();
        }
        if (i12 == 0) {
            zzdsVar.zzc = "";
            return zzj;
        }
        zzdsVar.zzc = new String(bArr, zzj, i12, zzez.zzb);
        return zzj + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i11, zzds zzdsVar) throws zzfa {
        int zzj = zzj(bArr, i11, zzdsVar);
        int i12 = zzdsVar.zza;
        if (i12 < 0) {
            throw zzfa.zzc();
        }
        if (i12 == 0) {
            zzdsVar.zzc = "";
            return zzj;
        }
        zzdsVar.zzc = zzhm.zzb(bArr, zzj, i12);
        return zzj + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i11, byte[] bArr, int i12, int i13, zzgz zzgzVar, zzds zzdsVar) throws zzfa {
        if ((i11 >>> 3) == 0) {
            throw zzfa.zza();
        }
        int i14 = i11 & 7;
        if (i14 == 0) {
            int zzm = zzm(bArr, i12, zzdsVar);
            zzgzVar.zzf(i11, Long.valueOf(zzdsVar.zzb));
            return zzm;
        }
        if (i14 == 1) {
            zzgzVar.zzf(i11, Long.valueOf(zzn(bArr, i12)));
            return i12 + 8;
        }
        if (i14 == 2) {
            int zzj = zzj(bArr, i12, zzdsVar);
            int i15 = zzdsVar.zza;
            if (i15 < 0) {
                throw zzfa.zzc();
            }
            if (i15 > bArr.length - zzj) {
                throw zzfa.zzf();
            }
            if (i15 == 0) {
                zzgzVar.zzf(i11, zzee.zzb);
            } else {
                zzgzVar.zzf(i11, zzee.zzk(bArr, zzj, i15));
            }
            return zzj + i15;
        }
        if (i14 != 3) {
            if (i14 != 5) {
                throw zzfa.zza();
            }
            zzgzVar.zzf(i11, Integer.valueOf(zzb(bArr, i12)));
            return i12 + 4;
        }
        int i16 = (i11 & (-8)) | 4;
        zzgz zzc = zzgz.zzc();
        int i17 = 0;
        while (true) {
            if (i12 >= i13) {
                break;
            }
            int zzj2 = zzj(bArr, i12, zzdsVar);
            int i18 = zzdsVar.zza;
            if (i18 == i16) {
                i17 = i18;
                i12 = zzj2;
                break;
            }
            i17 = i18;
            i12 = zzi(i18, bArr, zzj2, i13, zzc, zzdsVar);
        }
        if (i12 > i13 || i17 != i16) {
            throw zzfa.zzd();
        }
        zzgzVar.zzf(i11, zzc);
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i11, zzds zzdsVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzk(b11, bArr, i12, zzdsVar);
        }
        zzdsVar.zza = b11;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i11, byte[] bArr, int i12, zzds zzdsVar) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzdsVar.zza = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i12 + 2;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            zzdsVar.zza = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << 14);
        int i18 = i12 + 3;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzdsVar.zza = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << 21);
        int i20 = i12 + 4;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzdsVar.zza = i19 | (b14 << 28);
            return i20;
        }
        int i21 = i19 | ((b14 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i22 = i20 + 1;
            if (bArr[i20] >= 0) {
                zzdsVar.zza = i21;
                return i22;
            }
            i20 = i22;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i11, byte[] bArr, int i12, int i13, zzey zzeyVar, zzds zzdsVar) {
        zzev zzevVar = (zzev) zzeyVar;
        int zzj = zzj(bArr, i12, zzdsVar);
        zzevVar.zze(zzdsVar.zza);
        while (zzj < i13) {
            int zzj2 = zzj(bArr, zzj, zzdsVar);
            if (i11 != zzdsVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzdsVar);
            zzevVar.zze(zzdsVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i11, zzds zzdsVar) {
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        if (j11 >= 0) {
            zzdsVar.zzb = j11;
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
        zzdsVar.zzb = j12;
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i11) {
        return ((bArr[i11 + 7] & 255) << 56) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48);
    }
}
