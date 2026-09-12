package com.google.android.libraries.places.internal;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes4.dex */
final class zzbta {
    private final String zza;
    private final int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private char[] zzg;

    public zzbta(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.zza = name;
        this.zzb = name.length();
    }

    private final char zzb() {
        int i11;
        int i12;
        int i13 = this.zzc + 1;
        this.zzc = i13;
        if (i13 == this.zzb) {
            throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
        }
        char c11 = this.zzg[i13];
        if (c11 != ' ' && c11 != '%' && c11 != '\\' && c11 != '_' && c11 != '\"' && c11 != '#') {
            switch (c11) {
                default:
                    switch (c11) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            int zzc = zzc(i13);
                            this.zzc++;
                            if (zzc >= 128) {
                                if (zzc >= 192 && zzc <= 247) {
                                    if (zzc <= 223) {
                                        i11 = zzc & 31;
                                        i12 = 1;
                                    } else if (zzc <= 239) {
                                        i11 = zzc & 15;
                                        i12 = 2;
                                    } else {
                                        i11 = zzc & 7;
                                        i12 = 3;
                                    }
                                    for (int i14 = 0; i14 < i12; i14++) {
                                        int i15 = this.zzc;
                                        int i16 = i15 + 1;
                                        this.zzc = i16;
                                        if (i16 != this.zzb && this.zzg[i16] == '\\') {
                                            int i17 = i15 + 2;
                                            this.zzc = i17;
                                            int zzc2 = zzc(i17);
                                            this.zzc++;
                                            if ((zzc2 & PsExtractor.AUDIO_STREAM) == 128) {
                                                i11 = (i11 << 6) + (zzc2 & 63);
                                            }
                                        }
                                    }
                                    zzc = (char) i11;
                                }
                                zzc = 63;
                            }
                            return (char) zzc;
                    }
                case '*':
                case '+':
                case ',':
                    return c11;
            }
        }
        return c11;
    }

    private final int zzc(int i11) {
        int i12;
        int i13;
        int i14 = i11 + 1;
        if (i14 >= this.zzb) {
            throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
        }
        char[] cArr = this.zzg;
        char c11 = cArr[i11];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
            }
            i12 = c11 - '7';
        }
        char c12 = cArr[i14];
        if (c12 >= '0' && c12 <= '9') {
            i13 = c12 - '0';
        } else if (c12 >= 'a' && c12 <= 'f') {
            i13 = c12 - 'W';
        } else {
            if (c12 < 'A' || c12 > 'F') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
            }
            i13 = c12 - '7';
        }
        return (i12 << 4) + i13;
    }

    private final String zzd() {
        int i11;
        int i12;
        int i13;
        int i14;
        char c11;
        char c12;
        char c13;
        int i15;
        char c14;
        char c15;
        while (true) {
            i11 = this.zzc;
            i12 = this.zzb;
            if (i11 >= i12 || this.zzg[i11] != ' ') {
                break;
            }
            this.zzc = i11 + 1;
        }
        if (i11 == i12) {
            return null;
        }
        this.zzd = i11;
        this.zzc = i11 + 1;
        while (true) {
            i13 = this.zzc;
            i14 = this.zzb;
            if (i13 >= i14 || (c15 = this.zzg[i13]) == '=' || c15 == ' ') {
                break;
            }
            this.zzc = i13 + 1;
        }
        if (i13 >= i14) {
            throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
        }
        this.zze = i13;
        if (this.zzg[i13] == ' ') {
            while (true) {
                i13 = this.zzc;
                i15 = this.zzb;
                if (i13 >= i15 || (c14 = this.zzg[i13]) == '=' || c14 != ' ') {
                    break;
                }
                this.zzc = i13 + 1;
            }
            if (this.zzg[i13] != '=' || i13 == i15) {
                throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
            }
        }
        this.zzc = i13 + 1;
        while (true) {
            int i16 = this.zzc;
            if (i16 >= this.zzb || this.zzg[i16] != ' ') {
                break;
            }
            this.zzc = i16 + 1;
        }
        int i17 = this.zze;
        int i18 = this.zzd;
        if (i17 - i18 > 4) {
            char[] cArr = this.zzg;
            if (cArr[i18 + 3] == '.' && (((c11 = cArr[i18]) == 'O' || c11 == 'o') && (((c12 = cArr[i18 + 1]) == 'I' || c12 == 'i') && ((c13 = cArr[i18 + 2]) == 'D' || c13 == 'd')))) {
                i18 += 4;
                this.zzd = i18;
            }
        }
        return new String(this.zzg, i18, i17 - i18);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0083, code lost:
    
        r4 = r12.zzd;
        r2 = new java.lang.String(r3, r4, r12.zze - r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbta.zza(java.lang.String):java.lang.String");
    }
}
