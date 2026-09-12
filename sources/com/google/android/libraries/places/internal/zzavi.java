package com.google.android.libraries.places.internal;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mvel2.ast.ASTNode;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzavi<T> implements zzavt<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzawx.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzavf zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzaut zzm;
    private final zzawn zzn;
    private final zzatg zzo;
    private final zzavl zzp;
    private final zzava zzq;

    private zzavi(int[] iArr, Object[] objArr, int i11, int i12, zzavf zzavfVar, int i13, boolean z10, int[] iArr2, int i14, int i15, zzavl zzavlVar, zzaut zzautVar, zzawn zzawnVar, zzatg zzatgVar, zzava zzavaVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzi = zzavfVar instanceof zzatu;
        boolean z11 = false;
        if (zzatgVar != null && zzatgVar.zzi(zzavfVar)) {
            z11 = true;
        }
        this.zzh = z11;
        this.zzj = iArr2;
        this.zzk = i14;
        this.zzl = i15;
        this.zzp = zzavlVar;
        this.zzm = zzautVar;
        this.zzn = zzawnVar;
        this.zzo = zzatgVar;
        this.zzg = zzavfVar;
        this.zzq = zzavaVar;
    }

    private final void zzA(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzM(obj2, i12, i11)) {
            int zzp = zzp(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = zzp;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzavt zzs = zzs(i11);
            if (!zzM(obj, i12, i11)) {
                if (zzL(object)) {
                    Object zzc = zzs.zzc();
                    zzs.zze(zzc, object);
                    unsafe.putObject(obj, j11, zzc);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzD(obj, i12, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzL(object2)) {
                Object zzc2 = zzs.zzc();
                zzs.zze(zzc2, object2);
                unsafe.putObject(obj, j11, zzc2);
                object2 = zzc2;
            }
            zzs.zze(object2, object);
        }
    }

    private final void zzB(Object obj, int i11, zzavs zzavsVar) throws IOException {
        long j11 = i11 & 1048575;
        if (zzH(i11)) {
            zzawx.zzs(obj, j11, zzavsVar.zzs());
        } else if (this.zzi) {
            zzawx.zzs(obj, j11, zzavsVar.zzr());
        } else {
            zzawx.zzs(obj, j11, zzavsVar.zzp());
        }
    }

    private final void zzC(Object obj, int i11) {
        int zzn = zzn(i11);
        long j11 = 1048575 & zzn;
        if (j11 == 1048575) {
            return;
        }
        zzawx.zzq(obj, j11, (1 << (zzn >>> 20)) | zzawx.zzc(obj, j11));
    }

    private final void zzD(Object obj, int i11, int i12) {
        zzawx.zzq(obj, zzn(i12) & 1048575, i11);
    }

    private final void zzE(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, zzp(i11) & 1048575, obj2);
        zzC(obj, i11);
    }

    private final void zzF(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, zzp(i12) & 1048575, obj2);
        zzD(obj, i11, i12);
    }

    private final boolean zzG(Object obj, Object obj2, int i11) {
        return zzI(obj, i11) == zzI(obj2, i11);
    }

    private static boolean zzH(int i11) {
        return (i11 & ASTNode.DISCARD) != 0;
    }

    private final boolean zzI(Object obj, int i11) {
        int zzn = zzn(i11);
        long j11 = zzn & 1048575;
        if (j11 != 1048575) {
            return (zzawx.zzc(obj, j11) & (1 << (zzn >>> 20))) != 0;
        }
        int zzp = zzp(i11);
        long j12 = zzp & 1048575;
        switch (zzo(zzp)) {
            case 0:
                return Double.doubleToRawLongBits(zzawx.zza(obj, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzawx.zzb(obj, j12)) != 0;
            case 2:
                return zzawx.zzd(obj, j12) != 0;
            case 3:
                return zzawx.zzd(obj, j12) != 0;
            case 4:
                return zzawx.zzc(obj, j12) != 0;
            case 5:
                return zzawx.zzd(obj, j12) != 0;
            case 6:
                return zzawx.zzc(obj, j12) != 0;
            case 7:
                return zzawx.zzw(obj, j12);
            case 8:
                Object zzf = zzawx.zzf(obj, j12);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzask) {
                    return !zzask.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzawx.zzf(obj, j12) != null;
            case 10:
                return !zzask.zzb.equals(zzawx.zzf(obj, j12));
            case 11:
                return zzawx.zzc(obj, j12) != 0;
            case 12:
                return zzawx.zzc(obj, j12) != 0;
            case 13:
                return zzawx.zzc(obj, j12) != 0;
            case 14:
                return zzawx.zzd(obj, j12) != 0;
            case 15:
                return zzawx.zzc(obj, j12) != 0;
            case 16:
                return zzawx.zzd(obj, j12) != 0;
            case 17:
                return zzawx.zzf(obj, j12) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzI(obj, i11) : (i13 & i14) != 0;
    }

    private static boolean zzK(Object obj, int i11, zzavt zzavtVar) {
        return zzavtVar.zzh(zzawx.zzf(obj, i11 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzatu) {
            return ((zzatu) obj).zzaH();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i11, int i12) {
        return zzawx.zzc(obj, (long) (zzn(i12) & 1048575)) == i11;
    }

    private static boolean zzN(Object obj, long j11) {
        return ((Boolean) zzawx.zzf(obj, j11)).booleanValue();
    }

    private static final void zzO(int i11, Object obj, zzasy zzasyVar) throws IOException {
        if (obj instanceof String) {
            zzasyVar.zzG(i11, (String) obj);
        } else {
            zzasyVar.zzd(i11, (zzask) obj);
        }
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
    public static com.google.android.libraries.places.internal.zzavi zzi(java.lang.Class r33, com.google.android.libraries.places.internal.zzavc r34, com.google.android.libraries.places.internal.zzavl r35, com.google.android.libraries.places.internal.zzaut r36, com.google.android.libraries.places.internal.zzawn r37, com.google.android.libraries.places.internal.zzatg r38, com.google.android.libraries.places.internal.zzava r39) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzavi.zzi(java.lang.Class, com.google.android.libraries.places.internal.zzavc, com.google.android.libraries.places.internal.zzavl, com.google.android.libraries.places.internal.zzaut, com.google.android.libraries.places.internal.zzawn, com.google.android.libraries.places.internal.zzatg, com.google.android.libraries.places.internal.zzava):com.google.android.libraries.places.internal.zzavi");
    }

    private static double zzk(Object obj, long j11) {
        return ((Double) zzawx.zzf(obj, j11)).doubleValue();
    }

    private static float zzl(Object obj, long j11) {
        return ((Float) zzawx.zzf(obj, j11)).floatValue();
    }

    private static int zzm(Object obj, long j11) {
        return ((Integer) zzawx.zzf(obj, j11)).intValue();
    }

    private final int zzn(int i11) {
        return this.zzc[i11 + 2];
    }

    private static int zzo(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzp(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzq(Object obj, long j11) {
        return ((Long) zzawx.zzf(obj, j11)).longValue();
    }

    private final zzaty zzr(int i11) {
        int i12 = i11 / 3;
        return (zzaty) this.zzd[i12 + i12 + 1];
    }

    private final zzavt zzs(int i11) {
        Object[] objArr = this.zzd;
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzavt zzavtVar = (zzavt) objArr[i13];
        if (zzavtVar != null) {
            return zzavtVar;
        }
        zzavt zzb2 = zzavp.zza().zzb((Class) objArr[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final Object zzt(Object obj, int i11, Object obj2, zzawn zzawnVar, Object obj3) {
        int i12 = this.zzc[i11];
        Object zzf = zzawx.zzf(obj, zzp(i11) & 1048575);
        if (zzf == null || zzr(i11) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzu(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private final Object zzv(Object obj, int i11) {
        zzavt zzs = zzs(i11);
        int zzp = zzp(i11) & 1048575;
        if (!zzI(obj, i11)) {
            return zzs.zzc();
        }
        Object object = zzb.getObject(obj, zzp);
        if (zzL(object)) {
            return object;
        }
        Object zzc = zzs.zzc();
        if (object != null) {
            zzs.zze(zzc, object);
        }
        return zzc;
    }

    private final Object zzw(Object obj, int i11, int i12) {
        zzavt zzs = zzs(i12);
        if (!zzM(obj, i11, i12)) {
            return zzs.zzc();
        }
        Object object = zzb.getObject(obj, zzp(i12) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zzc = zzs.zzc();
        if (object != null) {
            zzs.zze(zzc, object);
        }
        return zzc;
    }

    private static Field zzx(Class cls, String str) {
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

    private static void zzy(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzz(Object obj, Object obj2, int i11) {
        if (zzI(obj2, i11)) {
            int zzp = zzp(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = zzp;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzavt zzs = zzs(i11);
            if (!zzI(obj, i11)) {
                if (zzL(object)) {
                    Object zzc = zzs.zzc();
                    zzs.zze(zzc, object);
                    unsafe.putObject(obj, j11, zzc);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzC(obj, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzL(object2)) {
                Object zzc2 = zzs.zzc();
                zzs.zze(zzc2, object2);
                unsafe.putObject(obj, j11, zzc2);
                object2 = zzc2;
            }
            zzs.zze(object2, object);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0056. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v112, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [com.google.android.libraries.places.internal.zzaun] */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v117, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v134 */
    /* JADX WARN: Type inference failed for: r0v182, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v253, types: [int] */
    /* JADX WARN: Type inference failed for: r0v260, types: [int] */
    /* JADX WARN: Type inference failed for: r0v262 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v126, types: [int] */
    /* JADX WARN: Type inference failed for: r1v172 */
    /* JADX WARN: Type inference failed for: r1v173 */
    /* JADX WARN: Type inference failed for: r1v83, types: [int] */
    /* JADX WARN: Type inference failed for: r1v85 */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [int] */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.libraries.places.internal.zzavt
    public final int zza(Object obj) {
        int i11;
        boolean z10;
        ?? r52;
        int zzB;
        int zzB2;
        int zzB3;
        int zzC;
        int zzB4;
        int zzB5;
        int zzd;
        int zzB6;
        ?? zzg;
        int size;
        int zzB7;
        int zzA;
        int zzA2;
        ?? r32;
        int zzz;
        ?? r12;
        ?? r02;
        int zze;
        int zzB8;
        int zzB9;
        ?? r42;
        Unsafe unsafe = zzb;
        boolean z11 = false;
        int i12 = 1048575;
        boolean z12 = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i13 < this.zzc.length) {
            int zzp = zzp(i13);
            int zzo = zzo(zzp);
            int[] iArr = this.zzc;
            int i16 = iArr[i13];
            int i17 = iArr[i13 + 2];
            int i18 = i17 & i12;
            if (zzo <= 17) {
                if (i18 != i15) {
                    z12 = i18 == i12 ? z11 : unsafe.getInt(obj, i18);
                    i15 = i18;
                }
                i11 = i15;
                z10 = z12;
                r52 = 1 << (i17 >>> 20);
            } else {
                i11 = i15;
                z10 = z12;
                r52 = z11;
            }
            int i19 = zzp & i12;
            if (zzo >= zzatl.zzJ.zza()) {
                zzatl.zzW.zza();
            }
            long j11 = i19;
            switch (zzo) {
                case 0:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        zzB = zzasx.zzB(i16 << 3);
                        r02 = zzB + 8;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 1:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        zzB2 = zzasx.zzB(i16 << 3);
                        r02 = zzB2 + 4;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 2:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        long j12 = unsafe.getLong(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC(j12);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 3:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        long j13 = unsafe.getLong(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC(j13);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 4:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        long j14 = unsafe.getInt(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC(j14);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 5:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        zzB = zzasx.zzB(i16 << 3);
                        r02 = zzB + 8;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 6:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        zzB2 = zzasx.zzB(i16 << 3);
                        r02 = zzB2 + 4;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 7:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        zzB4 = zzasx.zzB(i16 << 3);
                        r02 = zzB4 + 1;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 8:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        int i20 = i16 << 3;
                        Object object = unsafe.getObject(obj, j11);
                        if (object instanceof zzask) {
                            zzB5 = zzasx.zzB(i20);
                            zzd = ((zzask) object).zzd();
                            zzB6 = zzasx.zzB(zzd);
                            r02 = zzB5 + zzB6 + zzd;
                            i14 += r02;
                            i13 += 3;
                            i15 = i11;
                            z12 = z10;
                            z11 = false;
                            i12 = 1048575;
                        } else {
                            zzB3 = zzasx.zzB(i20);
                            zzC = zzasx.zzA((String) object);
                            r02 = zzB3 + zzC;
                            i14 += r02;
                            i13 += 3;
                            i15 = i11;
                            z12 = z10;
                            z11 = false;
                            i12 = 1048575;
                        }
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 9:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        r02 = zzavv.zzh(i16, unsafe.getObject(obj, j11), zzs(i13));
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 10:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        zzask zzaskVar = (zzask) unsafe.getObject(obj, j11);
                        zzB5 = zzasx.zzB(i16 << 3);
                        zzd = zzaskVar.zzd();
                        zzB6 = zzasx.zzB(zzd);
                        r02 = zzB5 + zzB6 + zzd;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 11:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        int i21 = unsafe.getInt(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzB(i21);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 12:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        long j15 = unsafe.getInt(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC(j15);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 13:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        zzB2 = zzasx.zzB(i16 << 3);
                        r02 = zzB2 + 4;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 14:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        zzB = zzasx.zzB(i16 << 3);
                        r02 = zzB + 8;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 15:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        int i22 = unsafe.getInt(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzB((i22 >> 31) ^ (i22 + i22));
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 16:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        long j16 = unsafe.getLong(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC((j16 >> 63) ^ (j16 + j16));
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 17:
                    if (zzJ(obj, i13, i11, z10 ? 1 : 0, r52)) {
                        r02 = zzasx.zzy(i16, (zzavf) unsafe.getObject(obj, j11), zzs(i13));
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 18:
                    r02 = zzavv.zzd(i16, (List) unsafe.getObject(obj, j11), z11);
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 19:
                    r02 = zzavv.zzb(i16, (List) unsafe.getObject(obj, j11), z11);
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj, j11);
                    int i23 = zzavv.zza;
                    if (list.size() != 0) {
                        zzg = zzavv.zzg(list) + (list.size() * zzasx.zzB(i16 << 3));
                        i14 += zzg;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    zzg = z11;
                    i14 += zzg;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j11);
                    int i24 = zzavv.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzB3 = zzavv.zzl(list2);
                        zzB7 = zzasx.zzB(i16 << 3);
                        zzC = size * zzB7;
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    r02 = z11;
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j11);
                    int i25 = zzavv.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzB3 = zzavv.zzf(list3);
                        zzB7 = zzasx.zzB(i16 << 3);
                        zzC = size * zzB7;
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    r02 = z11;
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 23:
                    r02 = zzavv.zzd(i16, (List) unsafe.getObject(obj, j11), z11);
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 24:
                    r02 = zzavv.zzb(i16, (List) unsafe.getObject(obj, j11), z11);
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j11);
                    int i26 = zzavv.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        r02 = size2 * (zzasx.zzB(i16 << 3) + 1);
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    r02 = z11;
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 26:
                    ?? r03 = (List) unsafe.getObject(obj, j11);
                    int i27 = zzavv.zza;
                    int size3 = r03.size();
                    if (size3 != 0) {
                        int zzB10 = zzasx.zzB(i16 << 3) * size3;
                        if (r03 instanceof zzaun) {
                            ?? r04 = (zzaun) r03;
                            zzg = zzB10;
                            for (?? r33 = z11; r33 < size3; r33++) {
                                Object zzf = r04.zzf(r33);
                                if (zzf instanceof zzask) {
                                    int zzd2 = ((zzask) zzf).zzd();
                                    zzA2 = zzg + zzasx.zzB(zzd2) + zzd2;
                                } else {
                                    zzA2 = zzg + zzasx.zzA((String) zzf);
                                }
                                zzg = zzA2;
                            }
                        } else {
                            zzg = zzB10;
                            for (?? r34 = z11; r34 < size3; r34++) {
                                Object obj2 = r03.get(r34);
                                if (obj2 instanceof zzask) {
                                    int zzd3 = ((zzask) obj2).zzd();
                                    zzA = zzg + zzasx.zzB(zzd3) + zzd3;
                                } else {
                                    zzA = zzg + zzasx.zzA((String) obj2);
                                }
                                zzg = zzA;
                            }
                        }
                        i14 += zzg;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    zzg = z11;
                    i14 += zzg;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 27:
                    ?? r05 = (List) unsafe.getObject(obj, j11);
                    zzavt zzs = zzs(i13);
                    int i28 = zzavv.zza;
                    int size4 = r05.size();
                    if (size4 == 0) {
                        r32 = z11;
                    } else {
                        r32 = zzasx.zzB(i16 << 3) * size4;
                        for (?? r43 = z11; r43 < size4; r43++) {
                            Object obj3 = r05.get(r43);
                            if (obj3 instanceof zzaul) {
                                int zza2 = ((zzaul) obj3).zza();
                                zzz = (r32 == true ? 1 : 0) + zzasx.zzB(zza2) + zza2;
                            } else {
                                zzz = (r32 == true ? 1 : 0) + zzasx.zzz((zzavf) obj3, zzs);
                            }
                            r32 = zzz;
                        }
                    }
                    i14 += r32;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 28:
                    ?? r06 = (List) unsafe.getObject(obj, j11);
                    int i29 = zzavv.zza;
                    int size5 = r06.size();
                    if (size5 == 0) {
                        r12 = z11;
                    } else {
                        r12 = size5 * zzasx.zzB(i16 << 3);
                        for (?? r22 = z11; r22 < r06.size(); r22++) {
                            int zzd4 = ((zzask) r06.get(r22)).zzd();
                            r12 += zzasx.zzB(zzd4) + zzd4;
                        }
                    }
                    i14 += r12;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case NOTIFICATION_REDIRECT_VALUE:
                    List list5 = (List) unsafe.getObject(obj, j11);
                    int i30 = zzavv.zza;
                    size = list5.size();
                    if (size != 0) {
                        zzB3 = zzavv.zzk(list5);
                        zzB7 = zzasx.zzB(i16 << 3);
                        zzC = size * zzB7;
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    r02 = z11;
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j11);
                    int i31 = zzavv.zza;
                    size = list6.size();
                    if (size != 0) {
                        zzB3 = zzavv.zza(list6);
                        zzB7 = zzasx.zzB(i16 << 3);
                        zzC = size * zzB7;
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    r02 = z11;
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case TEMPLATE_HTML_SIZE_VALUE:
                    r02 = zzavv.zzb(i16, (List) unsafe.getObject(obj, j11), z11);
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 32:
                    r02 = zzavv.zzd(i16, (List) unsafe.getObject(obj, j11), z11);
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j11);
                    int i32 = zzavv.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzB3 = zzavv.zzi(list7);
                        zzB7 = zzasx.zzB(i16 << 3);
                        zzC = size * zzB7;
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    r02 = z11;
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j11);
                    int i33 = zzavv.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzB3 = zzavv.zzj(list8);
                        zzB7 = zzasx.zzB(i16 << 3);
                        zzC = size * zzB7;
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                    r02 = z11;
                    i14 += r02;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 35:
                    zze = zzavv.zze((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 36:
                    zze = zzavv.zzc((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 37:
                    zze = zzavv.zzg((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 38:
                    zze = zzavv.zzl((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 39:
                    zze = zzavv.zzf((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 40:
                    zze = zzavv.zze((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 41:
                    zze = zzavv.zzc((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j11);
                    int i34 = zzavv.zza;
                    zze = list9.size();
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 43:
                    zze = zzavv.zzk((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 44:
                    zze = zzavv.zza((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 45:
                    zze = zzavv.zzc((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 46:
                    zze = zzavv.zze((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 47:
                    zze = zzavv.zzi((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    zze = zzavv.zzj((List) unsafe.getObject(obj, j11));
                    if (zze > 0) {
                        zzB8 = zzasx.zzB(i16 << 3);
                        zzB9 = zzasx.zzB(zze);
                        r12 = zzB8 + zzB9 + zze;
                        i14 += r12;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    ?? r07 = (List) unsafe.getObject(obj, j11);
                    zzavt zzs2 = zzs(i13);
                    int i35 = zzavv.zza;
                    int size6 = r07.size();
                    if (size6 == 0) {
                        r42 = z11;
                    } else {
                        boolean z13 = z11;
                        r42 = z13;
                        ?? r35 = z13;
                        while (r35 < size6) {
                            int zzy = zzasx.zzy(i16, (zzavf) r07.get(r35), zzs2);
                            r35++;
                            r42 = (r42 == true ? 1 : 0) + zzy;
                        }
                    }
                    i14 += r42;
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case 50:
                    zzauz zzauzVar = (zzauz) unsafe.getObject(obj, j11);
                    if (zzauzVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzauzVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
                case AD_REWARD_USER_VALUE:
                    if (zzM(obj, i16, i13)) {
                        zzB = zzasx.zzB(i16 << 3);
                        r02 = zzB + 8;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i13)) {
                        zzB2 = zzasx.zzB(i16 << 3);
                        r02 = zzB2 + 4;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i13)) {
                        long zzq = zzq(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC(zzq);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i16, i13)) {
                        long zzq2 = zzq(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC(zzq2);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i16, i13)) {
                        long zzm = zzm(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC(zzm);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case AD_VISIBILITY_VALUE:
                    if (zzM(obj, i16, i13)) {
                        zzB = zzasx.zzB(i16 << 3);
                        r02 = zzB + 8;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 57:
                    if (zzM(obj, i16, i13)) {
                        zzB2 = zzasx.zzB(i16 << 3);
                        r02 = zzB2 + 4;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i13)) {
                        zzB4 = zzasx.zzB(i16 << 3);
                        r02 = zzB4 + 1;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 59:
                    if (zzM(obj, i16, i13)) {
                        int i36 = i16 << 3;
                        Object object2 = unsafe.getObject(obj, j11);
                        if (object2 instanceof zzask) {
                            zzB5 = zzasx.zzB(i36);
                            zzd = ((zzask) object2).zzd();
                            zzB6 = zzasx.zzB(zzd);
                            r02 = zzB5 + zzB6 + zzd;
                            i14 += r02;
                            i13 += 3;
                            i15 = i11;
                            z12 = z10;
                            z11 = false;
                            i12 = 1048575;
                        } else {
                            zzB3 = zzasx.zzB(i36);
                            zzC = zzasx.zzA((String) object2);
                            r02 = zzB3 + zzC;
                            i14 += r02;
                            i13 += 3;
                            i15 = i11;
                            z12 = z10;
                            z11 = false;
                            i12 = 1048575;
                        }
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 60:
                    if (zzM(obj, i16, i13)) {
                        r02 = zzavv.zzh(i16, unsafe.getObject(obj, j11), zzs(i13));
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 61:
                    if (zzM(obj, i16, i13)) {
                        zzask zzaskVar2 = (zzask) unsafe.getObject(obj, j11);
                        zzB5 = zzasx.zzB(i16 << 3);
                        zzd = zzaskVar2.zzd();
                        zzB6 = zzasx.zzB(zzd);
                        r02 = zzB5 + zzB6 + zzd;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 62:
                    if (zzM(obj, i16, i13)) {
                        int zzm2 = zzm(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzB(zzm2);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 63:
                    if (zzM(obj, i16, i13)) {
                        long zzm3 = zzm(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC(zzm3);
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 64:
                    if (zzM(obj, i16, i13)) {
                        zzB2 = zzasx.zzB(i16 << 3);
                        r02 = zzB2 + 4;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i16, i13)) {
                        zzB = zzasx.zzB(i16 << 3);
                        r02 = zzB + 8;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 66:
                    if (zzM(obj, i16, i13)) {
                        int zzm4 = zzm(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzB((zzm4 >> 31) ^ (zzm4 + zzm4));
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 67:
                    if (zzM(obj, i16, i13)) {
                        long zzq3 = zzq(obj, j11);
                        zzB3 = zzasx.zzB(i16 << 3);
                        zzC = zzasx.zzC((zzq3 >> 63) ^ (zzq3 + zzq3));
                        r02 = zzB3 + zzC;
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                case 68:
                    if (zzM(obj, i16, i13)) {
                        r02 = zzasx.zzy(i16, (zzavf) unsafe.getObject(obj, j11), zzs(i13));
                        i14 += r02;
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    } else {
                        i13 += 3;
                        i15 = i11;
                        z12 = z10;
                        z11 = false;
                        i12 = 1048575;
                    }
                default:
                    i13 += 3;
                    i15 = i11;
                    z12 = z10;
                    z11 = false;
                    i12 = 1048575;
            }
        }
        zzawn zzawnVar = this.zzn;
        int zza3 = i14 + zzawnVar.zza(zzawnVar.zzd(obj));
        if (!this.zzh) {
            return zza3;
        }
        zzatk zzb2 = this.zzo.zzb(obj);
        int i37 = 0;
        for (int i38 = 0; i38 < zzb2.zza.zzb(); i38++) {
            Map.Entry zzg2 = zzb2.zza.zzg(i38);
            i37 += zzatk.zzb((zzatj) zzg2.getKey(), zzg2.getValue());
        }
        for (Map.Entry entry2 : zzb2.zza.zzc()) {
            i37 += zzatk.zzb((zzatj) entry2.getKey(), entry2.getValue());
        }
        return zza3 + i37;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
    @Override // com.google.android.libraries.places.internal.zzavt
    public final int zzb(Object obj) {
        int i11;
        long doubleToLongBits;
        int floatToIntBits;
        int i12;
        int i13 = 0;
        for (int i14 = 0; i14 < this.zzc.length; i14 += 3) {
            int zzp = zzp(i14);
            int[] iArr = this.zzc;
            int i15 = 1048575 & zzp;
            int zzo = zzo(zzp);
            int i16 = iArr[i14];
            long j11 = i15;
            int i17 = 37;
            switch (zzo) {
                case 0:
                    i11 = i13 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzawx.zza(obj, j11));
                    byte[] bArr = zzaud.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 1:
                    i11 = i13 * 53;
                    floatToIntBits = Float.floatToIntBits(zzawx.zzb(obj, j11));
                    i13 = i11 + floatToIntBits;
                    break;
                case 2:
                    i11 = i13 * 53;
                    doubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr2 = zzaud.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 3:
                    i11 = i13 * 53;
                    doubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr3 = zzaud.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 4:
                    i11 = i13 * 53;
                    floatToIntBits = zzawx.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 5:
                    i11 = i13 * 53;
                    doubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr4 = zzaud.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 6:
                    i11 = i13 * 53;
                    floatToIntBits = zzawx.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 7:
                    i11 = i13 * 53;
                    floatToIntBits = zzaud.zza(zzawx.zzw(obj, j11));
                    i13 = i11 + floatToIntBits;
                    break;
                case 8:
                    i11 = i13 * 53;
                    floatToIntBits = ((String) zzawx.zzf(obj, j11)).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 9:
                    i12 = i13 * 53;
                    Object zzf = zzawx.zzf(obj, j11);
                    if (zzf != null) {
                        i17 = zzf.hashCode();
                    }
                    i13 = i12 + i17;
                    break;
                case 10:
                    i11 = i13 * 53;
                    floatToIntBits = zzawx.zzf(obj, j11).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 11:
                    i11 = i13 * 53;
                    floatToIntBits = zzawx.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 12:
                    i11 = i13 * 53;
                    floatToIntBits = zzawx.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 13:
                    i11 = i13 * 53;
                    floatToIntBits = zzawx.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 14:
                    i11 = i13 * 53;
                    doubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr5 = zzaud.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 15:
                    i11 = i13 * 53;
                    floatToIntBits = zzawx.zzc(obj, j11);
                    i13 = i11 + floatToIntBits;
                    break;
                case 16:
                    i11 = i13 * 53;
                    doubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr6 = zzaud.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i13 = i11 + floatToIntBits;
                    break;
                case 17:
                    i12 = i13 * 53;
                    Object zzf2 = zzawx.zzf(obj, j11);
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
                    floatToIntBits = zzawx.zzf(obj, j11).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case 50:
                    i11 = i13 * 53;
                    floatToIntBits = zzawx.zzf(obj, j11).hashCode();
                    i13 = i11 + floatToIntBits;
                    break;
                case AD_REWARD_USER_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzk(obj, j11));
                        byte[] bArr7 = zzaud.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = Float.floatToIntBits(zzl(obj, j11));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzq(obj, j11);
                        byte[] bArr8 = zzaud.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzq(obj, j11);
                        byte[] bArr9 = zzaud.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzm(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case AD_VISIBILITY_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzq(obj, j11);
                        byte[] bArr10 = zzaud.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzm(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzaud.zza(zzN(obj, j11));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = ((String) zzawx.zzf(obj, j11)).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzawx.zzf(obj, j11).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzawx.zzf(obj, j11).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzm(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzm(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzm(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzq(obj, j11);
                        byte[] bArr11 = zzaud.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzm(obj, j11);
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        doubleToLongBits = zzq(obj, j11);
                        byte[] bArr12 = zzaud.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i16, i14)) {
                        i11 = i13 * 53;
                        floatToIntBits = zzawx.zzf(obj, j11).hashCode();
                        i13 = i11 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i13 * 53) + this.zzn.zzd(obj).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzo.zzb(obj).zza.hashCode() : hashCode;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final Object zzc() {
        return ((zzatu) this.zzg).zzat();
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zzd(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzatu) {
                zzatu zzatuVar = (zzatu) obj;
                zzatuVar.zzaF(Integer.MAX_VALUE);
                zzatuVar.zza = 0;
                zzatuVar.zzaD();
            }
            int[] iArr = this.zzc;
            for (int i11 = 0; i11 < iArr.length; i11 += 3) {
                int zzp = zzp(i11);
                int i12 = 1048575 & zzp;
                int zzo = zzo(zzp);
                long j11 = i12;
                if (zzo != 9) {
                    if (zzo != 60 && zzo != 68) {
                        switch (zzo) {
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
                                this.zzm.zzb(obj, j11);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j11);
                                if (object != null) {
                                    ((zzauz) object).zzc();
                                    unsafe.putObject(obj, j11, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, this.zzc[i11], i11)) {
                        zzs(i11).zzd(zzb.getObject(obj, j11));
                    }
                }
                if (zzI(obj, i11)) {
                    zzs(i11).zzd(zzb.getObject(obj, j11));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zzf(obj);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zze(Object obj, Object obj2) {
        zzy(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzp = zzp(i11);
            int i12 = 1048575 & zzp;
            int[] iArr = this.zzc;
            int zzo = zzo(zzp);
            int i13 = iArr[i11];
            long j11 = i12;
            switch (zzo) {
                case 0:
                    if (zzI(obj2, i11)) {
                        zzawx.zzo(obj, j11, zzawx.zza(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i11)) {
                        zzawx.zzp(obj, j11, zzawx.zzb(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i11)) {
                        zzawx.zzm(obj, j11, zzawx.zzw(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i11)) {
                        zzawx.zzs(obj, j11, zzawx.zzf(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzz(obj, obj2, i11);
                    break;
                case 10:
                    if (zzI(obj2, i11)) {
                        zzawx.zzs(obj, j11, zzawx.zzf(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzz(obj, obj2, i11);
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
                    this.zzm.zzc(obj, obj2, j11);
                    break;
                case 50:
                    int i14 = zzavv.zza;
                    zzawx.zzs(obj, j11, zzava.zza(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11)));
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
                        zzawx.zzs(obj, j11, zzawx.zzf(obj2, j11));
                        zzD(obj, i13, i11);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzA(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzM(obj2, i13, i11)) {
                        zzawx.zzs(obj, j11, zzawx.zzf(obj2, j11));
                        zzD(obj, i13, i11);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzA(obj, obj2, i11);
                    break;
            }
        }
        zzavv.zzr(this.zzn, obj, obj2);
        if (this.zzh) {
            zzavv.zzq(this.zzo, obj, obj2);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x00eb. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:113:0x064c A[LOOP:2: B:111:0x0648->B:113:0x064c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0619 A[Catch: all -> 0x0643, TryCatch #1 {all -> 0x0643, blocks: (B:105:0x02fc, B:119:0x0614, B:121:0x0619, B:122:0x061e, B:135:0x0309, B:138:0x031a, B:140:0x0329, B:142:0x0338, B:144:0x0347, B:146:0x0356, B:148:0x0365, B:150:0x0374, B:152:0x0383, B:154:0x0392, B:156:0x03a2, B:158:0x03b2, B:160:0x03c2, B:162:0x03d2, B:164:0x03ee, B:166:0x03fe, B:168:0x040e, B:172:0x0425, B:174:0x042b, B:175:0x043b, B:179:0x044b, B:181:0x045b, B:183:0x046b, B:185:0x047b, B:187:0x048b, B:189:0x049b, B:191:0x04ab, B:193:0x04bb, B:195:0x04cb, B:197:0x04e0, B:199:0x04f1, B:201:0x0502, B:203:0x0513, B:205:0x0524, B:207:0x0531, B:210:0x0538, B:211:0x0542, B:213:0x054c, B:215:0x055d, B:217:0x056e, B:219:0x0583, B:221:0x058e, B:223:0x059f, B:225:0x05b0, B:227:0x05c0, B:229:0x05d0, B:231:0x05e0, B:233:0x05f0, B:235:0x0600), top: B:104:0x02fc }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0624 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x004e A[SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzavt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(java.lang.Object r18, com.google.android.libraries.places.internal.zzavs r19, com.google.android.libraries.places.internal.zzatf r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzavi.zzf(java.lang.Object, com.google.android.libraries.places.internal.zzavs, com.google.android.libraries.places.internal.zzatf):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01c0 A[SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzavt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzg(java.lang.Object r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzavi.zzg(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final boolean zzh(Object obj) {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i14 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i16 = iArr[i14];
            int i17 = iArr2[i16];
            int zzp = zzp(i16);
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
            if ((268435456 & zzp) != 0 && !zzJ(obj, i16, i11, i12, i20)) {
                return false;
            }
            int zzo = zzo(zzp);
            if (zzo != 9 && zzo != 17) {
                if (zzo != 27) {
                    if (zzo == 60 || zzo == 68) {
                        if (zzM(obj, i17, i16) && !zzK(obj, zzp, zzs(i16))) {
                            return false;
                        }
                    } else if (zzo != 49) {
                        if (zzo == 50 && !((zzauz) zzawx.zzf(obj, zzp & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzawx.zzf(obj, zzp & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzavt zzs = zzs(i16);
                    for (int i21 = 0; i21 < list.size(); i21++) {
                        if (!zzs.zzh(list.get(i21))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i16, i11, i12, i20) && !zzK(obj, zzp, zzs(i16))) {
                return false;
            }
            i14++;
            i15 = i11;
            i13 = i12;
        }
        return !this.zzh || this.zzo.zzb(obj).zzj();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0094. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:257:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    @Override // com.google.android.libraries.places.internal.zzavt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(java.lang.Object r25, com.google.android.libraries.places.internal.zzasy r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2028
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzavi.zzj(java.lang.Object, com.google.android.libraries.places.internal.zzasy):void");
    }
}
