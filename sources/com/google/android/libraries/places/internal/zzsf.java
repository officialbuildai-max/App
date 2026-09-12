package com.google.android.libraries.places.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
final class zzsf extends zzsh {
    private zzsf(zzsd zzsdVar, Character ch2) {
        super(zzsdVar, ch2);
        zzmt.zze(zzsd.zze(zzsdVar).length == 64);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsf(String str, String str2, Character ch2) {
        this(new zzsd(str, str2.toCharArray()), ch2);
    }

    @Override // com.google.android.libraries.places.internal.zzsh, com.google.android.libraries.places.internal.zzsi
    final int zza(byte[] bArr, CharSequence charSequence) throws zzsg {
        CharSequence zzg = zzg(charSequence);
        if (!this.zzb.zzc(zzg.length())) {
            throw new zzsg("Invalid input length " + zzg.length());
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < zzg.length()) {
            int i13 = i12 + 1;
            int zzb = (this.zzb.zzb(zzg.charAt(i11)) << 18) | (this.zzb.zzb(zzg.charAt(i11 + 1)) << 12);
            bArr[i12] = (byte) (zzb >>> 16);
            int i14 = i11 + 2;
            if (i14 < zzg.length()) {
                int i15 = i11 + 3;
                int zzb2 = zzb | (this.zzb.zzb(zzg.charAt(i14)) << 6);
                int i16 = i12 + 2;
                bArr[i13] = (byte) ((zzb2 >>> 8) & 255);
                if (i15 < zzg.length()) {
                    i11 += 4;
                    i12 += 3;
                    bArr[i16] = (byte) ((zzb2 | this.zzb.zzb(zzg.charAt(i15))) & 255);
                } else {
                    i12 = i16;
                    i11 = i15;
                }
            } else {
                i11 = i14;
                i12 = i13;
            }
        }
        return i12;
    }

    @Override // com.google.android.libraries.places.internal.zzsh
    final zzsi zzb(zzsd zzsdVar, Character ch2) {
        return new zzsf(zzsdVar, null);
    }

    @Override // com.google.android.libraries.places.internal.zzsh, com.google.android.libraries.places.internal.zzsi
    final void zzc(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        zzmt.zzn(0, i12, bArr.length);
        for (int i14 = i12; i14 >= 3; i14 -= 3) {
            int i15 = bArr[i13] & 255;
            int i16 = ((bArr[i13 + 1] & 255) << 8) | (i15 << 16) | (bArr[i13 + 2] & 255);
            appendable.append(this.zzb.zza(i16 >>> 18));
            appendable.append(this.zzb.zza((i16 >>> 12) & 63));
            appendable.append(this.zzb.zza((i16 >>> 6) & 63));
            appendable.append(this.zzb.zza(i16 & 63));
            i13 += 3;
        }
        if (i13 < i12) {
            zzh(appendable, bArr, i13, i12 - i13);
        }
    }
}
