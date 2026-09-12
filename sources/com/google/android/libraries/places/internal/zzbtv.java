package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzbtv {
    zzbtt[] zza = new zzbtt[8];
    int zzb;
    private final zzbwb zzc;
    private int zzd;
    private int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbtv(int i11, boolean z10, zzbwb zzbwbVar) {
        this.zzd = r1.length - 1;
        this.zzc = zzbwbVar;
    }

    private final void zzd(zzbtt zzbttVar) {
        int i11;
        int i12 = zzbttVar.zzj;
        if (i12 > 4096) {
            Arrays.fill(this.zza, (Object) null);
            this.zzd = this.zza.length - 1;
            this.zzb = 0;
            this.zze = 0;
            return;
        }
        int i13 = (this.zze + i12) - 4096;
        if (i13 > 0) {
            int length = this.zza.length - 1;
            int i14 = 0;
            while (true) {
                i11 = this.zzd;
                if (length < i11 || i13 <= 0) {
                    break;
                }
                int i15 = this.zza[length].zzj;
                i13 -= i15;
                this.zze -= i15;
                this.zzb--;
                i14++;
                length--;
            }
            zzbtt[] zzbttVarArr = this.zza;
            int i16 = i11 + 1;
            System.arraycopy(zzbttVarArr, i16, zzbttVarArr, i16 + i14, this.zzb);
            this.zzd += i14;
        }
        int i17 = this.zzb + 1;
        zzbtt[] zzbttVarArr2 = this.zza;
        int length2 = zzbttVarArr2.length;
        if (i17 > length2) {
            zzbtt[] zzbttVarArr3 = new zzbtt[length2 + length2];
            System.arraycopy(zzbttVarArr2, 0, zzbttVarArr3, length2, length2);
            this.zzd = this.zza.length - 1;
            this.zza = zzbttVarArr3;
        }
        int i18 = this.zzd;
        this.zzd = i18 - 1;
        this.zza[i18] = zzbttVar;
        this.zzb++;
        this.zze += i12;
    }

    final void zza(zzbwf zzbwfVar) throws IOException {
        zzc(zzbwfVar.zzc(), 127, 0);
        this.zzc.zzk(zzbwfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(List list) throws IOException {
        Map map;
        int i11;
        int i12;
        zzbwf zzbwfVar;
        zzbtt[] zzbttVarArr;
        zzbtt[] zzbttVarArr2;
        zzbtt[] zzbttVarArr3;
        zzbtt[] zzbttVarArr4;
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            zzbtt zzbttVar = (zzbtt) list.get(i13);
            zzbwf zzg = zzbttVar.zzh.zzg();
            zzbwf zzbwfVar2 = zzbttVar.zzi;
            map = zzbtw.zzc;
            Integer num = (Integer) map.get(zzg);
            if (num != null) {
                int intValue = num.intValue();
                i12 = intValue + 1;
                if (i12 >= 2 && i12 <= 7) {
                    zzbttVarArr3 = zzbtw.zzb;
                    if (zzbttVarArr3[intValue].zzi.equals(zzbwfVar2)) {
                        i11 = i12;
                    } else {
                        zzbttVarArr4 = zzbtw.zzb;
                        if (zzbttVarArr4[i12].zzi.equals(zzbwfVar2)) {
                            i12 = intValue + 2;
                            i11 = i12;
                        }
                    }
                }
                i11 = i12;
                i12 = -1;
            } else {
                i11 = -1;
                i12 = -1;
            }
            if (i12 == -1) {
                int i14 = this.zzd;
                while (true) {
                    i14++;
                    zzbtt[] zzbttVarArr5 = this.zza;
                    if (i14 >= zzbttVarArr5.length) {
                        i12 = -1;
                        break;
                    }
                    if (zzbttVarArr5[i14].zzh.equals(zzg)) {
                        if (this.zza[i14].zzi.equals(zzbwfVar2)) {
                            int i15 = i14 - this.zzd;
                            zzbttVarArr = zzbtw.zzb;
                            int length = zzbttVarArr.length;
                            i12 = i15 + 61;
                            break;
                        }
                        if (i11 == -1) {
                            int i16 = i14 - this.zzd;
                            zzbttVarArr2 = zzbtw.zzb;
                            int length2 = zzbttVarArr2.length;
                            i11 = i16 + 61;
                        }
                    }
                }
            }
            if (i12 != -1) {
                zzc(i12, 127, 128);
            } else if (i11 == -1) {
                this.zzc.zzm(64);
                zza(zzg);
                zza(zzbwfVar2);
                zzd(zzbttVar);
            } else {
                zzbwfVar = zzbtw.zza;
                if (!zzg.zzm(zzbwfVar) || zzbtt.zze.equals(zzg)) {
                    zzc(i11, 63, 64);
                    zza(zzbwfVar2);
                    zzd(zzbttVar);
                } else {
                    zzc(i11, 15, 0);
                    zza(zzbwfVar2);
                }
            }
        }
    }

    final void zzc(int i11, int i12, int i13) throws IOException {
        if (i11 < i12) {
            this.zzc.zzm(i11 | i13);
            return;
        }
        this.zzc.zzm(i13 | i12);
        int i14 = i11 - i12;
        while (i14 >= 128) {
            this.zzc.zzm(128 | (i14 & 127));
            i14 >>>= 7;
        }
        this.zzc.zzm(i14);
    }
}
