package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzawo {
    private static final zzawo zza = new zzawo(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzawo() {
        this(0, new int[8], new Object[8], true);
    }

    private zzawo(int i11, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzawo zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzawo zze(zzawo zzawoVar, zzawo zzawoVar2) {
        int i11 = zzawoVar.zzb + zzawoVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzawoVar.zzc, i11);
        System.arraycopy(zzawoVar2.zzc, 0, copyOf, zzawoVar.zzb, zzawoVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzawoVar.zzd, i11);
        System.arraycopy(zzawoVar2.zzd, 0, copyOf2, zzawoVar.zzb, zzawoVar2.zzb);
        return new zzawo(i11, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzawo zzf() {
        return new zzawo(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i11) {
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
        if (obj == null || !(obj instanceof zzawo)) {
            return false;
        }
        zzawo zzawoVar = (zzawo) obj;
        int i11 = this.zzb;
        if (i11 == zzawoVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzawoVar.zzc;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzawoVar.zzd;
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
        int zzB;
        int zzC;
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
                    i11 = zzasx.zzB(i16 << 3) + 8;
                } else if (i17 == 2) {
                    int i18 = i16 << 3;
                    zzask zzaskVar = (zzask) this.zzd[i14];
                    int zzB2 = zzasx.zzB(i18);
                    int zzd = zzaskVar.zzd();
                    i11 = zzB2 + zzasx.zzB(zzd) + zzd;
                } else if (i17 == 3) {
                    int zzB3 = zzasx.zzB(i16 << 3);
                    zzB = zzB3 + zzB3;
                    zzC = ((zzawo) this.zzd[i14]).zza();
                } else {
                    if (i17 != 5) {
                        throw new IllegalStateException(zzauf.zza());
                    }
                    ((Integer) this.zzd[i14]).intValue();
                    i11 = zzasx.zzB(i16 << 3) + 4;
                }
                i13 += i11;
            } else {
                int i19 = i16 << 3;
                long longValue = ((Long) this.zzd[i14]).longValue();
                zzB = zzasx.zzB(i19);
                zzC = zzasx.zzC(longValue);
            }
            i11 = zzB + zzC;
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
            zzask zzaskVar = (zzask) this.zzd[i13];
            int zzB = zzasx.zzB(8);
            int zzB2 = zzasx.zzB(16) + zzasx.zzB(i14);
            int zzB3 = zzasx.zzB(24);
            int zzd = zzaskVar.zzd();
            i12 += zzB + zzB + zzB2 + zzB3 + zzasx.zzB(zzd) + zzd;
        }
        this.zze = i12;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzawo zzd(zzawo zzawoVar) {
        if (zzawoVar.equals(zza)) {
            return this;
        }
        zzg();
        int i11 = this.zzb + zzawoVar.zzb;
        zzm(i11);
        System.arraycopy(zzawoVar.zzc, 0, this.zzc, this.zzb, zzawoVar.zzb);
        System.arraycopy(zzawoVar.zzd, 0, this.zzd, this.zzb, zzawoVar.zzb);
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
            zzavh.zzb(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i11, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i12 = this.zzb;
        iArr[i12] = i11;
        this.zzd[i12] = obj;
        this.zzb = i12 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzk(zzasy zzasyVar) throws IOException {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzasyVar.zzw(this.zzc[i11] >>> 3, this.zzd[i11]);
        }
    }

    public final void zzl(zzasy zzasyVar) throws IOException {
        if (this.zzb != 0) {
            for (int i11 = 0; i11 < this.zzb; i11++) {
                int i12 = this.zzc[i11];
                Object obj = this.zzd[i11];
                int i13 = i12 & 7;
                int i14 = i12 >>> 3;
                if (i13 == 0) {
                    zzasyVar.zzt(i14, ((Long) obj).longValue());
                } else if (i13 == 1) {
                    zzasyVar.zzm(i14, ((Long) obj).longValue());
                } else if (i13 == 2) {
                    zzasyVar.zzd(i14, (zzask) obj);
                } else if (i13 == 3) {
                    zzasyVar.zzF(i14);
                    ((zzawo) obj).zzl(zzasyVar);
                    zzasyVar.zzh(i14);
                } else {
                    if (i13 != 5) {
                        throw new RuntimeException(zzauf.zza());
                    }
                    zzasyVar.zzk(i14, ((Integer) obj).intValue());
                }
            }
        }
    }
}
