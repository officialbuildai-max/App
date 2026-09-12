package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhe {
    private static final zzhe zza = new zzhe(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhe(int i11, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzhe zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhe zze(zzhe zzheVar, zzhe zzheVar2) {
        int i11 = zzheVar.zzb + zzheVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzheVar.zzc, i11);
        System.arraycopy(zzheVar2.zzc, 0, copyOf, zzheVar.zzb, zzheVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzheVar.zzd, i11);
        System.arraycopy(zzheVar2.zzd, 0, copyOf2, zzheVar.zzb, zzheVar2.zzb);
        return new zzhe(i11, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhe zzf() {
        return new zzhe(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i11) {
        int[] iArr = this.zzc;
        if (i11 > iArr.length) {
            int i12 = this.zzb;
            int i13 = i12 + (i12 / 2);
            if (i13 >= i11) {
                i11 = i13;
            }
            if (i11 < 8) {
                i11 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i11);
            this.zzd = Arrays.copyOf(this.zzd, i11);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhe)) {
            return false;
        }
        zzhe zzheVar = (zzhe) obj;
        int i11 = this.zzb;
        if (i11 == zzheVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzheVar.zzc;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzheVar.zzd;
                    int i13 = this.zzb;
                    for (int i14 = 0; i14 < i13; i14++) {
                        if (objArr[i14].equals(objArr2[i14])) {
                        }
                    }
                    return true;
                }
                if (iArr[i12] != iArr2[i12]) {
                    break;
                }
                i12++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzb;
        int i12 = i11 + 527;
        int[] iArr = this.zzc;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = ((i12 * 31) + i14) * 31;
        Object[] objArr = this.zzd;
        int i17 = this.zzb;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final int zza() {
        int zzy;
        int zzx;
        int i11;
        int i12 = this.zze;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.zzb; i14++) {
            int i15 = this.zzc[i14];
            int i16 = i15 >>> 3;
            int i17 = i15 & 7;
            if (i17 != 0) {
                if (i17 == 1) {
                    ((Long) this.zzd[i14]).longValue();
                    i11 = zzee.zzx(i16 << 3) + 8;
                } else if (i17 == 2) {
                    int i18 = i16 << 3;
                    zzdw zzdwVar = (zzdw) this.zzd[i14];
                    int i19 = zzee.zzb;
                    int zzd = zzdwVar.zzd();
                    i11 = zzee.zzx(i18) + zzee.zzx(zzd) + zzd;
                } else if (i17 == 3) {
                    int i20 = i16 << 3;
                    int i21 = zzee.zzb;
                    zzy = ((zzhe) this.zzd[i14]).zza();
                    int zzx2 = zzee.zzx(i20);
                    zzx = zzx2 + zzx2;
                } else {
                    if (i17 != 5) {
                        throw new IllegalStateException(zzff.zza());
                    }
                    ((Integer) this.zzd[i14]).intValue();
                    i11 = zzee.zzx(i16 << 3) + 4;
                }
                i13 += i11;
            } else {
                int i22 = i16 << 3;
                zzy = zzee.zzy(((Long) this.zzd[i14]).longValue());
                zzx = zzee.zzx(i22);
            }
            i11 = zzx + zzy;
            i13 += i11;
        }
        this.zze = i13;
        return i13;
    }

    public final int zzb() {
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzb; i13++) {
            int i14 = this.zzc[i13] >>> 3;
            zzdw zzdwVar = (zzdw) this.zzd[i13];
            int i15 = zzee.zzb;
            int zzd = zzdwVar.zzd();
            int zzx = zzee.zzx(zzd) + zzd;
            int zzx2 = zzee.zzx(16);
            int zzx3 = zzee.zzx(i14);
            int zzx4 = zzee.zzx(8);
            i12 += zzx4 + zzx4 + zzx2 + zzx3 + zzee.zzx(24) + zzx;
        }
        this.zze = i12;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzhe zzd(zzhe zzheVar) {
        if (zzheVar.equals(zza)) {
            return this;
        }
        zzg();
        int i11 = this.zzb + zzheVar.zzb;
        zzl(i11);
        System.arraycopy(zzheVar.zzc, 0, this.zzc, this.zzb, zzheVar.zzb);
        System.arraycopy(zzheVar.zzd, 0, this.zzd, this.zzb, zzheVar.zzb);
        this.zzb = i11;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.zzb; i12++) {
            zzge.zzb(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i11, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i12 = this.zzb;
        iArr[i12] = i11;
        this.zzd[i12] = obj;
        this.zzb = i12 + 1;
    }

    public final void zzk(zzhv zzhvVar) throws IOException {
        if (this.zzb != 0) {
            for (int i11 = 0; i11 < this.zzb; i11++) {
                int i12 = this.zzc[i11];
                Object obj = this.zzd[i11];
                int i13 = i12 & 7;
                int i14 = i12 >>> 3;
                if (i13 == 0) {
                    zzhvVar.zzt(i14, ((Long) obj).longValue());
                } else if (i13 == 1) {
                    zzhvVar.zzm(i14, ((Long) obj).longValue());
                } else if (i13 == 2) {
                    zzhvVar.zzd(i14, (zzdw) obj);
                } else if (i13 == 3) {
                    zzhvVar.zzE(i14);
                    ((zzhe) obj).zzk(zzhvVar);
                    zzhvVar.zzh(i14);
                } else {
                    if (i13 != 5) {
                        throw new RuntimeException(zzff.zza());
                    }
                    zzhvVar.zzk(i14, ((Integer) obj).intValue());
                }
            }
        }
    }
}
