package com.google.android.libraries.places.internal;

import com.cloud.tmc.kernel.constants.TmcConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzaxc {
    private static final zzawz zza;

    static {
        if (zzawx.zzx() && zzawx.zzy()) {
            int i11 = zzarx.zza;
        }
        zza = new zzaxa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i11, int i12) {
        int i13 = i12 - i11;
        byte b11 = bArr[i11 - 1];
        if (i13 == 0) {
            if (b11 <= -12) {
                return b11;
            }
            return -1;
        }
        if (i13 == 1) {
            byte b12 = bArr[i11];
            if (b11 > -12 || b12 > -65) {
                return -1;
            }
            return (b12 << 8) ^ b11;
        }
        if (i13 != 2) {
            throw new AssertionError();
        }
        byte b13 = bArr[i11];
        byte b14 = bArr[i11 + 1];
        if (b11 > -12 || b13 > -65 || b14 > -65) {
            return -1;
        }
        return (b14 << 16) ^ ((b13 << 8) ^ b11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0101, code lost:
    
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zzb(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzaxc.zzb(java.lang.String, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(String str) {
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i12 < length && str.charAt(i12) < 128) {
            i12++;
        }
        int i13 = length;
        while (true) {
            if (i12 >= length) {
                break;
            }
            char charAt = str.charAt(i12);
            if (charAt < 2048) {
                i13 += (127 - charAt) >>> 31;
                i12++;
            } else {
                int length2 = str.length();
                while (i12 < length2) {
                    char charAt2 = str.charAt(i12);
                    if (charAt2 < 2048) {
                        i11 += (127 - charAt2) >>> 31;
                    } else {
                        i11 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i12) < 65536) {
                                throw new zzaxb(i12, length2);
                            }
                            i12++;
                        }
                    }
                    i12++;
                }
                i13 += i11;
            }
        }
        if (i13 >= length) {
            return i13;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i13 + TmcConstants.TEMP_FILE_RUNTIME_MAX_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(byte[] bArr, int i11, int i12) throws zzauf {
        int i13;
        int length = bArr.length;
        if ((((length - i11) - i12) | i11 | i12) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
        int i14 = i11 + i12;
        char[] cArr = new char[i12];
        int i15 = 0;
        while (i11 < i14) {
            byte b11 = bArr[i11];
            if (!zzawy.zzd(b11)) {
                break;
            }
            i11++;
            cArr[i15] = (char) b11;
            i15++;
        }
        int i16 = i15;
        while (i11 < i14) {
            int i17 = i11 + 1;
            byte b12 = bArr[i11];
            if (zzawy.zzd(b12)) {
                cArr[i16] = (char) b12;
                i16++;
                i11 = i17;
                while (i11 < i14) {
                    byte b13 = bArr[i11];
                    if (zzawy.zzd(b13)) {
                        i11++;
                        cArr[i16] = (char) b13;
                        i16++;
                    }
                }
            } else {
                if (b12 < -32) {
                    if (i17 >= i14) {
                        throw zzauf.zzd();
                    }
                    i13 = i16 + 1;
                    i11 += 2;
                    zzawy.zzc(b12, bArr[i17], cArr, i16);
                } else if (b12 < -16) {
                    if (i17 >= i14 - 1) {
                        throw zzauf.zzd();
                    }
                    i13 = i16 + 1;
                    int i18 = i11 + 2;
                    i11 += 3;
                    zzawy.zzb(b12, bArr[i17], bArr[i18], cArr, i16);
                } else {
                    if (i17 >= i14 - 2) {
                        throw zzauf.zzd();
                    }
                    byte b14 = bArr[i17];
                    int i19 = i11 + 3;
                    byte b15 = bArr[i11 + 2];
                    i11 += 4;
                    zzawy.zza(b12, b14, b15, bArr[i19], cArr, i16);
                    i16 += 2;
                }
                i16 = i13;
            }
        }
        return new String(cArr, 0, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zze(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzf(byte[] bArr, int i11, int i12) {
        return zza.zzb(bArr, 0, i12);
    }
}
