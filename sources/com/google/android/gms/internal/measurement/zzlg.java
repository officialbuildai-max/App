package com.google.android.gms.internal.measurement;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mvel2.ast.ASTNode;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzlg<T> implements zzlu<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzml.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzlk zzn;
    private final zzkm zzo;
    private final zzmk<?, ?> zzp;
    private final zzji<?> zzq;
    private final zzkv zzr;

    private zzlg(int[] iArr, Object[] objArr, int i11, int i12, zzlc zzlcVar, boolean z10, int[] iArr2, int i13, int i14, zzlk zzlkVar, zzkm zzkmVar, zzmk<?, ?> zzmkVar, zzji<?> zzjiVar, zzkv zzkvVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzi = zzlcVar instanceof zzjt;
        this.zzh = zzjiVar != null && zzjiVar.zza(zzlcVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i13;
        this.zzm = i14;
        this.zzn = zzlkVar;
        this.zzo = zzkmVar;
        this.zzp = zzmkVar;
        this.zzq = zzjiVar;
        this.zzg = zzlcVar;
        this.zzr = zzkvVar;
    }

    private static <T> double zza(T t11, long j11) {
        return ((Double) zzml.zze(t11, j11)).doubleValue();
    }

    private final int zza(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zza(i11, 0);
    }

    private final int zza(int i11, int i12) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    private static int zza(byte[] bArr, int i11, int i12, zzms zzmsVar, Class<?> cls, zzij zzijVar) throws IOException {
        switch (zzlf.zza[zzmsVar.ordinal()]) {
            case 1:
                int zzd = zzig.zzd(bArr, i11, zzijVar);
                zzijVar.zzc = Boolean.valueOf(zzijVar.zzb != 0);
                return zzd;
            case 2:
                return zzig.zza(bArr, i11, zzijVar);
            case 3:
                zzijVar.zzc = Double.valueOf(zzig.zza(bArr, i11));
                return i11 + 8;
            case 4:
            case 5:
                zzijVar.zzc = Integer.valueOf(zzig.zzc(bArr, i11));
                return i11 + 4;
            case 6:
            case 7:
                zzijVar.zzc = Long.valueOf(zzig.zzd(bArr, i11));
                return i11 + 8;
            case 8:
                zzijVar.zzc = Float.valueOf(zzig.zzb(bArr, i11));
                return i11 + 4;
            case 9:
            case 10:
            case 11:
                int zzc = zzig.zzc(bArr, i11, zzijVar);
                zzijVar.zzc = Integer.valueOf(zzijVar.zza);
                return zzc;
            case 12:
            case 13:
                int zzd2 = zzig.zzd(bArr, i11, zzijVar);
                zzijVar.zzc = Long.valueOf(zzijVar.zzb);
                return zzd2;
            case 14:
                return zzig.zza(zzlq.zza().zza((Class) cls), bArr, i11, i12, zzijVar);
            case 15:
                int zzc2 = zzig.zzc(bArr, i11, zzijVar);
                zzijVar.zzc = Integer.valueOf(zziw.zza(zzijVar.zza));
                return zzc2;
            case 16:
                int zzd3 = zzig.zzd(bArr, i11, zzijVar);
                zzijVar.zzc = Long.valueOf(zziw.zza(zzijVar.zzb));
                return zzd3;
            case 17:
                return zzig.zzb(bArr, i11, zzijVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:113:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.android.gms.internal.measurement.zzlg<T> zza(java.lang.Class<T> r32, com.google.android.gms.internal.measurement.zzla r33, com.google.android.gms.internal.measurement.zzlk r34, com.google.android.gms.internal.measurement.zzkm r35, com.google.android.gms.internal.measurement.zzmk<?, ?> r36, com.google.android.gms.internal.measurement.zzji<?> r37, com.google.android.gms.internal.measurement.zzkv r38) {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzla, com.google.android.gms.internal.measurement.zzlk, com.google.android.gms.internal.measurement.zzkm, com.google.android.gms.internal.measurement.zzmk, com.google.android.gms.internal.measurement.zzji, com.google.android.gms.internal.measurement.zzkv):com.google.android.gms.internal.measurement.zzlg");
    }

    private final <K, V, UT, UB> UB zza(int i11, int i12, Map<K, V> map, zzjx zzjxVar, UB ub2, zzmk<UT, UB> zzmkVar, Object obj) {
        zzkt<?, ?> zza2 = this.zzr.zza(zzf(i11));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzjxVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = zzmkVar.zzc(obj);
                }
                zzit zzc = zzik.zzc(zzku.zza(zza2, next.getKey(), next.getValue()));
                try {
                    zzku.zza(zzc.zzb(), zza2, next.getKey(), next.getValue());
                    zzmkVar.zza((zzmk<UT, UB>) ub2, i12, zzc.zza());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return ub2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t11, int i11) {
        zzlu zze = zze(i11);
        long zzc = zzc(i11) & 1048575;
        if (!zzc((zzlg<T>) t11, i11)) {
            return zze.zza();
        }
        Object object = zzb.getObject(t11, zzc);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t11, int i11, int i12) {
        zzlu zze = zze(i12);
        if (!zzc((zzlg<T>) t11, i11, i12)) {
            return zze.zza();
        }
        Object object = zzb.getObject(t11, zzc(i12) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    private final <UT, UB> UB zza(Object obj, int i11, UB ub2, zzmk<UT, UB> zzmkVar, Object obj2) {
        zzjx zzd;
        int i12 = this.zzc[i11];
        Object zze = zzml.zze(obj, zzc(i11) & 1048575);
        return (zze == null || (zzd = zzd(i11)) == null) ? ub2 : (UB) zza(i11, i12, this.zzr.zze(zze), zzd, (zzjx) ub2, (zzmk<UT, zzjx>) zzmkVar, obj2);
    }

    private static Field zza(Class<?> cls, String str) {
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

    private static void zza(int i11, Object obj, zznb zznbVar) throws IOException {
        if (obj instanceof String) {
            zznbVar.zza(i11, (String) obj);
        } else {
            zznbVar.zza(i11, (zzik) obj);
        }
    }

    private static <UT, UB> void zza(zzmk<UT, UB> zzmkVar, T t11, zznb zznbVar) throws IOException {
        zzmkVar.zzb((zzmk<UT, UB>) zzmkVar.zzd(t11), zznbVar);
    }

    private final <K, V> void zza(zznb zznbVar, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            zznbVar.zza(i11, this.zzr.zza(zzf(i12)), this.zzr.zzd(obj));
        }
    }

    private final void zza(T t11, int i11, int i12, Object obj) {
        zzb.putObject(t11, zzc(i12) & 1048575, obj);
        zzb((zzlg<T>) t11, i11, i12);
    }

    private final void zza(Object obj, int i11, zzlr zzlrVar) throws IOException {
        if (zzg(i11)) {
            zzml.zza(obj, i11 & 1048575, zzlrVar.zzr());
        } else if (this.zzi) {
            zzml.zza(obj, i11 & 1048575, zzlrVar.zzq());
        } else {
            zzml.zza(obj, i11 & 1048575, zzlrVar.zzp());
        }
    }

    private final void zza(T t11, int i11, Object obj) {
        zzb.putObject(t11, zzc(i11) & 1048575, obj);
        zzb((zzlg<T>) t11, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t11, T t12, int i11) {
        if (zzc((zzlg<T>) t12, i11)) {
            long zzc = zzc(i11) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t12, zzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + String.valueOf(t12));
            }
            zzlu zze = zze(i11);
            if (!zzc((zzlg<T>) t11, i11)) {
                if (zzg(object)) {
                    Object zza2 = zze.zza();
                    zze.zza(zza2, object);
                    unsafe.putObject(t11, zzc, zza2);
                } else {
                    unsafe.putObject(t11, zzc, object);
                }
                zzb((zzlg<T>) t11, i11);
                return;
            }
            Object object2 = unsafe.getObject(t11, zzc);
            if (!zzg(object2)) {
                Object zza3 = zze.zza();
                zze.zza(zza3, object2);
                unsafe.putObject(t11, zzc, zza3);
                object2 = zza3;
            }
            zze.zza(object2, object);
        }
    }

    private final boolean zza(T t11, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzc((zzlg<T>) t11, i11) : (i13 & i14) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i11, zzlu zzluVar) {
        return zzluVar.zze(zzml.zze(obj, i11 & 1048575));
    }

    private static <T> float zzb(T t11, long j11) {
        return ((Float) zzml.zze(t11, j11)).floatValue();
    }

    private final int zzb(int i11) {
        return this.zzc[i11 + 2];
    }

    private final void zzb(T t11, int i11) {
        int zzb2 = zzb(i11);
        long j11 = 1048575 & zzb2;
        if (j11 == 1048575) {
            return;
        }
        zzml.zza((Object) t11, j11, (1 << (zzb2 >>> 20)) | zzml.zzc(t11, j11));
    }

    private final void zzb(T t11, int i11, int i12) {
        zzml.zza((Object) t11, zzb(i12) & 1048575, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t11, T t12, int i11) {
        int i12 = this.zzc[i11];
        if (zzc((zzlg<T>) t12, i12, i11)) {
            long zzc = zzc(i11) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t12, zzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + String.valueOf(t12));
            }
            zzlu zze = zze(i11);
            if (!zzc((zzlg<T>) t11, i12, i11)) {
                if (zzg(object)) {
                    Object zza2 = zze.zza();
                    zze.zza(zza2, object);
                    unsafe.putObject(t11, zzc, zza2);
                } else {
                    unsafe.putObject(t11, zzc, object);
                }
                zzb((zzlg<T>) t11, i12, i11);
                return;
            }
            Object object2 = unsafe.getObject(t11, zzc);
            if (!zzg(object2)) {
                Object zza3 = zze.zza();
                zze.zza(zza3, object2);
                unsafe.putObject(t11, zzc, zza3);
                object2 = zza3;
            }
            zze.zza(object2, object);
        }
    }

    private final int zzc(int i11) {
        return this.zzc[i11 + 1];
    }

    private static <T> int zzc(T t11, long j11) {
        return ((Integer) zzml.zze(t11, j11)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmj zzc(Object obj) {
        zzjt zzjtVar = (zzjt) obj;
        zzmj zzmjVar = zzjtVar.zzb;
        if (zzmjVar != zzmj.zzc()) {
            return zzmjVar;
        }
        zzmj zzd = zzmj.zzd();
        zzjtVar.zzb = zzd;
        return zzd;
    }

    private final boolean zzc(T t11, int i11) {
        int zzb2 = zzb(i11);
        long j11 = zzb2 & 1048575;
        if (j11 != 1048575) {
            return (zzml.zzc(t11, j11) & (1 << (zzb2 >>> 20))) != 0;
        }
        int zzc = zzc(i11);
        long j12 = zzc & 1048575;
        switch ((zzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzml.zza(t11, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzml.zzb(t11, j12)) != 0;
            case 2:
                return zzml.zzd(t11, j12) != 0;
            case 3:
                return zzml.zzd(t11, j12) != 0;
            case 4:
                return zzml.zzc(t11, j12) != 0;
            case 5:
                return zzml.zzd(t11, j12) != 0;
            case 6:
                return zzml.zzc(t11, j12) != 0;
            case 7:
                return zzml.zzh(t11, j12);
            case 8:
                Object zze = zzml.zze(t11, j12);
                if (zze instanceof String) {
                    return !((String) zze).isEmpty();
                }
                if (zze instanceof zzik) {
                    return !zzik.zza.equals(zze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzml.zze(t11, j12) != null;
            case 10:
                return !zzik.zza.equals(zzml.zze(t11, j12));
            case 11:
                return zzml.zzc(t11, j12) != 0;
            case 12:
                return zzml.zzc(t11, j12) != 0;
            case 13:
                return zzml.zzc(t11, j12) != 0;
            case 14:
                return zzml.zzd(t11, j12) != 0;
            case 15:
                return zzml.zzc(t11, j12) != 0;
            case 16:
                return zzml.zzd(t11, j12) != 0;
            case 17:
                return zzml.zze(t11, j12) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzc(T t11, int i11, int i12) {
        return zzml.zzc(t11, (long) (zzb(i12) & 1048575)) == i11;
    }

    private final boolean zzc(T t11, T t12, int i11) {
        return zzc((zzlg<T>) t11, i11) == zzc((zzlg<T>) t12, i11);
    }

    private static <T> long zzd(T t11, long j11) {
        return ((Long) zzml.zze(t11, j11)).longValue();
    }

    private final zzjx zzd(int i11) {
        return (zzjx) this.zzd[((i11 / 3) << 1) + 1];
    }

    private final zzlu zze(int i11) {
        int i12 = (i11 / 3) << 1;
        zzlu zzluVar = (zzlu) this.zzd[i12];
        if (zzluVar != null) {
            return zzluVar;
        }
        zzlu<T> zza2 = zzlq.zza().zza((Class) this.zzd[i12 + 1]);
        this.zzd[i12] = zza2;
        return zza2;
    }

    private static <T> boolean zze(T t11, long j11) {
        return ((Boolean) zzml.zze(t11, j11)).booleanValue();
    }

    private final Object zzf(int i11) {
        return this.zzd[(i11 / 3) << 1];
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    private static boolean zzg(int i11) {
        return (i11 & ASTNode.DISCARD) != 0;
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzjt) {
            return ((zzjt) obj).zzco();
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0058. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzlu
    public final int zza(T t11) {
        int i11;
        int i12;
        int i13;
        int zza2;
        int zzb2;
        int zzh;
        boolean z10;
        int zzc;
        int zzd;
        int zzi;
        int zzj;
        Unsafe unsafe = zzb;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < this.zzc.length) {
            int zzc2 = zzc(i17);
            int i19 = (267386880 & zzc2) >>> 20;
            int[] iArr = this.zzc;
            int i20 = iArr[i17];
            int i21 = iArr[i17 + 2];
            int i22 = i21 & i14;
            if (i19 <= 17) {
                if (i22 != i15) {
                    i16 = i22 == i14 ? 0 : unsafe.getInt(t11, i22);
                    i15 = i22;
                }
                i11 = i15;
                i12 = i16;
                i13 = 1 << (i21 >>> 20);
            } else {
                i11 = i15;
                i12 = i16;
                i13 = 0;
            }
            long j11 = zzc2 & i14;
            if (i19 >= zzjn.zza.zza()) {
                zzjn.zzb.zza();
            }
            switch (i19) {
                case 0:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zza2 = zzjc.zza(i20, 0.0d);
                        i18 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zza2 = zzjc.zza(i20, 0.0f);
                        i18 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zza2 = zzjc.zzd(i20, unsafe.getLong(t11, j11));
                        i18 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zza2 = zzjc.zzg(i20, unsafe.getLong(t11, j11));
                        i18 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zza2 = zzjc.zzg(i20, unsafe.getInt(t11, j11));
                        i18 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zza2 = zzjc.zzc(i20, 0L);
                        i18 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zza2 = zzjc.zzf(i20, 0);
                        i18 += zza2;
                        break;
                    }
                    break;
                case 7:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzjc.zzb(i20, true);
                        i18 += zzb2;
                    }
                    break;
                case 8:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        Object object = unsafe.getObject(t11, j11);
                        zzb2 = object instanceof zzik ? zzjc.zzc(i20, (zzik) object) : zzjc.zzb(i20, (String) object);
                        i18 += zzb2;
                    }
                    break;
                case 9:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzlw.zza(i20, unsafe.getObject(t11, j11), (zzlu<?>) zze(i17));
                        i18 += zzb2;
                    }
                    break;
                case 10:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzjc.zzc(i20, (zzik) unsafe.getObject(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 11:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzjc.zzj(i20, unsafe.getInt(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 12:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzjc.zze(i20, unsafe.getInt(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 13:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzh = zzjc.zzh(i20, 0);
                        i18 += zzh;
                    }
                    break;
                case 14:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzjc.zze(i20, 0L);
                        i18 += zzb2;
                    }
                    break;
                case 15:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzjc.zzi(i20, unsafe.getInt(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 16:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzjc.zzf(i20, unsafe.getLong(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 17:
                    if (zza((zzlg<T>) t11, i17, i11, i12, i13)) {
                        zzb2 = zzjc.zzb(i20, (zzlc) unsafe.getObject(t11, j11), zze(i17));
                        i18 += zzb2;
                    }
                    break;
                case 18:
                    zzb2 = zzlw.zzd(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzb2;
                    break;
                case 19:
                    z10 = false;
                    zzc = zzlw.zzc(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 20:
                    z10 = false;
                    zzc = zzlw.zzf(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 21:
                    z10 = false;
                    zzc = zzlw.zzj(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 22:
                    z10 = false;
                    zzc = zzlw.zze(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 23:
                    z10 = false;
                    zzc = zzlw.zzd(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 24:
                    z10 = false;
                    zzc = zzlw.zzc(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 25:
                    z10 = false;
                    zzc = zzlw.zza(i20, (List<?>) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 26:
                    zzb2 = zzlw.zzb(i20, (List) unsafe.getObject(t11, j11));
                    i18 += zzb2;
                    break;
                case 27:
                    zzb2 = zzlw.zzb(i20, (List<?>) unsafe.getObject(t11, j11), (zzlu<?>) zze(i17));
                    i18 += zzb2;
                    break;
                case 28:
                    zzb2 = zzlw.zza(i20, (List<zzik>) unsafe.getObject(t11, j11));
                    i18 += zzb2;
                    break;
                case NOTIFICATION_REDIRECT_VALUE:
                    zzb2 = zzlw.zzi(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzb2;
                    break;
                case 30:
                    z10 = false;
                    zzc = zzlw.zzb(i20, (List<Integer>) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case TEMPLATE_HTML_SIZE_VALUE:
                    z10 = false;
                    zzc = zzlw.zzc(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 32:
                    z10 = false;
                    zzc = zzlw.zzd(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 33:
                    z10 = false;
                    zzc = zzlw.zzg(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 34:
                    z10 = false;
                    zzc = zzlw.zzh(i20, (List) unsafe.getObject(t11, j11), false);
                    i18 += zzc;
                    break;
                case 35:
                    zzd = zzlw.zzd((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 36:
                    zzd = zzlw.zzc((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 37:
                    zzd = zzlw.zzf((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 38:
                    zzd = zzlw.zzj((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 39:
                    zzd = zzlw.zze((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 40:
                    zzd = zzlw.zzd((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 41:
                    zzd = zzlw.zzc((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 42:
                    zzd = zzlw.zza((List<?>) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 43:
                    zzd = zzlw.zzi((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 44:
                    zzd = zzlw.zzb((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 45:
                    zzd = zzlw.zzc((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 46:
                    zzd = zzlw.zzd((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case 47:
                    zzd = zzlw.zzg((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    zzd = zzlw.zzh((List) unsafe.getObject(t11, j11));
                    if (zzd > 0) {
                        zzi = zzjc.zzi(i20);
                        zzj = zzjc.zzj(zzd);
                        zzh = zzi + zzj + zzd;
                        i18 += zzh;
                    }
                    break;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    zzb2 = zzlw.zza(i20, (List<zzlc>) unsafe.getObject(t11, j11), (zzlu<?>) zze(i17));
                    i18 += zzb2;
                    break;
                case 50:
                    zzb2 = this.zzr.zza(i20, unsafe.getObject(t11, j11), zzf(i17));
                    i18 += zzb2;
                    break;
                case AD_REWARD_USER_VALUE:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zza(i20, 0.0d);
                        i18 += zzb2;
                    }
                    break;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zza(i20, 0.0f);
                        i18 += zzb2;
                    }
                    break;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzd(i20, zzd(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzg(i20, zzd(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzg(i20, zzc(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case AD_VISIBILITY_VALUE:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzc(i20, 0L);
                        i18 += zzb2;
                    }
                    break;
                case 57:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzh = zzjc.zzf(i20, 0);
                        i18 += zzh;
                    }
                    break;
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzb(i20, true);
                        i18 += zzb2;
                    }
                    break;
                case 59:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        Object object2 = unsafe.getObject(t11, j11);
                        zzb2 = object2 instanceof zzik ? zzjc.zzc(i20, (zzik) object2) : zzjc.zzb(i20, (String) object2);
                        i18 += zzb2;
                    }
                    break;
                case 60:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzlw.zza(i20, unsafe.getObject(t11, j11), (zzlu<?>) zze(i17));
                        i18 += zzb2;
                    }
                    break;
                case 61:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzc(i20, (zzik) unsafe.getObject(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 62:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzj(i20, zzc(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 63:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zze(i20, zzc(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 64:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzh = zzjc.zzh(i20, 0);
                        i18 += zzh;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zze(i20, 0L);
                        i18 += zzb2;
                    }
                    break;
                case 66:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzi(i20, zzc(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 67:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzf(i20, zzd(t11, j11));
                        i18 += zzb2;
                    }
                    break;
                case 68:
                    if (zzc((zzlg<T>) t11, i20, i17)) {
                        zzb2 = zzjc.zzb(i20, (zzlc) unsafe.getObject(t11, j11), zze(i17));
                        i18 += zzb2;
                    }
                    break;
            }
            i17 += 3;
            i15 = i11;
            i16 = i12;
            i14 = 1048575;
        }
        int i23 = 0;
        zzmk<?, ?> zzmkVar = this.zzp;
        int zza3 = i18 + zzmkVar.zza((zzmk<?, ?>) zzmkVar.zzd(t11));
        if (!this.zzh) {
            return zza3;
        }
        zzjm<?> zza4 = this.zzq.zza(t11);
        int zza5 = zza4.zza.zza();
        for (int i24 = 0; i24 < zza5; i24++) {
            Map.Entry<?, Object> zza6 = zza4.zza.zza(i24);
            i23 += zzjm.zza((zzjo<?>) zza6.getKey(), zza6.getValue());
        }
        for (Map.Entry<?, Object> entry : zza4.zza.zzb()) {
            i23 += zzjm.zza((zzjo<?>) entry.getKey(), entry.getValue());
        }
        return zza3 + i23;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x09fc, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkb.zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0d2a, code lost:
    
        if (r13 == r11) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0d2c, code lost:
    
        r30.putInt(r15, r13, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0d32, code lost:
    
        r11 = r7.zzl;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0d39, code lost:
    
        if (r11 >= r7.zzm) goto L651;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0d3b, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzmj) zza((java.lang.Object) r35, r7.zzk[r11], (int) r3, (com.google.android.gms.internal.measurement.zzmk<UT, int>) r7.zzp, (java.lang.Object) r35);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0d51, code lost:
    
        if (r3 == null) goto L532;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0d53, code lost:
    
        r7.zzp.zzb((java.lang.Object) r15, (T) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0d58, code lost:
    
        if (r10 != 0) goto L537;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0d5a, code lost:
    
        if (r6 != r8) goto L535;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0d61, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkb.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0d66, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0d62, code lost:
    
        if (r6 > r8) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0d64, code lost:
    
        if (r9 != r10) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0d6b, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkb.zzg();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:203:0x039c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0a1c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:565:0x00a8. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x08c7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x08b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0d03 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x08c4 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v56, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(T r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.measurement.zzij r40) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzij):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x00c0. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0630 A[Catch: all -> 0x00cb, TryCatch #7 {all -> 0x00cb, blocks: (B:51:0x00c5, B:14:0x00d3, B:33:0x062b, B:35:0x0630, B:36:0x0635, B:88:0x00ff, B:91:0x0114, B:93:0x0125, B:95:0x0136, B:97:0x0147, B:99:0x0158, B:101:0x0162, B:104:0x0169, B:105:0x016e, B:107:0x017b, B:109:0x018c, B:111:0x019a, B:113:0x01ac, B:115:0x01b4, B:117:0x01c6, B:119:0x01d8, B:121:0x01ea, B:123:0x01fc, B:125:0x020e, B:127:0x0220, B:129:0x0232, B:131:0x0244, B:133:0x0254, B:134:0x0275, B:135:0x025e, B:137:0x0266, B:139:0x0286, B:141:0x0298, B:143:0x02a6, B:145:0x02b4, B:147:0x02c2), top: B:50:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x063b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0665 A[LOOP:3: B:58:0x0661->B:60:0x0665, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0679  */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzlr] */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r18, com.google.android.gms.internal.measurement.zzlr r19, com.google.android.gms.internal.measurement.zzjg r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlr, com.google.android.gms.internal.measurement.zzjg):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:320:0x05b5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0b90  */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r24, com.google.android.gms.internal.measurement.zznb r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zza(java.lang.Object, com.google.android.gms.internal.measurement.zznb):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zza(T t11, T t12) {
        zzf(t11);
        t12.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzc = zzc(i11);
            long j11 = 1048575 & zzc;
            int i12 = this.zzc[i11];
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza(t11, j11, zzml.zza(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzb(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzd(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzd(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzc(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzd(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzc(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zzc(t11, j11, zzml.zzh(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza(t11, j11, zzml.zze(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t11, t12, i11);
                    break;
                case 10:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza(t11, j11, zzml.zze(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzc(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzc(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzc(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzd(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzc(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzlg<T>) t12, i11)) {
                        zzml.zza((Object) t11, j11, zzml.zzd(t12, j11));
                        zzb((zzlg<T>) t11, i11);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t11, t12, i11);
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
                    this.zzo.zza(t11, t12, j11);
                    break;
                case 50:
                    zzlw.zza(this.zzr, t11, t12, j11);
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
                    if (zzc((zzlg<T>) t12, i12, i11)) {
                        zzml.zza(t11, j11, zzml.zze(t12, j11));
                        zzb((zzlg<T>) t11, i12, i11);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t11, t12, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzc((zzlg<T>) t12, i12, i11)) {
                        zzml.zza(t11, j11, zzml.zze(t12, j11));
                        zzb((zzlg<T>) t11, i12, i11);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t11, t12, i11);
                    break;
            }
        }
        zzlw.zza(this.zzp, t11, t12);
        if (this.zzh) {
            zzlw.zza(this.zzq, t11, t12);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zza(T t11, byte[] bArr, int i11, int i12, zzij zzijVar) throws IOException {
        zza((zzlg<T>) t11, bArr, i11, i12, 0, zzijVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzlu
    public final int zzb(T t11) {
        int i11;
        int zza2;
        int length = this.zzc.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int zzc = zzc(i13);
            int i14 = this.zzc[i13];
            long j11 = 1048575 & zzc;
            int i15 = 37;
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    i11 = i12 * 53;
                    zza2 = zzjv.zza(Double.doubleToLongBits(zzml.zza(t11, j11)));
                    i12 = i11 + zza2;
                    break;
                case 1:
                    i11 = i12 * 53;
                    zza2 = Float.floatToIntBits(zzml.zzb(t11, j11));
                    i12 = i11 + zza2;
                    break;
                case 2:
                    i11 = i12 * 53;
                    zza2 = zzjv.zza(zzml.zzd(t11, j11));
                    i12 = i11 + zza2;
                    break;
                case 3:
                    i11 = i12 * 53;
                    zza2 = zzjv.zza(zzml.zzd(t11, j11));
                    i12 = i11 + zza2;
                    break;
                case 4:
                    i11 = i12 * 53;
                    zza2 = zzml.zzc(t11, j11);
                    i12 = i11 + zza2;
                    break;
                case 5:
                    i11 = i12 * 53;
                    zza2 = zzjv.zza(zzml.zzd(t11, j11));
                    i12 = i11 + zza2;
                    break;
                case 6:
                    i11 = i12 * 53;
                    zza2 = zzml.zzc(t11, j11);
                    i12 = i11 + zza2;
                    break;
                case 7:
                    i11 = i12 * 53;
                    zza2 = zzjv.zza(zzml.zzh(t11, j11));
                    i12 = i11 + zza2;
                    break;
                case 8:
                    i11 = i12 * 53;
                    zza2 = ((String) zzml.zze(t11, j11)).hashCode();
                    i12 = i11 + zza2;
                    break;
                case 9:
                    Object zze = zzml.zze(t11, j11);
                    if (zze != null) {
                        i15 = zze.hashCode();
                    }
                    i12 = (i12 * 53) + i15;
                    break;
                case 10:
                    i11 = i12 * 53;
                    zza2 = zzml.zze(t11, j11).hashCode();
                    i12 = i11 + zza2;
                    break;
                case 11:
                    i11 = i12 * 53;
                    zza2 = zzml.zzc(t11, j11);
                    i12 = i11 + zza2;
                    break;
                case 12:
                    i11 = i12 * 53;
                    zza2 = zzml.zzc(t11, j11);
                    i12 = i11 + zza2;
                    break;
                case 13:
                    i11 = i12 * 53;
                    zza2 = zzml.zzc(t11, j11);
                    i12 = i11 + zza2;
                    break;
                case 14:
                    i11 = i12 * 53;
                    zza2 = zzjv.zza(zzml.zzd(t11, j11));
                    i12 = i11 + zza2;
                    break;
                case 15:
                    i11 = i12 * 53;
                    zza2 = zzml.zzc(t11, j11);
                    i12 = i11 + zza2;
                    break;
                case 16:
                    i11 = i12 * 53;
                    zza2 = zzjv.zza(zzml.zzd(t11, j11));
                    i12 = i11 + zza2;
                    break;
                case 17:
                    Object zze2 = zzml.zze(t11, j11);
                    if (zze2 != null) {
                        i15 = zze2.hashCode();
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
                    zza2 = zzml.zze(t11, j11).hashCode();
                    i12 = i11 + zza2;
                    break;
                case 50:
                    i11 = i12 * 53;
                    zza2 = zzml.zze(t11, j11).hashCode();
                    i12 = i11 + zza2;
                    break;
                case AD_REWARD_USER_VALUE:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzjv.zza(Double.doubleToLongBits(zza(t11, j11)));
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = Float.floatToIntBits(zzb(t11, j11));
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzjv.zza(zzd(t11, j11));
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzjv.zza(zzd(t11, j11));
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzc(t11, j11);
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case AD_VISIBILITY_VALUE:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzjv.zza(zzd(t11, j11));
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzc(t11, j11);
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzjv.zza(zze(t11, j11));
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = ((String) zzml.zze(t11, j11)).hashCode();
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzml.zze(t11, j11).hashCode();
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzml.zze(t11, j11).hashCode();
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzc(t11, j11);
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzc(t11, j11);
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzc(t11, j11);
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzjv.zza(zzd(t11, j11));
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzc(t11, j11);
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzjv.zza(zzd(t11, j11));
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzlg<T>) t11, i14, i13)) {
                        i11 = i12 * 53;
                        zza2 = zzml.zze(t11, j11).hashCode();
                        i12 = i11 + zza2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i12 * 53) + this.zzp.zzd(t11).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzq.zza(t11).hashCode() : hashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        if (com.google.android.gms.internal.measurement.zzlw.zza(com.google.android.gms.internal.measurement.zzml.zze(r10, r6), com.google.android.gms.internal.measurement.zzml.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b3, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d6, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ec, code lost:
    
        if (com.google.android.gms.internal.measurement.zzlw.zza(com.google.android.gms.internal.measurement.zzml.zze(r10, r6), com.google.android.gms.internal.measurement.zzml.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0102, code lost:
    
        if (com.google.android.gms.internal.measurement.zzlw.zza(com.google.android.gms.internal.measurement.zzml.zze(r10, r6), com.google.android.gms.internal.measurement.zzml.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0118, code lost:
    
        if (com.google.android.gms.internal.measurement.zzlw.zza(com.google.android.gms.internal.measurement.zzml.zze(r10, r6), com.google.android.gms.internal.measurement.zzml.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzh(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzh(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x013c, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0150, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0162, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzc(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0176, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018a, code lost:
    
        if (com.google.android.gms.internal.measurement.zzml.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzml.zzd(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzml.zzb(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzml.zzb(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c0, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzml.zza(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzml.zza(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.measurement.zzlw.zza(com.google.android.gms.internal.measurement.zzml.zze(r10, r6), com.google.android.gms.internal.measurement.zzml.zze(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0017. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zzd(T t11) {
        if (zzg(t11)) {
            if (t11 instanceof zzjt) {
                zzjt zzjtVar = (zzjt) t11;
                zzjtVar.zzc(Integer.MAX_VALUE);
                zzjtVar.zza = 0;
                zzjtVar.zzcm();
            }
            int length = this.zzc.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int zzc = zzc(i11);
                long j11 = 1048575 & zzc;
                int i12 = (zzc & 267386880) >>> 20;
                if (i12 != 9) {
                    if (i12 != 60 && i12 != 68) {
                        switch (i12) {
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
                                this.zzo.zzb(t11, j11);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t11, j11);
                                if (object != null) {
                                    unsafe.putObject(t11, j11, this.zzr.zzc(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzc((zzlg<T>) t11, this.zzc[i11], i11)) {
                        zze(i11).zzd(zzb.getObject(t11, j11));
                    }
                }
                if (zzc((zzlg<T>) t11, i11)) {
                    zze(i11).zzd(zzb.getObject(t11, j11));
                }
            }
            this.zzp.zzf(t11);
            if (this.zzh) {
                this.zzq.zzc(t11);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzlu] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzlu] */
    @Override // com.google.android.gms.internal.measurement.zzlu
    public final boolean zze(T t11) {
        int i11;
        int i12;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.zzl) {
            int i16 = this.zzk[i15];
            int i17 = this.zzc[i16];
            int zzc = zzc(i16);
            int i18 = this.zzc[i16 + 2];
            int i19 = i18 & 1048575;
            int i20 = 1 << (i18 >>> 20);
            if (i19 != i13) {
                if (i19 != 1048575) {
                    i14 = zzb.getInt(t11, i19);
                }
                i12 = i14;
                i11 = i19;
            } else {
                i11 = i13;
                i12 = i14;
            }
            if ((268435456 & zzc) != 0 && !zza((zzlg<T>) t11, i16, i11, i12, i20)) {
                return false;
            }
            int i21 = (267386880 & zzc) >>> 20;
            if (i21 != 9 && i21 != 17) {
                if (i21 != 27) {
                    if (i21 == 60 || i21 == 68) {
                        if (zzc((zzlg<T>) t11, i17, i16) && !zza((Object) t11, zzc, zze(i16))) {
                            return false;
                        }
                    } else if (i21 != 49) {
                        if (i21 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzd = this.zzr.zzd(zzml.zze(t11, zzc & 1048575));
                            if (zzd.isEmpty()) {
                                continue;
                            } else if (this.zzr.zza(zzf(i16)).zzc.zzb() == zzmz.MESSAGE) {
                                ?? r12 = 0;
                                for (Object obj : zzd.values()) {
                                    r12 = r12;
                                    if (r12 == 0) {
                                        r12 = zzlq.zza().zza((Class) obj.getClass());
                                    }
                                    if (!r12.zze(obj)) {
                                        return false;
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                List list = (List) zzml.zze(t11, zzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ?? zze = zze(i16);
                    for (int i22 = 0; i22 < list.size(); i22++) {
                        if (!zze.zze(list.get(i22))) {
                            return false;
                        }
                    }
                }
            } else if (zza((zzlg<T>) t11, i16, i11, i12, i20) && !zza((Object) t11, zzc, zze(i16))) {
                return false;
            }
            i15++;
            i13 = i11;
            i14 = i12;
        }
        return !this.zzh || this.zzq.zza(t11).zzg();
    }
}
