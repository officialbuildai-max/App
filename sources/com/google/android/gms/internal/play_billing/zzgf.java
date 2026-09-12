package com.google.android.gms.internal.play_billing;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzgf<T> implements zzgm<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgc zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfq zzl;
    private final zzhd zzm;
    private final zzek zzn;
    private final zzgh zzo;
    private final zzfx zzp;

    private zzgf(int[] iArr, Object[] objArr, int i11, int i12, zzgc zzgcVar, int i13, boolean z10, int[] iArr2, int i14, int i15, zzgh zzghVar, zzfq zzfqVar, zzhd zzhdVar, zzek zzekVar, zzfx zzfxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        boolean z11 = false;
        if (zzekVar != null && zzekVar.zzc(zzgcVar)) {
            z11 = true;
        }
        this.zzh = z11;
        this.zzi = iArr2;
        this.zzj = i14;
        this.zzk = i15;
        this.zzo = zzghVar;
        this.zzl = zzfqVar;
        this.zzm = zzhdVar;
        this.zzn = zzekVar;
        this.zzg = zzgcVar;
        this.zzp = zzfxVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i11) {
        if (zzI(obj2, i11)) {
            int zzs = zzs(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = zzs;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzgm zzv = zzv(i11);
            if (!zzI(obj, i11)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j11, zze);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzD(obj, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j11, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzM(obj2, i12, i11)) {
            int zzs = zzs(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = zzs;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzgm zzv = zzv(i11);
            if (!zzM(obj, i12, i11)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j11, zze);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzE(obj, i12, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j11, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i11) {
        int zzp = zzp(i11);
        long j11 = 1048575 & zzp;
        if (j11 == 1048575) {
            return;
        }
        zzhn.zzq(obj, j11, (1 << (zzp >>> 20)) | zzhn.zzc(obj, j11));
    }

    private final void zzE(Object obj, int i11, int i12) {
        zzhn.zzq(obj, zzp(i12) & 1048575, i11);
    }

    private final void zzF(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, zzs(i11) & 1048575, obj2);
        zzD(obj, i11);
    }

    private final void zzG(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, zzs(i12) & 1048575, obj2);
        zzE(obj, i11, i12);
    }

    private final boolean zzH(Object obj, Object obj2, int i11) {
        return zzI(obj, i11) == zzI(obj2, i11);
    }

    private final boolean zzI(Object obj, int i11) {
        int zzp = zzp(i11);
        long j11 = zzp & 1048575;
        if (j11 != 1048575) {
            return (zzhn.zzc(obj, j11) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i11);
        long j12 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzhn.zza(obj, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhn.zzb(obj, j12)) != 0;
            case 2:
                return zzhn.zzd(obj, j12) != 0;
            case 3:
                return zzhn.zzd(obj, j12) != 0;
            case 4:
                return zzhn.zzc(obj, j12) != 0;
            case 5:
                return zzhn.zzd(obj, j12) != 0;
            case 6:
                return zzhn.zzc(obj, j12) != 0;
            case 7:
                return zzhn.zzw(obj, j12);
            case 8:
                Object zzf = zzhn.zzf(obj, j12);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzdw) {
                    return !zzdw.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhn.zzf(obj, j12) != null;
            case 10:
                return !zzdw.zzb.equals(zzhn.zzf(obj, j12));
            case 11:
                return zzhn.zzc(obj, j12) != 0;
            case 12:
                return zzhn.zzc(obj, j12) != 0;
            case 13:
                return zzhn.zzc(obj, j12) != 0;
            case 14:
                return zzhn.zzd(obj, j12) != 0;
            case 15:
                return zzhn.zzc(obj, j12) != 0;
            case 16:
                return zzhn.zzd(obj, j12) != 0;
            case 17:
                return zzhn.zzf(obj, j12) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzI(obj, i11) : (i13 & i14) != 0;
    }

    private static boolean zzK(Object obj, int i11, zzgm zzgmVar) {
        return zzgmVar.zzk(zzhn.zzf(obj, i11 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzex) {
            return ((zzex) obj).zzt();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i11, int i12) {
        return zzhn.zzc(obj, (long) (zzp(i12) & 1048575)) == i11;
    }

    private static boolean zzN(Object obj, long j11) {
        return ((Boolean) zzhn.zzf(obj, j11)).booleanValue();
    }

    private static final void zzO(int i11, Object obj, zzhv zzhvVar) throws IOException {
        if (obj instanceof String) {
            zzhvVar.zzF(i11, (String) obj);
        } else {
            zzhvVar.zzd(i11, (zzdw) obj);
        }
    }

    static zzhe zzd(Object obj) {
        zzex zzexVar = (zzex) obj;
        zzhe zzheVar = zzexVar.zzc;
        if (zzheVar != zzhe.zzc()) {
            return zzheVar;
        }
        zzhe zzf = zzhe.zzf();
        zzexVar.zzc = zzf;
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x026b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.play_billing.zzgf zzl(java.lang.Class r33, com.google.android.gms.internal.play_billing.zzfz r34, com.google.android.gms.internal.play_billing.zzgh r35, com.google.android.gms.internal.play_billing.zzfq r36, com.google.android.gms.internal.play_billing.zzhd r37, com.google.android.gms.internal.play_billing.zzek r38, com.google.android.gms.internal.play_billing.zzfx r39) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzfz, com.google.android.gms.internal.play_billing.zzgh, com.google.android.gms.internal.play_billing.zzfq, com.google.android.gms.internal.play_billing.zzhd, com.google.android.gms.internal.play_billing.zzek, com.google.android.gms.internal.play_billing.zzfx):com.google.android.gms.internal.play_billing.zzgf");
    }

    private static double zzm(Object obj, long j11) {
        return ((Double) zzhn.zzf(obj, j11)).doubleValue();
    }

    private static float zzn(Object obj, long j11) {
        return ((Float) zzhn.zzf(obj, j11)).floatValue();
    }

    private static int zzo(Object obj, long j11) {
        return ((Integer) zzhn.zzf(obj, j11)).intValue();
    }

    private final int zzp(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzq(int i11, int i12) {
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

    private static int zzr(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzs(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzt(Object obj, long j11) {
        return ((Long) zzhn.zzf(obj, j11)).longValue();
    }

    private final zzfb zzu(int i11) {
        int i12 = i11 / 3;
        return (zzfb) this.zzd[i12 + i12 + 1];
    }

    private final zzgm zzv(int i11) {
        Object[] objArr = this.zzd;
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzgm zzgmVar = (zzgm) objArr[i13];
        if (zzgmVar != null) {
            return zzgmVar;
        }
        zzgm zzb2 = zzgk.zza().zzb((Class) objArr[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private final Object zzx(Object obj, int i11) {
        zzgm zzv = zzv(i11);
        int zzs = zzs(i11) & 1048575;
        if (!zzI(obj, i11)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i11, int i12) {
        zzgm zzv = zzv(i12);
        if (!zzM(obj, i11, i12)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i12) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0053. Please report as an issue. */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final int zza(Object obj) {
        int i11;
        int i12;
        int i13;
        int i14;
        int zzx;
        int zzx2;
        int zzy;
        int zzx3;
        int i15;
        int i16;
        int zzx4;
        int zzx5;
        int zzx6;
        boolean z10;
        int zzd;
        int zzg;
        int size;
        int zzl;
        int zzx7;
        int zzd2;
        boolean z11;
        int zzb2;
        int zzx8;
        int zzx9;
        int size2;
        int zzk;
        int zzx10;
        int i17;
        int zze;
        int zzx11;
        int zzx12;
        int zzx13;
        int zzx14;
        int zzx15;
        int zzx16;
        Unsafe unsafe = zzb;
        int i18 = 1048575;
        int i19 = 1048575;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        while (i21 < this.zzc.length) {
            int zzs = zzs(i21);
            int zzr = zzr(zzs);
            int[] iArr = this.zzc;
            int i23 = iArr[i21];
            int i24 = iArr[i21 + 2];
            int i25 = i24 & i18;
            if (zzr <= 17) {
                if (i25 != i19) {
                    i20 = i25 == i18 ? 0 : unsafe.getInt(obj, i25);
                    i19 = i25;
                }
                i13 = 1 << (i24 >>> 20);
                i11 = i19;
                i12 = i20;
            } else {
                i11 = i19;
                i12 = i20;
                i13 = 0;
            }
            int i26 = zzs & i18;
            if (zzr >= zzep.zzJ.zza()) {
                zzep.zzW.zza();
            }
            long j11 = i26;
            switch (zzr) {
                case 0:
                    i14 = i21;
                    if (zzJ(obj, i14, i11, i12, i13)) {
                        zzx = zzee.zzx(i23 << 3);
                        i15 = zzx + 8;
                        i22 += i15;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 1:
                    i14 = i21;
                    if (zzJ(obj, i14, i11, i12, i13)) {
                        zzx2 = zzee.zzx(i23 << 3);
                        i15 = zzx2 + 4;
                        i22 += i15;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 2:
                    i14 = i21;
                    if (zzJ(obj, i14, i11, i12, i13)) {
                        zzy = zzee.zzy(unsafe.getLong(obj, j11));
                        zzx3 = zzee.zzx(i23 << 3);
                        i15 = zzx3 + zzy;
                        i22 += i15;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 3:
                    i14 = i21;
                    if (zzJ(obj, i14, i11, i12, i13)) {
                        zzy = zzee.zzy(unsafe.getLong(obj, j11));
                        zzx3 = zzee.zzx(i23 << 3);
                        i15 = zzx3 + zzy;
                        i22 += i15;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 4:
                    i14 = i21;
                    if (zzJ(obj, i14, i11, i12, i13)) {
                        zzy = zzee.zzu(unsafe.getInt(obj, j11));
                        zzx3 = zzee.zzx(i23 << 3);
                        i15 = zzx3 + zzy;
                        i22 += i15;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 5:
                    i14 = i21;
                    if (zzJ(obj, i14, i11, i12, i13)) {
                        zzx = zzee.zzx(i23 << 3);
                        i15 = zzx + 8;
                        i22 += i15;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 6:
                    i14 = i21;
                    if (zzJ(obj, i14, i11, i12, i13)) {
                        zzx2 = zzee.zzx(i23 << 3);
                        i15 = zzx2 + 4;
                        i22 += i15;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 7:
                    i14 = i21;
                    if (zzJ(obj, i14, i11, i12, i13)) {
                        i15 = zzee.zzx(i23 << 3) + 1;
                        i22 += i15;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 8:
                    int i27 = i21;
                    i14 = i27;
                    if (zzJ(obj, i27, i11, i12, i13)) {
                        int i28 = i23 << 3;
                        Object object = unsafe.getObject(obj, j11);
                        if (object instanceof zzdw) {
                            int i29 = zzee.zzb;
                            int zzd3 = ((zzdw) object).zzd();
                            i15 = zzee.zzx(i28) + zzee.zzx(zzd3) + zzd3;
                            i22 += i15;
                            i21 = i14 + 3;
                            i19 = i11;
                            i20 = i12;
                            i18 = 1048575;
                        } else {
                            zzy = zzee.zzw((String) object);
                            zzx3 = zzee.zzx(i28);
                            i15 = zzx3 + zzy;
                            i22 += i15;
                            i21 = i14 + 3;
                            i19 = i11;
                            i20 = i12;
                            i18 = 1048575;
                        }
                    } else {
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                case 9:
                    i16 = i21;
                    if (zzJ(obj, i16, i11, i12, i13)) {
                        i22 += zzgo.zzh(i23, unsafe.getObject(obj, j11), zzv(i16));
                        i14 = i16;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    i14 = i16;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 10:
                    i16 = i21;
                    if (zzJ(obj, i16, i11, i12, i13)) {
                        zzdw zzdwVar = (zzdw) unsafe.getObject(obj, j11);
                        int i30 = zzee.zzb;
                        int zzd4 = zzdwVar.zzd();
                        zzx4 = zzee.zzx(i23 << 3) + zzee.zzx(zzd4) + zzd4;
                        i22 += zzx4;
                    }
                    i14 = i16;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 11:
                    i16 = i21;
                    if (zzJ(obj, i16, i11, i12, i13)) {
                        zzx5 = zzee.zzx(unsafe.getInt(obj, j11));
                        zzx6 = zzee.zzx(i23 << 3);
                        zzx4 = zzx6 + zzx5;
                        i22 += zzx4;
                    }
                    i14 = i16;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 12:
                    i16 = i21;
                    if (zzJ(obj, i16, i11, i12, i13)) {
                        zzx5 = zzee.zzu(unsafe.getInt(obj, j11));
                        zzx6 = zzee.zzx(i23 << 3);
                        zzx4 = zzx6 + zzx5;
                        i22 += zzx4;
                    }
                    i14 = i16;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 13:
                    i16 = i21;
                    if (zzJ(obj, i16, i11, i12, i13)) {
                        zzx4 = zzee.zzx(i23 << 3) + 4;
                        i22 += zzx4;
                    }
                    i14 = i16;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 14:
                    i16 = i21;
                    if (zzJ(obj, i16, i11, i12, i13)) {
                        zzx4 = zzee.zzx(i23 << 3) + 8;
                        i22 += zzx4;
                    }
                    i14 = i16;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 15:
                    i16 = i21;
                    if (zzJ(obj, i16, i11, i12, i13)) {
                        int i31 = unsafe.getInt(obj, j11);
                        zzx6 = zzee.zzx(i23 << 3);
                        zzx5 = zzee.zzx((i31 >> 31) ^ (i31 + i31));
                        zzx4 = zzx6 + zzx5;
                        i22 += zzx4;
                    }
                    i14 = i16;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 16:
                    i16 = i21;
                    if (zzJ(obj, i21, i11, i12, i13)) {
                        long j12 = unsafe.getLong(obj, j11);
                        zzx6 = zzee.zzx(i23 << 3);
                        zzx5 = zzee.zzy((j12 >> 63) ^ (j12 + j12));
                        zzx4 = zzx6 + zzx5;
                        i22 += zzx4;
                    }
                    i14 = i16;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 17:
                    if (zzJ(obj, i21, i11, i12, i13)) {
                        i22 += zzee.zzt(i23, (zzgc) unsafe.getObject(obj, j11), zzv(i21));
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 18:
                    z10 = false;
                    zzd = zzgo.zzd(i23, (List) unsafe.getObject(obj, j11), false);
                    i22 += zzd;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 19:
                    z10 = false;
                    zzd = zzgo.zzb(i23, (List) unsafe.getObject(obj, j11), false);
                    i22 += zzd;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj, j11);
                    int i32 = zzgo.zza;
                    if (list.size() != 0) {
                        zzg = zzgo.zzg(list) + (list.size() * zzee.zzx(i23 << 3));
                        i22 += zzg;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzg = 0;
                    i22 += zzg;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j11);
                    int i33 = zzgo.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzl = zzgo.zzl(list2);
                        zzx7 = zzee.zzx(i23 << 3);
                        zzg = zzl + (size * zzx7);
                        i22 += zzg;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzg = 0;
                    i22 += zzg;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j11);
                    int i34 = zzgo.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzl = zzgo.zzf(list3);
                        zzx7 = zzee.zzx(i23 << 3);
                        zzg = zzl + (size * zzx7);
                        i22 += zzg;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzg = 0;
                    i22 += zzg;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 23:
                    zzd2 = zzgo.zzd(i23, (List) unsafe.getObject(obj, j11), false);
                    i22 += zzd2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 24:
                    z11 = false;
                    zzb2 = zzgo.zzb(i23, (List) unsafe.getObject(obj, j11), false);
                    i22 += zzb2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j11);
                    int i35 = zzgo.zza;
                    int size3 = list4.size();
                    if (size3 != 0) {
                        zzd2 = size3 * (zzee.zzx(i23 << 3) + 1);
                        i22 += zzd2;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzd2 = 0;
                    i22 += zzd2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j11);
                    int i36 = zzgo.zza;
                    int size4 = list5.size();
                    if (size4 != 0) {
                        boolean z12 = list5 instanceof zzfk;
                        int zzx17 = zzee.zzx(i23 << 3) * size4;
                        if (z12) {
                            zzfk zzfkVar = (zzfk) list5;
                            zzg = zzx17;
                            for (int i37 = 0; i37 < size4; i37++) {
                                Object zzf = zzfkVar.zzf(i37);
                                if (zzf instanceof zzdw) {
                                    int zzd5 = ((zzdw) zzf).zzd();
                                    zzg += zzee.zzx(zzd5) + zzd5;
                                } else {
                                    zzg += zzee.zzw((String) zzf);
                                }
                            }
                        } else {
                            zzg = zzx17;
                            for (int i38 = 0; i38 < size4; i38++) {
                                Object obj2 = list5.get(i38);
                                if (obj2 instanceof zzdw) {
                                    int zzd6 = ((zzdw) obj2).zzd();
                                    zzg += zzee.zzx(zzd6) + zzd6;
                                } else {
                                    zzg += zzee.zzw((String) obj2);
                                }
                            }
                        }
                        i22 += zzg;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzg = 0;
                    i22 += zzg;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j11);
                    zzgm zzv = zzv(i21);
                    int i39 = zzgo.zza;
                    int size5 = list6.size();
                    if (size5 != 0) {
                        zzx8 = zzee.zzx(i23 << 3) * size5;
                        for (int i40 = 0; i40 < size5; i40++) {
                            Object obj3 = list6.get(i40);
                            if (obj3 instanceof zzfi) {
                                int zza2 = ((zzfi) obj3).zza();
                                zzx8 += zzee.zzx(zza2) + zza2;
                            } else {
                                zzx8 += zzee.zzv((zzgc) obj3, zzv);
                            }
                        }
                        i22 += zzx8;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzx8 = 0;
                    i22 += zzx8;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j11);
                    int i41 = zzgo.zza;
                    int size6 = list7.size();
                    if (size6 == 0) {
                        zzx9 = 0;
                    } else {
                        zzx9 = size6 * zzee.zzx(i23 << 3);
                        for (int i42 = 0; i42 < list7.size(); i42++) {
                            int zzd7 = ((zzdw) list7.get(i42)).zzd();
                            zzx9 += zzee.zzx(zzd7) + zzd7;
                        }
                    }
                    i22 += zzx9;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case NOTIFICATION_REDIRECT_VALUE:
                    List list8 = (List) unsafe.getObject(obj, j11);
                    int i43 = zzgo.zza;
                    size2 = list8.size();
                    if (size2 != 0) {
                        zzk = zzgo.zzk(list8);
                        zzx10 = zzee.zzx(i23 << 3);
                        i17 = size2 * zzx10;
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzd2 = 0;
                    i22 += zzd2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j11);
                    int i44 = zzgo.zza;
                    size2 = list9.size();
                    if (size2 != 0) {
                        zzk = zzgo.zza(list9);
                        zzx10 = zzee.zzx(i23 << 3);
                        i17 = size2 * zzx10;
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzd2 = 0;
                    i22 += zzd2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case TEMPLATE_HTML_SIZE_VALUE:
                    zzd2 = zzgo.zzb(i23, (List) unsafe.getObject(obj, j11), false);
                    i22 += zzd2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 32:
                    z11 = false;
                    zzb2 = zzgo.zzd(i23, (List) unsafe.getObject(obj, j11), false);
                    i22 += zzb2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j11);
                    int i45 = zzgo.zza;
                    size2 = list10.size();
                    if (size2 != 0) {
                        zzk = zzgo.zzi(list10);
                        zzx10 = zzee.zzx(i23 << 3);
                        i17 = size2 * zzx10;
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzd2 = 0;
                    i22 += zzd2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j11);
                    int i46 = zzgo.zza;
                    size2 = list11.size();
                    if (size2 != 0) {
                        zzk = zzgo.zzj(list11);
                        zzx10 = zzee.zzx(i23 << 3);
                        i17 = size2 * zzx10;
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzd2 = 0;
                    i22 += zzd2;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 35:
                    zze = zzgo.zze((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 36:
                    zze = zzgo.zzc((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 37:
                    zze = zzgo.zzg((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 38:
                    zze = zzgo.zzl((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 39:
                    zze = zzgo.zzf((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 40:
                    zze = zzgo.zze((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 41:
                    zze = zzgo.zzc((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j11);
                    int i47 = zzgo.zza;
                    zze = list12.size();
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 43:
                    zze = zzgo.zzk((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 44:
                    zze = zzgo.zza((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 45:
                    zze = zzgo.zzc((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 46:
                    zze = zzgo.zze((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 47:
                    zze = zzgo.zzi((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    zze = zzgo.zzj((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzx11 = zzee.zzx(zze);
                        zzx12 = zzee.zzx(i23 << 3);
                        i22 += zzx12 + zzx11 + zze;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    List list13 = (List) unsafe.getObject(obj, j11);
                    zzgm zzv2 = zzv(i21);
                    int i48 = zzgo.zza;
                    int size7 = list13.size();
                    if (size7 != 0) {
                        zzx8 = 0;
                        for (int i49 = 0; i49 < size7; i49++) {
                            zzx8 += zzee.zzt(i23, (zzgc) list13.get(i49), zzv2);
                        }
                        i22 += zzx8;
                        i14 = i21;
                        i21 = i14 + 3;
                        i19 = i11;
                        i20 = i12;
                        i18 = 1048575;
                    }
                    zzx8 = 0;
                    i22 += zzx8;
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 50:
                    zzfw zzfwVar = (zzfw) unsafe.getObject(obj, j11);
                    if (!zzfwVar.isEmpty()) {
                        Iterator it = zzfwVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case AD_REWARD_USER_VALUE:
                    if (zzM(obj, i23, i21)) {
                        zzx13 = zzee.zzx(i23 << 3);
                        zzd2 = zzx13 + 8;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i23, i21)) {
                        zzx14 = zzee.zzx(i23 << 3);
                        zzd2 = zzx14 + 4;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i23, i21)) {
                        i17 = zzee.zzy(zzt(obj, j11));
                        zzk = zzee.zzx(i23 << 3);
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i23, i21)) {
                        i17 = zzee.zzy(zzt(obj, j11));
                        zzk = zzee.zzx(i23 << 3);
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i23, i21)) {
                        i17 = zzee.zzu(zzo(obj, j11));
                        zzk = zzee.zzx(i23 << 3);
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case AD_VISIBILITY_VALUE:
                    if (zzM(obj, i23, i21)) {
                        zzx13 = zzee.zzx(i23 << 3);
                        zzd2 = zzx13 + 8;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 57:
                    if (zzM(obj, i23, i21)) {
                        zzx14 = zzee.zzx(i23 << 3);
                        zzd2 = zzx14 + 4;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (zzM(obj, i23, i21)) {
                        zzd2 = zzee.zzx(i23 << 3) + 1;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 59:
                    if (zzM(obj, i23, i21)) {
                        int i50 = i23 << 3;
                        Object object2 = unsafe.getObject(obj, j11);
                        if (object2 instanceof zzdw) {
                            int i51 = zzee.zzb;
                            int zzd8 = ((zzdw) object2).zzd();
                            zzx15 = zzee.zzx(zzd8) + zzd8;
                            zzx16 = zzee.zzx(i50);
                            zzd2 = zzx16 + zzx15;
                            i22 += zzd2;
                        } else {
                            i17 = zzee.zzw((String) object2);
                            zzk = zzee.zzx(i50);
                            zzd2 = zzk + i17;
                            i22 += zzd2;
                        }
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 60:
                    if (zzM(obj, i23, i21)) {
                        zzd2 = zzgo.zzh(i23, unsafe.getObject(obj, j11), zzv(i21));
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 61:
                    if (zzM(obj, i23, i21)) {
                        zzdw zzdwVar2 = (zzdw) unsafe.getObject(obj, j11);
                        int i52 = zzee.zzb;
                        int zzd9 = zzdwVar2.zzd();
                        zzx15 = zzee.zzx(zzd9) + zzd9;
                        zzx16 = zzee.zzx(i23 << 3);
                        zzd2 = zzx16 + zzx15;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 62:
                    if (zzM(obj, i23, i21)) {
                        i17 = zzee.zzx(zzo(obj, j11));
                        zzk = zzee.zzx(i23 << 3);
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 63:
                    if (zzM(obj, i23, i21)) {
                        i17 = zzee.zzu(zzo(obj, j11));
                        zzk = zzee.zzx(i23 << 3);
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 64:
                    if (zzM(obj, i23, i21)) {
                        zzx14 = zzee.zzx(i23 << 3);
                        zzd2 = zzx14 + 4;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i23, i21)) {
                        zzx13 = zzee.zzx(i23 << 3);
                        zzd2 = zzx13 + 8;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 66:
                    if (zzM(obj, i23, i21)) {
                        int zzo = zzo(obj, j11);
                        zzk = zzee.zzx(i23 << 3);
                        i17 = zzee.zzx((zzo >> 31) ^ (zzo + zzo));
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 67:
                    if (zzM(obj, i23, i21)) {
                        long zzt = zzt(obj, j11);
                        zzk = zzee.zzx(i23 << 3);
                        i17 = zzee.zzy((zzt >> 63) ^ (zzt + zzt));
                        zzd2 = zzk + i17;
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                case 68:
                    if (zzM(obj, i23, i21)) {
                        zzd2 = zzee.zzt(i23, (zzgc) unsafe.getObject(obj, j11), zzv(i21));
                        i22 += zzd2;
                    }
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
                default:
                    i14 = i21;
                    i21 = i14 + 3;
                    i19 = i11;
                    i20 = i12;
                    i18 = 1048575;
            }
        }
        zzhd zzhdVar = this.zzm;
        int zza3 = i22 + zzhdVar.zza(zzhdVar.zzd(obj));
        if (!this.zzh) {
            return zza3;
        }
        this.zzn.zza(obj);
        throw null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final int zzb(Object obj) {
        int i11;
        long doubleToLongBits;
        int floatToIntBits;
        int i12;
        int i13 = 0;
        for (int i14 = 0; i14 < this.zzc.length; i14 += 3) {
            int zzs = zzs(i14);
            int[] iArr = this.zzc;
            int i15 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i16 = iArr[i14];
            long j11 = i15;
            int i17 = 37;
            switch (zzr) {
                case 0:
                    i11 = i13 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzhn.zza(obj, j11));
                    byte[] bArr = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 1:
                    i11 = i13 * 53;
                    floatToIntBits = Float.floatToIntBits(zzhn.zzb(obj, j11));
                    i13 = i11 + floatToIntBits;
                    break;
                case 2:
                    i11 = i13 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr2 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 3:
                    i11 = i13 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr3 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 4:
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 5:
                    i11 = i13 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr4 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 6:
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 7:
                    i11 = i13 * 53;
                    floatToIntBits = zzfd.zza(zzhn.zzw(obj, j11));
                    i13 = i11 + floatToIntBits;
                    break;
                case 8:
                    i11 = i13 * 53;
                    floatToIntBits = ((String) zzhn.zzf(obj, j11)).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 9:
                    i12 = i13 * 53;
                    Object zzf = zzhn.zzf(obj, j11);
                    if (zzf != null) {
                        i17 = zzf.hashCode();
                    }
                    i13 = i12 + i17;
                    break;
                case 10:
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzf(obj, j11).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 11:
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 12:
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 13:
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 14:
                    i11 = i13 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr5 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 15:
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 16:
                    i11 = i13 * 53;
                    doubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr6 = zzfd.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 17:
                    i12 = i13 * 53;
                    Object zzf2 = zzhn.zzf(obj, j11);
                    if (zzf2 != null) {
                        i17 = zzf2.hashCode();
                    }
                    i13 = i12 + i17;
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
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzf(obj, j11).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 50:
                    i11 = i13 * 53;
                    floatToIntBits = zzhn.zzf(obj, j11).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case AD_REWARD_USER_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j11));
                        byte[] bArr7 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j11));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzt(obj, j11);
                        byte[] bArr8 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzt(obj, j11);
                        byte[] bArr9 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_VISIBILITY_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzt(obj, j11);
                        byte[] bArr10 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzfd.zza(zzN(obj, j11));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = ((String) zzhn.zzf(obj, j11)).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzhn.zzf(obj, j11).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzhn.zzf(obj, j11).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzt(obj, j11);
                        byte[] bArr11 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzo(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzt(obj, j11);
                        byte[] bArr12 = zzfd.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzhn.zzf(obj, j11).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i13 * 53) + this.zzm.zzd(obj).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzn.zza(obj);
        throw null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    final int zzc(java.lang.Object r37, byte[] r38, int r39, int r40, int r41, com.google.android.gms.internal.play_billing.zzdj r42) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 4068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdj):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final Object zze() {
        return ((zzex) this.zzg).zzi();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzex) {
                zzex zzexVar = (zzex) obj;
                zzexVar.zzq(Integer.MAX_VALUE);
                zzexVar.zza = 0;
                zzexVar.zzo();
            }
            int[] iArr = this.zzc;
            for (int i11 = 0; i11 < iArr.length; i11 += 3) {
                int zzs = zzs(i11);
                int i12 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j11 = i12;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
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
                                this.zzl.zza(obj, j11);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j11);
                                if (object != null) {
                                    ((zzfw) object).zzc();
                                    unsafe.putObject(obj, j11, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, this.zzc[i11], i11)) {
                        zzv(i11).zzf(zzb.getObject(obj, j11));
                    }
                }
                if (zzI(obj, i11)) {
                    zzv(i11).zzf(zzb.getObject(obj, j11));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzb(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzs = zzs(i11);
            int i12 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i13 = iArr[i11];
            long j11 = i12;
            switch (zzr) {
                case 0:
                    if (zzI(obj2, i11)) {
                        zzhn.zzo(obj, j11, zzhn.zza(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i11)) {
                        zzhn.zzp(obj, j11, zzhn.zzb(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i11)) {
                        zzhn.zzm(obj, j11, zzhn.zzw(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i11)) {
                        zzhn.zzs(obj, j11, zzhn.zzf(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i11);
                    break;
                case 10:
                    if (zzI(obj2, i11)) {
                        zzhn.zzs(obj, j11, zzhn.zzf(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
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
                    int i14 = zzgo.zza;
                    zzhn.zzs(obj, j11, zzfx.zza(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11)));
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
                    if (zzM(obj2, i13, i11)) {
                        zzhn.zzs(obj, j11, zzhn.zzf(obj2, j11));
                        zzE(obj, i13, i11);
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
                    if (zzM(obj2, i13, i11)) {
                        zzhn.zzs(obj, j11, zzhn.zzf(obj2, j11));
                        zzE(obj, i13, i11);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i11);
                    break;
            }
        }
        zzgo.zzp(this.zzm, obj, obj2);
        if (this.zzh) {
            this.zzn.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzh(Object obj, byte[] bArr, int i11, int i12, zzdj zzdjVar) throws IOException {
        zzc(obj, bArr, i11, i12, 0, zzdjVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x004e. Please report as an issue. */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v20 */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzi(Object obj, zzhv zzhvVar) throws IOException {
        int i11;
        int i12;
        int i13;
        boolean z10;
        ?? r92 = 1;
        Throwable th2 = null;
        if (this.zzh) {
            this.zzn.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        while (i17 < iArr.length) {
            int zzs = zzs(i17);
            int[] iArr2 = this.zzc;
            int zzr = zzr(zzs);
            int i18 = iArr2[i17];
            if (zzr <= 17) {
                int i19 = iArr2[i17 + 2];
                int i20 = i19 & i14;
                if (i20 != i15) {
                    i16 = i20 == i14 ? 0 : unsafe.getInt(obj, i20);
                    i15 = i20;
                }
                i11 = i15;
                i12 = i16;
                i13 = r92 << (i19 >>> 20);
            } else {
                i11 = i15;
                i12 = i16;
                i13 = 0;
            }
            long j11 = zzs & i14;
            switch (zzr) {
                case 0:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzf(i18, zzhn.zza(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 1:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzo(i18, zzhn.zzb(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 2:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzt(i18, unsafe.getLong(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 3:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzJ(i18, unsafe.getLong(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 4:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzr(i18, unsafe.getInt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 5:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzm(i18, unsafe.getLong(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 6:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzk(i18, unsafe.getInt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 7:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzb(i18, zzhn.zzw(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 8:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzO(i18, unsafe.getObject(obj, j11), zzhvVar);
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 9:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzv(i18, unsafe.getObject(obj, j11), zzv(i17));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 10:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzd(i18, (zzdw) unsafe.getObject(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 11:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzH(i18, unsafe.getInt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 12:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzi(i18, unsafe.getInt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 13:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzw(i18, unsafe.getInt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 14:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzy(i18, unsafe.getLong(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 15:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzA(i18, unsafe.getInt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 16:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzC(i18, unsafe.getLong(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 17:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzq(i18, unsafe.getObject(obj, j11), zzv(i17));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 18:
                    z10 = false;
                    zzgo.zzs(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 19:
                    z10 = false;
                    zzgo.zzw(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 20:
                    z10 = false;
                    zzgo.zzy(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 21:
                    z10 = false;
                    zzgo.zzE(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 22:
                    z10 = false;
                    zzgo.zzx(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 23:
                    z10 = false;
                    zzgo.zzv(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 24:
                    z10 = false;
                    zzgo.zzu(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 25:
                    z10 = false;
                    zzgo.zzr(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 26:
                    int i21 = this.zzc[i17];
                    List list = (List) unsafe.getObject(obj, j11);
                    int i22 = zzgo.zza;
                    if (list != null && !list.isEmpty()) {
                        zzhvVar.zzG(i21, list);
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                    break;
                case 27:
                    int i23 = this.zzc[i17];
                    List list2 = (List) unsafe.getObject(obj, j11);
                    zzgm zzv = zzv(i17);
                    int i24 = zzgo.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i25 = 0; i25 < list2.size(); i25 += r92) {
                            ((zzef) zzhvVar).zzv(i23, list2.get(i25), zzv);
                        }
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                    break;
                case 28:
                    int i26 = this.zzc[i17];
                    List list3 = (List) unsafe.getObject(obj, j11);
                    int i27 = zzgo.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzhvVar.zze(i26, list3);
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                    break;
                case NOTIFICATION_REDIRECT_VALUE:
                    z10 = false;
                    zzgo.zzD(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 30:
                    z10 = false;
                    zzgo.zzt(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case TEMPLATE_HTML_SIZE_VALUE:
                    z10 = false;
                    zzgo.zzz(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 32:
                    z10 = false;
                    zzgo.zzA(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 33:
                    z10 = false;
                    zzgo.zzB(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 34:
                    z10 = false;
                    zzgo.zzC(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 35:
                    zzgo.zzs(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 36:
                    zzgo.zzw(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 37:
                    zzgo.zzy(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 38:
                    zzgo.zzE(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 39:
                    zzgo.zzx(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 40:
                    zzgo.zzv(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 41:
                    zzgo.zzu(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 42:
                    zzgo.zzr(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 43:
                    zzgo.zzD(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 44:
                    zzgo.zzt(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 45:
                    zzgo.zzz(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 46:
                    zzgo.zzA(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 47:
                    zzgo.zzB(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    zzgo.zzC(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, r92);
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    int i28 = this.zzc[i17];
                    List list4 = (List) unsafe.getObject(obj, j11);
                    zzgm zzv2 = zzv(i17);
                    int i29 = zzgo.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i30 = 0; i30 < list4.size(); i30 += r92) {
                            ((zzef) zzhvVar).zzq(i28, list4.get(i30), zzv2);
                        }
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j11) != null) {
                        throw th2;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case AD_REWARD_USER_VALUE:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzf(i18, zzm(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzo(i18, zzn(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzt(i18, zzt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzJ(i18, zzt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzr(i18, zzo(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case AD_VISIBILITY_VALUE:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzm(i18, zzt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 57:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzk(i18, zzo(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzb(i18, zzN(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 59:
                    if (zzM(obj, i18, i17)) {
                        zzO(i18, unsafe.getObject(obj, j11), zzhvVar);
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 60:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzv(i18, unsafe.getObject(obj, j11), zzv(i17));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 61:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzd(i18, (zzdw) unsafe.getObject(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 62:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzH(i18, zzo(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 63:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzi(i18, zzo(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 64:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzw(i18, zzo(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzy(i18, zzt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 66:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzA(i18, zzo(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 67:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzC(i18, zzt(obj, j11));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                case 68:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzq(i18, unsafe.getObject(obj, j11), zzv(i17));
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
                default:
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    r92 = 1;
                    th2 = null;
                    i14 = 1048575;
            }
        }
        zzhd zzhdVar = this.zzm;
        zzhdVar.zzi(zzhdVar.zzd(obj), zzhvVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c0 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzj(java.lang.Object r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzj(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final boolean zzk(Object obj) {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i14 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i16 = iArr[i14];
            int i17 = iArr2[i16];
            int zzs = zzs(i16);
            int i18 = this.zzc[i16 + 2];
            int i19 = i18 & 1048575;
            int i20 = 1 << (i18 >>> 20);
            if (i19 != i15) {
                if (i19 != 1048575) {
                    i13 = zzb.getInt(obj, i19);
                }
                i12 = i13;
                i11 = i19;
            } else {
                i11 = i15;
                i12 = i13;
            }
            if ((268435456 & zzs) != 0 && !zzJ(obj, i16, i11, i12, i20)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i17, i16) && !zzK(obj, zzs, zzv(i16))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzfw) zzhn.zzf(obj, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzhn.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgm zzv = zzv(i16);
                    for (int i21 = 0; i21 < list.size(); i21++) {
                        if (!zzv.zzk(list.get(i21))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i16, i11, i12, i20) && !zzK(obj, zzs, zzv(i16))) {
                return false;
            }
            i14++;
            i15 = i11;
            i13 = i12;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        throw null;
    }
}
