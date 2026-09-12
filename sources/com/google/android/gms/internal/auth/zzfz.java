package com.google.android.gms.internal.auth;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.mvel2.ast.ASTNode;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzfz<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfk zzl;
    private final zzgy zzm;
    private final zzel zzn;
    private final zzgb zzo;
    private final zzfr zzp;

    private zzfz(int[] iArr, Object[] objArr, int i11, int i12, zzfw zzfwVar, boolean z10, boolean z11, int[] iArr2, int i13, int i14, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzh = z10;
        this.zzi = iArr2;
        this.zzj = i13;
        this.zzk = i14;
        this.zzo = zzgbVar;
        this.zzl = zzfkVar;
        this.zzm = zzgyVar;
        this.zzn = zzelVar;
        this.zzg = zzfwVar;
        this.zzp = zzfrVar;
    }

    private static Field zzA(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzB(Object obj, Object obj2, int i11) {
        long zzv = zzv(i11) & 1048575;
        if (zzG(obj2, i11)) {
            Object zzf = zzhi.zzf(obj, zzv);
            Object zzf2 = zzhi.zzf(obj2, zzv);
            if (zzf != null && zzf2 != null) {
                zzhi.zzp(obj, zzv, zzez.zzg(zzf, zzf2));
                zzD(obj, i11);
            } else if (zzf2 != null) {
                zzhi.zzp(obj, zzv, zzf2);
                zzD(obj, i11);
            }
        }
    }

    private final void zzC(Object obj, Object obj2, int i11) {
        int zzv = zzv(i11);
        int i12 = this.zzc[i11];
        long j11 = zzv & 1048575;
        if (zzJ(obj2, i12, i11)) {
            Object zzf = zzJ(obj, i12, i11) ? zzhi.zzf(obj, j11) : null;
            Object zzf2 = zzhi.zzf(obj2, j11);
            if (zzf != null && zzf2 != null) {
                zzhi.zzp(obj, j11, zzez.zzg(zzf, zzf2));
                zzE(obj, i12, i11);
            } else if (zzf2 != null) {
                zzhi.zzp(obj, j11, zzf2);
                zzE(obj, i12, i11);
            }
        }
    }

    private final void zzD(Object obj, int i11) {
        int zzs = zzs(i11);
        long j11 = 1048575 & zzs;
        if (j11 == 1048575) {
            return;
        }
        zzhi.zzn(obj, j11, (1 << (zzs >>> 20)) | zzhi.zzc(obj, j11));
    }

    private final void zzE(Object obj, int i11, int i12) {
        zzhi.zzn(obj, zzs(i12) & 1048575, i11);
    }

    private final boolean zzF(Object obj, Object obj2, int i11) {
        return zzG(obj, i11) == zzG(obj2, i11);
    }

    private final boolean zzG(Object obj, int i11) {
        int zzs = zzs(i11);
        long j11 = zzs & 1048575;
        if (j11 != 1048575) {
            return (zzhi.zzc(obj, j11) & (1 << (zzs >>> 20))) != 0;
        }
        int zzv = zzv(i11);
        long j12 = zzv & 1048575;
        switch (zzu(zzv)) {
            case 0:
                return Double.doubleToRawLongBits(zzhi.zza(obj, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhi.zzb(obj, j12)) != 0;
            case 2:
                return zzhi.zzd(obj, j12) != 0;
            case 3:
                return zzhi.zzd(obj, j12) != 0;
            case 4:
                return zzhi.zzc(obj, j12) != 0;
            case 5:
                return zzhi.zzd(obj, j12) != 0;
            case 6:
                return zzhi.zzc(obj, j12) != 0;
            case 7:
                return zzhi.zzt(obj, j12);
            case 8:
                Object zzf = zzhi.zzf(obj, j12);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzee) {
                    return !zzee.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhi.zzf(obj, j12) != null;
            case 10:
                return !zzee.zzb.equals(zzhi.zzf(obj, j12));
            case 11:
                return zzhi.zzc(obj, j12) != 0;
            case 12:
                return zzhi.zzc(obj, j12) != 0;
            case 13:
                return zzhi.zzc(obj, j12) != 0;
            case 14:
                return zzhi.zzd(obj, j12) != 0;
            case 15:
                return zzhi.zzc(obj, j12) != 0;
            case 16:
                return zzhi.zzd(obj, j12) != 0;
            case 17:
                return zzhi.zzf(obj, j12) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzH(Object obj, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzG(obj, i11) : (i13 & i14) != 0;
    }

    private static boolean zzI(Object obj, int i11, zzgh zzghVar) {
        return zzghVar.zzi(zzhi.zzf(obj, i11 & 1048575));
    }

    private final boolean zzJ(Object obj, int i11, int i12) {
        return zzhi.zzc(obj, (long) (zzs(i12) & 1048575)) == i11;
    }

    static zzgz zzc(Object obj) {
        zzeu zzeuVar = (zzeu) obj;
        zzgz zzgzVar = zzeuVar.zzc;
        if (zzgzVar != zzgz.zza()) {
            return zzgzVar;
        }
        zzgz zzc = zzgz.zzc();
        zzeuVar.zzc = zzc;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfz zzj(Class cls, zzft zzftVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        if (zzftVar instanceof zzgg) {
            return zzk((zzgg) zzftVar, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0265  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.auth.zzfz zzk(com.google.android.gms.internal.auth.zzgg r34, com.google.android.gms.internal.auth.zzgb r35, com.google.android.gms.internal.auth.zzfk r36, com.google.android.gms.internal.auth.zzgy r37, com.google.android.gms.internal.auth.zzel r38, com.google.android.gms.internal.auth.zzfr r39) {
        /*
            Method dump skipped, instructions count: 1025
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzk(com.google.android.gms.internal.auth.zzgg, com.google.android.gms.internal.auth.zzgb, com.google.android.gms.internal.auth.zzfk, com.google.android.gms.internal.auth.zzgy, com.google.android.gms.internal.auth.zzel, com.google.android.gms.internal.auth.zzfr):com.google.android.gms.internal.auth.zzfz");
    }

    private static int zzl(Object obj, long j11) {
        return ((Integer) zzhi.zzf(obj, j11)).intValue();
    }

    private final int zzm(Object obj, byte[] bArr, int i11, int i12, int i13, long j11, zzds zzdsVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzz = zzz(i13);
        Object object = unsafe.getObject(obj, j11);
        if (!((zzfq) object).zze()) {
            zzfq zzb2 = zzfq.zza().zzb();
            zzfr.zza(zzb2, object);
            unsafe.putObject(obj, j11, zzb2);
        }
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final int zzn(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, zzds zzdsVar) throws IOException {
        Unsafe unsafe = zzb;
        long j12 = this.zzc[i18 + 2] & 1048575;
        switch (i17) {
            case AD_REWARD_USER_VALUE:
                if (i15 == 1) {
                    unsafe.putObject(obj, j11, Double.valueOf(Double.longBitsToDouble(zzdt.zzn(bArr, i11))));
                    unsafe.putInt(obj, j12, i14);
                    return i11 + 8;
                }
                return i11;
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                if (i15 == 5) {
                    unsafe.putObject(obj, j11, Float.valueOf(Float.intBitsToFloat(zzdt.zzb(bArr, i11))));
                    unsafe.putInt(obj, j12, i14);
                    return i11 + 4;
                }
                return i11;
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                if (i15 == 0) {
                    int zzm = zzdt.zzm(bArr, i11, zzdsVar);
                    unsafe.putObject(obj, j11, Long.valueOf(zzdsVar.zzb));
                    unsafe.putInt(obj, j12, i14);
                    return zzm;
                }
                return i11;
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
            case 62:
                if (i15 == 0) {
                    int zzj = zzdt.zzj(bArr, i11, zzdsVar);
                    unsafe.putObject(obj, j11, Integer.valueOf(zzdsVar.zza));
                    unsafe.putInt(obj, j12, i14);
                    return zzj;
                }
                return i11;
            case AD_VISIBILITY_VALUE:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i15 == 1) {
                    unsafe.putObject(obj, j11, Long.valueOf(zzdt.zzn(bArr, i11)));
                    unsafe.putInt(obj, j12, i14);
                    return i11 + 8;
                }
                return i11;
            case 57:
            case 64:
                if (i15 == 5) {
                    unsafe.putObject(obj, j11, Integer.valueOf(zzdt.zzb(bArr, i11)));
                    unsafe.putInt(obj, j12, i14);
                    return i11 + 4;
                }
                return i11;
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                if (i15 == 0) {
                    int zzm2 = zzdt.zzm(bArr, i11, zzdsVar);
                    unsafe.putObject(obj, j11, Boolean.valueOf(zzdsVar.zzb != 0));
                    unsafe.putInt(obj, j12, i14);
                    return zzm2;
                }
                return i11;
            case 59:
                if (i15 == 2) {
                    int zzj2 = zzdt.zzj(bArr, i11, zzdsVar);
                    int i19 = zzdsVar.zza;
                    if (i19 == 0) {
                        unsafe.putObject(obj, j11, "");
                    } else {
                        if ((i16 & ASTNode.DISCARD) != 0 && !zzhm.zzd(bArr, zzj2, zzj2 + i19)) {
                            throw zzfa.zzb();
                        }
                        unsafe.putObject(obj, j11, new String(bArr, zzj2, i19, zzez.zzb));
                        zzj2 += i19;
                    }
                    unsafe.putInt(obj, j12, i14);
                    return zzj2;
                }
                return i11;
            case 60:
                if (i15 == 2) {
                    int zzd = zzdt.zzd(zzy(i18), bArr, i11, i12, zzdsVar);
                    Object object = unsafe.getInt(obj, j12) == i14 ? unsafe.getObject(obj, j11) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j11, zzdsVar.zzc);
                    } else {
                        unsafe.putObject(obj, j11, zzez.zzg(object, zzdsVar.zzc));
                    }
                    unsafe.putInt(obj, j12, i14);
                    return zzd;
                }
                return i11;
            case 61:
                if (i15 == 2) {
                    int zza2 = zzdt.zza(bArr, i11, zzdsVar);
                    unsafe.putObject(obj, j11, zzdsVar.zzc);
                    unsafe.putInt(obj, j12, i14);
                    return zza2;
                }
                return i11;
            case 63:
                if (i15 == 0) {
                    int zzj3 = zzdt.zzj(bArr, i11, zzdsVar);
                    int i20 = zzdsVar.zza;
                    zzex zzx = zzx(i18);
                    if (zzx == null || zzx.zza()) {
                        unsafe.putObject(obj, j11, Integer.valueOf(i20));
                        unsafe.putInt(obj, j12, i14);
                    } else {
                        zzc(obj).zzf(i13, Long.valueOf(i20));
                    }
                    return zzj3;
                }
                return i11;
            case 66:
                if (i15 == 0) {
                    int zzj4 = zzdt.zzj(bArr, i11, zzdsVar);
                    unsafe.putObject(obj, j11, Integer.valueOf(zzei.zzb(zzdsVar.zza)));
                    unsafe.putInt(obj, j12, i14);
                    return zzj4;
                }
                return i11;
            case 67:
                if (i15 == 0) {
                    int zzm3 = zzdt.zzm(bArr, i11, zzdsVar);
                    unsafe.putObject(obj, j11, Long.valueOf(zzei.zzc(zzdsVar.zzb)));
                    unsafe.putInt(obj, j12, i14);
                    return zzm3;
                }
                return i11;
            case 68:
                if (i15 == 3) {
                    int zzc = zzdt.zzc(zzy(i18), bArr, i11, i12, (i13 & (-8)) | 4, zzdsVar);
                    Object object2 = unsafe.getInt(obj, j12) == i14 ? unsafe.getObject(obj, j11) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj, j11, zzdsVar.zzc);
                    } else {
                        unsafe.putObject(obj, j11, zzez.zzg(object2, zzdsVar.zzc));
                    }
                    unsafe.putInt(obj, j12, i14);
                    return zzc;
                }
                return i11;
            default:
                return i11;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:68:0x0081. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v22, types: [int] */
    private final int zzo(Object obj, byte[] bArr, int i11, int i12, zzds zzdsVar) throws IOException {
        byte b11;
        int i13;
        int i14;
        int i15;
        int i16;
        Unsafe unsafe;
        int i17;
        int i18;
        int i19;
        int i20;
        int zzm;
        int zzd;
        int i21;
        int i22;
        int i23;
        zzfz<T> zzfzVar = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i24 = i12;
        zzds zzdsVar2 = zzdsVar;
        Unsafe unsafe2 = zzb;
        int i25 = 1048575;
        int i26 = -1;
        int i27 = i11;
        int i28 = -1;
        int i29 = 1048575;
        int i30 = 0;
        int i31 = 0;
        while (i27 < i24) {
            int i32 = i27 + 1;
            byte b12 = bArr2[i27];
            if (b12 < 0) {
                i13 = zzdt.zzk(b12, bArr2, i32, zzdsVar2);
                b11 = zzdsVar2.zza;
            } else {
                b11 = b12;
                i13 = i32;
            }
            int i33 = b11 >>> 3;
            int i34 = b11 & 7;
            int zzr = i33 > i28 ? zzfzVar.zzr(i33, i30 / 3) : zzfzVar.zzq(i33);
            if (zzr == i26) {
                i14 = i13;
                i15 = i33;
                i16 = i26;
                unsafe = unsafe2;
                i17 = 0;
            } else {
                int[] iArr = zzfzVar.zzc;
                int i35 = iArr[zzr + 1];
                int zzu = zzu(i35);
                long j11 = i35 & i25;
                if (zzu <= 17) {
                    int i36 = iArr[zzr + 2];
                    int i37 = 1 << (i36 >>> 20);
                    int i38 = i36 & 1048575;
                    if (i38 != i29) {
                        if (i29 != 1048575) {
                            unsafe2.putInt(obj2, i29, i31);
                        }
                        if (i38 != 1048575) {
                            i31 = unsafe2.getInt(obj2, i38);
                        }
                        i29 = i38;
                    }
                    switch (zzu) {
                        case 0:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i19 = i13;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 1) {
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                zzhi.zzl(obj2, j11, Double.longBitsToDouble(zzdt.zzn(bArr2, i19)));
                                i27 = i19 + 8;
                                i31 |= i37;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 1:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i19 = i13;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 5) {
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                zzhi.zzm(obj2, j11, Float.intBitsToFloat(zzdt.zzb(bArr2, i19)));
                                i27 = i19 + 4;
                                i31 |= i37;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 2:
                        case 3:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i19 = i13;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 0) {
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                zzm = zzdt.zzm(bArr2, i19, zzdsVar2);
                                unsafe2.putLong(obj, j11, zzdsVar2.zzb);
                                i31 |= i37;
                                i27 = zzm;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 4:
                        case 11:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i19 = i13;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 0) {
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                i27 = zzdt.zzj(bArr2, i19, zzdsVar2);
                                unsafe2.putInt(obj2, j11, zzdsVar2.zza);
                                i31 |= i37;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 5:
                        case 14:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 1) {
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                i19 = i13;
                                unsafe2.putLong(obj, j11, zzdt.zzn(bArr2, i13));
                                i27 = i19 + 8;
                                i31 |= i37;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 6:
                        case 13:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 5) {
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                unsafe2.putInt(obj2, j11, zzdt.zzb(bArr2, i13));
                                i27 = i13 + 4;
                                i31 |= i37;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 7:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 0) {
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                i27 = zzdt.zzm(bArr2, i13, zzdsVar2);
                                zzhi.zzk(obj2, j11, zzdsVar2.zzb != 0);
                                i31 |= i37;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 8:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 2) {
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                i27 = (536870912 & i35) == 0 ? zzdt.zzg(bArr2, i13, zzdsVar2) : zzdt.zzh(bArr2, i13, zzdsVar2);
                                unsafe2.putObject(obj2, j11, zzdsVar2.zzc);
                                i31 |= i37;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 9:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 2) {
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                zzd = zzdt.zzd(zzfzVar.zzy(i18), bArr2, i13, i24, zzdsVar2);
                                Object object = unsafe2.getObject(obj2, j11);
                                if (object == null) {
                                    unsafe2.putObject(obj2, j11, zzdsVar2.zzc);
                                } else {
                                    unsafe2.putObject(obj2, j11, zzez.zzg(object, zzdsVar2.zzc));
                                }
                                i31 |= i37;
                                i27 = zzd;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 10:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 2) {
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                zzd = zzdt.zza(bArr2, i13, zzdsVar2);
                                unsafe2.putObject(obj2, j11, zzdsVar2.zzc);
                                i31 |= i37;
                                i27 = zzd;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 12:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 0) {
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                zzd = zzdt.zzj(bArr2, i13, zzdsVar2);
                                unsafe2.putInt(obj2, j11, zzdsVar2.zza);
                                i31 |= i37;
                                i27 = zzd;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 15:
                            zzdsVar2 = zzdsVar;
                            i18 = zzr;
                            i20 = 1048575;
                            i15 = i33;
                            if (i34 != 0) {
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                zzd = zzdt.zzj(bArr2, i13, zzdsVar2);
                                unsafe2.putInt(obj2, j11, zzei.zzb(zzdsVar2.zza));
                                i31 |= i37;
                                i27 = zzd;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        case 16:
                            if (i34 != 0) {
                                i15 = i33;
                                i18 = zzr;
                                i19 = i13;
                                i14 = i19;
                                unsafe = unsafe2;
                                i17 = i18;
                                i16 = -1;
                                break;
                            } else {
                                zzdsVar2 = zzdsVar;
                                zzm = zzdt.zzm(bArr2, i13, zzdsVar2);
                                i18 = zzr;
                                i15 = i33;
                                i20 = 1048575;
                                unsafe2.putLong(obj, j11, zzei.zzc(zzdsVar2.zzb));
                                i31 |= i37;
                                i27 = zzm;
                                i30 = i18;
                                i28 = i15;
                                i25 = i20;
                                i26 = -1;
                                break;
                            }
                        default:
                            i15 = i33;
                            i18 = zzr;
                            i19 = i13;
                            i14 = i19;
                            unsafe = unsafe2;
                            i17 = i18;
                            i16 = -1;
                            break;
                    }
                } else {
                    zzdsVar2 = zzdsVar;
                    i18 = zzr;
                    int i39 = i13;
                    i20 = 1048575;
                    i15 = i33;
                    if (zzu == 27) {
                        if (i34 == 2) {
                            zzey zzeyVar = (zzey) unsafe2.getObject(obj2, j11);
                            if (!zzeyVar.zzc()) {
                                int size = zzeyVar.size();
                                zzeyVar = zzeyVar.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj2, j11, zzeyVar);
                            }
                            i27 = zzdt.zze(zzfzVar.zzy(i18), b11, bArr, i39, i12, zzeyVar, zzdsVar);
                            i31 = i31;
                            i30 = i18;
                            i28 = i15;
                            i25 = i20;
                            i26 = -1;
                        } else {
                            i21 = i39;
                            i22 = i31;
                            i23 = i29;
                            unsafe = unsafe2;
                            i17 = i18;
                            i16 = -1;
                        }
                    } else if (zzu <= 49) {
                        i22 = i31;
                        i23 = i29;
                        i16 = -1;
                        unsafe = unsafe2;
                        i17 = i18;
                        i27 = zzp(obj, bArr, i39, i12, b11, i15, i34, i18, i35, zzu, j11, zzdsVar);
                        if (i27 != i39) {
                            obj2 = obj;
                            bArr2 = bArr;
                            i24 = i12;
                            zzdsVar2 = zzdsVar;
                            i29 = i23;
                            i26 = i16;
                            i28 = i15;
                            i31 = i22;
                            i30 = i17;
                            unsafe2 = unsafe;
                            i25 = 1048575;
                            zzfzVar = this;
                        } else {
                            i14 = i27;
                            i29 = i23;
                            i31 = i22;
                        }
                    } else {
                        i21 = i39;
                        i22 = i31;
                        i23 = i29;
                        unsafe = unsafe2;
                        i17 = i18;
                        i16 = -1;
                        if (zzu != 50) {
                            i27 = zzn(obj, bArr, i21, i12, b11, i15, i34, i35, zzu, j11, i17, zzdsVar);
                            if (i27 != i21) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i24 = i12;
                                zzdsVar2 = zzdsVar;
                                i29 = i23;
                                i26 = i16;
                                i28 = i15;
                                i31 = i22;
                                i30 = i17;
                                unsafe2 = unsafe;
                                i25 = 1048575;
                                zzfzVar = this;
                            } else {
                                i14 = i27;
                                i29 = i23;
                                i31 = i22;
                            }
                        } else if (i34 == 2) {
                            i27 = zzm(obj, bArr, i21, i12, i17, j11, zzdsVar);
                            if (i27 != i21) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i24 = i12;
                                zzdsVar2 = zzdsVar;
                                i29 = i23;
                                i26 = i16;
                                i28 = i15;
                                i31 = i22;
                                i30 = i17;
                                unsafe2 = unsafe;
                                i25 = 1048575;
                                zzfzVar = this;
                            } else {
                                i14 = i27;
                                i29 = i23;
                                i31 = i22;
                            }
                        }
                    }
                    i14 = i21;
                    i29 = i23;
                    i31 = i22;
                }
            }
            i27 = zzdt.zzi(b11, bArr, i14, i12, zzc(obj), zzdsVar);
            zzfzVar = this;
            obj2 = obj;
            bArr2 = bArr;
            i24 = i12;
            zzdsVar2 = zzdsVar;
            i26 = i16;
            i28 = i15;
            i30 = i17;
            unsafe2 = unsafe;
            i25 = 1048575;
        }
        int i40 = i31;
        int i41 = i29;
        Unsafe unsafe3 = unsafe2;
        if (i41 != i25) {
            unsafe3.putInt(obj, i41, i40);
        }
        if (i27 == i12) {
            return i27;
        }
        throw zzfa.zzd();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0037. Please report as an issue. */
    private final int zzp(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, long j12, zzds zzdsVar) throws IOException {
        int i18;
        int i19;
        int i20;
        int i21;
        int zzj;
        int i22 = i11;
        Unsafe unsafe = zzb;
        zzey zzeyVar = (zzey) unsafe.getObject(obj, j12);
        if (!zzeyVar.zzc()) {
            int size = zzeyVar.size();
            zzeyVar = zzeyVar.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j12, zzeyVar);
        }
        switch (i17) {
            case 18:
            case 35:
                if (i15 == 2) {
                    zzej zzejVar = (zzej) zzeyVar;
                    int zzj2 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i23 = zzdsVar.zza + zzj2;
                    while (zzj2 < i23) {
                        zzejVar.zze(Double.longBitsToDouble(zzdt.zzn(bArr, zzj2)));
                        zzj2 += 8;
                    }
                    if (zzj2 == i23) {
                        return zzj2;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 1) {
                    zzej zzejVar2 = (zzej) zzeyVar;
                    zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, i11)));
                    while (true) {
                        i18 = i22 + 8;
                        if (i18 < i12) {
                            i22 = zzdt.zzj(bArr, i18, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, i22)));
                            }
                        }
                    }
                    return i18;
                }
                return i22;
            case 19:
            case 36:
                if (i15 == 2) {
                    zzeq zzeqVar = (zzeq) zzeyVar;
                    int zzj3 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i24 = zzdsVar.zza + zzj3;
                    while (zzj3 < i24) {
                        zzeqVar.zze(Float.intBitsToFloat(zzdt.zzb(bArr, zzj3)));
                        zzj3 += 4;
                    }
                    if (zzj3 == i24) {
                        return zzj3;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 5) {
                    zzeq zzeqVar2 = (zzeq) zzeyVar;
                    zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, i11)));
                    while (true) {
                        i19 = i22 + 4;
                        if (i19 < i12) {
                            i22 = zzdt.zzj(bArr, i19, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, i22)));
                            }
                        }
                    }
                    return i19;
                }
                return i22;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    zzfl zzflVar = (zzfl) zzeyVar;
                    int zzj4 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i25 = zzdsVar.zza + zzj4;
                    while (zzj4 < i25) {
                        zzj4 = zzdt.zzm(bArr, zzj4, zzdsVar);
                        zzflVar.zze(zzdsVar.zzb);
                    }
                    if (zzj4 == i25) {
                        return zzj4;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 0) {
                    zzfl zzflVar2 = (zzfl) zzeyVar;
                    int zzm = zzdt.zzm(bArr, i22, zzdsVar);
                    zzflVar2.zze(zzdsVar.zzb);
                    while (zzm < i12) {
                        int zzj5 = zzdt.zzj(bArr, zzm, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return zzm;
                        }
                        zzm = zzdt.zzm(bArr, zzj5, zzdsVar);
                        zzflVar2.zze(zzdsVar.zzb);
                    }
                    return zzm;
                }
                return i22;
            case 22:
            case NOTIFICATION_REDIRECT_VALUE:
            case 39:
            case 43:
                if (i15 == 2) {
                    return zzdt.zzf(bArr, i22, zzeyVar, zzdsVar);
                }
                if (i15 == 0) {
                    return zzdt.zzl(i13, bArr, i11, i12, zzeyVar, zzdsVar);
                }
                return i22;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i15 == 2) {
                    zzfl zzflVar3 = (zzfl) zzeyVar;
                    int zzj6 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i26 = zzdsVar.zza + zzj6;
                    while (zzj6 < i26) {
                        zzflVar3.zze(zzdt.zzn(bArr, zzj6));
                        zzj6 += 8;
                    }
                    if (zzj6 == i26) {
                        return zzj6;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 1) {
                    zzfl zzflVar4 = (zzfl) zzeyVar;
                    zzflVar4.zze(zzdt.zzn(bArr, i11));
                    while (true) {
                        i20 = i22 + 8;
                        if (i20 < i12) {
                            i22 = zzdt.zzj(bArr, i20, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                zzflVar4.zze(zzdt.zzn(bArr, i22));
                            }
                        }
                    }
                    return i20;
                }
                return i22;
            case 24:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 41:
            case 45:
                if (i15 == 2) {
                    zzev zzevVar = (zzev) zzeyVar;
                    int zzj7 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i27 = zzdsVar.zza + zzj7;
                    while (zzj7 < i27) {
                        zzevVar.zze(zzdt.zzb(bArr, zzj7));
                        zzj7 += 4;
                    }
                    if (zzj7 == i27) {
                        return zzj7;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 5) {
                    zzev zzevVar2 = (zzev) zzeyVar;
                    zzevVar2.zze(zzdt.zzb(bArr, i11));
                    while (true) {
                        i21 = i22 + 4;
                        if (i21 < i12) {
                            i22 = zzdt.zzj(bArr, i21, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                zzevVar2.zze(zzdt.zzb(bArr, i22));
                            }
                        }
                    }
                    return i21;
                }
                return i22;
            case 25:
            case 42:
                if (i15 == 2) {
                    zzdu zzduVar = (zzdu) zzeyVar;
                    zzj = zzdt.zzj(bArr, i22, zzdsVar);
                    int i28 = zzdsVar.zza + zzj;
                    while (zzj < i28) {
                        zzj = zzdt.zzm(bArr, zzj, zzdsVar);
                        zzduVar.zze(zzdsVar.zzb != 0);
                    }
                    if (zzj != i28) {
                        throw zzfa.zzf();
                    }
                    return zzj;
                }
                if (i15 == 0) {
                    zzdu zzduVar2 = (zzdu) zzeyVar;
                    int zzm2 = zzdt.zzm(bArr, i22, zzdsVar);
                    zzduVar2.zze(zzdsVar.zzb != 0);
                    while (zzm2 < i12) {
                        int zzj8 = zzdt.zzj(bArr, zzm2, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return zzm2;
                        }
                        zzm2 = zzdt.zzm(bArr, zzj8, zzdsVar);
                        zzduVar2.zze(zzdsVar.zzb != 0);
                    }
                    return zzm2;
                }
                return i22;
            case 26:
                if (i15 == 2) {
                    if ((j11 & 536870912) == 0) {
                        int zzj9 = zzdt.zzj(bArr, i22, zzdsVar);
                        int i29 = zzdsVar.zza;
                        if (i29 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i29 == 0) {
                            zzeyVar.add("");
                        } else {
                            zzeyVar.add(new String(bArr, zzj9, i29, zzez.zzb));
                            zzj9 += i29;
                        }
                        while (zzj9 < i12) {
                            int zzj10 = zzdt.zzj(bArr, zzj9, zzdsVar);
                            if (i13 != zzdsVar.zza) {
                                return zzj9;
                            }
                            zzj9 = zzdt.zzj(bArr, zzj10, zzdsVar);
                            int i30 = zzdsVar.zza;
                            if (i30 < 0) {
                                throw zzfa.zzc();
                            }
                            if (i30 == 0) {
                                zzeyVar.add("");
                            } else {
                                zzeyVar.add(new String(bArr, zzj9, i30, zzez.zzb));
                                zzj9 += i30;
                            }
                        }
                        return zzj9;
                    }
                    int zzj11 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i31 = zzdsVar.zza;
                    if (i31 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i31 == 0) {
                        zzeyVar.add("");
                    } else {
                        int i32 = zzj11 + i31;
                        if (!zzhm.zzd(bArr, zzj11, i32)) {
                            throw zzfa.zzb();
                        }
                        zzeyVar.add(new String(bArr, zzj11, i31, zzez.zzb));
                        zzj11 = i32;
                    }
                    while (zzj11 < i12) {
                        int zzj12 = zzdt.zzj(bArr, zzj11, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return zzj11;
                        }
                        zzj11 = zzdt.zzj(bArr, zzj12, zzdsVar);
                        int i33 = zzdsVar.zza;
                        if (i33 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i33 == 0) {
                            zzeyVar.add("");
                        } else {
                            int i34 = zzj11 + i33;
                            if (!zzhm.zzd(bArr, zzj11, i34)) {
                                throw zzfa.zzb();
                            }
                            zzeyVar.add(new String(bArr, zzj11, i33, zzez.zzb));
                            zzj11 = i34;
                        }
                    }
                    return zzj11;
                }
                return i22;
            case 27:
                if (i15 == 2) {
                    return zzdt.zze(zzy(i16), i13, bArr, i11, i12, zzeyVar, zzdsVar);
                }
                return i22;
            case 28:
                if (i15 == 2) {
                    int zzj13 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i35 = zzdsVar.zza;
                    if (i35 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i35 > bArr.length - zzj13) {
                        throw zzfa.zzf();
                    }
                    if (i35 == 0) {
                        zzeyVar.add(zzee.zzb);
                    } else {
                        zzeyVar.add(zzee.zzk(bArr, zzj13, i35));
                        zzj13 += i35;
                    }
                    while (zzj13 < i12) {
                        int zzj14 = zzdt.zzj(bArr, zzj13, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return zzj13;
                        }
                        zzj13 = zzdt.zzj(bArr, zzj14, zzdsVar);
                        int i36 = zzdsVar.zza;
                        if (i36 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i36 > bArr.length - zzj13) {
                            throw zzfa.zzf();
                        }
                        if (i36 == 0) {
                            zzeyVar.add(zzee.zzb);
                        } else {
                            zzeyVar.add(zzee.zzk(bArr, zzj13, i36));
                            zzj13 += i36;
                        }
                    }
                    return zzj13;
                }
                return i22;
            case 30:
            case 44:
                if (i15 != 2) {
                    if (i15 == 0) {
                        zzj = zzdt.zzl(i13, bArr, i11, i12, zzeyVar, zzdsVar);
                    }
                    return i22;
                }
                zzj = zzdt.zzf(bArr, i22, zzeyVar, zzdsVar);
                zzeu zzeuVar = (zzeu) obj;
                zzgz zzgzVar = zzeuVar.zzc;
                if (zzgzVar == zzgz.zza()) {
                    zzgzVar = null;
                }
                Object zzd = zzgj.zzd(i14, zzeyVar, zzx(i16), zzgzVar, this.zzm);
                if (zzd != null) {
                    zzeuVar.zzc = (zzgz) zzd;
                    return zzj;
                }
                return zzj;
            case 33:
            case 47:
                if (i15 == 2) {
                    zzev zzevVar3 = (zzev) zzeyVar;
                    int zzj15 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i37 = zzdsVar.zza + zzj15;
                    while (zzj15 < i37) {
                        zzj15 = zzdt.zzj(bArr, zzj15, zzdsVar);
                        zzevVar3.zze(zzei.zzb(zzdsVar.zza));
                    }
                    if (zzj15 == i37) {
                        return zzj15;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 0) {
                    zzev zzevVar4 = (zzev) zzeyVar;
                    int zzj16 = zzdt.zzj(bArr, i22, zzdsVar);
                    zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    while (zzj16 < i12) {
                        int zzj17 = zzdt.zzj(bArr, zzj16, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return zzj16;
                        }
                        zzj16 = zzdt.zzj(bArr, zzj17, zzdsVar);
                        zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    }
                    return zzj16;
                }
                return i22;
            case 34:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                if (i15 == 2) {
                    zzfl zzflVar5 = (zzfl) zzeyVar;
                    int zzj18 = zzdt.zzj(bArr, i22, zzdsVar);
                    int i38 = zzdsVar.zza + zzj18;
                    while (zzj18 < i38) {
                        zzj18 = zzdt.zzm(bArr, zzj18, zzdsVar);
                        zzflVar5.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    if (zzj18 == i38) {
                        return zzj18;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 0) {
                    zzfl zzflVar6 = (zzfl) zzeyVar;
                    int zzm3 = zzdt.zzm(bArr, i22, zzdsVar);
                    zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    while (zzm3 < i12) {
                        int zzj19 = zzdt.zzj(bArr, zzm3, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return zzm3;
                        }
                        zzm3 = zzdt.zzm(bArr, zzj19, zzdsVar);
                        zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    return zzm3;
                }
                return i22;
            default:
                if (i15 == 3) {
                    zzgh zzy = zzy(i16);
                    int i39 = (i13 & (-8)) | 4;
                    int zzc = zzdt.zzc(zzy, bArr, i11, i12, i39, zzdsVar);
                    zzeyVar.add(zzdsVar.zzc);
                    while (zzc < i12) {
                        int zzj20 = zzdt.zzj(bArr, zzc, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return zzc;
                        }
                        zzc = zzdt.zzc(zzy, bArr, zzj20, i12, i39, zzdsVar);
                        zzeyVar.add(zzdsVar.zzc);
                    }
                    return zzc;
                }
                return i22;
        }
    }

    private final int zzq(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzt(i11, 0);
    }

    private final int zzr(int i11, int i12) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzt(i11, i12);
    }

    private final int zzs(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzt(int i11, int i12) {
        int length = (this.zzc.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int i15 = this.zzc[i14];
            if (i11 == i15) {
                return i14;
            }
            if (i11 < i15) {
                length = i13 - 1;
            } else {
                i12 = i13 + 1;
            }
        }
        return -1;
    }

    private static int zzu(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzv(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzw(Object obj, long j11) {
        return ((Long) zzhi.zzf(obj, j11)).longValue();
    }

    private final zzex zzx(int i11) {
        int i12 = i11 / 3;
        return (zzex) this.zzd[i12 + i12 + 1];
    }

    private final zzgh zzy(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzgh zzghVar = (zzgh) this.zzd[i13];
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzb2 = zzge.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final Object zzz(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001a. Please report as an issue. */
    @Override // com.google.android.gms.internal.auth.zzgh
    public final int zza(Object obj) {
        int i11;
        int zzc;
        int length = this.zzc.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int zzv = zzv(i13);
            int i14 = this.zzc[i13];
            long j11 = 1048575 & zzv;
            int i15 = 37;
            switch (zzu(zzv)) {
                case 0:
                    i11 = i12 * 53;
                    zzc = zzez.zzc(Double.doubleToLongBits(zzhi.zza(obj, j11)));
                    i12 = i11 + zzc;
                    break;
                case 1:
                    i11 = i12 * 53;
                    zzc = Float.floatToIntBits(zzhi.zzb(obj, j11));
                    i12 = i11 + zzc;
                    break;
                case 2:
                    i11 = i12 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + zzc;
                    break;
                case 3:
                    i11 = i12 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + zzc;
                    break;
                case 4:
                    i11 = i12 * 53;
                    zzc = zzhi.zzc(obj, j11);
                    i12 = i11 + zzc;
                    break;
                case 5:
                    i11 = i12 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + zzc;
                    break;
                case 6:
                    i11 = i12 * 53;
                    zzc = zzhi.zzc(obj, j11);
                    i12 = i11 + zzc;
                    break;
                case 7:
                    i11 = i12 * 53;
                    zzc = zzez.zza(zzhi.zzt(obj, j11));
                    i12 = i11 + zzc;
                    break;
                case 8:
                    i11 = i12 * 53;
                    zzc = ((String) zzhi.zzf(obj, j11)).hashCode();
                    i12 = i11 + zzc;
                    break;
                case 9:
                    Object zzf = zzhi.zzf(obj, j11);
                    if (zzf != null) {
                        i15 = zzf.hashCode();
                    }
                    i12 = (i12 * 53) + i15;
                    break;
                case 10:
                    i11 = i12 * 53;
                    zzc = zzhi.zzf(obj, j11).hashCode();
                    i12 = i11 + zzc;
                    break;
                case 11:
                    i11 = i12 * 53;
                    zzc = zzhi.zzc(obj, j11);
                    i12 = i11 + zzc;
                    break;
                case 12:
                    i11 = i12 * 53;
                    zzc = zzhi.zzc(obj, j11);
                    i12 = i11 + zzc;
                    break;
                case 13:
                    i11 = i12 * 53;
                    zzc = zzhi.zzc(obj, j11);
                    i12 = i11 + zzc;
                    break;
                case 14:
                    i11 = i12 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + zzc;
                    break;
                case 15:
                    i11 = i12 * 53;
                    zzc = zzhi.zzc(obj, j11);
                    i12 = i11 + zzc;
                    break;
                case 16:
                    i11 = i12 * 53;
                    zzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + zzc;
                    break;
                case 17:
                    Object zzf2 = zzhi.zzf(obj, j11);
                    if (zzf2 != null) {
                        i15 = zzf2.hashCode();
                    }
                    i12 = (i12 * 53) + i15;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case NOTIFICATION_REDIRECT_VALUE:
                case 30:
                case TEMPLATE_HTML_SIZE_VALUE:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    i11 = i12 * 53;
                    zzc = zzhi.zzf(obj, j11).hashCode();
                    i12 = i11 + zzc;
                    break;
                case 50:
                    i11 = i12 * 53;
                    zzc = zzhi.zzf(obj, j11).hashCode();
                    i12 = i11 + zzc;
                    break;
                case AD_REWARD_USER_VALUE:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzez.zzc(Double.doubleToLongBits(((Double) zzhi.zzf(obj, j11)).doubleValue()));
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = Float.floatToIntBits(((Float) zzhi.zzf(obj, j11)).floatValue());
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzl(obj, j11);
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case AD_VISIBILITY_VALUE:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzl(obj, j11);
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzez.zza(((Boolean) zzhi.zzf(obj, j11)).booleanValue());
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = ((String) zzhi.zzf(obj, j11)).hashCode();
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzhi.zzf(obj, j11).hashCode();
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzhi.zzf(obj, j11).hashCode();
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzl(obj, j11);
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzl(obj, j11);
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzl(obj, j11);
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzl(obj, j11);
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        zzc = zzhi.zzf(obj, j11).hashCode();
                        i12 = i11 + zzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return (i12 * 53) + this.zzm.zza(obj).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0353, code lost:
    
        if (r0 != r5) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0355, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r35;
        r8 = r17;
        r1 = r19;
        r7 = r22;
        r2 = r23;
        r3 = r24;
        r6 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x036f, code lost:
    
        r8 = r34;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03a7, code lost:
    
        if (r0 != r15) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03c8, code lost:
    
        if (r0 != r15) goto L117;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0083. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.auth.zzds r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1148
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final Object zzd() {
        return ((zzeu) this.zzg).zzi(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zze(Object obj) {
        int i11;
        int i12 = this.zzj;
        while (true) {
            i11 = this.zzk;
            if (i12 >= i11) {
                break;
            }
            long zzv = zzv(this.zzi[i12]) & 1048575;
            Object zzf = zzhi.zzf(obj, zzv);
            if (zzf != null) {
                ((zzfq) zzf).zzc();
                zzhi.zzp(obj, zzv, zzf);
            }
            i12++;
        }
        int length = this.zzi.length;
        while (i11 < length) {
            this.zzl.zza(obj, this.zzi[i11]);
            i11++;
        }
        this.zzm.zze(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzf(Object obj, Object obj2) {
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzv = zzv(i11);
            long j11 = 1048575 & zzv;
            int i12 = this.zzc[i11];
            switch (zzu(zzv)) {
                case 0:
                    if (zzG(obj2, i11)) {
                        zzhi.zzl(obj, j11, zzhi.zza(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzG(obj2, i11)) {
                        zzhi.zzm(obj, j11, zzhi.zzb(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzG(obj2, i11)) {
                        zzhi.zzk(obj, j11, zzhi.zzt(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzG(obj2, i11)) {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i11);
                    break;
                case 10:
                    if (zzG(obj2, i11)) {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i11);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case NOTIFICATION_REDIRECT_VALUE:
                case 30:
                case TEMPLATE_HTML_SIZE_VALUE:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    this.zzl.zzb(obj, obj2, j11);
                    break;
                case 50:
                    zzgj.zzi(this.zzp, obj, obj2, j11);
                    break;
                case AD_REWARD_USER_VALUE:
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                case AD_VISIBILITY_VALUE:
                case 57:
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                case 59:
                    if (zzJ(obj2, i12, i11)) {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzE(obj, i12, i11);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzJ(obj2, i12, i11)) {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzE(obj, i12, i11);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i11);
                    break;
            }
        }
        zzgj.zzf(this.zzm, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzg(Object obj, byte[] bArr, int i11, int i12, zzds zzdsVar) throws IOException {
        if (this.zzh) {
            zzo(obj, bArr, i11, i12, zzdsVar);
        } else {
            zzb(obj, bArr, i11, i12, 0, zzdsVar);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c0 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzh(java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzh(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzi(Object obj) {
        int i11;
        int i12;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.zzj) {
            int i16 = this.zzi[i15];
            int i17 = this.zzc[i16];
            int zzv = zzv(i16);
            int i18 = this.zzc[i16 + 2];
            int i19 = i18 & 1048575;
            int i20 = 1 << (i18 >>> 20);
            if (i19 != i13) {
                if (i19 != 1048575) {
                    i14 = zzb.getInt(obj, i19);
                }
                i12 = i14;
                i11 = i19;
            } else {
                i11 = i13;
                i12 = i14;
            }
            if ((268435456 & zzv) != 0 && !zzH(obj, i16, i11, i12, i20)) {
                return false;
            }
            int zzu = zzu(zzv);
            if (zzu != 9 && zzu != 17) {
                if (zzu != 27) {
                    if (zzu == 60 || zzu == 68) {
                        if (zzJ(obj, i17, i16) && !zzI(obj, zzv, zzy(i16))) {
                            return false;
                        }
                    } else if (zzu != 49) {
                        if (zzu == 50 && !((zzfq) zzhi.zzf(obj, zzv & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhi.zzf(obj, zzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgh zzy = zzy(i16);
                    for (int i21 = 0; i21 < list.size(); i21++) {
                        if (!zzy.zzi(list.get(i21))) {
                            return false;
                        }
                    }
                }
            } else if (zzH(obj, i16, i11, i12, i20) && !zzI(obj, zzv, zzy(i16))) {
                return false;
            }
            i15++;
            i13 = i11;
            i14 = i12;
        }
        return true;
    }
}
