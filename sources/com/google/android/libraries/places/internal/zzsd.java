package com.google.android.libraries.places.internal;

import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzsd {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;
    private final boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzsd(java.lang.String r10, char[] r11) {
        /*
            r9 = this;
            r0 = 128(0x80, float:1.794E-43)
            byte[] r1 = new byte[r0]
            r2 = -1
            java.util.Arrays.fill(r1, r2)
            r3 = 0
            r4 = r3
        La:
            int r5 = r11.length
            if (r4 >= r5) goto L2b
            char r5 = r11[r4]
            r6 = 1
            if (r5 >= r0) goto L14
            r7 = r6
            goto L15
        L14:
            r7 = r3
        L15:
            java.lang.String r8 = "Non-ASCII character: %s"
            com.google.android.libraries.places.internal.zzmt.zzg(r7, r8, r5)
            r7 = r1[r5]
            if (r7 != r2) goto L1f
            goto L20
        L1f:
            r6 = r3
        L20:
            java.lang.String r7 = "Duplicate character: %s"
            com.google.android.libraries.places.internal.zzmt.zzg(r6, r7, r5)
            byte r6 = (byte) r4
            r1[r5] = r6
            int r4 = r4 + 1
            goto La
        L2b:
            r9.<init>(r10, r11, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzsd.<init>(java.lang.String, char[]):void");
    }

    private zzsd(String str, char[] cArr, byte[] bArr, boolean z10) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int zzb = zzajl.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = zzb;
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(zzb);
            int i11 = 1 << (3 - numberOfTrailingZeros);
            this.zzc = i11;
            this.zzd = zzb >> numberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i11];
            for (int i12 = 0; i12 < this.zzd; i12++) {
                zArr[zzajl.zza(i12 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = false;
        } catch (ArithmeticException e11) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ char[] zze(zzsd zzsdVar) {
        return zzsdVar.zzf;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzsd) {
            zzsd zzsdVar = (zzsd) obj;
            boolean z10 = zzsdVar.zzi;
            if (Arrays.equals(this.zzf, zzsdVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + 1237;
    }

    public final String toString() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char zza(int i11) {
        return this.zzf[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(char c11) throws zzsg {
        if (c11 > 127) {
            throw new zzsg("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c11))));
        }
        byte b11 = this.zzg[c11];
        if (b11 != -1) {
            return b11;
        }
        if (c11 <= ' ' || c11 == 127) {
            throw new zzsg("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c11))));
        }
        throw new zzsg("Unrecognized character: " + c11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(int i11) {
        return this.zzh[i11 % this.zzc];
    }

    public final boolean zzd(char c11) {
        return this.zzg[61] != -1;
    }
}
