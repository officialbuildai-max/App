package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzmj {
    private static final zzmj zza = new zzmj(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmj() {
        this(0, new int[8], new Object[8], true);
    }

    private zzmj(int i11, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmj zza(zzmj zzmjVar, zzmj zzmjVar2) {
        int i11 = zzmjVar.zzb + zzmjVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzmjVar.zzc, i11);
        System.arraycopy(zzmjVar2.zzc, 0, copyOf, zzmjVar.zzb, zzmjVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmjVar.zzd, i11);
        System.arraycopy(zzmjVar2.zzd, 0, copyOf2, zzmjVar.zzb, zzmjVar2.zzb);
        return new zzmj(i11, copyOf, copyOf2, true);
    }

    private final void zza(int i11) {
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

    private static void zza(int i11, Object obj, zznb zznbVar) throws IOException {
        int i12 = i11 >>> 3;
        int i13 = i11 & 7;
        if (i13 == 0) {
            zznbVar.zzb(i12, ((Long) obj).longValue());
            return;
        }
        if (i13 == 1) {
            zznbVar.zza(i12, ((Long) obj).longValue());
            return;
        }
        if (i13 == 2) {
            zznbVar.zza(i12, (zzik) obj);
            return;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw new RuntimeException(zzkb.zza());
            }
            zznbVar.zzb(i12, ((Integer) obj).intValue());
        } else if (zznbVar.zza() == 1) {
            zznbVar.zzb(i12);
            ((zzmj) obj).zzb(zznbVar);
            zznbVar.zza(i12);
        } else {
            zznbVar.zza(i12);
            ((zzmj) obj).zzb(zznbVar);
            zznbVar.zzb(i12);
        }
    }

    public static zzmj zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmj zzd() {
        return new zzmj();
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmj)) {
            return false;
        }
        zzmj zzmjVar = (zzmj) obj;
        int i11 = this.zzb;
        if (i11 == zzmjVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmjVar.zzc;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmjVar.zzd;
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
        int i12 = (i11 + 527) * 31;
        int[] iArr = this.zzc;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = (i12 + i14) * 31;
        Object[] objArr = this.zzd;
        int i17 = this.zzb;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final int zza() {
        int zzg;
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzb; i13++) {
            int i14 = this.zzc[i13];
            int i15 = i14 >>> 3;
            int i16 = i14 & 7;
            if (i16 == 0) {
                zzg = zzjc.zzg(i15, ((Long) this.zzd[i13]).longValue());
            } else if (i16 == 1) {
                zzg = zzjc.zzc(i15, ((Long) this.zzd[i13]).longValue());
            } else if (i16 == 2) {
                zzg = zzjc.zzc(i15, (zzik) this.zzd[i13]);
            } else if (i16 == 3) {
                zzg = (zzjc.zzi(i15) << 1) + ((zzmj) this.zzd[i13]).zza();
            } else {
                if (i16 != 5) {
                    throw new IllegalStateException(zzkb.zza());
                }
                zzg = zzjc.zzf(i15, ((Integer) this.zzd[i13]).intValue());
            }
            i12 += zzg;
        }
        this.zze = i12;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzmj zza(zzmj zzmjVar) {
        if (zzmjVar.equals(zza)) {
            return this;
        }
        zzf();
        int i11 = this.zzb + zzmjVar.zzb;
        zza(i11);
        System.arraycopy(zzmjVar.zzc, 0, this.zzc, this.zzb, zzmjVar.zzb);
        System.arraycopy(zzmjVar.zzd, 0, this.zzd, this.zzb, zzmjVar.zzb);
        this.zzb = i11;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i11, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i12 = this.zzb;
        iArr[i12] = i11;
        this.zzd[i12] = obj;
        this.zzb = i12 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zznb zznbVar) throws IOException {
        if (zznbVar.zza() == 2) {
            for (int i11 = this.zzb - 1; i11 >= 0; i11--) {
                zznbVar.zza(this.zzc[i11] >>> 3, this.zzd[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.zzb; i12++) {
            zznbVar.zza(this.zzc[i12] >>> 3, this.zzd[i12]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.zzb; i12++) {
            zzld.zza(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    public final int zzb() {
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzb; i13++) {
            i12 += zzjc.zzd(this.zzc[i13] >>> 3, (zzik) this.zzd[i13]);
        }
        this.zze = i12;
        return i12;
    }

    public final void zzb(zznb zznbVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zznbVar.zza() == 1) {
            for (int i11 = 0; i11 < this.zzb; i11++) {
                zza(this.zzc[i11], this.zzd[i11], zznbVar);
            }
            return;
        }
        for (int i12 = this.zzb - 1; i12 >= 0; i12--) {
            zza(this.zzc[i12], this.zzd[i12], zznbVar);
        }
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }
}
