package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
final class zzbtu {
    int zzb;
    private final zzbwd zzf;
    private final List zze = new ArrayList();
    zzbtt[] zza = new zzbtt[8];
    int zzc = 0;
    int zzd = 0;
    private int zzg = 4096;
    private int zzh = 4096;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbtu(int i11, int i12, zzbws zzbwsVar) {
        this.zzb = r1.length - 1;
        this.zzf = zzbwh.zzb(zzbwsVar);
    }

    private final int zzf(int i11) {
        return this.zzb + 1 + i11;
    }

    private final int zzg(int i11) {
        int i12;
        int i13 = 0;
        if (i11 > 0) {
            int length = this.zza.length;
            while (true) {
                length--;
                i12 = this.zzb;
                if (length < i12 || i11 <= 0) {
                    break;
                }
                int i14 = this.zza[length].zzj;
                i11 -= i14;
                this.zzd -= i14;
                this.zzc--;
                i13++;
            }
            zzbtt[] zzbttVarArr = this.zza;
            int i15 = i12 + 1;
            System.arraycopy(zzbttVarArr, i15, zzbttVarArr, i15 + i13, this.zzc);
            this.zzb += i13;
        }
        return i13;
    }

    private final int zzh() throws IOException {
        return this.zzf.zzc() & 255;
    }

    private final zzbwf zzi(int i11) throws IOException {
        zzbtt[] zzbttVarArr;
        zzbtt[] zzbttVarArr2;
        if (zzm(i11)) {
            zzbttVarArr2 = zzbtw.zzb;
            return zzbttVarArr2[i11].zzh;
        }
        zzbttVarArr = zzbtw.zzb;
        int length = zzbttVarArr.length;
        int zzf = zzf(i11 - 61);
        if (zzf >= 0) {
            zzbtt[] zzbttVarArr3 = this.zza;
            if (zzf < zzbttVarArr3.length) {
                return zzbttVarArr3[zzf].zzh;
            }
        }
        throw new IOException("Header index too large " + (i11 + 1));
    }

    private final void zzj() {
        int i11 = this.zzh;
        int i12 = this.zzd;
        if (i11 < i12) {
            if (i11 == 0) {
                zzk();
            } else {
                zzg(i12 - i11);
            }
        }
    }

    private final void zzk() {
        Arrays.fill(this.zza, (Object) null);
        this.zzb = this.zza.length - 1;
        this.zzc = 0;
        this.zzd = 0;
    }

    private final void zzl(int i11, zzbtt zzbttVar) {
        this.zze.add(zzbttVar);
        int i12 = zzbttVar.zzj;
        int i13 = this.zzh;
        if (i12 > i13) {
            zzk();
            return;
        }
        zzg((this.zzd + i12) - i13);
        int i14 = this.zzc + 1;
        zzbtt[] zzbttVarArr = this.zza;
        int length = zzbttVarArr.length;
        if (i14 > length) {
            zzbtt[] zzbttVarArr2 = new zzbtt[length + length];
            System.arraycopy(zzbttVarArr, 0, zzbttVarArr2, length, length);
            this.zzb = this.zza.length - 1;
            this.zza = zzbttVarArr2;
        }
        int i15 = this.zzb;
        this.zzb = i15 - 1;
        this.zza[i15] = zzbttVar;
        this.zzc++;
        this.zzd += i12;
    }

    private static final boolean zzm(int i11) {
        zzbtt[] zzbttVarArr;
        if (i11 < 0) {
            return false;
        }
        zzbttVarArr = zzbtw.zzb;
        int length = zzbttVarArr.length;
        return i11 <= 60;
    }

    final int zza(int i11, int i12) throws IOException {
        int i13 = i11 & i12;
        if (i13 < i12) {
            return i13;
        }
        int i14 = 0;
        while (true) {
            int zzh = zzh();
            if ((zzh & 128) == 0) {
                return i12 + (zzh << i14);
            }
            i12 += (zzh & 127) << i14;
            i14 += 7;
        }
    }

    public final List zzb() {
        ArrayList arrayList = new ArrayList(this.zze);
        this.zze.clear();
        return arrayList;
    }

    final zzbwf zzc() throws IOException {
        int zzh = zzh();
        int i11 = zzh & 128;
        long zza = zza(zzh, 127);
        if (i11 != 128) {
            return this.zzf.zzy(zza);
        }
        zzbwd zzbwdVar = this.zzf;
        zzbud zza2 = zzbud.zza();
        zzbwl zzbwlVar = (zzbwl) zzbwdVar;
        zzbwlVar.zzD(zza);
        byte[] zzb = zza2.zzb(zzbwlVar.zzb.zzH(zza));
        zzbwe zzbweVar = zzbwf.zza;
        return zzbwe.zzb(zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i11) {
        this.zzg = i11;
        this.zzh = i11;
        zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e2, code lost:
    
        throw new java.io.IOException("Invalid dynamic table size update " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zze() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbtu.zze():void");
    }
}
