package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
final class zzmq extends zzmr {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmr
    public final int zza(int i11, byte[] bArr, int i12, int i13) {
        while (i12 < i13 && bArr[i12] >= 0) {
            i12++;
        }
        if (i12 >= i13) {
            return 0;
        }
        while (i12 < i13) {
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            if (b11 < 0) {
                if (b11 < -32) {
                    if (i14 >= i13) {
                        return b11;
                    }
                    if (b11 >= -62) {
                        i12 += 2;
                        if (bArr[i14] > -65) {
                        }
                    }
                    return -1;
                }
                if (b11 >= -16) {
                    if (i14 >= i13 - 2) {
                        return zzmp.zza(bArr, i14, i13);
                    }
                    int i15 = i12 + 2;
                    byte b12 = bArr[i14];
                    if (b12 <= -65 && (((b11 << 28) + (b12 + 112)) >> 30) == 0) {
                        int i16 = i12 + 3;
                        if (bArr[i15] <= -65) {
                            i12 += 4;
                            if (bArr[i16] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i14 >= i13 - 1) {
                    return zzmp.zza(bArr, i14, i13);
                }
                int i17 = i12 + 2;
                byte b13 = bArr[i14];
                if (b13 <= -65 && ((b11 != -32 || b13 >= -96) && (b11 != -19 || b13 < -96))) {
                    i12 += 3;
                    if (bArr[i17] > -65) {
                    }
                }
                return -1;
            }
            i12 = i14;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.measurement.zzmr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmq.zza(java.lang.String, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmr
    public final String zza(byte[] bArr, int i11, int i12) throws zzkb {
        if ((i11 | i12 | ((bArr.length - i11) - i12)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
        int i13 = i11 + i12;
        char[] cArr = new char[i12];
        int i14 = 0;
        while (i11 < i13) {
            byte b11 = bArr[i11];
            if (b11 < 0) {
                break;
            }
            i11++;
            zzmo.zza(b11, cArr, i14);
            i14++;
        }
        int i15 = i14;
        while (i11 < i13) {
            int i16 = i11 + 1;
            byte b12 = bArr[i11];
            if (b12 >= 0) {
                int i17 = i15 + 1;
                zzmo.zza(b12, cArr, i15);
                while (i16 < i13) {
                    byte b13 = bArr[i16];
                    if (b13 < 0) {
                        break;
                    }
                    i16++;
                    zzmo.zza(b13, cArr, i17);
                    i17++;
                }
                i15 = i17;
                i11 = i16;
            } else if (b12 < -32) {
                if (i16 >= i13) {
                    throw zzkb.zzd();
                }
                i11 += 2;
                zzmo.zza(b12, bArr[i16], cArr, i15);
                i15++;
            } else if (b12 < -16) {
                if (i16 >= i13 - 1) {
                    throw zzkb.zzd();
                }
                int i18 = i11 + 2;
                i11 += 3;
                zzmo.zza(b12, bArr[i16], bArr[i18], cArr, i15);
                i15++;
            } else {
                if (i16 >= i13 - 2) {
                    throw zzkb.zzd();
                }
                byte b14 = bArr[i16];
                int i19 = i11 + 3;
                byte b15 = bArr[i11 + 2];
                i11 += 4;
                zzmo.zza(b12, b14, b15, bArr[i19], cArr, i15);
                i15 += 2;
            }
        }
        return new String(cArr, 0, i15);
    }
}
